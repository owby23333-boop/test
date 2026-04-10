package com.amgcyo.cuttadon.activity.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetail;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetailBean;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.comment.FavArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.comment.CommentFlowLayout;
import com.amgcyo.cuttadon.view.comment.c;
import com.amgcyo.cuttadon.view.dialog.l1;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkCommentDetailActivity extends BaseRefreshMoreRecyclerActivity<BookPresenter> implements com.amgcyo.cuttadon.g.c {
    private BaseNewComment C0;
    com.amgcyo.cuttadon.view.comment.c D0;
    com.amgcyo.cuttadon.view.comment.c E0;

    @BindView(R.id.comment_edit_image)
    ImageView commentEditImage;

    @BindView(android.R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    int f2833r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    View f2834s0;

    @BindView(R.id.tv_comment_list_edittext)
    TextView tv_comment_list_edittext;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    CommentDetailBean f2837v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    CommentFlowLayout f2838w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    List<FavArrBean> f2839x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    TextView f2840y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f2841z0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    List<BaseNewComment> f2835t0 = new ArrayList();

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    List<BaseNewComment> f2836u0 = new ArrayList();
    private int A0 = -1;
    private int B0 = -1;

    class a implements c.InterfaceC0115c {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2842c;

        a(int i2, int i3, boolean z2) {
            this.a = i2;
            this.b = i3;
            this.f2842c = z2;
        }

        @Override // com.amgcyo.cuttadon.view.comment.c.InterfaceC0115c
        public void a(String str) {
            MkCommentDetailActivity.this.showLoading(com.amgcyo.cuttadon.f.o.d(R.string.submiting));
            ((BookPresenter) ((BaseTitleBarActivity) MkCommentDetailActivity.this).f2276v).H(Message.a(MkCommentDetailActivity.this.a(), new Object[]{Integer.valueOf(this.a), str, Integer.valueOf(this.b), Boolean.valueOf(this.f2842c)}));
        }
    }

    private void r() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        com.amgcyo.cuttadon.view.comment.c cVar = new com.amgcyo.cuttadon.view.comment.c(this);
        cVar.a(" 回复楼主 ");
        cVar.a(new c.InterfaceC0115c() { // from class: com.amgcyo.cuttadon.activity.setting.o
            @Override // com.amgcyo.cuttadon.view.comment.c.InterfaceC0115c
            public final void a(String str) {
                this.a.e(str);
            }
        });
        this.E0 = cVar;
        this.E0.show();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void addReplyComment(@NonNull BaseNewComment baseNewComment, ReplyArrBean replyArrBean, int i2, int i3) {
    }

    public /* synthetic */ void b(BaseNewComment baseNewComment, View view) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            r0.a(this.f2277w, true);
        } else if (baseNewComment.getFav_state() != 1) {
            ((BookPresenter) this.f2276v).F(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id()), Integer.valueOf(mkUserJ.getUser_id())}));
        } else {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.cannot_like_agian));
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "评论详情";
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void deleteReplyComment(@NonNull BaseNewComment baseNewComment, @NonNull ReplyArrBean replyArrBean, int i2) {
    }

    public /* synthetic */ void e(String str) {
        showLoading(com.amgcyo.cuttadon.f.o.d(R.string.submiting));
        ((BookPresenter) this.f2276v).H(Message.a(a(), new Object[]{Integer.valueOf(this.f2833r0), str, 0, false}));
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void gotoCommentDeiailPage(@NonNull BaseNewComment baseNewComment) {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        BaseNewComment comment;
        BaseQuickAdapter baseQuickAdapter;
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 825) {
            this.f2837v0 = (CommentDetailBean) message.f21202x;
            this.f2257o0 = this.f2837v0.getLimit();
            c(false);
            d(false);
            CommentDetail lists = this.f2837v0.getLists();
            if (lists == null || (comment = lists.getComment()) == null) {
                return;
            }
            String str = comment.getContent() + " == " + this.f2257o0;
            if (this.f2256n0.c() == 0) {
                this.f2834s0 = a(comment);
                this.f2256n0.b(this.f2834s0);
            }
            List<BaseNewComment> comment_reply_list = lists.getComment_reply_list();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(comment_reply_list)) {
                if (this.f2840y0 != null) {
                    int iA = me.jessyan.art.f.e.a(this, 10.0f);
                    com.amgcyo.cuttadon.f.o.a(this.f2840y0, iA, iA, iA, iA);
                    this.f2841z0 = comment_reply_list.size();
                    this.f2840y0.setText(String.format(Locale.getDefault(), "共%d条回复", Integer.valueOf(this.f2841z0)));
                    this.f2835t0.addAll(comment_reply_list);
                    a(comment_reply_list, this.f2257o0);
                    return;
                }
                return;
            }
            if (this.f2840y0 == null || (baseQuickAdapter = this.f2256n0) == null) {
                return;
            }
            if (this.pageNo != 1) {
                baseQuickAdapter.m();
                this.f2256n0.n();
                return;
            }
            int iA2 = me.jessyan.art.f.e.a(this, 20.0f);
            com.amgcyo.cuttadon.f.o.a(this.f2840y0, iA2, iA2, iA2, iA2);
            this.f2840y0.setText(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.no_comment));
            this.f2835t0.clear();
            this.f2256n0.notifyDataSetChanged();
            return;
        }
        if (i2 == 826) {
            PullToRefreshView pullToRefreshView = this.mRefreshView;
            if (pullToRefreshView != null) {
                pullToRefreshView.setRefreshing(false);
            }
            showMessage("请求出现错误,请重试!");
            return;
        }
        if (i2 == 870) {
            hideLoading();
            com.amgcyo.cuttadon.view.comment.c cVar = this.E0;
            if (cVar != null) {
                cVar.dismiss();
                this.E0 = null;
            }
            com.amgcyo.cuttadon.view.comment.c cVar2 = this.D0;
            if (cVar2 != null) {
                cVar2.dismiss();
                this.D0 = null;
                return;
            }
            return;
        }
        switch (i2) {
            case 846:
                finish();
                break;
            case 847:
                String str2 = this.C0.getContent() + " == " + this.B0;
                BaseNewComment baseNewComment = this.C0;
                if (baseNewComment != null && this.B0 != -1) {
                    baseNewComment.setFav(baseNewComment.getFav() + 1);
                    this.C0.setFav_state(1);
                    this.f2256n0.notifyItemChanged(this.B0);
                    this.B0 = -1;
                    this.C0 = null;
                    break;
                }
                break;
            case 848:
                hideLoading();
                if (((ReplyArrBean) message.f21202x) != null) {
                    this.pageNo = 1;
                    loadData();
                    com.amgcyo.cuttadon.view.comment.c cVar3 = this.E0;
                    if (cVar3 != null) {
                        cVar3.dismiss();
                        this.E0 = null;
                    }
                    com.amgcyo.cuttadon.view.comment.c cVar4 = this.D0;
                    if (cVar4 != null) {
                        cVar4.dismiss();
                        this.D0 = null;
                    }
                    break;
                }
                break;
            case 849:
                BaseNewComment baseNewComment2 = (BaseNewComment) message.f21202x;
                if (baseNewComment2 != null && this.A0 > -1 && this.f2256n0 != null) {
                    String str3 = baseNewComment2.getReply_comment_id() + " === " + baseNewComment2.getContent() + " deletePosition: " + this.A0;
                    this.f2256n0.d(this.A0);
                    this.f2256n0.notifyItemChanged(this.A0);
                    int itemCount = this.f2256n0.getItemCount();
                    int iC = this.f2256n0.c();
                    int iB = this.f2256n0.b();
                    String str4 = "itemCount:" + itemCount + "  headerLayoutCount: " + iC + "  footerLayoutCount: " + iB;
                    int i3 = (itemCount - iC) - iB;
                    String str5 = "itemCount:" + i3;
                    if (i3 <= 1 && this.f2840y0 != null) {
                        int iA3 = me.jessyan.art.f.e.a(this, 20.0f);
                        com.amgcyo.cuttadon.f.o.a(this.f2840y0, iA3, iA3, iA3, iA3);
                        this.f2840y0.setText(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.no_comment));
                        this.f2835t0.clear();
                        this.f2256n0.notifyDataSetChanged();
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2833r0 = extras.getInt("comment_id");
        this.f2256n0 = new com.amgcyo.cuttadon.b.c.r(this.f2835t0, this.G, this, 8);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.setting.p
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_ment_detail;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void likeCommentOperation(@NonNull BaseNewComment baseNewComment, int i2) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            r0.a(this.f2277w, true);
            return;
        }
        String str = "comment.getComment_id(): " + baseNewComment.getComment_id();
        String str2 = "comment.getReply_comment_id(): " + baseNewComment.getReply_comment_id();
        if (baseNewComment.getFav_state() == 1) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.cannot_like_agian));
            return;
        }
        this.B0 = i2;
        this.C0 = baseNewComment;
        ((BookPresenter) this.f2276v).G(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getReply_comment_id()), Integer.valueOf(mkUserJ.getUser_id())}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ((BookPresenter) this.f2276v).A(Message.a(this, new Object[]{Integer.valueOf(this.pageNo), Integer.valueOf(this.f2833r0)}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.amgcyo.cuttadon.view.comment.c cVar = this.E0;
        if (cVar != null) {
            cVar.dismiss();
            this.E0 = null;
        }
        com.amgcyo.cuttadon.view.comment.c cVar2 = this.D0;
        if (cVar2 != null) {
            cVar2.dismiss();
            this.D0 = null;
        }
    }

    @OnClick({R.id.fb_comment, R.id.tv_comment_list_edittext})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.fb_comment) {
            r();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        String str = "加载更多: " + this.pageNo;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void submitOrDeleteComment(@NonNull final BaseNewComment baseNewComment, final int i2) {
        int reply_comment_id = baseNewComment.getReply_comment_id();
        if (baseNewComment.isLoginUser()) {
            com.amgcyo.cuttadon.f.o.a(a(), "提示", "是否删除本条评论?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2878s.a(i2, baseNewComment, view);
                }
            }, (View.OnClickListener) null);
            return;
        }
        this.C0 = baseNewComment;
        a("回复 " + baseNewComment.getNick() + " :", baseNewComment.getComment_id(), reply_comment_id, false);
    }

    private void a(List<BaseNewComment> list, int i2) {
        if (this.pageNo == 1) {
            this.f2835t0.clear();
            for (BaseNewComment baseNewComment : list) {
                baseNewComment.setItemType(2);
                this.f2835t0.add(baseNewComment);
            }
            this.f2256n0.b((Collection) this.f2835t0);
        } else {
            this.f2836u0.clear();
            for (BaseNewComment baseNewComment2 : list) {
                baseNewComment2.setItemType(2);
                this.f2836u0.add(baseNewComment2);
            }
            this.f2256n0.a((Collection) this.f2836u0);
        }
        this.f2256n0.m();
        if (list.size() >= i2) {
            this.pageNo++;
        } else {
            this.f2256n0.n();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }

    private View a(final BaseNewComment baseNewComment) {
        View viewInflate = getLayoutInflater().inflate(R.layout.comment_head_layout, (ViewGroup) this.mRecyclerView.getParent(), false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.comment_user_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.comment_user_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.comment_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.comment_time);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.comment_delete);
        this.f2838w0 = (CommentFlowLayout) viewInflate.findViewById(R.id.flow_layout);
        this.f2840y0 = (TextView) viewInflate.findViewById(R.id.tv_replay_status);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.comment_like_count);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.comment_like_btn);
        if (baseNewComment.isLoginUser()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2871s.a(baseNewComment, view);
                }
            });
        } else {
            textView4.setVisibility(8);
        }
        textView2.setText(baseNewComment.getContent());
        textView3.setText(baseNewComment.getCreated_at());
        if (baseNewComment.getNick() != null && !TextUtils.isEmpty(baseNewComment.getNick())) {
            textView.setText(baseNewComment.getNick());
        }
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.b(baseNewComment.getAvatar());
        if (com.amgcyo.cuttadon.a.f2254e.intValue() == 1 && com.amgcyo.cuttadon.utils.otherutils.g.s(strB)) {
            this.G.a(this.f2277w, ImageConfigImpl.builder().isCircle(true).fallback(R.drawable.user_avatar).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).resId(R.drawable.user_avatar).imageView(imageView).build());
        } else {
            a(imageView, strB);
        }
        if (baseNewComment.getFav() > 0) {
            textView5.setVisibility(0);
            textView5.setText(com.amgcyo.cuttadon.utils.otherutils.g.a(baseNewComment.getFav()));
        } else {
            textView5.setVisibility(0);
            textView5.setText(com.amgcyo.cuttadon.utils.otherutils.g.a(0L));
        }
        if (baseNewComment.getFav_state() == 1) {
            imageView2.setImageResource(R.drawable.ic_praise_pressed);
            imageView2.setColorFilter(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary));
        } else {
            imageView2.setImageResource(R.drawable.ic_praise_normal);
        }
        this.f2839x0 = baseNewComment.getFav_arr();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2881s.b(baseNewComment, view);
            }
        });
        final ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.comment_more);
        a(imageView3);
        final String[] strArr = {"举报"};
        final a.b bVar = new a.b(a());
        bVar.b(imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2873s.a(bVar, imageView3, strArr, baseNewComment, view);
            }
        });
        a(this.f2839x0);
        return viewInflate;
    }

    public /* synthetic */ void a(BaseNewComment baseNewComment, View view) {
        try {
            ((BookPresenter) this.f2276v).e(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id())}));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(a.b bVar, ImageView imageView, String[] strArr, final BaseNewComment baseNewComment, View view) {
        com.lxj.xpopup.a.a(view);
        bVar.b(imageView.getHeight() / 2);
        bVar.a(strArr, null, new com.lxj.xpopup.c.f() { // from class: com.amgcyo.cuttadon.activity.setting.r
            @Override // com.lxj.xpopup.c.f
            public final void a(int i2, String str) {
                this.a.a(baseNewComment, i2, str);
            }
        }).u();
    }

    public /* synthetic */ void a(final BaseNewComment baseNewComment, int i2, String str) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        l1 l1Var = new l1(this.f2277w);
        l1Var.show();
        l1Var.a(new l1.a() { // from class: com.amgcyo.cuttadon.activity.setting.n
            @Override // com.amgcyo.cuttadon.view.dialog.l1.a
            public final void a(CommentReprotType commentReprotType) {
                this.a.a(baseNewComment, commentReprotType);
            }
        });
    }

    public /* synthetic */ void a(BaseNewComment baseNewComment, CommentReprotType commentReprotType) {
        commentReprotType.setComment_id(baseNewComment.getComment_id());
        commentReprotType.setComment_reply_id(baseNewComment.getReply_comment_id());
        Context context = this.f2277w;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).submitCommentReprot(commentReprotType);
        } else {
            l.b.a.j.a((CharSequence) "参数异常！");
        }
    }

    private void a(ImageView imageView) {
        new com.amgcyo.cuttadon.view.showcaseview.h().a(300L);
        com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(a(), "tip_comment_report");
        fVar.a(com.amgcyo.cuttadon.f.o.a(a(), imageView, "点击这里可以对不良评论进行举报哦~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, null));
        fVar.b();
    }

    private void a(ImageView imageView, String str) {
        this.G.a(this.f2277w, ImageConfigImpl.builder().isCircle(true).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).url(str).imageView(imageView).build());
    }

    private void a(List<FavArrBean> list) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FavArrBean> it = list.iterator();
        while (it.hasNext()) {
            String avatar = it.next().getAvatar();
            if (!TextUtils.isEmpty(avatar)) {
                arrayList.add(com.amgcyo.cuttadon.utils.otherutils.g.b(avatar));
            }
        }
        this.f2838w0.a(arrayList, this.G);
    }

    public /* synthetic */ void a(int i2, BaseNewComment baseNewComment, View view) {
        this.A0 = i2 - this.f2256n0.c();
        ((BookPresenter) this.f2276v).g(Message.a(this, new Object[]{baseNewComment}));
    }

    private void a(String str, int i2, int i3, boolean z2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        com.amgcyo.cuttadon.view.comment.c cVar = new com.amgcyo.cuttadon.view.comment.c(this);
        cVar.a(str);
        cVar.a(new a(i2, i3, z2));
        this.D0 = cVar;
        this.D0.show();
    }
}
