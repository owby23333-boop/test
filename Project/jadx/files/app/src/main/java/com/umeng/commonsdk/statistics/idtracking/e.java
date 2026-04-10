package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.be;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IdTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final long a = 86400000;
    public static e b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20098c = "umeng_it.cache";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f20099j = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f20100d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f20102f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f20105i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f20101e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f20104h = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f20103g = 86400000;

    /* JADX INFO: compiled from: IdTracker.java */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized boolean a(String str) {
            return !this.b.contains(str);
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(",")) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.f20105i = null;
        this.f20100d = new File(context.getFilesDir(), f20098c);
        this.f20105i = new a(context);
        this.f20105i.b();
    }

    public static synchronized void a() {
        if (b != null) {
            b.e();
            b = null;
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f20104h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.f20101e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f20099j) {
            if (!this.f20100d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f20100d);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new ay().a(cVar, streamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f20102f >= this.f20103g) {
            boolean z2 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f20104h) {
                if (aVar.c() && aVar.a()) {
                    z2 = true;
                    if (!aVar.c()) {
                        this.f20105i.b(aVar.b());
                    }
                }
            }
            if (z2) {
                h();
                this.f20105i.a();
                g();
            }
            this.f20102f = jCurrentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f20101e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (b == null) {
            return;
        }
        boolean z2 = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f20104h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z2 = true;
            }
        }
        if (z2) {
            this.f20101e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c cVarI = i();
        if (cVarI == null) {
            return;
        }
        a(cVarI);
        ArrayList arrayList = new ArrayList(this.f20104h.size());
        synchronized (this) {
            this.f20101e = cVarI;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f20104h) {
                aVar.a(this.f20101e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f20104h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        if (this.f20101e != null) {
            b(this.f20101e);
        }
    }

    public static synchronized e a(Context context) {
        if (b == null) {
            b = new e(context);
            b.a(new f(context));
            b.a(new b(context));
            b.a(new j(context));
            b.a(new d(context));
            b.a(new c(context));
            b.a(new g(context));
            b.a(new i());
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                b.a(new h(context));
            }
            b.f();
        }
        return b;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (f20099j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new be().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.f20100d, bArrA);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f20105i.a(aVar.b())) {
            return this.f20104h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.f20103g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f20220h)) {
            cVar.a.remove("mac");
        }
        if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f20219g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f20221i)) {
            cVar.a.remove("android_id");
        }
        if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f20222j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey(com.anythink.expressad.foundation.g.a.bj) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f20235w)) {
            cVar.a.remove(com.anythink.expressad.foundation.g.a.bj);
        }
        if (!cVar.a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }
}
