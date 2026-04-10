package com.amgcyo.cuttadon.api.presenter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.DomainBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.SecondaryDomain;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkDataBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.api.entity.other.UserIndex;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.api.repository.ConfigRepository;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.m0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
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
public class ConfigPresenter extends BasePresenter<ConfigRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3298u;

    class a extends com.amgcyo.cuttadon.f.p<BaseModel> {
        a(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Object data = baseModel.getData();
            if (data instanceof List) {
                g0.a().b("lanren_info", com.amgcyo.cuttadon.utils.otherutils.r.a(data));
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<List<SearchHotkeyBean>> {
        b(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<SearchHotkeyBean> list) {
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class c extends com.amgcyo.cuttadon.f.p<List<MkConfigSource>> {
        c(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkConfigSource> list) {
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<MkAppVersion> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkApplication f3299x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3300y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ int f3301z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2, MkApplication mkApplication, Message message, int i2) {
            super(cVar, str, str2);
            this.f3299x = mkApplication;
            this.f3300y = message;
            this.f3301z = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAppVersion mkAppVersion) {
            String strE0;
            if (this.f3299x == null) {
                return;
            }
            if (mkAppVersion != null) {
                ArrayList<Integer> version_data = mkAppVersion.getVersion_data();
                this.f3299x.setVersion(mkAppVersion);
                this.f3299x.setVersion_data(version_data);
                com.amgcyo.cuttadon.utils.otherutils.g.y(com.amgcyo.cuttadon.utils.otherutils.g.a(version_data) ? "11000011" : "11000001");
                strE0 = mkAppVersion.getPrivacy_url();
                this.f3300y.f21202x = mkAppVersion;
                com.amgcyo.cuttadon.utils.otherutils.h.h(com.amgcyo.cuttadon.utils.otherutils.r.a(mkAppVersion));
            } else {
                this.f3300y.f21202x = null;
                strE0 = "";
            }
            if (TextUtils.isEmpty(strE0)) {
                strE0 = com.amgcyo.cuttadon.utils.otherutils.g.e0();
            }
            g0.a().b("privacy_url", strE0);
            this.f3300y.f21197s = this.f3301z;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f3299x == null) {
                return;
            }
            try {
                super.onError(th);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            MkAppVersion mkAppVersionI0 = com.amgcyo.cuttadon.utils.otherutils.h.i0();
            if (mkAppVersionI0 != null) {
                onNext(mkAppVersionI0);
                return;
            }
            String strE0 = com.amgcyo.cuttadon.utils.otherutils.g.e0();
            this.f3300y.f21202x = null;
            g0.a().b("privacy_url", strE0);
            this.f3300y.f21197s = this.f3301z;
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<MkAppConfig> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3302x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ boolean f3303y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(me.jessyan.art.e.c cVar, String str, String str2, Message message, boolean z2) {
            super(cVar, str, str2);
            this.f3302x = message;
            this.f3303y = z2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAppConfig mkAppConfig) {
            mkAppConfig.setIs_cache(false);
            Message message = this.f3302x;
            message.f21197s = 853;
            message.f21202x = mkAppConfig;
            MkApplication.getAppContext().setAppConfig(mkAppConfig);
            String strH = com.amgcyo.cuttadon.utils.otherutils.h.H();
            com.amgcyo.cuttadon.utils.otherutils.g.C(strH);
            SecondaryDomain secondaryDomainH = com.amgcyo.cuttadon.utils.otherutils.h.h();
            if (secondaryDomainH != null) {
                MkApplication.getAppContext().setDomainUrlBySecondDomain(secondaryDomainH);
            } else {
                MkApplication.getAppContext().setDomainUrl(strH);
            }
            com.amgcyo.cuttadon.utils.otherutils.g.a(mkAppConfig);
            String str = "请求配置信息成功，\n本次下发的CDN域名是:" + strH + " , 参数：" + com.amgcyo.cuttadon.utils.otherutils.h.e0();
            if (this.f3302x.f21203y.length >= 2) {
                me.jessyan.art.d.f.a().a(new com.amgcyo.cuttadon.view.read.page.i(), "tag_get_config");
            }
            this.f3302x.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            String str;
            String message = th.getMessage();
            String str2 = this.f3303y + " 请求配置出错：" + message;
            String[] strArrZ = com.amgcyo.cuttadon.utils.otherutils.g.Z();
            int i2 = 0;
            while (true) {
                if (i2 >= strArrZ.length) {
                    str = "";
                    break;
                }
                String str3 = strArrZ[i2];
                if (message != null && message.contains(str3)) {
                    str = "错误的网络请求，错误码：" + i2;
                    th.printStackTrace();
                    break;
                }
                i2++;
            }
            if (TextUtils.isEmpty(str) && message != null && message.contains("chuangke.tv")) {
                str = "错误的网络请求，错误码：-1";
            }
            if (!TextUtils.isEmpty(str)) {
                com.amgcyo.cuttadon.f.o.b(str);
            }
            Message message2 = this.f3302x;
            message2.f21202x = null;
            if (!this.f3303y) {
                message2.f21197s = 612;
                message2.b();
            } else if (com.amgcyo.cuttadon.utils.otherutils.g.q0()) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(), "getAvailableDomainName");
                ConfigPresenter.this.k(this.f3302x);
            } else {
                Message message3 = this.f3302x;
                message3.f21197s = 1803;
                message3.b();
            }
        }
    }

    class f extends com.amgcyo.cuttadon.f.p<MkAppConfig> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3305x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3305x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAppConfig mkAppConfig) {
            mkAppConfig.setIs_cache(false);
            String strH = com.amgcyo.cuttadon.utils.otherutils.h.H();
            com.amgcyo.cuttadon.utils.otherutils.g.C(strH);
            SecondaryDomain secondaryDomainH = com.amgcyo.cuttadon.utils.otherutils.h.h();
            if (secondaryDomainH != null) {
                MkApplication.getAppContext().setDomainUrlBySecondDomain(secondaryDomainH);
            } else {
                MkApplication.getAppContext().setDomainUrl(strH);
            }
            com.amgcyo.cuttadon.utils.otherutils.g.a(mkAppConfig);
            String str = "广告页专用 请求配置信息成功，本次下发的CDN域名是:" + strH;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            String str = "广告页专用 请求配置出错：" + th.getMessage();
            if (com.amgcyo.cuttadon.utils.otherutils.g.q0()) {
                ConfigPresenter.this.k(this.f3305x);
            }
        }
    }

    class g extends com.amgcyo.cuttadon.f.p<DomainBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3307x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3308y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(me.jessyan.art.e.c cVar, Message message, me.jessyan.art.mvp.e eVar) {
            super(cVar);
            this.f3307x = message;
            this.f3308y = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(DomainBean domainBean) {
            String domainName = domainBean.getDomainName();
            if (domainBean.isCheckEnd()) {
                String str = "没救了轮询了所有域名都没有成功，只能使用默认的chuangke.tv开始去请求配置信息";
                MkApplication.getAppContext().setDomainUrl("chuangke.tv");
                com.amgcyo.cuttadon.utils.otherutils.g.C("chuangke.tv");
            } else {
                g0.a().b(com.amgcyo.cuttadon.f.n.a, "");
                String str2 = "轮询了部分域名，找到可用的域名" + domainName + "开始去请求配置信息";
                MkApplication.getAppContext().setDomainUrl(domainName);
                com.amgcyo.cuttadon.utils.otherutils.g.C(domainName);
            }
            com.amgcyo.cuttadon.utils.otherutils.h.i("");
            String str3 = "msg.objs.length:" + this.f3307x.f21203y.length;
            if (this.f3307x.f21203y.length >= 2) {
                ConfigPresenter.this.c(Message.a(this.f3308y, new Object[]{false, "重新获取"}));
            } else {
                ConfigPresenter.this.c(Message.a(this.f3308y, new Object[]{false}));
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            th.printStackTrace();
            try {
                com.amgcyo.cuttadon.utils.otherutils.g.a(th, "config_presenetr");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class i extends com.amgcyo.cuttadon.f.p<List<CommentReprotType>> {
        i(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
            super(cVar, str, str2);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<CommentReprotType> list) {
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class j extends com.amgcyo.cuttadon.f.p<NewApiAdList> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ boolean f3313x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3314y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(ConfigPresenter configPresenter, me.jessyan.art.e.c cVar, String str, String str2, boolean z2, Message message) {
            super(cVar, str, str2);
            this.f3313x = z2;
            this.f3314y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(NewApiAdList newApiAdList) {
            if (this.f3313x) {
                Message message = this.f3314y;
                message.f21197s = 888;
                if (newApiAdList == null) {
                    message.f21202x = null;
                } else {
                    message.f21202x = com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.f.n.f3697k, 1, new boolean[0]);
                }
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            if (this.f3313x) {
                Message message = this.f3314y;
                message.f21197s = 888;
                message.f21202x = null;
            }
        }
    }

    public ConfigPresenter(me.jessyan.art.a.a.a aVar) {
        super((ConfigRepository) aVar.d().b(ConfigRepository.class));
        this.f3298u = aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<DomainBean> observableObserveOn = ((ConfigRepository) this.f21196t).getAvailableDomainName().subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new g(this.f3298u, message, eVarA));
    }

    public void b(Message message) {
        String str = "联网请求配置信息,objs长度为：" + message.f21203y.length;
        ((ConfigRepository) this.f21196t).getArtAppConfig(com.amgcyo.cuttadon.utils.otherutils.h.h0(), d()).subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this.f3298u, "conf", "获取配置信息接口\n", message, ((Boolean) message.f21203y[0]).booleanValue()));
    }

    public void c(Message message) {
        MkAppConfig mkAppConfigJ0 = com.amgcyo.cuttadon.utils.otherutils.h.j0();
        if (mkAppConfigJ0 == null || t0.a(mkAppConfigJ0.getSave_time(), 60)) {
            b(message);
            return;
        }
        String str = "缓存时间：" + mkAppConfigJ0.getSave_time();
        mkAppConfigJ0.setIs_cache(true);
        MkApplication appContext = MkApplication.getAppContext();
        appContext.setAppConfig(mkAppConfigJ0);
        List<BaseAd> listX0 = com.amgcyo.cuttadon.utils.otherutils.h.x0();
        if (!com.amgcyo.cuttadon.app.o.c.h() || com.amgcyo.cuttadon.utils.otherutils.g.a(listX0)) {
            b(message);
            return;
        }
        message.f21197s = 853;
        message.f21202x = mkAppConfigJ0;
        String strH = com.amgcyo.cuttadon.utils.otherutils.h.H();
        com.amgcyo.cuttadon.utils.otherutils.g.C(strH);
        SecondaryDomain secondaryDomainH = com.amgcyo.cuttadon.utils.otherutils.h.h();
        if (secondaryDomainH != null) {
            appContext.setDomainUrlBySecondDomain(secondaryDomainH);
        } else {
            appContext.setDomainUrl(strH);
        }
        com.amgcyo.cuttadon.utils.otherutils.g.a(mkAppConfigJ0);
        String str2 = "读取" + mkAppConfigJ0.getSave_time() + "保存的缓存配置信息成功，CDN域名是:" + strH;
        message.b();
    }

    public void d(Message message) {
        MkApplication appContext = MkApplication.getAppContext();
        Object[] objArr = message.f21203y;
        int iIntValue = (objArr == null || objArr.length <= 0) ? 851 : ((Integer) objArr[0]).intValue();
        String str = "what:" + iIntValue + " finalWhat: " + iIntValue;
        Observable<MkAppVersion> observableObserveOn = ((ConfigRepository) this.f21196t).getArtAppVersion(com.amgcyo.cuttadon.utils.otherutils.h.h0(), com.amgcyo.cuttadon.utils.otherutils.g.T() + ".html").subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new d(this, this.f3298u, "conf", "获取APP版本渠道更新接口\n", appContext, message, iIntValue));
    }

    public void e(Message message) {
        Observable<List<MkConfigSource>> observableObserveOn = ((ConfigRepository) this.f21196t).getArtConfigSource().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new c(this, this.f3298u, "conf", "获取所有书源正则表达式接口\n"));
    }

    public void f(Message message) {
        Observable<BaseModel> observableObserveOn = ((ConfigRepository) this.f21196t).getArtErrorPackage().subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new a(this, this.f3298u, "conf", "getArtErrorPackage"));
    }

    public void g(Message message) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            message.b();
            return;
        }
        Observable<List<CommentReprotType>> observableObserveOn = ((ConfigRepository) this.f21196t).getCommentReprotTypeV1().subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new i(this, this.f3298u, "my", "获取评论举报列表v1"));
    }

    public void h(Message message) {
        Observable<List<SearchHotkeyBean>> observableObserveOn = ((ConfigRepository) this.f21196t).getHotKeywordBean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new b(this, this.f3298u, "s", "获取热词接口"));
    }

    public void i(Message message) {
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        Observable<NewApiAdList> observableObserveOn = ((ConfigRepository) this.f21196t).getNewApiAdListData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new v(message)).subscribe(new j(this, this.f3298u, "my", "获取广告类型接口接口", zBooleanValue, message));
    }

    public void j(final Message message) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            message.b();
            return;
        }
        MkDataBean data = mkUserJ.getData();
        String ad_token = data != null ? data.getAd_token() : "";
        if (TextUtils.isEmpty(ad_token)) {
            ad_token = mkUserJ.getToken();
        }
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        int iIntValue = ((Integer) message.f21203y[1]).intValue();
        final me.jessyan.art.mvp.e eVarA = message.a();
        ((ConfigRepository) this.f21196t).userIndexObservable(ad_token).subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.m
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                ConfigPresenter.a(eVarA, message);
            }
        }).subscribe(new h(this, zBooleanValue ? eVarA : null, this.f3298u, "my", "个人中心接口\n", message, iIntValue, eVarA));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3298u = null;
    }

    public void a(Message message) {
        ((ConfigRepository) this.f21196t).getArtAppConfig(com.amgcyo.cuttadon.utils.otherutils.h.h0(), d()).subscribeOn(Schedulers.io()).doOnSubscribe(new o(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this.f3298u, "conf", "获取配置信息接口\n", message));
    }

    static /* synthetic */ void a(me.jessyan.art.mvp.e eVar, Message message) throws Exception {
        if (eVar != null) {
            eVar.hideLoading();
        }
        message.b();
    }

    private String d() {
        return com.amgcyo.cuttadon.utils.otherutils.g.T() + ".html";
    }

    class h extends com.amgcyo.cuttadon.f.p<UserIndex> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3310x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3311y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3312z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ConfigPresenter configPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3310x = message;
            this.f3311y = i2;
            this.f3312z = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(UserIndex userIndex) {
            if (userIndex == null || TextUtils.isEmpty(userIndex.getUser_login())) {
                this.f3310x.f21202x = null;
            } else {
                this.f3310x.f21202x = userIndex;
                g0 g0VarA = g0.a();
                com.amgcyo.cuttadon.h.a.c.c("minefragment_time");
                g0VarA.b("service_appeal_number", userIndex.getService_appeal_number() > 0);
                g0VarA.b("comment_number", userIndex.getComment_number() > 0);
                if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
                    g0VarA.b("gold", userIndex.getGold());
                    g0VarA.b("money", userIndex.getMoney());
                }
                final String strB = com.amgcyo.cuttadon.utils.otherutils.g.b(userIndex.getUser_avatar());
                if (!TextUtils.isEmpty(strB)) {
                    new Thread(new Runnable() { // from class: com.amgcyo.cuttadon.api.presenter.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConfigPresenter.h.a(strB);
                        }
                    }).start();
                }
                MkAdBean ad = userIndex.getAd();
                if (ad != null) {
                    ad.setSuccess(true);
                    com.amgcyo.cuttadon.utils.otherutils.g.a(ad);
                    String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(ad);
                    String str = "ad json:" + strA;
                    com.amgcyo.cuttadon.utils.otherutils.h.k(strA);
                    me.jessyan.art.d.f.a().a(ad, "mkadbean");
                }
            }
            this.f3310x.f21197s = this.f3311y;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            if (com.amgcyo.cuttadon.utils.otherutils.h.I0() || com.amgcyo.cuttadon.utils.otherutils.h.N0() || com.amgcyo.cuttadon.utils.otherutils.h.J0()) {
                this.f3312z.showToasyErrorMessage("用户数据获取失败，请在我的页面下拉刷新重新获取！");
            }
            com.amgcyo.cuttadon.utils.otherutils.h.k("");
            Message message = this.f3310x;
            int i2 = this.f3311y;
            message.f21197s = i2;
            message.f21202x = null;
            if (861 == i2) {
                me.jessyan.art.d.f.a().a(new MkAdBean(false), "mkadbean");
            }
        }

        static /* synthetic */ void a(String str) {
            Bitmap bitmapA = com.amgcyo.cuttadon.utils.otherutils.w.a(str);
            if (bitmapA != null) {
                m0.a("user_avatar.jpg", bitmapA);
            }
        }
    }
}
