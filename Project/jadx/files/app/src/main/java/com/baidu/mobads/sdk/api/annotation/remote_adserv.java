package com.baidu.mobads.sdk.api.annotation;

import com.baidu.mobads.sdk.api.AdservRemoteLoaderImpl;
import com.baidu.mobads.sdk.api.RouteInfo;
import com.baidu.mobads.sdk.internal.c;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class remote_adserv {
    public static HashMap<String, RouteInfo> getRoutesMap() {
        HashMap<String, RouteInfo> map = new HashMap<>();
        map.put(c.a.a, RouteInfo.build(AdservRemoteLoaderImpl.class, c.a.a));
        return map;
    }
}
