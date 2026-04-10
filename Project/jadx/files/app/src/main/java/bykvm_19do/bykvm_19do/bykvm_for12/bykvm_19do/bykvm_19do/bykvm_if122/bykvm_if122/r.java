package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    private final String[] a;

    public static final class a {
        final List<String> a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                char cCharAt2 = str2.charAt(i3);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i3), str, str2));
                }
            }
        }

        a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                str = str.substring(1);
            }
            return b("", str);
        }

        public a a(String str, String str2) {
            try {
                d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char cCharAt = str2.charAt(i2);
                            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                                sb.append(cCharAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            return b(str, str2);
        }

        public r a() {
            return new r(this);
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i2))) {
                    this.a.remove(i2);
                    this.a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        a b(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            try {
                d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char cCharAt = str2.charAt(i2);
                            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                                sb.append(cCharAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                return this;
            }
            b(str);
            b(str, str2);
            return this;
        }
    }

    r(a aVar) {
        List<String> list = aVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public String a(int i2) {
        return this.a[i2 * 2];
    }

    public String a(String str) {
        return a(this.a, str);
    }

    public int b() {
        return this.a.length / 2;
    }

    public String b(int i2) {
        return this.a[(i2 * 2) + 1];
    }

    public List<String> b(String str) {
        int iB = b();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < iB; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).a, this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iB = b();
        for (int i2 = 0; i2 < iB; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
