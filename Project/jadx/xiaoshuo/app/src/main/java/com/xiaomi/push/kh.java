package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public abstract class kh {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: a */
    public abstract void mo690a(byte[] bArr, int i, int i2);

    public int b() {
        return -1;
    }

    public void a(int i) {
    }

    public int b(byte[] bArr, int i, int i2) throws ki {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new ki("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += iA;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public byte[] mo691a() {
        return null;
    }
}
