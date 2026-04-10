# Seedance 2.0 视频生成技能 🎬

> 使用火山引擎 Seedance 2.0 API 创建高质量视频内容

## 📚 技能位置

```
~/.openclaw/workspace/skills/seedance-video-generation/
```

## 🎯 核心能力

- 📹 **文本到视频**：通过文字描述生成视频
- 🎨 **图生视频**：基于图片生成视频（首帧/首尾帧/参考图）
- ⚡ **多模态参考**：图片 + 视频 + 音频组合生成
- 🎭 **多种风格**：支持电影、动画、写实等多种风格

## 🔑 认证配置

```python
API_KEY = "b9d2a96f-aed7-4274-bcad-0d930d4c2615"  # 白哥的 API Key
API_HOST = "ark.cn-beijing.volces.com"
API_URL = "https://{API_HOST}/api/v3/contents/generations/tasks"
```

## 📖 API 说明

### 创建视频生成任务

**请求方式：** POST

**请求头：**
```json
{
  "Authorization": "Bearer {API_KEY}",
  "Content-Type": "application/json"
}
```

**请求体参数：**

| 参数 | 类型 | 必填 | 说明 |
|------|------|------|------|
| model | string | ✅ | 模型 ID，如 `doubao-seedance-1-0-pro-fast-251015` |
| content | array | ✅ | 输入内容数组，包含文本、图片等 |
| config | object | 可选 | 视频配置参数（分辨率、时长等） |
| callback_url | string | 可选 | 任务完成回调地址 |
| generate_audio | boolean | 可选，默认 true | 是否生成有声视频 |
| watermark | boolean | 可选，默认 false | 是否包含水印 |

**content 数组内容格式：**

```json
{
  "model": "doubao-seedance-1-0-pro-fast-251015",
  "content": [
    {
      "type": "text",
      "text": "一只可爱的小猫在厨房里炒菜"
    }
  ],
  "config": {
    "resolution": "1080p",
    "duration": 10,
    "fps": 30,
    "style": "realistic"
  }
}
```

## 🎬 使用场景

### 1. 文生视频

```json
{
  "model": "doubao-seedance-1-0-pro-fast-251015",
  "content": [
    {
      "type": "text",
      "text": "一只可爱的小猫在厨房里炒菜，画面温馨可爱，有烟火气和烹饪场景"
    }
  ],
  "config": {
    "resolution": "1080p",
    "duration": 10,
    "fps": 30,
    "style": "realistic"
  }
}
```

### 2. 图生视频（首帧）

```json
{
  "model": "doubao-seedance-1-0-pro-fast-251015",
  "content": [
    {
      "type": "text",
      "text": "小猫从盒子里探出头来"
    },
    {
      "type": "image_url",
      "image_url": {
        "url": "https://example.com/cat.jpg"
      }
    }
  ],
  "config": {
    "resolution": "1080p",
    "duration": 10
  }
}
```

### 3. 图生视频（首尾帧）

```json
{
  "model": "doubao-seedance-1-0-pro-fast-251015",
  "content": [
    {
      "type": "image_url",
      "image_url": {
        "url": "https://example.com/cat1.jpg"
      }
    },
    {
      "type": "image_url",
      "image_url": {
        "url": "https://example.com/cat2.jpg"
      },
      "role": "last_frame"
    }
  ],
  "config": {
    "resolution": "1080p",
    "duration": 10
  }
}
```

### 4. 多模态参考生视频

```json
{
  "model": "doubao-seedance-1-0-pro-fast-251015",
  "content": [
    {
      "type": "text",
      "text": "[图 1] 戴着眼镜的男生和 [图 2] 的柯基小狗"
    },
    {
      "type": "image_url",
      "image_url": {
        "url": "https://example.com/img1.jpg"
      },
      "role": "reference_image"
    },
    {
      "type": "image_url",
      "image_url": {
        "url": "https://example.com/img2.jpg"
      },
      "role": "reference_image"
    }
  ]
}
```

## ⚙️ 配置参数详解

### 分辨率 (resolution)

| 值 | 说明 | 支持模型 |
|----|------|----------|
| 480p | 864×480 | 全部 |
| 720p | 1280×720 | 全部 |
| 1080p | 1920×1080 | Seedance 1.0 pro 及以上 |

**注意：** Seedance 2.0 & 2.0 fast 不支持 1080p 分辨率

### 时长 (duration)

| 模型 | 有效范围 (秒) |
|------|---------------|
| Seedance 1.0 pro/1.0 pro fast/1.0 lite | [2, 12] |
| Seedance 1.5 pro | [4, 12] 或 -1（自动） |
| Seedance 2.0 & 2.0 fast | [4, 15] 或 -1（自动） |

**建议：** 设置 -1 让模型自动选择时长

### 宽高比 (ratio)

| 值 | 说明 |
|----|------|
| 16:9 | 标准宽屏 |
| 4:3 | 经典比例 |
| 1:1 | 正方形 |
| adaptive | 自动适配（Seedance 1.5 pro/2.0 & 2.0 fast） |

### 其他参数

- **fps**: 帧率 [24, 60]
- **seed**: 随机种子 [-1, 2^32-1]，-1 表示随机
- **camera_fixed**: 是否固定摄像头（Seedance 2.0 暂不支持）
- **watermark**: 是否包含水印
- **generate_audio**: 是否生成有声视频（仅 2.0/1.5 pro 支持）

## 🚀 使用流程

### 步骤 1：创建视频生成任务

```python
import requests

headers = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json"
}

payload = {
    "model": "doubao-seedance-1-0-pro-fast-251015",
    "content": [
        {
            "type": "text",
            "text": prompt
        }
    ],
    "config": {
        "resolution": "1080p",
        "duration": 10,
        "fps": 30
    }
}

response = requests.post(API_URL, headers=headers, json=payload)
task_id = response.json()["id"]
```

### 步骤 2：查询任务状态

```python
for i in range(20):  # 最多轮询 20 次
    response = requests.get(f"{API_URL}/{task_id}", headers=headers)
    task = response.json().get("task", {})
    
    status = task.get("status", "unknown")
    progress = task.get("progress", 0)
    
    if status == "running":
        print(f"进度：{progress}%")
        time.sleep(5)
    elif status == "finished":
        output = task.get("output", {})
        video_url = output.get("url", "")
        print("视频生成完成！")
        print("视频 URL:", video_url)
        break
    elif status == "failed":
        print("任务失败:", task)
        break
```

## 💡 使用示例

### 示例 1：简单文生视频

```
用户：生成一个太空探险的视频
小鱼：✅ 正在创建视频生成任务...
     🎬 描述：太空飞船穿越星云，壮观的宇宙景象
     🔢 任务 ID: cgt-20260403132418-2pxx6
     ⏱️ 预计完成时间：5-10 分钟
```

### 示例 2：图生视频

```
用户：用这张图生成视频 [图片]
     描述：人物微笑挥手
小鱼：✅ 正在创建视频生成任务...
     🎬 使用图生视频模式
     ⏱️ 预计完成时间：8-15 分钟
```

## 📁 输出文件

生成的视频将保存在：

```
C:/Users/15093/.openclaw/workspace/Video/{video_filename}
```

## ⚠️ 注意事项

### 1. 图片上传要求

- **格式：** jpeg、png、webp、bmp、tiff、gif
- **宽高比：** (0.4, 2.5)
- **尺寸：** (300, 6000) px
- **大小：** 单张图片小于 30 MB
- **Seedance 2.0 不支持真人人脸**（除非已通过教程处理）

### 2. 文本提示词

- **中文：** 不超过 500 字
- **英文：** 不超过 1000 词
- **建议：** 详细描述期望生成的视频内容

### 3. 计费说明

- 免费额度有限
- 超出后按量计费
- 查看 `模型列表` 了解价格

### 4. 任务超时

- 默认超时：48 小时（172800 秒）
- 可设置 `execution_expires_after`（范围：3600-259200）

## 🐛 错误处理

| 错误码 | 原因 | 解决方案 |
|--------|------|----------|
| 401 | 认证失败 | 检查 API Key 是否正确 |
| 404 | 端点不存在 | 使用正确的 API URL |
| 429 | 频率限制 | 等待后重试或补充配额 |
| 500 | 服务异常 | 稍后重试 |

## 📝 最佳实践

1. **详细描述：** 提示词越详细，生成效果越好
2. **图片质量：** 使用清晰、合规的图片
3. **合理时长：** 根据需求设置时长，避免浪费配额
4. **种子值：** 固定 seed 可复现相同结果
5. **音频开关：** 有声视频更生动，但会占用更多资源

## 🔗 相关链接

- **官方文档：** https://www.volcengine.com/docs/82379/1520757
- **API Key 申请：** https://ark.cn-beijing.volces.com
- **模型列表：** https://console.volcengine.com/ark/model
- **使用教程：** https://www.volcengine.com/docs/82379

## 📦 已安装的模型

- doubao-seedance-1-0-pro-fast-251015
- doubao-seedance-1-0-lite-t2v
- doubao-seedance-1-0-lite-i2v

---

**准备生成视频了吗？告诉我你的想法吧！** 🎬✨
