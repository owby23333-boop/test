package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z(com.bytedance.pangle.wrapper.z zVar, Activity activity) {
        try {
            FieldUtils.writeField(zVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) zVar, "mThemeResource", (Object) 0);
            int[] iArrZ = z(activity);
            if (iArrZ == null) {
                return;
            }
            for (int i : iArrZ) {
                if (i != 0) {
                    zVar.setWrapperActivityTheme(i);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
        }
    }

    private static int[] z(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (fo.kb()) {
                Object field = FieldUtils.readField(theme, "mThemeImpl");
                if (field == null) {
                    return null;
                }
                try {
                    Object objInvokeMethod = MethodUtils.invokeMethod(field, "getKey", new Object[0]);
                    if (objInvokeMethod != null) {
                        return (int[]) FieldUtils.readField(objInvokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object objInvoke = com.bytedance.pangle.g.g.z.z(field.getClass(), "getKey", new Class[0]).invoke(field, new Object[0]);
                if (objInvoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.bytedance.pangle.g.g.z.z(objInvoke.getClass(), "mResId").get(objInvoke);
            }
            if (fo.g()) {
                Object objInvokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (objInvokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(objInvokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    public static void z(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] iArrZ = z(activity);
            if (iArrZ == null) {
                return;
            }
            for (int i : iArrZ) {
                if (i != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
        }
    }
}
