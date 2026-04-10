package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodChannelService extends IService {
    String identity();

    Object invokeMethod(String str, Object... objArr);
}
