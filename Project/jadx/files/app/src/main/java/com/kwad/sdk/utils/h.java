package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private AudioManager amF;
    private AudioManager.OnAudioFocusChangeListener ayd = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i2) {
            if (h.this.gS == null) {
                return;
            }
            bh.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i2 < 0) {
                        h.this.gS.onAudioBeOccupied();
                    } else {
                        h.this.gS.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a gS;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.amF = (AudioManager) context.getSystemService(com.anythink.expressad.exoplayer.k.o.b);
    }

    @TargetApi(26)
    private AudioFocusRequest CV() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.ayd).build();
    }

    public final boolean CU() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.ayd;
        if (onAudioFocusChangeListener != null && (audioManager = this.amF) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(CV());
            }
            if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.gS = aVar;
    }
}
