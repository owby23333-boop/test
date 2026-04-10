package top.canyie.pine.xposed;

import dalvik.system.PathClassLoader;
import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class ModuleClassLoader extends PathClassLoader {
    public ModuleClassLoader(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    public ModuleClassLoader(String str, String str2, ClassLoader classLoader) {
        super(str, str2, classLoader);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) {
        return super.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        return super.findResource(str);
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        URL resource = Object.class.getClassLoader().getResource(str);
        if (resource != null) {
            return resource;
        }
        URL urlFindResource = findResource(str);
        if (urlFindResource != null) {
            return urlFindResource;
        }
        ClassLoader parent = getParent();
        if (parent == null) {
            return null;
        }
        return parent.getResource(str);
    }

    public URL getResourceNoDelegate(String str) {
        return super.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) {
        return new CompoundEnumeration(new Enumeration[]{Object.class.getClassLoader().getResources(str), findResources(str), getParent() == null ? null : getParent().getResources(str)});
    }

    public Enumeration<URL> getResourcesNoDelegate(String str) {
        return super.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            return Object.class.getClassLoader().loadClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e2) {
                try {
                    return getParent().loadClass(str);
                } catch (ClassNotFoundException e3) {
                    throw e2;
                }
            }
        }
    }

    public Class<?> loadClassNoDelegate(String str, boolean z) {
        return super.loadClass(str, z);
    }
}
