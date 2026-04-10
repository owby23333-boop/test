package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class AutoCloser {
    final long mAutoCloseTimeoutInMs;

    @Nullable
    @GuardedBy("mLock")
    SupportSQLiteDatabase mDelegateDatabase;

    @NonNull
    final Executor mExecutor;

    @Nullable
    private SupportSQLiteOpenHelper mDelegateOpenHelper = null;

    @NonNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Nullable
    Runnable mOnAutoCloseCallback = null;

    @NonNull
    final Object mLock = new Object();

    @GuardedBy("mLock")
    int mRefCount = 0;

    @GuardedBy("mLock")
    long mLastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
    private boolean mManuallyClosed = false;
    private final Runnable mExecuteAutoCloser = new Runnable() { // from class: androidx.room.AutoCloser.1
        @Override // java.lang.Runnable
        public void run() {
            AutoCloser autoCloser = AutoCloser.this;
            autoCloser.mExecutor.execute(autoCloser.mAutoCloser);
        }
    };

    @NonNull
    final Runnable mAutoCloser = new Runnable() { // from class: androidx.room.AutoCloser.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AutoCloser.this.mLock) {
                if (SystemClock.uptimeMillis() - AutoCloser.this.mLastDecrementRefCountTimeStamp < AutoCloser.this.mAutoCloseTimeoutInMs) {
                    return;
                }
                if (AutoCloser.this.mRefCount != 0) {
                    return;
                }
                if (AutoCloser.this.mOnAutoCloseCallback == null) {
                    throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                AutoCloser.this.mOnAutoCloseCallback.run();
                if (AutoCloser.this.mDelegateDatabase != null && AutoCloser.this.mDelegateDatabase.isOpen()) {
                    try {
                        AutoCloser.this.mDelegateDatabase.close();
                    } catch (IOException e2) {
                        SneakyThrow.reThrow(e2);
                    }
                    AutoCloser.this.mDelegateDatabase = null;
                }
            }
        }
    };

    AutoCloser(long j2, @NonNull TimeUnit timeUnit, @NonNull Executor executor) {
        this.mAutoCloseTimeoutInMs = timeUnit.toMillis(j2);
        this.mExecutor = executor;
    }

    public void closeDatabaseIfOpen() throws IOException {
        synchronized (this.mLock) {
            this.mManuallyClosed = true;
            if (this.mDelegateDatabase != null) {
                this.mDelegateDatabase.close();
            }
            this.mDelegateDatabase = null;
        }
    }

    public void decrementCountAndScheduleClose() {
        synchronized (this.mLock) {
            if (this.mRefCount <= 0) {
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            }
            this.mRefCount--;
            if (this.mRefCount == 0) {
                if (this.mDelegateDatabase == null) {
                } else {
                    this.mHandler.postDelayed(this.mExecuteAutoCloser, this.mAutoCloseTimeoutInMs);
                }
            }
        }
    }

    @Nullable
    public <V> V executeRefCountingFunction(@NonNull Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public SupportSQLiteDatabase getDelegateDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.mLock) {
            supportSQLiteDatabase = this.mDelegateDatabase;
        }
        return supportSQLiteDatabase;
    }

    @VisibleForTesting
    public int getRefCountForTest() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mRefCount;
        }
        return i2;
    }

    @NonNull
    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.mLock) {
            this.mHandler.removeCallbacks(this.mExecuteAutoCloser);
            this.mRefCount++;
            if (this.mManuallyClosed) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            if (this.mDelegateDatabase != null && this.mDelegateDatabase.isOpen()) {
                return this.mDelegateDatabase;
            }
            if (this.mDelegateOpenHelper == null) {
                throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
            this.mDelegateDatabase = this.mDelegateOpenHelper.getWritableDatabase();
            return this.mDelegateDatabase;
        }
    }

    public void init(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (this.mDelegateOpenHelper != null) {
            return;
        }
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public void setAutoCloseCallback(Runnable runnable) {
        this.mOnAutoCloseCallback = runnable;
    }
}
