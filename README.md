# Advent of Code 2025

I'm solving AoC 2025 with AI, to get better/faster/more accurate at prompting and cooperating with the AI.

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
├── cljs/                # ClojureScript solutions
│   ├── dayXX_partYY.cljs
│   ├── dayXX_partYY_v2.cljs  # Alternative implementations
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

## Setup

```bash
bun install
```

## Links

- [Advent of Code 2025](https://adventofcode.com/2025)
