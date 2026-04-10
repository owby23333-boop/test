package e0;

import android.text.TextUtils;

/* JADX INFO: compiled from: LogExt.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static final String a = i.class.getClassLoader().getClass().getName() + "@" + Integer.toHexString(i.class.getClassLoader().hashCode());

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(a);
        sb.append("]");
        if (!TextUtils.isEmpty(str)) {
            sb.append("#");
            sb.append(str);
        }
        sb.append(": " + str2);
        return sb.toString();
    }

    public static void b(String str, String str2) {
        if (n.b.b()) {
            a(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (n.b.b()) {
            a(str, str2);
        }
    }
}
