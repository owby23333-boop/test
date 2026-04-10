package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class e {
    private static final List<String> Zl;

    static class a extends DexClassLoader {
        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        private static boolean aQ(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z2) {
            if (aQ(str)) {
                return getParent().loadClass(str);
            }
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return clsFindLoadedClass != null ? clsFindLoadedClass : super.loadClass(str, z2);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        Zl = arrayList;
        arrayList.add("com.kwad.sdk");
        Zl.add("com.ksad");
        Zl.add("com.kwai");
        Zl.add("kwad.support");
        Zl.add("android.support.rastermill");
    }

    @NonNull
    static ClassLoader a(Context context, String str, String str2, String str3) {
        return new a(str, str2, str3, context.getClassLoader());
    }
}
