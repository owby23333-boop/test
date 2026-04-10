# SKILL VETTING REPORT

════════════════════════════════════════

Skill: agent-browser
Source: GitHub (openclaw/skills)
Version: 1.0
════════════════════════════════════════

## METRICS
• Downloads/Stars: Vercel Labs 开源项目
• Last Updated: 2026-04-02
• Files Reviewed: 1 (SKILL.md)
════════════════════════════════════════

## RED FLAGS
✅ None detected

✅ No curl/wget to unknown URLs (only uses agent-browser commands)
✅ No external data transmission beyond necessary API calls
✅ No credential requests in code
✅ No unauthorized file access
✅ No base64 decode operations
✅ No eval() or exec() with external input
✅ No system file modifications outside workspace
✅ No package installations without listing (only npm install for Chromium)
✅ No IP-based network calls (uses domain URLs)
✅ No obfuscated code
✅ No elevated permissions requested
✅ No cookie/session abuse

════════════════════════════════════════

## PERMISSIONS NEEDED

### Files:
- agent-browser install: Chromium browser
- agent-browser state save/load: 用户授权的状态文件
- agent-browser cookies: 浏览器存储

### Network:
- agent-browser open <url>: 用户指定的 URL
- agent-browser snapshot: 访问指定网页
- agent-browser network route: 网络拦截规则

### Commands:
agent-browser
- open, back, forward, reload, close
- snapshot, click, fill, type, hover, check
- get text/html/value/attr
- is visible/enabled/checked
- wait
- screenshot, pdf
- network, cookies, storage, tabs, frames

════════════════════════════════════════

## RISK LEVEL: 🟡 MEDIUM

## VERDICT: ⚠️ INSTALL WITH CAUTION

## NOTES

**技能说明：**
- 使用目的：无头浏览器自动化工具
- 核心功能：控制网页、填写表单、提取数据、截图等
- 类型：implementation - 实现类技能

**安全性分析：**
- ⚠️ 涉及网络访问和浏览器操作
- ⚠️ 可访问用户指定的任何 URL
- ✅ 需要用户明确授权目标网站
- ✅ 不会自动保存凭据
- ✅ 会话隔离功能提升安全性

**权限风险：**
- ⚠️ 可访问网页内容（需用户确认 URL）
- ⚠️ 可执行点击、填写等操作
- ✅ 不会自动上传数据
- ✅ 会话隔离防止交叉污染

**使用场景：**
- 访问网页并截图
- 填写表单并提交
- 搜索并提取信息
- 自动化多步骤流程
- 测试不同浏览器会话

**安全建议：**
1. 只在受信任的域上使用
2. 使用会话隔离（--session）
3. 定期清理状态文件
4. 不在敏感网站使用
5. 定期检查网络拦截规则

**推荐理由：**
- 提供比内置浏览器工具更好的性能
- 确定性元素选择
- 会话隔离支持并行测试
- 适合复杂 SPA 应用

**安装建议：**
- ✅ 中等风险，需要白哥确认
- 建议限制访问域名列表
- 定期审计使用记录

════════════════════════════════════════
