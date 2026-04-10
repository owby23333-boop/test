package com.amgcyo.cuttadon.view.comic.zoomablerecyclerview;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import androidx.core.widget.ScrollerCompat;
import com.amgcyo.cuttadon.view.comic.j;

/* JADX INFO: compiled from: FlingRunnable.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f4586s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final a f4587t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ScrollerCompat f4588u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4589v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4590w;

    /* JADX INFO: compiled from: FlingRunnable.java */
    interface a {
        void a(int i2, int i3);
    }

    b(Context context, a aVar, View view) {
        this.f4588u = ScrollerCompat.create(context);
        this.f4587t = aVar;
        this.f4586s = view;
    }

    void a() {
        this.f4588u.abortAnimation();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f4588u.isFinished() && this.f4588u.computeScrollOffset()) {
            int currX = this.f4588u.getCurrX();
            int currY = this.f4588u.getCurrY();
            this.f4587t.a(this.f4589v - currX, this.f4590w - currY);
            this.f4589v = currX;
            this.f4590w = currY;
            j.a(this.f4586s, this);
        }
    }

    void a(RectF rectF, int i2, int i3, int i4, int i5) {
        int i6;
        int iRound;
        int i7;
        int iRound2;
        int iRound3 = Math.round(-rectF.left);
        float f2 = i2;
        if (f2 < rectF.width()) {
            iRound = Math.round(rectF.width() - f2);
            i6 = 0;
        } else {
            i6 = iRound3;
            iRound = i6;
        }
        int iRound4 = Math.round(-rectF.top);
        float f3 = i3;
        if (f3 < rectF.height()) {
            iRound2 = Math.round(rectF.height() - f3);
            i7 = 0;
        } else {
            i7 = iRound4;
            iRound2 = i7;
        }
        this.f4589v = iRound3;
        this.f4590w = iRound4;
        if (iRound3 == iRound && iRound4 == iRound2) {
            return;
        }
        this.f4588u.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
    }
}
