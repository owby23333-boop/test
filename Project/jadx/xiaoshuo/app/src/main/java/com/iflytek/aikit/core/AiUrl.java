package com.iflytek.aikit.core;

import android.annotation.SuppressLint;
import com.alipay.sdk.m.y.l;
import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes7.dex */
public class AiUrl {
    boolean ssl;
    String url;

    public static class Builder {
        String url;
        boolean ssl = false;
        int port = 0;

        public AiUrl build() {
            return new AiUrl(this);
        }

        public Builder port(int i) {
            this.port = i;
            return this;
        }

        public Builder ssl(boolean z) {
            this.ssl = z;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isSsl() {
        return this.ssl;
    }

    @SuppressLint({"DefaultLocale"})
    public String toJson(String str) throws MalformedURLException {
        URL url = new URL(this.url);
        StringBuilder sb = new StringBuilder("{");
        Object[] objArr = new Object[4];
        objArr[0] = url.getHost();
        objArr[1] = url.getPath();
        objArr[2] = url.getProtocol().equals("https") ? a.c : MscKeys.VAL_FALSE;
        objArr[3] = Integer.valueOf(url.getPort() > 0 ? url.getPort() : url.getDefaultPort());
        String str2 = String.format("{\"host\":\"%s\",\"path\":\"%s\",\"ssl\":%s,\"port\":%d}", objArr);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        sb.append(":");
        sb.append(str2);
        sb.append(l.d);
        return sb.toString();
    }

    private AiUrl(Builder builder) {
        this.url = builder.url;
        this.ssl = builder.ssl;
    }
}
