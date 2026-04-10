package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private String LQ;
    private String aCk;
    private String aCl;
    private String aHo;
    private String aIk;
    private JSONObject aSM;
    private boolean aSN;
    private Map<String, String> and;
    private String appId;
    private JSONObject axq;
    private String sdkVersion;

    private g() {
    }

    public static g MY() {
        return new g();
    }

    public final g gb(String str) {
        this.appId = str;
        return this;
    }

    public final g gc(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gd(String str) {
        this.aCl = str;
        return this;
    }

    public final g ge(String str) {
        this.LQ = str;
        return this;
    }

    public final g gf(String str) {
        this.aIk = str;
        return this;
    }

    public final g gg(String str) {
        this.aCk = str;
        return this;
    }

    public final g m(JSONObject jSONObject) {
        this.aSM = jSONObject;
        return this;
    }

    public final g bL(boolean z) {
        this.aSN = z;
        return this;
    }

    public final g gh(String str) {
        this.aHo = str;
        return this;
    }

    public final g h(Map<String, String> map) {
        this.and = map;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.axq = jSONObject;
        return this;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getOaid() {
        return this.aCl;
    }

    public final String getDeviceId() {
        return this.LQ;
    }

    public final String getAndroidId() {
        return this.aIk;
    }

    public final String getImei() {
        return this.aCk;
    }

    public final JSONObject MZ() {
        return this.aSM;
    }

    public final boolean Na() {
        return this.aSN;
    }

    public final String Nb() {
        return this.aHo;
    }

    public final Map<String, String> getRequestHeader() {
        return this.and;
    }

    public final JSONObject Nc() {
        return this.axq;
    }
}
