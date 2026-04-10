package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements com.bytedance.adsdk.ugeno.dl.iq, com.bytedance.sdk.component.adexpress.g.fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1277a;
    private na dl;
    private com.bytedance.sdk.openadsdk.v.gz e;
    private String g;
    private long gc;
    private long m;
    private com.bytedance.sdk.openadsdk.m.z z;

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void a() {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void gc() {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(boolean z) {
    }

    public fo(com.bytedance.sdk.openadsdk.m.z zVar, String str, na naVar, String str2) {
        this.z = zVar;
        this.g = str;
        this.f1277a = str2;
        this.dl = naVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void m() {
        this.z.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void g(boolean z) {
        this.z.z(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void e() {
        com.bytedance.sdk.openadsdk.v.gz gzVar = this.e;
        if (gzVar == null) {
            return;
        }
        gzVar.m(io.z(this.dl));
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void gz() {
        this.z.g();
        com.bytedance.sdk.openadsdk.v.gz gzVar = this.e;
        if (gzVar == null) {
            return;
        }
        gzVar.e(io.z(this.dl));
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void z(int i, String str) {
        this.z.z(i, str);
        gz.z(i, this.g, this.f1277a, this.dl);
        com.bytedance.sdk.openadsdk.v.gz gzVar = this.e;
        if (gzVar == null) {
            return;
        }
        gzVar.z(true, io.z(this.dl), 105);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void z(int i) {
        this.gc = System.currentTimeMillis();
        if (i == 3) {
            this.z.z("dynamic_render2_start");
        } else {
            this.z.z("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void g(int i) {
        if (i == 3) {
            this.z.g("dynamic_sub_analysis2_start");
        } else {
            this.z.g("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void dl(int i) {
        if (i == 3) {
            this.z.g("dynamic_sub_analysis2_end");
        } else {
            this.z.g("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void a(int i) {
        if (i == 3) {
            this.z.g("dynamic_sub_render2_start");
        } else {
            this.z.g("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void gc(int i) {
        if (i == 3) {
            this.z.g("dynamic_sub_render2_end");
        } else {
            this.z.g("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void m(int i) {
        final String str;
        this.m = System.currentTimeMillis();
        if (i == 3) {
            this.z.dl("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.z.dl("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.z.z(true);
        com.bytedance.sdk.component.uy.e.dl(new com.bytedance.sdk.component.uy.fo("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.fo.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.i.a.e(fo.this.dl, fo.this.g, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void z(int i, int i2, String str, boolean z) {
        this.z.z(true);
        if (i == 3) {
            this.z.g(i2, "dynamic_render2_error");
        } else {
            this.z.g(i2, "dynamic_render_error");
        }
        gz.z(i2, this.g, this.f1277a, this.dl);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void fo() {
        this.z.dl();
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void uy() {
        this.z.z(true);
        this.z.gc();
        com.bytedance.sdk.component.uy.e.dl(new com.bytedance.sdk.component.uy.fo("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.fo.2
            @Override // java.lang.Runnable
            public void run() {
                gz.z(fo.this.g, fo.this.f1277a, fo.this.dl);
                com.bytedance.sdk.openadsdk.core.i.a.e(fo.this.dl, fo.this.g, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void kb() {
        this.z.z(true);
        this.z.i();
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void wp() {
        this.z.v();
    }

    @Override // com.bytedance.sdk.component.adexpress.g.fo
    public void i() {
        this.z.g();
    }

    public void v() {
        this.z.pf();
        this.z.ls();
    }

    public void z(com.bytedance.sdk.openadsdk.v.gz gzVar) {
        this.e = gzVar;
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z() {
        this.z.a("ugen_render_start");
        this.z.a("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void g() {
        this.z.a("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void dl() {
        this.z.a("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(com.bytedance.adsdk.ugeno.dl.q qVar) {
        if (qVar.z() == 0) {
            this.z.a("ugen_sub_render_end");
            this.z.gc("ugen_render_success");
        } else {
            this.z.dl(qVar.z(), "ugen_render_error");
        }
        this.z.z(true);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(JSONObject jSONObject) {
        this.z.z(jSONObject);
    }
}
