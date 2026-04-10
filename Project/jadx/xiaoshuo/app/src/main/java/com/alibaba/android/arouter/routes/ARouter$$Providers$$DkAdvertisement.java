package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.duokan.advertisement.yimi.bridge.YimiServiceProviderImpl;
import com.yuewen.m7;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$DkAdvertisement implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.duokan.adbridge.service.IYimiAdServiceProvider", RouteMeta.build(RouteType.PROVIDER, YimiServiceProviderImpl.class, m7.f14317a, "yimi", null, -1, Integer.MIN_VALUE));
    }
}
