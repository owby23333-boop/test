package com.bytedance.sdk.component.dl.g.z.gc;

import com.bytedance.sdk.component.dl.z.js;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    static final dl[] z = {new dl(dl.m, ""), new dl(dl.dl, "GET"), new dl(dl.dl, "POST"), new dl(dl.f665a, "/"), new dl(dl.f665a, "/index.html"), new dl(dl.gc, "http"), new dl(dl.gc, "https"), new dl(dl.g, "200"), new dl(dl.g, "204"), new dl(dl.g, "206"), new dl(dl.g, "304"), new dl(dl.g, "400"), new dl(dl.g, "404"), new dl(dl.g, "500"), new dl("accept-charset", ""), new dl("accept-encoding", "gzip, deflate"), new dl("accept-language", ""), new dl("accept-ranges", ""), new dl("accept", ""), new dl("access-control-allow-origin", ""), new dl("age", ""), new dl("allow", ""), new dl("authorization", ""), new dl("cache-control", ""), new dl("content-disposition", ""), new dl("content-encoding", ""), new dl("content-language", ""), new dl("content-length", ""), new dl("content-location", ""), new dl("content-range", ""), new dl("content-type", ""), new dl("cookie", ""), new dl("date", ""), new dl("etag", ""), new dl("expect", ""), new dl("expires", ""), new dl("from", ""), new dl("host", ""), new dl("if-match", ""), new dl("if-modified-since", ""), new dl("if-none-match", ""), new dl("if-range", ""), new dl("if-unmodified-since", ""), new dl("last-modified", ""), new dl("link", ""), new dl("location", ""), new dl("max-forwards", ""), new dl("proxy-authenticate", ""), new dl("proxy-authorization", ""), new dl("range", ""), new dl("referer", ""), new dl("refresh", ""), new dl("retry-after", ""), new dl("server", ""), new dl("set-cookie", ""), new dl("strict-transport-security", ""), new dl("transfer-encoding", ""), new dl("user-agent", ""), new dl("vary", ""), new dl("via", ""), new dl("www-authenticate", "")};
    static final Map<com.bytedance.sdk.component.dl.z.m, Integer> g = z();

    static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f664a;
        int dl;
        private final int e;
        int g;
        private final List<dl> gc;
        private int gz;
        private final com.bytedance.sdk.component.dl.z.gc m;
        dl[] z;

        z(int i, js jsVar) {
            this(i, i, jsVar);
        }

        z(int i, int i2, js jsVar) {
            this.gc = new ArrayList();
            this.z = new dl[8];
            this.g = r0.length - 1;
            this.dl = 0;
            this.f664a = 0;
            this.e = i;
            this.gz = i2;
            this.m = com.bytedance.sdk.component.dl.z.wp.z(jsVar);
        }

        private void a() {
            int i = this.gz;
            int i2 = this.f664a;
            if (i < i2) {
                if (i == 0) {
                    gc();
                } else {
                    z(i2 - i);
                }
            }
        }

        private void gc() {
            Arrays.fill(this.z, (Object) null);
            this.g = this.z.length - 1;
            this.dl = 0;
            this.f664a = 0;
        }

        private int z(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.z.length;
                while (true) {
                    length--;
                    i2 = this.g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.z[length].fo;
                    this.f664a -= this.z[length].fo;
                    this.dl--;
                    i3++;
                }
                dl[] dlVarArr = this.z;
                System.arraycopy(dlVarArr, i2 + 1, dlVarArr, i2 + 1 + i3, this.dl);
                this.g += i3;
            }
            return i3;
        }

        void z() throws IOException {
            while (!this.m.gc()) {
                int iGz = this.m.gz() & 255;
                if (iGz == 128) {
                    throw new IOException("index == 0");
                }
                if ((iGz & 128) == 128) {
                    g(z(iGz, 127) - 1);
                } else if (iGz == 64) {
                    e();
                } else if ((iGz & 64) == 64) {
                    gc(z(iGz, 63) - 1);
                } else if ((iGz & 32) == 32) {
                    int iZ = z(iGz, 31);
                    this.gz = iZ;
                    if (iZ < 0 || iZ > this.e) {
                        throw new IOException("Invalid dynamic table size update " + this.gz);
                    }
                    a();
                } else if (iGz == 16 || iGz == 0) {
                    m();
                } else {
                    a(z(iGz, 15) - 1);
                }
            }
        }

        public List<dl> g() {
            ArrayList arrayList = new ArrayList(this.gc);
            this.gc.clear();
            return arrayList;
        }

        private void g(int i) throws IOException {
            if (e(i)) {
                this.gc.add(a.z[i]);
                return;
            }
            int iDl = dl(i - a.z.length);
            if (iDl >= 0) {
                dl[] dlVarArr = this.z;
                if (iDl <= dlVarArr.length - 1) {
                    this.gc.add(dlVarArr[iDl]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int dl(int i) {
            return this.g + 1 + i;
        }

        private void a(int i) throws IOException {
            this.gc.add(new dl(m(i), dl()));
        }

        private void m() throws IOException {
            this.gc.add(new dl(a.z(dl()), dl()));
        }

        private void gc(int i) throws IOException {
            z(-1, new dl(m(i), dl()));
        }

        private void e() throws IOException {
            z(-1, new dl(a.z(dl()), dl()));
        }

        private com.bytedance.sdk.component.dl.z.m m(int i) {
            if (e(i)) {
                return a.z[i].e;
            }
            return this.z[dl(i - a.z.length)].e;
        }

        private boolean e(int i) {
            return i >= 0 && i <= a.z.length - 1;
        }

        private void z(int i, dl dlVar) {
            this.gc.add(dlVar);
            int i2 = dlVar.fo;
            if (i != -1) {
                i2 -= this.z[dl(i)].fo;
            }
            int i3 = this.gz;
            if (i2 > i3) {
                gc();
                return;
            }
            int iZ = z((this.f664a + i2) - i3);
            if (i == -1) {
                int i4 = this.dl + 1;
                dl[] dlVarArr = this.z;
                if (i4 > dlVarArr.length) {
                    dl[] dlVarArr2 = new dl[dlVarArr.length * 2];
                    System.arraycopy(dlVarArr, 0, dlVarArr2, dlVarArr.length, dlVarArr.length);
                    this.g = this.z.length - 1;
                    this.z = dlVarArr2;
                }
                int i5 = this.g;
                this.g = i5 - 1;
                this.z[i5] = dlVar;
                this.dl++;
            } else {
                this.z[i + dl(i) + iZ] = dlVar;
            }
            this.f664a += i2;
        }

        private int gz() throws IOException {
            return this.m.gz() & 255;
        }

        int z(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iGz = gz();
                if ((iGz & 128) == 0) {
                    return i2 + (iGz << i4);
                }
                i2 += (iGz & 127) << i4;
                i4 += 7;
            }
        }

        com.bytedance.sdk.component.dl.z.m dl() throws IOException {
            int iGz = gz();
            boolean z = (iGz & 128) == 128;
            int iZ = z(iGz, 127);
            if (z) {
                return com.bytedance.sdk.component.dl.z.m.z(kb.z().z(this.m.e(iZ)));
            }
            return this.m.dl(iZ);
        }
    }

    private static Map<com.bytedance.sdk.component.dl.z.m, Integer> z() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(z.length);
        int i = 0;
        while (true) {
            dl[] dlVarArr = z;
            if (i < dlVarArr.length) {
                if (!linkedHashMap.containsKey(dlVarArr[i].e)) {
                    linkedHashMap.put(dlVarArr[i].e, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f663a;
        dl[] dl;
        private final com.bytedance.sdk.component.dl.z.dl e;
        private int fo;
        int g;
        int gc;
        private final boolean gz;
        int m;
        private boolean uy;
        int z;

        g(com.bytedance.sdk.component.dl.z.dl dlVar) {
            this(4096, true, dlVar);
        }

        g(int i, boolean z, com.bytedance.sdk.component.dl.z.dl dlVar) {
            this.fo = Integer.MAX_VALUE;
            this.dl = new dl[8];
            this.f663a = r0.length - 1;
            this.gc = 0;
            this.m = 0;
            this.z = i;
            this.g = i;
            this.gz = z;
            this.e = dlVar;
        }

        private void z() {
            Arrays.fill(this.dl, (Object) null);
            this.f663a = this.dl.length - 1;
            this.gc = 0;
            this.m = 0;
        }

        private int g(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dl.length;
                while (true) {
                    length--;
                    i2 = this.f663a;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.dl[length].fo;
                    this.m -= this.dl[length].fo;
                    this.gc--;
                    i3++;
                }
                dl[] dlVarArr = this.dl;
                System.arraycopy(dlVarArr, i2 + 1, dlVarArr, i2 + 1 + i3, this.gc);
                dl[] dlVarArr2 = this.dl;
                int i4 = this.f663a;
                Arrays.fill(dlVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.f663a += i3;
            }
            return i3;
        }

        private void z(dl dlVar) {
            int i = dlVar.fo;
            int i2 = this.g;
            if (i > i2) {
                z();
                return;
            }
            g((this.m + i) - i2);
            int i3 = this.gc + 1;
            dl[] dlVarArr = this.dl;
            if (i3 > dlVarArr.length) {
                dl[] dlVarArr2 = new dl[dlVarArr.length * 2];
                System.arraycopy(dlVarArr, 0, dlVarArr2, dlVarArr.length, dlVarArr.length);
                this.f663a = this.dl.length - 1;
                this.dl = dlVarArr2;
            }
            int i4 = this.f663a;
            this.f663a = i4 - 1;
            this.dl[i4] = dlVar;
            this.gc++;
            this.m += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void z(java.util.List<com.bytedance.sdk.component.dl.g.z.gc.dl> r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.gc.a.g.z(java.util.List):void");
        }

        void z(int i, int i2, int i3) {
            if (i < i2) {
                this.e.fo(i | i3);
                return;
            }
            this.e.fo(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.e.fo(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.e.fo(i4);
        }

        void z(com.bytedance.sdk.component.dl.z.m mVar) throws IOException {
            if (this.gz && kb.z().z(mVar) < mVar.e()) {
                com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
                kb.z().z(mVar, dlVar);
                com.bytedance.sdk.component.dl.z.m mVarV = dlVar.v();
                z(mVarV.e(), 127, 128);
                this.e.g(mVarV);
                return;
            }
            z(mVar.e(), 127, 0);
            this.e.g(mVar);
        }

        void z(int i) {
            this.z = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.g;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.fo = Math.min(this.fo, iMin);
            }
            this.uy = true;
            this.g = iMin;
            g();
        }

        private void g() {
            int i = this.g;
            int i2 = this.m;
            if (i < i2) {
                if (i == 0) {
                    z();
                } else {
                    g(i2 - i);
                }
            }
        }
    }

    static com.bytedance.sdk.component.dl.z.m z(com.bytedance.sdk.component.dl.z.m mVar) throws IOException {
        int iE = mVar.e();
        for (int i = 0; i < iE; i++) {
            byte bZ = mVar.z(i);
            if (bZ >= 65 && bZ <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + mVar.z());
            }
        }
        return mVar;
    }
}
