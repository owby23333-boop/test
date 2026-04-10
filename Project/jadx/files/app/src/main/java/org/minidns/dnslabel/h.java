package org.minidns.dnslabel;

/* JADX INFO: compiled from: ReservedLdhLabel.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends c {
    protected h(String str) {
        super(str);
    }

    public static boolean d(String str) {
        if (c.c(str)) {
            return e(str);
        }
        return false;
    }

    static boolean e(String str) {
        return str.length() >= 4 && str.charAt(2) == '-' && str.charAt(3) == '-';
    }
}
