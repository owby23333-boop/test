package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f1212j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f1213k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f1214l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f1215m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f1216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f1218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f1220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f1221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f1222i;

    private l(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = str;
        this.b = str2;
        this.f1216c = j2;
        this.f1217d = str3;
        this.f1218e = str4;
        this.f1219f = z2;
        this.f1220g = z3;
        this.f1222i = z4;
        this.f1221h = z5;
    }

    private static int a(String str, int i2, int i3, boolean z2) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z2)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str, int i2, int i3) {
        int iA = a(str, i2, i3, false);
        Matcher matcher = f1215m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int iIndexOf = -1;
        int i7 = -1;
        int i8 = -1;
        while (iA < i3) {
            int iA2 = a(str, iA + 1, i3, true);
            matcher.region(iA, iA2);
            if (i5 == -1 && matcher.usePattern(f1215m).matches()) {
                int i9 = Integer.parseInt(matcher.group(1));
                int i10 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
                i8 = i10;
                i5 = i9;
            } else if (i6 == -1 && matcher.usePattern(f1214l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1 && matcher.usePattern(f1213k).matches()) {
                iIndexOf = f1213k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f1212j).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            iA = a(str, iA2 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        }
        if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1154n);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i4);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i6);
        gregorianCalendar.set(11, i5);
        gregorianCalendar.set(12, i8);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00be A[PHI: r0
  0x00be: PHI (r0v14 long) = (r0v1 long), (r0v4 long) binds: [B:42:0x00bc, B:53:0x00e4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l a(long r23, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l.a(long, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s, java.lang.String):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l");
    }

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    private static String a(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str);
        if (strA != null) {
            return strA;
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> listB = rVar.b(HttpConstant.SET_COOKIE);
        int size = listB.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l lVarA = a(sVar, listB.get(i2));
            if (lVarA != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lVarA);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.d(str);
    }

    private static long b(String str) {
        long j2;
        try {
            j2 = Long.parseLong(str);
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            }
            if (!str.startsWith("-")) {
                return Long.MAX_VALUE;
            }
        }
        if (j2 <= 0) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public String a() {
        return this.a;
    }

    String a(boolean z2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('=');
        sb.append(this.b);
        if (this.f1221h) {
            if (this.f1216c == Long.MIN_VALUE) {
                strA = "; max-age=0";
            } else {
                sb.append("; expires=");
                strA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(new Date(this.f1216c));
            }
            sb.append(strA);
        }
        if (!this.f1222i) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(this.f1217d);
        }
        sb.append("; path=");
        sb.append(this.f1218e);
        if (this.f1219f) {
            sb.append("; secure");
        }
        if (this.f1220g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.a.equals(this.a) && lVar.b.equals(this.b) && lVar.f1217d.equals(this.f1217d) && lVar.f1218e.equals(this.f1218e) && lVar.f1216c == this.f1216c && lVar.f1219f == this.f1219f && lVar.f1220g == this.f1220g && lVar.f1221h == this.f1221h && lVar.f1222i == this.f1222i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        int iHashCode2 = this.b.hashCode();
        int iHashCode3 = this.f1217d.hashCode();
        int iHashCode4 = this.f1218e.hashCode();
        long j2 = this.f1216c;
        return ((((((((((((((((iHashCode + 527) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + (!this.f1219f ? 1 : 0)) * 31) + (!this.f1220g ? 1 : 0)) * 31) + (!this.f1221h ? 1 : 0)) * 31) + (!this.f1222i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }
}
