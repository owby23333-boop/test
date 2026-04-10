name: markdown-to-word
description: >
  将 Markdown 文档转换为 Word 格式 (.docx)。支持标题、段落、列表、表格、代码块等元素。自动识别 Markdown 结构并转换为 Word 格式。
---

# Markdown 转 Word 技能

## 功能

- 将 Markdown 文件转换为 Word 格式
- 支持标题、段落、列表、表格
- 支持代码块和高亮
- 自动样式格式化

## 使用方式

```python
# 基本用法
markdown_to_word('content.md', 'output.docx')

# 自定义样式
markdown_to_word(
    'content.md', 
    'output.docx',
    font_size=12,
    line_spacing=1.5
)
```

## 安装依赖

```bash
pip install python-docx
```

## 转换规则

- # = 一级标题 (Heading 1)
- ## = 二级标题 (Heading 2)
- 粗体：使用加粗字体
- 斜体：使用斜体字体
- 代码块：使用等宽字体
- 列表：使用项目符号或编号
- 表格：转换为 Word 表格