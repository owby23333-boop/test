package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements tb.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.component.dl.g.z.g.dl f654a;
    private final dl dl;
    private final com.bytedance.sdk.component.dl.g.gc e;
    private final int fo;
    private final com.bytedance.sdk.component.dl.g.z.g.e g;
    private final int gc;
    private final ls gz;
    private final int kb;
    private final sy m;
    private final int uy;
    private int wp;
    private final List<tb> z;

    public e(List<tb> list, com.bytedance.sdk.component.dl.g.z.g.e eVar, dl dlVar, com.bytedance.sdk.component.dl.g.z.g.dl dlVar2, int i, sy syVar, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar, int i2, int i3, int i4) {
        this.z = list;
        this.f654a = dlVar2;
        this.g = eVar;
        this.dl = dlVar;
        this.gc = i;
        this.m = syVar;
        this.e = gcVar;
        this.gz = lsVar;
        this.fo = i2;
        this.uy = i3;
        this.kb = i4;
    }

    public com.bytedance.sdk.component.dl.g.fo gc() {
        return this.f654a;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public int g() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public int dl() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public int a() {
        return this.kb;
    }

    public com.bytedance.sdk.component.dl.g.z.g.e m() {
        return this.g;
    }

    public dl e() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public com.bytedance.sdk.component.dl.g.gc call() {
        return this.e;
    }

    public ls gz() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public sy z() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb.z
    public h z(sy syVar) throws IOException {
        return z(syVar, this.g, this.dl, this.f654a);
    }

    public h z(sy syVar, com.bytedance.sdk.component.dl.g.z.g.e eVar, dl dlVar, com.bytedance.sdk.component.dl.g.z.g.dl dlVar2) throws IOException {
        if (this.gc >= this.z.size()) {
            throw new AssertionError();
        }
        this.wp++;
        if (this.dl != null && !this.f654a.z(syVar.z())) {
            throw new IllegalStateException("network interceptor " + this.z.get(this.gc - 1) + " must retain the same host and port");
        }
        if (this.dl != null && this.wp > 1) {
            throw new IllegalStateException("network interceptor " + this.z.get(this.gc - 1) + " must call proceed() exactly once");
        }
        e eVar2 = new e(this.z, eVar, dlVar, dlVar2, this.gc + 1, syVar, this.e, this.gz, this.fo, this.uy, this.kb);
        tb tbVar = this.z.get(this.gc);
        h hVarZ = tbVar.z(eVar2);
        if (dlVar != null && this.gc + 1 < this.z.size() && eVar2.wp != 1) {
            throw new IllegalStateException("network interceptor " + tbVar + " must call proceed() exactly once");
        }
        if (hVarZ == null) {
            throw new NullPointerException("interceptor " + tbVar + " returned a null response");
        }
        if (hVarZ.gz() != null) {
            return hVarZ;
        }
        throw new IllegalStateException("interceptor " + tbVar + " returned a response with no body");
    }
}
