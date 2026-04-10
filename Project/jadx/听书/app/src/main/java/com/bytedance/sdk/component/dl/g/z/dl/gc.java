package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.fv;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.i;
import com.bytedance.sdk.component.dl.g.js;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class gc {
    private static final Pattern z = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long z(h hVar) {
        return z(hVar.e());
    }

    public static long z(fv fvVar) {
        return z(fvVar.z(HttpHeaders.CONTENT_LENGTH));
    }

    private static long z(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> g(fv fvVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iZ = fvVar.z();
        for (int i = 0; i < iZ; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(fvVar.z(i))) {
                String strG = fvVar.g(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strG.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static fv g(h hVar) {
        return z(hVar.uy().z().dl(), hVar.e());
    }

    public static fv z(fv fvVar, fv fvVar2) {
        Set<String> setG = g(fvVar2);
        if (setG.isEmpty()) {
            return new fv.z().z();
        }
        fv.z zVar = new fv.z();
        int iZ = fvVar.z();
        for (int i = 0; i < iZ; i++) {
            String strZ = fvVar.z(i);
            if (setG.contains(strZ)) {
                zVar.z(strZ, fvVar.g(i));
            }
        }
        return zVar.z();
    }

    public static void z(i iVar, js jsVar, fv fvVar) {
        if (iVar == i.z) {
            return;
        }
        com.bytedance.sdk.component.dl.g.wp.z(jsVar, fvVar).isEmpty();
    }

    public static boolean dl(h hVar) {
        if (hVar.z().g().equals("HEAD")) {
            return false;
        }
        int iDl = hVar.dl();
        return (((iDl >= 100 && iDl < 200) || iDl == 204 || iDl == 304) && z(hVar) == -1 && !"chunked".equalsIgnoreCase(hVar.z(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static int z(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int z(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int g(String str, int i) {
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
}
