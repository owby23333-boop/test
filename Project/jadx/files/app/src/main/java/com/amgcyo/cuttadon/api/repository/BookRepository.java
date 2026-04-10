package com.amgcyo.cuttadon.api.repository;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.bookcity.BaseMaleFemaleBean;
import com.amgcyo.cuttadon.api.entity.bookcity.BookCityHeaderData;
import com.amgcyo.cuttadon.api.entity.bookcity.BookClassBean;
import com.amgcyo.cuttadon.api.entity.bookcity.BookStoreMaleBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ItemsGrid2Book;
import com.amgcyo.cuttadon.api.entity.bookcity.RankBean;
import com.amgcyo.cuttadon.api.entity.bookcity.RankIndexLeft;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListDeatil;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeStates;
import com.amgcyo.cuttadon.api.entity.bookcity.v4.ItemsGrid3Book;
import com.amgcyo.cuttadon.api.entity.bookcity.v4.ItemsGrid4Book;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBean;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7Bookcity;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7DataBean;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7IconBean;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.style.V7Style2Rank;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comment.BaseCommentBean;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentBean;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetail;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetailBean;
import com.amgcyo.cuttadon.api.entity.comment.PostCommentRespone;
import com.amgcyo.cuttadon.api.entity.other.HistoryBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkAllBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.entity.other.MultiTile;
import com.amgcyo.cuttadon.api.entity.other.ThemeBookListID;
import com.amgcyo.cuttadon.api.entity.other.ThemeLisiID;
import com.amgcyo.cuttadon.api.entity.other.WanyiwanBean;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.fatcatfat.io.R;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import me.drakeet.multitype.Items;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: loaded from: classes.dex */
public class BookRepository implements me.jessyan.art.mvp.b {
    private WeakHashMap<String, BookClassBean> bookClassBeanWeakHashMap;
    private boolean comicShow;
    private me.jessyan.art.mvp.d mManager;
    private boolean novelShow;
    private WeakHashMap<Integer, Object> sexDataCache;
    private int sigleLine = 4;

    public BookRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ CommentDetailBean A(BaseModel baseModel) throws Exception {
        CommentDetailBean commentDetailBean = (CommentDetailBean) baseModel.getData();
        CommentDetail lists = commentDetailBean.getLists();
        List<MkCommentStatus> listB = AppDatabase.i().b().b();
        BaseNewComment comment = lists.getComment();
        if (comment != null) {
            comment.setCreated_at(com.amgcyo.cuttadon.utils.otherutils.y.d(comment.getCreated_at()));
            boolean z2 = com.amgcyo.cuttadon.utils.otherutils.g.z() == comment.getUser_id();
            comment.setLoginUser(z2);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
                Iterator<MkCommentStatus> it = listB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MkCommentStatus next = it.next();
                    if (z2 && comment.getComment_id() == next.getCommentId()) {
                        comment.setFav_state(next.getComment_fav_status());
                        break;
                    }
                }
            }
        }
        for (BaseNewComment baseNewComment : lists.getComment_reply_list()) {
            baseNewComment.setCreated_at(com.amgcyo.cuttadon.utils.otherutils.y.d(baseNewComment.getCreated_at()));
            baseNewComment.setLoginUser(com.amgcyo.cuttadon.utils.otherutils.g.z() == baseNewComment.getUser_id());
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
                Iterator<MkCommentStatus> it2 = listB.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        MkCommentStatus next2 = it2.next();
                        if (baseNewComment.getReply_comment_id() == next2.getCommentId()) {
                            baseNewComment.setFav_state(next2.getComment_fav_status());
                            break;
                        }
                    }
                }
            }
        }
        return commentDetailBean;
    }

    static /* synthetic */ CommentBean B(BaseModel baseModel) throws Exception {
        CommentBean commentBean = (CommentBean) baseModel.getData();
        List<BaseNewComment> lists = commentBean.getLists();
        List<MkCommentStatus> listB = AppDatabase.i().b().b();
        for (BaseNewComment baseNewComment : lists) {
            baseNewComment.setCreated_at(com.amgcyo.cuttadon.utils.otherutils.y.d(baseNewComment.getCreated_at()));
            boolean z2 = com.amgcyo.cuttadon.utils.otherutils.g.z() == baseNewComment.getUser_id();
            baseNewComment.setLoginUser(z2);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
                Iterator<MkCommentStatus> it = listB.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MkCommentStatus next = it.next();
                        if (z2 && baseNewComment.getComment_id() == next.getCommentId()) {
                            baseNewComment.setFav_state(next.getComment_fav_status());
                            break;
                        }
                    }
                }
            }
        }
        return commentBean;
    }

    static /* synthetic */ MkAllBookBean C(BaseModel baseModel) throws Exception {
        MkAllBookBean mkAllBookBean = (MkAllBookBean) baseModel.getData();
        List<MkBook> lists = mkAllBookBean.getLists();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
            for (MkBook mkBook : lists) {
                mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
                mkBook.setItemType(2);
            }
        }
        return mkAllBookBean;
    }

    static /* synthetic */ BaseModel D(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel E(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel F(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel G(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel H(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ ShudanListData a(ShudanListData shudanListData) throws Exception {
        return shudanListData;
    }

    static /* synthetic */ MkBook a(MkBook mkBook) throws Exception {
        return mkBook;
    }

    static /* synthetic */ BaseModel a(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ void a(Throwable th) throws Exception {
    }

    static /* synthetic */ MkBook b(MkBook mkBook) throws Exception {
        return mkBook;
    }

    static /* synthetic */ BaseModel b(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkBook c(MkBook mkBook, Throwable th) throws Exception {
        return mkBook;
    }

    static /* synthetic */ BaseModel c(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkBook d(MkBook mkBook, Throwable th) throws Exception {
        return mkBook;
    }

    static /* synthetic */ BaseModel d(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel e(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel f(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel g(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    private Observable<ShudanListData> getArtBookListBaseInfo(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.t3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (ShudanListData) ((BaseModel) obj).getData();
            }
        });
    }

    private Observable<MkBook> getArtBookShelfBookDetail(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).g(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.n((BaseModel) obj);
            }
        });
    }

    private Observable<MkBook> getArtBookShelfComicDetail(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).e(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.o0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.o((BaseModel) obj);
            }
        });
    }

    private String getRandHtml() {
        return "1.html";
    }

    static /* synthetic */ BaseModel h(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel i(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel j(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel k(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkAllBookBean l(BaseModel baseModel) throws Exception {
        MkAllBookBean mkAllBookBean = (MkAllBookBean) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkAllBookBean.class);
        if (mkAllBookBean == null) {
            return new MkAllBookBean();
        }
        List<MkBook> lists = mkAllBookBean.getLists();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
            for (MkBook mkBook : lists) {
                mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
                mkBook.setItemType(2);
            }
        }
        return mkAllBookBean;
    }

    static /* synthetic */ MkBook m(BaseModel baseModel) throws Exception {
        MkBook mkBook = (MkBook) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkBook.class);
        return mkBook != null ? mkBook : new MkBook();
    }

    static /* synthetic */ MkBook n(BaseModel baseModel) throws Exception {
        MkBook mkBook = (MkBook) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkBook.class);
        return mkBook != null ? mkBook : new MkBook();
    }

    static /* synthetic */ MkBook o(BaseModel baseModel) throws Exception {
        return (MkBook) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkBook.class);
    }

    static /* synthetic */ List p(BaseModel baseModel) throws Exception {
        List<MkSiteBean> listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkSiteBean.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkSiteBean mkSiteBean : listB) {
            mkSiteBean.setShow_updated_at(com.amgcyo.cuttadon.utils.otherutils.y.b(mkSiteBean.getUpdated_at()));
        }
        return listB;
    }

    static /* synthetic */ List q(BaseModel baseModel) throws Exception {
        List<MkBook> list = (List) baseModel.getData();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : list) {
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
            mkBook.setItemType(2);
        }
        return list;
    }

    static /* synthetic */ MkBook r(BaseModel baseModel) throws Exception {
        MkBook mkBook = (MkBook) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkBook.class);
        if (mkBook != null) {
            return mkBook;
        }
        MkBook mkBook2 = new MkBook();
        mkBook2.setBook_id(-1);
        return mkBook2;
    }

    static /* synthetic */ HistoryBookBean s(BaseModel baseModel) throws Exception {
        HistoryBookBean historyBookBean = (HistoryBookBean) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), HistoryBookBean.class);
        return historyBookBean != null ? historyBookBean : new HistoryBookBean();
    }

    static /* synthetic */ List t(BaseModel baseModel) throws Exception {
        List<MkBook> list = (List) baseModel.getData();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : list) {
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
            mkBook.setItemType(2);
        }
        return list;
    }

    static /* synthetic */ List u(BaseModel baseModel) throws Exception {
        List<MkBook> listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkBook.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : listB) {
            mkBook.setItemType(2);
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
        }
        return listB;
    }

    static /* synthetic */ ThemeBookListBean v(BaseModel baseModel) throws Exception {
        ThemeBookListBean themeBookListBean = (ThemeBookListBean) baseModel.getData();
        List<ShudanListData> lists = themeBookListBean.getLists();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
            for (ShudanListData shudanListData : lists) {
                shudanListData.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(shudanListData.getRemark()));
            }
        }
        return themeBookListBean;
    }

    static /* synthetic */ ThemeBookListDeatil w(BaseModel baseModel) throws Exception {
        ThemeBookListDeatil themeBookListDeatil = (ThemeBookListDeatil) baseModel.getData();
        List<MkBook> books = themeBookListDeatil.getBooks();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(books)) {
            for (MkBook mkBook : books) {
                mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
                mkBook.setItemType(2);
            }
        }
        return themeBookListDeatil;
    }

    static /* synthetic */ List x(BaseModel baseModel) throws Exception {
        List<MkBook> listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkBook.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : listB) {
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
            mkBook.setItemType(2);
        }
        return listB;
    }

    static /* synthetic */ List y(BaseModel baseModel) throws Exception {
        List<MkBook> listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkBook.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : listB) {
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
            mkBook.setItemType(2);
        }
        return listB;
    }

    static /* synthetic */ List z(BaseModel baseModel) throws Exception {
        List<BaseNewComment> list = (List) baseModel.getData();
        List<MkCommentStatus> listB = AppDatabase.i().b().b();
        for (BaseNewComment baseNewComment : list) {
            baseNewComment.setItemType(2);
            baseNewComment.setCreated_at(com.amgcyo.cuttadon.utils.otherutils.y.d(baseNewComment.getCreated_at()));
            boolean z2 = com.amgcyo.cuttadon.utils.otherutils.g.z() == baseNewComment.getUser_id();
            baseNewComment.setLoginUser(z2);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
                Iterator<MkCommentStatus> it = listB.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MkCommentStatus next = it.next();
                        if (z2 && baseNewComment.getComment_id() == next.getCommentId()) {
                            baseNewComment.setFav_state(next.getComment_fav_status());
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public /* synthetic */ ObservableSource a(String str, List list, BaseModel baseModel) throws Exception {
        NormalAdParams normalAdParamsB;
        int iB;
        int i2;
        V7Bookcity v7Bookcity = (V7Bookcity) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), V7Bookcity.class);
        Items items = new Items();
        if (v7Bookcity == null) {
            return Observable.just(items);
        }
        List<V7BannerBean> banner = v7Bookcity.getBanner();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(banner)) {
            BookCityHeaderData bookCityHeaderData = new BookCityHeaderData();
            bookCityHeaderData.setBanner(banner);
            bookCityHeaderData.setSex(str);
            items.add(bookCityHeaderData);
        }
        List<V7IconBean> icon = v7Bookcity.getIcon();
        int i3 = 1;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(icon) && com.amgcyo.cuttadon.utils.otherutils.g.m(str)) {
            if (com.amgcyo.cuttadon.utils.otherutils.h.Q() == 1) {
                for (V7IconBean v7IconBean : icon) {
                    v7IconBean.setImage(com.amgcyo.cuttadon.utils.otherutils.h.h0() + "/" + v7IconBean.getImage());
                    items.add(v7IconBean);
                }
            } else {
                items.addAll(icon);
            }
        }
        int i4 = 0;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(banner) && com.amgcyo.cuttadon.utils.otherutils.g.l(str)) {
            NormalAdParams normalAdParamsB2 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_top");
            if (normalAdParamsB2 != null) {
                normalAdParamsB2.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3704r);
                items.add(normalAdParamsB2);
            }
        } else if ("male".equals(str)) {
            NormalAdParams normalAdParamsB3 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_male_top");
            if (normalAdParamsB3 != null) {
                normalAdParamsB3.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3704r);
                items.add(normalAdParamsB3);
            }
        } else if (("female".equals(str) || "comics".equals(str)) && (normalAdParamsB = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_female_top")) != null) {
            normalAdParamsB.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3704r);
            items.add(normalAdParamsB);
        }
        List<V7DataBean> data = v7Bookcity.getData();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data)) {
            Collections.sort(data, new Comparator() { // from class: com.amgcyo.cuttadon.api.repository.h
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BookRepository.a((V7DataBean) obj, (V7DataBean) obj2);
                }
            });
            int size = data.size();
            String str2 = "data里面的大小：" + size;
            int i5 = 0;
            while (i5 < size) {
                if (i5 == 2) {
                    if ("male".equals(str)) {
                        NormalAdParams normalAdParamsB4 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_male_center");
                        if (normalAdParamsB4 != null) {
                            normalAdParamsB4.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3705s);
                            items.add(normalAdParamsB4);
                        }
                    } else if ("female".equals(str) || "comics".equals(str)) {
                        NormalAdParams normalAdParamsB5 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_female_center");
                        if (normalAdParamsB5 != null) {
                            normalAdParamsB5.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3705s);
                            items.add(normalAdParamsB5);
                        }
                    } else {
                        NormalAdParams normalAdParamsB6 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_center");
                        if (normalAdParamsB6 != null) {
                            normalAdParamsB6.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3705s);
                            items.add(normalAdParamsB6);
                        }
                    }
                } else if (i5 == 4) {
                    if ("male".equals(str)) {
                        NormalAdParams normalAdParamsB7 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_male_end");
                        if (normalAdParamsB7 != null) {
                            normalAdParamsB7.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3706t);
                            items.add(normalAdParamsB7);
                        }
                    } else if ("female".equals(str) || "comics".equals(str)) {
                        NormalAdParams normalAdParamsB8 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_female_end");
                        if (normalAdParamsB8 != null) {
                            normalAdParamsB8.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3706t);
                            items.add(normalAdParamsB8);
                        }
                    } else {
                        NormalAdParams normalAdParamsB9 = com.amgcyo.cuttadon.sdk.utils.e.b("position_book_city_end");
                        if (normalAdParamsB9 != null) {
                            normalAdParamsB9.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3706t);
                            items.add(normalAdParamsB9);
                        }
                    }
                }
                if (i5 == size - 2 && com.amgcyo.cuttadon.utils.otherutils.h.O() != 0) {
                    items.add(new WanyiwanBean(com.amgcyo.cuttadon.f.n.f3708v, 3));
                }
                V7DataBean v7DataBean = data.get(i5);
                int style = v7DataBean.getStyle();
                List<ShudanListData> data2 = v7DataBean.getData();
                String str3 = !(v7DataBean.getMore() == i3) ? "" : "查看更多";
                String name = v7DataBean.getName();
                int category = v7DataBean.getCategory();
                switch (style) {
                    case 0:
                        String str4 = str3;
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            items.add(new MultiTile(name, category, str, str4));
                            int i6 = 0;
                            while (i6 < data2.size()) {
                                ShudanListData shudanListData = data2.get(i6);
                                if (i6 == 0) {
                                    iB = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
                                } else if (i6 == 1) {
                                    iB = com.amgcyo.cuttadon.f.o.b(R.color.color_2);
                                } else {
                                    iB = i6 == 2 ? com.amgcyo.cuttadon.f.o.b(R.color.color_3) : com.amgcyo.cuttadon.f.o.b(R.color.color_CCCCCC);
                                    i6++;
                                    items.add(new ItemsGrid2Book(i6, shudanListData.getBook_id(), shudanListData.getForm(), shudanListData.getName(), shudanListData.getImage(), shudanListData.getAuthor(), iB));
                                }
                                i6++;
                                items.add(new ItemsGrid2Book(i6, shudanListData.getBook_id(), shudanListData.getForm(), shudanListData.getName(), shudanListData.getImage(), shudanListData.getAuthor(), iB));
                            }
                        }
                        break;
                    case 1:
                        String str5 = str3;
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            items.add(new MultiTile(category, name, str5, str, true));
                            items.addAll(data2);
                        }
                        break;
                    case 2:
                        String str6 = str3;
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            List listA = com.amgcyo.cuttadon.utils.otherutils.g.a(data2, 4);
                            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listA)) {
                                ArrayList arrayList = new ArrayList();
                                int i7 = 0;
                                while (i7 < listA.size()) {
                                    ShudanListData shudanListData2 = (ShudanListData) listA.get(i7);
                                    List list2 = listA;
                                    List<MkBook> data3 = shudanListData2.getData();
                                    if (com.amgcyo.cuttadon.utils.otherutils.g.a(data3)) {
                                        i2 = category;
                                    } else {
                                        i2 = category;
                                        int i8 = 0;
                                        while (i8 < data3.size()) {
                                            MkBook mkBook = data3.get(i8);
                                            i8++;
                                            mkBook.setPosition(i8);
                                        }
                                        arrayList.add(new RankBean(shudanListData2.getName(), shudanListData2.getSub_name(), data3));
                                    }
                                    i7++;
                                    listA = list2;
                                    category = i2;
                                }
                                int i9 = category;
                                if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
                                    items.add(new MultiTile(name, i9, str, str6));
                                    int i10 = 0;
                                    while (i10 < data2.size()) {
                                        ShudanListData shudanListData3 = data2.get(i10);
                                        i10++;
                                        items.add(new V7Style2Rank(i10, shudanListData3.getBook_id(), shudanListData3.getForm(), shudanListData3.getName(), shudanListData3.getImage(), shudanListData3.getAuthor(), shudanListData3.getScore()));
                                    }
                                } else {
                                    items.add(new MultiTile(true, name, i9, str, str6));
                                    BookStoreMaleBean bookStoreMaleBean = new BookStoreMaleBean();
                                    bookStoreMaleBean.setRank(arrayList);
                                    items.add(bookStoreMaleBean);
                                }
                            }
                        }
                        break;
                    case 3:
                    case 11:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            boolean z2 = style == 11;
                            List<ShudanListData> list3 = data2;
                            items.add(new MultiTile(name, category, str, str3, z2));
                            if (!z2 || com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
                                int i11 = 0;
                                while (i11 < list3.size()) {
                                    List<ShudanListData> list4 = list3;
                                    ShudanListData shudanListData4 = list4.get(i11);
                                    items.add(new MkBook(shudanListData4.getBook_id(), shudanListData4.getForm(), shudanListData4.getName(), shudanListData4.getImage(), shudanListData4.getScore(), shudanListData4.getRemark(), shudanListData4.getLtype(), shudanListData4.getWords_number()));
                                    i11++;
                                    list3 = list4;
                                }
                            } else {
                                items.addAll(list);
                            }
                        }
                        break;
                    case 4:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            items.add(new MultiTile(name, category, str, str3));
                            for (int i12 = 0; i12 < data2.size(); i12++) {
                                ShudanListData shudanListData5 = data2.get(i12);
                                items.add(new ItemsGrid2Book(i12, shudanListData5.getBook_id(), shudanListData5.getForm(), shudanListData5.getName(), shudanListData5.getImage(), shudanListData5.getAuthor(), 0));
                            }
                        }
                        break;
                    case 5:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            items.add(new MultiTile(name, category, str, str3));
                            for (int i13 = 0; i13 < data2.size(); i13++) {
                                ShudanListData shudanListData6 = data2.get(i13);
                                items.add(new ItemsGrid3Book(i13, shudanListData6.getBook_id(), shudanListData6.getForm(), shudanListData6.getName(), shudanListData6.getImage(), shudanListData6.getAuthor()));
                            }
                        }
                        break;
                    case 6:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2)) {
                            items.add(new MultiTile(name, category, str, str3));
                            for (int i14 = 0; i14 < data2.size(); i14++) {
                                ShudanListData shudanListData7 = data2.get(i14);
                                items.add(new ItemsGrid4Book(shudanListData7.getBook_id(), shudanListData7.getForm(), shudanListData7.getName(), shudanListData7.getImage(), shudanListData7.getAuthor()));
                            }
                        }
                        break;
                    case 7:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2) && data2.size() >= 5) {
                            items.add(new MultiTile(name, category, str, str3));
                            ShudanListData shudanListData8 = data2.subList(i4, 1).get(i4);
                            items.add(new MkBook(shudanListData8.getBook_id(), shudanListData8.getForm(), shudanListData8.getName(), shudanListData8.getImage(), shudanListData8.getScore(), shudanListData8.getRemark(), shudanListData8.getLtype(), shudanListData8.getWords_number()));
                            List<ShudanListData> listSubList = data2.subList(1, data2.size());
                            for (int i15 = 0; i15 < listSubList.size(); i15++) {
                                if (i15 < this.sigleLine) {
                                    ShudanListData shudanListData9 = listSubList.get(i15);
                                    items.add(new ItemsGrid4Book(shudanListData9.getBook_id(), shudanListData9.getForm(), shudanListData9.getName(), shudanListData9.getImage(), shudanListData9.getAuthor()));
                                }
                            }
                        }
                        break;
                    case 10:
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data2) && data2.size() >= 6) {
                            items.add(new MultiTile(name, category, str, str3));
                            for (int i16 = 0; i16 < data2.size(); i16++) {
                                ShudanListData shudanListData10 = data2.get(i16);
                                if (i16 < 3) {
                                    items.add(new ItemsGrid3Book(i16, shudanListData10.getBook_id(), shudanListData10.getForm(), shudanListData10.getName(), shudanListData10.getImage(), shudanListData10.getAuthor()));
                                } else {
                                    items.add(new MkBook(shudanListData10.getBook_id(), shudanListData10.getForm(), shudanListData10.getName(), shudanListData10.getImage(), shudanListData10.getScore(), shudanListData10.getRemark(), shudanListData10.getLtype(), shudanListData10.getWords_number()));
                                }
                            }
                        }
                        break;
                }
                i5++;
                i3 = 1;
                i4 = 0;
            }
        }
        return Observable.just(items);
    }

    public Observable<BaseModel> addBookToShelfV4(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).c(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.v
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.a(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> addBookToShelfV6(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(i2, i3, com.open.hule.library.c.b.a(String.format(Locale.getDefault(), "%d%d%d%s", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() / 1000), ")*YHLK%$^EDRYFVGJkj"))).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.m0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.b(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> addSourceChoose(int i2, String str) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).d(i2, str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.w0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.c(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> addThemeBookList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).k(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.x0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.d(baseModel);
                return baseModel;
            }
        });
    }

    public /* synthetic */ void b(MkBook mkBook, Throwable th) throws Exception {
        String message = th.getMessage();
        if (!this.novelShow) {
            this.novelShow = true;
            l.b.a.j.a((CharSequence) message);
        }
        String str = "书籍id：" + mkBook.getBook_id() + "  " + mkBook.getName() + "  小说出现错误：" + message;
        if (!TextUtils.isEmpty(message) && message != null && message.contains("书籍已下架")) {
            mkBook.setShield_data(Collections.singletonList(Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.l())));
        }
        th.printStackTrace();
    }

    public Observable<BaseModel> deleteAllHistory(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.n0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.e(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> deleteBookFromShelf(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.y0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.f(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> deleteComment(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).h(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.s0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.g(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> deleteShelfReplyComment(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).j(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.h(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> deleteThemeBookList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).f(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.h0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.i(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> fattenBook(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).g(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.z0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.j(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> fattenDelBook(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).d(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.k(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<MkAllBookBean> getArtAllCateBookList(int i2, int i3, int i4, int i5, int i6, String str) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, i3, i4, i5, i6, str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.k0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.l((BaseModel) obj);
            }
        });
    }

    public Observable<MkBook> getArtBookAndComicsDetailBean(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).h(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.m((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkSiteBean>> getArtBookSourceList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.u0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.p((BaseModel) obj);
            }
        });
    }

    public Observable<ArrayList<MkBookclassifyBean>> getArtBookclassifyBeanList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).d(i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.x1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (ArrayList) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<List<MkBook>> getArtCategoryHotBookList(int i2, int i3, int i4) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, i3, i4 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.q((BaseModel) obj);
            }
        });
    }

    public Observable<MkBook> getArtComicDetailBean(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).c(com.amgcyo.cuttadon.utils.otherutils.g.d(i2), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.r((BaseModel) obj);
            }
        });
    }

    public Observable<HistoryBookBean> getArtHistoryBookID(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).h(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.b0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.s((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getArtHotCommentBookList() {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.r0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.t((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getArtRankDeatilListV7(int i2, String str) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).c(com.amgcyo.cuttadon.utils.otherutils.g.l(), i2, str + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.z
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.u((BaseModel) obj);
            }
        });
    }

    public Observable<List<BaseMaleFemaleBean>> getArtRankIndexBeanV7(final int i2) {
        WeakHashMap<Integer, Object> weakHashMap = this.sexDataCache;
        if (weakHashMap != null) {
            Object obj = weakHashMap.get(Integer.valueOf(i2));
            if (obj instanceof List) {
                return Observable.just((List) obj);
            }
        }
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).c(com.amgcyo.cuttadon.utils.otherutils.g.l() + ".html").subscribeOn(Schedulers.io()).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.repository.b1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return this.f3443s.a(i2, (BaseModel) obj2);
            }
        });
    }

    public Observable<SitePathReload> getArtSitePathReload(String str) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(str).subscribeOn(Schedulers.io()).map(v3.f3560s);
    }

    public Observable<List<ShudanListData>> getArtThemeBookBaseInfo(List<ThemeLisiID> list) {
        return Observable.fromArray(list).flatMap(z1.f3579s).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.w1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((ThemeLisiID) obj).getList_id());
            }
        }).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.repository.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f3461s.a((Integer) obj);
            }
        }).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                ShudanListData shudanListData = (ShudanListData) obj;
                BookRepository.a(shudanListData);
                return shudanListData;
            }
        }).collect(v1.f3558s, new BiConsumer() { // from class: com.amgcyo.cuttadon.api.repository.i2
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((List) obj).add((ShudanListData) obj2);
            }
        }).subscribeOn(Schedulers.io()).flatMapObservable(new Function() { // from class: com.amgcyo.cuttadon.api.repository.a2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.just((List) obj);
            }
        });
    }

    public Observable<ThemeBookListBean> getArtThemeBookList(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).f(i2, i3 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.v((BaseModel) obj);
            }
        });
    }

    public Observable<ThemeBookListDeatil> getArtThemeBookListDeatil(String str) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.x
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.w((BaseModel) obj);
            }
        });
    }

    public Observable<ThemeBookListID> getArtThemeBookListID(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).g(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.y1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (ThemeBookListID) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Items> getBookCityClassifyDataV4() {
        final Items items = new Items();
        WeakHashMap<String, BookClassBean> weakHashMap = this.bookClassBeanWeakHashMap;
        if (weakHashMap == null || !weakHashMap.containsKey("title")) {
            return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b().subscribeOn(Schedulers.io()).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.repository.j0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f3489s.a(items, (BaseModel) obj);
                }
            });
        }
        items.add(this.bookClassBeanWeakHashMap.get("title"));
        return Observable.just(items);
    }

    public Observable<List<MkBook>> getBookCityMoreV7(String str, int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(str, com.amgcyo.cuttadon.utils.otherutils.g.l(), i2, i3 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.x((BaseModel) obj);
            }
        });
    }

    public Observable<Items> getBookCitySexDataListDataConfV7(final String str, final List<MkBook> list) {
        com.amgcyo.cuttadon.utils.otherutils.g.a(list);
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(str, com.amgcyo.cuttadon.utils.otherutils.g.l(), getRandHtml()).subscribeOn(Schedulers.io()).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.repository.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f3465s.a(str, list, (BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getBookCityYourLikeV7(String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).b(str, com.amgcyo.cuttadon.utils.otherutils.g.f(), i2 + ".html").subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.v0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.y((BaseModel) obj);
            }
        });
    }

    public Observable<List<BaseNewComment>> getBookDetailCommentList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).c(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.z((BaseModel) obj);
            }
        });
    }

    public Observable<CommentDetailBean> getCommentDetailBeanLoadMore(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).f(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.c0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.A((BaseModel) obj);
            }
        });
    }

    public Observable<CommentBean> getCommentListLoadMore(int i2, int i3, int i4) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, i3, i4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.a1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.B((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getLoginUserShelfBookList(final boolean z2, final int i2) {
        final List[] listArr = {com.amgcyo.cuttadon.utils.otherutils.g.b(i2)};
        final HashMap map = new HashMap();
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.a(map, z2, i2, listArr, (BaseModel) obj);
            }
        });
    }

    public Observable<MkAllBookBean> getMaleFemaleMoreDataList(String str, int i2, int i3, String str2, int i4) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(str, i2, i3, str2, i4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.C((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getNoLoginArtShelfListData(final int i2) {
        final List[] listArr = {com.amgcyo.cuttadon.utils.otherutils.g.b(i2)};
        final HashMap map = new HashMap();
        return Observable.fromArray(listArr[0]).flatMap(z1.f3579s).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.f0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                MkBook mkBook = (MkBook) obj;
                BookRepository.a(mkBook);
                return mkBook;
            }
        }).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.repository.q0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f3527s.a(i2, (MkBook) obj);
            }
        }).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.p0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                MkBook mkBook = (MkBook) obj;
                BookRepository.b(mkBook);
                return mkBook;
            }
        }).collect(v1.f3558s, new BiConsumer() { // from class: com.amgcyo.cuttadon.api.repository.m3
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((List) obj).add((MkBook) obj2);
            }
        }).subscribeOn(Schedulers.io()).flatMapObservable(new Function() { // from class: com.amgcyo.cuttadon.api.repository.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.a(map, listArr, i2, (List) obj);
            }
        });
    }

    public Observable<ThemeStates> isFavThemeBookList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).d(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.b2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (ThemeStates) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<BaseModel> likeComment(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).e(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.l0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.D(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> likeReplyComment(int i2) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).i(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.E(baseModel);
                return baseModel;
            }
        });
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
        this.sexDataCache = null;
        this.bookClassBeanWeakHashMap = null;
    }

    public Observable<PostCommentRespone> postComment(int i2, String str, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, str, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.l3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (PostCommentRespone) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<BaseModel<BaseCommentBean>> subMitCommentV4(int i2, int i3, String str, int i4) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, i3, str, i4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.d0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.F(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> topBook(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).a(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.i0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.G(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> topDelBook(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.a) this.mManager.a(com.amgcyo.cuttadon.c.a.a.class)).e(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.y
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                BookRepository.H(baseModel);
                return baseModel;
            }
        });
    }

    static /* synthetic */ ShudanListData b(Throwable th) throws Exception {
        return new ShudanListData();
    }

    static /* synthetic */ int a(V7DataBean v7DataBean, V7DataBean v7DataBean2) {
        return v7DataBean.getCategory() - v7DataBean2.getCategory();
    }

    public /* synthetic */ ObservableSource a(int i2, BaseModel baseModel) throws Exception {
        try {
            RankIndexLeft rankIndexLeft = (RankIndexLeft) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), RankIndexLeft.class);
            if (rankIndexLeft != null) {
                if (this.sexDataCache == null) {
                    this.sexDataCache = new WeakHashMap<>();
                }
                this.sexDataCache.put(1, rankIndexLeft.getMale());
                this.sexDataCache.put(2, rankIndexLeft.getFemale());
                this.sexDataCache.put(5, rankIndexLeft.getComics());
                Object obj = this.sexDataCache.get(Integer.valueOf(i2));
                if (obj instanceof List) {
                    return Observable.just((List) obj);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Observable.just(new ArrayList());
    }

    public /* synthetic */ ObservableSource a(Items items, BaseModel baseModel) throws Exception {
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        if (base64Bean == null) {
            return Observable.just(items);
        }
        BookClassBean bookClassBean = (BookClassBean) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, BookClassBean.class);
        if (bookClassBean == null) {
            return Observable.just(items);
        }
        if (this.bookClassBeanWeakHashMap == null) {
            this.bookClassBeanWeakHashMap = new WeakHashMap<>();
        }
        com.amgcyo.cuttadon.utils.otherutils.d dVarA = com.amgcyo.cuttadon.utils.otherutils.d.a(MkApplication.getAppContext());
        ArrayList<MkBookclassifyBean> female = bookClassBean.getFemale();
        ArrayList<MkBookclassifyBean> male = bookClassBean.getMale();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(male)) {
            dVarA.a("all_book_classify_bean_1", male);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(female)) {
            dVarA.a("all_book_classify_bean_2", female);
        }
        items.add(bookClassBean);
        this.bookClassBeanWeakHashMap.put("title", bookClassBean);
        return Observable.just(items);
    }

    public /* synthetic */ Observable a(int i2, final MkBook mkBook) throws Exception {
        if (com.amgcyo.cuttadon.utils.otherutils.g.h(i2)) {
            return getArtBookShelfComicDetail(mkBook.getBook_id()).doOnError(new Consumer() { // from class: com.amgcyo.cuttadon.api.repository.t0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f3543s.a(mkBook, (Throwable) obj);
                }
            }).onErrorReturn(new Function() { // from class: com.amgcyo.cuttadon.api.repository.j
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) throws Exception {
                    MkBook mkBook2 = mkBook;
                    BookRepository.c(mkBook2, (Throwable) obj);
                    return mkBook2;
                }
            });
        }
        return getArtBookShelfBookDetail(mkBook.getBook_id()).doOnError(new Consumer() { // from class: com.amgcyo.cuttadon.api.repository.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f3494s.b(mkBook, (Throwable) obj);
            }
        }).onErrorReturn(new Function() { // from class: com.amgcyo.cuttadon.api.repository.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                MkBook mkBook2 = mkBook;
                BookRepository.d(mkBook2, (Throwable) obj);
                return mkBook2;
            }
        });
    }

    public /* synthetic */ void a(MkBook mkBook, Throwable th) throws Exception {
        String message = th.getMessage();
        if (!this.comicShow) {
            this.comicShow = true;
            l.b.a.j.a((CharSequence) message);
        }
        String str = "书籍id：" + mkBook.getBook_id() + "  " + mkBook.getName() + "  漫画出现错误：" + message;
        if (!TextUtils.isEmpty(message) && message != null && message.contains("书籍已下架")) {
            mkBook.setShield_data(Collections.singletonList(Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.l())));
        }
        th.printStackTrace();
    }

    static /* synthetic */ ObservableSource a(Map map, List[] listArr, int i2, List list) throws Exception {
        com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MkBook mkBook = (MkBook) it.next();
            List<Integer> shield_data = mkBook.getShield_data();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(shield_data)) {
                map.put(Integer.valueOf(mkBook.getBook_id()), shield_data);
            }
            String updated_at = mkBook.getUpdated_at();
            Iterator it2 = listArr[0].iterator();
            while (true) {
                if (it2.hasNext()) {
                    MkBook mkBook2 = (MkBook) it2.next();
                    if (mkBook.getBook_id() == mkBook2.getBook_id()) {
                        if (TextUtils.isEmpty(mkBook2.getName())) {
                            mkBook.setReading_datetime(mkBook2.getReading_datetime());
                            mkBook.setJpush_status(1);
                            fVarA.insert(mkBook);
                        } else {
                            String updated_at2 = mkBook2.getUpdated_at();
                            if ((TextUtils.isEmpty(updated_at2) || TextUtils.isEmpty(updated_at)) ? true : com.amgcyo.cuttadon.utils.otherutils.y.a(updated_at2, updated_at)) {
                                int fatten_num = mkBook2.getIs_fatten() == 1 ? mkBook2.getFatten_num() + 1 : 0;
                                String str = "------更新本地数据库信息-------" + mkBook.getName() + "," + updated_at + " book_id：" + mkBook.getBook_id() + " last_chapter_name：" + mkBook.getLast_chapter_name();
                                fVarA.a(updated_at, 0, fatten_num, mkBook.getLast_chapter_name(), mkBook.getBook_id());
                            }
                            if (mkBook.getComment_number() != mkBook2.getComment_number()) {
                                fVarA.e(mkBook.getComment_number(), mkBook.getBook_id());
                            }
                            if (mkBook.getFav_count() != mkBook2.getFav_count()) {
                                fVarA.h(mkBook.getFav_count(), mkBook.getBook_id());
                            }
                            if (mkBook.getWords_number() != mkBook2.getWords_number()) {
                                fVarA.f(mkBook.getWords_number(), mkBook.getBook_id());
                            }
                            if (mkBook.getScore_number() != mkBook2.getScore_number()) {
                                fVarA.b(mkBook.getScore_number(), mkBook.getBook_id());
                            }
                            if (mkBook.getView_count() != mkBook2.getView_count()) {
                                fVarA.i(mkBook.getView_count(), mkBook.getBook_id());
                            }
                            if (TextUtils.isEmpty(mkBook2.getScore()) || !mkBook2.getScore().equals(mkBook.getScore())) {
                                fVarA.d(mkBook.getScore(), mkBook.getBook_id());
                            }
                            if (com.amgcyo.cuttadon.utils.otherutils.g.h(i2)) {
                                if (TextUtils.isEmpty(mkBook2.getList_path()) || !mkBook2.getList_path().equals(mkBook.getList_path()) || TextUtils.isEmpty(mkBook2.getList_reload_path()) || !mkBook2.getList_reload_path().equals(mkBook.getList_reload_path())) {
                                    fVarA.a(mkBook.getList_path(), mkBook.getList_reload_path(), mkBook.getBook_id());
                                }
                                if (!mkBook.getImage().equals(mkBook2.getImage()) || !mkBook.getName().equals(mkBook2.getName()) || !mkBook.getAuthor().equals(mkBook2.getAuthor()) || !mkBook.getList_path().equals(mkBook2.getList_path()) || !mkBook.getLast_chapter_name().equals(mkBook2.getLast_chapter_name()) || !mkBook.getList_reload_path().equals(mkBook2.getList_reload_path()) || mkBook.getStatus() != mkBook2.getStatus() || mkBook.getIs_fatten() != mkBook2.getIs_fatten() || mkBook.getIs_top() != mkBook2.getIs_top() || mkBook.getChapter_count() != mkBook2.getChapter_count()) {
                                    fVarA.a(mkBook.getName(), mkBook.getAuthor(), mkBook.getImage(), mkBook.getList_path(), mkBook.getLast_chapter_name(), mkBook.getList_reload_path(), mkBook.getStatus(), mkBook.getChapter_count(), mkBook.getIs_fatten(), mkBook.getIs_top(), mkBook.getBook_id());
                                }
                            } else if (!mkBook.getImage().equals(mkBook2.getImage()) || !mkBook.getName().equals(mkBook2.getName()) || !mkBook.getAuthor().equals(mkBook2.getAuthor()) || !mkBook.getLtype().equals(mkBook2.getLtype()) || !mkBook.getStype().equals(mkBook2.getStype()) || mkBook.getStatus() != mkBook2.getStatus()) {
                                fVarA.a(mkBook.getName(), mkBook.getAuthor(), mkBook.getImage(), mkBook.getLtype(), mkBook.getStype(), mkBook.getStatus(), mkBook.getBook_id());
                            }
                        }
                    }
                }
            }
        }
        listArr[0] = com.amgcyo.cuttadon.utils.otherutils.g.b(i2);
        String str2 = "shield_data_maps:" + map.size();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listArr[0])) {
            for (MkBook mkBook3 : listArr[0]) {
                Iterator it3 = map.entrySet().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Map.Entry entry = (Map.Entry) it3.next();
                        if (mkBook3.getBook_id() == ((Integer) entry.getKey()).intValue()) {
                            mkBook3.setShield_data((List) entry.getValue());
                            break;
                        }
                    }
                }
                mkBook3.setShow_update_at(com.amgcyo.cuttadon.utils.otherutils.y.b(mkBook3.getUpdated_at()));
                mkBook3.setShow_last_read_at(com.amgcyo.cuttadon.utils.otherutils.y.c(com.amgcyo.cuttadon.utils.otherutils.t0.d(mkBook3.getReading_datetime() * 1000)));
            }
        }
        return Observable.just(listArr[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.util.List a(java.util.Map r15, boolean r16, int r17, java.util.List[] r18, me.jessyan.art.entity.BaseModel r19) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.api.repository.BookRepository.a(java.util.Map, boolean, int, java.util.List[], me.jessyan.art.entity.BaseModel):java.util.List");
    }

    public /* synthetic */ Observable a(Integer num) throws Exception {
        return getArtBookListBaseInfo(num.intValue()).doOnError(new Consumer() { // from class: com.amgcyo.cuttadon.api.repository.g0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                BookRepository.a((Throwable) obj);
            }
        }).onErrorReturn(new Function() { // from class: com.amgcyo.cuttadon.api.repository.w
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BookRepository.b((Throwable) obj);
            }
        });
    }
}
