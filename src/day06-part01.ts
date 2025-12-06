import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const opLineIdx = lines.findIndex((line) => line.includes("+") || line.includes("*"))
	const lastLine = lines[opLineIdx]
	const dataLines = lines.slice(0, opLineIdx)

	const columns: { start: number; op: string }[] = []
	for (let i = 0; i < lastLine.length; i++) {
		if (lastLine[i] === "+" || lastLine[i] === "*") {
			columns.push({ start: i, op: lastLine[i] })
		}
	}

	let total = 0n

	for (let c = 0; c < columns.length; c++) {
		const start = columns[c].start
		const maxLineLen = Math.max(...dataLines.map((l) => l.length))
		const end = c < columns.length - 1 ? columns[c + 1].start - 1 : maxLineLen
		const op = columns[c].op

		const numbers: number[] = []
		for (const line of dataLines) {
			const slice = line.slice(start, end).trim()
			if (slice) {
				numbers.push(parseInt(slice))
			}
		}

		let result: bigint
		if (op === "+") {
			result = numbers.reduce((acc, n) => acc + BigInt(n), 0n)
		} else {
			result = numbers.reduce((acc, n) => acc * BigInt(n), 1n)
		}

		total += result
	}

	console.log("answer:")
	console.log(total.toString())
}
