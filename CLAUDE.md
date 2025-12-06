# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Advent of Code 2025 solutions written in TypeScript using Bun.

## Commands

```bash
# Run a solution
bun solve <day> <part> <input>

# Examples:
bun solve 1 1 test    # Day 1, Part 1, using test.txt
bun solve 1 1 input   # Day 1, Part 1, using input.txt
bun solve 02 2 test   # Day 2, Part 2, using test.txt

# Type checking
bun tsc

# Format code
bun prettier --write .
```

## Project Structure

- `solve.ts` - Entry point that loads the appropriate day/part solution
- `src/dayXX-partYY.ts` - Solution files for each day and part
- `src/utils/input.ts` - Input reading utilities
- `input/XX/test.txt` - Test input for day XX
- `input/XX/input.txt` - Puzzle input for day XX

## Code Style

- Uses tabs for indentation, no semicolons
- Each solution file exports a `main()` function that runs immediately
- Input file path is passed via `process.env.INPUT_FILE`
- Use `readLines()` from `src/utils/input.ts` to read input
