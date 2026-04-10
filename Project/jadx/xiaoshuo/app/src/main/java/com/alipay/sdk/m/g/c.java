package com.alipay.sdk.m.g;

import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class c implements i, j {
    @Override // com.alipay.sdk.m.g.j
    public Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // com.alipay.sdk.m.g.i
    public Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // com.alipay.sdk.m.g.i, com.alipay.sdk.m.g.j
    public boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
