from itertools import permutations
from sys import maxsize

with open('day09/input.txt', 'r') as file:
    data = [x.strip().split()[::2] for x in file.readlines()]
    data = {(x[0], x[1]): x[2] for x in data}

cities = list(set(vec[1] for vec in data.keys()).union(set(vec[0] for vec in data.keys())))
routes = list(permutations(cities, len(cities)))
result_1 = maxsize
result_2 = 0
for route in routes:
    length = 0
    for i in range(len(route)-1):
        connection = (route[i], route[i+1])
        length += int(data.get(connection) or data.get(connection[::-1]))
    result_1 = min(result_1, length)
    result_2 = max(result_2, length)        
    
print(f"Result 1: {result_1}\nResult 2: {result_2}")
