# Advent of Code 2025

I'm solving AoC 2025 with AI, to get better/faster/more accurate at prompting and cooperating with the AI.

## Workflow

The process for each puzzle:
1. I read the puzzle on adventofcode.com
2. I digest and understand the problem
3. I explain/instruct Claude on how to implement the solution (not just copy-paste the puzzle text)
4. We iterate on the solution together
5. After both parts are solved, I paste the original puzzle text and Claude creates the `texts/dayXX.md` summary

## Languages

Solutions are implemented in both **TypeScript** and **ClojureScript** (via [nbb](https://github.com/babashka/nbb)).

## Running Solutions

### TypeScript

```bash
bun solve <day> <part> <input>

# Examples:
bun solve 01 1 test    # Day 1, Part 1, test input
bun solve 01 2 input  # Day 1, Part 2, real input
```

### ClojureScript

```bash
bun solve:cljs <day> <part> <input>

# Examples:
bun solve:cljs 01 1 test
bun solve:cljs 06 2 input
```

## Project Structure

```
├── src/                 # TypeScript solutions
│   ├── dayXX-partYY.ts
│   └── utils/
├── cljs/                # ClojureScript solutions (idiomatic)
│   ├── dayXX_partYY.cljs
│   └── utils/
├── input/               # Puzzle inputs
│   └── XX/
│       ├── test.txt
│       └── input.txt
├── texts/               # Puzzle descriptions
│   └── dayXX.md
└── solve.ts             # TypeScript runner
```

## Progress

| Day | Name                | Part 1 | Part 2 |
| --- | ------------------- | ------ | ------ |
| 1   | Secret Entrance     | ✅     | ✅     |
| 2   | Gift Shop           | ✅     | ✅     |
| 3   | Lobby               | ✅     | ✅     |
| 4   | Printing Department | ✅     | ✅     |
| 5   | Cafeteria           | ✅     | ✅     |
| 6   | Trash Compactor     | ✅     | ✅     |
| 7   | Laboratories        | ✅     | ✅     |
| 8   | Sleigh Calibration  | ✅     | ✅     |

## Setup

```bash
bun install
```

## Links

- [Advent of Code 2025](https://adventofcode.com/2025)
