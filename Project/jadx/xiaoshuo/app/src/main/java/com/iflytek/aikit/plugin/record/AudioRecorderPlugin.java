package com.iflytek.aikit.plugin.record;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class AudioRecorderPlugin {
    private AudioRecorderPlugin AudioRecorderPlugin;
    private Context mContext;

    public static class Holder {
        private Holder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AudioRecorderPlugin getInstance(Context context) {
            return new AudioRecorderPlugin(context);
        }
    }

    public static AudioRecorderPlugin getInst(Context context) {
        return Holder.getInstance(context);
    }

    public AudioRecorderPlugin audioFormat() {
        return this;
    }

    public AudioRecorderPlugin audioSource() {
        return this;
    }

    public void pause() {
    }

    public void release() {
    }

    public void resume() {
    }

    public void setListener(RecorderListener recorderListener) {
    }

    public void start() {
    }

    public void stop() {
    }

    private AudioRecorderPlugin(Context context) {
        this.mContext = context;
        if (this.AudioRecorderPlugin == null) {
            this.AudioRecorderPlugin = new AudioRecorderPlugin(context);
        }
    }
}
