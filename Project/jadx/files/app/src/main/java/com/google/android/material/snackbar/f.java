package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static f f15829e;

    @NonNull
    private final Object a = new Object();

    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private c f15830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private c f15831d;

    /* JADX INFO: compiled from: SnackbarManager.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            f.this.a((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    interface b {
        void a(int i2);
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    private static class c {

        @NonNull
        final WeakReference<b> a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f15833c;

        boolean a(@Nullable b bVar) {
            return bVar != null && this.a.get() == bVar;
        }
    }

    private f() {
    }

    static f a() {
        if (f15829e == null) {
            f15829e = new f();
        }
        return f15829e;
    }

    private boolean c(b bVar) {
        c cVar = this.f15830c;
        return cVar != null && cVar.a(bVar);
    }

    public void b(b bVar) {
        synchronized (this.a) {
            if (c(bVar) && this.f15830c.f15833c) {
                this.f15830c.f15833c = false;
                b(this.f15830c);
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.a) {
            if (c(bVar) && !this.f15830c.f15833c) {
                this.f15830c.f15833c = true;
                this.b.removeCallbacksAndMessages(this.f15830c);
            }
        }
    }

    private void b(@NonNull c cVar) {
        int i2 = cVar.b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? TTAdConstant.STYLE_SIZE_RADIO_3_2 : 2750;
        }
        this.b.removeCallbacksAndMessages(cVar);
        Handler handler = this.b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    private boolean a(@NonNull c cVar, int i2) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.b.removeCallbacksAndMessages(cVar);
        bVar.a(i2);
        return true;
    }

    void a(@NonNull c cVar) {
        synchronized (this.a) {
            if (this.f15830c == cVar || this.f15831d == cVar) {
                a(cVar, 2);
            }
        }
    }
}
