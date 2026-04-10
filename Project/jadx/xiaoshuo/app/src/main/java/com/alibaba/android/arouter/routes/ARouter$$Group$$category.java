package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.duokan.dkcategory.biz.CategoryJumpServiceImpl;
import com.yuewen.ry;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$category implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        atlas.put(ry.f17297a, RouteMeta.build(RouteType.PROVIDER, CategoryJumpServiceImpl.class, ry.f17297a, "category", null, -1, Integer.MIN_VALUE));
    }
}
