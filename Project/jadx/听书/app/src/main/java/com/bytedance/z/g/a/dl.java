package com.bytedance.z.g.a;

import android.content.Context;
import com.bytedance.z.g.gc.z.gc;
import com.bytedance.z.g.gz.a;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements g {
    private Context z;

    @Override // com.bytedance.z.g.a.g
    public boolean z(Throwable th) {
        return true;
    }

    @Override // com.bytedance.z.g.a.g
    public void z(long j, Thread thread, Throwable th) throws Throwable {
        com.bytedance.z.g.dl.z zVarZ = com.bytedance.z.g.dl.z.z(j, this.z, thread, th);
        a.z(this.z, com.bytedance.z.g.dl.JAVA.z(), Thread.currentThread().getName());
        com.bytedance.z.g.e.z.z().z(gc.z().z(com.bytedance.z.g.dl.JAVA, zVarZ).z());
    }

    public dl(Context context) {
        this.z = context;
    }
}
