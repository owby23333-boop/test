package com.bumptech.glide.load.k.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.k.g.g;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GifDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {
    private Paint A;
    private Rect B;
    private List<Animatable2Compat.AnimationCallback> C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final a f13719s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f13720t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13721u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13723w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13724x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f13725y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13726z;

    /* JADX INFO: compiled from: GifDrawable.java */
    static final class a extends Drawable.ConstantState {

        @VisibleForTesting
        final g a;

        a(g gVar) {
            this.a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.i<Bitmap> iVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.a(context), gifDecoder, i2, i3, iVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback h() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect i() {
        if (this.B == null) {
            this.B = new Rect();
        }
        return this.B;
    }

    private Paint j() {
        if (this.A == null) {
            this.A = new Paint(2);
        }
        return this.A;
    }

    private void k() {
        List<Animatable2Compat.AnimationCallback> list = this.C;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.C.get(i2).onAnimationEnd(this);
            }
        }
    }

    private void l() {
        this.f13724x = 0;
    }

    private void m() {
        k.a(!this.f13722v, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f13719s.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f13720t) {
                return;
            }
            this.f13720t = true;
            this.f13719s.a.a(this);
            invalidateSelf();
        }
    }

    private void n() {
        this.f13720t = false;
        this.f13719s.a.b(this);
    }

    public void a(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.f13719s.a.a(iVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f13719s.a.b();
    }

    public Bitmap c() {
        return this.f13719s.a.e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.C;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.f13719s.a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f13722v) {
            return;
        }
        if (this.f13726z) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), i());
            this.f13726z = false;
        }
        canvas.drawBitmap(this.f13719s.a.c(), (Rect) null, i(), j());
    }

    public int e() {
        return this.f13719s.a.d();
    }

    public int f() {
        return this.f13719s.a.i();
    }

    public void g() {
        this.f13722v = true;
        this.f13719s.a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13719s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f13719s.a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f13719s.a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f13720t;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13726z = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        j().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        j().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        k.a(!this.f13722v, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f13723w = z2;
        if (!z2) {
            n();
        } else if (this.f13721u) {
            m();
        }
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f13721u = true;
        l();
        if (this.f13723w) {
            m();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f13721u = false;
        n();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.C;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    @Override // com.bumptech.glide.load.k.g.g.b
    public void a() {
        if (h() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f13724x++;
        }
        int i2 = this.f13725y;
        if (i2 == -1 || this.f13724x < i2) {
            return;
        }
        k();
        stop();
    }

    c(a aVar) {
        this.f13723w = true;
        this.f13725y = -1;
        k.a(aVar);
        this.f13719s = aVar;
    }

    public void a(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            int iH = this.f13719s.a.h();
            if (iH == 0) {
                iH = -1;
            }
            this.f13725y = iH;
            return;
        }
        this.f13725y = i2;
    }
}
