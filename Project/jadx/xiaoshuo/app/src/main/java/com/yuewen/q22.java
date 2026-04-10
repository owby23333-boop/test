package com.yuewen;

import com.duokan.adbridge.bean.CommonAdInfo;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class q22 {
    public static void a(String str, q6 q6Var) {
        v72.m().i(str, q6Var);
    }

    public static void b(String[] strArr, String[] strArr2, yo1 yo1Var) {
        v72.m().k(strArr, strArr2, yo1Var);
    }

    public static int c() {
        return v72.m().r();
    }

    public static int d() {
        return v72.m().s();
    }

    public static String e() {
        return "";
    }

    public static void f(com.duokan.reader.domain.bookshelf.b bVar) {
        v72.m().z(bVar);
    }

    public static void g(String str, q6 q6Var) {
        v72.m().A(str, q6Var);
    }

    public static void h() {
        v72.m().B();
    }

    public static void i() {
        v72.m();
    }

    public static boolean j() {
        return new sf2().a();
    }

    public static void k(CommonAdInfo commonAdInfo, String str) {
        if (commonAdInfo == null || commonAdInfo.m == null || !v72.m().j(commonAdInfo.m)) {
            return;
        }
        v72.m().x().n(str, null, commonAdInfo.q, commonAdInfo);
    }

    public static void l(CommonAdInfo commonAdInfo, String str, List<String> list) {
        if (commonAdInfo == null) {
            return;
        }
        if (commonAdInfo.m == null || !v72.m().j(commonAdInfo.m)) {
            v72.m().x().m(str, list, commonAdInfo.q, commonAdInfo);
        } else {
            v72.m().x().n(str, list, commonAdInfo.q, commonAdInfo);
        }
    }

    public static void m(j8 j8Var) {
    }

    public static void n(CommonAdInfo commonAdInfo) {
    }
}
