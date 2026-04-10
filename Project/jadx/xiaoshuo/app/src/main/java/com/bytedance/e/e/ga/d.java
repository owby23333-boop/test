package com.bytedance.e.e.ga;

import com.bytedance.e.e.ga.zk;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static long e(int i) throws Throwable {
        String[] strArrTg = com.bytedance.e.e.v.tg.tg("/proc/self/task/" + i + "/stat");
        if (strArrTg == null) {
            return -1L;
        }
        return (Long.parseLong(strArrTg[11]) * zk.e.e()) + (Long.parseLong(strArrTg[12]) * zk.e.e());
    }
}
