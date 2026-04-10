package com.kwai.sodler.lib.kwai.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.r;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static Map<String, Resources> aaq = new HashMap();
    private static final Object aar = new Object();

    /* JADX INFO: renamed from: com.kwai.sodler.lib.kwai.a.a$a, reason: collision with other inner class name */
    static final class C0476a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) r.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0476a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) r.c("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0476a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) r.c("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return g(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0476a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) r.c("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0476a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) r.c("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class f {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0476a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) r.c("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                r.c(resources2, "init", context.getPackageName());
            } catch (Exception e2) {
                com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources init failed", e2);
            }
            try {
                r.b(resources2, "mThemeValues", r.e(resources, "mThemeValues"));
            } catch (Exception e3) {
                com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e3);
            }
            return resources2;
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        return a(resources) ? d.a(resources, assetManager) : b(resources) ? c.a(resources, assetManager) : e(resources) ? b.a(resources, assetManager) : c(resources) ? f.a(context, resources, assetManager) : d(resources) ? e.a(resources, assetManager) : f(resources) ? C0476a.a(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        Resources resourcesB;
        synchronized (aar) {
            resourcesB = aaq.get(str);
            if (resourcesB == null) {
                resourcesB = b(context, resources, str);
                if (resourcesB == null) {
                    throw new RuntimeException("Can not createResources for " + str);
                }
                aaq.put(str, resources);
            }
        }
        return resourcesB;
    }

    private static void a(AssetManager assetManager, String str) {
        try {
            r.c(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            r.c(assetManager, "addAssetPath", str);
        }
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                r.c(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                r.c(assetManager, "addAssetPath", str);
            }
        } catch (Throwable unused) {
            r.c(assetManager, "addAssetPath", str);
        }
        return 0;
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) r.i(AssetManager.class);
        r.c(assetManager, "addAssetPath", str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object objD = r.d(applicationInfo, "resourceDirs");
                if (objD != null && objD.getClass().isArray()) {
                    Object[] objArr = (Object[]) objD;
                    if (objArr.length > 0) {
                        for (Object obj : objArr) {
                            if (obj instanceof String) {
                                a(assetManager, (String) obj);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (applicationInfo.sharedLibraryFiles != null && applicationInfo.sharedLibraryFiles.length > 0) {
                    for (String str2 : applicationInfo.sharedLibraryFiles) {
                        if (str2 != null && str2.endsWith(com.anythink.china.common.a.a.f6395g)) {
                            b(assetManager, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    private static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    private static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    private static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    private static boolean f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }
}
