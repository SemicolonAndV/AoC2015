with open('Day1/input.txt', 'r') as file:
    data = file.read()
    
up = data.count('(')
down = data.count(')')
print(f'Part 1: {up - down}')

counter, index = 0, 0
for char in data:
    index += 1
    if char == '(':
        counter += 1
    else:
        counter -= 1
    if counter == -1:
        break 
print(f'Part 2: {index}')