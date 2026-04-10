package org.android.agoo.control;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class g extends Handler {
    final /* synthetic */ BaseIntentService a;

    g(BaseIntentService baseIntentService) {
        this.a = baseIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            ALog.i("BaseIntentService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable("intent");
            if (intent != null) {
                ALog.i("BaseIntentService", "handleMessage get intent success", "intent", intent.toString());
                ThreadPoolExecutorFactory.execute(new h(this, intent));
            }
        }
    }
}
