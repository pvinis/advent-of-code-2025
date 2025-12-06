const day = Bun.argv[2]?.padStart(2, "0")
const part = Bun.argv[3]
const inputType = Bun.argv[4]

if (!day || !part || !inputType) {
	console.error("Usage: bun solve <day> <part> <input>")
	console.error("Example: bun solve 01 1 test")
	process.exit(1)
}

const inputFile = inputType === "test" ? "test.txt" : "input.txt"
process.env.INPUT_FILE = `input/${day}/${inputFile}`

await import(`./src/day-${day}-part${part}.ts`)
