package com.bytedance.pangle.m;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.m;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a implements m.z {
    @Override // com.bytedance.pangle.m.m.z
    public boolean z(String str, int i) {
        String strG = com.bytedance.pangle.gc.dl.g(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strG)));
        String strDl = com.bytedance.pangle.gc.dl.dl(str, i);
        String str2 = strDl + File.separator + "compFully" + g.g(strG);
        String str3 = strDl + File.separator + g.z(strG);
        if (!g(strG, str2)) {
            return false;
        }
        z(str2, str3);
        boolean z = g.z(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(z)));
        return z;
    }

    private void z(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        File file2 = new File(str.replace(".odex", ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(".odex", ".vdex")));
        }
    }

    private static boolean g(String str, String str2) {
        try {
            return z.z(g.z(str, str2, g.g));
        } catch (Exception unused) {
            return false;
        }
    }
}
