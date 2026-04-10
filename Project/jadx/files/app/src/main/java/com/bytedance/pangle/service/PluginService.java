package com.bytedance.pangle.service;

import android.app.Service;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class PluginService extends Service implements a {
    private static final String TAG = "PluginService";

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e2);
        }
    }

    protected Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
            @Override // java.lang.reflect.InvocationHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object[] r6) {
                /*
                    r3 = this;
                    java.lang.String r4 = r5.getName()
                    int r5 = r4.hashCode()
                    r6 = 39551382(0x25b8196, float:1.6126768E-37)
                    r0 = 0
                    r1 = 2
                    r2 = 1
                    if (r5 == r6) goto L2f
                    r6 = 690954390(0x292f2096, float:3.888607E-14)
                    if (r5 == r6) goto L25
                    r6 = 1930712422(0x73145566, float:1.1752198E31)
                    if (r5 == r6) goto L1b
                    goto L39
                L1b:
                    java.lang.String r5 = "stopServiceToken"
                    boolean r4 = r4.equals(r5)
                    if (r4 == 0) goto L39
                    r4 = 0
                    goto L3a
                L25:
                    java.lang.String r5 = "getForegroundServiceType"
                    boolean r4 = r4.equals(r5)
                    if (r4 == 0) goto L39
                    r4 = 2
                    goto L3a
                L2f:
                    java.lang.String r5 = "setServiceForeground"
                    boolean r4 = r4.equals(r5)
                    if (r4 == 0) goto L39
                    r4 = 1
                    goto L3a
                L39:
                    r4 = -1
                L3a:
                    if (r4 == 0) goto L48
                    if (r4 == r2) goto L46
                    if (r4 == r1) goto L41
                    goto L46
                L41:
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
                    return r4
                L46:
                    r4 = 0
                    return r4
                L48:
                    com.bytedance.pangle.service.a.a r4 = com.bytedance.pangle.service.a.a.b()
                    android.content.ComponentName r5 = new android.content.ComponentName
                    com.bytedance.pangle.service.PluginService r6 = com.bytedance.pangle.service.PluginService.this
                    java.lang.Class r0 = r6.getClass()
                    java.lang.String r0 = r0.getName()
                    r5.<init>(r6, r0)
                    boolean r4 = r4.a(r5)
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.service.PluginService.AnonymousClass1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
            }
        });
    }
}
