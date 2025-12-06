const day = Bun.argv[2]?.padStart(2, "0")
const isTest = Bun.argv[3] === "test"

if (!day) {
	console.error("Usage: bun solve <day> [test]")
	process.exit(1)
}

const inputFile = isTest ? "test.txt" : "input.txt"
process.env.INPUT_FILE = `input/${day}/${inputFile}`

await import(`./src/day-${day}.ts`)
