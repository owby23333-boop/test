package com.duokan.reader.abk;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.abkplayer_export.service.QingTingService;
import com.yuewen.ai3;
import com.yuewen.tq2;
import com.yuewen.v0;
import com.yuewen.wf2;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = v0.f18854a)
public class QingTingServiceImpl implements QingTingService<ai3> {
    @Override // com.duokan.abkplayer_export.service.QingTingService
    public void J1(String str, List<String> list, wf2<Map<String, ai3>> wf2Var) {
        tq2.o(str, list, wf2Var);
    }

    @Override // com.duokan.abkplayer_export.service.QingTingService
    public void b0() {
        tq2.v();
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.duokan.abkplayer_export.service.QingTingService
    public void x() {
        tq2.u();
    }
}
