package com.anythink.basead.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.anythink.basead.e.b;
import com.anythink.core.api.BaseAd;
import com.anythink.core.basead.a;
import com.anythink.core.common.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.y;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAdActivity extends Activity {
    public static final String a = BaseAdActivity.class.getSimpleName();
    boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    y f6094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f6095d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f6096e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f6097f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f6098g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    b.a f6099h = new b.a() { // from class: com.anythink.basead.ui.BaseAdActivity.1
        @Override // com.anythink.core.common.b.a
        public final void a(Object obj) {
            if (!(obj instanceof y) || BaseAdActivity.this.f6102k == null) {
                return;
            }
            y yVar = (y) obj;
            if (yVar.a().B().equals(BaseAdActivity.this.f6102k.B())) {
                BaseAdActivity baseAdActivity = BaseAdActivity.this;
                if (baseAdActivity.b) {
                    yVar.a(baseAdActivity);
                } else {
                    baseAdActivity.f6094c = yVar;
                }
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseScreenAdView f6100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private j f6101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i f6102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b.InterfaceC0141b f6104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f6109r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6110s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6111t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BaseAd f6113v;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        BaseScreenAdView thirdPartyFullScreenAdView;
        super.onCreate(bundle);
        if (n.a().g() == null) {
            n.a().a(getApplicationContext());
        }
        if (this instanceof AdLandscapeActivity) {
            this.f6107p = 2;
        } else {
            this.f6107p = 1;
        }
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.f6105n = intent.getStringExtra("extra_scenario");
                this.f6106o = intent.getIntExtra(a.C0154a.b, 1);
                this.f6102k = (i) intent.getSerializableExtra(a.C0154a.f6570c);
                this.f6101j = (j) intent.getSerializableExtra(a.C0154a.f6572e);
                this.f6103l = intent.getStringExtra(a.C0154a.f6571d);
                this.f6112u = a(this.f6106o, this.f6101j);
            } else {
                String str = a + " Intent is null.";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f6104m = com.anythink.basead.e.b.a().a(this.f6103l);
        this.f6113v = com.anythink.basead.d.i.a().a(this.f6103l);
        j jVar = this.f6101j;
        if (jVar == null || jVar.f7312m == null) {
            String str2 = a + "Start Screen Ad Error.";
            try {
                if (this.f6104m != null) {
                    this.f6104m.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, a + "Start FullScreen Ad Error."));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            finish();
            return;
        }
        if (this.f6102k == null) {
            String str3 = a + " onCreate: OfferAd = null";
            try {
                if (this.f6104m != null) {
                    this.f6104m.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, a + " onCreate: OfferAd = null"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            finish();
            return;
        }
        com.anythink.core.common.b.a().a("1", this.f6099h);
        int i2 = this.f6106o;
        if (i2 != 3) {
            thirdPartyFullScreenAdView = new FullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p);
        } else {
            BaseAd baseAd = this.f6113v;
            thirdPartyFullScreenAdView = baseAd != null ? new ThirdPartyFullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p, baseAd) : this.f6112u ? new HalfScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p) : new FullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p);
        }
        this.f6100i = thirdPartyFullScreenAdView;
        BaseAd baseAd2 = this.f6113v;
        if (baseAd2 == null || baseAd2.getCustomAdContainer() == null) {
            setContentView(this.f6100i);
        } else {
            ViewGroup customAdContainer = this.f6113v.getCustomAdContainer();
            customAdContainer.addView(this.f6100i);
            setContentView(customAdContainer);
        }
        this.f6100i.setListener(new AnonymousClass2());
        if (bundle != null) {
            this.f6108q = bundle.getBoolean(a.C0154a.f6573f);
            this.f6109r = bundle.getBoolean(a.C0154a.f6574g);
            this.f6110s = bundle.getBoolean(a.C0154a.f6575h);
            this.f6111t = bundle.getBoolean(a.C0154a.f6578k);
            this.f6095d = bundle.getLong(a.C0154a.f6580m);
            this.f6096e = bundle.getLong(a.C0154a.f6581n);
            this.f6097f = bundle.getFloat(a.C0154a.f6582o);
            this.f6098g = bundle.getBoolean(a.C0154a.f6576i);
        }
        this.f6100i.setIsShowEndCard(this.f6108q);
        this.f6100i.setHideFeedbackButton(this.f6109r);
        this.f6100i.setHasReward(this.f6111t);
        if (bundle != null) {
            this.f6100i.setVideoMute(this.f6110s);
            this.f6100i.setShowBannerTime(this.f6095d);
            this.f6100i.setHideBannerTime(this.f6096e);
            this.f6100i.setCloseButtonScaleFactor(this.f6097f);
            this.f6100i.setHasPerformClick(this.f6098g);
        }
        try {
            this.f6100i.init();
        } catch (Throwable th3) {
            th3.printStackTrace();
            try {
                if (this.f6104m != null) {
                    this.f6104m.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, h.a(th3.getStackTrace())));
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f6094c = null;
        com.anythink.core.common.b.a().b("1", this.f6099h);
        BaseScreenAdView baseScreenAdView = this.f6100i;
        if (baseScreenAdView != null) {
            baseScreenAdView.t();
        }
        i iVar = this.f6102k;
        if (iVar != null && iVar.E() && !this.f6102k.L()) {
            com.anythink.core.common.a.j.a().b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 == i2) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.b = false;
        BaseScreenAdView baseScreenAdView = this.f6100i;
        if (baseScreenAdView != null) {
            baseScreenAdView.s();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.b = true;
        BaseScreenAdView baseScreenAdView = this.f6100i;
        if (baseScreenAdView != null) {
            baseScreenAdView.r();
        }
        y yVar = this.f6094c;
        if (yVar != null) {
            yVar.a(this);
            this.f6094c = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseScreenAdView baseScreenAdView = this.f6100i;
        if (baseScreenAdView != null) {
            if (baseScreenAdView.isShowEndCard()) {
                bundle.putBoolean(a.C0154a.f6573f, true);
            }
            bundle.putBoolean(a.C0154a.f6574g, this.f6100i.needHideFeedbackButton());
            bundle.putBoolean(a.C0154a.f6575h, this.f6100i.isVideoMute());
            bundle.putBoolean(a.C0154a.f6578k, this.f6100i.hasReward());
            bundle.putLong(a.C0154a.f6580m, this.f6100i.getShowBannerTime());
            bundle.putLong(a.C0154a.f6581n, this.f6100i.getHideBannerTime());
            bundle.putFloat(a.C0154a.f6582o, this.f6100i.getCloseButtonScaleFactor());
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (Build.VERSION.SDK_INT == 26) {
            super.setTheme(h.a(this, "myoffer_half_screen_fit_by_o", com.anythink.expressad.foundation.h.i.f10647e));
        } else {
            super.setTheme(i2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseAdActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements b.InterfaceC0141b {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a() {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.a();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b() {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.b();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void c() {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.c();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void d() {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.d();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void e() {
            BaseAdActivity.this.finish();
            if (BaseAdActivity.this.f6112u) {
                BaseAdActivity.this.overridePendingTransition(0, 0);
            }
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.e();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.c.e eVar) {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.a(eVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(int i2) {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.a(i2);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(boolean z2) {
            if (BaseAdActivity.this.f6104m != null) {
                BaseAdActivity.this.f6104m.a(z2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.app.Activity r4, com.anythink.core.basead.b.a r5) {
        /*
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            com.anythink.core.common.b.n r1 = com.anythink.core.common.b.n.a()
            android.content.Context r1 = r1.g()
            if (r4 == 0) goto L16
            boolean r2 = r4.isFinishing()
            if (r2 != 0) goto L16
            goto L17
        L16:
            r4 = r1
        L17:
            int r1 = r5.a
            com.anythink.core.common.e.j r2 = r5.f6591h
            boolean r1 = a(r1, r2)
            int r2 = r5.f6588e
            r3 = 2
            if (r2 != r3) goto L32
            if (r1 == 0) goto L2c
            java.lang.Class<com.anythink.basead.ui.AdLandscapeTranslucentActivity> r1 = com.anythink.basead.ui.AdLandscapeTranslucentActivity.class
            r0.setClass(r4, r1)
            goto L3f
        L2c:
            java.lang.Class<com.anythink.basead.ui.AdLandscapeActivity> r1 = com.anythink.basead.ui.AdLandscapeActivity.class
            r0.setClass(r4, r1)
            goto L3f
        L32:
            if (r1 == 0) goto L3a
            java.lang.Class<com.anythink.basead.ui.AdPortraitTranslucentActivity> r1 = com.anythink.basead.ui.AdPortraitTranslucentActivity.class
            r0.setClass(r4, r1)
            goto L3f
        L3a:
            java.lang.Class<com.anythink.basead.ui.AdPortraitActivity> r1 = com.anythink.basead.ui.AdPortraitActivity.class
            r0.setClass(r4, r1)
        L3f:
            java.lang.String r1 = r5.b
            java.lang.String r2 = "extra_scenario"
            r0.putExtra(r2, r1)
            int r1 = r5.a
            java.lang.String r2 = "extra_ad_format"
            r0.putExtra(r2, r1)
            com.anythink.core.common.e.i r1 = r5.f6586c
            java.lang.String r2 = "extra_offer_ad"
            r0.putExtra(r2, r1)
            java.lang.String r1 = r5.f6587d
            java.lang.String r2 = "extra_event_id"
            r0.putExtra(r2, r1)
            com.anythink.core.common.e.j r1 = r5.f6591h
            java.lang.String r2 = "extra_request_info"
            r0.putExtra(r2, r1)
            boolean r1 = r4 instanceof android.app.Activity
            if (r1 != 0) goto L6b
            r1 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r1)
        L6b:
            r4.startActivity(r0)     // Catch: java.lang.Throwable -> L6f
            return
        L6f:
            r4 = move-exception
            com.anythink.basead.e.b r0 = com.anythink.basead.e.b.a()
            java.lang.String r5 = r5.f6587d
            com.anythink.basead.e.b$b r5 = r0.a(r5)
            if (r5 == 0) goto L89
            java.lang.String r4 = r4.getMessage()
            java.lang.String r0 = "10000"
            com.anythink.basead.c.e r4 = com.anythink.basead.c.f.a(r0, r4)
            r5.a(r4)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.BaseAdActivity.a(android.app.Activity, com.anythink.core.basead.b.a):void");
    }

    private BaseScreenAdView b() {
        int i2 = this.f6106o;
        if (i2 != 3) {
            return new FullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p);
        }
        BaseAd baseAd = this.f6113v;
        return baseAd != null ? new ThirdPartyFullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p, baseAd) : this.f6112u ? new HalfScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p) : new FullScreenAdView(this, this.f6101j, this.f6102k, this.f6105n, i2, this.f6107p);
    }

    private void b(Bundle bundle) {
        this.f6100i.setListener(new AnonymousClass2());
        if (bundle != null) {
            this.f6108q = bundle.getBoolean(a.C0154a.f6573f);
            this.f6109r = bundle.getBoolean(a.C0154a.f6574g);
            this.f6110s = bundle.getBoolean(a.C0154a.f6575h);
            this.f6111t = bundle.getBoolean(a.C0154a.f6578k);
            this.f6095d = bundle.getLong(a.C0154a.f6580m);
            this.f6096e = bundle.getLong(a.C0154a.f6581n);
            this.f6097f = bundle.getFloat(a.C0154a.f6582o);
            this.f6098g = bundle.getBoolean(a.C0154a.f6576i);
        }
        this.f6100i.setIsShowEndCard(this.f6108q);
        this.f6100i.setHideFeedbackButton(this.f6109r);
        this.f6100i.setHasReward(this.f6111t);
        if (bundle != null) {
            this.f6100i.setVideoMute(this.f6110s);
            this.f6100i.setShowBannerTime(this.f6095d);
            this.f6100i.setHideBannerTime(this.f6096e);
            this.f6100i.setCloseButtonScaleFactor(this.f6097f);
            this.f6100i.setHasPerformClick(this.f6098g);
        }
        try {
            this.f6100i.init();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                if (this.f6104m != null) {
                    this.f6104m.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, h.a(th.getStackTrace())));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            finish();
        }
    }

    private void a() {
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.f6105n = intent.getStringExtra("extra_scenario");
                this.f6106o = intent.getIntExtra(a.C0154a.b, 1);
                this.f6102k = (i) intent.getSerializableExtra(a.C0154a.f6570c);
                this.f6101j = (j) intent.getSerializableExtra(a.C0154a.f6572e);
                this.f6103l = intent.getStringExtra(a.C0154a.f6571d);
                this.f6112u = a(this.f6106o, this.f6101j);
                return;
            }
            String str = a + " Intent is null.";
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(int i2, j jVar) {
        k kVar;
        if (jVar == null || (kVar = jVar.f7312m) == null || i2 != 3) {
            return false;
        }
        return TextUtils.equals("2", kVar.E());
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f6108q = bundle.getBoolean(a.C0154a.f6573f);
            this.f6109r = bundle.getBoolean(a.C0154a.f6574g);
            this.f6110s = bundle.getBoolean(a.C0154a.f6575h);
            this.f6111t = bundle.getBoolean(a.C0154a.f6578k);
            this.f6095d = bundle.getLong(a.C0154a.f6580m);
            this.f6096e = bundle.getLong(a.C0154a.f6581n);
            this.f6097f = bundle.getFloat(a.C0154a.f6582o);
            this.f6098g = bundle.getBoolean(a.C0154a.f6576i);
        }
    }
}
