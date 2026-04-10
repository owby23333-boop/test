package com.bytedance.sdk.component.d.bf;

import com.alibaba.android.arouter.utils.Consts;
import com.dangdang.reader.utils.DangdangFileManager;
import com.fasterxml.jackson.core.JsonPointer;
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

/* JADX INFO: loaded from: classes.dex */
public final class k {
    private static final char[] tg = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String bf;
    final int d;
    final String e;
    private final String ga;
    private final String m;
    private final List<String> p;
    private final List<String> v;
    private final String vn;
    private final String zk;

    public static final class e {
        String e;
        List<String> p;
        String tg;
        String v;
        final List<String> vn;
        String bf = "";
        String d = "";
        int ga = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.d.bf.k$e$e, reason: collision with other inner class name */
        public enum EnumC0097e {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public e() {
            ArrayList arrayList = new ArrayList();
            this.vn = arrayList;
            arrayList.add("");
        }

        private boolean p(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private boolean vn(String str) {
            return str.equals(Consts.DOT) || str.equalsIgnoreCase("%2e");
        }

        public e bf(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.bf = k.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public e d(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.d = k.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public e e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.e = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.e = "https";
            }
            return this;
        }

        public e ga(String str) {
            this.p = str != null ? k.bf(k.e(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public e query(String str) {
            this.p = str != null ? k.bf(k.e(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public e tg(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strGa = ga(str, 0, str.length());
            if (strGa != null) {
                this.tg = strGa;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.e);
            sb.append("://");
            if (!this.bf.isEmpty() || !this.d.isEmpty()) {
                sb.append(this.bf);
                if (!this.d.isEmpty()) {
                    sb.append(':');
                    sb.append(this.d);
                }
                sb.append('@');
            }
            if (this.tg.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.tg);
                sb.append(']');
            } else {
                sb.append(this.tg);
            }
            int iE = e();
            if (iE != k.e(this.e)) {
                sb.append(':');
                sb.append(iE);
            }
            k.e(sb, this.vn);
            if (this.p != null) {
                sb.append('?');
                k.bf(sb, this.p);
            }
            if (this.v != null) {
                sb.append(DangdangFileManager.REPLACE);
                sb.append(this.v);
            }
            return sb.toString();
        }

        private static int vn(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(k.e(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }

        private static String ga(String str, int i, int i2) {
            return com.bytedance.sdk.component.d.bf.e.d.e(k.e(str, i, i2, false));
        }

        public e bf() {
            int size = this.vn.size();
            for (int i = 0; i < size; i++) {
                this.vn.set(i, k.e(this.vn.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.p;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.p.get(i2);
                    if (str != null) {
                        this.p.set(i2, k.e(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.v;
            if (str2 != null) {
                this.v = k.e(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public k d() {
            if (this.e != null) {
                if (this.tg != null) {
                    return new k(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void tg() {
            if (this.vn.remove(r0.size() - 1).isEmpty() && !this.vn.isEmpty()) {
                this.vn.set(r0.size() - 1, "");
            } else {
                this.vn.add("");
            }
        }

        public e e(int i) {
            if (i > 0 && i <= 65535) {
                this.ga = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        private static int d(String str, int i, int i2) {
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

        private static int tg(String str, int i, int i2) {
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

        public int e() {
            int i = this.ga;
            return i != -1 ? i : k.e(this.e);
        }

        public EnumC0097e e(k kVar, String str) {
            int iE;
            int i;
            int iE2 = com.bytedance.sdk.component.d.bf.e.d.e(str, 0, str.length());
            int iBf = com.bytedance.sdk.component.d.bf.e.d.bf(str, iE2, str.length());
            if (bf(str, iE2, iBf) != -1) {
                if (str.regionMatches(true, iE2, "https:", 0, 6)) {
                    this.e = "https";
                    iE2 += 6;
                } else if (str.regionMatches(true, iE2, "http:", 0, 5)) {
                    this.e = "http";
                    iE2 += 5;
                } else {
                    return EnumC0097e.UNSUPPORTED_SCHEME;
                }
            } else if (kVar != null) {
                this.e = kVar.e;
            } else {
                return EnumC0097e.MISSING_SCHEME;
            }
            int iD = d(str, iE2, iBf);
            char c = '?';
            char c2 = DangdangFileManager.REPLACE;
            if (iD < 2 && kVar != null && kVar.e.equals(this.e)) {
                this.bf = kVar.ga();
                this.d = kVar.vn();
                this.tg = kVar.bf;
                this.ga = kVar.d;
                this.vn.clear();
                this.vn.addAll(kVar.m());
                if (iE2 == iBf || str.charAt(iE2) == '#') {
                    ga(kVar.wu());
                }
            } else {
                boolean z = false;
                boolean z2 = false;
                int i2 = iE2 + iD;
                while (true) {
                    iE = com.bytedance.sdk.component.d.bf.e.d.e(str, i2, iBf, "@/\\?#");
                    byte bCharAt = iE != iBf ? str.charAt(iE) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iE3 = com.bytedance.sdk.component.d.bf.e.d.e(str, i2, iE, ':');
                            i = iE;
                            String strE = k.e(str, i2, iE3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strE = this.bf + "%40" + strE;
                            }
                            this.bf = strE;
                            if (iE3 != i) {
                                this.d = k.e(str, iE3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iE;
                            this.d += "%40" + k.e(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = DangdangFileManager.REPLACE;
                }
                int iTg = tg(str, i2, iE);
                int i3 = iTg + 1;
                if (i3 < iE) {
                    this.tg = ga(str, i2, iTg);
                    int iVn = vn(str, i3, iE);
                    this.ga = iVn;
                    if (iVn == -1) {
                        return EnumC0097e.INVALID_PORT;
                    }
                } else {
                    this.tg = ga(str, i2, iTg);
                    this.ga = k.e(this.e);
                }
                if (this.tg == null) {
                    return EnumC0097e.INVALID_HOST;
                }
                iE2 = iE;
            }
            int iE4 = com.bytedance.sdk.component.d.bf.e.d.e(str, iE2, iBf, "?#");
            e(str, iE2, iE4);
            if (iE4 < iBf && str.charAt(iE4) == '?') {
                int iE5 = com.bytedance.sdk.component.d.bf.e.d.e(str, iE4, iBf, DangdangFileManager.REPLACE);
                this.p = k.bf(k.e(str, iE4 + 1, iE5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iE4 = iE5;
            }
            if (iE4 < iBf && str.charAt(iE4) == '#') {
                this.v = k.e(str, 1 + iE4, iBf, "", true, false, false, false, null);
            }
            return EnumC0097e.SUCCESS;
        }

        private static int bf(String str, int i, int i2) {
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

        private void e(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.vn;
                list.set(list.size() - 1, "");
            } else {
                this.vn.clear();
                this.vn.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.d.bf.e.d.e(str, i3, i2, "/\\");
                boolean z = i < i2;
                e(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void e(String str, int i, int i2, boolean z, boolean z2) {
            String strE = k.e(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (vn(strE)) {
                return;
            }
            if (p(strE)) {
                tg();
                return;
            }
            if (this.vn.get(r11.size() - 1).isEmpty()) {
                this.vn.set(r11.size() - 1, strE);
            } else {
                this.vn.add(strE);
            }
            if (z) {
                this.vn.add("");
            }
        }
    }

    public k(e eVar) {
        this.e = eVar.e;
        this.ga = e(eVar.bf, false);
        this.vn = e(eVar.d, false);
        this.bf = eVar.tg;
        this.d = eVar.e();
        this.p = e(eVar.vn, false);
        List<String> list = eVar.p;
        this.v = list != null ? e(list, true) : null;
        String str = eVar.v;
        this.zk = str != null ? e(str, false) : null;
        this.m = eVar.toString();
    }

    public URI bf() {
        String string = t().bf().toString();
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

    public String bh() {
        return tg("/...").bf("").d("").d().toString();
    }

    public String d() {
        return this.e;
    }

    public URL e() {
        try {
            return new URL(this.m);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && ((k) obj).m.equals(this.m);
    }

    public String ga() {
        if (this.ga.isEmpty()) {
            return "";
        }
        int length = this.e.length() + 3;
        String str = this.m;
        return this.m.substring(length, com.bytedance.sdk.component.d.bf.e.d.e(str, length, str.length(), ":@"));
    }

    public int hashCode() {
        return this.m.hashCode();
    }

    public List<String> m() {
        int iIndexOf = this.m.indexOf(47, this.e.length() + 3);
        String str = this.m;
        int iE = com.bytedance.sdk.component.d.bf.e.d.e(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iE) {
            int i = iIndexOf + 1;
            int iE2 = com.bytedance.sdk.component.d.bf.e.d.e(this.m, i, iE, JsonPointer.SEPARATOR);
            arrayList.add(this.m.substring(i, iE2));
            iIndexOf = iE2;
        }
        return arrayList;
    }

    public String p() {
        return this.bf;
    }

    public String query() {
        if (this.v == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        bf(sb, this.v);
        return sb.toString();
    }

    public e t() {
        e eVar = new e();
        eVar.e = this.e;
        eVar.bf = ga();
        eVar.d = vn();
        eVar.tg = this.bf;
        eVar.ga = this.d != e(this.e) ? this.d : -1;
        eVar.vn.clear();
        eVar.vn.addAll(m());
        eVar.ga(wu());
        eVar.v = xu();
        return eVar;
    }

    public boolean tg() {
        return this.e.equals("https");
    }

    public String toString() {
        return this.m;
    }

    public int v() {
        return this.d;
    }

    public String vn() {
        if (this.vn.isEmpty()) {
            return "";
        }
        return this.m.substring(this.m.indexOf(58, this.e.length() + 3) + 1, this.m.indexOf(64));
    }

    public String wu() {
        if (this.v == null) {
            return null;
        }
        int iIndexOf = this.m.indexOf(63) + 1;
        String str = this.m;
        return this.m.substring(iIndexOf, com.bytedance.sdk.component.d.bf.e.d.e(str, iIndexOf, str.length(), DangdangFileManager.REPLACE));
    }

    public String xu() {
        if (this.zk == null) {
            return null;
        }
        return this.m.substring(this.m.indexOf(35) + 1);
    }

    public String zk() {
        int iIndexOf = this.m.indexOf(47, this.e.length() + 3);
        String str = this.m;
        return this.m.substring(iIndexOf, com.bytedance.sdk.component.d.bf.e.d.e(str, iIndexOf, str.length(), "?#"));
    }

    public k d(String str) {
        e eVarTg = tg(str);
        if (eVarTg != null) {
            return eVarTg.d();
        }
        return null;
    }

    public e tg(String str) {
        e eVar = new e();
        if (eVar.e(this, str) == e.EnumC0097e.SUCCESS) {
            return eVar;
        }
        return null;
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void e(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(JsonPointer.SEPARATOR);
            sb.append(list.get(i));
        }
    }

    public static k ga(String str) {
        e eVar = new e();
        if (eVar.e(null, str) == e.EnumC0097e.SUCCESS) {
            return eVar.d();
        }
        return null;
    }

    public static void bf(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.p.a.h);
                sb.append(str2);
            }
        }
    }

    public static k e(URL url) {
        return ga(url.toString());
    }

    public static String e(String str, boolean z) {
        return e(str, 0, str.length(), z);
    }

    private List<String> e(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? e(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> bf(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static String e(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.d.e.d dVar = new com.bytedance.sdk.component.d.e.d();
                dVar.e(str, i, i3);
                e(dVar, str, i3, i2, z);
                return dVar.s();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(com.bytedance.sdk.component.d.e.d r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = com.bytedance.sdk.component.d.bf.e.d.e(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.component.d.bf.e.d.e(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.zk(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.zk(r1)
            goto L3c
        L39:
            r5.e(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.k.e(com.bytedance.sdk.component.d.e.d, java.lang.String, int, int, boolean):void");
    }

    public static boolean e(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.d.bf.e.d.e(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.d.bf.e.d.e(str.charAt(i3)) != -1;
    }

    public static String e(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || e(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.component.d.e.d dVar = new com.bytedance.sdk.component.d.e.d();
                    dVar.e(str, i, iCharCount);
                    e(dVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return dVar.s();
                }
            } else {
                com.bytedance.sdk.component.d.e.d dVar2 = new com.bytedance.sdk.component.d.e.d();
                dVar2.e(str, i, iCharCount);
                e(dVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return dVar2.s();
            }
        }
        return str.substring(i, i2);
    }

    public static void e(com.bytedance.sdk.component.d.e.d dVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.d.e.d dVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    dVar.bf(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || e(str, i, i2)))))) {
                    dVar.e(iCodePointAt);
                } else {
                    if (dVar2 == null) {
                        dVar2 = new com.bytedance.sdk.component.d.e.d();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.d.bf.e.d.ga)) {
                        dVar2.e(str, i, Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        dVar2.e(iCodePointAt);
                    }
                    while (!dVar2.ga()) {
                        int iV = dVar2.v() & 255;
                        dVar.zk(37);
                        char[] cArr = tg;
                        dVar.zk((int) cArr[(iV >> 4) & 15]);
                        dVar.zk((int) cArr[iV & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String e(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return e(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
