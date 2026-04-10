package com.ss.android.socialbase.appdownloader.m.z;

import com.funny.audio.core.utils.FileUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static final void z(a aVar, int i) throws IOException {
        int iG = aVar.g();
        if (iG != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iG) + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
    }
}
