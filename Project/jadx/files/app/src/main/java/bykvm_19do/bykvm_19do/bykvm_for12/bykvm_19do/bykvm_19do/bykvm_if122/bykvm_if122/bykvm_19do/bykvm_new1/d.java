package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import cn.bmob.v3.datatype.up.ParallelUploader;
import cn.bmob.v3.datatype.up.Params;
import com.anythink.core.api.ATCustomRuleKeys;
import com.baidu.mobads.sdk.internal.ch;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class d {
    static final c[] a = {new c(c.f1016i, ""), new c(c.f1013f, "GET"), new c(c.f1013f, "POST"), new c(c.f1014g, "/"), new c(c.f1014g, "/index.html"), new c(c.f1015h, "http"), new c(c.f1015h, "https"), new c(c.f1012e, "200"), new c(c.f1012e, "204"), new c(c.f1012e, "206"), new c(c.f1012e, "304"), new c(c.f1012e, "400"), new c(c.f1012e, ch.b), new c(c.f1012e, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c(ParallelUploader.Params.ACCEPT, ""), new c("access-control-allow-origin", ""), new c(ATCustomRuleKeys.AGE, ""), new c("allow", ""), new c("authorization", ""), new c(SpJsonConstants.CACHE_CONTROL, ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c(Params.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c(Constants.KEY_HOST, ""), new c("if-match", ""), new c(DownloadUtils.IF_MODIFIED_SINCE, ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
    static final Map<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> b = a();

    static final class a {
        private final List<c> a;
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c[] f1020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1023h;

        a(int i2, int i3, s sVar) {
            this.a = new ArrayList();
            this.f1020e = new c[8];
            this.f1021f = this.f1020e.length - 1;
            this.f1022g = 0;
            this.f1023h = 0;
            this.f1018c = i2;
            this.f1019d = i3;
            this.b = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(sVar);
        }

        a(int i2, s sVar) {
            this(i2, i2, sVar);
        }

        private int a(int i2) {
            return this.f1021f + 1 + i2;
        }

        private void a(int i2, c cVar) {
            this.a.add(cVar);
            int i3 = cVar.f1017c;
            if (i2 != -1) {
                i3 -= this.f1020e[a(i2)].f1017c;
            }
            int i4 = this.f1019d;
            if (i3 > i4) {
                e();
                return;
            }
            int iB = b((this.f1023h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f1022g;
                c[] cVarArr = this.f1020e;
                if (i5 + 1 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f1021f = this.f1020e.length - 1;
                    this.f1020e = cVarArr2;
                }
                int i6 = this.f1021f;
                this.f1021f = i6 - 1;
                this.f1020e[i6] = cVar;
                this.f1022g++;
            } else {
                this.f1020e[iB + a(i2) + i2] = cVar;
            }
            this.f1023h = i3 + this.f1023h;
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f1020e.length;
                while (true) {
                    length--;
                    if (length < this.f1021f || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f1020e;
                    i2 -= cVarArr[length].f1017c;
                    this.f1023h -= cVarArr[length].f1017c;
                    this.f1022g--;
                    i3++;
                }
                c[] cVarArr2 = this.f1020e;
                int i4 = this.f1021f + 1;
                System.arraycopy(cVarArr2, i4, cVarArr2, i4 + i3, this.f1022g);
                this.f1021f += i3;
            }
            return i3;
        }

        private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c(int i2) {
            return (d(i2) ? d.a[i2] : this.f1020e[a(i2 - d.a.length)]).a;
        }

        private void d() {
            int i2 = this.f1019d;
            int i3 = this.f1023h;
            if (i2 < i3) {
                if (i2 == 0) {
                    e();
                } else {
                    b(i3 - i2);
                }
            }
        }

        private boolean d(int i2) {
            return i2 >= 0 && i2 <= d.a.length - 1;
        }

        private void e() {
            Arrays.fill(this.f1020e, (Object) null);
            this.f1021f = this.f1020e.length - 1;
            this.f1022g = 0;
            this.f1023h = 0;
        }

        private void e(int i2) throws IOException {
            if (d(i2)) {
                this.a.add(d.a[i2]);
                return;
            }
            int iA = a(i2 - d.a.length);
            if (iA >= 0) {
                c[] cVarArr = this.f1020e;
                if (iA <= cVarArr.length - 1) {
                    this.a.add(cVarArr[iA]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private int f() throws IOException {
            return this.b.readByte() & 255;
        }

        private void f(int i2) throws IOException {
            a(-1, new c(c(i2), b()));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(b()), b()));
        }

        private void g(int i2) throws IOException {
            this.a.add(new c(c(i2), b()));
        }

        private void h() throws IOException {
            this.a.add(new c(d.a(b()), b()));
        }

        int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int iF = f();
                if ((iF & 128) == 0) {
                    return (iF << i5) + i3;
                }
                i3 += (iF & 127) << i5;
                i5 += 7;
            }
        }

        public List<c> a() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b() throws IOException {
            int iF = f();
            boolean z2 = (iF & 128) == 128;
            int iA = a(iF, 127);
            return z2 ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(k.b().a(this.b.d(iA))) : this.b.b(iA);
        }

        void c() throws IOException {
            while (!this.b.f()) {
                int i2 = this.b.readByte() & 255;
                if (i2 == 128) {
                    throw new IOException("index == 0");
                }
                if ((i2 & 128) == 128) {
                    e(a(i2, 127) - 1);
                } else if (i2 == 64) {
                    g();
                } else if ((i2 & 64) == 64) {
                    f(a(i2, 63) - 1);
                } else if ((i2 & 32) == 32) {
                    this.f1019d = a(i2, 31);
                    int i3 = this.f1019d;
                    if (i3 < 0 || i3 > this.f1018c) {
                        throw new IOException("Invalid dynamic table size update " + this.f1019d);
                    }
                    d();
                } else if (i2 == 16 || i2 == 0) {
                    h();
                } else {
                    g(a(i2, 15) - 1);
                }
            }
        }
    }

    static final class b {
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a;
        private final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        c[] f1027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1028g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1029h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1030i;

        b(int i2, boolean z2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this.f1024c = Integer.MAX_VALUE;
            this.f1027f = new c[8];
            this.f1028g = this.f1027f.length - 1;
            this.f1029h = 0;
            this.f1030i = 0;
            this.f1026e = i2;
            this.b = z2;
            this.a = cVar;
        }

        b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i2 = this.f1026e;
            int i3 = this.f1030i;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    b(i3 - i2);
                }
            }
        }

        private void a(c cVar) {
            int i2 = cVar.f1017c;
            int i3 = this.f1026e;
            if (i2 > i3) {
                b();
                return;
            }
            b((this.f1030i + i2) - i3);
            int i4 = this.f1029h;
            c[] cVarArr = this.f1027f;
            if (i4 + 1 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f1028g = this.f1027f.length - 1;
                this.f1027f = cVarArr2;
            }
            int i5 = this.f1028g;
            this.f1028g = i5 - 1;
            this.f1027f[i5] = cVar;
            this.f1029h++;
            this.f1030i = i2 + this.f1030i;
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f1027f.length;
                while (true) {
                    length--;
                    if (length < this.f1028g || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f1027f;
                    i2 -= cVarArr[length].f1017c;
                    this.f1030i -= cVarArr[length].f1017c;
                    this.f1029h--;
                    i3++;
                }
                c[] cVarArr2 = this.f1027f;
                int i4 = this.f1028g + 1;
                System.arraycopy(cVarArr2, i4, cVarArr2, i4 + i3, this.f1029h);
                c[] cVarArr3 = this.f1027f;
                int i5 = this.f1028g + 1;
                Arrays.fill(cVarArr3, i5, i5 + i3, (Object) null);
                this.f1028g += i3;
            }
            return i3;
        }

        private void b() {
            Arrays.fill(this.f1027f, (Object) null);
            this.f1028g = this.f1027f.length - 1;
            this.f1029h = 0;
            this.f1030i = 0;
        }

        void a(int i2) {
            int iMin = Math.min(i2, 16384);
            int i3 = this.f1026e;
            if (i3 == iMin) {
                return;
            }
            if (iMin < i3) {
                this.f1024c = Math.min(this.f1024c, iMin);
            }
            this.f1025d = true;
            this.f1026e = iMin;
            a();
        }

        void a(int i2, int i3, int i4) {
            int i5;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar;
            if (i2 < i3) {
                cVar = this.a;
                i5 = i2 | i4;
            } else {
                this.a.writeByte(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                cVar = this.a;
            }
            cVar.writeByte(i5);
        }

        void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
            int iE;
            int i2;
            if (!this.b || k.b().a(fVar) >= fVar.e()) {
                iE = fVar.e();
                i2 = 0;
            } else {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                k.b().a(fVar, cVar);
                fVar = cVar.m();
                iE = fVar.e();
                i2 = 128;
            }
            a(iE, 127, i2);
            this.a.a(fVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(java.util.List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> r13) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 228
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d.b.a(java.util.List):void");
        }
    }

    static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
        int iE = fVar.e();
        for (int i2 = 0; i2 < iE; i2++) {
            byte bA = fVar.a(i2);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.h());
            }
        }
        return fVar;
    }

    private static Map<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i2 = 0;
        while (true) {
            c[] cVarArr = a;
            if (i2 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i2].a)) {
                linkedHashMap.put(a[i2].a, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
