from functools import lru_cache, partial

with open('day07/input.txt', 'r') as file:
    data = (x.strip().split(" -> ") for x in file.readlines())

operators = {
    None: lambda x: x(0),
    "NOT": lambda x: ~x(1),
    "AND": lambda x: x(0) & x(2),
    "OR": lambda x: x(0) | x(2),
    "LSHIFT": lambda x: x(0) << x(2),
    "RSHIFT": lambda x: x(0) >> x(2)
}

commands = {v: k for k, v in data}

def parse_cmd(cmd):
    return next((x for x in operators if x in cmd), None)

def get_arg(cmd, idx):
    return get_value(cmd[idx])

@lru_cache
def get_value(key):
    try:
        value = int(key)
    except ValueError:
        command = commands[key].split(" ")
        op = parse_cmd(command)
        arg = partial(get_arg, command)
        value = operators[op](arg)
    return value

result_1 = get_value("a")

part_2 = {"b": str(result_1)}
commands.update(part_2)
get_value.cache_clear()
result_2 = get_value("a")

print(f"Result 1: {result_1}\nResult 2: {result_2}")

