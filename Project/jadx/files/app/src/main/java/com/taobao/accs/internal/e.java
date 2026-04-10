package com.taobao.accs.internal;

import android.content.Intent;
import android.os.Process;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ ServiceImpl.AnonymousClass1 a;

    e(ServiceImpl.AnonymousClass1 anonymousClass1) {
        this.a = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (ServiceImpl.this.f18192c == null || !UtilityImpl.e(ServiceImpl.this.f18192c)) {
                Process.killProcess(Process.myPid());
            } else {
                Intent intent = new Intent();
                intent.setAction("org.agoo.android.intent.action.PING_V4");
                intent.setClassName(ServiceImpl.this.f18192c.getPackageName(), j.channelService);
                ServiceImpl.this.f18192c.startService(intent);
                UTMini.getInstance().commitEvent(66001, "probeServiceEnabled", UtilityImpl.k(ServiceImpl.this.f18192c));
                ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
            }
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
        } catch (Throwable th) {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
        }
    }
}
