package com.kwad.sdk.utils.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.kwai.a;
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

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aAH = {0, 1, 4, 4, 8, 8};
    private static final byte[] aAI = new byte[0];
    private static final int aAJ;
    private static final int aAK;
    private static final int aAL;
    private final String RY;
    private final Map<String, b> aAM;
    private FileChannel aAO;
    private FileChannel aAP;
    private RandomAccessFile aAQ;
    private RandomAccessFile aAR;
    private MappedByteBuffer aAS;
    private MappedByteBuffer aAT;
    private com.kwad.sdk.utils.kwai.b aAU;
    private int aAV;
    private long aAW;
    private int aAZ;
    private int aBa;
    private int aBb;
    private boolean aBc;
    private String aBd;
    private int aBe;
    private int aBg;
    private final String name;
    private final d aAN = com.kwad.sdk.utils.kwai.d.aBr;
    private final Map<String, a.b> aAX = new HashMap();
    private boolean aAY = false;
    private final ArrayList<e> aBf = new ArrayList<>();
    private boolean aBh = true;
    private final Executor aBi = new f();

    public static class a {
        static int aBk = 11;
        static final C0459c aBl = new C0459c(aBk);
        private final String RY;
        private int aBg = 0;
        private b[] aBm;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.RY = str;
            this.name = str2;
        }

        public final c Fr() {
            String str = this.RY + this.name;
            c cVarEM = C0459c.eM(str);
            if (cVarEM == null) {
                synchronized (a.class) {
                    cVarEM = C0459c.eM(str);
                    if (cVarEM == null) {
                        cVarEM = new c(this.RY, this.name, this.aBm, this.aBg);
                        C0459c.b(str, cVarEM);
                    }
                }
            }
            Integer num = C0459c.aBq.get(str);
            if (num != null) {
                C0459c.aBq.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0459c.aBq.put(str, 1);
            }
            return cVarEM;
        }
    }

    public interface b<T> {
        String Fs();

        T g(byte[] bArr, int i2, int i3);

        byte[] i(T t2);
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.kwai.c$c, reason: collision with other inner class name */
    static class C0459c {
        private static Map<String, c> aBn;
        private static List<String> aBo;
        private static int aBp;
        public static Map<String, Integer> aBq;

        public C0459c(int i2) {
            int size = getSize(i2);
            aBn = new ConcurrentHashMap(size);
            aBq = new HashMap(size);
            aBo = new CopyOnWriteArrayList();
            aBp = i2;
        }

        public static void b(String str, c cVar) {
            if (aBn == null) {
                aBn = new ConcurrentHashMap(getSize(aBp));
            }
            if (aBo == null) {
                aBo = new CopyOnWriteArrayList();
            }
            if (aBn.containsKey(str)) {
                aBo.remove(str);
            }
            aBo.add(str);
            aBn.put(str, cVar);
            if (aBn.size() > aBp) {
                Integer num = aBq.get(aBo.get(0));
                if (num != null && num.intValue() != 2) {
                    cp(aBp + 1);
                    return;
                }
                c cVar2 = aBn.get(aBo.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aBn.remove(aBo.get(0));
                aBo.remove(0);
            }
        }

        private static void cp(int i2) {
            com.kwad.sdk.utils.kwai.d.aBr.i("Ks_UnionKv", "reSize:" + i2);
            aBp = i2;
        }

        public static c eM(String str) {
            if (aBn == null) {
                aBn = new ConcurrentHashMap(getSize(aBp));
            }
            if (aBo == null) {
                aBo = new CopyOnWriteArrayList();
            }
            c cVar = aBn.get(str);
            if (cVar == null) {
                return null;
            }
            aBo.remove(str);
            aBo.add(str);
            return cVar;
        }

        private static int getSize(int i2) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }

        public static void remove(String str) {
            List<String> list = aBo;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aBn;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public interface d {
        void a(String str, Exception exc);

        void b(String str, Exception exc);

        void i(String str, String str2);
    }

    static class e implements Comparable<e> {
        int end;
        int start;

        e(int i2, int i3) {
            this.start = i2;
            this.end = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int iFv = h.Fv();
        PAGE_SIZE = iFv;
        aAJ = iFv - 192;
        int iMax = Math.max(PAGE_SIZE << 1, 16384);
        aAK = iMax;
        aAL = iMax << 1;
    }

    c(String str, String str2, b[] bVarArr, int i2) {
        this.RY = str;
        this.name = str2;
        this.aBg = i2;
        HashMap map = new HashMap();
        g gVar = g.aBz;
        map.put(gVar.Fs(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strFs = bVar.Fs();
                if (map.containsKey(strFs)) {
                    eL("duplicate encoder tag:" + strFs);
                } else {
                    map.put(strFs, bVar);
                }
            }
        }
        this.aAM = map;
        synchronized (this.aAX) {
            com.kwad.sdk.utils.kwai.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.EZ();
                }
            });
            while (!this.aAY) {
                try {
                    this.aAX.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void EZ() {
        synchronized (this.aAX) {
            this.aAY = true;
            this.aAX.notify();
        }
        long jNanoTime = System.nanoTime();
        if (!Fc() && this.aBg == 0) {
            Fa();
        }
        if (this.aAU == null) {
            this.aAU = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        }
        if (this.aAN != null) {
            info("loading finish, data len:" + this.aAV + ", get keys:" + this.aAX.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    private void Fa() {
        boolean z2;
        c cVar = this;
        File file = new File(cVar.RY, cVar.name + ".kva");
        File file2 = new File(cVar.RY, cVar.name + ".kvb");
        try {
            if (h.Y(file) && h.Y(file2)) {
                cVar.aAQ = new RandomAccessFile(file, "rw");
                cVar.aAR = new RandomAccessFile(file2, "rw");
                long length = cVar.aAQ.length();
                long length2 = cVar.aAR.length();
                cVar.aAO = cVar.aAQ.getChannel();
                cVar.aAP = cVar.aAR.getChannel();
                try {
                    cVar.aAS = cVar.aAO.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    cVar.aAS.order(ByteOrder.LITTLE_ENDIAN);
                    cVar.aAT = cVar.aAP.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    cVar.aAT.order(ByteOrder.LITTLE_ENDIAN);
                    cVar.aAU = new com.kwad.sdk.utils.kwai.b(cVar.aAS.capacity());
                    if (length == 0 && length2 == 0) {
                        cVar.aAV = 12;
                        return;
                    }
                    int i2 = cVar.aAS.getInt();
                    long j2 = cVar.aAS.getLong();
                    int i3 = cVar.aAT.getInt();
                    long j3 = cVar.aAT.getLong();
                    boolean z3 = false;
                    if (i2 < 0) {
                        z2 = false;
                    } else {
                        if (i2 <= length - 12) {
                            cVar = this;
                            cVar.aAV = i2 + 12;
                            cVar.aAS.rewind();
                            cVar.aAS.get(cVar.aAU.aAG, 0, cVar.aAV);
                            if (j2 == cVar.aAU.w(12, i2) && Fd() == 0) {
                                cVar.aAW = j2;
                                z2 = true;
                            }
                        } else {
                            cVar = this;
                        }
                        z2 = false;
                    }
                    if (z2) {
                        if (length == length2 && Fb()) {
                            return;
                        }
                        cVar.b(new Exception("B file error"));
                        cVar.a(cVar.aAS, cVar.aAT, cVar.aAV);
                        return;
                    }
                    if (i3 >= 0 && i3 <= length2 - 12) {
                        cVar.aAX.clear();
                        Fq();
                        cVar.aAV = i3 + 12;
                        if (cVar.aAU.aAG.length != cVar.aAT.capacity()) {
                            cVar.aAU = new com.kwad.sdk.utils.kwai.b(cVar.aAT.capacity());
                        }
                        cVar.aAT.rewind();
                        cVar.aAT.get(cVar.aAU.aAG, 0, cVar.aAV);
                        if (j3 == cVar.aAU.w(12, i3) && Fd() == 0) {
                            cVar.b(new Exception("A file error"));
                            cVar.a(cVar.aAT, cVar.aAS, cVar.aAV);
                            cVar.aAW = j3;
                            z3 = true;
                        }
                    }
                    if (z3) {
                        return;
                    }
                    cVar.eL("both files error");
                    Fj();
                    return;
                } catch (IOException e2) {
                    cVar.a(e2);
                    Fi();
                    cVar.f(file, file2);
                    return;
                }
            }
            cVar.a(new Exception("open file failed"));
            Fi();
        } catch (Exception e3) {
            cVar.a(e3);
            Fk();
            Fi();
        }
    }

    private boolean Fb() {
        com.kwad.sdk.utils.kwai.b bVar = new com.kwad.sdk.utils.kwai.b(this.aAV);
        MappedByteBuffer mappedByteBuffer = this.aAT;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aAT.get(bVar.aAG, 0, this.aAV);
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.aAG;
        byte[] bArr2 = bVar.aAG;
        for (int i2 = 0; i2 < this.aAV; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean Fc() {
        File file = new File(this.RY, this.name + ".kvc");
        File file2 = new File(this.RY, this.name + ".tmp");
        boolean z2 = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!X(file)) {
                    Fk();
                    Fh();
                } else if (this.aBg == 0) {
                    if (a(this.aAU)) {
                        info("recover from c file");
                        try {
                            Fh();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            a(e);
                            return z2;
                        }
                    }
                    this.aBg = 1;
                }
            } else if (this.aBg != 0) {
                File file3 = new File(this.RY, this.name + ".kva");
                File file4 = new File(this.RY, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    f(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x015f, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Fd() {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fd():int");
    }

    private void Fe() {
        if (this.aBg == 0 || !this.aBh) {
            return;
        }
        Ff();
    }

    private boolean Ff() {
        int i2 = this.aBg;
        if (i2 == 1) {
            Executor executor = this.aBi;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Fg();
                    }
                });
            }
        } else if (i2 == 2) {
            return Fg();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean Fg() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r2 = r6.RY     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r3.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r4 = r6.name     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r4 = ".tmp"
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r2 = com.kwad.sdk.utils.kwai.h.Y(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r2 == 0) goto L7b
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r3 = r6.aAV     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.setLength(r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            com.kwad.sdk.utils.kwai.b r3 = r6.aAU     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            byte[] r3 = r3.aAG     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r4 = r6.aAV     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.write(r3, r0, r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.close()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r3 = r6.RY     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = r6.name     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r4.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = ".kvc"
            r4.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r3 == 0) goto L61
            boolean r3 = r2.delete()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r3 == 0) goto L7b
        L61:
            boolean r1 = r1.renameTo(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r1 == 0) goto L6a
            r0 = 1
            monitor-exit(r6)
            return r0
        L6a:
            java.lang.Exception r1 = new java.lang.Exception     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r2 = "rename failed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r6.b(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            goto L7b
        L75:
            r0 = move-exception
            goto L7d
        L77:
            r1 = move-exception
            r6.a(r1)     // Catch: java.lang.Throwable -> L75
        L7b:
            monitor-exit(r6)
            return r0
        L7d:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fg():boolean");
    }

    private void Fh() {
        try {
            h.c(new File(this.RY, this.name + ".kvc"));
            h.c(new File(this.RY, this.name + ".tmp"));
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void Fi() {
        this.aBg = 1;
        h.closeQuietly(this.aAO);
        h.closeQuietly(this.aAP);
        this.aAO = null;
        this.aAP = null;
        this.aAS = null;
        this.aAT = null;
    }

    private void Fj() {
        if (this.aBg == 0) {
            try {
                a(this.aAS);
                a(this.aAT);
            } catch (Throwable unused) {
                Fi();
            }
        }
        Fk();
        h.c(new File(this.RY + this.name));
    }

    private void Fk() {
        this.aAV = 12;
        this.aAW = 0L;
        Fq();
        this.aAX.clear();
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar == null || bVar.aAG.length != PAGE_SIZE) {
            this.aAU = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        } else {
            bVar.u(0, 0);
            this.aAU.c(4, 0L);
        }
    }

    private void Fl() {
        com.kwad.sdk.utils.kwai.b bVar;
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        if (bVar2 != null) {
            this.aAW ^= bVar2.w(this.aAZ, this.aBa);
        }
        if (this.aBg == 0) {
            MappedByteBuffer mappedByteBuffer = this.aAS;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aAS);
                this.aAS.putInt(0, this.aAV - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aAT;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aBc && (bVar = this.aAU) != null) {
                bVar.u(0, this.aAV - 12);
            }
            com.kwad.sdk.utils.kwai.b bVar3 = this.aAU;
            if (bVar3 != null) {
                bVar3.c(4, this.aAW);
            }
        }
        this.aBc = false;
        this.aBb = 0;
        this.aBa = 0;
    }

    private int Fm() {
        int i2 = this.aAV;
        if (i2 <= 16384) {
            return 4096;
        }
        return i2 <= 65536 ? 8192 : 16384;
    }

    private void Fn() {
        cm(this.aBa);
        int i2 = this.aAV;
        this.aAZ = i2;
        this.aAV = i2 + this.aBa;
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar != null) {
            bVar.position = this.aAZ;
        }
        this.aBc = true;
    }

    private void Fo() {
        if (this.aBe < (Fm() << 1)) {
            if (this.aBf.size() < (this.aAV < 16384 ? 80 : 160)) {
                return;
            }
        }
        cn(0);
    }

    private void Fp() {
        ArrayList<e> arrayList = this.aBf;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aBf.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.aBf.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aBf.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void Fq() {
        this.aBe = 0;
        ArrayList<e> arrayList = this.aBf;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private boolean X(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i2 = (int) length;
            int iX = x(PAGE_SIZE, i2);
            com.kwad.sdk.utils.kwai.b bVar = this.aAU;
            if (bVar == null || bVar.aAG.length != iX) {
                bVar = new com.kwad.sdk.utils.kwai.b(new byte[iX]);
                this.aAU = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.aAG, i2);
            int i3 = bVar.getInt();
            long j2 = bVar.getLong();
            this.aAV = i3 + 12;
            if (i3 >= 0 && i3 <= i2 - 12 && j2 == bVar.w(12, i3) && Fd() == 0) {
                this.aAW = j2;
                return true;
            }
        }
        return false;
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.aBd = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strFu = h.Fu();
        if (!h.a(new File(this.RY + this.name, strFu), bArr)) {
            eL("save large value failed");
            return 0;
        }
        this.aBd = strFu;
        byte[] bArr2 = new byte[32];
        strFu.getBytes(0, 32, bArr2, 0);
        return b(str, bArr2, (byte) (b2 | 64));
    }

    private Object a(a.h hVar) {
        Exception exc;
        try {
            byte[] bArrZ = h.Z(new File(this.RY + this.name, (String) hVar.value));
            if (bArrZ != null) {
                int i2 = bArrZ[0] & 255;
                String str = new String(bArrZ, 1, i2, com.kwad.sdk.utils.kwai.b.UTF_8);
                b bVar = this.aAM.get(str);
                if (bVar != null) {
                    int i3 = i2 + 1;
                    return bVar.g(bArrZ, i3, bArrZ.length - i3);
                }
                exc = new Exception("No encoder for tag:" + str);
            } else {
                exc = new Exception("Read object data failed");
            }
            b(exc);
            return null;
        } catch (Exception e2) {
            a(e2);
            return null;
        }
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] bArrZ = h.Z(new File(this.RY + this.name, (String) iVar.value));
            String str = new String(bArrZ);
            return (bArrZ == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.kwai.b.j(bArrZ, com.kwad.sdk.utils.kwai.b.eH(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.kwai.b.UTF_8);
        } catch (Exception e2) {
            a(e2);
        }
        return "";
    }

    private void a(byte b2, int i2) {
        this.aAW ^= c(1L, i2);
        if (this.aBg == 0) {
            MappedByteBuffer mappedByteBuffer = this.aAS;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, this.aAW);
                this.aAS.put(i2, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aAT;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aAW);
                this.aAT.put(i2, b2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aAU;
            if (bVar != null) {
                bVar.c(4, this.aAW);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        if (bVar2 != null) {
            bVar2.aAG[i2] = b2;
        }
    }

    private void a(byte b2, int i2, int i3) {
        byte[] bArr;
        y(i2, i3);
        byte b3 = (byte) (b2 | (-128));
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar != null && (bArr = bVar.aAG) != null) {
            this.aAW = ((((long) (bArr[i2] ^ b3)) & 255) << ((i2 & 7) << 3)) ^ this.aAW;
            bArr[i2] = b3;
        }
        this.aBb = i2;
    }

    private void a(int i2, long j2, int i3) {
        this.aAW = c(j2, i3) ^ this.aAW;
        if (this.aBg == 0) {
            MappedByteBuffer mappedByteBuffer = this.aAS;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, this.aAW);
                this.aAS.putInt(i3, i2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aAT;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aAW);
                this.aAT.putInt(i3, i2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aAU;
            if (bVar != null) {
                bVar.c(4, this.aAW);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        if (bVar2 != null) {
            bVar2.u(i3, i2);
        }
    }

    private void a(int i2, int[] iArr) {
        Map<String, a.b> map = this.aAX;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i3 = bVar.offset;
            if (i3 > i2) {
                int i4 = iArr[(h.binarySearch(iArr, i3) << 1) + 1];
                bVar.offset -= i4;
                if (bVar.EX() >= 6) {
                    ((a.j) bVar).start -= i4;
                }
            }
        }
    }

    private void a(Exception exc) {
        d dVar = this.aAN;
        if (dVar != null) {
            dVar.b(this.name, exc);
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, aAH[b2]);
    }

    private void a(String str, byte b2, int i2) {
        int iEH = com.kwad.sdk.utils.kwai.b.eH(str);
        cl(iEH);
        this.aBa = iEH + 2 + i2;
        Fn();
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar != null) {
            bVar.b(b2);
        }
        o(str, iEH);
    }

    private static void a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5;
        if (i3 <= str.length() && i3 >= 0) {
            int i6 = 0;
            while (i6 < i3) {
                int i7 = i6 + 1;
                char cCharAt = str.charAt(i6);
                if (cCharAt < 128) {
                    i5 = i4 + 1;
                    bArr[i4] = (byte) (((byte) cCharAt) ^ 1);
                } else {
                    i5 = i4 + 1;
                    bArr[i4] = (byte) cCharAt;
                }
                i6 = i7;
                i4 = i5;
            }
        }
    }

    private synchronized <T> void a(String str, T t2, b<T> bVar) {
        eK(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalArgumentException;
            }
            a(illegalArgumentException);
            return;
        }
        String strFs = bVar.Fs();
        if (!strFs.isEmpty() && strFs.length() <= 50) {
            if (!this.aAM.containsKey(strFs)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (com.kwad.a.a.bI.booleanValue()) {
                    throw illegalArgumentException2;
                }
                a(illegalArgumentException2);
                return;
            }
            if (t2 == null) {
                remove(str);
                return;
            }
            byte[] bArrI = null;
            try {
                bArrI = bVar.i(t2);
            } catch (Exception e2) {
                a(e2);
            }
            if (bArrI == null) {
                remove(str);
                return;
            }
            int iEH = com.kwad.sdk.utils.kwai.b.eH(strFs);
            com.kwad.sdk.utils.kwai.b bVar2 = new com.kwad.sdk.utils.kwai.b(iEH + 1 + bArrI.length);
            bVar2.b((byte) iEH);
            bVar2.eG(strFs);
            bVar2.n(bArrI);
            a(str, t2, bVar2.aAG, (a.h) this.aAX.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + strFs);
        if (com.kwad.a.a.bI.booleanValue()) {
            throw illegalArgumentException3;
        }
        a(illegalArgumentException3);
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        int iA = a(str, bArr, b2);
        if (iA != 0) {
            boolean z2 = this.aBd != null;
            if (z2) {
                String str2 = this.aBd;
                this.aBd = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            this.aAX.put(str, b2 == 6 ? new a.i(this.aAZ, iA, (String) obj2, length, z2) : b2 == 7 ? new a.C0458a(this.aAZ, iA, obj2, length, z2) : new a.h(this.aAZ, iA, obj2, length, z2));
            Fl();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int iA = a(str, bArr, jVar.EX());
        if (iA != 0) {
            String str2 = jVar.aAE ? (String) jVar.value : null;
            a(jVar.EX(), jVar.start, jVar.offset + jVar.aAD);
            boolean z2 = this.aBd != null;
            jVar.start = this.aAZ;
            jVar.offset = iA;
            jVar.aAE = z2;
            if (z2) {
                jVar.value = this.aBd;
                jVar.aAD = 32;
                this.aBd = null;
            } else {
                jVar.value = obj;
                jVar.aAD = bArr.length;
            }
            Fl();
            Fo();
            if (str2 != null) {
                h.c(new File(this.RY + this.name, str2));
            }
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.aAE || jVar.aAD != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        Fe();
    }

    private void a(String str, String str2, a.i iVar) {
        int iEH = com.kwad.sdk.utils.kwai.b.eH(str2);
        if (iVar == null) {
            int iEH2 = com.kwad.sdk.utils.kwai.b.eH(str);
            cl(iEH2);
            int i2 = iEH2 + 4;
            this.aBa = i2 + iEH;
            Fn();
            com.kwad.sdk.utils.kwai.b bVar = this.aAU;
            if (bVar != null) {
                bVar.b((byte) 6);
            }
            o(str, iEH2);
            p(str2, iEH);
            Map<String, a.b> map = this.aAX;
            int i3 = this.aAZ;
            map.put(str, new a.i(i3, i3 + i2, str2, iEH, false));
            Fl();
        } else {
            int i4 = iVar.offset;
            int i5 = i4 - iVar.start;
            int i6 = iVar.aAD;
            boolean z2 = true;
            if (i6 == iEH) {
                this.aAW = this.aAU.w(i4, i6) ^ this.aAW;
                if (iEH == str2.length()) {
                    a(str2, 0, iEH, this.aAU.aAG, iVar.offset);
                } else {
                    com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.eG(str2);
                    }
                }
                this.aAZ = iVar.offset;
                this.aBa = iEH;
                z2 = false;
            } else {
                this.aBa = i5 + iEH;
                Fn();
                com.kwad.sdk.utils.kwai.b bVar3 = this.aAU;
                if (bVar3 != null) {
                    bVar3.b((byte) 6);
                }
                int i7 = i5 - 3;
                com.kwad.sdk.utils.kwai.b bVar4 = this.aAU;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aAG;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i7);
                }
                com.kwad.sdk.utils.kwai.b bVar5 = this.aAU;
                if (bVar5 != null) {
                    bVar5.position += i7;
                }
                p(str2, iEH);
                a((byte) 6, iVar.start, iVar.offset + iVar.aAD);
                str = iVar.aAE ? (String) iVar.value : null;
                iVar.aAE = false;
                int i8 = this.aAZ;
                iVar.start = i8;
                iVar.offset = i8 + i5;
                iVar.aAD = iEH;
            }
            iVar.value = str2;
            Fl();
            if (z2) {
                Fo();
            }
            if (str != null) {
                h.c(new File(this.RY + this.name, str));
            }
        }
        Fe();
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer == null) {
            return;
        }
        if (mappedByteBuffer.capacity() != PAGE_SIZE) {
            FileChannel fileChannel = mappedByteBuffer == this.aAS ? this.aAO : this.aAP;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(PAGE_SIZE);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, PAGE_SIZE);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aAS) {
                this.aAS = map;
            } else {
                this.aAT = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i2) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aAT ? this.aAP : this.aAO).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aAT) {
                    this.aAT = map;
                } else {
                    this.aAS = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                a(e2);
                Fi();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i2);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
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
                    b(new Exception("missing encoders"));
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.utils.kwai.b bVar) {
        int length = bVar.aAG.length;
        File file = new File(this.RY, this.name + ".kva");
        File file2 = new File(this.RY, this.name + ".kvb");
        try {
            if (!h.Y(file) || !h.Y(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j2 = length;
            randomAccessFile.setLength(j2);
            randomAccessFile2.setLength(j2);
            this.aAO = randomAccessFile.getChannel();
            this.aAP = randomAccessFile2.getChannel();
            this.aAS = this.aAO.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
            this.aAS.order(ByteOrder.LITTLE_ENDIAN);
            this.aAT = this.aAP.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
            this.aAT.order(ByteOrder.LITTLE_ENDIAN);
            this.aAS.put(bVar.aAG, 0, this.aAV);
            this.aAT.put(bVar.aAG, 0, this.aAV);
            return true;
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    private byte[] a(a.C0458a c0458a) {
        try {
            byte[] bArrZ = h.Z(new File(this.RY + this.name, (String) c0458a.value));
            return bArrZ != null ? bArrZ : aAI;
        } catch (Exception e2) {
            a(e2);
            return aAI;
        }
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        int i2 = bVar2.position;
        bVar2.n(bArr);
        return i2;
    }

    private void b(long j2, long j3, int i2) {
        this.aAW = c(j3, i2) ^ this.aAW;
        if (this.aBg == 0) {
            MappedByteBuffer mappedByteBuffer = this.aAS;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, this.aAW);
                this.aAS.putLong(i2, j2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aAT;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aAW);
                this.aAT.putLong(i2, j2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aAU;
            if (bVar != null) {
                bVar.c(4, this.aAW);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        if (bVar2 != null) {
            bVar2.c(i2, j2);
        }
    }

    private void b(Exception exc) {
        d dVar = this.aAN;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        eK(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0458a) this.aAX.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aBc && mappedByteBuffer != this.aAS) {
            mappedByteBuffer.putInt(0, this.aAV - 12);
        }
        mappedByteBuffer.putLong(4, this.aAW);
        int i2 = this.aBb;
        if (i2 != 0) {
            mappedByteBuffer.put(i2, this.aAU.aAG[i2]);
        }
        if (this.aBa != 0) {
            mappedByteBuffer.position(this.aAZ);
            mappedByteBuffer.put(this.aAU.aAG, this.aAZ, this.aBa);
        }
    }

    private static long c(long j2, int i2) {
        int i3 = (i2 & 7) << 3;
        return (j2 >>> (64 - i3)) | (j2 << i3);
    }

    private static void cl(int i2) {
        if (i2 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void cm(int i2) {
        int length = this.aAU.aAG.length;
        int i3 = this.aAV + i2;
        if (i3 >= length) {
            int i4 = this.aBe;
            if (i4 > i2 && i4 > Fm()) {
                cn(i2);
                return;
            }
            int iX = x(length, i3);
            byte[] bArr = new byte[iX];
            System.arraycopy(this.aAU.aAG, 0, bArr, 0, this.aAV);
            this.aAU.aAG = bArr;
            if (this.aBg == 0) {
                try {
                    long j2 = iX;
                    this.aAS = this.aAO.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                    this.aAS.order(ByteOrder.LITTLE_ENDIAN);
                    this.aAT = this.aAP.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                    this.aAT.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    a(new Exception("map failed", th));
                    this.aAU.u(0, this.aAV - 12);
                    this.aAU.c(4, this.aAW);
                    Fi();
                }
            }
        }
    }

    private void cn(int i2) {
        int i3;
        ArrayList<e> arrayList = this.aBf;
        if (arrayList == null || this.aAU == null) {
            return;
        }
        Collections.sort(arrayList);
        Fp();
        e eVar = this.aBf.get(0);
        int i4 = eVar.start;
        int i5 = this.aAV;
        int i6 = i5 - this.aBe;
        int i7 = i6 - 12;
        int i8 = i6 - i4;
        int i9 = i5 - i4;
        boolean z2 = i7 < i9 + i8;
        if (!z2) {
            this.aAW ^= this.aAU.w(i4, i9);
        }
        int size = this.aBf.size();
        int i10 = size - 1;
        int i11 = this.aAV - this.aBf.get(i10).end;
        int[] iArr = new int[(i11 > 0 ? size : i10) << 1];
        int i12 = eVar.start;
        int i13 = eVar.end;
        for (int i14 = 1; i14 < size; i14++) {
            e eVar2 = this.aBf.get(i14);
            int i15 = eVar2.start - i13;
            byte[] bArr = this.aAU.aAG;
            System.arraycopy(bArr, i13, bArr, i12, i15);
            int i16 = (i14 - 1) << 1;
            iArr[i16] = i13;
            iArr[i16 + 1] = i13 - i12;
            i12 += i15;
            i13 = eVar2.end;
        }
        if (i11 > 0) {
            byte[] bArr2 = this.aAU.aAG;
            System.arraycopy(bArr2, i13, bArr2, i12, i11);
            int i17 = i10 << 1;
            iArr[i17] = i13;
            iArr[i17 + 1] = i13 - i12;
        }
        Fq();
        this.aAW = z2 ? this.aAU.w(12, i7) : this.aAW ^ this.aAU.w(i4, i8);
        this.aAV = i6;
        if (this.aBg == 0) {
            MappedByteBuffer mappedByteBuffer = this.aAS;
            if (mappedByteBuffer != null) {
                i3 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aAS.putLong(4, this.aAW);
                this.aAS.position(i4);
                this.aAS.put(this.aAU.aAG, i4, i8);
                this.aAS.putInt(0, i7);
            } else {
                i3 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aAT;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i3, i7);
                this.aAT.putLong(4, this.aAW);
                this.aAT.position(i4);
                this.aAT.put(this.aAU.aAG, i4, i8);
            }
        } else {
            this.aAU.u(0, i7);
            this.aAU.c(4, this.aAW);
        }
        a(i4, iArr);
        int i18 = i6 + i2;
        if (this.aAU.aAG.length - i18 > aAL) {
            co(i18);
        }
        info("gc finish");
    }

    private void co(int i2) {
        int i3 = PAGE_SIZE;
        int iX = x(i3, i2 + i3);
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar != null) {
            byte[] bArr = bVar.aAG;
            if (iX >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[iX];
            System.arraycopy(bArr, 0, bArr2, 0, this.aAV);
            this.aAU.aAG = bArr2;
        }
        if (this.aBg == 0) {
            try {
                long j2 = iX;
                this.aAO.truncate(j2);
                this.aAS = this.aAO.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                this.aAS.order(ByteOrder.LITTLE_ENDIAN);
                this.aAP.truncate(j2);
                this.aAT = this.aAP.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                this.aAT.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                a(new Exception("map failed", th));
                Fi();
            }
        }
        info("truncate finish");
    }

    private static void e(int i2, boolean z2) {
        if (z2) {
            if (i2 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i2 < 0 || i2 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private static void eK(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void eL(String str) {
        d dVar = this.aAN;
        if (dVar != null) {
            dVar.b(this.name, new Exception(str));
        }
    }

    private void f(File file, File file2) {
        try {
            if (X(file)) {
                return;
            }
        } catch (IOException e2) {
            b(e2);
        }
        Fk();
        try {
            if (X(file2)) {
                return;
            }
        } catch (Exception e3) {
            b(e3);
        }
        Fk();
    }

    private void info(String str) {
        d dVar = this.aAN;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void o(String str, int i2) {
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar == null) {
            return;
        }
        bVar.b((byte) i2);
        if (i2 != str.length()) {
            this.aAU.eG(str);
            return;
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
        a(str, 0, i2, bVar2.aAG, bVar2.position);
        this.aAU.position += i2;
    }

    private void p(String str, int i2) {
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i2);
        if (i2 != str.length()) {
            this.aAU.eG(str);
        } else {
            com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
            a(str, 0, i2, bVar2.aAG, bVar2.position);
        }
    }

    private synchronized void putDouble(String str, double d2) {
        eK(str);
        a.d dVar = (a.d) this.aAX.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ jDoubleToRawLongBits;
                dVar.value = d2;
                b(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.offset);
                Fe();
            }
            return;
        }
        a(str, (byte) 5);
        if (this.aAU != null) {
            int i2 = this.aAU.position;
            this.aAU.ai(Double.doubleToRawLongBits(d2));
            Fl();
            if (this.aAX != null) {
                this.aAX.put(str, new a.d(i2, d2));
            }
        }
        Fe();
    }

    private synchronized void putFloat(String str, float f2) {
        eK(str);
        a.e eVar = (a.e) this.aAX.get(str);
        if (eVar != null) {
            if (eVar.value != f2) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f2);
                long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.value) ^ iFloatToRawIntBits)) & 4294967295L;
                eVar.value = f2;
                a(iFloatToRawIntBits, jFloatToRawIntBits, eVar.offset);
                Fe();
            }
            return;
        }
        a(str, (byte) 3);
        if (this.aAU != null) {
            int i2 = this.aAU.position;
            this.aAU.ce(Float.floatToRawIntBits(f2));
            Fl();
            if (this.aAX != null) {
                this.aAX.put(str, new a.e(i2, f2));
            }
        }
        Fe();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, set, g.aBz);
        }
    }

    private void updateBytes(int i2, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.kwai.b bVar = this.aAU;
        if (bVar != null) {
            this.aAW ^= bVar.w(i2, length);
            com.kwad.sdk.utils.kwai.b bVar2 = this.aAU;
            bVar2.position = i2;
            bVar2.n(bArr);
            this.aAW ^= this.aAU.w(i2, length);
        }
        if (this.aBg != 0) {
            com.kwad.sdk.utils.kwai.b bVar3 = this.aAU;
            if (bVar3 != null) {
                bVar3.c(4, this.aAW);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.aAS;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.aAS.putLong(4, this.aAW);
            this.aAS.position(i2);
            this.aAS.put(bArr);
            this.aAS.putInt(0, this.aAV - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.aAT;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.aAW);
            this.aAT.position(i2);
            this.aAT.put(bArr);
        }
    }

    private int x(int i2, int i3) {
        if (i3 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalStateException;
            }
            a(illegalStateException);
        }
        int i4 = PAGE_SIZE;
        if (i3 <= i4) {
            return i4;
        }
        while (i2 < i3) {
            int i5 = aAK;
            i2 = i2 <= i5 ? i2 << 1 : i2 + i5;
        }
        return i2;
    }

    private void y(int i2, int i3) {
        this.aBe += i3 - i2;
        ArrayList<e> arrayList = this.aBf;
        if (arrayList != null) {
            arrayList.add(new e(i2, i3));
        }
    }

    public final synchronized void clear() {
        Fj();
        if (this.aBg != 0) {
            Fh();
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aAX.containsKey(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[Catch: all -> 0x00a2, PHI: r2
  0x0060: PHI (r2v22 com.kwad.sdk.utils.kwai.a$j) = (r2v27 com.kwad.sdk.utils.kwai.a$j), (r2v28 com.kwad.sdk.utils.kwai.a$j), (r2v29 com.kwad.sdk.utils.kwai.a$j) binds: [B:24:0x0068, B:19:0x0059, B:17:0x0052] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0010, B:9:0x0025, B:11:0x002b, B:12:0x0042, B:31:0x009c, B:14:0x0046, B:16:0x004d, B:17:0x0052, B:21:0x0060, B:18:0x0055, B:20:0x005b, B:23:0x0064, B:25:0x006a, B:26:0x006f, B:27:0x0078, B:28:0x0081, B:29:0x008a, B:30:0x0093), top: B:40:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.Map<java.lang.String, java.lang.Object> getAll() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.Map<java.lang.String, com.kwad.sdk.utils.kwai.a$b> r0 = r6.aAX     // Catch: java.lang.Throwable -> La2
            int r0 = r0.size()     // Catch: java.lang.Throwable -> La2
            if (r0 != 0) goto L10
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> La2
            r0.<init>()     // Catch: java.lang.Throwable -> La2
            monitor-exit(r6)
            return r0
        L10:
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> La2
            int r0 = r0 * 4
            int r0 = r0 / 3
            int r0 = r0 + 1
            r1.<init>(r0)     // Catch: java.lang.Throwable -> La2
            java.util.Map<java.lang.String, com.kwad.sdk.utils.kwai.a$b> r0 = r6.aAX     // Catch: java.lang.Throwable -> La2
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> La2
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> La2
        L25:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La0
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> La2
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> La2
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> La2
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> La2
            com.kwad.sdk.utils.kwai.a$b r2 = (com.kwad.sdk.utils.kwai.a.b) r2     // Catch: java.lang.Throwable -> La2
            r4 = 0
            byte r5 = r2.EX()     // Catch: java.lang.Throwable -> La2
            switch(r5) {
                case 1: goto L93;
                case 2: goto L8a;
                case 3: goto L81;
                case 4: goto L78;
                case 5: goto L6f;
                case 6: goto L64;
                case 7: goto L55;
                case 8: goto L46;
                default: goto L45;
            }     // Catch: java.lang.Throwable -> La2
        L45:
            goto L9c
        L46:
            r4 = r2
            com.kwad.sdk.utils.kwai.a$h r4 = (com.kwad.sdk.utils.kwai.a.h) r4     // Catch: java.lang.Throwable -> La2
            boolean r5 = r4.aAE     // Catch: java.lang.Throwable -> La2
            if (r5 == 0) goto L52
            java.lang.Object r2 = r6.a(r4)     // Catch: java.lang.Throwable -> La2
            goto L62
        L52:
            com.kwad.sdk.utils.kwai.a$h r2 = (com.kwad.sdk.utils.kwai.a.h) r2     // Catch: java.lang.Throwable -> La2
            goto L60
        L55:
            com.kwad.sdk.utils.kwai.a$a r2 = (com.kwad.sdk.utils.kwai.a.C0458a) r2     // Catch: java.lang.Throwable -> La2
            boolean r4 = r2.aAE     // Catch: java.lang.Throwable -> La2
            if (r4 == 0) goto L60
            byte[] r2 = r6.a(r2)     // Catch: java.lang.Throwable -> La2
            goto L62
        L60:
            java.lang.Object r2 = r2.value     // Catch: java.lang.Throwable -> La2
        L62:
            r4 = r2
            goto L9c
        L64:
            com.kwad.sdk.utils.kwai.a$i r2 = (com.kwad.sdk.utils.kwai.a.i) r2     // Catch: java.lang.Throwable -> La2
            boolean r4 = r2.aAE     // Catch: java.lang.Throwable -> La2
            if (r4 == 0) goto L60
            java.lang.String r2 = r6.a(r2)     // Catch: java.lang.Throwable -> La2
            goto L62
        L6f:
            com.kwad.sdk.utils.kwai.a$d r2 = (com.kwad.sdk.utils.kwai.a.d) r2     // Catch: java.lang.Throwable -> La2
            double r4 = r2.value     // Catch: java.lang.Throwable -> La2
            java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch: java.lang.Throwable -> La2
            goto L62
        L78:
            com.kwad.sdk.utils.kwai.a$g r2 = (com.kwad.sdk.utils.kwai.a.g) r2     // Catch: java.lang.Throwable -> La2
            long r4 = r2.value     // Catch: java.lang.Throwable -> La2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> La2
            goto L62
        L81:
            com.kwad.sdk.utils.kwai.a$e r2 = (com.kwad.sdk.utils.kwai.a.e) r2     // Catch: java.lang.Throwable -> La2
            float r2 = r2.value     // Catch: java.lang.Throwable -> La2
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch: java.lang.Throwable -> La2
            goto L62
        L8a:
            com.kwad.sdk.utils.kwai.a$f r2 = (com.kwad.sdk.utils.kwai.a.f) r2     // Catch: java.lang.Throwable -> La2
            int r2 = r2.value     // Catch: java.lang.Throwable -> La2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> La2
            goto L62
        L93:
            com.kwad.sdk.utils.kwai.a$c r2 = (com.kwad.sdk.utils.kwai.a.c) r2     // Catch: java.lang.Throwable -> La2
            boolean r2 = r2.value     // Catch: java.lang.Throwable -> La2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> La2
            goto L62
        L9c:
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> La2
            goto L25
        La0:
            monitor-exit(r6)
            return r1
        La2:
            r0 = move-exception
            monitor-exit(r6)
            goto La6
        La5:
            throw r0
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.getAll():java.util.Map");
    }

    public final synchronized boolean getBoolean(String str, boolean z2) {
        a.c cVar = (a.c) this.aAX.get(str);
        if (cVar == null) {
            return z2;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i2) {
        a.f fVar = (a.f) this.aAX.get(str);
        if (fVar == null) {
            return i2;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j2) {
        a.g gVar = (a.g) this.aAX.get(str);
        if (gVar == null) {
            return j2;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aAX.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.aAE) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z2) {
        eK(str);
        a.c cVar = (a.c) this.aAX.get(str);
        if (cVar != null) {
            if (cVar.value != z2) {
                cVar.value = z2;
                a((byte) (z2 ? 1 : 0), cVar.offset);
                Fe();
            }
            return;
        }
        a(str, (byte) 1);
        if (this.aAU != null) {
            int i2 = this.aAU.position;
            this.aAU.b((byte) (z2 ? 1 : 0));
            Fl();
            if (this.aAX != null) {
                this.aAX.put(str, new a.c(i2, z2));
            }
        }
        Fe();
    }

    public final synchronized void putInt(String str, int i2) {
        eK(str);
        a.f fVar = (a.f) this.aAX.get(str);
        if (fVar != null) {
            if (fVar.value != i2) {
                long j2 = ((long) (fVar.value ^ i2)) & 4294967295L;
                fVar.value = i2;
                a(i2, j2, fVar.offset);
                Fe();
            }
            return;
        }
        a(str, (byte) 2);
        if (this.aAU != null) {
            int i3 = this.aAU.position;
            this.aAU.ce(i2);
            Fl();
            if (this.aAX != null) {
                this.aAX.put(str, new a.f(i3, i2));
            }
        }
        Fe();
    }

    public final synchronized void putLong(String str, long j2) {
        eK(str);
        a.g gVar = (a.g) this.aAX.get(str);
        if (gVar != null) {
            if (gVar.value != j2) {
                long j3 = j2 ^ gVar.value;
                gVar.value = j2;
                b(j2, j3, gVar.offset);
                Fe();
            }
            return;
        }
        a(str, (byte) 4);
        if (this.aAU != null) {
            int i2 = this.aAU.position;
            this.aAU.ai(j2);
            Fl();
            if (this.aAX != null) {
                this.aAX.put(str, new a.g(i2, j2));
            }
        }
        Fe();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArr;
        byte[] bArrEJ;
        byte[] bArr2;
        eK(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aAX.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (!str2.isEmpty()) {
            if (iVar != null || str2.length() >= 2048) {
                if (iVar != null && !iVar.aAE) {
                    int iEH = com.kwad.sdk.utils.kwai.b.eH(str2);
                    bArr = new byte[iEH];
                    if (iEH == str2.length()) {
                        a(str2, 0, iEH, bArr, 0);
                        bArr2 = bArr;
                    }
                }
                bArrEJ = com.kwad.sdk.utils.kwai.b.eJ(str2);
            } else {
                int iEH2 = com.kwad.sdk.utils.kwai.b.eH(str2);
                bArr = new byte[iEH2];
                if (iEH2 == str2.length()) {
                    a(str2, 0, iEH2, bArr, 0);
                    bArr2 = bArr;
                }
                bArrEJ = com.kwad.sdk.utils.kwai.b.eJ(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArrEJ = aAI;
        bArr2 = bArrEJ;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aAQ);
        h.closeQuietly(this.aAR);
        h.closeQuietly(this.aAO);
        h.closeQuietly(this.aAP);
        this.aAO = null;
        this.aAP = null;
        this.aAS = null;
        this.aAT = null;
        String str = this.RY + this.name;
        C0459c c0459c = a.aBl;
        C0459c.remove(str);
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.aAX.get(str);
        if (bVar != null) {
            this.aAX.remove(str);
            byte bEX = bVar.EX();
            String str2 = null;
            if (bEX <= 5) {
                a(bEX, bVar.offset - (com.kwad.sdk.utils.kwai.b.eH(str) + 2), bVar.offset + aAH[bEX]);
            } else {
                a.j jVar = (a.j) bVar;
                a(bEX, jVar.start, jVar.offset + jVar.aAD);
                if (jVar.aAE) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (bEX | (-128));
            if (this.aBg == 0) {
                if (this.aAS != null) {
                    this.aAS.putLong(4, this.aAW);
                    this.aAS.put(this.aBb, b2);
                }
                if (this.aAT != null) {
                    this.aAT.putLong(4, this.aAW);
                    this.aAT.put(this.aBb, b2);
                }
            } else if (this.aAU != null) {
                this.aAU.c(4, this.aAW);
            }
            this.aBb = 0;
            if (str2 != null) {
                h.c(new File(this.RY + this.name, str2));
            }
            Fo();
            Fe();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.RY + " name:" + this.name;
    }
}
