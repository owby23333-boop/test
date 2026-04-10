package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class fo extends gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1221a;
    private WeakReference<Context> dl;
    private volatile com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl fo;
    private final na gc;
    private String m;
    private volatile boolean uy;
    private int gz = 0;
    private boolean kb = false;
    private Function<SparseArray<Object>, Object> e = com.bytedance.sdk.openadsdk.core.uy.ls().oq();

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(int i, dl.z zVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(na naVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar, boolean z) {
    }

    public fo(Context context, String str, na naVar, String str2, boolean z) {
        this.dl = new WeakReference<>(context);
        this.gc = naVar;
        this.m = str2;
        this.f1221a = str;
        z(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.dl;
            if (weakReference == null) {
                return zw.getContext();
            }
            Context context = weakReference.get();
            return context == null ? zw.getContext() : context;
        } catch (Throwable unused) {
            return zw.getContext();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gz
    public com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl m() {
        if (this.fo == null) {
            synchronized (this) {
                if (this.fo == null) {
                    this.fo = new com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl(getContext(), this.gc);
                }
            }
        }
        return this.fo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.kb.dl.dl.z gz() {
        if (dl()) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.gc();
        }
        return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(boolean z) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.f1221a, this.m, this.gc, (JSONObject) null, e());
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.gc, e(), z);
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.m, e());
        uy();
    }

    private synchronized void fo() {
        if (this.e == null) {
            return;
        }
        if (gk.dl >= 6400 && !gk.e()) {
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z((com.bytedance.sdk.openadsdk.core.kb.z.a) null, e());
        }
        if (kb()) {
            this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).z(0, new lq().z("hashCode", Integer.valueOf(e()))).g());
        } else {
            this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(4).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(e()))).g());
        }
    }

    private synchronized void uy() {
        if (this.e == null) {
            return;
        }
        if (!kb()) {
            this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(e()))).g());
            return;
        }
        lq lqVar = new lq();
        lqVar.z("hashCode", Integer.valueOf(e()));
        Object objApply = this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(19).z(Boolean.class).z(0, lqVar).g());
        if (objApply != null && ((Boolean) objApply).booleanValue()) {
            this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(14).z(Boolean.class).z(0, new lq().z("hashCode", Integer.valueOf(e()))).g());
        }
    }

    private boolean kb() {
        na naVar = this.gc;
        if (naVar != null) {
            return tb.z(naVar);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z() {
        uy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void g() {
        fo();
        WeakReference<Context> weakReference = this.dl;
        if (weakReference != null) {
            weakReference.clear();
            this.dl = null;
        }
        this.fo = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public boolean dl() {
        Function<SparseArray<Object>, Object> function = this.e;
        return function != null && com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(function, e()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(JSONObject jSONObject, boolean z) {
        m().z(gz());
        if (ls()) {
            if (dl() || !wp()) {
                z((com.bytedance.sdk.openadsdk.core.iq.a) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wp() {
        int i = this.gz;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.iq.a aVarZ = zw.z().z(fo.this.gc, fo.this.f1221a);
                    if (aVarZ == null || !aVarZ.gc()) {
                        uy.z(zw.getContext());
                        return;
                    }
                    String strM = aVarZ.m();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject = new JSONObject(strM);
                    } catch (JSONException unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.iq.m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(jSONObject);
                    com.bytedance.sdk.openadsdk.core.iq.m mVarBw = fo.this.gc.bw();
                    if (mVarBw == null) {
                        fo.this.gc.z(mVarGc);
                    } else {
                        mVarBw.uy(mVarGc.v());
                        mVarBw.g(mVarGc.gc());
                        mVarBw.a(mVarGc.e());
                        mVarBw.g(mVarGc.wp());
                        mVarBw.gc(mVarGc.gz());
                        mVarBw.fo(mVarGc.i());
                        mVarBw.dl(mVarGc.m());
                        mVarBw.m(mVarGc.fo());
                        mVarBw.e(mVarGc.uy());
                        mVarBw.gz(mVarGc.kb());
                        mVarGc = mVarBw;
                    }
                    if (fo.this.i()) {
                        return;
                    }
                    fo.this.z(mVarGc.m(), mVarGc.v(), mVarGc.i());
                    fo.this.z(aVarZ);
                }
            });
            return true;
        }
        if (i()) {
            return true;
        }
        uy.z(zw.getContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, String str3) {
        if (this.e == null) {
            return;
        }
        this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(24).z(Boolean.class).z(0, new lq().z("appIcon", str).z("appName", str2).z("hashCode", Integer.valueOf(e())).z("packageName", str3)).g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.iq.a aVar) {
        tb();
        if (g(aVar)) {
            return;
        }
        fv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return pf() || v();
    }

    private boolean v() {
        na naVar = this.gc;
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar != null ? naVar.bw() : null;
        String strI = mVarBw != null ? mVarBw.i() : "";
        Intent intentG = TextUtils.isEmpty(strI) ? null : eo.g(getContext(), strI);
        if (intentG != null && eo.dl(getContext(), strI)) {
            try {
                getContext().startActivity(intentG);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private boolean pf() {
        na naVar = this.gc;
        if (naVar == null || naVar.vy() == null) {
            return false;
        }
        String strG = this.gc.vy().g();
        if (TextUtils.isEmpty(strG)) {
            return false;
        }
        ls.z((String) null);
        Uri uri = Uri.parse(strG);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!eo.z(getContext(), intent)) {
            return false;
        }
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            getContext().startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean g(com.bytedance.sdk.openadsdk.core.iq.a aVar) {
        com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl dlVarM = m();
        if (!dlVarM.a(false) || p()) {
            return false;
        }
        if (z(getContext(), this.gc, this.m)) {
            return true;
        }
        dlVarM.z(aVar, this.m, this.f1221a, new com.bytedance.sdk.openadsdk.core.kb.dl.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.g
            public void z() {
                fo.this.fv();
                fo.this.dl(true);
            }
        });
        return true;
    }

    private boolean ls() {
        if (this.e == null || tb.js(this.gc) == 1) {
            return true;
        }
        if (zw.g().s()) {
            return z("正在下载，可在通知栏暂停或取消", true);
        }
        if (tb.uy(this.gc)) {
            return true;
        }
        return z("应用正在下载...", false);
    }

    private boolean z(final String str, final boolean z) {
        if (!p()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    hh.g(fo.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    hh.z(fo.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    private boolean p() {
        if (this.e == null) {
            return false;
        }
        Object objApply = this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, new lq().z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.f1221a).z("hashCode", Integer.valueOf(e()))).g());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv() {
        final Map<String, Object> mapJs = js();
        if (!dl()) {
            z(16, mapJs);
        } else {
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(mapJs, new com.bytedance.sdk.openadsdk.core.kb.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.4
                @Override // com.ss.android.z.z.g.p
                public void z(boolean z) {
                }

                @Override // com.ss.android.z.z.g.p
                public void z() {
                    if (mapJs == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(0, fo.this.e());
                    fo.this.m().z(fo.this.gz());
                    mapJs.remove("downloadButtonClickListener");
                    if (fo.this.wp()) {
                        return;
                    }
                    fo.this.z((com.bytedance.sdk.openadsdk.core.iq.a) null);
                }
            });
            z(mapJs);
        }
    }

    private void z(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.kb.fo.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.5
            @Override // java.lang.Runnable
            public void run() {
                fo.this.z(17, (Map<String, Object>) map);
            }
        }, this.gc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final int i, final Map<String, Object> map) {
        try {
            if (this.e == null) {
                return;
            }
            if (kb()) {
                this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(13).z(Void.class).z(0, map).g());
                this.uy = false;
            } else {
                map.put("itemClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(new com.bytedance.sdk.openadsdk.core.kb.z.gc() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.fo.6
                    @Override // com.bytedance.sdk.openadsdk.core.kb.z.gc
                    public void onItemClick() {
                        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.g(1, fo.this.e());
                        map.remove("itemClickListener");
                        fo.this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Void.class).z(0, map).g());
                    }
                }));
                this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Void.class).z(0, map).g());
                this.uy = false;
            }
        } catch (Throwable unused) {
        }
    }

    private Map<String, Object> js() {
        long jLongValue = Double.valueOf(this.gc.mj()).longValue();
        if (kb()) {
            return new lq().z("userAgent", null).z("isDisableDialog", Boolean.TRUE).z("downloadStatusChangeListener", null).z("action_type_button", 2).z("id", Long.valueOf(jLongValue)).z("hashCode", Integer.valueOf(e()));
        }
        return new lq().z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.f1221a).z("hashCode", Integer.valueOf(e())).z("id", Long.valueOf(jLongValue)).z("action_type_button", 2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void dl(boolean z) {
        if (gk.dl >= 5400 && z) {
            this.uy = z;
            if (dl()) {
                com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(true, com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.gc, this.kb), e());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void a(boolean z) {
        this.kb = z;
    }

    private void tb() {
        if (gk.dl >= 5400 && dl() && !this.uy) {
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(false, (com.bytedance.sdk.openadsdk.core.kb.z.a) null, e());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void a() {
        Function<SparseArray<Object>, Object> function = this.e;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8).z(Void.class).z(0, new lq().z("force", Boolean.TRUE).z("hashCode", Integer.valueOf(e()))).g());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(int i) {
        this.gz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public Map<String, Object> gc() {
        return new HashMap();
    }
}
