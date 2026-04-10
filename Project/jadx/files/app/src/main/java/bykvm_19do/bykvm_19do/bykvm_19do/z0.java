package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_19do.v0;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class z0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static e f788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f789j;
    private a1 b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d1 f791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f792e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f795h;
    private final ReentrantLock a = new ReentrantLock();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f793f = new AtomicBoolean(false);

    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z2) {
            this.a = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.b(this.a);
        }
    }

    z0(Context context) {
        this.f792e = context;
        a(this.f792e);
        this.f791d = new d1(context);
    }

    private void a(Context context) {
        this.b = b1.a(context);
        a1 a1Var = this.b;
        this.f790c = a1Var != null ? a1Var.a(context) : false;
    }

    private static void a(e.a aVar) {
        e eVar;
        if (aVar == null || (eVar = f788i) == null) {
            return;
        }
        eVar.a(aVar);
    }

    static void a(e eVar) {
        f788i = eVar;
        String str = f789j;
        if (str != null) {
            a(new e.a(str));
        }
    }

    private static void a(Runnable runnable) {
        u0.a("Oaid#-query", runnable);
    }

    static <K, V> void a(Map<K, V> map, K k2, V v2) {
        if (k2 == null || v2 == null) {
            return;
        }
        map.put(k2, v2);
    }

    static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> b(Context context) {
        Boolean boolValueOf;
        a1.a aVarB;
        a1 a1Var = this.b;
        String str = null;
        if (a1Var == null || (aVarB = a1Var.b(context)) == null) {
            boolValueOf = null;
        } else {
            str = aVarB.a;
            boolean z2 = aVarB.b;
            if (aVarB instanceof v0.c) {
                this.f795h = Long.valueOf(((v0.c) aVarB).f758c);
            }
            boolValueOf = Boolean.valueOf(z2);
        }
        return new Pair<>(str, boolValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        int iIntValue;
        t0.b("Oaid#", "Oaid#initOaid");
        try {
            this.a.lock();
            c1 c1Var = null;
            String string = null;
            if (z2) {
                t0.b("Oaid#", "Oaid#initOaid clear");
                this.f791d.b();
                f789j = null;
                this.f794g = null;
            }
            t0.b("Oaid#", "Oaid#initOaid exec");
            c1 c1VarA = this.f791d.a();
            t0.b("Oaid#", "Oaid#initOaid fetch=" + c1VarA);
            if (c1VarA != null) {
                f789j = c1VarA.a;
                this.f794g = c1VarA.a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairB = b(this.f792e);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (pairB.first != null) {
                if (c1VarA != null) {
                    string = c1VarA.b;
                    iIntValue = c1VarA.f668f.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                c1 c1Var2 = new c1((String) pairB.first, str, (Boolean) pairB.second, Long.valueOf(jElapsedRealtime2 - jElapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.f795h);
                this.f791d.a(c1Var2);
                c1Var = c1Var2;
            }
            if (c1Var != null) {
                f789j = c1Var.a;
                this.f794g = c1Var.a();
            }
            t0.b("Oaid#", "Oaid#initOaid oaidModel=" + c1Var);
        } finally {
            this.a.unlock();
            a(new e.a(f789j));
        }
    }

    @Nullable
    @WorkerThread
    public Map<String, String> a(long j2) {
        if (!this.f790c) {
            return null;
        }
        boolean zTryLock = false;
        a(false);
        t0.a("Oaid#", "Oaid#getOaid timeoutMills=" + j2);
        if (this.f794g == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                try {
                    zTryLock = this.a.tryLock(j2, TimeUnit.MILLISECONDS);
                    t0.b("Oaid#", "Oaid#getOaid locked=" + zTryLock + ", took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    if (zTryLock) {
                    }
                }
                if (zTryLock) {
                    this.a.unlock();
                }
            } catch (Throwable th) {
                if (zTryLock) {
                    this.a.unlock();
                }
                throw th;
            }
        }
        t0.a("Oaid#", "Oaid#getOaid return apiMap=" + this.f794g);
        return this.f794g;
    }

    public void a(boolean z2) {
        if (z2 || this.f793f.compareAndSet(false, true)) {
            a(new a(z2));
        }
    }
}
