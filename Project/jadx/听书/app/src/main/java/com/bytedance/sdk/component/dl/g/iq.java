package com.bytedance.sdk.component.dl.g;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class iq extends hh {
    private final com.bytedance.sdk.component.dl.z.m fo;
    private long i = -1;
    private final q kb;
    private final q uy;
    private final List<g> wp;
    public static final q z = q.z("multipart/mixed");
    public static final q g = q.z("multipart/alternative");
    public static final q dl = q.z("multipart/digest");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f633a = q.z("multipart/parallel");
    public static final q gc = q.z("multipart/form-data");
    private static final byte[] m = {58, 32};
    private static final byte[] e = {13, 10};
    private static final byte[] gz = {45, 45};

    iq(com.bytedance.sdk.component.dl.z.m mVar, q qVar, List<g> list) {
        this.fo = mVar;
        this.uy = qVar;
        this.kb = q.z(qVar + "; boundary=" + mVar.z());
        this.wp = com.bytedance.sdk.component.dl.g.z.dl.z(list);
    }

    @Override // com.bytedance.sdk.component.dl.g.hh
    public q z() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.dl.g.hh
    public long g() throws IOException {
        long j = this.i;
        if (j != -1) {
            return j;
        }
        long jZ = z((com.bytedance.sdk.component.dl.z.a) null, true);
        this.i = jZ;
        return jZ;
    }

    @Override // com.bytedance.sdk.component.dl.g.hh
    public void z(com.bytedance.sdk.component.dl.z.a aVar) throws IOException {
        z(aVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long z(com.bytedance.sdk.component.dl.z.a aVar, boolean z2) throws IOException {
        com.bytedance.sdk.component.dl.z.dl dlVar;
        if (z2) {
            aVar = new com.bytedance.sdk.component.dl.z.dl();
            dlVar = aVar;
        } else {
            dlVar = 0;
        }
        int size = this.wp.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            g gVar = this.wp.get(i);
            fv fvVar = gVar.z;
            hh hhVar = gVar.g;
            aVar.dl(gz);
            aVar.g(this.fo);
            aVar.dl(e);
            if (fvVar != null) {
                int iZ = fvVar.z();
                for (int i2 = 0; i2 < iZ; i2++) {
                    aVar.g(fvVar.z(i2)).dl(m).g(fvVar.g(i2)).dl(e);
                }
            }
            q qVarZ = hhVar.z();
            if (qVarZ != null) {
                aVar.g("Content-Type: ").g(qVarZ.toString()).dl(e);
            }
            long jG = hhVar.g();
            if (jG != -1) {
                aVar.g("Content-Length: ").wp(jG).dl(e);
            } else if (z2) {
                dlVar.fv();
                return -1L;
            }
            byte[] bArr = e;
            aVar.dl(bArr);
            if (z2) {
                j += jG;
            } else {
                hhVar.z(aVar);
            }
            aVar.dl(bArr);
        }
        byte[] bArr2 = gz;
        aVar.dl(bArr2);
        aVar.g(this.fo);
        aVar.dl(bArr2);
        aVar.dl(e);
        if (!z2) {
            return j;
        }
        long jG2 = j + dlVar.g();
        dlVar.fv();
        return jG2;
    }

    static StringBuilder z(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append(Typography.quote);
        return sb;
    }

    public static final class g {
        final hh g;
        final fv z;

        public static g z(fv fvVar, hh hhVar) {
            if (hhVar == null) {
                throw new NullPointerException("body == null");
            }
            if (fvVar != null && fvVar.z(HttpHeaders.CONTENT_TYPE) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (fvVar != null && fvVar.z(HttpHeaders.CONTENT_LENGTH) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new g(fvVar, hhVar);
        }

        public static g z(String str, String str2, hh hhVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            iq.z(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                iq.z(sb, str2);
            }
            return z(fv.z(HttpHeaders.CONTENT_DISPOSITION, sb.toString()), hhVar);
        }

        private g(fv fvVar, hh hhVar) {
            this.z = fvVar;
            this.g = hhVar;
        }
    }

    public static final class z {
        private final List<g> dl;
        private q g;
        private final com.bytedance.sdk.component.dl.z.m z;

        public z() {
            this(UUID.randomUUID().toString());
        }

        public z(String str) {
            this.g = iq.z;
            this.dl = new ArrayList();
            this.z = com.bytedance.sdk.component.dl.z.m.z(str);
        }

        public z z(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!qVar.z().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(qVar)));
            }
            this.g = qVar;
            return this;
        }

        public z z(String str, String str2, hh hhVar) {
            return z(g.z(str, str2, hhVar));
        }

        public z z(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("part == null");
            }
            this.dl.add(gVar);
            return this;
        }

        public iq z() {
            if (this.dl.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new iq(this.z, this.g, this.dl);
        }
    }
}
