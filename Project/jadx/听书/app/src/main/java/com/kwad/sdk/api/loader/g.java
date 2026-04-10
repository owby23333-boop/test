package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class g {
    private static final List<String> auc;

    static {
        ArrayList arrayList = new ArrayList();
        auc = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (b.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }

    public static class a extends DexClassLoader {
        private final ClassLoader aud;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.aud = classLoader;
            classLoader.getClass().getName();
        }

        private static boolean cr(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("com.kwad.sdk.api") || str.startsWith("com.kwad.sdk.liteapi");
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) {
            if (cr(str)) {
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
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = super.loadClass(str, z);
            } catch (ClassNotFoundException unused2) {
            }
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException unused3) {
                return clsFindLoadedClass;
            }
        }
    }
}
