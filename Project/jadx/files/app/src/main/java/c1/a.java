package c1;

import com.sntech.proxylib.ProxyClassLoaders;
import dalvik.system.DexClassLoader;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: MyDexClassLoader.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends DexClassLoader {
    public Set<String> a;

    public a(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add("com.sn.android.transform.DexTransformUtils");
        this.a.add("com.sntech.net.DomainManager");
        this.a.add("com.sntech.net.DomainConfig");
        this.a.add("com.sntech.net.DomainProvider");
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (this.a.contains(str)) {
            clsFindLoadedClass = super.loadClass(str, z2);
        }
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            clsFindLoadedClass = findClass(str);
        } catch (ClassNotFoundException unused) {
        }
        if (clsFindLoadedClass == null) {
            try {
                clsFindLoadedClass = super.loadClass(str, z2);
            } catch (ClassNotFoundException unused2) {
            }
        }
        return clsFindLoadedClass == null ? ProxyClassLoaders.loadClass(str) : clsFindLoadedClass;
    }
}
