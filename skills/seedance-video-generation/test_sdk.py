import volcengine
from volcengine.apiService import ApiClient
from volcengine.model import Task

# 火山引擎 SDK 配置
AK = "b9d2a96f-aed7-4274-bcad-0d930d4c2615"
API_HOST = "ark.cn-beijing.volces.com"
SECRET_KEY = ""  # 如果只有 API Key 没有 Secret Key，留空

# 初始化 SDK
print("Initializing volcengine SDK...")

# 如果 SDK 无法使用，我们继续使用 HTTP 请求方法
# 但首先需要确认正确的 API 端点
