package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
final class mb implements TTAdManager {
    static final mb mb = new mb();
    private volatile TTAdManager ox;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.plugin.mb$1, reason: invalid class name */
    class AnonymousClass1 implements ox<TTAdNative> {
        TTAdNative mb;
        final /* synthetic */ WeakReference ox;

        AnonymousClass1(WeakReference weakReference) {
            this.ox = weakReference;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.ox
        public void mb(final InterfaceC0308mb<TTAdNative> interfaceC0308mb) {
            TTAdNative tTAdNative = this.mb;
            if (tTAdNative != null) {
                interfaceC0308mb.mb(tTAdNative);
            } else {
                mb.this.call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                    public void mb(TTAdManager tTAdManager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.mb = tTAdManager.createAdNative((Context) anonymousClass1.ox.get());
                        interfaceC0308mb.mb(AnonymousClass1.this.mb);
                    }
                });
            }
        }
    }

    private interface b<T> extends InterfaceC0308mb<T> {
        void mb();
    }

    private static final class hj implements TTAdNative {
        private ox<TTAdNative> mb;

        public hj(ox<TTAdNative> oxVar) {
            this.mb = oxVar;
        }

        private final void mb(CommonListener commonListener, InterfaceC0308mb<TTAdNative> interfaceC0308mb) {
            try {
                this.mb.mb(interfaceC0308mb);
            } catch (Throwable th) {
                if (commonListener != null) {
                    commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadBannerExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            mb(drawFeedAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.6
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadDrawFeedAd(adSlot, drawFeedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.3
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadExpressDrawFeedAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            mb(feedAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.1
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadFeedAd(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            mb(fullScreenVideoAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.12
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadFullScreenVideoAd(adSlot, fullScreenVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
            mb(nativeAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.7
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeAd(adSlot, nativeAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(final AdSlot adSlot, final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            mb(nativeExpressAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.2
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadNativeExpressAd(adSlot, nativeExpressAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(final AdSlot adSlot, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            mb(rewardVideoAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.11
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadRewardVideoAd(adSlot, rewardVideoAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, final int i2) {
            mb(splashAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.8
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener, i2);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
            mb(feedAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.5
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadStream(adSlot, feedAdListener);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.CSJSplashAdListener cSJSplashAdListener, final int i2) {
            mb(cSJSplashAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.9
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, cSJSplashAdListener, i2);
                }
            });
        }

        private final void mb(TTAdNative.CSJSplashAdListener cSJSplashAdListener, InterfaceC0308mb<TTAdNative> interfaceC0308mb) {
            try {
                this.mb.mb(interfaceC0308mb);
            } catch (Throwable th) {
                if (cSJSplashAdListener != null) {
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError(4202, "Load ad failed: " + th.getMessage()));
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
            mb(splashAdListener, new InterfaceC0308mb<TTAdNative>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.hj.10
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdNative tTAdNative) {
                    tTAdNative.loadSplashAd(adSlot, splashAdListener);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.plugin.mb$mb, reason: collision with other inner class name */
    private interface InterfaceC0308mb<T> {
        void mb(T t2);
    }

    private interface ox<T> {
        void mb(InterfaceC0308mb<T> interfaceC0308mb);
    }

    mb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(final InterfaceC0308mb<TTAdManager> interfaceC0308mb) {
        if (this.ox == null) {
            ScheduledExecutorService scheduledExecutorService = ko.mb;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (mb.this.ox != null) {
                                interfaceC0308mb.mb(mb.this.ox);
                                return;
                            }
                            if (interfaceC0308mb instanceof b) {
                                ((b) interfaceC0308mb).mb();
                            }
                            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Not ready, no manager");
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                            u.mb(th);
                        }
                    }
                });
                return;
            } else {
                com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Not ready, no executor");
                return;
            }
        }
        try {
            interfaceC0308mb.mb(this.ox);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.hj("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
            u.mb(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new hj(new AnonymousClass1(new WeakReference(context)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (this.ox != null) {
            return this.ox.getBiddingToken(adSlot);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
        if (this.ox != null) {
            return (T) this.ox.getExtra(cls, bundle);
        }
        if (cls == Bundle.class && bundle != null && bundle.getInt(NativeAdvancedJsUtils.f8246p, 0) == 1) {
            call(new b<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.4
                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.b
                public void mb() {
                    com.bytedance.sdk.openadsdk.api.plugin.hj.mb(bundle);
                }

                @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
                public void mb(TTAdManager tTAdManager) {
                    tTAdManager.getExtra(cls, bundle);
                }
            });
            return null;
        }
        call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.5
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.getExtra(cls, bundle);
            }
        });
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.ox != null ? this.ox.getPluginVersion() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "5.1.0.2";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        if (this.ox != null) {
            return this.ox.getThemeStatus();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(final Object obj) {
        final Object objMb;
        if (obj instanceof TTPluginListener) {
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            objMb = u.mb(TTAppContextHolder.getContext()).mb(tTPluginListener.packageName(), tTPluginListener.config());
        } else {
            objMb = obj;
        }
        call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.2
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.register(objMb);
                if (obj instanceof TTPluginListener) {
                    u.mb(TTAppContextHolder.getContext()).mb((TTPluginListener) obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(final Context context) {
        call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.6
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.requestPermissionIfNecessary(context);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(final int i2) {
        call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.7
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
            public void mb(TTAdManager tTAdManager) {
                mb.this.ox.setThemeStatus(i2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.ox != null && this.ox.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(final Object obj) {
        call(new InterfaceC0308mb<TTAdManager>() { // from class: com.bytedance.sdk.openadsdk.api.plugin.mb.3
            @Override // com.bytedance.sdk.openadsdk.api.plugin.mb.InterfaceC0308mb
            public void mb(TTAdManager tTAdManager) {
                tTAdManager.unregister(obj);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z2, int i2) {
        if (this.ox != null) {
            return this.ox.getBiddingToken(adSlot, z2, i2);
        }
        return null;
    }

    public void mb(TTAdManager tTAdManager) {
        this.ox = tTAdManager;
    }
}
