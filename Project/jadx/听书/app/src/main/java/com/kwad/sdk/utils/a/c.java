package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import com.kuaishou.weapon.p0.bi;
import com.kwad.sdk.utils.a.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] bbW = {0, 1, 4, 4, 8, 8};
    private static final byte[] bbX = new byte[0];
    private static final int bbY;
    private static final int bbZ;
    private static final int bca;
    private final String aca;
    private final Map<String, b> bcb;
    private FileChannel bcd;
    private FileChannel bce;
    private RandomAccessFile bcf;
    private RandomAccessFile bcg;
    private MappedByteBuffer bch;
    private MappedByteBuffer bci;
    private com.kwad.sdk.utils.a.b bcj;
    private int bck;
    private long bcl;
    private int bco;
    private int bcp;
    private int bcq;
    private boolean bcr;
    private String bcs;
    private int bct;
    private int bcv;
    private final String name;
    private final d bcc = com.kwad.sdk.utils.a.d.bcG;
    private final Map<String, a.b> bcm = new HashMap();
    private boolean bcn = false;
    private final ArrayList<e> bcu = new ArrayList<>();
    private boolean bcw = true;
    private final Executor bcx = new f();

    public interface b<T> {
        String SK();

        T f(byte[] bArr, int i, int i2);

        byte[] p(T t);
    }

    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    private static long g(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    static {
        int iSM = h.SM();
        PAGE_SIZE = iSM;
        bbY = iSM - 192;
        int iMax = Math.max(iSM << 1, 16384);
        bbZ = iMax;
        bca = iMax << 1;
    }

    c(String str, String str2, b[] bVarArr, int i) {
        this.aca = str;
        this.name = str2;
        this.bcv = i;
        HashMap map = new HashMap();
        g gVar = g.bcN;
        map.put(gVar.SK(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strSK = bVar.SK();
                if (map.containsKey(strSK)) {
                    hH("duplicate encoder tag:" + strSK);
                } else {
                    map.put(strSK, bVar);
                }
            }
        }
        this.bcb = map;
        synchronized (this.bcm) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Sr();
                }
            });
            while (!this.bcn) {
                try {
                    this.bcm.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sr() {
        synchronized (this.bcm) {
            this.bcn = true;
            this.bcm.notify();
        }
        long jNanoTime = System.nanoTime();
        if (!Su() && this.bcv == 0) {
            Ss();
        }
        if (this.bcj == null) {
            this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.bcc != null) {
            info("loading finish, data len:" + this.bck + ", get keys:" + this.bcm.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Ss() {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Ss():void");
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        SC();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e3) {
            g(e3);
        }
        SC();
    }

    private boolean St() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.bck);
        MappedByteBuffer mappedByteBuffer = this.bci;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.bci.get(bVar.bbV, 0, this.bck);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.bbV;
        byte[] bArr2 = bVar.bbV;
        for (int i = 0; i < this.bck; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean Su() {
        File file = new File(this.aca, this.name + ".kvc");
        File file2 = new File(this.aca, this.name + bi.k);
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (ad(file)) {
                    if (this.bcv != 0) {
                        return false;
                    }
                    if (a(this.bcj)) {
                        info("recover from c file");
                        try {
                            Sz();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            t(e);
                            return z;
                        }
                    }
                    this.bcv = 1;
                    return false;
                }
                SC();
                Sz();
                return false;
            }
            if (this.bcv == 0) {
                return false;
            }
            File file3 = new File(this.aca, this.name + ".kva");
            File file4 = new File(this.aca, this.name + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            h(file3, file4);
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private boolean ad(File file) {
        com.kwad.sdk.utils.a.b bVar;
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int iG = G(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar2 = this.bcj;
            if (bVar2 != null && bVar2.bbV.length == iG) {
                bVar = this.bcj;
                bVar.position = 0;
            } else {
                com.kwad.sdk.utils.a.b bVar3 = new com.kwad.sdk.utils.a.b(new byte[iG]);
                this.bcj = bVar3;
                bVar = bVar3;
            }
            h.a(file, bVar.bbV, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.bck = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.F(12, i2) && Sv() == 0) {
                this.bcl = j;
                return true;
            }
        }
        return false;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.bbV.length;
        File file = new File(this.aca, this.name + ".kva");
        File file2 = new File(this.aca, this.name + ".kvb");
        try {
            if (!h.ae(file) || !h.ae(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.bcd = randomAccessFile.getChannel();
            this.bce = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.bcd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bch = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            MappedByteBuffer map2 = this.bce.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bci = map2;
            map2.order(ByteOrder.LITTLE_ENDIAN);
            this.bch.put(bVar.bbV, 0, this.bck);
            this.bci.put(bVar.bbV, 0, this.bck);
            return true;
        } catch (Exception e2) {
            t(e2);
            return false;
        }
    }

    private static void e(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bci ? this.bce : this.bcd).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bci) {
                    this.bci = map;
                } else {
                    this.bch = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                t(e2);
                SA();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x017a, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Sv() {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Sv():int");
    }

    public final synchronized boolean contains(String str) {
        return this.bcm.containsKey(str);
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.bcm.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.bcm.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.bcm.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.bcm.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.bbT) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] bArrAf = h.af(new File(this.aca + this.name, (String) iVar.value));
            String str = new String(bArrAf);
            return (bArrAf == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(bArrAf, com.kwad.sdk.utils.a.b.hD(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            t(e2);
        }
        return "";
    }

    private byte[] a(a.C0427a c0427a) {
        try {
            byte[] bArrAf = h.af(new File(this.aca + this.name, (String) c0427a.value));
            return bArrAf != null ? bArrAf : bbX;
        } catch (Exception e2) {
            t(e2);
            return bbX;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] bArrAf = h.af(new File(this.aca + this.name, (String) hVar.value));
            if (bArrAf != null) {
                int i = bArrAf[0] & 255;
                String str = new String(bArrAf, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.bcb.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.f(bArrAf, i2, bArrAf.length - i2);
                }
                g(new Exception("No encoder for tag:".concat(str)));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            t(e2);
            return null;
        }
    }

    public final synchronized void putBoolean(String str, boolean z) {
        hG(str);
        a.c cVar = (a.c) this.bcm.get(str);
        if (cVar == null) {
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                int i = bVar.position;
                this.bcj.e((byte) (z ? 1 : 0));
                SD();
                Map<String, a.b> map = this.bcm;
                if (map != null) {
                    map.put(str, new a.c(i, z));
                }
            }
            Sw();
            return;
        }
        if (cVar.value != z) {
            cVar.value = z;
            a((byte) (z ? 1 : 0), cVar.offset);
            Sw();
        }
    }

    public final synchronized void putInt(String str, int i) {
        hG(str);
        a.f fVar = (a.f) this.bcm.get(str);
        if (fVar == null) {
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                int i2 = bVar.position;
                this.bcj.eY(i);
                SD();
                Map<String, a.b> map = this.bcm;
                if (map != null) {
                    map.put(str, new a.f(i2, i));
                }
            }
            Sw();
            return;
        }
        if (fVar.value != i) {
            long j = ((long) (fVar.value ^ i)) & 4294967295L;
            fVar.value = i;
            a(i, j, fVar.offset);
            Sw();
        }
    }

    private synchronized void putFloat(String str, float f) {
        hG(str);
        a.e eVar = (a.e) this.bcm.get(str);
        if (eVar != null) {
            if (eVar.value != f) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f);
                long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.value) ^ iFloatToRawIntBits)) & 4294967295L;
                eVar.value = f;
                a(iFloatToRawIntBits, jFloatToRawIntBits, eVar.offset);
                Sw();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            int i = bVar.position;
            this.bcj.eY(Float.floatToRawIntBits(f));
            SD();
            Map<String, a.b> map = this.bcm;
            if (map != null) {
                map.put(str, new a.e(i, f));
            }
        }
        Sw();
    }

    public final synchronized void putLong(String str, long j) {
        hG(str);
        a.g gVar = (a.g) this.bcm.get(str);
        if (gVar != null) {
            if (gVar.value != j) {
                long j2 = j ^ gVar.value;
                gVar.value = j;
                b(j, j2, gVar.offset);
                Sw();
            }
            return;
        }
        a(str, (byte) 4);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            int i = bVar.position;
            this.bcj.bb(j);
            SD();
            Map<String, a.b> map = this.bcm;
            if (map != null) {
                map.put(str, new a.g(i, j));
            }
        }
        Sw();
    }

    private synchronized void putDouble(String str, double d2) {
        hG(str);
        a.d dVar = (a.d) this.bcm.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ jDoubleToRawLongBits;
                dVar.value = d2;
                b(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.offset);
                Sw();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            int i = bVar.position;
            this.bcj.bb(Double.doubleToRawLongBits(d2));
            SD();
            Map<String, a.b> map = this.bcm;
            if (map != null) {
                map.put(str, new a.d(i, d2));
            }
        }
        Sw();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArrHF;
        byte[] bArr;
        byte[] bArr2;
        hG(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.bcm.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            bArrHF = bbX;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int iHD = com.kwad.sdk.utils.a.b.hD(str2);
                bArr = new byte[iHD];
                if (iHD == str2.length()) {
                    a(str2, 0, iHD, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrHF = com.kwad.sdk.utils.a.b.hF(str2);
                }
            } else if (iVar != null && !iVar.bbT) {
                int iHD2 = com.kwad.sdk.utils.a.b.hD(str2);
                bArr = new byte[iHD2];
                if (iHD2 == str2.length()) {
                    a(str2, 0, iHD2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrHF = com.kwad.sdk.utils.a.b.hF(str2);
                }
            } else {
                bArrHF = com.kwad.sdk.utils.a.b.hF(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = bArrHF;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    private synchronized void b(String str, byte[] bArr) {
        hG(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0427a) this.bcm.get(str), (byte) 7);
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        byte[] bArrP;
        hG(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (com.kwad.library.a.a.oz.booleanValue()) {
                throw illegalArgumentException;
            }
            t(illegalArgumentException);
            return;
        }
        String strSK = bVar.SK();
        if (!strSK.isEmpty() && strSK.length() <= 50) {
            if (!this.bcb.containsKey(strSK)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (com.kwad.library.a.a.oz.booleanValue()) {
                    throw illegalArgumentException2;
                }
                t(illegalArgumentException2);
                return;
            }
            if (t == null) {
                remove(str);
                return;
            }
            try {
                bArrP = bVar.p(t);
            } catch (Exception e2) {
                t(e2);
                bArrP = null;
            }
            if (bArrP == null) {
                remove(str);
                return;
            }
            int iHD = com.kwad.sdk.utils.a.b.hD(strSK);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(iHD + 1 + bArrP.length);
            bVar2.e((byte) iHD);
            bVar2.hC(strSK);
            bVar2.k(bArrP);
            a(str, t, bVar2.bbV, (a.h) this.bcm.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + strSK);
        if (com.kwad.library.a.a.oz.booleanValue()) {
            throw illegalArgumentException3;
        }
        t(illegalArgumentException3);
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, set, g.bcN);
        }
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.bcm.get(str);
        if (bVar != null) {
            this.bcm.remove(str);
            byte bSp = bVar.Sp();
            String str2 = null;
            if (bSp <= 5) {
                a(bSp, bVar.offset - (com.kwad.sdk.utils.a.b.hD(str) + 2), bVar.offset + bbW[bSp]);
            } else {
                a.j jVar = (a.j) bVar;
                a(bSp, jVar.start, jVar.offset + jVar.bbS);
                if (jVar.bbT) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (bSp | (-128));
            if (this.bcv == 0) {
                MappedByteBuffer mappedByteBuffer = this.bch;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.bcl);
                    this.bch.put(this.bcq, b2);
                }
                MappedByteBuffer mappedByteBuffer2 = this.bci;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.bcl);
                    this.bci.put(this.bcq, b2);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.bcj;
                if (bVar2 != null) {
                    bVar2.f(4, this.bcl);
                }
            }
            this.bcq = 0;
            if (str2 != null) {
                h.h(new File(this.aca + this.name, str2));
            }
            SG();
            Sw();
        }
    }

    public final synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.bcm.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.bcm.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            switch (value.Sp()) {
                case 1:
                    objValueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    objValueOf = iVar.bbT ? a(iVar) : iVar.value;
                    break;
                case 7:
                    a.C0427a c0427a = (a.C0427a) value;
                    objValueOf = c0427a.bbT ? a(c0427a) : c0427a.value;
                    break;
                case 8:
                    a.h hVar = (a.h) value;
                    objValueOf = hVar.bbT ? a(hVar) : ((a.h) value).value;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private void Sw() {
        if (this.bcv == 0 || !this.bcw) {
            return;
        }
        Sx();
    }

    private boolean Sx() {
        int i = this.bcv;
        if (i == 1) {
            Executor executor = this.bcx;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Sy();
                    }
                });
            }
        } else if (i == 2) {
            return Sy();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean Sy() {
        try {
            File file = new File(this.aca, this.name + bi.k);
            if (h.ae(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.bck);
                randomAccessFile.write(this.bcj.bbV, 0, this.bck);
                randomAccessFile.close();
                File file2 = new File(this.aca, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            t(e2);
        }
        return false;
    }

    private void Sz() {
        try {
            h.h(new File(this.aca, this.name + ".kvc"));
            h.h(new File(this.aca, this.name + bi.k));
        } catch (Exception e2) {
            t(e2);
        }
    }

    private void SA() {
        this.bcv = 1;
        h.closeQuietly(this.bcd);
        h.closeQuietly(this.bce);
        this.bcd = null;
        this.bce = null;
        this.bch = null;
        this.bci = null;
    }

    private void SB() {
        if (this.bcv == 0) {
            try {
                a(this.bch);
                a(this.bci);
            } catch (Throwable unused) {
                SA();
            }
        }
        SC();
        h.h(new File(this.aca + this.name));
    }

    public final void release() {
        h.closeQuietly(this.bcf);
        h.closeQuietly(this.bcg);
        h.closeQuietly(this.bcd);
        h.closeQuietly(this.bce);
        this.bcd = null;
        this.bce = null;
        this.bch = null;
        this.bci = null;
        String str = this.aca + this.name;
        C0428c c0428c = a.bcA;
        C0428c.remove(str);
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer == null) {
            return;
        }
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.bch ? this.bcd : this.bce;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.bch) {
                this.bch = map;
            } else {
                this.bci = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void SC() {
        this.bck = 12;
        this.bcl = 0L;
        SI();
        this.bcm.clear();
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null || bVar.bbV.length != PAGE_SIZE) {
            this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            this.bcj.D(0, 0);
            this.bcj.f(4, 0L);
        }
    }

    private static void hG(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private static void ff(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, bbW[b2]);
    }

    private void a(String str, byte b2, int i) {
        int iHD = com.kwad.sdk.utils.a.b.hD(str);
        ff(iHD);
        this.bcp = iHD + 2 + i;
        SF();
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            bVar.e(b2);
        }
        t(str, iHD);
    }

    private void SD() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            this.bcl ^= bVar2.F(this.bco, this.bcp);
        }
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.bch);
                this.bch.putInt(0, this.bck - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.bcr && (bVar = this.bcj) != null) {
                bVar.D(0, this.bck - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.bcj;
            if (bVar3 != null) {
                bVar3.f(4, this.bcl);
            }
        }
        this.bcr = false;
        this.bcq = 0;
        this.bcp = 0;
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.bcr && mappedByteBuffer != this.bch) {
            mappedByteBuffer.putInt(0, this.bck - 12);
        }
        mappedByteBuffer.putLong(4, this.bcl);
        int i = this.bcq;
        if (i != 0) {
            mappedByteBuffer.put(i, this.bcj.bbV[this.bcq]);
        }
        if (this.bcp != 0) {
            mappedByteBuffer.position(this.bco);
            mappedByteBuffer.put(this.bcj.bbV, this.bco, this.bcp);
        }
    }

    private int SE() {
        int i = this.bck;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void fg(int i) {
        if (this.bcj == null) {
            this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.bcj.bbV.length;
        int i2 = this.bck + i;
        if (i2 >= length) {
            int i3 = this.bct;
            if (i3 > i && i3 > SE()) {
                fh(i);
                return;
            }
            int iG = G(length, i2);
            byte[] bArr = new byte[iG];
            System.arraycopy(this.bcj.bbV, 0, bArr, 0, this.bck);
            this.bcj.bbV = bArr;
            if (this.bcv == 0) {
                try {
                    long j = iG;
                    MappedByteBuffer map = this.bcd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bch = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.bce.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bci = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    t(new Exception("map failed", th));
                    this.bcj.D(0, this.bck - 12);
                    this.bcj.f(4, this.bcl);
                    SA();
                }
            }
        }
    }

    private void a(byte b2, int i) {
        long jG = this.bcl ^ g(1L, i);
        this.bcl = jG;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bch.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.bbV[i] = b2;
        }
    }

    private void a(int i, long j, int i2) {
        long jG = g(j, i2) ^ this.bcl;
        this.bcl = jG;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bch.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.D(i2, i);
        }
    }

    private void b(long j, long j2, int i) {
        long jG = g(j2, i) ^ this.bcl;
        this.bcl = jG;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bch.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.f(i, j);
        }
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            this.bcl ^= bVar.F(i, length);
            this.bcj.position = i;
            this.bcj.k(bArr);
            this.bcl ^= this.bcj.F(i, length);
        }
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.bch.putLong(4, this.bcl);
                this.bch.position(i);
                this.bch.put(bArr);
                this.bch.putInt(0, this.bck - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.position(i);
                this.bci.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.f(4, this.bcl);
        }
    }

    private void SF() {
        fg(this.bcp);
        int i = this.bck;
        this.bco = i;
        this.bck = this.bcp + i;
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            bVar.position = i;
        }
        this.bcr = true;
    }

    private void t(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i == str.length()) {
            a(str, 0, i, this.bcj.bbV, this.bcj.position);
            this.bcj.position += i;
            return;
        }
        this.bcj.hC(str);
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) cCharAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) cCharAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private void u(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i == str.length()) {
            a(str, 0, i, this.bcj.bbV, this.bcj.position);
        } else {
            this.bcj.hC(str);
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int iHD = com.kwad.sdk.utils.a.b.hD(str2);
        if (iVar == null) {
            int iHD2 = com.kwad.sdk.utils.a.b.hD(str);
            ff(iHD2);
            int i = iHD2 + 4;
            this.bcp = i + iHD;
            SF();
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            t(str, iHD2);
            u(str2, iHD);
            Map<String, a.b> map = this.bcm;
            int i2 = this.bco;
            map.put(str, new a.i(i2, i2 + i, str2, iHD, false));
            SD();
        } else {
            int i3 = iVar.offset - iVar.start;
            boolean z = false;
            if (iVar.bbS == iHD) {
                this.bcl ^= this.bcj.F(iVar.offset, iVar.bbS);
                if (iHD == str2.length()) {
                    a(str2, 0, iHD, this.bcj.bbV, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.bcj;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        this.bcj.hC(str2);
                    }
                }
                this.bco = iVar.offset;
                this.bcp = iHD;
            } else {
                this.bcp = i3 + iHD;
                SF();
                com.kwad.sdk.utils.a.b bVar3 = this.bcj;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i4 = i3 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.bcj;
                if (bVar4 != null) {
                    System.arraycopy(bVar4.bbV, iVar.start + 1, this.bcj.bbV, this.bcj.position, i4);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.bcj;
                if (bVar5 != null) {
                    bVar5.position += i4;
                }
                u(str2, iHD);
                a((byte) 6, iVar.start, iVar.offset + iVar.bbS);
                str = iVar.bbT ? (String) iVar.value : null;
                iVar.bbT = false;
                iVar.start = this.bco;
                iVar.offset = this.bco + i3;
                iVar.bbS = iHD;
                z = true;
            }
            iVar.value = str2;
            SD();
            if (z) {
                SG();
            }
            if (str != null) {
                h.h(new File(this.aca + this.name, str));
            }
        }
        Sw();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.bbT || jVar.bbS != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        Sw();
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        a.b hVar;
        int iA = a(str, bArr, b2);
        if (iA != 0) {
            String str2 = this.bcs;
            boolean z = str2 != null;
            if (z) {
                this.bcs = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new a.i(this.bco, iA, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new a.C0427a(this.bco, iA, obj2, length, z);
            } else {
                hVar = new a.h(this.bco, iA, obj2, length, z);
            }
            this.bcm.put(str, hVar);
            SD();
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar) {
        int iA = a(str, bArr, jVar.Sp());
        if (iA != 0) {
            String str2 = jVar.bbT ? (String) jVar.value : null;
            a(jVar.Sp(), jVar.start, jVar.offset + jVar.bbS);
            boolean z = this.bcs != null;
            jVar.start = this.bco;
            jVar.offset = iA;
            jVar.bbT = z;
            if (z) {
                jVar.value = this.bcs;
                jVar.bbS = 32;
                this.bcs = null;
            } else {
                jVar.value = obj;
                jVar.bbS = bArr.length;
            }
            SD();
            SG();
            if (str2 != null) {
                h.h(new File(this.aca + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.bcs = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strSL = h.SL();
        if (h.a(new File(this.aca + this.name, strSL), bArr)) {
            this.bcs = strSL;
            byte[] bArr2 = new byte[32];
            strSL.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | SignedBytes.MAX_POWER_OF_TWO));
        }
        hH("save large value failed");
        return 0;
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        int i = this.bcj.position;
        this.bcj.k(bArr);
        return i;
    }

    private void a(byte b2, int i, int i2) {
        H(i, i2);
        byte b3 = (byte) (b2 | (-128));
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null && bVar.bbV != null) {
            this.bcl ^= (((long) (this.bcj.bbV[i] ^ b3)) & 255) << ((i & 7) << 3);
            this.bcj.bbV[i] = b3;
        }
        this.bcq = i;
    }

    private void SG() {
        if (this.bct < (SE() << 1)) {
            if (this.bcu.size() < (this.bck < 16384 ? 80 : 160)) {
                return;
            }
        }
        fh(0);
    }

    private void SH() {
        ArrayList<e> arrayList = this.bcu;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.bcu.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.bcu.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.bcu.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void fh(int i) {
        int i2;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList == null || this.bcj == null) {
            return;
        }
        Collections.sort(arrayList);
        SH();
        e eVar = this.bcu.get(0);
        int i3 = eVar.start;
        int i4 = this.bck;
        int i5 = i4 - this.bct;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.bcl ^= this.bcj.F(i3, i8);
        }
        int size = this.bcu.size();
        int i9 = size - 1;
        int i10 = this.bck - this.bcu.get(i9).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = eVar.start;
        int i12 = eVar.end;
        int i13 = 1;
        while (i13 < size) {
            e eVar2 = this.bcu.get(i13);
            int i14 = eVar2.start - i12;
            int i15 = size;
            System.arraycopy(this.bcj.bbV, i12, this.bcj.bbV, i11, i14);
            int i16 = (i13 - 1) << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
            i11 += i14;
            i12 = eVar2.end;
            i13++;
            size = i15;
        }
        if (i10 > 0) {
            System.arraycopy(this.bcj.bbV, i12, this.bcj.bbV, i11, i10);
            int i17 = i9 << 1;
            iArr[i17] = i12;
            iArr[i17 + 1] = i12 - i11;
        }
        SI();
        if (z) {
            this.bcl = this.bcj.F(12, i6);
        } else {
            this.bcl ^= this.bcj.F(i3, i7);
        }
        this.bck = i5;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.bch.putLong(4, this.bcl);
                this.bch.position(i3);
                this.bch.put(this.bcj.bbV, i3, i7);
                this.bch.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.bci.putLong(4, this.bcl);
                this.bci.position(i3);
                this.bci.put(this.bcj.bbV, i3, i7);
            }
        } else {
            this.bcj.D(0, i6);
            this.bcj.f(4, this.bcl);
        }
        a(i3, iArr);
        int i18 = i5 + i;
        if (this.bcj.bbV.length - i18 > bca) {
            fi(i18);
        }
        info("gc finish");
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.bcm;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            if (bVar.offset > i) {
                int i2 = iArr[(h.binarySearch(iArr, bVar.offset) << 1) + 1];
                bVar.offset -= i2;
                if (bVar.Sp() >= 6) {
                    ((a.j) bVar).start -= i2;
                }
            }
        }
    }

    private void fi(int i) {
        int i2 = PAGE_SIZE;
        int iG = G(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            if (iG >= bVar.bbV.length) {
                return;
            }
            byte[] bArr = new byte[iG];
            System.arraycopy(this.bcj.bbV, 0, bArr, 0, this.bck);
            this.bcj.bbV = bArr;
        }
        if (this.bcv == 0) {
            try {
                long j = iG;
                this.bcd.truncate(j);
                MappedByteBuffer map = this.bcd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bch = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.bce.truncate(j);
                MappedByteBuffer map2 = this.bce.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bci = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                t(new Exception("map failed", th));
                SA();
            }
        }
        info("truncate finish");
    }

    private int G(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.oz.booleanValue()) {
                throw illegalStateException;
            }
            t(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = bbZ;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void H(int i, int i2) {
        this.bct += i2 - i;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    private void SI() {
        this.bct = 0;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    static class e implements Comparable<e> {
        int end;
        int start;

        e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    private void hH(String str) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void t(Throwable th) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void g(Exception exc) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void info(String str) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    static class C0428c {
        private static Map<String, c> bcC;
        private static List<String> bcD;
        private static int bcE;
        public static Map<String, Integer> bcF;

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public C0428c(int i) {
            int size = getSize(i);
            bcC = new ConcurrentHashMap(size);
            bcF = new HashMap(size);
            bcD = new CopyOnWriteArrayList();
            bcE = i;
        }

        private static void fj(int i) {
            com.kwad.sdk.utils.a.d.bcG.i("Ks_UnionKv", "reSize:" + i);
            bcE = i;
        }

        public static c hI(String str) {
            if (bcC == null) {
                bcC = new ConcurrentHashMap(getSize(bcE));
            }
            if (bcD == null) {
                bcD = new CopyOnWriteArrayList();
            }
            c cVar = bcC.get(str);
            if (cVar == null) {
                return null;
            }
            bcD.remove(str);
            bcD.add(str);
            return cVar;
        }

        public static void b(String str, c cVar) {
            if (bcC == null) {
                bcC = new ConcurrentHashMap(getSize(bcE));
            }
            if (bcD == null) {
                bcD = new CopyOnWriteArrayList();
            }
            if (bcC.containsKey(str)) {
                bcD.remove(str);
                bcD.add(str);
            } else {
                bcD.add(str);
            }
            bcC.put(str, cVar);
            if (bcC.size() > bcE) {
                Integer num = bcF.get(bcD.get(0));
                if (num != null && num.intValue() != 2) {
                    fj(bcE + 1);
                    return;
                }
                c cVar2 = bcC.get(bcD.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                bcC.remove(bcD.get(0));
                bcD.remove(0);
            }
        }

        public static void remove(String str) {
            List<String> list = bcD;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = bcC;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static class a {
        private final String aca;
        private b[] bcB;
        private int bcv = 0;
        private final String name;
        static int bcz = 11;
        static final C0428c bcA = new C0428c(bcz);

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            this.aca = str.endsWith("/") ? str : str + '/';
            this.name = str2;
        }

        public final c SJ() {
            String str = this.aca + this.name;
            c cVarHI = C0428c.hI(str);
            if (cVarHI == null) {
                synchronized (a.class) {
                    cVarHI = C0428c.hI(str);
                    if (cVarHI == null) {
                        cVarHI = new c(this.aca, this.name, this.bcB, this.bcv);
                        C0428c.b(str, cVarHI);
                    }
                }
            }
            Integer num = C0428c.bcF.get(str);
            if (num != null) {
                C0428c.bcF.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0428c.bcF.put(str, 1);
            }
            return cVarHI;
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.aca + " name:" + this.name;
    }
}
