# 📖 小说阅读器 App

## 🎯 项目简介

一个功能完善的 Android 小说阅读器 App，支持看书和听书双模式，提供舒适的阅读体验。

**版本：** v1.0.0  
**状态：** 开发中  
**技术栈：** Kotlin + Jetpack Compose

---

## ✨ 核心功能

### 📖 阅读模式
- ✅ 支持 TXT、MD、EPUB 等格式
- ✅ 本地和云端资源管理
- ✅ 目录导航和搜索
- ✅ 章节快速跳转
- ✅ 阅读进度自动保存

### 🔊 TTS 听书模式
- ✅ 接入 Android 系统 TTS
- ✅ 自定义朗读声音
- ✅ 调节朗读速度
- ✅ 连续朗读/暂停/停止
- ✅ 朗读进度记忆

### 💾 阅读管理
- ✅ 自动保存阅读进度
- ✅ 章节书签
- ✅ 笔记和高亮
- ✅ 恢复继续阅读位置

### 🎨 主题定制
- ✅ 亮色/暗色/护眼主题
- ✅ 字体大小调节
- ✅ 行间距、页边距
- ✅ 夜间模式

---

## 📱 技术架构

### 技术栈
- **语言：** Kotlin
- **架构：** MVVM + Jetpack Compose
- **依赖管理：** Gradle 8.0+
- **数据库：** Room + SQLite
- **TTS:** Android 系统 Text-to-Speech API
- **网络：** Retrofit + OkHttp

### 核心依赖
```kotlin
dependencies {
    // Core Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    
    // Compose
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")
    
    // Room Database
    implementation("androidx.room:room-runtime:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
```

---

## 📦 项目结构

```
app/
├── app/src/main/
│   ├── java/com/reader/
│   │   ├── data/           # 数据层
│   │   │   ├── model/      # 数据模型 (Book, ReadingProgress)
│   │   │   ├── dao/        # Room DAO
│   │   │   ├── local/      # 本地数据管理
│   │   │   └── remote/     # 远程数据管理
│   │   ├── database/       # 数据库
│   │   ├── domain/         # 业务逻辑层
│   │   └── ui/             # 界面层
│   │       ├── theme/      # 主题配置
│   │       ├── screens/    # 页面组件
│   │       └── components/ # 可复用组件
│   └── res/                # 资源文件
│       ├── values/         # 常规资源
│       └── values-night/   # 夜间资源
└── build.gradle.kts
```

---

## 🚀 开发指南

### 环境要求
- Android Studio Hedgehog 或更新版本
- JDK 17
- Android SDK 34

### 编译配置
```bash
# 编译项目
./gradlew assembleDebug

# 安装到设备
./gradlew installDebug

# 运行测试
./gradlew test
```

### 开发步骤

#### Phase 1 - 基础架构
1. ✅ 创建项目结构
2. ✅ 配置 Gradle
3. ✅ 实现基础 UI 组件
4. ✅ 设置主题和样式

#### Phase 2 - 核心功能
1. 📝 实现 TXT 阅读器
2. 🔊 实现 TTS 朗读
3. 💾 实现进度保存
4. 📖 实现目录导航

#### Phase 3 - 增强功能
1. 📚 支持 EPUB 格式
2. 📝 笔记和高亮
3. 🎨 自定义主题
4. 📊 阅读统计

---

## 🗂️ 数据库模型

### Book（书籍）
```kotlin
data class Book(
    val id: String,              // 书籍 ID
    val title: String,           // 书名
    val author: String,          // 作者
    val coverUrl: String?,       // 封面 URL
    val totalChapters: Int,      // 总章节数
    val lastReadChapter: Int,    // 最后阅读章节
    val lastReadProgress: Int,   // 最后阅读进度
    val isFavorite: Boolean       // 是否收藏
)
```

### ReadingProgress（阅读进度）
```kotlin
data class ReadingProgress(
    val id: Int,
    val bookId: String,
    val chapterId: String,
    val chapterTitle: String,
    val progressPercent: Int,
    val contentOffset: Int,
    val lastReadTime: Long,
    val isBookmarked: Boolean,
    val notes: String?
)
```

---

## 🎨 UI 设计

### 主题配色
- **主色：** #FF6B9D（紫粉色）
- **辅助色：** #6C5CE7
- **背景色：** #FAFAFA（亮色）/#1A1A2E（暗色）
- **文字色：** #333333（亮色）/#FFFFFF（暗色）

### 核心页面
- 📚 书架 - 书籍列表和最近阅读
- 📖 阅读页 - 看书主界面
- 🔊 TTS 设置 - 语音配置
- ⚙️ 设置页 - 全局设置
- 📥 导入管理 - 文件导入

---

## ⚠️ 注意事项

### 1. TTS 权限
- ✅ 无需额外权限，使用系统 TTS
- ✅ 确保语音包已安装
- ⚠️ 某些 ROM 可能需要权限

### 2. 文件访问
- ✅ 使用 Android File Provider
- ✅ 支持 Android 10+ 分区存储
- ⚠️ Android 9 及以下需要存储权限

### 3. 数据隐私
- ✅ 所有数据本地存储
- ✅ 可选加密保存
- ✅ 无数据上传

### 4. 兼容性
- ✅ 最低 Android 8.0
- ✅ 目标 Android 14
- ⚠️ 测试 Android 10-14 版本

---

## 📦 使用示例

### 导入书籍
```kotlin
// 从文件管理器导入
Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
    type = "*/*"
    addCategory(Intent.CATEGORY_OPENABLE)
    activity.startActivity(this)
}
```

### 开始阅读
```kotlin
// 打开阅读器
Navigation.findNavController(...)
    .navigate(Screen.Reading)
```

### TTS 朗读
```kotlin
// 初始化 TTS
val tts = TextToSpeech(context) { status ->
    if (status == TextToSpeech.SUCCESS) {
        val result = tts.setLanguage(Locale.CHINESE)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            // 处理语言不支持
        }
    }
}
```

---

## 🤝 贡献指南

1. Fork 项目
2. 创建特性分支
3. 提交 Pull Request

## 📄 许可

MIT License

## 📞 联系

开发者：小鱼（全栈 AI 工程师）  
邮箱：your-email@example.com

---

**开发状态：** 基础功能已完成，正在开发中...  
**下一步：** 添加 EPUB 支持、云端同步等
