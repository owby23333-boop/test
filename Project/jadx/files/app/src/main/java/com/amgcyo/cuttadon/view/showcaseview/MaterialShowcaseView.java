package com.amgcyo.cuttadon.view.showcaseview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip;
import com.amgcyo.cuttadon.view.showcaseview.c;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShowcaseView extends FrameLayout implements View.OnTouchListener, View.OnClickListener {
    private boolean A;
    private int B;
    private int C;
    private View D;
    private TextView E;
    private TextView F;
    private TextView G;
    private boolean H;
    private TextView I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private int P;
    private com.amgcyo.cuttadon.view.showcaseview.c Q;
    private boolean R;
    private boolean S;
    private long T;
    private Handler U;
    private long V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private g f5435a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    List<com.amgcyo.cuttadon.view.showcaseview.e> f5436b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private e f5437c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.showcaseview.d f5438d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f5439e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f5440f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ShowcaseTooltip f5441g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f5442h0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    long f5443s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    long f5444t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f5445u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.showcaseview.j.a f5446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.showcaseview.i.e f5447w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5448x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5449y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5450z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zIsAttachedToWindow = Build.VERSION.SDK_INT >= 19 ? MaterialShowcaseView.this.isAttachedToWindow() : MaterialShowcaseView.this.getWindowToken() != null;
            if (MaterialShowcaseView.this.R && zIsAttachedToWindow) {
                MaterialShowcaseView.this.b();
            } else {
                MaterialShowcaseView.this.setVisibility(0);
                MaterialShowcaseView.this.l();
            }
        }
    }

    class b implements c.b {
        b() {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.c.b
        public void c() {
            MaterialShowcaseView.this.setVisibility(0);
            MaterialShowcaseView.this.l();
        }
    }

    class c implements c.a {
        c() {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.c.a
        public void a() {
            MaterialShowcaseView.this.setVisibility(4);
            MaterialShowcaseView.this.d();
        }
    }

    public static class d {
        private boolean a = false;
        private int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MaterialShowcaseView f5452c;

        public d(Activity activity) {
            this.f5452c = new MaterialShowcaseView(activity);
        }

        public d a(View view) {
            this.f5452c.setTarget(new com.amgcyo.cuttadon.view.showcaseview.j.b(view));
            return this;
        }

        public d b(int i2) {
            this.f5452c.setShapePadding(i2);
            return this;
        }

        public d c(int i2) {
            this.f5452c.setTooltipMargin(i2);
            return this;
        }

        public d a(ShowcaseTooltip showcaseTooltip) {
            this.f5452c.setToolTip(showcaseTooltip);
            return this;
        }

        public d b(boolean z2) {
            this.b = 1;
            this.a = z2;
            return this;
        }

        public d c() {
            b(false);
            return this;
        }

        public d a(boolean z2) {
            this.f5452c.setDismissOnTouch(z2);
            return this;
        }

        public d a(int i2) {
            this.f5452c.setMaskColour(i2);
            return this;
        }

        public d b() {
            this.f5452c.setRenderOverNavigationBar(true);
            return this;
        }

        public d a(com.amgcyo.cuttadon.view.showcaseview.e eVar) {
            this.f5452c.a(eVar);
            return this;
        }

        public d a(com.amgcyo.cuttadon.view.showcaseview.i.e eVar) {
            this.f5452c.setShape(eVar);
            return this;
        }

        public MaterialShowcaseView a() {
            if (this.f5452c.f5447w == null) {
                int i2 = this.b;
                if (i2 == 1) {
                    MaterialShowcaseView materialShowcaseView = this.f5452c;
                    materialShowcaseView.setShape(new com.amgcyo.cuttadon.view.showcaseview.i.d(materialShowcaseView.f5446v.a(), this.a));
                } else if (i2 == 2) {
                    this.f5452c.setShape(new com.amgcyo.cuttadon.view.showcaseview.i.b());
                } else if (i2 != 3) {
                    MaterialShowcaseView materialShowcaseView2 = this.f5452c;
                    materialShowcaseView2.setShape(new com.amgcyo.cuttadon.view.showcaseview.i.a(materialShowcaseView2.f5446v));
                } else {
                    MaterialShowcaseView materialShowcaseView3 = this.f5452c;
                    materialShowcaseView3.setShape(new com.amgcyo.cuttadon.view.showcaseview.i.c(materialShowcaseView3.f5446v));
                }
            }
            if (this.f5452c.Q == null) {
                if (Build.VERSION.SDK_INT >= 21 && !this.f5452c.S) {
                    this.f5452c.setAnimationFactory(new com.amgcyo.cuttadon.view.showcaseview.a());
                } else {
                    this.f5452c.setAnimationFactory(new com.amgcyo.cuttadon.view.showcaseview.b());
                }
            }
            this.f5452c.f5447w.a(this.f5452c.B);
            return this.f5452c;
        }
    }

    private class e implements ViewTreeObserver.OnGlobalLayoutListener {
        private e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MaterialShowcaseView materialShowcaseView = MaterialShowcaseView.this;
            materialShowcaseView.setTarget(materialShowcaseView.f5446v);
        }

        /* synthetic */ e(MaterialShowcaseView materialShowcaseView, a aVar) {
            this();
        }
    }

    public MaterialShowcaseView(Context context) {
        super(context);
        this.f5443s = 0L;
        this.f5444t = 300L;
        this.f5450z = false;
        this.A = false;
        this.B = 10;
        this.C = 10;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = true;
        this.S = false;
        this.T = this.f5444t;
        this.V = this.f5443s;
        this.W = false;
        this.f5439e0 = false;
        this.f5440f0 = true;
        j();
    }

    private void i() {
        View view = this.D;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
        boolean z2 = false;
        int i2 = layoutParams.bottomMargin;
        int i3 = this.K;
        if (i2 != i3) {
            layoutParams.bottomMargin = i3;
            z2 = true;
        }
        int i4 = layoutParams.topMargin;
        int i5 = this.L;
        if (i4 != i5) {
            layoutParams.topMargin = i5;
            z2 = true;
        }
        int i6 = layoutParams.gravity;
        int i7 = this.J;
        if (i6 != i7) {
            layoutParams.gravity = i7;
            z2 = true;
        }
        if (z2) {
            this.D.setLayoutParams(layoutParams);
        }
        h();
    }

    private void j() {
        setWillNotDraw(false);
        this.f5436b0 = new ArrayList();
        this.f5437c0 = new e(this, null);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f5437c0);
        setOnTouchListener(this);
        this.P = Color.parseColor("#dd335075");
        setVisibility(4);
        this.f5445u = new Paint();
        this.f5445u.setColor(-1);
        this.f5445u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f5445u.setFlags(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.showcase_content, (ViewGroup) this, true);
        this.D = viewInflate.findViewById(R.id.content_box);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_content);
        this.G = (TextView) viewInflate.findViewById(R.id.tv_dismiss);
        this.G.setOnClickListener(this);
        setLayerType(1, null);
        this.I = (TextView) viewInflate.findViewById(R.id.tv_skip);
        this.I.setOnClickListener(this);
    }

    private void k() {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f5436b0)) {
            for (com.amgcyo.cuttadon.view.showcaseview.e eVar : this.f5436b0) {
                if (eVar != null) {
                    eVar.b(this);
                }
            }
            this.f5436b0.clear();
            this.f5436b0 = null;
        }
        com.amgcyo.cuttadon.view.showcaseview.d dVar = this.f5438d0;
        if (dVar != null) {
            dVar.a(this, this.f5450z, this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f5436b0)) {
            return;
        }
        for (com.amgcyo.cuttadon.view.showcaseview.e eVar : this.f5436b0) {
            if (eVar != null) {
                eVar.a(this);
            }
        }
    }

    private void setContentText(CharSequence charSequence) {
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private void setContentTextColor(int i2) {
        TextView textView = this.F;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    private void setDelay(long j2) {
        this.V = j2;
    }

    private void setDismissOnTargetTouch(boolean z2) {
        this.f5440f0 = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDismissOnTouch(boolean z2) {
        this.M = z2;
    }

    private void setDismissStyle(Typeface typeface) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setTypeface(typeface);
            f();
        }
    }

    private void setDismissText(CharSequence charSequence) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(charSequence);
            f();
        }
    }

    private void setDismissTextColor(int i2) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    private void setFadeDuration(long j2) {
        this.T = j2;
    }

    private void setIsSequence(Boolean bool) {
        bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskColour(int i2) {
        this.P = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderOverNavigationBar(boolean z2) {
        this.O = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShapePadding(int i2) {
        this.B = i2;
    }

    private void setShouldRender(boolean z2) {
        this.N = z2;
    }

    private void setSkipStyle(Typeface typeface) {
        TextView textView = this.I;
        if (textView != null) {
            textView.setTypeface(typeface);
            g();
        }
    }

    private void setSkipText(CharSequence charSequence) {
        TextView textView = this.I;
        if (textView != null) {
            textView.setText(charSequence);
            g();
        }
    }

    private void setTargetTouchable(boolean z2) {
        this.f5439e0 = z2;
    }

    private void setTitleText(CharSequence charSequence) {
        if (this.E == null || charSequence.equals("")) {
            return;
        }
        this.F.setAlpha(0.5f);
        this.E.setText(charSequence);
    }

    private void setTitleTextColor(int i2) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolTip(ShowcaseTooltip showcaseTooltip) {
        this.f5441g0 = showcaseTooltip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTooltipMargin(int i2) {
        this.C = i2;
    }

    private void setUseFadeAnimation(boolean z2) {
        this.S = z2;
    }

    public int getSoftButtonsBarSizePort() {
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    void h() {
        if (this.f5441g0 != null) {
            if (!this.f5442h0) {
                this.f5442h0 = true;
                this.f5441g0.b((((this.f5447w.a() * 2) - this.f5446v.a().height()) / 2) + this.C);
            }
            if (this.J == 80) {
                this.f5441g0.a(ShowcaseTooltip.Position.TOP);
            } else {
                this.f5441g0.a(ShowcaseTooltip.Position.BOTTOM);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_dismiss) {
            c();
        } else if (view.getId() == R.id.tv_skip) {
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        g gVar;
        super.onDetachedFromWindow();
        if (!this.f5450z && this.W && (gVar = this.f5435a0) != null) {
            gVar.d();
        }
        k();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.N) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth <= 0 || measuredHeight <= 0) {
                return;
            }
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawColor(this.P);
            this.f5447w.a(canvas, this.f5445u, this.f5448x, this.f5449y);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.M) {
            c();
        }
        if (!this.f5439e0 || !this.f5446v.a().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        if (!this.f5440f0) {
            return false;
        }
        c();
        return false;
    }

    public void setAnimationFactory(com.amgcyo.cuttadon.view.showcaseview.c cVar) {
        this.Q = cVar;
    }

    public void setConfig(h hVar) {
        if (hVar.b() > -1) {
            setDelay(hVar.b());
        }
        if (hVar.e() > 0) {
            setFadeDuration(hVar.e());
        }
        if (hVar.a() > 0) {
            setContentTextColor(hVar.a());
        }
        if (hVar.c() > 0) {
            setDismissTextColor(hVar.c());
        }
        if (hVar.d() != null) {
            setDismissStyle(hVar.d());
        }
        if (hVar.f() > 0) {
            setMaskColour(hVar.f());
        }
        if (hVar.h() != null) {
            setShape(hVar.h());
        }
        if (hVar.i() > -1) {
            setShapePadding(hVar.i());
        }
        if (hVar.g() != null) {
            setRenderOverNavigationBar(hVar.g().booleanValue());
        }
    }

    void setDetachedListener(com.amgcyo.cuttadon.view.showcaseview.d dVar) {
        this.f5438d0 = dVar;
    }

    public void setGravity(int i2) {
        this.H = i2 != 0;
        if (this.H) {
            this.J = i2;
            this.K = 0;
            this.L = 0;
        }
        i();
    }

    void setPosition(Point point) {
        a(point.x, point.y);
    }

    public void setShape(com.amgcyo.cuttadon.view.showcaseview.i.e eVar) {
        this.f5447w = eVar;
    }

    public void setTarget(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        this.f5446v = aVar;
        f();
        if (this.f5446v != null) {
            if (!this.O && Build.VERSION.SDK_INT >= 21) {
                int softButtonsBarSizePort = getSoftButtonsBarSizePort();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != softButtonsBarSizePort) {
                    layoutParams.bottomMargin = softButtonsBarSizePort;
                }
            }
            Point pointB = this.f5446v.b();
            Rect rectA = this.f5446v.a();
            setPosition(pointB);
            int measuredHeight = getMeasuredHeight();
            int i2 = measuredHeight / 2;
            int i3 = pointB.y;
            int iMax = Math.max(rectA.height(), rectA.width()) / 2;
            com.amgcyo.cuttadon.view.showcaseview.i.e eVar = this.f5447w;
            if (eVar != null) {
                eVar.a(this.f5446v);
                iMax = this.f5447w.getHeight() / 2;
            }
            if (!this.H) {
                if (i3 > i2) {
                    this.L = 0;
                    this.K = (measuredHeight - i3) + iMax + this.B;
                    this.J = 80;
                } else {
                    this.L = i3 + iMax + this.B;
                    this.K = 0;
                    this.J = 48;
                }
            }
        }
        i();
    }

    public void d() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.f5445u = null;
        this.Q = null;
        this.U = null;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.f5437c0);
        this.f5437c0 = null;
        g gVar = this.f5435a0;
        if (gVar != null) {
            gVar.a();
        }
        this.f5435a0 = null;
    }

    public void e() {
        this.A = true;
        if (this.R) {
            a();
        } else {
            d();
        }
    }

    void f() {
        TextView textView = this.G;
        if (textView != null) {
            if (TextUtils.isEmpty(textView.getText())) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
            }
        }
    }

    void g() {
        TextView textView = this.I;
        if (textView != null) {
            if (TextUtils.isEmpty(textView.getText())) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
        }
    }

    public void c() {
        this.f5450z = true;
        if (this.R) {
            a();
        } else {
            d();
        }
    }

    public void b() {
        setVisibility(4);
        this.Q.a(this, this.f5446v.b(), this.T, new b());
    }

    void a(int i2, int i3) {
        this.f5448x = i2;
        this.f5449y = i3;
    }

    public void a(com.amgcyo.cuttadon.view.showcaseview.e eVar) {
        List<com.amgcyo.cuttadon.view.showcaseview.e> list = this.f5436b0;
        if (list != null) {
            list.add(eVar);
        }
    }

    public boolean a(Activity activity) {
        if (this.W) {
            if (this.f5435a0.c()) {
                return false;
            }
            this.f5435a0.e();
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this);
        setShouldRender(true);
        ShowcaseTooltip showcaseTooltip = this.f5441g0;
        if (showcaseTooltip != null) {
            com.amgcyo.cuttadon.view.showcaseview.j.a aVar = this.f5446v;
            if (aVar instanceof com.amgcyo.cuttadon.view.showcaseview.j.b) {
                showcaseTooltip.a(this, ((com.amgcyo.cuttadon.view.showcaseview.j.b) aVar).c());
            } else {
                throw new RuntimeException("The target must be of type: " + com.amgcyo.cuttadon.view.showcaseview.j.b.class.getCanonicalName());
            }
        }
        this.U = new Handler();
        this.U.postDelayed(new a(), this.V);
        f();
        return true;
    }

    public MaterialShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5443s = 0L;
        this.f5444t = 300L;
        this.f5450z = false;
        this.A = false;
        this.B = 10;
        this.C = 10;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = true;
        this.S = false;
        this.T = this.f5444t;
        this.V = this.f5443s;
        this.W = false;
        this.f5439e0 = false;
        this.f5440f0 = true;
        j();
    }

    public void a() {
        this.Q.a(this, this.f5446v.b(), this.T, new c());
    }

    public MaterialShowcaseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5443s = 0L;
        this.f5444t = 300L;
        this.f5450z = false;
        this.A = false;
        this.B = 10;
        this.C = 10;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = true;
        this.S = false;
        this.T = this.f5444t;
        this.V = this.f5443s;
        this.W = false;
        this.f5439e0 = false;
        this.f5440f0 = true;
        j();
    }
}
