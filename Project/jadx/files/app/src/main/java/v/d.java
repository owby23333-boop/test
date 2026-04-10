package v;

import com.umeng.analytics.pro.cb;

/* JADX INFO: compiled from: C0003c.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            char[] cArr = a;
            sb.append(cArr[(b & 240) >> 4]);
            sb.append(cArr[b & cb.f19604m]);
        }
        return sb.toString();
    }
}
