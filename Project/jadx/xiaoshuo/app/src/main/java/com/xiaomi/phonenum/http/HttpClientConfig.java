package com.xiaomi.phonenum.http;

import com.yuewen.mw3;

/* JADX INFO: loaded from: classes8.dex */
public class HttpClientConfig {
    private static volatile long defaultConnectTimeoutMs = 10000;
    private static volatile long defaultWaitCellularTimeoutMs = 5000;
    public final long connectTimeoutMs;
    public final int netWorkSubId;
    public final long readTimeoutMs;
    public final long waitCellularTimeoutMs;
    public final long writeTimeoutMs;

    public static class Builder {
        int netWorkSubId = -1;

        public HttpClientConfig build() {
            return new HttpClientConfig(this);
        }

        public Builder useDataNetWork(int i) {
            this.netWorkSubId = i;
            return this;
        }
    }

    public static void setDefaultConnectTimeoutMs(long j) {
        defaultConnectTimeoutMs = j;
    }

    public static void setDefaultWaitCellularTimeoutMs(long j) {
        defaultWaitCellularTimeoutMs = j;
    }

    private HttpClientConfig(Builder builder) {
        this.netWorkSubId = builder.netWorkSubId;
        this.connectTimeoutMs = defaultConnectTimeoutMs;
        this.waitCellularTimeoutMs = defaultWaitCellularTimeoutMs;
        this.readTimeoutMs = mw3.f;
        this.writeTimeoutMs = mw3.f;
    }
}
