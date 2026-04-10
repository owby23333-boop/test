package com.ss.android.socialbase.appdownloader.vn.e;

import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class bf {
    public static final void e(tg tgVar, int i) throws IOException {
        int iBf = tgVar.bf();
        if (iBf == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iBf) + Consts.DOT);
    }
}
