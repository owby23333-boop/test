package com.bytedance.sdk.component.dl.g;

import com.funny.audio.core.utils.FileUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f634a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final int dl;
    private final List<String> e;
    private final String fo;
    final String g;
    private final String gc;
    private final List<String> gz;
    private final String m;
    private final String uy;
    final String z;

    js(z zVar) {
        this.z = zVar.z;
        this.gc = z(zVar.g, false);
        this.m = z(zVar.dl, false);
        this.g = zVar.f635a;
        this.dl = zVar.z();
        this.e = z(zVar.m, false);
        this.gz = zVar.e != null ? z(zVar.e, true) : null;
        this.fo = zVar.gz != null ? z(zVar.gz, false) : null;
        this.uy = zVar.toString();
    }

    public URL z() {
        try {
            return new URL(this.uy);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI g() {
        String string = v().g().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String dl() {
        return this.z;
    }

    public boolean a() {
        return this.z.equals("https");
    }

    public String gc() {
        if (this.gc.isEmpty()) {
            return "";
        }
        int length = this.z.length() + 3;
        String str = this.uy;
        return this.uy.substring(length, com.bytedance.sdk.component.dl.g.z.dl.z(str, length, str.length(), ":@"));
    }

    public String m() {
        if (this.m.isEmpty()) {
            return "";
        }
        return this.uy.substring(this.uy.indexOf(58, this.z.length() + 3) + 1, this.uy.indexOf(64));
    }

    public String e() {
        return this.g;
    }

    public int gz() {
        return this.dl;
    }

    public static int z(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String fo() {
        int iIndexOf = this.uy.indexOf(47, this.z.length() + 3);
        String str = this.uy;
        return this.uy.substring(iIndexOf, com.bytedance.sdk.component.dl.g.z.dl.z(str, iIndexOf, str.length(), "?#"));
    }

    static void z(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> uy() {
        int iIndexOf = this.uy.indexOf(47, this.z.length() + 3);
        String str = this.uy;
        int iZ = com.bytedance.sdk.component.dl.g.z.dl.z(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iZ) {
            int i = iIndexOf + 1;
            int iZ2 = com.bytedance.sdk.component.dl.g.z.dl.z(this.uy, i, iZ, '/');
            arrayList.add(this.uy.substring(i, iZ2));
            iIndexOf = iZ2;
        }
        return arrayList;
    }

    public String kb() {
        if (this.gz == null) {
            return null;
        }
        int iIndexOf = this.uy.indexOf(63) + 1;
        String str = this.uy;
        return this.uy.substring(iIndexOf, com.bytedance.sdk.component.dl.g.z.dl.z(str, iIndexOf, str.length(), '#'));
    }

    static void g(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> g(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.gz == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        g(sb, this.gz);
        return sb.toString();
    }

    public String wp() {
        if (this.fo == null) {
            return null;
        }
        return this.uy.substring(this.uy.indexOf(35) + 1);
    }

    public String i() {
        return a("/...").g("").dl("").dl().toString();
    }

    public js dl(String str) {
        z zVarA = a(str);
        if (zVarA != null) {
            return zVarA.dl();
        }
        return null;
    }

    public z v() {
        z zVar = new z();
        zVar.z = this.z;
        zVar.g = gc();
        zVar.dl = m();
        zVar.f635a = this.g;
        zVar.gc = this.dl != z(this.z) ? this.dl : -1;
        zVar.m.clear();
        zVar.m.addAll(uy());
        zVar.gc(kb());
        zVar.gz = wp();
        return zVar;
    }

    public z a(String str) {
        z zVar = new z();
        if (zVar.z(this, str) == z.EnumC0126z.SUCCESS) {
            return zVar;
        }
        return null;
    }

    public static js gc(String str) {
        z zVar = new z();
        if (zVar.z(null, str) == z.EnumC0126z.SUCCESS) {
            return zVar.dl();
        }
        return null;
    }

    public static js z(URL url) {
        return gc(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof js) && ((js) obj).uy.equals(this.uy);
    }

    public int hashCode() {
        return this.uy.hashCode();
    }

    public String toString() {
        return this.uy;
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f635a;
        List<String> e;
        String gz;
        final List<String> m;
        String z;
        String g = "";
        String dl = "";
        int gc = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.dl.g.js$z$z, reason: collision with other inner class name */
        enum EnumC0126z {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public z() {
            ArrayList arrayList = new ArrayList();
            this.m = arrayList;
            arrayList.add("");
        }

        public z z(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.z = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.z = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public z g(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.g = js.z(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public z dl(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.dl = js.z(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public z a(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strGc = gc(str, 0, str.length());
            if (strGc == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f635a = strGc;
            return this;
        }

        public z z(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.gc = i;
            return this;
        }

        int z() {
            int i = this.gc;
            return i != -1 ? i : js.z(this.z);
        }

        public z query(String str) {
            this.e = str != null ? js.g(js.z(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public z gc(String str) {
            this.e = str != null ? js.g(js.z(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        z g() {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                this.m.set(i, js.z(this.m.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.e;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.e.get(i2);
                    if (str != null) {
                        this.e.set(i2, js.z(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.gz;
            if (str2 != null) {
                this.gz = js.z(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public js dl() {
            if (this.z == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f635a == null) {
                throw new IllegalStateException("host == null");
            }
            return new js(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.z);
            sb.append("://");
            if (!this.g.isEmpty() || !this.dl.isEmpty()) {
                sb.append(this.g);
                if (!this.dl.isEmpty()) {
                    sb.append(':');
                    sb.append(this.dl);
                }
                sb.append('@');
            }
            if (this.f635a.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f635a);
                sb.append(']');
            } else {
                sb.append(this.f635a);
            }
            int iZ = z();
            if (iZ != js.z(this.z)) {
                sb.append(':');
                sb.append(iZ);
            }
            js.z(sb, this.m);
            if (this.e != null) {
                sb.append('?');
                js.g(sb, this.e);
            }
            if (this.gz != null) {
                sb.append('#');
                sb.append(this.gz);
            }
            return sb.toString();
        }

        EnumC0126z z(js jsVar, String str) {
            int iZ;
            int i;
            int iZ2 = com.bytedance.sdk.component.dl.g.z.dl.z(str, 0, str.length());
            int iG = com.bytedance.sdk.component.dl.g.z.dl.g(str, iZ2, str.length());
            if (g(str, iZ2, iG) != -1) {
                if (str.regionMatches(true, iZ2, "https:", 0, 6)) {
                    this.z = "https";
                    iZ2 += 6;
                } else if (str.regionMatches(true, iZ2, "http:", 0, 5)) {
                    this.z = "http";
                    iZ2 += 5;
                } else {
                    return EnumC0126z.UNSUPPORTED_SCHEME;
                }
            } else if (jsVar != null) {
                this.z = jsVar.z;
            } else {
                return EnumC0126z.MISSING_SCHEME;
            }
            int iDl = dl(str, iZ2, iG);
            char c = '?';
            char c2 = '#';
            if (iDl >= 2 || jsVar == null || !jsVar.z.equals(this.z)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iZ2 + iDl;
                while (true) {
                    iZ = com.bytedance.sdk.component.dl.g.z.dl.z(str, i2, iG, "@/\\?#");
                    byte bCharAt = iZ != iG ? str.charAt(iZ) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iZ3 = com.bytedance.sdk.component.dl.g.z.dl.z(str, i2, iZ, ':');
                            i = iZ;
                            String strZ = js.z(str, i2, iZ3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strZ = this.g + "%40" + strZ;
                            }
                            this.g = strZ;
                            if (iZ3 != i) {
                                this.dl = js.z(str, iZ3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iZ;
                            this.dl += "%40" + js.z(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iA = a(str, i2, iZ);
                int i3 = iA + 1;
                if (i3 < iZ) {
                    this.f635a = gc(str, i2, iA);
                    int iM = m(str, i3, iZ);
                    this.gc = iM;
                    if (iM == -1) {
                        return EnumC0126z.INVALID_PORT;
                    }
                } else {
                    this.f635a = gc(str, i2, iA);
                    this.gc = js.z(this.z);
                }
                if (this.f635a == null) {
                    return EnumC0126z.INVALID_HOST;
                }
                iZ2 = iZ;
            } else {
                this.g = jsVar.gc();
                this.dl = jsVar.m();
                this.f635a = jsVar.g;
                this.gc = jsVar.dl;
                this.m.clear();
                this.m.addAll(jsVar.uy());
                if (iZ2 == iG || str.charAt(iZ2) == '#') {
                    gc(jsVar.kb());
                }
            }
            int iZ4 = com.bytedance.sdk.component.dl.g.z.dl.z(str, iZ2, iG, "?#");
            z(str, iZ2, iZ4);
            if (iZ4 < iG && str.charAt(iZ4) == '?') {
                int iZ5 = com.bytedance.sdk.component.dl.g.z.dl.z(str, iZ4, iG, '#');
                this.e = js.g(js.z(str, iZ4 + 1, iZ5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iZ4 = iZ5;
            }
            if (iZ4 < iG && str.charAt(iZ4) == '#') {
                this.gz = js.z(str, 1 + iZ4, iG, "", true, false, false, false, null);
            }
            return EnumC0126z.SUCCESS;
        }

        private void z(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.m.clear();
                this.m.add("");
                i++;
            } else {
                List<String> list = this.m;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.dl.g.z.dl.z(str, i3, i2, "/\\");
                boolean z = i < i2;
                z(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void z(String str, int i, int i2, boolean z, boolean z2) {
            String strZ = js.z(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (m(strZ)) {
                return;
            }
            if (e(strZ)) {
                a();
                return;
            }
            if (this.m.get(r11.size() - 1).isEmpty()) {
                this.m.set(r11.size() - 1, strZ);
            } else {
                this.m.add(strZ);
            }
            if (z) {
                this.m.add("");
            }
        }

        private boolean m(String str) {
            return str.equals(FileUtils.FILE_EXTENSION_SEPARATOR) || str.equalsIgnoreCase("%2e");
        }

        private boolean e(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void a() {
            if (this.m.remove(r0.size() - 1).isEmpty() && !this.m.isEmpty()) {
                this.m.set(r0.size() - 1, "");
            } else {
                this.m.add("");
            }
        }

        private static int g(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int dl(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int a(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String gc(String str, int i, int i2) {
            return com.bytedance.sdk.component.dl.g.z.dl.z(js.z(str, i, i2, false));
        }

        private static int m(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(js.z(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }
    }

    static String z(String str, boolean z2) {
        return z(str, 0, str.length(), z2);
    }

    private List<String> z(List<String> list, boolean z2) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? z(str, z2) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String z(String str, int i, int i2, boolean z2) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
                dlVar.z(str, i, i3);
                z(dlVar, str, i3, i2, z2);
                return dlVar.pf();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void z(com.bytedance.sdk.component.dl.z.dl r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = com.bytedance.sdk.component.dl.g.z.dl.z(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.component.dl.g.z.dl.z(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.fo(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.fo(r1)
            goto L3c
        L39:
            r5.z(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.js.z(com.bytedance.sdk.component.dl.z.dl, java.lang.String, int, int, boolean):void");
    }

    static boolean z(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.dl.g.z.dl.z(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.dl.g.z.dl.z(str.charAt(i3)) != -1;
    }

    static String z(String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z5)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z2 && (!z3 || z(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z4))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
                    dlVar.z(str, i, iCharCount);
                    z(dlVar, str, iCharCount, i2, str2, z2, z3, z4, z5, charset);
                    return dlVar.pf();
                }
            } else {
                com.bytedance.sdk.component.dl.z.dl dlVar2 = new com.bytedance.sdk.component.dl.z.dl();
                dlVar2.z(str, i, iCharCount);
                z(dlVar2, str, iCharCount, i2, str2, z2, z3, z4, z5, charset);
                return dlVar2.pf();
            }
        }
        return str.substring(i, i2);
    }

    static void z(com.bytedance.sdk.component.dl.z.dl dlVar, String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        com.bytedance.sdk.component.dl.z.dl dlVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z4) {
                    dlVar.g(z2 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z5) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z2 || (z3 && !z(str, i, i2)))))) {
                    if (dlVar2 == null) {
                        dlVar2 = new com.bytedance.sdk.component.dl.z.dl();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.dl.g.z.dl.gc)) {
                        dlVar2.z(iCodePointAt);
                    } else {
                        dlVar2.z(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!dlVar2.gc()) {
                        int iGz = dlVar2.gz() & 255;
                        dlVar.fo(37);
                        char[] cArr = f634a;
                        dlVar.fo((int) cArr[(iGz >> 4) & 15]);
                        dlVar.fo((int) cArr[iGz & 15]);
                    }
                } else {
                    dlVar.z(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String z(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5) {
        return z(str, 0, str.length(), str2, z2, z3, z4, z5, null);
    }
}
