from concurrent.futures import ProcessPoolExecutor


def cup_task(n):
    print(f"当前执行第{n}个 task")


if __name__ == "__main__":
    print('++++++++++++++++')
    with ProcessPoolExecutor(4) as p:
        result = list(p.map(cup_task, [1, 2, 3, 4]))
        print(result)
