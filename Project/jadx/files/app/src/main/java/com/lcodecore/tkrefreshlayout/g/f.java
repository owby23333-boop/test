package com.lcodecore.tkrefreshlayout.g;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/* JADX INFO: compiled from: OverScrollDecorator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f17049h;

    /* JADX INFO: compiled from: OverScrollDecorator.java */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int iU = f.this.b.u();
            int i2 = message.what;
            if (i2 == 0) {
                f.this.f17045d = -1;
            } else if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                f.this.f17045d = 60;
                return;
            }
            f.b(f.this);
            View viewT = f.this.b.t();
            if (f.this.b.a()) {
                if (f.this.f17044c >= 3000.0f) {
                    if (com.lcodecore.tkrefreshlayout.h.c.b(viewT, iU)) {
                        f.this.b.k().b(f.this.f17044c, f.this.f17045d);
                        f.this.f17044c = 0.0f;
                        f.this.f17045d = 60;
                    }
                } else if (f.this.f17044c <= -3000.0f && com.lcodecore.tkrefreshlayout.h.c.a(viewT, iU)) {
                    f.this.b.k().a(f.this.f17044c, f.this.f17045d);
                    f.this.f17044c = 0.0f;
                    f.this.f17045d = 60;
                }
            }
            if (f.this.f17045d < 60) {
                f.this.f17049h.sendEmptyMessageDelayed(1, 10L);
            }
        }
    }

    public f(TwinklingRefreshLayout.d dVar, e eVar) {
        super(dVar, eVar);
        this.f17045d = 0;
        this.f17046e = false;
        this.f17047f = false;
        this.f17048g = false;
        this.f17049h = new a();
    }

    static /* synthetic */ int b(f fVar) {
        int i2 = fVar.f17045d;
        fVar.f17045d = i2 + 1;
        return i2;
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        e eVar = this.a;
        return eVar != null && eVar.dispatchTouchEvent(motionEvent);
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public boolean b(MotionEvent motionEvent) {
        e eVar = this.a;
        return eVar != null && eVar.b(motionEvent);
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public boolean c(MotionEvent motionEvent) {
        e eVar = this.a;
        return eVar != null && eVar.c(motionEvent);
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(motionEvent);
        }
        this.f17046e = com.lcodecore.tkrefreshlayout.h.c.b(this.b.t(), this.b.u());
        this.f17047f = com.lcodecore.tkrefreshlayout.h.c.a(this.b.t(), this.b.u());
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, boolean z2) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(motionEvent, this.f17048g && z2);
        }
        this.f17048g = false;
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3, float f4, float f5) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(motionEvent, motionEvent2, f2, f3, f4, f5);
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(motionEvent, motionEvent2, f2, f3);
        }
        if (this.b.f()) {
            int y2 = (int) (motionEvent2.getY() - motionEvent.getY());
            if (y2 >= (-this.b.u()) || !this.f17047f) {
                if (y2 <= this.b.u() || !this.f17046e) {
                    this.f17044c = f3;
                    if (Math.abs(this.f17044c) >= 3000.0f) {
                        this.f17049h.sendEmptyMessage(0);
                        this.f17048g = true;
                    } else {
                        this.f17044c = 0.0f;
                        this.f17045d = 60;
                    }
                }
            }
        }
    }
}
