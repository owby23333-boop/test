package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.yuewen.ed3;
import java.util.Map;
import service.SearchServiceImpl;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dksearch implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ed3.f10574b, RouteMeta.build(RouteType.PROVIDER, SearchServiceImpl.class, ed3.f10574b, "dksearch", null, -1, Integer.MIN_VALUE));
    }
}
