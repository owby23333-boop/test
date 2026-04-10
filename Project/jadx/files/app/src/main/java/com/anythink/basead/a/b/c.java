package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.core.common.a.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final int a = 0;
    public static final int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5793c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, Integer> f5794d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, MraidWebView> f5795e = new ConcurrentHashMap<>(3);

    public static boolean a(String str) {
        Integer num = f5794d.get(str);
        return num != null && num.intValue() == 0;
    }

    public static MraidWebView b(String str) {
        return f5795e.remove(str);
    }

    public static boolean c(String str) {
        String strA = com.anythink.core.common.k.f.a(str);
        com.anythink.core.common.res.d dVarA = com.anythink.core.common.res.d.a(n.a().g());
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return new File(dVarA.a(1) + File.separator + strA + ".0").exists();
    }

    public static boolean b(String str, int i2) {
        return j.a().a(str, i2);
    }

    public static void a(String str, int i2) {
        Integer num = f5794d.get(str);
        if (num == null || num.intValue() < i2) {
            f5794d.put(str, Integer.valueOf(i2));
        }
    }

    public static void a(String str, MraidWebView mraidWebView) {
        f5795e.put(str, mraidWebView);
    }

    public static String a(com.anythink.core.common.e.j jVar, i iVar) {
        return jVar.f7303d + "_" + iVar.p();
    }

    public static boolean a(i iVar, com.anythink.core.common.e.j jVar) {
        k kVar;
        boolean zA;
        if (iVar == null || !(zA = a(iVar, jVar.f7309j, (kVar = jVar.f7312m)))) {
            return false;
        }
        if (!iVar.g()) {
            return zA;
        }
        if (kVar.V()) {
            return f5795e.containsKey(a(jVar, iVar));
        }
        return true;
    }

    public static boolean a(i iVar, int i2, k kVar) {
        if (TextUtils.equals(String.valueOf(i2), "1")) {
            if (TextUtils.isEmpty(iVar.x())) {
                return false;
            }
            return b(iVar.x(), kVar.S());
        }
        if (!TextUtils.equals(String.valueOf(i2), "3") || TextUtils.isEmpty(iVar.x())) {
            return true;
        }
        return b(iVar.x(), kVar.S());
    }
}
