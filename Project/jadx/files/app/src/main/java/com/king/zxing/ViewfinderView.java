package com.king.zxing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewfinderView extends View {
    private TextLocation A;
    private String B;
    private int C;
    private float D;
    public int E;
    public int F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private LaserStyle L;
    private int M;
    private int N;
    private Rect O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private float V;
    private List<com.google.zxing.i> W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private List<com.google.zxing.i> f16435a0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f16436s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextPaint f16437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f16438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f16439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f16440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f16442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f16443z;

    public enum LaserStyle {
        NONE(0),
        LINE(1),
        GRID(2);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f16448s;

        LaserStyle(int i2) {
            this.f16448s = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LaserStyle c(int i2) {
            for (LaserStyle laserStyle : values()) {
                if (laserStyle.f16448s == i2) {
                    return laserStyle;
                }
            }
            return LINE;
        }
    }

    public enum TextLocation {
        TOP(0),
        BOTTOM(1);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f16452s;

        TextLocation(int i2) {
            this.f16452s = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TextLocation c(int i2) {
            for (TextLocation textLocation : values()) {
                if (textLocation.f16452s == i2) {
                    return textLocation;
                }
            }
            return TOP;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[LaserStyle.values().length];

        static {
            try {
                a[LaserStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LaserStyle.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewfinderView);
        this.f16438u = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_maskColor, ContextCompat.getColor(context, R$color.viewfinder_mask));
        this.f16439v = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_frameColor, ContextCompat.getColor(context, R$color.viewfinder_frame));
        this.f16441x = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_cornerColor, ContextCompat.getColor(context, R$color.viewfinder_corner));
        this.f16440w = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_laserColor, ContextCompat.getColor(context, R$color.viewfinder_laser));
        this.f16442y = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_resultPointColor, ContextCompat.getColor(context, R$color.viewfinder_result_point_color));
        this.B = typedArrayObtainStyledAttributes.getString(R$styleable.ViewfinderView_labelText);
        this.C = typedArrayObtainStyledAttributes.getColor(R$styleable.ViewfinderView_labelTextColor, ContextCompat.getColor(context, R$color.viewfinder_text_color));
        this.D = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f16443z = typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.A = TextLocation.c(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_labelTextLocation, 0));
        this.G = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ViewfinderView_showResultPoint, false);
        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ViewfinderView_frameWidth, 0);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ViewfinderView_frameHeight, 0);
        this.L = LaserStyle.c(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_laserStyle, LaserStyle.LINE.f16448s));
        this.M = typedArrayObtainStyledAttributes.getInt(R$styleable.ViewfinderView_gridColumn, 20);
        this.N = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.P = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_cornerRectWidth, TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.Q = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_cornerRectHeight, TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
        this.R = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_scannerLineMoveDistance, TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.S = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_scannerLineHeight, TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()));
        this.T = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.ViewfinderView_frameLineWidth, TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.U = typedArrayObtainStyledAttributes.getInteger(R$styleable.ViewfinderView_scannerAnimationDelay, 15);
        this.V = typedArrayObtainStyledAttributes.getFloat(R$styleable.ViewfinderView_frameRatio, 0.625f);
        typedArrayObtainStyledAttributes.recycle();
        this.f16436s = new Paint(1);
        this.f16437t = new TextPaint(1);
        this.W = new ArrayList(5);
        this.f16435a0 = null;
        this.H = getDisplayMetrics().widthPixels;
        this.I = getDisplayMetrics().heightPixels;
        int iMin = (int) (Math.min(this.H, this.I) * this.V);
        int i2 = this.J;
        if (i2 <= 0 || i2 > this.H) {
            this.J = iMin;
        }
        int i3 = this.K;
        if (i3 <= 0 || i3 > this.I) {
            this.K = iMin;
        }
    }

    private void b(Canvas canvas, Rect rect) {
        this.f16436s.setColor(this.f16439v);
        canvas.drawRect(rect.left, rect.top, rect.right, r0 + this.T, this.f16436s);
        canvas.drawRect(rect.left, rect.top, r0 + this.T, rect.bottom, this.f16436s);
        canvas.drawRect(r0 - this.T, rect.top, rect.right, rect.bottom, this.f16436s);
        canvas.drawRect(rect.left, r0 - this.T, rect.right, rect.bottom, this.f16436s);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.graphics.Canvas r14, android.graphics.Rect r15) {
        /*
            r13 = this;
            android.graphics.Paint r0 = r13.f16436s
            r1 = 2
            float r2 = (float) r1
            r0.setStrokeWidth(r2)
            int r0 = r13.N
            if (r0 <= 0) goto L15
            int r2 = r13.E
            int r3 = r15.top
            int r3 = r2 - r3
            if (r3 <= r0) goto L15
            int r2 = r2 - r0
            goto L17
        L15:
            int r2 = r15.top
        L17:
            android.graphics.LinearGradient r0 = new android.graphics.LinearGradient
            int r3 = r15.left
            int r4 = r15.width()
            int r4 = r4 / r1
            int r3 = r3 + r4
            float r4 = (float) r3
            float r2 = (float) r2
            int r3 = r15.left
            int r5 = r15.width()
            int r5 = r5 / r1
            int r3 = r3 + r5
            float r6 = (float) r3
            int r3 = r13.E
            float r7 = (float) r3
            int[] r8 = new int[r1]
            int r3 = r13.f16440w
            int r3 = r13.a(r3)
            r11 = 0
            r8[r11] = r3
            int r3 = r13.f16440w
            r12 = 1
            r8[r12] = r3
            float[] r9 = new float[r1]
            r9 = {x00bc: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.graphics.Shader$TileMode r10 = android.graphics.Shader.TileMode.CLAMP
            r3 = r0
            r5 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            android.graphics.Paint r1 = r13.f16436s
            r1.setShader(r0)
            int r0 = r15.width()
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            int r1 = r13.M
            float r1 = (float) r1
            float r0 = r0 / r1
        L5d:
            int r1 = r13.M
            if (r12 >= r1) goto L79
            int r1 = r15.left
            float r3 = (float) r1
            float r4 = (float) r12
            float r4 = r4 * r0
            float r6 = r3 + r4
            float r1 = (float) r1
            float r8 = r1 + r4
            int r1 = r13.E
            float r9 = (float) r1
            android.graphics.Paint r10 = r13.f16436s
            r5 = r14
            r7 = r2
            r5.drawLine(r6, r7, r8, r9, r10)
            int r12 = r12 + 1
            goto L5d
        L79:
            int r1 = r13.N
            if (r1 <= 0) goto L85
            int r2 = r13.E
            int r3 = r15.top
            int r2 = r2 - r3
            if (r2 <= r1) goto L85
            goto L8a
        L85:
            int r1 = r13.E
            int r2 = r15.top
            int r1 = r1 - r2
        L8a:
            float r2 = (float) r11
            float r3 = (float) r1
            float r3 = r3 / r0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 > 0) goto Laa
            int r3 = r15.left
            float r5 = (float) r3
            int r3 = r13.E
            float r4 = (float) r3
            float r2 = r2 * r0
            float r6 = r4 - r2
            int r4 = r15.right
            float r7 = (float) r4
            float r3 = (float) r3
            float r8 = r3 - r2
            android.graphics.Paint r9 = r13.f16436s
            r4 = r14
            r4.drawLine(r5, r6, r7, r8, r9)
            int r11 = r11 + 1
            goto L8a
        Laa:
            int r14 = r13.E
            int r0 = r13.F
            if (r14 >= r0) goto Lb6
            int r15 = r13.R
            int r14 = r14 + r15
            r13.E = r14
            goto Lba
        Lb6:
            int r14 = r15.top
            r13.E = r14
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.zxing.ViewfinderView.c(android.graphics.Canvas, android.graphics.Rect):void");
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.L != null) {
            this.f16436s.setColor(this.f16440w);
            int i2 = a.a[this.L.ordinal()];
            if (i2 == 1) {
                e(canvas, rect);
            } else if (i2 == 2) {
                c(canvas, rect);
            }
            this.f16436s.setShader(null);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        int i2 = rect.left;
        this.f16436s.setShader(new LinearGradient(i2, this.E, i2, r2 + this.S, a(this.f16440w), this.f16440w, Shader.TileMode.MIRROR));
        int i3 = this.E;
        if (i3 > this.F) {
            this.E = rect.top;
            return;
        }
        int i4 = rect.left;
        int i5 = this.S;
        canvas.drawOval(new RectF(i4 + (i5 * 2), i3, rect.right - (i5 * 2), i3 + i5), this.f16436s);
        this.E += this.R;
    }

    private void f(Canvas canvas, Rect rect) {
        if (this.G) {
            List<com.google.zxing.i> list = this.W;
            List<com.google.zxing.i> list2 = this.f16435a0;
            if (list.isEmpty()) {
                this.f16435a0 = null;
            } else {
                this.W = new ArrayList(5);
                this.f16435a0 = list;
                this.f16436s.setAlpha(160);
                this.f16436s.setColor(this.f16442y);
                synchronized (list) {
                    for (com.google.zxing.i iVar : list) {
                        canvas.drawCircle(iVar.a(), iVar.b(), 10.0f, this.f16436s);
                    }
                }
            }
            if (list2 != null) {
                this.f16436s.setAlpha(80);
                this.f16436s.setColor(this.f16442y);
                synchronized (list2) {
                    for (com.google.zxing.i iVar2 : list2) {
                        canvas.drawCircle(iVar2.a(), iVar2.b(), 10.0f, this.f16436s);
                    }
                }
            }
        }
    }

    private void g(Canvas canvas, Rect rect) {
        if (TextUtils.isEmpty(this.B)) {
            return;
        }
        this.f16437t.setColor(this.C);
        this.f16437t.setTextSize(this.D);
        this.f16437t.setTextAlign(Paint.Align.CENTER);
        StaticLayout staticLayout = new StaticLayout(this.B, this.f16437t, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        if (this.A == TextLocation.BOTTOM) {
            canvas.translate(rect.left + (rect.width() / 2), rect.bottom + this.f16443z);
            staticLayout.draw(canvas);
        } else {
            canvas.translate(rect.left + (rect.width() / 2), (rect.top - this.f16443z) - staticLayout.getHeight());
            staticLayout.draw(canvas);
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.O == null) {
            return;
        }
        if (this.E == 0 || this.F == 0) {
            Rect rect = this.O;
            this.E = rect.top;
            this.F = rect.bottom - this.S;
        }
        a(canvas, this.O, canvas.getWidth(), canvas.getHeight());
        d(canvas, this.O);
        b(canvas, this.O);
        a(canvas, this.O);
        g(canvas, this.O);
        f(canvas, this.O);
        long j2 = this.U;
        Rect rect2 = this.O;
        postInvalidateDelayed(j2, rect2.left - 20, rect2.top - 20, rect2.right + 20, rect2.bottom + 20);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = (((this.H - this.J) / 2) + getPaddingLeft()) - getPaddingRight();
        int paddingTop = (((this.I - this.K) / 2) + getPaddingTop()) - getPaddingBottom();
        this.O = new Rect(paddingLeft, paddingTop, this.J + paddingLeft, this.K + paddingTop);
    }

    public void setLabelText(String str) {
        this.B = str;
    }

    public void setLabelTextColor(@ColorInt int i2) {
        this.C = i2;
    }

    public void setLabelTextColorResource(@ColorRes int i2) {
        this.C = ContextCompat.getColor(getContext(), i2);
    }

    public void setLabelTextSize(float f2) {
        this.D = f2;
    }

    public void setLaserStyle(LaserStyle laserStyle) {
        this.L = laserStyle;
    }

    public void setShowResultPoint(boolean z2) {
        this.G = z2;
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.E = 0;
        this.F = 0;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect) {
        this.f16436s.setColor(this.f16441x);
        canvas.drawRect(rect.left, rect.top, r0 + this.P, r1 + this.Q, this.f16436s);
        canvas.drawRect(rect.left, rect.top, r0 + this.Q, r1 + this.P, this.f16436s);
        int i2 = rect.right;
        canvas.drawRect(i2 - this.P, rect.top, i2, r1 + this.Q, this.f16436s);
        int i3 = rect.right;
        canvas.drawRect(i3 - this.Q, rect.top, i3, r1 + this.P, this.f16436s);
        canvas.drawRect(rect.left, r1 - this.P, r0 + this.Q, rect.bottom, this.f16436s);
        canvas.drawRect(rect.left, r1 - this.Q, r0 + this.P, rect.bottom, this.f16436s);
        int i4 = rect.right;
        canvas.drawRect(i4 - this.P, r1 - this.Q, i4, rect.bottom, this.f16436s);
        int i5 = rect.right;
        canvas.drawRect(i5 - this.Q, r10 - this.P, i5, rect.bottom, this.f16436s);
    }

    public int a(int i2) {
        return Integer.valueOf("01" + Integer.toHexString(i2).substring(2), 16).intValue();
    }

    private void a(Canvas canvas, Rect rect, int i2, int i3) {
        this.f16436s.setColor(this.f16438u);
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f2, rect.top, this.f16436s);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f16436s);
        canvas.drawRect(rect.right, rect.top, f2, rect.bottom, this.f16436s);
        canvas.drawRect(0.0f, rect.bottom, f2, i3, this.f16436s);
    }

    public void a() {
        invalidate();
    }

    public void a(com.google.zxing.i iVar) {
        if (this.G) {
            List<com.google.zxing.i> list = this.W;
            synchronized (list) {
                list.add(iVar);
                int size = list.size();
                if (size > 20) {
                    list.subList(0, size - 10).clear();
                }
            }
        }
    }
}
