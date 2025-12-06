# Day 3 - Lobby

## Puzzle Description

Process sequences of digits to form the largest possible number by selecting a subset.

### Part One
Select 2 digits from each line to form the maximum 2-digit number.

### Part Two
Select 12 digits from each line to form the maximum 12-digit number.

## Algorithm Notes (from maneatingape)

Uses a greedy swap mechanism:
- Maintains an array of N batteries (N=2 for Part 1, N=12 for Part 2)
- Iterates through digits right-to-left
- Performs conditional swaps using `std::mem::replace`
- Terminates swaps when encountering smaller values
- Converts final digit array into a decimal number

The key insight: iterate in reverse, maintaining the largest N digits seen so far in sorted order.
