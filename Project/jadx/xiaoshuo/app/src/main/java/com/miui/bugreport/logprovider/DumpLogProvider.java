package com.miui.bugreport.logprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaomi.onetrack.api.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class DumpLogProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final File f7185a = new File("/");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile HashMap<String, File> f7186b = new HashMap<>();

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f7186b.putAll(a(getContext(), "com.miui.bugreport.DEFAULT_LOG_DIR"));
        f7186b.putAll(a(getContext(), "com.miui.bugreport.LOG_DIR"));
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        File file;
        String canonicalPath;
        Iterator<Map.Entry<String, File>> it;
        if (!a(getContext())) {
            return null;
        }
        String path = Uri.parse(Uri.decode(uri.toString())).getPath();
        if (TextUtils.isEmpty(path)) {
            throw new FileNotFoundException();
        }
        try {
            file = new File(path);
            canonicalPath = file.getCanonicalPath();
            it = f7186b.entrySet().iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (it.hasNext()) {
            if (canonicalPath.startsWith(it.next().getValue().getPath())) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (!a(getContext())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, File>> it = f7186b.entrySet().iterator();
        while (it.hasNext()) {
            File value = it.next().getValue();
            if (value.exists()) {
                linkedList.offer(value);
                while (linkedList.size() != 0) {
                    File file = (File) linkedList.poll();
                    if (file.isFile()) {
                        arrayList.add(file.getPath());
                    } else {
                        File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                if (file2.isFile()) {
                                    arrayList.add(file2.getPath());
                                } else if (file2.isDirectory()) {
                                    linkedList.offer(file2);
                                }
                            }
                        }
                    }
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[0]);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("logDir", arrayList);
        matrixCursor.setExtras(bundle);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    private static HashMap<String, File> a(Context context, String str) {
        HashMap<String, File> map = new HashMap<>();
        try {
            XmlResourceParser xmlResourceParserLoadXmlMetaData = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).loadXmlMetaData(context.getPackageManager(), str);
            if (xmlResourceParserLoadXmlMetaData != null) {
                while (true) {
                    int next = xmlResourceParserLoadXmlMetaData.next();
                    if (next == 1) {
                        break;
                    }
                    if (next == 2) {
                        String name = xmlResourceParserLoadXmlMetaData.getName();
                        File cacheDir = null;
                        String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                        String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, g.F);
                        if ("root-path".equals(name)) {
                            cacheDir = f7185a;
                        } else if ("files-path".equals(name)) {
                            cacheDir = context.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            cacheDir = context.getCacheDir();
                        } else if ("external-files-path".equals(name)) {
                            File[] externalFilesDirs = context.getExternalFilesDirs(null);
                            if (externalFilesDirs.length > 0) {
                                cacheDir = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            File[] externalCacheDirs = context.getExternalCacheDirs();
                            if (externalCacheDirs.length > 0) {
                                cacheDir = externalCacheDirs[0];
                            }
                        } else if ("external-media-path".equals(name)) {
                            File[] externalMediaDirs = context.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                cacheDir = externalMediaDirs[0];
                            }
                        }
                        if (cacheDir != null) {
                            a(attributeValue, a(cacheDir, attributeValue2));
                        }
                    }
                }
            } else {
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f7186b.put(str, file.getCanonicalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(Context context) {
        try {
            return (context.getPackageManager().getPackageInfo("com.miui.bugreport", 0).applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
