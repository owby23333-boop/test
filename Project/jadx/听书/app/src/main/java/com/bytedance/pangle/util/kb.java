package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class kb {
    private static String g;
    static volatile ArrayList<String> z;

    public static List<String> z() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
            assetManager = null;
        }
        return z(assetManager);
    }

    public static List<String> z(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (fo.pf()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i = 0; i < iIntValue; i++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static boolean z(AssetManager assetManager, String str) {
        try {
            if (fo.pf()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i = 0;
                while (i < iIntValue) {
                    i++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    public static String g(AssetManager assetManager) {
        return z(z(assetManager));
    }

    public static String z(List<String> list) {
        StringBuilder sb = new StringBuilder("[");
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static synchronized List<String> g() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, TtmlNode.START);
        if (z == null) {
            synchronized (kb.class) {
                if (z == null) {
                    z = new ArrayList<>();
                    if (fo.gc()) {
                        try {
                            Resources resources = Zeus.getAppApplication().getResources();
                            z.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", TypedValues.Custom.S_STRING, "android")), 0).getApplicationInfo().sourceDir);
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e);
                        }
                    } else if (fo.kb()) {
                        try {
                            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                            if (fo.ls()) {
                                Collections.addAll(z, z(((Context) objInvokeStaticMethod).getApplicationInfo()));
                            } else {
                                String str = ((Context) objInvokeStaticMethod).getApplicationInfo().sourceDir;
                                z.add(str);
                            }
                        } catch (Exception e2) {
                            ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e2);
                        }
                    }
                }
            }
        }
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "finish :" + z);
        return z;
    }

    private static String[] z(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.g.g.z.z((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        if (applicationInfo.sourceDir != null) {
            arrayList.add(applicationInfo.sourceDir);
        }
        for (int i = 0; i < 3; i++) {
            String[] strArr3 = strArr2[i];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
