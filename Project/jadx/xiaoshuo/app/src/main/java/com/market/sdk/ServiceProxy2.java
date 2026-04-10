package com.market.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.market.sdk.compat.FutureTaskCompat;
import com.market.sdk.utils.Log;

/* JADX INFO: loaded from: classes7.dex */
public class ServiceProxy2 {
    private static final String TAG = "ServiceProxy2";
    private Context context;
    private Intent intent;

    public abstract class ProxyTask<T> {
        private ServiceConnection conn;
        private FutureTaskCompat<T> syncCallTask;

        public ProxyTask(final boolean z) {
            this.conn = new ServiceConnection() { // from class: com.market.sdk.ServiceProxy2.ProxyTask.1
                /* JADX INFO: Access modifiers changed from: private */
                public void doRemoteCall(IBinder iBinder) {
                    RemoteException e;
                    Object objRun;
                    try {
                        objRun = ProxyTask.this.run(iBinder);
                    } catch (RemoteException e2) {
                        e = e2;
                        objRun = null;
                    }
                    try {
                        if (z) {
                            ServiceProxy2.this.context.unbindService(ProxyTask.this.conn);
                            ProxyTask.this.conn = null;
                        }
                    } catch (RemoteException e3) {
                        e = e3;
                        Log.e(ServiceProxy2.TAG, "doInBackground: ", e);
                    }
                    if (ProxyTask.this.syncCallTask != null) {
                        ProxyTask.this.syncCallTask.set(objRun);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        new AsyncTask<Void, Void, Void>() { // from class: com.market.sdk.ServiceProxy2.ProxyTask.1.1
                            @Override // android.os.AsyncTask
                            public Void doInBackground(Void... voidArr) {
                                doRemoteCall(iBinder);
                                return null;
                            }
                        }.execute(new Void[0]);
                    } else {
                        doRemoteCall(iBinder);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bind() {
            ServiceProxy2.this.context.bindService(ServiceProxy2.this.intent, this.conn, 1);
        }

        public T getResult() {
            FutureTaskCompat<T> futureTaskCompat = new FutureTaskCompat<>();
            this.syncCallTask = futureTaskCompat;
            return futureTaskCompat.get();
        }

        public abstract T run(IBinder iBinder) throws RemoteException;

        public void unbind() {
            if (this.conn != null) {
                ServiceProxy2.this.context.unbindService(this.conn);
                this.conn = null;
            }
        }
    }

    public ServiceProxy2(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }

    public ProxyTask setTask(ProxyTask proxyTask) {
        proxyTask.bind();
        return proxyTask;
    }
}
