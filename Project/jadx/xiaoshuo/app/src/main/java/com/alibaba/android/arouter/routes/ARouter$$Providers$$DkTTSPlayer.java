package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.duokan.free.tts.service.TtsViewManagerServiceImpl;
import com.yuewen.gq0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$DkTTSPlayer implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.duokan.dkttsplayer_export.service.TtsViewManagerService<com.duokan.free.tts.TtsFloatingPopupRunnable>", RouteMeta.build(RouteType.PROVIDER, TtsViewManagerServiceImpl.class, gq0.f11637a, "dkttsplayer", null, -1, Integer.MIN_VALUE));
    }
}
