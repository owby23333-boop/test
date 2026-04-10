package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a aNk;
    private long YY;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.h.a.b> aNl = new CopyOnWriteArrayList();
    private final List<String> aNm = new CopyOnWriteArrayList();
    private final List<String> aNn = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aNo = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.KU();
            }
        }
    };

    private a() {
    }

    public static a KT() {
        if (aNk == null) {
            synchronized (a.class) {
                if (aNk == null) {
                    aNk = new a();
                }
            }
        }
        return aNk;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.Pp();
            this.mHasInit = true;
            h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        if (e.b(c.aAk)) {
                            a.this.YY = System.currentTimeMillis();
                            a.this.bV(context);
                            a.this.KU();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aNo);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long tg() {
        return this.YY;
    }

    public final void KU() {
        if (e.FF()) {
            h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        List<com.kwad.sdk.h.a.b> listKV = a.this.KV();
                        if (listKV != null && !listKV.isEmpty()) {
                            a.this.G(listKV);
                            for (com.kwad.sdk.h.a.b bVar : listKV) {
                                if (bVar != null && bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ao.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.h.a.b bVar) {
        if (this.aNn.contains(bVar.aRp) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0410a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0410a
            public final void c(com.kwad.sdk.h.a.b bVar2) {
                a.this.aNn.add(bVar2.aRp);
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0410a
            public final void d(com.kwad.sdk.h.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.aNl.add(bVar2);
                    a aVar = a.this;
                    aVar.bU(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.aNn.remove(bVar2.aRp);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0410a
            public final void e(com.kwad.sdk.h.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aNn.remove(bVar2.aRp);
            }
        });
    }

    public final WebResourceResponse aa(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String strFa = com.kwad.sdk.core.webview.b.c.a.fa(str);
        if (!TextUtils.isEmpty(strFa)) {
            com.kwad.sdk.core.webview.b.c.b.c(str2, strFa, str);
            WebResourceResponse webResourceResponseAb = ab(strFa, str);
            com.kwad.sdk.core.webview.b.c.b.d(str2, strFa, str);
            return webResourceResponseAb;
        }
        return eV(str);
    }

    private WebResourceResponse ab(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aNm.add(str);
            WebResourceResponse webResourceResponseA = a(str, str2, aVar, false);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (webResourceResponseA != null) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load success time:" + jCurrentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", jCurrentTimeMillis2);
            } else {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, jCurrentTimeMillis2);
            }
            return webResourceResponseA;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - jCurrentTimeMillis);
            return null;
        }
    }

    private WebResourceResponse eV(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aNl) {
                Iterator<String> it = this.aNm.iterator();
                while (it.hasNext()) {
                    WebResourceResponse webResourceResponseA = a(it.next(), str, aVar, true);
                    if (webResourceResponseA != null) {
                        return webResourceResponseA;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private WebResourceResponse a(String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.h.a.b bVarEX = eX(str);
        if (bVarEX == null) {
            com.kwad.sdk.h.a.b bVarEW = eW(str);
            if (bVarEW == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + bVarEW.loadType;
            b(bVarEW);
            return null;
        }
        return b.a(this.mContext, str2, bVarEX, aVar, z);
    }

    private com.kwad.sdk.h.a.b eW(String str) {
        List<com.kwad.sdk.h.a.b> listKV = KV();
        if (listKV != null && !listKV.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : listKV) {
                if (bp.isEquals(str, bVar.aRp)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.h.a.b eX(String str) {
        synchronized (this.aNl) {
            if (!TextUtils.isEmpty(str) && this.aNl.size() > 0) {
                for (com.kwad.sdk.h.a.b bVar : this.aNl) {
                    if (TextUtils.equals(str, bVar.aRp)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.kwad.sdk.h.a.b> KV() {
        List<com.kwad.sdk.h.a.a> list;
        SdkConfigData sdkConfigDataFw = e.Fw();
        if (sdkConfigDataFw == null || (list = sdkConfigDataFw.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            if (aVar != null && aVar.aRo != null) {
                for (com.kwad.sdk.h.a.b bVar : aVar.aRo) {
                    a(bVar, aVar);
                    if (bVar.isValid()) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.aRp = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String strFb = com.kwad.sdk.core.webview.b.c.a.fb(bVar.packageUrl);
        if (TextUtils.isEmpty(strFb)) {
            return;
        }
        bVar.aRq = strFb;
        bVar.aRr = com.kwad.sdk.core.webview.b.c.a.I(this.mContext, bVar.aRq);
    }

    private void b(final com.kwad.sdk.h.a.b bVar) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.h.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.aNl) {
            bV(this.mContext);
            for (com.kwad.sdk.h.a.b bVar : this.aNl) {
                if (list.contains(bVar)) {
                    if (w.gR(com.kwad.sdk.core.webview.b.c.a.K(this.mContext, bVar.aRq))) {
                        list.remove(bVar);
                    }
                } else {
                    w.ab(new File(bVar.aRr));
                    this.aNl.remove(bVar);
                }
            }
            bU(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(Context context) {
        synchronized (this.aNl) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File fileBY = com.kwad.sdk.core.webview.b.c.a.bY(context);
                    String string = aa.S(this.aNl).toString();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileBY);
                    try {
                        fileOutputStream2.write(string.getBytes());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        com.kwad.sdk.core.d.c.e("updatePackageIndexFile", "read packageIndex file error");
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused2) {
            }
            this.aNm.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aNl) {
                if (bVar.aRt) {
                    this.aNm.add(bVar.aRp);
                }
            }
        }
    }

    @Deprecated
    private static List<com.kwad.sdk.h.a.b> a(String str, com.kwad.sdk.core.c<com.kwad.sdk.h.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.h.a.b bVar = (com.kwad.sdk.h.a.b) cVar.Ef();
                bVar.parseJson(jSONObject);
                arrayList.add(bVar);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(Context context) {
        FileInputStream fileInputStream;
        List<com.kwad.sdk.h.a.b> listA;
        synchronized (this.aNl) {
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            List<com.kwad.sdk.h.a.b> list = null;
            try {
                File fileBY = com.kwad.sdk.core.webview.b.c.a.bY(context);
                if (w.O(fileBY)) {
                    fileInputStream = new FileInputStream(fileBY);
                    try {
                        try {
                            listA = a(com.kwad.sdk.crash.utils.h.b(new InputStreamReader(fileInputStream)), new com.kwad.sdk.core.c<com.kwad.sdk.h.a.b>() { // from class: com.kwad.sdk.core.webview.b.a.6
                                @Override // com.kwad.sdk.core.c
                                public final /* synthetic */ com.kwad.sdk.core.b Ef() {
                                    return KW();
                                }

                                private static com.kwad.sdk.h.a.b KW() {
                                    return new com.kwad.sdk.h.a.b();
                                }
                            });
                            fileInputStream3 = fileInputStream;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    }
                } else {
                    listA = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream3);
                list = listA;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
            if (list != null) {
                this.aNl.clear();
                this.aNl.addAll(list);
            }
            this.aNm.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aNl) {
                if (!w.gR(com.kwad.sdk.core.webview.b.c.a.K(this.mContext, bVar.aRq))) {
                    this.aNl.remove(bVar);
                }
                if (bVar.aRt) {
                    this.aNm.add(bVar.aRp);
                }
            }
        }
    }
}
