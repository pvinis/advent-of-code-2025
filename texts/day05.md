# Day 5 - Cafeteria

> https://adventofcode.com/2025/day/5

## What We Need To Do

Input has two sections separated by a blank line:
1. Fresh ingredient ID ranges (inclusive, like `3-5` means 3, 4, 5)
2. Available ingredient IDs (one per line)

Ranges can overlap.

Example:
```
3-5
10-14
16-20
12-18

1
5
8
11
17
32
```

### Part One

Count how many of the available ingredient IDs fall within any fresh range.

```
ID 1  → spoiled (not in any range)
ID 5  → fresh (in 3-5)
ID 8  → spoiled
ID 11 → fresh (in 10-14)
ID 17 → fresh (in 16-20 and 12-18)
ID 32 → spoiled
```

Answer: **3** fresh IDs

### Part Two

Ignore the available IDs. Count **how many total IDs** are covered by the ranges (merging overlaps).

Ranges `10-14`, `16-20`, `12-18` overlap/touch → merged they cover 10-20 (11 IDs).
Range `3-5` covers 3 IDs.

Fresh IDs: 3, 4, 5, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20

Answer: **14** total fresh IDs
