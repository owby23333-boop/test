package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final int aFx;
    private final Map<String, String> aFs;
    private final com.kwad.sdk.core.network.idc.a.b aFt;
    private final Random aFu;
    private final Map<String, AtomicBoolean> aFv;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> aFw;
    private volatile int aFy;
    private volatile boolean aFz;
    private Context mContext;

    /* synthetic */ a(byte b) {
        this();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aFz = false;
        return false;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    static final class C0406a {
        private static final a aFC = new a(0);
    }

    private a() {
        this.aFs = new ConcurrentHashMap(8);
        this.aFt = new com.kwad.sdk.core.network.idc.a.b();
        this.aFu = new Random(System.currentTimeMillis());
        HashMap map = new HashMap();
        this.aFv = map;
        this.aFw = new ConcurrentHashMap(4);
        this.aFy = 0;
        this.aFz = false;
        map.put("api", new AtomicBoolean(false));
        map.put("ulog", new AtomicBoolean(false));
        map.put("zt", new AtomicBoolean(false));
        map.put("cdn", new AtomicBoolean(false));
    }

    public static a HF() {
        return C0406a.aFC;
    }

    static {
        aFx = com.kwad.framework.a.a.oz.booleanValue() ? 0 : 60000;
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        this.aFz = true;
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.aFs.putAll(b.bB(context));
                a.this.HG();
                if (!a.this.aFt.isEmpty()) {
                    Iterator<String> it = a.this.aFt.HM().iterator();
                    while (it.hasNext()) {
                        a.this.ed(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        com.kwad.sdk.core.network.idc.a.b bVarBA = b.bA(this.mContext);
        if (bVarBA.isEmpty()) {
            bVarBA = b.bz(this.mContext);
        }
        this.aFt.a(bVarBA);
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i) {
        this.aFy = i * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i);
        if (i == 0) {
            this.aFw.clear();
        }
        this.aFt.a(bVar);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, a.this.aFt);
            }
        });
    }

    private void V(String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> listEg = this.aFt.eg(str2);
        if (listEg.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.aFv.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String strEe = ee(str2);
                if ((TextUtils.isEmpty(strEe) || host.equals(strEe)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = listEg.size();
                    int iIndexOf = listEg.indexOf(host);
                    boolean z = iIndexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int iNextInt = this.aFu.nextInt(size) + 1;
                        if (z) {
                            iNextInt += iIndexOf;
                        }
                        int size2 = iNextInt % listEg.size();
                        String str3 = listEg.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + listEg + ", key = " + size2);
                        X(str2, str3);
                        if (p(str2, size2)) {
                            eb(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                c.d("IdcManager", sb.append(str2).append(", old host = ").append(host).toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private boolean p(String str, int i) {
        return "api".equals(str) && i > 0 && !this.aFw.containsKey(str) && this.aFy > 0;
    }

    private void eb(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.aFw.put(str, new com.kwad.sdk.core.network.idc.a.a(jElapsedRealtime, false));
    }

    public final boolean HH() {
        return !this.aFw.isEmpty();
    }

    public final void ec(String str) {
        int i = this.aFy;
        if (this.aFz || i <= 0) {
            c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.aFz + ",rollbackInterval = " + i);
            return;
        }
        com.kwad.sdk.core.network.idc.a.a aVar = this.aFw.get(str);
        if (aVar != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - aVar.HK();
            boolean z = jElapsedRealtime > ((long) Math.max(i, aFx));
            c.d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + jElapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
            if (z) {
                AtomicBoolean atomicBoolean = this.aFv.get(str);
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        boolean zHJ = aVar.HJ();
                        c.d("IdcManager", "handleHostRollback: isInRollback = " + zHJ);
                        if (!zHJ) {
                            aVar.bq(true);
                            if (ed(str)) {
                                this.aFw.remove(str);
                                c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                            } else {
                                c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                eb(str);
                            }
                        }
                    }
                } catch (Exception e) {
                    c.e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                } finally {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ed(String str) {
        boolean zHc;
        String strEe = ee(str);
        List<String> listEg = this.aFt.eg(str);
        if (listEg.isEmpty()) {
            return false;
        }
        String str2 = listEg.get(0);
        if (TextUtils.equals(str2, strEe)) {
            return true;
        }
        if ("api".equals(str)) {
            zHc = c(com.kwad.framework.a.a.oz.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            zHc = ao.hc(str2);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str2 + ",isSuccess = " + zHc);
        if (zHc) {
            X(str, str2);
        }
        return zHc;
    }

    public final String W(String str, String str2) {
        String str3 = this.aFs.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    private String ee(String str) {
        return this.aFs.get(str);
    }

    private void X(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.aFs.put(str, str2);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.aFs);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, "ulog", new DomainException(i, th));
    }

    public final void h(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            V(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    public final String ef(String str) {
        return Y(str, "cdn");
    }

    public final String Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strEe = ee(str2);
        if (strEe == null || strEe.isEmpty()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getPath()) || strEe.equals(uri.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(strEe);
        if (TextUtils.isEmpty(uri.getScheme())) {
            builder.scheme("https");
        } else {
            builder.scheme(uri.getScheme());
        }
        builder.path(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            builder.query(uri.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    private static boolean c(final String str, Context context) {
        boolean zIsNetworkConnected = ao.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + zIsNetworkConnected);
        if (zIsNetworkConnected && str != null) {
            AdHttpProxy adHttpProxyAI = g.AI();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.h.ce("https://" + str);
                }
            };
            com.kwad.sdk.core.network.c cVarDoGet = adHttpProxyAI.doGet(dVar.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (cVarDoGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + cVarDoGet.aEi + ",body = " + cVarDoGet.aEk);
                if (cVarDoGet.aEi == 200) {
                    return true;
                }
            }
        }
        return false;
    }
}
