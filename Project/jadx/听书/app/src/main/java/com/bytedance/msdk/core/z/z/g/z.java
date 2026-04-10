package com.bytedance.msdk.core.z.z.g;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.core.z.z.z.g;
import com.bytedance.msdk.g.dl;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements com.bytedance.msdk.core.z.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f423a;
    public Function<SparseArray<Object>, Object> dl;
    public uy g;
    public com.bytedance.msdk.api.z.g z;

    protected abstract void z(Context context);

    @Override // com.bytedance.msdk.core.z.z.z.z
    public final void z(Context context, Function<SparseArray<Object>, Object> function, com.bytedance.msdk.api.z.g gVar, uy uyVar, g gVar2) {
        if (function == null || gVar == null || uyVar == null || gVar2 == null) {
            return;
        }
        this.f423a = gVar2;
        this.g = uyVar;
        this.z = gVar;
        this.dl = function;
        z(context);
    }

    public final void z(int i, String str) {
        g gVar = this.f423a;
        if (gVar != null) {
            gVar.z(i, str);
        }
    }

    public void z(List<dl> list) {
        g gVar = this.f423a;
        if (gVar != null) {
            gVar.z(list);
        }
    }

    public void z(dl dlVar, com.bytedance.msdk.api.z zVar) {
        g gVar = this.f423a;
        if (gVar != null) {
            gVar.z(dlVar, zVar);
        }
    }

    public boolean z() {
        uy uyVar = this.g;
        if (uyVar == null) {
            return false;
        }
        int iUy = uyVar.uy();
        return iUy == 1 || iUy == 3;
    }

    public String g() {
        uy uyVar = this.g;
        return (uyVar == null || !uyVar.gk() || this.g.l() == null) ? "" : this.g.l().uy();
    }

    public boolean dl() {
        return ((com.bytedance.msdk.e.z.z.z().a() == 1) && this.g.x()) || ((com.bytedance.msdk.e.z.z.z().gc() == 1) && (this.g.js() == 0));
    }
}
