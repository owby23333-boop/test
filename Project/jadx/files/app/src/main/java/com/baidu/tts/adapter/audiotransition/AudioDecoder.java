package com.baidu.tts.adapter.audiotransition;

/* JADX INFO: loaded from: classes2.dex */
public class AudioDecoder<S, T> {
    private IAudioTransitionAdapter<S, T> mVoiceDecoderAdapter;

    public S decode(T t2) {
        return this.mVoiceDecoderAdapter.getAdaptedData(t2);
    }

    public void initial() {
        this.mVoiceDecoderAdapter.initial();
    }

    public void release() {
        this.mVoiceDecoderAdapter.release();
    }

    public void setVoiceDecoderAdapter(IAudioTransitionAdapter<S, T> iAudioTransitionAdapter) {
        this.mVoiceDecoderAdapter = iAudioTransitionAdapter;
    }

    public void start() {
        this.mVoiceDecoderAdapter.start();
    }

    public void stop() {
        this.mVoiceDecoderAdapter.stop();
    }
}
