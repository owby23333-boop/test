package com.amgcyo.cuttadon.api.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.shelf.BookShelfCleanaupActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.BaseMaleFemaleBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListDeatil;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeStates;
import com.amgcyo.cuttadon.api.entity.comment.BaseCommentBean;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentBean;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetailBean;
import com.amgcyo.cuttadon.api.entity.comment.PostCommentRespone;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyToCommentBean;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.HistoryBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkAllBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.ThemeBookListID;
import com.amgcyo.cuttadon.api.entity.other.VideoAddBook;
import com.amgcyo.cuttadon.api.repository.BookRepository;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.view.dialog.s0;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Objects;
import me.drakeet.multitype.Items;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.BasePresenter;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class BookPresenter extends BasePresenter<BookRepository> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.jessyan.art.e.c f3166u;

    class a extends com.amgcyo.cuttadon.f.p<Items> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3167x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3168y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3167x = eVar;
            this.f3168y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Items items) {
            if (items == null) {
                this.f3167x.showEmpty();
            } else {
                this.f3168y.f21202x = items;
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            me.jessyan.art.mvp.e eVar = this.f3167x;
            if (eVar != null) {
                eVar.hideLoading();
            }
            this.f3168y.f21202x = null;
        }
    }

    class a0 extends com.amgcyo.cuttadon.f.p<CommentBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3169x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3170y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3169x = eVar;
            this.f3170y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(CommentBean commentBean) {
            this.f3169x.showLoadSuccess();
            Message message = this.f3170y;
            message.f21197s = 825;
            message.f21202x = commentBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3170y.f21197s = 826;
        }
    }

    class b extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3171x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3171x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3171x;
            message.f21197s = 843;
            message.f21202x = baseModel;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class b0 extends com.amgcyo.cuttadon.f.p<CommentDetailBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3172x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3173y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3172x = eVar;
            this.f3173y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(CommentDetailBean commentDetailBean) {
            if (commentDetailBean == null || commentDetailBean.getLists() == null) {
                this.f3172x.showEmpty();
                return;
            }
            Message message = this.f3173y;
            message.f21197s = 825;
            message.f21202x = commentDetailBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3173y.f21197s = 826;
        }
    }

    class c implements Action {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Message f3174s;

        c(BookPresenter bookPresenter, Message message) {
            this.f3174s = message;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.f3174s.b();
        }
    }

    class c0 extends com.amgcyo.cuttadon.f.p<MkBook> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3175x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3176y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3175x = eVar2;
            this.f3176y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkBook mkBook) {
            if (mkBook == null) {
                this.f3175x.showMessage("暂无数据");
                return;
            }
            Message message = this.f3176y;
            message.f21197s = 872;
            message.f21202x = mkBook;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            me.jessyan.art.mvp.e eVar = this.f3175x;
            if (eVar != null) {
                eVar.hideLoading();
            }
        }
    }

    class d extends com.amgcyo.cuttadon.f.p<BaseModel<BaseCommentBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3177x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3178y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3177x = message;
            this.f3178y = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel<BaseCommentBean> baseModel) {
            this.f3177x.f21197s = 844;
            BaseCommentBean data = baseModel.getData();
            if (data != null) {
                this.f3178y.showMessage("评论成功");
                this.f3177x.f21202x = data;
            } else {
                this.f3178y.showMessage(baseModel.getMsg());
                this.f3177x.f21202x = null;
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3177x.f21197s = 870;
            this.f3178y.showMessage(th.getMessage());
        }
    }

    class d0 extends com.amgcyo.cuttadon.f.p<PostCommentRespone> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ boolean f3179x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3180y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3181z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, boolean z2, Message message, me.jessyan.art.mvp.e eVar) {
            super(cVar, str, str2);
            this.f3179x = z2;
            this.f3180y = message;
            this.f3181z = eVar;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(PostCommentRespone postCommentRespone) {
            ReplyToCommentBean reply_to_comment = postCommentRespone.getReply_to_comment();
            ReplyToCommentBean replyToCommentBean = (!this.f3179x || reply_to_comment == null) ? null : new ReplyToCommentBean(reply_to_comment.getNick(), reply_to_comment.getAvatar(), reply_to_comment.getUser_id(), reply_to_comment.isFloor_host());
            String str = "PostCommentRespone返回数据：" + postCommentRespone.toString();
            ReplyArrBean replyArrBean = new ReplyArrBean(postCommentRespone.getNick(), postCommentRespone.getAvatar(), postCommentRespone.getBook_id(), postCommentRespone.getContent(), postCommentRespone.getUser_id(), postCommentRespone.getComment_id(), postCommentRespone.isFloor_host(), postCommentRespone.getComment_reply_id(), this.f3179x ? replyToCommentBean : null, 0, postCommentRespone.getCreated_at(), postCommentRespone.getFav_status(), postCommentRespone.getStatus());
            Message message = this.f3180y;
            message.f21197s = 848;
            message.f21202x = replyArrBean;
            String str2 = "返回数据：" + replyArrBean.toString();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3181z.showMessage(th.getMessage());
            this.f3180y.f21197s = 870;
        }
    }

    class e extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3182x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3183y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3182x = message;
            this.f3183y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3182x;
            message.f21197s = 846;
            message.f21202x = baseModel;
            this.f3183y.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class e0 extends com.amgcyo.cuttadon.f.p<List<ShudanListData>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3184x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3185y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3184x = eVar;
            this.f3185y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<ShudanListData> list) {
            if (list == null) {
                this.f3184x.showEmpty();
                return;
            }
            Message message = this.f3185y;
            message.f21197s = 842;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class f extends com.amgcyo.cuttadon.f.p<BaseModel> {
        final /* synthetic */ me.jessyan.art.mvp.e A;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ int f3186x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3187y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ Message f3188z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, int i2, int i3, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3186x = i2;
            this.f3187y = i3;
            this.f3188z = message;
            this.A = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            AppDatabase.i().b().insert(new MkCommentStatus(this.f3186x, 1, this.f3187y));
            Message message = this.f3188z;
            message.f21197s = 847;
            message.f21202x = baseModel;
            this.A.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class f0 extends com.amgcyo.cuttadon.f.p<ThemeBookListDeatil> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3189x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3190y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3189x = eVar;
            this.f3190y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ThemeBookListDeatil themeBookListDeatil) {
            if (themeBookListDeatil == null) {
                this.f3189x.showEmpty();
                return;
            }
            Message message = this.f3190y;
            message.f21197s = 825;
            message.f21202x = themeBookListDeatil;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3190y;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class g extends com.amgcyo.cuttadon.f.p<BaseModel> {
        final /* synthetic */ me.jessyan.art.mvp.e A;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ int f3191x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3192y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ Message f3193z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, int i2, int i3, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3191x = i2;
            this.f3192y = i3;
            this.f3193z = message;
            this.A = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            AppDatabase.i().b().insert(new MkCommentStatus(this.f3191x, 1, this.f3192y));
            Message message = this.f3193z;
            message.f21197s = 847;
            message.f21202x = baseModel;
            this.A.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class g0 extends com.amgcyo.cuttadon.f.p<BaseModel> {
        g0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
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

    class h extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3194x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ ReplyArrBean f3195y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3196z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, ReplyArrBean replyArrBean, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3194x = message;
            this.f3195y = replyArrBean;
            this.f3196z = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3194x;
            message.f21197s = 849;
            message.f21202x = this.f3195y;
            this.f3196z.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class h0 extends com.amgcyo.cuttadon.f.p<BaseModel> {
        h0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
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

    class i extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3197x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ BaseNewComment f3198y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3199z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, BaseNewComment baseNewComment, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3197x = message;
            this.f3198y = baseNewComment;
            this.f3199z = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3197x;
            message.f21197s = 849;
            message.f21202x = this.f3198y;
            this.f3199z.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class i0 extends com.amgcyo.cuttadon.f.p<BaseModel> {
        i0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
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

    class j extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3200x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3201y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ MkBook f3202z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2, MkBook mkBook) {
            super(eVar, cVar, str, str2);
            this.f3200x = message;
            this.f3201y = eVar2;
            this.f3202z = mkBook;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            BookPresenter.this.a(this.f3200x, this.f3201y, this.f3202z, false, false);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class j0 extends com.amgcyo.cuttadon.f.p<BaseModel> {
        j0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2) {
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

    class k extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3203x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ int f3204y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, int i2) {
            super(cVar, str, str2);
            this.f3203x = message;
            this.f3204y = i2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            Message message = this.f3203x;
            message.f21197s = 825;
            message.f21202x = list;
            com.amgcyo.cuttadon.h.a.c.c("bookshelf_time" + this.f3204y);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3203x.f21197s = 826;
        }
    }

    class k0 extends com.amgcyo.cuttadon.f.p<MkBook> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3205x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3206y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3205x = message;
            this.f3206y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkBook mkBook) {
            Message message = this.f3205x;
            message.f21197s = 872;
            message.f21202x = mkBook;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            me.jessyan.art.mvp.e eVar = this.f3206y;
            if (eVar != null) {
                eVar.hideLoading();
            }
        }
    }

    class l implements com.amgcyo.cuttadon.g.e {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s0 f3207c;

        l(BookPresenter bookPresenter, Context context, int i2, s0 s0Var) {
            this.a = context;
            this.b = i2;
            this.f3207c = s0Var;
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void a() {
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void b() {
            Intent intent = new Intent(this.a, (Class<?>) BookShelfCleanaupActivity.class);
            intent.putExtra("form", this.b);
            intent.putExtra("type_id", 10);
            this.a.startActivity(intent);
            this.f3207c.dismiss();
        }
    }

    class l0 extends com.amgcyo.cuttadon.f.p<Items> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3208x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3208x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Items items) {
            Message message = this.f3208x;
            message.f21197s = 888;
            message.f21202x = items;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3208x;
            message.f21197s = 888;
            message.f21202x = null;
        }
    }

    class m implements com.amgcyo.cuttadon.g.e {
        final /* synthetic */ Message a;
        final /* synthetic */ MkBook b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ s0 f3210d;

        m(BookPresenter bookPresenter, Message message, MkBook mkBook, me.jessyan.art.mvp.e eVar, s0 s0Var) {
            this.a = message;
            this.b = mkBook;
            this.f3209c = eVar;
            this.f3210d = s0Var;
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void a() {
            if (this.b.isNeedFinishActivity()) {
                this.f3209c.finishReadActivity();
            }
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void b() {
            this.a.f21202x = new VideoAddBook(this.b);
            this.f3209c.addBookToShelfV6(this.a);
            this.f3210d.dismiss();
        }
    }

    class m0 extends com.amgcyo.cuttadon.f.p<List<MkSiteBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3211x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3212y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m0(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3211x = eVar2;
            this.f3212y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkSiteBean> list) {
            if (list == null) {
                this.f3211x.showMessage("暂无数据");
                return;
            }
            Message message = this.f3212y;
            message.f21197s = 897;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3212y;
            message.f21197s = 897;
            message.f21202x = null;
        }
    }

    class n extends com.amgcyo.cuttadon.f.p<BaseModel> {
        final /* synthetic */ boolean A;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3213x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3214y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ MkBook f3215z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2, MkBook mkBook, boolean z2) {
            super(eVar, cVar, str, str2);
            this.f3213x = message;
            this.f3214y = eVar2;
            this.f3215z = mkBook;
            this.A = z2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            BookPresenter.this.a(this.f3213x, this.f3214y, this.f3215z, true, this.A);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class n0 extends com.amgcyo.cuttadon.f.p<List<BaseMaleFemaleBean>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3216x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3217y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3216x = eVar;
            this.f3217y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<BaseMaleFemaleBean> list) {
            if (list == null) {
                this.f3216x.showMessage("暂无数据");
                return;
            }
            Message message = this.f3217y;
            message.f21197s = 825;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3217y;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class o extends com.amgcyo.cuttadon.f.p<ThemeStates> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3218x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3218x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ThemeStates themeStates) {
            Message message = this.f3218x;
            message.f21197s = 839;
            message.f21202x = themeStates;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class o0 extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3219x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o0(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3219x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.f3219x.f21202x = null;
            } else {
                this.f3219x.f21202x = list;
            }
            Message message = this.f3219x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3219x;
            message.f21202x = null;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.b();
        }
    }

    class p extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3220x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3221y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ MkBook f3222z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2, MkBook mkBook) {
            super(eVar, cVar, str, str2);
            this.f3220x = message;
            this.f3221y = eVar2;
            this.f3222z = mkBook;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            BookPresenter.this.a(this.f3220x, this.f3221y, this.f3222z);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class p0 extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3223x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p0(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3223x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.f3223x.f21202x = null;
            } else {
                this.f3223x.f21202x = list;
            }
            Message message = this.f3223x;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.b();
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3223x;
            message.f21202x = null;
            message.f21197s = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT;
            message.b();
        }
    }

    class q extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3224x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3225y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3224x = message;
            this.f3225y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3224x;
            message.f21197s = 840;
            message.f21202x = baseModel;
            this.f3225y.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class r extends com.amgcyo.cuttadon.f.p<BaseModel> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3226x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3227y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message, me.jessyan.art.mvp.e eVar2) {
            super(eVar, cVar, str, str2);
            this.f3226x = message;
            this.f3227y = eVar2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseModel baseModel) {
            Message message = this.f3226x;
            message.f21197s = 841;
            message.f21202x = baseModel;
            this.f3227y.showMessage(baseModel.getMsg());
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class s extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3228x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(cVar, str, str2);
            this.f3228x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            Message message = this.f3228x;
            message.f21197s = 900;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3228x;
            message.f21197s = 900;
            message.f21202x = null;
        }
    }

    class t extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3229x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ boolean f3230y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, Message message, boolean z2) {
            super(cVar, str, str2);
            this.f3229x = message;
            this.f3230y = z2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(final List<MkBook> list) {
            Message message = this.f3229x;
            message.f21197s = 825;
            message.f21202x = list;
            if (!this.f3230y || com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                return;
            }
            new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.api.presenter.b
                @Override // java.lang.Runnable
                public final void run() {
                    com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, com.amgcyo.cuttadon.i.n.a((List<MkBook>) list));
                }
            }, 5000L);
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            this.f3229x.f21197s = 826;
        }
    }

    class u extends com.amgcyo.cuttadon.f.p<List<MkBook>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ int f3231x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3232y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ int f3233z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, int i2, Message message, int i3) {
            super(cVar, str, str2);
            this.f3231x = i2;
            this.f3232y = message;
            this.f3233z = i3;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<MkBook> list) {
            String str = "当前页：" + this.f3231x + "返回条数：" + list.size();
            Message message = this.f3232y;
            message.f21197s = this.f3233z;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3232y;
            message.f21197s = this.f3233z;
            message.f21202x = null;
        }
    }

    class v extends com.amgcyo.cuttadon.f.p<ThemeBookListBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3234x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3235y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3234x = eVar;
            this.f3235y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ThemeBookListBean themeBookListBean) {
            if (themeBookListBean == null) {
                this.f3234x.showEmpty();
                return;
            }
            Message message = this.f3235y;
            message.f21197s = 825;
            message.f21202x = themeBookListBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3235y;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class w extends com.amgcyo.cuttadon.f.p<ThemeBookListID> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ int f3236x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3237y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ Message f3238z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, int i2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3236x = i2;
            this.f3237y = eVar;
            this.f3238z = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ThemeBookListID themeBookListID) {
            if (themeBookListID != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(themeBookListID.getLists())) {
                Message message = this.f3238z;
                message.f21197s = 825;
                message.f21202x = themeBookListID;
            } else if (this.f3236x == 1) {
                this.f3237y.showEmpty();
            } else {
                this.f3238z.f21197s = 852;
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    class x extends com.amgcyo.cuttadon.f.p<HistoryBookBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ int f3239x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3240y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ Message f3241z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, int i2, me.jessyan.art.mvp.e eVar2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3239x = i2;
            this.f3240y = eVar2;
            this.f3241z = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(HistoryBookBean historyBookBean) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(historyBookBean.getLists())) {
                if (this.f3239x == 1) {
                    this.f3240y.showEmpty();
                }
            } else {
                Message message = this.f3241z;
                message.f21197s = 825;
                message.f21202x = historyBookBean;
            }
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3241z;
            message.f21197s = 826;
            message.f21202x = null;
        }
    }

    class y extends com.amgcyo.cuttadon.f.p<MkAllBookBean> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ me.jessyan.art.mvp.e f3242x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ Message f3243y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(BookPresenter bookPresenter, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar, Message message) {
            super(cVar, str, str2);
            this.f3242x = eVar;
            this.f3243y = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(MkAllBookBean mkAllBookBean) {
            if (mkAllBookBean == null || com.amgcyo.cuttadon.utils.otherutils.g.a(mkAllBookBean.getLists())) {
                this.f3242x.showMessage("暂无数据");
                return;
            }
            Message message = this.f3243y;
            message.f21197s = 825;
            message.f21202x = mkAllBookBean;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            Message message = this.f3243y;
            message.f21197s = 825;
            message.f21202x = null;
        }
    }

    class z extends com.amgcyo.cuttadon.f.p<List<BaseNewComment>> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Message f3244x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(BookPresenter bookPresenter, me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2, Message message) {
            super(eVar, cVar, str, str2);
            this.f3244x = message;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<BaseNewComment> list) {
            Message message = this.f3244x;
            message.f21197s = 845;
            message.f21202x = list;
        }

        @Override // com.amgcyo.cuttadon.f.p, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    public BookPresenter(me.jessyan.art.a.a.a aVar) {
        super((BookRepository) aVar.d().b(BookRepository.class));
        this.f3166u = aVar.b();
    }

    static /* synthetic */ void L(Message message) throws Exception {
        message.f21197s = 825;
        message.b();
    }

    public void A(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<CommentDetailBean> observableObserveOn = ((BookRepository) this.f21196t).getCommentDetailBeanLoadMore(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new b0(this, this.f3166u, "my", "评论详情", eVarA, message));
    }

    public void B(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<CommentBean> observableObserveOn = ((BookRepository) this.f21196t).getCommentListLoadMore(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue(), ((Integer) message.f21203y[2]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new a0(this, this.f3166u, "my", "评论列表", eVarA, message));
    }

    public void C(Message message) {
        boolean zBooleanValue = ((Boolean) message.f21203y[0]).booleanValue();
        Observable<List<MkBook>> observableObserveOn = ((BookRepository) this.f21196t).getLoginUserShelfBookList(zBooleanValue, ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new t(this, this.f3166u, "my", "getLoginUserShelfBookList", message, zBooleanValue));
    }

    public void D(Message message) {
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Observable<List<MkBook>> observableObserveOn = ((BookRepository) this.f21196t).getNoLoginArtShelfListData(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new k(this, this.f3166u, "book", "getNoLoginArtShelfListData", message, iIntValue));
    }

    public void E(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<ThemeStates> observableObserveOn = ((BookRepository) this.f21196t).isFavThemeBookList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new o(this, eVarA, this.f3166u, "my", "是否收藏书单", message));
    }

    public void F(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).likeComment(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new f(this, eVarA, this.f3166u, "my", "评论点赞", iIntValue, iIntValue2, message, eVarA));
    }

    public void G(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).likeReplyComment(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new g(this, eVarA, this.f3166u, "my", "评论回复点赞", iIntValue, iIntValue2, message, eVarA));
    }

    public void H(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Object[] objArr = message.f21203y;
        String str = (String) objArr[1];
        int iIntValue2 = ((Integer) objArr[2]).intValue();
        boolean zBooleanValue = ((Boolean) message.f21203y[3]).booleanValue();
        Observable<PostCommentRespone> observableObserveOn = ((BookRepository) this.f21196t).postComment(iIntValue, str, iIntValue2).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new d0(this, this.f3166u, "my", "提交评论", zBooleanValue, message, eVarA));
    }

    public void I(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        Object[] objArr = message.f21203y;
        Observable<BaseModel<BaseCommentBean>> observableObserveOn = ((BookRepository) this.f21196t).subMitCommentV4(iIntValue, iIntValue2, (String) objArr[2], ((Integer) objArr[3]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new d(this, this.f3166u, "my", "提交评论接口", message, eVarA));
    }

    public void J(Message message) {
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).topBook(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new i0(this, this.f3166u, "my", "置顶书籍"));
    }

    public void K(Message message) {
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).topDelBook(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new j0(this, this.f3166u, "my", "取消置顶书籍"));
    }

    public void b(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).addThemeBookList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new q(this, eVarA, this.f3166u, "my", "添加书单", message, eVarA));
    }

    public void c(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        ((BookRepository) this.f21196t).deleteAllHistory(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new c(this, message)).subscribe(new b(this, eVarA, this.f3166u, "my", "deleteAllHistory", message));
    }

    public void d(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        MkBook mkBook = (MkBook) message.f21203y[0];
        if (mkBook == null) {
            eVarA.showMessage("操作异常!");
        } else if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            a(message, eVarA, mkBook);
        } else {
            ((BookRepository) this.f21196t).deleteBookFromShelf(mkBook.getBook_id(), mkBook.getForm()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(eVarA, this.f3166u, "my", "移除书架", message, eVarA, mkBook));
        }
    }

    public void e(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).deleteComment(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new e(this, eVarA, this.f3166u, "my", "删除评论", message, eVarA));
    }

    public void f(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        ReplyArrBean replyArrBean = (ReplyArrBean) message.f21203y[0];
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).deleteShelfReplyComment(replyArrBean.getComment_reply_id()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new h(this, eVarA, this.f3166u, "my", "deleteShelfReplyComment", message, replyArrBean, eVarA));
    }

    public void g(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        BaseNewComment baseNewComment = (BaseNewComment) message.f21203y[0];
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).deleteShelfReplyComment(baseNewComment.getReply_comment_id()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new i(this, eVarA, this.f3166u, "my", "deleteShelfReplyComment1", message, baseNewComment, eVarA));
    }

    public void h(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).deleteThemeBookList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new r(this, eVarA, this.f3166u, "my", "删除书单", message, eVarA));
    }

    public void i(Message message) {
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).fattenBook(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new g0(this, this.f3166u, "my", "养肥书籍"));
    }

    public void j(Message message) {
        Observable<BaseModel> observableObserveOn = ((BookRepository) this.f21196t).fattenDelBook(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new h0(this, this.f3166u, "my", "取消养肥书籍"));
    }

    public void k(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<MkAllBookBean> observableObserveOn = ((BookRepository) this.f21196t).getArtAllCateBookList(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue(), ((Integer) message.f21203y[2]).intValue(), ((Integer) message.f21203y[3]).intValue(), ((Integer) message.f21203y[4]).intValue(), ((Integer) message.f21203y[5]).intValue() + ".html").subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new y(this, this.f3166u, "book", "获取分类全部数据", eVarA, message));
    }

    public void l(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[1]).intValue();
        if (1 == iIntValue2) {
            ((BookRepository) this.f21196t).getArtBookAndComicsDetailBean(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this, eVarA, this.f3166u, "book", "书籍详情", eVarA, message));
        } else if (3 == iIntValue2) {
            ((BookRepository) this.f21196t).getArtComicDetailBean(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new k0(this, eVarA, this.f3166u, "book", "书籍详情", message, eVarA));
        }
    }

    public void m(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<MkSiteBean>> observableObserveOn = ((BookRepository) this.f21196t).getArtBookSourceList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new m0(this, eVarA, this.f3166u, "book", "获取书源信息", eVarA, message));
    }

    public void n(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Observable<HistoryBookBean> observableObserveOn = ((BookRepository) this.f21196t).getArtHistoryBookID(iIntValue, ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new x(this, eVarA, this.f3166u, "my", "获取用户阅读历史", iIntValue, eVarA, message));
    }

    public void o(Message message) {
        ((BookRepository) this.f21196t).getArtRankDeatilListV7(((Integer) message.f21203y[0]).intValue(), (String) message.f21203y[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new p0(this, this.f3166u, "book", "获取榜单详情数据", message));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
    }

    @Override // me.jessyan.art.mvp.BasePresenter, me.jessyan.art.mvp.c
    public void onDestroy() {
        super.onDestroy();
        this.f3166u = null;
    }

    public void p(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        ((BookRepository) this.f21196t).getArtRankDeatilListV7(((Integer) message.f21203y[0]).intValue(), (String) message.f21203y[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(this, eVarA, this.f3166u, "book", "获取榜单详情数据", message));
    }

    public void q(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<BaseMaleFemaleBean>> observableObserveOn = ((BookRepository) this.f21196t).getArtRankIndexBeanV7(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new n0(this, this.f3166u, "book", "获取书源信息", eVarA, message));
    }

    public void r(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<ShudanListData>> observableObserveOn = ((BookRepository) this.f21196t).getArtThemeBookBaseInfo((List) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new e0(this, this.f3166u, "book", "getArtThemeBookBaseInfo", eVarA, message));
    }

    public void s(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<ThemeBookListBean> observableObserveOn = ((BookRepository) this.f21196t).getArtThemeBookList(((Integer) message.f21203y[0]).intValue(), ((Integer) message.f21203y[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new v(this, this.f3166u, "book", "getArtThemeBookList", eVarA, message));
    }

    public void t(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<ThemeBookListDeatil> observableObserveOn = ((BookRepository) this.f21196t).getArtThemeBookListDeatil((String) message.f21203y[0]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new f0(this, this.f3166u, "book", "getArtThemeBookListDeatil", eVarA, message));
    }

    public void u(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        int iIntValue = ((Integer) message.f21203y[0]).intValue();
        Observable<ThemeBookListID> observableObserveOn = ((BookRepository) this.f21196t).getArtThemeBookListID(iIntValue).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new w(this, this.f3166u, "my", "getArtThemeBookListID", iIntValue, eVarA, message));
    }

    public void v(final Message message) {
        ((BookRepository) this.f21196t).getBookCityClassifyDataV4().subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.amgcyo.cuttadon.api.presenter.a
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                BookPresenter.L(message);
            }
        }).subscribe(new a(this, this.f3166u, "book", "获取分类首页数据，（新版）", message.a(), message));
    }

    public void w(Message message) {
        Object[] objArr = message.f21203y;
        String str = (String) objArr[0];
        int iIntValue = ((Integer) objArr[1]).intValue();
        int iIntValue2 = ((Integer) message.f21203y[2]).intValue();
        int iIntValue3 = ((Integer) message.f21203y[3]).intValue();
        Observable<List<MkBook>> observableObserveOn = ((BookRepository) this.f21196t).getBookCityMoreV7(str, iIntValue, iIntValue2).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new u(this, this.f3166u, "book", "getBookCityMoreV7", iIntValue2, message, iIntValue3));
    }

    public void x(Message message) {
        Object[] objArr = message.f21203y;
        Observable<Items> observableObserveOn = ((BookRepository) this.f21196t).getBookCitySexDataListDataConfV7((String) objArr[0], (List) objArr[1]).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new l0(this, this.f3166u, "book", "书城接口", message));
    }

    public void y(Message message) {
        Object[] objArr = message.f21203y;
        Observable<List<MkBook>> observableObserveOn = ((BookRepository) this.f21196t).getBookCityYourLikeV7((String) objArr[0], ((Integer) objArr[1]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new s(this, this.f3166u, "book", "getBookCityYourLikeV4", message));
    }

    public void z(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        Observable<List<BaseNewComment>> observableObserveOn = ((BookRepository) this.f21196t).getBookDetailCommentList(((Integer) message.f21203y[0]).intValue()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(message);
        observableObserveOn.doFinally(new com.amgcyo.cuttadon.api.presenter.v(message)).subscribe(new z(this, eVarA, this.f3166u, "my", "获取书籍详情评论", message));
    }

    public void a(Message message) {
        me.jessyan.art.mvp.e eVarA = message.a();
        MkBook mkBook = (MkBook) message.f21203y[0];
        if (mkBook == null) {
            eVarA.showMessage("参数异常!");
            return;
        }
        int form = mkBook.getForm();
        String str = 3 == form ? "漫画" : "小说";
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        int iE = AppDatabase.i().a().e(form);
        String str2 = "dbBookSizeByForm: " + iE;
        if (mkUserJ == null) {
            int iP = com.amgcyo.cuttadon.utils.otherutils.h.P();
            if (iE >= iP) {
                eVarA.showLoginDialog("游客模式最多只能添加" + iP + "本书籍~\n是否登录?");
                return;
            }
            a(message, eVarA, mkBook, false, false);
            return;
        }
        int iV = com.amgcyo.cuttadon.utils.otherutils.h.V();
        if (iE < iV) {
            ((BookRepository) this.f21196t).addBookToShelfV4(mkBook.getBook_id(), form).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(eVarA, this.f3166u, "my", "添加书架v4", message, eVarA, mkBook));
            return;
        }
        List<BaseAd> listB = com.amgcyo.cuttadon.sdk.utils.h.b("video_add_book");
        int iA = com.amgcyo.cuttadon.sdk.utils.h.a("video_add_book", "add_count");
        boolean z2 = com.amgcyo.cuttadon.utils.otherutils.g.a(listB) || iA <= 0;
        int iA2 = com.amgcyo.cuttadon.sdk.utils.h.a("video_add_book", "total_count");
        String str3 = "server total_book_number " + iA2;
        if (z2) {
            iA2 = iV;
        }
        if (iE >= iA2) {
            iA2 = iE;
        }
        String str4 = "final total_book_number " + iA2 + " dbBookSizeByForm: " + iE;
        Context hostContext = eVarA.getHostContext();
        if (iE >= iA2) {
            s0 s0Var = new s0(hostContext);
            s0Var.show();
            s0Var.a("暂不清理", "书架清理", str + "书架收藏已满", "无法继续添加！可点击下方按钮对书架清理后再添加！");
            s0Var.a(new l(this, hostContext, form, s0Var));
            return;
        }
        String str5 = "广告大小：" + listB.size() + " 每次添加大小：" + iA;
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        int iA3 = com.amgcyo.cuttadon.sdk.utils.h.a("video_add_book", "today_count");
        if (iA3 < 0) {
            iA3 = 1;
        }
        int iA4 = com.amgcyo.cuttadon.sdk.utils.h.a("video_add_book", "interval_min");
        if (iA4 < 0) {
            iA4 = 20;
        }
        int iA5 = g0VarA.a(com.amgcyo.cuttadon.f.n.f3692f, 0);
        String str6 = "todayCountSp:" + iA5 + " addBookNumber: " + iA + " todayBookCount: " + iA3 + " videoBookIntervalMin: " + iA4;
        if (iA5 % iA == 0) {
            long jC = g0VarA.c("video_book_interval_time");
            String str7 = "上次观看时间：" + t0.d(jC);
            if (iA5 < iA3) {
                if (jC > 0 && !t0.a(jC, iA4)) {
                    a("添加扩容书籍过于频繁，请" + (((long) iA4) - t0.b(jC)) + "分钟后再来添加！");
                    if (mkBook.isNeedFinishActivity()) {
                        eVarA.finishReadActivity();
                        return;
                    }
                    return;
                }
                s0 s0Var2 = new s0(hostContext);
                s0Var2.a(new m(this, message, mkBook, eVarA, s0Var2));
                s0Var2.show();
                s0Var2.a("稍后", "观看小视频", str + "书架收藏已满", "你需要观看小视频解锁加入书架权限，是否观看？");
                return;
            }
            a("今日添加书籍次数已用完，请明天再来！");
            if (mkBook.isNeedFinishActivity()) {
                eVarA.finishReadActivity();
                return;
            }
            return;
        }
        a(message, false);
    }

    private void a(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 1, 3);
    }

    public void a(Message message, boolean z2) {
        me.jessyan.art.mvp.e eVarA = message.a();
        MkBook mkBook = (MkBook) message.f21203y[0];
        if (mkBook == null) {
            eVarA.showMessage("参数异常!");
        } else {
            ((BookRepository) this.f21196t).addBookToShelfV6(mkBook.getBook_id(), mkBook.getForm()).subscribeOn(Schedulers.io()).doOnSubscribe(new com.amgcyo.cuttadon.api.presenter.n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(eVarA, this.f3166u, "my", "添加书架v6", message, eVarA, mkBook, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, me.jessyan.art.mvp.e eVar, MkBook mkBook, boolean z2, boolean z3) {
        mkBook.setJpush_status(1);
        mkBook.setReading_datetime(System.currentTimeMillis() / 1000);
        long jInsert = AppDatabase.i().a().insert(mkBook);
        if (jInsert > 0) {
            message.f21197s = 832;
            message.f21202x = Long.valueOf(jInsert);
            eVar.showMessage("成功加入书架!");
            Context hostContext = eVar.getHostContext();
            if (mkBook.isSkipToDetailPage() && hostContext != null) {
                r0.a(hostContext, mkBook.getBook_id(), mkBook.getForm());
            }
            com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, String.valueOf(mkBook.getBook_id()));
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "add_delete_book");
            if (mkBook.isNeedFinishActivity()) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(), "comic_finish_activity");
            }
            com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
            if (z3) {
                g0VarA.b("video_book_interval_time", System.currentTimeMillis());
            }
            if (z2) {
                String str = com.amgcyo.cuttadon.f.n.f3692f;
                g0VarA.b(str, g0VarA.b(str) + 1);
            }
            if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null && !g0VarA.a("show_first_login_tip ", false) && !(hostContext instanceof MyRewardBaseAdActivity)) {
                g0VarA.b("show_first_login_tip ", true);
                eVar.showLoginDialog("登录后可以云端同步书架哦~\n是否登录?");
            }
        } else {
            eVar.showMessage("加入书架失败!");
        }
        message.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, me.jessyan.art.mvp.e eVar, MkBook mkBook) {
        String strA;
        mkBook.setJpush_status(0);
        long jA = AppDatabase.i().a().a(mkBook.getBook_id());
        if (jA > 0) {
            eVar.showMessage("成功从书架删除!");
            message.f21197s = 833;
            message.f21202x = Long.valueOf(jA);
            if (1 == mkBook.getForm()) {
                strA = com.amgcyo.cuttadon.utils.otherutils.z.b(mkBook.getBook_id());
            } else {
                strA = com.amgcyo.cuttadon.utils.otherutils.z.a(mkBook.getBook_id());
            }
            com.amgcyo.cuttadon.j.a.e.a((BaseTitleBarActivity) eVar.getHostContext(), strA, false, (com.amgcyo.cuttadon.j.e.b) null, false);
            com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.az, String.valueOf(mkBook.getBook_id()));
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "add_delete_book");
            if (mkBook.isNeedFinishActivity()) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(), "comic_finish_activity");
            }
        } else {
            eVar.showMessage("从书架删除失败!");
        }
        message.b();
    }
}
