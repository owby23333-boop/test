package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ao extends RouteInfo {
    private v a;

    public ao(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Class<?> cls = Class.forName(w.ap + getPath());
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("getRoutesMap", new Class[0]);
                declaredMethod.setAccessible(true);
                HashMap map = (HashMap) declaredMethod.invoke(null, new Object[0]);
                if (map == null || map.size() <= 0 || (routeInfo = (RouteInfo) map.get(getPath())) == null) {
                    return;
                }
                this.a = (v) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.a;
    }
}
