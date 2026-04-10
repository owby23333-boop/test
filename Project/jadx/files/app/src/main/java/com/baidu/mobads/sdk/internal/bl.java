package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    public static final String a = "ContainerFactoryBuilder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static IXAdContainerFactory f12924e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f12925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class<?> f12926d;
    public double b = 0.1d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private bq f12927f = bq.a();

    public bl(Class<?> cls, Context context) {
        this.f12926d = null;
        this.f12926d = cls;
        this.f12925c = context;
    }

    public IXAdContainerFactory a() throws bw.a {
        if (f12924e == null) {
            try {
                f12924e = (IXAdContainerFactory) this.f12926d.getDeclaredConstructor(Context.class).newInstance(this.f12925c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.am.bd, "9.26");
                f12924e.initConfig(jSONObject);
                this.b = f12924e.getRemoteVersion();
                f12924e.onTaskDistribute(az.a, MobadsPermissionSettings.getPermissionInfo());
                f12924e.initCommonModuleObj(q.a());
            } catch (Throwable th) {
                this.f12927f.b(a, th.getMessage());
                throw new bw.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f12924e;
    }

    public void b() {
        f12924e = null;
    }
}
