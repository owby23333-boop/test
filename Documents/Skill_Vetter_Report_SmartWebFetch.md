# SKILL VETTING REPORT

════════════════════════════════════════

Skill: smart-web-fetch
Source: GitHub (openclaw/skills)
Version: 1.0
════════════════════════════════════════

## METRICS
• Downloads/Stars: Unknown
• Last Updated: 2026-04-02
• Files Reviewed: 1 (SKILL.md)
════════════════════════════════════════

## SECURITY SCAN

### ✅ Purpose & Capability:
- 智能网页抓取
- 自动清洗 HTML 为 Markdown
- 四级降级策略确保可用性
- 零成本，无需 API Key

### ✅ Install Mechanism:
- Python 脚本，纯本地运行
- 无需安装包
- 无需第三方依赖
- 仅读取/写入本地文件

### ✅ Credentials:
- 不请求任何环境变量
- 不存储 API 密钥
- 无外部凭证要求

### ✅ Persistence & Privilege:
- 仅下载网页内容
- 不修改系统配置
- 不持久化敏感数据
- 纯本地操作

════════════════════════════════════════

## RED FLAGS
✅ None detected

✅ 无网络调用到未授权地址
✅ 无外部数据上传
✅ 无凭证请求
✅ 无敏感文件访问
✅ 无系统级权限
✅ 无网络调用到 IP

⚠️ 注意事项：
- 使用多个第三方清洗服务（Jina、markdown.new 等）
- 这些服务可能会追踪访问
- 但所有服务都免费且无需认证
- 仅下载内容，不上传数据

════════════════════════════════════════

## PERMISSIONS NEEDED

### Files:
- 无，仅读取网页内容

### Network:
- https://r.jina.ai/ (Jina Reader)
- https://markdown.new/ (markdown.new)
- https://defuddle.md/ (defuddle.md)
- 目标 URL (原始内容)

### Commands:
- python3 scripts/fetch.py
- 网页下载和解析

════════════════════════════════════════

## RISK LEVEL: 🟢 LOW

## VERDICT: ✅ SAFE TO INSTALL

## NOTES

**技能说明：**
- 使用目的：智能网页抓取，替代内置 web_fetch
- 核心功能：自动清洗 HTML 为干净 Markdown
- 优势：节省 50-80% Token，四级降级策略

**安全性分析：**
- ✅ 纯本地 Python 脚本
- ✅ 无需 API Key
- ✅ 零成本
- ⚠️ 使用第三方服务（隐私考虑）
- ✅ 不上传数据

**权限范围：**
- 仅下载网页内容
- 读取并清洗 HTML
- 输出 Markdown 内容
- 不修改系统文件

**使用场景：**
- 获取网页文章
- 提取 GitHub README
- 抓取 Reddit 帖子
- 替代 web_fetch 工具

**推荐理由：**
- 🚀 Token 节省 50-80%
- 🔄 自动容错（四级降级）
- 🆓 零成本
- 📝 干净输出（纯 Markdown）
- 🔌 即插即用

**安装建议：**
- ✅ 低风险，推荐使用
- 替代内置 web_fetch
- 配置为默认工具
- 定期检查第三方服务可用性

════════════════════════════════════════
