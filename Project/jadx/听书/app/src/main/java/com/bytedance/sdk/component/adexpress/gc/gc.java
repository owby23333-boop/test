package com.bytedance.sdk.component.adexpress.gc;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.z.uf;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static int e = 10;
    private static volatile gc fo = null;
    private static final byte[] gc = new byte[0];
    private static int m = 10;
    private final AtomicBoolean gz = new AtomicBoolean(false);
    private final List<SSWebView> z = new ArrayList();
    private final List<SSWebView> g = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.i.dl, dl> dl = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<com.bytedance.sdk.component.i.dl, a> f583a = new WeakHashMap<>();

    private gc() {
        com.bytedance.sdk.component.adexpress.z.z.dl dlVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl();
        if (dlVarDl != null) {
            m = dlVarDl.gz();
            e = dlVarDl.fo();
        }
    }

    public static gc z() {
        if (fo == null) {
            synchronized (gc.class) {
                if (fo == null) {
                    fo = new gc();
                }
            }
        }
        return fo;
    }

    public SSWebView z(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (a() <= 0 || (sSWebViewRemove = this.g.remove(0)) == null) {
            return null;
        }
        this.g.size();
        return sSWebViewRemove;
    }

    public void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.g.size() >= e) {
            sSWebView.destroy();
        } else {
            if (this.g.contains(sSWebView)) {
                return;
            }
            this.g.add(sSWebView);
            this.g.size();
        }
    }

    public void g(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        m(sSWebView);
        z(sSWebView);
    }

    public SSWebView g(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (dl() <= 0 || (sSWebViewRemove = this.z.remove(0)) == null) {
            return null;
        }
        dl();
        return sSWebViewRemove;
    }

    public void dl(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        m(sSWebView);
        a(sSWebView);
    }

    public void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.z.size() >= m) {
            sSWebView.destroy();
        } else {
            if (this.z.contains(sSWebView)) {
                return;
            }
            this.z.add(sSWebView);
            dl();
        }
    }

    public boolean gc(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void g() {
        for (SSWebView sSWebView : this.z) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.z.clear();
        for (SSWebView sSWebView2 : this.g) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.g.clear();
        synchronized (this.f583a) {
            this.f583a.clear();
        }
    }

    public int dl() {
        return this.z.size();
    }

    public int a() {
        return this.g.size();
    }

    public int gc() {
        return this.z.size() + a();
    }

    public void z(SSWebView sSWebView, g gVar) {
        if (sSWebView == null || gVar == null) {
            return;
        }
        dl dlVar = this.dl.get(sSWebView);
        if (dlVar != null) {
            dlVar.z(gVar);
        } else {
            dlVar = new dl(gVar);
            this.dl.put(sSWebView, dlVar);
        }
        sSWebView.addJavascriptInterface(dlVar, "SDK_INJECT_GLOBAL");
    }

    public void m(SSWebView sSWebView) {
        dl dlVar;
        if (sSWebView == null || (dlVar = this.dl.get(sSWebView)) == null) {
            return;
        }
        dlVar.z(null);
    }

    private static void z(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            gz.g().post(runnable);
        }
    }

    public void z(final com.bytedance.sdk.component.i.dl dlVar, uf ufVar, final String str) {
        final a aVar;
        if (dlVar == null || ufVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f583a) {
            aVar = this.f583a.get(dlVar);
            if (aVar != null) {
                aVar.z(ufVar);
            } else {
                aVar = new a(ufVar);
                this.f583a.put(dlVar, aVar);
            }
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.gc.gc.1
            @Override // java.lang.Runnable
            public void run() {
                dlVar.addJavascriptInterface(aVar, str);
            }
        });
    }

    public void z(final com.bytedance.sdk.component.i.dl dlVar, final String str) {
        if (dlVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f583a) {
            a aVar = this.f583a.get(dlVar);
            if (aVar != null) {
                aVar.z(null);
            }
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.gc.gc.2
            @Override // java.lang.Runnable
            public void run() {
                dlVar.removeJavascriptInterface(str);
            }
        });
    }
}
