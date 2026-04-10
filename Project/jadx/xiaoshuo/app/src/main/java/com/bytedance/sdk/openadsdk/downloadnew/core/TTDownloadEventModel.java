package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class TTDownloadEventModel {
    private String bf;
    private JSONObject d;
    private String e;
    private JSONObject tg;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.d;
    }

    public String getLabel() {
        return this.bf;
    }

    public JSONObject getMaterialMeta() {
        return this.tg;
    }

    public String getTag() {
        return this.e;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.d = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.bf = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.tg = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.e = str;
        return this;
    }
}
