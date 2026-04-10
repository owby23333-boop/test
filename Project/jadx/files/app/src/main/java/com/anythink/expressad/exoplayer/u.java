package com.anythink.expressad.exoplayer;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.h.s;

/* JADX INFO: loaded from: classes2.dex */
final class u {
    public final ae a;

    @Nullable
    public final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s.a f10060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final af f10065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.i.i f10066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f10067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f10068k;

    public u(ae aeVar, long j2, af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        this(aeVar, null, new s.a(0), j2, b.b, 1, false, afVar, iVar);
    }

    public final u a(s.a aVar, long j2, long j3) {
        return new u(this.a, this.b, aVar, j2, aVar.a() ? j3 : -9223372036854775807L, this.f10063f, this.f10064g, this.f10065h, this.f10066i);
    }

    public final u b(int i2) {
        u uVar = new u(this.a, this.b, this.f10060c, this.f10061d, this.f10062e, i2, this.f10064g, this.f10065h, this.f10066i);
        a(this, uVar);
        return uVar;
    }

    public u(ae aeVar, @Nullable Object obj, s.a aVar, long j2, long j3, int i2, boolean z2, af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        this.a = aeVar;
        this.b = obj;
        this.f10060c = aVar;
        this.f10061d = j2;
        this.f10062e = j3;
        this.f10067j = j2;
        this.f10068k = j2;
        this.f10063f = i2;
        this.f10064g = z2;
        this.f10065h = afVar;
        this.f10066i = iVar;
    }

    public final u a(int i2) {
        u uVar = new u(this.a, this.b, this.f10060c.a(i2), this.f10061d, this.f10062e, this.f10063f, this.f10064g, this.f10065h, this.f10066i);
        a(this, uVar);
        return uVar;
    }

    public final u a(ae aeVar, Object obj) {
        u uVar = new u(aeVar, obj, this.f10060c, this.f10061d, this.f10062e, this.f10063f, this.f10064g, this.f10065h, this.f10066i);
        a(this, uVar);
        return uVar;
    }

    public final u a(boolean z2) {
        u uVar = new u(this.a, this.b, this.f10060c, this.f10061d, this.f10062e, this.f10063f, z2, this.f10065h, this.f10066i);
        a(this, uVar);
        return uVar;
    }

    public final u a(af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        u uVar = new u(this.a, this.b, this.f10060c, this.f10061d, this.f10062e, this.f10063f, this.f10064g, afVar, iVar);
        a(this, uVar);
        return uVar;
    }

    private static void a(u uVar, u uVar2) {
        uVar2.f10067j = uVar.f10067j;
        uVar2.f10068k = uVar.f10068k;
    }
}
