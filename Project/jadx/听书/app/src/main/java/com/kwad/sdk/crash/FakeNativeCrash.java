package com.kwad.sdk.crash;

/* JADX INFO: loaded from: classes4.dex */
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    public static native void init(boolean z, int i);

    public static void upload(int i, int i2, String str) {
        com.kwad.sdk.core.d.c.e(TAG, "upload: signal=" + i + ", code=" + i2 + ", nativeBacktraceStr=" + str);
    }
}
