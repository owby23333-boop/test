package com.duokan.adbridge.bean;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.duokan.core.app.AppWrapper;
import com.xiaomi.ad.common.util.Constants;
import com.xiaomi.onetrack.util.z;
import com.yuewen.ay1;
import com.yuewen.ei1;
import com.yuewen.h32;
import com.yuewen.i8;
import com.yuewen.id;
import com.yuewen.se2;
import com.yuewen.so2;
import com.yuewen.w6;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class CommonAdInfo extends w6 implements ei1 {
    public static int m0 = 1;
    public static int n0 = 2;
    public static final int o0 = 6;
    public static final int p0 = 7;
    public static final int q0 = 4;
    public static final int r0 = 11;
    public static final int s0 = 60;
    public static final int t0 = 61;
    public static final int u0 = 20;
    public static final int v0 = 50;
    public static final int w0 = 40;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public double L;
    public String M;
    public boolean N;
    public JSONObject O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public final List<String> T;
    public String U;
    public String V;
    public String W;
    public boolean X;
    public String Y;
    public boolean Z;
    public boolean a0;
    public List<b> b0;
    public int c0;
    public id d0;
    public String e;
    public long e0;
    public String f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public d h0;
    public String i;
    public View i0;
    public String j;
    public List<ay1> j0;
    public String k;
    public final String k0;
    public String l;
    public String l0;
    public String m;
    public int n;
    public int o;
    public long p;
    public String q;
    public List<String> r;
    public List<String> s;
    public List<String> t;
    public List<String> u;
    public List<String> v;
    public List<String> w;
    public String x;
    public String y;
    public String z;

    public enum DspType {
        YIMI_SCHEDULE,
        YIMI,
        OUTER
    }

    public enum TagPosition {
        NONE,
        STYLE_A,
        STYLE_B,
        STYLE_C
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2459a;

        static {
            int[] iArr = new int[DspType.values().length];
            f2459a = iArr;
            try {
                iArr[DspType.YIMI_SCHEDULE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2459a[DspType.YIMI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2459a[DspType.OUTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2461b;

        public b(String str, int i) {
            this.f2460a = str;
            this.f2461b = i;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new b(jSONObject.getString("url"), jSONObject.getInt("materialType"));
            } catch (JSONException unused) {
                return null;
            }
        }

        public static List<b> b(JSONArray jSONArray) {
            LinkedList linkedList = new LinkedList();
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        Object objOpt = jSONArray.opt(i);
                        if (objOpt instanceof JSONObject) {
                            linkedList.add(a(jSONArray.optJSONObject(i)));
                        } else if (objOpt instanceof String) {
                            linkedList.add(new b((String) objOpt, 0));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return linkedList;
        }
    }

    public static class c {
        public String A;
        public double B;
        public String C;
        public boolean D;
        public JSONObject E;
        public String F;
        public String G;
        public String H;
        public String I;
        public String J;
        public String K;
        public String L;
        public String M;
        public List<b> P;
        public int Q;
        public id R;
        public String S;
        public String T;
        public d U;
        public View V;
        public List<ay1> W;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2463b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
        public int k;
        public long l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;
        public String t = "";
        public boolean N = false;
        public boolean O = false;

        public c A0(String str) {
            this.e = str;
            return this;
        }

        public c B0(boolean z) {
            this.D = z;
            return this;
        }

        public c C0(d dVar) {
            this.U = dVar;
            return this;
        }

        public c D0(String str) {
            this.v = str;
            return this;
        }

        public c E0(String str) {
            this.S = str;
            return this;
        }

        public c F0(String str) {
            this.x = str;
            return this;
        }

        public c G0(String str) {
            this.u = str;
            return this;
        }

        public c H0(String str) {
            this.K = str;
            return this;
        }

        public c I0(String str) {
            this.I = str;
            return this;
        }

        public c J0(String str) {
            this.c = str;
            return this;
        }

        public c K0(String str) {
            this.i = str;
            return this;
        }

        public c L0(String str) {
            this.J = str;
            return this;
        }

        public c M0(String str) {
            this.F = str;
            return this;
        }

        public c N0(int i) {
            this.k = i;
            return this;
        }

        public c O0(String str) {
            this.y = str;
            return this;
        }

        public c P0(String str) {
            this.f2463b = str;
            return this;
        }

        public c Q0(String str) {
            this.M = str;
            return this;
        }

        public c R0(String str) {
            this.r = str;
            return this;
        }

        public c S0(View view) {
            this.V = view;
            return this;
        }

        public c T0(String str) {
            this.f = str;
            return this;
        }

        public c U0(String str) {
            this.g = str;
            return this;
        }

        public CommonAdInfo X() {
            return new CommonAdInfo(this);
        }

        public c Y(String str) {
            this.n = str;
            return this;
        }

        public c Z(JSONObject jSONObject) {
            this.E = jSONObject;
            return this;
        }

        public c a0(int i) {
            this.j = i;
            return this;
        }

        public c b0(String str) {
            this.G = str;
            return this;
        }

        public c c0(String str) {
            this.L = str;
            return this;
        }

        public c d0(id idVar) {
            this.R = idVar;
            return this;
        }

        public c e0(String str) {
            this.A = str;
            return this;
        }

        public c f0(double d) {
            this.B = d;
            return this;
        }

        public c g0(String str) {
            this.s = str;
            return this;
        }

        public c h0(String str) {
            this.d = str;
            return this;
        }

        public c i0(String str) {
            this.C = str;
            return this;
        }

        public c j0(String str) {
            this.t = str;
            return this;
        }

        public c k0(String str) {
            this.w = str;
            return this;
        }

        public c l0(boolean z) {
            this.O = z;
            return this;
        }

        public c m0(String str) {
            this.T = str;
            return this;
        }

        public c n0(String str) {
            this.o = str;
            return this;
        }

        public c o0(String str) {
            this.z = str;
            return this;
        }

        public c p0(long j) {
            this.l = j;
            return this;
        }

        public c q0(String str) {
            this.m = str;
            return this;
        }

        public c r0(String str) {
            this.h = str;
            return this;
        }

        public c s0(String str) {
            this.H = str;
            return this;
        }

        public c t0(boolean z) {
            this.N = z;
            return this;
        }

        public c u0(int i) {
            this.Q = i;
            return this;
        }

        public c v0(String str) {
            this.p = str;
            return this;
        }

        public c w0(String str) {
            this.f2462a = str;
            return this;
        }

        public c x0(List<ay1> list) {
            this.W = list;
            return this;
        }

        public c y0(String str) {
            this.q = str;
            return this;
        }

        public c z0(List<b> list) {
            this.P = list;
            return this;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2465b;
        public String c;

        public String toString() {
            return "LiveRoom{mAvatarUrl='" + this.f2464a + "', mAuthorNickName='" + this.f2465b + "', mWatchCount='" + this.c + "'}";
        }
    }

    public static List<String> J(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public static int Q(int i) {
        if (i == 1 || i == 3) {
            return m0;
        }
        if (i == 2 || i == 4 || i == 0) {
            return n0;
        }
        return 0;
    }

    public static int R(String str) {
        if (TextUtils.equals(str, "2.1") || TextUtils.equals(str, "2.4") || TextUtils.equals(str, "1.4")) {
            return 6;
        }
        if (TextUtils.equals(str, "2.3") || TextUtils.equals(str, "2.6")) {
            return 7;
        }
        if (TextUtils.equals(str, "2.2") || TextUtils.equals(str, "2.5") || TextUtils.equals(str, "4.3") || TextUtils.equals(str, "1.14") || TextUtils.equals(str, "1.15")) {
            return 4;
        }
        if (TextUtils.equals(str, "2.72") || TextUtils.equals(str, "2.71") || TextUtils.equals(str, "2.7") || TextUtils.equals(str, "2.14") || TextUtils.equals(str, "4.2")) {
            return 60;
        }
        return (TextUtils.equals(str, "2.25") || TextUtils.equals(str, "2.26")) ? 61 : 0;
    }

    public static int S(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contentEquals("2.4") || str.contentEquals("2.5") || str.contentEquals("2.6") || str.contentEquals("2.26") || str.contentEquals("1.4") || str.contentEquals("2.72") || str.contentEquals("2.14") || str.contentEquals("4.2")) {
            return n0;
        }
        if (str.contentEquals("2.1") || str.contentEquals("2.2") || str.contentEquals("2.3") || str.contentEquals("2.25") || str.contentEquals("2.7") || str.contentEquals("2.71")) {
            return m0;
        }
        return 0;
    }

    public static boolean a(String str) {
        return str.split(z.f7779a).length == 4;
    }

    public static CommonAdInfo b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            CommonAdInfo commonAdInfo = new CommonAdInfo();
            commonAdInfo.O = jSONObject;
            commonAdInfo.e = jSONObject.optString("id");
            commonAdInfo.g = jSONObject.optString("summary");
            commonAdInfo.h = jSONObject.optString("brief");
            commonAdInfo.i = jSONObject.optString("landingPageUrl");
            commonAdInfo.l = jSONObject.optString("floatCardData");
            commonAdInfo.j = jSONObject.optString("wxMiniProgramId");
            commonAdInfo.k = jSONObject.optString("wxMiniProgramPath");
            commonAdInfo.m = jSONObject.optString("tagId");
            commonAdInfo.f = jSONObject.optString("title");
            commonAdInfo.V = jSONObject.optString("source");
            if (a(commonAdInfo.m)) {
                String strOptString = jSONObject.optString(i8.f12399a);
                commonAdInfo.I = strOptString;
                commonAdInfo.n = R(strOptString);
                commonAdInfo.b0 = b.b(jSONObject.optJSONArray("imgUrls"));
            } else {
                commonAdInfo.n = jSONObject.optInt("adStyle");
                commonAdInfo.b0 = b.b(jSONObject.optJSONArray("assets"));
            }
            commonAdInfo.o = r(jSONObject, commonAdInfo.I, commonAdInfo.m, jSONObject.optInt("targetType", 0));
            commonAdInfo.D = jSONObject.optString("appChannel");
            commonAdInfo.G = jSONObject.optString(h32.f);
            commonAdInfo.E = jSONObject.optString(h32.g);
            commonAdInfo.H = jSONObject.optString("appRef");
            commonAdInfo.F = jSONObject.optString("nonce");
            commonAdInfo.s = J(jSONObject.optJSONArray(Constants.KEY_CLICK_MONITOR_URLS));
            commonAdInfo.r = J(jSONObject.optJSONArray(Constants.KEY_VIEW_MONITOR_URLS));
            commonAdInfo.t = J(jSONObject.optJSONArray("startDownloadMonitorUrls"));
            commonAdInfo.w = J(jSONObject.optJSONArray("finishInstallMonitorUrls"));
            commonAdInfo.v = J(jSONObject.optJSONArray("startInstallMonitorUrls"));
            commonAdInfo.u = J(jSONObject.optJSONArray("finishDownloadMonitorUrls"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("parameters");
            if (jSONObjectOptJSONObject != null) {
                commonAdInfo.X = jSONObjectOptJSONObject.optBoolean("autoLaunch");
                commonAdInfo.Q = jSONObjectOptJSONObject.optString("adValueLevel");
                commonAdInfo.P = jSONObjectOptJSONObject.optString("tagText");
                commonAdInfo.Y = jSONObjectOptJSONObject.optString("trackingStrategy");
            }
            commonAdInfo.f19380b = jSONObject.optString("packageName");
            commonAdInfo.x = jSONObject.optString("actionUrl");
            commonAdInfo.y = jSONObject.optString(so2.Dc);
            commonAdInfo.z = jSONObject.optString("iconUrl");
            commonAdInfo.B = jSONObject.optString("videoUrl");
            commonAdInfo.C = jSONObject.optString("brand");
            commonAdInfo.J = jSONObject.optString("dspName");
            commonAdInfo.K = jSONObject.optString("appName");
            commonAdInfo.L = jSONObject.optDouble("appRatingScore", 5.0d);
            commonAdInfo.M = jSONObject.optString("categoryName", "安全");
            commonAdInfo.h = jSONObject.optString("brief");
            commonAdInfo.q = jSONObject.optString("ex");
            commonAdInfo.d0 = new id(jSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("adControl");
            if (jSONObjectOptJSONObject2 != null) {
                commonAdInfo.p = jSONObjectOptJSONObject2.optLong("duration", 0L);
            }
            commonAdInfo.R = jSONObject.optString("floatCardData", "");
            commonAdInfo.L = jSONObject.optDouble("appRatingScore", 5.0d);
            commonAdInfo.M = jSONObject.optString("categoryName", "安全");
            commonAdInfo.W = jSONObject.optString("appId");
            return commonAdInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static CommonAdInfo c(String str) {
        try {
            return b(new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int r(JSONObject jSONObject, String str, String str2, int i) {
        return a(str2) ? S(str) : jSONObject.optInt("targetType");
    }

    public boolean A() {
        int i = this.n;
        return i == 4 || i == 7 || i == 60 || i == 61 || i == 6;
    }

    public boolean B() {
        return n() == DspType.OUTER;
    }

    public boolean C() {
        id idVar = this.d0;
        return idVar == null || idVar.b();
    }

    public boolean D() {
        return !C() || se2.b(AppWrapper.v(), this.f19380b);
    }

    public boolean E() {
        return TextUtils.equals(this.J, "xiaomi.schedule") || TextUtils.equals(this.J, "schedule");
    }

    public boolean F() {
        return "0".equalsIgnoreCase(this.Q);
    }

    public boolean G() {
        return TextUtils.equals(this.I, "2.25") || TextUtils.equals(this.I, "2.26");
    }

    public boolean H() {
        int i = this.n;
        return i == 60 || i == 61;
    }

    public boolean I() {
        return DspType.YIMI == n();
    }

    public String K() {
        String strP = p();
        String strH = h();
        return (TextUtils.isEmpty(strP) || TextUtils.equals(L(), strP)) ? (TextUtils.isEmpty(strH) || TextUtils.equals(L(), strH)) ? "点我了解更多" : strH : strP;
    }

    public String L() {
        String strS = s();
        String strP = p();
        return !TextUtils.isEmpty(strS) ? strS : !TextUtils.isEmpty(strP) ? strP : h();
    }

    public String M() {
        return N(false);
    }

    public String N(boolean z) {
        String strP = p();
        String strS = s();
        String strM = m();
        int i = a.f2459a[n().ordinal()];
        return i != 1 ? i != 2 ? z ? this.l0 : strS : !TextUtils.isEmpty(strP) ? strP : !TextUtils.isEmpty(strS) ? strS : strM : !TextUtils.isEmpty(strS) ? strS : strM;
    }

    public String O() {
        return P(false);
    }

    public String P(boolean z) {
        if (v() && !TextUtils.isEmpty(this.K)) {
            return h();
        }
        String strL = l();
        String strP = p();
        String strO = o();
        String strS = s();
        String strM = m();
        int i = a.f2459a[n().ordinal()];
        if (i == 1) {
            return !TextUtils.isEmpty(strL) ? strL : strP;
        }
        if (i == 2) {
            return strL;
        }
        if (!z) {
            return !TextUtils.isEmpty(strS) ? strS : !TextUtils.isEmpty(strP) ? strP : !TextUtils.isEmpty(strL) ? strL : !TextUtils.isEmpty(strO) ? strO : strM;
        }
        if (!TextUtils.isEmpty(this.K)) {
            this.l0 = strS;
            return this.K;
        }
        if (TextUtils.isEmpty(strS)) {
            this.l0 = "点我了解更多";
            return !TextUtils.isEmpty(this.g) ? this.g : !TextUtils.isEmpty(this.C) ? this.C : strM;
        }
        if (TextUtils.equals(strS, this.g) || TextUtils.isEmpty(this.g)) {
            this.l0 = "点我了解更多";
        } else {
            this.l0 = this.g;
        }
        return strS;
    }

    public String d() {
        if (!TextUtils.isEmpty(this.R)) {
            return this.R;
        }
        Uri uri = Uri.parse(this.i);
        String queryParameter = uri.getQueryParameter("id");
        String queryParameter2 = uri.getQueryParameter("ref");
        String queryParameter3 = uri.getQueryParameter("ext_apkChannel");
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("useCache", false);
        boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("ext_useCache", false);
        boolean booleanQueryParameter3 = uri.getBooleanQueryParameter("launchWhenInstalled", false);
        String queryParameter4 = uri.getQueryParameter("ext_passback");
        String queryParameter5 = uri.getQueryParameter("ext_delayDeeplink");
        return "mimarket://details/detailfloat?id=" + queryParameter + "&ref=" + queryParameter2 + "&startDownload=true&ext_apkChannel=" + Uri.encode(queryParameter3) + "&useCache=" + booleanQueryParameter + "&ext_useCache=" + booleanQueryParameter2 + "&launchWhenInstalled=" + booleanQueryParameter3 + "&ext_passback=" + Uri.encode(queryParameter4) + "&ext_delayDeeplink=" + Uri.encode(queryParameter5) + "&packageName=" + this.f19380b + "&appClientId=" + uri.getQueryParameter(h32.f) + "&appSignature=" + Uri.encode(uri.getQueryParameter(h32.g)) + "&nonce=" + this.F + "&senderPackageName=" + AppWrapper.v().getPackageName() + "&overlayPosition=1";
    }

    public String e() {
        id idVar = this.d0;
        return idVar == null ? "" : idVar.f12456b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CommonAdInfo) {
            return TextUtils.equals(this.e, ((CommonAdInfo) obj).e);
        }
        return false;
    }

    public String f() {
        return this.W;
    }

    public String g() {
        id idVar = this.d0;
        return idVar == null ? "" : idVar.e;
    }

    public String h() {
        return this.K;
    }

    public String i() {
        id idVar = this.d0;
        return idVar == null ? "" : idVar.c;
    }

    public String j() {
        id idVar = this.d0;
        return idVar == null ? "" : idVar.d;
    }

    public String k() {
        id idVar = this.d0;
        return idVar == null ? "" : idVar.f12455a;
    }

    public String l() {
        if (w()) {
            String str = this.g;
            return str == null ? "" : str.trim();
        }
        String str2 = this.C;
        return str2 == null ? "" : str2.trim();
    }

    public final String m() {
        String str = this.h;
        return str == null ? "" : str.trim();
    }

    public final DspType n() {
        String str = this.J;
        return (str == null || !str.contains("xiaomi.")) ? DspType.OUTER : TextUtils.equals(this.J, "xiaomi.schedule") ? DspType.YIMI_SCHEDULE : DspType.YIMI;
    }

    public String o() {
        return this.V;
    }

    public String p() {
        if (w()) {
            String str = this.C;
            return str == null ? "" : str.trim();
        }
        String str2 = this.g;
        return str2 == null ? "" : str2.trim();
    }

    public TagPosition q() {
        if (TextUtils.isEmpty(this.U) || this.T.isEmpty()) {
            return TagPosition.NONE;
        }
        String str = this.U;
        str.hashCode();
        switch (str) {
            case "styleA":
                return TagPosition.STYLE_A;
            case "styleB":
                return TagPosition.STYLE_B;
            case "styleC":
                return TagPosition.STYLE_C;
            default:
                return TagPosition.NONE;
        }
    }

    public String s() {
        String str = this.f;
        return str == null ? "" : str.trim();
    }

    public boolean t() {
        return !TextUtils.isEmpty(this.g);
    }

    public String toString() {
        return "CommonAdInfo{mId='" + this.e + "', mAdStyle=" + this.n + ", mTitle='" + this.f + "', mSummary='" + this.g + "', mBrand='" + this.C + "', mBrief='" + this.h + "', mLandingPageUrl='" + this.i + "', mFloatCardData='" + this.l + "', mTagId='" + this.m + "', mTargetType=" + this.o + ", mDuration=" + this.p + ", mEx='" + this.q + "', mViewMonitorUrls=" + this.r + ", mClickMonitorUrls=" + this.s + ", mDownloadStartMonitorUrls=" + this.t + ", mDownloadSuccessUrls=" + this.u + ", mInstallStartUrls=" + this.v + ", mInstallSuccessUrls=" + this.w + ", mActionUrl='" + this.x + "', mDeepLink='" + this.y + "', mIconUrl='" + this.z + "', mVideoUrl='" + this.B + "', mChannel='" + this.D + "', mSign='" + this.E + "', mNonce='" + this.F + "', mClientId='" + this.G + "', mRef='" + this.H + "', mTemplate='" + this.I + "', mDspName='" + this.J + "', mAppName='" + this.K + "', mAppRatingScore=" + this.L + ", mCategoryName='" + this.M + "', mAdInfo=" + this.O + ", mTagText='" + this.P + "', mFloatcardLink='" + this.R + "', mTagTexts=" + this.T + ", mTagPosition='" + this.U + "', mSource='" + this.V + "', mLauchAfterInstall=" + this.X + ", mHasInstalled=" + this.Z + ", mConsumed=" + this.a0 + ", mImageUrls=" + this.b0 + ", height=" + this.c0 + ", mAppInfo=" + this.d0 + ", mCTAText=" + this.g0 + ", mLiveRoom=" + this.h0 + ", appId=" + this.W + '}';
    }

    public boolean u() {
        return !TextUtils.isEmpty(this.x);
    }

    public boolean v() {
        return this.o == n0;
    }

    public boolean w() {
        return TextUtils.equals(this.J, "baidurtb");
    }

    public boolean x() {
        return !TextUtils.isEmpty(this.R);
    }

    public boolean y() {
        return "iqiyi".equals(this.J) || "bytedance".equals(this.J);
    }

    public boolean z(Context context) {
        return this.o == n0 && C() && !se2.b(context, this.f19380b);
    }

    public CommonAdInfo() {
        this.D = "";
        this.T = new ArrayList();
        this.X = false;
        this.Z = false;
        this.a0 = false;
        this.e0 = -1L;
        this.f0 = "";
        this.k0 = "点我了解更多";
    }

    public CommonAdInfo(c cVar) {
        this.D = "";
        this.T = new ArrayList();
        this.X = false;
        this.Z = false;
        this.a0 = false;
        this.e0 = -1L;
        this.f0 = "";
        this.k0 = "点我了解更多";
        this.e = cVar.f2462a;
        this.f = cVar.f2463b;
        this.g = cVar.c;
        this.h = cVar.d;
        this.i = cVar.e;
        this.j = cVar.f;
        this.k = cVar.g;
        this.l = cVar.h;
        this.m = cVar.i;
        this.n = cVar.j;
        this.o = cVar.k;
        this.p = cVar.l;
        this.q = cVar.m;
        this.x = cVar.n;
        this.y = cVar.o;
        this.z = cVar.p;
        this.A = cVar.q;
        this.B = cVar.r;
        this.C = cVar.s;
        this.D = cVar.t;
        this.E = cVar.u;
        this.F = cVar.v;
        this.G = cVar.w;
        this.H = cVar.x;
        this.I = cVar.y;
        this.J = cVar.z;
        this.K = cVar.A;
        this.L = cVar.B;
        this.M = cVar.C;
        this.N = cVar.D;
        this.O = cVar.E;
        this.P = cVar.F;
        this.Q = cVar.G;
        this.R = cVar.H;
        this.S = cVar.I;
        this.U = cVar.J;
        this.V = cVar.K;
        this.W = cVar.L;
        this.Y = cVar.M;
        this.Z = cVar.N;
        this.a0 = cVar.O;
        this.b0 = cVar.P;
        this.c0 = cVar.Q;
        this.d0 = cVar.R;
        this.f19380b = cVar.S;
        this.g0 = cVar.T;
        this.h0 = cVar.U;
        this.i0 = cVar.V;
        this.j0 = cVar.W;
    }
}
