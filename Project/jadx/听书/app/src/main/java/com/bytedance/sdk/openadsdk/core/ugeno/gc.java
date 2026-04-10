package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.g.a;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kb;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static void z() {
        com.bytedance.adsdk.ugeno.a.z().z(zw.getContext(), new com.bytedance.adsdk.ugeno.dl.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1
            @Override // com.bytedance.adsdk.ugeno.dl.dl
            public List<com.bytedance.adsdk.ugeno.dl.g> z() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("View") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.1
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("CustomComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.12
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Text") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.23
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Image") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.33
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.image.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("UpieImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.34
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.dl.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("FlexLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.35
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.flexbox.gc(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("FrameLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.36
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("InteractContainerView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.37
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new kb(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("ScrollLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.38
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.scroll.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RichText") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.2
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Input") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.3
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.input.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Dislike") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.4
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.dislike.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RatingBar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.5
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RatingStar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.6
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("UgenProgressView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.7
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("ProgressButton") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.8
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Button") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.9
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.z.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.10
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.g.m(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Video") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.11
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Gif") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.13
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.14
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.a.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.15
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("InterLottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.16
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.17
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new wp(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("WebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.18
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Blur") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.19
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.20
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("FVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.21
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.22
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("CycleCountDownView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.24
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("CycleSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.25
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RewardClickCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.26
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.a(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("Icon") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.27
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.z.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("FVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.28
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("RVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.29
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("VideoV3") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.30
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.a.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("PlayableComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.31
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.dl.g("CsjRefreshTip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.1.32
                    @Override // com.bytedance.adsdk.ugeno.dl.g
                    public com.bytedance.adsdk.ugeno.g.dl z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.dl(context);
                    }
                });
                return arrayList;
            }
        }, new a());
        com.bytedance.adsdk.ugeno.a.z().z(new com.bytedance.adsdk.ugeno.gc.gz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.2
            @Override // com.bytedance.adsdk.ugeno.gc.gz
            public List<com.bytedance.adsdk.ugeno.gc.e> z() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.gc.e("shake") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.2.1
                    @Override // com.bytedance.adsdk.ugeno.gc.e
                    public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.g.z(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.gc.e("twist") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.2.2
                    @Override // com.bytedance.adsdk.ugeno.gc.e
                    public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.g.g(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.gc.e("videoProgress") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.2.3
                    @Override // com.bytedance.adsdk.ugeno.gc.e
                    public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.g.dl(context);
                    }
                });
                return arrayList;
            }
        });
        com.bytedance.adsdk.ugeno.a.z().z(new com.bytedance.adsdk.g.dl());
        com.bytedance.adsdk.ugeno.a.z().z(new com.bytedance.adsdk.ugeno.dl.g.a() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.3
            @Override // com.bytedance.adsdk.ugeno.dl.g.a
            public a.z z(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar) {
                return new m(context, dlVar);
            }
        });
        com.bytedance.adsdk.ugeno.a.z().z(new com.bytedance.adsdk.ugeno.dl.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.4
            @Override // com.bytedance.adsdk.ugeno.dl.z.z
            public com.bytedance.adsdk.ugeno.dl.z.g z(fv fvVar) {
                return new fo(fvVar);
            }
        });
        com.bytedance.adsdk.ugeno.a.z().z(new com.bytedance.adsdk.ugeno.gc.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.5
            @Override // com.bytedance.adsdk.ugeno.gc.dl
            public List<com.bytedance.adsdk.ugeno.gc.g> z() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.gc.g("interactiveFinish") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.5.1
                    @Override // com.bytedance.adsdk.ugeno.gc.g
                    public com.bytedance.adsdk.ugeno.gc.g.z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
                        return new com.bytedance.adsdk.ugeno.gc.g.dl(dlVar, str, zVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.gc.g("nextVideoCancel") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gc.5.2
                    @Override // com.bytedance.adsdk.ugeno.gc.g
                    public com.bytedance.adsdk.ugeno.gc.g.z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
                        return new com.bytedance.adsdk.ugeno.gc.g.dl(dlVar, str, zVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
