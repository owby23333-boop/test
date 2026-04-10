package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.j.c {
    public a aig;
    private long aih;
    private com.kwad.sdk.core.j.b dn;
    private com.kwad.components.core.widget.a.b fg;
    public AdInfo mAdInfo;
    protected T mAdResultData;
    public R mAdTemplate;
    public Context mContext;
    private bv mTimerHelper;
    protected boolean oR;

    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public void bt() {
    }

    public void bu() {
    }

    protected abstract void bw();

    public void cq() {
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    static /* synthetic */ long a(b bVar, long j) {
        long j2 = bVar.aih + j;
        bVar.aih = j2;
        return j2;
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        if (com.kwad.sdk.core.config.e.Gh()) {
            return;
        }
        setBackgroundColor(-1);
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bw();
        this.fg = new com.kwad.components.core.widget.a.b(this, 70);
    }

    public final boolean fq() {
        return (this.mAdInfo.status == 2 || this.mAdInfo.status == 3) ? false : true;
    }

    public void d(T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.b.c.r(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(r);
        a(this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ab() {
        super.ab();
        this.fg.wj();
        this.fg.b(this);
        cq();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        this.fg.a(this);
        this.fg.a(this.dn);
        this.fg.wi();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.aig = aVar;
    }

    public void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    public bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bv();
        }
        return this.mTimerHelper;
    }

    public long getStayTime() {
        return this.aih + getTimerHelper().getTime();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.e.FK() && com.kwad.sdk.core.config.e.FJ() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0364a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void aa() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void onWindowFocusChanged(boolean z) {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void ab() {
                    if (b.this.mAdTemplate.mPvReported && b.this.oR) {
                        long jSn = b.this.getTimerHelper().Sn();
                        b.a(b.this, jSn);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jSn, (JSONObject) null);
                        b.this.oR = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void c(View view) {
                    if (!b.this.mAdTemplate.mPvReported && b.this.aig != null) {
                        b.this.oR = true;
                        b.this.W();
                        b.this.getTimerHelper().startTiming();
                    }
                    if (!b.this.oR) {
                        b.this.getTimerHelper().startTiming();
                    }
                    b.this.oR = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0364a
                public final void ay() {
                    if (b.this.mAdTemplate.mPvReported && b.this.oR) {
                        long jSn = b.this.getTimerHelper().Sn();
                        b.a(b.this, jSn);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jSn, (JSONObject) null);
                        b.this.oR = false;
                    }
                }
            });
            aVar.vU();
            return;
        }
        c cVarB = b(viewGroup);
        if (cVarB == null) {
            cVarB = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarB);
        }
        cVarB.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void fs() {
                b.this.W();
            }
        });
        cVarB.setNeedCheckingShow(true);
    }

    private static c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    protected void W() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aig) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0392a c0392a = new a.C0392a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0392a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0392a.awW = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        bVar.b(c0392a);
        bVar.w(getHeight(), getWidth());
        com.kwad.components.core.t.b.sY().a(this.mAdTemplate, null, bVar);
    }

    public final void c(com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void vV() {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void ba(int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.mI = i;
        a.C0392a c0392a = new a.C0392a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        c0392a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0392a.awW = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        aVar.Pk = c0392a;
        if (this.mAdTemplate.swipeAngle != 0) {
            aVar.ayv = this.mAdTemplate.swipeAngle;
        }
        if (getTouchCoords() != null) {
            aVar.mK = getTouchCoords();
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, aVar, (JSONObject) null);
        a aVar2 = this.aig;
        if (aVar2 != null) {
            aVar2.onAdClicked();
        }
    }

    public final void vW() {
        com.kwad.sdk.core.adlog.c.bR(this.mAdTemplate);
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }
}
