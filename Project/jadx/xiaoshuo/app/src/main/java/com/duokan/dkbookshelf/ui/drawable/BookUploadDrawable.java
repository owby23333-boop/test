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
public class BookUploadDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f3283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimationDrawable f3284b;
    public final Drawable.Callback c;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable2) {
            BookUploadDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable2, Runnable runnable, long j) {
            BookUploadDrawable.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
            BookUploadDrawable.this.unscheduleSelf(runnable);
        }
    }

    public BookUploadDrawable(Context context) {
        a aVar = new a();
        this.c = aVar;
        this.f3283a = ContextCompat.getDrawable(context, es2.h.o3);
        AnimationDrawable animationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, es2.h.h3);
        this.f3284b = animationDrawable;
        animationDrawable.setCallback(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3283a.draw(canvas);
        this.f3284b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3283a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3283a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3284b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f3283a.setBounds(rect);
        this.f3284b.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f3283a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3283a.setAlpha(i);
        this.f3284b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3283a.setColorFilter(colorFilter);
        this.f3284b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f3284b.isRunning()) {
            return;
        }
        this.f3284b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f3284b.isRunning()) {
            this.f3284b.setVisible(true, true);
            this.f3284b.stop();
        }
    }
}
