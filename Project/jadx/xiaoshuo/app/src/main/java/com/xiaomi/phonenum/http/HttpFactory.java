package com.xiaomi.phonenum.http;

import com.xiaomi.phonenum.http.HttpClientConfig;

/* JADX INFO: loaded from: classes8.dex */
public abstract class HttpFactory {
    public HttpClient createDataHttpClient(int i) {
        return createHttpClient(new HttpClientConfig.Builder().useDataNetWork(i).build());
    }

    public HttpClient createHttpClient() {
        return createHttpClient(new HttpClientConfig.Builder().build());
    }

    public abstract HttpClient createHttpClient(HttpClientConfig httpClientConfig);
}
