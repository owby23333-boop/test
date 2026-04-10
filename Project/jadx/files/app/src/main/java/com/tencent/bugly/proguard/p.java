package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static boolean a = true;
    public static List<o> b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f18774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static w f18775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f18776e;

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.f18490v;
        aaVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        a(context, null);
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (f18776e) {
            al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            return;
        }
        aa aaVarA = aa.a(context);
        if (a(aaVarA)) {
            a = false;
            return;
        }
        String strE = aaVarA.e();
        if (strE == null) {
            return;
        }
        a(context, strE, aaVarA.D, buglyStrategy);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x020c A[Catch: all -> 0x022a, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0008, B:16:0x001a, B:18:0x001e, B:19:0x005a, B:21:0x009b, B:24:0x009f, B:26:0x00b1, B:28:0x00bf, B:30:0x00c5, B:31:0x00db, B:32:0x00ea, B:34:0x00f2, B:36:0x00fc, B:38:0x0102, B:39:0x0118, B:45:0x0140, B:51:0x0154, B:53:0x015e, B:55:0x0164, B:56:0x017a, B:57:0x0189, B:59:0x018f, B:61:0x0195, B:62:0x01ab, B:63:0x01b7, B:65:0x01bd, B:66:0x01c9, B:40:0x0126, B:42:0x012f, B:44:0x0139, B:48:0x014d, B:50:0x0151, B:68:0x01d6, B:78:0x0204, B:79:0x0207, B:81:0x020c, B:83:0x0213, B:75:0x01fb, B:77:0x0201, B:70:0x01de, B:72:0x01ee), top: B:95:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r12, java.lang.String r13, boolean r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instruction units count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(android.content.Context, java.lang.String, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    public static synchronized void a(o oVar) {
        if (!b.contains(oVar)) {
            b.add(oVar);
        }
    }
}
