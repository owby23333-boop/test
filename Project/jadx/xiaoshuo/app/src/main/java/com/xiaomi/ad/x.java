package com.xiaomi.ad;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.ad.common.util.AppEnv;
import com.xiaomi.ad.common.util.ExecutorUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.m;
import com.xiaomi.ad.mediation.internal.config.IMediationConfigInitListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class x implements m.d<v> {
    public static final String f = "MediationConfigModel";
    public static volatile x g = null;
    public static final String h = "mi_mediation_sdk_files";
    public static final String i = "config.json";
    public static String j = "";
    public static boolean k = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f7305b;
    public Context c;
    public IMediationConfigInitListener e;
    public y d = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<w> f7304a = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            File filesDirFile = AppEnv.getFilesDirFile(x.this.c, x.h, x.i);
            if (filesDirFile.exists()) {
                String strA = e.a(filesDirFile);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                v vVarD = v.d(strA);
                MLog.d(x.f, "Read cached config " + strA);
                if (vVarD != null) {
                    if (x.this.f7305b == null) {
                        x.this.f7305b = vVarD;
                    }
                    if (x.k || x.this.e == null) {
                        return;
                    }
                    boolean unused = x.k = true;
                    x.this.e.onSuccess();
                }
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f7307a;

        public b(v vVar) {
            this.f7307a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            File filesDirFile = AppEnv.getFilesDirFile(x.this.c, x.h, x.i);
            String strB = this.f7307a.b();
            MLog.d(x.f, "Save config to cache");
            e.a(strB, filesDirFile);
        }
    }

    public x(Context context) {
        this.c = context.getApplicationContext();
        b();
        c();
    }

    public static x f() {
        return g;
    }

    public void d() {
        this.d = new y();
    }

    public v a() {
        return this.f7305b;
    }

    public void b() {
        ExecutorUtils.THREAD_POOL_EXECUTOR.submit(new a());
    }

    public void c() {
        MLog.d(f, "Start to refresh config");
        if (this.d.e()) {
            MLog.w(f, "Config has been refreshing already");
            return;
        }
        this.d.a((m.d) this);
        if (!TextUtils.isEmpty(j)) {
            this.d.b(j);
        }
        this.d.b(this.c);
    }

    private void c(v vVar) {
        ExecutorUtils.THREAD_POOL_EXECUTOR.submit(new b(vVar));
    }

    @Override // com.xiaomi.ad.m.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(v vVar) {
        IMediationConfigInitListener iMediationConfigInitListener;
        MLog.d(f, "Success to get remote config");
        if (vVar.a()) {
            a2(vVar);
            this.f7305b = vVar;
            c(vVar);
            if (k || (iMediationConfigInitListener = this.e) == null) {
                return;
            }
            k = true;
            iMediationConfigInitListener.onSuccess();
        }
    }

    @Override // com.xiaomi.ad.m.d
    public void a(int i2) {
        IMediationConfigInitListener iMediationConfigInitListener;
        MLog.e(f, "Failed to get remote config " + i2);
        if (k || (iMediationConfigInitListener = this.e) == null) {
            return;
        }
        k = true;
        iMediationConfigInitListener.onFailed(i2);
    }

    public static void a(Context context) {
        if (g == null) {
            synchronized (x.class) {
                if (g == null) {
                    g = new x(context);
                }
            }
        }
    }

    public static void a(Context context, String str, IMediationConfigInitListener iMediationConfigInitListener) {
        k = false;
        if (g != null) {
            g.c();
            return;
        }
        synchronized (x.class) {
            if (g == null) {
                j = str;
                g = new x(context);
                g.a(iMediationConfigInitListener);
            }
        }
    }

    public void a(IMediationConfigInitListener iMediationConfigInitListener) {
        this.e = iMediationConfigInitListener;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(v vVar) {
        List<w> list = this.f7304a;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<w> it = this.f7304a.iterator();
        while (it.hasNext()) {
            it.next().a(vVar);
        }
    }

    public void a(w wVar) {
        if (wVar != null) {
            this.f7304a.add(wVar);
        }
    }
}
