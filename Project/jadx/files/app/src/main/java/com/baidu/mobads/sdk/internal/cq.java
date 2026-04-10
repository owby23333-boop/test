package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cq extends bf {
    private HashMap<String, Object> a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RelativeLayout f13050r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CpuAdView.CpuAdViewInternalStatusListener f13051s;

    public cq(Context context, RelativeLayout relativeLayout, String str, int i2, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f12902o = str;
        this.f13050r = relativeLayout;
        this.f13049q = i2;
        if (cPUWebAdRequestParam == null) {
            av.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f13051s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f13051s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f13051s != null && bool != null && bool.booleanValue()) {
            this.f13051s.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f13051s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public Activity f() {
        return an.c();
    }

    public boolean g() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f13051s != null && bool != null && bool.booleanValue()) {
            this.f13051s.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f13051s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(IOAdEvent iOAdEvent) {
        if (this.f13051s == null || iOAdEvent == null) {
            return;
        }
        this.f13051s.onLpContentStatus(iOAdEvent.getData());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f12898k != null) {
            try {
                jSONObject.put("channel", this.f13049q);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.f12902o)) {
                    jSONObject.put("appid", this.f12902o);
                }
                if (this.f13050r != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f12898k.createProdHandler(jSONObject2);
                    this.f12898k.setAdContainer(this.f13050r);
                    n();
                    this.f12898k.addEventListener("Update_fbReader_Setting", new cr(this));
                    this.f12898k.addEventListener("closeInterstitialAd", new cs(this));
                    this.f12898k.addEventListener("feOpenFbReader", new ct(this));
                    JSONObject jSONObjectA = j.a(this.a);
                    jSONObjectA.put("isInitNovelSDK", an.f());
                    this.f12898k.loadAd(jSONObject, jSONObjectA);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str, int i4, int i5, String str2) {
        an.a(i2);
        an.b(i3);
        an.a(new cu(this, i4, i5, str2));
        an.a(this.f12895h, str);
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f13051s = cpuAdViewInternalStatusListener;
    }
}
