package com.funny.audio.database.dao;

import com.funny.audio.database.entities.PlayHistoryEntity;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayHistoryDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH'J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH'J2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0016"}, d2 = {"Lcom/funny/audio/database/dao/PlayHistoryDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "album", "albumId", "", "latest", "listByNeedSync", "", "size", "", "pageByAll", "page", "pageSize", "pageByTimeBefore", "time", "", "pageByTimeFilter", AnalyticsConfig.RTD_START_TIME, "endTime", "remove", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlayHistoryDao extends BaseDao<PlayHistoryEntity> {
    PlayHistoryEntity album(String albumId);

    PlayHistoryEntity latest();

    List<PlayHistoryEntity> listByNeedSync(int size);

    List<PlayHistoryEntity> pageByAll(int page, int pageSize);

    List<PlayHistoryEntity> pageByTimeBefore(long time, int page, int pageSize);

    List<PlayHistoryEntity> pageByTimeFilter(long startTime, long endTime, int page, int pageSize);

    void remove(String albumId);

    /* JADX INFO: compiled from: PlayHistoryDao.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ List pageByAll$default(PlayHistoryDao playHistoryDao, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByAll");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 15;
            }
            return playHistoryDao.pageByAll(i, i2);
        }

        public static /* synthetic */ List pageByTimeBefore$default(PlayHistoryDao playHistoryDao, long j, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByTimeBefore");
            }
            if ((i3 & 2) != 0) {
                i = 1;
            }
            if ((i3 & 4) != 0) {
                i2 = 15;
            }
            return playHistoryDao.pageByTimeBefore(j, i, i2);
        }

        public static /* synthetic */ List pageByTimeFilter$default(PlayHistoryDao playHistoryDao, long j, long j2, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByTimeFilter");
            }
            if ((i3 & 4) != 0) {
                i = 1;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = 15;
            }
            return playHistoryDao.pageByTimeFilter(j, j2, i4, i2);
        }
    }
}
