package com.mardous.discreteseekbar.a.d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ThumbDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends c implements Animatable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f17641w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17642x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f17643y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Runnable f17644z;

    /* JADX INFO: compiled from: ThumbDrawable.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f17642x = true;
            d.this.invalidateSelf();
            d.this.f17643y = false;
        }
    }

    public d(@NonNull ColorStateList colorStateList, int i2) {
        super(colorStateList);
        this.f17644z = new a();
        this.f17641w = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17641w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17641w;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f17643y;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        a();
    }

    @Override // com.mardous.discreteseekbar.a.d.c
    public void a(Canvas canvas, Paint paint) {
        if (this.f17642x) {
            return;
        }
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f17641w / 2, paint);
    }

    public void b() {
        scheduleSelf(this.f17644z, SystemClock.uptimeMillis() + 100);
        this.f17643y = true;
    }

    public void a() {
        this.f17642x = false;
        this.f17643y = false;
        unscheduleSelf(this.f17644z);
        invalidateSelf();
    }
}
