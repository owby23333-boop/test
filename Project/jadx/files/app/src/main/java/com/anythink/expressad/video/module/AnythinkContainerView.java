package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView;
import com.anythink.expressad.video.module.a.a;
import com.anythink.expressad.video.module.a.a.g;
import com.anythink.expressad.video.module.a.a.i;
import com.anythink.expressad.video.module.a.a.k;
import com.anythink.expressad.video.module.a.a.l;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.video.signal.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkContainerView extends AnythinkBaseView implements e, h {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private b Q;
    private AnyThinkOrderCampView R;
    private boolean S;
    private boolean T;
    private List<c> U;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AnythinkPlayableView f11807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AnythinkClickCTAView f11808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AnythinkClickMiniCardView f11809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AnythinkNativeEndCardView f11810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AnythinkH5EndCardView f11811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AnythinkVideoEndCoverView f11812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AnythinkVastEndCardView f11813t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AnythinkLandingPageView f11814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AnythinkAlertWebview f11815v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f11816w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11817x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11818y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11819z;

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkContainerView$4, reason: invalid class name */
    final class AnonymousClass4 extends i {
        AnonymousClass4(a aVar) {
            super(aVar);
        }

        @Override // com.anythink.expressad.video.module.a.a.i, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i2, Object obj) {
            super.a(i2, obj);
            if (i2 == 100) {
                AnythinkContainerView.this.webviewshow();
                AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                anythinkContainerView.onConfigurationChanged(anythinkContainerView.getResources().getConfiguration());
            }
        }
    }

    public AnythinkContainerView(Context context) {
        super(context);
        this.f11818y = 1;
        this.f11819z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    private void b() {
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    private void e() {
        c cVar = this.b;
        if (cVar != null) {
            boolean zJ = cVar.j();
            boolean zF = t.f(this.b.I());
            if (zJ && !zF) {
                i();
                return;
            }
        }
        if (this.f11818y != 2 || this.I) {
            i();
        } else {
            h();
        }
    }

    private void f() {
        if (this.f11813t == null) {
            a(this.Q, (Integer) 3);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        addView(this.f11813t, layoutParams);
        this.f11813t.notifyShowListener();
    }

    private void g() {
        if (this.f11814u == null) {
            a(this.Q, (Integer) 4);
        }
        this.f11814u.setUnitId(this.f11816w);
        this.f11814u.preLoadData(this.Q);
        addView(this.f11814u);
    }

    private void h() {
        if (this.f11811r == null) {
            a(this.Q, (Integer) 2);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView == null || !anythinkH5EndCardView.isLoadSuccess()) {
            i();
            AnythinkH5EndCardView anythinkH5EndCardView2 = this.f11811r;
            if (anythinkH5EndCardView2 != null) {
                anythinkH5EndCardView2.reportRenderResult("timeout", 3);
                this.f11811r.setError(true);
            }
        } else {
            this.I = true;
            addView(this.f11811r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f11811r.excuteTask();
            this.f11811r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        AnythinkH5EndCardView anythinkH5EndCardView3 = this.f11811r;
        if (anythinkH5EndCardView3 != null) {
            anythinkH5EndCardView3.setUnitId(this.f11816w);
        }
    }

    private void i() {
        this.f11818y = 1;
        if (this.f11810q == null) {
            a(this.Q, (Integer) 2);
        }
        addView(this.f11810q);
        onConfigurationChanged(getResources().getConfiguration());
        this.f11810q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void j() {
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.f11812s;
        if (anythinkVideoEndCoverView == null) {
            b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                this.f11812s = new AnythinkVideoEndCoverView(this.a);
                this.f11812s.setCampaign(this.b);
                this.f11812s.setNotifyListener(new i(this.f11787e));
                this.f11812s.preLoadData(bVar);
            }
        }
        addView(this.f11812s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    private void k() {
        if (this.f11807n == null) {
            preLoadData(this.Q);
        }
        addView(this.f11807n);
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.f11816w);
            c cVar = this.b;
            if (cVar != null && cVar.H() && this.b.J() == 2) {
                this.f11807n.setCloseVisible(0);
            }
            this.f11807n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
    }

    private void l() {
        if (this.f11808o == null) {
            b(-1);
        }
        if (this.f11808o != null) {
            c cVar = this.b;
            if (cVar == null || !cVar.j()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                addView(this.f11808o, 0, layoutParams);
            }
        }
    }

    private void m() {
        if (this.f11809p == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.D && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f11809p, layoutParams);
    }

    private void n() {
        if (this.f11815v == null) {
            o();
        }
        AnythinkAlertWebview anythinkAlertWebview = this.f11815v;
        if (anythinkAlertWebview != null && anythinkAlertWebview.getParent() != null) {
            removeView(this.f11815v);
        }
        addView(this.f11815v);
    }

    private void o() {
        if (this.f11815v == null) {
            this.f11815v = new AnythinkAlertWebview(this.a);
            this.f11815v.setUnitId(this.f11816w);
            this.f11815v.setCampaign(this.b);
        }
        this.f11815v.preLoadData(this.Q);
    }

    private void p() {
        this.C = false;
        this.T = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof AnythinkContainerView) {
                    i2++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    private void q() {
        int i2;
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        String strI = cVar.I();
        if (TextUtils.isEmpty(strI)) {
            i2 = 404;
        } else {
            try {
                i2 = Integer.parseInt(x.a(strI, "ecid"));
            } catch (Throwable th) {
                o.d(AnythinkBaseView.TAG, th.getMessage());
                i2 = 404;
            }
        }
        this.f11810q = new AnythinkNativeEndCardView(this.a, null, true, i2, this.b.f() == 2, this.f11794l, this.b.as());
        if (this.b.k() != 5) {
            this.f11810q.setCampaign(this.b);
            return;
        }
        a aVar = this.f11787e;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.b);
        }
        this.f11810q.setCampaign(this.b);
    }

    public void addOrderViewData(List<c> list) {
        if (list == null) {
            return;
        }
        this.U = list;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == null) {
            o.d(AnythinkBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view);
        }
    }

    public boolean canBackPress() {
        if (this.f11810q != null) {
            return false;
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            return anythinkH5EndCardView.canBackPress();
        }
        AnythinkLandingPageView anythinkLandingPageView = this.f11814u;
        if (anythinkLandingPageView != null) {
            return anythinkLandingPageView.canBackPress();
        }
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            return anythinkPlayableView.canBackPress();
        }
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void configurationChanged(int i2, int i3, int i4) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        if (anythinkClickMiniCardView == null || anythinkClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.f11809p.resizeMiniCard(i2, i3);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean endCardShowing() {
        return this.B;
    }

    public boolean endcardIsPlayable() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        return anythinkH5EndCardView != null && anythinkH5EndCardView.isPlayable();
    }

    public AnythinkH5EndCardView getH5EndCardView() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        return anythinkH5EndCardView == null ? this.f11807n : anythinkH5EndCardView;
    }

    public c getReSetCampaign() {
        if (!this.b.j() || !TextUtils.isEmpty(this.b.I())) {
            return null;
        }
        int size = this.U.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (this.U.get(i3) != null && this.U.get(i3).aZ() == this.b.aZ()) {
                    i2 = i3 - 1;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (i2 < 0 || i2 >= size || this.U.get(i2) == null) {
            return null;
        }
        return this.U.get(i2);
    }

    public boolean getShowingTransparent() {
        return this.D;
    }

    public String getUnitID() {
        return this.f11816w;
    }

    public int getVideoInteractiveType() {
        return this.f11817x;
    }

    public int getVideoSkipTime() {
        return this.H;
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.handlerPlayableException(str);
            if (!this.I) {
                return;
            }
        }
        e();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.S && !this.T) {
            p();
            this.S = false;
        }
        AnythinkAlertWebview anythinkAlertWebview = this.f11815v;
        if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.f11815v);
        AnythinkClickCTAView anythinkClickCTAView = this.f11808o;
        if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(c cVar) {
        this.f11787e.a(105, cVar);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void ivRewardAdsWithoutVideo(String str) {
        this.f11787e.a(103, str);
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardLoaded() {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        return anythinkClickMiniCardView != null && anythinkClickMiniCardView.isLoadSuccess();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardShowing() {
        return this.C;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i2) {
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.notifyCloseBtn(i2);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.notifyCloseBtn(i2);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AnythinkBaseView[] anythinkBaseViewArr = {this.f11807n, this.f11808o, this.f11809p, this.f11810q, this.f11811r, this.f11813t, this.f11814u, this.f11812s};
        for (int i2 = 0; i2 < 8; i2++) {
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null && (anythinkBaseView instanceof AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.f11810q != null || this.f11813t != null) {
            this.f11787e.a(104, "");
            return;
        }
        if (this.f11814u != null) {
            this.f11787e.a(103, "");
            return;
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.C) {
            this.f11787e.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.onBackPress();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        AnythinkH5EndCardView[] anythinkH5EndCardViewArr = {this.f11807n, this.f11809p, this.f11811r, this.f11815v};
        for (int i2 = 0; i2 < 4; i2++) {
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0) {
                anythinkH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(final b bVar) {
        this.Q = bVar;
        c cVar = this.b;
        if (cVar != null) {
            if (cVar.J() == 2) {
                if (this.f11807n == null) {
                    this.f11807n = new AnythinkPlayableView(this.a);
                }
                this.f11807n.setCloseDelayShowTime(this.f11819z);
                this.f11807n.setPlayCloseBtnTm(this.A);
                this.f11807n.setCampaign(this.b);
                this.f11807n.setNotifyListener(new AnonymousClass4(this.f11787e));
                this.f11807n.preLoadData(bVar);
            } else {
                b(this.f11817x);
                if (this.b.j()) {
                    try {
                        a(bVar, Integer.valueOf(this.b.F()));
                    } catch (Throwable th) {
                        o.d(AnythinkBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                                anythinkContainerView.a(bVar, Integer.valueOf(anythinkContainerView.b.F()));
                            }
                        });
                    }
                    t.f(this.b.I());
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                            anythinkContainerView.a(bVar, Integer.valueOf(anythinkContainerView.b.F()));
                        }
                    }, getVideoSkipTime());
                }
            }
            o();
        }
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void readyStatus(int i2) {
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.readyStatus(i2);
        }
    }

    public void release() {
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.release();
            this.f11811r = null;
        }
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.release();
        }
        AnythinkLandingPageView anythinkLandingPageView = this.f11814u;
        if (anythinkLandingPageView != null) {
            anythinkLandingPageView.release();
        }
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.f11810q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.clearMoreOfferBitmap();
            this.f11810q.release();
        }
        if (this.f11787e != null) {
            this.f11787e = null;
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void resizeMiniCard(int i2, int i3, int i4) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.resizeMiniCard(i2, i3);
            this.f11809p.setRadius(i4);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
        }
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setAnythinkClickMiniCardViewTransparent();
            this.f11809p.setAnythinkClickMiniCardViewClickable(false);
        }
    }

    public void setCloseDelayTime(int i2) {
        this.f11819z = i2;
    }

    public void setEndscreenType(int i2) {
        this.f11818y = i2;
    }

    public void setJSFactory(b bVar) {
        this.Q = bVar;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        o.d(AnythinkBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2)));
        this.O = i2;
        this.K = i3;
        this.L = i4;
        this.M = i5;
        this.N = i6;
        this.P = com.anythink.expressad.foundation.h.h.a(i2, i3, i4, i5, i6);
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.f11810q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setNotchPadding(i3, i4, i5, i6);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null && anythinkH5EndCardView.f11825s != null) {
            anythinkH5EndCardView.setNotchValue(this.P, i3, i4, i5, i6);
            j.a();
            j.a((WebView) this.f11811r.f11825s, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null && anythinkPlayableView.f11825s != null) {
            anythinkPlayableView.setNotchValue(this.P, i3, i4, i5, i6);
            j.a();
            j.a((WebView) this.f11807n.f11825s, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        AnyThinkOrderCampView anyThinkOrderCampView = this.R;
        if (anyThinkOrderCampView != null) {
            anyThinkOrderCampView.setNotchPadding(i3, i4, i5, i6);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setNotifyListener(a aVar) {
        super.setNotifyListener(aVar);
        AnythinkBaseView[] anythinkBaseViewArr = {this.f11807n, this.f11808o, this.f11809p, this.f11810q, this.f11811r, this.f11813t, this.f11814u, this.f11812s};
        for (int i2 = 0; i2 < 8; i2++) {
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new g(this.f11809p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.f11810q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        AnythinkNativeEndCardView anythinkNativeEndCardView = this.f11810q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i2) {
        this.A = i2;
    }

    public void setRewardStatus(boolean z2) {
        this.J = z2;
    }

    public void setShowingTransparent(boolean z2) {
        this.D = z2;
    }

    public void setUnitID(String str) {
        this.f11816w = str;
    }

    public void setVideoInteractiveType(int i2) {
        c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            this.f11817x = i2;
            return;
        }
        int iA = com.anythink.expressad.video.dynview.i.c.a(this.b);
        if (iA == 100) {
            this.f11817x = i2;
        } else {
            this.f11817x = iA;
        }
    }

    public void setVideoSkipTime(int i2) {
        this.H = i2;
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean showAlertWebView() {
        AnythinkAlertWebview anythinkAlertWebview = this.f11815v;
        if (anythinkAlertWebview == null || !anythinkAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        if (anythinkClickMiniCardView != null && anythinkClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.f11815v == null) {
            o();
        }
        AnythinkAlertWebview anythinkAlertWebview2 = this.f11815v;
        if (anythinkAlertWebview2 != null && anythinkAlertWebview2.getParent() != null) {
            removeView(this.f11815v);
        }
        addView(this.f11815v);
        setBackgroundColor(0);
        this.f11815v.webviewshow();
        return true;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showEndcard(int i2) {
        c cVar = this.b;
        if (cVar != null) {
            if (i2 == 1) {
                this.f11787e.a(104, "");
            } else if (i2 == 100) {
                if (cVar.J() == 2) {
                    this.E = true;
                }
                a(this.f11807n);
                setMatchParent();
                i();
                o.a(AnythinkBaseView.TAG, "showEndcard addNativeEndcard");
            } else if (i2 == 3) {
                removeAllViews();
                setMatchParent();
                if (this.f11813t == null) {
                    a(this.Q, (Integer) 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.f11813t, layoutParams);
                this.f11813t.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i2 == 4) {
                this.f11787e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.f11814u == null) {
                    a(this.Q, (Integer) 4);
                }
                this.f11814u.setUnitId(this.f11816w);
                this.f11814u.preLoadData(this.Q);
                addView(this.f11814u);
                this.T = true;
                bringToFront();
            } else if (i2 != 5) {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                e();
                this.f11787e.a(117, "");
            } else {
                this.f11787e.a(106, "");
            }
        }
        this.B = true;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showMiniCard(int i2, int i3, int i4, int i5, int i6) {
        AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setMiniCardLocation(i2, i3, i4, i5);
            this.f11809p.setRadius(i6);
            this.f11809p.setCloseVisible(8);
            this.f11809p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
            if (this.G) {
                return;
            }
            this.G = true;
            this.f11787e.a(109, "");
            this.f11787e.a(117, "");
        }
    }

    public void showOrderCampView() {
        this.R = new AnyThinkOrderCampView(this.a);
        this.R.setCampaignExes(this.U);
        a aVar = this.f11787e;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.U);
        }
        this.R.setNotifyListener(new i(this.f11787e));
        this.R.setRewarded(this.J);
        this.R.setNotchPadding(this.K, this.L, this.M, this.N);
        this.R.setCampOrderViewBuildCallback(new com.anythink.expressad.video.dynview.f.b() { // from class: com.anythink.expressad.video.module.AnythinkContainerView.3
            @Override // com.anythink.expressad.video.dynview.f.b
            public final void a() {
                a aVar2 = AnythinkContainerView.this.f11787e;
                if (aVar2 != null) {
                    aVar2.a(117, "");
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.b
            public final void b() {
                if (AnythinkContainerView.this.b.f() == 2) {
                    AnythinkContainerView.this.showVideoEndCover();
                } else {
                    AnythinkContainerView anythinkContainerView = AnythinkContainerView.this;
                    anythinkContainerView.showEndcard(anythinkContainerView.b.F());
                }
            }
        });
        this.R.createView(this);
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showPlayableView() {
        if (this.b == null || this.E) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.f11807n == null) {
            preLoadData(this.Q);
        }
        addView(this.f11807n);
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.f11816w);
            c cVar = this.b;
            if (cVar != null && cVar.H() && this.b.J() == 2) {
                this.f11807n.setCloseVisible(0);
            }
            this.f11807n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoClickView(int i2) {
        if (this.b != null) {
            if (i2 == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                p();
                return;
            }
            if (i2 == 1) {
                if (this.B) {
                    return;
                }
                AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
                if (anythinkH5EndCardView != null && anythinkH5EndCardView.getParent() != null) {
                    removeView(this.f11811r);
                }
                AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
                if (anythinkClickMiniCardView != null && anythinkClickMiniCardView.getParent() != null) {
                    removeView(this.f11809p);
                }
                AnythinkClickCTAView anythinkClickCTAView = this.f11808o;
                if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
                    try {
                        if (this.b != null && this.b.J() == 1) {
                            this.T = true;
                            if (this.f11808o == null) {
                                b(-1);
                            }
                            if (this.f11808o != null && (this.b == null || !this.b.j())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.f11808o, 0, layoutParams);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            AnythinkClickCTAView anythinkClickCTAView2 = this.f11808o;
            if (anythinkClickCTAView2 != null && anythinkClickCTAView2.getParent() != null) {
                removeView(this.f11808o);
            }
            AnythinkAlertWebview anythinkAlertWebview = this.f11815v;
            if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
                AnythinkClickMiniCardView anythinkClickMiniCardView2 = this.f11809p;
                if (anythinkClickMiniCardView2 == null || anythinkClickMiniCardView2.getParent() == null) {
                    try {
                        if (this.b != null && this.b.J() == 1) {
                            setMatchParent();
                            m();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (!miniCardLoaded()) {
                    p();
                    return;
                }
                AnythinkH5EndCardView anythinkH5EndCardView2 = this.f11811r;
                if (anythinkH5EndCardView2 != null && anythinkH5EndCardView2.getParent() != null) {
                    removeView(this.f11811r);
                }
                this.f11787e.a(112, "");
                c cVar = this.b;
                if (cVar != null && !cVar.aw()) {
                    this.b.ax();
                    com.anythink.expressad.video.module.b.a.e(this.a, this.b);
                }
                if (this.D) {
                    this.f11787e.a(115, "");
                } else {
                    this.T = true;
                    bringToFront();
                    webviewshow();
                    onConfigurationChanged(getResources().getConfiguration());
                }
                this.C = true;
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.f11812s;
        if (anythinkVideoEndCoverView == null) {
            b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                this.f11812s = new AnythinkVideoEndCoverView(this.a);
                this.f11812s.setCampaign(this.b);
                this.f11812s.setNotifyListener(new i(this.f11787e));
                this.f11812s.preLoadData(bVar);
            }
        }
        addView(this.f11812s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i2) {
        AnythinkPlayableView anythinkPlayableView = this.f11807n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.toggleCloseBtn(i2);
        }
        AnythinkH5EndCardView anythinkH5EndCardView = this.f11811r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.toggleCloseBtn(i2);
        }
    }

    public void triggerCloseBtn(String str) {
        if (this.b != null) {
            this.f11787e.a(122, "");
            this.f11787e.a(104, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        AnythinkH5EndCardView[] anythinkH5EndCardViewArr = {this.f11807n, this.f11809p, this.f11811r, this.f11815v};
        for (int i2 = 0; i2 < 4; i2++) {
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0 && anythinkH5EndCardView.getParent() != null && !isLast()) {
                anythinkH5EndCardView.webviewshow();
            }
        }
    }

    private boolean a() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
        } else {
            o.d(AnythinkBaseView.TAG, "view is null");
        }
    }

    private static void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void b(b bVar) {
        this.Q = bVar;
        if (this.f11812s == null) {
            this.f11812s = new AnythinkVideoEndCoverView(this.a);
            this.f11812s.setCampaign(this.b);
            this.f11812s.setNotifyListener(new i(this.f11787e));
            this.f11812s.preLoadData(bVar);
        }
    }

    private void a(b bVar) {
        if (this.f11807n == null) {
            this.f11807n = new AnythinkPlayableView(this.a);
        }
        this.f11807n.setCloseDelayShowTime(this.f11819z);
        this.f11807n.setPlayCloseBtnTm(this.A);
        this.f11807n.setCampaign(this.b);
        this.f11807n.setNotifyListener(new AnonymousClass4(this.f11787e));
        this.f11807n.preLoadData(bVar);
    }

    private void b(int i2) {
        if (i2 != -3) {
            if (i2 != -2) {
                if (this.f11808o == null) {
                    this.f11808o = new AnythinkClickCTAView(this.a);
                }
                this.f11808o.setCampaign(this.b);
                this.f11808o.setUnitId(this.f11816w);
                this.f11808o.setNotifyListener(new i(this.f11787e));
                this.f11808o.preLoadData(this.Q);
                return;
            }
            c cVar = this.b;
            if (cVar == null || cVar.F() != 2) {
                return;
            }
            if (this.f11809p == null) {
                this.f11809p = new AnythinkClickMiniCardView(this.a);
            }
            this.f11809p.setCampaign(this.b);
            AnythinkClickMiniCardView anythinkClickMiniCardView = this.f11809p;
            anythinkClickMiniCardView.setNotifyListener(new g(anythinkClickMiniCardView, this.f11787e));
            this.f11809p.preLoadData(this.Q);
            setMatchParent();
            m();
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        a aVar;
        this.Q = bVar;
        c cVar = this.b;
        if (cVar != null) {
            if (num == null) {
                num = Integer.valueOf(cVar.F());
            }
            if (!isLast()) {
                p();
            }
            int iIntValue = num.intValue();
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    if (this.f11813t == null) {
                        this.f11813t = new AnythinkVastEndCardView(this.a);
                    }
                    this.f11813t.setCampaign(this.b);
                    this.f11813t.setNotifyListener(new l(this.f11787e));
                    this.f11813t.preLoadData(bVar);
                    return;
                }
                if (iIntValue == 4) {
                    if (this.f11814u == null) {
                        this.f11814u = new AnythinkLandingPageView(this.a);
                    }
                    this.f11814u.setCampaign(this.b);
                    this.f11814u.setNotifyListener(new i(this.f11787e));
                    return;
                }
                if (iIntValue != 5) {
                    if (this.f11818y == 2) {
                        boolean zJ = this.b.j();
                        boolean zF = t.f(this.b.I());
                        if ((this.b == null || !zJ || zF) && this.b.f() != 2) {
                            if (this.f11811r == null) {
                                this.f11811r = new AnythinkH5EndCardView(this.a);
                            }
                            if (this.b.k() == 5 && (aVar = this.f11787e) != null && (aVar instanceof k)) {
                                ((k) aVar).a(this.b);
                            }
                            this.f11811r.setCampaign(this.b);
                            this.f11811r.setCloseDelayShowTime(this.f11819z);
                            this.f11811r.setNotifyListener(new i(this.f11787e));
                            this.f11811r.setUnitId(this.f11816w);
                            this.f11811r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
                            this.f11811r.preLoadData(bVar);
                            o.a(AnythinkBaseView.TAG, "preload H5Endcard");
                            if (this.D) {
                                return;
                            }
                            o.a(AnythinkBaseView.TAG, "showTransparent = " + this.D + " addview");
                            addView(this.f11811r);
                            return;
                        }
                        return;
                    }
                    c cVar2 = this.b;
                    int iC = (cVar2 == null || cVar2.M() == null) ? 0 : this.b.M().c();
                    AnythinkNativeEndCardView anythinkNativeEndCardView = this.f11810q;
                    if (anythinkNativeEndCardView == null && anythinkNativeEndCardView == null) {
                        if (this.b.j()) {
                            q();
                        } else {
                            this.f11810q = new AnythinkNativeEndCardView(this.a, null, false, -1, this.b.f() == 2, iC, this.b.as());
                            this.f11810q.setCampaign(this.b);
                        }
                    }
                    this.f11810q.setLayout();
                    this.f11810q.setCampaign(this.b);
                    this.f11810q.setUnitId(this.f11816w);
                    this.f11810q.setCloseBtnDelay(this.f11819z);
                    this.f11810q.setNotifyListener(new i(this.f11787e));
                    this.f11810q.preLoadData(bVar);
                    this.f11810q.setNotchPadding(this.K, this.L, this.M, this.N);
                }
            }
        }
    }

    public AnythinkContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11818y = 1;
        this.f11819z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    private void b(AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0) {
                anythinkH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    private void a(a aVar, AnythinkBaseView... anythinkBaseViewArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new g(this.f11809p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    private void a(Configuration configuration, AnythinkBaseView... anythinkBaseViewArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i2];
            if (anythinkBaseView != null && (anythinkBaseView instanceof AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    private void a(AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i2];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0 && anythinkH5EndCardView.getParent() != null && !isLast()) {
                anythinkH5EndCardView.webviewshow();
            }
        }
    }
}
