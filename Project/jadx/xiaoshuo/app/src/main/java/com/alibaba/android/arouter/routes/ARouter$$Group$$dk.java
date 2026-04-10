package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.service.DkUserFavouriteServiceImpl;
import com.yuewen.bu;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dk implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/dk/user/favourite/refresh", RouteMeta.build(RouteType.PROVIDER, DkUserFavouriteServiceImpl.class, "/dk/user/favourite/refresh", bu.d, null, -1, Integer.MIN_VALUE));
    }
}
