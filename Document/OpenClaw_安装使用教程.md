# 🐟 小鱼 - OpenClaw 安装使用教程

**更新时间**：2026 年 4 月 2 日  
**版本**：2026.3.28+  
**系统**：Windows 10/11

---

## 📑 目录

1. [系统要求](#1-系统要求)
2. [安装方式选择](#2-安装方式选择)
3. **方式一：快速安装（推荐）**
4. **方式二：手动安装**
5. [配置环境](#5-配置环境)
6. [初始设置](#6-初始设置)
7. [验证安装](#7-验证安装)
8. [常见问题](#8-常见问题)

---

## 1. 系统要求

### 基础要求

- **操作系统**：Windows 10/11，WSL2 更稳定
- **Node.js**：v24（推荐）或 v22.14+
- **npm/pnpm**：npm 6.x+ 或 pnpm 8.x+
- **内存**：4GB+（建议 8GB）
- **磁盘**：500MB+

### 可选要求

- **pnpm**：如果你要从源码安装
- **Docker**：容器化部署
- **Git**：版本控制和源码安装

---

## 2. 安装方式选择

| 方式 | 适合人群 | 难度 | 速度 |
|------|---------|------|------|
| **快速安装** | 初学者、日常使用 | ⭐ | 快 |
| **手动安装** | 高级用户、定制需求 | ⭐⭐⭐ | 中 |
| **容器部署** | DevOps、云部署 | ⭐⭐⭐⭐ | 快 |
| **源码安装** | 开发者、贡献者 | ⭐⭐⭐⭐⭐ | 慢 |

**白哥，推荐使用"方式一：快速安装"**，一行命令搞定！

---

## 方式一：快速安装（推荐）✅

### Windows PowerShell 安装

**打开 PowerShell（管理员权限），运行：**

```powershell
iwr -useb https://openclaw.ai/install.ps1 | iex
```

**这会：**
- ✅ 自动检测系统环境
- ✅ 安装 Node.js（如果需要）
- ✅ 安装 OpenClaw
- ✅ 启动引导程序

### 不运行引导程序

如果只想安装 CLI 工具：

```powershell
iwr -useb https://openclaw.ai/install.ps1 | iex -s --no-onboard
```

---

## 方式二：手动安装

### 步骤 1：安装 Node.js

```powershell
# 方式 1：使用 winget（推荐）
winget install OpenJS.NodeJS.LTS

# 方式 2：使用 Scoop
scoop install nodejs-lts

# 方式 3：访问 https://nodejs.org 下载安装
```

### 步骤 2：安装 OpenClaw

```powershell
# 方式 1：使用 npm（推荐）
npm install -g openclaw@latest

# 方式 2：使用 pnpm（更推荐）
pnpm add -g openclaw@latest
pnpm approve-builds -g

# 方式 3：从 GitHub 安装最新源码
npm install -g github:openclaw/openclaw#main
```

### 步骤 3：运行引导程序

```powershell
openclaw onboard --install-daemon
```

**引导程序会：**
- 配置环境变量
- 设置默认模型
- 配置消息通道
- 安装网关守护进程

---

## 5. 配置环境

### 5.1 环境变量配置

打开 PowerShell，运行：

```powershell
# 检查 Node.js 版本
node -v

# 检查 npm 版本
npm -v

# 查看已安装的 openclaw
npm list -g openclaw
```

### 5.2 设置 API 密钥

**方式 1：配置文件**

编辑 `C:\Users\15093\.openclaw\openclaw.json`：

```json
{
  "models": {
    "mode": "merge",
    "providers": {
      "ollama": {
        "api": "ollama",
        "apiKey": "ollama-local",
        "baseUrl": "http://127.0.0.1:11434"
      },
      "claude": {
        "api": "anthropic",
        "apiKey": "${CLAUDE_API_KEY}",
        "baseUrl": "https://api.anthropic.com/v1"
      }
    }
  }
}
```

**方式 2：环境变量**

```powershell
$env:CLAUDE_API_KEY = "your-api-key-here"
```

### 5.3 配置消息通道

**配置微信（openclaw-weixin）：**

1. 下载 WeChat OpenClaw 插件
2. 在 `openclaw.json` 中启用：

```json
{
  "plugins": {
    "allow": [
      "openclaw-weixin"
    ],
    "entries": {
      "openclaw-weixin": {
        "enabled": true
      }
    }
  }
}
```

---

## 6. 初始设置

### 6.1 运行引导程序

```powershell
# 完成初始设置
openclaw onboard

# 这会提示你配置：
# - 选择默认模型
# - 配置消息通道
# - 设置工作目录
# - 配置网关权限
```

### 6.2 配置网关

```powershell
# 启动网关
openclaw gateway start

# 查看网关状态
openclaw gateway status

# 重启网关（如果需要）
openclaw gateway restart
```

### 6.3 配置子代理（可选）

```powershell
# 查看可用的子代理
openclaw agents list

# 安装新技能（需要先用 Find Skills 和 Skill Vetter）
npx skills add <owner/repo@skill> -g -y

# 查看已安装技能
npx skills list
```

---

## 7. 验证安装

### 7.1 检查版本

```powershell
# 检查 OpenClaw 版本
openclaw --version

# 或
openclaw doctor
```

### 7.2 检查网关状态

```powershell
openclaw gateway status
```

**预期输出：**

```
Gateway: Running
Port: 18789
Mode: local
Bind: loopback
Status: Healthy
```

### 7.3 测试消息功能

```powershell
# 向自己发送测试消息
openclaw session send --session-key <session-id> --message "测试消息"
```

---

## 8. 常见问题

### Q1：安装后 openclaw 命令找不到？

**原因**：PATH 环境变量未配置

**解决方案：**

```powershell
# 查看 npm 全局包路径
npm prefix -g

# 添加 PATH（Windows 环境变量）
$env:Path = [System.IO.Path]::Combine([System.IO.Path]::GetFullPath("$([System.NamingNamespace]::GetExecutingAssembly().Location -replace '.dll','bin')"),$env:Path)

# 或手动添加
$env:Path = "C:\Program Files\nodejs\node_modules\openclaw\bin;$env:Path"
```

### Q2：onboard 时报错 sharp？

**解决方案：**

```powershell
# 设置环境变量
$env:SHARP_IGNORE_GLOBAL_LIBVIPS = 1

# 重新安装
npm install -g openclaw@latest
```

### Q3：无法连接到网关？

**原因**：网关未启动或端口被占用

**解决方案：**

```powershell
# 重启网关
openclaw gateway restart

# 检查端口占用
netstat -ano | findstr :18789

# 关闭占用端口的进程
taskkill /F /PID <pid>
```

### Q4：配置文件中 API 密钥失效？

**解决方案：**

```powershell
# 更新配置文件
openclaw doctor

# 重新运行引导程序
openclaw onboard
```

### Q5：如何更新 OpenClaw？

```powershell
# 更新 CLI
npm update -g openclaw

# 或从 GitHub 安装最新版
npm install -g github:openclaw/openclaw#main

# 重启网关
openclaw gateway restart
```

---

## 📋 快速命令速查表

| 命令 | 说明 | 示例 |
|------|------|------|
| `openclaw onboard` | 运行引导程序 | `openclaw onboard --install-daemon` |
| `openclaw gateway start` | 启动网关 | - |
| `openclaw gateway status` | 查看网关状态 | - |
| `openclaw --version` | 查看版本 | - |
| `openclaw doctor` | 诊断配置问题 | - |
| `openclaw agents list` | 列出子代理 | - |
| `openclaw session spawn` | 创建新会话 | `openclaw session spawn --task "任务"` |
| `npx skills add` | 安装新技能 | `npx skills add owner/repo@skill` |

---

## 📚 更多资源

- **官方文档**：https://docs.openclaw.ai
- **GitHub 仓库**：https://github.com/openclaw/openclaw
- **安装脚本**：https://openclaw.ai/install.ps1
- **社区讨论**：https://discord.com/invite/clawd

---

## 🎯 下一步

安装完成后，你可以：

1. **创建子代理任务**
   ```powershell
   openclaw session spawn --task "帮我分析这个项目"
   ```

2. **安装新技能**
   ```powershell
   npx skills find <关键词>
   npx skills add <owner/repo@skill>
   ```

3. **配置消息通道**
   ```powershell
   openclaw onboard --configure-channels
   ```

4. **运行自动检查**
   ```powershell
   openclaw doctor
   ```

---

**文档版本**：1.0  
**最后更新**：2026-04-02  
**维护者**：小鱼 🐟
