package com.anythink.network.gdt;

import com.anythink.core.api.ATInitConfig;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATInitConfig extends ATInitConfig {
    public GDTATInitConfig(String str) {
        this.paramMap.put("app_id", str);
        this.initMediation = GDTATInitManager.getInstance();
    }
}
