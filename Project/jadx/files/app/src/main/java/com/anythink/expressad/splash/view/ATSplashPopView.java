package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.d.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11397c = "ATSplashPopView";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f11398d = new AtomicInteger(1);
    View.OnClickListener a;
    View.OnClickListener b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f11402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f11403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f11404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageView f11405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageView f11406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImageView f11407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f11408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f11409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f11410p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11411q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Handler f11412r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f11413s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.anythink.expressad.a.a f11414t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f11415u;

    public static class a {
        private String a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f11417d;

        public a(String str, String str2, int i2, c cVar) {
            this.a = str;
            this.b = str2;
            this.f11416c = i2;
            this.f11417d = cVar;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.f11416c;
        }

        public final c d() {
            return this.f11417d;
        }

        private void a(String str) {
            this.a = str;
        }

        private void b(String str) {
            this.b = str;
        }

        private void a(int i2) {
            this.f11416c = i2;
        }

        private void a(c cVar) {
            this.f11417d = cVar;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public ATSplashPopView(Context context, a aVar, d dVar) {
        super(context);
        this.f11401g = 1;
        this.f11411q = -1;
        this.f11412r = new Handler();
        this.f11413s = false;
        this.f11415u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.f11410p != null) {
                    if (ATSplashPopView.this.f11411q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.f11410p.setText(String.valueOf(ATSplashPopView.this.f11411q));
                        ATSplashPopView.this.f11412r.postDelayed(ATSplashPopView.this.f11415u, 1000L);
                    } else {
                        ATSplashPopView.e(ATSplashPopView.this);
                        ATSplashPopView.this.g();
                        ATSplashPopView.this.f11412r.removeCallbacks(ATSplashPopView.this.f11415u);
                        if (ATSplashPopView.this.f11403i != null) {
                            ATSplashPopView.this.f11403i.b();
                        }
                    }
                }
            }
        };
        this.a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.f11402h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11411q <= 0 && ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView.this.f11403i.b();
                }
            }
        };
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f11400f = aVar.b();
        this.f11399e = aVar.a();
        this.f11401g = aVar.c();
        this.f11402h = aVar.d();
        this.f11403i = dVar;
        a();
    }

    static /* synthetic */ int e(ATSplashPopView aTSplashPopView) {
        aTSplashPopView.f11411q = -1;
        return -1;
    }

    public static int generateViewId() {
        int i2;
        int i3;
        do {
            i2 = f11398d.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f11398d.compareAndSet(i2, i3));
        return i2;
    }

    static /* synthetic */ int j(ATSplashPopView aTSplashPopView) {
        int i2 = aTSplashPopView.f11411q;
        aTSplashPopView.f11411q = i2 - 1;
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11403i != null) {
            getWidth();
            getHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f11413s = true;
        if (this.f11410p != null) {
            this.f11412r.removeCallbacks(this.f11415u);
        }
    }

    public void reStartCountDown() {
        if (this.f11413s) {
            this.f11413s = false;
            int i2 = this.f11411q;
            if (i2 == -1 || i2 == 0) {
                g();
                return;
            }
            TextView textView = this.f11410p;
            if (textView != null) {
                textView.setText(String.valueOf(i2));
                this.f11412r.postDelayed(this.f11415u, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.f11412r.removeCallbacks(this.f11415u);
            this.f11415u = null;
            detachAllViewsFromParent();
            this.f11402h = null;
            this.f11403i = null;
        } catch (Exception e2) {
            o.d(f11397c, e2.getMessage());
        }
    }

    public void setPopViewType(a aVar, d dVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f11400f = aVar.b();
        this.f11399e = aVar.a();
        this.f11401g = aVar.c();
        this.f11402h = aVar.d();
        this.f11403i = dVar;
        a();
    }

    public void startCountDown() {
        this.f11412r.removeCallbacks(this.f11415u);
        c cVar = this.f11402h;
        if (cVar == null || this.f11401g != 1) {
            return;
        }
        int iU = cVar.u();
        if (iU <= 0) {
            g();
            return;
        }
        this.f11411q = iU;
        TextView textView = this.f11410p;
        if (textView != null) {
            textView.setText(String.valueOf(this.f11411q));
            this.f11412r.postDelayed(this.f11415u, 1000L);
        }
    }

    private void a() {
        if (this.f11402h == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i2 = this.f11401g;
        if (i2 == 1) {
            b();
            return;
        }
        if (i2 == 2) {
            c();
        } else if (i2 == 3) {
            d();
        } else {
            if (i2 != 4) {
                return;
            }
            e();
        }
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 80.0f), t.b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = t.b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_default", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        this.f11404j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t.b(getContext(), 60.0f), t.b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = t.b(getContext(), 7.0f);
        layoutParams2.leftMargin = t.b(getContext(), 10.0f);
        this.f11404j.setId(generateViewId());
        this.f11404j.setLayoutParams(layoutParams2);
        this.f11404j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        c cVar = this.f11402h;
        if (cVar != null && !TextUtils.isEmpty(cVar.bd())) {
            a(this.f11402h.bd(), true);
        }
        this.f11410p = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = t.b(getContext(), 62.0f);
        layoutParams3.bottomMargin = t.b(getContext(), 70.0f);
        this.f11410p.setId(generateViewId());
        this.f11410p.setTextSize(10.0f);
        this.f11410p.setTextColor(-1);
        this.f11410p.setGravity(17);
        this.f11410p.setMinWidth(t.b(getContext(), 16.0f));
        this.f11410p.setMaxHeight(t.b(getContext(), 16.0f));
        this.f11410p.setLayoutParams(layoutParams3);
        this.f11410p.setBackgroundResource(getResources().getIdentifier("anythink_cm_circle_50black", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(imageView);
        addView(this.f11410p);
        addView(this.f11404j);
        c cVar2 = this.f11402h;
        if (cVar2 != null && cVar2.u() <= 0) {
            g();
        }
        setOnClickListener(this.a);
        this.f11410p.setOnClickListener(this.b);
    }

    private void c() {
        int iB = t.b(getContext(), 4.0f);
        this.f11404j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f11404j.setId(generateViewId());
        this.f11404j.setLayoutParams(layoutParams);
        this.f11404j.setPadding(iB, iB, iB, iB);
        this.f11404j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.f11402h.bd(), false);
        this.f11408n = new TextView(getContext());
        this.f11408n.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f11404j.getId());
        layoutParams2.addRule(6, this.f11404j.getId());
        layoutParams2.addRule(8, this.f11404j.getId());
        layoutParams2.leftMargin = t.b(getContext(), 4.0f);
        layoutParams2.rightMargin = t.b(getContext(), 40.0f);
        this.f11408n.setLayoutParams(layoutParams2);
        this.f11408n.setGravity(16);
        this.f11408n.setTextSize(10.0f);
        this.f11408n.setSelected(true);
        this.f11408n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f11408n.setMarqueeRepeatLimit(-1);
        this.f11408n.setSingleLine(true);
        this.f11408n.setTextColor(-16777216);
        this.f11408n.setText(this.f11402h.bb());
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.f11404j);
        addView(this.f11408n);
        f();
        setOnClickListener(this.a);
    }

    private void d() {
        int iB = t.b(getContext(), 4.0f);
        this.f11404j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 50.0f), t.b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f11404j.setId(generateViewId());
        this.f11404j.setLayoutParams(layoutParams);
        this.f11404j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f11404j.setPadding(iB, iB, iB, iB);
        a(this.f11402h.bd(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f11404j.getId());
        layoutParams2.addRule(6, this.f11404j.getId());
        layoutParams2.addRule(8, this.f11404j.getId());
        layoutParams2.leftMargin = t.b(getContext(), 8.0f);
        layoutParams2.rightMargin = t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        this.f11408n = new TextView(getContext());
        this.f11408n.setId(generateViewId());
        this.f11408n.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f11408n.setGravity(16);
        this.f11408n.setTextSize(12.0f);
        this.f11408n.setSelected(true);
        this.f11408n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f11408n.setMarqueeRepeatLimit(-1);
        this.f11408n.setSingleLine(true);
        this.f11408n.setTextColor(-16777216);
        this.f11408n.setText(this.f11402h.bb());
        this.f11409o = new TextView(getContext());
        this.f11409o.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.f11408n.getId());
        layoutParams3.addRule(3, this.f11408n.getId());
        layoutParams3.topMargin = t.b(getContext(), 4.0f);
        layoutParams3.rightMargin = t.b(getContext(), 36.0f);
        this.f11409o.setGravity(16);
        this.f11409o.setLayoutParams(layoutParams3);
        this.f11409o.setTextSize(8.0f);
        this.f11409o.setTextColor(-10066330);
        this.f11409o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f11409o.setMarqueeRepeatLimit(-1);
        this.f11409o.setSelected(true);
        this.f11409o.setSingleLine(true);
        this.f11409o.setText(this.f11402h.bc());
        relativeLayout.addView(this.f11408n);
        relativeLayout.addView(this.f11409o);
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.f11404j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    private void e() {
        this.f11406l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t.b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.f11406l.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f11406l.setId(generateViewId());
        this.f11406l.setLayoutParams(layoutParams);
        a(this.f11402h.be());
        this.f11405k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, t.b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f11405k.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f11405k.setId(generateViewId());
        this.f11405k.setLayoutParams(layoutParams2);
        b(this.f11402h.be());
        this.f11404j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(t.b(getContext(), 50.0f), t.b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.f11406l.getId());
        layoutParams3.topMargin = 20;
        this.f11404j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f11404j.setId(generateViewId());
        this.f11404j.setLayoutParams(layoutParams3);
        a(this.f11402h.bd(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f11404j.getId());
        layoutParams4.addRule(6, this.f11404j.getId());
        layoutParams4.addRule(8, this.f11404j.getId());
        layoutParams4.leftMargin = t.b(getContext(), 8.0f);
        layoutParams4.rightMargin = t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        this.f11408n = new TextView(getContext());
        this.f11408n.setId(generateViewId());
        this.f11408n.setGravity(16);
        this.f11408n.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f11408n.setTextSize(12.0f);
        this.f11408n.setTextColor(-16777216);
        this.f11408n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f11408n.setMarqueeRepeatLimit(-1);
        this.f11408n.setSelected(true);
        this.f11408n.setSingleLine(true);
        this.f11408n.setText(this.f11402h.bb());
        this.f11409o = new TextView(getContext());
        this.f11409o.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.f11408n.getId());
        layoutParams5.addRule(3, this.f11408n.getId());
        layoutParams5.topMargin = t.b(getContext(), 4.0f);
        layoutParams5.rightMargin = t.b(getContext(), 36.0f);
        this.f11409o.setGravity(16);
        this.f11409o.setLayoutParams(layoutParams5);
        this.f11409o.setTextSize(8.0f);
        this.f11409o.setTextColor(-10066330);
        this.f11409o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f11409o.setMarqueeRepeatLimit(-1);
        this.f11409o.setSelected(true);
        this.f11409o.setSingleLine(true);
        this.f11409o.setText(this.f11402h.bc());
        relativeLayout.addView(this.f11408n);
        relativeLayout.addView(this.f11409o);
        addView(this.f11406l);
        addView(this.f11405k);
        addView(this.f11404j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    private void f() {
        String language;
        this.f11407m = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 32.0f), t.b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f11404j.getId());
        this.f11407m.setLayoutParams(layoutParams);
        try {
            language = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            o.d(f11397c, th.getMessage());
            language = "ZH";
        }
        this.f11407m.setBackgroundResource((language.toUpperCase().equals("CN") || language.toUpperCase().equals("ZH")) ? getResources().getIdentifier("anythink_splash_ad", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()) : getResources().getIdentifier("anythink_splash_ad_en", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.f11407m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.f11410p;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = t.b(getContext(), 16.0f);
            layoutParams.height = t.b(getContext(), 16.0f);
            this.f11410p.setLayoutParams(layoutParams);
            this.f11410p.setText("");
            this.f11410p.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_close", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    private void a(String str, final boolean z2) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.1
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    Bitmap bitmapA = z2 ? com.anythink.expressad.foundation.h.n.a(bitmap) : com.anythink.expressad.foundation.h.n.a(bitmap, 16);
                    ImageView imageView = ATSplashPopView.this.f11404j;
                    if (bitmapA != null) {
                        bitmap = bitmapA;
                    }
                    imageView.setImageBitmap(bitmap);
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f11397c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f11397c, str2);
            }
        });
    }

    private void a(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    com.anythink.core.common.k.b.a(n.a().g(), bitmap);
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f11397c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f11397c, str2);
            }
        });
    }

    private void a(c cVar) {
        d dVar = this.f11403i;
        if (dVar != null) {
            dVar.a(cVar);
            this.f11403i.b();
        }
    }

    static /* synthetic */ void a(ATSplashPopView aTSplashPopView, c cVar) {
        d dVar = aTSplashPopView.f11403i;
        if (dVar != null) {
            dVar.a(cVar);
            aTSplashPopView.f11403i.b();
        }
    }

    public ATSplashPopView(Context context) {
        super(context);
        this.f11401g = 1;
        this.f11411q = -1;
        this.f11412r = new Handler();
        this.f11413s = false;
        this.f11415u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.f11410p != null) {
                    if (ATSplashPopView.this.f11411q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.f11410p.setText(String.valueOf(ATSplashPopView.this.f11411q));
                        ATSplashPopView.this.f11412r.postDelayed(ATSplashPopView.this.f11415u, 1000L);
                    } else {
                        ATSplashPopView.e(ATSplashPopView.this);
                        ATSplashPopView.this.g();
                        ATSplashPopView.this.f11412r.removeCallbacks(ATSplashPopView.this.f11415u);
                        if (ATSplashPopView.this.f11403i != null) {
                            ATSplashPopView.this.f11403i.b();
                        }
                    }
                }
            }
        };
        this.a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.f11402h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11411q <= 0 && ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView.this.f11403i.b();
                }
            }
        };
        this.f11401g = 1;
        o.b(f11397c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11401g = 1;
        this.f11411q = -1;
        this.f11412r = new Handler();
        this.f11413s = false;
        this.f11415u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.f11410p != null) {
                    if (ATSplashPopView.this.f11411q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.f11410p.setText(String.valueOf(ATSplashPopView.this.f11411q));
                        ATSplashPopView.this.f11412r.postDelayed(ATSplashPopView.this.f11415u, 1000L);
                    } else {
                        ATSplashPopView.e(ATSplashPopView.this);
                        ATSplashPopView.this.g();
                        ATSplashPopView.this.f11412r.removeCallbacks(ATSplashPopView.this.f11415u);
                        if (ATSplashPopView.this.f11403i != null) {
                            ATSplashPopView.this.f11403i.b();
                        }
                    }
                }
            }
        };
        this.a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.f11402h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11411q <= 0 && ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView.this.f11403i.b();
                }
            }
        };
        this.f11401g = 1;
        o.b(f11397c, "Please call setPopViewType() to init.");
    }

    public ATSplashPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11401g = 1;
        this.f11411q = -1;
        this.f11412r = new Handler();
        this.f11413s = false;
        this.f11415u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.f11410p != null) {
                    if (ATSplashPopView.this.f11411q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.f11410p.setText(String.valueOf(ATSplashPopView.this.f11411q));
                        ATSplashPopView.this.f11412r.postDelayed(ATSplashPopView.this.f11415u, 1000L);
                    } else {
                        ATSplashPopView.e(ATSplashPopView.this);
                        ATSplashPopView.this.g();
                        ATSplashPopView.this.f11412r.removeCallbacks(ATSplashPopView.this.f11415u);
                        if (ATSplashPopView.this.f11403i != null) {
                            ATSplashPopView.this.f11403i.b();
                        }
                    }
                }
            }
        };
        this.a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.f11402h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11411q <= 0 && ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView.this.f11403i.b();
                }
            }
        };
        this.f11401g = 1;
        o.b(f11397c, "Please call setPopViewType() to init.");
    }

    private void b(String str) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.3
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    ATSplashPopView.this.f11405k.setImageBitmap(com.anythink.expressad.foundation.h.n.a(bitmap, 16));
                } catch (Throwable th) {
                    o.d(ATSplashPopView.f11397c, th.getMessage());
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                o.d(ATSplashPopView.f11397c, str2);
            }
        });
    }

    private void b(c cVar) {
        d dVar = this.f11403i;
        if (dVar != null) {
            dVar.a(cVar);
            this.f11403i.b();
        }
    }

    @RequiresApi(api = 21)
    public ATSplashPopView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f11401g = 1;
        this.f11411q = -1;
        this.f11412r = new Handler();
        this.f11413s = false;
        this.f11415u = new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (ATSplashPopView.this.f11410p != null) {
                    if (ATSplashPopView.this.f11411q != 0) {
                        ATSplashPopView.j(ATSplashPopView.this);
                        ATSplashPopView.this.f11410p.setText(String.valueOf(ATSplashPopView.this.f11411q));
                        ATSplashPopView.this.f11412r.postDelayed(ATSplashPopView.this.f11415u, 1000L);
                    } else {
                        ATSplashPopView.e(ATSplashPopView.this);
                        ATSplashPopView.this.g();
                        ATSplashPopView.this.f11412r.removeCallbacks(ATSplashPopView.this.f11415u);
                        if (ATSplashPopView.this.f11403i != null) {
                            ATSplashPopView.this.f11403i.b();
                        }
                    }
                }
            }
        };
        this.a = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView aTSplashPopView = ATSplashPopView.this;
                    ATSplashPopView.a(aTSplashPopView, aTSplashPopView.f11402h);
                }
            }
        };
        this.b = new View.OnClickListener() { // from class: com.anythink.expressad.splash.view.ATSplashPopView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ATSplashPopView.this.f11411q <= 0 && ATSplashPopView.this.f11403i != null) {
                    ATSplashPopView.this.f11403i.b();
                }
            }
        };
        this.f11401g = 1;
        o.b(f11397c, "Please call setPopViewType() to init.");
    }
}
