package com.lxj.xpopup.photoview;

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

/* JADX INFO: loaded from: classes3.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k f17494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView.ScaleType f17495t;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f17494s = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f17495t;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f17495t = null;
        }
    }

    public k getAttacher() {
        return this.f17494s;
    }

    public RectF getDisplayRect() {
        return this.f17494s.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f17494s.b();
    }

    public float getMaximumScale() {
        return this.f17494s.c();
    }

    public float getMediumScale() {
        return this.f17494s.d();
    }

    public float getMinimumScale() {
        return this.f17494s.e();
    }

    public float getScale() {
        return this.f17494s.f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f17494s.g();
    }

    public void setAllowParentInterceptOnEdge(boolean z2) {
        this.f17494s.a(z2);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f17494s.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f17494s;
        if (kVar != null) {
            kVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        k kVar = this.f17494s;
        if (kVar != null) {
            kVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f17494s;
        if (kVar != null) {
            kVar.update();
        }
    }

    public void setMaximumScale(float f2) {
        this.f17494s.a(f2);
    }

    public void setMediumScale(float f2) {
        this.f17494s.b(f2);
    }

    public void setMinimumScale(float f2) {
        this.f17494s.c(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f17494s.a(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f17494s.a(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f17494s.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f17494s.a(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f17494s.a(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f17494s.a(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f17494s.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f17494s.a(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f17494s.a(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f17494s.a(jVar);
    }

    public void setRotationBy(float f2) {
        this.f17494s.d(f2);
    }

    public void setRotationTo(float f2) {
        this.f17494s.e(f2);
    }

    public void setScale(float f2) {
        this.f17494s.f(f2);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f17494s;
        if (kVar == null) {
            this.f17495t = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f17494s.a(i2);
    }

    public void setZoomable(boolean z2) {
        this.f17494s.b(z2);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
