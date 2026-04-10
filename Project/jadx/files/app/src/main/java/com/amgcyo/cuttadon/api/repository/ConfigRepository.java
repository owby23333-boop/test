package com.amgcyo.cuttadon.api.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyV4;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.config.DomainBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.api.entity.other.UserIndex;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.taobao.accs.common.Constants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.entity.BaseModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class ConfigRepository implements me.jessyan.art.mvp.b {
    private MkCommentEvent commentEvent;
    private int index = 0;
    private me.jessyan.art.mvp.d mManager;

    class a implements Callback {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f3432s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ObservableEmitter f3433t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ String f3434u;

        a(int i2, ObservableEmitter observableEmitter, String str) {
            this.f3432s = i2;
            this.f3433t = observableEmitter;
            this.f3434u = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            ConfigRepository.this.checkNextDomain(this.f3432s, this.f3433t, iOException.getMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            int iCode = response.code();
            String str = "Response: " + iCode;
            if (com.amgcyo.cuttadon.utils.otherutils.g.i(iCode)) {
                ConfigRepository.this.index = 0;
                String str2 = " 找到可用域名：" + this.f3434u;
                ConfigRepository.this.successFindDomain(this.f3433t, this.f3434u, false);
                return;
            }
            ConfigRepository.this.checkNextDomain(this.f3432s, this.f3433t, "请求成功，但是响应码" + iCode + "不在大于0小于400之间");
        }
    }

    public ConfigRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ BaseModel b(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ List c(BaseModel baseModel) throws Exception {
        List list = (List) baseModel.getData();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
            com.amgcyo.cuttadon.utils.otherutils.h.j(com.amgcyo.cuttadon.utils.otherutils.r.a(list));
        }
        return com.amgcyo.cuttadon.utils.otherutils.h.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void check(ObservableEmitter<DomainBean> observableEmitter) {
        String[] strArrZ = com.amgcyo.cuttadon.utils.otherutils.g.Z();
        int length = strArrZ.length;
        if (this.index >= length) {
            this.index = length - 1;
        }
        String str = strArrZ[this.index];
        String strC = com.amgcyo.cuttadon.utils.otherutils.g.c(str);
        String str2 = "开始检查域名:" + str + " 请求路径：" + strC;
        getCheckDomainCall(strC).enqueue(new a(length, observableEmitter, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNextDomain(int i2, ObservableEmitter<DomainBean> observableEmitter, String str) {
        this.index++;
        String str2 = "当前index: " + (this.index - 1) + " onFailure " + str;
        if (this.commentEvent == null) {
            this.commentEvent = new MkCommentEvent();
        }
        this.commentEvent.b(this.index);
        me.jessyan.art.d.f.a().a(this.commentEvent, "getAvailableDomainName");
        int i3 = i2 - 1;
        if (this.index > i3) {
            this.index = 0;
            successFindDomain(observableEmitter, com.amgcyo.cuttadon.utils.otherutils.g.F(), true);
            return;
        }
        String str3 = "循环下一个，index为：" + this.index;
        if (this.index >= i2) {
            this.index = i3;
        }
        check(observableEmitter);
    }

    static /* synthetic */ List d(BaseModel baseModel) throws Exception {
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        ArrayList arrayList = new ArrayList();
        SearchHotkeyV4 searchHotkeyV4 = (SearchHotkeyV4) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, SearchHotkeyV4.class);
        if (searchHotkeyV4 != null) {
            List<String> book = searchHotkeyV4.getBook();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(book)) {
                Iterator<String> it = book.iterator();
                while (it.hasNext()) {
                    arrayList.add(new SearchHotkeyBean(1, it.next()));
                }
            }
            List<String> comics = searchHotkeyV4.getComics();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(comics) && !com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
                Iterator<String> it2 = comics.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new SearchHotkeyBean(3, it2.next()));
                }
            }
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
            SearchHotkeyBean searchHotkeyBean = new SearchHotkeyBean(1, "首席继承人");
            SearchHotkeyBean searchHotkeyBean2 = new SearchHotkeyBean(1, "都市极品医神");
            SearchHotkeyBean searchHotkeyBean3 = new SearchHotkeyBean(1, "无敌");
            SearchHotkeyBean searchHotkeyBean4 = new SearchHotkeyBean(1, "斗破");
            SearchHotkeyBean searchHotkeyBean5 = new SearchHotkeyBean(1, "最强高手在花都");
            SearchHotkeyBean searchHotkeyBean6 = new SearchHotkeyBean(1, "假面骑士");
            SearchHotkeyBean searchHotkeyBean7 = new SearchHotkeyBean(1, "叶凡秋沐橙");
            SearchHotkeyBean searchHotkeyBean8 = new SearchHotkeyBean(1, "全职法师");
            arrayList.add(searchHotkeyBean);
            arrayList.add(searchHotkeyBean2);
            arrayList.add(searchHotkeyBean3);
            arrayList.add(searchHotkeyBean4);
            arrayList.add(searchHotkeyBean5);
            arrayList.add(searchHotkeyBean6);
            arrayList.add(searchHotkeyBean7);
            arrayList.add(searchHotkeyBean8);
        } else {
            com.amgcyo.cuttadon.utils.comic.d.a("HotKey", (Object) com.amgcyo.cuttadon.utils.otherutils.t0.a());
        }
        com.amgcyo.cuttadon.utils.comic.d.a("hot_keyword", (Object) com.amgcyo.cuttadon.utils.otherutils.r.a(arrayList));
        return arrayList;
    }

    static /* synthetic */ NewApiAdList e(BaseModel baseModel) throws Exception {
        NewApiAdList newApiAdList = (NewApiAdList) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), NewApiAdList.class);
        MkApplication.getAppContext().setNewApiAdList(newApiAdList);
        return newApiAdList;
    }

    static /* synthetic */ UserIndex f(BaseModel baseModel) throws Exception {
        UserIndex userIndex = (UserIndex) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), UserIndex.class);
        if (userIndex == null) {
            return new UserIndex("");
        }
        com.amgcyo.cuttadon.database.l lVarD = AppDatabase.i().d();
        MkUser mkUserA = lVarD.a();
        if (mkUserA != null) {
            String user_avatar = userIndex.getUser_avatar();
            String user_nickname = userIndex.getUser_nickname();
            String user_login = userIndex.getUser_login();
            String user_phone = userIndex.getUser_phone();
            String invitation_code = userIndex.getInvitation_code();
            int invitation_count = userIndex.getInvitation_count();
            String str = "invitation_count:" + invitation_count;
            int master_user_id = userIndex.getMaster_user_id();
            MkAdBean ad = userIndex.getAd();
            int ad_state = ad != null ? ad.getAd_state() : 0;
            mkUserA.setAvatar(user_avatar);
            mkUserA.setNick(user_nickname);
            mkUserA.setUser(user_login);
            mkUserA.setPhone(user_phone);
            mkUserA.setInvitation_count(invitation_count);
            mkUserA.setInvitation_code(invitation_code);
            mkUserA.setMaster_user_id(master_user_id);
            mkUserA.setAd_style(ad_state);
            String str2 = "update：" + lVarD.update(mkUserA);
        }
        return userIndex;
    }

    private Call getCheckDomainCall(String str) {
        String strA;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strA0 = com.amgcyo.cuttadon.utils.otherutils.g.a0();
        String strC0 = com.amgcyo.cuttadon.utils.otherutils.g.c0();
        String strQ = com.amgcyo.cuttadon.utils.otherutils.g.q();
        if (TextUtils.isEmpty(strQ)) {
            strA = "";
        } else {
            strA = com.open.hule.library.c.b.a(strQ + jCurrentTimeMillis);
        }
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (!TextUtils.isEmpty(strA0)) {
            builderUrl.addHeader(BmobDbOpenHelper.USER, strA0);
        }
        if (!TextUtils.isEmpty(strC0)) {
            builderUrl.addHeader("token", strC0);
        }
        String strT = com.amgcyo.cuttadon.utils.otherutils.h.t();
        builderUrl.addHeader("User-Agent", com.amgcyo.cuttadon.utils.otherutils.v0.a()).addHeader("pt", "1").addHeader("version", "5.0.2").addHeader("channel", com.amgcyo.cuttadon.utils.otherutils.g.T()).addHeader(Constants.KEY_PACKAGE, strT).addHeader("stamp", strA).addHeader("time", String.valueOf(jCurrentTimeMillis)).addHeader("sign", me.jessyan.retrofiturlmanager.a.a(jCurrentTimeMillis, strC0, strT));
        return com.amgcyo.cuttadon.utils.otherutils.g.Y().newCall(builderUrl.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void successFindDomain(ObservableEmitter<DomainBean> observableEmitter, String str, boolean z2) {
        observableEmitter.onNext(new DomainBean(str, z2));
        observableEmitter.onComplete();
    }

    public /* synthetic */ void a(ObservableEmitter observableEmitter) throws Exception {
        String[] strArr = {"chuangke.tv"};
        String str = "默认的域名---save_domain: " + strArr[0];
        strArr[0] = com.amgcyo.cuttadon.utils.otherutils.g.F();
        String str2 = "下发的cdn域名----save_domain: " + strArr[0];
        getCheckDomainCall(com.amgcyo.cuttadon.utils.otherutils.g.c(strArr[0])).enqueue(new x3(this, observableEmitter, strArr));
    }

    public Observable<MkAppConfig> getArtAppConfig(String str, String str2) {
        final com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        String strValueOf = g0VarA.a("config_use_timestamp", false) ? String.valueOf(System.currentTimeMillis()) : com.amgcyo.cuttadon.utils.otherutils.t0.c();
        String str3 = "t:" + strValueOf;
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).a(str, str2, strValueOf).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.n1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.a(g0VarA, (BaseModel) obj);
            }
        });
    }

    public Observable<MkAppVersion> getArtAppVersion(String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).a(str, str2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.t1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.a((BaseModel) obj);
            }
        });
    }

    public Observable<List<MkConfigSource>> getArtConfigSource() {
        final com.amgcyo.cuttadon.database.j jVarC = AppDatabase.i().c();
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).c().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.q1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.a(jVarC, (BaseModel) obj);
            }
        });
    }

    public Observable<BaseModel> getArtErrorPackage() {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).a().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.o1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                ConfigRepository.b(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<DomainBean> getAvailableDomainName() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.api.repository.m1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(observableEmitter);
            }
        });
    }

    public Observable<List<CommentReprotType>> getCommentReprotTypeV1() {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).d().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.p1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.c((BaseModel) obj);
            }
        });
    }

    public Observable<List<SearchHotkeyBean>> getHotKeywordBean() {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).a(com.amgcyo.cuttadon.utils.otherutils.h.F(), com.amgcyo.cuttadon.utils.otherutils.h.h0()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.r1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.d((BaseModel) obj);
            }
        });
    }

    public Observable<NewApiAdList> getNewApiAdListData() {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).b().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.u1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.e((BaseModel) obj);
            }
        });
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
    }

    public Observable<UserIndex> userIndexObservable(String str) {
        return ((com.amgcyo.cuttadon.c.a.d) this.mManager.a(com.amgcyo.cuttadon.c.a.d.class)).b(com.amgcyo.cuttadon.utils.otherutils.h.c(), str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.s1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ConfigRepository.f((BaseModel) obj);
            }
        });
    }

    static /* synthetic */ List a(com.amgcyo.cuttadon.database.j jVar, BaseModel baseModel) throws Exception {
        List<MkConfigSource> listB = com.amgcyo.cuttadon.utils.comic.b.b((Base64Bean) baseModel.getData(), MkConfigSource.class);
        try {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
                long jInsert = 0;
                for (MkConfigSource mkConfigSource : listB) {
                    MkConfigSource mkConfigSourceA = jVar.a(mkConfigSource.getSite_id());
                    if (mkConfigSourceA == null) {
                        jInsert = jVar.insert(mkConfigSource);
                    } else {
                        jInsert = mkConfigSourceA.getRegular_time() != mkConfigSource.getRegular_time() ? jVar.a(mkConfigSource.getRegular_time(), com.amgcyo.cuttadon.utils.otherutils.r.a(mkConfigSource.getRegular()), mkConfigSource.getSite_id()) : 1L;
                    }
                }
                if (jInsert > 0) {
                    com.amgcyo.cuttadon.utils.comic.d.a("regex_new", (Object) com.amgcyo.cuttadon.utils.otherutils.t0.a());
                }
                return listB;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return com.amgcyo.cuttadon.utils.otherutils.o0.b().a();
    }

    static /* synthetic */ MkAppVersion a(BaseModel baseModel) throws Exception {
        MkAppVersion mkAppVersion = (MkAppVersion) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkAppVersion.class);
        return mkAppVersion != null ? mkAppVersion : new MkAppVersion();
    }

    static /* synthetic */ MkAppConfig a(com.amgcyo.cuttadon.utils.otherutils.g0 g0Var, BaseModel baseModel) throws Exception {
        MkAppConfig mkAppConfig = (MkAppConfig) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkAppConfig.class);
        if (mkAppConfig != null) {
            try {
                com.amgcyo.cuttadon.sdk.utils.g.a();
                com.amgcyo.cuttadon.sdk.utils.d.a();
                String strD = com.amgcyo.cuttadon.utils.otherutils.t0.d(System.currentTimeMillis());
                String str = "配置请求成功，时间是：" + strD;
                mkAppConfig.setSave_time(strD);
                mkAppConfig.setIs_success(true);
                String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(mkAppConfig);
                com.amgcyo.cuttadon.j.c.b.a(strA);
                MkApplication.getAppContext().setAppConfig(mkAppConfig);
                com.amgcyo.cuttadon.utils.otherutils.h.i(strA);
                g0Var.b("config_use_timestamp", false);
                return mkAppConfig;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return new MkAppConfig();
    }
}
