### 🛠️ 最佳实践流程：代码编写 $\rightarrow$ GitHub 自动化流程 (Bubble Sort)

**🎯 目标：** 模拟完整的开发工作流，从代码创建到远程仓库同步，并准备创建 Pull Request。

**✅ 流程验证点：** 本次任务成功验证了：
1.  代码编写能力。
2.  本地 Git 初始化 (`git init`)。
3.  提交代码 (`git add` & `git commit`)。
4.  GitHub 仓库创建 (`gh repo create`)。
5.  本地代码推送到远程 (`git push --set-upstream origin master`)。

**⭐ 核心指令序列（可直接复用）：**

1.  **代码创建:** 使用 `write` 工具在目标目录创建代码文件（如 `bubble_sort.py`）。
2.  **Git 状态管理:**
    *   `git add <文件>`
    *   `git commit -m "feat: [描述]"`
    *   *（注意：首次运行时，如果目录未初始化，应先执行 `git init`）*
3.  **远程同步 (Push):**
    *   `git remote add origin <New_Repo_URL>`
    *   `git push --set-upstream origin master`
4.  **流程收尾:** `gh pr create --title "..." --body "..."`

**❗ 注意事项 (⚠️ 警告)：**
*   **凭证 (Credentials):** 流程执行的成功与否，高度依赖于本地 Git 凭证的有效性。如果 `git push` 失败，请优先执行 `gh auth login` 刷新凭证。
*   **目录管理:** 务必在目标项目目录内进行所有 Git 操作。

**本次流程测试通过，逻辑和指令序列已固化。**