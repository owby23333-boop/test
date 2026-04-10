package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.taobao.accs.common.Constants;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public enum TbsPrivacyAccess {
    DeviceId(false),
    Imsi(false),
    AndroidId(false),
    MacAddress(false),
    AndroidVersion(true),
    DeviceModel(true),
    AppList(true);


    @Deprecated
    private static boolean a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18917c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f18918d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f18919e = null;
    private boolean b;

    public enum ConfigurablePrivacy {
        IMSI(Constants.KEY_IMSI),
        ANDROID_ID("android_id"),
        MAC("mac"),
        ANDROID_VERSION("android_version"),
        DEVICE_MODEL("device_model"),
        APP_LIST("app_list"),
        QIMEI36("q36"),
        MODEL("model"),
        OAID("oaid"),
        SERIAL("serial"),
        ACTION(NativeAdvancedJsUtils.f8246p),
        QB_INSTALLED("qb_installed");

        String a;

        ConfigurablePrivacy(String str) {
            this.a = str;
        }
    }

    TbsPrivacyAccess(boolean z2) {
        this.b = z2;
    }

    private static void a(Context context, SharedPreferences.Editor editor, ConfigurablePrivacy configurablePrivacy, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TbsLog.i("TbsPrivacy", "doConfigPrivacy  " + configurablePrivacy.a + " is " + str);
        if (!TextUtils.isEmpty(configurablePrivacy.a) && configurablePrivacy.a.equals(NativeAdvancedJsUtils.f8246p)) {
            a(context, str);
            return;
        }
        editor.putString(configurablePrivacy.a, str);
        TbsLog.i("TbsPrivacy", "configurePrivacy " + configurablePrivacy.a + " is " + str);
    }

    private static void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && FileUtil.a(context) && str.equals("deleteQBApk")) {
                String str2 = Environment.getExternalStorageDirectory() + File.separator;
                if (!str2.equals("")) {
                    str2 = str2 + "Android" + File.separator + "data" + File.separator + f18917c + File.separator + "files" + File.separator + "Download";
                }
                File file = new File(str2);
                TbsLog.i("TbsPrivacy", "doActionByApp QbApkDir is " + file.getAbsolutePath());
                FileUtil.b(file);
            }
        } catch (Throwable th) {
            TbsLog.i("TbsPrivacy", "doActionByApp stack is " + Log.getStackTraceString(th));
        }
    }

    public static void configureAllPrivacy(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String strI = com.tencent.smtt.utils.s.i(context);
            TbsLog.i("TbsPrivacy", "configureAllPrivacy state is " + strI);
            if (bundle.containsKey("qimei36") && !strI.contains("qimei36")) {
                bundle.putString(ConfigurablePrivacy.QIMEI36.a, bundle.getString("qimei36"));
            }
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                TbsLog.i("TbsPrivacy", "configureAllPrivacy bundle key is " + it.next());
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
            f18917c = context.getApplicationInfo().packageName;
            for (ConfigurablePrivacy configurablePrivacy : ConfigurablePrivacy.values()) {
                if (bundle.containsKey(configurablePrivacy.a) && !strI.contains(configurablePrivacy.a)) {
                    a(context, editorEdit, configurablePrivacy, bundle.getString(configurablePrivacy.a));
                }
            }
            editorEdit.putString("app_call", "done");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configureAllPrivacy(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            String strI = com.tencent.smtt.utils.s.i(context);
            TbsLog.i("TbsPrivacy", "configureAllPrivacy state is " + strI);
            if (strI.contains("app_list")) {
                return;
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
            editorEdit.putString("app_list", str);
            editorEdit.putString("app_call", "done");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("uifa", 0).edit();
        a(context, editorEdit, configurablePrivacy, str);
        editorEdit.commit();
    }

    @Deprecated
    public static void disableSensitiveApi() {
        a = false;
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.NO_SENSITIVE_API, true);
        QbSdk.initTbsSettings(map);
    }

    public static String getConfigurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        return context.getSharedPreferences("uifa", 0).getString(configurablePrivacy.a, str);
    }

    public static String[] getItemToRmPrivacy() {
        return f18919e;
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return a;
    }

    public static void rmPrivacyItemIfNeeded(Context context) {
        try {
            TbsLog.i("TbsPrivacy", "mRmPrivacyItemChecked is " + f18918d);
            if (f18918d) {
                return;
            }
            f18918d = true;
            String strI = com.tencent.smtt.utils.s.i(context);
            TbsLog.i("TbsPrivacy", "rmPrivacyItemIfNeeded state is " + strI);
            if (strI.equals("removenone")) {
                f18919e = null;
                return;
            }
            f18919e = strI.split("\\|");
            TbsLog.i("TbsPrivacy", "rmPrivacyItemIfNeeded mItemToRmPrivacy is " + f18919e);
            SharedPreferences sharedPreferences = context.getSharedPreferences("uifa", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (String str : f18919e) {
                if (sharedPreferences.contains(str)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            TbsLog.i("TbsPrivacy", "stack is " + Log.getStackTraceString(th));
        }
    }

    public boolean isDisabled() {
        return !this.b;
    }

    public boolean isEnabled() {
        return this.b;
    }

    public void setEnabled(boolean z2) {
        this.b = z2;
        TbsLog.i("TbsPrivacy", name() + " is " + z2);
    }
}
