package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.g.z.g.dl;
import com.bytedance.sdk.openadsdk.core.g.z.g.gc;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.js;
import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gc extends dl implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.iq.gc f1224a;
    protected WeakReference<Context> dl;
    protected ls fv;
    protected na gc;
    protected boolean io;
    protected Function<SparseArray<Object>, Object> iq;
    protected HashSet<Integer> kb;
    protected String m;
    protected final String pf;
    private volatile com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl sy;
    protected volatile Runnable tb;
    protected com.bytedance.sdk.openadsdk.core.kb.g.gc wp;
    protected volatile boolean zw;
    protected final AtomicInteger e = new AtomicInteger(1);
    protected final AtomicBoolean gz = new AtomicBoolean(false);
    protected boolean fo = false;
    protected final AtomicBoolean uy = new AtomicBoolean(false);
    protected final l i = new l(Looper.getMainLooper(), this);
    protected boolean v = true;
    protected boolean ls = false;
    protected volatile boolean p = false;
    protected z js = new z();
    protected int q = 0;
    private List<js> hh = new CopyOnWriteArrayList();
    protected final com.bytedance.sdk.openadsdk.core.kb.z.dl uf = new com.bytedance.sdk.openadsdk.core.kb.z.dl() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.1
        @Override // com.ss.android.z.z.dl.a
        public void z() {
            gc.this.e.set(1);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc.this.z("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (gc.this.wp != null) {
                gc.this.wp.z();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onDownloadStart() {
            gc.this.e.set(2);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc.this.z("onIdle", 0L, 0L, (String) null, (String) null);
            } else if (gc.this.wp != null) {
                gc.this.wp.z();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onDownloadActive(long j, long j2, String str) {
            gc.this.e.set(3);
            gc.this.gz.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc gcVar = gc.this;
                gcVar.z("onDownloadActive", j, j2, str, gcVar.f1224a.dl());
                return;
            }
            if (gc.this.wp != null) {
                gc.this.wp.z(j, j2, str, gc.this.f1224a.dl());
            }
            if (gc.this.wp == null || gc.this.wp.dl() || gc.this.gc == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.zw.z.g(gc.this.gc.xn());
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onDownloadPaused(long j, long j2, String str) {
            gc.this.e.set(4);
            gc.this.gz.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc gcVar = gc.this;
                gcVar.z("onDownloadPaused", j, j2, str, gcVar.f1224a.dl());
            } else if (gc.this.wp != null) {
                gc.this.wp.g(j, j2, str, gc.this.f1224a.dl());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onDownloadFailed(long j, long j2, String str) {
            gc.this.e.set(5);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc gcVar = gc.this;
                gcVar.z("onDownloadFailed", j, j2, str, gcVar.f1224a.dl());
            } else if (gc.this.wp != null) {
                gc.this.wp.dl(j, j2, str, gc.this.f1224a.dl());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onInstalled(long j, long j2, String str) {
            gc.this.e.set(7);
            gc.this.gz.set(true);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String str2 = str;
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc gcVar = gc.this;
                gcVar.z("onInstalled", j, j2, str2, gcVar.f1224a.dl());
            } else if (gc.this.wp != null) {
                gc.this.wp.z(str2, gc.this.f1224a.dl());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.z.dl
        public void onDownloadFinished(long j, long j2, String str) {
            gc.this.e.set(6);
            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                gc gcVar = gc.this;
                gcVar.z("onDownloadFinished", j, j2, str, gcVar.f1224a.dl());
            } else if (gc.this.wp != null) {
                gc.this.wp.z(j, str, gc.this.f1224a.dl());
            }
        }
    };

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public abstract boolean dl();

    public abstract void gz(boolean z2);

    protected abstract void kb();

    public abstract void ls();

    public gc(Context context, na naVar, String str, boolean z2) {
        this.dl = new WeakReference<>(context);
        this.gc = naVar;
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = naVar.c();
        this.f1224a = gcVarC;
        str = TextUtils.isEmpty(str) ? eo.g(naVar) : str;
        this.m = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.pf = naVar.hashCode() + naVar.aq();
        this.iq = com.bytedance.sdk.openadsdk.core.uy.ls().oq();
        if (gcVarC == null) {
            return;
        }
        if (zw.getContext() == null) {
            zw.z(context);
        }
        this.wp = new com.bytedance.sdk.openadsdk.core.kb.g.gc();
        z(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(boolean z2) {
        gz(z2);
        ls();
    }

    protected Context getContext() {
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

    public com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl gz() {
        if (this.sy == null) {
            synchronized (this) {
                if (this.sy == null) {
                    this.sy = new com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl(getContext(), this.gc);
                }
            }
        }
        return this.sy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
        z(zVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar, boolean z2) {
        if (zVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.z(zVar);
        }
        if (z2) {
            g(zVar);
        }
        ls();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(int i, dl.z zVar) {
        if (this.kb == null) {
            this.kb = new HashSet<>();
        }
        this.kb.add(Integer.valueOf(i));
        if (this.iq != null) {
            Object zVar2 = zVar;
            if (!com.bytedance.sdk.openadsdk.ls.dl.a.g(gk.dl)) {
                zVar2 = new com.bytedance.sdk.openadsdk.core.kb.z.z(zVar);
            }
            this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(9).z(Void.class).z(0, new lq().z("hid", Integer.valueOf(i)).z("id", Integer.valueOf(i)).z("onEventLogHandler", zVar2).z("hashCode", Integer.valueOf(e()))).g());
        }
    }

    public class z extends com.bytedance.sdk.component.uy.fo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1225a;
        long dl;
        long g;
        String gc;
        String z;

        z() {
            super("DownloadCallbackRunnable");
        }

        z(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.z = str;
            this.g = j;
            this.dl = j2;
            this.f1225a = str2;
            this.gc = str3;
        }

        public void z(String str) {
            this.z = str;
        }

        public void z(long j) {
            this.g = j;
        }

        public void g(long j) {
            this.dl = j;
        }

        public void g(String str) {
            this.f1225a = str;
        }

        public void dl(String str) {
            this.gc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                gc.this.fo().z(gc.this.pf, this.z, this.g, this.dl, this.f1225a, this.gc);
            } catch (Throwable unused) {
            }
        }
    }

    protected ls fo() {
        if (this.fv == null) {
            this.fv = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.g.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(3));
        }
        return this.fv;
    }

    protected void uy() {
        if (this.dl == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && com.bytedance.sdk.openadsdk.core.uy.ls().z(activity)) {
            g(activity);
        } else {
            p();
        }
    }

    private void g(Activity activity) {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = com.bytedance.sdk.openadsdk.core.uy.ls().a();
        if (zVarA != null && this.tb == null) {
            this.tb = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.3
                @Override // java.lang.Runnable
                public void run() {
                    gc.this.p();
                    gc.this.tb = null;
                }
            };
            zVarA.z(activity, this.tb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.dl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.4
                @Override // java.lang.Runnable
                public void run() {
                    ls lsVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.g.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(3));
                    try {
                        synchronized (gc.this.hh) {
                            if (lsVarZ != null) {
                                if (gc.this.hh.size() > 0) {
                                    Iterator it = gc.this.hh.iterator();
                                    while (it.hasNext()) {
                                        lsVarZ.g(gc.this.pf, (js) it.next());
                                    }
                                    gc.this.hh.clear();
                                }
                            }
                        }
                    } catch (RemoteException e) {
                        wp.z(e);
                    }
                }
            });
        }
    }

    protected void g(final com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.g.dl() || zVar == null) {
            return;
        }
        com.bytedance.sdk.component.uy.e.dl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.z zVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m mVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.g.m(zVar);
                ls lsVarZ = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.g.z(zVarZ.z(3));
                if (lsVarZ != null) {
                    try {
                        lsVarZ.z(gc.this.pf, mVar);
                        synchronized (gc.this.hh) {
                            gc.this.hh.add(mVar);
                        }
                    } catch (RemoteException e) {
                        wp.z(e);
                    }
                }
            }
        });
    }

    protected String z(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    protected void g(JSONObject jSONObject, boolean z2) {
        com.bytedance.sdk.openadsdk.core.iq.gc gcVar = this.f1224a;
        if (gcVar == null || gcVar.g() == null) {
            return;
        }
        dl(jSONObject, z2);
    }

    protected void z(na naVar, String str, String str2, Throwable th) {
        if (dl()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, str, str2, th);
    }

    public boolean m() {
        if (this.gc.vy() != null) {
            String strG = this.gc.vy().g();
            if (!TextUtils.isEmpty(strG)) {
                com.bytedance.sdk.openadsdk.core.iq.ls.z((String) null);
                Uri uri = Uri.parse(strG);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                eo.g(intent);
                if (this.p) {
                    com.bytedance.sdk.openadsdk.core.i.a.g(this.gc, this.m, "lp_open_dpl", z(strG));
                }
                if (eo.z(getContext(), intent)) {
                    try {
                        eo.z(this.p, this.gc, this.m);
                        if (!z(this.m, "open_url_app", this.gc)) {
                            HashMap map = new HashMap();
                            map.put("source", "DMLibManager");
                            com.bytedance.sdk.openadsdk.core.i.a.gz(this.gc, this.m, "open_url_app", map);
                        }
                        com.bytedance.sdk.component.utils.g.startActivity(getContext(), intent, TextUtils.equals("main", UMModuleRegister.INNER));
                        com.bytedance.sdk.openadsdk.core.i.e.z().z(this.gc, this.m, this.p);
                        if (this.p) {
                            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.m, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.m, "lp_deeplink_success_realtime", (Throwable) null);
                        } else {
                            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.m, "deeplink_success_realtime", (Throwable) null);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.gc.fp())) {
                            com.bytedance.sdk.openadsdk.core.eo.z(getContext(), this.gc.fp(), this.gc, this.m);
                        }
                        if (this.p) {
                            com.bytedance.sdk.openadsdk.core.i.a.dl(this.gc, this.m, "lp_openurl_failed");
                            z(this.gc, this.m, "lp_deeplink_fail_realtime", th);
                        } else {
                            z(this.gc, this.m, "deeplink_fail_realtime", th);
                        }
                        return false;
                    }
                }
                if (this.p) {
                    com.bytedance.sdk.openadsdk.core.i.a.dl(this.gc, this.m, "lp_openurl_failed");
                    z(this.gc, this.m, "lp_deeplink_fail_realtime", null);
                } else {
                    z(this.gc, this.m, "deeplink_fail_realtime", null);
                }
            }
            if (this.e.get() != 4 && this.e.get() != 3 && (!this.fo || this.gz.get())) {
                this.fo = true;
                if (!z(this.m, "open_fallback_url", this.gc)) {
                    com.bytedance.sdk.openadsdk.core.i.a.gz(this.gc, this.m, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    protected boolean z(String str, String str2, na naVar) {
        if (this.iq != null) {
            Object objApply = this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).z(0, new lq().z("tagIntercept", str).z("label", str2).z("hashCode", Integer.valueOf(e())).z("meta", naVar.kv().toString())).g());
            if (objApply != null && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean dl(JSONObject jSONObject, boolean z2) {
        if (this.e.get() == 1) {
            if (v.dl(getContext()) == 0) {
                try {
                    hh.z(getContext(), tb.z(getContext(), "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            } else {
                if (eo.g(getContext())) {
                    eo.z(this.p, this.gc, this.m);
                }
                a(jSONObject, z2);
            }
            return true;
        }
        if (eo.g(getContext())) {
            eo.z(this.p, this.gc, this.m);
        }
        z(jSONObject, z2);
        if (this.e.get() == 3 || this.e.get() == 4) {
            this.gz.set(false);
            return false;
        }
        if (this.e.get() != 6) {
            return false;
        }
        this.gz.set(true);
        return false;
    }

    protected void gc(boolean z2) {
        if (z2) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.gc, this.m, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.gc, this.m, "quickapp_fail");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z() {
        if (zw.getContext() == null) {
            zw.z(getContext());
        }
        ls();
    }

    protected void z(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.iq;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(16).z(Void.class).z(0, map).g());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void g() {
        com.bytedance.sdk.openadsdk.core.kb.g.gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.g();
        }
        kb();
        HashSet<Integer> hashSet = this.kb;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.kb);
            this.kb.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.6
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (gc.this.iq != null) {
                            gc.this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Void.class).z(0, new lq().z("hid", Integer.valueOf(iIntValue)).z("hashCode", Integer.valueOf(gc.this.e()))).g());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.dl;
        if (weakReference != null) {
            weakReference.clear();
            this.dl = null;
        }
        this.sy = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(Activity activity) {
        if (activity == null) {
            return;
        }
        this.dl = new WeakReference<>(activity);
        ls();
    }

    public int wp() {
        return this.e.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void a(boolean z2) {
        this.io = z2;
    }

    public void m(boolean z2) {
        this.p = z2;
    }

    public void z(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.uy.ls() != null && !com.bytedance.sdk.openadsdk.core.uy.ls().z()) {
            gc(false);
            if (this.v) {
                Object obj = message.obj;
                g(eo.js(this.gc), obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
                return;
            }
            return;
        }
        gc(true);
    }

    protected void a(JSONObject jSONObject, boolean z2) {
        m(jSONObject, z2);
        this.gz.set(true);
    }

    private void m(JSONObject jSONObject, boolean z2) {
        z(jSONObject, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(int i) {
        this.q = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public Map<String, Object> gc() {
        return new HashMap();
    }

    protected void z(String str, long j, long j2, String str2, String str3) {
        z zVar = this.js;
        if (zVar == null) {
            this.js = new z(str, j, j2, str2, str3);
        } else {
            zVar.z(str);
            this.js.z(j);
            this.js.g(j2);
            this.js.g(str2);
            this.js.dl(str3);
        }
        com.bytedance.sdk.component.uy.e.dl().execute(this.js);
    }

    protected boolean i() {
        if (this.iq == null || com.bytedance.sdk.openadsdk.core.iq.tb.js(this.gc) == 1) {
            return true;
        }
        if (zw.g().s()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(this.uf.getCurrentPercent()));
            } catch (Exception unused) {
            }
            return z(str, true);
        }
        if (com.bytedance.sdk.openadsdk.core.iq.tb.uy(this.gc)) {
            return true;
        }
        return z("应用正在下载...", false);
    }

    private boolean z(final String str, final boolean z2) {
        Object objApply = this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, new lq().z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.f1224a.g()).z("hashCode", Integer.valueOf(e()))).g());
        if (objApply == null || !((Boolean) objApply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.7
            @Override // java.lang.Runnable
            public void run() {
                if (z2) {
                    hh.g(gc.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    hh.z(gc.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(final na naVar, final boolean z2) {
        if (getContext() == null) {
            return;
        }
        this.gc = naVar;
        fv();
        if (com.bytedance.sdk.openadsdk.core.g.z.g.dl.z(this.gc, false) && !com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.gc) && !com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.gc)) {
            new com.bytedance.sdk.openadsdk.core.g.z.g.dl(this.gc, getContext()).z(this.m).z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.8
                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.dl.z
                public void z() {
                    gc.this.e(eo.js(naVar), z2);
                }
            });
        } else {
            e(eo.js(naVar), z2);
        }
    }

    private void fv() {
        if (this.ls) {
            return;
        }
        this.ls = true;
        z(4, new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.9
            @Override // com.bytedance.sdk.openadsdk.core.kb.a.dl.z
            public boolean z(int i, String str, String str2, String str3, Object obj) {
                if (i != 4) {
                    return true;
                }
                if ("market_click_open".equals(str3) || "applink_click".equals(str3)) {
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_ad_tag", str2);
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_dpl_success_materialmeta", str);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final JSONObject jSONObject, final boolean z2) {
        int iZ = com.bytedance.sdk.openadsdk.core.live.g.z().z(this.gc, new com.bytedance.sdk.openadsdk.core.live.z.dl() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.10
            @Override // com.bytedance.sdk.openadsdk.core.live.z.dl
            public void z(int i) {
                gc.this.gz(jSONObject, z2);
            }
        }, this.m);
        if (iZ == 1 || iZ == 2) {
            return;
        }
        gz(jSONObject, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(final JSONObject jSONObject, final boolean z2) {
        com.bytedance.sdk.openadsdk.core.live.g gVarZ = com.bytedance.sdk.openadsdk.core.live.g.z();
        HashMap map = new HashMap(1);
        map.put("event_tag", this.m);
        if ((gVarZ.z(getContext(), this.gc, map) & 255) == 0) {
            com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_ad_tag", this.m);
            com.bytedance.sdk.openadsdk.core.g.z().put("save_dpl_success_materialmeta", this.gc.kv().toString());
            return;
        }
        gz().z(v(), this.gc);
        boolean z3 = com.bytedance.sdk.openadsdk.core.g.z.g.gc.z();
        if (z3) {
            com.bytedance.sdk.openadsdk.core.g.z.g.gc.z(false);
        }
        if (!z3) {
            if (new com.bytedance.sdk.openadsdk.core.g.z.g.gc(this.gc, getContext()).z(this.m).z(eo.g(this.m)).g(this.p).z(new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.gc.2
                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.gc.z
                public void z() {
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_ad_tag", gc.this.m);
                    com.bytedance.sdk.openadsdk.core.g.z().put("save_dpl_success_materialmeta", gc.this.gc.kv().toString());
                }

                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.gc.z
                public void g() {
                    gc.this.gc(jSONObject, z2);
                }
            })) {
                return;
            }
            gc(jSONObject, z2);
            return;
        }
        gc(jSONObject, z2);
    }

    protected void gc(JSONObject jSONObject, boolean z2) {
        if (m()) {
            this.gz.set(true);
            return;
        }
        if (!this.p && this.gc.c() == null && this.gc.fp() != null && !this.gc.hb()) {
            com.bytedance.sdk.openadsdk.core.eo.z(getContext(), this.gc.fp(), this.gc, this.m);
        } else if (e(z2)) {
            this.gz.set(true);
        } else {
            if (this.gc.hb()) {
                return;
            }
            g(jSONObject, z2);
        }
    }

    protected com.bytedance.sdk.openadsdk.core.kb.dl.dl.z v() {
        if (dl()) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.gc();
        }
        if (this.p) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.a();
        }
        return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.g();
    }

    public boolean pf() {
        na naVar = this.gc;
        return (naVar == null || this.f1224a == null || com.bytedance.sdk.openadsdk.core.iq.tb.m(naVar) != 3 || this.f1224a.z() == null) ? false : true;
    }

    protected boolean e(boolean z2) {
        if (this.f1224a == null || !pf()) {
            return false;
        }
        boolean z3 = z(getContext(), this.f1224a.z(), this.gc, this.m, this.p);
        if (z3) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            messageObtain.obj = Boolean.valueOf(z2);
            this.i.sendMessageDelayed(messageObtain, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.g.z().put("save_jump_success_ad_tag", this.m);
            com.bytedance.sdk.openadsdk.core.g.z().put("save_dpl_success_materialmeta", this.gc.kv().toString());
        } else {
            gc(false);
        }
        return z3;
    }

    public boolean z(Context context, String str, na naVar, String str2, boolean z2) {
        if (context == null) {
            return false;
        }
        try {
            eo.z(z2, naVar, str2);
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
