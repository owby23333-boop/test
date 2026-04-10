package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.ti;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.v.gz;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class io extends com.bytedance.sdk.component.adexpress.gc.z implements i, v {
    private Context e;
    private na fo;
    private com.bytedance.sdk.component.adexpress.g.fo fv;
    private String gz;
    private mc i;
    private long js;
    private String kb;
    private com.bytedance.sdk.openadsdk.v.gz ls;
    private final Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> m;
    private m p;
    private com.bytedance.sdk.openadsdk.core.un.z pf;
    private com.bytedance.sdk.openadsdk.m.z uy;
    private int v;
    private com.bytedance.sdk.openadsdk.core.i.gc wp;

    public io(Context context, com.bytedance.sdk.component.adexpress.g.i iVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.m.z zVar, na naVar, com.bytedance.sdk.component.adexpress.g.fo foVar) {
        super(context, iVar, themeStatusBroadcastReceiver);
        this.m = Collections.synchronizedMap(new HashMap());
        this.v = 8;
        this.js = -1L;
        this.e = context;
        this.gz = iVar.m();
        this.fo = naVar;
        this.uy = zVar;
        this.z = iVar.gc();
        String strZ = z(naVar);
        this.kb = strZ;
        this.fv = foVar;
        z(ti.g(strZ));
        themeStatusBroadcastReceiver.z(this);
        wp();
        i();
        v();
    }

    public static String z(na naVar) {
        return com.bytedance.sdk.component.adexpress.z.g.g.g(vm.gz(naVar) ? "v3" : null);
    }

    public static void z(Map<String, Object> map, na naVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (vm.m(naVar) != null && !TextUtils.isEmpty(vm.m(naVar).kb())) {
                map.put("engine_version", vm.m(naVar).kb());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void wp() {
        if (this.dl == null) {
            return;
        }
        mc mcVar = new mc(this.e);
        this.i = mcVar;
        mcVar.g(this.dl).z(this.fo).g(this.fo.mj()).a(this.fo.vk()).z(this.gz).dl(eo.g(this.gz)).gc(eo.ls(this.fo)).z(this).gc(this.z).z(this.dl).z(this.uy);
    }

    public void i() {
        if (this.dl == null) {
            return;
        }
        this.dl.setMaterialMeta(un.z(this.fo));
        try {
            this.dl.setBackgroundColor(0);
            this.dl.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        z(this.dl);
        if (z() != null) {
            this.wp = new com.bytedance.sdk.openadsdk.core.i.gc(this.fo, z()).g(false);
        }
        this.wp.z(this.uy);
        this.dl.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.i, this.wp));
        this.dl.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.io.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (io.this.m.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = (com.bytedance.sdk.openadsdk.core.kb.g.dl) io.this.m.get(str);
                    if (dlVar != null) {
                        dlVar.z(eo.js(io.this.fo), false);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z(io.this.e, str, io.this.fo, io.this.gz);
                io.this.m.put(str, dlVarZ);
                dlVarZ.z(eo.js(io.this.fo), false);
            }
        });
        if ("rewarded_video".equals(this.gz) || "fullscreen_interstitial_ad".equals(this.gz)) {
            oq.z((com.bytedance.sdk.component.i.dl) this.dl);
        }
        com.bytedance.sdk.component.adexpress.gc.gc.z().z(this.dl, this.i);
    }

    private void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.e).z(false).z(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            com.bytedance.sdk.openadsdk.core.un.q.z(sSWebView, gk.dl, na.a(this.fo));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("WebViewRender", e.toString());
        }
    }

    public void v() {
        if (this.dl == null || this.ls != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.tb.dl dlVar = new com.bytedance.sdk.openadsdk.core.tb.dl();
        com.bytedance.sdk.openadsdk.core.tb.a aVar = new com.bytedance.sdk.openadsdk.core.tb.a();
        com.bytedance.sdk.openadsdk.core.tb.gc gcVar = new com.bytedance.sdk.openadsdk.core.tb.gc(this.i);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, this.fo.mj());
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.fo.vk());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.ls = dlVar.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), this.dl, gcVar, aVar, hashSet, "embeded_ad".equals(this.gz) ? gz.z.FEED : gz.z.OTHER).gc(this.kb).a(com.bytedance.sdk.openadsdk.core.gz.z.e()).z(com.bytedance.sdk.openadsdk.core.gz.z.z()).gc(jSONObject).z("sdkEdition", com.bytedance.sdk.openadsdk.core.gz.z.dl()).g(com.bytedance.sdk.openadsdk.core.gz.z.gc()).dl(com.bytedance.sdk.openadsdk.core.gz.z.a()).dl(false);
        this.p = new m(this.e, this.i, this.fo, this.wp, ls(), this.ls, kb());
        this.dl.setWebViewClient(this.p);
        com.bytedance.sdk.component.adexpress.g.fo foVar = this.fv;
        if (foVar instanceof fo) {
            ((fo) foVar).z(this.ls);
        }
        Set<String> setUy = this.ls.uy();
        if (this.i == null || setUy == null || setUy.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.ls);
        Iterator<String> it = setUy.iterator();
        while (it.hasNext()) {
            this.i.m().z(it.next(), (com.bytedance.sdk.component.z.gc<?, ?>) new com.bytedance.sdk.component.z.gc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.io.2
                @Override // com.bytedance.sdk.component.z.gc
                public JSONObject z(JSONObject jSONObject2, com.bytedance.sdk.component.z.m mVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.v.gz gzVar = (com.bytedance.sdk.openadsdk.v.gz) weakReference.get();
                        if (gzVar == null) {
                            return null;
                        }
                        return gzVar.a(z(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public m pf() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    public SSWebView z() {
        return this.dl;
    }

    private boolean ls() {
        return !TextUtils.isEmpty(this.gz) && this.gz.equals("splash_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    public void a() {
        if (this.gc.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.m();
        }
        if (this.dl != null) {
            this.dl.I_();
            this.dl.setOnShakeListener(null);
        }
        mc mcVar = this.i;
        if (mcVar != null) {
            mcVar.gc();
        }
        super.a();
        this.m.clear();
        this.i = null;
        com.bytedance.sdk.openadsdk.v.gz gzVar = this.ls;
        if (gzVar == null) {
            return;
        }
        gzVar.mc();
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z, com.bytedance.sdk.component.adexpress.g.a
    public int dl() {
        return vm.g(this.fo);
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    public void gc() {
        if (z() == null) {
            return;
        }
        try {
            z().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    protected void z(boolean z, int i) {
        super.z(z, i);
        com.bytedance.sdk.openadsdk.m.z zVar = this.uy;
        if (zVar != null) {
            zVar.z(z, i);
            this.uy.g(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z, com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void gz() {
        super.gz();
        if (this.i == null) {
            return;
        }
        p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.i.z("expressShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private void p() {
        if (this.i == null || ((ViewGroup) this.dl.getParent()) == null) {
            return;
        }
        this.i.z(new uf(this.dl, this.i, this.fo));
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    protected void fo() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = com.bytedance.sdk.openadsdk.core.uy.ls().a();
        this.pf = zVarA;
        zVarA.z(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    protected void uy() {
        super.uy();
        com.bytedance.sdk.openadsdk.core.un.z zVar = this.pf;
        if (zVar != null) {
            zVar.g(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    public void m() {
        mc mcVar = this.i;
        if (mcVar == null) {
            return;
        }
        mcVar.z("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z, com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void g(final int i) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.io.3
            @Override // java.lang.Runnable
            public void run() {
                io.this.dl(i);
                io.this.a(i);
                if (i == io.this.v) {
                    return;
                }
                io.this.v = i;
                io.this.g(i == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i) {
        com.bytedance.sdk.openadsdk.v.gz gzVar = this.ls;
        if (gzVar == null) {
            return;
        }
        if (i == 0) {
            gzVar.g(true);
            this.ls.z(false);
        } else {
            gzVar.g(false);
            this.ls.z(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        if (this.i == null || this.dl == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.i.z("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.v
    public mc D_() {
        return this.i;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.z
    public void b_(int i) {
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        this.i.z("themeChange", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            if (gk.z() && i == 0) {
                long jO = com.bytedance.sdk.openadsdk.core.zw.g().o();
                if (this.js != -1 && System.currentTimeMillis() - this.js > jO) {
                    SSWebView sSWebViewZ = z();
                    WebView webView = sSWebViewZ.getWebView();
                    sSWebViewZ.removeView(webView);
                    sSWebViewZ.addView(webView);
                }
                this.js = -1L;
                return;
            }
            this.js = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.z
    protected void z(float f, float f2) {
        float f3 = this.e.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.z(oq.g(f3, oq.z(f4, f)), oq.g(f3, oq.z(f4, f2)));
    }
}
