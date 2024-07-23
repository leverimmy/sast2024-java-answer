import random
import json

def generate_json(nums, target):
    data = {
        "input": {
            "nums": nums,
            "target": target
        },
        "output": {
            "answer": None
        }
    }
    return json.dumps(data, indent=4)

for i in range(9, 11):
    with open(f"{i}.json", "w", encoding="utf-8") as f:
        l = -1000
        r = 1000
        len = random.randint(500, 501)
        nums = [random.randint(l, r) for _ in range(len)]
        sum_all = sum(nums)
        if sum_all < 0:
            target = target = random.randint(sum(nums), -sum(nums))
        else:
            target = random.randint(-sum(nums), sum(nums))

        f.write(generate_json(nums, target))
