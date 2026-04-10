package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class z extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f902a;
    private File dl;
    private File e;
    private File g;
    private File gc;
    private File gz;
    private File m;
    private final Object z;

    protected String z() {
        return "pangle_com.byted.pangle";
    }

    public z(Context context) {
        super(context);
        this.z = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileZ;
        if (z() == null) {
            return super.getDataDir();
        }
        synchronized (this.z) {
            if (this.g == null) {
                this.g = new File(g(), z());
            }
            fileZ = z(this.g);
        }
        return fileZ;
    }

    public File g() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileZ;
        if (z() == null) {
            return super.getFilesDir();
        }
        synchronized (this.z) {
            if (this.dl == null) {
                this.dl = new File(super.getFilesDir(), z());
            }
            fileZ = z(this.dl);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (z() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(z(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        if (i != 0 || z() == null) {
            return super.openFileOutput(str, i);
        }
        return new FileOutputStream(z(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return z(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileZ;
        if (z() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.z) {
            if (this.f902a == null) {
                this.f902a = new File(super.getNoBackupFilesDir(), z());
            }
            fileZ = z(this.f902a);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (z() == null) {
            return super.getExternalFilesDir(str);
        }
        return z(new File(super.getExternalFilesDir(str), z()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (z() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = z(new File(externalFilesDirs[i], z()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileZ;
        if (z() == null) {
            return super.getObbDir();
        }
        synchronized (this.z) {
            if (this.gc == null) {
                this.gc = new File(super.getObbDir(), z());
            }
            fileZ = z(this.gc);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (z() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = z(new File(obbDirs[i], z()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileZ;
        if (z() == null) {
            return super.getCacheDir();
        }
        synchronized (this.z) {
            if (this.m == null) {
                this.m = new File(super.getCacheDir(), z());
            }
            fileZ = z(this.m);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileZ;
        if (z() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.z) {
            if (this.e == null) {
                this.e = new File(super.getCodeCacheDir(), z());
            }
            fileZ = z(this.e);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileZ;
        if (z() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.z) {
            if (this.gz == null) {
                this.gz = new File(super.getExternalCacheDir(), z());
            }
            fileZ = z(this.gz);
        }
        return fileZ;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (z() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = z(new File(externalCacheDirs[i], z()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (z() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = z(new File(externalMediaDirs[i], z()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        if (i != 0 || z() == null) {
            return super.getDir(str, i);
        }
        return z(new File(super.getDir(str, i), z()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (i != 0 || z() == null) {
            return super.getSharedPreferences(str, i);
        }
        return super.getSharedPreferences(z(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (z() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(z(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i != 0 || z() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        return super.openOrCreateDatabase(z(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i != 0 || z() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(z(str), i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (z() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (z() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(z(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (z() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(z(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (z() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(z())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = strArrDatabaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    private String z(String str) {
        return z() + "_" + str;
    }

    private static File z(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File z(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
