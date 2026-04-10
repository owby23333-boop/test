package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements ServiceConnection {
    final /* synthetic */ Intent a;
    final /* synthetic */ Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f335c;

    h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f335c = sessionRequest;
        this.a = intent;
        this.b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable("intent", this.a);
                messenger.send(message);
            } catch (Exception e2) {
                ALog.e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e2, new Object[0]);
            }
        } finally {
            this.b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        this.b.unbindService(this);
    }
}
