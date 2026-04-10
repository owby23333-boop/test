package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements f.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static a f805n;
    private final boolean a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f812i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a f814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f815l;
    private volatile boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f806c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f807d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f808e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f809f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ThreadPoolExecutor f810g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f811h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f813j = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f f816m = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$a, reason: collision with other inner class name */
    class RunnableC0023a implements Runnable {
        RunnableC0023a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    class b implements Runnable {
        final /* synthetic */ boolean a;

        b(boolean z2) {
            this.a = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.a);
        }
    }

    class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            JSONObject jSONObject;
            if (bVar2 != null && bVar2.e()) {
                String string = null;
                try {
                    jSONObject = new JSONObject(bVar2.a());
                } catch (Exception unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        string = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if ("success".equals(string)) {
                        try {
                            if (a.this.a(jSONObject)) {
                                a.this.b(101);
                            } else {
                                a.this.a(this.a + 1);
                            }
                            return;
                        } catch (Exception unused3) {
                            return;
                        }
                    }
                }
            }
            a.this.a(this.a + 1);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            a.this.a(this.a + 1);
        }
    }

    public a(Context context, int i2) {
        this.f812i = context;
        this.a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context);
        this.f815l = i2;
    }

    private a(Context context, boolean z2) {
        this.f812i = context;
        this.a = z2;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f805n == null) {
                f805n = new a(context.getApplicationContext(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context));
            }
            aVar = f805n;
        }
        return aVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        String[] strArrA = a();
        if (strArrA != null && strArrA.length > i2) {
            String str = strArrA[i2];
            if (!TextUtils.isEmpty(str)) {
                try {
                    String strA = a(str);
                    if (TextUtils.isEmpty(strA)) {
                        b(102);
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVarA = h().a();
                        aVarA.b(strA);
                        a(aVarA);
                        aVarA.a(new c(i2));
                    }
                    return;
                } catch (Throwable th) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("AppConfig", "try app config exception: " + th);
                    return;
                }
            }
        }
        b(102);
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar) {
        if (aVar == null) {
            return;
        }
        Address addressA = h.a().a(this.f815l).b() != null ? h.a().a(this.f815l).b().a(this.f812i) : null;
        if (addressA != null && addressA.hasLatitude() && addressA.hasLongitude()) {
            aVar.b("latitude", addressA.getLatitude() + "");
            aVar.b("longitude", addressA.getLongitude() + "");
            String locality = addressA.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                aVar.b("city", Uri.encode(locality));
            }
        }
        if (this.b) {
            aVar.b("force", "1");
        }
        try {
            aVar.b("abi", Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (h.a().a(this.f815l).b() != null) {
            aVar.b("aid", h.a().a(this.f815l).b().c() + "");
            aVar.b("device_platform", h.a().a(this.f815l).b().b());
            aVar.b("channel", h.a().a(this.f815l).b().d());
            aVar.b("version_code", h.a().a(this.f815l).b().e() + "");
            aVar.b("custom_info_1", h.a().a(this.f815l).b().f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("Gromore-message"))) {
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
            SharedPreferences.Editor editorEdit = this.f812i.getSharedPreferences("m_ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (h.a().a(this.f815l).d() != null) {
            h.a().a(this.f815l).d().a(jSONObject2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f fVar = this.f816m;
        if (fVar != null) {
            fVar.sendEmptyMessage(i2);
        }
    }

    public static void d(boolean z2) {
    }

    private void e(boolean z2) {
        if (this.f807d) {
            return;
        }
        if (this.f806c) {
            this.f806c = false;
            this.f808e = 0L;
            this.f809f = 0L;
        }
        long j2 = z2 ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f808e <= j2 || jCurrentTimeMillis - this.f809f <= 120000) {
            return;
        }
        boolean zA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f812i);
        if (!this.f813j || zA) {
            a(zA);
        }
    }

    private boolean g() {
        String[] strArrA = a();
        if (strArrA != null && strArrA.length != 0) {
            a(0);
        }
        return false;
    }

    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a h() {
        if (this.f814k == null) {
            this.f814k = new a.b().a(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).c(10L, TimeUnit.SECONDS).a();
        }
        return this.f814k;
    }

    public boolean a(boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doRefresh: updating state " + this.f811h.get());
        if (this.f811h.compareAndSet(false, true)) {
            if (z2) {
                this.f809f = System.currentTimeMillis();
            }
            b().execute(new b(z2));
            return true;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doRefresh, already running（mConfigUpdating：" + this.f811h.get() + ad.f20406s);
        return false;
    }

    public String[] a() {
        String[] strArrA = h.a().a(this.f815l).b() != null ? h.a().a(this.f815l).b().a() : null;
        return (strArrA == null || strArrA.length <= 0) ? new String[0] : strArrA;
    }

    public ThreadPoolExecutor b() {
        if (this.f810g == null) {
            synchronized (a.class) {
                if (this.f810g == null) {
                    this.f810g = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    this.f810g.allowCoreThreadTimeOut(true);
                }
            }
        }
        return this.f810g;
    }

    public void b(boolean z2) {
        synchronized (this) {
            if (this.a) {
                e(z2);
            } else if (this.f808e <= 0) {
                try {
                    b().execute(new RunnableC0023a());
                } catch (Throwable unused) {
                }
            }
        }
    }

    void c() {
        synchronized (this) {
            if (System.currentTimeMillis() - this.f808e > 3600000) {
                this.f808e = System.currentTimeMillis();
                try {
                    if (h.a().a(this.f815l).d() != null) {
                        h.a().a(this.f815l).d().c();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    void c(boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doRefresh, actual request");
        d();
        this.f807d = true;
        if (!z2) {
            this.f816m.sendEmptyMessage(102);
            return;
        }
        try {
            g();
        } catch (Exception unused) {
            this.f811h.set(false);
        }
    }

    public void d() {
        synchronized (this) {
            if (!this.f813j) {
                this.f813j = true;
                long j2 = this.f812i.getSharedPreferences("m_ss_app_config", 0).getLong("last_refresh_time", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (j2 > jCurrentTimeMillis) {
                    j2 = jCurrentTimeMillis;
                }
                this.f808e = j2;
                try {
                    if (h.a().a(this.f815l).d() != null) {
                        h.a().a(this.f815l).d().b();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void e() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.a) {
                d();
            } else {
                c();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        b(false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f.a
    public void handleMsg(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.f807d = false;
            this.f808e = System.currentTimeMillis();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doRefresh, succ");
            if (this.f806c) {
                f();
            }
        } else {
            if (i2 != 102) {
                return;
            }
            this.f807d = false;
            if (this.f806c) {
                f();
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doRefresh, error");
        }
        this.f811h.set(false);
    }
}
