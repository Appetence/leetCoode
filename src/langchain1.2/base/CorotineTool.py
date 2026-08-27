import asyncio
from typing import List


async def work(task_id: int, delay: float) -> str:
    print(f"work{task_id} begin")
    print(f"work{task_id} wait {delay}s")
    await asyncio.sleep(delay)
    print(f"work{task_id} end")
    return f"work{task_id} 的 result"


async def main() -> str:
    print("main invoke")

    tasks: List[asyncio.Task[str]] = []
    for index in range(1, 4):
        task = asyncio.create_task(work(index, 0.5 * index))
        tasks.append(task)

    results = await asyncio.gather(*tasks)
    print(results)
    return "main end"


if __name__ == "__main__":
    result = asyncio.run(main())
    print(result)
