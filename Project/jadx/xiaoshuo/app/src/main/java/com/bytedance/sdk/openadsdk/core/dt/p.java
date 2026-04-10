package com.bytedance.sdk.openadsdk.core.dt;

/* JADX INFO: loaded from: classes10.dex */
public class p {
    public boolean e = true;
    public boolean bf = true;
    public boolean d = true;
    public boolean tg = true;
    public boolean ga = true;
    public boolean vn = true;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String p1691727045748dc(java.lang.String r2) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            switch(r0) {
                case 72: goto L26;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L26;
                case 96: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto Lf;
                case 56: goto L26;
                case 57: goto L26;
                default: goto Le;
            }
        Le:
            goto L0
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 74
            r1 = 55
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dt.p.p1691727045748dc(java.lang.String):java.lang.String");
    }

    public String toString() {
        return "ClickArea{clickUpperContentArea=" + this.e + ", clickUpperNonContentArea=" + this.bf + ", clickLowerContentArea=" + this.d + ", clickLowerNonContentArea=" + this.tg + ", clickButtonArea=" + this.ga + ", clickVideoArea=" + this.vn + '}';
    }
}
