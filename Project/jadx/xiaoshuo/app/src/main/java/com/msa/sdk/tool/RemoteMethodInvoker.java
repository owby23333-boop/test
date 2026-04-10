package com.msa.sdk.tool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.msa.sdk.tool.RemoteMethodInvoker;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RemoteMethodInvoker<T, S extends IInterface> extends FutureTask<T> implements ServiceConnection {
    private static final Map<Class, IInterface> CONNECTED_BINDERS = new ConcurrentHashMap();
    private static final String TAG = "SystemSdk-RemoteMethodInvoker";
    private Context mContext;
    private InvokeFailedCallback mInvokeFailedCallback;
    private T mResult;
    private boolean mReuseBinder;
    private S mService;
    private Class<S> mServiceClass;
    private long mStartTime;
    private int mUnbindDelayInterval;

    public interface InvokeFailedCallback {
        void onBindException(Throwable th);

        void onBindFailed();

        void onIPCException(Throwable th);

        void onTimeout();
    }

    public RemoteMethodInvoker(Context context, Class<S> cls) {
        super(new Callable() { // from class: com.yuewen.y63
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RemoteMethodInvoker.lambda$new$0();
            }
        });
        this.mContext = context;
        this.mServiceClass = cls;
        MLog.i(TAG, "RMI of " + this.mServiceClass.getPackage().toString() + this.mServiceClass);
    }

    public static boolean binderCanBeReused(Class cls) {
        return CONNECTED_BINDERS.containsKey(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAndKeepBinder(IBinder iBinder) {
        try {
            MLog.i(TAG, this.mServiceClass.getCanonicalName());
            this.mService = (S) Class.forName(this.mServiceClass.getCanonicalName() + "$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            MLog.i(TAG, "Service[" + this.mServiceClass + ", " + iBinder + "] connected!");
            trySaveReuseBinder(iBinder);
            return true;
        } catch (Exception e) {
            MLog.e(TAG, "Cast binder exception " + this.mServiceClass, e);
            InvokeFailedCallback invokeFailedCallback = this.mInvokeFailedCallback;
            if (invokeFailedCallback != null) {
                invokeFailedCallback.onBindException(e);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T invokeInternal(S s) {
        T tInnerInvoke;
        try {
            tInnerInvoke = innerInvoke(s);
        } catch (Exception e) {
            MLog.e(TAG, "invokeInternal Exception " + this.mServiceClass, e);
            if (this.mInvokeFailedCallback != null) {
                this.mInvokeFailedCallback.onIPCException(e);
            }
            tInnerInvoke = null;
        }
        MLog.i(TAG, "[RMIMonitor] " + this.mServiceClass + " takes " + (System.currentTimeMillis() - this.mStartTime) + "ms");
        return tInnerInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0() throws Exception {
        throw new IllegalStateException("this should never be called");
    }

    private S tryGetReuseBinder() {
        S s;
        if (!this.mReuseBinder || (s = (S) CONNECTED_BINDERS.get(this.mServiceClass)) == null) {
            return null;
        }
        MLog.i(TAG, "Reuse Service[" + this.mServiceClass + ", " + s + "]");
        return s;
    }

    private void trySaveReuseBinder(IBinder iBinder) throws RemoteException {
        if (this.mReuseBinder) {
            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.msa.sdk.tool.RemoteMethodInvoker.3
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    MLog.w(RemoteMethodInvoker.TAG, "Service[" + RemoteMethodInvoker.this.mServiceClass + ", " + RemoteMethodInvoker.this.mService + "] died, remove from reusing-map!");
                    RemoteMethodInvoker.CONNECTED_BINDERS.remove(RemoteMethodInvoker.this.mServiceClass);
                }
            }, 0);
            MLog.i(TAG, "Keep Service[" + this.mServiceClass + ", " + this.mService + "] for reusing!");
            CONNECTED_BINDERS.put(this.mServiceClass, this.mService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService() {
        ThrowableCaughtRunnable throwableCaughtRunnable = new ThrowableCaughtRunnable(TAG, "Unbind service exception") { // from class: com.msa.sdk.tool.RemoteMethodInvoker.2
            @Override // com.msa.sdk.tool.ThrowableCaughtRunnable
            public void execute() {
                RemoteMethodInvoker.this.mContext.unbindService(RemoteMethodInvoker.this);
                MLog.i(RemoteMethodInvoker.TAG, "Unbind Service[" + RemoteMethodInvoker.this.mServiceClass + ", " + RemoteMethodInvoker.this.mService + "]");
            }
        };
        if (this.mUnbindDelayInterval > 0) {
            HandlerHolder.getBackgroundHandler().postDelayed(throwableCaughtRunnable, this.mUnbindDelayInterval);
        } else {
            throwableCaughtRunnable.run();
        }
    }

    public abstract T innerInvoke(S s) throws RemoteException;

    public T invoke(Intent intent) {
        return invoke(intent, 0L);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        TaskRunner.CACHED_EXECUTOR.execute(new ThrowableCaughtRunnable(TAG, "onServiceConnected exception") { // from class: com.msa.sdk.tool.RemoteMethodInvoker.1
            @Override // com.msa.sdk.tool.ThrowableCaughtRunnable
            public void execute() {
                if (RemoteMethodInvoker.this.getAndKeepBinder(iBinder)) {
                    RemoteMethodInvoker remoteMethodInvoker = RemoteMethodInvoker.this;
                    remoteMethodInvoker.mResult = remoteMethodInvoker.invokeInternal(remoteMethodInvoker.mService);
                    RemoteMethodInvoker remoteMethodInvoker2 = RemoteMethodInvoker.this;
                    remoteMethodInvoker2.set(remoteMethodInvoker2.mResult);
                    RemoteMethodInvoker.this.unbindService();
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public RemoteMethodInvoker setInvokeFailedCallback(InvokeFailedCallback invokeFailedCallback) {
        this.mInvokeFailedCallback = invokeFailedCallback;
        return this;
    }

    public RemoteMethodInvoker setReuseBinder(boolean z) {
        this.mReuseBinder = z;
        return this;
    }

    public RemoteMethodInvoker setUnbindDelay(int i) {
        this.mUnbindDelayInterval = i;
        return this;
    }

    public T invoke(Intent intent, long j) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new RuntimeException("Should not run on main thread.");
        }
        this.mStartTime = System.currentTimeMillis();
        S s = (S) tryGetReuseBinder();
        this.mService = s;
        if (s != null) {
            return invokeInternal(s);
        }
        if (!this.mContext.bindService(intent, this, 1)) {
            MLog.e(TAG, "Can not find bind service for " + this.mServiceClass);
            InvokeFailedCallback invokeFailedCallback = this.mInvokeFailedCallback;
            if (invokeFailedCallback == null) {
                return null;
            }
            invokeFailedCallback.onBindFailed();
            return null;
        }
        try {
            return j <= 0 ? get() : get(j, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            MLog.e(TAG, "invoke Exception " + this.mServiceClass + " Timeout", e);
            InvokeFailedCallback invokeFailedCallback2 = this.mInvokeFailedCallback;
            if (invokeFailedCallback2 == null) {
                return null;
            }
            invokeFailedCallback2.onTimeout();
            return null;
        } catch (Exception e2) {
            MLog.e(TAG, "invoke Exception " + this.mServiceClass, e2);
            InvokeFailedCallback invokeFailedCallback3 = this.mInvokeFailedCallback;
            if (invokeFailedCallback3 == null) {
                return null;
            }
            invokeFailedCallback3.onIPCException(e2);
            return null;
        }
    }
}
