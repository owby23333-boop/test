package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static List<String> aPK = null;
    private static List<String> aPL = null;
    private static int aPM = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aPK = new ArrayList();
        if (aVar.aPX != null && !aVar.aPX.isEmpty()) {
            aPK.addAll(aVar.aPX);
        } else {
            aPK.add("com.kwad");
            aPK.add("com.kwai");
            aPK.add("com.ksad");
            aPK.add("tkruntime");
            aPK.add("tachikoma");
            aPK.add("kuaishou");
        }
        aPM = aVar.aQc;
        aPL = new ArrayList();
        if (aVar.aPW != null && !aVar.aPW.isEmpty()) {
            aPL.addAll(aVar.aPW);
            return;
        }
        aPL.add("android.");
        aPL.add("androidx.");
        aPL.add("org.");
        aPL.add("java.");
    }

    private static boolean fG(String str) {
        List<String> list = aPL;
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

    private static boolean fH(String str) {
        List<String> list = aPK;
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

    public static String fI(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        com.kwad.sdk.core.d.c.d("perfMonitor.Filter", "stacks after split:" + strArrSplit.length);
        boolean z = false;
        int i = 0;
        for (String str2 : strArrSplit) {
            if (z || !fG(str2)) {
                if (i >= aPM) {
                    return "";
                }
                if (fH(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
