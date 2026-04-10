package me.jessyan.art.f;

/* JADX INFO: compiled from: UrlEncoderUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    private static boolean a(char c2) {
        return ('0' <= c2 && c2 <= '9') || ('a' <= c2 && c2 <= 'f') || ('A' <= c2 && c2 <= 'F');
    }

    public static boolean a(String str) {
        int i2;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '%' && (i2 = i3 + 2) < str.length()) {
                return a(str.charAt(i3 + 1)) && a(str.charAt(i2));
            }
        }
        return false;
    }
}
