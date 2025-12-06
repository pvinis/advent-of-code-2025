import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const opLineIdx = lines.findIndex((line) => line.includes("+") || line.includes("*"))
	const opLine = lines[opLineIdx]
	const dataLines = lines.slice(0, opLineIdx)

	const maxLen = Math.max(...dataLines.map((l) => l.length), opLine.length)

	const problems: { op: string; numbers: bigint[] }[] = []
	let pendingNumbers: bigint[] = []

	for (let col = maxLen - 1; col >= 0; col--) {
		const opChar = col < opLine.length ? opLine[col] : " "

		let verticalNum = ""
		for (const line of dataLines) {
			const ch = col < line.length ? line[col] : " "
			if (ch >= "0" && ch <= "9") {
				verticalNum += ch
			}
		}

		if (verticalNum) {
			pendingNumbers.push(BigInt(verticalNum))
		}

		if (opChar === "+" || opChar === "*") {
			problems.push({ op: opChar, numbers: pendingNumbers })
			pendingNumbers = []
		}
	}

	let total = 0n
	for (const p of problems) {
		if (p.op === "+") {
			total += p.numbers.reduce((a, b) => a + b, 0n)
		} else {
			total += p.numbers.reduce((a, b) => a * b, 1n)
		}
	}

	console.log("answer:")
	console.log(total.toString())
}
