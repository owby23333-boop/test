package com.funny.audio.database.dao;

import com.funny.audio.database.entities.BookshelfEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: BookshelfDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0014"}, d2 = {"Lcom/funny/audio/database/dao/BookshelfDao;", "Lcom/funny/audio/database/dao/BaseDao;", "Lcom/funny/audio/database/entities/BookshelfEntity;", "get", "albumId", "", "listByLatestCollect", "", "listByLatestRead", "listByLatestUpdate", "listByNeedRemove", "listByNeedSync", "pageByLatestCollect", "page", "", "pageSize", "pageByLatestRead", "pageByLatestUpdate", "remove", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BookshelfDao extends BaseDao<BookshelfEntity> {
    BookshelfEntity get(String albumId);

    List<BookshelfEntity> listByLatestCollect();

    List<BookshelfEntity> listByLatestRead();

    List<BookshelfEntity> listByLatestUpdate();

    List<BookshelfEntity> listByNeedRemove();

    List<BookshelfEntity> listByNeedSync();

    List<BookshelfEntity> pageByLatestCollect(int page, int pageSize);

    List<BookshelfEntity> pageByLatestRead(int page, int pageSize);

    List<BookshelfEntity> pageByLatestUpdate(int page, int pageSize);

    void remove(String albumId);

    /* JADX INFO: compiled from: BookshelfDao.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ List pageByLatestCollect$default(BookshelfDao bookshelfDao, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByLatestCollect");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 15;
            }
            return bookshelfDao.pageByLatestCollect(i, i2);
        }

        public static /* synthetic */ List pageByLatestRead$default(BookshelfDao bookshelfDao, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByLatestRead");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 15;
            }
            return bookshelfDao.pageByLatestRead(i, i2);
        }

        public static /* synthetic */ List pageByLatestUpdate$default(BookshelfDao bookshelfDao, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageByLatestUpdate");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 15;
            }
            return bookshelfDao.pageByLatestUpdate(i, i2);
        }
    }
}
