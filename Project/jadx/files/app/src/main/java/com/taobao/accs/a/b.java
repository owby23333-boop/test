package com.taobao.accs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class b implements ServiceConnection {
    final /* synthetic */ Intent a;
    final /* synthetic */ Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f18111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f18112d;

    b(Intent intent, Context context, Context context2, int i2) {
        this.a = intent;
        this.b = context;
        this.f18111c = context2;
        this.f18112d = i2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean zEquals;
        ALog.d(a.TAG, "bindService connected", "componentName", componentName.toString());
        Messenger messenger = new Messenger(iBinder);
        Message message = new Message();
        try {
            try {
                message.getData().putParcelable("intent", this.a);
                messenger.send(message);
                try {
                    this.b.unbindService(this);
                } catch (Exception unused) {
                }
                zEquals = this.f18111c.getPackageName().equals(componentName.getPackageName());
                componentName = componentName;
            } catch (Exception e2) {
                ALog.e(a.TAG, "dispatch intent with exception", e2, new Object[0]);
                try {
                    this.b.unbindService(this);
                } catch (Exception unused2) {
                }
                boolean zEquals2 = this.f18111c.getPackageName().equals(componentName.getPackageName());
                componentName = componentName;
                if (zEquals2) {
                }
            }
            if (zEquals) {
                String className = componentName.getClassName();
                k.a("accs", BaseMonitor.ALARM_POINT_BIND, className);
                componentName = className;
            }
        } finally {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d(a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.b.unbindService(this);
        } catch (Exception unused) {
        }
        if (this.f18111c.getPackageName().equals(componentName.getPackageName())) {
            k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.a(this.f18112d - 3), "onServiceDisconnected");
        }
    }
}
