package com.reader.domain.tts

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.speech.tts.*
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TTSManager(private val context: Context) {

    private val tts = TextToSpeech(object : TextToSpeech.OnInitListener {
        override fun onStart(status: Int) {}

        override fun onReadyForSpeech(params: Params?) {}

        override fun onSpeakCompleted() {}

        override fun onIdle() {}

        override fun onError(error: Int) {}

        override fun onDone() {}

        override fun onReady() {
            this@TTSManager.isReady = true
        }
    })

    private val engineManager = EngineManager(context)

    private val _status: StateFlow<TTSStatus> = MutableStateFlow(TTSStatus.Idle)
    val status: StateFlow<TTSStatus> = _status

    var isReady: Boolean = false
        private set

    private var currentQueueIndex = 0
    private val queue = mutableListOf<CharSequence>()

    var speaking = false
        private set

    var queueModeEnabled = false
        private set

    var speakPunctuation = true
        private set

    var pitch = 0.0
        private set

    var rate = 1.0f
        private set

    fun queueSpeak(text: CharSequence) {
        if (!queueModeEnabled) return

        queue.add(text)
        if (speaking) {
            currentQueueIndex++
        } else {
            currentQueueIndex = 0
        }
    }

    fun isSpeaking(): Boolean = speaking

    fun queueSize(): Int = queue.size - currentQueueIndex

    fun pause() {
        if (speaking) {
            tts.pause()
        }
    }

    fun resume() {
        if (speaking) {
            tts.resume()
        }
    }

    fun stop() {
        tts.stop()
        speaking = false
        tts.shutdown()
    }

    fun speak(text: CharSequence) {
        if (!isReady) {
            Toast.makeText(context, "TTS 尚未准备好", Toast.LENGTH_SHORT).show()
            return
        }

        queue.clear()
        currentQueueIndex = 0

        queueSpeak(text)
        if (queue.isNotEmpty()) {
            speakNow()
        }
    }

    private fun speakNow() {
        if (currentQueueIndex < queue.size) {
            tts.speak(queue[currentQueueIndex], QUEUE_FLUSH)
            speaking = true
        } else {
            stop()
        }
    }

    fun queueSpeak(text: CharSequence, pitch: Float, rate: Float) {
        if (!queueModeEnabled) return

        queue.add(text)
        if (speaking) {
            currentQueueIndex++
        } else {
            currentQueueIndex = 0
        }
    }

    fun cancel() {
        if (speaking) {
            tts.cancel()
        }
    }

    fun getVoice(): Voice? = tts.voice
}

enum class TTSStatus {
    Idle,
    Ready,
    Speaking,
    Paused
}
