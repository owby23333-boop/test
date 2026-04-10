package com.funny.audio.database.dao;

import com.funny.audio.settings.AppSettingEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppSettingDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H'¨\u0006\n"}, d2 = {"Lcom/funny/audio/database/dao/AppSettingDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/settings/AppSettingEntity;", "delete", "", "key", "", "list", "", "type", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AppSettingDao extends BaseDao<AppSettingEntity> {
    void delete(String key);

    AppSettingEntity key(String key);

    List<AppSettingEntity> list(String type);
}
