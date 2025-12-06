import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)
	const input = lines[0]
	const pairs = input.split(",")

	const invalids: number[] = []

	for (const pair of pairs) {
		const [lowStr, highStr] = pair.split("-")
		const low = parseInt(lowStr)
		const high = parseInt(highStr)

		for (let n = low; n <= high; n++) {
			const str = n.toString()

			if (isRepeating(str)) {
				invalids.push(n)
			}
		}
	}

	const sum = invalids.reduce((a, b) => a + b, 0)

	console.log("answer:")
	console.log(sum)
}

function isRepeating(str: string): boolean {
	const len = str.length
	for (let patternLen = 1; patternLen <= len / 2; patternLen++) {
		if (len % patternLen !== 0) continue

		const pattern = str.slice(0, patternLen)
		const repeated = pattern.repeat(len / patternLen)

		if (repeated === str) {
			return true
		}
	}
	return false
}
