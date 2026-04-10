package com.xuexiang.xupdate.proxy;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdateChecker {
    void checkVersion(boolean z, String str, Map<String, Object> map, IUpdateProxy iUpdateProxy);

    void noNewVersion(Throwable th);

    void onAfterCheck();

    void onBeforeCheck();

    void processCheckResult(String str, IUpdateProxy iUpdateProxy);
}
