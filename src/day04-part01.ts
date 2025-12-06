import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	let count = 0

	for (let y = 0; y < lines.length; y++) {
		for (let x = 0; x < lines[y].length; x++) {
			if (lines[y][x] !== "@") continue

			let neighbors = 0
			for (let dy = -1; dy <= 1; dy++) {
				for (let dx = -1; dx <= 1; dx++) {
					if (dy === 0 && dx === 0) continue
					const ny = y + dy
					const nx = x + dx
					if (ny >= 0 && ny < lines.length && nx >= 0 && nx < lines[ny].length) {
						if (lines[ny][nx] === "@") neighbors++
					}
				}
			}

			if (neighbors < 4) count++
		}
	}

	console.log("answer:")
	console.log(count)
}
