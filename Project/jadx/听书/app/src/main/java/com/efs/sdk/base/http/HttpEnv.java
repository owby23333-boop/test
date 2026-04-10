package com.efs.sdk.base.http;

import com.efs.sdk.base.core.util.a.a;
import com.efs.sdk.base.core.util.concurrent.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HttpEnv {
    private List<b<HttpResponse>> mHttpListenerList;
    private IHttpUtil mHttpUtil;

    private HttpEnv() {
        this.mHttpUtil = a.a();
        this.mHttpListenerList = new ArrayList(1);
    }

    static class SingletonHolder {
        private static final HttpEnv INSTANCE = new HttpEnv();

        private SingletonHolder() {
        }
    }

    public static HttpEnv getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public IHttpUtil getHttpUtil() {
        return this.mHttpUtil;
    }

    public void setHttpUtil(IHttpUtil iHttpUtil) {
        this.mHttpUtil = iHttpUtil;
    }

    public List<b<HttpResponse>> getHttpListenerList() {
        return new ArrayList(this.mHttpListenerList);
    }

    public void addListener(AbsHttpListener absHttpListener) {
        this.mHttpListenerList.add(absHttpListener);
    }

    public void removeListener(AbsHttpListener absHttpListener) {
        this.mHttpListenerList.remove(absHttpListener);
    }
}
