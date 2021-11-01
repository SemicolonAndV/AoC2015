import re

with open('day06/input.txt', 'r') as file:
    data = file.readlines()
    
lights, bright = {}, {}
for x in range(1000):
    for y in range(1000):
        lights[(x, y)] = False
        bright[(x, y)] = 0
        

# 1 for turn on, 0 for turn off, 2 for toggle        
for line in data:
    order = re.search(r'(.*) (\d+),(\d+) through (\d+),(\d+)', line)
    c, start, stop = order.group(1), (int(order.group(2)), int(order.group(3))), (int(order.group(4)), int(order.group(5)))
    for x in range(start[0], stop[0] + 1):
        for y in range(start[1], stop[1] + 1):
            if c == 'toggle':
                lights[(x, y)] = not lights[(x, y)]
                bright[(x, y)] += 2
            elif c == 'turn on':
                lights[(x, y)] = True
                bright[(x, y)] += 1
            else:
                lights[(x, y)] = False
                if bright[(x, y)] != 0:
                    bright[(x, y)] -= 1
                
result1 = [True for k in lights.keys() if lights[k]]
result2 = [v for v in bright.values()]

print(f'Part 1: {len(result1)}')
print(f'Part 2: {sum(result2)}')
