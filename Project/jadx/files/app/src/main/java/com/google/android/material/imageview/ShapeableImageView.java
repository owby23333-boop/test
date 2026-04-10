package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements o {
    private static final int K = R$style.Widget_MaterialComponents_ShapeableImageView;
    private l A;

    @Dimension
    private float B;
    private Path C;

    @Dimension
    private int D;

    @Dimension
    private int E;

    @Dimension
    private int F;

    @Dimension
    private int G;

    @Dimension
    private int H;

    @Dimension
    private int I;
    private boolean J;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final m f15437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final RectF f15438t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final RectF f15439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Paint f15440v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Paint f15441w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Path f15442x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private ColorStateList f15443y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f15444z;

    @TargetApi(21)
    class a extends ViewOutlineProvider {
        private final Rect a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.A == null) {
                return;
            }
            if (ShapeableImageView.this.f15444z == null) {
                ShapeableImageView shapeableImageView = ShapeableImageView.this;
                shapeableImageView.f15444z = new MaterialShapeDrawable(shapeableImageView.A);
            }
            ShapeableImageView.this.f15438t.round(this.a);
            ShapeableImageView.this.f15444z.setBounds(this.a);
            ShapeableImageView.this.f15444z.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.G;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i2 = this.I;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.D : this.F;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.I) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.H) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.D;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.H) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.I) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.F;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i2 = this.H;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.F : this.D;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.E;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public l getShapeAppearanceModel() {
        return this.A;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f15443y;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.B;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.C, this.f15441w);
        a(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.J) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 19 || isLayoutDirectionResolved()) {
            this.J = true;
            if (Build.VERSION.SDK_INT < 21 || !(isPaddingRelative() || a())) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPadding(i2 + getContentPaddingLeft(), i3 + getContentPaddingTop(), i4 + getContentPaddingRight(), i5 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPaddingRelative(i2 + getContentPaddingStart(), i3 + getContentPaddingTop(), i4 + getContentPaddingEnd(), i5 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.A = lVar;
        MaterialShapeDrawable materialShapeDrawable = this.f15444z;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(lVar);
        }
        a(getWidth(), getHeight());
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f15443y = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1;
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, K), attributeSet, i2);
        this.f15437s = m.a();
        this.f15442x = new Path();
        this.J = false;
        Context context2 = getContext();
        this.f15441w = new Paint();
        this.f15441w.setAntiAlias(true);
        this.f15441w.setColor(-1);
        this.f15441w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f15438t = new RectF();
        this.f15439u = new RectF();
        this.C = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ShapeableImageView, i2, K);
        this.f15443y = c.a(context2, typedArrayObtainStyledAttributes, R$styleable.ShapeableImageView_strokeColor);
        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPadding, 0);
        this.D = dimensionPixelSize;
        this.E = dimensionPixelSize;
        this.F = dimensionPixelSize;
        this.G = dimensionPixelSize;
        this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        this.f15440v = new Paint();
        this.f15440v.setStyle(Paint.Style.STROKE);
        this.f15440v.setAntiAlias(true);
        this.A = l.a(context2, attributeSet, i2, K).a();
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new a());
        }
    }

    private boolean a() {
        return (this.H == Integer.MIN_VALUE && this.I == Integer.MIN_VALUE) ? false : true;
    }

    private void a(int i2, int i3) {
        this.f15438t.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        this.f15437s.a(this.A, 1.0f, this.f15438t, this.f15442x);
        this.C.rewind();
        this.C.addPath(this.f15442x);
        this.f15439u.set(0.0f, 0.0f, i2, i3);
        this.C.addRect(this.f15439u, Path.Direction.CCW);
    }

    private void a(Canvas canvas) {
        if (this.f15443y == null) {
            return;
        }
        this.f15440v.setStrokeWidth(this.B);
        int colorForState = this.f15443y.getColorForState(getDrawableState(), this.f15443y.getDefaultColor());
        if (this.B <= 0.0f || colorForState == 0) {
            return;
        }
        this.f15440v.setColor(colorForState);
        canvas.drawPath(this.f15442x, this.f15440v);
    }
}
