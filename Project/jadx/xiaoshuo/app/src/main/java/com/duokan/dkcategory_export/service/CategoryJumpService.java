package com.duokan.dkcategory_export.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.duokan.dkcategory_export.data.CategoryChannel;
import com.duokan.dkcategory_export.data.CategoryTag;

/* JADX INFO: loaded from: classes13.dex */
public interface CategoryJumpService extends IProvider {
    void e1(Context context, CategoryChannel categoryChannel, CategoryTag categoryTag);

    void g2(Context context);
}
