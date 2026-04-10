package com.duokan.dkcategory.biz;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.dkcategory_export.data.CategoryChannel;
import com.duokan.dkcategory_export.data.CategoryTag;
import com.duokan.dkcategory_export.service.CategoryJumpService;
import com.yuewen.kz;
import com.yuewen.ry;

/* JADX INFO: loaded from: classes13.dex */
@Route(path = ry.f17297a)
public class CategoryJumpServiceImpl implements CategoryJumpService {
    @Override // com.duokan.dkcategory_export.service.CategoryJumpService
    public void e1(Context context, CategoryChannel channel, CategoryTag tag) {
        kz.f(context, channel, tag);
    }

    @Override // com.duokan.dkcategory_export.service.CategoryJumpService
    public void g2(Context context) {
        kz.b(context);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }
}
