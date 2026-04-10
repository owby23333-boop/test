package com.duokan.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.dkreadercore_export.service.ABTestUtilsService;
import com.yuewen.q;
import com.yuewen.sw2;

/* JADX INFO: loaded from: classes6.dex */
@Route(path = sw2.r)
public class ABTestUtilsServiceImpl implements ABTestUtilsService {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.duokan.dkreadercore_export.service.ABTestUtilsService
    public boolean o1() {
        return q.c().i();
    }
}
