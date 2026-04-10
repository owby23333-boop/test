package org.minidns.dnslabel;

/* JADX INFO: compiled from: LdhLabel.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends DnsLabel {
    protected c(String str) {
        super(str);
    }

    protected static c b(String str) {
        return h.d(str) ? j.f(str) ? j.b(str) : new h(str) : new f(str);
    }

    public static boolean c(String str) {
        if (str.isEmpty() || d.c(str)) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }
}
