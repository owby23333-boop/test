package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.R$styleable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SegmentControlView extends View {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private c F;
    private float G;
    private Paint H;
    private Paint I;
    private Paint J;
    private RectF K;
    private RectF L;
    private Path M;
    private float N;
    private int O;
    private int P;
    private ViewPager Q;
    private int R;
    private float S;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String[] f5060s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5061t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5062u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5063v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5064w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5065x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5066y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5067z;

    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (SegmentControlView.this.E) {
                SegmentControlView.this.B = i2;
                SegmentControlView.this.R = i2;
                SegmentControlView.this.S = f2;
                SegmentControlView.this.invalidate();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (SegmentControlView.this.E) {
                return;
            }
            SegmentControlView.this.setSelectedIndex(i2);
        }
    }

    public interface c {
        void a(int i2);
    }

    public SegmentControlView(Context context) {
        super(context);
        this.f5060s = null;
        this.f5061t = -13850209;
        this.f5062u = -1;
        this.f5063v = -1;
        this.f5064w = -13850209;
        this.f5065x = -13850209;
        this.f5066y = 2;
        this.f5067z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 16;
        this.D = 12;
        this.E = false;
        this.G = 0.0f;
        this.O = -1;
        this.P = -1;
        this.R = -1;
        this.S = 0.0f;
        a();
    }

    private int a(float f2, int i2, int i3) {
        int i4 = (i2 & (-16777216)) >>> 24;
        int i5 = (i2 & 16711680) >>> 16;
        int i6 = (i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        return ((int) (((i2 & 255) >>> 0) + ((((i3 & 255) >>> 0) - r9) * f2))) | (((int) (i4 + (((((-16777216) & i3) >>> 24) - i4) * f2))) << 24) | (((int) (i5 + ((((16711680 & i3) >>> 16) - i5) * f2))) << 16) | (((int) (i6 + ((((65280 & i3) >>> 8) - i6) * f2))) << 8);
    }

    private int a(int i2, float f2) {
        return ((int) (((i2 & 255) >>> 0) * f2)) | ((((-16777216) & i2) >>> 24) << 24) | (((int) (((16711680 & i2) >>> 16) * f2)) << 16) | (((int) (((65280 & i2) >>> 8) * f2)) << 8);
    }

    public int getCount() {
        String[] strArr = this.f5060s;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    public boolean getGradient() {
        return this.E;
    }

    public int getSelectedIndex() {
        return this.B;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (b(this.f5060s)) {
            return;
        }
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(b(i2, this.H), a(i3, this.H));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.K.left = getPaddingLeft();
        this.K.top = getPaddingTop();
        this.K.right = i2 - getPaddingRight();
        this.K.bottom = i3 - getPaddingBottom();
        float fCeil = (float) Math.ceil(this.f5066y / 2);
        this.K.inset(fCeil, fCeil);
        String[] strArr = this.f5060s;
        if (strArr != null && strArr.length > 0) {
            this.G = this.K.width() / this.f5060s.length;
        }
        RectF rectF = this.L;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        int i6 = this.f5067z;
        rectF.right = i6 * 2;
        rectF.bottom = i6 * 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.O = this.P;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.P = a(motionEvent.getX(), motionEvent.getY());
            if (this.O != this.P) {
                invalidate();
            }
        } else if (action == 1) {
            this.P = a(motionEvent.getX(), motionEvent.getY());
            int i2 = this.P;
            if (i2 != -1) {
                c cVar = this.F;
                if (cVar != null && this.B != i2) {
                    cVar.a(i2);
                }
                this.B = this.P;
            }
            this.P = -1;
            if (!this.E || !a(this.Q)) {
                invalidate();
            }
        } else if (action == 2) {
            this.P = a(motionEvent.getX(), motionEvent.getY());
            if (this.O != this.P) {
                invalidate();
            }
        } else if (action == 3) {
            this.P = -1;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFrameColor(int i2) {
        this.f5065x = i2;
        invalidate();
    }

    public void setFrameWidth(int i2) {
        this.f5066y = i2;
        requestLayout();
        invalidate();
    }

    public void setGradient(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
        }
    }

    public void setOnSegmentChangedListener(c cVar) {
        this.F = cVar;
    }

    public void setSelectedIndex(int i2) {
        if (this.B != i2) {
            this.B = i2;
            c cVar = this.F;
            if (cVar != null) {
                cVar.a(this.B);
            }
            if (this.E && a(this.Q)) {
                return;
            }
            invalidate();
        }
    }

    public void setTextSize(int i2) {
        if (this.A != i2) {
            this.A = i2;
            this.H.setTextSize(i2);
            this.N = a(this.H.getFontMetrics());
            requestLayout();
            invalidate();
        }
    }

    public void setTexts(String[] strArr) {
        a(strArr);
        if (strArr == null || strArr.length < 2) {
            throw new IllegalArgumentException("SegmentControlView's content text array'length should larger than 1");
        }
        if (a(this.f5060s, strArr)) {
            return;
        }
        this.f5060s = strArr;
        this.G = this.K.width() / strArr.length;
        requestLayout();
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.Q = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
        }
    }

    public void update() {
        invalidate();
    }

    private int b(int i2, Paint paint) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int iB = (b(this.f5060s, paint) + (this.C * 2) + (this.f5066y * 2)) * this.f5060s.length;
        int i3 = this.f5067z;
        if (iB < i3 * 2) {
            iB = i3 * 2;
        }
        int paddingLeft = iB + getPaddingLeft() + getPaddingRight();
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SegmentControlView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == 1) {
                this.f5061t = typedArrayObtainStyledAttributes.getColor(index, -13850209);
            } else if (index == 0) {
                this.f5062u = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 11) {
                this.f5063v = typedArrayObtainStyledAttributes.getColor(index, -1);
            } else if (index == 10) {
                this.f5064w = typedArrayObtainStyledAttributes.getColor(index, -13850209);
            } else if (index == 2) {
                this.f5065x = typedArrayObtainStyledAttributes.getColor(index, -13850209);
            } else if (index == 12) {
                this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, a(getContext(), 16.0f));
            } else if (index == 9) {
                this.f5060s = a(typedArrayObtainStyledAttributes.getTextArray(index));
            } else if (index == 4) {
                this.f5066y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 2);
            } else if (index == 3) {
                this.f5067z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 8) {
                this.B = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == 6) {
                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 16);
            } else if (index == 7) {
                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 12);
            } else if (index == 5) {
                this.E = typedArrayObtainStyledAttributes.getBoolean(index, false);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private int b(String[] strArr, Paint paint) {
        if (strArr == null) {
            return 0;
        }
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                iMax = Math.max(b(str, paint), iMax);
            }
        }
        return iMax;
    }

    private boolean b(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    private int b(String str, Paint paint) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) (paint.measureText(str) + 0.5f);
    }

    public SegmentControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5060s = null;
        this.f5061t = -13850209;
        this.f5062u = -1;
        this.f5063v = -1;
        this.f5064w = -13850209;
        this.f5065x = -13850209;
        this.f5066y = 2;
        this.f5067z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 16;
        this.D = 12;
        this.E = false;
        this.G = 0.0f;
        this.O = -1;
        this.P = -1;
        this.R = -1;
        this.S = 0.0f;
        a(context, attributeSet);
        a();
    }

    private void a() {
        this.K = new RectF();
        this.L = new RectF();
        this.M = new Path();
        if (this.A == 0) {
            this.A = a(getContext(), 16.0f);
        }
        this.H = new Paint();
        this.H.setAntiAlias(true);
        this.H.setTextAlign(Paint.Align.CENTER);
        this.H.setTextSize(this.A);
        this.I = new Paint();
        this.I.setAntiAlias(true);
        this.I.setStyle(Paint.Style.FILL);
        this.J = new Paint();
        this.J.setAntiAlias(true);
        this.J.setStyle(Paint.Style.STROKE);
        this.J.setStrokeWidth(this.f5066y);
        this.J.setColor(this.f5065x);
        this.N = a(this.H.getFontMetrics());
        setClickable(true);
    }

    private float a(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private String[] a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i2 = 0; i2 < charSequenceArr.length; i2++) {
            strArr[i2] = charSequenceArr[i2].toString();
        }
        return strArr;
    }

    public SegmentControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5060s = null;
        this.f5061t = -13850209;
        this.f5062u = -1;
        this.f5063v = -1;
        this.f5064w = -13850209;
        this.f5065x = -13850209;
        this.f5066y = 2;
        this.f5067z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 16;
        this.D = 12;
        this.E = false;
        this.G = 0.0f;
        this.O = -1;
        this.P = -1;
        this.R = -1;
        this.S = 0.0f;
        a(context, attributeSet);
        a();
    }

    private void a(String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            throw new IllegalArgumentException("SegmentControlView's content text array'length should larger than 1");
        }
    }

    private boolean a(ViewPager viewPager) {
        if (viewPager == null) {
            return false;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mOnPageChangeListener");
            if (declaredField == null) {
                return false;
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager);
            if (obj != null) {
                if (obj instanceof b) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private int a(float f2, float f3) {
        if (!this.K.contains(f2, f3)) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f5060s.length; i2++) {
            float f4 = this.K.left;
            float f5 = this.G;
            if ((i2 * f5) + f4 <= f2 && f2 < f4 + ((i2 + 1) * f5)) {
                return i2;
            }
        }
        return -1;
    }

    private boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null && strArr2 == null) {
            return true;
        }
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!(strArr[i2] == null && strArr2[i2] == null) && (strArr[i2] == null || !strArr[i2].equals(strArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    private int a(int i2, Paint paint) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int iA = a(this.f5060s, paint) + (this.D * 2) + (this.f5066y * 2);
        int i3 = this.f5067z;
        if (iA < i3 * 2) {
            iA = i3 * 2;
        }
        int paddingTop = iA + getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int a(String[] strArr, Paint paint) {
        if (strArr == null) {
            return 0;
        }
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                iMax = Math.max(a(str, paint), iMax);
            }
        }
        return iMax;
    }

    private void a(Canvas canvas) {
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < this.f5060s.length; i2++) {
            float f2 = i2;
            float f3 = this.K.left + (this.G * f2);
            this.M.reset();
            if (i2 == 0) {
                Path path = this.M;
                RectF rectF = this.K;
                path.moveTo(rectF.left, rectF.top + this.f5067z);
                RectF rectF2 = this.L;
                RectF rectF3 = this.K;
                rectF2.offsetTo(rectF3.left, rectF3.top);
                this.M.arcTo(this.L, 180.0f, 90.0f);
                Path path2 = this.M;
                RectF rectF4 = this.K;
                path2.lineTo(rectF4.left + this.G, rectF4.top);
                Path path3 = this.M;
                RectF rectF5 = this.K;
                path3.lineTo(rectF5.left + this.G, rectF5.bottom);
                Path path4 = this.M;
                RectF rectF6 = this.K;
                path4.lineTo(rectF6.left + this.f5067z, rectF6.bottom);
                RectF rectF7 = this.L;
                RectF rectF8 = this.K;
                rectF7.offsetTo(rectF8.left, rectF8.bottom - (this.f5067z * 2));
                this.M.arcTo(this.L, 90.0f, 90.0f);
            } else if (i2 == this.f5060s.length - 1) {
                Path path5 = this.M;
                RectF rectF9 = this.K;
                path5.moveTo(rectF9.left + (this.G * f2), rectF9.top);
                Path path6 = this.M;
                RectF rectF10 = this.K;
                path6.lineTo(rectF10.right - this.f5067z, rectF10.top);
                RectF rectF11 = this.L;
                RectF rectF12 = this.K;
                rectF11.offsetTo(rectF12.right - (this.f5067z * 2), rectF12.top);
                this.M.arcTo(this.L, 270.0f, 90.0f);
                Path path7 = this.M;
                RectF rectF13 = this.K;
                path7.lineTo(rectF13.right, rectF13.bottom - this.f5067z);
                RectF rectF14 = this.L;
                RectF rectF15 = this.K;
                float f4 = rectF15.right;
                int i3 = this.f5067z;
                rectF14.offsetTo(f4 - (i3 * 2), rectF15.bottom - (i3 * 2));
                this.M.arcTo(this.L, 0.0f, 90.0f);
                Path path8 = this.M;
                RectF rectF16 = this.K;
                path8.lineTo(rectF16.left + (f2 * this.G), rectF16.bottom);
            } else {
                this.M.moveTo(f3, this.K.top);
                this.M.lineTo(this.G + f3, this.K.top);
                this.M.lineTo(this.G + f3, this.K.bottom);
                this.M.lineTo(f3, this.K.bottom);
            }
            this.M.close();
            if (!this.E) {
                if (i2 == this.B) {
                    iA = this.f5061t;
                    iA2 = this.f5063v;
                } else {
                    iA = this.f5062u;
                    iA2 = this.f5064w;
                }
            }
            if (this.E) {
                float f5 = this.S;
                if (f5 != 0.0f) {
                    int i4 = this.R;
                    if (i2 == i4) {
                        iA = a(f5, this.f5061t, this.f5062u);
                        iA2 = a(this.S, this.f5063v, this.f5064w);
                    } else if (i2 == i4 + 1) {
                        iA = a(f5, this.f5062u, this.f5061t);
                        iA2 = a(this.S, this.f5064w, this.f5063v);
                    } else {
                        iA = this.f5062u;
                        iA2 = this.f5064w;
                    }
                } else if (i2 == this.B) {
                    iA = this.f5061t;
                    iA2 = this.f5063v;
                } else {
                    iA = this.f5062u;
                    iA2 = this.f5064w;
                }
            }
            this.I.setColor(iA);
            if (this.P == i2) {
                this.I.setColor(a(iA, 0.95f));
            }
            canvas.drawPath(this.M, this.I);
            canvas.drawPath(this.M, this.J);
            this.H.setColor(iA2);
            canvas.drawText(this.f5060s[i2], f3 + (this.G / 2.0f), this.K.centerY() + this.N, this.H);
        }
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private int a(String str, Paint paint) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }
}
