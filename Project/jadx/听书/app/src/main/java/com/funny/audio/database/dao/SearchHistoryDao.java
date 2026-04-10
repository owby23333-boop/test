package com.funny.audio.database.dao;

import com.funny.audio.database.entities.SearchHistoryEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchHistoryDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/database/dao/SearchHistoryDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/SearchHistoryEntity;", "clear", "", "list", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SearchHistoryDao extends BaseDao<SearchHistoryEntity> {
    void clear();

    List<SearchHistoryEntity> list();
}
