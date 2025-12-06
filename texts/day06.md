# Day 6 - Trash Compactor

## Puzzle Description

Grid with numbers arranged in columns, with operators (`+` or `*`) at the bottom row.

### Part One
For each column section:
1. Extract numbers reading row-by-row
2. Apply the operator at the bottom (sum or product)
3. Sum all column results

### Part Two
For each column section:
1. Extract numbers reading column-by-column
2. Apply the operator at the bottom
3. Sum all column results

## Algorithm Notes (from maneatingape)

- Process columns from right to left
- Track column boundaries based on operator positions
- The `acc` function builds multi-digit numbers by scanning within boundaries
- Simultaneously calculates both part results during parsing
