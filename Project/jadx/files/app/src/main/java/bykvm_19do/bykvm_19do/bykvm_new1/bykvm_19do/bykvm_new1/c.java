package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.i;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static long a(int i2) throws Throwable {
        String[] strArrD = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.d("/proc/self/task/" + i2 + "/stat");
        if (strArrD == null) {
            return -1L;
        }
        return (Long.parseLong(strArrD[11]) * i.a.a()) + (Long.parseLong(strArrD[12]) * i.a.a());
    }
}
