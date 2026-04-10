package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class j extends Handler {
    final /* synthetic */ MsgDistributeService a;

    j(MsgDistributeService msgDistributeService) {
        this.a = msgDistributeService;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message != null) {
            ALog.i("MsgDistributeService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable("intent");
            if (intent != null) {
                ALog.i("MsgDistributeService", "handleMessage get intent success", "intent", intent.toString());
                this.a.onStartCommand(intent, 0, 0);
            }
        }
    }
}
