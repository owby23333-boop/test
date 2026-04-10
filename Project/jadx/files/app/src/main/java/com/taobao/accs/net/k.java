package com.taobao.accs.net;

import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.q;
import java.util.UUID;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.d(this.a.d(), "sendAccsHeartbeatMessage", new Object[0]);
        try {
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, new q.a().a("dataType", "pingreq").a("timeInterval", Long.valueOf(this.a.f18224p)).a().toString().getBytes(com.anythink.expressad.foundation.g.a.bN), UUID.randomUUID().toString());
            accsRequest.setTarget("accs-iot");
            accsRequest.setTargetServiceName("sal");
            this.a.a(Message.buildRequest(this.a.f18201d, this.a.b((String) null), this.a.d(), this.a.f18206i.getStoreId(), this.a.f18201d.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
        } catch (Exception e2) {
            ALog.e(this.a.d(), "send accs heartbeat message", e2, new Object[0]);
        }
    }
}
