package com.amgcyo.cuttadon.api.presenter;

import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.activity.fission5.Fission5RegSuccessActivity;
import com.amgcyo.cuttadon.api.entity.config.JsJsonObject;
import com.amgcyo.cuttadon.api.entity.cz.CzChannelBean;
import com.amgcyo.cuttadon.api.entity.cz.CzHelperBean;
import com.amgcyo.cuttadon.api.entity.cz.CzIndexBean;
import com.amgcyo.cuttadon.api.entity.cz.CzOrderBean;
import com.amgcyo.cuttadon.api.entity.cz.CzPayDataBean;
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
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkDataBean;
import com.amgcyo.cuttadon.api.entity.other.MkFeedbackHisBean;
import com.amgcyo.cuttadon.api.entity.other.MkUplaodAvatar;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.repository.UserRepository;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.google.gson.reflect.TypeToken;
import com.sntech.ads.api.event.SNEvent;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import me.jessyan.art.base.convert.ApiException;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.BasePresenter;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class UserPresenter extends BasePresenter<UserRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3322u;

    class a extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3323x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ JsJsonObject f3324y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3325z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, JsJsonObject jsJsonObject, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3323x = message;
            this.f3324y = jsJsonObject;
            this.f3325z = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            if (baseModel == null) {
                return;
            }
            this.f3323x.f21197s = 865;
            this.f3324y.setResponeJson(com.amgcyo.cuttadon.utils.otherutils.r.a(baseModel));
            this.f3323x.f21202x = this.f3324y;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            me.jessyan.art.mvp.e eVar = this.f3325z;
            if (eVar == null) {
                return;
            }
            eVar.hideLoading();
        }
    }

    class a0 extends com.amgcyo.cuttadon.f.p<Task5ResultBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3326x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3326x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Task5ResultBean task5ResultBean) {
            Message message = this.f3326x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = task5ResultBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3326x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = null;
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3327x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3328y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3327x = eVar2;
            this.f3328y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3327x.showMessage(baseModel.getMsg());
            this.f3328y.f21197s = 856;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class b0 extends com.amgcyo.cuttadon.f.p<Task5ResultBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3329x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3329x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Task5ResultBean task5ResultBean) {
            Message message = this.f3329x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.f21202x = task5ResultBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3329x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.f21202x = null;
        }
    }

    class c extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3330x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3331y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3330x = eVar2;
            this.f3331y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3330x.showMessage(baseModel.getMsg());
            this.f3331y.f21197s = 1901;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3331y.f21197s = 1902;
        }
    }

    class c0 extends com.amgcyo.cuttadon.f.p<Fuli5SignIndex> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3332x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3332x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Fuli5SignIndex fuli5SignIndex) {
            Message message = this.f3332x;
            message.f21197s = com.anythink.expressad.video.dynview.a.a.f11586s;
            message.f21202x = fuli5SignIndex;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3332x;
            message.f21197s = com.anythink.expressad.video.dynview.a.a.f11586s;
            message.f21202x = null;
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3333x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3334y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3333x = eVar2;
            this.f3334y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3333x.showMessage(baseModel.getMsg());
            this.f3334y.f21197s = 2119;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3334y.f21197s = 1902;
        }
    }

    class d0 extends com.amgcyo.cuttadon.f.p<WithDrawBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3335x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3335x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(WithDrawBean withDrawBean) {
            Message message = this.f3335x;
            message.f21197s = 903;
            message.f21202x = withDrawBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3335x;
            message.f21197s = 903;
            message.f21202x = null;
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3336x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3336x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3336x;
            message.f21197s = 825;
            message.f21202x = baseModel.getMsg();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3336x;
            message.f21197s = 826;
            message.f21202x = th.getMessage();
        }
    }

    class e0 extends com.amgcyo.cuttadon.f.p<TxStepBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3337x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3337x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(TxStepBean txStepBean) {
            Message message = this.f3337x;
            message.f21197s = 905;
            message.f21202x = txStepBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3337x;
            message.f21197s = 905;
            message.f21202x = null;
        }
    }

    class f extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3338x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3338x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3338x;
            message.f21197s = 2120;
            message.f21202x = baseModel;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3338x.f21197s = 2121;
        }
    }

    class f0 extends com.amgcyo.cuttadon.f.p<MkUser> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3339x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3340y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3339x = eVar2;
            this.f3340y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(final MkUser mkUser) {
            if (mkUser == null || mkUser.getUser_id() <= 0) {
                this.f3339x.showMessage("用户信息非法，请重试！");
                this.f3340y.f21197s = 102;
                return;
            }
            if (AppDatabase.i().d().insert(mkUser) <= 0) {
                this.f3339x.showMessage("用户信息写入失败，请重试！");
                this.f3340y.f21197s = 102;
                return;
            }
            this.f3339x.showMessage("自动登录成功！");
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tel", mkUser.getTel());
            UserPresenter.this.a(mkUser);
            Message message = this.f3340y;
            message.f21202x = mkUser;
            message.f21197s = 103;
            com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
            List<MkBook> listC = fVarA.c();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listC)) {
                com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.az, com.amgcyo.cuttadon.i.n.a(listC));
            }
            String str = "deleteAllBooks: " + fVarA.a();
            mkUser.setLogin(true);
            MkDataBean data = mkUser.getData();
            if (data != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.k(data.getAttributes());
            }
            new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.api.presenter.s
                @Override // java.lang.Runnable
                public final void run() {
                    com.amgcyo.cuttadon.i.n.a(mkUser);
                }
            }, 22000L);
            me.jessyan.art.d.f.a().a(mkUser, "finish_activity");
            x0.c().a(mkUser, 1);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.UserEvent.LOGIN);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3340y;
            message.f21197s = 102;
            message.f21202x = th;
        }
    }

    class g extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3342x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3342x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3342x;
            message.f21202x = baseModel;
            message.f21197s = 1101;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3342x.f21197s = 1102;
        }
    }

    class g0 extends com.amgcyo.cuttadon.f.p<Task5ResultBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3343x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3343x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Task5ResultBean task5ResultBean) {
            Message message = this.f3343x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = task5ResultBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3343x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = null;
        }
    }

    class h extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3344x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3345y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3344x = eVar2;
            this.f3345y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3344x.showMessage(baseModel.getMsg());
            this.f3345y.f21197s = 858;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            th.printStackTrace();
            String message = th.getMessage();
            if (this.f3344x == null || message == null || TextUtils.isEmpty(message)) {
                return;
            }
            this.f3344x.showMessage(message);
        }
    }

    class h0 extends com.amgcyo.cuttadon.f.p<Task5ResultBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3346x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3346x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Task5ResultBean task5ResultBean) {
            Message message = this.f3346x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = task5ResultBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3346x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = null;
        }
    }

    class i extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3347x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3348y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3347x = eVar2;
            this.f3348y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3347x.showMessage(baseModel.getMsg());
            Message message = this.f3348y;
            message.f21197s = 825;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class i0 extends com.amgcyo.cuttadon.f.p<Fission6Index> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkUser f3349x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3350y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, MkUser mkUser, Message message) {
            super(cVar, str, str2);
            this.f3349x = mkUser;
            this.f3350y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Fission6Index fission6Index) {
            if (fission6Index.getUser_id() > 0) {
                fission6Index.setAvatar(com.amgcyo.cuttadon.utils.otherutils.g.b(this.f3349x.getAvatar()));
                this.f3350y.f21202x = fission6Index;
            } else {
                this.f3350y.f21202x = null;
            }
            this.f3350y.f21197s = 1637;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3350y;
            message.f21197s = 1637;
            message.f21202x = null;
        }
    }

    class j extends com.amgcyo.cuttadon.f.p<MkUser> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3351x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3352y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ int f3353z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message, int i2) {
            super(eVar, cVar, str, str2);
            this.f3351x = eVar2;
            this.f3352y = message;
            this.f3353z = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkUser mkUser) {
            if (mkUser == null || mkUser.getUser_id() <= 0) {
                this.f3351x.showMessage("注册失败");
                this.f3352y.f21197s = 824;
                UserPresenter.this.d();
                return;
            }
            if (AppDatabase.i().d().insert(mkUser) <= 0) {
                this.f3351x.showMessage("注册失败");
                this.f3352y.f21197s = 824;
                UserPresenter.this.d();
                return;
            }
            this.f3351x.showMessage("注册成功~");
            UserPresenter.this.a(mkUser);
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tel", mkUser.getTel());
            Message message = this.f3352y;
            message.f21202x = mkUser;
            message.f21197s = 823;
            mkUser.setLogin(false);
            MkDataBean data = mkUser.getData();
            if (data != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.k(data.getAttributes());
            }
            com.amgcyo.cuttadon.i.n.a(mkUser);
            me.jessyan.art.d.f.a().a(mkUser, "finish_activity");
            if (this.f3353z == -100) {
                com.amgcyo.cuttadon.utils.otherutils.h.u(-100);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.h.u(1);
            }
            if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
                r0.startActivity(this.f3352y.a().getHostContext(), Fission5RegSuccessActivity.class);
            }
            x0.c().a(mkUser, 0);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.UserEvent.REGISTER);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3352y.f21197s = 824;
            UserPresenter.this.d();
        }
    }

    class j0 extends com.amgcyo.cuttadon.f.p<CzIndexBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3354x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3355y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3354x = eVar2;
            this.f3355y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(CzIndexBean czIndexBean) {
            List<CzChannelBean> channel = czIndexBean.getChannel();
            List<CzPayDataBean> pay_data = czIndexBean.getPay_data();
            List<CzHelperBean> help = czIndexBean.getHelp();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(help)) {
                String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(help);
                if (!TextUtils.isEmpty(strA)) {
                    com.amgcyo.cuttadon.utils.otherutils.g0.a().b("cz_help", strA);
                }
            }
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(channel) || com.amgcyo.cuttadon.utils.otherutils.g.a(pay_data)) {
                Message message = this.f3355y;
                message.f21202x = null;
                message.f21197s = 921;
            } else {
                this.f3354x.showLoadSuccess();
                Message message2 = this.f3355y;
                message2.f21202x = czIndexBean;
                message2.f21197s = 920;
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3355y;
            message.f21197s = 921;
            message.f21202x = null;
        }
    }

    class k extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3356x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3357y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3356x = eVar2;
            this.f3357y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3356x.showMessage(baseModel.getMsg());
            this.f3357y.f21197s = 825;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class k0 extends com.amgcyo.cuttadon.f.p<List<CzRecordBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3358x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3358x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<CzRecordBean> list) {
            Message message = this.f3358x;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3358x;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class l extends com.amgcyo.cuttadon.f.p<MkUplaodAvatar> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3359x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ MkUser f3360y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3361z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, MkUser mkUser, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3359x = message;
            this.f3360y = mkUser;
            this.f3361z = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkUplaodAvatar mkUplaodAvatar) {
            if (mkUplaodAvatar == null || TextUtils.isEmpty(mkUplaodAvatar.getAvatar())) {
                this.f3361z.showMessage("上传失败!");
                return;
            }
            Message message = this.f3359x;
            message.f21197s = 834;
            message.f21202x = mkUplaodAvatar.getAvatar();
            String str = "updateArUserAvatarById: " + AppDatabase.i().d().a(mkUplaodAvatar.getAvatar(), this.f3360y.getUser_id());
            this.f3361z.showMessage("上传成功!");
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3359x;
            message.f21197s = 834;
            message.f21202x = null;
        }
    }

    class l0 extends com.amgcyo.cuttadon.f.p<CzOrderBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3362x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3363y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3362x = message;
            this.f3363y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(CzOrderBean czOrderBean) {
            if (czOrderBean == null || TextUtils.isEmpty(czOrderBean.getPay_url())) {
                Message message = this.f3362x;
                message.f21197s = 826;
                message.f21202x = null;
                return;
            }
            Message message2 = this.f3362x;
            message2.f21197s = 189;
            message2.f21202x = czOrderBean;
            String str = "orderBean：" + czOrderBean.toString();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            me.jessyan.art.mvp.e eVar;
            if ((th instanceof ApiException) && (eVar = this.f3363y) != null) {
                eVar.showToasyErrorMessage(((ApiException) th).g());
            }
            Message message = this.f3362x;
            message.f21197s = 826;
            message.f21202x = null;
        }
    }

    class m extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3364x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3365y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3364x = eVar;
            this.f3365y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            me.jessyan.art.mvp.e eVar;
            if (baseModel == null || (eVar = this.f3364x) == null) {
                return;
            }
            eVar.showMessage(baseModel.getMsg());
            Message message = this.f3365y;
            message.f21197s = 825;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3365y;
            message.f21197s = 826;
            message.b();
        }
    }

    class m0 extends com.amgcyo.cuttadon.f.p<MkAdBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3366x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3367y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3366x = message;
            this.f3367y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAdBean mkAdBean) {
            if (mkAdBean == null || TextUtils.isEmpty(mkAdBean.getAd_end_datetime())) {
                Message message = this.f3366x;
                message.f21197s = 826;
                message.f21202x = null;
                return;
            }
            mkAdBean.setSuccess(true);
            Message message2 = this.f3366x;
            message2.f21197s = 191;
            message2.f21202x = mkAdBean;
            String str = "mkAdBean：" + mkAdBean.toString();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            me.jessyan.art.mvp.e eVar;
            if ((th instanceof ApiException) && (eVar = this.f3367y) != null) {
                eVar.showToasyErrorMessage(((ApiException) th).g());
            }
            Message message = this.f3366x;
            message.f21197s = 826;
            message.f21202x = null;
        }
    }

    class n extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3368x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3369y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3368x = eVar2;
            this.f3369y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            me.jessyan.art.mvp.e eVar;
            if (baseModel == null || (eVar = this.f3368x) == null) {
                return;
            }
            eVar.showMessage(baseModel.getMsg());
            this.f3369y.f21197s = 811;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3369y.f21197s = 812;
        }
    }

    class n0 extends com.amgcyo.cuttadon.f.p<BaseModel> {
        final /* synthetic */ Message A;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ MkUser f3370x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ String f3371y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3372z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, MkUser mkUser, String str3, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3370x = mkUser;
            this.f3371y = str3;
            this.f3372z = eVar2;
            this.A = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            this.f3370x.setNick(this.f3371y);
            if (AppDatabase.i().d().update(this.f3370x) > 0) {
                this.f3372z.showMessage(baseModel.getMsg());
                this.A.f21197s = 823;
                me.jessyan.art.d.f.a().a(this.f3370x, "finish_activity");
            } else {
                this.f3372z.showMessage("修改失败!");
                this.A.f21197s = 824;
            }
            this.A.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class o extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3373x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3373x = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            me.jessyan.art.mvp.e eVar;
            if (baseModel == null || (eVar = this.f3373x) == null) {
                return;
            }
            eVar.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class o0 extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3374x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3375y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o0(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3374x = message;
            this.f3375y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3374x;
            message.f21197s = 892;
            message.b();
            this.f3375y.showMessage("反馈成功!");
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class p extends com.amgcyo.cuttadon.f.p<List<MkFeedbackHisBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3376x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3377y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(UserPresenter userPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3376x = eVar2;
            this.f3377y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkFeedbackHisBean> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.f3376x.showEmpty();
                return;
            }
            Message message = this.f3377y;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class p0 extends TypeToken<Map<String, Object>> {
        p0(UserPresenter userPresenter) {
        }
    }

    class q extends com.amgcyo.cuttadon.f.p<List<MkAreaCodeBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3378x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3379y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3378x = eVar;
            this.f3379y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkAreaCodeBean> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.f3378x.showEmpty();
                return;
            }
            Message message = this.f3379y;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            List listB = null;
            try {
                File fileI = com.amgcyo.cuttadon.utils.otherutils.z.i();
                if (fileI != null) {
                    File file = new File(fileI.getAbsolutePath(), "area_code");
                    if (file.exists()) {
                        String strM = com.amgcyo.cuttadon.utils.otherutils.z.m(file.getAbsolutePath());
                        if (!TextUtils.isEmpty(strM)) {
                            String strA = com.amgcyo.cuttadon.app.o.a.a(com.amgcyo.cuttadon.app.o.c.c(), strM);
                            if (!TextUtils.isEmpty(strA)) {
                                listB = com.amgcyo.cuttadon.utils.otherutils.r.b(strA, MkAreaCodeBean.class);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Message message = this.f3379y;
            message.f21197s = 825;
            message.f21202x = listB;
        }
    }

    class q0 extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3380x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ JsJsonObject f3381y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3382z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q0(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, JsJsonObject jsJsonObject, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3380x = message;
            this.f3381y = jsJsonObject;
            this.f3382z = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            if (baseModel == null) {
                return;
            }
            this.f3380x.f21197s = 866;
            this.f3381y.setResponeJson(com.amgcyo.cuttadon.utils.otherutils.r.a(baseModel));
            this.f3380x.f21202x = this.f3381y;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            me.jessyan.art.mvp.e eVar = this.f3382z;
            if (eVar == null) {
                return;
            }
            eVar.hideLoading();
        }
    }

    class r extends com.amgcyo.cuttadon.f.p<MkAddBookBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3383x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3383x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAddBookBean mkAddBookBean) {
            Message message = this.f3383x;
            message.f21197s = 825;
            message.f21202x = mkAddBookBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class s extends com.amgcyo.cuttadon.f.p<LimitCenterListBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3384x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3384x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(LimitCenterListBean limitCenterListBean) {
            Message message = this.f3384x;
            message.f21197s = 825;
            message.f21202x = limitCenterListBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3384x;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class t extends com.amgcyo.cuttadon.f.p<Income5Bean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3385x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3385x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Income5Bean income5Bean) {
            Message message = this.f3385x;
            message.f21197s = 825;
            message.f21202x = income5Bean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3385x;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class u extends com.amgcyo.cuttadon.f.p<MkUser> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3386x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3387y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ int f3388z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message, int i2) {
            super(eVar, cVar, str, str2);
            this.f3386x = eVar2;
            this.f3387y = message;
            this.f3388z = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(final MkUser mkUser) {
            if (mkUser == null || mkUser.getUser_id() <= 0) {
                this.f3386x.showMessage("登录失败!");
                this.f3387y.f21197s = 824;
                UserPresenter.this.d();
                return;
            }
            if (AppDatabase.i().d().insert(mkUser) <= 0) {
                this.f3386x.showMessage("登录失败!");
                this.f3387y.f21197s = 824;
                UserPresenter.this.d();
                return;
            }
            this.f3386x.showMessage("登录成功~");
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tel", mkUser.getTel());
            UserPresenter.this.a(mkUser);
            Message message = this.f3387y;
            message.f21202x = mkUser;
            message.f21197s = 823;
            com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
            List<MkBook> listC = fVarA.c();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listC)) {
                com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.az, com.amgcyo.cuttadon.i.n.a(listC));
            }
            String str = "deleteAllBooks: " + fVarA.a();
            mkUser.setLogin(true);
            MkDataBean data = mkUser.getData();
            if (data != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.k(data.getAttributes());
            }
            new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.api.presenter.r
                @Override // java.lang.Runnable
                public final void run() {
                    com.amgcyo.cuttadon.i.n.a(mkUser);
                }
            }, 22000L);
            me.jessyan.art.d.f.a().a(mkUser, "finish_activity");
            if (this.f3388z == -100) {
                com.amgcyo.cuttadon.utils.otherutils.h.u(-100);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.h.u(1);
            }
            x0.c().a(mkUser, 1);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.UserEvent.LOGIN);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3387y.f21197s = 824;
            UserPresenter.this.d();
        }
    }

    class v extends com.amgcyo.cuttadon.f.p<List<WithdrawalListBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3389x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3389x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<WithdrawalListBean> list) {
            Message message = this.f3389x;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3389x;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class w extends com.amgcyo.cuttadon.f.p<Invalitation5Bean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3390x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3390x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Invalitation5Bean invalitation5Bean) {
            Message message = this.f3390x;
            message.f21197s = 889;
            message.f21202x = invalitation5Bean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3390x;
            message.f21197s = 889;
            message.f21202x = null;
        }
    }

    class x extends com.amgcyo.cuttadon.f.p<Fuli5Index> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3391x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3391x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Fuli5Index fuli5Index) {
            com.amgcyo.cuttadon.utils.otherutils.h.u(0);
            Message message = this.f3391x;
            message.f21197s = 899;
            message.f21202x = fuli5Index;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3391x;
            message.f21197s = 899;
            message.f21202x = null;
        }
    }

    class y extends com.amgcyo.cuttadon.f.p<OpenBoxBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3392x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3392x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(OpenBoxBean openBoxBean) {
            Message message = this.f3392x;
            message.f21197s = 900;
            message.f21202x = openBoxBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3392x;
            message.f21197s = 900;
            message.f21202x = null;
        }
    }

    class z extends com.amgcyo.cuttadon.f.p<Task5ResultBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3393x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(UserPresenter userPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3393x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Task5ResultBean task5ResultBean) {
            Message message = this.f3393x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = task5ResultBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3393x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE;
            message.f21202x = null;
        }
    }

    public UserPresenter(me.jessyan.art.a.a.a aVar) {
        super((UserRepository) aVar.d().b(UserRepository.class));
        this.f3322u = aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.amgcyo.cuttadon.utils.otherutils.g.a("", "");
        com.amgcyo.cuttadon.utils.otherutils.h.u(0);
    }

    public void A(Message message) {
        Object[] objArr = message.f21203y;
        Observable<Task5ResultBean> observableObserveOn = ((UserRepository) this.f21196t).postMasterCodeBean((String) objArr[0], (String) objArr[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new g0(this, this.f3322u, "my", "裂变5-绑定邀请码", message));
    }

    public void B(Message message) {
        message.a();
        Observable<OpenBoxBean> observableObserveOn = ((UserRepository) this.f21196t).postOpenBoxData().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new y(this, this.f3322u, "my", "开宝箱", message));
    }

    public void C(Message message) {
        message.a();
        Observable<Task5ResultBean> observableObserveOn = ((UserRepository) this.f21196t).postTask5Receive10000Bean().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new a0(this, this.f3322u, "my", "裂变5-领取10000金币", message));
    }

    public void D(Message message) {
        message.a();
        Observable<Task5ResultBean> observableObserveOn = ((UserRepository) this.f21196t).postTask5ResultBean().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new z(this, this.f3322u, "my", "裂变5-看视频获得金币", message));
    }

    public void E(Message message) {
        message.a();
        Observable<Task5ResultBean> observableObserveOn = ((UserRepository) this.f21196t).postTask5ResultBean(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new h0(this, this.f3322u, "my", "裂变5-签到、开宝箱视频奖励", message));
    }

    public void F(Message message) {
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        Object[] objArr = message.f21203y;
        Observable<TxStepBean> observableObserveOn = ((UserRepository) this.f21196t).postTxStepBean(iIntValue, iIntValue2, (String) objArr[2], (String) objArr[3]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new e0(this, this.f3322u, "my", "裂变5-提现接口", message));
    }

    public void G(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<WithDrawBean> observableObserveOn = ((UserRepository) this.f21196t).postWithdrawalBean().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new d0(this, eVarA, this.f3322u, "my", "裂变5-提现页面", message));
    }

    public void H(Message message) {
        Observable<List<WithdrawalListBean>> observableObserveOn = ((UserRepository) this.f21196t).postWithdrawalList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new v(this, this.f3322u, "my", "裂变5-我的收益", message));
    }

    public void I(Message message) {
        Object[] objArr = message.f21203y;
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        String str4 = (String) objArr[3];
        String str5 = (String) objArr[4];
        String str6 = (String) objArr[5];
        int iIntValue = ((Integer) objArr[6]).intValue();
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<MkUser> observableObserveOn = ((UserRepository) this.f21196t).registerApiWithVersion(str, str2, str3, str4, str5, str6).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new j(eVarA, this.f3322u, "my", "用户注册接口", eVarA, message, iIntValue));
    }

    public void J(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).replaceAccount((String) objArr[0], (String) objArr[1], (String) objArr[2]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new f(this, eVarA, this.f3322u, "my", "更换账号", message));
    }

    public void K(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).submitCommentReportV1(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue(), ((Integer) message.f21203y[2]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new n(this, eVarA, this.f3322u, "my", "提交举报接口", eVarA, message));
    }

    public void L(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        ((UserRepository) this.f21196t).submitFeedbackV1((String) objArr[0], (String) objArr[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this, this.f3322u, "my", "提交反馈接口", eVarA, message));
    }

    public void M(final Message message) {
        final me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        ((UserRepository) this.f21196t).submitFeedbackV2((String) objArr[0], (String) objArr[1], (String) objArr[2]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.t
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                UserPresenter.a(message, eVarA);
            }
        }).subscribe(new o(this, this.f3322u, "my", "提交反馈接口V2", eVarA));
    }

    public void N(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        String str = (String) objArr[0];
        ((UserRepository) this.f21196t).updateNick(str).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new n0(this, eVarA, this.f3322u, "my", "修改用户昵称接口", (MkUser) objArr[1], str, eVarA, message));
    }

    public void O(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        ((UserRepository) this.f21196t).updatePwd((String) objArr[0], (String) objArr[1], (String) objArr[2]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, eVarA, this.f3322u, "my", "修改密码接口", eVarA, message));
    }

    public void P(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        File file = (File) objArr[0];
        MkUser mkUser = (MkUser) objArr[1];
        Observable<MkUplaodAvatar> observableObserveOn = ((UserRepository) this.f21196t).uploadAvatar(file).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new l(this, eVarA, this.f3322u, "my", "上传头像接口", message, mkUser, eVarA));
    }

    public void b(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).delBatchBook((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new e(this, eVarA, this.f3322u, "my", "批量删除V4", message));
    }

    public void c(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).findPwd((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new h(this, eVarA, this.f3322u, "my", "找回密码接口", eVarA, message));
    }

    public void e(Message message) {
        message.a();
        Observable<MkAddBookBean> observableObserveOn = ((UserRepository) this.f21196t).getArtAddBookHistory(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new r(this, this.f3322u, "my", "添加浏览历史接口", message));
    }

    public void f(Message message) {
        Observable<LimitCenterListBean> observableObserveOn = ((UserRepository) this.f21196t).getCommentListLoadMore(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new s(this, this.f3322u, "my", "个人中心评论列表", message));
    }

    public void g(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<CzIndexBean> observableObserveOn = ((UserRepository) this.f21196t).getCzIndexDataV6().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new j0(this, eVarA, this.f3322u, "my", "v6充值中心", eVarA, message));
    }

    public void h(Message message) {
        Observable<List<CzRecordBean>> observableObserveOn = ((UserRepository) this.f21196t).getCzRecordListData(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new k0(this, this.f3322u, "my", "充值记录v6", message));
    }

    public void i(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<MkFeedbackHisBean>> observableObserveOn = ((UserRepository) this.f21196t).getFeedbackHistory().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new p(this, eVarA, this.f3322u, "my", "获取反馈历史接口", eVarA, message));
    }

    public void j(Message message) {
        MkUser mkUser = (MkUser) message.f21203y[0];
        Observable<Fission6Index> observableObserveOn = ((UserRepository) this.f21196t).getFission6IndexDataV6(mkUser.getUser_id()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new i0(this, this.f3322u, "my", "添加书架v6", mkUser, message));
    }

    public void k(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        JsJsonObject jsJsonObject = (JsJsonObject) message.f21203y[0];
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).getH5Server(jsJsonObject.getUrl()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new a(this, this.f3322u, "my", "getH5Server接口", message, jsJsonObject, eVarA));
    }

    public void l(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).getValidateCode((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) message.f21203y[2]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new b(this, eVarA, this.f3322u, "my", "获取验证码接口", eVarA, message));
    }

    public void m(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).getValidateCodeForCancel((String) objArr[0], (String) objArr[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new c(this, eVarA, this.f3322u, "my", "注销账号发送验证码", eVarA, message));
    }

    public void n(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).getValidateCodeForReplace((String) objArr[0], (String) objArr[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new d(this, eVarA, this.f3322u, "my", "更换手机号发送验证码", eVarA, message));
    }

    public void o(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        int iIntValue = ((Integer) objArr[3]).intValue();
        Observable<MkUser> observableObserveOn = ((UserRepository) this.f21196t).loginApiWithVersion(str, str2, str3).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new u(eVarA, this.f3322u, "my", "用户登录接口", eVarA, message, iIntValue));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3322u = null;
    }

    public void p(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<MkUser> observableObserveOn = ((UserRepository) this.f21196t).migrateV6((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new f0(eVarA, this.f3322u, "my", "用户登录接口", eVarA, message));
    }

    public void q(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Object[] objArr = message.f21203y;
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).postAddBook((String) objArr[0], (String) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new k(this, eVarA, this.f3322u, "my", "求书接口", eVarA, message));
    }

    public void r(Message message) {
        message.a();
        Observable<Task5ResultBean> observableObserveOn = ((UserRepository) this.f21196t).postBindCodeOverTimeBean().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new b0(this, this.f3322u, "my", "裂变5-绑定邀请码-超过10天", message));
    }

    public void s(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Object[] objArr = message.f21203y;
        ((UserRepository) this.f21196t).postChapterFeedback(iIntValue, (String) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) message.f21203y[4]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(this, eVarA, this.f3322u, "my", "提交一键反馈", message, eVarA));
    }

    public void t(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<CzOrderBean> observableObserveOn = ((UserRepository) this.f21196t).postCzOrderData((SubmitOrderBean) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new l0(this, eVarA, this.f3322u, "my", "下订单v6", message, eVarA));
    }

    public void u(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<MkAdBean> observableObserveOn = ((UserRepository) this.f21196t).postCzOrderStatus((String) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new m0(this, eVarA, this.f3322u, "my", "订单状态查询", message, eVarA));
    }

    public void v(Message message) {
        Observable<Income5Bean> observableObserveOn = ((UserRepository) this.f21196t).postEarningsListLoadMore(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new t(this, this.f3322u, "my", "裂变5-我的收益", message));
    }

    public void w(Message message) {
        message.a();
        Observable<Fuli5Index> observableObserveOn = ((UserRepository) this.f21196t).postFuli5ListData((String) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new x(this, this.f3322u, "my", "裂变5主页数据", message));
    }

    public void x(Message message) {
        message.a();
        Observable<Fuli5SignIndex> observableObserveOn = ((UserRepository) this.f21196t).postFuli5SignIndexBean().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new c0(this, this.f3322u, "my", "裂变5-签到", message));
    }

    public void y(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        JsJsonObject jsJsonObject = (JsJsonObject) message.f21203y[0];
        Type type = new p0(this).getType();
        String query = jsJsonObject.getQuery();
        Map<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(query) && (map = (Map) com.amgcyo.cuttadon.utils.otherutils.r.a(query, type)) != null) {
            String str = "retMap == > " + map;
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String str2 = "key2 ==" + entry.getKey() + " , value2==" + entry.getValue();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).postH5Server(jsJsonObject.getUrl(), map).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new q0(this, this.f3322u, "my", "postH5Server接口", message, jsJsonObject, eVarA));
    }

    public void z(Message message) {
        Observable<Invalitation5Bean> observableObserveOn = ((UserRepository) this.f21196t).postInvalitation5BeanData().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new w(this, this.f3322u, "my", "裂变5-邀请首页", message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MkUser mkUser) {
        if (mkUser != null) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(String.valueOf(mkUser.getUser_id()), mkUser.getToken());
            if (com.amgcyo.cuttadon.utils.otherutils.h.I0()) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(new MkAdBean(mkUser.getAd_style(), mkUser.getAd_state(), mkUser.getServ_datetime(), mkUser.getAd_end_datetime(), mkUser.getAd_tips()));
                return;
            }
            return;
        }
        d();
    }

    public void d(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<MkAreaCodeBean>> observableObserveOn = ((UserRepository) this.f21196t).getAreaCodeBeanList().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new q(this, this.f3322u, "my", "获取区号接口", eVarA, message));
    }

    public void a(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<BaseModel> observableObserveOn = ((UserRepository) this.f21196t).cancelAccount((String) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.p(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new g(this, eVarA, this.f3322u, "my", "注销账号", message));
    }

    static /* synthetic */ void a(Message message, me.jessyan.art.mvp.e eVar) throws Exception {
        message.f21197s = 1020;
        eVar.hideLoading();
        message.b();
    }
}
