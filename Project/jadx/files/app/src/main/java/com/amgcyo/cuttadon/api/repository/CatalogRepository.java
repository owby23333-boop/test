package com.amgcyo.cuttadon.api.repository;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.reader.ReadLog;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.event.MkChapterListEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: loaded from: classes.dex */
public class CatalogRepository implements me.jessyan.art.mvp.b {
    private me.jessyan.art.mvp.d mManager;

    public CatalogRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ ArrayList a(MkBook mkBook, int i2, String str, BaseModel baseModel) throws Exception {
        ArrayList<MkCatalog> arrayList = (ArrayList) baseModel.getData();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        for (MkCatalog mkCatalog : arrayList) {
            mkCatalog.setCatalogId(i3);
            if (mkCatalog.isIs_content()) {
                mkCatalog.setCacheExists(!com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.z.a(String.valueOf(mkBook.getBook_id()), mkBook.getReading_site_id(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()))));
            } else {
                mkCatalog.setCacheExists(false);
            }
            i3++;
        }
        mkBook.setReload_updated_at(baseModel.getUpdated_at());
        AppDatabase.i().a().a(baseModel.getUpdated_at(), i2);
        String str2 = "耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis);
        me.jessyan.art.d.f.a().a(new MkChapterListEvent(i2, str, arrayList), "tag_save_chapter_list_to_tile");
        return arrayList;
    }

    static /* synthetic */ BaseModel a(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel b(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    public Observable<BaseModel> addReadHistory(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).a(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.e1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                CatalogRepository.a(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<ArrayList<MkCatalog>> getArtCatalogBeanListData(final MkBook mkBook, int i2) {
        String reading_site_path = mkBook.getReading_site_path();
        final int book_id = mkBook.getBook_id();
        final String reading_site_id = mkBook.getReading_site_id();
        final ArrayList<MkCatalog> arrayListB = com.amgcyo.cuttadon.utils.otherutils.z.b(mkBook);
        return (i2 == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListB)) ? ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).c(reading_site_path).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.f1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CatalogRepository.a(mkBook, book_id, reading_site_id, (BaseModel) obj);
            }
        }).onErrorReturn(new Function() { // from class: com.amgcyo.cuttadon.api.repository.h1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CatalogRepository.a(arrayListB, (Throwable) obj);
            }
        }) : Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.repository.c1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                CatalogRepository.a(arrayListB, mkBook, observableEmitter);
            }
        });
    }

    public Observable<MkChapterContent> getArtChapterContent(final MkCatalog mkCatalog, final int i2, final String str) {
        final String path = mkCatalog.getPath();
        return ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).b(path).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.d1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CatalogRepository.a(mkCatalog, path, i2, str, (BaseModel) obj);
            }
        }).onErrorReturn(new Function() { // from class: com.amgcyo.cuttadon.api.repository.g1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CatalogRepository.a(mkCatalog, (Throwable) obj);
            }
        });
    }

    public Observable<SitePathReload> getArtSitePathReload(String str) {
        return ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).a(str).subscribeOn(Schedulers.io()).map(v3.f3560s);
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
    }

    public Observable<BaseModel> setBookInfo(int i2, int i3, String str, int i4, int i5, int i6, int i7) {
        return ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).a(i2, i3, str, i4, i5, i6, i7).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.i1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                CatalogRepository.b(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<ReadLog> submitRecordTime(int i2, String str, String str2, int i3, int i4) {
        return ((com.amgcyo.cuttadon.c.a.b) this.mManager.a(com.amgcyo.cuttadon.c.a.b.class)).a(i2, str, str2, i3, i4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.n3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (ReadLog) ((BaseModel) obj).getData();
            }
        });
    }

    static /* synthetic */ ArrayList a(ArrayList arrayList, Throwable th) throws Exception {
        String str = "onErrorReturn章节列表" + th.getMessage();
        th.printStackTrace();
        return com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList) ? com.amgcyo.cuttadon.utils.otherutils.o0.b().a() : arrayList;
    }

    static /* synthetic */ void a(ArrayList arrayList, MkBook mkBook, ObservableEmitter observableEmitter) throws Exception {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MkCatalog mkCatalog = (MkCatalog) it.next();
            if (!mkCatalog.isIs_content()) {
                mkCatalog.setCacheExists(false);
            } else {
                mkCatalog.setCacheExists(!com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.z.a(String.valueOf(mkBook.getBook_id()), mkBook.getReading_site_id(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()))));
            }
        }
        String str = "耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis);
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    static /* synthetic */ MkChapterContent a(MkCatalog mkCatalog, String str, int i2, String str2, BaseModel baseModel) throws Exception {
        MkChapterContent mkChapterContent = (MkChapterContent) baseModel.getData();
        mkChapterContent.setError_msg("");
        mkChapterContent.setOnErrorReturn(false);
        mkChapterContent.setIs_content(mkCatalog.isIs_content());
        String name = mkChapterContent.getName();
        String content = mkChapterContent.getContent();
        if (mkChapterContent.isIs_encrypt()) {
            mkChapterContent.setName(me.jessyan.art.b.c.a().a(name));
            content = me.jessyan.art.b.c.a().a(content);
        }
        File fileA = com.amgcyo.cuttadon.utils.otherutils.z.a(i2, str2, com.amgcyo.cuttadon.utils.otherutils.g.a(str, mkCatalog.getUpdated_at()), mkCatalog.getCatalogId(), content);
        mkCatalog.setCacheExists(!com.amgcyo.cuttadon.utils.otherutils.g.a(fileA));
        mkChapterContent.setCacheFilePath(fileA.getAbsolutePath());
        return mkChapterContent;
    }

    static /* synthetic */ MkChapterContent a(MkCatalog mkCatalog, Throwable th) throws Exception {
        mkCatalog.setOnErrorReturn(true);
        MkChapterContent mkChapterContent = new MkChapterContent(true, 0, mkCatalog.getCatalogId(), mkCatalog.getName(), mkCatalog.getPath());
        mkChapterContent.setError_msg(th.getMessage());
        mkChapterContent.setIs_content(mkCatalog.isIs_content());
        return mkChapterContent;
    }
}
