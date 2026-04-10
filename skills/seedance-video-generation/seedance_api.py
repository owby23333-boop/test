import requests
import time
import base64

# 火山引擎 Seedance API 配置（根据白哥提供的示例）
API_KEY = "b9d2a96f-aed7-4274-bcad-0d930d4c2615"
API_HOST = "ark.cn-beijing.volces.com"
API_URL = f"https://{API_HOST}/api/v3/contents/generations/tasks"
OUTPUT_DIR = r"C:\Users\15093\.openclaw\workspace\Video"

# 使用 Doubao 模型的认证头
headers = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json",
    "User-Agent": "OpenClaw/Seedance-Video"
}

def create_image_to_video_task(prompt, image_url=None, config=None):
    """创建图生视频任务"""
    payload = {
        "model": "doubao-seedance-1-0-pro-fast-251015",
        "content": [
            {
                "type": "text",
                "text": prompt
            }
        ]
    }
    
    if image_url:
        payload["content"].append({
            "type": "image_url",
            "image_url": {"url": image_url}
        })
    
    if config:
        payload["config"] = config
    
    print(f"Creating image-to-video task...")
    print("Payload:", payload)
    
    try:
        response = requests.post(API_URL, headers=headers, json=payload, timeout=30)
        print(f"Status: {response.status_code}")
        print(f"Response: {response.text}")
        return response.json()
    except Exception as e:
        print(f"Request error: {e}")
        return {"error": str(e)}

def create_text_to_video_task(prompt, config=None):
    """创建文生视频任务"""
    payload = {
        "model": "doubao-seedance-1-0-pro-fast-251015",
        "content": [
            {
                "type": "text",
                "text": prompt
            }
        ]
    }
    
    if config:
        payload["config"] = config
    
    print(f"Creating text-to-video task...")
    print("Payload:", payload)
    
    try:
        response = requests.post(API_URL, headers=headers, json=payload, timeout=30)
        print(f"Status: {response.status_code}")
        print(f"Response: {response.text}")
        return response.json()
    except Exception as e:
        print(f"Request error: {e}")
        return {"error": str(e)}

def check_task_status(task_id):
    """检查任务状态"""
    print("Waiting for video generation...")
    
    for i in range(20):
        try:
            response = requests.get(
                f"https://{API_HOST}/api/v3/contents/generations/tasks/{task_id}",
                headers=headers,
                timeout=10
            )
            
            print(f"Check {i}: Status={response.status_code}")
            result = response.json()
            task = result.get("task", result)
            
            if "status" in task:
                status = task["status"]
                progress = task.get("progress", 0)
                print(f"  Progress: {progress}% - Status: {status}")
                
                if status == "running":
                    time.sleep(5)
                elif status == "failed":
                    print("Task FAILED:", task)
                    return False
                elif status == "finished" or status == "succeeded":
                    output = task.get("output", {})
                    video_url = output.get("url") or output.get("path", "")
                    print("SUCCESS! Video URL:", video_url)
                    return video_url
                elif status == "cancelled":
                    print("Task cancelled")
                    return None
            
            time.sleep(5)
        except Exception as e:
            print(f"Check error: {e}")
            time.sleep(5)
    
    return None

def generate_video(prompt, image_url=None, config=None):
    """生成视频（文生或图生）"""
    if image_url:
        return create_image_to_video_task(prompt, image_url, config)
    else:
        return create_text_to_video_task(prompt, config)

if __name__ == "__main__":
    print("=" * 70)
    print("Seedance 2.0 Video Generation")
    print("=" * 70)
    print(f"API_KEY: {API_KEY[:20]}...")
    print(f"API_URL: {API_URL}")
    print("=" * 70)
    
    # 小猫炒菜视频描述
    prompt = "一只可爱的小猫在厨房里炒菜，画面温馨可爱，有烟火气和烹饪场景"
    
    print("")
    print("PROMPT:", prompt)
    print("Starting video generation...")
    
    # 配置参数
    config = {
        "resolution": "1080p",
        "duration": 10,
        "fps": 30,
        "style": "realistic"
    }
    
    # 生成文生视频
    result = create_text_to_video_task(prompt, config)
    
    if "error" in result:
        print("FAILED:", result["error"])
    elif "id" in result:
        print("SUCCESS: Task created!")
        print("TASK ID:", result.get("id"))
        
        video_url = check_task_status(result.get("id"))
        
        if video_url:
            print("SAVE PATH:", OUTPUT_DIR)
            print("VIDEO URL:", video_url)
            print("Video generation complete!")
        else:
            print("Task still generating, please wait...")
    else:
        print("Unknown response:", result)
