---
name: android-kotlin-development
description: 用 Kotlin 开发原生 Android 应用 - 涵盖 MVVM 架构、Jetpack 组件、Compose UI、Retrofit API、Room 存储、导航架构等。138 stars | aj-geddes
version: 1.0.0
author: aj-geddes
category: development
flags: optional
license: MIT
---

# Android Kotlin Development

用 Kotlin 开发原生 Android 应用的最佳实践指南。

## 核心功能

### 🏗️ 架构模式
- **MVVM 架构**：ViewModel + LiveData + StateFlow
- **Jetpack 组件**：Navigation、Lifecycle、Hilt、Room
- **Compose UI**：声明式界面
- **协程**：异步操作管理

### 📦 核心依赖

```kotlin
dependencies {
    // MVVM
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    
    // 网络
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    
    // 数据库
    implementation("androidx.room:room-runtime:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")
    
    // 依赖注入
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")
}
```

### 📋 数据模型

```kotlin
// Models
data class User(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null
)

data class Item(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val price: Double
)
```

### 🌐 API 服务

```kotlin
// API Service with Retrofit
interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: String): User
    
    @PUT("users/{id}")
    suspend fun updateUser(
        @Path("id") userId: String,
        @Body user: User
    )
}
```

## 使用指南

### ✅ DO（推荐做法）

- ✅ 用 Kotlin 开发
- ✅ MVVM 架构
- ✅ Jetpack 组件
- ✅ Compose UI
- ✅ 协程异步
- ✅ Room 数据库
- ✅ Hilt 注入
- ✅ 状态管理

### ❌ DON'T（避免做法）

- ❌ SharedPreferences 存 Token
- ❌ 主线程网络请求
- ❌ 忽略生命周期
- ❌ 空安全检查
- ❌ 硬编码字符串
- ❌ 密码硬编码
- ❌ 未测试设备

## 快速开始

```kotlin
// ViewModel
class MainViewModel(
    private val repo: MainRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    
    fun loadData() {
        viewModelScope.launch {
            repo.fetchData()
                .onSuccess { _uiState.value = UiState.Success(it) }
                .onFailure { _uiState.value = UiState.Error(it) }
        }
    }
}

// Repository
class MainRepository(
    private val apiService: ApiService,
    private val dao: MainDao
) {
    suspend fun fetchData(): Result<List<Item>> {
        return try {
            val items = apiService.getItems()
            // 本地缓存
            dao.insertAll(items)
            Result.success(items)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
```

## 参考文档

详细实现见 references/ 目录：

| 文档 | 说明 |
|------|------|
| Models & API Service | 数据模型与 API |
| MVVM ViewModels | ViewModel 实现 |
| Jetpack Compose UI | UI 界面实现 |

## 最佳实践

### 1. 数据层
```kotlin
// Repository 模式
class MainRepository(
    private val api: ApiService,
    private val dao: MainDao,
    private val storage: DataStore
) : MainRepositoryInterface
```

### 2. UI 层
```kotlin
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    
    when (state) {
        is UiState.Loading -> LoadingScreen()
        is UiState.Success -> SuccessScreen(state.items)
        is UiState.Error -> ErrorScreen(state.error)
    }
}
```

### 3. 依赖注入
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}
```

## 注意事项

⚠️ **重要：**
1. 仅提供开发建议
2. 需手动应用建议
3. 依赖开发者自行实现
4. 参考文档需手动阅读

## 安装方式

```bash
# 克隆技能目录
git clone <repo> skills/android-kotlin-development/

# 或手动下载 SKILL.md
# 放置在 ~/.openclaw/skills/ 目录下
```

## 优势

- 🚀 官方推荐架构
- 📚 最佳实践指导
- 🛡️ 安全可靠
- ⚡ 提升开发效率
- 📱 现代 Android 开发

## Credits

Skill created by aj-geddes
License: MIT
