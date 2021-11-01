import hashlib

with open('day04/input.txt', 'r') as file:
    data = file.read()
    
index = 0
end_1 = '00000'

while True:
    result = data + str(index)
    if hashlib.md5(result.encode()).hexdigest()[:5] == end_1:
        break
    index += 1
    
print(f'Part 1: {index}')

index = 0
end_2 = '000000'

while True:
    result = data + str(index)
    if hashlib.md5(result.encode()).hexdigest()[:6] == end_2:
        break
    index += 1
    
print(f'Part 2: {index}')