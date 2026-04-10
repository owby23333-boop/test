# SKILL VETTING REPORT

════════════════════════════════════════

Skill: weather
Source: clawhub.ai
Version: 1.0
════════════════════════════════════════

## METRICS
• Downloads/Stars: 4.2k stars, 10k forks
• Last Updated: Feb 7, 2026
• Files Reviewed: 1 (SKILL.md)
════════════════════════════════════════

## SECURITY SCAN RESULTS

### ✅ Purpose & Capability:
- 天气查询和预报
- 使用 wttr.in 和 open-meteo API
- 无 API Key 要求
- 可选 PNG 截图

### ✅ Install Mechanism:
- 纯指令，无代码文件
- 仅需要 curl 命令
- 无第三方依赖
- 磁盘占用极小

### ✅ Credentials:
- 不请求任何环境变量
- 不存储任何凭证
- 无 API Key 要求

### ✅ Persistence & Privilege:
- always:false
- 无特殊持久化
- 仅访问 wttr.in 和 open-meteo
- 无 elevated privileges

════════════════════════════════════════

## RED FLAGS
✅ None detected

✅ 无网络调用到未授权地址
✅ 无数据上传
✅ 无凭证请求
✅ 无敏感文件访问
✅ 无系统级权限
✅ 仅访问天气 API

⚠️ 注意事项：
- 需要使用 curl 命令
- 会查询用户指定的位置
- 查询内容包含位置信息
- 建议避免查询敏感地点

════════════════════════════════════════

## PERMISSIONS NEEDED

### Files:
- 无，可选 /tmp/*.png 用于保存截图

### Network:
- https://wttr.in/{location}
- https://open-meteo.com/api

### Commands:
- curl (required)
- 下载天气数据

════════════════════════════════════════

## RISK LEVEL: 🟢 LOW

## VERDICT: ✅ SAFE TO INSTALL

## NOTES

**技能说明：**
- 使用目的：天气查询和预报
- 核心功能：获取当前天气和天气预报
- 服务：wttr.in + open-meteo

**安全性分析：**
- ✅ 纯 HTTP 请求
- ✅ 无 API Key
- ✅ 无数据上传
- ✅ 仅查询天气
- ✅ 无系统级权限

**权限范围：**
- 访问 wttr.in API
- 访问 open-meteo API
- 可选保存 PNG 截图
- 无文件读取/写入权限

**使用场景：**
- 查询天气
- 获取天气预报
- 温度查询
- 天气状况

**推荐理由：**
- 🌤️ 免费天气查询
- 🆓 无 API Key
- 📱 轻量级技能
- 🎯 精准查询

**安装建议：**
- ✅ 低风险，推荐使用
- 确保 curl 可用
- 避免查询敏感地点
- 可选禁用截图功能

════════════════════════════════════════
