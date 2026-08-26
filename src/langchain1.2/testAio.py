import asyncio
from pathlib import Path
from urllib.parse import urlparse

import aiohttp


async def download_file(session: aiohttp.ClientSession, url: str, save_dir: str = "downloads") -> str:
    parsed_url = urlparse(url)
    filename = Path(parsed_url.path).name or "download.bin"
    save_path = Path(save_dir) / filename
    save_path.parent.mkdir(parents=True, exist_ok=True)

    print(f"download open: {url}")
    try:
        async with session.get(url, timeout=aiohttp.ClientTimeout(total=30)) as response:
            response.raise_for_status()
            data = await response.read()
        save_path.write_bytes(data)
    except Exception as exc:
        print(f"download failed: {url} -> {exc}")
        raise

    print(f"download end: {save_path}")
    return str(save_path)


async def main() -> None:
    urls = [
        "https://gips3.baidu.com/it/u=3886271102,3123389489&fm=3028&app=3028&f=JPEG&fmt=auto?w=1280&h=960"
    ]
    print("exec begin")

    async with aiohttp.ClientSession() as session:
        tasks = [download_file(session, url) for url in urls]
        results = await asyncio.gather(*tasks)

    for result in results:
        print(result)
    print("exec end")


if __name__ == "__main__":
    asyncio.run(main())
