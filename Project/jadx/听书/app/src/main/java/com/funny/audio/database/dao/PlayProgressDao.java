package com.funny.audio.database.dao;

import com.funny.audio.database.entities.PlayProgressEntity;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayProgressDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/database/dao/PlayProgressDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/PlayProgressEntity;", "latest", "albumId", "", "trackId", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlayProgressDao extends BaseDao<PlayProgressEntity> {
    PlayProgressEntity latest(String albumId);

    PlayProgressEntity latest(String albumId, String trackId);
}
