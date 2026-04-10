package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class bf implements y {
    private boolean e = false;

    @Override // com.ss.android.socialbase.downloader.depend.y
    public void e(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.e = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.y
    public boolean e() {
        return this.e;
    }
}
