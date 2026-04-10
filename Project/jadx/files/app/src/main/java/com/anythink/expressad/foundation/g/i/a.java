package com.anythink.expressad.foundation.g.i;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPlayer f10616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f10617d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile MediaPlayer.OnPreparedListener f10619f;
    Object a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f10618e = false;

    static /* synthetic */ boolean a(a aVar) {
        aVar.f10618e = true;
        return true;
    }

    private String c() {
        return this.b;
    }

    private MediaPlayer d() {
        return this.f10616c;
    }

    private void a(MediaPlayer mediaPlayer, String str) {
        this.f10616c = mediaPlayer;
        this.b = str;
        this.f10617d = true;
        this.f10616c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.anythink.expressad.foundation.g.i.a.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                synchronized (a.this.a) {
                    a.a(a.this);
                    if (a.this.f10619f != null) {
                        a.this.f10619f.onPrepared(mediaPlayer2);
                    }
                }
            }
        });
        try {
            this.f10616c.prepareAsync();
        } catch (Throwable unused) {
        }
    }

    private boolean b() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f10618e;
        }
        return z2;
    }

    private boolean a() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f10617d;
        }
        return z2;
    }

    private void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        synchronized (this.a) {
            this.f10619f = onPreparedListener;
        }
    }
}
