package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.kb.fo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl f1063a;
    protected String dl;
    protected Context g;
    protected String gc;
    protected com.ss.android.z.z.dl.a gz;
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z i;
    protected boolean m;
    private tb uy;
    private volatile boolean wp;
    protected na z;
    protected volatile boolean e = false;
    private int kb = 0;
    protected Function<SparseArray<Object>, Object> fo = uy.ls().oq();

    abstract com.bytedance.sdk.openadsdk.core.kb.z.g a(Map<String, Object> map);

    abstract boolean dl(int i);

    abstract void g(boolean z, int i);

    abstract com.bytedance.sdk.openadsdk.core.kb.z.gc z(Map<String, Object> map, lq<String, Object> lqVar);

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        if (z()) {
            return g(map);
        }
        return false;
    }

    protected boolean z() {
        return (this.z == null || this.g == null || this.fo == null || TextUtils.isEmpty(this.gc) || TextUtils.isEmpty(this.dl) || this.f1063a == null) ? false : true;
    }

    public boolean g(Map<String, Object> map) {
        if (this.z.hb() || TextUtils.isEmpty(this.gc)) {
            return false;
        }
        if (v.dl(this.g) == 0) {
            try {
                Context context = this.g;
                hh.z(context, com.bytedance.sdk.component.utils.tb.z(context, "tt_no_network"), 0);
            } catch (Exception unused) {
            }
            return true;
        }
        gc(map);
        return true;
    }

    private void gc(Map<String, Object> map) {
        int iDl = dl(map);
        z(this.wp, iDl);
        if (this.g == null || TextUtils.isEmpty(this.gc) || !m(map)) {
            return;
        }
        this.f1063a.z(g(iDl), this.z);
        lq<String, Object> lqVarZ = new lq().z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.gc);
        lqVarZ.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        lqVarZ.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        com.bytedance.sdk.openadsdk.core.kb.z.g gVarA = a(lqVarZ);
        if (gVarA == null || z((com.bytedance.sdk.openadsdk.core.iq.a) null, gVarA, lqVarZ)) {
            return;
        }
        z(true, iDl);
        z(lqVarZ, gVarA);
    }

    private boolean m(Map<String, Object> map) {
        if (this.fo == null) {
            return true;
        }
        tb tbVar = this.uy;
        if (tbVar != null && tbVar.gc() == 1) {
            return true;
        }
        if (zw.g().s()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                com.ss.android.z.z.dl.a aVar = this.gz;
                if (aVar instanceof com.bytedance.sdk.openadsdk.core.kb.z.dl) {
                    str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(((com.bytedance.sdk.openadsdk.core.kb.z.dl) aVar).getCurrentPercent()));
                }
            } catch (Exception unused) {
            }
            return z(map, str, true);
        }
        tb tbVar2 = this.uy;
        if (tbVar2 == null || !tbVar2.dl()) {
            return z(map, "应用正在下载...", false);
        }
        return true;
    }

    private boolean z(Map<String, Object> map, final String str, final boolean z) {
        Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, new lq().z("hashCode", Integer.valueOf(dl(map))).z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.gc)).g());
        if (objApply == null || !((Boolean) objApply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    hh.g(z.this.g, str, 0, 17, 0, 0);
                } else {
                    hh.z(z.this.g, str, 0);
                }
            }
        });
        return false;
    }

    boolean z(com.bytedance.sdk.openadsdk.core.iq.a aVar, final com.bytedance.sdk.openadsdk.core.kb.z.g gVar, final Map<String, Object> map) {
        boolean z = com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(map);
        final int iDl = dl(map);
        if (!this.f1063a.a(z)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.i;
        if (zVar != null && zVar.z(new HashMap())) {
            return true;
        }
        this.f1063a.z(aVar, this.dl, this.gc, new com.bytedance.sdk.openadsdk.core.kb.dl.z.g() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.g
            public void z() {
                if (z.this.dl(iDl)) {
                    z.this.z(true, iDl);
                    z.this.z((Map<String, Object>) map, gVar);
                } else {
                    z.this.z(gVar, map);
                }
            }
        });
        return true;
    }

    public void z(boolean z, int i) {
        if (gk.dl >= 5400 && dl(i)) {
            g(z, i);
        }
    }

    public void z(boolean z) {
        this.e = z;
    }

    public void z(com.ss.android.z.z.dl.a aVar) {
        this.gz = aVar;
    }

    public void z(tb tbVar) {
        this.uy = tbVar;
    }

    public void z(int i) {
        this.kb = i;
    }

    public void z(com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar) {
        this.i = zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.kb.z.g gVar) {
        fo.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.3
            @Override // java.lang.Runnable
            public void run() {
                z.this.z(gVar, map);
            }
        }, this.z);
        this.wp = false;
    }

    void z(com.bytedance.sdk.openadsdk.core.kb.z.g gVar, Map<String, Object> map) {
        try {
            if (gVar == null) {
                e(map);
                this.wp = false;
            } else {
                g(gVar, map);
                this.wp = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void g(com.bytedance.sdk.openadsdk.core.kb.z.g gVar, Map<String, Object> map) {
        if (this.fo == null) {
            return;
        }
        lq<String, Object> lqVarZ = new lq().z("itemClickListener", null).z("downloadButtonClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(gVar)).z("hashCode", Integer.valueOf(dl(map))).z(map);
        lqVarZ.put("itemClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(z(map, lqVarZ)));
        this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(17).z(Void.class).z(0, lqVarZ).g());
    }

    private void e(Map<String, Object> map) {
        if (this.fo != null) {
            int iDl = dl(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(iDl));
            }
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(16).z(Void.class).z(0, map).g());
        }
    }

    protected com.bytedance.sdk.openadsdk.core.kb.dl.dl.z g(int i) {
        if (dl(i)) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.gc();
        }
        if (this.e) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.a();
        }
        return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.g();
    }

    void z(final Map<String, Object> map, final boolean z) {
        int i = this.kb;
        if (i == 1) {
            com.bytedance.sdk.openadsdk.core.kb.dl.uy.z(zw.getContext());
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.iq.a aVarZ = zw.z().z(z.this.z, z.this.gc);
                    if (aVarZ != null && aVarZ.gc()) {
                        if (z) {
                            z.this.z(aVarZ, (Map<String, Object>) map);
                            return;
                        } else {
                            z.this.z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, map);
                            return;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.kb.dl.uy.z(zw.getContext());
                }
            });
        } else if (z) {
            z((com.bytedance.sdk.openadsdk.core.iq.a) null, map);
        } else {
            z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.iq.a aVar, Map<String, Object> map) {
        z(g(aVar, map), map);
    }

    public void g(boolean z) {
        this.m = z;
    }

    public static int dl(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private com.bytedance.sdk.openadsdk.core.kb.z.g g(final com.bytedance.sdk.openadsdk.core.iq.a aVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.kb.z.g() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.5
            @Override // com.ss.android.z.z.g.p
            public void z() {
            }

            @Override // com.ss.android.z.z.g.p
            public void z(boolean z) {
                if (z && z.this.z(aVar, (com.bytedance.sdk.openadsdk.core.kb.z.g) null, map)) {
                    return;
                }
                z.this.z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, map);
            }
        };
    }
}
