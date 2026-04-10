package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.g.c {
    private long VJ;
    private com.kwad.components.core.widget.kwai.b bY;
    private com.kwad.sdk.core.g.b cb;
    public AdInfo mAdInfo;

    @NonNull
    public T mAdTemplate;

    @NonNull
    public Context mContext;
    protected boolean mK;
    private bg mTimerHelper;
    public InterfaceC0422b oJ;

    public static class a implements InterfaceC0422b {
        @Override // com.kwad.components.core.widget.b.InterfaceC0422b
        public void onAdClicked() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0422b
        public void onAdShow() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0422b
        public final void onDislikeClicked() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0422b
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0422b
        public final void onDownloadTipsDialogShow() {
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0422b {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.uT() && com.kwad.sdk.core.config.d.uS() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0421a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void eM() {
                    b bVar = b.this;
                    if (bVar.mAdTemplate.mPvReported && bVar.mK) {
                        long jEV = bVar.getTimerHelper().EV();
                        b.this.VJ += jEV;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, jEV, (JSONObject) null);
                        b.this.mK = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void k(View view) {
                    b bVar = b.this;
                    if (!bVar.mAdTemplate.mPvReported && bVar.oJ != null) {
                        bVar.mK = true;
                        bVar.bC();
                        b.this.getTimerHelper().startTiming();
                    }
                    b bVar2 = b.this;
                    if (!bVar2.mK) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.mK = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0421a
                public final void onViewDetached() {
                    b bVar = b.this;
                    if (bVar.mAdTemplate.mPvReported && bVar.mK) {
                        long jEV = bVar.getTimerHelper().EV();
                        b.this.VJ += jEV;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, jEV, (JSONObject) null);
                        b.this.mK = false;
                    }
                }
            });
            aVar.rK();
            return;
        }
        c cVarB = b(viewGroup);
        if (cVarB == null) {
            cVarB = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarB);
        }
        cVarB.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                b.this.bC();
            }
        });
        cVarB.setNeedCheckingShow(true);
    }

    private static c b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bk();
        this.bY = new com.kwad.components.core.widget.kwai.b(this, 70);
        a((ViewGroup) this);
    }

    public final void aH(int i2) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, getTouchCoords());
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onAdClicked();
        }
    }

    public void aS() {
    }

    public void aT() {
    }

    protected void bC() {
        InterfaceC0422b interfaceC0422b;
        if (!this.mAdTemplate.mPvReported && (interfaceC0422b = this.oJ) != null) {
            interfaceC0422b.onAdShow();
        }
        i iVar = new i();
        y.a aVar = new y.a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        aVar.templateId = String.valueOf(feedTypeFromInt.getType());
        iVar.a(aVar);
        iVar.p(getHeight(), getWidth());
        com.kwad.components.core.r.c.qa().a(this.mAdTemplate, null, iVar);
    }

    public void bindView(@NonNull T t2) {
        this.mAdTemplate = t2;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(t2);
    }

    protected abstract void bk();

    public void bn() {
    }

    public final void c(@NonNull i iVar) {
        iVar.c(getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar, (JSONObject) null);
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onAdClicked();
        }
    }

    public final void eh() {
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onAdClicked();
        }
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public long getStayTime() {
        return this.VJ + getTimerHelper().getTime();
    }

    public bg getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bg();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        this.bY.a(this);
        this.bY.a(this.cb);
        this.bY.rU();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        this.bY.b(this);
        this.bY.rV();
        bn();
    }

    public final void rL() {
        com.kwad.sdk.core.report.a.aq(this.mAdTemplate);
        InterfaceC0422b interfaceC0422b = this.oJ;
        if (interfaceC0422b != null) {
            interfaceC0422b.onDislikeClicked();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC0422b interfaceC0422b) {
        this.oJ = interfaceC0422b;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.cb = bVar;
    }
}
