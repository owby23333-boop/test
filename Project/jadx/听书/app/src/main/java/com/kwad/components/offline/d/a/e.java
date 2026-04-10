package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.k;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements IOfflineApkLoaderHolder {
    private k afU;

    public e(k kVar) {
        this.afU = kVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i) {
        return new d(this.afU.bi(i));
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.afU.bf(str));
    }
}
