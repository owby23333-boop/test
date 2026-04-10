package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes10.dex */
public class bf implements TTNativeExpressAd.ExpressAdInteractionListener {
    public e bf;
    public int d;
    public TTNativeExpressAd.ExpressAdInteractionListener e;

    public interface e {
        void e(int i);
    }

    public bf(e eVar, int i, TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.e = expressAdInteractionListener;
        this.bf = eVar;
        this.d = i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.e;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdClicked(view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.e;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdShow(view, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        e eVar = this.bf;
        if (eVar != null) {
            eVar.e(this.d);
        }
    }
}
