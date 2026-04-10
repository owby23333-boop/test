package com.xiaomi.mipush.sdk;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7426a;

    static {
        int[] iArr = new int[aq.values().length];
        f7426a = iArr;
        try {
            iArr[aq.DISABLE_PUSH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7426a[aq.ENABLE_PUSH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7426a[aq.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7426a[aq.UPLOAD_FCM_TOKEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7426a[aq.UPLOAD_COS_TOKEN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7426a[aq.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
