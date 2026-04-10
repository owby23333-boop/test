package com.amgcyo.cuttadon.h.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.sdk.gdt_new.view.GdtFeedNativeBigAdView;
import com.amgcyo.cuttadon.sdk.gdt_new.view.GdtFeedNativeSmallAdView;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: compiled from: GdtNewAdTools.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: compiled from: GdtNewAdTools.java */
    class a implements NativeADUnifiedListener {
        final /* synthetic */ AdFrameLayout a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f3873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ NormalAdParams f3875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3877g;

        a(AdFrameLayout adFrameLayout, int i2, Context context, String str, NormalAdParams normalAdParams, String str2, String str3) {
            this.a = adFrameLayout;
            this.b = i2;
            this.f3873c = context;
            this.f3874d = str;
            this.f3875e = normalAdParams;
            this.f3876f = str2;
            this.f3877g = str3;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (g.a(list)) {
                onNoAD(new AdError(-1, "加载成功，但是没有广告返回"));
                return;
            }
            if (this.a.getChildCount() > 0) {
                this.a.removeAllViews();
            }
            NativeUnifiedADData nativeUnifiedADData = list.get(0);
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            int i2 = this.b;
            if (i2 == 1 || i2 == 4) {
                GdtFeedNativeSmallAdView gdtFeedNativeSmallAdView = new GdtFeedNativeSmallAdView(this.f3873c);
                gdtFeedNativeSmallAdView.setGdtNewFeedNativeData(nativeUnifiedADData);
                this.a.addView(gdtFeedNativeSmallAdView);
                this.a.setDislikeImagview(this.f3874d);
            } else if (i2 == 5) {
                GdtFeedNativeBigAdView gdtFeedNativeBigAdView = new GdtFeedNativeBigAdView(this.f3873c);
                gdtFeedNativeBigAdView.setGdtNewFeedNativeData(nativeUnifiedADData);
                this.a.addView(gdtFeedNativeBigAdView);
                this.a.setDislikeImagview(this.f3874d);
            }
            com.amgcyo.cuttadon.h.a.c.c(this.f3874d);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            int errorCode;
            String errorMsg;
            if (adError != null) {
                errorCode = adError.getErrorCode();
                errorMsg = adError.getErrorMsg();
            } else {
                errorCode = -1;
                errorMsg = "onNoAD";
            }
            b.this.a(this.f3873c, errorCode, errorMsg);
            if (this.f3875e.isFailRestart()) {
                b.this.a(this.f3873c, new SdkErrorBean(errorCode, errorMsg, this.f3876f, this.f3877g), n.f3690d);
            }
            AdFrameLayout adFrameLayout = this.a;
            if (adFrameLayout != null) {
                adFrameLayout.a(errorMsg, errorCode);
            }
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GdtNewAdTools.java */
    private static class C0094b {
        private static final b a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0094b.a;
    }

    private b() {
    }

    public void a(Context context, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        BaseAd baseAd;
        int style;
        String strG;
        if (normalAdParams == null || context == null || adFrameLayout == null || (baseAd = normalAdParams.getBaseAd()) == null || (style = baseAd.getStyle()) == 0) {
            return;
        }
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        strG = null;
        String str = "adPosition:" + adPosition + " style: " + style;
        switch (adPosition) {
            case "csj_new_position_shelf":
                if (style == 1) {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.g("b_banner2");
                    break;
                } else {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.g("b_small_sr");
                    break;
                }
                break;
            case "csj_new_position_read_bottom":
                if (style == 1) {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.i("banner_2");
                    break;
                } else {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.i("sr_small");
                    break;
                }
                break;
            case "csj_new_position_read_bottom_comics":
                if (style == 1) {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.i("cbanner_2");
                    break;
                } else {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.i("csr_small");
                    break;
                }
                break;
            case "csj_new_position_read_page":
            case "csj_new_position_read_end":
                if (style != 4) {
                    if (style != 5) {
                        strG = com.amgcyo.cuttadon.sdk.utils.d.i("cbanner_2");
                    } else {
                        strG = com.amgcyo.cuttadon.sdk.utils.d.i("sr_big");
                    }
                    break;
                } else {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.i("csr_small");
                    break;
                }
                break;
            case "csj_new_position_lists":
            case "csj_new_position_book_city":
                if (style != 4) {
                    if (style != 5) {
                        strG = com.amgcyo.cuttadon.sdk.utils.d.g("c_banner2");
                    } else {
                        strG = com.amgcyo.cuttadon.sdk.utils.d.g("c_big_sr");
                    }
                    break;
                } else {
                    strG = com.amgcyo.cuttadon.sdk.utils.d.g("c_small_sr");
                    break;
                }
                break;
        }
        if (TextUtils.isEmpty(strG)) {
            String str2 = adPosition + " 位置上的广告位id是空的";
            return;
        }
        normalAdParams.setAdUnitId(strG);
        a(context, style, normalAdParams, adFrameLayout);
    }

    private void a(Context context, int i2, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            return;
        }
        String adUnitId = normalAdParams.getAdUnitId();
        if (TextUtils.isEmpty(adUnitId)) {
            return;
        }
        String stochasticKey = normalAdParams.getStochasticKey();
        if (TextUtils.isEmpty(stochasticKey)) {
            return;
        }
        String str = "GdtNewNativeUtils style：" + i2 + " adPosition: " + adPosition + " adUnitId: " + adUnitId;
        new NativeUnifiedAD(context, adUnitId, new a(adFrameLayout, i2, context, stochasticKey, normalAdParams, adPosition, adUnitId)).loadData(1);
    }

    @SuppressLint({"SetTextI18n"})
    public static void a(TextView textView, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isWeChatCanvasAd()) {
            textView.setText("去微信看看");
            return;
        }
        if (!nativeUnifiedADData.isAppAd()) {
            textView.setText("浏览");
            return;
        }
        int appStatus = nativeUnifiedADData.getAppStatus();
        if (appStatus != 0) {
            if (appStatus == 1) {
                textView.setText("启动");
                return;
            }
            if (appStatus == 4) {
                textView.setText(nativeUnifiedADData.getProgress() + "%");
                return;
            }
            if (appStatus == 8) {
                textView.setText("安装");
                return;
            } else if (appStatus == 16) {
                textView.setText("下载失败，重新下载");
                return;
            } else if (appStatus != 32) {
                textView.setText("浏览");
                return;
            }
        }
        textView.setText("下载");
    }
}
