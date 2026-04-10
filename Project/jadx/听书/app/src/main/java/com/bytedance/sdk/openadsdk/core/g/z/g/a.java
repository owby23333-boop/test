package com.bytedance.sdk.openadsdk.core.g.z.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.sy;
import com.bytedance.sdk.openadsdk.core.g.z.g.gc;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static volatile a z;
    private Object dl;
    private boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1071a = new AtomicBoolean(false);
    private AtomicInteger gc = new AtomicInteger(3);
    private AtomicBoolean m = new AtomicBoolean(false);

    private a() {
        this.g = false;
        try {
            Object obj = Class.forName("com.tencent.mm.opensdk.constants.Build").getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                this.g = "android 5.3.1".toLowerCase(Locale.ROOT).compareTo(((String) obj).toLowerCase(Locale.ROOT)) <= 0;
            }
        } catch (Throwable unused) {
            this.g = false;
        }
    }

    public boolean z() {
        return this.g;
    }

    public int g() {
        return this.g ? 1 : 0;
    }

    public static a dl() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    private void z(String str) {
        Method methodZ;
        if (!this.f1071a.get() && this.gc.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                z("wc_init_fail", "error_appid");
                return;
            }
            if (!a()) {
                z("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.g) {
                z("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method methodZ2 = sy.z("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (methodZ2 != null) {
                    Function<SparseArray<Object>, Object> functionGb = uy.ls().gb();
                    Object objApply = functionGb != null ? functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Context.class).g()) : null;
                    if (objApply == null) {
                        objApply = zw.getContext();
                    }
                    if (objApply == null && (methodZ = sy.z("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodZ.invoke(null, new Object[0]);
                    }
                    if (objApply == null) {
                        z("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.dl = methodZ2.invoke(null, objApply, str);
                    z("wc_init_suc", "");
                    this.f1071a.set(true);
                }
            } catch (Throwable th) {
                z("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private boolean a() {
        Context context = zw.getContext();
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (com.bytedance.sdk.openadsdk.core.un.uy.z(intent, 0).size() > 0) {
            return true;
        }
        if (eo.g(context)) {
            return false;
        }
        return eo.z("com.tencent.mm");
    }

    private void z(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.q.z.g<com.bytedance.sdk.openadsdk.core.q.z.g> gVarG = com.bytedance.sdk.openadsdk.core.q.z.g.g();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                gVarG.g(jSONObject.toString());
            }
            gVarG.z(str);
            v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.a.1
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                    return gVarG;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    private void gc() {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                hh.g(zw.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public void z(na naVar, String str, String str2, final gc.z zVar, String str3, boolean z2) {
        try {
            if (naVar == null) {
                zVar.g();
                gc();
                return;
            }
            ja jaVarFx = naVar.fx();
            if (jaVarFx == null) {
                z("wc_init_fail", "wechat data is null");
                zVar.g();
                gc();
                return;
            }
            z(jaVarFx.gz());
            if (this.dl == null) {
                zVar.g();
                gc();
                return;
            }
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, str);
            Field declaredField2 = cls.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(objNewInstance, str2);
            Field declaredField3 = cls.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(objNewInstance, cls.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(objNewInstance, 0);
            }
            Method method = this.dl.getClass().getMethod("sendReq", cls.getSuperclass());
            jaVarFx.g(2);
            com.bytedance.sdk.openadsdk.core.i.a.z(naVar, str3, "deeplink_success_realtime", (Throwable) null);
            HashMap map = new HashMap();
            map.put("source", "WeChatOpenSdkProcessor");
            com.bytedance.sdk.openadsdk.core.i.a.gz(naVar, str3, "open_url_app", map);
            com.bytedance.sdk.openadsdk.core.i.e.z().z(naVar, str3, z2);
            method.invoke(this.dl, objNewInstance);
            e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    zVar.z();
                }
            });
        } catch (Throwable th) {
            z("wc_init_fail", "invoke:" + th.getMessage());
            zVar.g();
            gc();
        }
    }
}
