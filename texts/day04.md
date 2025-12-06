# Day 4 - Printing Department

> https://adventofcode.com/2025/day/4

## What We Need To Do

A grid contains `@` characters. We care about diagonal neighbors (all 8 directions).

### Part One

Count all `@` characters that have fewer than 4 diagonal neighbors that are also `@`.

These are the "edge" or "boundary" cells.

### Part Two

Remove cells iteratively:

1. Find all `@` with fewer than 4 `@` neighbors
2. Remove them from the grid
3. This may cause other `@` to now have fewer than 4 neighbors
4. Repeat until no more can be removed

Count the total number of `@` removed.
