package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.s;
import com.anythink.core.common.res.b;
import com.anythink.core.common.v;
import com.anythink.expressad.foundation.h.i;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.anythink.core.common.f<e> {
    public static final String a = "a";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Runnable f12293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f12294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AtomicBoolean f12295p;

    /* JADX INFO: renamed from: com.anythink.interstitial.a.a$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.a$3, reason: invalid class name */
    final class AnonymousClass3 implements b.a {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12303c;

        AnonymousClass3(WeakReference weakReference, String str, int i2) {
            this.a = weakReference;
            this.b = str;
            this.f12303c = i2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            "load: image load fail:".concat(String.valueOf(str2));
            ImageView imageView = (ImageView) this.a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageResource(this.f12303c);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            ImageView imageView = (ImageView) this.a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    private a(Context context, String str) {
        super(context, str);
        this.f12295p = new AtomicBoolean(false);
        this.f12293n = new Runnable() { // from class: com.anythink.interstitial.a.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.j()) {
                    a.this.a(n.a().E(), 4, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        };
    }

    private static void m() {
    }

    private static void n() {
    }

    private static void o() {
    }

    private void p() {
        n.a().a(this.f12293n, ((long) Math.pow(2.0d, this.f7397h)) * 1000);
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(j jVar) {
        e eVar = (e) jVar;
        f fVar = new f(eVar.a());
        fVar.a(eVar.f7583d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    protected final String a() {
        return "3";
    }

    @Override // com.anythink.core.common.f
    protected final boolean j() {
        return v.a().f(this.f7392c);
    }

    @Override // com.anythink.core.common.f
    protected final void k() {
        n.a().c(this.f12293n);
    }

    @Override // com.anythink.core.common.f
    protected final void l() {
        ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener;
        super.l();
        if (!j() || (aTInterstitialAutoLoadListener = b.a().b) == null) {
            return;
        }
        aTInterstitialAutoLoadListener.onInterstitialAutoLoaded(this.f7392c);
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.a$5, reason: invalid class name */
    final class AnonymousClass5 implements b.InterfaceC0141b {
        final /* synthetic */ d a;
        final /* synthetic */ String b;

        AnonymousClass5(d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(boolean z2) {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoStart();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void c() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void d() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void e() {
            com.anythink.basead.e.b.a().b(this.b);
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.c.e eVar) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(int i2) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.onInterstitialAdClicked();
            }
        }
    }

    @Override // com.anythink.core.common.f
    protected final void b(AdError adError) {
        super.b(adError);
        if (j()) {
            n.a().a(this.f12293n, ((long) Math.pow(2.0d, this.f7397h)) * 1000);
            ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener = b.a().b;
            if (aTInterstitialAutoLoadListener != null) {
                aTInterstitialAutoLoadListener.onInterstitialAutoLoadFail(this.f7392c, adError);
            }
        }
    }

    public static a a(Context context, String str) {
        com.anythink.core.common.f fVarB = v.a().b(str);
        if (fVarB == null || !(fVarB instanceof a)) {
            fVarB = new a(context, str);
            v.a().a(str, fVarB);
        }
        return (a) fVarB;
    }

    public final synchronized void a(final Activity activity, final String str, final ATInterstitialListener aTInterstitialListener, final ATEventInterface aTEventInterface, final Map<String, Object> map) {
        if (this.f12295p.get()) {
            StringBuilder sb = new StringBuilder("The placementId(");
            sb.append(this.f7392c);
            sb.append(") is already in the process of being delayed.");
            return;
        }
        final com.anythink.core.common.e.b bVarA = a((Context) activity, false, true, map);
        if (bVarA == null || !(bVarA.e() instanceof CustomInterstitialAdapter)) {
            if (a((ATAdStatusInfo) null)) {
                a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
            }
            return;
        }
        a(bVarA);
        f();
        bVarA.a(bVarA.d() + 1);
        final int iAe = bVarA.e().getUnitGroupInfo().ae();
        if (iAe > 0) {
            this.f12295p.set(true);
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final CustomInterstitialAdapter customInterstitialAdapter = (CustomInterstitialAdapter) bVarA.e();
                Activity activity2 = activity;
                if (activity2 != null) {
                    customInterstitialAdapter.refreshActivityContext(activity2);
                }
                final com.anythink.core.common.e.e trackingInfo = bVarA.e().getTrackingInfo();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (trackingInfo != null) {
                    trackingInfo.f7248v = ((com.anythink.core.common.f) a.this).f7396g;
                    trackingInfo.C = str;
                    trackingInfo.h(g.a(trackingInfo.X(), trackingInfo.x(), jCurrentTimeMillis));
                    s.a(((com.anythink.core.common.f) a.this).b, trackingInfo);
                    s.a((Map<String, Object>) map, trackingInfo);
                }
                com.anythink.core.common.a.a().a(((com.anythink.core.common.f) a.this).b, bVarA);
                com.anythink.core.common.j.a.a(((com.anythink.core.common.f) a.this).b).a(13, trackingInfo, bVarA.e().getUnitGroupInfo(), jCurrentTimeMillis);
                if (iAe > 0) {
                    n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.a(a.this, activity);
                        }
                    });
                }
                n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        customInterstitialAdapter.setScenario(str);
                        IExHandler iExHandlerB = n.a().b();
                        if (iExHandlerB != null) {
                            CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                            customInterstitialAdapter2.setAdDownloadListener(iExHandlerB.createDownloadListener(customInterstitialAdapter2, null, aTEventInterface));
                        }
                        if (customInterstitialAdapter.getMixedFormatAdType() == 0) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.a(a.this, activity, new d(customInterstitialAdapter, aTInterstitialListener), bVarA.f(), trackingInfo, str);
                        } else {
                            CustomInterstitialAdapter customInterstitialAdapter3 = customInterstitialAdapter;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            customInterstitialAdapter3.internalShow(activity, new d(customInterstitialAdapter3, aTInterstitialListener));
                        }
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        if (iAe <= 0 || !a.this.f12295p.get()) {
                            return;
                        }
                        if (a.this.f12294o != null) {
                            ((ViewGroup) a.this.f12294o.getParent()).removeView(a.this.f12294o);
                        }
                        a.this.f12295p.set(false);
                    }
                }, iAe);
            }
        });
    }

    private void a(Activity activity) {
        if (activity == null) {
            return;
        }
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.b).b(n.a().p());
        String strN = aVarB.n();
        String strM = aVarB.m();
        if (this.f12294o == null) {
            this.f12294o = LayoutInflater.from(activity.getApplicationContext()).inflate(com.anythink.core.common.k.h.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
        }
        this.f12294o.setOnTouchListener(new AnonymousClass2());
        ImageView imageView = (ImageView) this.f12294o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_iv_loading", "id"));
        TextView textView = (TextView) this.f12294o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_tv_loading", "id"));
        int iA = com.anythink.core.common.k.h.a(activity, 30.0f);
        imageView.setMinimumWidth(iA);
        imageView.setMinimumHeight(iA);
        int iA2 = com.anythink.core.common.k.h.a(activity, 90.0f);
        imageView.setMaxWidth(iA2);
        imageView.setMaxHeight(iA2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iA3 = com.anythink.core.common.k.h.a(activity, "interstitial_loading_default", i.f10645c);
        if (TextUtils.isEmpty(strN)) {
            imageView.setImageResource(iA3);
        } else {
            com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strN), new AnonymousClass3(new WeakReference(imageView), strN, iA3));
        }
        if (!TextUtils.isEmpty(strM)) {
            textView.setText(strM);
        } else {
            textView.setText(com.anythink.core.common.k.h.a(activity, "interstitial_text_loading_default", i.f10649g));
        }
        View view = this.f12294o;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f12294o.getParent()).removeView(this.f12294o);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f12294o, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void a(Context context, int i2, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        e eVar = new e();
        eVar.a(context);
        eVar.f7583d = i2;
        eVar.f7584e = bVar;
        eVar.f7586g = map;
        super.a(this.b, "3", this.f7392c, eVar, aVar);
    }

    private static h a(e eVar) {
        f fVar = new f(eVar.a());
        fVar.a(eVar.f7583d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        ATAdStatusInfo aTAdStatusInfoA = super.a(context, map);
        if (!c() && a(aTAdStatusInfoA)) {
            a(context, 5, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
        }
        return aTAdStatusInfoA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Activity activity, d dVar, BaseAd baseAd, com.anythink.core.common.e.e eVar, String str) {
        if (baseAd == 0 || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            if (dVar != null) {
                dVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail,AdCache return illegal type adObject");
                return;
            }
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("3"));
        String strA = com.anythink.core.common.f.a(cVar);
        com.anythink.basead.e.b.a().a(strA, new AnonymousClass5(dVar, strA));
        com.anythink.basead.d.i.a().a(strA, baseAd);
        com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
        aVar.f6586c = bVar;
        aVar.f6587d = strA;
        aVar.a = 3;
        aVar.f6591h = cVar;
        aVar.f6588e = com.anythink.core.common.k.d.g(activity);
        aVar.b = str;
        BaseAdActivity.a(activity, aVar);
    }

    static /* synthetic */ void a(a aVar, Activity activity) {
        if (activity != null) {
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(aVar.b).b(n.a().p());
            String strN = aVarB.n();
            String strM = aVarB.m();
            if (aVar.f12294o == null) {
                aVar.f12294o = LayoutInflater.from(activity.getApplicationContext()).inflate(com.anythink.core.common.k.h.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
            }
            aVar.f12294o.setOnTouchListener(aVar.new AnonymousClass2());
            ImageView imageView = (ImageView) aVar.f12294o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_iv_loading", "id"));
            TextView textView = (TextView) aVar.f12294o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_tv_loading", "id"));
            int iA = com.anythink.core.common.k.h.a(activity, 30.0f);
            imageView.setMinimumWidth(iA);
            imageView.setMinimumHeight(iA);
            int iA2 = com.anythink.core.common.k.h.a(activity, 90.0f);
            imageView.setMaxWidth(iA2);
            imageView.setMaxHeight(iA2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iA3 = com.anythink.core.common.k.h.a(activity, "interstitial_loading_default", i.f10645c);
            if (TextUtils.isEmpty(strN)) {
                imageView.setImageResource(iA3);
            } else {
                com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, strN), aVar.new AnonymousClass3(new WeakReference(imageView), strN, iA3));
            }
            if (!TextUtils.isEmpty(strM)) {
                textView.setText(strM);
            } else {
                textView.setText(com.anythink.core.common.k.h.a(activity, "interstitial_text_loading_default", i.f10649g));
            }
            View view = aVar.f12294o;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) aVar.f12294o.getParent()).removeView(aVar.f12294o);
            }
            ((ViewGroup) activity.getWindow().getDecorView()).addView(aVar.f12294o, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(a aVar, Activity activity, d dVar, BaseAd baseAd, com.anythink.core.common.e.e eVar, String str) {
        if (baseAd != 0 && (baseAd instanceof com.anythink.core.common.e.a.e)) {
            com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
            com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("3"));
            String strA = com.anythink.core.common.f.a(cVar);
            com.anythink.basead.e.b.a().a(strA, aVar.new AnonymousClass5(dVar, strA));
            com.anythink.basead.d.i.a().a(strA, baseAd);
            com.anythink.core.basead.b.a aVar2 = new com.anythink.core.basead.b.a();
            aVar2.f6586c = bVar;
            aVar2.f6587d = strA;
            aVar2.a = 3;
            aVar2.f6591h = cVar;
            aVar2.f6588e = com.anythink.core.common.k.d.g(activity);
            aVar2.b = str;
            BaseAdActivity.a(activity, aVar2);
            return;
        }
        dVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail,AdCache return illegal type adObject");
    }
}
