package com.duokan.advertisement.yimi.bridge;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.adbridge.service.IYimiAdServiceProvider;
import com.yuewen.bm4;
import com.yuewen.fi1;
import com.yuewen.m7;
import com.yuewen.q7;
import com.yuewen.z1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
@Route(path = m7.f14317a)
public class YimiServiceProviderImpl extends z1 implements IYimiAdServiceProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2718b = "YimiAdManagerProviderImpl";

    @Override // com.duokan.adbridge.service.IAdServiceProvider
    public fi1 X2(q7.a aVar) {
        Context context = this.f20668a.get();
        if (context == null) {
            return null;
        }
        return new bm4(context, aVar);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        if (context != null) {
            this.f20668a = new WeakReference<>(context);
        }
    }

    @Override // com.duokan.adbridge.service.IAdServiceProvider
    public boolean isInitSuccess() {
        return true;
    }
}
