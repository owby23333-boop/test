package com.duokan.kernel;

/* JADX INFO: loaded from: classes11.dex */
public abstract class DkNative {
    static {
        System.loadLibrary("dkkernel");
        load();
    }

    private static native void load();
}
