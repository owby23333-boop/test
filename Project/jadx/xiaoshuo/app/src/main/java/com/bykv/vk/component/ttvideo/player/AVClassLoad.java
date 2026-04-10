package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("UTILS")
class AVClassLoad {
    @CalledByNative
    public static Object getClassLoader() {
        return AVClassLoad.class.getClassLoader();
    }
}
