package com.bytedance.sdk.openadsdk.core.un;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class js {
    public static void z() {
        Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        if (context != null && com.bytedance.sdk.component.utils.wp.dl()) {
            z(context);
            String packageName = context.getPackageName();
            int i = context.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = context.getPackageManager();
            boolean z2 = false;
            boolean z3 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                        com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                    } else {
                        com.bytedance.sdk.openadsdk.tools.g.dl(3, "1");
                    }
                    z2 = true;
                } else if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                    if (i < 24) {
                        com.bytedance.sdk.component.utils.wp.z("TTAdSdk-InitChecker", "TTFileProvider不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=24");
                        com.bytedance.sdk.openadsdk.tools.g.dl(3, "1");
                    } else {
                        if (providerInfo.exported) {
                            com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                            com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                        }
                        if (!providerInfo.grantUriPermissions) {
                            com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                            com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                        }
                        try {
                            List<z> listZ = z(context, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                            if (listZ != null && !listZ.isEmpty()) {
                                List<z> listDl = dl();
                                List<z> listA = a();
                                for (z zVar : listZ) {
                                    if (zVar != null) {
                                        listDl.remove(zVar);
                                        listA.remove(zVar);
                                    }
                                }
                                if (listDl.isEmpty() && listA.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.tools.g.dl(3, "1");
                                } else {
                                    Iterator<z> it = listDl.iterator();
                                    while (it.hasNext()) {
                                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                    }
                                    Iterator<z> it2 = listA.iterator();
                                    while (it2.hasNext()) {
                                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                    }
                                    com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                                }
                            } else {
                                com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.wp.dl("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                            com.bytedance.sdk.openadsdk.tools.g.dl(3, "0");
                        }
                    }
                    z3 = true;
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> listG = g();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            listG.remove(str2);
                        }
                    }
                    if (!listG.isEmpty()) {
                        Iterator<String> it3 = listG.iterator();
                        while (it3.hasNext()) {
                            com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                } else {
                    com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.wp.dl("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            try {
                if (i < 23) {
                    com.bytedance.sdk.component.utils.wp.z("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                } else {
                    boolean z4 = com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, com.kuaishou.weapon.p0.g.c);
                    boolean z5 = com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, com.kuaishou.weapon.p0.g.h);
                    boolean z6 = com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, com.kuaishou.weapon.p0.g.g);
                    boolean z7 = com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, com.kuaishou.weapon.p0.g.j);
                    if (!z4) {
                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                    }
                    if (!z5) {
                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (!z6) {
                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                    }
                    if (!z7) {
                        com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.wp.dl("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
            }
            if (!z2) {
                com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
            }
            if (z3) {
                return;
            }
            com.bytedance.sdk.component.utils.wp.a("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
        }
    }

    private static String z(Context context) {
        try {
            return com.bytedance.sdk.component.utils.p.g(context);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.f1857a);
        arrayList.add(com.kuaishou.weapon.p0.g.b);
        arrayList.add(com.kuaishou.weapon.p0.g.d);
        arrayList.add(com.kuaishou.weapon.p0.g.c);
        arrayList.add(com.kuaishou.weapon.p0.g.j);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add(com.kuaishou.weapon.p0.g.h);
        arrayList.add(com.kuaishou.weapon.p0.g.g);
        return arrayList;
    }

    private static List<z> dl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new z("external-path", "tt_external_download", "Download"));
        arrayList.add(new z("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new z("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new z("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<z> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new z("external-path", "tt_external_root", FileUtils.FILE_EXTENSION_SEPARATOR));
        return arrayList;
    }

    private static List<z> z(Context context, int i) {
        XmlResourceParser xml;
        try {
            ArrayList arrayList = new ArrayList();
            xml = context.getResources().getXml(i);
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        int attributeCount = xml.getAttributeCount();
                        String attributeValue = null;
                        String attributeValue2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xml.getAttributeName(i2);
                            if (attributeName.equals("name")) {
                                attributeValue = xml.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                attributeValue2 = xml.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(attributeValue2)) {
                            arrayList.add(new z(name, attributeValue, attributeValue2));
                        }
                    }
                }
                if (xml != null) {
                    xml.close();
                }
                return arrayList;
            } catch (Throwable unused) {
                if (xml != null) {
                    xml.close();
                }
                return null;
            }
        } catch (Throwable unused2) {
            xml = null;
        }
    }

    private static class z {
        String dl;
        String g;
        String z;

        z(String str, String str2, String str3) {
            this.z = str;
            this.g = str2;
            this.dl = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof z) {
                z zVar = (z) obj;
                String str2 = this.z;
                return str2 != null && str2.equals(zVar.z) && (str = this.dl) != null && str.equals(zVar.dl);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.z + " name=\"" + this.g + "\" path=\"" + this.dl + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }
}
