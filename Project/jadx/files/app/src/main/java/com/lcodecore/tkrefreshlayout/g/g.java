package com.lcodecore.tkrefreshlayout.g;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/* JADX INFO: compiled from: RefreshProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements e {
    protected TwinklingRefreshLayout.d a;
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17051d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17052e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17053f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17054g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MotionEvent f17055h;

    public g(TwinklingRefreshLayout.d dVar) {
        if (dVar == null) {
            throw new NullPointerException("The coprocessor can not be null.");
        }
        this.a = dVar;
    }

    private void a() {
        MotionEvent motionEvent = this.f17055h;
        if (motionEvent == null) {
            return;
        }
        this.a.a(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    private void b() {
        MotionEvent motionEvent = this.f17055h;
        this.a.a(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent) {
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public boolean c(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0177  */
    @Override // com.lcodecore.tkrefreshlayout.g.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lcodecore.tkrefreshlayout.g.g.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, boolean z2) {
        if (!z2 && this.f17052e) {
            this.a.k().c();
        }
        if (!z2 && this.f17053f) {
            this.a.k().d();
        }
        this.f17052e = false;
        this.f17053f = false;
    }

    @Override // com.lcodecore.tkrefreshlayout.g.e
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3, float f4, float f5) {
        int iU = this.a.u();
        if (this.a.G() && f3 >= iU && !this.a.A()) {
            this.a.k().b((int) f5);
        }
        if (!this.a.z() || f3 > (-iU)) {
            return;
        }
        this.a.k().a((int) f5);
    }
}
