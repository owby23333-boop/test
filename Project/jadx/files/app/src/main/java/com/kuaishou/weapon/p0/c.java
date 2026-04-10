package com.kuaishou.weapon.p0;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16604c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16605d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16606e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16607f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f16608g = !c.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f16609h = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    static abstract class a {
        public byte[] a;
        public int b;

        a() {
        }

        public abstract int a(int i2);

        public abstract boolean a(byte[] bArr, int i2, int i3, boolean z2);
    }

    static class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int[] f16610c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int[] f16611d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f16612e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f16613f = -2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f16614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f16615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int[] f16616i;

        public b(int i2, byte[] bArr) {
            this.a = bArr;
            this.f16616i = (i2 & 8) == 0 ? f16610c : f16611d;
            this.f16614g = 0;
            this.f16615h = 0;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            return ((i2 * 3) / 4) + 10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x0107, code lost:
        
            if (r5 != 4) goto L72;
         */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 292
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.b.a(byte[], int, int, boolean):boolean");
        }
    }

    /* JADX INFO: renamed from: com.kuaishou.weapon.p0.c$c, reason: collision with other inner class name */
    static class C0338c extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f16617c = 19;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final /* synthetic */ boolean f16618h = !c.class.desiredAssertionStatus();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final byte[] f16619i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final byte[] f16620j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f16622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f16623f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f16624g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final byte[] f16625k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f16626l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final byte[] f16627m;

        public C0338c(int i2, byte[] bArr) {
            this.a = bArr;
            this.f16622e = (i2 & 1) == 0;
            this.f16623f = (i2 & 2) == 0;
            this.f16624g = (i2 & 4) != 0;
            this.f16627m = (i2 & 8) == 0 ? f16619i : f16620j;
            this.f16625k = new byte[2];
            this.f16621d = 0;
            this.f16626l = this.f16623f ? 19 : -1;
        }

        @Override // com.kuaishou.weapon.p0.c.a
        public int a(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x00e9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.kuaishou.weapon.p0.c.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 529
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.c.C0338c.a(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(c(bArr, 0), str);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    return f16609h.matcher(str).matches();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static byte[] a(String str, int i2) {
        return a(str.getBytes(), i2);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 0);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, new byte[(i3 * 3) / 4]);
        if (!bVar.a(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i5 = bVar.b;
        byte[] bArr2 = bVar.a;
        if (i5 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr3, 0, i5);
        return bArr3;
    }

    public static String b(String str, int i2) {
        try {
            return new String(a(str.getBytes(), i2));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(byte[] bArr, int i2) {
        try {
            return new String(c(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String b(byte[] bArr, int i2, int i3, int i4) {
        try {
            return new String(c(bArr, i2, i3, i4), "US-ASCII");
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public static byte[] c(byte[] bArr, int i2) {
        try {
            return c(bArr, 0, bArr.length, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) {
        C0338c c0338c = new C0338c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!c0338c.f16622e) {
            int i6 = i3 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i5 += 2;
                } else if (i6 == 2) {
                    i5 += 3;
                }
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (c0338c.f16623f && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (c0338c.f16624g ? 2 : 1);
        }
        c0338c.a = new byte[i5];
        c0338c.a(bArr, i2, i3, true);
        if (f16608g || c0338c.b == i5) {
            return c0338c.a;
        }
        throw new AssertionError();
    }
}
