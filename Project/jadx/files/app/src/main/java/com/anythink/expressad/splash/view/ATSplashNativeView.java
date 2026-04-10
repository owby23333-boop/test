package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.shake.MBShakeView;
import com.anythink.expressad.widget.FeedBackButton;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashNativeView extends RelativeLayout {
    private static final String a = "MBSplashNativeView";
    private int A;
    private int B;
    private float C;
    private float D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;
    private String K;
    private ATSplashView L;
    private c M;
    private MBShakeView N;
    private String O;
    private String P;
    private String Q;
    private com.anythink.expressad.shake.b R;
    private MBNoRecycledCrashImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MBNoRecycledCrashImageView f11372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f11373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f11374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FeedBackButton f11375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f11376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RelativeLayout f11377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MBNoRecycledCrashImageView f11378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f11379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MBNoRecycledCrashImageView f11380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f11381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f11382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RelativeLayout f11383n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f11384o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f11385p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f11386q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MBSplashClickView f11387r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11388s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f11390u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f11391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11393x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11394y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11395z;

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() < bitmap.getHeight()) {
                        ATSplashNativeView.a(ATSplashNativeView.this);
                        ATSplashNativeView.this.f11377h.setVisibility(4);
                        ATSplashNativeView.this.f11372c.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        ATSplashNativeView.this.f11372c.setImageBitmap(bitmap);
                    } else if (ATSplashNativeView.this.A == 1) {
                        ATSplashNativeView.this.f11377h.setVisibility(0);
                        try {
                            Bitmap bitmapA = n.a(bitmap, t.b(com.anythink.core.common.b.n.a().g(), 10.0f));
                            if (bitmapA != null && !bitmapA.isRecycled()) {
                                ATSplashNativeView.this.f11380k.setScaleType(ImageView.ScaleType.FIT_XY);
                                ATSplashNativeView.this.f11380k.setImageBitmap(bitmapA);
                            }
                        } catch (Throwable th) {
                            try {
                                o.d(ATSplashNativeView.a, th.getMessage());
                                ATSplashNativeView.this.f11380k.setImageBitmap(bitmap);
                            } catch (Throwable th2) {
                                o.d(ATSplashNativeView.a, th2.getMessage());
                            }
                        }
                        ATSplashNativeView.this.f11379j.setText(ATSplashNativeView.this.M.bb());
                        ATSplashNativeView.h(ATSplashNativeView.this);
                        try {
                            try {
                                Bitmap bitmapB = n.b(bitmap);
                                if (bitmapB != null && !bitmapB.isRecycled()) {
                                    ATSplashNativeView.this.f11372c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ATSplashNativeView.this.f11372c.setImageBitmap(bitmapB);
                                }
                            } catch (Throwable unused) {
                                ATSplashNativeView.this.f11372c.setImageBitmap(bitmap);
                            }
                        } catch (Throwable th3) {
                            o.d(ATSplashNativeView.a, th3.getMessage());
                        }
                    } else {
                        ATSplashNativeView.this.f11377h.setVisibility(4);
                        ATSplashNativeView.this.f11372c.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        ATSplashNativeView.this.f11372c.setImageBitmap(bitmap);
                    }
                    try {
                        Bitmap bitmapB2 = n.b(bitmap);
                        if (bitmapB2 == null || bitmapB2.isRecycled()) {
                            return;
                        }
                        ATSplashNativeView.this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        ATSplashNativeView.this.b.setImageBitmap(bitmapB2);
                    } catch (Throwable unused2) {
                        ATSplashNativeView.this.f11372c.setImageBitmap(bitmap);
                    }
                } catch (Throwable th4) {
                    o.d(ATSplashNativeView.a, th4.getMessage());
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$10, reason: invalid class name */
    final class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ATSplashNativeView.this.G) {
                if (ATSplashNativeView.this.L.getSplashJSBridgeImpl() != null && ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener() != null) {
                    ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener().c();
                }
                ATSplashNativeView.this.f11376g.setVisibility(4);
                ATSplashNativeView.this.f11376g.setEnabled(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$11, reason: invalid class name */
    final class AnonymousClass11 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            ATSplashNativeView.this.I = true;
            ATSplashNativeView.b(ATSplashNativeView.this, false);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            ATSplashNativeView.this.I = false;
            ATSplashNativeView.b(ATSplashNativeView.this, true);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            ATSplashNativeView.this.I = false;
            ATSplashNativeView.b(ATSplashNativeView.this, true);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ATSplashNativeView.a(ATSplashNativeView.this, 0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$3, reason: invalid class name */
    final class AnonymousClass3 extends com.anythink.expressad.shake.b {
        AnonymousClass3(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (ATSplashNativeView.this.I || ATSplashNativeView.this.H) {
                return;
            }
            ATSplashNativeView.a(ATSplashNativeView.this, 4);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ATSplashNativeView.a(ATSplashNativeView.this, 1);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ATSplashNativeView.a(ATSplashNativeView.this, 0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$8, reason: invalid class name */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ATSplashNativeView.this.M.aG() != null) {
                String strC = ATSplashNativeView.this.M.aG().c();
                if (TextUtils.isEmpty(strC)) {
                    return;
                }
                l.b(ATSplashNativeView.this.getContext(), strC);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$9, reason: invalid class name */
    final class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.anythink.expressad.foundation.d.a aVarAG = ATSplashNativeView.this.M.aG();
            if (aVarAG != null) {
                l.b(com.anythink.core.common.b.n.a().g(), aVarAG.a());
            }
        }
    }

    public ATSplashNativeView(Context context) {
        super(context);
        this.H = false;
        this.I = false;
    }

    static /* synthetic */ boolean a(ATSplashNativeView aTSplashNativeView) {
        aTSplashNativeView.F = true;
        return true;
    }

    private void h() {
        if (this.f11390u == 1) {
            setOnClickListener(new AnonymousClass6());
        } else {
            this.f11387r.setOnClickListener(new AnonymousClass7());
        }
        this.f11385p.setOnClickListener(new AnonymousClass8());
        this.f11386q.setOnClickListener(new AnonymousClass9());
        this.f11376g.setOnClickListener(new AnonymousClass10());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f11393x != 1 || this.N == null || this.R == null) {
                return;
            }
            com.anythink.expressad.shake.a.a().a(this.R);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.C = motionEvent.getRawX();
        this.D = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.R != null) {
                com.anythink.expressad.shake.a.a().b(this.R);
                this.R = null;
            }
            com.anythink.expressad.foundation.f.b.a().c(this.J);
            detachAllViewsFromParent();
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
        }
    }

    public void setIsPause(boolean z2) {
        this.H = z2;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        this.f11373d.setPadding(i2, i4, i3, i5);
    }

    public void updateCountDown(int i2) {
        String str;
        if (this.f11376g != null) {
            this.f11389t = i2;
            if (this.G) {
                str = this.P + " " + i2 + this.O;
            } else {
                str = i2 + this.O + " " + this.Q;
            }
            this.f11376g.setText(str);
        }
    }

    private void b() {
        try {
            this.E = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f11375f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
        } else {
            FeedBackButton feedBackButton = this.f11375f;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(this.M.be())) {
            this.f11372c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
        }
        e();
        if (this.M.aG() == null || this.f11392w != 0) {
            this.f11383n.setVisibility(8);
        } else {
            com.anythink.expressad.foundation.d.a aVarAG = this.M.aG();
            StringBuilder sb = new StringBuilder();
            sb.append("应用名称：");
            sb.append(aVarAG.b());
            sb.append("\n版本：");
            sb.append(aVarAG.e());
            sb.append("\n开发者：");
            sb.append(aVarAG.f());
            sb.append("\n更新时间：");
            sb.append(aVarAG.d());
            this.f11384o.setText(sb);
        }
        if (this.f11391v == 1 || this.f11393x == 1) {
            this.f11387r.setVisibility(8);
        } else {
            this.f11387r.initView(this.M.cU);
        }
        if (this.f11390u == 1) {
            setOnClickListener(new AnonymousClass6());
        } else {
            this.f11387r.setOnClickListener(new AnonymousClass7());
        }
        this.f11385p.setOnClickListener(new AnonymousClass8());
        this.f11386q.setOnClickListener(new AnonymousClass9());
        this.f11376g.setOnClickListener(new AnonymousClass10());
        if (this.f11393x == 1) {
            this.N = new MBShakeView(getContext());
            this.N.initView(this.M.cU);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.f11387r.setVisibility(4);
            this.f11387r.setEnabled(false);
            this.N.setOnClickListener(new AnonymousClass2());
            this.R = new AnonymousClass3(this.f11394y, this.f11395z * 1000);
        }
        updateCountDown(this.f11388s);
    }

    private void c() {
        if (TextUtils.isEmpty(this.M.be())) {
            this.f11372c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
        }
    }

    private void d() {
        if (TextUtils.isEmpty(this.M.bd())) {
            this.f11378i.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.bd(), new AnonymousClass4());
        }
    }

    private void e() {
        Drawable drawable;
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
        if (aVarB != null) {
            final String strJ = aVarB.J();
            if (TextUtils.isEmpty(strJ)) {
                this.f11374e.setVisibility(8);
            }
            this.f11374e.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashNativeView.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.b(ATSplashNativeView.this.getContext(), strJ);
                }
            });
        } else {
            this.f11374e.setVisibility(8);
        }
        try {
            drawable = getResources().getDrawable(i.a(getContext().getApplicationContext(), "anythink_splash_m_circle", i.f10645c));
        } catch (Throwable th) {
            th = th;
            drawable = null;
        }
        try {
            drawable.setBounds(0, 0, t.b(getContext(), 10.0f), t.b(getContext(), 10.0f));
        } catch (Throwable th2) {
            th = th2;
            o.d(a, th.getMessage());
        }
        if (this.A == 1 && this.F) {
            if (this.B != 0 && drawable != null) {
                this.f11382m.setCompoundDrawables(drawable, null, null, null);
            }
            this.f11382m.setText(this.E ? "AD" : "广告");
            this.f11381l.setVisibility(4);
            return;
        }
        if (this.B != 0 && drawable != null) {
            this.f11381l.setCompoundDrawables(drawable, null, null, null);
        }
        this.f11381l.setText(this.E ? "AD" : "广告");
        this.f11382m.setVisibility(4);
    }

    private void f() {
        if (this.M.aG() == null || this.f11392w != 0) {
            this.f11383n.setVisibility(8);
            return;
        }
        com.anythink.expressad.foundation.d.a aVarAG = this.M.aG();
        StringBuilder sb = new StringBuilder();
        sb.append("应用名称：");
        sb.append(aVarAG.b());
        sb.append("\n版本：");
        sb.append(aVarAG.e());
        sb.append("\n开发者：");
        sb.append(aVarAG.f());
        sb.append("\n更新时间：");
        sb.append(aVarAG.d());
        this.f11384o.setText(sb);
    }

    private void g() {
        if (this.f11391v == 1) {
            this.f11387r.setVisibility(8);
        } else if (this.f11393x == 1) {
            this.f11387r.setVisibility(8);
        } else {
            this.f11387r.initView(this.M.cU);
        }
    }

    private void i() {
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f11375f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
            return;
        }
        FeedBackButton feedBackButton = this.f11375f;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    private void j() {
        if (this.f11393x == 1) {
            this.N = new MBShakeView(getContext());
            this.N.initView(this.M.cU);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.f11387r.setVisibility(4);
            this.f11387r.setEnabled(false);
            this.N.setOnClickListener(new AnonymousClass2());
            this.R = new AnonymousClass3(this.f11394y, this.f11395z * 1000);
        }
    }

    private void a() {
        int iA;
        try {
            if (this.A == 1) {
                iA = i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout");
            } else {
                iA = i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout");
            }
            View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
            addView(viewInflate);
            this.b = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
            this.f11372c = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
            this.f11373d = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
            this.f11374e = (ImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
            this.f11375f = (FeedBackButton) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
            this.f11376g = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
            this.f11377h = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
            this.f11378i = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
            this.f11379j = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
            this.f11380k = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
            this.f11381l = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
            this.f11383n = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
            this.f11384o = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
            this.f11385p = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
            this.f11386q = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
            this.f11387r = (MBSplashClickView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
            this.f11382m = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
            int iA2 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", i.f10649g);
            int iA3 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", i.f10649g);
            int iA4 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", i.f10649g);
            this.P = getContext().getResources().getString(iA2);
            this.Q = getContext().getResources().getString(iA3);
            this.O = getContext().getResources().getString(iA4);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    public ATSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashNativeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.H = false;
        this.I = false;
    }

    static /* synthetic */ void h(ATSplashNativeView aTSplashNativeView) {
        if (!TextUtils.isEmpty(aTSplashNativeView.M.bd())) {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(aTSplashNativeView.M.bd(), aTSplashNativeView.new AnonymousClass4());
        } else {
            aTSplashNativeView.f11378i.setVisibility(4);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {
        AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            Bitmap bitmapA;
            if (bitmap != null) {
                try {
                } catch (Throwable th) {
                    o.d(ATSplashNativeView.a, th.getMessage());
                }
                if (bitmap.isRecycled()) {
                    return;
                }
                try {
                    if (ATSplashNativeView.this.f11378i == null || (bitmapA = n.a(bitmap, t.b(com.anythink.core.common.b.n.a().g(), 40.0f))) == null || bitmapA.isRecycled()) {
                        return;
                    }
                    ATSplashNativeView.this.f11378i.setImageBitmap(bitmapA);
                    return;
                } catch (Throwable th2) {
                    o.d(ATSplashNativeView.a, th2.getMessage());
                    ATSplashNativeView.this.f11378i.setImageBitmap(bitmap);
                    return;
                }
                o.d(ATSplashNativeView.a, th.getMessage());
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            ATSplashNativeView.this.f11378i.setVisibility(4);
        }
    }

    public ATSplashNativeView(Context context, ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar) {
        int iA;
        super(context);
        this.H = false;
        this.I = false;
        if (bVar != null) {
            this.J = bVar.b();
            this.K = bVar.a();
            this.M = bVar.c();
            this.L = aTSplashView;
            this.f11388s = bVar.e();
            this.f11391v = bVar.f();
            this.f11390u = bVar.g();
            this.f11392w = bVar.h();
            this.f11393x = bVar.i();
            this.f11394y = bVar.j();
            this.f11395z = bVar.k();
            this.A = bVar.l();
            this.G = bVar.d();
            this.B = bVar.m();
            try {
                if (this.A == 1) {
                    iA = i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout");
                } else {
                    iA = i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout");
                }
                View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
                addView(viewInflate);
                this.b = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
                this.f11372c = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
                this.f11373d = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
                this.f11374e = (ImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
                this.f11375f = (FeedBackButton) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
                this.f11376g = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
                this.f11377h = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
                this.f11378i = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
                this.f11379j = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
                this.f11380k = (MBNoRecycledCrashImageView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
                this.f11381l = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
                this.f11383n = (RelativeLayout) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
                this.f11384o = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
                this.f11385p = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
                this.f11386q = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
                this.f11387r = (MBSplashClickView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
                this.f11382m = (TextView) viewInflate.findViewById(i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
                int iA2 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", i.f10649g);
                int iA3 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", i.f10649g);
                int iA4 = i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", i.f10649g);
                this.P = getContext().getResources().getString(iA2);
                this.Q = getContext().getResources().getString(iA3);
                this.O = getContext().getResources().getString(iA4);
            } catch (Throwable th) {
                o.d(a, th.getMessage());
            }
            try {
                this.E = getContext().getResources().getConfiguration().locale.getLanguage().contains("en");
            } catch (Throwable th2) {
                o.d(a, th2.getMessage());
            }
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                this.M.l(this.J);
                com.anythink.expressad.foundation.f.b.a().a(this.J, new AnonymousClass11());
                com.anythink.expressad.foundation.f.b.a().a(this.J, this.f11375f);
                com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
            } else {
                FeedBackButton feedBackButton = this.f11375f;
                if (feedBackButton != null) {
                    feedBackButton.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.M.be())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.M.be(), new AnonymousClass1());
            } else {
                this.f11372c.setVisibility(4);
            }
            e();
            if (this.M.aG() != null && this.f11392w == 0) {
                com.anythink.expressad.foundation.d.a aVarAG = this.M.aG();
                StringBuilder sb = new StringBuilder();
                sb.append("应用名称：");
                sb.append(aVarAG.b());
                sb.append("\n版本：");
                sb.append(aVarAG.e());
                sb.append("\n开发者：");
                sb.append(aVarAG.f());
                sb.append("\n更新时间：");
                sb.append(aVarAG.d());
                this.f11384o.setText(sb);
            } else {
                this.f11383n.setVisibility(8);
            }
            if (this.f11391v == 1 || this.f11393x == 1) {
                this.f11387r.setVisibility(8);
            } else {
                this.f11387r.initView(this.M.cU);
            }
            if (this.f11390u == 1) {
                setOnClickListener(new AnonymousClass6());
            } else {
                this.f11387r.setOnClickListener(new AnonymousClass7());
            }
            this.f11385p.setOnClickListener(new AnonymousClass8());
            this.f11386q.setOnClickListener(new AnonymousClass9());
            this.f11376g.setOnClickListener(new AnonymousClass10());
            if (this.f11393x == 1) {
                this.N = new MBShakeView(getContext());
                this.N.initView(this.M.cU);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.N.setLayoutParams(layoutParams);
                addView(this.N);
                this.f11387r.setVisibility(4);
                this.f11387r.setEnabled(false);
                this.N.setOnClickListener(new AnonymousClass2());
                this.R = new AnonymousClass3(this.f11394y, this.f11395z * 1000);
            }
            updateCountDown(this.f11388s);
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    private void a(int i2) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i2, this.C, this.D), this.M));
        } catch (Throwable th) {
            o.d(a, th.getMessage());
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(this.M);
        }
    }

    private void a(boolean z2) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z2 ? 2 : 1, this.f11389t);
    }

    static /* synthetic */ void a(ATSplashNativeView aTSplashNativeView, int i2) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i2, aTSplashNativeView.C, aTSplashNativeView.D), aTSplashNativeView.M));
        } catch (Throwable th) {
            o.d(a, th.getMessage());
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(aTSplashNativeView.M);
        }
    }

    static /* synthetic */ void b(ATSplashNativeView aTSplashNativeView, boolean z2) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z2 ? 2 : 1, aTSplashNativeView.f11389t);
    }
}
