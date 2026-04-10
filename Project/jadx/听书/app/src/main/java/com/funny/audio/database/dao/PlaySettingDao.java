package com.funny.audio.database.dao;

import com.funny.audio.database.entities.PlaySettingEntity;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlaySettingDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/funny/audio/database/dao/PlaySettingDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/PlaySettingEntity;", "album", "albumId", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlaySettingDao extends BaseDao<PlaySettingEntity> {
    PlaySettingEntity album(String albumId);
}
