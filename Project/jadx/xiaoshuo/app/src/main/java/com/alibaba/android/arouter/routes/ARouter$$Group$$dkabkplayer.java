package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.reader.abk.QingTingServiceImpl;
import com.yuewen.v0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dkabkplayer implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(v0.f18854a, RouteMeta.build(RouteType.PROVIDER, QingTingServiceImpl.class, v0.f18854a, "dkabkplayer", null, -1, Integer.MIN_VALUE));
    }
}
