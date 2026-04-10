package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.arialyy.aria.core.ProtocolType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public enum d0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2(ProtocolType.TLSv1_2),
    TLS_1_1(ProtocolType.TLSv1_1),
    TLS_1_0(ProtocolType.TLSv1),
    SSL_3_0(ProtocolType.SSLv3);

    final String a;

    d0(String str) {
        this.a = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 a(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 79201641(0x4b88569, float:4.338071E-36)
            if (r0 == r5) goto L3e
            r5 = 79923350(0x4c38896, float:4.5969714E-36)
            if (r0 == r5) goto L34
            switch(r0) {
                case -503070503: goto L2a;
                case -503070502: goto L20;
                case -503070501: goto L16;
                default: goto L15;
            }
        L15:
            goto L48
        L16:
            java.lang.String r0 = "TLSv1.3"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L48
            r0 = 0
            goto L49
        L20:
            java.lang.String r0 = "TLSv1.2"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L48
            r0 = 1
            goto L49
        L2a:
            java.lang.String r0 = "TLSv1.1"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L48
            r0 = 2
            goto L49
        L34:
            java.lang.String r0 = "TLSv1"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L48
            r0 = 3
            goto L49
        L3e:
            java.lang.String r0 = "SSLv3"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L48
            r0 = 4
            goto L49
        L48:
            r0 = -1
        L49:
            if (r0 == 0) goto L76
            if (r0 == r4) goto L73
            if (r0 == r3) goto L70
            if (r0 == r2) goto L6d
            if (r0 != r1) goto L56
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 r6 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.SSL_3_0
            goto L78
        L56:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected TLS version: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L6d:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 r6 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.TLS_1_0
            goto L78
        L70:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 r6 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.TLS_1_1
            goto L78
        L73:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 r6 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.TLS_1_2
            goto L78
        L76:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0 r6 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.TLS_1_3
        L78:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0.a(java.lang.String):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d0");
    }

    static List<d0> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
