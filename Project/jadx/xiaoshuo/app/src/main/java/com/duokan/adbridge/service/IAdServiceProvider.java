package com.duokan.adbridge.service;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.yuewen.fi1;
import com.yuewen.q7;

/* JADX INFO: loaded from: classes11.dex */
public interface IAdServiceProvider extends IProvider {
    fi1 X2(q7.a aVar);

    default boolean isInitSuccess() {
        return false;
    }
}
