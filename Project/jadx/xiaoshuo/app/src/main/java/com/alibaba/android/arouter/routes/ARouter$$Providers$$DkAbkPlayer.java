package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.duokan.reader.abk.QingTingServiceImpl;
import com.yuewen.v0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$DkAbkPlayer implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.duokan.abkplayer_export.service.QingTingService<com.duokan.reader.domain.bookshelf.SerialChapterLink>", RouteMeta.build(RouteType.PROVIDER, QingTingServiceImpl.class, v0.f18854a, "dkabkplayer", null, -1, Integer.MIN_VALUE));
    }
}
