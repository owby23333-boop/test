package com.yuewen;

import com.duokan.adbridge.bean.CommonAdInfo;
import com.yuewen.v7;

/* JADX INFO: loaded from: classes12.dex */
public class jm4 implements v7.a<CommonAdInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommonAdInfo f12978a;

    public jm4(CommonAdInfo commonAdInfo) {
        commonAdInfo.S = "yimi";
        this.f12978a = commonAdInfo;
    }

    @Override // com.yuewen.v7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CommonAdInfo a() {
        return this.f12978a;
    }
}
