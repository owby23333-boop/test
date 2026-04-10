package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.a;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.dl;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.e;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.g;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.gc;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.z.m;
import com.bytedance.sdk.openadsdk.core.wp;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z dl;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f1271a;
    private wp g;
    private Context z;
    private final Object gc = new Object();
    private long m = 0;
    private ServiceConnection e = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.z.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.bytedance.sdk.component.utils.wp.z("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            z.this.g = wp.z.z(iBinder);
            try {
                z.this.g.asBinder().linkToDeath(z.this.gz, 0);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.wp.dl("MultiProcess", "onServiceConnected throws :", e);
            }
            z.this.f1271a.countDown();
            System.currentTimeMillis();
            long unused = z.this.m;
        }
    };
    private IBinder.DeathRecipient gz = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.z.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.bytedance.sdk.component.utils.wp.g("MultiProcess", "binder died.");
            z.this.g.asBinder().unlinkToDeath(z.this.gz, 0);
            z.this.g = null;
            z.this.z();
        }
    };

    private z(Context context) {
        this.z = context.getApplicationContext();
        z();
    }

    public static z z(Context context) {
        if (dl == null) {
            synchronized (z.class) {
                if (dl == null) {
                    dl = new z(context);
                }
            }
        }
        return dl;
    }

    public IBinder z(int i) {
        try {
            wp wpVar = this.g;
            if (wpVar != null) {
                return wpVar.z(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z() {
        com.bytedance.sdk.component.utils.wp.z("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f1271a = new CountDownLatch(1);
        try {
            this.z.bindService(new Intent(this.z, (Class<?>) BinderPoolService.class), this.e, 1);
            this.m = System.currentTimeMillis();
            this.f1271a.await();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.z$z, reason: collision with other inner class name */
    public static class BinderC0189z extends wp.z {
        @Override // com.bytedance.sdk.openadsdk.core.wp
        public IBinder z(int i) throws RemoteException {
            if (i == 0) {
                return e.g();
            }
            if (i == 1) {
                return gc.g();
            }
            if (i == 2) {
                return dl.g();
            }
            if (i == 3) {
                return g.g();
            }
            if (i == 4) {
                return a.g();
            }
            if (i != 5) {
                return null;
            }
            return m.g();
        }
    }
}
