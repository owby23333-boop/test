package org.minidns.dnslabel;

/* JADX INFO: compiled from: LeadingOrTrailingHyphenLabel.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {
    protected d(String str) {
        super(str);
    }

    protected static boolean c(String str) {
        if (str.isEmpty()) {
            return false;
        }
        return str.charAt(0) == '-' || str.charAt(str.length() - 1) == '-';
    }
}
