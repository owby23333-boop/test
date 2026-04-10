package com.amgcyo.cuttadon.api.repository;

import android.os.Build;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.cz.CzIndexBean;
import com.amgcyo.cuttadon.api.entity.cz.CzOrderBean;
import com.amgcyo.cuttadon.api.entity.cz.CzRecordBean;
import com.amgcyo.cuttadon.api.entity.cz.SubmitOrderBean;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5Index;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5SignIndex;
import com.amgcyo.cuttadon.api.entity.fission5.Income5Bean;
import com.amgcyo.cuttadon.api.entity.fission5.Invalitation5Bean;
import com.amgcyo.cuttadon.api.entity.fission5.OpenBoxBean;
import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import com.amgcyo.cuttadon.api.entity.fission5.TxStepBean;
import com.amgcyo.cuttadon.api.entity.fission5.WithDrawBean;
import com.amgcyo.cuttadon.api.entity.fission5.WithdrawalListBean;
import com.amgcyo.cuttadon.api.entity.fission6.Fission6Index;
import com.amgcyo.cuttadon.api.entity.other.LimitCenterListBean;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAddBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkFeedbackHisBean;
import com.amgcyo.cuttadon.api.entity.other.MkUplaodAvatar;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.anythink.expressad.foundation.d.c;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.jessyan.art.entity.BaseModel;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class UserRepository implements me.jessyan.art.mvp.b {
    private me.jessyan.art.mvp.d mManager;

    class a implements Function<BaseModel<List<MkFeedbackHisBean>>, List<MkFeedbackHisBean>> {
        a(UserRepository userRepository) {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MkFeedbackHisBean> apply(BaseModel<List<MkFeedbackHisBean>> baseModel) throws Exception {
            return baseModel.getData();
        }
    }

    class b implements Function<BaseModel<Task5ResultBean>, Task5ResultBean> {
        b(UserRepository userRepository) {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task5ResultBean apply(BaseModel<Task5ResultBean> baseModel) throws Exception {
            return baseModel.getData();
        }
    }

    class c implements Function<BaseModel<Task5ResultBean>, Task5ResultBean> {
        c(UserRepository userRepository) {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task5ResultBean apply(BaseModel<Task5ResultBean> baseModel) throws Exception {
            return baseModel.getData();
        }
    }

    class d implements Function<BaseModel<WithDrawBean>, WithDrawBean> {
        d(UserRepository userRepository) {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WithDrawBean apply(BaseModel<WithDrawBean> baseModel) throws Exception {
            return baseModel.getData();
        }
    }

    class e implements Function<BaseModel<Task5ResultBean>, Task5ResultBean> {
        e(UserRepository userRepository) {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task5ResultBean apply(BaseModel<Task5ResultBean> baseModel) throws Exception {
            return baseModel.getData();
        }
    }

    public UserRepository(me.jessyan.art.mvp.d dVar) {
        this.mManager = dVar;
    }

    static /* synthetic */ BaseModel A(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel B(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel a(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel b(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel c(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel d(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel e(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ List f(BaseModel baseModel) throws Exception {
        List list = (List) baseModel.getData();
        if (list != null) {
            try {
                String strB = com.amgcyo.cuttadon.app.o.a.b(com.amgcyo.cuttadon.app.o.c.c(), com.amgcyo.cuttadon.utils.otherutils.r.a(list));
                File fileI = com.amgcyo.cuttadon.utils.otherutils.z.i();
                if (fileI != null) {
                    com.amgcyo.cuttadon.utils.otherutils.z.b(strB, fileI.getAbsolutePath(), "area_code");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    static /* synthetic */ MkAddBookBean g(BaseModel baseModel) throws Exception {
        MkAddBookBean mkAddBookBean = (MkAddBookBean) com.amgcyo.cuttadon.utils.comic.b.a((Base64Bean) baseModel.getData(), MkAddBookBean.class);
        return mkAddBookBean != null ? mkAddBookBean : new MkAddBookBean();
    }

    static /* synthetic */ CzIndexBean h(BaseModel baseModel) throws Exception {
        CzIndexBean czIndexBean = (CzIndexBean) baseModel.getData();
        return czIndexBean != null ? czIndexBean : new CzIndexBean();
    }

    static /* synthetic */ Fission6Index i(BaseModel baseModel) throws Exception {
        Fission6Index fission6Index = (Fission6Index) baseModel.getData();
        return fission6Index != null ? fission6Index : new Fission6Index(0);
    }

    static /* synthetic */ BaseModel j(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel k(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel l(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel m(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkUser n(BaseModel baseModel) throws Exception {
        MkUser mkUser;
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        return (base64Bean == null || (mkUser = (MkUser) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, MkUser.class)) == null) ? new MkUser(0) : mkUser;
    }

    static /* synthetic */ BaseModel o(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkUser p(BaseModel baseModel) throws Exception {
        MkUser mkUser;
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        return (base64Bean == null || (mkUser = (MkUser) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, MkUser.class)) == null) ? new MkUser(0) : mkUser;
    }

    static /* synthetic */ BaseModel q(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel r(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ CzOrderBean s(BaseModel baseModel) throws Exception {
        CzOrderBean czOrderBean = (CzOrderBean) baseModel.getData();
        return czOrderBean != null ? czOrderBean : new CzOrderBean();
    }

    static /* synthetic */ MkAdBean t(BaseModel baseModel) throws Exception {
        MkAdBean mkAdBean = (MkAdBean) baseModel.getData();
        return mkAdBean != null ? mkAdBean : new MkAdBean();
    }

    static /* synthetic */ BaseModel u(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ MkUser v(BaseModel baseModel) throws Exception {
        MkUser mkUser;
        Base64Bean base64Bean = (Base64Bean) baseModel.getData();
        return (base64Bean == null || (mkUser = (MkUser) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, MkUser.class)) == null) ? new MkUser(0) : mkUser;
    }

    static /* synthetic */ BaseModel w(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel x(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel y(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    static /* synthetic */ BaseModel z(BaseModel baseModel) throws Exception {
        return baseModel;
    }

    public Observable<BaseModel> bindPhone(String str, String str2, String str3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, str3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.n2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.a(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> cancelAccount(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).d(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.d3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.b(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> delBatchBook(String str, int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.k2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.c(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> exchangeCode(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.f3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.d(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> findPwd(String str, String str2, String str3, String str4) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, str3, str4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.t2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.e(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<List<MkAreaCodeBean>> getAreaCodeBeanList() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).h().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.j3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.f((BaseModel) obj);
            }
        });
    }

    public Observable<MkAddBookBean> getArtAddBookHistory(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).d(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.l2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.g((BaseModel) obj);
            }
        });
    }

    public Observable<LimitCenterListBean> getCommentListLoadMore(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).c(i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (LimitCenterListBean) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<CzIndexBean> getCzIndexDataV6() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).g().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.u2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.h((BaseModel) obj);
            }
        });
    }

    public Observable<List<CzRecordBean>> getCzRecordListData(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b(i2, 20).subscribeOn(Schedulers.io()).map(com.amgcyo.cuttadon.api.repository.b.f3441s);
    }

    public Observable<List<MkFeedbackHisBean>> getFeedbackHistory() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b().subscribeOn(Schedulers.io()).map(new a(this));
    }

    public Observable<Fission6Index> getFission6IndexDataV6(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).c(com.amgcyo.cuttadon.utils.otherutils.h.B0(), com.open.hule.library.c.b.a(String.format(Locale.getDefault(), "%d%s%s%d%s", Integer.valueOf(i2), com.amgcyo.cuttadon.utils.otherutils.h.h0(), com.amgcyo.cuttadon.utils.otherutils.g.T(), Long.valueOf(System.currentTimeMillis() / 1000), "0*(YHNL@B:L<>@O;l"))).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.j2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.i((BaseModel) obj);
            }
        });
    }

    public Observable<BaseModel> getH5Server(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).e(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.k3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.j(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> getValidateCode(String str, int i2, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, i2, str2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.h3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.k(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> getValidateCodeForCancel(String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.b3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.l(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> getValidateCodeForReplace(String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b(str, str2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.o2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.m(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<MkUser> loginApiWithVersion(String str, String str2, String str3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(com.amgcyo.cuttadon.utils.otherutils.h.c(), str, str2, str3, 1).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.y2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.n((BaseModel) obj);
            }
        });
    }

    public Observable<BaseModel> mergeBookApi(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).g(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.m2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.o(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<MkUser> migrateV6(String str, String str2, String str3, String str4) {
        String strA = com.open.hule.library.c.b.a(String.format(Locale.getDefault(), "%s%s%s%d%s", str, str3, str4, Long.valueOf(System.currentTimeMillis() / 1000), "0*(YHNL@B:L<>@O;l"));
        String str5 = "old_package_name:" + str3 + " old_channel:" + str4 + " old_user:" + str;
        String str6 = "sign:" + strA;
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, str3, str4, strA).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.a3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.p((BaseModel) obj);
            }
        });
    }

    @Override // me.jessyan.art.mvp.b
    public void onDestroy() {
    }

    public Observable<BaseModel> postAddBook(String str, String str2, String str3, int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, str3, i2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.r2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.q(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<Task5ResultBean> postBindCodeOverTimeBean() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).d().subscribeOn(Schedulers.io()).map(q3.f3531s);
    }

    public Observable<BaseModel> postChapterFeedback(int i2, String str, String str2, int i3, int i4) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(i2, i4, str, str2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.w2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.r(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<CzOrderBean> postCzOrderData(SubmitOrderBean submitOrderBean) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(submitOrderBean.getChannel(), submitOrderBean.getType(), submitOrderBean.getProduct()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.e3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.s((BaseModel) obj);
            }
        });
    }

    public Observable<MkAdBean> postCzOrderStatus(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).c(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.s2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.t((BaseModel) obj);
            }
        });
    }

    public Observable<Income5Bean> postEarningsListLoadMore(int i2, int i3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(i2, i3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.p3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (Income5Bean) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Fuli5Index> postFuli5ListData(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.w3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (Fuli5Index) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Fuli5SignIndex> postFuli5SignIndexBean() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).f().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.s3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (Fuli5SignIndex) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<BaseModel> postH5Server(String str, Map<String, Object> map) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, map).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.q2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.u(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<Invalitation5Bean> postInvalitation5BeanData() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).i().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.r3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (Invalitation5Bean) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Task5ResultBean> postMasterCodeBean(String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).d(str, str2).subscribeOn(Schedulers.io()).map(q3.f3531s);
    }

    public Observable<OpenBoxBean> postOpenBoxData() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a().subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.o3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (OpenBoxBean) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Task5ResultBean> postTask5Receive10000Bean() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).j().subscribeOn(Schedulers.io()).map(new c(this));
    }

    public Observable<Task5ResultBean> postTask5ResultBean() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).e().subscribeOn(Schedulers.io()).map(new b(this));
    }

    public Observable<TxStepBean> postTxStepBean(int i2, int i3, String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(i2, i3, str, str2).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (TxStepBean) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<WithDrawBean> postWithdrawalBean() {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).c().subscribeOn(Schedulers.io()).map(new d(this));
    }

    public Observable<List<WithdrawalListBean>> postWithdrawalList(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b(i2).subscribeOn(Schedulers.io()).map(com.amgcyo.cuttadon.api.repository.b.f3441s);
    }

    public Observable<MkUser> registerApiWithVersion(String str, String str2, String str3, String str4, String str5, String str6) {
        String strW = com.amgcyo.cuttadon.utils.otherutils.g.w();
        String str7 = "uniqueID:" + strW;
        String strA = com.open.hule.library.c.b.a(strW);
        String str8 = " md5: " + strA;
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(com.amgcyo.cuttadon.utils.otherutils.h.c(), str, str2, com.amgcyo.cuttadon.utils.otherutils.g.h(), 502, "5.0.2", Build.BRAND, Build.MODEL, strA, com.amgcyo.cuttadon.utils.otherutils.g.T(), str3, str4, str5, str6, 1).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.v2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserRepository.v((BaseModel) obj);
            }
        });
    }

    public Observable<BaseModel> replaceAccount(String str, String str2, String str3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).c(str, str2, str3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.z2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.w(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> submitCommentReportV1(int i2, int i3, int i4) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(i2, i3, i4).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.p2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.x(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> submitFeedbackV1(String str, String str2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, "5.0.2", Build.VERSION.RELEASE, Build.MODEL, com.amgcyo.cuttadon.utils.otherutils.g.f(this.mManager.getContext())).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.i3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.y(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> submitFeedbackV2(String str, String str2, String str3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(str, str2, "5.0.2", Build.VERSION.RELEASE, Build.MODEL, com.amgcyo.cuttadon.utils.otherutils.g.f(this.mManager.getContext()), str3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.g3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.z(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> updateNick(String str) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).f(str).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.c3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.A(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<BaseModel> updatePwd(String str, String str2, String str3) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).b(str, str2, str3).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.x2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) throws Exception {
                BaseModel baseModel = (BaseModel) obj;
                UserRepository.B(baseModel);
                return baseModel;
            }
        });
    }

    public Observable<MkUplaodAvatar> uploadAvatar(File file) {
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        type.addFormDataPart(c.C0205c.f10205e, file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(type.build().parts()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.amgcyo.cuttadon.api.repository.u3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (MkUplaodAvatar) ((BaseModel) obj).getData();
            }
        });
    }

    public Observable<Task5ResultBean> postTask5ResultBean(int i2) {
        return ((com.amgcyo.cuttadon.c.a.f) this.mManager.a(com.amgcyo.cuttadon.c.a.f.class)).a(i2).subscribeOn(Schedulers.io()).map(new e(this));
    }
}
