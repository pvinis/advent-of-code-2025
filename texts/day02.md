# Day 2 - Gift Shop

## Puzzle Description

Calculate cumulative costs for items based on numeric patterns in ranges.

### Part One
Find "double" numbers - numbers where the left half equals the right half (must have even digit count).

Examples: 1212, 5555, 123123

### Part Two
Find "repeating" patterns - numbers that can be expressed as a pattern repeated multiple times.

Examples: 123123 (123 x 2), 1111 (1 x 4), 121212 (12 x 3)

## Input Format
Comma-separated ranges: `from-to,from-to,...`

## Algorithm Notes (from maneatingape)

The Rust solution uses mathematical optimization:
- Predefined digit/size constants define pricing tiers
- Calculates geometric progressions within ranges
- Uses triangular number formula for efficient summation
- Avoids iterating through all individual values

The simple approach (used here) iterates through all numbers and checks each one.
