package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static final int a = 3;
    private static q b = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f16760g = "1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f16761c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Cdo f16762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f16763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private t f16764f;

    private q(Context context) {
        this.f16763e = context;
        this.f16762d = Cdo.a(context);
        this.f16764f = t.a(context);
    }

    public static synchronized q a(Context context) {
        try {
            if (b == null) {
                b = new q(context);
            }
        } catch (Exception unused) {
            return null;
        }
        return b;
    }

    private synchronized boolean a(int i2, String str, String str2, boolean z2, PackageInfo packageInfo) {
        if (z2) {
            if (this.f16764f.c(i2) != 1) {
                return false;
            }
        }
        s sVarA = this.f16764f.a(i2);
        if (sVarA == null) {
            this.f16764f.b(i2, -1);
            HashMap map = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            map.put("pk", sb.toString());
            map.put("pv", str);
            map.put(com.anythink.core.c.e.a, cj.f16638m);
            bg.a(this.f16763e, "1002001", map);
            return false;
        }
        if (!dm.a(new File(sVarA.f16775e))) {
            this.f16764f.b(i2, -1);
            HashMap map2 = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            map2.put("pk", sb2.toString());
            map2.put("pv", str);
            map2.put(com.anythink.core.c.e.a, cj.f16639n);
            map2.put("l", "CBH");
            bg.a(this.f16763e, "1002001", map2);
            return false;
        }
        if (packageInfo != null) {
            sVarA.f16788r = packageInfo;
        }
        r rVarA = r.a(this.f16763e.getApplicationContext(), true);
        if (rVarA.a(sVarA, false)) {
            s sVarC = rVarA.c(sVarA.f16775e);
            sVarC.b = 1;
            sVarC.f16786p = 1;
            this.f16764f.a(sVarC);
            return true;
        }
        this.f16764f.b(i2, -1);
        rVarA.a(sVarA.f16775e);
        HashMap map3 = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i2);
        map3.put("pk", sb3.toString());
        map3.put("pv", str);
        map3.put(com.anythink.core.c.e.a, cj.f16640o);
        map3.put("l", "CBH");
        bg.a(this.f16763e, "1002001", map3);
        return false;
    }

    private static void d() {
        try {
            Cdo cdoA = Cdo.a();
            if (cdoA != null) {
                cdoA.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        d();
        b();
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r rVarA;
                    try {
                        if (TextUtils.isEmpty(str) || (rVarA = r.a(q.this.f16763e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        final s sVarD = rVarA.d(str);
                        if (sVarD == null) {
                            s sVarB = q.this.f16764f.b(str);
                            if (sVarB != null) {
                                q.this.a(str, sVarB.f16775e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                rVarA.b(str);
                                q.this.f16764f.a(str);
                                File file = new File(sVarD.f16775e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, TTAdConstant.AD_MAX_EVENT_TIME);
                        rVarA.b(str);
                        q.this.f16764f.a(str);
                        File file = new File(sVarD.f16775e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f16764f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        return a(i2, str, null, false, packageInfo);
    }

    public boolean a(s sVar, String str, String str2) {
        s sVarC;
        r rVarA;
        HashMap map;
        String str3;
        if (sVar == null) {
            map = new HashMap();
            str3 = cj.f16643r;
        } else {
            File file = new File(sVar.f16775e);
            if (dm.a(file)) {
                try {
                    if (!this.f16764f.b(sVar.a)) {
                        this.f16764f.a(sVar);
                    }
                    rVarA = r.a(this.f16763e.getApplicationContext(), true);
                    this.f16764f.a(sVar.a, 1);
                    b(sVar.f16773c);
                } catch (Throwable unused) {
                    sVarC = sVar;
                }
                if (!rVarA.a(sVar, true)) {
                    file.delete();
                    a(sVar.a, sVar.f16774d, null, true, null);
                    this.f16764f.a(sVar.a, 0);
                    HashMap map2 = new HashMap();
                    map2.put(com.anythink.core.c.e.a, cj.f16646u);
                    map2.put("l", "CBH");
                    map2.put("apk", sVar.toString());
                    bg.a(this.f16763e, "1002001", map2);
                    return false;
                }
                sVarC = rVarA.c(sVar.f16775e);
                if (sVarC == null) {
                    try {
                        this.f16764f.a(sVarC.a, 0);
                        HashMap map3 = new HashMap();
                        map3.put(com.anythink.core.c.e.a, cj.f16644s);
                        map3.put("l", "CBH");
                        bg.a(this.f16763e, "1002001", map3);
                        return false;
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    s sVarA = this.f16764f.a(sVarC.a);
                    File file2 = null;
                    if (sVarA != null && !sVarA.f16774d.equals(sVarC.f16774d)) {
                        file2 = new File(sVarA.f16775e);
                    }
                    sVarC.b = 1;
                    sVarC.f16786p = 1;
                    if (this.f16764f.a(sVarC) > 0 && file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    this.f16764f.a(sVarC.a, 0);
                    return true;
                } catch (Throwable unused3) {
                    return false;
                }
            }
            map = new HashMap();
            str3 = cj.f16645t;
        }
        map.put(com.anythink.core.c.e.a, str3);
        map.put("l", "CBH");
        bg.a(this.f16763e, "1002001", map);
        return false;
    }

    public synchronized void b() {
        try {
            if (this.f16761c) {
                return;
            }
            this.f16761c = true;
            for (s sVar : this.f16764f.a()) {
                String canonicalPath = null;
                try {
                    canonicalPath = this.f16763e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                }
                if (canonicalPath != null) {
                    sVar.f16783m = canonicalPath + bh.f16571j + sVar.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.f16783m);
                    sb.append("/lib");
                    dm.c(sb.toString());
                    dm.b(sVar.f16783m);
                }
            }
            this.f16764f.b();
            if (this.f16762d.b(Cdo.f16710d)) {
                this.f16764f.c();
            } else {
                this.f16762d.a(Cdo.f16710d, Boolean.TRUE, true);
            }
            n.a().a(new u(this.f16763e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        r rVarA;
        try {
            if (TextUtils.isEmpty(str) || (rVarA = r.a()) == null) {
                return;
            }
            rVarA.b(str);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        for (s sVar : this.f16764f.a()) {
            r rVarA = r.a();
            if ((rVarA != null ? rVarA.d(sVar.f16773c) : null) == null) {
                a(sVar.a, sVar.f16774d, (PackageInfo) null);
            }
        }
    }
}
