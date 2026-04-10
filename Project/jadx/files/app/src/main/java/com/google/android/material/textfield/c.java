package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends MaterialShapeDrawable {

    @NonNull
    private final Paint Q;

    @NonNull
    private final RectF R;
    private int S;

    c() {
        this(null);
    }

    private void b(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!a(callback)) {
            c(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void c(@NonNull Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.S = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.S = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void y() {
        this.Q.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Q.setColor(-1);
        this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    void a(float f2, float f3, float f4, float f5) {
        RectF rectF = this.R;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        this.R.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        b(canvas);
        super.draw(canvas);
        canvas.drawRect(this.R, this.Q);
        a(canvas);
    }

    boolean w() {
        return !this.R.isEmpty();
    }

    void x() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    c(@Nullable l lVar) {
        super(lVar == null ? new l() : lVar);
        this.Q = new Paint(1);
        y();
        this.R = new RectF();
    }

    void a(@NonNull RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private void a(@NonNull Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.S);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
