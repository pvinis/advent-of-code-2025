import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	let dial = 50
	let count = 0

	for (const line of lines) {
		const dir = line[0]
		const num = parseInt(line.slice(1))

		for (let i = 0; i < num; i++) {
			if (dir === "L") {
				dial = dial === 0 ? 99 : dial - 1
			} else {
				dial = dial === 99 ? 0 : dial + 1
			}

			if (dial === 0) {
				count++
			}
		}
	}

	console.log("answer:")
	console.log(count)
}
