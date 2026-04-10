package com.dangdang.zframework.network.command;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface OnCommandListener<T> {

    public static class NetResult {
        public Map<String, String> mHeader;
        public int mResponseCode;
        public String mUrl;
    }

    void onFailed(NetResult netResult);

    void onSuccess(T t, NetResult netResult);
}
