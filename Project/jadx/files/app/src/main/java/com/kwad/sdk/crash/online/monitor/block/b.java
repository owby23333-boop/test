package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static List<String> arm = null;
    private static List<String> arn = null;
    private static int aro = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        arm = new ArrayList();
        List<String> list = aVar.arA;
        if (list == null || list.isEmpty()) {
            arm.add("com.kwad");
            arm.add("com.kwai");
            arm.add("com.ksad");
            arm.add("tkruntime");
            arm.add("tachikoma");
            arm.add("kuaishou");
        } else {
            arm.addAll(aVar.arA);
        }
        aro = aVar.arF;
        arn = new ArrayList();
        List<String> list2 = aVar.arz;
        if (list2 != null && !list2.isEmpty()) {
            arn.addAll(aVar.arz);
            return;
        }
        arn.add("android.");
        arn.add("androidx.");
        arn.add("org.");
        arn.add("java.");
    }

    private static boolean dn(String str) {
        List<String> list = arn;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static boolean m71do(String str) {
        List<String> list = arm;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String dp(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        com.kwad.sdk.core.d.b.d("perfMonitor.Filter", "stacks after split:" + strArrSplit.length);
        boolean z2 = false;
        int i2 = 0;
        for (String str2 : strArrSplit) {
            if (z2 || !dn(str2)) {
                if (i2 >= aro) {
                    return "";
                }
                if (m71do(str2)) {
                    return str;
                }
                i2++;
                z2 = true;
            }
        }
        return "";
    }
}
