package com.anythink.network.toutiao;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TTATNativeExpressHandler {
    static final String a = "TTATNativeExpressHandler";
    final List<TTNativeExpressAd> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<TTNativeExpressAd> f12685c = new ArrayList();

    public interface RenderCallback {
        void onRenderFail(String str, int i2);

        void onRenderSuccess(List<TTNativeExpressAd> list);
    }

    public TTATNativeExpressHandler(List<TTNativeExpressAd> list) {
        this.b = list;
    }

    public void startRender(final RenderCallback renderCallback) {
        final int[] iArr = {this.b.size()};
        for (final TTNativeExpressAd tTNativeExpressAd : this.b) {
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressHandler.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdClicked(View view, int i2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdShow(View view, int i2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderFail(View view, String str, int i2) {
                    String.format("onRenderFail, errorCode: %d, errorMsg: %s", Integer.valueOf(i2), str);
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] == 0) {
                        if (TTATNativeExpressHandler.this.f12685c.size() == 0) {
                            RenderCallback renderCallback2 = renderCallback;
                            if (renderCallback2 != null) {
                                renderCallback2.onRenderFail(str, i2);
                                return;
                            }
                            return;
                        }
                        RenderCallback renderCallback3 = renderCallback;
                        if (renderCallback3 != null) {
                            renderCallback3.onRenderSuccess(TTATNativeExpressHandler.this.f12685c);
                        }
                        TTATNativeExpressHandler.this.f12685c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderSuccess(View view, float f2, float f3) {
                    TTATNativeExpressHandler.this.f12685c.add(tTNativeExpressAd);
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] == 0) {
                        RenderCallback renderCallback2 = renderCallback;
                        if (renderCallback2 != null) {
                            renderCallback2.onRenderSuccess(TTATNativeExpressHandler.this.f12685c);
                        }
                        TTATNativeExpressHandler.this.f12685c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }
            });
            tTNativeExpressAd.render();
        }
    }
}
