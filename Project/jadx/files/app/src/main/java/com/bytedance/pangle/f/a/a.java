package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    int a;
    b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f14572c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14578i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private f f14580k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14579j = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c f14581l = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f14573d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f14574e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14575f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f14576g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f14577h = 4;

    public a() {
        c();
    }

    private int e(int i2) {
        if (this.a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.f14572c.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public final void a() {
        if (this.f14579j) {
            this.f14579j = false;
            b bVar = this.b;
            InputStream inputStream = bVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.f14580k = null;
            this.b = null;
            c cVar = this.f14581l;
            cVar.b = 0;
            cVar.f14582c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0112, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x023e, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc A[Catch: IOException -> 0x024a, TryCatch #0 {IOException -> 0x024a, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0009, B:8:0x0042, B:12:0x004a, B:14:0x004f, B:16:0x0059, B:18:0x005e, B:19:0x0064, B:20:0x0069, B:21:0x006a, B:22:0x0074, B:23:0x0079, B:24:0x007a, B:26:0x0080, B:27:0x0085, B:29:0x008a, B:31:0x0092, B:33:0x00a0, B:34:0x00ac, B:36:0x00b0, B:38:0x00b6, B:43:0x00c6, B:41:0x00bd, B:44:0x00cc, B:50:0x00e4, B:52:0x00ee, B:54:0x00f2, B:55:0x00fc, B:56:0x0112, B:64:0x0122, B:65:0x0128, B:71:0x0142, B:72:0x016b, B:74:0x0170, B:75:0x017b, B:78:0x018b, B:80:0x019f, B:82:0x01b6, B:84:0x01c8, B:85:0x01cb, B:86:0x01f7, B:88:0x0207, B:90:0x0210, B:91:0x0228, B:92:0x023e, B:47:0x00d7, B:93:0x023f, B:95:0x0242, B:96:0x0249), top: B:101:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i2) {
        return this.f14572c[e(i2) + 4];
    }

    public final String d(int i2) {
        int iE = e(i2);
        int[] iArr = this.f14572c;
        if (iArr[iE + 3] != 3) {
            return "";
        }
        return this.f14580k.a(iArr[iE + 2]);
    }

    private void c() {
        this.f14572c = null;
        this.a = -1;
    }

    public final String a(int i2) {
        int i3 = this.f14572c[e(i2) + 1];
        return i3 == -1 ? "" : this.f14580k.a(i3);
    }

    public final int b(int i2) {
        return this.f14572c[e(i2) + 3];
    }
}
