package com.bytedance.sdk.component.gz.g.g;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.gz.z.m;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static long z(int i, Context context, gc gcVar) {
        return g(i, context, gcVar);
    }

    private static long g(int i, Context context, gc gcVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long jMaxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            if (jFreeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean z(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.z())) ? false : true;
    }

    public static boolean g(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.g())) ? false : true;
    }

    public static boolean dl(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.a())) ? false : true;
    }

    public static boolean a(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.gc())) ? false : true;
    }

    public static boolean gc(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.dl())) ? false : true;
    }

    public static boolean m(gc gcVar) {
        m mVarG = gcVar.g();
        return (mVarG == null || TextUtils.isEmpty(mVarG.m())) ? false : true;
    }
}
