# Day 2 - Gift Shop

> https://adventofcode.com/2025/day/2

## What We Need To Do

Input is a single line of comma-separated ranges: `11-22,95-115,998-1012,...`

Find "invalid" product IDs within these ranges based on digit patterns.

### Part One

An ID is invalid if it's a sequence of digits **repeated exactly twice**.

Examples of invalid IDs:
- `55` (5 twice)
- `6464` (64 twice)
- `123123` (123 twice)

Example ranges:
```
11-22 → invalid: 11, 22
95-115 → invalid: 99
998-1012 → invalid: 1010
1188511880-1188511890 → invalid: 1188511885
222220-222224 → invalid: 222222
1698522-1698528 → none
446443-446449 → invalid: 446446
38593856-38593862 → invalid: 38593859
```

Sum all invalid IDs. Example answer: 1227775554

### Part Two

An ID is invalid if it's a sequence of digits **repeated at least twice** (2x, 3x, 4x, etc.).

Additional invalid IDs:
- `111` (1 three times)
- `999` (9 three times)
- `565656` (56 three times)
- `824824824` (824 three times)
- `2121212121` (21 five times)

Same example with new rules:
```
95-115 → now also includes 111
998-1012 → now also includes 999
565653-565659 → now includes 565656
824824821-824824827 → now includes 824824824
2121212118-2121212124 → now includes 2121212121
```

Example answer: 4174379265
