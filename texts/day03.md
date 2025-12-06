# Day 3 - Lobby

> https://adventofcode.com/2025/day/3

## What We Need To Do

Each line is a "bank" of batteries, each digit (1-9) is a battery's joltage rating. Pick batteries to turn on, and the joltage produced is the number formed by those digits in order (no rearranging).

### Part One

Turn on exactly **2 batteries** per bank to produce the largest possible joltage.

Example:
```
987654321111111 → 98 (first two)
811111111111119 → 89 (the 8 and the 9)
234234234234278 → 78 (last two)
818181911112111 → 92
```

Sum: 98 + 89 + 78 + 92 = **357**

### Part Two

Turn on exactly **12 batteries** per bank to produce the largest possible joltage.

Example:
```
987654321111111 → 987654321111 (skip some 1s at end)
811111111111119 → 811111111119 (skip some 1s)
234234234234278 → 434234234278 (skip a 2, 3, and 2 near start)
818181911112111 → 888911112111 (skip some 1s near front)
```

Sum: 987654321111 + 811111111119 + 434234234278 + 888911112111 = **3121910778619**

Use a greedy approach: for each position, pick the largest digit that still leaves enough digits remaining.
