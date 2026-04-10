package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;

/* JADX INFO: loaded from: classes2.dex */
class bg implements z.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bf f12904c;

    bg(bf bfVar) {
        this.f12904c = bfVar;
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onFailure() {
        this.f12904c.f12896i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f12904c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onSuccess() {
        this.f12904c.f12896i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f12904c.i();
    }
}
