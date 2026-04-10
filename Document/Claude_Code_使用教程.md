# 🐟 小鱼 - Claude Code 使用教程

**更新时间**：2026 年 4 月 2 日

---

## 📖 目录

1. [什么是 Claude Code](#1-什么是-claude-code)
2. [安装与配置](#2-安装与配置)
3. [基本使用流程](#3-基本使用流程)
4. [高级功能](#4-高级功能)
5. [最佳实践](#5-最佳实践)
6. [常见问题](#6-常见问题)

---

## 1. 什么是 Claude Code

**Claude Code** 是 Anthropic 开发的命令行 AI 编程助手，集成了强大的代码生成、调试、重构等功能。

### 核心特点

- ✅ 支持多文件编辑和项目管理
- ✅ 自动理解代码上下文
- ✅ 实时代码审查和 bug 修复
- ✅ 支持多种编程语言和框架
- ✅ 可配置化，适应不同开发场景

---

## 2. 安装与配置

### 2.1 通过 OpenClaw 使用

#### 方式 1：直接调用（无需额外安装）

```bash
# 创建子代理任务
openclaw session spawn "使用 Claude 进行代码开发" --model claude-3-5-sonnet
```

#### 方式 2：配置 OpenClaw 默认模型

编辑 `C:\Users\15093\.openclaw\openclaw.json`：

```json
{
  "agents": {
    "defaults": {
      "model": {
        "primary": "claude-3-5-sonnet"
      },
      "models": {
        "claude-3-5-sonnet": {
          "api_key": "${CLAUDE_API_KEY}",
          "baseUrl": "https://api.anthropic.com/v1"
        }
      }
    }
  }
}
```

### 2.2 通过 Claude 官方 CLI（可选）

```bash
# 安装 Claude CLI
pip install claude

# 或 npm install
npm install -g @anthropic/claude

# 配置 API 密钥
claude configure --api-key YOUR_API_KEY
```

---

## 3. 基本使用流程

### 3.1 启动开发会话

```bash
# 方式 1：创建临时任务（一次性执行）
openclaw session spawn --task "重构这个模块" --runtime acp --mode run

# 方式 2：创建持久化会话（适合长期开发）
openclaw session spawn --task "持续优化这个项目" --runtime acp --mode session --thread true
```

### 3.2 传递任务参数

```bash
# 指定工作目录
--cwd ./Project/MyApp

# 指定模型
--model claude-3-5-sonnet

# 设置超时时间（秒）
--timeout 300

# 指定清理策略
--cleanup keep
```

### 3.3 查看会话状态

```bash
# 查看会话信息
openclaw session status --session-key <session-id>

# 查看会话历史
openclaw session history --session-key <session-id> --limit 50
```

### 3.4 发送消息到会话

```bash
# 向会话发送消息
openclaw session send --session-key <session-id> --message "请优化这个函数"
```

### 3.5 管理子代理

```bash
# 列出所有子代理
openclaw subagent list

# 控制子代理
openclaw subagent steer --target <agent-id> --message "继续执行"

# 停止子代理
openclaw subagent kill --target <agent-id>
```

---

## 4. 高级功能

### 4.1 多文件编辑

Claude Code 可以一次性修改多个文件：

```bash
# 创建批量编辑任务
openclaw session spawn --task "修改以下内容：
1. src/app.js: 添加新函数
2. src/config.js: 更新配置
3. README.md: 添加说明"
```

### 4.2 代码审查

```bash
# 启用代码审查
openclaw session spawn --task "审查这个模块的代码，检查潜在问题并修复" --cwd ./Project/MyApp
```

### 4.3 自动测试

```bash
# 自动运行测试并修复 bug
openclaw session spawn --task "运行所有测试，修复失败的测试用例" --cwd ./Project/MyApp
```

### 4.4 生成文档

```bash
# 从代码自动生成文档
openclaw session spawn --task "为这个模块生成完整的 API 文档和 README" --cwd ./Project/MyApp
```

### 4.5 代码迁移

```bash
# 重构和迁移代码
openclaw session spawn --task "将这个项目从 Java 迁移到 Kotlin" --cwd ./Project/MyApp
```

---

## 5. 最佳实践

### 5.1 任务分解

**❌ 不好的做法**：一次性给一个庞大的任务
```
"帮我重构整个项目"
```

**✅ 好的做法**：分解为小任务
```
"第一步：分析项目结构"
"第二步：优化核心模块"
"第三步：添加单元测试"
"第四步：生成文档"
```

### 5.2 提供上下文

**好的任务描述**：
```
"在 src/api/user.js 文件中：
1. 添加用户登录接口
2. 添加用户注销接口
3. 添加错误处理
4. 添加单元测试
"
```

### 5.3 配置权限

```bash
# 设置子代理的权限
openclaw session spawn \
  --task "任务描述" \
  --sandbox inherit \
  --cleanup keep \
  --streamTo parent
```

### 5.4 日志记录

定期查看会话日志：

```bash
# 查看最新日志
openclaw session history --session-key <session-id> --limit 100

# 导出日志
openclaw session history --session-key <session-id> > log.txt
```

---

## 6. 常见问题

### Q1：如何设置 API 密钥？

```bash
# 方法 1：环境变量
export CLAUDE_API_KEY="your-api-key"

# 方法 2：配置文件
echo "claude_api_key = your-api-key" >> ~/.claude.toml
```

### Q2：会话超时怎么办？

```bash
# 设置更长的超时时间
openclaw session spawn --timeout 3600  # 1 小时

# 或后台运行
openclaw session spawn --background true --timeout 7200
```

### Q3：如何查看子代理的输出？

```bash
# 启用流式输出
openclaw session spawn --streamTo parent

# 查看日志
openclaw session history --session-key <session-id>
```

### Q4：如何停止正在运行的子代理？

```bash
# 查看子代理列表
openclaw subagent list

# 停止指定子代理
openclaw subagent kill --target <agent-id>
```

### Q5：如何清空会话历史？

```bash
# 删除会话（如果有持久化存储）
openclaw session delete --session-key <session-id>
```

---

## 📋 快速命令速查表

| 命令 | 说明 | 示例 |
|------|------|------|
| `session spawn` | 创建新会话 | `session spawn --task "任务描述"` |
| `session status` | 查看状态 | `session status --session-key <id>` |
| `session history` | 查看历史 | `session history --limit 50` |
| `session send` | 发送消息 | `session send --session-key <id> --message "消息"` |
| `subagent list` | 列出子代理 | - |
| `subagent steer` | 控制子代理 | `subagent steer --target <id> --message "继续"` |
| `subagent kill` | 停止子代理 | `subagent kill --target <id>` |

---

## 📚 更多资源

- **官方文档**：https://docs.anthropic.com/claude/docs
- **GitHub 仓库**：https://github.com/anthropics/claude-code
- **社区讨论**：https://discord.com/invite/claude

---

## ⚠️ 注意事项

1. **隐私安全**：不要将敏感信息（API 密钥、密码等）发送给 AI
2. **权限控制**：定期检查子代理的权限设置
3. **资源消耗**：长时间运行可能会占用较多资源
4. **成本控制**：Claude Code 会产生 API 调用费用

---

**文档版本**：1.0  
**最后更新**：2026-04-02  
**维护者**：小鱼 🐟
