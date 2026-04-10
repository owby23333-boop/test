package com.bytedance.sdk.openadsdk.core.g.z.z;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.gc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.core.g.z.z {
    g gc = new g();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.g.z.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0171z {
        void z(View view, int i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.g.z.dl dlVar) {
        return 0;
    }

    public void z(int i) {
        this.gc.g(i);
    }

    public void z(Map<String, Object> map) {
        this.gc.z(map);
    }

    public void z(String str) {
        this.gc.z(str);
    }

    public void z(boolean z) {
        this.gc.z(z);
    }

    public void z(na naVar) {
        this.z = naVar;
        this.gc.z(naVar);
    }

    public void z(Context context) {
        this.g = context;
        this.gc.z(context);
    }

    public void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar) {
        this.gc.z(dlVar);
    }

    public com.bytedance.sdk.openadsdk.core.kb.g.dl z() {
        return this.gc.m();
    }

    public void g(boolean z) {
        this.gc.a(z);
    }

    public void z(Object obj) {
        this.gc.z(obj);
    }

    public void dl(boolean z) {
        this.gc.dl(z);
    }

    public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
        this.gc.z(zVar);
    }

    public void a(boolean z) {
        this.gc.g(z);
    }

    public void z(InterfaceC0171z interfaceC0171z) {
        this.gc.z(interfaceC0171z);
    }

    protected void g(int i) {
        if (this.gc.a()) {
            this.gc.z(i);
        }
    }

    public void z(long j) {
        this.gc.z(j);
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.gc.z(gVar);
    }

    public g g() {
        return this.gc;
    }

    protected void dl() {
        if (this.gc.g() && this.gc.a()) {
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarM = this.gc.m();
            if (dlVarM instanceof gc) {
                ((gc) dlVarM).m(true);
            }
        }
    }

    protected void a() {
        if (this.gc.a()) {
            com.bytedance.sdk.openadsdk.q.z.g.z.z zVarGc = this.gc.gc();
            if (!eo.dl(this.z) || zVarGc == null) {
                return;
            }
            zVarGc.g();
        }
    }
}
