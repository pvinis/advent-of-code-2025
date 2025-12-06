# Day 6 - Trash Compactor

> https://adventofcode.com/2025/day/6

## What We Need To Do

A grid has numbers arranged in columns. The last row contains operators (`+` or `*`) that mark column boundaries.

Example:

```
123 328  51
 45 64  387
  6 98  215
*   +   *
```

Each operator defines a column section. Extract numbers from that section and apply the operator.

### Part One

Read numbers **row by row** within each column section:

- Column 1 (`*`): 123, 45, 6 → product
- Column 2 (`+`): 328, 64, 98 → sum
- Column 3 (`*`): 51, 387, 215 → product

Sum all results.

### Part Two

Read numbers **column by column** (top to bottom for each x position):

- Build numbers by reading digits vertically
- Apply the same operators

Sum all results.
