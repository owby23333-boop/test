package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.advertisement.yimi.bridge.YimiServiceProviderImpl;
import com.yuewen.m7;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$yimi implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(m7.f14317a, RouteMeta.build(RouteType.PROVIDER, YimiServiceProviderImpl.class, m7.f14317a, "yimi", null, -1, Integer.MIN_VALUE));
    }
}
