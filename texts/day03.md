# Day 3 - Lobby

> https://adventofcode.com/2025/day/3

## What We Need To Do

Each line contains a sequence of digits. Pick digits from each line to form the largest possible number.

### Part One

Pick any 2 digits (in order, left to right) from each line to form the maximum 2-digit number.

Example: from `38291` you could pick `3+8=38`, `3+9=39`, `8+9=89`, `9+1=91`, etc. The max is `91`.

Sum all the maximums.

### Part Two

Same thing, but pick 12 digits to form the maximum 12-digit number.

Use a greedy approach: for each position, pick the largest digit that still leaves enough digits remaining.
