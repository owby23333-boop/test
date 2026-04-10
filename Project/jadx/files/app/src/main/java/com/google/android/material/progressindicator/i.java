package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: IndeterminateDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<S extends b> extends f {
    private g<S> H;
    private h<ObjectAnimator> I;

    i(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar, @NonNull h<ObjectAnimator> hVar) {
        super(context, bVar);
        a(gVar);
        a(hVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.H.b(canvas, a());
        this.H.a(canvas, this.E);
        int i2 = 0;
        while (true) {
            h<ObjectAnimator> hVar = this.I;
            int[] iArr = hVar.f15665c;
            if (i2 >= iArr.length) {
                canvas.restore();
                return;
            }
            g<S> gVar = this.H;
            Paint paint = this.E;
            float[] fArr = hVar.b;
            int i3 = i2 * 2;
            gVar.a(canvas, paint, fArr[i3], fArr[i3 + 1], iArr[i2]);
            i2++;
        }
    }

    @NonNull
    h<ObjectAnimator> e() {
        return this.I;
    }

    @NonNull
    g<S> f() {
        return this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.H.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.H.b();
    }

    @NonNull
    public static i<LinearProgressIndicatorSpec> a(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new i<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f15629g == 0 ? new k(linearProgressIndicatorSpec) : new l(context, linearProgressIndicatorSpec));
    }

    @Override // com.google.android.material.progressindicator.f
    boolean b(boolean z2, boolean z3, boolean z4) {
        boolean zB = super.b(z2, z3, z4);
        if (!isRunning()) {
            this.I.a();
        }
        float fA = this.f15657u.a(this.f15655s.getContentResolver());
        if (z2 && (z4 || (Build.VERSION.SDK_INT <= 21 && fA > 0.0f))) {
            this.I.d();
        }
        return zB;
    }

    @NonNull
    public static i<CircularProgressIndicatorSpec> a(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    void a(@NonNull h<ObjectAnimator> hVar) {
        this.I = hVar;
        hVar.a(this);
    }

    void a(@NonNull g<S> gVar) {
        this.H = gVar;
        gVar.a(this);
    }
}
