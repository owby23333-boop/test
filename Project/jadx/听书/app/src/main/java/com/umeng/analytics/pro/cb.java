package com.umeng.analytics.pro;

import java.util.BitSet;

/* JADX INFO: compiled from: TTupleProtocol.java */
/* JADX INFO: loaded from: classes4.dex */
public final class cb extends bp {

    /* JADX INFO: compiled from: TTupleProtocol.java */
    public static class a implements bx {
        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            return new cb(cjVar);
        }
    }

    public cb(cj cjVar) {
        super(cjVar);
    }

    @Override // com.umeng.analytics.pro.bv
    public Class<? extends cd> D() {
        return cg.class;
    }

    public void a(BitSet bitSet, int i) throws bc {
        for (byte b : b(bitSet, i)) {
            a(b);
        }
    }

    public BitSet b(int i) throws bc {
        int iCeil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        int iCeil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (iCeil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }
}
