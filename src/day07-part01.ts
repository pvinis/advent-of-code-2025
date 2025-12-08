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

	let count = 0
	for (let y = 0; y < lines.length; y++) {
		for (let x = 0; x < lines[y].length; x++) {
			if (lines[y][x] === "^" && shouldCount(y, x)) {
				count++
			}
		}
	}

	console.log("answer:")
	console.log(count)
}
