package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: PreloadTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<Z> extends c<Z> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Handler f13876w = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.bumptech.glide.i f13877v;

    /* JADX INFO: compiled from: PreloadTarget.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((h) message.obj).b();
            return true;
        }
    }

    private h(com.bumptech.glide.i iVar, int i2, int i3) {
        super(i2, i3);
        this.f13877v = iVar;
    }

    public static <Z> h<Z> a(com.bumptech.glide.i iVar, int i2, int i3) {
        return new h<>(iVar, i2, i3);
    }

    void b() {
        this.f13877v.clear(this);
    }

    @Override // com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@NonNull Z z2, @Nullable com.bumptech.glide.request.l.d<? super Z> dVar) {
        com.bumptech.glide.request.e eVarA = a();
        if (eVarA == null || !eVarA.isComplete()) {
            return;
        }
        f13876w.obtainMessage(1, this).sendToTarget();
    }
}
