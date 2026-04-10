package com.anythink.expressad.exoplayer.i;

import com.anythink.expressad.exoplayer.aa;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public final int a;
    public final aa[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f9568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9569d;

    public i(aa[] aaVarArr, f[] fVarArr, Object obj) {
        this.b = aaVarArr;
        this.f9568c = new g(fVarArr);
        this.f9569d = obj;
        this.a = aaVarArr.length;
    }

    public final boolean a(int i2) {
        return this.b[i2] != null;
    }

    public final boolean a(i iVar) {
        if (iVar == null || iVar.f9568c.a != this.f9568c.a) {
            return false;
        }
        for (int i2 = 0; i2 < this.f9568c.a; i2++) {
            if (!a(iVar, i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(i iVar, int i2) {
        return iVar != null && af.a(this.b[i2], iVar.b[i2]) && af.a(this.f9568c.a(i2), iVar.f9568c.a(i2));
    }
}
