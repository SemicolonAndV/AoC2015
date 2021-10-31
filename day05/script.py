import re

from string import ascii_lowercase

with open('Day5/input.txt', 'r') as file:
    data = file.readlines()

x1 = [line for line in data if (re.search(r'(.)\1', line) and
                               re.search(r'([aeiou].*){3,}', line) and not
                               re.search(r'cd|ab|pq|xy', line))]

x2 = [line for line in data if (re.search(r'(..).*\1', line) and
                                re.search(r'(.).\1', line))]
print(f'Part 1: {len(x1)}')
print(f'Part 2: {len(x2)}')
