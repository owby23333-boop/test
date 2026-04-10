package com.bytedance.sdk.component.p.e.ga;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class v implements Comparable<v>, Runnable {
    private String d;
    private int e = 5;
    private String bf = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());

    public v(String str) {
        this.d = str;
    }

    public void e(int i) {
        this.e = i;
    }

    public int e() {
        return this.e;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        if (e() < vVar.e()) {
            return 1;
        }
        return e() >= vVar.e() ? -1 : 0;
    }
}
