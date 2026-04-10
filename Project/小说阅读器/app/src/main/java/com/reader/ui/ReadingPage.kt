package com.reader.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReadingPage(
    modifier: Modifier = Modifier,
    content: String = "",
    fontSize: Int = 16,
    lineSpacing: Int = 12,
    textColor: String = "#000000"
) {
    var showChapterSelector by remember { mutableStateOf(false) }
    
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (showChapterSelector) MaterialTheme.colorScheme.surface else Color.White)
        ) {
            if (showChapterSelector) {
                ChapterSelector(
                    onDismiss = { showChapterSelector = false }
                )
            } else {
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .padding(horizontal = 24.dp, vertical = 48.dp)
                ) {
                    // 顶部控制栏
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = { showChapterSelector = true }) {
                            Text("📖 目录")
                        }
                        TextButton(onClick = { }) {
                            Text("🔊 听书")
                        }
                        TextButton(onClick = { }) {
                            Text("⚙️ 设置")
                        }
                    }

                    Spacer(Modifier.height(32.dp))

                    // 正文内容
                    Text(
                        text = content,
                        fontSize = fontSize.sp,
                        lineHeight = fontSize.sp + lineSpacing,
                        fontWeight = FontWeight.Normal,
                        color = if (showChapterSelector) MaterialTheme.colorScheme.onSurface else Color.Black
                    )

                    Spacer(Modifier.weight(1F))

                    // 底部控制
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "📍 当前位置",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Slider(
                            value = 50F,
                            onValueChange = { },
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        Text(
                            text = "50%",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChapterSelector(
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "选择章节",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "第 1 章 - 第一章",
                fontSize = 16.sp
            )
            Text(
                text = "第 2 章 - 第二章",
                fontSize = 16.sp
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = onDismiss) {
                Text("关闭")
            }
        }
    }
}

@Preview
@Composable
fun PreviewReadingPage() {
    MaterialTheme {
        ReadingPage(
            content = "这是小说的正文内容...",
            fontSize = 18
        )
    }
}