package com.bytedance.sdk.component.d.bf;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final String[] e;

    public f(e eVar) {
        List<String> list = eVar.e;
        this.e = (String[]) list.toArray(new String[list.size()]);
    }

    public String bf(int i) {
        return this.e[(i * 2) + 1];
    }

    public Map<String, List<String>> d() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iE = e();
        for (int i = 0; i < iE; i++) {
            String lowerCase = e(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(bf(i));
        }
        return treeMap;
    }

    public String e(String str) {
        return e(this.e, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && Arrays.equals(((f) obj).e, this.e);
    }

    public int hashCode() {
        return Arrays.hashCode(this.e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iE = e();
        for (int i = 0; i < iE; i++) {
            sb.append(e(i));
            sb.append(": ");
            sb.append(bf(i));
            sb.append(SignatureUtils.DELIMITER);
        }
        return sb.toString();
    }

    public static final class e {
        final List<String> e = new ArrayList(20);

        private void tg(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.d.bf.e.d.e("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.d.bf.e.d.e("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public e bf(String str, String str2) {
            this.e.add(str);
            this.e.add(str2.trim());
            return this;
        }

        public e d(String str, String str2) {
            try {
                tg(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                                sb.append(cCharAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            bf(str);
            bf(str, str2);
            return this;
        }

        public e e(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? bf(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? bf("", str.substring(1)) : bf("", str);
        }

        public e bf(String str) {
            int i = 0;
            while (i < this.e.size()) {
                if (str.equalsIgnoreCase(this.e.get(i))) {
                    this.e.remove(i);
                    this.e.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public e e(String str, String str2) {
            try {
                tg(str, str2);
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
                        e.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            return bf(str, str2);
        }

        public f e() {
            return new f(this);
        }
    }

    public List<String> bf(String str) {
        int iE = e();
        ArrayList arrayList = null;
        for (int i = 0; i < iE; i++) {
            if (str.equalsIgnoreCase(e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(bf(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public int e() {
        return this.e.length / 2;
    }

    private f(String[] strArr) {
        this.e = strArr;
    }

    public String e(int i) {
        return this.e[i * 2];
    }

    private static String e(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static f e(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    String str = strArr2[i];
                    if (str != null) {
                        strArr2[i] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str2 = strArr2[i2];
                    String str3 = strArr2[i2 + 1];
                    if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
                    }
                }
                return new f(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public e bf() {
        e eVar = new e();
        Collections.addAll(eVar.e, this.e);
        return eVar;
    }
}
