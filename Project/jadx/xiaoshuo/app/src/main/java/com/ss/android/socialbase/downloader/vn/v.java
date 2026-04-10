package com.ss.android.socialbase.downloader.vn;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
class v implements ga {
    private final ga bf;
    private final ga e;

    public v(ga gaVar, ga gaVar2) {
        this.e = gaVar;
        this.bf = gaVar2;
    }

    @Override // com.ss.android.socialbase.downloader.vn.ga
    public void bf(@NonNull e eVar) throws IOException {
        eVar.bf = this.bf;
        this.e.bf(eVar);
    }
}
