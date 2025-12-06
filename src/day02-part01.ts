import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)
	const input = lines[0]
	const pairs = input.split(",")

	const doubles: number[] = []

	for (const pair of pairs) {
		const [lowStr, highStr] = pair.split("-")
		const low = parseInt(lowStr)
		const high = parseInt(highStr)

		if (lowStr.length === highStr.length && lowStr.length % 2 === 1) {
			continue
		}

		for (let n = low; n <= high; n++) {
			const str = n.toString()
			if (str.length % 2 === 1) continue

			const half = str.length / 2
			const left = str.slice(0, half)
			const right = str.slice(half)

			if (left === right) {
				doubles.push(n)
			}
		}
	}

	const sum = doubles.reduce((a, b) => a + b, 0)

	console.log("answer:")
	console.log(sum)
}
