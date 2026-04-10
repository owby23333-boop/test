package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
final class FakeDrag {
    private final ViewPager2 a;
    private final ScrollEventAdapter b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f13202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f13203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f13205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13207h;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.a = viewPager2;
        this.b = scrollEventAdapter;
        this.f13202c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f13203d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f13203d = VelocityTracker.obtain();
            this.f13204e = ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    boolean a() {
        return this.b.g();
    }

    @UiThread
    boolean b() {
        if (this.b.f()) {
            return false;
        }
        this.f13206g = 0;
        this.f13205f = 0;
        this.f13207h = SystemClock.uptimeMillis();
        d();
        this.b.b();
        if (!this.b.e()) {
            this.f13202c.stopScroll();
        }
        a(this.f13207h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean c() {
        if (!this.b.g()) {
            return false;
        }
        this.b.c();
        VelocityTracker velocityTracker = this.f13203d;
        velocityTracker.computeCurrentVelocity(1000, this.f13204e);
        if (this.f13202c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.a.d();
        return true;
    }

    @UiThread
    boolean a(float f2) {
        if (!this.b.g()) {
            return false;
        }
        this.f13205f -= f2;
        int iRound = Math.round(this.f13205f - this.f13206g);
        this.f13206g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z2 = this.a.getOrientation() == 0;
        int i2 = z2 ? iRound : 0;
        if (z2) {
            iRound = 0;
        }
        float f3 = z2 ? this.f13205f : 0.0f;
        float f4 = z2 ? 0.0f : this.f13205f;
        this.f13202c.scrollBy(i2, iRound);
        a(jUptimeMillis, 2, f3, f4);
        return true;
    }

    private void a(long j2, int i2, float f2, float f3) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f13207h, j2, i2, f2, f3, 0);
        this.f13203d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }
}
