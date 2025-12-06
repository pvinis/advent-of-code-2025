# Day 5 - Cafeteria

## Puzzle Description

Process seat ranges and individual seat IDs.

### Input Format
```
from-to
from-to
...

id
id
...
```

### Part One
Count how many individual IDs fall within any of the given ranges.

### Part Two
Merge overlapping ranges and sum their total sizes.

## Algorithm Notes (from maneatingape)

- Sort ranges and IDs for efficient processing
- Merge overlapping ranges using interval overlap detection
- Part 1: Use binary search to locate where boundaries fall within sorted IDs
- Part 2: Sum the sizes of all merged ranges
