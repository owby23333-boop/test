package com.bytedance.sdk.openadsdk.hh;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f1439a;
    private AudioManager dl;
    private AudioFocusRequest g;
    private boolean gc;
    private AudioAttributes z;

    public z() {
        this.gc = false;
        boolean zL = zw.g().l();
        this.gc = zL;
        if (zL) {
            this.f1439a = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.hh.z.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.dl = (AudioManager) zw.getContext().getSystemService("audio");
        }
    }

    public int z() {
        if (!this.gc) {
            return -1;
        }
        this.z = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.f1439a).setAudioAttributes(this.z).build();
        this.g = audioFocusRequestBuild;
        AudioManager audioManager = this.dl;
        if (audioManager != null) {
            return audioManager.requestAudioFocus(audioFocusRequestBuild);
        }
        return -1;
    }

    public void g() {
        AudioManager audioManager;
        if (this.gc && (audioManager = this.dl) != null) {
            audioManager.abandonAudioFocusRequest(this.g);
        }
    }
}
