---
name: weather
description: 天气查询技能 - 获取当前天气和预报 (无 API key 要求)。使用 wttr.in 和 open-meteo 服务，免费且无需认证。
version: 1.0.0
author: steipete
category: weather
flags: optional
license: MIT-0
runtime_requirements:
  - curl
---

# Weather Skill

天气查询技能，获取当前天气和预报 (无 API key 要求)。

## 核心功能

- 当前天气查询
- 天气预报
- 温度信息
- 天气状况
- 可选 PNG 截图

## 使用方式

### 命令行查询

```bash
# 查询北京天气
curl wttr.in/beijing

# 查询纽约天气
curl wttr.in/new+york

# 查询坐标
curl wttr.in/40.7128,-74.0060

# 获取详细预报
curl wttr.in/Yaozhou --format 2

# 获取 JSON 格式
curl wttr.in/beijing --format json
```

### 使用 open-meteo

```bash
# 获取详细气象数据
curl "https://open-meteo.com/api?latitude=39.9042&longitude=116.4074&current=temperature_2m,weather_code&daily=temperature_2m_max,temperature_2m_min,precipitation_sum"
```

## 在 Agent 中使用

当用户问天气时：

```
用户: "北京今天天气怎么样？"
Agent: curl wttr.in/beijing
```

## 输出示例

```
🌤️ 2°C
🌡️ 最低：-2°C, 最高：6°C
💧 降水：50%
📍 Beijing, CN
```

## JSON 输出示例

```json
{
  "location": "Beijing",
  "temperature": 2,
  "description": "Partly cloudy",
  "humidity": 45,
  "wind_speed": 5
}
```

## 注意事项

⚠️ **重要：**
1. 确保 curl 可用
2. 查询包含位置信息
3. 避免查询敏感地点
4. 可选禁用 PNG 截图

## 安装方式

```bash
# 克隆技能目录
git clone <repo> skills/weather/

# 或使用指令-only（无代码文件）
```

## 配置建议

在 openclaw.json 中禁用网络访问（如果需要）：

```json
{
  "agents": {
    "list": [
      {
        "id": "agent",
        "tools": {
          "deny": ["weather"]
        }
      }
    ]
  }
}
```

## 优势

- 🌤️ 免费天气查询
- 🆓 无 API Key
- 📱 轻量级
- 🎯 精准查询
- ⚡ 快速响应

## Credits

Skill created by Pete (steipete)
License: MIT-0
