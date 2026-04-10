package com.bytedance.sdk.openadsdk.core.io;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.openadsdk.core.fo;
import com.bytedance.sdk.openadsdk.core.q.v;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements io<Bitmap> {
    private com.bytedance.sdk.openadsdk.core.q.z.g g;
    private boolean z;

    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.dl(str);
    }

    public void z(int i) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.z(i);
    }

    public void g(String str) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.m(str);
    }

    public void dl(String str) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.a(str);
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.gz(str);
    }

    public dl(boolean z) {
        this.z = z;
        if (z) {
            this.g = com.bytedance.sdk.openadsdk.core.q.z.g.g();
        }
    }

    @Override // com.bytedance.sdk.component.m.io
    public void onSuccess(ls<Bitmap> lsVar) {
        if (!this.z || this.g == null) {
            return;
        }
        if (lsVar == null || lsVar.getResult() == null) {
            this.g.g(202).e(fo.z(202));
            v.z().z(this.g);
        }
    }

    @Override // com.bytedance.sdk.component.m.io
    public void onFailed(int i, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.q.z.g gVar;
        if (!this.z || (gVar = this.g) == null) {
            return;
        }
        gVar.g(201).e(fo.z(201));
        v.z().z(this.g);
    }
}
