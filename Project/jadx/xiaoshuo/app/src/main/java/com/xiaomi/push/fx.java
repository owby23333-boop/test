package com.xiaomi.push;

import com.xiaomi.push.service.bg;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7983a;

    static {
        int[] iArr = new int[bg.c.values().length];
        f7983a = iArr;
        try {
            iArr[bg.c.unbind.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7983a[bg.c.binding.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7983a[bg.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
