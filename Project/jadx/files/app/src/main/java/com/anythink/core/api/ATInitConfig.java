package com.anythink.core.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ATInitConfig {
    protected ATInitMediation initMediation;
    protected Map<String, Object> paramMap = new HashMap(4);

    public final ATInitMediation getInitMediation() {
        return this.initMediation;
    }

    public final Map<String, Object> getRequestParamMap() {
        return this.paramMap;
    }
}
