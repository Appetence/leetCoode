from langchain_openai import ChatOpenAI
from dotenv import load_dotenv
import os
from rich import print as rprint

load_dotenv(override=True)
DEEPSEEK_MODEL = "deepseek-v4-flash"
# DEEPSEEK_MODEL = os.getenv("DEEPSEEK_MODEL")
DEEPSEEK_API_KEY = os.getenv("DEEPSEEK_API_KEY")
DEEPSEEK_BASE_URL = os.getenv("DEEPSEEK_API_BASE")
# Set the OpenAI client base URL globally instead of passing api_base to the request payload

llm = ChatOpenAI(
    model=DEEPSEEK_MODEL, api_key=DEEPSEEK_API_KEY, base_url=DEEPSEEK_BASE_URL
)
rprint("open")
resp = llm.invoke("你是谁")
rprint(resp)
