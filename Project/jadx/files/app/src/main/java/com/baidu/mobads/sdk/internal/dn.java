package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dn extends bf {
    private static int E;
    private static dn J;
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private SplashAdListener F;
    private SplashAd.OnFinishListener G;
    private SplashAd.SplashFocusAdListener H;
    private RequestParameters I;
    private a K;
    private SplashAd.SplashAdDownloadDialogListener L;
    private HashMap<String, String> M;
    public boolean a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RelativeLayout f13127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f13128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f13132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13133z;

    public dn(Context context, String str, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context);
        this.D = 60;
        this.f13124q = false;
        this.f13125r = false;
        this.f13126s = false;
        this.f13128u = str;
        this.f13129v = i2;
        this.f13130w = i3;
        this.f13131x = i4;
        this.f13132y = i5;
        this.f13133z = z2;
        this.A = z3;
        this.B = z5;
        this.C = z4;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f12895h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        }
        this.f12895h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f12895h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void c(int i2) {
        E = i2;
    }

    private String i(String str) {
        if (this.I == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.I.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f12896i.d(bf.b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H == null || data == null || !data.containsKey("splash_show_reason")) {
            return;
        }
        this.H.onAdIconShow();
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.a || (iAdInterListener = this.f12898k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f13127t);
        this.f12898k.showAd();
    }

    public a g() {
        return this.K;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        this.f13124q = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f12898k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13128u);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f13129v);
            jSONObject.put("h", "" + this.f13130w);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            String strI = i(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(strI)) {
                if (!Boolean.parseBoolean(strI)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = j.a(jSONObject, b(this.M));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f13132y);
            jSONObject.put("splashTipStyle", this.f13131x);
            jSONObject.put("bitmapDisplayMode", E);
            jSONObject.put("countDownNew", ITagManager.STATUS_TRUE);
            jSONObject.put("Display_Down_Info", "" + this.f13133z);
            jSONObject.put("popDialogIfDl", "" + this.A);
            jSONObject.put("limitRegionClick", "" + this.B);
            jSONObject.put("displayClickButton", "" + this.C);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.a);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.D);
            if (this.I != null) {
                a(this.I.getExtras());
            }
            return j.a(jSONObject, b(this.f12900m));
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdPresent();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void t() {
        SplashAd.OnFinishListener onFinishListener = this.G;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.G = null;
        } else {
            Context context = this.f12895h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f12895h = null;
        this.f13127t = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.f13127t = relativeLayout;
    }

    public void c(Map<String, String> map) {
        try {
            this.M = j.a(map);
        } catch (Throwable unused) {
            this.M = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H != null && data != null && data.containsKey("splash_close_reason")) {
            this.H.onAdClose();
            return;
        }
        if (this.f13125r) {
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        this.f13125r = true;
    }

    public void a(int i2) {
        this.D = i2;
    }

    public void a(SplashAdListener splashAdListener) {
        this.F = splashAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.H = splashFocusAdListener;
    }

    public void a(RequestParameters requestParameters) {
        this.I = requestParameters;
        c(this.I.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        if (!this.a) {
            iAdInterListener.setAdContainer(this.f13127t);
        }
        this.f12898k.loadAd(k(), l());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        this.f13126s = true;
        if (this.F != null) {
            a(i2 + "==" + str);
            this.F.onAdFailed(str);
        }
        super.b(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, boolean z2) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z2) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f13124q && intent != null && this.f12898k != null && !this.f13126s && (this.f12895h instanceof Activity)) {
                this.G = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap map = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    map.put("splash_focus_user_intent", intent);
                } catch (JSONException e2) {
                    bq.a().a(e2);
                }
                this.f12898k.removeAllListeners();
                this.f12898k.addEventListener(w.Z, this.f12897j);
                this.f12898k.addEventListener(w.N, this.f12897j);
                this.f12898k.addEventListener(w.H, this.f12897j);
                this.f12898k.addEventListener(w.W, this.f12897j);
                this.f12898k.addEventListener(w.X, this.f12897j);
                a(jSONObject, map);
                this.F = null;
                J = this;
                ba.a().a(new Cdo(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dn dnVar = J;
        if (dnVar != null) {
            dnVar.a(splashFocusAdListener);
            HashMap map = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    map.put("splash_focus_activity", activity);
                    J.a(jSONObject2, map);
                } catch (JSONException e2) {
                    bq.a().c(e2);
                } catch (Throwable th) {
                    bq.a().c(th);
                }
            } finally {
                J = null;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        List<a> listA;
        if (iOAdEvent != null && (listA = b.a(iOAdEvent.getMessage()).a()) != null && listA.size() > 0) {
            this.K = listA.get(0);
        }
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        this.f13126s = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i2, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(String str, boolean z2) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z2) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.L = splashAdDownloadDialogListener;
    }

    public void a(boolean z2, String str) {
        a(z2, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z2, String str, HashMap<String, Object> map) {
        a aVar = this.K;
        if (aVar != null) {
            a(aVar.G(), z2, str, map);
        }
    }

    public void a(String str) {
        try {
            HashMap map = new HashMap();
            map.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e2) {
                bq.a().a(e2);
            }
            a(jSONObject, map);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
