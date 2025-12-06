# Day 4 - Printing Department

## Puzzle Description

Grid-based puzzle involving `@` characters representing print positions.

### Part One
Count all `@` characters that have fewer than 4 diagonal neighbors that are also `@`.

### Part Two
Implement a flood-fill removal algorithm:
1. Remove all `@` with <4 diagonal `@` neighbors
2. This may cause other `@` to now have <4 neighbors
3. Repeat until no more can be removed
4. Count total removed

## Algorithm Notes (from maneatingape)

- Creates a padded grid with neighbor counts
- Uses a work queue for efficient processing
- Part 1: Simply count boundary `@` characters
- Part 2: Process positions iteratively, decrementing neighbor counts and adding newly qualifying positions to the queue
