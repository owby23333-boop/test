package com.amgcyo.cuttadon.view.otherview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import com.amgcyo.cuttadon.R$styleable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class CommonShapeButton extends AppCompatButton {
    private int A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private int H;
    private GradientDrawable I;
    private GradientDrawable J;
    private StateListDrawable K;
    private float L;
    private float M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4936s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4937t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4938u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4939v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4940w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4941x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4942y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4943z;

    public CommonShapeButton(Context context) {
        this(context, null);
    }

    private void a() {
        if (Build.VERSION.SDK_INT < 21) {
            for (Class<CommonShapeButton> superclass = CommonShapeButton.class; superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    Field declaredField = superclass.getDeclaredField("mContext");
                    declaredField.setAccessible(true);
                    declaredField.set(this, getActivity());
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void b() {
        if (this.E == Color.parseColor("#FFFFFF") || this.F == Color.parseColor("#FFFFFF")) {
            this.I.setColor(this.f4941x);
        } else {
            this.I.setColors(new int[]{this.E, this.F});
            int i2 = this.G;
            if (i2 == 0) {
                this.I.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            } else if (i2 == 1) {
                this.I.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        int i3 = this.f4940w;
        if (i3 == 0) {
            this.I.setShape(0);
        } else if (i3 == 1) {
            this.I.setShape(1);
        } else if (i3 == 2) {
            this.I.setShape(2);
        } else if (i3 == 3) {
            this.I.setShape(3);
        }
        if (this.C == -1) {
            this.I.setCornerRadius(TypedValue.applyDimension(0, this.B, getResources().getDisplayMetrics()));
        } else {
            this.I.setCornerRadii(getCornerRadiusByPosition());
        }
        if (this.f4943z != Color.parseColor("#00000000")) {
            this.I.setStroke(this.A, this.f4943z);
        }
    }

    private void c() {
        this.J.setColor(this.f4942y);
        int i2 = this.f4940w;
        if (i2 == 0) {
            this.J.setShape(0);
        } else if (i2 == 1) {
            this.J.setShape(1);
        } else if (i2 == 2) {
            this.J.setShape(2);
        } else if (i2 == 3) {
            this.J.setShape(3);
        }
        this.J.setCornerRadius(TypedValue.applyDimension(0, this.B, getResources().getDisplayMetrics()));
        this.J.setStroke(this.A, this.f4943z);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private float[] getCornerRadiusByPosition() {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.B;
        if (a(this.C, this.f4936s).booleanValue()) {
            fArr[0] = f2;
            fArr[1] = f2;
        }
        if (a(this.C, this.f4937t).booleanValue()) {
            fArr[2] = f2;
            fArr[3] = f2;
        }
        if (a(this.C, this.f4938u).booleanValue()) {
            fArr[4] = f2;
            fArr[5] = f2;
        }
        if (a(this.C, this.f4939v).booleanValue()) {
            fArr[6] = f2;
            fArr[7] = f2;
        }
        return fArr;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.H > -1) {
            Drawable drawable = getCompoundDrawables()[this.H];
            int compoundDrawablePadding = getCompoundDrawablePadding();
            int i6 = this.H;
            if (i6 != 0) {
                if (i6 == 1) {
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                    this.M = (((float) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra()) + intrinsicHeight + compoundDrawablePadding;
                    setPadding(0, 0, 0, (int) (getHeight() - this.M));
                } else if (i6 != 2) {
                    if (i6 == 3) {
                    }
                }
                int intrinsicHeight2 = drawable.getIntrinsicHeight();
                Paint.FontMetrics fontMetrics2 = getPaint().getFontMetrics();
                this.M = (((float) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent)) * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra()) + intrinsicHeight2 + compoundDrawablePadding;
                setPadding(0, 0, 0, (int) (getHeight() - this.M));
            } else {
                this.L = ((int) getPaint().measureText(getText().toString())) + drawable.getIntrinsicWidth() + compoundDrawablePadding;
                setPadding(0, 0, (int) (getWidth() - this.L), 0);
            }
            this.L = ((int) getPaint().measureText(getText().toString())) + drawable.getIntrinsicWidth() + compoundDrawablePadding;
            setPadding(0, 0, (int) (getWidth() - this.L), 0);
            int intrinsicHeight3 = drawable.getIntrinsicHeight();
            Paint.FontMetrics fontMetrics3 = getPaint().getFontMetrics();
            this.M = (((float) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent)) * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra()) + intrinsicHeight3 + compoundDrawablePadding;
            setPadding(0, 0, 0, (int) (getHeight() - this.M));
            int intrinsicHeight22 = drawable.getIntrinsicHeight();
            Paint.FontMetrics fontMetrics22 = getPaint().getFontMetrics();
            this.M = (((float) Math.ceil(fontMetrics22.descent - fontMetrics22.ascent)) * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra()) + intrinsicHeight22 + compoundDrawablePadding;
            setPadding(0, 0, 0, (int) (getHeight() - this.M));
        }
        setGravity(17);
        setClickable(true);
        a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        b();
        if (!this.D) {
            setBackground(this.I);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setBackground(new RippleDrawable(ColorStateList.valueOf(this.f4942y), this.I, null));
            return;
        }
        c();
        this.K.addState(new int[]{R.attr.state_pressed}, this.J);
        this.K.addState(new int[0], this.I);
        setBackground(this.K);
    }

    public void setmFillColor(int i2) {
        this.f4941x = i2;
        this.I.setColor(i2);
    }

    public void setmStrokeColor(int i2) {
        this.f4943z = i2;
        this.I.setStroke(this.A, i2);
    }

    public CommonShapeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonShapeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4936s = 1;
        this.f4937t = 2;
        this.f4938u = 4;
        this.f4939v = 8;
        this.f4940w = 0;
        this.f4941x = 0;
        this.f4942y = 0;
        this.f4943z = 0;
        this.A = 0;
        this.B = 0;
        this.C = -1;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = -1;
        this.I = new GradientDrawable();
        this.J = new GradientDrawable();
        this.K = new StateListDrawable();
        this.L = 0.0f;
        this.M = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CommonShapeButton, i2, 0);
        this.f4940w = typedArrayObtainStyledAttributes.getInt(8, 0);
        this.f4941x = typedArrayObtainStyledAttributes.getColor(5, Color.parseColor("#FFFFFF"));
        this.f4942y = typedArrayObtainStyledAttributes.getColor(7, Color.parseColor("#666666"));
        this.f4943z = typedArrayObtainStyledAttributes.getColor(10, Color.parseColor("#00000000"));
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0);
        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.C = typedArrayObtainStyledAttributes.getInt(1, -1);
        this.D = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.H = typedArrayObtainStyledAttributes.getInt(3, -1);
        this.E = typedArrayObtainStyledAttributes.getColor(9, Color.parseColor("#FFFFFF"));
        this.F = typedArrayObtainStyledAttributes.getColor(4, Color.parseColor("#FFFFFF"));
        this.G = typedArrayObtainStyledAttributes.getColor(6, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private Boolean a(int i2, int i3) {
        if (i2 != -1) {
            return true;
        }
        return Boolean.valueOf(i3 == i2);
    }
}
