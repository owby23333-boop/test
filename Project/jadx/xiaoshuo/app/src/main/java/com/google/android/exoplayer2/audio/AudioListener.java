package com.google.android.exoplayer2.audio;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface AudioListener {
    default void onAudioAttributesChanged(AudioAttributes audioAttributes) {
    }

    default void onAudioSessionIdChanged(int i) {
    }

    default void onSkipSilenceEnabledChanged(boolean z) {
    }

    default void onVolumeChanged(float f) {
    }
}
