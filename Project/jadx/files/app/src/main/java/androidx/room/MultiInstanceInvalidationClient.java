package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class MultiInstanceInvalidationClient {
    final Context mAppContext;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker.Observer mObserver;

    @Nullable
    IMultiInstanceInvalidationService mService;
    final IMultiInstanceInvalidationCallback mCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient.1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(final String[] strArr) {
            MultiInstanceInvalidationClient.this.mExecutor.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(strArr);
                }
            });
        }
    };
    final AtomicBoolean mStopped = new AtomicBoolean(false);
    final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MultiInstanceInvalidationClient.this.mService = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mSetUpRunnable);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mRemoveObserverRunnable);
            MultiInstanceInvalidationClient.this.mService = null;
        }
    };
    final Runnable mSetUpRunnable = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.mService;
                if (iMultiInstanceInvalidationService != null) {
                    MultiInstanceInvalidationClient.this.mClientId = iMultiInstanceInvalidationService.registerCallback(MultiInstanceInvalidationClient.this.mCallback, MultiInstanceInvalidationClient.this.mName);
                    MultiInstanceInvalidationClient.this.mInvalidationTracker.addObserver(MultiInstanceInvalidationClient.this.mObserver);
                }
            } catch (RemoteException unused) {
            }
        }
    };
    final Runnable mRemoveObserverRunnable = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.4
        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
        }
    };

    MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        this.mAppContext = context.getApplicationContext();
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new InvalidationTracker.Observer((String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.5
            @Override // androidx.room.InvalidationTracker.Observer
            boolean isRemote() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> set) {
                if (MultiInstanceInvalidationClient.this.mStopped.get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.mService;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(MultiInstanceInvalidationClient.this.mClientId, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        };
        this.mAppContext.bindService(new Intent(this.mAppContext, (Class<?>) MultiInstanceInvalidationService.class), this.mServiceConnection, 1);
    }

    void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mInvalidationTracker.removeObserver(this.mObserver);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.mCallback, this.mClientId);
                }
            } catch (RemoteException unused) {
            }
            this.mAppContext.unbindService(this.mServiceConnection);
        }
    }
}
