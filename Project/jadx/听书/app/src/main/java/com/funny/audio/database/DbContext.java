package com.funny.audio.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.funny.audio.database.dao.AdSettingDao;
import com.funny.audio.database.dao.AppSettingDao;
import com.funny.audio.database.dao.BookshelfDao;
import com.funny.audio.database.dao.PlayHistoryDao;
import com.funny.audio.database.dao.PlayProgressDao;
import com.funny.audio.database.dao.PlaySettingDao;
import com.funny.audio.database.dao.SearchHistoryDao;
import com.umeng.analytics.pro.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/database/DbContext;", "Landroidx/room/RoomDatabase;", "()V", "adSetting", "Lcom/funny/audio/database/dao/AdSettingDao;", "appSetting", "Lcom/funny/audio/database/dao/AppSettingDao;", "bookshelf", "Lcom/funny/audio/database/dao/BookshelfDao;", "playHistory", "Lcom/funny/audio/database/dao/PlayHistoryDao;", "playProgress", "Lcom/funny/audio/database/dao/PlayProgressDao;", "playSetting", "Lcom/funny/audio/database/dao/PlaySettingDao;", "searchHistory", "Lcom/funny/audio/database/dao/SearchHistoryDao;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DbContext extends RoomDatabase {
    private static DbContext _current;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<DbContext> current$delegate = LazyKt.lazy(new Function0<DbContext>() { // from class: com.funny.audio.database.DbContext$Companion$current$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DbContext invoke() {
            DbContext dbContext = DbContext._current;
            Intrinsics.checkNotNull(dbContext);
            return dbContext;
        }
    });

    public abstract AdSettingDao adSetting();

    public abstract AppSettingDao appSetting();

    public abstract BookshelfDao bookshelf();

    public abstract PlayHistoryDao playHistory();

    public abstract PlayProgressDao playProgress();

    public abstract PlaySettingDao playSetting();

    public abstract SearchHistoryDao searchHistory();

    /* JADX INFO: compiled from: DbContext.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/funny/audio/database/DbContext$Companion;", "", "()V", "_current", "Lcom/funny/audio/database/DbContext;", "current", "getCurrent", "()Lcom/funny/audio/database/DbContext;", "current$delegate", "Lkotlin/Lazy;", "init", "", d.R, "Landroid/content/Context;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DbContext getCurrent() {
            return (DbContext) DbContext.current$delegate.getValue();
        }

        public final void init(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DbContext._current = (DbContext) Room.databaseBuilder(context, DbContext.class, "audio_db").build();
        }
    }
}
