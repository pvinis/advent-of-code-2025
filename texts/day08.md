# Day 8 - Playground

> https://adventofcode.com/2025/day/8

## What We Need To Do

Connect junction boxes in 3D space with strings of lights. Each junction box has X,Y,Z coordinates. Connect pairs by shortest straight-line distance to form circuits.

Example input:
```
162,817,812
57,618,57
906,360,560
592,479,940
352,342,300
...
```

### Part One

Connect the 1000 closest pairs of junction boxes. Find the 3 largest circuits and multiply their sizes.

Process:
1. Calculate Euclidean distance between all pairs
2. Sort pairs by distance (shortest first)
3. Connect pairs using Union-Find (merging circuits)
4. After 1000 connections, find circuit sizes
5. Multiply top 3 sizes

Example with 10 connections:
- Circuit with 5 boxes
- Circuit with 4 boxes
- Two circuits with 2 boxes each
- Seven circuits with 1 box each

Answer: 5 × 4 × 2 = **40**

### Part Two

Keep connecting pairs until ALL junction boxes form one single circuit.

The answer is X1 × X2 of the two junction boxes in the final connection.

Example: Final connection is between `216,146,977` and `117,168,530`
Answer: 216 × 117 = **25272**
