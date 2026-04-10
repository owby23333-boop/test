package com.kuaishou.pushad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.core.webview.c.a.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes2.dex */
public class PushAdView extends KSFrameLayout implements h {
    public static String PUSH_VIEW_TAG = "PUSH_VIEW_TAG";
    private static final String TAG = "PushAdView";
    private ae mCardLifecycleHandler;
    private AdTemplate mPushAd;
    private PushAdListener mPushAdListener;
    private g mTKLoadController;
    private boolean mTKLoadSuccess;

    public interface PushAdListener {
        void onPushAdViewClose();

        void onPushAdViewShow();
    }

    public PushAdView(@NonNull Context context) {
        super(context);
        this.mTKLoadSuccess = false;
        init(context, null, 0);
    }

    public PushAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, 0);
    }

    public PushAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, i2);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        setTag(PUSH_VIEW_TAG);
    }

    private void notifyPushAdClose() {
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rt();
            this.mCardLifecycleHandler.ru();
        }
    }

    private void notifyPushAdShow() {
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rr();
            this.mCardLifecycleHandler.rs();
        }
    }

    public void bindView(AdTemplate adTemplate) {
        this.mPushAd = adTemplate;
        this.mTKLoadController = new g(-1L, getContext()) { // from class: com.kuaishou.pushad.PushAdView.1
            @Override // com.kwad.components.core.webview.a.g
            public void onRegisterWebCardHandler(b bVar, c cVar, l lVar, ViewGroup viewGroup) {
                super.onRegisterWebCardHandler(bVar, cVar, lVar, viewGroup);
                lVar.c(new com.kwad.components.core.webview.jshandler.g(bVar, cVar, this));
            }
        };
        this.mTKLoadController.bind(null, adTemplate, this);
    }

    public void destroy() {
        this.mTKLoadController.unBind();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.a.h
    public String getTkTemplateId() {
        return i.b("ksad-push-card", this.mPushAd);
    }

    @Override // com.kwad.components.core.webview.a.h
    public e getTouchCoordsView() {
        return this;
    }

    public boolean isTKLoadSuccess() {
        return this.mTKLoadSuccess;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onAdClicked(@Nullable a aVar) {
        com.kwad.sdk.core.d.b.d(TAG, "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        float screenHeight = com.kwad.sdk.b.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((screenHeight / fAG) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterLifecycleLisener(ae aeVar) {
        this.mCardLifecycleHandler = aeVar;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, b bVar) {
    }

    public boolean onShow() {
        if (!this.mTKLoadSuccess || this.mPushAd == null) {
            return false;
        }
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewShow();
        }
        notifyPushAdShow();
        return true;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onSkipClick(s sVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onTkLoadFailed() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadFailed");
        this.mTKLoadSuccess = false;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onTkLoadSuccess() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadSuccess");
        this.mTKLoadSuccess = true;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void pageClose(WebCloseStatus webCloseStatus) {
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewClose();
        }
        notifyPushAdClose();
    }

    public void setListener(PushAdListener pushAdListener) {
        this.mPushAdListener = pushAdListener;
    }
}
