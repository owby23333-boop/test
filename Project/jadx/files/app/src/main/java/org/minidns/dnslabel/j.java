package org.minidns.dnslabel;

import java.util.Locale;

/* JADX INFO: compiled from: XnLabel.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends h {
    protected j(String str) {
        super(str);
    }

    protected static c b(String str) {
        return str.equals(org.minidns.d.c.b(str)) ? new b(str) : new a(str);
    }

    static boolean f(String str) {
        return str.substring(0, 2).toLowerCase(Locale.US).equals("xn");
    }
}
