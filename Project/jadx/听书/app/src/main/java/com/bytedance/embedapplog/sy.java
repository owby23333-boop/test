package com.bytedance.embedapplog;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final q f300a;
    protected final hh dl;
    protected final Context g;
    protected final List<Future<h>> z = new ArrayList();

    protected abstract List<String> z();

    public boolean z(JSONObject jSONObject) {
        return false;
    }

    public sy(Context context, q qVar, hh hhVar) {
        this.f300a = qVar;
        this.dl = hhVar;
        this.g = context;
    }

    protected void z(tb tbVar, Long l) {
        this.z.add(x.z(new iq(tbVar, l)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:6:0x001a, B:9:0x0029, B:28:0x0072, B:24:0x0054, B:25:0x0062, B:14:0x0039, B:17:0x0043), top: B:33:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0008 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void z(java.util.Map<java.lang.String, org.json.JSONObject> r6, long r7) {
        /*
            r5 = this;
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L8:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L95
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r2 = r5.z()     // Catch: java.lang.Exception -> L7a
            java.lang.Object r3 = r0.getKey()     // Catch: java.lang.Exception -> L7a
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Exception -> L7a
            if (r2 != 0) goto L29
            goto L8
        L29:
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L7a
            r3 = 3073450(0x2ee5aa, float:4.306821E-39)
            r4 = 1
            if (r2 == r3) goto L43
            r3 = 3073698(0x2ee6a2, float:4.307168E-39)
            if (r2 == r3) goto L39
            goto L4d
        L39:
            java.lang.String r2 = "d_i0"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L4d
            r1 = r4
            goto L4e
        L43:
            java.lang.String r2 = "d_a0"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L4d
            r1 = 0
            goto L4e
        L4d:
            r1 = -1
        L4e:
            if (r1 == 0) goto L62
            if (r1 == r4) goto L54
            r0 = 0
            goto L70
        L54:
            com.bytedance.embedapplog.io r1 = new com.bytedance.embedapplog.io     // Catch: java.lang.Exception -> L7a
            android.content.Context r2 = r5.g     // Catch: java.lang.Exception -> L7a
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Exception -> L7a
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Exception -> L7a
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L7a
            goto L6f
        L62:
            com.bytedance.embedapplog.zw r1 = new com.bytedance.embedapplog.zw     // Catch: java.lang.Exception -> L7a
            android.content.Context r2 = r5.g     // Catch: java.lang.Exception -> L7a
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Exception -> L7a
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Exception -> L7a
            r1.<init>(r2, r0)     // Catch: java.lang.Exception -> L7a
        L6f:
            r0 = r1
        L70:
            if (r0 == 0) goto L8
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> L7a
            r5.z(r0, r1)     // Catch: java.lang.Exception -> L7a
            goto L8
        L7a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "__kite"
            com.bytedance.embedapplog.js.a(r1, r0)
            goto L8
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.sy.z(java.util.Map, long):void");
    }
}
