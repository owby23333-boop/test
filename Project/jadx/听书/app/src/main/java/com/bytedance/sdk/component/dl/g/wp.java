package com.bytedance.sdk.component.dl.g;

import com.funny.audio.core.utils.FileUtils;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class wp {
    private final long e;
    private final String fo;
    private final String gc;
    private final String gz;
    private final boolean i;
    private final boolean kb;
    private final String m;
    private final boolean uy;
    private final boolean wp;
    private static final Pattern z = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern g = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern dl = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f648a = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private wp(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.gc = str;
        this.m = str2;
        this.e = j;
        this.gz = str3;
        this.fo = str4;
        this.uy = z2;
        this.kb = z3;
        this.i = z4;
        this.wp = z5;
    }

    public String z() {
        return this.gc;
    }

    public String g() {
        return this.m;
    }

    private static boolean z(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.dl.g.z.dl.dl(str);
    }

    public static wp z(js jsVar, String str) {
        return z(System.currentTimeMillis(), jsVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.bytedance.sdk.component.dl.g.wp z(long r23, com.bytedance.sdk.component.dl.g.js r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.wp.z(long, com.bytedance.sdk.component.dl.g.js, java.lang.String):com.bytedance.sdk.component.dl.g.wp");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long z(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.wp.z(java.lang.String, int, int):long");
    }

    private static int z(String str, int i, int i2, boolean z2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z2)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long z(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    private static String g(String str) {
        if (str.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            str = str.substring(1);
        }
        String strZ = com.bytedance.sdk.component.dl.g.z.dl.z(str);
        if (strZ != null) {
            return strZ;
        }
        throw new IllegalArgumentException();
    }

    public static List<wp> z(js jsVar, fv fvVar) {
        List<String> listG = fvVar.g(HttpHeaders.SET_COOKIE);
        int size = listG.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            wp wpVarZ = z(jsVar, listG.get(i));
            if (wpVarZ != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(wpVarZ);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return z(false);
    }

    String z(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.gc);
        sb.append('=');
        sb.append(this.m);
        if (this.wp) {
            if (this.e == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.bytedance.sdk.component.dl.g.z.dl.a.z(new Date(this.e)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z2) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            sb.append(this.gz);
        }
        sb.append("; path=").append(this.fo);
        if (this.uy) {
            sb.append("; secure");
        }
        if (this.kb) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wp)) {
            return false;
        }
        wp wpVar = (wp) obj;
        return wpVar.gc.equals(this.gc) && wpVar.m.equals(this.m) && wpVar.gz.equals(this.gz) && wpVar.fo.equals(this.fo) && wpVar.e == this.e && wpVar.uy == this.uy && wpVar.kb == this.kb && wpVar.wp == this.wp && wpVar.i == this.i;
    }

    public int hashCode() {
        int iHashCode = (((((((this.gc.hashCode() + 527) * 31) + this.m.hashCode()) * 31) + this.gz.hashCode()) * 31) + this.fo.hashCode()) * 31;
        long j = this.e;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.uy ? 1 : 0)) * 31) + (!this.kb ? 1 : 0)) * 31) + (!this.wp ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }
}
