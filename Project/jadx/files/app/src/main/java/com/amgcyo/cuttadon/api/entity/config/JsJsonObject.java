package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JsJsonObject implements Serializable {
    private String callback;
    private String callback_key;
    private String method;
    private String query;
    private String responeJson;
    private String url;

    public String getCallback() {
        return this.callback;
    }

    public String getCallback_key() {
        return this.callback_key;
    }

    public String getMethod() {
        return this.method;
    }

    public String getQuery() {
        return this.query;
    }

    public String getResponeJson() {
        return this.responeJson;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCallback(String str) {
        this.callback = str;
    }

    public void setCallback_key(String str) {
        this.callback_key = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public void setResponeJson(String str) {
        this.responeJson = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Test{url='" + this.url + "', method='" + this.method + "', callback='" + this.callback + "', callback_key='" + this.callback_key + "', query='" + this.query + "'}";
    }
}
