package com.bytedance.sdk.component.g.z;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private final String[] z;

    public m(String[] strArr) {
        this.z = strArr;
    }

    m(z zVar) {
        this.z = (String[]) zVar.z.toArray(new String[zVar.z.size()]);
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

    public Map<String, List<String>> g() {
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

    public static final class z {
        final List<String> z = new ArrayList(20);

        public m z() {
            return new m(this);
        }

        z z(String str, String str2) {
            this.z.add(str);
            this.z.add(str2.trim());
            return this;
        }

        public z g(String str, String str2) {
            try {
                dl(str, str2);
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
            return z(str, str2);
        }

        private void dl(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.g.z.g.uy.z("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.g.z.g.uy.z("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }
    }
}
