with open('day10/input.txt', 'r') as file:
    new_seed = file.read()
    
l_counter = 1
for j in range(1, 51):
    seed = new_seed + "$"
    new_seed = ""
    for i in range(1, len(seed)):
        if seed[i] != seed[i-1]:
            new_seed = new_seed + str(l_counter)
            new_seed = new_seed + str(seed[i-1])
            l_counter = 1
        else:
            l_counter += 1
            
    if j == 40:
        print(f"Result 1: {len(new_seed)}")
    
    if j == 50:
        print(f"Result 2: {len(new_seed)}")