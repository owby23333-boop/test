package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.duokan.dkcategory.biz.CategoryJumpServiceImpl;
import com.yuewen.ry;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$DkCategory implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> providers) {
        providers.put("com.duokan.dkcategory_export.service.CategoryJumpService", RouteMeta.build(RouteType.PROVIDER, CategoryJumpServiceImpl.class, ry.f17297a, "category", null, -1, Integer.MIN_VALUE));
    }
}
