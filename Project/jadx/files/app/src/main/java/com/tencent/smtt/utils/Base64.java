package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class Base64 {
    static final /* synthetic */ boolean a = !Base64.class.desiredAssertionStatus();

    static abstract class a {
        public byte[] a;
        public int b;

        a() {
        }
    }

    static class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int[] f19165c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int[] f19166d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f19168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f19169g;

        public b(int i2, byte[] bArr) {
            this.a = bArr;
            this.f19169g = (i2 & 8) == 0 ? f19165c : f19166d;
            this.f19167e = 0;
            this.f19168f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x0100, code lost:
        
            if (r5 != 4) goto L72;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r17, int r18, int r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.b.a(byte[], int, int, boolean):boolean");
        }
    }

    static class c extends a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f19170g = !Base64.class.desiredAssertionStatus();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final byte[] f19171h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final byte[] f19172i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f19174d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f19175e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f19176f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final byte[] f19177j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f19178k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final byte[] f19179l;

        public c(int i2, byte[] bArr) {
            this.a = bArr;
            this.f19174d = (i2 & 1) == 0;
            this.f19175e = (i2 & 2) == 0;
            this.f19176f = (i2 & 4) != 0;
            this.f19179l = (i2 & 8) == 0 ? f19171h : f19172i;
            this.f19177j = new byte[2];
            this.f19173c = 0;
            this.f19178k = this.f19175e ? 19 : -1;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 528
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] a(String str, int i2) {
        return a(str.getBytes(), i2);
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

    public static byte[] b(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        c cVar = new c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!cVar.f19174d) {
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
        if (cVar.f19175e && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (cVar.f19176f ? 2 : 1);
        }
        cVar.a = new byte[i5];
        cVar.a(bArr, i2, i3, true);
        if (a || cVar.b == i5) {
            return cVar.a;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i2) {
        try {
            return new String(b(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
