package com.bytedance.android.live.base.api;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodChannelService {
    String identity();

    Object invokeMethod(String str, Map<String, String> map);
}
