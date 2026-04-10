package com.amgcyo.cuttadon.fragment.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.setting.MkCommentDetailActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentBean;
import com.amgcyo.cuttadon.api.entity.comment.FavArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.amgcyo.cuttadon.view.comment.c;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: MkCommentListFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends BaseRefreshMoreRecyclerFragment<BookPresenter> implements com.amgcyo.cuttadon.g.c {
    private int K;
    private int L;
    private BaseNewComment Q;
    private com.amgcyo.cuttadon.view.comment.c U;
    private List<BaseNewComment> M = new ArrayList();
    private List<BaseNewComment> N = new ArrayList();
    private int O = 0;
    private int P = -1;
    private int R = -1;
    private int S = -1;
    private int T = -1;

    /* JADX INFO: compiled from: MkCommentListFragment.java */
    class a implements c.InterfaceC0115c {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3828c;

        a(int i2, int i3, boolean z2) {
            this.a = i2;
            this.b = i3;
            this.f3828c = z2;
        }

        @Override // com.amgcyo.cuttadon.view.comment.c.InterfaceC0115c
        public void a(String str) {
            x0.this.showLoading("正在提交...");
            ((BookPresenter) ((com.amgcyo.cuttadon.fragment.base.a) x0.this).f3726u).H(Message.a(x0.this, new Object[]{Integer.valueOf(this.a), str, Integer.valueOf(this.b), Boolean.valueOf(this.f3828c)}));
        }
    }

    private void b(List<FavArrBean> list) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ != null) {
            list.add(new FavArrBean("书友" + mkUserJ.getUser_id(), mkUserJ.getAvatar(), mkUserJ.getUser_id()));
        }
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void addReplyComment(@NonNull BaseNewComment baseNewComment, ReplyArrBean replyArrBean, int i2, int i3) {
        this.T = i2;
        this.Q = baseNewComment;
        a("回复 " + replyArrBean.getNick() + " :", baseNewComment.getComment_id(), i3, true);
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void deleteReplyComment(@NonNull BaseNewComment baseNewComment, @NonNull ReplyArrBean replyArrBean, int i2) {
        this.Q = baseNewComment;
        this.R = i2;
        a(replyArrBean);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.K = arguments.getInt("book_id", -1);
        this.L = arguments.getInt("comment_sort_type", 1);
        if (this.K == -1) {
            return;
        }
        this.O = com.amgcyo.cuttadon.sdk.utils.h.a("comment_lists", "interval_count");
        String str = "adCount: " + this.O;
        p();
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void gotoCommentDeiailPage(@NonNull BaseNewComment baseNewComment) {
        Bundle bundle = new Bundle();
        bundle.putInt("comment_id", baseNewComment.getComment_id());
        startActivity(new Intent(this.f3725t, (Class<?>) MkCommentDetailActivity.class).putExtras(bundle));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        int i2;
        BaseNewComment baseNewComment;
        super.handleMessage(message);
        int i3 = message.f21197s;
        if (i3 == 825) {
            CommentBean commentBean = (CommentBean) message.f21202x;
            if (commentBean == null || com.amgcyo.cuttadon.utils.otherutils.g.a(commentBean.getLists())) {
                String str = "pageNo:" + this.H;
                if (this.H <= 1) {
                    showEmpty();
                } else {
                    BaseQuickAdapter baseQuickAdapter = this.G;
                    if (baseQuickAdapter != null) {
                        baseQuickAdapter.n();
                    }
                }
            } else {
                List<BaseNewComment> lists = commentBean.getLists();
                if (this.M == null) {
                    this.M = new ArrayList();
                }
                if (this.N == null) {
                    this.N = new ArrayList();
                }
                int limit = commentBean.getLimit();
                this.recyclerView.setItemViewCacheSize(lists.size());
                a(lists, limit);
            }
            c(false);
            return;
        }
        if (i3 == 826) {
            if (this.H <= 1) {
                j();
            } else {
                BaseQuickAdapter baseQuickAdapter2 = this.G;
                if (baseQuickAdapter2 != null) {
                    baseQuickAdapter2.o();
                }
            }
            c(false);
            return;
        }
        if (i3 == 870) {
            hideLoading();
            com.amgcyo.cuttadon.view.comment.c cVar = this.U;
            if (cVar != null) {
                cVar.dismiss();
                this.U = null;
                return;
            }
            return;
        }
        switch (i3) {
            case 846:
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.M) && (i2 = this.S) != -1) {
                    this.M.remove(i2);
                    this.G.notifyItemRemoved(this.S);
                    this.G.notifyItemChanged(this.S);
                    if (this.M.size() <= 0) {
                        showEmpty();
                    }
                    this.recyclerView.requestLayout();
                    this.S = -1;
                    break;
                }
                break;
            case 847:
                BaseNewComment baseNewComment2 = this.Q;
                if (baseNewComment2 != null && this.P != -1) {
                    List<FavArrBean> fav_arr = baseNewComment2.getFav_arr();
                    if (com.amgcyo.cuttadon.utils.otherutils.g.a(fav_arr)) {
                        fav_arr = new ArrayList<>();
                        b(fav_arr);
                    } else {
                        if (fav_arr.size() >= 5) {
                            fav_arr.remove(0);
                        }
                        b(fav_arr);
                    }
                    this.Q.setFav_arr(fav_arr);
                    BaseNewComment baseNewComment3 = this.Q;
                    baseNewComment3.setFav(baseNewComment3.getFav() + 1);
                    this.Q.setFav_state(1);
                    this.G.notifyItemChanged(this.P);
                    this.P = -1;
                    this.Q = null;
                    break;
                }
                break;
            case 848:
                ReplyArrBean replyArrBean = (ReplyArrBean) message.f21202x;
                if (replyArrBean != null && this.T >= 0 && this.Q != null) {
                    String str2 = "add_reply_position：" + this.T;
                    List<ReplyArrBean> reply_arr = this.Q.getReply_arr();
                    if (reply_arr == null) {
                        reply_arr = new ArrayList<>();
                    }
                    if (reply_arr.size() >= 5) {
                        reply_arr.remove(0);
                    }
                    reply_arr.add(replyArrBean);
                    this.Q.setReply_arr(reply_arr);
                    BaseNewComment baseNewComment4 = this.Q;
                    baseNewComment4.setReply_count(baseNewComment4.getReply_count() + 1);
                    this.G.notifyItemChanged(this.T);
                    this.T = -1;
                    com.amgcyo.cuttadon.view.comment.c cVar2 = this.U;
                    if (cVar2 != null) {
                        cVar2.dismiss();
                        this.U = null;
                    }
                    break;
                }
                break;
            case 849:
                ReplyArrBean replyArrBean2 = (ReplyArrBean) message.f21202x;
                if (replyArrBean2 != null && (baseNewComment = this.Q) != null && this.R >= 0) {
                    List<ReplyArrBean> reply_arr2 = baseNewComment.getReply_arr();
                    if (!com.amgcyo.cuttadon.utils.otherutils.g.a(reply_arr2)) {
                        reply_arr2.remove(replyArrBean2);
                        if (reply_arr2.size() == 0) {
                            this.Q.setReply_arr(null);
                        } else {
                            this.Q.setReply_arr(reply_arr2);
                        }
                        BaseNewComment baseNewComment5 = this.Q;
                        baseNewComment5.setReply_count(baseNewComment5.getReply_count() - 1);
                        this.G.notifyItemChanged(this.R);
                        this.R = -1;
                        this.Q = null;
                        this.recyclerView.requestLayout();
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void i() {
        super.i();
        onRefresh();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.G = new com.amgcyo.cuttadon.b.c.r(this.M, this.f3728w, this, 0);
        this.G.a(this.recyclerView);
        this.G.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.fragment.books.b0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.o();
            }
        }, this.recyclerView);
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void likeCommentOperation(@NonNull BaseNewComment baseNewComment, int i2) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
        } else {
            if (baseNewComment.getFav_state() == 1) {
                showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.cannot_like_agian));
                return;
            }
            this.P = i2;
            this.Q = baseNewComment;
            ((BookPresenter) this.f3726u).F(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id()), Integer.valueOf(mkUserJ.getUser_id())}));
        }
    }

    public /* synthetic */ void o() {
        String str = "加载更多: " + this.H;
        p();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.amgcyo.cuttadon.view.comment.c cVar = this.U;
        if (cVar != null) {
            cVar.dismiss();
            this.U = null;
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        this.H = 1;
        p();
    }

    public void p() {
        ((BookPresenter) this.f3726u).B(Message.a(this, new Object[]{Integer.valueOf(this.H), Integer.valueOf(this.K), Integer.valueOf(this.L)}));
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void submitOrDeleteComment(@NonNull BaseNewComment baseNewComment, int i2) {
        if (baseNewComment.isLoginUser()) {
            this.S = i2;
            ((BookPresenter) this.f3726u).e(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id())}));
            return;
        }
        this.T = i2;
        this.Q = baseNewComment;
        a("回复 " + baseNewComment.getNick() + " :", baseNewComment.getComment_id(), 0, false);
    }

    public static x0 a(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("book_id", i2);
        bundle.putInt("comment_sort_type", i3);
        x0 x0Var = new x0();
        x0Var.setArguments(bundle);
        return x0Var;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    private void a(List<BaseNewComment> list) {
        NormalAdParams normalAdParamsA;
        if (this.O <= 0 || !com.amgcyo.cuttadon.utils.otherutils.g.b(list)) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != 0 && i2 % this.O == 0 && (normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_comment_lists", "csj_new_position_lists")) != null) {
                list.add(i2, new BaseNewComment(normalAdParamsA, 1));
            }
        }
    }

    private void a(List<BaseNewComment> list, int i2) {
        if (this.H == 1) {
            this.M.clear();
            for (BaseNewComment baseNewComment : list) {
                baseNewComment.setItemType(2);
                this.M.add(baseNewComment);
            }
            a(this.M);
            this.G.b((Collection) this.M);
        } else {
            this.N.clear();
            for (BaseNewComment baseNewComment2 : list) {
                baseNewComment2.setItemType(2);
                this.N.add(baseNewComment2);
            }
            a(this.N);
            this.G.a((Collection) this.N);
        }
        this.G.m();
        if (list.size() >= i2) {
            this.H++;
        } else {
            this.G.n();
        }
    }

    private void a(final ReplyArrBean replyArrBean) {
        com.amgcyo.cuttadon.f.o.a(this.f3725t, "提示", "是否删除本条评论?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3804s.a(replyArrBean, view);
            }
        }, (View.OnClickListener) null);
    }

    public /* synthetic */ void a(ReplyArrBean replyArrBean, View view) {
        ((BookPresenter) this.f3726u).f(Message.a(this, new Object[]{replyArrBean}));
    }

    private void a(String str, int i2, int i3, boolean z2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
            return;
        }
        com.amgcyo.cuttadon.view.comment.c cVar = new com.amgcyo.cuttadon.view.comment.c(getActivity());
        cVar.a(str);
        cVar.a(new a(i2, i3, z2));
        this.U = cVar;
        this.U.show();
    }
}
