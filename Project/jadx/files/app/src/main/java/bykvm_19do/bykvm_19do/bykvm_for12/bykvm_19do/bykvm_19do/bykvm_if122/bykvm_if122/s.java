package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char[] f1230i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f1232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f1233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f1234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f1235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f1236h;

    public static final class a {
        String a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f1238d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List<String> f1241g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f1242h;
        String b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1237c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1239e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f1240f = new ArrayList();

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s$a$a, reason: collision with other inner class name */
        enum EnumC0031a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f1240f.add("");
        }

        private a a(String str, boolean z2) {
            int i2 = 0;
            do {
                int iA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i2, str.length(), "/\\");
                a(str, i2, iA, iA < str.length(), z2);
                i2 = iA + 1;
            } while (i2 <= str.length());
            return this;
        }

        private static String a(String str, int i2, int i3) {
            return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(s.a(str, i2, i3, false));
        }

        private void a(String str, int i2, int i3, boolean z2, boolean z3) {
            String strA = s.a(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z3, false, false, true, null);
            if (g(strA)) {
                return;
            }
            if (h(strA)) {
                d();
                return;
            }
            if (this.f1240f.get(r11.size() - 1).isEmpty()) {
                this.f1240f.set(r11.size() - 1, strA);
            } else {
                this.f1240f.add(strA);
            }
            if (z2) {
                this.f1240f.add("");
            }
        }

        private static int b(String str, int i2, int i3) {
            try {
                int i4 = Integer.parseInt(s.a(str, i2, i3, "", false, false, false, true, null));
                if (i4 <= 0 || i4 > 65535) {
                    return -1;
                }
                return i4;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private static int c(String str, int i2, int i3) {
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ':') {
                    return i2;
                }
                if (cCharAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void d() {
            if (!this.f1240f.remove(r0.size() - 1).isEmpty() || this.f1240f.isEmpty()) {
                this.f1240f.add("");
            } else {
                this.f1240f.set(r0.size() - 1, "");
            }
        }

        private void d(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f1240f.clear();
                this.f1240f.add("");
                i2++;
            } else {
                List<String> list = this.f1240f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i4 = i2;
                if (i4 >= i3) {
                    return;
                }
                i2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i4, i3, "/\\");
                boolean z2 = i2 < i3;
                a(str, i4, i2, z2, true);
                if (z2) {
                    i2++;
                }
            }
        }

        private static int e(String str, int i2, int i3) {
            char cCharAt;
            if (i3 - i2 >= 2 && (((cCharAt = str.charAt(i2)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int f(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private boolean g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        EnumC0031a a(s sVar, String str) {
            int iA;
            int i2;
            int i3;
            int iB = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(str, 0, str.length());
            int iC = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.c(str, iB, str.length());
            if (e(str, iB, iC) != -1) {
                if (str.regionMatches(true, iB, "https:", 0, 6)) {
                    this.a = "https";
                    iB += 6;
                } else {
                    if (!str.regionMatches(true, iB, "http:", 0, 5)) {
                        return EnumC0031a.UNSUPPORTED_SCHEME;
                    }
                    this.a = "http";
                    iB += 5;
                }
            } else {
                if (sVar == null) {
                    return EnumC0031a.MISSING_SCHEME;
                }
                this.a = sVar.a;
            }
            int iF = f(str, iB, iC);
            char c2 = '?';
            char c3 = '#';
            if (iF >= 2 || sVar == null || !sVar.a.equals(this.a)) {
                int i4 = iB + iF;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    iA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i4, iC, "@/\\?#");
                    byte bCharAt = iA != iC ? str.charAt(iA) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c3 || bCharAt == 47 || bCharAt == 92 || bCharAt == c2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z2) {
                            i3 = iA;
                            this.f1237c += "%40" + s.a(str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iA2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i4, iA, ':');
                            i3 = iA;
                            String strA = s.a(str, i4, iA2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z3) {
                                strA = this.b + "%40" + strA;
                            }
                            this.b = strA;
                            if (iA2 != i3) {
                                this.f1237c = s.a(str, iA2 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z2 = true;
                            }
                            z3 = true;
                        }
                        i4 = i3 + 1;
                        c2 = '?';
                        c3 = '#';
                    }
                }
                i2 = iA;
                int iC2 = c(str, i4, i2);
                int i5 = iC2 + 1;
                this.f1238d = a(str, i4, iC2);
                if (i5 < i2) {
                    this.f1239e = b(str, i5, i2);
                    if (this.f1239e == -1) {
                        return EnumC0031a.INVALID_PORT;
                    }
                } else {
                    this.f1239e = s.c(this.a);
                }
                if (this.f1238d == null) {
                    return EnumC0031a.INVALID_HOST;
                }
            } else {
                this.b = sVar.f();
                this.f1237c = sVar.b();
                this.f1238d = sVar.f1232d;
                this.f1239e = sVar.f1233e;
                this.f1240f.clear();
                this.f1240f.addAll(sVar.d());
                if (iB == iC || str.charAt(iB) == '#') {
                    b(sVar.e());
                }
                i2 = iB;
            }
            int iA3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i2, iC, "?#");
            d(str, i2, iA3);
            if (iA3 < iC && str.charAt(iA3) == '?') {
                int iA4 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, iA3, iC, '#');
                this.f1241g = s.e(s.a(str, iA3 + 1, iA4, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iA3 = iA4;
            }
            if (iA3 < iC && str.charAt(iA3) == '#') {
                this.f1242h = s.a(str, 1 + iA3, iC, "", true, false, false, false, null);
            }
            return EnumC0031a.SUCCESS;
        }

        public a a(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f1239e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public a a(String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f1241g == null) {
                this.f1241g = new ArrayList();
            }
            this.f1241g.add(s.a(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.f1241g.add(str2 != null ? s.a(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public s a() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f1238d != null) {
                return new s(this);
            }
            throw new IllegalStateException("host == null");
        }

        int b() {
            int i2 = this.f1239e;
            return i2 != -1 ? i2 : s.c(this.a);
        }

        public a b(String str) {
            this.f1241g = str != null ? s.e(s.a(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        a c() {
            int size = this.f1240f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1240f.set(i2, s.a(this.f1240f.get(i2), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.f1241g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f1241g.get(i3);
                    if (str != null) {
                        this.f1241g.set(i3, s.a(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.f1242h;
            if (str2 != null) {
                this.f1242h = s.a(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strA = a(str, 0, str.length());
            if (strA != null) {
                this.f1238d = strA;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a d(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f1237c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.a = str2;
            return this;
        }

        public a f(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (!this.b.isEmpty() || !this.f1237c.isEmpty()) {
                sb.append(this.b);
                if (!this.f1237c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f1237c);
                }
                sb.append('@');
            }
            if (this.f1238d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1238d);
                sb.append(']');
            } else {
                sb.append(this.f1238d);
            }
            int iB = b();
            if (iB != s.c(this.a)) {
                sb.append(':');
                sb.append(iB);
            }
            s.b(sb, this.f1240f);
            if (this.f1241g != null) {
                sb.append('?');
                s.a(sb, this.f1241g);
            }
            if (this.f1242h != null) {
                sb.append('#');
                sb.append(this.f1242h);
            }
            return sb.toString();
        }
    }

    s(a aVar) {
        this.a = aVar.a;
        this.b = a(aVar.b, false);
        this.f1231c = a(aVar.f1237c, false);
        this.f1232d = aVar.f1238d;
        this.f1233e = aVar.b();
        a(aVar.f1240f, false);
        List<String> list = aVar.f1241g;
        this.f1234f = list != null ? a(list, true) : null;
        String str = aVar.f1242h;
        this.f1235g = str != null ? a(str, false) : null;
        this.f1236h = aVar.toString();
    }

    static String a(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        int iCharCount = i2;
        while (iCharCount < i3) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z5)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                cVar.a(str, i2, iCharCount);
                a(cVar, str, iCharCount, i3, str2, z2, z3, z4, z5, charset);
                return cVar.n();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z2 || (z3 && !a(str, iCharCount, i3)))) || (iCodePointAt == 43 && z4))) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                cVar2.a(str, i2, iCharCount);
                a(cVar2, str, iCharCount, i3, str2, z2, z3, z4, z5, charset);
                return cVar2.n();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i2, i3);
    }

    static String a(String str, int i2, int i3, boolean z2) {
        for (int i4 = i2; i4 < i3; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z2);
                return cVar.n();
            }
        }
        return str.substring(i2, i3);
    }

    static String a(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5) {
        return a(str, 0, str.length(), str2, z2, z3, z4, z5, null);
    }

    static String a(String str, boolean z2) {
        return a(str, 0, str.length(), z2);
    }

    private List<String> a(List<String> list, boolean z2) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z2) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z4) {
                    cVar.a(z2 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z5) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z2 || (z3 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                    }
                    if (charset == null || charset.equals(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1149i)) {
                        cVar2.c(iCodePointAt);
                    } else {
                        cVar2.a(str, i2, Character.charCount(iCodePointAt) + i2, charset);
                    }
                    while (!cVar2.f()) {
                        int i4 = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) f1230i[(i4 >> 4) & 15]);
                        cVar.writeByte((int) f1230i[i4 & 15]);
                    }
                } else {
                    cVar.c(iCodePointAt);
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r2)
            char r3 = r6.charAt(r1)
            int r3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.c(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c, java.lang.String, int, int, boolean):void");
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i2 + 1)) != -1 && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i4)) != -1;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.PORT;
        }
        return -1;
    }

    public static s d(String str) {
        a aVar = new a();
        if (aVar.a((s) null, str) == a.EnumC0031a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    static List<String> e(String str) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iIndexOf = str.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i2);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i2, iIndexOf));
                strSubstring = null;
            } else {
                arrayList.add(str.substring(i2, iIndexOf2));
                strSubstring = str.substring(iIndexOf2 + 1, iIndexOf);
            }
            arrayList.add(strSubstring);
            i2 = iIndexOf + 1;
        }
        return arrayList;
    }

    public a a(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0031a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String a() {
        if (this.f1235g == null) {
            return null;
        }
        return this.f1236h.substring(this.f1236h.indexOf(35) + 1);
    }

    public s b(String str) {
        a aVarA = a(str);
        if (aVarA != null) {
            return aVarA.a();
        }
        return null;
    }

    public String b() {
        if (this.f1231c.isEmpty()) {
            return "";
        }
        int iIndexOf = this.f1236h.indexOf(58, this.a.length() + 3);
        return this.f1236h.substring(iIndexOf + 1, this.f1236h.indexOf(64));
    }

    public String c() {
        int iIndexOf = this.f1236h.indexOf(47, this.a.length() + 3);
        String str = this.f1236h;
        return this.f1236h.substring(iIndexOf, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, iIndexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int iIndexOf = this.f1236h.indexOf(47, this.a.length() + 3);
        String str = this.f1236h;
        int iA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i2 = iIndexOf + 1;
            int iA2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1236h, i2, iA, '/');
            arrayList.add(this.f1236h.substring(i2, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    public String e() {
        if (this.f1234f == null) {
            return null;
        }
        int iIndexOf = this.f1236h.indexOf(63) + 1;
        String str = this.f1236h;
        return this.f1236h.substring(iIndexOf, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, iIndexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f1236h.equals(this.f1236h);
    }

    public String f() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.f1236h;
        return this.f1236h.substring(length, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f1232d;
    }

    public boolean h() {
        return this.a.equals("https");
    }

    public int hashCode() {
        return this.f1236h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = f();
        aVar.f1237c = b();
        aVar.f1238d = this.f1232d;
        aVar.f1239e = this.f1233e != c(this.a) ? this.f1233e : -1;
        aVar.f1240f.clear();
        aVar.f1240f.addAll(d());
        aVar.b(e());
        aVar.f1242h = a();
        return aVar;
    }

    public int j() {
        return this.f1233e;
    }

    public String k() {
        if (this.f1234f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f1234f);
        return sb.toString();
    }

    public String l() {
        return a("/...").f("").d("").a().toString();
    }

    public String m() {
        return this.a;
    }

    public URI n() {
        String string = i().c().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL o() {
        try {
            return new URL(this.f1236h);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.f1236h;
    }
}
