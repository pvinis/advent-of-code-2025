import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	console.log(lines)
}
