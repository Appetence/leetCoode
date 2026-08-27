from functools import wraps


def say_msg(msg):
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            print(f"say msg is: {msg}")
            return func(*args, **kwargs)

        return wrapper

    return decorator


@say_msg("add")
def add(x, y, z):
    res = x + y + z
    print(f"{x} {y} {z} 的执行结果是 {res}")
    return res


class SayHello:
    def __init__(self, msg):
        self.msg = msg

    def __call__(self, func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            print(f"wrapper func class: {self.msg}")
            return func(*args, **kwargs)

        return wrapper


@SayHello("say hello")
def cc(a, b, c):
    return a + b + c


def iterate_items(items):
    for item in items:
        print(item)


cc(1, 2, 3)

if __name__ == "__main__":
    add(1, 2, 3)
    cc(1, 1, 3)

    types = ["a", "b", "c", "d"]
    iterate_items(types)


