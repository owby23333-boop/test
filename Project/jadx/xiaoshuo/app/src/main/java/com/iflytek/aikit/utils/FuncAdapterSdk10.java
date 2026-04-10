package com.iflytek.aikit.utils;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import com.iflytek.aikit.utils.log.LogUtil;

/* JADX INFO: loaded from: classes7.dex */
public class FuncAdapterSdk10 {
    private static int avoidValue;

    public static void CloseHardWareAccelerate(View view) {
        view.setLayerType(1, null);
    }

    public static boolean Lock(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            LogUtil.d("start request music_stream focus");
            ((AudioManager) context.getSystemService("audio")).requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean UnLock(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            LogUtil.d("start abandon audio focus");
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(onAudioFocusChangeListener);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void avoidSystemError(int i) {
        LogUtil.d("avoidSystemError");
        avoidValue = i;
    }
}
