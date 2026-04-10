package com.anythink.expressad.exoplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.anythink.expressad.exoplayer.a implements Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9143n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9144o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final d f9145p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final f f9146q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Handler f9147r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final n f9148s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final e f9149t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.g.a[] f9150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long[] f9151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f9152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f9153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private b f9154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f9155z;

    @Deprecated
    public interface a extends f {
    }

    public g(f fVar, Looper looper) {
        this(fVar, looper, d.a);
    }

    private void b(com.anythink.expressad.exoplayer.g.a aVar) {
        this.f9146q.a(aVar);
    }

    private void w() {
        Arrays.fill(this.f9150u, (Object) null);
        this.f9152w = 0;
        this.f9153x = 0;
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(m mVar) {
        if (this.f9145p.a(mVar)) {
            return com.anythink.expressad.exoplayer.a.a((com.anythink.expressad.exoplayer.d.g<?>) null, mVar.f9993k) ? 4 : 2;
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((com.anythink.expressad.exoplayer.g.a) message.obj);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void p() {
        w();
        this.f9154y = null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.f9155z;
    }

    private g(f fVar, Looper looper, d dVar) {
        super(4);
        this.f9146q = (f) com.anythink.expressad.exoplayer.k.a.a(fVar);
        this.f9147r = looper == null ? null : new Handler(looper, this);
        this.f9145p = (d) com.anythink.expressad.exoplayer.k.a.a(dVar);
        this.f9148s = new n();
        this.f9149t = new e();
        this.f9150u = new com.anythink.expressad.exoplayer.g.a[5];
        this.f9151v = new long[5];
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void a(m[] mVarArr, long j2) {
        this.f9154y = this.f9145p.b(mVarArr[0]);
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void a(long j2, boolean z2) {
        w();
        this.f9155z = false;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j2, long j3) throws com.anythink.expressad.exoplayer.g {
        if (!this.f9155z && this.f9153x < 5) {
            this.f9149t.a();
            if (a(this.f9148s, (com.anythink.expressad.exoplayer.c.e) this.f9149t, false) == -4) {
                if (this.f9149t.c()) {
                    this.f9155z = true;
                } else if (!this.f9149t.b()) {
                    e eVar = this.f9149t;
                    eVar.f9142g = this.f9148s.a.f9994l;
                    eVar.h();
                    try {
                        int i2 = (this.f9152w + this.f9153x) % 5;
                        this.f9150u[i2] = this.f9154y.a(this.f9149t);
                        this.f9151v[i2] = this.f9149t.f8738f;
                        this.f9153x++;
                    } catch (c e2) {
                        throw com.anythink.expressad.exoplayer.g.a(e2, s());
                    }
                }
            }
        }
        if (this.f9153x > 0) {
            long[] jArr = this.f9151v;
            int i3 = this.f9152w;
            if (jArr[i3] <= j2) {
                com.anythink.expressad.exoplayer.g.a aVar = this.f9150u[i3];
                Handler handler = this.f9147r;
                if (handler != null) {
                    handler.obtainMessage(0, aVar).sendToTarget();
                } else {
                    b(aVar);
                }
                com.anythink.expressad.exoplayer.g.a[] aVarArr = this.f9150u;
                int i4 = this.f9152w;
                aVarArr[i4] = null;
                this.f9152w = (i4 + 1) % 5;
                this.f9153x--;
            }
        }
    }

    private void a(com.anythink.expressad.exoplayer.g.a aVar) {
        Handler handler = this.f9147r;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            b(aVar);
        }
    }
}
