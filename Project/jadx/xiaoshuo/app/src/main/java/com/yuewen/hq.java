package com.yuewen;

import android.content.Context;
import com.yuewen.es2;

/* JADX INFO: loaded from: classes13.dex */
public class hq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12089a = 3;

    public static int a(Context context, int i) {
        int iB = b();
        return (i - ((iB - 1) * ((int) Math.ceil(context.getResources().getDimension(es2.g.n3))))) / iB;
    }

    public static int b() {
        return 3;
    }
}
