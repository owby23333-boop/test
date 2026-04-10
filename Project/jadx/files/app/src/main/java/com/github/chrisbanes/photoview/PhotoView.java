package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private l f14852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView.ScaleType f14853t;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f14852s = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f14853t;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f14853t = null;
        }
    }

    public l getAttacher() {
        return this.f14852s;
    }

    public RectF getDisplayRect() {
        return this.f14852s.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f14852s.b();
    }

    public float getMaximumScale() {
        return this.f14852s.c();
    }

    public float getMediumScale() {
        return this.f14852s.d();
    }

    public float getMinimumScale() {
        return this.f14852s.e();
    }

    public float getScale() {
        return this.f14852s.f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f14852s.g();
    }

    public void setAllowParentInterceptOnEdge(boolean z2) {
        this.f14852s.a(z2);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f14852s.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f14852s;
        if (lVar != null) {
            lVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l lVar = this.f14852s;
        if (lVar != null) {
            lVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f14852s;
        if (lVar != null) {
            lVar.update();
        }
    }

    public void setMaximumScale(float f2) {
        this.f14852s.a(f2);
    }

    public void setMediumScale(float f2) {
        this.f14852s.b(f2);
    }

    public void setMinimumScale(float f2) {
        this.f14852s.c(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f14852s.a(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f14852s.a(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14852s.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f14852s.a(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f14852s.a(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f14852s.a(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f14852s.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f14852s.a(hVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.f14852s.a(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.f14852s.a(kVar);
    }

    public void setRotationBy(float f2) {
        this.f14852s.d(f2);
    }

    public void setRotationTo(float f2) {
        this.f14852s.e(f2);
    }

    public void setScale(float f2) {
        this.f14852s.f(f2);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.f14852s;
        if (lVar == null) {
            this.f14853t = scaleType;
        } else {
            lVar.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f14852s.a(i2);
    }

    public void setZoomable(boolean z2) {
        this.f14852s.c(z2);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
