import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	let sum = 0n

	for (const line of lines) {
		let result = ""
		let startPos = 0
		let remaining = 12

		for (let d = 0; d < 12; d++) {
			let maxDigit = ""
			let maxPos = startPos

			for (let i = startPos; i <= line.length - remaining; i++) {
				if (line[i] > maxDigit) {
					maxDigit = line[i]
					maxPos = i
				}
			}

			result += maxDigit
			startPos = maxPos + 1
			remaining--
		}

		sum += BigInt(result)
	}

	console.log("answer:")
	console.log(sum.toString())
}
