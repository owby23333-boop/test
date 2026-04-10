package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final String aaH;
    public final String akI;
    public final double apW;
    public final boolean aqa;
    public final boolean aqb;
    public final com.kwad.sdk.crash.model.b aqe;
    public final com.kwad.sdk.crash.model.a aqf;
    public final h aqg;
    public final String[] aqh;
    public final String[] aqi;
    public final boolean aqj;
    public final f aqk;
    public final String aql;
    public final String aqm;
    public final String aqn;
    public final String aqo;
    public final List<com.kwad.sdk.crash.a> aqp;
    public final Context context;
    public final boolean isExternal;
    public final String platform;
    public final String version;

    public static class a {
        private String SI;
        private int SJ;
        public int SK;
        private String aaH;
        private int ajn;
        private String akI;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private f aqk;
        private String aql;
        private String aqm;
        private String aqq;
        private h aqr;
        private String[] aqs;
        public String[] aqt;
        private Context context;
        private String platform;
        private String sdkVersion;
        private String version;
        private boolean aqj = false;
        private boolean aqa = false;
        private boolean aqb = false;
        private boolean isExternal = false;
        private String aqn = "";
        private String aqo = "";
        private List<com.kwad.sdk.crash.a> aqp = new ArrayList();
        private double apW = 1.0d;

        public final a a(f fVar) {
            this.aqk = fVar;
            return this;
        }

        public final a a(h hVar) {
            this.aqr = hVar;
            return this;
        }

        public final a bB(int i2) {
            this.ajn = i2;
            return this;
        }

        public final a bC(int i2) {
            this.SJ = i2;
            return this;
        }

        public final a bD(int i2) {
            this.SK = 1;
            return this;
        }

        public final a bb(boolean z2) {
            this.aqa = z2;
            return this;
        }

        public final a bc(boolean z2) {
            this.aqb = z2;
            return this;
        }

        public final a bd(boolean z2) {
            this.isExternal = z2;
            return this;
        }

        public final a bx(Context context) {
            this.context = context;
            return this;
        }

        public final a cY(String str) {
            this.aqn = str;
            return this;
        }

        public final a cZ(String str) {
            this.aqo = str;
            return this;
        }

        public final a d(String[] strArr) {
            this.aqs = strArr;
            return this;
        }

        public final a da(String str) {
            this.platform = str;
            return this;
        }

        public final a db(String str) {
            this.akI = str;
            return this;
        }

        public final a dc(String str) {
            this.aaH = str;
            return this;
        }

        public final a dd(String str) {
            this.aqm = str;
            return this;
        }

        public final a de(String str) {
            this.aqq = str;
            return this;
        }

        public final a df(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a dg(String str) {
            this.SI = str;
            return this;
        }

        public final a dh(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a di(String str) {
            this.appId = str;
            return this;
        }

        public final a dj(String str) {
            this.appName = str;
            return this;
        }

        public final a dk(String str) {
            this.appVersion = str;
            return this;
        }

        public final a e(String[] strArr) {
            this.aqt = strArr;
            return this;
        }

        public final a j(double d2) {
            this.apW = d2;
            return this;
        }

        public final a w(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aqp.add(aVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.w("ExceptionCollectorConfigs", e2.toString());
                    }
                }
            }
            return this;
        }

        public final c zI() {
            return new c(this, (byte) 0);
        }
    }

    private c(a aVar) {
        this.aqe = new com.kwad.sdk.crash.model.b();
        this.aqf = new com.kwad.sdk.crash.model.a();
        this.aqp = new ArrayList();
        this.aqj = aVar.aqj;
        this.aqa = aVar.aqa;
        this.aqb = aVar.aqb;
        this.isExternal = aVar.isExternal;
        this.aqn = aVar.aqn;
        this.aqo = aVar.aqo;
        this.context = aVar.context;
        this.aqk = aVar.aqk;
        this.platform = aVar.platform;
        this.version = aVar.version;
        this.akI = aVar.akI;
        this.aaH = aVar.aaH;
        this.aql = aVar.aql;
        this.aqm = aVar.aqm;
        this.aqf.aqS = aVar.appId;
        this.aqf.mAppName = aVar.appName;
        this.aqf.aqU = aVar.appVersion;
        this.aqf.aqT = aVar.appPackageName;
        this.aqe.aqX = aVar.SI;
        this.aqe.aqY = aVar.SJ;
        this.aqe.mSdkVersion = aVar.sdkVersion;
        this.aqe.aqW = aVar.ajn;
        this.aqe.aqV = aVar.aqq;
        this.aqe.aqZ = aVar.SK;
        this.aqg = aVar.aqr;
        this.aqh = aVar.aqs;
        this.aqi = aVar.aqt;
        this.aqp.addAll(aVar.aqp);
        this.apW = aVar.apW;
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f zG() {
        return this.aqk;
    }

    public final boolean zH() {
        return this.aqj;
    }
}
