package me.jessyan.art.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ManifestParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private final Context a;

    public i(Context context) {
        this.a = context;
    }

    public List<e> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("ConfigModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(a(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse ConfigModule", e2);
        }
    }

    private static e a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof e) {
                    return (e) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof ConfigModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + cls, e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new IllegalArgumentException("Unable to find ConfigModule implementation", e4);
        }
    }
}
