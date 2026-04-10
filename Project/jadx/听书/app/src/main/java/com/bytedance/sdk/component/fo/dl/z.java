package com.bytedance.sdk.component.fo.dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.fo.z;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.uy;
import com.kuaishou.weapon.p0.bi;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements l.z {
    private static ThreadPoolExecutor fo;
    private static boolean gz;
    private final boolean g;
    private com.bytedance.sdk.component.fo.z i;
    private final Context kb;
    private int v;
    private volatile boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f708a = true;
    private boolean gc = false;
    private long m = 0;
    private long e = 0;
    private AtomicBoolean uy = new AtomicBoolean(false);
    private volatile boolean wp = false;
    final l z = com.bytedance.sdk.component.uy.g.z.z().z(this, "tt-net");

    public z(Context context, int i) {
        this.kb = context;
        this.g = p.z(context);
        this.v = i;
    }

    public void z() {
        z(false);
    }

    public synchronized void z(boolean z) {
        if (this.g) {
            a(z);
            return;
        }
        if (this.m <= 0) {
            try {
                e().execute(new Runnable() { // from class: com.bytedance.sdk.component.fo.dl.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(boolean z) {
        gz = z;
    }

    public Context getContext() {
        return this.kb;
    }

    public static void z(Context context, int i) {
        z zVarZ;
        if (gz && (zVarZ = e.z().z(i, context)) != null) {
            if (p.z(context)) {
                zVarZ.z(true);
            } else {
                zVarZ.z();
            }
        }
    }

    synchronized void g() {
        if (System.currentTimeMillis() - this.m > bi.s) {
            this.m = System.currentTimeMillis();
            try {
                if (e.z().z(this.v).gz() != null) {
                    e.z().z(this.v).gz().g();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(boolean z) {
        if (this.gc) {
            return;
        }
        if (this.f708a) {
            this.f708a = false;
            this.m = 0L;
            this.e = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.m > j) {
            if (jCurrentTimeMillis - this.e > 120000 || !this.wp) {
                dl();
            }
        }
    }

    public boolean dl() {
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doRefresh: updating state " + this.uy.get());
        e().execute(new Runnable() { // from class: com.bytedance.sdk.component.fo.dl.z.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z = com.bytedance.sdk.component.fo.a.m.z(z.this.kb);
                if (z) {
                    z.this.e = System.currentTimeMillis();
                    if (!z.this.uy.compareAndSet(false, true)) {
                        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doRefresh, already running");
                    } else {
                        z.this.dl(z);
                    }
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        if (i == 101) {
            this.gc = false;
            this.m = System.currentTimeMillis();
            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doRefresh, succ");
            if (this.f708a) {
                z();
            }
            this.uy.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.gc = false;
        if (this.f708a) {
            z();
        }
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doRefresh, error");
        this.uy.set(false);
    }

    public synchronized void a() {
        if (this.wp) {
            return;
        }
        this.wp = true;
        long j = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.kb, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.m = j;
        try {
            if (e.z().z(this.v).gz() != null) {
                e.z().z(this.v).gz().z();
            }
        } catch (Exception unused) {
        }
    }

    public void gc() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.g) {
                a();
            } else {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    void dl(boolean z) {
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doRefresh, actual request");
        a();
        this.gc = true;
        if (!z) {
            this.z.sendEmptyMessage(102);
            return;
        }
        try {
            gz();
        } catch (Exception unused) {
            this.uy.set(false);
        }
    }

    public String[] m() {
        String[] strArrM = e.z().z(this.v).a() != null ? e.z().z(this.v).a().m() : null;
        return (strArrM == null || strArrM.length <= 0) ? new String[0] : strArrM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.kb, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (e.z().z(this.v).gz() == null) {
            return true;
        }
        e.z().z(this.v).gz().z(jSONObject2);
        return true;
    }

    private boolean gz() {
        String[] strArrM = m();
        if (strArrM != null && strArrM.length != 0) {
            z(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final int i) {
        String[] strArrM = m();
        if (strArrM == null || strArrM.length <= i) {
            g(102);
            return;
        }
        String str = strArrM[i];
        if (TextUtils.isEmpty(str)) {
            g(102);
            return;
        }
        try {
            String strZ = z(str);
            if (TextUtils.isEmpty(strZ)) {
                g(102);
                return;
            }
            com.bytedance.sdk.component.fo.g.dl dlVarDl = fo().dl();
            dlVarDl.z(strZ);
            z(dlVarDl);
            dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.component.fo.dl.z.3
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    JSONObject jSONObject;
                    if (gVar == null || !gVar.gz()) {
                        z.this.z(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObject = new JSONObject(gVar.a());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        z.this.z(i + 1);
                        return;
                    }
                    try {
                        string = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        z.this.z(i + 1);
                        return;
                    }
                    try {
                        if (z.this.z(jSONObject)) {
                            z.this.g(101);
                        } else {
                            z.this.z(i + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    z.this.z(i + 1);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.fo.a.dl.g("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
        }
    }

    private com.bytedance.sdk.component.fo.z fo() {
        if (this.i == null) {
            this.i = new z.C0131z().z(10L, TimeUnit.SECONDS).g(10L, TimeUnit.SECONDS).dl(10L, TimeUnit.SECONDS).z();
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        l lVar = this.z;
        if (lVar != null) {
            lVar.sendEmptyMessage(i);
        }
    }

    private String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void z(com.bytedance.sdk.component.fo.g.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        Address addressZ = e.z().z(this.v).a() != null ? e.z().z(this.v).a().z(this.kb) : null;
        if (addressZ != null && addressZ.hasLatitude() && addressZ.hasLongitude()) {
            dlVar.z("latitude", new StringBuilder().append(addressZ.getLatitude()).toString());
            dlVar.z("longitude", new StringBuilder().append(addressZ.getLongitude()).toString());
            String locality = addressZ.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                dlVar.z("city", Uri.encode(locality));
            }
        }
        if (this.dl) {
            dlVar.z("force", "1");
        }
        try {
            dlVar.z("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            wp.z(th);
        }
        if (e.z().z(this.v).a() != null) {
            dlVar.z("aid", new StringBuilder().append(e.z().z(this.v).a().z()).toString());
            dlVar.z("device_platform", e.z().z(this.v).a().dl());
            dlVar.z("channel", e.z().z(this.v).a().g());
            dlVar.z("version_code", new StringBuilder().append(e.z().z(this.v).a().a()).toString());
            dlVar.z("custom_info_1", e.z().z(this.v).a().gc());
        }
    }

    public static ThreadPoolExecutor e() {
        if (fo == null) {
            synchronized (z.class) {
                if (fo == null) {
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new uy("tnc/AppConfig"));
                    fo = aVar;
                    aVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return fo;
    }

    public static void z(ThreadPoolExecutor threadPoolExecutor) {
        fo = threadPoolExecutor;
    }
}
