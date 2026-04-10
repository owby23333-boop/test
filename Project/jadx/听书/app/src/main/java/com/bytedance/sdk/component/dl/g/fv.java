package com.bytedance.sdk.component.dl.g;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class fv {
    public final String[] z;

    fv(z zVar) {
        this.z = (String[]) zVar.z.toArray(new String[zVar.z.size()]);
    }

    private fv(String[] strArr) {
        this.z = strArr;
    }

    public String z(String str) {
        return z(this.z, str);
    }

    public int z() {
        return this.z.length / 2;
    }

    public String z(int i) {
        return this.z[i * 2];
    }

    public String g(int i) {
        return this.z[(i * 2) + 1];
    }

    public List<String> g(String str) {
        int iZ = z();
        ArrayList arrayList = null;
        for (int i = 0; i < iZ; i++) {
            if (str.equalsIgnoreCase(z(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(g(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public z g() {
        z zVar = new z();
        Collections.addAll(zVar.z, this.z);
        return zVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof fv) && Arrays.equals(((fv) obj).z, this.z);
    }

    public int hashCode() {
        return Arrays.hashCode(this.z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iZ = z();
        for (int i = 0; i < iZ; i++) {
            sb.append(z(i)).append(": ").append(g(i)).append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> dl() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iZ = z();
        for (int i = 0; i < iZ; i++) {
            String lowerCase = z(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(g(i));
        }
        return treeMap;
    }

    private static String z(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static fv z(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str2 = strArr2[i2];
            String str3 = strArr2[i2 + 1];
            if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
            }
        }
        return new fv(strArr2);
    }

    public static final class z {
        final List<String> z = new ArrayList(20);

        z z(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return g(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return g("", str.substring(1));
            }
            return g("", str);
        }

        public z z(String str, String str2) {
            try {
                a(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                        return this;
                    }
                }
                return this;
            }
            return g(str, str2);
        }

        z g(String str, String str2) {
            this.z.add(str);
            this.z.add(str2.trim());
            return this;
        }

        public z g(String str) {
            int i = 0;
            while (i < this.z.size()) {
                if (str.equalsIgnoreCase(this.z.get(i))) {
                    this.z.remove(i);
                    this.z.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public z dl(String str, String str2) {
            try {
                a(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                        return this;
                    }
                }
                return this;
            }
            g(str);
            g(str, str2);
            return this;
        }

        private void a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.dl.g.z.dl.z("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.dl.g.z.dl.z("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public fv z() {
            return new fv(this);
        }
    }
}
