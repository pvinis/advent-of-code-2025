# Day 1 - Secret Entrance

## Puzzle Description

The puzzle involves a **dial mechanism** with directional commands:

- **Directions**: R (right) or L (left)
- **Amounts**: Signed integers accompanying each direction
- **Starting position**: Dial begins at 50 (on a 0-99 scale)

### Part One
Count the number of times the dial reaches exactly position 0 after processing an instruction.

### Part Two
Count every time the dial crosses through 0 (passes through). Left turns are easier if you first "reverse" the dial position (100 - dial), then treat it as a right turn.

## Algorithm Notes (from maneatingape)

- Right turns: track overflow with `(dial + amount) / 100`, update dial with modulo 100
- Left turns: reverse dial position first, apply same logic
- Uses `rem_euclid` for proper modulo handling of negative numbers
