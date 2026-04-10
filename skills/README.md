# 📚 技能管理目录

**位置：** `C:\Users\15093\.openclaw\workspace\skills\`

---

## 📦 已安装的技能

### 1. **skill-vetter**
- **位置：** `skills/skill-vetter/`
- **用途：** 安全审核工具
- **类型：** 安全性
- **状态：** ✅ 已安装
- **描述：** 在安装任何技能前进行安全检测，检查红旗、权限范围、可疑模式

**文件结构：**
```
skills/skill-vetter/
├── SKILL.md          # 技能说明文档
└── _meta.json        # 元数据信息
```

---

### 2. **find-skills**
- **位置：** `skills/find-skills/`
- **用途：** 技能搜索和发现
- **类型：** 发现
- **状态：** ✅ 已安装
- **描述：** 帮助用户搜索和发现可用的 AI 技能，提供安装命令和链接

**文件结构：**
```
skills/find-skills/
├── SKILL.md          # 技能说明文档
└── _meta.json        # 元数据信息
```

---

### 3. **using-superpowers**
- **位置：** `skills/using-superpowers/`
- **用途：** 工作流程标准化
- **类型：** 流程
- **状态：** ✅ 已安装
- **描述：** 在开始任何对话时确立工作流程，要求先调用 Skill 工具

**文件结构：**
```
skills/using-superpowers/
├── SKILL.md          # 技能说明文档
└── _meta.json        # 元数据信息
```

---

## 🔧 技能安装流程

### 标准流程：

```
1. 接收用户请求
   ↓
2. Using Superpowers 检查是否有适用技能
   ↓
3. Find Skills 搜索相关技能
   ↓
4. Skill Vetter 审核技能安全性
   ↓
5. 生成审核报告
   ↓
6. 根据风险等级决定是否安装
   ↓
7. 记录到 MEMORY.md
```

---

## 📝 技能管理规则

### ✅ 安装前必须：
1. 使用 Find Skills 搜索
2. 使用 Skill Vetter 审核
3. 生成审核报告
4. 记录到 MEMORY.md

### ❌ 禁止：
- 直接安装未经审核的技能
- 跳过安全审核流程
- 未经确认安装高风险技能

### 📋 审核标准：
- 🟢 低风险 → 直接安装
- 🟡 中风险 → 仔细审查后安装
- 🔴 高风险 → 需要白哥确认
- ⛔ 极高风险 → 不安装

---

## 📂 目录结构

```
C:\Users\15093\.openclaw\workspace\
├── Project/           # 项目代码
├── Documents/         # 文档
├── clawshell/         # 脚本
├── skills/            # 技能管理（统一位置）
│   ├── skill-vetter/
│   ├── find-skills/
│   └── using-superpowers/
├── MEMORY.md          # 长期记忆
├── SOUL.md            # 价值观
├── AGENTS.md          # 行为准则
└── USER.md            # 用户信息
```

---

## 🛠️ 后续技能安装

所有新技能都将安装到 `skills/` 目录下：

```bash
# 1. 下载技能代码
git clone <repo> skills/<skill-name>/

# 2. 创建元数据文件
mkdir skills/<skill-name>/_meta.json

# 3. 添加元数据
{
  "name": "<skill-name>",
  "description": "...",
  "version": "1.0.0",
  "author": "<author>",
  "category": "<category>",
  "flags": "mandatory"
}
```

---

## 📊 技能分类

- **security** - 安全相关（如 skill-vetter）
- **discovery** - 搜索发现（如 find-skills）
- **process** - 工作流程（如 using-superpowers）
- **web** - Web 工具（如 tavily-search）
- **weather** - 天气查询
- **coding** - 代码开发
- **productivity** - 生产力工具

---

**更新时间：** 2026 年 4 月 2 日  
**维护者：** 小鱼 🐟
