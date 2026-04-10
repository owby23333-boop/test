package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class da {
    public static final String a = "error_message";
    public static final String b = "error_code";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile da f13064d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final bq f13065c = bq.a();

    private da() {
    }

    public static da a() {
        if (f13064d == null) {
            synchronized (da.class) {
                if (f13064d == null) {
                    f13064d = new da();
                }
            }
        }
        return f13064d;
    }

    public String a(bm bmVar, String str) {
        if (bmVar == null) {
            return "";
        }
        return a(bmVar.b() + "", bmVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /* JADX WARN: Path cross not found for [B:16:0x0008, B:11:0x0026], limit reached: 19 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0026
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L26
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.bm r5 = (com.baidu.mobads.sdk.internal.bm) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L27
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L26
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L27
        L26:
            r5 = r2
        L27:
            if (r5 != 0) goto L2a
            r5 = r2
        L2a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.da.a(java.util.Map):java.lang.String");
    }
}
