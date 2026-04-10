package com.duokan.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.dkreadercore_export.service.AdService;
import com.yuewen.q22;
import com.yuewen.sw2;

/* JADX INFO: loaded from: classes6.dex */
@Route(path = sw2.d)
public class AdServiceImpl implements AdService {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.duokan.dkreadercore_export.service.AdService
    public boolean k1() {
        return q22.j();
    }
}
