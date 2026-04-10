package com.bytedance.sdk.component.bf.e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class vn {
    private final String[] e;

    public static final class e {
        final List<String> e = new ArrayList(20);

        private void d(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.bf.e.bf.zk.e("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.bf.e.bf.zk.e("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public e bf(String str, String str2) {
            try {
                d(str, str2);
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
            return e(str, str2);
        }

        public vn e() {
            return new vn(this);
        }

        public e e(String str, String str2) {
            this.e.add(str);
            this.e.add(str2.trim());
            return this;
        }
    }

    public vn(String[] strArr) {
        this.e = strArr;
    }

    public String bf(int i) {
        return this.e[(i * 2) + 1];
    }

    public int e() {
        return this.e.length / 2;
    }

    public Map<String, List<String>> bf() {
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

    public String e(int i) {
        return this.e[i * 2];
    }

    public vn(e eVar) {
        List<String> list = eVar.e;
        this.e = (String[]) list.toArray(new String[list.size()]);
    }
}
