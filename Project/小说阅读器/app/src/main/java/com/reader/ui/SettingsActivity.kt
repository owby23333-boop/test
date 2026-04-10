package com.reader.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsActivity() {
    var font_size by remember { mutableStateOf("16") }
    var line_spacing by remember { mutableStateOf("12") }
    var theme_mode by remember { mutableIntStateOf(0) } // 0:亮色 1:暗色 2:护眼
    
    var tts_enabled by remember { mutableStateOf(true) }
    var tts_rate by remember { mutableFloatStateOf(1.0f) }
    
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
                    text = "⚙️ 设置",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(24.dp))

                // 字体设置
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🔤 字体设置",
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OutlinedTextField(
                                value = font_size,
                                onValueChange = { font_size = it },
                                modifier = Modifier.weight(1f),
                                label = { Text("字体大小") }
                            )
                            OutlinedTextField(
                                value = line_spacing,
                                onValueChange = { line_spacing = it },
                                modifier = Modifier.weight(1f),
                                label = { Text("行间距") }
                            )
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))

                // 主题设置
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🎨 主题设置",
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { theme_mode = 0 },
                                enabled = theme_mode != 1,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (theme_mode != 1) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                                )
                            ) {
                                Text("亮色")
                            }
                            Button(
                                onClick = { theme_mode = 1 },
                                enabled = theme_mode != 2,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (theme_mode != 2) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                                )
                            ) {
                                Text("暗色")
                            }
                            Button(
                                onClick = { theme_mode = 2 },
                                enabled = theme_mode != 0,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (theme_mode != 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                                )
                            ) {
                                Text("护眼")
                            }
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))

                // TTS 设置
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🔊 TTS 设置",
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(Modifier.height(8.dp))
                        Switch(
                            checked = tts_enabled,
                            onCheckedChange = { tts_enabled = it }
                        )
                        Text(
                            text = "启用语音朗读",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "语速：${String.format("%.1f", tts_rate)}x",
                            fontSize = 14.sp
                        )
                        Slider(
                            value = tts_rate,
                            onValueChange = { tts_rate = it },
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                // 说明
                Text(
                    text = "💡 提示",
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "TTS 功能使用 Android 系统语音引擎，无需额外权限。",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsActivity() {
    MaterialTheme {
        SettingsActivity()
    }
}