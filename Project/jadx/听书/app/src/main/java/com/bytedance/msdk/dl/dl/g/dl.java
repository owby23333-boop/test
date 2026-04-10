package com.bytedance.msdk.dl.dl.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.core.gz.v;
import com.bytedance.msdk.core.uy.fo;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.dl.g.z;
import com.bytedance.msdk.gz.gk;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.gz.js;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z, com.bytedance.msdk.dl.z.g {
    private com.bytedance.msdk.api.z.g dl;
    private long e;
    private com.bytedance.msdk.dl.m.z.g g;
    private long m;
    private com.bytedance.msdk.dl.m.g.g z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.dl.z.z f433a = null;
    private volatile long gc = -1;

    private List<com.bytedance.msdk.g.dl> g(List<com.bytedance.msdk.g.dl> list) {
        String strG;
        long jCurrentTimeMillis;
        ArrayList arrayList = new ArrayList();
        if (!h.z(list)) {
            arrayList.addAll(list);
        }
        if (this.z != null && !h.g(list) && (this.z.z() || this.z.io())) {
            for (com.bytedance.msdk.g.dl dlVar : list) {
                gk.z(dlVar, this.z.gz(), this.dl, true);
                double dVm = this.dl.vm();
                if (dVm > 0.0d && dVm > dlVar.u()) {
                    arrayList.remove(dlVar);
                    String strValueOf = String.valueOf(dlVar.u());
                    String strGb = dlVar.gb();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (js.z(this.z.gz())) {
                        strG = js.g();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strG = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.bytedance.msdk.gc.m.z(new com.bytedance.msdk.api.z(50100, com.bytedance.msdk.api.z.z(50100)), this.dl, this.z.gz(), this.z.dl(), this.z.e(), this.z.m(), z(this.z.i()), this.m, strValueOf, strGb, strG, jCurrentTimeMillis);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(List<com.bytedance.msdk.g.dl> list) {
        long jCurrentTimeMillis;
        String strG;
        if (list == null) {
            return;
        }
        if (this.gc == -1) {
            this.gc = SystemClock.elapsedRealtime();
        }
        this.m = System.currentTimeMillis() - this.e;
        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.msdk.g.dl next = it.next();
            com.bytedance.msdk.api.z.g gVar = this.dl;
            com.bytedance.msdk.dl.m.g.g gVar2 = this.z;
            com.bytedance.msdk.dl.m.z.g gVar3 = this.g;
            fo foVarUn = gVar3 != null ? gVar3.un() : null;
            com.bytedance.msdk.dl.m.g.g gVar4 = this.z;
            com.bytedance.msdk.dl.gz.dl.z(next, gVar, gVar2, foVarUn, gVar4 != null ? z(gVar4.i()) : "");
        }
        List<com.bytedance.msdk.g.dl> listG = g(list);
        if (listG.size() != 0) {
            if (this.z != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(this.z.gz())) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    jCurrentTimeMillis = -1;
                    strG = null;
                }
                int i = (list == null || list.size() <= 0) ? 820001 : 20000;
                if (this.z.z() || this.z.io()) {
                    for (com.bytedance.msdk.g.dl dlVar : list) {
                        if (dlVar != null) {
                            z(i, dlVar, 1, strG, jCurrentTimeMillis);
                        }
                    }
                } else {
                    z(i, listG.get(0), listG.size(), strG, jCurrentTimeMillis);
                }
                if (this.z.zw() && !h.g(list)) {
                    com.bytedance.msdk.gc.m.z(list.get(0), this.dl, this.z.gz(), this.m);
                }
            }
            dl(listG);
            if (this.z.gz() != null && this.z.gz().i() == 10 && this.z.gz().m() == 1) {
                z(listG, (com.bytedance.msdk.api.z) null);
                return;
            }
            return;
        }
        z(new com.bytedance.msdk.api.z(50100, com.bytedance.msdk.api.z.z(50100)), false);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(com.bytedance.msdk.api.z zVar) {
        z(zVar, true);
    }

    private void z(com.bytedance.msdk.api.z zVar, boolean z) {
        long jCurrentTimeMillis;
        String strG;
        this.m = System.currentTimeMillis() - this.e;
        com.bytedance.msdk.dl.m.g.g gVar = this.z;
        if (gVar != null && gVar.gz() != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (js.z(this.z.gz())) {
                strG = js.g();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                jCurrentTimeMillis = -1;
                strG = null;
            }
            if (!this.z.zw() && z) {
                com.bytedance.msdk.gc.m.z(zVar, this.dl, this.z.gz(), this.z.dl(), this.z.e(), this.z.m(), z(this.z.i()), this.m, (String) null, (String) null, strG, jCurrentTimeMillis);
            } else {
                com.bytedance.msdk.gc.m.z(zVar, this.dl, this.z.gz(), this.z.dl(), this.z.e(), this.z.m(), z(this.z.i()), this.m);
            }
            uy uyVarGz = this.z.gz();
            if (zVar != null) {
                if (this.dl != null) {
                    if (com.bytedance.msdk.g.g.g) {
                        StringBuilder sb = new StringBuilder();
                        com.bytedance.msdk.api.z.g gVar2 = this.dl;
                        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", sb.append(com.bytedance.msdk.z.gc.gc.z(gVar2 != null ? gVar2.zw() : "", "fill_fail")).append("AdNetWorkName[").append(uyVarGz.pf()).append("] AdUnitId[").append(uyVarGz.fv()).append("] AdType[").append(com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz)).append("] 请求失败 (loadSort=").append(uyVarGz.io()).append(",showSort=").append(uyVarGz.uf()).append("),error=").append(zVar.dl).append(",msg=").append(zVar.f366a).toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.bytedance.msdk.api.z.g gVar3 = this.dl;
                        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", sb2.append(com.bytedance.msdk.z.gc.gc.z(gVar3 != null ? gVar3.zw() : "", "fill_fail")).append("AdNetWorkName[").append(uyVarGz.pf()).append("] AdType[").append(com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz)).append("] 请求失败 error=").append(zVar.dl).append(",msg=").append(zVar.f366a).toString());
                    }
                }
                String string = new StringBuilder().append(zVar.dl).toString();
                String strZ = com.bytedance.msdk.z.z.z(this.z.gz().pf(), zVar.f366a);
                v vVarZ = v.z();
                com.bytedance.msdk.api.z.g gVar4 = this.dl;
                if (vVarZ.z(gVar4 == null ? null : gVar4.zw(), this.z.gz().p())) {
                    v vVarZ2 = v.z();
                    com.bytedance.msdk.api.z.g gVar5 = this.dl;
                    vVarZ2.z(gVar5 != null ? gVar5.zw() : null, this.z.gz().pf(), this.z.gz().fv(), com.bytedance.msdk.z.z.z(this.z.gz().pf(), string, strZ));
                } else {
                    com.bytedance.msdk.core.gz.dl.z().z(this.z.gz().pf(), this.z.gz().fv(), com.bytedance.msdk.z.z.z(this.z.gz().pf(), string, strZ));
                }
            }
        }
        g(zVar);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(final List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
        if (list != null) {
            for (com.bytedance.msdk.g.dl dlVar : list) {
                if (dlVar != null) {
                    dlVar.fo(true);
                    com.bytedance.msdk.api.z.g gVar = this.dl;
                    com.bytedance.msdk.dl.m.g.g gVar2 = this.z;
                    com.bytedance.msdk.dl.m.z.g gVar3 = this.g;
                    fo foVarUn = gVar3 == null ? null : gVar3.un();
                    com.bytedance.msdk.dl.m.g.g gVar4 = this.z;
                    com.bytedance.msdk.dl.gz.dl.z(dlVar, gVar, gVar2, foVarUn, gVar4 != null ? z(gVar4.i()) : "");
                    z(dlVar);
                }
            }
        }
        if (zVar != null && zVar.z == 30010 && com.bytedance.msdk.z.z.z()) {
            com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (dl.this.z != null && dl.this.z.zw()) {
                        com.bytedance.msdk.gc.m.z(!h.g(list) ? (com.bytedance.msdk.g.dl) list.get(0) : null, dl.this.dl, dl.this.z.gz());
                    }
                    dl.this.z();
                }
            }, 1000L);
            return;
        }
        com.bytedance.msdk.dl.m.g.g gVar5 = this.z;
        if (gVar5 != null && gVar5.zw()) {
            com.bytedance.msdk.gc.m.z(h.g(list) ? null : list.get(0), this.dl, this.z.gz());
        }
        z();
    }

    private void dl(List<com.bytedance.msdk.g.dl> list) {
        com.bytedance.msdk.dl.m.g.g gVar = this.z;
        if (gVar != null) {
            gVar.z(list, gVar.gz());
        }
        z(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.dl.2
            @Override // java.lang.Runnable
            public void run() {
                if (dl.this.z != null) {
                    com.bytedance.msdk.core.dl.dl.dl(dl.this.z.i(), dl.this.z.g(), dl.this.z.wp());
                }
            }
        });
    }

    private void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.dl.m.g.g gVar = this.z;
        if (gVar != null) {
            gVar.z(zVar, gVar.gz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.bytedance.msdk.dl.m.g.g gVar = this.z;
        if (gVar != null) {
            gVar.fo();
        }
    }

    private void z(Runnable runnable) {
        com.bytedance.msdk.z.gc.m.z(runnable);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(com.bytedance.msdk.g.dl dlVar, String str) {
        if (dlVar == null || dlVar.hy() != 5) {
            return;
        }
        com.bytedance.msdk.gc.m.z(dlVar, this.dl, str);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z
    public void z(z.InterfaceC0089z interfaceC0089z) {
        if (interfaceC0089z == null) {
            return;
        }
        this.e = System.currentTimeMillis();
        this.z = interfaceC0089z.z();
        com.bytedance.msdk.dl.m.z.g gVarG = interfaceC0089z.g();
        this.g = gVarG;
        this.dl = gVarG.js();
        if (this.g.getContext() == null) {
            com.bytedance.msdk.api.z zVar = new com.bytedance.msdk.api.z("request adn context is null");
            z(this.z, this.g, zVar, "");
            z(zVar);
        } else {
            if (this.z != null) {
                g();
                return;
            }
            com.bytedance.msdk.api.z zVar2 = new com.bytedance.msdk.api.z("request adn waterfall request is null");
            z(this.z, this.g, zVar2, "");
            z(zVar2);
        }
    }

    private void z(com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.dl.m.z.g gVar2, com.bytedance.msdk.api.z zVar, String str) {
        if (gVar == null || gVar2 == null || gVar.gz() == null) {
            return;
        }
        uy uyVarGz = gVar.gz();
        String strZ = TextUtils.isEmpty(str) ? com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()) : str;
        if (!uyVarGz.gk()) {
            com.bytedance.msdk.gc.m.z(uyVarGz, this.dl, strZ, gVar.gc(), gVar.e() == 4 ? 3 : 0, gVar.dl(), gVar.e(), gVar.m(), zVar, gVar.a(), gVar2.un().gc, false);
        } else if (uyVarGz.l() != null) {
            com.bytedance.msdk.gc.m.z(uyVarGz, this.dl, strZ);
        }
    }

    private void z(com.bytedance.msdk.g.dl dlVar) {
        com.bytedance.msdk.dl.m.g.g gVar;
        if (this.g == null || this.dl == null || (gVar = this.z) == null || gVar.gz() == null) {
            return;
        }
        uy uyVarGz = this.z.gz();
        if (!this.z.zw() && dlVar != null) {
            com.bytedance.msdk.gc.m.z(this.dl, dlVar, this.z.gz());
        }
        if (com.bytedance.msdk.g.g.g) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "fill") + "AdNetWorkName[" + uyVarGz.pf() + "] AdUnitId[" + uyVarGz.fv() + "] AdType[" + com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz) + "] 视频缓存成功 (loadSort=" + uyVarGz.io() + ",showSort=" + uyVarGz.uf() + ")");
        } else {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "fill") + "AdNetWorkName[" + uyVarGz.pf() + "] AdType[" + com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz) + "] 视频缓存成功 ");
        }
    }

    private void z(int i, com.bytedance.msdk.g.dl dlVar, int i2, String str, long j) {
        com.bytedance.msdk.dl.m.g.g gVar;
        if (this.g == null || this.dl == null || (gVar = this.z) == null || gVar.gz() == null) {
            return;
        }
        uy uyVarGz = this.z.gz();
        String str2 = i == 20000 ? "load success" : "请求成功，但无广告可用";
        boolean z = this.g.un().m;
        if (!this.z.zw() && dlVar != null) {
            com.bytedance.msdk.gc.m.z(dlVar, i, str2, this.m, this.dl, this.z.dl(), i2, z ? 1 : 0, str, j, this.gc != -1 ? SystemClock.elapsedRealtime() - this.gc : -1L);
        }
        if (com.bytedance.msdk.g.g.g) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "fill") + "AdNetWorkName[" + uyVarGz.pf() + "] AdUnitId[" + uyVarGz.fv() + "] AdType[" + com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz) + "] 请求成功 (loadSort=" + uyVarGz.io() + ",showSort=" + uyVarGz.uf() + ")");
        } else {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "fill") + "AdNetWorkName[" + uyVarGz.pf() + "] AdType[" + com.bytedance.msdk.g.z.z(this.dl.iq(), uyVarGz.m(), uyVarGz) + "] 请求成功");
        }
    }

    private void g() {
        com.bytedance.msdk.dl.m.g.g gVar;
        com.bytedance.msdk.dl.m.g.g gVar2 = this.z;
        gVar2.z(com.bytedance.msdk.dl.gz.dl.z(this.dl, gVar2));
        this.z.g(this.g.wp().un());
        if (!this.z.uy()) {
            if (this.z.kb()) {
                this.f433a = com.bytedance.msdk.dl.dl.g.z.a.z(this.z, this);
            } else if (com.bytedance.msdk.core.e.dl.z(this.z.gz())) {
                this.f433a = new com.bytedance.msdk.dl.dl.g.z.dl(this);
            }
        } else {
            Context context = com.bytedance.msdk.core.g.getContext();
            com.bytedance.msdk.dl.m.g.g gVar3 = this.z;
            com.bytedance.msdk.m.g.z(context, gVar3 != null ? gVar3.i() : "");
            if (com.bytedance.msdk.m.g.z.z(this.z.i()) == null) {
                com.bytedance.msdk.gc.m.z("", this.g.kb(), this.dl, this.z.gz(), new com.bytedance.msdk.api.z(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.e.z.g.z().z(this.z.i());
                if (zVarZ == null) {
                    com.bytedance.msdk.gc.m.z("", (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (zVarZ.a() == null) {
                    com.bytedance.msdk.gc.m.z("", (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.bytedance.msdk.api.a.z.g.dl.z zVarZ2 = zVarZ.a().z(this.z.sy(), this.z.pf());
                    if (zVarZ2 == null) {
                        com.bytedance.msdk.gc.m.z("", (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.bytedance.msdk.dl.gz.dl.z(zVarZ2)) {
                        this.f433a = com.bytedance.msdk.dl.dl.g.z.a.z(zVarZ2.z(), this.z, this);
                    } else {
                        com.bytedance.msdk.gc.m.z("", (com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, (uy) null, new com.bytedance.msdk.api.z(49013, "创建自定义广告对象 check className false className is " + zVarZ2.z()));
                    }
                }
            }
        }
        com.bytedance.msdk.dl.z.z zVar = this.f433a;
        if (zVar != null) {
            String strZ = zVar.z(this.z.i());
            if (!TextUtils.isEmpty(strZ) && (gVar = this.z) != null && !TextUtils.isEmpty(gVar.wp()) && !this.z.uy()) {
                com.bytedance.msdk.core.gc.z.z.z().a(this.z.wp(), strZ);
            }
            z(this.z, this.g, null, strZ);
            com.bytedance.msdk.dl.z.z zVar2 = this.f433a;
            Context context2 = this.g.getContext();
            com.bytedance.msdk.dl.m.g.g gVar4 = this.z;
            com.bytedance.msdk.api.z.g gVar5 = this.dl;
            zVar2.z(context2, gVar4, gVar5, com.bytedance.msdk.dl.gz.dl.z(gVar4, gVar5, this.g.h()));
            if (this.z.uy()) {
                return;
            }
            com.bytedance.msdk.core.gc.z.z.z().z(this.z.g(), this.z.wp(), this.z.gz(), this.z.dl());
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "**********【重要】" + this.z.i() + "创建失败，请检查adapter是否接入 **********");
        com.bytedance.msdk.gc.m.z(this.z.gz(), this.dl, this.z.e(), this.z.m());
        z(this.z, this.g, new com.bytedance.msdk.api.z("create adn loader fail"), "");
        z(new com.bytedance.msdk.api.z("create adn loader fail"));
    }

    private String z(String str) {
        com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(str);
        if (aVarZ != null) {
            return aVarZ.g();
        }
        return null;
    }
}
