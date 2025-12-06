import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const emptyIdx = lines.indexOf("")
	const ranges = lines.slice(0, emptyIdx).map((line) => {
		const [start, end] = line.split("-").map(Number)
		return [start, end] as [number, number]
	})

	ranges.sort((a, b) => a[0] - b[0])

	const merged: [number, number][] = []
	for (const [start, end] of ranges) {
		if (merged.length === 0 || merged[merged.length - 1][1] < start - 1) {
			merged.push([start, end])
		} else {
			merged[merged.length - 1][1] = Math.max(merged[merged.length - 1][1], end)
		}
	}

	let count = 0
	for (const [start, end] of merged) {
		count += end - start + 1
	}

	console.log("answer:")
	console.log(count)
}
