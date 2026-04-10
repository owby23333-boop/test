package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.gc;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.zd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class pd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<gc> f296a = new ArrayList();
    private static final String g = "pd#";
    private static long kb = 0;
    private static String uy = null;
    private static boolean wp = false;
    static final String z = "pd#";
    private final oz e;
    private final gm gc;
    private final Context gz;
    private Map<String, String> i;
    private final boolean m;
    private Long v;
    private final ReentrantLock dl = new ReentrantLock();
    private final AtomicBoolean fo = new AtomicBoolean(false);

    pd(Context context) {
        this.gz = context.getApplicationContext();
        gm gmVarZ = mn.z(context);
        this.gc = gmVarZ;
        if (gmVarZ != null) {
            this.m = gmVarZ.z(context);
        } else {
            this.m = false;
        }
        this.e = new oz(context);
    }

    public Map<String, String> z(long j) {
        if (!this.m) {
            return null;
        }
        if (!z.g) {
            jz jzVarZ = this.e.z();
            if (jzVarZ != null) {
                return jzVarZ.z();
            }
            return null;
        }
        g();
        if (this.i == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.dl.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.dl.unlock();
                }
            } catch (InterruptedException e) {
                cb.z(e);
            }
        }
        return this.i;
    }

    static void z(gc gcVar) {
        List<gc> list = f296a;
        synchronized (list) {
            list.add(gcVar);
        }
        if (uy != null) {
            z(new gc.z(uy, wp, kb), new Object[]{gcVar});
        }
    }

    public gm z() {
        return this.gc;
    }

    private static Object[] dl() {
        Object[] array;
        List<gc> list = f296a;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    private static void z(gc.z zVar, Object[] objArr) {
        if (zVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((gc) obj).z(zVar);
        }
    }

    static void z(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            cb.z(e);
        }
    }

    static <K, V> void z(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    public void g() {
        if (this.fo.compareAndSet(false, true)) {
            z(new Runnable() { // from class: com.bytedance.embedapplog.pd.1
                @Override // java.lang.Runnable
                public void run() {
                    pd.this.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iIntValue;
        try {
            this.dl.lock();
            jz jzVarZ = this.e.z();
            long jLongValue = -1;
            boolean z2 = false;
            if (jzVarZ != null) {
                uy = jzVarZ.z;
                wp = jzVarZ.dl != null && jzVarZ.dl.booleanValue();
                kb = jzVarZ.e == null ? -1L : jzVarZ.e.longValue();
                this.i = jzVarZ.z();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairZ = z(this.gz);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            jz jzVar = null;
            String string = null;
            if (pairZ.first != null) {
                if (jzVarZ != null) {
                    string = jzVarZ.g;
                    iIntValue = jzVarZ.m.intValue() + 1;
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
                jz jzVar2 = new jz((String) pairZ.first, str, (Boolean) pairZ.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.v);
                this.e.z(jzVar2);
                jzVar = jzVar2;
            }
            if (jzVar != null) {
                uy = jzVar.z;
                if (jzVar.dl != null && jzVar.dl.booleanValue()) {
                    z2 = true;
                }
                wp = z2;
                if (jzVar.e != null) {
                    jLongValue = jzVar.e.longValue();
                }
                kb = jLongValue;
                this.i = jzVar.z();
            }
        } finally {
            this.dl.unlock();
            z(new gc.z(uy, wp, kb), dl());
        }
    }

    private Pair<String, Boolean> z(Context context) {
        String str;
        Boolean boolValueOf;
        gm.z zVarG;
        gm gmVar = this.gc;
        if (gmVar == null || (zVarG = gmVar.g(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = zVarG.g;
            boolValueOf = Boolean.valueOf(zVarG.dl);
            if (zVarG instanceof zd.z) {
                this.v = Long.valueOf(((zd.z) zVarG).z);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void z(Runnable runnable) {
        zb.z(z + "-query", runnable);
    }
}
