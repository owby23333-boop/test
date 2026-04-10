package com.yuewen;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Debug;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ki3 {
    public static final boolean i = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f13498b;
    public final Intent c;
    public long g;
    public String d = " unnamed";
    public final b e = new b();
    public int f = 45;
    public boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13497a = getClass().getSimpleName();

    /* JADX INFO: Add missing generic type declarations: [Result] */
    public class a<Result> extends FutureTask<Result> {
        public a(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                ki3.this.f13498b.unbindService(ki3.this.e);
            } catch (RuntimeException e) {
                Log.e(ki3.this.f13497a, "RuntimeException when trying to unbind from service", e);
            }
        }
    }

    public class b<Result> implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunnableFuture<Result> f13500a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.v(ki3.this.f13497a, "Connected: " + componentName.getShortClassName() + " at " + (System.currentTimeMillis() - ki3.this.g) + "ms");
            ki3.this.e(iBinder);
            cl2.q(this.f13500a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ki3.this.f();
            Log.v(ki3.this.f13497a, "Disconnected: " + componentName.getShortClassName() + " at " + (System.currentTimeMillis() - ki3.this.g) + "ms");
        }

        public b() {
        }
    }

    public interface c<Result> extends Callable<Result> {
        @Override // java.util.concurrent.Callable
        Result call() throws RemoteException;
    }

    public ki3(Context context, Intent intent) {
        this.f13498b = context;
        this.c = intent;
        if (Debug.isDebuggerConnected()) {
            this.f <<= 2;
        }
    }

    public int d() {
        return this.f;
    }

    public abstract void e(IBinder iBinder);

    public abstract void f();

    public <Result> Future<Result> g(c<Result> cVar, String str) throws IllegalStateException {
        if (this.h) {
            throw new IllegalStateException("Cannot call setTask twice on the same ServiceProxy.");
        }
        this.h = true;
        this.d = str;
        this.g = System.currentTimeMillis();
        Log.v(this.f13497a, "Bind requested for task " + this.d);
        a aVar = new a(cVar);
        b bVar = this.e;
        bVar.f13500a = aVar;
        this.f13498b.bindService(this.c, bVar, 1);
        return aVar;
    }

    public ki3 h(int i2) {
        this.f = i2;
        return this;
    }
}
