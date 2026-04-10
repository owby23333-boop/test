package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
public class SplitCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<SplitCompat> f6926a = new AtomicReference<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6927b;
    private final c c;
    private final Set<String> d = new HashSet();

    private SplitCompat(Context context) {
        this.f6927b = context;
        try {
            this.c = new c(context.getFilesDir(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            throw new com.google.android.play.core.a.k("Failed to initialize FileStorage", e);
        }
    }

    public static boolean install(Context context) {
        return a(context, false);
    }

    private final synchronized void a(boolean z) {
        if (z) {
            this.c.a();
        } else {
            a.a().execute(new m(this));
        }
        Set<o> setB = b(z);
        d dVar = new d(this.c);
        com.google.android.play.core.splitcompat.b.a aVarA = com.google.android.play.core.splitcompat.b.b.a();
        ClassLoader classLoader = this.f6927b.getClassLoader();
        if (z) {
            aVarA.a(classLoader, dVar.a());
        } else {
            Iterator<o> it = setB.iterator();
            while (it.hasNext()) {
                Set<File> setA = dVar.a(it.next());
                if (setA == null) {
                    it.remove();
                } else {
                    aVarA.a(classLoader, setA);
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (o oVar : setB) {
            if (aVarA.a(classLoader, this.c.c(oVar.a()), oVar.b(), z)) {
                hashSet.add(oVar.b());
            }
        }
        AssetManager assets = this.f6927b.getAssets();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) com.google.android.play.core.splitcompat.c.b.a(assets, "addAssetPath", Integer.class, String.class, ((File) it2.next()).getPath())).intValue();
            StringBuilder sb = new StringBuilder(39);
            sb.append("addAssetPath completed with ");
            sb.append(iIntValue);
            Log.d("SplitCompat", sb.toString());
        }
        for (o oVar2 : setB) {
            String strA = oVar2.a();
            StringBuilder sb2 = new StringBuilder(String.valueOf(strA).length() + 30);
            sb2.append("Split '");
            sb2.append(strA);
            sb2.append("' installation emulated");
            Log.d("SplitCompat", sb2.toString());
            this.d.add(oVar2.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Set<String> b() {
        return new HashSet(this.d);
    }

    public static boolean a() {
        return f6926a.get() != null;
    }

    private final Set<o> b(boolean z) throws IOException {
        String packageName = this.f6927b.getPackageName();
        try {
            String[] strArr = this.f6927b.getPackageManager().getPackageInfo(packageName, 0).splitNames;
            List arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
            Set<o> setC = this.c.c();
            HashSet hashSet = new HashSet();
            Iterator<o> it = setC.iterator();
            while (it.hasNext()) {
                String strA = it.next().a();
                if (arrayList.contains(strA)) {
                    if (z) {
                        this.c.f(strA);
                    } else {
                        hashSet.add(strA);
                    }
                    it.remove();
                }
            }
            if (!hashSet.isEmpty()) {
                a.a().execute(new n(this, hashSet));
            }
            return setC;
        } catch (PackageManager.NameNotFoundException e) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e);
        }
    }

    public static boolean a(Context context) {
        return a(context, true);
    }

    private static boolean a(Context context, boolean z) {
        return true;
    }
}
