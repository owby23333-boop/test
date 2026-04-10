package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.d {
    private final int[] A;
    private final float[] B;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private String[] G;
    private float H;
    private final ColorStateList I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ClockHandView f16029v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Rect f16030w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final RectF f16031x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final SparseArray<TextView> f16032y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AccessibilityDelegateCompat f16033z;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.a(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f16029v.c()) - ClockFaceView.this.C);
            return true;
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int iIntValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (iIntValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f16032y.get(iIntValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.G.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        c();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iA = (int) (this.F / a(this.D / displayMetrics.heightPixels, this.E / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
        setMeasuredDimension(iA, iA);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    private void b(@StringRes int i2) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f16032y.size();
        for (int i3 = 0; i3 < Math.max(this.G.length, size); i3++) {
            TextView textView = this.f16032y.get(i3);
            if (i3 >= this.G.length) {
                removeView(textView);
                this.f16032y.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f16032y.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.G[i3]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i3));
                ViewCompat.setAccessibilityDelegate(textView, this.f16033z);
                textView.setTextColor(this.I);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, this.G[i3]));
                }
            }
        }
    }

    private void c() {
        RectF rectFA = this.f16029v.a();
        for (int i2 = 0; i2 < this.f16032y.size(); i2++) {
            TextView textView = this.f16032y.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.f16030w);
                this.f16030w.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f16030w);
                this.f16031x.set(this.f16030w);
                textView.getPaint().setShader(a(rectFA, this.f16031x));
                textView.invalidate();
            }
        }
    }

    public void a(String[] strArr, @StringRes int i2) {
        this.G = strArr;
        b(i2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16030w = new Rect();
        this.f16031x = new RectF();
        this.f16032y = new SparseArray<>();
        this.B = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        this.I = c.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        this.f16029v = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.C = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        ColorStateList colorStateList = this.I;
        int colorForState = colorStateList.getColorForState(new int[]{R.attr.state_selected}, colorStateList.getDefaultColor());
        this.A = new int[]{colorForState, colorForState, this.I.getDefaultColor()};
        this.f16029v.a(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA = c.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA != null ? colorStateListA.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f16033z = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        a(strArr, 0);
        this.D = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.E = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.F = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void a(int i2) {
        if (i2 != a()) {
            super.a(i2);
            this.f16029v.a(a());
        }
    }

    private RadialGradient a(RectF rectF, RectF rectF2) {
        if (RectF.intersects(rectF, rectF2)) {
            return new RadialGradient(rectF.centerX() - this.f16031x.left, rectF.centerY() - this.f16031x.top, rectF.width() * 0.5f, this.A, this.B, Shader.TileMode.CLAMP);
        }
        return null;
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f2, boolean z2) {
        if (Math.abs(this.H - f2) > 0.001f) {
            this.H = f2;
            c();
        }
    }

    private static float a(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }
}
