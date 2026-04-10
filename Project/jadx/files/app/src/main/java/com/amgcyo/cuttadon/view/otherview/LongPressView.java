package com.amgcyo.cuttadon.view.otherview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import com.amgcyo.cuttadon.utils.otherutils.d0;
import com.jakewharton.processphoenix.ProcessPhoenix;

/* JADX INFO: loaded from: classes.dex */
public class LongPressView extends AppCompatButton {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f5012s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f5013t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f5014u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Context f5016w;

    public LongPressView(Context context) {
        super(context);
        this.f5016w = context;
    }

    private void c() {
        new d0(this.f5016w).a(100L);
    }

    public /* synthetic */ void a() {
        ProcessPhoenix.triggerRebirth(this.f5016w);
    }

    public /* synthetic */ void b() {
        performLongClick();
        int iA0 = com.amgcyo.cuttadon.utils.otherutils.h.a0() + 1;
        int iB0 = com.amgcyo.cuttadon.utils.otherutils.h.b0() + 1;
        com.amgcyo.cuttadon.app.o.c.b(iA0);
        com.amgcyo.cuttadon.utils.otherutils.g.c(iB0 * 60);
        c();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.view.otherview.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f5104s.a();
            }
        }, 1000L);
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5012s = x2;
            this.f5013t = y2;
            this.f5015v = false;
            postDelayed(this.f5014u, 5000L);
        } else if (action == 1) {
            removeCallbacks(this.f5014u);
        } else if (action == 2 && !this.f5015v && (Math.abs(this.f5012s - motionEvent.getX()) > 20.0f || Math.abs(this.f5013t - motionEvent.getY()) > 20.0f)) {
            this.f5015v = true;
            removeCallbacks(this.f5014u);
        }
        return super.onTouchEvent(motionEvent);
    }

    public LongPressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5016w = context;
        this.f5014u = new Runnable() { // from class: com.amgcyo.cuttadon.view.otherview.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f5105s.b();
            }
        };
    }
}
