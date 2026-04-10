package com.anythink.expressad.videocommon.a;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12131c = "com.anythink.expressad.videocommon.a.a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f12132d;

    private a() {
        try {
            n.a().g();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        if (f12132d == null) {
            synchronized (a.class) {
                if (f12132d == null) {
                    f12132d = new a();
                }
            }
        }
        return f12132d;
    }

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    private static void e() {
    }

    private static void f() {
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        }
    }

    public static boolean a(c cVar) {
        try {
            com.anythink.expressad.videocommon.e.a aVarB = com.anythink.expressad.videocommon.e.c.a().b();
            long jC = aVarB != null ? aVarB.c() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (cVar != null) {
                long jO = cVar.o() * 1000;
                long jBg = jCurrentTimeMillis - cVar.bg();
                if (jO > 0 && jO >= jBg) {
                    return false;
                }
                if (jO <= 0 && jC >= jBg) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static List<c> a(List<c> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.anythink.expressad.videocommon.e.a aVarB = com.anythink.expressad.videocommon.e.c.a().b();
            long jC = aVarB != null ? aVarB.c() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (c cVar : list) {
                    if (cVar != null) {
                        long jO = cVar.o() * 1000;
                        long jBg = jCurrentTimeMillis - cVar.bg();
                        if ((jO > 0 && jO >= jBg) || (jO <= 0 && jC >= jBg)) {
                            arrayList2.add(cVar);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e2) {
                e = e2;
                arrayList = arrayList2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
        return arrayList;
    }
}
