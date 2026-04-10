---
name: self-improving-agent-cn
description: AI 自我改进与记忆系统 - 解决'同类错误反复犯、用户纠正不长记性'的痛点。自动捕获错误、用户纠正、最佳实践，并转化为长期记忆。
version: 1.0.0
author: zhengxinjipai
category: learning
flags: optional
license: MIT-0
---

# Self-Improving Agent CN

AI 自我改进与记忆系统 - 解决"同类错误反复犯、用户纠正不长记性"的痛点。自动捕获错误、用户纠正、最佳实践，并转化为长期记忆。

## 核心功能

- 错误记录与学习
- 纠正反馈收集
- 最佳实践积累
- 长期记忆管理

## 使用说明

### 1. 错误记录

```bash
# 当命令失败时自动记录
agent-browser --error "命令失败了"

# 记录错误到文件
python self-improving/log-error.py "错误的命令" "错误原因"
```

### 2. 纠正记录

```bash
# 记录用户纠正
python self-improving/log-correction.py "原错误" "用户纠正" "正确做法"
```

### 3. 最佳实践

```bash
# 记录最佳实践
python self-improving/log-best-practice.py "做法" "效果" "适用场景"
```

### 4. 查看记录

```bash
# 查看错误日志
cat ~/.openclaw/memory/self-improving/errors.jsonl

# 查看纠正记录
cat ~/.openclaw/memory/self-improving/corrections.jsonl

# 查看最佳实践
cat ~/.openclaw/memory/self-improving/best_practices.jsonl
```

## 文件结构

```
~/.openclaw/memory/self-improving/
├── errors.jsonl          # 错误记录
├── corrections.jsonl     # 纠正记录
└── best_practices.jsonl  # 最佳实践
```

## 数据格式

```json
# 错误记录
{"timestamp": "2026-04-02T00:00:00Z", "error": "错误描述", "command": "命令"}

# 纠正记录
{"timestamp": "2026-04-02T00:00:00Z", "error": "原错误", "correction": "纠正内容", "solution": "正确做法"}

# 最佳实践
{"timestamp": "2026-04-02T00:00:00Z", "practice": "做法", "effect": "效果", "scope": "适用场景"}
```

## 安全注意事项

⚠️ **重要：**
1. 仅记录非敏感信息
2. 不应记录密码、API 密钥等敏感数据
3. 设置文件权限为 700
4. 定期清理旧日志
5. 审查 Python 源代码
6. 限制自主调用

## 安装方式

```bash
# 克隆技能目录
git clone <repo> skills/self-improving-agent-cn/

# 或手动下载 Python 脚本
# 放置在 ~/.openclaw/memory/self-improving/ 目录下
```

## 使用示例

### 场景 1：错误学习

```bash
# 执行失败
agent-browser open https://example.com
# → 自动记录错误

# 纠正错误
python log-correction.py "无法打开页面" "需要安装 Chromium" "agent-browser install"

# 查看学习结果
cat ~/.openclaw/memory/self-improving/corrections.jsonl
```

### 场景 2：最佳实践收集

```bash
# 记录成功的做法
python log-best-practice.py \
  "使用 --session 参数隔离测试" \
  "避免浏览器状态污染" \
  "多会话并行测试"

# 查看最佳实践
cat ~/.openclaw/memory/self-improving/best_practices.jsonl
```

## Credits

Skill created by 郑信捷派 (zhengxinjipai)
License: MIT-0
