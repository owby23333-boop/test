package com.iflytek.aikit.plugin.player;

import android.media.AudioManager;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class FuncAdapterSdk10 {
    private static int avoidValue;

    public static void CloseHardWareAccelerate(View view) {
        view.setLayerType(1, null);
    }

    public static boolean Lock(AudioManager audioManager, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (audioManager == null) {
            return false;
        }
        try {
            Log.d("AudioPlayer", "start request music_stream focus");
            audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean UnLock(AudioManager audioManager, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (audioManager == null) {
            return false;
        }
        try {
            Log.d("AudioPlayer", "start abandon audio focus");
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void avoidSystemError(int i) {
        Log.d("AudioPlayer", "avoidSystemError");
        avoidValue = i;
    }
}
