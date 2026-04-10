package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.core.common.c.k;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bf extends Observable {
    private static final String a = "b_f";
    public static final String b = "XAbstractProdTemplate";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12890c = "error_message";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12891d = "error_code";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final String f12892e = "instanceInfo";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final String f12893f = "showState";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected RelativeLayout f12894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Context f12895h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, String> f12900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f12901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f12902o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected bq f12896i = bq.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IAdInterListener f12898k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12899l = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12903p = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IOAdEventListener f12897j = new a();

    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bf.a(new bi(this, iOAdEvent));
        }
    }

    public bf(Context context) {
        this.f12895h = context;
        z.a().a(this.f12895h, new bg(this));
    }

    public abstract void a();

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    protected void a(IOAdEvent iOAdEvent) {
    }

    protected void a(String str, boolean z2) {
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    protected void b(IOAdEvent iOAdEvent) {
    }

    protected void b(String str, boolean z2) {
    }

    protected void b(boolean z2) {
    }

    protected void b_() {
    }

    protected void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.f12898k == null) {
            b("Initialization doesn't finish yet.", 1);
            return;
        }
        HashMap map = new HashMap();
        map.put(k.a.b, str);
        a("load_bidding_ad", (Map<String, Object>) map);
    }

    protected void c_() {
    }

    protected void d() {
    }

    protected void d(IOAdEvent iOAdEvent) {
    }

    protected void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    protected void e(IOAdEvent iOAdEvent) {
    }

    protected void e(String str) {
    }

    protected void f(IOAdEvent iOAdEvent) {
    }

    protected void f(String str) {
    }

    protected void g(IOAdEvent iOAdEvent) {
        r();
    }

    public String h(String str) {
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

    protected void h(IOAdEvent iOAdEvent) {
    }

    public void i() {
        this.f12898k = (IAdInterListener) ar.a(w.f13186k, bp.a(this.f12895h), (Class<?>[]) new Class[]{Context.class}, this.f12895h);
        if (this.f12899l) {
            return;
        }
        a();
    }

    protected void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    protected void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    protected void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject jSONObjectK = k();
        JSONObject jSONObjectL = l();
        HashMap map = new HashMap();
        map.put("param_info", jSONObjectK);
        map.put("ad_buss_param", jSONObjectL);
        a("get_request_token", (Map<String, Object>) map);
        Object obj = map.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.b.f12808e, new b.a());
            this.f12898k.addEventListener(w.H, this.f12897j);
            this.f12898k.addEventListener(w.J, this.f12897j);
            this.f12898k.addEventListener(w.L, this.f12897j);
            this.f12898k.addEventListener(w.M, this.f12897j);
            this.f12898k.addEventListener(w.W, this.f12897j);
            this.f12898k.addEventListener(w.f13193r, this.f12897j);
            this.f12898k.addEventListener(w.X, this.f12897j);
            this.f12898k.addEventListener(w.f13194s, this.f12897j);
            this.f12898k.addEventListener(w.N, this.f12897j);
            this.f12898k.addEventListener(w.O, this.f12897j);
            this.f12898k.addEventListener(w.K, this.f12897j);
            this.f12898k.addEventListener(w.D, this.f12897j);
            this.f12898k.addEventListener(w.ac, this.f12897j);
            this.f12898k.addEventListener(w.ad, this.f12897j);
            this.f12898k.addEventListener(w.aa, this.f12897j);
            this.f12898k.addEventListener(w.V, this.f12897j);
            this.f12898k.addEventListener(w.ae, this.f12897j);
            this.f12898k.addEventListener(w.af, this.f12897j);
            this.f12898k.addEventListener(w.ag, this.f12897j);
            this.f12898k.addEventListener(w.ah, this.f12897j);
            this.f12898k.addEventListener(w.ai, this.f12897j);
            this.f12898k.addEventListener(w.aj, this.f12897j);
            this.f12898k.addEventListener(w.ab, this.f12897j);
            this.f12898k.addEventListener(w.ak, this.f12897j);
            this.f12898k.addEventListener(w.Y, this.f12897j);
            this.f12898k.addEventListener(w.al, this.f12897j);
            this.f12898k.addEventListener(w.am, this.f12897j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    protected void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    protected void s() {
    }

    protected void t() {
    }

    protected void u() {
    }

    public View v() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void g(String str) {
        this.f12902o = str;
    }

    public void a(Activity activity) {
        if (this.f12898k != null) {
            HashMap map = new HashMap();
            map.put("setActivity", activity);
            this.f12898k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), map);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.f12898k != null) {
            HashMap map = new HashMap();
            map.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) map);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void b(int i2) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i2);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    protected void b(String str, int i2) {
        r();
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            if (this.f12898k != null) {
                this.f12898k.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception unused) {
            return null;
        }
    }

    protected void b(JSONObject jSONObject) {
        int i2 = this.f12903p;
        if (i2 < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(a, i2);
        } catch (Throwable th) {
            this.f12896i.a(th);
        }
    }

    public void a(String str, boolean z2, String str2) {
        a(str, z2, str2, null);
    }

    public void a(String str, boolean z2, String str2, HashMap<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z2);
            jSONObject.put("replacement", str2);
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    av.f(th.getMessage());
                }
            }
            if (this.f12898k != null) {
                this.f12898k.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            if (this.f12898k != null) {
                this.f12898k.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), map);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z2) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z2);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i2, keyEvent);
        }
        return false;
    }

    protected void a(int i2, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bh(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f12900m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
