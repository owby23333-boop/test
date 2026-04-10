package com.baidu.tts.bridge.play.player;

import com.anythink.expressad.foundation.d.c;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class PlayCache2Tts {
    private static boolean enableAECPlay = false;
    private Method closeMethod;
    private Object proxy;
    private Method writeMethod;

    PlayCache2Tts(long j2) {
        try {
            this.proxy = Class.forName("com.baidu.speech.PlayCache").getConstructor(Long.TYPE).newInstance(Long.valueOf(j2));
            this.writeMethod = this.proxy.getClass().getDeclaredMethod("write", new byte[0].getClass(), Integer.TYPE, Integer.TYPE);
            this.closeMethod = this.proxy.getClass().getDeclaredMethod(c.cf, new Class[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean getEnableAecPlay() {
        return enableAECPlay;
    }

    public static void setEnableAecPlay(boolean z2) {
        enableAECPlay = z2;
    }

    public static void setSampleRate(int i2) {
        try {
            Class<?> cls = Class.forName("com.baidu.speech.spil.sdk.aec.AecManager");
            cls.getMethod("resetAEC", Integer.TYPE).invoke(cls.newInstance(), Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void close() {
        if (this.closeMethod == null && this.proxy == null) {
            return;
        }
        try {
            this.closeMethod.invoke(this.proxy, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    void write(byte[] bArr, int i2, int i3) {
        if (this.writeMethod == null && this.proxy == null) {
            return;
        }
        try {
            this.writeMethod.invoke(this.proxy, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
