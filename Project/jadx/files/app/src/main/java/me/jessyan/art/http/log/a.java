package me.jessyan.art.http.log;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;

/* JADX INFO: compiled from: DefaultFormatPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements b {
    private static final String a = System.getProperty("line.separator");
    private static final String b = a + a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f21190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f21191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadLocal<Integer> f21192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f21193f;

    /* JADX INFO: renamed from: me.jessyan.art.http.log.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultFormatPrinter.java */
    class C0581a extends ThreadLocal<Integer> {
        C0581a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return 0;
        }
    }

    static {
        String str = a;
        f21190c = new String[]{str, "Omitted response body"};
        f21191d = new String[]{str, "Omitted request body"};
        f21192e = new C0581a();
        f21193f = new String[]{"-A-", "-R-", "-T-"};
    }

    private static String a(boolean z2) {
        return z2 ? "NetLog-Request" : "NetLog-Response";
    }

    private static boolean b(String str) {
        return TextUtils.isEmpty(str) || "\n".equals(str) || "\t".equals(str) || TextUtils.isEmpty(str.trim());
    }

    private static String c(String str) {
        return a() + str;
    }

    @Override // me.jessyan.art.http.log.b
    public void a(@NonNull Request request, @NonNull String str) {
        String str2 = a + "Body:" + a + str;
        String strA = a(true);
        me.jessyan.art.f.d.a(strA, "   ┌────── Request ────────────────────────────────────────────────────────────────────────");
        a(strA, new String[]{"URL: " + request.url()}, false);
        a(strA, b(request), true);
        a(strA, str2.split(a), true);
        me.jessyan.art.f.d.a(strA, "   └───────────────────────────────────────────────────────────────────────────────────────");
    }

    private static String[] b(Request request) {
        String str;
        String string = request.headers().toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Method: @");
        sb.append(request.method());
        sb.append(b);
        if (b(string)) {
            str = "";
        } else {
            str = "Headers:" + a + a(string);
        }
        sb.append(str);
        return sb.toString().split(a);
    }

    @Override // me.jessyan.art.http.log.b
    public void a(@NonNull Request request) {
        String strA = a(true);
        me.jessyan.art.f.d.a(strA, "   ┌────── Request ────────────────────────────────────────────────────────────────────────");
        a(strA, new String[]{"URL: " + request.url()}, false);
        a(strA, b(request), true);
        a(strA, f21191d, true);
        me.jessyan.art.f.d.a(strA, "   └───────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override // me.jessyan.art.http.log.b
    public void a(long j2, boolean z2, int i2, @NonNull String str, @Nullable MediaType mediaType, @Nullable String str2, @NonNull List<String> list, @NonNull String str3, @NonNull String str4) {
        String strB;
        if (RequestInterceptor.c(mediaType)) {
            strB = me.jessyan.art.f.b.a(str2);
        } else {
            strB = RequestInterceptor.g(mediaType) ? me.jessyan.art.f.b.b(str2) : str2;
        }
        String str5 = a + "Body:" + a + strB;
        String strA = a(false);
        me.jessyan.art.f.d.a(strA, "   ┌────── Response ───────────────────────────────────────────────────────────────────────");
        a(strA, new String[]{"URL: " + str4, "\n"}, true);
        a(strA, a(str, j2, i2, z2, list, str3), true);
        a(strA, str5.split(a), true);
        me.jessyan.art.f.d.a(strA, "   └───────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override // me.jessyan.art.http.log.b
    public void a(long j2, boolean z2, int i2, @NonNull String str, @NonNull List<String> list, @NonNull String str2, @NonNull String str3) {
        String strA = a(false);
        me.jessyan.art.f.d.a(strA, "   ┌────── Response ───────────────────────────────────────────────────────────────────────");
        a(strA, new String[]{"URL: " + str3, "\n"}, true);
        a(strA, a(str, j2, i2, z2, list, str2), true);
        a(strA, f21190c, true);
        me.jessyan.art.f.d.a(strA, "   └───────────────────────────────────────────────────────────────────────────────────────");
    }

    private static void a(String str, String[] strArr, boolean z2) {
        for (String str2 : strArr) {
            int length = str2.length();
            int i2 = z2 ? 110 : length;
            int i3 = 0;
            while (i3 <= length / i2) {
                int i4 = i3 * i2;
                i3++;
                int length2 = i3 * i2;
                if (length2 > str2.length()) {
                    length2 = str2.length();
                }
                me.jessyan.art.f.d.a(c(str), "│ " + str2.substring(i4, length2));
            }
        }
    }

    private static String a() {
        if (f21192e.get().intValue() >= 3) {
            f21192e.set(0);
        }
        String str = f21193f[f21192e.get().intValue()];
        ThreadLocal<Integer> threadLocal = f21192e;
        threadLocal.set(Integer.valueOf(threadLocal.get().intValue() + 1));
        return str;
    }

    private static String[] a(String str, long j2, int i2, boolean z2, List<String> list, String str2) {
        String str3;
        String strA = a(list);
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (TextUtils.isEmpty(strA)) {
            str3 = "";
        } else {
            str3 = strA + " - ";
        }
        sb.append(str3);
        sb.append("is success : ");
        sb.append(z2);
        sb.append(" - ");
        sb.append("Received in: ");
        sb.append(j2);
        sb.append("ms");
        sb.append(b);
        sb.append("Status Code: ");
        sb.append(i2);
        sb.append(" / ");
        sb.append(str2);
        sb.append(b);
        if (!b(str)) {
            str4 = "Headers:" + a + a(str);
        }
        sb.append(str4);
        return sb.toString().split(a);
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }

    private static String a(String str) {
        String str2;
        String[] strArrSplit = str.split(a);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (strArrSplit.length > 1) {
            while (i2 < strArrSplit.length) {
                if (i2 == 0) {
                    str2 = "┌ ";
                } else {
                    str2 = i2 == strArrSplit.length - 1 ? "└ " : "├ ";
                }
                sb.append(str2);
                sb.append(strArrSplit[i2]);
                sb.append("\n");
                i2++;
            }
        } else {
            int length = strArrSplit.length;
            while (i2 < length) {
                String str3 = strArrSplit[i2];
                sb.append("─ ");
                sb.append(str3);
                sb.append("\n");
                i2++;
            }
        }
        return sb.toString();
    }
}
