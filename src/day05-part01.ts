import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const emptyIdx = lines.indexOf("")
	const ranges = lines.slice(0, emptyIdx).map((line) => {
		const [start, end] = line.split("-").map(Number)
		return { start, end }
	})
	const numbers = lines.slice(emptyIdx + 1).map(Number)

	let count = 0
	for (const num of numbers) {
		for (const range of ranges) {
			if (num >= range.start && num <= range.end) {
				count++
				break
			}
		}
	}

	console.log("answer:")
	console.log(count)
}
