package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final Map<String, String> agP;
    private final com.kwad.sdk.core.network.idc.kwai.a agQ;
    private final Random agR;
    private final Map<String, AtomicBoolean> agS;
    private Context mContext;

    /* JADX INFO: renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    static final class C0441a {
        private static final a agU = new a(0);
    }

    private a() {
        this.agP = new ConcurrentHashMap(8);
        this.agQ = new com.kwad.sdk.core.network.idc.kwai.a();
        this.agR = new Random(System.currentTimeMillis());
        this.agS = new HashMap();
        this.agS.put("api", new AtomicBoolean(false));
        this.agS.put(INet.HostType.ULOG, new AtomicBoolean(false));
        this.agS.put(INet.HostType.ZT, new AtomicBoolean(false));
        this.agS.put("cdn", new AtomicBoolean(false));
    }

    /* synthetic */ a(byte b) {
        this();
    }

    @WorkerThread
    private void B(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> listBS = this.agQ.bS(str2);
        if (listBS.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.b.d("IdcManager", ">>> switchHost start, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.agS.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String strBQ = bQ(str2);
                if ((TextUtils.isEmpty(strBQ) || host.equals(strBQ)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = listBS.size();
                    int iIndexOf = listBS.indexOf(host);
                    boolean z2 = iIndexOf >= 0;
                    if (z2) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int iNextInt = this.agR.nextInt(size) + 1;
                        if (z2) {
                            iNextInt += iIndexOf;
                        }
                        int size2 = iNextInt % listBS.size();
                        String str3 = listBS.get(size2);
                        com.kwad.sdk.core.d.b.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + listBS + ", key = " + size2);
                        D(str2, str3);
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                com.kwad.sdk.core.d.b.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                com.kwad.sdk.core.d.b.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void D(String str, String str2) {
        this.agP.put(str, str2);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, (Map<String, String>) a.this.agP);
            }
        });
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void bP(String str) {
        String strBQ = bQ(str);
        List<String> listBS = this.agQ.bS(str);
        if (listBS.isEmpty()) {
            return;
        }
        String str2 = listBS.get(0);
        if (!TextUtils.equals(str2, strBQ) && af.eq(str2)) {
            D(str, str2);
        }
    }

    private String bQ(String str) {
        return this.agP.get(str);
    }

    public static a wy() {
        return C0441a.agU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void wz() {
        com.kwad.sdk.core.network.idc.kwai.a aVarBb = b.bb(this.mContext);
        if (aVarBb.isEmpty()) {
            aVarBb = b.ba(this.mContext);
        }
        this.agQ.b(aVarBb);
    }

    @Nullable
    public final String C(String str, String str2) {
        String str3 = this.agP.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String E(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strBQ = bQ(str2);
        if (strBQ == null || strBQ.isEmpty()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getPath()) || strBQ.equals(uri.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(strBQ);
        builder.scheme(TextUtils.isEmpty(uri.getScheme()) ? "https" : uri.getScheme());
        builder.path(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            builder.query(uri.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void a(com.kwad.sdk.core.network.idc.kwai.a aVar) {
        this.agQ.b(aVar);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.agQ);
            }
        });
    }

    public final void a(String str, int i2, Throwable th) {
        a(str, INet.HostType.ULOG, new DomainException(i2, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            B(str, str2);
        }
    }

    public final String bR(String str) {
        return E(str, "cdn");
    }

    public final void d(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        g.execute(new av() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                a.this.agP.putAll(b.bc(context));
                a.this.wz();
                if (a.this.agQ.isEmpty()) {
                    return;
                }
                Iterator<String> it = a.this.agQ.wC().iterator();
                while (it.hasNext()) {
                    a.this.bP(it.next());
                }
            }
        });
    }
}
