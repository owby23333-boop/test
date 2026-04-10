package com.google.android.play.core.a;

import android.content.ServiceConnection;

/* JADX INFO: loaded from: classes7.dex */
final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ b f6918a;

    public e(b bVar) {
        this.f6918a = bVar;
    }

    @Override // com.google.android.play.core.a.a
    public final void b() {
        if (this.f6918a.l != null) {
            this.f6918a.c.a("Unbind from service.", new Object[0]);
            this.f6918a.f6914b.unbindService(this.f6918a.k);
            b.a(this.f6918a, false);
            this.f6918a.l = null;
            b.a(this.f6918a, (ServiceConnection) null);
        }
    }
}
