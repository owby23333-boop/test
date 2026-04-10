package com.ta.utdid2.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    private static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f18100d;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f18101x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f18102y;

        private a() {
            this.f18100d = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        a aVarA;
        if (bArr == null || (aVarA = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, aVarA);
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i2 = 0; i2 < 256; i2++) {
            aVar.f18100d[i2] = i2;
        }
        aVar.f18101x = 0;
        aVar.f18102y = 0;
        int length = 0;
        int iCharAt = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            try {
                iCharAt = ((str.charAt(length) + aVar.f18100d[i3]) + iCharAt) % 256;
                int i4 = aVar.f18100d[i3];
                aVar.f18100d[i3] = aVar.f18100d[iCharAt];
                aVar.f18100d[iCharAt] = i4;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i2 = aVar.f18101x;
        int i3 = aVar.f18102y;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = aVar.f18100d;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            int i6 = (iArr[i2] + iArr[i3]) % 256;
            bArr[i4] = (byte) (iArr[i6] ^ bArr[i4]);
        }
        aVar.f18101x = i2;
        aVar.f18102y = i3;
        return bArr;
    }
}
