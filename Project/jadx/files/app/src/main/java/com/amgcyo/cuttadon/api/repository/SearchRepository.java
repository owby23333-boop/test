package com.amgcyo.cuttadon.api.repository;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comic.SearchResultListV4;
import com.amgcyo.cuttadon.api.entity.other.MkAutoKeyword;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.fatcatfat.io.R;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: loaded from: classes.dex */
public class SearchRepository implements me.jessyan.art.mvp.b {
    private me.jessyan.art.mvp.d mManager;

    public SearchRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ List a(BaseModel baseModel) throws Exception {
        List listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkAutoKeyword.class);
        return com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB) ? com.amgcyo.cuttadon.utils.otherutils.o0.b().a() : listB;
    }

    static /* synthetic */ List b(BaseModel baseModel) throws Exception {
        List<MkBook> list = (List) baseModel.getData();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
            return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
        }
        for (MkBook mkBook : list) {
            mkBook.setItemType(2);
            mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
        }
        return list;
    }

    static /* synthetic */ List c(BaseModel baseModel) throws Exception {
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        if (base64Bean != null) {
            List<MkBook> listB = com.amgcyo.cuttadon.utils.comic.b.b(base64Bean, MkBook.class);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
                for (MkBook mkBook : listB) {
                    mkBook.setItemType(2);
                    mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
                }
                return listB;
            }
        }
        return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
    }

    static /* synthetic */ BaseModel d(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel e(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    private SpannableString findSearchKeyword(String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(Pattern.quote(str2)).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(this.mManager.getContext().getResources().getColor(R.color.colorPrimary)), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public Observable<List<MkAutoKeyword>> getArtAutoKeywordBean(String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).a(com.amgcyo.cuttadon.utils.otherutils.g.I(), str, com.amgcyo.cuttadon.utils.otherutils.h.h0(), i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.f2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SearchRepository.a((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getArtRankDeatilList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).a(i2, com.amgcyo.cuttadon.utils.otherutils.h.F()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.h2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SearchRepository.b((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkBook>> getAutoSearchAuthorBookList(String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).c(com.amgcyo.cuttadon.utils.otherutils.g.I(), str, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.e2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SearchRepository.c((BaseModel) obj);
            }
        });
    }

    public Observable<SearchResultListV4> getSearchSearchResultBookList(final String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).a(com.amgcyo.cuttadon.utils.otherutils.g.I(), str, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.c2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f3449s.a(str, (BaseModel) obj);
            }
        });
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
    }

    public Observable<BaseModel> postKeywordSearchLog(String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).a(str, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.g2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                SearchRepository.d(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> postSearchBookItemClickLog(String str, String str2, int i2) {
        return ((com.amgcyo.cuttadon.c.a.e) this.mManager.a(com.amgcyo.cuttadon.c.a.e.class)).b(str, str2, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.d2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                SearchRepository.e(baseModel);
                return baseModel;
            }
        });
    }

    public /* synthetic */ SearchResultListV4 a(String str, BaseModel baseModel) throws Exception {
        SearchResultListV4 searchResultListV4 = (SearchResultListV4) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), SearchResultListV4.class);
        if (searchResultListV4 != null) {
            List<MkBook> book = searchResultListV4.getBook();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(book)) {
                for (MkBook mkBook : book) {
                    mkBook.setHighLightBookName(findSearchKeyword(mkBook.getName(), str));
                    mkBook.setHighLightBookAuthor(findSearchKeyword(mkBook.getAuthor(), str));
                    mkBook.setRemark(com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
                    mkBook.setItemType(2);
                }
            }
        }
        return searchResultListV4;
    }
}
