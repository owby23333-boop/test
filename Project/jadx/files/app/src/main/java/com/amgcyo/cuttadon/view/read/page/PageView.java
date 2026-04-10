package com.amgcyo.cuttadon.view.read.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.api.entity.reader.ReadConfig;
import com.amgcyo.cuttadon.view.otherview.LabelTextView;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;
import com.amgcyo.cuttadon.view.read.page.j;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PageView extends FrameLayout {
    private boolean A;
    private PageAnimation B;
    private boolean C;
    private FrameLayout D;
    private int E;
    private TextView F;
    View G;
    int H;
    View I;
    private Context J;
    private PageAnimation.a K;
    private g L;
    private j M;
    public Bitmap N;
    private Canvas O;
    private Canvas P;
    private Canvas Q;
    private boolean R;
    private View S;
    o T;
    private o U;
    f V;
    Runnable W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    Runnable f5245a0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5246s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5247t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5248u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5249v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f5250w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5251x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5252y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RectF f5253z;

    class a implements PageAnimation.a {
        a() {
        }

        @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation.a
        public boolean a() {
            return PageView.this.f();
        }

        @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation.a
        public void b() {
            PageView.this.i();
        }

        @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation.a
        public boolean hasNext() {
            return PageView.this.e();
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ o f5254s;

        b(o oVar) {
            this.f5254s = oVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (PageView.this.D != null) {
                PageView pageView = PageView.this;
                pageView.E = pageView.D.getMeasuredHeight();
                if (PageView.this.E > 0) {
                    PageView.this.D.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (PageView.this.S == null) {
                        String str = "因为信息控件是空，需要进行控件初始化:" + PageView.this.E + " 屏幕高度 " + PageView.this.f5247t;
                        PageView.this.a(this.f5254s.f5321h);
                    } else if (this.f5254s.f5321h != null) {
                        String str2 = "因为该章节需要解锁，需要进行控件初始化:" + PageView.this.E + " 屏幕高度 " + PageView.this.f5247t;
                        PageView.this.a(this.f5254s.f5321h);
                    } else {
                        String str3 = "不初始化info的控件:" + PageView.this.E;
                        l.a(PageView.this.S);
                        PageView pageView2 = PageView.this;
                        pageView2.addView(pageView2.S);
                    }
                    if (PageView.this.F != null) {
                        PageView.this.F.setVisibility(8);
                    }
                }
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PageView pageView = PageView.this;
            pageView.H = 0;
            if (pageView.L != null) {
                PageView.this.removeAllViews();
                PageView pageView2 = PageView.this;
                pageView2.I = pageView2.L.getErrorView();
                View view = PageView.this.I;
                if (view != null) {
                    view.setVisibility(0);
                    l.a(PageView.this.I);
                    PageView pageView3 = PageView.this;
                    pageView3.addView(pageView3.I);
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PageView pageView = PageView.this;
            pageView.H = 0;
            if (pageView.L != null) {
                PageView.this.removeAllViews();
                PageView pageView2 = PageView.this;
                pageView2.G = pageView2.L.getAddPageView();
                View view = PageView.this.G;
                if (view != null) {
                    view.setVisibility(0);
                    l.a(PageView.this.G);
                    PageView pageView3 = PageView.this;
                    pageView3.addView(pageView3.G);
                }
            }
        }
    }

    static /* synthetic */ class e {
        static final /* synthetic */ int[] a = new int[PageMode.values().length];

        static {
            try {
                a[PageMode.SIMULATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PageMode.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PageMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PageMode.AutoPage.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PageMode.SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static class f extends Handler {
        f(@NonNull Looper looper) {
            super(looper);
        }
    }

    public interface g {
        void cancel();

        void center();

        void exemptNovelAd();

        void exitReader();

        View getAddPageView();

        FrameLayout getContentView(NormalAdParams normalAdParams, boolean z2);

        View getErrorView();

        TextView getLoadingAdText();

        boolean nextPage();

        boolean prePage();

        void unlockChapter(Slippage slippage);
    }

    public PageView(Context context) {
        this(context, null);
        this.J = context;
    }

    @Override // android.view.View
    public void computeScroll() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation != null) {
            pageAnimation.f();
        }
        super.computeScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            if (this.M == null) {
                return;
            }
            int childCount = getChildCount();
            if (this.U != null && "type_ad".equals(this.U.f5319f) && !h()) {
                super.dispatchDraw(canvas);
            }
            if (childCount > 0 && this.P != null && !h()) {
                super.dispatchDraw(this.P);
                postInvalidate();
            }
            if (!this.R || childCount <= 0 || this.Q == null || h()) {
                return;
            }
            super.dispatchDraw(this.Q);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean g() {
        return this.A;
    }

    public Bitmap getBgBitmap() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation == null) {
            return null;
        }
        return pageAnimation.c();
    }

    public Bitmap getNextBitmap() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation == null) {
            return null;
        }
        return pageAnimation.d();
    }

    public PageAnimation getmPageAnim() {
        return this.B;
    }

    public boolean h() {
        PageAnimation pageAnimation = this.B;
        return pageAnimation != null && pageAnimation.e();
    }

    public void i() {
        this.L.cancel();
        this.M.r();
        o oVar = this.U;
        if (oVar == null || !oVar.f5318e) {
            a("pageCancel");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        this.R = true;
        super.onDescendantInvalidated(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.B.a();
            this.B.b();
            this.M = null;
            this.B = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(this.f5251x);
        PageAnimation pageAnimation = this.B;
        if (pageAnimation != null) {
            pageAnimation.a(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5246s = i2;
        this.f5247t = i3;
        this.A = true;
        j jVar = this.M;
        if (jVar != null) {
            jVar.a(i2, i3);
        }
        postInvalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        super.onTouchEvent(motionEvent);
        if (this.B == null || this.M == null) {
            super.onTouchEvent(motionEvent);
        }
        if (!this.f5252y && motionEvent.getAction() != 0) {
            return true;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5248u = x2;
            this.f5249v = y2;
            this.f5250w = false;
            this.C = false;
            this.f5252y = true;
            PageAnimation pageAnimation = this.B;
            if (pageAnimation != null) {
                pageAnimation.a(motionEvent);
            }
        } else if (action == 1) {
            this.C = true;
            if (!this.f5250w) {
                if (this.f5253z == null) {
                    int i2 = this.f5246s;
                    int i3 = this.f5247t;
                    this.f5253z = new RectF(i2 / 4, i3 / 4, (i2 * 3) / 4, (i3 * 3) / 4);
                }
                if (this.f5253z.contains(x2, y2) && (gVar = this.L) != null) {
                    gVar.center();
                    return true;
                }
            }
            PageAnimation pageAnimation2 = this.B;
            if (pageAnimation2 != null) {
                pageAnimation2.a(motionEvent);
            }
        } else if (action == 2) {
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (!this.f5250w) {
                float f2 = scaledTouchSlop;
                this.f5250w = Math.abs(((float) this.f5248u) - motionEvent.getX()) > f2 || Math.abs(((float) this.f5249v) - motionEvent.getY()) > f2;
            }
            if (this.f5250w) {
                try {
                    this.T = this.M.f();
                    if ((this.T == null || !this.T.f5324k) && this.B != null) {
                        this.B.a(motionEvent);
                    }
                } catch (Exception unused) {
                    PageAnimation pageAnimation3 = this.B;
                    if (pageAnimation3 != null) {
                        pageAnimation3.a(motionEvent);
                    }
                }
            }
        }
        return true;
    }

    public void setAddPageView(View view) {
        this.G = view;
    }

    public void setBgColor(int i2) {
        this.f5251x = i2;
    }

    void setPageMode(PageMode pageMode) {
        if (this.f5246s == 0 || this.f5247t == 0 || pageMode == null) {
            return;
        }
        int i2 = e.a[pageMode.ordinal()];
        if (i2 == 1) {
            this.B = new com.amgcyo.cuttadon.view.read.anim.f(this.f5246s, this.f5247t, this, this.K);
            return;
        }
        if (i2 == 2) {
            this.B = new com.amgcyo.cuttadon.view.read.anim.b(this.f5246s, this.f5247t, this, this.K);
            return;
        }
        if (i2 == 3) {
            this.B = new com.amgcyo.cuttadon.view.read.anim.d(this.f5246s, this.f5247t, this, this.K);
        } else if (i2 != 4) {
            this.B = new com.amgcyo.cuttadon.view.read.anim.g(this.f5246s, this.f5247t, this, this.K);
        } else {
            this.B = new com.amgcyo.cuttadon.view.read.anim.a(this.f5246s, this.f5247t, this, this.K);
        }
    }

    public void setTouchListener(g gVar) {
        this.L = gVar;
    }

    public boolean b() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation == null || (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.e)) {
            return false;
        }
        a(PageAnimation.Direction.NEXT);
        return true;
    }

    public boolean c() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation == null || (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.e)) {
            return false;
        }
        a(PageAnimation.Direction.PRE);
        return true;
    }

    public void d() {
        o oVar;
        if (this.A) {
            PageAnimation pageAnimation = this.B;
            if (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.c) {
                ((com.amgcyo.cuttadon.view.read.anim.c) pageAnimation).h();
            } else if (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.a) {
                ((com.amgcyo.cuttadon.view.read.anim.a) pageAnimation).h();
            }
            if (this.N != null && (oVar = this.U) != null && "type_ad".equals(oVar.f5319f)) {
                dispatchDraw(new Canvas(this.N));
            }
            this.M.a(getNextBitmap(), false);
        }
    }

    public boolean e() {
        this.R = true;
        return this.L.nextPage() && this.M.p();
    }

    public boolean f() {
        this.R = true;
        return this.L.prePage() && this.M.w();
    }

    public PageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.J = context;
    }

    public void a(int i2) {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation != null) {
            pageAnimation.a(i2, this.C);
        }
    }

    public PageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5246s = 0;
        this.f5247t = 0;
        this.f5248u = 0;
        this.f5249v = 0;
        this.f5250w = false;
        this.f5251x = -3226980;
        this.f5252y = true;
        this.f5253z = null;
        this.C = true;
        this.K = new a();
        this.R = false;
        this.V = new f(Looper.getMainLooper());
        this.W = new c();
        this.f5245a0 = new d();
        this.J = context;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    private void a(PageAnimation.Direction direction) {
        if (this.L == null) {
            return;
        }
        a();
        if (direction == PageAnimation.Direction.NEXT) {
            float f2 = this.f5246s;
            float f3 = this.f5247t;
            this.B.a(f2, f3);
            this.B.b(f2, f3);
            Boolean boolValueOf = Boolean.valueOf(e());
            this.B.a(direction);
            if (!boolValueOf.booleanValue()) {
                return;
            }
        } else {
            float f4 = 0;
            float f5 = this.f5247t;
            this.B.a(f4, f5);
            this.B.b(f4, f5);
            this.B.a(direction);
            if (!Boolean.valueOf(f()).booleanValue()) {
                return;
            }
        }
        this.B.g();
        postInvalidate();
    }

    public /* synthetic */ void b(View view) {
        g gVar = this.L;
        if (gVar != null) {
            gVar.exitReader();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void a(final Slippage slippage) {
        String chapterName;
        boolean z2;
        if (slippage != null) {
            chapterName = slippage.getChapterName();
            z2 = true;
        } else {
            chapterName = null;
            z2 = false;
        }
        if (this.S == null) {
            this.S = LayoutInflater.from(this.J).inflate(R.layout.left_right_page_view, (ViewGroup) null);
        }
        View view = this.S;
        if (view == null) {
            return;
        }
        removeView(view);
        com.amgcyo.cuttadon.utils.otherutils.k kVarH = k.c(this.J).h();
        this.S.setBackgroundColor(0);
        LabelTextView labelTextView = (LabelTextView) this.S.findViewById(R.id.labeltextview);
        TextView textView = (TextView) this.S.findViewById(R.id.tv_ad_tips);
        List<BaseAd> listZ = com.amgcyo.cuttadon.utils.otherutils.h.Z();
        int iB = com.amgcyo.cuttadon.h.a.i.b(1);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listZ) && iB > 0) {
            labelTextView.setVisibility(0);
            textView.setVisibility(0);
            labelTextView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.read.page.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f5260s.a(view2);
                }
            });
            labelTextView.setTextColor(-1);
            labelTextView.setText(com.amgcyo.cuttadon.utils.otherutils.h.n(iB));
            textView.setTextColor(kVarH.b);
        } else {
            labelTextView.setVisibility(4);
            textView.setVisibility(4);
        }
        TextView textView2 = (TextView) this.S.findViewById(R.id.tv_unlock_btn);
        TextView textView3 = (TextView) this.S.findViewById(R.id.tv_next_read);
        textView3.setTextColor(kVarH.b);
        TextView textView4 = (TextView) this.S.findViewById(R.id.tv_close);
        TextView textView5 = (TextView) this.S.findViewById(R.id.tv_next_chapter_name);
        String str = "isUnlockChapter:" + z2;
        if (z2) {
            textView3.setVisibility(8);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.read.page.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f5262s.a(slippage, view2);
                }
            });
            textView2.setText(com.amgcyo.cuttadon.utils.otherutils.h.V0());
            textView2.setVisibility(0);
            textView4.setVisibility(0);
            textView4.setTextColor(kVarH.b);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.read.page.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f5261s.b(view2);
                }
            });
            if (!TextUtils.isEmpty(chapterName)) {
                textView5.setText("下一章：" + chapterName);
                textView5.setTextColor(kVarH.b);
                textView5.setVisibility(0);
            }
        } else {
            textView3.setVisibility(0);
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        }
        int i2 = this.f5247t;
        double d2 = i2 * 0.8f;
        double d3 = i2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        int i3 = (int) ((d3 - d2) / 2.0d);
        String str2 = "contentPageAdHeight: " + this.E + " height80: " + d2;
        l.a(this.S);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.E >= d2) {
            labelTextView.setVisibility(8);
            textView.setVisibility(8);
            textView5.setVisibility(8);
            labelTextView.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams2.topMargin = i3 / 3;
            layoutParams2.gravity = 49;
            layoutParams2.height = this.E;
            this.D.setLayoutParams(layoutParams2);
            if (textView3.getVisibility() == 0) {
                com.amgcyo.cuttadon.f.o.a(textView3, 0, layoutParams2.topMargin, 0, 0);
            }
            int i4 = this.E + layoutParams2.topMargin;
            layoutParams.height = -2;
            layoutParams.topMargin = i4;
            layoutParams.gravity = 49;
        } else {
            layoutParams.bottomMargin = Math.round(this.f5246s / 11.0f);
            layoutParams.gravity = 81;
        }
        this.S.setLayoutParams(layoutParams);
        addView(this.S);
    }

    public /* synthetic */ void a(View view) {
        g gVar = this.L;
        if (gVar != null) {
            gVar.exemptNovelAd();
        }
    }

    public /* synthetic */ void a(Slippage slippage, View view) {
        g gVar = this.L;
        if (gVar != null) {
            gVar.unlockChapter(slippage);
        }
    }

    public void a(String str) {
        if (getChildCount() > 0) {
            removeAllViews();
            String str2 = "清除添加的所有view:" + str;
        }
        if (this.O != null) {
            this.O = null;
        }
    }

    public void a() {
        PageAnimation pageAnimation = this.B;
        if (pageAnimation != null) {
            pageAnimation.a();
        }
    }

    public boolean a(Bitmap bitmap, o oVar) {
        if (oVar == null) {
            return false;
        }
        a("drawIndexPageAd");
        if (!this.A) {
            return false;
        }
        this.U = oVar;
        this.N = bitmap;
        boolean z2 = oVar.b;
        NormalAdParams normalAdParams = oVar.f5322i;
        boolean z3 = oVar.f5323j;
        this.O = null;
        String str = "overTime:" + z3;
        if (!z2) {
            this.D = this.L.getContentView(normalAdParams, z3);
            FrameLayout frameLayout = this.D;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                l.a(this.D);
                addView(this.D);
                this.E = this.D.getHeight();
                if (z3) {
                    this.E = 0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("contentPageAdView高度：");
                sb.append(this.E);
                sb.append(" 章节解锁：");
                sb.append(oVar.f5321h == null);
                sb.toString();
                if (this.E <= 0) {
                    this.F = this.L.getLoadingAdText();
                    TextView textView = this.F;
                    if (textView != null) {
                        textView.setVisibility(0);
                        l.a(this.F);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        addView(this.F, 0, layoutParams);
                    }
                    this.D.getViewTreeObserver().addOnGlobalLayoutListener(new b(oVar));
                } else if (this.S != null) {
                    if (oVar.f5321h != null) {
                        String str2 = "因为该章节需要解锁，需要进行控件初始化:" + this.E + " 屏幕高度 " + this.f5247t;
                        a(oVar.f5321h);
                    } else {
                        l.a(this.S);
                        addView(this.S);
                    }
                }
            }
        }
        return true;
    }

    public boolean a(Bitmap bitmap, boolean z2) {
        if (!this.A) {
            return false;
        }
        this.N = bitmap;
        this.R = true;
        this.P = new Canvas(this.N);
        this.O = null;
        String str = "needAddAdContent:" + z2;
        if (!z2) {
            this.V.post(this.f5245a0);
        }
        return true;
    }

    public void a(View view, Bitmap bitmap, int i2) {
        if (!this.A || view == null) {
            return;
        }
        this.N = bitmap;
        this.I = view;
        this.Q = new Canvas(this.N);
        this.O = null;
        this.R = true;
        this.V.post(this.W);
    }

    public void a(boolean z2) {
        PageAnimation pageAnimation;
        if (!this.A || this.M == null || (pageAnimation = this.B) == null) {
            return;
        }
        if (!z2 && (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.e)) {
            ((com.amgcyo.cuttadon.view.read.anim.e) pageAnimation).h();
        }
        this.M.a(getNextBitmap(), z2);
    }

    public j a(ReadConfig readConfig, j.b bVar, k kVar, MkConfigSource mkConfigSource) {
        this.M = new h(this, readConfig, bVar, kVar, mkConfigSource);
        if (this.f5246s != 0 || this.f5247t != 0) {
            this.M.a(this.f5246s, this.f5247t);
        }
        return this.M;
    }
}
