package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATNativeExpressAd extends CustomNativeAd {
    NativeExpressAD a;
    NativeExpressADView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f12455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12456d;

    protected GDTATNativeExpressAd(Context context, String str, int i2, int i3, int i4, int i5, int i6, String str2) {
        int iA;
        int iA2;
        this.f12456d = str2;
        NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClicked(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClosed(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADExposure(NativeExpressADView nativeExpressADView) {
                GDTATInitManager.getInstance().a(GDTATNativeExpressAd.this.getShowId(), new WeakReference(GDTATNativeExpressAd.this.b));
                GDTATNativeExpressAd.this.notifyAdImpression();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLoaded(List<NativeExpressADView> list) {
                if (list.size() > 0) {
                    NativeExpressADView nativeExpressADView = list.get(0);
                    GDTATNativeExpressAd.this.setNetworkInfoMap(nativeExpressADView.getExtraInfo());
                    nativeExpressADView.render();
                } else {
                    a aVar = GDTATNativeExpressAd.this.f12455c;
                    if (aVar != null) {
                        aVar.notifyError("", "GDT Ad request success but no Ad return.");
                    }
                    GDTATNativeExpressAd.this.f12455c = null;
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public final void onNoAD(AdError adError) {
                a aVar = GDTATNativeExpressAd.this.f12455c;
                if (aVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(adError.getErrorCode());
                    aVar.notifyError(sb.toString(), adError.getErrorMsg());
                }
                GDTATNativeExpressAd.this.f12455c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderFail(NativeExpressADView nativeExpressADView) {
                a aVar = GDTATNativeExpressAd.this.f12455c;
                if (aVar != null) {
                    aVar.notifyError("", "GDT onRenderFail");
                }
                GDTATNativeExpressAd.this.f12455c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd gDTATNativeExpressAd = GDTATNativeExpressAd.this;
                gDTATNativeExpressAd.b = nativeExpressADView;
                AdData boundData = gDTATNativeExpressAd.b.getBoundData();
                if (boundData != null) {
                    if (boundData.getAdPatternType() == 2) {
                        ((com.anythink.nativead.unitgroup.a) GDTATNativeExpressAd.this).mAdSourceType = "1";
                    } else {
                        ((com.anythink.nativead.unitgroup.a) GDTATNativeExpressAd.this).mAdSourceType = "2";
                    }
                }
                GDTATNativeExpressAd.this.setVideoDuration(boundData != null ? boundData.getVideoDuration() / 1000 : PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                GDTATNativeExpressAd.this.b.setMediaListener(new NativeExpressMediaListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1.1
                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                        GDTATNativeExpressAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                        GDTATNativeExpressAd gDTATNativeExpressAd2 = GDTATNativeExpressAd.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(adError.getErrorCode());
                        gDTATNativeExpressAd2.notifyAdVideoVideoPlayFail(sb.toString(), adError.getErrorMsg());
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoPause(NativeExpressADView nativeExpressADView2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoReady(NativeExpressADView nativeExpressADView2, long j2) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public final void onVideoStart(NativeExpressADView nativeExpressADView2) {
                        GDTATNativeExpressAd.this.notifyAdVideoStart();
                    }
                });
                GDTATNativeExpressAd gDTATNativeExpressAd2 = GDTATNativeExpressAd.this;
                a aVar = gDTATNativeExpressAd2.f12455c;
                if (aVar != null) {
                    aVar.notifyLoaded(gDTATNativeExpressAd2);
                }
                GDTATNativeExpressAd.this.f12455c = null;
            }
        };
        if (i2 > 0) {
            GDTATInitManager.getInstance();
            iA = GDTATInitManager.a(context, i2);
        } else {
            iA = -1;
        }
        if (i3 > 0) {
            GDTATInitManager.getInstance();
            iA2 = GDTATInitManager.a(context, i3);
        } else {
            iA2 = -2;
        }
        if (TextUtils.isEmpty(str2)) {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, nativeExpressADListener);
        } else {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, nativeExpressADListener, str2);
        }
        this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i4 == 1).setDetailPageMuted(i4 == 1).setAutoPlayPolicy(i5).build());
        if (i6 != -1) {
            this.a.setMaxVideoDuration(i6);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(null);
            this.b.destroy();
        }
        this.b = null;
        this.f12455c = null;
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        return this.b;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.2
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i2;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    GDTATNativeExpressAd.this.notifyDownloadConfirm(activity, null, gDTDownloadFirmInfo);
                }
            });
        }
    }

    protected final void a(a aVar, LoadAdParams loadAdParams) {
        this.f12455c = aVar;
        if (TextUtils.isEmpty(this.f12456d)) {
            this.a.loadAD(1, loadAdParams);
        } else {
            this.a.loadAD(1);
        }
    }
}
