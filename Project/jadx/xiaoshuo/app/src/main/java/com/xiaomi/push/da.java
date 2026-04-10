package com.xiaomi.push;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes8.dex */
public final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f221a;

    public da(String str, int i) {
        this.f221a = str;
        this.f7872a = i;
    }

    public int a() {
        return this.f7872a;
    }

    public String toString() {
        if (this.f7872a <= 0) {
            return this.f221a;
        }
        return this.f221a + ":" + this.f7872a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m282a() {
        return this.f221a;
    }

    public static da a(String str, int i) {
        int iLastIndexOf = str.lastIndexOf(":");
        if (iLastIndexOf != -1) {
            String strSubstring = str.substring(0, iLastIndexOf);
            try {
                int i2 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                if (i2 > 0) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
            }
            str = strSubstring;
        }
        return new da(str, i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m281a(String str, int i) {
        da daVarA = a(str, i);
        return new InetSocketAddress(daVarA.m282a(), daVarA.a());
    }
}
