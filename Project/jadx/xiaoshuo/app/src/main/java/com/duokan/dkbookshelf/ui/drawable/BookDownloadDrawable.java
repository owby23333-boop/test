package com.duokan.dkbookshelf.ui.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.yuewen.es2;

/* JADX INFO: loaded from: classes13.dex */
public class BookDownloadDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f3280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimationDrawable f3281b;
    public final Drawable.Callback c;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable2) {
            BookDownloadDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable2, Runnable runnable, long j) {
            BookDownloadDrawable.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
            BookDownloadDrawable.this.unscheduleSelf(runnable);
        }
    }

    public BookDownloadDrawable(Context context) {
        a aVar = new a();
        this.c = aVar;
        this.f3280a = ContextCompat.getDrawable(context, es2.h.e3);
        AnimationDrawable animationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, es2.h.X2);
        this.f3281b = animationDrawable;
        animationDrawable.setCallback(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3280a.draw(canvas);
        this.f3281b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3280a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3280a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3281b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f3280a.setBounds(rect);
        this.f3281b.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f3280a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3280a.setAlpha(i);
        this.f3281b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3280a.setColorFilter(colorFilter);
        this.f3281b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f3281b.isRunning()) {
            return;
        }
        this.f3281b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f3281b.isRunning()) {
            this.f3281b.setVisible(true, true);
            this.f3281b.stop();
        }
    }
}
