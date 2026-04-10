package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ad extends bf {
    public static final int a = 17;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f12817q = "javascript:";
    private int A;
    private boolean B;
    private String C;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f12818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f12819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f12820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f12821u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f12822v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private HashMap<String, Object> f12823w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private NativeCPUManager.CPUAdListener f12824x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private NativeCPUManager f12825y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f12826z;

    public ad(Context context) {
        super(context);
        this.f12826z = 5;
        this.A = 60;
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

    private String i(String str) {
        IXAdContainerFactory iXAdContainerFactoryC;
        z zVarA = z.a();
        if (zVarA != null && (iXAdContainerFactoryC = zVarA.c()) != null) {
            Object remoteParam = iXAdContainerFactoryC.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        an.a(this.f12826z);
        an.b(this.A);
        an.a(new ai(this));
    }

    public Activity g() {
        return an.c();
    }

    public boolean h() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        super.b(str, i2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i2);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.f12824x = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(IOAdEvent iOAdEvent) {
        try {
            if (this.f12824x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> map = (HashMap) iOAdEvent.getData();
            this.f12824x.onLpCustomEventCallBack(map, new ag(this, map.get("activity")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ad(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.f12826z = 5;
        this.A = 60;
        this.f12902o = str;
        this.f12825y = nativeCPUManager;
    }

    public void a(int i2, int i3, int[] iArr, boolean z2, HashMap<String, Object> map) {
        this.f12819s = i2;
        this.f12818r = i3;
        this.f12820t = iArr;
        this.f12821u = z2;
        this.f12823w = map;
        this.B = an.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f12898k.createProdHandler(jSONObject3);
            n();
            this.f12898k.addEventListener("Update_fbReader_Setting", new ae(this));
            this.f12898k.addEventListener("closeInterstitialAd", new af(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.f12902o);
            jSONObject.put("pageIndex", this.f12819s);
            jSONObject.put("pageSize", this.f12818r);
            jSONObject.put("channels", this.f12820t);
            jSONObject.put("showAd", this.f12821u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            jSONObject2.put("timeout", this.f12822v);
            if (this.f12823w == null || this.f12823w.isEmpty()) {
                av.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = j.a(this.f12823w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f12898k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i2) {
        this.f12822v = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        if (this.f12824x != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f12895h, it.next(), this.f12823w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.f12824x.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        super.a(i2, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12824x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i2);
        }
    }

    protected void a(WebView webView, JSONObject jSONObject) {
        bf.a(new ah(this, jSONObject, webView));
    }

    public void a(String str) {
        this.C = str;
    }
}
