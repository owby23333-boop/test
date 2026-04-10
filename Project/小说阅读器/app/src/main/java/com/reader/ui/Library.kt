package com.reader.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Library() {
    var selectedBook by remember { mutableStateOf<String?>(null) }
    
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // 顶部标题
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📚 书架",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    
                    // 搜索框
                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
                        modifier = Modifier.width(200.dp),
                        label = { Text("搜索书籍") },
                        leadingIcon = {
                            Icon(
                                ImageVector.Builder().build(),
                                contentDescription = "搜索",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )
                }

                Spacer(Modifier.height(16.dp))

                // 最近阅读
                Text(
                    text = "📖 最近阅读",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(8.dp))

                // 书籍列表
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.Builder().build(),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(Modifier.width(12.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "第 1 章 - 第一章",
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "《书名示例》",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Text(
                            text = "99%",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                // 其他书籍
                Text(
                    text = "📖 其他书籍",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(8.dp))

                // 更多书籍卡片
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.Builder().build(),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(Modifier.width(12.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "第 1 章 - 第一章",
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "《其他书名》",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Text(
                            text = "50%",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                // 导入按钮
                Button(
                    onClick = { },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("📥 导入新小说")
                }

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "💡 提示",
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "支持 TXT、MD、EPUB 等格式文件。",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImportBooks() {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "📥 导入小说",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("📂 从文件管理器选择")
                }

                Spacer(Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("☁️ 从云端同步")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLibrary() {
    MaterialTheme {
        Library()
    }
}