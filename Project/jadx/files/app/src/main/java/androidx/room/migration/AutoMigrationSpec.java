package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
