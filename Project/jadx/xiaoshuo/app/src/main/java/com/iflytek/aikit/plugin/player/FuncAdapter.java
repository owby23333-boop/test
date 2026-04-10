package com.iflytek.aikit.plugin.player;

import android.media.AudioManager;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class FuncAdapter {
    public static int SDK_GINGERBREAD = 9;
    public static int SDK_ICECREM = 14;

    public static void CloseHardWareAccelerate(View view) {
        if (Build.VERSION.SDK_INT >= SDK_ICECREM) {
            FuncAdapterSdk10.CloseHardWareAccelerate(view);
        }
    }

    public static boolean Lock(AudioManager audioManager, Boolean bool, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (!bool.booleanValue() || Build.VERSION.SDK_INT < SDK_GINGERBREAD) {
            return false;
        }
        FuncAdapterSdk10.Lock(audioManager, onAudioFocusChangeListener);
        return false;
    }

    public static boolean UnLock(AudioManager audioManager, Boolean bool, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (!bool.booleanValue() || Build.VERSION.SDK_INT < SDK_GINGERBREAD) {
            return false;
        }
        return FuncAdapterSdk10.UnLock(audioManager, onAudioFocusChangeListener);
    }
}
