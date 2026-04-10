package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static Map<String, Integer> a = new HashMap();
    private LinkedHashMap<String, Integer> b = new LinkedHashMap<>();

    static {
        List<String> listA = j.a();
        if (listA == null || listA.size() <= 0) {
            return;
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            a.put(it.next(), 0);
        }
    }

    public a() {
        this.b.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private static AssetManager b(AssetManager assetManager, String str, boolean z2) {
        String str2 = "addAssetPath";
        String str3 = z2 ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z2 && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z2) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i3 = 3;
            while (true) {
                int i4 = i3 - 1;
                if (i3 < 0) {
                    break;
                }
                try {
                    int iIntValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    if (iIntValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + iIntValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + iIntValue + " " + str);
                } catch (Exception e2) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z2 + ", methodName = " + str2, e2);
                }
                i3 = i4;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z2 + " methodName:" + str2);
        }
        return assetManager;
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z2) {
        int iIntValue;
        int i2 = 3;
        Throwable th = null;
        int i3 = 3;
        loop0: while (true) {
            int i4 = i3 - 1;
            if (i3 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    iIntValue = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        try {
                            if (i.c()) {
                                iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else if (Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 25) {
                                iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z2)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                            }
                            if (iIntValue != 0) {
                                break loop0;
                            }
                        } finally {
                        }
                    }
                    break loop0;
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = i4;
                i2 = 3;
            }
        }
        if (iIntValue == 0) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + iIntValue + " " + str);
        } else {
            Object field = FieldUtils.readField(assetManager, "mStringBlocks");
            int length = field != null ? Array.getLength(field) : 0;
            int iIntValue2 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            Object objNewInstance = Array.newInstance(field.getClass().getComponentType(), iIntValue2);
            for (int i6 = 0; i6 < iIntValue2; i6++) {
                if (i6 < length) {
                    Array.set(objNewInstance, i6, Array.get(field, i6));
                } else {
                    Array.set(objNewInstance, i6, MethodUtils.invokeConstructor(field.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i6)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                }
            }
            FieldUtils.writeField(assetManager, "mStringBlocks", objNewInstance);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z2) {
        AssetManager assetManagerA;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(String.valueOf(str)));
            return assetManager;
        }
        if (!i.a()) {
            assetManagerA = a(assetManager, str);
        } else if (i.d()) {
            assetManagerA = c(assetManager, str, z2);
            if (!j.a(assetManagerA, str)) {
                assetManagerA = b(assetManager, str, z2);
            }
        } else {
            assetManagerA = b(assetManager, str, z2);
        }
        synchronized (this.b) {
            this.b.put(str, 0);
        }
        return assetManagerA;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> listA = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : listA) {
            if (!a.containsKey(str2) && !this.b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.b) {
                for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
                    if (!a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if ((Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", com.anythink.expressad.foundation.h.i.f10649g, DispatchConstants.ANDROID)), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e2);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e3);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e4) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e4);
        }
        return assetManager;
    }
}
