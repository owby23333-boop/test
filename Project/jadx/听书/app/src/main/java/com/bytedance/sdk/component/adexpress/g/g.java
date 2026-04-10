package com.bytedance.sdk.component.adexpress.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.g.uy;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class g implements uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gz f577a;
    private ThemeStatusBroadcastReceiver dl;
    private com.bytedance.sdk.component.adexpress.dynamic.z.z g;
    private i gc;
    private int m;
    private Context z;

    public g(Context context, i iVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.a.gz gzVar, gz gzVar2, com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar) {
        this(context, iVar, themeStatusBroadcastReceiver, z, gzVar, gzVar2, zVar, null);
    }

    public g(Context context, i iVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.a.gz gzVar, gz gzVar2, com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar, com.bytedance.sdk.component.adexpress.dynamic.z.z zVar2) {
        this.z = context;
        this.gc = iVar;
        this.dl = themeStatusBroadcastReceiver;
        this.f577a = gzVar2;
        if (zVar2 != null) {
            this.g = zVar2;
        } else {
            this.g = new com.bytedance.sdk.component.adexpress.dynamic.z.z(this.z, this.dl, z, gzVar, this.gc, zVar);
        }
        this.g.z(this.f577a);
        if (gzVar instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e) {
            this.m = 3;
        } else {
            this.m = 2;
        }
    }

    public void z(boolean z) {
        this.g.g(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public boolean z(final uy.z zVar) {
        this.gc.e().z(this.m);
        this.g.z(new e() { // from class: com.bytedance.sdk.component.adexpress.g.g.1
            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(View view, v vVar) {
                if (zVar.dl()) {
                    return;
                }
                g.this.gc.e().gc(g.this.m);
                g.this.gc.e().m(g.this.m);
                g.this.gc.e().i();
                pf pfVarG = zVar.g();
                if (pfVarG == null) {
                    return;
                }
                pfVarG.z(g.this.g, vVar);
                zVar.z(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(int i, String str) {
                g.this.gc.e().z(g.this.m, i, str, zVar.g(g.this));
                if (zVar.g(g.this)) {
                    zVar.z(g.this);
                    return;
                }
                pf pfVarG = zVar.g();
                if (pfVarG == null) {
                    return;
                }
                pfVarG.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public void z() {
        com.bytedance.sdk.component.adexpress.dynamic.z.z zVar = this.g;
        if (zVar != null) {
            zVar.g();
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.a g() {
        com.bytedance.sdk.component.adexpress.dynamic.z.z zVar = this.g;
        if (zVar != null) {
            return zVar.m();
        }
        return null;
    }
}
