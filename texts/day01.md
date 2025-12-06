# Day 1 - Secret Entrance

> https://adventofcode.com/2025/day/1

## What We Need To Do

A dial with numbers 0-99 in a circle, starting at **50**.

Each instruction is `L` (left/lower) or `R` (right/higher) followed by a click count. The dial wraps: left from 0 → 99, right from 99 → 0.

### Part One

Count how many times the dial **lands on 0** after a rotation.

Example sequence:
```
L68 → 82
L30 → 52
R48 → 0    ✓
L5  → 95
R60 → 55
L55 → 0    ✓
L1  → 99
L99 → 0    ✓
R14 → 14
L82 → 32
```
Answer: 3

### Part Two

Count how many times the dial **passes through 0** during any rotation (every click counts, not just final position).

Same example:
- `L68` from 50 → 82 crosses 0 once
- `R48` lands on 0
- `R60` from 95 → 55 crosses 0 once
- `L55` lands on 0
- `L99` lands on 0
- `L82` from 14 → 32 crosses 0 once

Answer: 6

Note: `R1000` from 50 would pass through 0 ten times before returning to 50.
