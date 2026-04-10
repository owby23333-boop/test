package com.amgcyo.cuttadon.api.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.api.entity.comic.SearchResultListV4;
import com.amgcyo.cuttadon.api.entity.other.MkAutoKeyword;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.repository.SearchRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.BasePresenter;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class SearchPresenter extends BasePresenter<SearchRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3315u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Disposable f3316v;

    class a extends com.amgcyo.cuttadon.f.p<BaseModel> {
        a(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<SearchResultListV4> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3317x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3317x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(SearchResultListV4 searchResultListV4) {
            Message message = this.f3317x;
            message.f21197s = 828;
            message.f21202x = searchResultListV4;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3317x;
            message.f21197s = 828;
            message.f21202x = null;
        }
    }

    class c extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3318x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3318x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            String str = "返回条数：" + list.size();
            Message message = this.f3318x;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3318x;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<List<MkAutoKeyword>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3319x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3319x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkAutoKeyword> list) {
            String str = list.size() + "条数据";
            this.f3319x.f21197s = 825;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
                this.f3319x.f21202x = list;
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                for (MkAutoKeyword mkAutoKeyword : list) {
                    if (mkAutoKeyword.getForm() != 3) {
                        arrayList.add(mkAutoKeyword);
                    }
                }
            }
            this.f3319x.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3320x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3321y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3320x = eVar;
            this.f3321y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.f3320x.showEmpty();
                return;
            }
            Message message = this.f3321y;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3321y;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class f extends com.amgcyo.cuttadon.f.p<BaseModel> {
        f(SearchPresenter searchPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            baseModel.getMsg();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    public SearchPresenter(me.jessyan.art.a.a.a aVar) {
        super((SearchRepository) aVar.d().b(SearchRepository.class));
        this.f3315u = aVar.b();
    }

    public void a(Message message) {
        Object[] objArr = message.f21203y;
        Observable<List<MkAutoKeyword>> observableObserveOn = ((SearchRepository) this.f21196t).getArtAutoKeywordBean((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer() { // from class: com.amgcyo.cuttadon.api.presenter.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f3416s.b((Disposable) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new d(this, this.f3315u, "s", "搜索自动联想", message));
    }

    public /* synthetic */ void b(Disposable disposable) throws Exception {
        a(disposable);
        this.f3316v = disposable;
    }

    public void c(Message message) {
        Object[] objArr = message.f21203y;
        Observable<List<MkBook>> observableObserveOn = ((SearchRepository) this.f21196t).getAutoSearchAuthorBookList((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new u(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new c(this, this.f3315u, "s", "搜索作者列表书籍接口", message));
    }

    public void d(Message message) {
        Object[] objArr = message.f21203y;
        Observable<SearchResultListV4> observableObserveOn = ((SearchRepository) this.f21196t).getSearchSearchResultBookList((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new u(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new b(this, this.f3315u, "s", "搜索接口v4", message));
    }

    public void e(Message message) {
        Object[] objArr = message.f21203y;
        ((SearchRepository) this.f21196t).postKeywordSearchLog((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new u(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, this.f3315u, "s", "搜索日志接口"));
    }

    public void f(Message message) {
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((SearchRepository) this.f21196t).postSearchBookItemClickLog((String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new f(this, this.f3315u, "s", "书籍搜索日志"));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3315u = null;
    }

    public void b(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<MkBook>> observableObserveOn = ((SearchRepository) this.f21196t).getArtRankDeatilList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new u(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new e(this, this.f3315u, "s", "搜索页面点击进去的排行榜列表", eVarA, message));
    }
}
