package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.reader.ReadingFeatureServiceImpl;
import com.yuewen.tx2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dkreading implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(tx2.f18259a, RouteMeta.build(RouteType.PROVIDER, ReadingFeatureServiceImpl.class, tx2.f18259a, "dkreading", null, -1, Integer.MIN_VALUE));
    }
}
