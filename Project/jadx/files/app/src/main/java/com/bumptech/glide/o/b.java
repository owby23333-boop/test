package com.bumptech.glide.o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: ApplicationVersionSignature.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final ConcurrentMap<String, com.bumptech.glide.load.c> a = new ConcurrentHashMap();

    @NonNull
    private static String a(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    public static com.bumptech.glide.load.c b(@NonNull Context context) {
        String packageName = context.getPackageName();
        com.bumptech.glide.load.c cVar = a.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        com.bumptech.glide.load.c cVarC = c(context);
        com.bumptech.glide.load.c cVarPutIfAbsent = a.putIfAbsent(packageName, cVarC);
        return cVarPutIfAbsent == null ? cVarC : cVarPutIfAbsent;
    }

    @NonNull
    private static com.bumptech.glide.load.c c(@NonNull Context context) {
        return new d(a(a(context)));
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = "Cannot resolve info for" + context.getPackageName();
            return null;
        }
    }
}
