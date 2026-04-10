package com.bytedance.sdk.gromore.z.z.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.a.z.e.gz;
import com.bytedance.msdk.core.gz.kb;
import com.bytedance.msdk.dl.a.fo;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.p;
import com.bytedance.msdk.gz.v;
import com.bytedance.sdk.gromore.z.z.a.i;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.uy;
import com.bytedance.sdk.openadsdk.ls.dl.g.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g extends uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.iq.z.g.z.z f875a;
    private com.bytedance.msdk.api.z.g dl;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z e;
    private com.bytedance.sdk.openadsdk.ls.dl.z.dl fo;
    private com.bytedance.msdk.g.dl g;
    private com.bytedance.sdk.openadsdk.iq.z.g.z.g gc;
    private com.bytedance.sdk.openadsdk.io.z.g.z.dl gz;
    private View m;
    private com.bytedance.sdk.openadsdk.ls.dl.z.g uy;
    private fo z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    public g(fo foVar, com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar) {
        this.z = foVar;
        this.g = dlVar;
        if (dlVar != null && dlVar.j() == 3) {
            this.g.e(true);
        }
        this.dl = gVar;
        sy();
    }

    private void sy() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(new gz() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.1
                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void z() {
                    if (g.this.f875a != null) {
                        g.this.f875a.z(g.this);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void g() {
                    if (g.this.f875a != null) {
                        g.this.f875a.g(g.this);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void dl() {
                    if (g.this.f875a != null) {
                        g.this.f875a.dl(g.this);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void a() {
                    if (g.this.f875a != null) {
                        g.this.f875a.a(g.this);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void gc() {
                    if (g.this.f875a != null) {
                        g.this.f875a.gc(g.this);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void z(com.bytedance.msdk.api.z zVar) {
                    String strG;
                    long jCurrentTimeMillis;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (js.z(g.this.g)) {
                        strG = js.g();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strG = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.bytedance.msdk.gc.m.z(g.this.g, g.this.dl, (com.bytedance.msdk.api.z) null, 2, 0, strG, jCurrentTimeMillis);
                    if (zVar == null || g.this.f875a == null) {
                        return;
                    }
                    g.this.f875a.z(zVar.z, -1);
                }

                @Override // com.bytedance.msdk.api.a.z.e.gz
                public void z(long j, long j2) {
                    if (g.this.f875a != null) {
                        g.this.f875a.z(j, j2);
                    }
                }
            });
            this.g.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.3
                @Override // com.bytedance.msdk.api.a.z.g
                public void g() {
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z() {
                    if (g.this.fo != null) {
                        g.this.fo.z();
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, int i, int i2, String str, String str2) {
                    if (g.this.fo != null) {
                        g.this.fo.z(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, String str, String str2) {
                    if (g.this.fo != null) {
                        g.this.fo.g(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void g(long j, long j2, String str, String str2) {
                    if (g.this.fo != null) {
                        g.this.fo.dl(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, String str, String str2) {
                    if (g.this.fo != null) {
                        g.this.fo.z(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(String str, String str2) {
                    if (g.this.fo != null) {
                        g.this.fo.z(str, str2);
                    }
                }
            });
            this.g.z(new com.bytedance.msdk.api.a.z.e.fo() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.4
                @Override // com.bytedance.msdk.api.a.z.e.fo
                public void z(int i) {
                    if (g.this.gc != null) {
                        g.this.gc.z(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public void z(com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar) {
        this.f875a = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public void z(com.bytedance.sdk.openadsdk.iq.z.g.z.g gVar) {
        this.gc = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public double z() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.no();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public com.bytedance.sdk.openadsdk.iq.z.g.g.z g() {
        return new com.bytedance.sdk.gromore.z.z.a.dl(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public int dl() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            if (dlVar.tc()) {
                View view = this.m;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.bytedance.msdk.g.dl dlVar2 = this.g;
            if (dlVar2 != null) {
                return dlVar2.jz();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public int a() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            if (dlVar.tc()) {
                View view = this.m;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.bytedance.msdk.g.dl dlVar2 = this.g;
            if (dlVar2 != null) {
                return dlVar2.oz();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public wp gc() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public Bitmap m() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.mj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String e() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.lt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String gz() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.kp();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String fo() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        return dlVar != null ? dlVar.zd() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int uy() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return (int) dlVar.fp();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int kb() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.vy();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int wp() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.te();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public String i() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.vt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public wp v() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        return new i(dlVar != null ? dlVar.bw() : null);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public List<wp> pf() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.g.dl dlVar = this.g;
        List<String> listXf = dlVar != null ? dlVar.xf() : null;
        com.bytedance.msdk.g.dl dlVar2 = this.g;
        String strGy = dlVar2 != null ? dlVar2.gy() : null;
        if (listXf != null) {
            if (listXf.size() != 0) {
                Iterator<String> it = listXf.iterator();
                while (it.hasNext()) {
                    arrayList.add(new i(it.next()));
                }
            } else if (!TextUtils.isEmpty(strGy)) {
                com.bytedance.msdk.g.dl dlVar3 = this.g;
                int iDh = dlVar3 != null ? dlVar3.dh() : 0;
                com.bytedance.msdk.g.dl dlVar4 = this.g;
                arrayList.add(new i(strGy, iDh, dlVar4 != null ? dlVar4.zb() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int ls() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.me();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public int p() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.nh();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.ls.dl.g.a fv() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.he();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.ls.dl.g.dl js() {
        return new com.bytedance.sdk.gromore.z.z.a.g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.ls.dl.g.gc tb() {
        return new com.bytedance.sdk.gromore.z.z.a.a(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public View q() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return null;
        }
        if (dlVar.tc()) {
            com.bytedance.msdk.gc.m.z(this.dl);
            if (this.g.pc() != null) {
                this.g.pc().z();
            }
            com.bytedance.msdk.g.dl dlVar2 = this.g;
            com.bytedance.msdk.gc.m.z(dlVar2, this.dl, dlVar2.gk(), 0);
            View viewFo = this.g.fo();
            this.m = viewFo;
            return viewFo;
        }
        return this.g.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public Map<String, Object> iq() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return null;
        }
        Map<String, Object> mapH = dlVar.h();
        if (mapH == null) {
            com.bytedance.msdk.api.z.g gVar = this.dl;
            mapH = com.bytedance.msdk.dl.a.g.dl(gVar != null ? gVar.zw() : "");
        }
        if (this.g.sv() && p.z()) {
            String strZ = p.z(v.z(this.dl, this.g, true));
            if (!TextUtils.isEmpty(strZ)) {
                mapH.put("get_show_ecpm_info", strZ);
            }
        }
        return com.bytedance.sdk.gromore.z.g.g.z(mapH, this.g.ec());
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public e z(Activity activity) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.z(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public e z(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.g(dialog, numArr);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        z(viewGroup, (List<View>) null, arrayList, (List<View>) null, (List<View>) null, (View) null, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        z(viewGroup, (List<View>) null, list, list2, (List<View>) null, (View) null, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        z(viewGroup, (List<View>) null, list, list2, (List<View>) null, view, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        z(viewGroup, list, list2, list3, (List<View>) null, view, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4, final View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        l();
        if (this.g != null) {
            z(zVar);
            z(false, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.5
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (TextUtils.equals(g.this.g.zx(), MediationConstant.ADN_PANGLE)) {
                        g.this.g.z(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    g.this.g.z(null, viewGroup, list2, list3, list4, null, list);
                    return false;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
        l();
        if (this.g != null) {
            z(zVar);
            z(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    g.this.g.z(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.a.z.e.uy.z(aVar), null);
                    return false;
                }
            });
        }
    }

    private void l() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null || !dlVar.tc()) {
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "当前广告为模版广告，不能使用自渲染接口进行渲染，请使用render进行渲染");
    }

    private void h() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null || dlVar.tc()) {
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染");
    }

    private void z(com.bytedance.sdk.openadsdk.io.z.g.z.z zVar) {
        this.e = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.fo = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void g(Activity activity) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.g(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void zw() {
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar;
        h();
        if (this.g != null) {
            gk();
            this.g.kb();
            z(this.g);
            if (this.g.j() != 3 || (dlVar = this.gz) == null) {
                return;
            }
            dlVar.z(this.m, -1.0f, -2.0f, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar) {
        this.gz = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null || activity == null) {
            return;
        }
        dlVar.z(activity, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void g(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(String str) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.ti(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void io() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            try {
                dlVar.fv();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc uf() {
        return new com.bytedance.sdk.gromore.z.z.a.uy(new dl(this.z, this.g, this.dl));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        this.uy = gVar;
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(gVar);
        }
    }

    private void z(boolean z, Handler.Callback callback) {
        com.bytedance.msdk.gc.m.z(this.dl);
        if (this.g != null) {
            gk();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.g.pc() != null) {
                this.g.pc().z();
            }
            z(this.g);
            HashMap map = new HashMap();
            map.put("has_view_binder", Boolean.valueOf(z));
            com.bytedance.msdk.g.dl dlVar = this.g;
            com.bytedance.msdk.gc.m.z(dlVar, this.dl, dlVar.gk(), 0, map);
            return;
        }
        com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.dl, 0);
    }

    private void gk() {
        int iJ = this.g.j();
        if (iJ != 4) {
            if (iJ == 5) {
                lq();
                return;
            } else if (iJ == 3) {
                x();
                return;
            }
        }
        mc();
    }

    private void x() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        dlVar.z((com.bytedance.msdk.z.g.m) new com.bytedance.msdk.z.g.z() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.7
            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(com.bytedance.msdk.api.z zVar) {
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void f_() {
                if (g.this.g.js() != null) {
                    g.this.g.js().z(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(View view) {
                g.this.z(view);
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void g(View view) {
                g.this.g(view);
            }
        });
    }

    private void lq() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        if (dlVar.tc()) {
            this.g.z((com.bytedance.msdk.api.a.z.dl.z) new com.bytedance.msdk.api.a.z.dl.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.8
                @Override // com.bytedance.msdk.api.a.z.dl.a
                public void z(View view, String str, int i) {
                    if (g.this.gz instanceof com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) g.this.gz).z(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.dl.a
                public void z(float f, float f2) {
                    if (g.this.gz != null) {
                        g.this.gz.z(g.this.m, f, f2, true);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z(View view) {
                    g.this.z(view);
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z() {
                    g.this.g((View) null);
                }
            });
        } else {
            this.g.z(new com.bytedance.msdk.api.a.z.dl.z() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.9
                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z(View view) {
                    g.this.z(view);
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z() {
                    g.this.g((View) null);
                }
            });
        }
    }

    private void mc() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        if (dlVar.tc()) {
            this.g.z((com.bytedance.msdk.api.a.z.e.g) new com.bytedance.msdk.api.a.z.e.m() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.10
                @Override // com.bytedance.msdk.api.a.z.e.m
                public void z(View view, String str, int i) {
                    if (g.this.gz instanceof com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) g.this.gz).z(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.m
                public void z(float f, float f2) {
                    if (g.this.gz != null) {
                        g.this.gz.z(g.this.m, f, f2, true);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z(View view) {
                    g.this.z(view);
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z() {
                    g.this.g((View) null);
                }
            });
        } else {
            this.g.z((com.bytedance.msdk.api.a.z.e.g) new com.bytedance.msdk.api.a.z.e.dl() { // from class: com.bytedance.sdk.gromore.z.z.e.a.g.2
                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z(View view) {
                    g.this.z(view);
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z() {
                    g.this.g((View) null);
                }
            });
        }
    }

    private void z(com.bytedance.msdk.g.dl dlVar) {
        if (com.bytedance.msdk.core.g.g().x()) {
            com.bytedance.msdk.gc.m.z(dlVar, this.dl, js.z(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar = this.gz;
        if (dlVar instanceof com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) dlVar).z();
        }
        com.bytedance.sdk.openadsdk.io.z.g.z.z zVar = this.e;
        if (zVar != null) {
            zVar.z(view, this);
        }
        un();
    }

    private void un() {
        String strG;
        long jCurrentTimeMillis;
        if (this.g == null || this.dl == null) {
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.g)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.core.g.z.gc(this.dl.zw());
        com.bytedance.msdk.g.dl dlVar = this.g;
        com.bytedance.msdk.gc.m.g(dlVar, this.dl, 0, strG, jCurrentTimeMillis, dlVar.lq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view) {
        com.bytedance.msdk.g.dl dlVar;
        String strG;
        long jCurrentTimeMillis;
        if (this.dl == null || (dlVar = this.g) == null) {
            return;
        }
        dlVar.m(true);
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar2 = this.gz;
        if (dlVar2 instanceof com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc) dlVar2).g();
        }
        com.bytedance.sdk.openadsdk.io.z.g.z.z zVar = this.e;
        if (zVar != null) {
            zVar.z(this);
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "show_listen") + "adSlotId：" + this.g.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(this.g.r()));
        com.bytedance.msdk.core.gz.i.z().e(this.dl.zw());
        com.bytedance.msdk.core.gz.i.z().g(this.dl.zw());
        kb.z().g(this.dl.zw(), this.g.yz());
        com.bytedance.msdk.core.gz.wp.z().g(this.dl.zw(), this.g.yz());
        com.bytedance.msdk.core.dl.dl.z(this.g.lw(), this.dl.zw(), this.g.yz());
        if (this.g.pc() != null) {
            this.g.pc().z(this.g);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.g)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        String str = strG;
        long j = jCurrentTimeMillis;
        boolean zX = this.g.x();
        if (!zX) {
            com.bytedance.msdk.core.g.z.e(this.dl.zw());
            com.bytedance.msdk.core.g.z.dl(this.dl.zw());
            com.bytedance.msdk.core.fo.a.z(1, this.dl.zw(), this.g.hy(), this.g.u());
        }
        com.bytedance.msdk.gc.m.z(this.g, this.dl, 0, str, j, zX);
        com.bytedance.msdk.api.z.g gVar = this.dl;
        com.bytedance.msdk.core.e.dl.z(gVar != null ? gVar.zw() : "", this.g);
    }
}
