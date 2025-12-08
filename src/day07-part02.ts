import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	function shouldCount(y: number, x: number): boolean {
		let scanY = y - 1
		while (scanY >= 0) {
			const left = lines[scanY]?.[x - 1] ?? "."
			const mid = lines[scanY][x]
			const right = lines[scanY]?.[x + 1] ?? "."

			if (mid === "^") return false
			if (mid === "S") return true
			if (left === "^" || right === "^") return true
			scanY--
		}
		return false
	}

	// Build set of valid ^ positions
	const validCarets = new Set<string>()
	for (let y = 0; y < lines.length; y++) {
		for (let x = 0; x < lines[y].length; x++) {
			if (lines[y][x] === "^" && shouldCount(y, x)) {
				validCarets.add(`${y},${x}`)
			}
		}
	}

	// Find S position
	let sY = 0,
		sX = 0
	for (let y = 0; y < lines.length; y++) {
		const x = lines[y].indexOf("S")
		if (x !== -1) {
			sY = y
			sX = x
			break
		}
	}

	// Track paths: x position -> count
	let paths = new Map<number, bigint>()
	paths.set(sX, 1n)

	for (let y = sY + 1; y < lines.length; y++) {
		const newPaths = new Map<number, bigint>()
		for (const [x, count] of paths) {
			if (validCarets.has(`${y},${x}`)) {
				// Split left and right
				newPaths.set(x - 1, (newPaths.get(x - 1) ?? 0n) + count)
				newPaths.set(x + 1, (newPaths.get(x + 1) ?? 0n) + count)
			} else {
				// Continue straight down
				newPaths.set(x, (newPaths.get(x) ?? 0n) + count)
			}
		}
		paths = newPaths
	}

	let total = 0n
	for (const count of paths.values()) {
		total += count
	}

	console.log("answer:")
	console.log(total.toString())
}
