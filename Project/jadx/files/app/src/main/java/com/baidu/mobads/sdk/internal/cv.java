package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cv extends bf {
    private static final String G = cv.class.getSimpleName();
    public static final String a = "enter_refresh_bookstore";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13054q = "enter_reader";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f13055r = "notify_impression";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13056s = "request_int_ad_view";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13057t = "request_banner_ad_view";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f13058u = "request_bookstore_bottom_view";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f13059v = "request_shelf_ad_view";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f13060w = "reader_background_status_change";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f13061x = "pre_chapter_adstart_countdown";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f13062y = "try_get_cuid";
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    private CPUNovelAd.CpuNovelListener H;
    private SoftReference<RelativeLayout> I;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HashMap<String, Object> f13063z;

    public cv(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.B = 5;
        this.C = 60;
        this.D = 0;
        this.E = 10006;
        this.F = "";
        this.A = str;
        this.f13063z = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public void f() {
        an.a(this.B);
        an.b(this.C);
        an.a(new cy(this));
    }

    public Activity g() {
        return an.c();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public View v() {
        View viewA = an.a(this.f12895h);
        if (viewA instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f12895h);
            this.I = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ax.a(this.f12895h, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) viewA).addView(relativeLayout, layoutParams);
            if (bj.a((Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new cz(this, relativeLayout));
            }
        }
        return viewA;
    }

    public boolean w() {
        return an.e();
    }

    public void x() {
        an.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                an.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                an.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                an.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                an.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                an.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        f();
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f12898k.createProdHandler(jSONObject);
            n();
            this.f12898k.addEventListener("Update_fbReader_Setting", new cw(this));
            this.f12898k.addEventListener("closeInterstitialAd", new cx(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject2.put("appid", this.A);
            }
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f12898k.loadAd(jSONObject2, j.a(this.f13063z));
        } catch (Throwable th) {
            this.f12896i.c(G, th);
        }
    }

    public boolean h() {
        return an.d();
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.H = cpuNovelListener;
    }
}
