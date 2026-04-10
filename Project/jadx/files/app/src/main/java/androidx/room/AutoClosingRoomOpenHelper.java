package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NonNull
    private final AutoCloser mAutoCloser;

    @NonNull
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;

    @NonNull
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        @NonNull
        private final AutoCloser mAutoCloser;

        AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        static /* synthetic */ Object b(long j2, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setPageSize(j2);
            return null;
        }

        static /* synthetic */ Object b(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        static /* synthetic */ Object c(int i2, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setVersion(i2);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String str) {
            return new AutoClosingSupportSqliteStatement(str, this.mAutoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String str, final String str2, final Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.p
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).delete(str, str2, objArr));
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                this.mAutoCloser.getDelegateDatabase().endTransaction();
            } finally {
                this.mAutoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void execPerConnectionSQL(@NonNull String str, @Nullable @SuppressLint({"ArrayReturn"}) Object[] objArr) {
            androidx.sqlite.db.a.$default$execPerConnectionSQL(this, str, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String str) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.a(str, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.u
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.w0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.w
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.v0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.s0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.q0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).inTransaction());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String str, final int i2, final ContentValues contentValues) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.o
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).insert(str, i2, contentValues));
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.x0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDatabaseIntegrityOk());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.u0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return androidx.sqlite.db.a.$default$isExecPerConnectionSQLSupported(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.t
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.e
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.a((SupportSQLiteDatabase) obj);
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int i2) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.d
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).needUpgrade(i2));
                }
            })).booleanValue();
        }

        void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.b((SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String str) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(final boolean z2) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.a(z2, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.a(locale, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int i2) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.b(i2, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long j2) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).setMaximumSize(j2));
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long j2) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.b(j2, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
            delegateDatabase.setTransactionSuccessful();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int i2) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.n
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.c(i2, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String str, final int i2, final ContentValues contentValues, final String str2, final Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).update(str, i2, contentValues, str2, objArr));
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(r0.a)).booleanValue();
        }

        static /* synthetic */ Object b(int i2, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setMaxSqlCacheSize(i2);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String str, final Object[] objArr) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.a(str, objArr, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long j2) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(r0.a)).booleanValue();
        }

        static /* synthetic */ Object a(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str);
            return null;
        }

        static /* synthetic */ Object a(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str, objArr);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String str, Object[] objArr) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        static /* synthetic */ Object a(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setLocale(locale);
            return null;
        }

        static /* synthetic */ Object a(boolean z2, SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 16) {
                return null;
            }
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z2);
            return null;
        }

        static /* synthetic */ Boolean a(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
            }
            return false;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            this.mDelegate = cursor;
            this.mAutoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
            this.mDelegate.copyStringToBuffer(i2, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i2) {
            return this.mDelegate.getBlob(i2);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.mDelegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i2) {
            return this.mDelegate.getColumnName(i2);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i2) {
            return this.mDelegate.getDouble(i2);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i2) {
            return this.mDelegate.getFloat(i2);
        }

        @Override // android.database.Cursor
        public int getInt(int i2) {
            return this.mDelegate.getInt(i2);
        }

        @Override // android.database.Cursor
        public long getLong(int i2) {
            return this.mDelegate.getLong(i2);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.mDelegate);
        }

        @Override // android.database.Cursor
        @Nullable
        @RequiresApi(api = 29)
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.mDelegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i2) {
            return this.mDelegate.getShort(i2);
        }

        @Override // android.database.Cursor
        public String getString(int i2) {
            return this.mDelegate.getString(i2);
        }

        @Override // android.database.Cursor
        public int getType(int i2) {
            return this.mDelegate.getType(i2);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i2) {
            return this.mDelegate.isNull(i2);
        }

        @Override // android.database.Cursor
        public boolean move(int i2) {
            return this.mDelegate.move(i2);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i2) {
            return this.mDelegate.moveToPosition(i2);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.mDelegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.mDelegate.respond(bundle);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        public void setExtras(Bundle bundle) {
            SupportSQLiteCompat.Api23Impl.setExtras(this.mDelegate, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.mDelegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        public void setNotificationUris(@NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.mDelegate, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.mDelegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(this.mDelegateOpenHelper);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(this.mAutoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            this.mAutoClosingDb.close();
        } catch (IOException e2) {
            SneakyThrow.reThrow(e2);
        }
    }

    @NonNull
    AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    @NonNull
    SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds = new ArrayList<>();
        private final String mSql;

        AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            this.mSql = str;
            this.mAutoCloser = autoCloser;
        }

        private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            int i2 = 0;
            while (i2 < this.mBinds.size()) {
                int i3 = i2 + 1;
                Object obj = this.mBinds.get(i2);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i3);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i3, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i3, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i3, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i3, (byte[]) obj);
                }
                i2 = i3;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(final Function<SupportSQLiteStatement, T> function) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.a.a(function, (SupportSQLiteDatabase) obj);
                }
            });
        }

        private void saveBinds(int i2, Object obj) {
            int i3 = i2 - 1;
            if (i3 >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i3; size++) {
                    this.mBinds.add(null);
                }
            }
            this.mBinds.set(i3, obj);
        }

        public /* synthetic */ Object a(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement supportSQLiteStatementCompileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(supportSQLiteStatementCompileStatement);
            return function.apply(supportSQLiteStatementCompileStatement);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i2, byte[] bArr) {
            saveBinds(i2, bArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i2, double d2) {
            saveBinds(i2, Double.valueOf(d2));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i2, long j2) {
            saveBinds(i2, Long.valueOf(j2));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i2) {
            saveBinds(i2, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i2, String str) {
            saveBinds(i2, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.r
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.a((SupportSQLiteStatement) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.v
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.a
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.t0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteStatement) obj).simpleQueryForString();
                }
            });
        }

        static /* synthetic */ Object a(SupportSQLiteStatement supportSQLiteStatement) {
            supportSQLiteStatement.execute();
            return null;
        }
    }
}
