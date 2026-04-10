package com.bytedance.pangle.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class dl {
    /* JADX WARN: Multi-variable type inference failed */
    static void z(g gVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            m.gc(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            gVar.zeusSuperOnCreate(null);
            gVar.finish();
            return;
        }
        Intent intent = gVar.getIntent();
        String pluginPkgName = gVar.getPluginPkgName();
        Plugin plugin = gVar.getPlugin();
        if (plugin == null) {
            m.gc(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            gVar.zeusSuperOnCreate(null);
            gVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.z(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(gVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                gVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                gVar.finish();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            gVar.zeusSuperOnCreate(null);
            gVar.finish();
        }
        int i = -1;
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", gVar.getApplication());
            gVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(gVar, plugin);
            i = activityInfo.theme;
            gVar.zeusSuperSetTheme(i);
            TypedArray typedArrayObtainStyledAttributes = ((Activity) gVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (typedArrayObtainStyledAttributes.getBoolean(typedArrayObtainStyledAttributes.getIndex(0), false)) {
                z((Activity) gVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(gVar.getBaseContext());
            try {
                if (((Activity) gVar).getRequestedOrientation() != activityInfo.screenOrientation) {
                    ((Activity) gVar).setRequestedOrientation(activityInfo.screenOrientation);
                }
            } catch (IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e2) {
            throw new RuntimeException(e2 instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i)) : "", e2);
        }
    }

    static void z(g gVar, Context context) {
        if (!Zeus.hasInit()) {
            m.gc(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            gVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = gVar.getPluginPkgName();
        boolean zLoadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            gVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (zLoadPlugin) {
                gVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(gVar, "mResources", (Object) null);
            } else {
                gVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void z(Activity activity, View view) {
        Object field;
        if (view == null) {
            return;
        }
        try {
            Object field2 = FieldUtils.readField(view, "mListenerInfo");
            if (field2 != null && (field = FieldUtils.readField(field2, "mOnClickListener")) != null) {
                String name = field.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new z(activity, view.getId(), (String) FieldUtils.readField(field, "mMethodName")));
                }
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            m.z(e);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            z(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    private static Class z() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void z(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", z(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
