package com.bytedance.sdk.openadsdk.ls.z;

import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.tb.z.z.z.a;
import com.bytedance.sdk.openadsdk.tb.z.z.z.gc;
import com.bytedance.sdk.openadsdk.tb.z.z.z.m;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public abstract void a(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void dl(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void e(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void fo(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void g(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void gc(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void gz(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void m(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> z(Exception exc);

    public abstract void z(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void z(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public TTAdNative z() {
        return new C0220z(this);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ls.z.z$z, reason: collision with other inner class name */
    public static class C0220z implements TTAdNative {
        private final z z;

        protected C0220z(z zVar) {
            this.z = zVar;
        }

        private ValueSet z(AdSlot adSlot) {
            dl dlVarZ = dl.z(com.bytedance.sdk.openadsdk.ls.z.dl.g.z(adSlot));
            dlVarZ.z(8302, MediationAdClassLoader.getInstance());
            return dlVarZ.g();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.z.z(z(adSlot), new com.bytedance.sdk.openadsdk.tb.z.z.z.g(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    feedAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.z.g(z(adSlot), new com.bytedance.sdk.openadsdk.tb.z.z.z.g(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    feedAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.z.dl(z(adSlot), new com.bytedance.sdk.openadsdk.tb.z.z.z.z(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    drawFeedAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.z.a(z(adSlot), new a(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    nativeAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.z.z(z(adSlot), new g(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairZ = this.z.z(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.ls.z.z.z.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairZ.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairZ.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.z.gc(z(adSlot), new m(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    rewardVideoAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.z.m(z(adSlot), new com.bytedance.sdk.openadsdk.tb.z.z.z.dl(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    fullScreenVideoAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.z.e(z(adSlot), new gc(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    nativeExpressAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.z.gz(z(adSlot), new gc(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    nativeExpressAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.z.fo(z(adSlot), new gc(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairZ = this.z.z(e);
                    nativeExpressAdListener.onError(((Integer) pairZ.first).intValue(), (String) pairZ.second);
                }
            }
        }
    }
}
