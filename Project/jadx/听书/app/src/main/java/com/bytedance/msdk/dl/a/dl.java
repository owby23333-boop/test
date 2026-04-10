package com.bytedance.msdk.dl.a;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.core.gc.g.a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g implements com.bytedance.msdk.core.gc.g.g {
    public dl(Context context) {
        super(context);
    }

    @Override // com.bytedance.msdk.core.gc.g.g
    public void z(Context context, com.bytedance.msdk.api.z.g gVar, a.dl dlVar) {
        z(gVar);
        this.dl.g(true);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.dl.z(jCurrentThreadTimeMillis);
        this.dl.z(dlVar);
        com.bytedance.msdk.core.gc.g.a.z().z(this.gc, jCurrentThreadTimeMillis);
        fo();
    }

    @Override // com.bytedance.msdk.core.gc.g.g
    public int e_() {
        if (this.dl != null) {
            return this.dl.sy();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.core.gc.g.g
    public ConcurrentHashMap<String, com.bytedance.msdk.api.g> dl() {
        if (this.dl != null) {
            return this.dl.io();
        }
        return null;
    }

    @Override // com.bytedance.msdk.core.gc.g.g
    public com.bytedance.msdk.dl.m.z.g a() {
        return this.dl;
    }
}
