package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.dynview.f.b;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.module.AnythinkBaseView;
import com.anythink.expressad.widget.FeedBackButton;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkOrderCampView extends AnythinkBaseView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AnyThinkOrderCampView f11749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<c> f11750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11751p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f11753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11754s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f11755t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FeedBackButton f11756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f11757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.anythink.expressad.video.dynview.f.c f11759x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private b f11760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f11761z;

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass3() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView$4, reason: invalid class name */
    final class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ String a;

        AnonymousClass4(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.a(((AnythinkBaseView) AnyThinkOrderCampView.this).a, this.a);
        }
    }

    public AnyThinkOrderCampView(Context context) {
        super(context);
        this.f11758w = false;
        this.f11759x = new com.anythink.expressad.video.dynview.f.c() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.1
            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a(c cVar, int i2) {
                if (cVar != null) {
                    try {
                        AnyThinkOrderCampView.this.setCampaign(cVar);
                        AnyThinkOrderCampView.a(AnyThinkOrderCampView.this, cVar, i2);
                    } catch (Exception e2) {
                        o.d(AnythinkBaseView.TAG, e2.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a() {
                AnyThinkOrderCampView.a(AnyThinkOrderCampView.this);
            }
        };
        this.f11761z = false;
    }

    private void e() {
        FeedBackButton feedBackButton = this.f11756u;
        if (feedBackButton == null) {
            return;
        }
        List<c> list = this.f11750o;
        if (list == null) {
            feedBackButton.setVisibility(8);
            return;
        }
        if (list.get(0) == null) {
            this.f11756u.setVisibility(8);
            return;
        }
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            this.f11756u.setVisibility(8);
            return;
        }
        this.f11755t = this.f11750o.get(0).K();
        this.b = this.f11750o.get(0);
        com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", new AnonymousClass3());
        com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", this.b);
        com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", this.f11756u);
    }

    private void f() {
        if (this.f11757v == null) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
        if (aVarB == null) {
            this.f11757v.setVisibility(8);
            return;
        }
        String strJ = aVarB.J();
        if (TextUtils.isEmpty(strJ)) {
            this.f11757v.setVisibility(8);
        }
        this.f11757v.setOnClickListener(new AnonymousClass4(strJ));
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.f11750o == null) {
            b bVar = this.f11760y;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put(com.anythink.expressad.video.dynview.a.a.E, this.f11759x);
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c cVarB = com.anythink.expressad.video.dynview.j.c.b(n.a().g(), this.f11750o);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(cVarB, new h() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.2
            @Override // com.anythink.expressad.video.dynview.f.h
            public final void a(com.anythink.expressad.video.dynview.a aVar) {
                try {
                    AnyThinkOrderCampView.this.f11749n.addView(aVar.a());
                    AnyThinkOrderCampView.this.f11758w = aVar.c();
                    viewGroup.removeAllViews();
                    viewGroup.addView(AnyThinkOrderCampView.this.f11749n);
                    AnyThinkOrderCampView.this.setViewStatus();
                    if (AnyThinkOrderCampView.this.f11760y != null) {
                        AnyThinkOrderCampView.this.f11760y.a();
                    }
                } catch (Exception e2) {
                    o.d(AnythinkBaseView.TAG, e2.getMessage());
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.h
            public final void a(com.anythink.expressad.video.dynview.c.b bVar2) {
                try {
                    if (AnyThinkOrderCampView.this.f11760y != null) {
                        AnyThinkOrderCampView.this.f11760y.b();
                    }
                } catch (Exception e2) {
                    o.d(AnythinkBaseView.TAG, e2.getMessage());
                }
            }
        }, map);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        this.f11749n = this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        JSONObject jSONObject;
        JSONException e2;
        super.onAttachedToWindow();
        if (this.f11750o == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f11750o.size(); i2++) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e3) {
                jSONObject = null;
                e2 = e3;
            }
            try {
                jSONObject.put("camp_position", i2);
            } catch (JSONException e4) {
                e2 = e4;
                e2.printStackTrace();
            }
            com.anythink.expressad.video.module.a.a aVar = this.f11787e;
            if (aVar != null) {
                aVar.a(110, jSONObject);
            }
        }
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.f11760y = bVar;
    }

    public void setCampaignExes(List<c> list) {
        this.f11750o = list;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        this.f11751p = i2;
        this.f11752q = i3;
        this.f11753r = i4;
        this.f11754s = i5;
        setViewStatus();
    }

    public void setRewarded(boolean z2) {
        this.f11761z = z2;
    }

    public void setViewStatus() {
        AnyThinkOrderCampView anyThinkOrderCampView = this.f11749n;
        if (anyThinkOrderCampView == null || !this.f11761z) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) anyThinkOrderCampView.findViewById(filterFindViewId(this.f11758w, "anythink_native_order_camp_controller"));
        this.f11756u = (FeedBackButton) this.f11749n.findViewById(filterFindViewId(this.f11758w, "anythink_native_order_camp_feed_btn"));
        this.f11757v = (ImageView) this.f11749n.findViewById(filterFindViewId(this.f11758w, "anythink_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.f11751p, this.f11753r, this.f11752q, this.f11754s);
        }
        FeedBackButton feedBackButton = this.f11756u;
        if (feedBackButton != null && feedBackButton != null) {
            try {
                if (this.f11750o == null) {
                    feedBackButton.setVisibility(8);
                } else if (this.f11750o.get(0) != null && com.anythink.expressad.foundation.f.b.a().b()) {
                    this.f11755t = this.f11750o.get(0).K();
                    this.b = this.f11750o.get(0);
                    com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", new AnonymousClass3());
                    com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", this.b);
                    com.anythink.expressad.foundation.f.b.a().a(this.f11755t + "_2", this.f11756u);
                } else {
                    this.f11756u.setVisibility(8);
                }
            } catch (Exception e2) {
                o.d(AnythinkBaseView.TAG, e2.getMessage());
            }
        }
        ImageView imageView = this.f11757v;
        if (imageView == null || imageView == null) {
            return;
        }
        try {
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
            if (aVarB == null) {
                this.f11757v.setVisibility(8);
                return;
            }
            String strJ = aVarB.J();
            if (TextUtils.isEmpty(strJ)) {
                this.f11757v.setVisibility(8);
            }
            this.f11757v.setOnClickListener(new AnonymousClass4(strJ));
        } catch (Exception e3) {
            o.d(AnythinkBaseView.TAG, e3.getMessage());
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.f11749n.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.f11749n.startAnimation(translateAnimation);
    }

    private void a(c cVar, int i2, int i3) {
        JSONObject jSONObject;
        JSONException e2;
        if (cVar != null && cVar.j()) {
            try {
                c.C0205c c0205cM = cVar.M();
                if (c0205cM != null) {
                    new StringBuilder().append(c0205cM.b());
                }
            } catch (Exception e3) {
                o.d(AnythinkBaseView.TAG, e3.getMessage());
            }
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e4) {
            jSONObject = null;
            e2 = e4;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i2));
            jSONObject.put("camp_position", i3);
        } catch (JSONException e5) {
            e2 = e5;
            e2.printStackTrace();
        }
        com.anythink.expressad.video.module.a.a aVar = this.f11787e;
        if (aVar != null) {
            aVar.a(105, jSONObject);
        }
    }

    private void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
        scaleAnimation.setDuration(500L);
        this.f11749n.startAnimation(scaleAnimation);
    }

    public AnyThinkOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11758w = false;
        this.f11759x = new com.anythink.expressad.video.dynview.f.c() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.1
            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a(c cVar, int i2) {
                if (cVar != null) {
                    try {
                        AnyThinkOrderCampView.this.setCampaign(cVar);
                        AnyThinkOrderCampView.a(AnyThinkOrderCampView.this, cVar, i2);
                    } catch (Exception e2) {
                        o.d(AnythinkBaseView.TAG, e2.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a() {
                AnyThinkOrderCampView.a(AnyThinkOrderCampView.this);
            }
        };
        this.f11761z = false;
    }

    private void a() {
        com.anythink.expressad.video.module.a.a aVar = this.f11787e;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    static /* synthetic */ void a(AnyThinkOrderCampView anyThinkOrderCampView, c cVar, int i2) {
        JSONObject jSONObject;
        JSONException e2;
        if (cVar != null && cVar.j()) {
            try {
                c.C0205c c0205cM = cVar.M();
                if (c0205cM != null) {
                    new StringBuilder().append(c0205cM.b());
                }
            } catch (Exception e3) {
                o.d(AnythinkBaseView.TAG, e3.getMessage());
            }
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e4) {
            jSONObject = null;
            e2 = e4;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anyThinkOrderCampView.a(0));
            jSONObject.put("camp_position", i2);
        } catch (JSONException e5) {
            e2 = e5;
            e2.printStackTrace();
        }
        com.anythink.expressad.video.module.a.a aVar = anyThinkOrderCampView.f11787e;
        if (aVar != null) {
            aVar.a(105, jSONObject);
        }
    }

    static /* synthetic */ void a(AnyThinkOrderCampView anyThinkOrderCampView) {
        com.anythink.expressad.video.module.a.a aVar = anyThinkOrderCampView.f11787e;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }
}
