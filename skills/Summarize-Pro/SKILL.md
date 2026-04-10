---
name: Summarize Pro
description: 高级多格式摘要技能 - 7 模式智能摘要，支持 PDF、网页、YouTube 视频、代码文件和演示文稿。Chain-of-Density 信息压缩，8 种语言支持。
version: 1.0.0
author: hanabi-jpn
category: productivity
flags: optional
license: MIT
---

# Summarize Pro

高级多格式摘要技能，完全替代手动总结。

## 核心功能

- **7 模式智能摘要**:
  1. TL;DR - 极简摘要
  2. Bullet Points - 要点列表
  3. Executive Brief - 高管简报
  4. Annotated Highlights - 标注要点
  5. Slide-Ready - PPT 就绪
  6. Code Summary - 代码摘要
  7. Key Insights - 核心洞察

- **支持的格式**:
  - PDF 文档
  - 网页文章
  - YouTube 视频
  - 代码文件
  - 演示文稿 (PPT)

- **语言支持**: 8 种语言
- **压缩深度**: 4 级可调
- **智能缓存**: 快速重复访问

## 使用方式

### 命令行使用

```bash
# 总结 PDF
python summarize.py --file document.pdf --mode tl;dr

# 总结网页
python summarize.py --url https://example.com/article --mode executive

# 总结 YouTube 视频
python summarize.py --youtube https://youtube.com/watch?v=xxx --mode key-insights

# 获取 JSON 输出
python summarize.py --file doc.pdf --json

# 查看缓存
python summarize.py --cache-list
```

### 在 Agent 中使用

**当用户需要总结时：**

```
用户: "帮我总结一下这个 PDF"
Agent: python ~/.openclaw/skills/Summarize-Pro/scripts/summarize.py --file file.pdf --mode tl;dr
```

## 摘要模式说明

### 1. TL;DR
- 极简摘要，1-2 句话
- 适合快速了解内容

### 2. Bullet Points
- 要点列表
- 关键信息点

### 3. Executive Brief
- 专业简报
- 适合管理层

### 4. Annotated Highlights
- 标注重点
- 附带解释

### 5. Slide-Ready
- PPT 格式
- 适合演示

### 6. Code Summary
- 代码功能说明
- 关键逻辑提取

### 7. Key Insights
- 核心洞察
- 深度分析

## 输出示例

```
# TL;DR 模式
## 文章标题
一句话总结...

## 关键要点
- 要点 1
- 要点 2

# Executive 模式
# 执行摘要
## 背景
## 问题
## 解决方案
## 建议
```

## JSON 输出格式

```json
{
  "url": "https://example.com",
  "title": "文章标题",
  "mode": "tl;dr",
  "summary": "简短总结...",
  "source": "web",
  "language": "zh-CN"
}
```

## 配置选项

```bash
# 设置压缩深度
python summarize.py --depth 3 --file doc.pdf

# 设置语言
python summarize.py --lang ja --file doc.pdf

# 禁用缓存
python summarize.py --no-cache --file doc.pdf

# 自定义输出
python summarize.py --output custom.json --file doc.pdf
```

## 注意事项

⚠️ **重要：**
1. 仅处理可信内容
2. 定期清理缓存
3. 避免处理敏感信息
4. 审查 API 使用情况
5. 配置适当的使用限制

## 安装方式

```bash
# 从 LobeHub 安装
npx -y @lobehub/market-cli skills install hanabi-jpn-clawhub-skills-summarize-pro --agent open-claw

# 或手动下载 Python 脚本
git clone <repo> skills/Summarize-Pro/

# 放置在 ~/.openclaw/skills/ 目录下
```

## 优势

- 🚀 **多格式支持**: PDF、网页、视频、代码、PPT
- 📝 **7 种模式**: 满足不同场景需求
- 🌐 **8 种语言**: 支持多语言
- ⚡ **智能压缩**: 节省 Token
- 📚 **生产力工具**: 提升研究效率

## Credits

Skill created by 汉笔 (hanabi-jpn)
License: MIT
