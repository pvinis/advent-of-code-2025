import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	let dial = 50
	let count = 0

	for (const line of lines) {
		const dir = line[0]
		const num = parseInt(line.slice(1))

		if (dir === "L") {
			dial -= num
		} else if (dir === "R") {
			dial += num
		}

		count += Math.floor(num / 100)

		if (dial < 0 || dial > 99) {
			count++
		}

		dial = ((dial % 100) + 100) % 100
	}

	console.log("password is:")
	console.log(count)
}
