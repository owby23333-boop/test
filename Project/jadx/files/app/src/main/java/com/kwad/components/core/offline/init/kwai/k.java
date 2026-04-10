package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.bp;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
final class k implements IZipper {
    k() {
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return bp.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return bp.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        bp.zipFile(file);
    }
}
