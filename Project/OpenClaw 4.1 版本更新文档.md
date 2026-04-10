# 🦞 OpenClaw 4.1 版本更新文档

**版本：** 2026.4.1  
**发布日期：** 2026 年 3 月  
**状态：** 正式版

---

## 📋 版本概览

### ✅ 主要特性

- **移动端节点支持**：新增 Android 和 iOS 移动节点
- **性能优化**：桌面 App 更新至 v0.1.1
- **稳定性修复**：修复 v3.31 的问题
- **技能市场**：78+ 个技能可用

### ⚡ 更新重点

**OpenClaw 4.1 是重大更新**，主要修复了 3.31 版本的问题，并新增了重要功能。

---

## 🚀 新功能

### 1. 移动端节点支持 📱

**新增功能：**
- ✅ Android 移动节点
- ✅ iOS 移动节点
- ✅ 从手机/平板运行 OpenClaw 任务
- ✅ 移动设备配对管理

**使用方法：**
```bash
# 在 Android/iOS 设备上安装 OpenClaw
# 使用二维码配对
# 配置移动节点
```

### 2. 桌面 App 更新 🖥️

**更新内容：**
- 稳定性修复
- 性能优化
- UI 改进
- 新版本 v0.1.1

### 3. ClawHub 技能市场 🛍️

**可用技能：** 78+ 个技能
- 开发工具
- 数据处理
- 文件管理
- 网络工具
- AI 助手

---

## 🔧 配置参数

### 核心配置文件

#### 1. `openclaw.json` - 主配置文件

```json
{
  // === 网关配置 ===
  "port": 18789,              // 网关端口
  "bind": "auto",             // 绑定模式：auto/0.0.0.0/127.0.0.1
  "pairing": {
    "required": true          // 是否需要配对
  },
  
  // === 执行命令配置 ===
  "exec": {
    "allow": {
      "commands": [           // 允许的命令列表
        "java",
        "npm",
        "gradlew",
        "python",
        "git"
      ],
      "approval": "on-miss"    // 批准策略：on-miss/always/deny
    }
  },
  
  // === Tailscale 配置 ===
  "tailscale": {
    "mode": "off",            // 模式：on/off/auto
    "resetOnExit": false      // 退出时重置连接
  },
  
  // === 插件配置 ===
  "plugins": {
    "entries": {
      "device-pair": {
        "config": {
          "publicUrl": "https://..."
        }
      }
    }
  }
}
```

#### 2. 关键配置项说明

| 配置项 | 类型 | 说明 | 默认值 |
|--------|------|------|--------|
| `port` | number | 网关端口 | 18789 |
| `bind` | string | 绑定地址 | "auto" |
| `pairing.required` | boolean | 是否需配对 | true |
| `exec.allow.commands` | array | 允许命令 | [] |
| `exec.approval` | string | 批准策略 | "on-miss" |
| `tailscale.mode` | string | Tailscale 模式 | "off" |
| `plugins.entries` | object | 插件配置 | {} |

---

## 🛠️ 配置示例

### 示例 1：允许所有命令

```json
{
  "exec": {
    "allow": {
      "commands": ["*"],
      "approval": "always"
    }
  }
}
```

### 示例 2：禁止所有命令

```json
{
  "exec": {
    "allow": {
      "commands": [],
      "approval": "deny"
    }
  }
}
```

### 示例 3：仅允许特定命令

```json
{
  "exec": {
    "allow": {
      "commands": ["java", "npm", "git"],
      "approval": "on-miss"
    }
  }
}
```

---

## ⚙️ 常用命令

### 查看版本

```bash
openclaw version
# 或
openclaw status
```

### 重启网关

```bash
openclaw gateway restart
```

### 查看配置

```bash
openclaw config get
```

### 修复配置

```bash
openclaw doctor --fix
```

### 更新 OpenClaw

```bash
openclaw update
```

---

## 📦 安装命令

### 安装 OpenClaw

```bash
npm install -g openclaw
```

### 更新 OpenClaw

```bash
openclaw update
```

### 启动 OpenClaw

```bash
openclaw gateway start
```

### 停止 OpenClaw

```bash
openclaw gateway stop
```

---

## 🔒 安全配置

### 启用配对保护

```json
{
  "pairing": {
    "required": true
  }
}
```

### 限制命令执行

```json
{
  "exec": {
    "allow": {
      "commands": [
        "java",
        "npm install"
      ]
    }
  }
}
```

### 禁用 Tailscale

```json
{
  "tailscale": {
    "mode": "off"
  }
}
```

---

## 🎯 最佳实践

### 1. 生产环境配置

```json
{
  "port": 18789,
  "bind": "127.0.0.1",
  "pairing": {
    "required": true
  },
  "exec": {
    "allow": {
      "commands": ["java", "npm", "git"],
      "approval": "on-miss"
    }
  },
  "tailscale": {
    "mode": "off"
  }
}
```

### 2. 开发环境配置

```json
{
  "port": 18789,
  "bind": "0.0.0.0",
  "pairing": {
    "required": false
  },
  "exec": {
    "allow": {
      "commands": ["*"],
      "approval": "always"
    }
  },
  "tailscale": {
    "mode": "auto"
  }
}
```

---

## 🚨 故障排除

### 问题 1：命令需要批准

**解决方案：**
```bash
# 在 Web UI 上批准
# 或修改配置文件
# 设置 approval: "always"
```

### 问题 2：配置无效

**解决方案：**
```bash
openclaw doctor --fix
# 或
# 删除 openclaw.json 重新创建
```

### 问题 3：端口占用

**解决方案：**
```bash
# 更改端口
"port": 18790
```

---

## 📚 参考文档

### 官方文档

- [OpenClaw 官方文档](https://docs.openclaw.ai)
- [GitHub 仓库](https://github.com/openclaw/openclaw)
- [ClawHub 技能市场](https://clawhub.ai)

### 更新日志

- 查看 [Changelog](https://openclawdesktop.com/changelog.html)
- 查看 [Releases](https://github.com/openclaw/openclaw/releases)

---

## 📝 更新摘要

| 版本 | 日期 | 主要内容 |
|------|------|----------|
| 4.1 | Mar 2026 | 移动端节点、性能优化、稳定性修复 |
| 3.31 | - | - |
| 3.x | - | - |

---

## ✅ 检查清单

配置完 OpenClaw 后检查：

- [ ] 端口配置正确
- [ ] 绑定模式设置
- [ ] 配对要求配置
- [ ] 命令执行限制
- [ ] Tailscale 配置
- [ ] 插件配置
- [ ] 测试网关连接
- [ ] 测试命令执行

---

**版本：** 2026.4.1  
**更新日期：** 2026-03-XX  
**状态：** 稳定版
