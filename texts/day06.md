# Day 6 - Trash Compactor

> https://adventofcode.com/2025/day/6

## What We Need To Do

A math worksheet with problems arranged in columns. The bottom row has operators (`+` or `*`). Problems are separated by columns of only spaces.

Example:
```
123 328  51 64
 45 64  387 23
  6 98  215 314
*   +   *   +
```

### Part One

Read numbers **row by row** (left-to-right, normal reading). Apply the operator at the bottom of each problem section.

```
Problem 1: 123 * 45 * 6 = 33210
Problem 2: 328 + 64 + 98 = 490
Problem 3: 51 * 387 * 215 = 4243455
Problem 4: 64 + 23 + 314 = 401
```

Grand total: 33210 + 490 + 4243455 + 401 = **4277556**

### Part Two

Read numbers **column by column** (top-to-bottom for each x position). Each column of digits forms one number, most significant digit at top.

Same worksheet, but reading columns right-to-left:
```
Problem 1 (rightmost): 4 + 431 + 623 = 1058
Problem 2: 175 * 581 * 32 = 3253600
Problem 3: 8 + 248 + 369 = 625
Problem 4 (leftmost): 356 * 24 * 1 = 8544
```

Grand total: 1058 + 3253600 + 625 + 8544 = **3263827**
