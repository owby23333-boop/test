package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public abstract class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7878a;

    public df(int i) {
        this.f7878a = i;
    }

    public abstract String a(Context context, String str, List<be> list);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m295a(Context context, String str, List<be> list) {
        return true;
    }

    public int a() {
        return this.f7878a;
    }
}
