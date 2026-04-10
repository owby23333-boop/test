package com.bytedance.pangle.m;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.m;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements m.z {
    @Override // com.bytedance.pangle.m.m.z
    public boolean z(String str, int i) {
        String strZ = e.z(str, i);
        String strDl = com.bytedance.pangle.gc.dl.dl(str, i);
        String[] strArrSplit = strZ.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(String.valueOf(strZ)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = strArrSplit.length;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                z = z2;
                break;
            }
            String str2 = strArrSplit[i2];
            if (!z(str2, strDl + File.separator + g.z(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i2++;
            z2 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result:" + z);
        return z;
    }

    private boolean z(String str, String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
