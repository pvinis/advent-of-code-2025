import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	let sum = 0

	for (const line of lines) {
		let max = 0
		for (let i = 0; i < line.length; i++) {
			for (let j = i + 1; j < line.length; j++) {
				const num = parseInt(line[i] + line[j])
				if (num > max) {
					max = num
				}
			}
		}
		sum += max
	}

	console.log("answer:")
	console.log(sum)
}
