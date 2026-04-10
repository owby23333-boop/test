package com.amgcyo.cuttadon.api.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.DanmakuContent;
import com.amgcyo.cuttadon.api.entity.comic.DanmuResponeBean;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.amgcyo.cuttadon.api.repository.ComicRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.BasePresenter;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class ComicPresenter extends BasePresenter<ComicRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3277w;

    class a extends com.amgcyo.cuttadon.j.g.h.a<Object, ArrayList<ZymkChapter>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Message f3280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3281f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3282g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3283h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f3284i;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.api.presenter.ComicPresenter$a$a, reason: collision with other inner class name */
        class C0085a extends com.amgcyo.cuttadon.f.p<List<ZymkChapter>> {
            C0085a(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2) {
                super(eVar, cVar, str, str2);
            }

            @Override // io.reactivex.Observer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(List<ZymkChapter> list) {
                a aVar = a.this;
                Message message = aVar.f3280e;
                message.f21197s = aVar.f3281f;
                Object[] objArr = message.f21203y;
                objArr[0] = list;
                objArr[1] = Integer.valueOf(aVar.f3282g);
                a.this.f3280e.f21203y[2] = null;
            }

            @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                a aVar = a.this;
                Message message = aVar.f3280e;
                message.f21197s = aVar.f3281f;
                Object[] objArr = message.f21203y;
                objArr[0] = null;
                objArr[1] = Integer.valueOf(aVar.f3282g);
                a.this.f3280e.f21203y[2] = th;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, int i2, int i3, Message message, int i4, int i5, String str, boolean z2) {
            super(obj);
            this.f3278c = i2;
            this.f3279d = i3;
            this.f3280e = message;
            this.f3281f = i4;
            this.f3282g = i5;
            this.f3283h = str;
            this.f3284i = z2;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public ArrayList<ZymkChapter> a(Object obj) {
            String str = "读取章节目录缓存 是否主线程：" + me.jessyan.art.f.e.a();
            return com.amgcyo.cuttadon.utils.otherutils.z.c(this.f3278c);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ArrayList<ZymkChapter> arrayList) {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList) && 8 == this.f3279d) {
                String str = "读取章节目录缓存：" + arrayList.size() + " 是否主线程：" + me.jessyan.art.f.e.a();
                Message message = this.f3280e;
                message.f21197s = this.f3281f;
                Object[] objArr = message.f21203y;
                objArr[0] = arrayList;
                objArr[1] = Integer.valueOf(this.f3282g);
                Message message2 = this.f3280e;
                message2.f21203y[2] = null;
                message2.b();
                return;
            }
            Observable<List<ZymkChapter>> observableObserveOn = ((ComicRepository) ((BasePresenter) ComicPresenter.this).f21196t).getComicZymkChapterList(this.f3283h, this.f3278c).subscribeOn(Schedulers.io()).doOnSubscribe(new x(ComicPresenter.this)).observeOn(AndroidSchedulers.mainThread());
            Message message3 = this.f3280e;
            Objects.requireNonNull(message3);
            observableObserveOn.doFinally(new v(message3)).subscribe(new C0085a(this.f3284i ? this.f3280e.a() : null, ComicPresenter.this.f3275u, "comic_catalog", "获取3的列表数据"));
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<DanmuResponeBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3287x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ ZymkChapter f3288y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ComicPresenter comicPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, ZymkChapter zymkChapter) {
            super(cVar, str, str2);
            this.f3287x = message;
            this.f3288y = zymkChapter;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(DanmuResponeBean danmuResponeBean) {
            Message message = this.f3287x;
            message.f21197s = 1231;
            Object[] objArr = message.f21203y;
            objArr[0] = danmuResponeBean;
            objArr[1] = this.f3288y;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
        }
    }

    class c extends com.amgcyo.cuttadon.f.p<List<ComicChapter>> {
        final /* synthetic */ boolean A;
        final /* synthetic */ ZymkChapter B;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3289x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3290y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ int f3291z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2, int i3, boolean z2, ZymkChapter zymkChapter) {
            super(cVar, str, str2);
            this.f3289x = message;
            this.f3290y = i2;
            this.f3291z = i3;
            this.A = z2;
            this.B = zymkChapter;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<ComicChapter> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                ComicPresenter.this.a(this.f3289x, this.f3290y, (List<ComicChapter>) null, (Throwable) null);
            } else {
                int size = list.size();
                if (this.f3291z == 0) {
                    if (this.A && ComicPresenter.this.f3276v > 0 && ComicPresenter.this.f3276v != 3) {
                        for (int i2 = 0; i2 < size; i2++) {
                            if (ComicPresenter.this.a(i2)) {
                                ComicPresenter.this.a(list, i2, i2, this.B.getName());
                            }
                        }
                    }
                } else if (ComicPresenter.this.f3276v == 2 && this.A) {
                    ComicPresenter.this.b(list, this.B.getName());
                }
                if (ComicPresenter.this.f3276v == 1 && this.A) {
                    ComicPresenter.this.b(list, this.B.getName());
                }
                if (this.A) {
                    ComicPresenter.this.a(list, this.B.getName());
                }
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ComicChapter comicChapter = list.get(i3);
                    comicChapter.setIndex(i3);
                    comicChapter.setCount(size2);
                    comicChapter.setChapter_path(this.B.getPath());
                }
            }
            ComicPresenter.this.a(this.f3289x, this.f3290y, list, (Throwable) null);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            ComicPresenter.this.a(this.f3289x, this.f3290y, (List<ComicChapter>) null, th);
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<SitePathReload> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkBook f3292x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3293y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3294z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ComicPresenter comicPresenter, me.jessyan.art.e.c cVar, String str, String str2, MkBook mkBook, Message message, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3292x = mkBook;
            this.f3293y = message;
            this.f3294z = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(SitePathReload sitePathReload) {
            int i2 = 8;
            if (sitePathReload != null && sitePathReload.getUpdated_at() > 0) {
                long reload_updated_at = this.f3292x.getReload_updated_at();
                long updated_at = sitePathReload.getUpdated_at();
                String str = "oldUpdateAt:" + reload_updated_at + " newUpdateAt: " + updated_at;
                if (reload_updated_at != updated_at) {
                    i2 = 0;
                }
            }
            Object[] objArr = this.f3293y.f21203y;
            objArr[0] = this.f3292x;
            objArr[1] = Integer.valueOf(i2);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            this.f3294z.hideLoading();
            int i2 = (me.jessyan.art.f.f.a(this.f3294z.getHostContext()) && me.jessyan.art.f.f.b(this.f3294z.getHostContext())) ? 0 : 8;
            Object[] objArr = this.f3293y.f21203y;
            objArr[0] = this.f3292x;
            objArr[1] = Integer.valueOf(i2);
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<BaseModel> {
        final /* synthetic */ int A;
        final /* synthetic */ int B;
        final /* synthetic */ ComicChapter C;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3295x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3296y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ String f3297z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ComicPresenter comicPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message, String str3, int i2, int i3, ComicChapter comicChapter) {
            super(eVar, cVar, str, str2);
            this.f3295x = eVar2;
            this.f3296y = message;
            this.f3297z = str3;
            this.A = i2;
            this.B = i3;
            this.C = comicChapter;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3295x.showMessage("发送成功");
            this.f3296y.f21203y[0] = new DanmakuContent(this.f3297z, -1, this.A);
            this.f3296y.f21203y[1] = Integer.valueOf(this.B);
            this.f3296y.f21203y[2] = this.C;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Object[] objArr = this.f3296y.f21203y;
            objArr[0] = null;
            objArr[1] = -1;
            this.f3296y.f21203y[2] = null;
        }
    }

    public ComicPresenter(me.jessyan.art.a.a.a aVar) {
        super((ComicRepository) aVar.d().b(ComicRepository.class));
        this.f3275u = aVar.b();
        this.f3276v = com.amgcyo.cuttadon.utils.otherutils.h.e(3);
        this.f3277w = com.amgcyo.cuttadon.utils.otherutils.h.d(3);
        String str = "intervalCount:" + this.f3277w + " style:" + this.f3276v;
    }

    static /* synthetic */ void f(Message message) throws Exception {
        message.f21197s = 1215;
        message.b();
    }

    public void d(Message message) {
        Object[] objArr = message.f21203y;
        com.amgcyo.cuttadon.j.g.b.a(new a("", ((Integer) objArr[1]).intValue(), ((Integer) message.f21203y[2]).intValue(), message, ((Integer) message.f21203y[3]).intValue(), ((Integer) message.f21203y[4]).intValue(), (String) objArr[0], ((Boolean) message.f21203y[5]).booleanValue()));
    }

    public void e(final Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Object[] objArr = message.f21203y;
        String str = (String) objArr[1];
        int iIntValue2 = ((Integer) objArr[2]).intValue();
        Object[] objArr2 = message.f21203y;
        String str2 = (String) objArr2[3];
        int iIntValue3 = ((Integer) objArr2[4]).intValue();
        ((ComicRepository) this.f21196t).postComment(iIntValue, str, iIntValue2, str2, iIntValue3, 3).subscribeOn(Schedulers.io()).doOnSubscribe(new x(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.k
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                ComicPresenter.f(message);
            }
        }).subscribe(new e(this, eVarA, this.f3275u, "my", "提交弹幕", eVarA, message, str2, iIntValue3, ((Integer) message.f21203y[5]).intValue(), (ComicChapter) message.f21203y[6]));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3275u = null;
    }

    public void c(Message message) {
        Object[] objArr = message.f21203y;
        ZymkChapter zymkChapter = (ZymkChapter) objArr[0];
        ((ComicRepository) this.f21196t).getComicDanmakuList(((Integer) objArr[1]).intValue(), ((Integer) message.f21203y[2]).intValue(), zymkChapter.getPath()).subscribeOn(Schedulers.io()).doOnSubscribe(new x(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, this.f3275u, "comic_catalog", "获取弹幕列表", message, zymkChapter));
    }

    public void b(Message message) {
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        int iIntValue3 = ((Integer) message.f21203y[2]).intValue();
        Object[] objArr = message.f21203y;
        ZymkChapter zymkChapter = (ZymkChapter) objArr[3];
        ((ComicRepository) this.f21196t).getComicChapterContent(zymkChapter, iIntValue, iIntValue3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this.f3275u, "comic_pic", "获取3的内容数据", message, iIntValue2, iIntValue3, ((Boolean) objArr[4]).booleanValue(), zymkChapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i2, List<ComicChapter> list, Throwable th) {
        message.f21197s = i2;
        Object[] objArr = message.f21203y;
        objArr[0] = list;
        objArr[1] = th;
        message.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2) {
        int i3 = this.f3277w;
        return i3 > 0 && (i2 + 1) % i3 == 0 && this.f3276v == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ComicChapter> list, int i2, int i3, String str) {
        NormalAdParams normalAdParamsB = com.amgcyo.cuttadon.sdk.utils.e.b();
        if (normalAdParamsB != null) {
            list.add(i2, new ComicChapter(1, i3, str, normalAdParamsB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ComicChapter> list, String str) {
        NormalAdParams normalAdParamsB = com.amgcyo.cuttadon.sdk.utils.e.b();
        if (normalAdParamsB != null) {
            String str2 = "adParams不为空，添加首页广告对象," + str;
            list.add(new ComicChapter(1, 0, list.size() + 1, str, normalAdParamsB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ComicChapter> list, String str) {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a();
        if (normalAdParamsA != null) {
            list.add(new ComicChapter(1, list.size(), list.size() + 1, str, normalAdParamsA));
        }
    }

    public void a(final Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        MkBook mkBook = (MkBook) objArr[0];
        final int iIntValue = ((Integer) objArr[1]).intValue();
        ((ComicRepository) this.f21196t).getArtSitePathReload(mkBook.getList_reload_path()).subscribeOn(Schedulers.io()).doOnSubscribe(new x(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.j
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                ComicPresenter.a(message, iIntValue);
            }
        }).subscribe(new d(this, this.f3275u, "comic_catalog", "reload接口v4", mkBook, message, eVarA));
    }

    static /* synthetic */ void a(Message message, int i2) throws Exception {
        message.f21197s = i2;
        message.b();
    }
}
