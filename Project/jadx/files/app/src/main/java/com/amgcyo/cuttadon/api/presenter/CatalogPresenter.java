package com.amgcyo.cuttadon.api.presenter;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.reader.ReadLog;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.amgcyo.cuttadon.api.repository.CatalogRepository;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.ChapterException;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.BasePresenter;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class CatalogPresenter extends BasePresenter<CatalogRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3245u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3246v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList<MkCatalog> f3247w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Disposable f3248x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3249y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3250z;

    class a implements Observer<Long> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.g.i f3251s;

        a(com.amgcyo.cuttadon.g.i iVar) {
            this.f3251s = iVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long l2) {
            try {
                com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", Integer.valueOf(com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", 0).intValue() + 60));
                CatalogPresenter.this.f3249y = com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", 0).intValue();
                if (CatalogPresenter.this.f3249y > CatalogPresenter.this.f3250z * 2) {
                    CatalogPresenter.this.f3249y = CatalogPresenter.this.f3250z;
                }
                if (CatalogPresenter.this.f3249y == 0 || CatalogPresenter.this.f3249y < CatalogPresenter.this.f3250z || this.f3251s == null) {
                    return;
                }
                this.f3251s.subMitrecordTime(CatalogPresenter.this.f3249y);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (CatalogPresenter.this.f3248x != null) {
                CatalogPresenter.this.f3248x.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            th.printStackTrace();
            if (CatalogPresenter.this.f3248x != null) {
                CatalogPresenter.this.f3248x.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            CatalogPresenter.this.f3248x = disposable;
            CatalogPresenter.this.a(disposable);
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3253x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ String f3254y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, String str3) {
            super(cVar, str, str2);
            this.f3253x = message;
            this.f3254y = str3;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3253x;
            message.f21197s = 860;
            message.f21202x = baseModel;
            String strE = t0.e(System.currentTimeMillis());
            String str = strE + "提交阅读记录成功了。。。。";
            g0.a().b(this.f3254y, strE);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class c extends com.amgcyo.cuttadon.f.p<ReadLog> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3255x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3256y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2) {
            super(cVar, str, str2);
            this.f3255x = message;
            this.f3256y = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ReadLog readLog) {
            if (readLog != null) {
                if (readLog.getNext_id() <= 0) {
                    g0.a().b("piexl_" + t0.a(), 1);
                }
                com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", (Object) 0);
                com.amgcyo.cuttadon.utils.comic.d.a("refresh_read_time", (Object) 1);
                com.amgcyo.cuttadon.utils.otherutils.h.u(1);
                Message message = this.f3255x;
                message.f21197s = this.f3256y;
                message.f21202x = readLog;
                message.b();
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", (Object) 0);
            Message message = this.f3255x;
            message.f21197s = this.f3256y;
            message.f21202x = null;
            message.b();
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<SitePathReload> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkBook f3257x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3258y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3259z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, MkBook mkBook, Message message, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3257x = mkBook;
            this.f3258y = message;
            this.f3259z = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(SitePathReload sitePathReload) {
            if (sitePathReload != null) {
                long reload_updated_at = this.f3257x.getReload_updated_at();
                long updated_at = sitePathReload.getUpdated_at();
                String str = "oldUpdateAt:" + reload_updated_at + " newUpdateAt: " + updated_at;
                if (reload_updated_at != updated_at) {
                    this.f3257x.setUpdated(0);
                } else {
                    this.f3257x.setUpdated(8);
                }
            }
            this.f3258y.f21202x = this.f3257x;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            this.f3259z.hideLoading();
            if (me.jessyan.art.f.f.a(this.f3259z.getHostContext()) && me.jessyan.art.f.f.b(this.f3259z.getHostContext())) {
                this.f3257x.setUpdated(0);
            } else {
                this.f3257x.setUpdated(8);
            }
            this.f3258y.f21202x = this.f3257x;
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3260x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3261y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CatalogPresenter catalogPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2) {
            super(eVar, cVar, str, str2);
            this.f3260x = message;
            this.f3261y = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
                this.f3260x.f21197s = 837;
                return;
            }
            Message message = this.f3260x;
            message.f21197s = this.f3261y;
            message.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class f extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3262x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3263y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2) {
            super(cVar, str, str2);
            this.f3262x = message;
            this.f3263y = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
                this.f3262x.f21197s = 837;
                return;
            }
            Message message = this.f3262x;
            message.f21197s = this.f3263y;
            message.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class g extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3264x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ MkBook f3265y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, MkBook mkBook) {
            super(eVar, cVar, str, str2);
            this.f3264x = message;
            this.f3265y = mkBook;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
                this.f3264x.f21197s = 1543;
                return;
            }
            this.f3265y.setUpdated(8);
            String str = "获取章节列表数据大小：" + arrayList.size();
            CatalogPresenter.this.f3247w = arrayList;
            Message message = this.f3264x;
            message.f21197s = 1545;
            message.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3264x.f21197s = 1543;
        }
    }

    class h extends com.amgcyo.cuttadon.f.p<MkChapterContent> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3267x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ boolean f3268y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3269z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(CatalogPresenter catalogPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, boolean z2, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3267x = message;
            this.f3268y = z2;
            this.f3269z = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkChapterContent mkChapterContent) {
            Message message = this.f3267x;
            message.f21197s = 827;
            message.f21202x = mkChapterContent;
            if (this.f3268y && mkChapterContent.isOnErrorReturn() && !TextUtils.isEmpty(mkChapterContent.getError_msg())) {
                super.onError(new ChapterException(mkChapterContent.getPath()));
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            me.jessyan.art.mvp.e eVar;
            super.onError(th);
            if (!this.f3268y || (eVar = this.f3269z) == null) {
                return;
            }
            eVar.showMessage("请求章节失败,请重试或移出书架重新添加后重试！");
            this.f3269z.hideLoading();
            Message message = this.f3267x;
            message.f21197s = 863;
            message.f21202x = null;
        }
    }

    class i extends com.amgcyo.cuttadon.f.p<MkChapterContent> {
        i(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkChapterContent mkChapterContent) {
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
        }
    }

    class j extends com.amgcyo.cuttadon.f.p<MkChapterContent> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3270x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(CatalogPresenter catalogPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3270x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkChapterContent mkChapterContent) {
            Message message = this.f3270x;
            message.f21197s = 893;
            message.f21202x = mkChapterContent;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3270x;
            message.f21197s = 893;
            message.f21202x = null;
        }
    }

    class k extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3271x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(CatalogPresenter catalogPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3271x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
                this.f3271x.f21197s = 837;
                return;
            }
            Message message = this.f3271x;
            message.f21197s = 878;
            message.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class l extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3272x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3272x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
                this.f3272x.f21197s = 837;
                return;
            }
            Message message = this.f3272x;
            message.f21197s = 878;
            message.f21202x = arrayList;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class m extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkBook f3273x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3274y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, MkBook mkBook, Message message) {
            super(cVar, str, str2);
            this.f3273x = mkBook;
            this.f3274y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList<MkCatalog> arrayList) {
            this.f3273x.setUpdated(8);
            Message message = this.f3274y;
            message.f21202x = arrayList;
            message.f21197s = 1339;
            String str = "getArtChapterList数据大小：" + arrayList.size();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            Message message = this.f3274y;
            message.f21202x = null;
            message.f21197s = 1339;
        }
    }

    public CatalogPresenter(me.jessyan.art.a.a.a aVar) {
        super((CatalogRepository) aVar.d().b(CatalogRepository.class));
        this.f3245u = aVar.b();
    }

    private Observable<MkChapterContent> j(Message message) {
        final me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        final MkBook mkBook = (MkBook) objArr[1];
        final AtomicInteger atomicInteger = new AtomicInteger(((Integer) objArr[2]).intValue());
        return Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.presenter.f
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(mkBook, eVarA, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.computation()).flatMap(new Function() { // from class: com.amgcyo.cuttadon.api.presenter.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f3403s.a(atomicInteger, mkBook, (ArrayList) obj);
            }
        });
    }

    public void c(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        Object[] objArr = message.f21203y;
        final MkBook mkBook = (MkBook) objArr[1];
        int iIntValue = ((Integer) objArr[2]).intValue();
        Observable observableObserveOn = Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.presenter.d
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.b(mkBook, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe((Observer) (zBooleanValue ? new e(this, eVarA, this.f3245u, "catalog", "获取章节列表接口03", message, iIntValue) : new f(this, this.f3245u, "catalog", "获取章节列表接口04", message, iIntValue)));
    }

    public void d(Message message) {
        Object[] objArr = message.f21203y;
        MkCatalog mkCatalog = (MkCatalog) objArr[0];
        MkBook mkBook = (MkBook) objArr[1];
        boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
        Observable<MkChapterContent> observableObserveOn = ((CatalogRepository) this.f21196t).getArtChapterContent(mkCatalog, mkBook.getBook_id(), mkBook.getReading_site_id()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(zBooleanValue ? new i(this, this.f3245u, "catalog", "预加载章节内容") : new j(this, message.a(), this.f3245u, "catalog", "重试或加载章节", message));
    }

    public void e(Message message) {
        MkBook mkBook = (MkBook) message.f21203y[0];
        Observable<ArrayList<MkCatalog>> observableObserveOn = ((CatalogRepository) this.f21196t).getArtCatalogBeanListData(mkBook, 0).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new m(this, this.f3245u, "catalog", "getArtChapterList", mkBook, message));
    }

    public void f(final Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        MkBook mkBook = (MkBook) objArr[0];
        final int iIntValue = ((Integer) objArr[1]).intValue();
        ((CatalogRepository) this.f21196t).getArtSitePathReload(mkBook.getSite_path_reload()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.e
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                CatalogPresenter.a(message, iIntValue);
            }
        }).subscribe(new d(this, this.f3245u, "catalog", "reload接口", mkBook, message, eVarA));
    }

    public void g(Message message) {
        Object[] objArr = message.f21203y;
        MkBook mkBook = (MkBook) objArr[0];
        int iIntValue = ((Integer) objArr[1]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[2]).intValue();
        String str = (String) message.f21203y[3];
        ((CatalogRepository) this.f21196t).setBookInfo(mkBook.getBook_id(), iIntValue, mkBook.getReading_site_id(), mkBook.getCrawl_book_id(), mkBook.getIs_top(), mkBook.getIs_fatten(), iIntValue2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, this.f3245u, "my", "提交阅读记录", message, str));
    }

    public void h(Message message) {
        me.jessyan.art.mvp.e eVarA;
        String str;
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        if (zBooleanValue) {
            eVarA = message.a();
            str = "请求章节内容接口带loading";
        } else {
            eVarA = null;
            str = "请求章节内容接口没有loading框";
        }
        me.jessyan.art.mvp.e eVar = eVarA;
        Observable<MkChapterContent> observableObserveOn = j(message).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new h(this, eVar, this.f3245u, "catalog", str, message, zBooleanValue, eVar));
    }

    public void i(Message message) {
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Object[] objArr = message.f21203y;
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        int iIntValue2 = ((Integer) objArr[3]).intValue();
        int iIntValue3 = ((Integer) message.f21203y[4]).intValue();
        int iIntValue4 = ((Integer) message.f21203y[5]).intValue();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Long lB = com.amgcyo.cuttadon.utils.comic.d.b("save_record_time");
        int iLongValue = (int) (jCurrentTimeMillis - lB.longValue());
        String str3 = "当前：" + jCurrentTimeMillis + " 上次保存的：" + lB + " 差值：" + iLongValue;
        if (iLongValue <= 10) {
            message.b();
            return;
        }
        if (iLongValue < this.f3250z) {
            iIntValue2 = iLongValue;
        }
        int i2 = this.f3250z;
        if (iLongValue >= i2) {
            iIntValue2 = i2;
        }
        if (iIntValue2 <= 0) {
            iIntValue2 = 1;
        }
        com.amgcyo.cuttadon.utils.comic.d.a("save_record_time", Long.valueOf(jCurrentTimeMillis));
        ((CatalogRepository) this.f21196t).submitRecordTime(iIntValue, str, str2, iIntValue2, iIntValue4).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, this.f3245u, "my", "提交阅读时间", message, iIntValue3));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3245u = null;
        this.f3247w = null;
    }

    public /* synthetic */ void b(MkBook mkBook, ObservableEmitter observableEmitter) throws Exception {
        ((CatalogRepository) this.f21196t).getArtCatalogBeanListData(mkBook, mkBook.getUpdated()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).subscribe(new y(this, this.f3245u, "catalog", "获取章节列表接口2", observableEmitter, mkBook));
    }

    public CatalogPresenter(me.jessyan.art.a.a.a aVar, com.amgcyo.cuttadon.g.h hVar) {
        super((CatalogRepository) aVar.d().b(CatalogRepository.class));
        this.f3245u = aVar.b();
    }

    public /* synthetic */ void a(MkBook mkBook, me.jessyan.art.mvp.e eVar, ObservableEmitter observableEmitter) throws Exception {
        ArrayList<MkCatalog> arrayList = this.f3247w;
        if (arrayList != null) {
            observableEmitter.onNext(arrayList);
            observableEmitter.onComplete();
        } else {
            ((CatalogRepository) this.f21196t).getArtCatalogBeanListData(mkBook, mkBook.getUpdated()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).subscribe(new z(this, eVar, false, this.f3245u, "catalog", "获取章节列表接口0", eVar, observableEmitter));
        }
    }

    public void b(Message message) {
        me.jessyan.art.mvp.e eVarA = ((Boolean) message.f21203y[0]).booleanValue() ? message.a() : null;
        MkBook mkBook = (MkBook) message.f21203y[1];
        Observable<ArrayList<MkCatalog>> observableObserveOn = ((CatalogRepository) this.f21196t).getArtCatalogBeanListData(mkBook, mkBook.getUpdated()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new g(eVarA, this.f3245u, "catalog", "获取章节列表接口2", message, mkBook));
    }

    public /* synthetic */ ObservableSource a(AtomicInteger atomicInteger, MkBook mkBook, ArrayList arrayList) throws Exception {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f3247w) && !com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
            int size = this.f3247w.size();
            if (size > 0 && atomicInteger.get() >= size) {
                atomicInteger.set(size - 1);
            }
            return a(mkBook, (MkCatalog) arrayList.get(atomicInteger.get()));
        }
        MkChapterContent mkChapterContent = new MkChapterContent(2);
        mkChapterContent.setOnErrorReturn(true);
        return Observable.just(mkChapterContent);
    }

    public void d() {
        Disposable disposable = this.f3248x;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.f3248x.dispose();
    }

    public Observable<MkChapterContent> a(final MkBook mkBook, final MkCatalog mkCatalog) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.presenter.h
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(mkCatalog, mkBook, observableEmitter);
            }
        }).subscribeOn(Schedulers.io());
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [M extends me.jessyan.art.mvp.b, me.jessyan.art.mvp.b] */
    public /* synthetic */ void a(MkCatalog mkCatalog, MkBook mkBook, ObservableEmitter observableEmitter) throws Exception {
        MkChapterContent mkChapterContentBlockingFirst;
        mkCatalog.setOnErrorReturn(false);
        int catalogId = mkCatalog.getCatalogId();
        File fileA = com.amgcyo.cuttadon.utils.otherutils.z.a(String.valueOf(mkBook.getBook_id()), mkBook.getReading_site_id(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()));
        mkCatalog.setCacheExists(!com.amgcyo.cuttadon.utils.otherutils.g.a(fileA));
        String absolutePath = fileA.getAbsolutePath();
        if (!mkCatalog.isIs_content()) {
            mkChapterContentBlockingFirst = new MkChapterContent(com.amgcyo.cuttadon.utils.otherutils.z.l(mkCatalog.getName()), catalogId, mkCatalog.getName(), mkCatalog.isIs_content());
            mkChapterContentBlockingFirst.setOnErrorReturn(false);
        } else if (mkCatalog.isCacheExists() && !TextUtils.isEmpty(absolutePath)) {
            String str = mkCatalog.getName() + " 该章节内容缓存已经缓存好了";
            MkChapterContent mkChapterContent = new MkChapterContent(absolutePath, catalogId, mkCatalog.getName());
            mkChapterContent.setOnErrorReturn(false);
            mkChapterContent.setIs_content(mkCatalog.isIs_content());
            mkChapterContentBlockingFirst = mkChapterContent;
        } else {
            String str2 = "正在缓存 --->>> " + mkCatalog.getName();
            int book_id = mkBook.getBook_id();
            String reading_site_id = mkBook.getReading_site_id();
            if (this.f21196t == 0) {
                this.f21196t = me.jessyan.art.f.e.a(MkApplication.getAppContext()).d().b(CatalogRepository.class);
            }
            MkChapterContent mkChapterContent2 = new MkChapterContent(com.amgcyo.cuttadon.utils.otherutils.z.l(), catalogId, mkCatalog.getName());
            mkChapterContent2.setIs_content(mkCatalog.isIs_content());
            mkChapterContentBlockingFirst = ((CatalogRepository) this.f21196t).getArtChapterContent(mkCatalog, book_id, reading_site_id).blockingFirst(mkChapterContent2);
            mkChapterContentBlockingFirst.setCatalogId(catalogId);
        }
        observableEmitter.onNext(mkChapterContentBlockingFirst);
        observableEmitter.onComplete();
    }

    public void a(Message message) {
        Disposable lVar;
        me.jessyan.art.mvp.e eVarA = message.a();
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        final MkBook mkBook = (MkBook) message.f21203y[1];
        Observable observableObserveOn = Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.presenter.i
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(mkBook, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        Observable observableDoFinally = observableObserveOn.doFinally(new v(message));
        if (zBooleanValue) {
            lVar = new k(this, eVarA, this.f3245u, "catalog", "获取章节列表接口03", message);
        } else {
            lVar = new l(this, this.f3245u, "catalog", "获取章节列表接口04", message);
        }
        observableDoFinally.subscribe((Observer) lVar);
    }

    public /* synthetic */ void a(MkBook mkBook, ObservableEmitter observableEmitter) throws Exception {
        ((CatalogRepository) this.f21196t).getArtCatalogBeanListData(mkBook, mkBook.getUpdated()).subscribeOn(Schedulers.io()).doOnSubscribe(new w(this)).subscribe(new a0(this, this.f3245u, "catalog", "获取章节列表接口2", observableEmitter, mkBook));
    }

    public void a(com.amgcyo.cuttadon.g.i iVar) {
        this.f3250z = com.amgcyo.cuttadon.sdk.utils.g.a("read_second", 100);
        try {
            if (this.f3248x != null) {
                this.f3248x.dispose();
            }
            Observable.interval(1L, 1L, TimeUnit.MINUTES).take(1441L).map(new Function() { // from class: com.amgcyo.cuttadon.api.presenter.c
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(1440 - ((Long) obj).longValue());
                }
            }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new a(iVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void a(Message message, int i2) throws Exception {
        message.f21197s = i2;
        message.b();
    }
}
