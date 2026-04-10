package com.funny.audio.database.dao;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH'J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH'J\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0002\u0010\rJ\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH'¨\u0006\u0011"}, d2 = {"Lcom/funny/audio/database/dao/BaseDao;", ExifInterface.GPS_DIRECTION_TRUE, "", "add", "", "info", "(Ljava/lang/Object;)J", "addList", "", "infos", "", "modify", "", "(Ljava/lang/Object;)I", "modifyList", "remove", "removeList", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BaseDao<T> {
    long add(T info);

    void addList(List<? extends T> infos);

    int modify(T info);

    int modifyList(List<? extends T> infos);

    int remove(T info);

    int removeList(List<? extends T> infos);
}
