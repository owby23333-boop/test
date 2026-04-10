package com.xiaomi.mipush.sdk;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7439a;

    static {
        int[] iArr = new int[d.values().length];
        f7439a = iArr;
        try {
            iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7439a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7439a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7439a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
