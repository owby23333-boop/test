package com.amgcyo.cuttadon.api.repository;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.DanmakuContent;
import com.amgcyo.cuttadon.api.entity.comic.DanmuResponeBean;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: loaded from: classes.dex */
public class ComicRepository implements me.jessyan.art.mvp.b {
    private me.jessyan.art.mvp.d mManager;
    private int userId = 0;

    class a implements Function<BaseModel, BaseModel> {
        a(ComicRepository comicRepository) {
        }

        public BaseModel a(BaseModel baseModel) throws Exception {
            return baseModel;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ BaseModel apply(BaseModel baseModel) throws Exception {
            BaseModel baseModel2 = baseModel;
            a(baseModel2);
            return baseModel2;
        }
    }

    class b implements Function<BaseModel<Base64Bean>, DanmuResponeBean> {

        class a extends TypeToken<HashMap<String, List<DanmakuContent>>> {
            a(b bVar) {
            }
        }

        b() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DanmuResponeBean apply(BaseModel<Base64Bean> baseModel) throws Exception {
            Map<String, Object> mapB;
            String str = (String) com.amgcyo.cuttadon.utils.comic.b.a(baseModel.getData(), String.class);
            DanmuResponeBean danmuResponeBean = new DanmuResponeBean();
            if (!TextUtils.isEmpty(str) && (mapB = com.amgcyo.cuttadon.utils.comic.c.b(str)) != null && mapB.size() > 0) {
                Object obj = mapB.get("lists");
                Object obj2 = mapB.get("count");
                if (obj2 != null && obj != null) {
                    danmuResponeBean.setDanmuCount(Integer.parseInt(obj2.toString()));
                    HashMap<String, List<DanmakuContent>> map = (HashMap) com.amgcyo.cuttadon.utils.otherutils.r.a().fromJson(String.valueOf(obj), new a(this).getType());
                    if (map != null && map.size() > 0) {
                        Iterator<Map.Entry<String, List<DanmakuContent>>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            List<DanmakuContent> value = it.next().getValue();
                            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(value)) {
                                for (DanmakuContent danmakuContent : value) {
                                    danmakuContent.setUser_id(ComicRepository.this.userId == danmakuContent.getUser_id() ? -1 : danmakuContent.getUser_id());
                                }
                            }
                        }
                        danmuResponeBean.setHashMap(map);
                    }
                }
            }
            return danmuResponeBean;
        }
    }

    public ComicRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ List a(String str, ZymkChapter zymkChapter, BaseModel baseModel) throws Exception {
        StringBuilder sb;
        String str2;
        List listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), ComicChapter.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        String str3 = "listBaseModel 里面的update_at：" + baseModel.getUpdated_at();
        int size = listB.size();
        for (int i2 = 0; i2 < size; i2++) {
            ComicChapter comicChapter = (ComicChapter) listB.get(i2);
            comicChapter.setCacheFile(new File(str + com.amgcyo.cuttadon.utils.otherutils.z.a + comicChapter.getId()));
            comicChapter.setIndex(i2);
            comicChapter.setTempName(zymkChapter.getName());
            comicChapter.setCount(size);
            comicChapter.setOwnerChapterIndex(zymkChapter.getIndex());
            comicChapter.setOwnerChapterPath(zymkChapter.getPath());
            comicChapter.setUpdated_at(baseModel.getUpdated_at());
        }
        boolean zB = com.amgcyo.cuttadon.utils.otherutils.z.b(com.amgcyo.cuttadon.utils.otherutils.r.a(listB), str, "comic_32767.comic");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("章节列表：");
        if (zB) {
            sb = new StringBuilder();
            str2 = "保存成功";
        } else {
            sb = new StringBuilder();
            str2 = "保存失败";
        }
        sb.append(str2);
        sb.append(str);
        sb2.append(sb.toString());
        sb2.toString();
        return listB;
    }

    private Observable<List<ComicChapter>> getListObservable(final ZymkChapter zymkChapter, final String str) {
        return ((com.amgcyo.cuttadon.c.a.c) this.mManager.a(com.amgcyo.cuttadon.c.a.c.class)).a(zymkChapter.getPath(), zymkChapter.getUpdated_at()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.k1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ComicRepository.a(str, zymkChapter, (BaseModel) obj);
            }
        });
    }

    public Observable<SitePathReload> getArtSitePathReload(String str) {
        return ((com.amgcyo.cuttadon.c.a.c) this.mManager.a(com.amgcyo.cuttadon.c.a.c.class)).a(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.l1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ComicRepository.a((BaseModel) obj);
            }
        });
    }

    public Observable<List<ComicChapter>> getComicChapterContent(ZymkChapter zymkChapter, int i2, int i3) {
        String strE = com.amgcyo.cuttadon.utils.otherutils.z.e(i2 + com.amgcyo.cuttadon.utils.otherutils.z.a + zymkChapter.getUpdated_at() + "_" + zymkChapter.getPath().replaceAll("/", "_").replaceAll(".html", ""));
        File file = new File(strE, "comic_32767.comic");
        if (!file.exists()) {
            return getListObservable(zymkChapter, strE);
        }
        ArrayList<ComicChapter> arrayListJ = com.amgcyo.cuttadon.utils.otherutils.z.j(file.getAbsolutePath());
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListJ)) {
            return getListObservable(zymkChapter, strE);
        }
        ComicChapter comicChapter = arrayListJ.get(0);
        return (comicChapter == null || comicChapter.getUpdated_at() < zymkChapter.getUpdated_at()) ? getListObservable(zymkChapter, strE) : Observable.just(arrayListJ);
    }

    public Observable<DanmuResponeBean> getComicDanmakuList(int i2, int i3, String str) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ != null) {
            this.userId = mkUserJ.getUser_id();
        }
        return ((com.amgcyo.cuttadon.c.a.c) this.mManager.a(com.amgcyo.cuttadon.c.a.c.class)).a(i2, i3, str).subscribeOn(Schedulers.io()).map(new b());
    }

    public Observable<List<ZymkChapter>> getComicZymkChapterList(String str, final int i2) {
        return ((com.amgcyo.cuttadon.c.a.c) this.mManager.a(com.amgcyo.cuttadon.c.a.c.class)).b(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.j1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ComicRepository.a(i2, (BaseModel) obj);
            }
        });
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
    }

    public Observable<BaseModel> postComment(int i2, String str, int i3, String str2, int i4, int i5) {
        return ((com.amgcyo.cuttadon.c.a.c) this.mManager.a(com.amgcyo.cuttadon.c.a.c.class)).a(i2, str, i3, str2, i4, i5).subscribeOn(Schedulers.io()).map(new a(this));
    }

    static /* synthetic */ List a(int i2, BaseModel baseModel) throws Exception {
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        AppDatabase.i().a().a(baseModel.getUpdated_at(), i2);
        String str = "当前线程：" + me.jessyan.art.f.e.a();
        List listB = com.amgcyo.cuttadon.utils.comic.b.b(base64Bean, ZymkChapter.class);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            int i3 = 0;
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                ((ZymkChapter) it.next()).setIndex(i3);
                i3++;
            }
            com.amgcyo.cuttadon.utils.otherutils.z.a(i2, (List<ZymkChapter>) listB);
            return listB;
        }
        return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
    }

    static /* synthetic */ SitePathReload a(BaseModel baseModel) throws Exception {
        SitePathReload sitePathReload = (SitePathReload) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), SitePathReload.class);
        return sitePathReload != null ? sitePathReload : new SitePathReload(0L);
    }
}
