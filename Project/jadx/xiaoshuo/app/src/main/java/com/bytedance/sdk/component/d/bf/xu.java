package com.bytedance.sdk.component.d.bf;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class xu {
    private final boolean bh;
    private final String ga;
    private final boolean m;
    private final long p;
    private final String v;
    private final String vn;
    private final boolean wu;
    private final boolean xu;
    private final String zk;
    private static final Pattern e = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern bf = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern d = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern tg = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private xu(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.ga = str;
        this.vn = str2;
        this.p = j;
        this.v = str3;
        this.zk = str4;
        this.m = z;
        this.wu = z2;
        this.bh = z3;
        this.xu = z4;
    }

    public String bf() {
        return this.vn;
    }

    public String e() {
        return this.ga;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xu)) {
            return false;
        }
        xu xuVar = (xu) obj;
        return xuVar.ga.equals(this.ga) && xuVar.vn.equals(this.vn) && xuVar.v.equals(this.v) && xuVar.zk.equals(this.zk) && xuVar.p == this.p && xuVar.m == this.m && xuVar.wu == this.wu && xuVar.xu == this.xu && xuVar.bh == this.bh;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.ga.hashCode()) * 31) + this.vn.hashCode()) * 31) + this.v.hashCode()) * 31) + this.zk.hashCode()) * 31;
        long j = this.p;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.m ? 1 : 0)) * 31) + (!this.wu ? 1 : 0)) * 31) + (!this.xu ? 1 : 0)) * 31) + (!this.bh ? 1 : 0);
    }

    public String toString() {
        return e(false);
    }

    private static String bf(String str) {
        if (str.endsWith(Consts.DOT)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(Consts.DOT)) {
            str = str.substring(1);
        }
        String strE = com.bytedance.sdk.component.d.bf.e.d.e(str);
        if (strE != null) {
            return strE;
        }
        throw new IllegalArgumentException();
    }

    private static boolean e(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.d.bf.e.d.d(str);
    }

    public static xu e(k kVar, String str) {
        return e(System.currentTimeMillis(), kVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.d.bf.xu e(long r23, com.bytedance.sdk.component.d.bf.k r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.xu.e(long, com.bytedance.sdk.component.d.bf.k, java.lang.String):com.bytedance.sdk.component.d.bf.xu");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long e(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.xu.e(java.lang.String, int, int):long");
    }

    private static int e(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long e(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    public static List<xu> e(k kVar, f fVar) {
        List<String> listBf = fVar.bf(HttpHeaders.SET_COOKIE);
        int size = listBf.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            xu xuVarE = e(kVar, listBf.get(i));
            if (xuVarE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(xuVarE);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String e(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ga);
        sb.append(com.alipay.sdk.m.p.a.h);
        sb.append(this.vn);
        if (this.xu) {
            if (this.p == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.component.d.bf.e.d.tg.e(new Date(this.p)));
            }
        }
        if (!this.bh) {
            sb.append("; domain=");
            if (z) {
                sb.append(Consts.DOT);
            }
            sb.append(this.v);
        }
        sb.append("; path=");
        sb.append(this.zk);
        if (this.m) {
            sb.append("; secure");
        }
        if (this.wu) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
