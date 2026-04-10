package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements s {
    private final ArrayList<s.b> a = new ArrayList<>(1);
    private final t.a b = new t.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.h f9293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.ae f9294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f9295e;

    protected abstract void a();

    protected final void a(com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        this.f9294d = aeVar;
        this.f9295e = obj;
        Iterator<s.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, aeVar, obj);
        }
    }

    protected abstract void a(com.anythink.expressad.exoplayer.h hVar, boolean z2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final t.a a(@Nullable s.a aVar) {
        return this.b.a(0, aVar, 0L);
    }

    private t.a a(s.a aVar, long j2) {
        com.anythink.expressad.exoplayer.k.a.a(aVar != null);
        return this.b.a(0, aVar, j2);
    }

    protected final t.a a(int i2, @Nullable s.a aVar) {
        return this.b.a(i2, aVar, 0L);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(Handler handler, t tVar) {
        this.b.a(handler, tVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(t tVar) {
        this.b.a(tVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2, s.b bVar) {
        com.anythink.expressad.exoplayer.h hVar2 = this.f9293c;
        com.anythink.expressad.exoplayer.k.a.a(hVar2 == null || hVar2 == hVar);
        this.a.add(bVar);
        if (this.f9293c == null) {
            this.f9293c = hVar;
            a(hVar, z2);
        } else {
            com.anythink.expressad.exoplayer.ae aeVar = this.f9294d;
            if (aeVar != null) {
                bVar.a(this, aeVar, this.f9295e);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(s.b bVar) {
        this.a.remove(bVar);
        if (this.a.isEmpty()) {
            this.f9293c = null;
            this.f9294d = null;
            this.f9295e = null;
            a();
        }
    }
}
