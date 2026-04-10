package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NonNull
    private final Context mContext;

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @Nullable
    private final Callable<InputStream> mCopyFromInputStream;

    @Nullable
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;

    @NonNull
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(@NonNull Context context, @Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, int i2, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDatabaseVersion = i2;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File file, boolean z2) throws Throwable {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.mCopyFromAssetPath != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else {
            File file2 = this.mCopyFromFile;
            if (file2 != null) {
                readableByteChannelNewChannel = new FileInputStream(file2).getChannel();
            } else {
                Callable<InputStream> callable = this.mCopyFromInputStream;
                if (callable == null) {
                    throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
                }
                try {
                    readableByteChannelNewChannel = Channels.newChannel(callable.call());
                } catch (Exception e2) {
                    throw new IOException("inputStreamCallable exception on call", e2);
                }
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannelNewChannel, new FileOutputStream(fileCreateTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        dispatchOnOpenPrepackagedDatabase(fileCreateTempFile, z2);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) throws Throwable {
        try {
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(file.getName()).callback(new SupportSQLiteOpenHelper.Callback(DBUtil.readVersion(file)) { // from class: androidx.room.SQLiteCopyOpenHelper.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
                }
            }).build());
        } catch (IOException e2) {
            throw new RuntimeException("Malformed database file, unable to read version.", e2);
        }
    }

    private void dispatchOnOpenPrepackagedDatabase(File file, boolean z2) throws Throwable {
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration == null || databaseConfiguration.prepackagedDatabaseCallback == null) {
            return;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelperCreateFrameworkOpenHelper = createFrameworkOpenHelper(file);
        try {
            this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(z2 ? supportSQLiteOpenHelperCreateFrameworkOpenHelper.getWritableDatabase() : supportSQLiteOpenHelperCreateFrameworkOpenHelper.getReadableDatabase());
        } finally {
            supportSQLiteOpenHelperCreateFrameworkOpenHelper.close();
        }
    }

    private void verifyDatabaseFile(boolean z2) {
        String databaseName = getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath, z2);
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            }
            if (this.mDatabaseConfiguration == null) {
                return;
            }
            try {
                int version = DBUtil.readVersion(databasePath);
                if (version == this.mDatabaseVersion) {
                    return;
                }
                if (this.mDatabaseConfiguration.isMigrationRequired(version, this.mDatabaseVersion)) {
                    return;
                }
                if (this.mContext.deleteDatabase(databaseName)) {
                    try {
                        copyDatabaseFile(databasePath, z2);
                    } catch (IOException unused) {
                    }
                } else {
                    String str = "Failed to delete database file (" + databaseName + ") for a copy destructive migration.";
                }
            } catch (IOException unused2) {
            }
        } finally {
            copyLock.unlock();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(false);
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(true);
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    void setDatabaseConfiguration(@Nullable DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.mDelegate.setWriteAheadLoggingEnabled(z2);
    }
}
