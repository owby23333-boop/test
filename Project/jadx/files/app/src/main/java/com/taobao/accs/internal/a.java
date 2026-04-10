package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class a implements l.b {
    final /* synthetic */ ACCSManagerImpl a;

    a(ACCSManagerImpl aCCSManagerImpl) {
        this.a = aCCSManagerImpl;
    }

    @Override // com.taobao.accs.utl.l.b
    public void a() {
        try {
            ALog.e(ACCSManagerImpl.f18188c, "onForeState", new Object[0]);
            if (AccsClientConfig.getConfigByTag(this.a.b).isForePingEnable()) {
                this.a.a(this.a.f18189d);
            }
        } catch (Exception e2) {
            ALog.e(ACCSManagerImpl.f18188c, "onForeState error, Error:", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.utl.l.b
    public void b() {
        ALog.e(ACCSManagerImpl.f18188c, "onBackState", new Object[0]);
    }
}
