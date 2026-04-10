package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.p.a;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.widget.z.dl;
import com.bytedance.sdk.openadsdk.core.widget.z.g;
import com.bytedance.sdk.openadsdk.hh.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PageWebView extends FrameLayout implements a {
    private static final SparseArray<WeakReference<DownloadListener>> z = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private na f1367a;
    private Context dl;
    private SSWebView g;
    private mc gc;
    private v m;

    @Override // com.bytedance.sdk.openadsdk.core.p.a
    public void z(boolean z2, JSONArray jSONArray) {
    }

    public static void z(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        z.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            z.remove(jSONObject.hashCode());
        }
    }

    public PageWebView(Context context) {
        super(context);
        this.dl = context;
        SSWebView sSWebView = new SSWebView(context);
        this.g = sSWebView;
        sSWebView.setMaterialMeta(un.z(this.f1367a));
        addView(this.g);
    }

    public void setUGenContext(v vVar) {
        this.m = vVar;
    }

    public void setMeta(na naVar) {
        this.f1367a = naVar;
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(un.z(naVar));
        }
    }

    public void z() {
        Map<String, Object> mapG;
        if (this.g == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1367a);
        this.gc = new mc(this.dl);
        v vVar = this.m;
        if (vVar != null && (mapG = vVar.g()) != null && mapG.containsKey("key_reward_page")) {
            Object obj = mapG.get("key_reward_page");
            if (obj instanceof Map) {
                this.gc.z((Map<String, Object>) obj);
            }
        }
        this.gc.g(this.g).z(this.f1367a).dl(arrayList).g(this.f1367a.mj()).a(this.f1367a.vk()).dl(7).z(eo.g(this.f1367a)).gc(eo.ls(this.f1367a)).z(this.g).z(true).g(uy.z(this.f1367a)).z((a) this);
        this.g.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.dl, this.gc, this.f1367a.mj(), new gc(this.f1367a, this.g), null));
        this.g.setWebChromeClient(new dl(this.gc));
    }

    public void g(final JSONObject jSONObject) {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.dl(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        g.z(this.dl).z(false).g(false).z(this.g);
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            q.z(sSWebView, gk.dl, na.a(this.f1367a));
        }
        this.g.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = z.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.g.setDownloadListener(weakReference.get());
    }

    public void z(String str) {
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
