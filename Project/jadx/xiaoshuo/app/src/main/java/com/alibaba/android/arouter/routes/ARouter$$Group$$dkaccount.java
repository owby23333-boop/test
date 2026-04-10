package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.account.AccountModuleServiceImpl;
import com.yuewen.s3;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dkaccount implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(s3.f17348a, RouteMeta.build(RouteType.PROVIDER, AccountModuleServiceImpl.class, s3.f17348a, "dkaccount", null, -1, Integer.MIN_VALUE));
    }
}
