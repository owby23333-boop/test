package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.duokan.ad.video.VideoAdServiceProviderImpl;
import com.yuewen.m7;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$DkVideoAd implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.duokan.adbridge.service.IVideoAdServiceProvider", RouteMeta.build(RouteType.PROVIDER, VideoAdServiceProviderImpl.class, m7.d, "video", null, -1, Integer.MIN_VALUE));
    }
}
