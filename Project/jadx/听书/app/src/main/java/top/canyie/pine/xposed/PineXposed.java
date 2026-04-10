package top.canyie.pine.xposed;

import android.content.pm.ApplicationInfo;
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.IXposedMod;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XCallback;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public final class PineXposed {
    public static final String TAG = "PineXposed";
    public static boolean disableHooks;
    public static boolean disableZygoteInitCallbacks;
    private static ExtHandler sExtHandler;
    private static final XposedBridge.CopyOnWriteSortedSet<XC_LoadPackage> sLoadedPackageCallbacks = new XposedBridge.CopyOnWriteSortedSet<>();

    public interface ExtHandler {
        void handle(IXposedMod iXposedMod);
    }

    private PineXposed() {
    }

    public static boolean checkModule(ClassLoader classLoader) {
        boolean z = classLoader instanceof ModuleClassLoader;
        try {
            if ((z ? ((ModuleClassLoader) classLoader).findClass("com.android.tools.fd.runtime.BootstrapApplication") : classLoader.loadClass("com.android.tools.fd.runtime.BootstrapApplication")) != null) {
                Log.e("PineXposed", "  Cannot load module, please disable \"Instant Run\" in Android Studio.");
                return false;
            }
        } catch (ClassNotFoundException e) {
        }
        if (z) {
            try {
                if (((ModuleClassLoader) classLoader).findClass(XposedBridge.class.getName()) == null) {
                    return true;
                }
            } catch (ClassNotFoundException e2) {
                return true;
            }
        } else {
            try {
                if (classLoader.loadClass(XposedBridge.class.getName()) == XposedBridge.class) {
                    return true;
                }
            } catch (ClassNotFoundException e3) {
                Log.e("PineXposed", "  Cannot load module, XposedBridge is not available on the class loader", e3);
                Log.e("PineXposed", "  Make sure you have set parent of the class loader");
                return false;
            }
        }
        Log.e("PineXposed", "  Cannot load module:");
        Log.e("PineXposed", "  The Xposed API classes are compiled into the module's APK.");
        Log.e("PineXposed", "  This may cause strange issues and must be fixed by the module developer.");
        Log.e("PineXposed", "  For details, see: http://api.xposed.info/using.html");
        return false;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static ExtHandler getExtHandler() {
        return sExtHandler;
    }

    public static void hookLoadPackage(IXposedHookLoadPackage iXposedHookLoadPackage) {
        sLoadedPackageCallbacks.add(new IXposedHookLoadPackage.Wrapper(iXposedHookLoadPackage));
    }

    public static void loadModule(File file) {
        loadModule(file, false);
    }

    public static void loadModule(File file, String str, boolean z) {
        if (!file.exists()) {
            Log.e("PineXposed", "  File " + file + " does not exist");
            return;
        }
        ClassLoader classLoader = PineXposed.class.getClassLoader();
        String absolutePath = file.getAbsolutePath();
        loadOpenedModule(absolutePath, new ModuleClassLoader(absolutePath, str, classLoader), z);
    }

    public static void loadModule(File file, boolean z) {
        loadModule(file, null, z);
    }

    public static void loadModule(String str) {
        loadModule(new File(str));
    }

    public static void loadOpenedModule(String str, ClassLoader classLoader, boolean z) {
        InputStream resourceAsStream;
        if (!checkModule(classLoader)) {
            return;
        }
        try {
            if (classLoader instanceof ModuleClassLoader) {
                URL urlFindResource = ((ModuleClassLoader) classLoader).findResource("assets/xposed_init");
                resourceAsStream = urlFindResource != null ? urlFindResource.openStream() : null;
            } else {
                resourceAsStream = classLoader.getResourceAsStream("assets/xposed_init");
            }
            if (resourceAsStream == null) {
                Log.e("PineXposed", "  Failed to load module " + str);
                Log.e("PineXposed", "  assets/xposed_init not found in the module APK");
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        return;
                    }
                    String strTrim = line.trim();
                    if (!strTrim.isEmpty() && !strTrim.startsWith("#")) {
                        try {
                            Class<?> clsLoadClass = classLoader.loadClass(strTrim);
                            if (IXposedMod.class.isAssignableFrom(clsLoadClass)) {
                                IXposedMod iXposedMod = (IXposedMod) clsLoadClass.newInstance();
                                if ((iXposedMod instanceof IXposedHookZygoteInit) && !disableZygoteInitCallbacks) {
                                    IXposedHookZygoteInit.StartupParam startupParam = new IXposedHookZygoteInit.StartupParam();
                                    startupParam.modulePath = str;
                                    startupParam.startsSystemServer = z;
                                    ((IXposedHookZygoteInit) iXposedMod).initZygote(startupParam);
                                }
                                if (iXposedMod instanceof IXposedHookLoadPackage) {
                                    hookLoadPackage((IXposedHookLoadPackage) iXposedMod);
                                }
                                ExtHandler extHandler = sExtHandler;
                                if (extHandler != null) {
                                    extHandler.handle(iXposedMod);
                                }
                            } else {
                                Log.e("PineXposed", "    Cannot load callback class " + strTrim + " in module " + str + " :");
                                Log.e("PineXposed", "    This class doesn't implement any sub-interface of IXposedMod, skipping it");
                            }
                        } catch (Throwable th) {
                            Log.e("PineXposed", "    Failed to load class " + strTrim + " from module " + str + " :", th);
                        }
                    }
                } catch (IOException e) {
                    Log.e("PineXposed", "  Failed to load module " + str);
                    Log.e("PineXposed", "  Cannot read assets/xposed_init in the module APK", e);
                    return;
                } finally {
                    closeQuietly(bufferedReader);
                }
            }
        } catch (IOException e2) {
            Log.e("PineXposed", "  Failed to load module " + str);
            Log.e("PineXposed", "  Cannot open assets/xposed_init in the module APK", e2);
        }
    }

    public static void onPackageLoad(String str, String str2, ApplicationInfo applicationInfo, boolean z, ClassLoader classLoader) {
        XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(sLoadedPackageCallbacks);
        loadPackageParam.packageName = str;
        loadPackageParam.processName = str2;
        loadPackageParam.appInfo = applicationInfo;
        loadPackageParam.isFirstApplication = z;
        loadPackageParam.classLoader = classLoader;
        XCallback.callAll(loadPackageParam);
    }

    public static void setExtHandler(ExtHandler extHandler) {
        sExtHandler = extHandler;
    }
}
