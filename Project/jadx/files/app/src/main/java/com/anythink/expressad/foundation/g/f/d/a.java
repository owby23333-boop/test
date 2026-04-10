package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a extends i<Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10522c = a.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f10523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f10524e;

    public a(File file, String str) {
        super(str);
        this.f10523d = file;
        this.f10524e = new File(file + ".tmp");
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    protected final k<Void> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        return !f() ? (!this.f10524e.canRead() || this.f10524e.length() <= 0) ? k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : this.f10524e.renameTo(this.f10523d) ? k.a(null, cVar) : k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : k.a(new com.anythink.expressad.foundation.g.f.a.a(-2, cVar));
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final int j() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        r15.b(r13);
     */
    @Override // com.anythink.expressad.foundation.g.f.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a(com.anythink.expressad.foundation.g.f.f.b r14, com.anythink.expressad.foundation.g.f.c r15) throws java.lang.Throwable {
        /*
            r13 = this;
            java.util.List r0 = r14.b()
            java.lang.String r1 = "Content-Length"
            java.lang.String r0 = com.anythink.expressad.foundation.g.f.g.e.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L1b
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r0 = r0.longValue()
            goto L1c
        L1b:
            r0 = r2
        L1c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L27
            java.lang.String r4 = com.anythink.expressad.foundation.g.f.d.a.f10522c
            java.lang.String r5 = "Response doesn't present Content-Length!"
            com.anythink.expressad.foundation.h.o.b(r4, r5)
        L27:
            r10 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L45
            java.io.File r4 = r13.f10523d
            long r4 = r4.length()
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L45
            java.io.File r14 = r13.f10523d
            java.io.File r2 = r13.f10524e
            r14.renameTo(r2)
            r4 = r15
            r5 = r13
            r6 = r0
            r8 = r0
            r4.a(r5, r6, r8)
            return r10
        L45:
            java.io.RandomAccessFile r11 = new java.io.RandomAccessFile
            java.io.File r4 = r13.f10524e
            java.lang.String r4 = r4.getAbsolutePath()
            java.lang.String r5 = "rw"
            r11.<init>(r4, r5)
            r11.setLength(r2)
            java.io.InputStream r4 = r14.c()     // Catch: java.lang.Throwable -> La9
            java.util.List r14 = r14.b()     // Catch: java.lang.Throwable -> La7
            boolean r14 = com.anythink.expressad.foundation.g.f.g.e.b(r14)     // Catch: java.lang.Throwable -> La7
            if (r14 == 0) goto L6d
            boolean r14 = r4 instanceof java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> La7
            if (r14 != 0) goto L6d
            java.util.zip.GZIPInputStream r14 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> La7
            r14.<init>(r4)     // Catch: java.lang.Throwable -> La7
            goto L6e
        L6d:
            r14 = r4
        L6e:
            r4 = 6144(0x1800, float:8.61E-42)
            byte[] r12 = new byte[r4]     // Catch: java.lang.Throwable -> La3
        L72:
            int r4 = r14.read(r12)     // Catch: java.lang.Throwable -> La3
            r5 = -1
            if (r4 == r5) goto L8f
            r5 = 0
            r11.write(r12, r5, r4)     // Catch: java.lang.Throwable -> La3
            long r4 = (long) r4     // Catch: java.lang.Throwable -> La3
            long r2 = r2 + r4
            r4 = r15
            r5 = r13
            r6 = r0
            r8 = r2
            r4.a(r5, r6, r8)     // Catch: java.lang.Throwable -> La3
            boolean r4 = r13.f()     // Catch: java.lang.Throwable -> La3
            if (r4 == 0) goto L72
            r15.b(r13)     // Catch: java.lang.Throwable -> La3
        L8f:
            if (r14 == 0) goto L9f
            r14.close()     // Catch: java.lang.Exception -> L95
            goto L9f
        L95:
            r14 = move-exception
            java.lang.String r15 = com.anythink.expressad.foundation.g.f.d.a.f10522c
            java.lang.String r14 = r14.getMessage()
            com.anythink.expressad.foundation.h.o.d(r15, r14)
        L9f:
            r11.close()
            return r10
        La3:
            r15 = move-exception
            r4 = r14
            r14 = r15
            goto Lab
        La7:
            r14 = move-exception
            goto Lab
        La9:
            r14 = move-exception
            r4 = r10
        Lab:
            if (r4 == 0) goto Lbb
            r4.close()     // Catch: java.lang.Exception -> Lb1
            goto Lbb
        Lb1:
            r15 = move-exception
            java.lang.String r0 = com.anythink.expressad.foundation.g.f.d.a.f10522c
            java.lang.String r15 = r15.getMessage()
            com.anythink.expressad.foundation.h.o.d(r0, r15)
        Lbb:
            r11.close()
            goto Lc0
        Lbf:
            throw r14
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.f.d.a.a(com.anythink.expressad.foundation.g.f.f.b, com.anythink.expressad.foundation.g.f.c):byte[]");
    }
}
