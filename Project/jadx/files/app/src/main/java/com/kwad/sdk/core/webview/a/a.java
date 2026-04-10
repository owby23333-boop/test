package com.kwad.sdk.core.webview.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.a.a.a;
import com.kwad.sdk.core.webview.a.b.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a ape;
    private Context mContext;
    private long mInitTime;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.e.kwai.b> apf = new CopyOnWriteArrayList();
    private final List<String> apg = new CopyOnWriteArrayList();
    private final List<String> aph = new CopyOnWriteArrayList();
    private final NetworkMonitor.a api = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.a.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.zn();
            }
        }
    };

    private a() {
    }

    private WebResourceResponse K(String str, String str2) {
        int i2;
        String str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.apg.add(str);
            WebResourceResponse webResourceResponseA = a(str, str2, aVar, false);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (webResourceResponseA != null) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load success time:" + jCurrentTimeMillis2 + "--url:" + str2);
                i2 = 1;
                str3 = "";
            } else {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                i2 = 2;
                str3 = aVar.msg;
            }
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, i2, str3, jCurrentTimeMillis2);
            return webResourceResponseA;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - jCurrentTimeMillis);
            return null;
        }
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z2) {
        com.kwad.sdk.e.kwai.b bVarCN = cN(str);
        if (bVarCN != null) {
            return b.a(this.mContext, str2, bVarCN, aVar, z2);
        }
        com.kwad.sdk.e.kwai.b bVarCM = cM(str);
        if (bVarCM == null) {
            aVar.msg = "配置文件没有下发该zip资源";
            return null;
        }
        aVar.msg = "资源未下载:" + bVarCM.loadType;
        b(bVarCM);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        if (this.aph.contains(bVar.asH)) {
            return;
        }
        com.kwad.sdk.core.webview.a.a.a.a(this.mContext, bVar, new a.InterfaceC0447a() { // from class: com.kwad.sdk.core.webview.a.a.4
            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0447a
            public final void c(com.kwad.sdk.e.kwai.b bVar2) {
                a.this.aph.add(bVar2.asH);
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0447a
            public final void d(com.kwad.sdk.e.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.a.a.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.b.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.apf.add(bVar2);
                    a aVar = a.this;
                    aVar.bq(aVar.mContext);
                    com.kwad.sdk.core.webview.a.b.b.a(bVar2, 4);
                }
                a.this.aph.remove(bVar2.asH);
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0447a
            public final void e(com.kwad.sdk.e.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aph.remove(bVar2.asH);
            }
        });
    }

    private void a(com.kwad.sdk.e.kwai.b bVar, com.kwad.sdk.e.kwai.a aVar) {
        bVar.asH = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String strCR = com.kwad.sdk.core.webview.a.b.a.cR(bVar.packageUrl);
        if (TextUtils.isEmpty(strCR)) {
            return;
        }
        bVar.asI = strCR;
        bVar.asJ = com.kwad.sdk.core.webview.a.b.a.w(this.mContext, bVar.asI);
    }

    private void b(@NonNull final com.kwad.sdk.e.kwai.b bVar) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(Context context) {
        synchronized (this.apf) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File fileBu = com.kwad.sdk.core.webview.a.b.a.bu(context);
                    String string = s.E(this.apf).toString();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileBu);
                    try {
                        fileOutputStream2.write(string.getBytes());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        com.kwad.sdk.core.d.b.e("updatePackageIndexFile", "read packageIndex file error");
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
            this.apg.clear();
            for (com.kwad.sdk.e.kwai.b bVar : this.apf) {
                if (bVar.asM) {
                    this.apg.add(bVar.asH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(Context context) {
        FileInputStream fileInputStream;
        List listA;
        synchronized (this.apf) {
            FileInputStream fileInputStream2 = null;
            try {
                File fileBu = com.kwad.sdk.core.webview.a.b.a.bu(context);
                if (p.G(fileBu)) {
                    fileInputStream = new FileInputStream(fileBu);
                    try {
                        try {
                            listA = s.a(h.b(new InputStreamReader(fileInputStream)), new c<com.kwad.sdk.e.kwai.b>() { // from class: com.kwad.sdk.core.webview.a.a.6
                                private static com.kwad.sdk.e.kwai.b zp() {
                                    return new com.kwad.sdk.e.kwai.b();
                                }

                                @Override // com.kwad.sdk.core.c
                                public final /* synthetic */ com.kwad.sdk.core.b uf() {
                                    return zp();
                                }
                            });
                            fileInputStream2 = fileInputStream;
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        listA = null;
                    }
                } else {
                    listA = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
            if (listA != null) {
                this.apf.clear();
                this.apf.addAll(listA);
            }
            this.apg.clear();
            for (com.kwad.sdk.e.kwai.b bVar : this.apf) {
                if (!p.ee(com.kwad.sdk.core.webview.a.b.a.y(this.mContext, bVar.asI))) {
                    this.apf.remove(bVar);
                }
                if (bVar.asM) {
                    this.apg.add(bVar.asH);
                }
            }
        }
    }

    private WebResourceResponse cL(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.apf) {
                Iterator<String> it = this.apg.iterator();
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

    private com.kwad.sdk.e.kwai.b cM(String str) {
        List<com.kwad.sdk.e.kwai.b> listZo = zo();
        if (listZo != null && !listZo.isEmpty()) {
            for (com.kwad.sdk.e.kwai.b bVar : listZo) {
                if (ba.isEquals(str, bVar.asH)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.e.kwai.b cN(String str) {
        synchronized (this.apf) {
            if (!TextUtils.isEmpty(str) && this.apf.size() > 0) {
                for (com.kwad.sdk.e.kwai.b bVar : this.apf) {
                    if (TextUtils.equals(str, bVar.asH)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<com.kwad.sdk.e.kwai.b> list) {
        synchronized (this.apf) {
            br(this.mContext);
            for (com.kwad.sdk.e.kwai.b bVar : this.apf) {
                if (!list.contains(bVar)) {
                    p.V(new File(bVar.asJ));
                    this.apf.remove(bVar);
                } else if (p.ee(com.kwad.sdk.core.webview.a.b.a.y(this.mContext, bVar.asI))) {
                    list.remove(bVar);
                }
            }
            bq(this.mContext);
        }
    }

    public static a zl() {
        if (ape == null) {
            synchronized (a.class) {
                if (ape == null) {
                    ape = new a();
                }
            }
        }
        return ape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.e.kwai.b> zo() {
        List<com.kwad.sdk.e.kwai.a> list;
        SdkConfigData sdkConfigDataUG = d.uG();
        if (sdkConfigDataUG == null || (list = sdkConfigDataUG.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.e.kwai.a aVar : list) {
            for (com.kwad.sdk.e.kwai.b bVar : aVar.asG) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final WebResourceResponse J(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String strCQ = com.kwad.sdk.core.webview.a.b.a.cQ(str);
        if (TextUtils.isEmpty(strCQ)) {
            return cL(str);
        }
        com.kwad.sdk.core.webview.a.b.b.b(str2, strCQ, str);
        WebResourceResponse webResourceResponseK = K(strCQ, str);
        com.kwad.sdk.core.webview.a.b.b.c(str2, strCQ, str);
        return webResourceResponseK;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = bo.dt(context);
            this.mHasInit = true;
            g.execute(new av() { // from class: com.kwad.sdk.core.webview.a.a.1
                @Override // com.kwad.sdk.utils.av
                public final void doTask() {
                    try {
                        if (d.b(com.kwad.sdk.core.config.c.acK)) {
                            a.this.mInitTime = System.currentTimeMillis();
                            a.this.br(context);
                            a.this.zn();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.api);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long zm() {
        return this.mInitTime;
    }

    public final void zn() {
        if (d.uP()) {
            g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        List<com.kwad.sdk.e.kwai.b> listZo = a.this.zo();
                        if (listZo != null && !listZo.isEmpty()) {
                            a.this.v(listZo);
                            for (com.kwad.sdk.e.kwai.b bVar : listZo) {
                                if (bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && af.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }
}
