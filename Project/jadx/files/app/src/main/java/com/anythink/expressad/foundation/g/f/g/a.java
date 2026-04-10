package com.anythink.expressad.foundation.g.f.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a = -2;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10554c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10555d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10556e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10557f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10558g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10559h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10560i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10561j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10562k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10563l = 11;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10564m = 12;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10565n = 13;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10566o = 14;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10567p = 15;

    public static String a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        if (aVar != null) {
            try {
                int i2 = aVar.a;
                int i3 = aVar.b != null ? aVar.b.a : 0;
                if (i2 == -2) {
                    return "Network is canceled";
                }
                if (i2 != 1) {
                    switch (i2) {
                        case 3:
                            return "Network error,timeout exception";
                        case 4:
                            return "Network unknown error";
                        case 5:
                            return "Network error，https is not work,please check your phone time";
                        case 6:
                            return i3 != 0 ? "Network error,please check state code".concat(String.valueOf(i3)) : "Network error,please check ";
                        case 7:
                            return i3 != 0 ? "The server returns an exception state code ".concat(String.valueOf(i3)) : "The server returns an exception ";
                        case 8:
                            return "Cast exception, return data can't be casted correctly";
                        case 9:
                        case 12:
                            return "Network error,disconnected network exception";
                        case 10:
                            return "Network error,socket timeout exception";
                        case 11:
                            return "Network error，sslp exception";
                        default:
                            return "Network error,I/O exception";
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "Network error,Load failed";
    }
}
