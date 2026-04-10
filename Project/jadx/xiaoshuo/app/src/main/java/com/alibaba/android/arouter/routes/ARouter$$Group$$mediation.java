package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.ad.mediation.MediationServiceProviderImpl;
import com.yuewen.m7;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$mediation implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(m7.c, RouteMeta.build(RouteType.PROVIDER, MediationServiceProviderImpl.class, m7.c, "mediation", null, -1, Integer.MIN_VALUE));
    }
}
