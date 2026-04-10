package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.personal.service.PersonalServiceImpl;
import com.yuewen.li2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$personal implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(li2.c, RouteMeta.build(RouteType.PROVIDER, PersonalServiceImpl.class, li2.c, "personal", null, -1, Integer.MIN_VALUE));
    }
}
