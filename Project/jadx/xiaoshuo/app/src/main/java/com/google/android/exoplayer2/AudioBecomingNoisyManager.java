package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes7.dex */
final class AudioBecomingNoisyManager {
    private final Context context;
    private final AudioBecomingNoisyReceiver receiver;
    private boolean receiverRegistered;

    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler eventHandler;

        /* JADX INFO: renamed from: listener, reason: collision with root package name */
        private final EventListener f6788listener;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.eventHandler = handler;
            this.f6788listener = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.receiverRegistered) {
                this.f6788listener.onAudioBecomingNoisy();
            }
        }
    }

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.context = context.getApplicationContext();
        this.receiver = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void setEnabled(boolean z) {
        if (z && !this.receiverRegistered) {
            this.context.registerReceiver(this.receiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.receiverRegistered = true;
        } else {
            if (z || !this.receiverRegistered) {
                return;
            }
            this.context.unregisterReceiver(this.receiver);
            this.receiverRegistered = false;
        }
    }
}
