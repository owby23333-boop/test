package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mb {
    private static SharedPreferences mb;

    public static boolean b(long j2) {
        int i2;
        if (mb == null) {
            mb = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        SharedPreferences sharedPreferences = mb;
        if (sharedPreferences != null) {
            i2 = sharedPreferences.getInt("live_init_" + j2, 0);
        } else {
            i2 = 0;
        }
        return i2 < 5;
    }

    public static void hj(long j2) {
        try {
            Zeus.unInstallPlugin("com.byted.live.lite");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ox(j2);
    }

    public static Bundle mb(u uVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("app_id", str);
        String strMb = u.mb("com.byted.live.lite");
        if (TextUtils.isEmpty(strMb)) {
            strMb = "0.0.0.0";
        }
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strMb);
        bundle.putString("sdk_version", mb(TTAppContextHolder.getContext()));
        return bundle;
    }

    public static void ox(long j2) {
        if (mb == null) {
            mb = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        try {
            if (mb != null) {
                SharedPreferences.Editor editorEdit = mb.edit();
                editorEdit.putInt("live_init_" + j2, 0);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void mb(u uVar, final Bundle bundle, final TTPluginListener tTPluginListener) {
        uVar.ox(new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.mb.1
            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public Bundle config() {
                return bundle;
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle2) {
                TTPluginListener tTPluginListener2 = tTPluginListener;
                if (tTPluginListener2 != null) {
                    tTPluginListener2.onPluginListener(i2, classLoader, resources, bundle2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public String packageName() {
                return "com.byted.live.lite";
            }
        });
    }

    public static String mb(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString(TTLiveConstants.LIVE_META_KEY);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return u.mb(new JSONObject(string).optInt(TTLiveConstants.LIVE_API_VERSION_KEY));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean mb(final Context context, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback) {
        try {
            com.bytedance.sdk.openadsdk.ox.mb.mb().mb(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.mb.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.init((Application) context, str, builder, iLiveInitCallback);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean mb() {
        try {
            com.bytedance.sdk.openadsdk.ox.mb.mb().mb(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.mb.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLiveCommerce();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean mb(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey(TTLiveConstants.ROOMID_KEY)) {
            long j2 = bundle.getLong(TTLiveConstants.ROOMID_KEY);
            try {
                IOuterLiveService iOuterLiveService = (IOuterLiveService) LivePluginHelper.getLiveRoomService();
                if (iOuterLiveService == null) {
                    return false;
                }
                iOuterLiveService.enterLiveRoom(context, j2, bundle);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void mb(long j2) {
        if (mb == null) {
            mb = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        try {
            if (mb != null) {
                int i2 = mb.getInt("live_init_" + j2, 0);
                SharedPreferences.Editor editorEdit = mb.edit();
                editorEdit.putInt("live_init_" + j2, i2 + 1);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
