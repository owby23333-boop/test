package com.anythink.expressad.exoplayer.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.d.c;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(18)
final class b<T extends i> implements f<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f8773i = "DefaultDrmSession";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8774j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8775k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f8776l = 60;
    private byte[] A;
    private Object B;
    private Object C;
    final n a;
    final UUID b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b<T>.HandlerC0184b f8777c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final j<T> f8778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c<T> f8779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final e.a f8780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f8781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final HashMap<String, String> f8782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final c.a f8783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8784s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8785t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8786u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private HandlerThread f8787v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b<T>.a f8788w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private T f8789x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private f.a f8790y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f8791z;

    @SuppressLint({"HandlerLeak"})
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        final void a(int i2, Object obj, boolean z2) {
            obtainMessage(i2, z2 ? 1 : 0, 0, obj).sendToTarget();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object objA;
            int i2;
            Object obj = message.obj;
            try {
                int i3 = message.what;
                if (i3 == 0) {
                    objA = b.this.a.a();
                } else {
                    if (i3 != 1) {
                        throw new RuntimeException();
                    }
                    Pair pair = (Pair) obj;
                    Object obj2 = pair.first;
                    Object obj3 = pair.second;
                    objA = b.this.a.b();
                }
            } catch (Exception e2) {
                boolean z2 = false;
                if ((message.arg1 == 1) && (i2 = message.arg2 + 1) <= b.this.f8784s) {
                    Message messageObtain = Message.obtain(message);
                    messageObtain.arg2 = i2;
                    sendMessageDelayed(messageObtain, Math.min((i2 - 1) * 1000, 5000));
                    z2 = true;
                }
                if (z2) {
                    return;
                } else {
                    objA = e2;
                }
            }
            b.this.f8777c.obtainMessage(message.what, Pair.create(obj, objA)).sendToTarget();
        }

        private boolean a(Message message) {
            int i2;
            if (!(message.arg1 == 1) || (i2 = message.arg2 + 1) > b.this.f8784s) {
                return false;
            }
            Message messageObtain = Message.obtain(message);
            messageObtain.arg2 = i2;
            sendMessageDelayed(messageObtain, Math.min((i2 - 1) * 1000, 5000));
            return true;
        }

        private static long a(int i2) {
            return Math.min((i2 - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.d.b$b, reason: collision with other inner class name */
    @SuppressLint({"HandlerLeak"})
    private class HandlerC0184b extends Handler {
        public HandlerC0184b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                b.a(b.this, obj, obj2);
            } else {
                if (i2 != 1) {
                    return;
                }
                b.b(b.this, obj, obj2);
            }
        }
    }

    public interface c<T extends i> {
        void a();

        void a(b<T> bVar);

        void a(Exception exc);
    }

    public b(UUID uuid, j<T> jVar, c<T> cVar, @Nullable e.a aVar, int i2, @Nullable byte[] bArr, HashMap<String, String> map, n nVar, Looper looper, c.a aVar2, int i3) {
        this.b = uuid;
        this.f8779n = cVar;
        this.f8778m = jVar;
        this.f8781p = i2;
        this.A = bArr;
        this.f8780o = bArr != null ? null : aVar;
        this.f8782q = map;
        this.a = nVar;
        this.f8784s = i3;
        this.f8783r = aVar2;
        this.f8785t = 2;
        this.f8777c = new HandlerC0184b(looper);
        this.f8787v = new HandlerThread("DrmRequestHandler");
        this.f8787v.start();
        this.f8788w = new a(this.f8787v.getLooper());
    }

    private boolean j() {
        if (n()) {
            return true;
        }
        try {
            this.f8791z = this.f8778m.a();
            this.f8789x = (T) this.f8778m.d(this.f8791z);
            this.f8785t = 3;
            return true;
        } catch (Exception e2) {
            c(e2);
            return false;
        }
    }

    private boolean k() {
        try {
            this.f8778m.b(this.f8791z, this.A);
            return true;
        } catch (Exception e2) {
            c(e2);
            return false;
        }
    }

    private long l() {
        if (!com.anythink.expressad.exoplayer.b.bk.equals(this.b)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> pairA = p.a(this);
        return Math.min(((Long) pairA.first).longValue(), ((Long) pairA.second).longValue());
    }

    private void m() {
        if (this.f8785t == 4) {
            this.f8785t = 3;
            c(new m());
        }
    }

    private boolean n() {
        int i2 = this.f8785t;
        return i2 == 3 || i2 == 4;
    }

    public final boolean b() {
        int i2 = this.f8786u - 1;
        this.f8786u = i2;
        if (i2 != 0) {
            return false;
        }
        this.f8785t = 0;
        this.f8777c.removeCallbacksAndMessages(null);
        this.f8788w.removeCallbacksAndMessages(null);
        this.f8788w = null;
        this.f8787v.quit();
        this.f8787v = null;
        this.f8789x = null;
        this.f8790y = null;
        this.B = null;
        this.C = null;
        byte[] bArr = this.f8791z;
        if (bArr != null) {
            this.f8778m.a(bArr);
            this.f8791z = null;
        }
        return true;
    }

    public final void c() {
        this.C = this.f8778m.b();
        this.f8788w.a(0, this.C, true);
    }

    public final void d() {
        if (j()) {
            a(true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final int e() {
        return this.f8785t;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final f.a f() {
        if (this.f8785t == 1) {
            return this.f8790y;
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final T g() {
        return this.f8789x;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final Map<String, String> h() {
        byte[] bArr = this.f8791z;
        if (bArr == null) {
            return null;
        }
        return this.f8778m.c(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final byte[] i() {
        return this.A;
    }

    public final void a() {
        int i2 = this.f8786u + 1;
        this.f8786u = i2;
        if (i2 == 1 && this.f8785t != 1 && j()) {
            a(true);
        }
    }

    private void c(Exception exc) {
        this.f8790y = new f.a(exc);
        this.f8783r.a(exc);
        if (this.f8785t != 4) {
            this.f8785t = 1;
        }
    }

    public final boolean a(byte[] bArr) {
        e.a aVar = this.f8780o;
        return Arrays.equals(aVar != null ? aVar.f8813c : null, bArr);
    }

    public final void a(int i2) {
        if (n()) {
            if (i2 == 1) {
                this.f8785t = 3;
                this.f8779n.a(this);
            } else {
                if (i2 != 2) {
                    if (i2 == 3 && this.f8785t == 4) {
                        this.f8785t = 3;
                        c(new m());
                        return;
                    }
                    return;
                }
                a(false);
            }
        }
    }

    public final void a(Exception exc) {
        c(exc);
    }

    private void a(Object obj, Object obj2) {
        if (obj == this.C) {
            if (this.f8785t == 2 || n()) {
                this.C = null;
                if (obj2 instanceof Exception) {
                    this.f8779n.a((Exception) obj2);
                    return;
                }
                try {
                    this.f8778m.b((byte[]) obj2);
                    this.f8779n.a();
                } catch (Exception e2) {
                    this.f8779n.a(e2);
                }
            }
        }
    }

    public final boolean b(byte[] bArr) {
        return Arrays.equals(this.f8791z, bArr);
    }

    private void b(Object obj, Object obj2) {
        if (obj == this.B && n()) {
            this.B = null;
            if (obj2 instanceof Exception) {
                b((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f8781p == 3) {
                    this.f8778m.a(this.A, bArr);
                    this.f8783r.c();
                    return;
                }
                byte[] bArrA = this.f8778m.a(this.f8791z, bArr);
                if ((this.f8781p == 2 || (this.f8781p == 0 && this.A != null)) && bArrA != null && bArrA.length != 0) {
                    this.A = bArrA;
                }
                this.f8785t = 4;
                this.f8783r.a();
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    private void a(boolean z2) {
        int i2 = this.f8781p;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && k()) {
                    a(3, z2);
                    return;
                }
                return;
            }
            if (this.A == null) {
                a(2, z2);
                return;
            } else {
                if (k()) {
                    a(2, z2);
                    return;
                }
                return;
            }
        }
        if (this.A == null) {
            a(1, z2);
            return;
        }
        if (this.f8785t == 4 || k()) {
            long jL = l();
            if (this.f8781p == 0 && jL <= 60) {
                "Offline license has expired or will expire soon. Remaining seconds: ".concat(String.valueOf(jL));
                a(2, z2);
            } else if (jL <= 0) {
                c(new m());
            } else {
                this.f8785t = 4;
                this.f8783r.b();
            }
        }
    }

    private void b(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f8779n.a(this);
        } else {
            c(exc);
        }
    }

    static /* synthetic */ void b(b bVar, Object obj, Object obj2) {
        if (obj == bVar.B && bVar.n()) {
            bVar.B = null;
            if (obj2 instanceof Exception) {
                bVar.b((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (bVar.f8781p == 3) {
                    bVar.f8778m.a(bVar.A, bArr);
                    bVar.f8783r.c();
                    return;
                }
                byte[] bArrA = bVar.f8778m.a(bVar.f8791z, bArr);
                if ((bVar.f8781p == 2 || (bVar.f8781p == 0 && bVar.A != null)) && bArrA != null && bArrA.length != 0) {
                    bVar.A = bArrA;
                }
                bVar.f8785t = 4;
                bVar.f8783r.a();
            } catch (Exception e2) {
                bVar.b(e2);
            }
        }
    }

    private void a(int i2, boolean z2) {
        String str;
        byte[] bArr;
        String str2;
        byte[] bArr2 = i2 == 3 ? this.A : this.f8791z;
        e.a aVar = this.f8780o;
        if (aVar != null) {
            byte[] bArr3 = aVar.f8813c;
            String str3 = aVar.b;
            str = aVar.a;
            str2 = str3;
            bArr = bArr3;
        } else {
            str = null;
            bArr = null;
            str2 = null;
        }
        try {
            this.B = Pair.create(this.f8778m.a(bArr2, bArr, str2, i2, this.f8782q), str);
            this.f8788w.a(1, this.B, z2);
        } catch (Exception e2) {
            b(e2);
        }
    }

    static /* synthetic */ void a(b bVar, Object obj, Object obj2) {
        if (obj == bVar.C) {
            if (bVar.f8785t == 2 || bVar.n()) {
                bVar.C = null;
                if (obj2 instanceof Exception) {
                    bVar.f8779n.a((Exception) obj2);
                    return;
                }
                try {
                    bVar.f8778m.b((byte[]) obj2);
                    bVar.f8779n.a();
                } catch (Exception e2) {
                    bVar.f8779n.a(e2);
                }
            }
        }
    }
}
