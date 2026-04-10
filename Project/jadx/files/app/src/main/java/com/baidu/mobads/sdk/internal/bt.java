package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cf;

/* JADX INFO: loaded from: classes2.dex */
class bt implements cf.a {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void a(bu buVar) {
        this.a.a(bw.f12977k, buVar, "download apk successfully, downloader exit");
        bs unused = bs.f12953h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void b(bu buVar) {
        this.a.a(bw.f12978l, buVar, "downloadApk failed");
    }
}
