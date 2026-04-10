package com.yuewen;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ti<T> extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f17991a;

    public ti(@NonNull T t) {
        this.f17991a = new WeakReference<>(t);
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference<T> weakReference = this.f17991a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        a(message);
    }

    public ti(@NonNull T t, Handler.Callback callback) {
        super(callback);
        this.f17991a = new WeakReference<>(t);
    }
}
