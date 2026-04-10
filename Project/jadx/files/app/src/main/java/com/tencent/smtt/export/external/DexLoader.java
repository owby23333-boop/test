package com.tencent.smtt.export.external;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DexLoader {
    private static final String ANDROIDX_PACKAGE_PREFIX = "androidx";
    private static final String CHROMIUM_J_N = "J.N";
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAF_PACKAGE_PREFIX = "com.taf";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mMttClassUseCorePrivate = false;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    private static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
            ClassLoader parent;
            if (str == null) {
                return super.loadClass(str, z2);
            }
            boolean z3 = str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX) || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.ANDROIDX_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX) || str.equals(DexLoader.CHROMIUM_J_N);
            if (DexLoader.mMttClassUseCorePrivate) {
                z3 = z3 || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX);
            }
            if (!z3) {
                return super.loadClass(str, z2);
            }
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                String str2 = "WebCoreClassLoader - loadClass(" + str + "," + z2 + ")...";
                clsFindLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return (clsFindLoadedClass != null || (parent = getParent()) == null) ? clsFindLoadedClass : parent.loadClass(str);
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) throws Throwable {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) throws Throwable {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + File.pathSeparator + str2;
        }
        int i2 = 0;
        ClassLoader classLoader2 = classLoader;
        while (i2 < strArr.length) {
            DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i2], str, str3, classLoader2, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i2++;
            classLoader2 = dexClassLoaderCreateDexClassLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) throws Throwable {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        String str3 = "Set base classLoader for DexClassLoader: " + callingClassLoader;
        int i2 = 0;
        ClassLoader classLoader = callingClassLoader;
        while (i2 < strArr.length) {
            DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i2], str2, str, classLoader, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i2++;
            classLoader = dexClassLoaderCreateDexClassLoader;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01eb  */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private dalvik.system.DexClassLoader createDexClassLoader(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.ClassLoader r20, android.content.Context r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.createDexClassLoader(java.lang.String, java.lang.String, java.lang.String, java.lang.ClassLoader, android.content.Context):dalvik.system.DexClassLoader");
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            delete(file2);
        }
        file.delete();
    }

    public static String getFileNameNoEx(String str) {
        int iLastIndexOf;
        return (str == null || str.length() <= 0 || (iLastIndexOf = str.lastIndexOf(46)) <= -1 || iLastIndexOf >= str.length()) ? str : str.substring(0, iLastIndexOf);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        String str = "initTbsSettings - " + map;
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (obj4 instanceof Boolean) {
                    mMttClassUseCorePrivate = ((Boolean) obj4).booleanValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (mUseTbsCorePrivateClassLoader) {
            return str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
        }
        return false;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable unused) {
            String str3 = "'" + str + "' get field '" + str2 + "' failed";
            return null;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            String str3 = "Not a crash, just message for help." + str + " invoke method '" + str2 + "' failed";
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                String str3 = "Not a crash, just message for help." + str + " invoke static method '" + str2 + "' failed";
                return null;
            }
            String str4 = "Not a crash, just message for help. " + str + " invoke static method '" + str2 + "' failed";
            return th;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable unused) {
            String str2 = "loadClass '" + str + "' failed";
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable unused) {
            String str2 = "create " + str + " instance failed";
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                String str2 = "'newInstance " + str + " failed";
                return th;
            }
            String str3 = "create '" + str + "' instance failed";
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable unused) {
            String str3 = "'" + str + "' set field '" + str2 + "' failed";
        }
    }
}
