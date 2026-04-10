package com.anythink.expressad.foundation.g.f;

import android.content.Context;
import com.anythink.core.common.b.n;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static m f10604c;
    private j a;
    private com.anythink.expressad.foundation.g.f.d.b b;

    private m() {
    }

    public static void a(Context context) {
        if (f10604c == null) {
            m mVar = new m();
            f10604c = mVar;
            mVar.a = new j(context.getApplicationContext());
            f10604c.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
    }

    private static j b() {
        m mVar = f10604c;
        if (mVar != null) {
            j jVar = mVar.a;
            if (jVar != null) {
                return jVar;
            }
            mVar.a = new j(n.a().g());
            return f10604c.a;
        }
        m mVar2 = new m();
        f10604c = mVar2;
        if (mVar2.a == null) {
            f10604c.a = new j(n.a().g());
        }
        return f10604c.a;
    }

    private static void c() {
        com.anythink.expressad.foundation.g.f.d.b bVar;
        m mVar = f10604c;
        if (mVar == null || (bVar = mVar.b) == null) {
            return;
        }
        bVar.a();
        f10604c.b = null;
    }

    public static void a(i iVar) {
        b().a(iVar);
    }

    public static com.anythink.expressad.foundation.g.f.d.b a() {
        m mVar = f10604c;
        if (mVar != null) {
            com.anythink.expressad.foundation.g.f.d.b bVar = mVar.b;
            if (bVar != null) {
                return bVar;
            }
            mVar.b = new com.anythink.expressad.foundation.g.f.d.b(b());
            return f10604c.b;
        }
        m mVar2 = new m();
        f10604c = mVar2;
        if (mVar2.b == null) {
            f10604c.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
        return f10604c.b;
    }
}
