import codecs
from ast import literal_eval

with open('day08/input.txt', 'r') as file:
    data = [x.strip() for x in file.readlines()]

result_1 = 0
result_2 = 0
for item in data:
    # literal_eval ommits all escaped characters
    result_1 += len(item) - len(literal_eval(item))
    # every string contains two '"'s and every '"' translates into '\"'
    # also every '\' translates into '\\'
    # so to find the difference between original and new one, it is required to find
    # the sum of newly added elements
    result_2 += item.count('"') + item.count('\\') + 2

print(f"Result 1: {result_1}\nResult 2: {result_2}")
