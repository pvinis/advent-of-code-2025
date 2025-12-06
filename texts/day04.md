# Day 4 - Printing Department

> https://adventofcode.com/2025/day/4

## What We Need To Do

A grid contains rolls of paper (`@`) and empty spaces (`.`). Forklifts can only access a roll if it has **fewer than 4 rolls in the 8 adjacent positions** (all 8 directions).

### Part One

Count how many rolls of paper can be accessed by a forklift.

Example:
```
..@@.@@@@.      ..xx.xx@x.
@@@.@.@.@@      x@@.@.@.@@
@@@@@.@.@@      @@@@@.x.@@
@.@@@@..@.  →   @.@@@@..@.
@@.@@@@.@@      x@.@@@@.@x
.@@@@@@@.@      .@@@@@@@.@
.@.@.@.@@@      .@.@.@.@@@
@.@@@.@@@@      x.@@@.@@@@
.@@@@@@@@.      .@@@@@@@@.
@.@.@@@.@.      x.x.@@@.x.
```

Answer: **13** rolls accessible

### Part Two

Remove accessible rolls iteratively:
1. Find all rolls with < 4 neighbors
2. Remove them
3. This may cause other rolls to now have < 4 neighbors
4. Repeat until no more can be removed

Count the **total** rolls removed.

Example progression:
```
Initial → Remove 13 → Remove 12 → Remove 7 → Remove 5 → Remove 2 → Remove 1 → Remove 1 → Remove 1 → Remove 1 → Stop
```

Total: 13 + 12 + 7 + 5 + 2 + 1 + 1 + 1 + 1 = **43** rolls removed
