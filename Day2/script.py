with open('Day2/input.txt', 'r') as file:
    data = file.readlines()
    
boxes = [line.strip().split('x') for line in data]
boxes_s = [sorted([int(x) for x in line]) for line in boxes]


conv_1 = lambda x: 3 * x[0] * x[1] + 2 * (x[1] * x[2] + x[0] * x[2]) 
paper_1 = [conv_1(x) for x in boxes_s]
print(f'Part 1: {sum(paper_1)}')

conv_2 = lambda x: x[0] * x[1] * x[2] + 2 * (x[0] + x[1])
paper_2 = [conv_2(x) for x in boxes_s]
print(f'Part 2: {sum(paper_2)}')
