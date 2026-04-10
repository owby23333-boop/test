package com.funny.audio.database.dao;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.funny.audio.database.entities.AdSettingEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AdSettingDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H'¨\u0006\u0005"}, d2 = {"Lcom/funny/audio/database/dao/AdSettingDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/AdSettingEntity;", TtmlNode.COMBINE_ALL, "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AdSettingDao extends BaseDao<AdSettingEntity> {
    List<AdSettingEntity> all();
}
