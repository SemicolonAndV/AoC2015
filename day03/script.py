with open('day03/input.txt', 'r') as file:
    data = file.read()
    
diff = {'>' : (1, 0), 
        '<' : (-1, 0), 
        '^' : (0, 1), 
        'v' : (0, -1)
        }
dx, dy = 0, 0
houses = {(0, 0) : 1}

for char in data:
    dx += diff[char][0]
    dy += diff[char][1]
    if (dx, dy) not in houses:
        houses[(dx, dy)] = 1
    else:
        houses[(dx, dy)] += 1
print(f'Part 1: {len(houses)}')
    
houses_2 = {(0, 0) : 1}
sdx, sdy = 0, 0
rdx, rdy = 0, 0
mod = 0

for char in data:
    if mod % 2:
        sdx += diff[char][0]
        sdy += diff[char][1]
        if (sdx, sdy) not in houses_2:
            houses_2[(sdx, sdy)] = 1
        else:
            houses_2[(sdx, sdy)] += 1
    else:
        rdx += diff[char][0]
        rdy += diff[char][1]
        if (rdx, rdy) not in houses_2:
            houses_2[(rdx, rdy)] = 1
        else:
            houses_2[(rdx, rdy)] += 1
    mod += 1

print(f'Part 2: {len(houses_2)}')
