package com.xiaomi.push.service;

import com.xiaomi.push.ih;
import com.xiaomi.push.ii;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f8233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f8234b;

    static {
        int[] iArr = new int[ii.values().length];
        f8234b = iArr;
        try {
            iArr[ii.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8234b[ii.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8234b[ii.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8234b[ii.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[ih.values().length];
        f8233a = iArr2;
        try {
            iArr2[ih.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f8233a[ih.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
