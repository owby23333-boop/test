package com.amgcyo.cuttadon.view.showcaseview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ShowcaseTooltip {
    private View a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f5454c;

    public enum ALIGN {
        START,
        CENTER,
        END
    }

    public enum Position {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5464s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f5465t;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$a$a, reason: collision with other inner class name */
        class ViewTreeObserverOnPreDrawListenerC0117a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ Rect f5467s;

            ViewTreeObserverOnPreDrawListenerC0117a(Rect rect) {
                this.f5467s = rect;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ShowcaseTooltip.this.f5454c.b(this.f5467s, a.this.f5464s.getWidth());
                ShowcaseTooltip.this.f5454c.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        }

        a(ViewGroup viewGroup, int i2) {
            this.f5464s = viewGroup;
            this.f5465t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            ShowcaseTooltip.this.b.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            Point point = new Point();
            this.f5464s.getGlobalVisibleRect(rect2, point);
            int[] iArr = new int[2];
            ShowcaseTooltip.this.b.getLocationOnScreen(iArr);
            rect.left = iArr[0];
            int i2 = rect.top;
            int i3 = point.y;
            rect.top = i2 - i3;
            rect.bottom -= i3;
            int i4 = rect.left;
            int i5 = point.x;
            rect.left = i4 - i5;
            rect.right -= i5;
            int i6 = rect.top;
            int i7 = this.f5465t;
            rect.top = i6 - i7;
            rect.bottom += i7;
            this.f5464s.addView(ShowcaseTooltip.this.f5454c, -2, -2);
            ShowcaseTooltip.this.f5454c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0117a(rect));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[ALIGN.values().length];

        static {
            try {
                b[ALIGN.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ALIGN.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[Position.values().length];
            try {
                a[Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Position.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Position.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Position.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class c implements f {
        private long a = 400;

        @Override // com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.f
        public void a(View view, Animator.AnimatorListener animatorListener) {
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(this.a).setListener(animatorListener);
        }
    }

    public interface d {
        void a(View view);
    }

    public static class e {
        private Fragment a;
        private Activity b;

        public e(Activity activity) {
            this.b = activity;
        }

        public Activity getActivity() {
            Activity activity = this.b;
            return activity != null ? activity : this.a.getActivity();
        }

        public Context getContext() {
            Activity activity = this.b;
            return activity != null ? activity : this.a.getActivity();
        }
    }

    public interface f {
        void a(View view, Animator.AnimatorListener animatorListener);
    }

    public static class g extends FrameLayout {
        private Paint A;
        private Position B;
        private ALIGN C;
        private d D;
        private f E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private Rect K;
        private int L;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5469s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5470t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f5471u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f5472v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        protected View f5473w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f5474x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private Path f5475y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private Paint f5476z;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (g.this.D != null) {
                    g.this.D.a(g.this);
                }
            }
        }

        class b implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ Rect f5478s;

            b(Rect rect) {
                this.f5478s = rect;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                g.this.a(this.f5478s);
                g.this.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        }

        public g(Context context) {
            super(context);
            this.f5469s = 15;
            this.f5470t = 15;
            this.f5471u = 0;
            this.f5472v = 0;
            this.f5474x = Color.parseColor("#FFFFFF");
            this.B = Position.BOTTOM;
            this.C = ALIGN.CENTER;
            this.E = new c();
            this.F = 30;
            this.G = 20;
            this.H = 30;
            this.I = 60;
            this.J = 60;
            this.L = 0;
            setWillNotDraw(false);
            this.f5473w = new TextView(context);
            ((TextView) this.f5473w).setTextColor(-16777216);
            addView(this.f5473w, -2, -2);
            this.f5473w.setPadding(0, 0, 0, 0);
            this.f5476z = new Paint(1);
            this.f5476z.setColor(this.f5474x);
            this.f5476z.setStyle(Paint.Style.FILL);
            this.A = null;
            setLayerType(1, this.f5476z);
        }

        public void b(Rect rect, int i2) {
            this.K = new Rect(rect);
            Rect rect2 = new Rect(rect);
            if (a(rect2, i2)) {
                getViewTreeObserver().addOnPreDrawListener(new b(rect2));
            } else {
                a(rect2);
            }
        }

        public int getArrowHeight() {
            return this.f5469s;
        }

        public int getArrowSourceMargin() {
            return this.f5471u;
        }

        public int getArrowTargetMargin() {
            return this.f5472v;
        }

        public int getArrowWidth() {
            return this.f5470t;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Path path = this.f5475y;
            if (path != null) {
                canvas.drawPath(path, this.f5476z);
                Paint paint = this.A;
                if (paint != null) {
                    canvas.drawPath(this.f5475y, paint);
                }
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            RectF rectF = new RectF(0.0f, 0.0f, i2, i3);
            int i6 = this.F;
            this.f5475y = a(rectF, i6, i6, i6, i6);
        }

        public void setAlign(ALIGN align) {
            this.C = align;
            postInvalidate();
        }

        public void setArrowHeight(int i2) {
            this.f5469s = i2;
            postInvalidate();
        }

        public void setArrowSourceMargin(int i2) {
            this.f5471u = i2;
            postInvalidate();
        }

        public void setArrowTargetMargin(int i2) {
            this.f5472v = i2;
            postInvalidate();
        }

        public void setArrowWidth(int i2) {
            this.f5470t = i2;
            postInvalidate();
        }

        public void setBorderPaint(Paint paint) {
            this.A = paint;
            postInvalidate();
        }

        public void setColor(int i2) {
            this.f5474x = i2;
            this.f5476z.setColor(i2);
            postInvalidate();
        }

        public void setCorner(int i2) {
            this.F = i2;
        }

        public void setCustomView(View view) {
            removeView(this.f5473w);
            this.f5473w = view;
            addView(this.f5473w, -2, -2);
        }

        public void setDistanceWithView(int i2) {
            this.L = i2;
        }

        public void setListenerDisplay(d dVar) {
            this.D = dVar;
        }

        public void setPaint(Paint paint) {
            this.f5476z = paint;
            setLayerType(1, paint);
            postInvalidate();
        }

        public void setPosition(Position position) {
            this.B = position;
            int i2 = b.a[position.ordinal()];
            if (i2 == 1) {
                setPadding(this.J, this.G, this.I, this.H + this.f5469s);
            } else if (i2 == 2) {
                setPadding(this.J, this.G + this.f5469s, this.I, this.H);
            } else if (i2 == 3) {
                setPadding(this.J, this.G, this.I + this.f5469s, this.H);
            } else if (i2 == 4) {
                setPadding(this.J + this.f5469s, this.G, this.I, this.H);
            }
            postInvalidate();
        }

        public void setText(String str) {
            View view = this.f5473w;
            if (view instanceof TextView) {
                ((TextView) view).setText(Html.fromHtml(str));
            }
            postInvalidate();
        }

        public void setTextColor(int i2) {
            View view = this.f5473w;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(i2);
            }
            postInvalidate();
        }

        public void setTextGravity(int i2) {
            View view = this.f5473w;
            if (view instanceof TextView) {
                ((TextView) view).setGravity(i2);
            }
            postInvalidate();
        }

        public void setTextTypeFace(Typeface typeface) {
            View view = this.f5473w;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface);
            }
            postInvalidate();
        }

        public void setTooltipAnimation(f fVar) {
            this.E = fVar;
        }

        public void setupPosition(Rect rect) {
            int width;
            int iA;
            Position position = this.B;
            if (position == Position.LEFT || position == Position.RIGHT) {
                width = this.B == Position.LEFT ? (rect.left - getWidth()) - this.L : rect.right + this.L;
                iA = rect.top + a(getHeight(), rect.height());
            } else {
                iA = position == Position.BOTTOM ? rect.bottom + this.L : (rect.top - getHeight()) - this.L;
                width = rect.left + a(getWidth(), rect.width());
            }
            setTranslationX(width);
            setTranslationY(iA);
        }

        protected void a() {
            this.E.a(this, new a());
        }

        private int a(int i2, int i3) {
            int i4 = b.b[this.C.ordinal()];
            if (i4 == 1) {
                return i3 - i2;
            }
            if (i4 != 2) {
                return 0;
            }
            return (i3 - i2) / 2;
        }

        public void setText(int i2) {
            View view = this.f5473w;
            if (view instanceof TextView) {
                ((TextView) view).setText(i2);
            }
            postInvalidate();
        }

        private Path a(RectF rectF, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            Path path = new Path();
            if (this.K == null) {
                return path;
            }
            float f8 = f2 < 0.0f ? 0.0f : f2;
            float f9 = f3 < 0.0f ? 0.0f : f3;
            float f10 = f5 < 0.0f ? 0.0f : f5;
            float f11 = f4 < 0.0f ? 0.0f : f4;
            float f12 = this.B == Position.BOTTOM ? this.f5469s : 0.0f;
            float f13 = this.B == Position.TOP ? this.f5469s : 0.0f;
            float f14 = rectF.left + 30.0f;
            float f15 = f12 + rectF.top;
            float f16 = rectF.right - 30.0f;
            float f17 = rectF.bottom - f13;
            float fCenterX = this.K.centerX() - getX();
            float f18 = Arrays.asList(Position.TOP, Position.BOTTOM).contains(this.B) ? this.f5471u + fCenterX : fCenterX;
            if (Arrays.asList(Position.TOP, Position.BOTTOM).contains(this.B)) {
                fCenterX += this.f5472v;
            }
            float f19 = Arrays.asList(Position.RIGHT, Position.LEFT).contains(this.B) ? (f17 / 2.0f) - this.f5471u : f17 / 2.0f;
            if (Arrays.asList(Position.RIGHT, Position.LEFT).contains(this.B)) {
                f7 = (f17 / 2.0f) - this.f5472v;
                f6 = 2.0f;
            } else {
                f6 = 2.0f;
                f7 = f17 / 2.0f;
            }
            float f20 = f8 / f6;
            float f21 = f14 + f20;
            path.moveTo(f21, f15);
            if (this.B == Position.BOTTOM) {
                path.lineTo(f18 - this.f5470t, f15);
                path.lineTo(fCenterX, rectF.top);
                path.lineTo(this.f5470t + f18, f15);
            }
            float f22 = f9 / 2.0f;
            path.lineTo(f16 - f22, f15);
            path.quadTo(f16, f15, f16, f22 + f15);
            if (this.B == Position.LEFT) {
                path.lineTo(f16, f19 - this.f5470t);
                path.lineTo(rectF.right, f7);
                path.lineTo(f16, this.f5470t + f19);
            }
            float f23 = f11 / 2.0f;
            path.lineTo(f16, f17 - f23);
            path.quadTo(f16, f17, f16 - f23, f17);
            if (this.B == Position.TOP) {
                path.lineTo(this.f5470t + f18, f17);
                path.lineTo(fCenterX, rectF.bottom);
                path.lineTo(f18 - this.f5470t, f17);
            }
            float f24 = f10 / 2.0f;
            path.lineTo(f14 + f24, f17);
            path.quadTo(f14, f17, f14, f17 - f24);
            if (this.B == Position.RIGHT) {
                path.lineTo(f14, this.f5470t + f19);
                path.lineTo(rectF.left, f7);
                path.lineTo(f14, f19 - this.f5470t);
            }
            path.lineTo(f14, f15 + f20);
            path.quadTo(f14, f15, f21, f15);
            path.close();
            return path;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(android.graphics.Rect r10, int r11) {
            /*
                r9 = this;
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                r9.getGlobalVisibleRect(r0)
                android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r1 = r9.B
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r2 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.Position.LEFT
                r3 = 0
                r4 = 1
                if (r1 != r2) goto L25
                int r1 = r9.getWidth()
                int r2 = r10.left
                if (r1 <= r2) goto L25
                int r2 = r2 + (-30)
                int r10 = r9.L
                int r2 = r2 - r10
                r0.width = r2
                goto Lb3
            L25:
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r1 = r9.B
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r2 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.Position.RIGHT
                if (r1 != r2) goto L40
                int r1 = r10.right
                int r2 = r9.getWidth()
                int r1 = r1 + r2
                if (r1 <= r11) goto L40
                int r10 = r10.right
                int r11 = r11 - r10
                int r11 = r11 + (-30)
                int r10 = r9.L
                int r11 = r11 - r10
                r0.width = r11
                goto Lb3
            L40:
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r1 = r9.B
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r2 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.Position.TOP
                if (r1 == r2) goto L4d
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$Position r2 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.Position.BOTTOM
                if (r1 != r2) goto L4b
                goto L4d
            L4b:
                r4 = 0
                goto Lb3
            L4d:
                int r1 = r10.left
                int r2 = r10.right
                int r5 = r10.centerX()
                float r5 = (float) r5
                int r6 = r9.getWidth()
                float r6 = (float) r6
                r7 = 1073741824(0x40000000, float:2.0)
                float r6 = r6 / r7
                float r5 = r5 + r6
                float r6 = (float) r11
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 <= 0) goto L7d
                int r5 = r10.centerX()
                float r5 = (float) r5
                int r8 = r9.getWidth()
                float r8 = (float) r8
                float r8 = r8 / r7
                float r5 = r5 + r8
                float r5 = r5 - r6
                float r1 = (float) r1
                float r1 = r1 - r5
                int r1 = (int) r1
                float r2 = (float) r2
                float r2 = r2 - r5
                int r2 = (int) r2
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$ALIGN r5 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.ALIGN.CENTER
                r9.setAlign(r5)
                goto La8
            L7d:
                int r5 = r10.centerX()
                float r5 = (float) r5
                int r6 = r9.getWidth()
                float r6 = (float) r6
                float r6 = r6 / r7
                float r5 = r5 - r6
                r6 = 0
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 >= 0) goto La7
                int r5 = r10.centerX()
                float r5 = (float) r5
                int r6 = r9.getWidth()
                float r6 = (float) r6
                float r6 = r6 / r7
                float r5 = r5 - r6
                float r5 = -r5
                float r1 = (float) r1
                float r1 = r1 + r5
                int r1 = (int) r1
                float r2 = (float) r2
                float r2 = r2 + r5
                int r2 = (int) r2
                com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip$ALIGN r5 = com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.ALIGN.CENTER
                r9.setAlign(r5)
                goto La8
            La7:
                r4 = 0
            La8:
                if (r1 >= 0) goto Lab
                r1 = 0
            Lab:
                if (r2 <= r11) goto Lae
                goto Laf
            Lae:
                r11 = r2
            Laf:
                r10.left = r1
                r10.right = r11
            Lb3:
                r9.setLayoutParams(r0)
                r9.postInvalidate()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip.g.a(android.graphics.Rect, int):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Rect rect) {
            setupPosition(rect);
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            int i2 = this.F;
            this.f5475y = a(rectF, i2, i2, i2, i2);
            a();
        }
    }

    private ShowcaseTooltip(Context context) {
        this.f5454c = new g(new e(b(context)).getContext());
    }

    public static ShowcaseTooltip a(Context context) {
        return new ShowcaseTooltip(context);
    }

    private static Activity b(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public void a(ViewGroup viewGroup, View view) {
        this.a = viewGroup;
        this.b = view;
    }

    public ShowcaseTooltip a(Position position) {
        this.f5454c.setPosition(position);
        return this;
    }

    public ShowcaseTooltip a(View view) {
        this.f5454c.setCustomView(view);
        return this;
    }

    public g b(int i2) {
        ViewGroup viewGroup;
        Context context = this.f5454c.getContext();
        if (context != null && (context instanceof Activity)) {
            View view = this.a;
            if (view != null) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            }
            this.b.postDelayed(new a(viewGroup, i2), 100L);
        }
        return this.f5454c;
    }

    public ShowcaseTooltip a(int i2) {
        this.f5454c.setCorner(i2);
        return this;
    }
}
