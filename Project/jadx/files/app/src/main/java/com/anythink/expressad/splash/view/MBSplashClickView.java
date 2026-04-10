package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
public class MBSplashClickView extends RelativeLayout {
    private static final String a = "MBSplashClickView";
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f11439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f11440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f11441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f11442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f11443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f11444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f11446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f11447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RectF f11448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Paint f11449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Paint f11450s;

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.MBSplashClickView$1, reason: invalid class name */
    final class AnonymousClass1 implements Animation.AnimationListener {
        final /* synthetic */ ScaleAnimation a;

        AnonymousClass1(ScaleAnimation scaleAnimation) {
            this.a = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            MBSplashClickView.this.f11447p.setVisibility(4);
            MBSplashClickView.this.f11447p.postDelayed(new Runnable() { // from class: com.anythink.expressad.splash.view.MBSplashClickView.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.f11447p.startAnimation(AnonymousClass1.this.a);
                }
            }, 700L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            MBSplashClickView.this.f11447p.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.MBSplashClickView$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ ScaleAnimation a;

        AnonymousClass2(ScaleAnimation scaleAnimation) {
            this.a = scaleAnimation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBSplashClickView.this.f11447p.startAnimation(this.a);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.view.MBSplashClickView$3, reason: invalid class name */
    final class AnonymousClass3 implements Animation.AnimationListener {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(final Animation animation) {
            MBSplashClickView.this.f11446o.setVisibility(4);
            MBSplashClickView.this.f11446o.postDelayed(new Runnable() { // from class: com.anythink.expressad.splash.view.MBSplashClickView.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.f11446o.startAnimation(animation);
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            MBSplashClickView.this.f11446o.setVisibility(0);
        }
    }

    public MBSplashClickView(Context context) {
        super(context);
        this.b = "浏览第三方应用";
        this.f11434c = "View";
        this.f11435d = "打开第三方应用";
        this.f11436e = "Open";
        this.f11437f = "下载第三方应用";
        this.f11438g = "Install";
        this.f11439h = "anythink_splash_btn_arrow_right";
        this.f11440i = "anythink_splash_btn_circle";
        this.f11441j = "anythink_splash_btn_finger";
        this.f11442k = "anythink_splash_btn_go";
        this.f11443l = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f11448q = new RectF();
        this.f11449r = new Paint();
        this.f11450s = new Paint();
        a();
    }

    private void c() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setAnimationListener(new AnonymousClass1(scaleAnimation2));
        this.f11447p.setVisibility(4);
        this.f11446o.startAnimation(scaleAnimation);
        this.f11447p.postDelayed(new AnonymousClass2(scaleAnimation2), 500L);
    }

    private void d() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(new AnonymousClass3());
        this.f11446o.startAnimation(translateAnimation);
    }

    private void e() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        this.f11446o.startAnimation(scaleAnimation);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f11448q, this.f11450s, 31);
        canvas.drawRoundRect(this.f11448q, 200.0f, 200.0f, this.f11450s);
        canvas.saveLayer(this.f11448q, this.f11449r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initView(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.view.MBSplashClickView.initView(java.lang.String):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i2 = this.f11445n;
        if (i2 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f11446o.startAnimation(scaleAnimation);
            return;
        }
        if (i2 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new AnonymousClass3());
            this.f11446o.startAnimation(translateAnimation);
            return;
        }
        if (i2 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new AnonymousClass1(scaleAnimation3));
            this.f11447p.setVisibility(4);
            this.f11446o.startAnimation(scaleAnimation2);
            this.f11447p.postDelayed(new AnonymousClass2(scaleAnimation3), 500L);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f11448q.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    private void a() {
        this.f11449r.setAntiAlias(true);
        this.f11449r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f11450s.setAntiAlias(true);
        this.f11450s.setColor(-1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.view.MBSplashClickView.b():void");
    }

    private void a(int i2) {
        int color = Color.parseColor("#666666");
        int color2 = Color.parseColor("#8FC31F");
        int color3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i2 == 2) {
            gradientDrawable.setColor(color2);
        } else {
            gradientDrawable.setColor(color3);
            gradientDrawable.setStroke(2, color);
        }
        gradientDrawable.setCornerRadius(200.0f);
        setBackgroundDrawable(gradientDrawable);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -672744069: goto L40;
                case 2464362: goto L36;
                case 2666181: goto L2c;
                case 855294846: goto L22;
                case 1383132195: goto L18;
                case 1681333335: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "浏览第三方应用"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L18:
            java.lang.String r0 = "打开第三方应用"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L22:
            java.lang.String r0 = "下载第三方应用"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L2c:
            java.lang.String r0 = "View"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L36:
            java.lang.String r0 = "Open"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L40:
            java.lang.String r0 = "Install"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L5f
            if (r8 == r6) goto L5f
            if (r8 == r5) goto L5c
            if (r8 == r4) goto L5c
            if (r8 == r2) goto L59
            if (r8 == r1) goto L59
            r6 = 0
            goto L61
        L59:
            r7.f11445n = r6
            goto L61
        L5c:
            r7.f11445n = r4
            goto L61
        L5f:
            r7.f11445n = r5
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.view.MBSplashClickView.a(java.lang.String):boolean");
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "浏览第三方应用";
        this.f11434c = "View";
        this.f11435d = "打开第三方应用";
        this.f11436e = "Open";
        this.f11437f = "下载第三方应用";
        this.f11438g = "Install";
        this.f11439h = "anythink_splash_btn_arrow_right";
        this.f11440i = "anythink_splash_btn_circle";
        this.f11441j = "anythink_splash_btn_finger";
        this.f11442k = "anythink_splash_btn_go";
        this.f11443l = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f11448q = new RectF();
        this.f11449r = new Paint();
        this.f11450s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = "浏览第三方应用";
        this.f11434c = "View";
        this.f11435d = "打开第三方应用";
        this.f11436e = "Open";
        this.f11437f = "下载第三方应用";
        this.f11438g = "Install";
        this.f11439h = "anythink_splash_btn_arrow_right";
        this.f11440i = "anythink_splash_btn_circle";
        this.f11441j = "anythink_splash_btn_finger";
        this.f11442k = "anythink_splash_btn_go";
        this.f11443l = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f11448q = new RectF();
        this.f11449r = new Paint();
        this.f11450s = new Paint();
        a();
    }

    @RequiresApi(api = 21)
    public MBSplashClickView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.b = "浏览第三方应用";
        this.f11434c = "View";
        this.f11435d = "打开第三方应用";
        this.f11436e = "Open";
        this.f11437f = "下载第三方应用";
        this.f11438g = "Install";
        this.f11439h = "anythink_splash_btn_arrow_right";
        this.f11440i = "anythink_splash_btn_circle";
        this.f11441j = "anythink_splash_btn_finger";
        this.f11442k = "anythink_splash_btn_go";
        this.f11443l = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f11448q = new RectF();
        this.f11449r = new Paint();
        this.f11450s = new Paint();
    }
}
