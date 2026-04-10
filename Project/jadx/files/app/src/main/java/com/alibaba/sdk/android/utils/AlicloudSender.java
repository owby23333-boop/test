package com.alibaba.sdk.android.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.tbrest.SendService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UTMini;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudSender {
    private static SendService a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String f43a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicBoolean f44a = new AtomicBoolean(false);
    private static Map<String, SdkInfo> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static ExecutorService f45b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, a> f2236c;

    private static class a {
        private int a;
        private String b;

        private a() {
            this.a = -1;
            this.b = "";
        }
    }

    public static void asyncSend(Application application, SdkInfo sdkInfo) {
        String strB = sdkInfo.b();
        if (application == null || TextUtils.isEmpty(strB)) {
            return;
        }
        a(application, sdkInfo);
        b.put(strB, sdkInfo);
        a(application.getApplicationContext(), sdkInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context, SdkInfo sdkInfo) {
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        a aVar = f2236c.get(sdkInfo.b());
        if (aVar == null) {
            aVar = new a();
            f2236c.put(sdkInfo.b(), aVar);
        } else if (TextUtils.equals(str, aVar.b) && aVar.a == 0) {
            return;
        }
        aVar.b = str;
        aVar.a = -1;
        HashMap map = new HashMap();
        map.put("sdkId", sdkInfo.f2240c);
        map.put("packageName", context.getPackageName());
        map.put(Constants.KEY_SDK_VERSION, sdkInfo.f2241d);
        map.put("kVersion", "2.0.0");
        if (!TextUtils.isEmpty(sdkInfo.f2242e)) {
            map.put(Constants.KEY_APP_KEY, sdkInfo.f2242e);
        }
        if (sdkInfo.f2243f != null) {
            map.putAll(sdkInfo.f2243f);
        }
        map.put("_aliyun_biz_id", "emas-active");
        SendService sendService = a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = f43a;
        StringBuilder sb = new StringBuilder();
        sb.append(sdkInfo.f2240c);
        sb.append("_biz_active");
        aVar.a = sendService.sendRequest("adash-emas.cn-hangzhou.aliyuncs.com", jCurrentTimeMillis, str2, UTMini.EVENTID_AGOO, sb.toString(), (Object) null, (Object) null, map).booleanValue() ? 0 : -1;
        a(context, f2236c);
    }

    private static void a(Application application, SdkInfo sdkInfo) {
        if (f44a.compareAndSet(false, true)) {
            b = new ConcurrentHashMap();
            f2236c = m32a(application.getApplicationContext());
            a = new SendService();
            a.openHttp = true;
            a.init(application.getApplicationContext(), "24527540@android", "24527540", a(application.getApplicationContext()), (String) null, (String) null);
            a.appSecret = "56fc10fbe8c6ae7d0d895f49c4fb6838";
            f45b = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new SynchronousQueue());
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.sdk.android.utils.AlicloudSender.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        if (AlicloudSender.b.isEmpty()) {
                            return;
                        }
                        Iterator it = AlicloudSender.b.values().iterator();
                        while (it.hasNext()) {
                            AlicloudSender.a(activity, (SdkInfo) it.next());
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Context context, final SdkInfo sdkInfo) {
        f45b.execute(new Runnable() { // from class: com.alibaba.sdk.android.utils.AlicloudSender.2
            @Override // java.lang.Runnable
            public void run() {
                AlicloudSender.b(context, sdkInfo);
            }
        });
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static Map<String, a> m32a(Context context) {
        HashMap map = new HashMap();
        String string = context.getSharedPreferences("emas_info", 0).getString("emas_sdk_info", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String string2 = jSONObject.getString("id");
                        a aVar = new a();
                        aVar.b = jSONObject.getString("time");
                        aVar.a = jSONObject.getInt("statu");
                        map.put(string2, aVar);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    private static void a(Context context, Map<String, a> map) {
        if (map != null && !map.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : map.keySet()) {
                a aVar = map.get(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    jSONObject.put("time", aVar.b);
                    jSONObject.put("statu", aVar.a);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
            }
            context.getSharedPreferences("emas_info", 0).edit().putString("emas_sdk_info", jSONArray.toString()).apply();
            return;
        }
        context.getSharedPreferences("emas_info", 0).edit().remove("emas_sdk_info").apply();
    }
}
