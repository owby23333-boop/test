package com.reader.ui

import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TtsActivity(
    tts: TextToSpeech? = null
) {
    var text by remember { mutableStateOf("") }
    var isSpeaking by remember { mutableStateOf(false) }
    var rate by remember { mutableFloatStateOf(1.0f) }
    
    val context = LocalContext.current
    
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
                    text = "🔊 语音朗读设置",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "朗读内容：",
                    fontSize = 14.sp
                )
                
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp)
                        .padding(vertical = 8.dp),
                    maxLines = 10,
                    label = { Text("输入小说内容或粘贴章节") }
                )

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Slider(
                        value = rate,
                        onValueChange = { rate = it },
                        steps = 10,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "语速：${String.format("%.1f", rate)}x",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Spacer(Modifier.height(8.dp))

                // 控制按钮
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { /* 暂停 */ },
                        enabled = isSpeaking
                    ) {
                        Text("⏸️ 暂停")
                    }

                    Button(
                        onClick = { /* 继续 */ },
                        enabled = !isSpeaking
                    ) {
                        Text("▶️ 继续")
                    }

                    Button(
                        onClick = { /* 停止 */ },
                        enabled = true
                    ) {
                        Text("⏹️ 停止")
                    }
                }

                Spacer(Modifier.height(16.dp))

                // 状态提示
                if (isSpeaking) {
                    Text(
                        text = "🔊 正在朗读...",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTtsActivity() {
    MaterialTheme {
        TtsActivity()
    }
}