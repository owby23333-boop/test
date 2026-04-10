package com.bytedance.sdk.component.d.bf.e.d;

import com.bytedance.sdk.component.d.bf.bh;
import com.bytedance.sdk.component.d.bf.f;
import com.bytedance.sdk.component.d.bf.k;
import com.bytedance.sdk.component.d.bf.uk;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class ga {
    private static final Pattern e = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static Set<String> bf(f fVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iE = fVar.e();
        for (int i = 0; i < iE; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(fVar.e(i))) {
                String strBf = fVar.bf(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strBf.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static boolean d(uk ukVar) {
        if (ukVar.e().bf().equals("HEAD")) {
            return false;
        }
        int iD = ukVar.d();
        return (((iD >= 100 && iD < 200) || iD == 204 || iD == 304) && e(ukVar) == -1 && !"chunked".equalsIgnoreCase(ukVar.e(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static long e(uk ukVar) {
        return e(ukVar.p());
    }

    public static long e(f fVar) {
        return e(fVar.e("Content-Length"));
    }

    private static long e(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static f e(f fVar, f fVar2) {
        Set<String> setBf = bf(fVar2);
        if (setBf.isEmpty()) {
            return new f.e().e();
        }
        f.e eVar = new f.e();
        int iE = fVar.e();
        for (int i = 0; i < iE; i++) {
            String strE = fVar.e(i);
            if (setBf.contains(strE)) {
                eVar.e(strE, fVar.bf(i));
            }
        }
        return eVar.e();
    }

    public static f bf(uk ukVar) {
        return e(ukVar.m().e().d(), ukVar.p());
    }

    public static int bf(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void e(bh bhVar, k kVar, f fVar) {
        if (bhVar == bh.e) {
            return;
        }
        List<com.bytedance.sdk.component.d.bf.xu> listE = com.bytedance.sdk.component.d.bf.xu.e(kVar, fVar);
        if (listE.isEmpty()) {
            return;
        }
        bhVar.e(kVar, listE);
    }

    public static int e(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int e(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }
}
