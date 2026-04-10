package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import com.anythink.expressad.exoplayer.j.h;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements h.a {
    private final Context a;
    private final aa<? super h> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a f9711c;

    public o(Context context, String str) {
        this(context, str, (aa<? super h>) null);
    }

    private n b() {
        return new n(this.a, this.b, this.f9711c.a());
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new n(this.a, this.b, this.f9711c.a());
    }

    private o(Context context, String str, aa<? super h> aaVar) {
        this(context, aaVar, new q(str, aaVar));
    }

    private o(Context context, aa<? super h> aaVar, h.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aaVar;
        this.f9711c = aVar;
    }
}
