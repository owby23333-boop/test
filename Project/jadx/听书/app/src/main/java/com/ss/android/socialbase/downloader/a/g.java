package com.ss.android.socialbase.downloader.a;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g implements io {
    private boolean z = false;

    @Override // com.ss.android.socialbase.downloader.a.io
    public void z(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.z = true;
    }

    @Override // com.ss.android.socialbase.downloader.a.io
    public boolean z() {
        return this.z;
    }
}
