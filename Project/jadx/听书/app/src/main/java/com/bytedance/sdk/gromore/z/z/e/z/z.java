package com.bytedance.sdk.gromore.z.z.e.z;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.msdk.dl.a.kb;
import com.bytedance.sdk.gromore.z.z.a.uy;
import com.bytedance.sdk.openadsdk.ls.dl.g.a;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.uf.z.g.z.g f889a;
    private com.bytedance.sdk.openadsdk.uf.z.g.z.z dl;
    private com.bytedance.sdk.openadsdk.uf.z.g.z.dl e;
    private com.bytedance.sdk.openadsdk.js.z.g.z.z g;
    private View gc = null;
    private com.bytedance.sdk.openadsdk.ls.dl.z.g gz;
    private com.bytedance.sdk.openadsdk.ls.dl.z.dl m;
    private final kb z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(boolean z) {
    }

    public z(kb kbVar) {
        this.z = kbVar;
        uy();
    }

    private void uy() {
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z(new com.bytedance.msdk.api.a.z.z.z() { // from class: com.bytedance.sdk.gromore.z.z.e.z.z.1
                @Override // com.bytedance.msdk.api.a.z.z.z
                public void z(com.bytedance.msdk.api.z zVar) {
                }

                @Override // com.bytedance.msdk.api.a.z.z.z
                public void f_() {
                    if (z.this.g != null) {
                        z.this.g.z(0, "ad closed", true);
                    }
                    if (z.this.dl != null) {
                        z.this.dl.z();
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.z.z
                public void z(View view) {
                    if (z.this.f889a != null) {
                        z.this.f889a.z(view, 0);
                    }
                    if (z.this.dl != null) {
                        z.this.dl.z(view, 0);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.z.z
                public void g(View view) {
                    if (z.this.f889a != null) {
                        z.this.f889a.g(view, 0);
                    }
                    if (z.this.dl != null) {
                        z.this.dl.g(view, 0);
                    }
                }
            });
        }
    }

    private void kb() {
        com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar;
        kb kbVar = this.z;
        if (kbVar == null || (dlVar = this.m) == null) {
            return;
        }
        kbVar.z(dlVar);
    }

    private void i() {
        com.bytedance.sdk.openadsdk.ls.dl.z.g gVar;
        kb kbVar = this.z;
        if (kbVar == null || (gVar = this.gz) == null) {
            return;
        }
        kbVar.z(gVar);
    }

    private void v() {
        com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar;
        kb kbVar = this.z;
        if (kbVar == null || (dlVar = this.e) == null) {
            return;
        }
        kbVar.z(dlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public View z() {
        kb kbVar;
        if (this.gc == null && (kbVar = this.z) != null) {
            this.gc = kbVar.gc();
        }
        kb();
        v();
        i();
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int g() {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.m();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar) {
        this.f889a = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar) {
        this.dl = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.m = dlVar;
        kb();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int dl() {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.i();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void a() {
        com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar = this.f889a;
        if (gVar != null) {
            gVar.z(this.gc, 0.0f, 0.0f);
        }
        com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            zVar.z(this.gc, 0.0f, 0.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void gc() {
        if (this.gc != null) {
            this.gc = null;
        }
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.dl();
        }
        if (this.m != null) {
            this.m = null;
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        this.g = zVar;
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z(activity, zVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Dialog dialog, Integer[] numArr) {
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(String str) {
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public e z(Activity activity) {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.z(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public a m() {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.v();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        this.e = dlVar;
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public Map<String, Object> gz() {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.e();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public gc fo() {
        return new uy(new g(this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        this.gz = gVar;
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z(gVar);
        }
    }
}
