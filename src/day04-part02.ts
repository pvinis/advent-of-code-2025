import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const grid = lines.map((line) => line.split(""))
	let total = 0

	while (true) {
		const toRemove: [number, number][] = []

		for (let y = 0; y < grid.length; y++) {
			for (let x = 0; x < grid[y].length; x++) {
				if (grid[y][x] !== "@") continue

				let neighbors = 0
				for (let dy = -1; dy <= 1; dy++) {
					for (let dx = -1; dx <= 1; dx++) {
						if (dy === 0 && dx === 0) continue
						const ny = y + dy
						const nx = x + dx
						if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[ny].length) {
							if (grid[ny][nx] === "@") neighbors++
						}
					}
				}

				if (neighbors < 4) toRemove.push([y, x])
			}
		}

		if (toRemove.length === 0) break

		total += toRemove.length
		for (const [y, x] of toRemove) {
			grid[y][x] = "."
		}
	}

	console.log("answer:")
	console.log(total)
}
