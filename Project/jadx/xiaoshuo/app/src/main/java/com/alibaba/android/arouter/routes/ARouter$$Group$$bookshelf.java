package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.dkbookshelf.service.BookSearchServiceImpl;
import com.duokan.dkbookshelf.service.BookServiceImpl;
import com.yuewen.bp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$bookshelf implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put(bp.f9205a, RouteMeta.build(routeType, BookServiceImpl.class, bp.f9205a, "bookshelf", null, -1, Integer.MIN_VALUE));
        map.put(bp.f9206b, RouteMeta.build(routeType, BookSearchServiceImpl.class, bp.f9206b, "bookshelf", null, -1, Integer.MIN_VALUE));
    }
}
