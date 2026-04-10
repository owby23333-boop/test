package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.bf;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.d;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.ga;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.p;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.tg;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.e.vn;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private static volatile e d;
    private t bf;
    private Context e;
    private CountDownLatch tg;
    private final Object ga = new Object();
    private long vn = 0;
    private ServiceConnection p = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.e.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.bf = t.e.e(iBinder);
            try {
                e.this.bf.asBinder().linkToDeath(e.this.v, 0);
            } catch (RemoteException e) {
                wu.d("MultiProcess", "onServiceConnected throws :", e);
            }
            e.this.tg.countDown();
            wu.bf("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - e.this.vn));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            wu.d("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient v = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.e.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            wu.tg("MultiProcess", "binder died.");
            e.this.bf.asBinder().unlinkToDeath(e.this.v, 0);
            e.this.bf = null;
            e.this.e();
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.e$e, reason: collision with other inner class name */
    public static class BinderC0144e extends t.e {
        @Override // com.bytedance.sdk.openadsdk.core.t
        public IBinder e(int i) throws RemoteException {
            if (i == 0) {
                return p.bf();
            }
            if (i == 1) {
                return ga.bf();
            }
            if (i == 2) {
                return d.bf();
            }
            if (i == 3) {
                return bf.bf();
            }
            if (i == 4) {
                return tg.bf();
            }
            if (i != 5) {
                return null;
            }
            return vn.bf();
        }
    }

    private e(Context context) {
        this.e = context.getApplicationContext();
        e();
    }

    public static e e(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e(context);
                }
            }
        }
        return d;
    }

    public IBinder e(int i) {
        try {
            t tVar = this.bf;
            if (tVar != null) {
                return tVar.e(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        wu.d("MultiProcess", "BinderPool......connectBinderPoolService");
        this.tg = new CountDownLatch(1);
        try {
            this.e.bindService(new Intent(this.e, (Class<?>) BinderPoolService.class), this.p, 1);
            this.vn = System.currentTimeMillis();
            this.tg.await();
        } catch (Exception e) {
            wu.d("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }
}
