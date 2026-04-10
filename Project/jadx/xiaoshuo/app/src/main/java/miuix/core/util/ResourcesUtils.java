package miuix.core.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
public class ResourcesUtils {
    private static Method ASSET_MANAGER_ADD_ASSET_PATH;
    private static Constructor<AssetManager> ASSET_MANAGER_CONSTRUCTOR;

    static {
        try {
            ASSET_MANAGER_ADD_ASSET_PATH = AssetManager.class.getMethod("addAssetPath", String.class);
            ASSET_MANAGER_CONSTRUCTOR = AssetManager.class.getConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private ResourcesUtils() {
    }

    public static Resources createResources(String... strArr) {
        return createResources(null, strArr);
    }

    public static Resources createResources(Resources resources, String... strArr) {
        AssetManager assetManagerNewInstance;
        try {
            assetManagerNewInstance = ASSET_MANAGER_CONSTRUCTOR.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            e = e;
            assetManagerNewInstance = null;
        } catch (InstantiationException e2) {
            e = e2;
            assetManagerNewInstance = null;
        } catch (InvocationTargetException e3) {
            e = e3;
            assetManagerNewInstance = null;
        }
        try {
            for (String str : strArr) {
                ASSET_MANAGER_ADD_ASSET_PATH.invoke(assetManagerNewInstance, str);
            }
        } catch (IllegalAccessException e4) {
            e = e4;
            e.printStackTrace();
        } catch (InstantiationException e5) {
            e = e5;
            e.printStackTrace();
        } catch (InvocationTargetException e6) {
            e = e6;
            e.printStackTrace();
        }
        return resources == null ? new Resources(assetManagerNewInstance, null, null) : new Resources(assetManagerNewInstance, resources.getDisplayMetrics(), resources.getConfiguration());
    }
}
