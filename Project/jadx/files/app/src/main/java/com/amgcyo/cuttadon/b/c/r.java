package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.comment.FavArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyToCommentBean;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.amgcyo.cuttadon.view.comment.CommentFlowLayout;
import com.amgcyo.cuttadon.view.comment.CommentsView;
import com.amgcyo.cuttadon.view.dialog.l1;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkCommentListMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends com.chad.library.adapter.base.a<BaseNewComment, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;
    private com.amgcyo.cuttadon.g.c M;
    private int N;

    public r(List<BaseNewComment> list, me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.g.c cVar2, int i2) {
        super(list);
        this.L = cVar;
        this.M = cVar2;
        this.N = i2;
        b(1, R.layout.book_city_item_adview);
        b(2, R.layout.item_list_comment);
    }

    private void b(com.chad.library.adapter.base.b bVar, final BaseNewComment baseNewComment) {
        int i2;
        final int adapterPosition = bVar.getAdapterPosition();
        RelativeLayout relativeLayout = (RelativeLayout) bVar.a(R.id.ll_have_comment);
        ImageView imageView = (ImageView) bVar.a(R.id.comment_user_icon);
        TextView textView = (TextView) bVar.a(R.id.comment_user_name);
        TextView textView2 = (TextView) bVar.a(R.id.comment_content);
        TextView textView3 = (TextView) bVar.a(R.id.comment_time);
        TextView textView4 = (TextView) bVar.a(R.id.comment_like_count);
        ImageView imageView2 = (ImageView) bVar.a(R.id.comment_like_btn);
        TextView textView5 = (TextView) bVar.a(R.id.tv_replay);
        CommentFlowLayout commentFlowLayout = (CommentFlowLayout) bVar.a(R.id.flow_layout);
        CommentsView commentsView = (CommentsView) bVar.a(R.id.commentView);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lv_new_layout);
        LinearLayout linearLayout2 = (LinearLayout) bVar.a(R.id.lv_like);
        LinearLayout linearLayout3 = (LinearLayout) bVar.a(R.id.lv_comment_list);
        ImageView imageView3 = (ImageView) bVar.a(R.id.comment_coment_btn);
        TextView textView6 = (TextView) bVar.a(R.id.like_count);
        TextView textView7 = (TextView) bVar.a(R.id.tv_floor);
        TextView textView8 = (TextView) bVar.a(R.id.tv_repay_floor);
        TextView textView9 = (TextView) bVar.a(R.id.comment_reply_user_name);
        SimpleRatingBar simpleRatingBar = (SimpleRatingBar) bVar.a(R.id.rat_bar_score);
        int score = baseNewComment.getScore();
        if (score > 0) {
            simpleRatingBar.setVisibility(0);
            simpleRatingBar.setRating(score);
        } else {
            simpleRatingBar.setVisibility(8);
        }
        textView2.setText(baseNewComment.getContent());
        textView3.setText(baseNewComment.getCreated_at());
        textView.setVisibility(0);
        textView.setText(baseNewComment.getNick());
        String avatar = baseNewComment.getAvatar();
        if (com.amgcyo.cuttadon.a.f2254e.intValue() == 1 && com.amgcyo.cuttadon.utils.otherutils.g.s(avatar)) {
            this.L.a(bVar.itemView.getContext(), ImageConfigImpl.builder().isCircle(true).fallback(R.drawable.user_avatar).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).resId(R.drawable.user_avatar).imageView(imageView).build());
        } else {
            a(bVar, imageView, avatar);
        }
        if (baseNewComment.getFav() > 0) {
            textView4.setVisibility(0);
            textView4.setText(String.format(Locale.getDefault(), "%d人点赞过", Integer.valueOf(baseNewComment.getFav())));
        } else {
            textView4.setVisibility(4);
        }
        if (baseNewComment.getFav_state() == 1) {
            imageView2.setImageResource(R.drawable.ic_praise_pressed);
            imageView2.setColorFilter(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary));
        } else {
            imageView2.setImageResource(R.drawable.ic_praise_normal);
            imageView2.clearColorFilter();
        }
        if (baseNewComment.getReply_count() > 0) {
            textView5.setText(String.format(Locale.getDefault(), "查看全部共%d条回复", Integer.valueOf(baseNewComment.getReply_count())));
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3611s.a(baseNewComment, view);
                }
            });
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3602s.a(baseNewComment, adapterPosition, view);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3608s.b(baseNewComment, adapterPosition, view);
            }
        });
        List<FavArrBean> fav_arr = baseNewComment.getFav_arr();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(fav_arr)) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            Iterator<FavArrBean> it = fav_arr.iterator();
            while (it.hasNext()) {
                String avatar2 = it.next().getAvatar();
                if (!TextUtils.isEmpty(avatar2)) {
                    arrayList.add(com.amgcyo.cuttadon.utils.otherutils.g.b(avatar2));
                }
            }
            commentFlowLayout.a(arrayList, this.L);
        }
        List<ReplyArrBean> reply_arr = baseNewComment.getReply_arr();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(reply_arr)) {
            i2 = 8;
            linearLayout.setVisibility(8);
            linearLayout3.setVisibility(8);
            commentsView.setList(null);
            commentsView.a();
        } else {
            linearLayout.setVisibility(0);
            linearLayout3.setVisibility(0);
            commentsView.setList(reply_arr);
            commentsView.setOnItemClickListener(new a(baseNewComment, adapterPosition));
            commentsView.a();
            i2 = 8;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(fav_arr) && com.amgcyo.cuttadon.utils.otherutils.g.a(reply_arr)) {
            linearLayout.setVisibility(i2);
        } else {
            linearLayout.setVisibility(0);
        }
        if (this.N == 0) {
            textView6.setVisibility(i2);
            textView7.setVisibility(i2);
            textView8.setVisibility(i2);
            textView9.setVisibility(i2);
            imageView3.setVisibility(this.N);
            if (baseNewComment.isLoginUser()) {
                imageView3.setImageResource(R.drawable.delete_comment);
            } else {
                imageView3.setImageResource(R.drawable.list_comment_btn);
            }
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3605s.c(baseNewComment, adapterPosition, view);
                }
            });
        } else {
            textView6.setVisibility(0);
            textView6.setText(com.amgcyo.cuttadon.utils.otherutils.g.b(baseNewComment.getFav()));
            imageView3.setVisibility(this.N);
            com.amgcyo.cuttadon.f.o.a(imageView2, 0, 0, me.jessyan.art.f.e.a(this.f14735w, 5.0f), 0);
            ReplyToCommentBean reply_to_comment = baseNewComment.getReply_to_comment();
            int color = this.f14735w.getResources().getColor(R.color.colorPrimary);
            if (baseNewComment.isLoginUser()) {
                textView.setTextColor(color);
            } else {
                textView.setTextColor(this.f14735w.getResources().getColor(R.color.text_33));
            }
            if (baseNewComment.isFloor_host()) {
                textView7.setVisibility(0);
            } else {
                textView7.setVisibility(8);
            }
            if (reply_to_comment != null) {
                new SpannableString("  回复  " + reply_to_comment.getNick()).setSpan(new ForegroundColorSpan(color), 6, reply_to_comment.getNick().length() + 6, 34);
                textView9.setText(String.format("%s%s", "  回复  ", reply_to_comment.getNick()));
                if (reply_to_comment.isFloor_host()) {
                    textView8.setVisibility(0);
                } else {
                    textView8.setVisibility(8);
                }
            }
        }
        final ImageView imageView4 = (ImageView) bVar.a(R.id.comment_more);
        final String[] strArr = {"举报"};
        final a.b bVar2 = new a.b(this.f14735w);
        bVar2.b(imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3597s.a(bVar2, imageView4, strArr, baseNewComment, view);
            }
        });
    }

    public /* synthetic */ void c(BaseNewComment baseNewComment, int i2, View view) {
        com.amgcyo.cuttadon.g.c cVar = this.M;
        if (cVar != null) {
            cVar.submitOrDeleteComment(baseNewComment, i2);
        }
    }

    /* JADX INFO: compiled from: MkCommentListMuiltQa.java */
    class a implements CommentsView.d {
        final /* synthetic */ BaseNewComment a;
        final /* synthetic */ int b;

        a(BaseNewComment baseNewComment, int i2) {
            this.a = baseNewComment;
            this.b = i2;
        }

        @Override // com.amgcyo.cuttadon.view.comment.CommentsView.d
        public void a(int i2, ReplyArrBean replyArrBean, int i3) {
            if (r.this.M != null) {
                r.this.M.addReplyComment(this.a, replyArrBean, i2, i3);
            }
        }

        @Override // com.amgcyo.cuttadon.view.comment.CommentsView.d
        public void a(ReplyArrBean replyArrBean) {
            if (r.this.M != null) {
                r.this.M.deleteReplyComment(this.a, replyArrBean, this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, BaseNewComment baseNewComment) {
        int itemViewType = bVar.getItemViewType();
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            b(bVar, baseNewComment);
        } else {
            AdFrameLayout adFrameLayout = (AdFrameLayout) bVar.a(R.id.fl_ad);
            NormalAdParams adParams = baseNewComment.getAdParams();
            if (adParams != null) {
                adParams.setSelfAdPosition(com.amgcyo.cuttadon.f.n.J);
            }
            adFrameLayout.b(adParams);
        }
    }

    public /* synthetic */ void a(BaseNewComment baseNewComment, View view) {
        com.amgcyo.cuttadon.g.c cVar = this.M;
        if (cVar != null) {
            cVar.gotoCommentDeiailPage(baseNewComment);
        }
    }

    public /* synthetic */ void a(BaseNewComment baseNewComment, int i2, View view) {
        com.amgcyo.cuttadon.g.c cVar = this.M;
        if (cVar != null) {
            cVar.likeCommentOperation(baseNewComment, i2);
        }
    }

    public /* synthetic */ void a(a.b bVar, ImageView imageView, String[] strArr, final BaseNewComment baseNewComment, View view) {
        com.lxj.xpopup.a.a(view);
        bVar.b(imageView.getHeight() / 2);
        bVar.a(strArr, null, new com.lxj.xpopup.c.f() { // from class: com.amgcyo.cuttadon.b.c.h
            @Override // com.lxj.xpopup.c.f
            public final void a(int i2, String str) {
                this.a.a(baseNewComment, i2, str);
            }
        }).u();
    }

    public /* synthetic */ void a(final BaseNewComment baseNewComment, int i2, String str) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f14735w, true);
            return;
        }
        l1 l1Var = new l1(this.f14735w);
        l1Var.show();
        l1Var.a(new l1.a() { // from class: com.amgcyo.cuttadon.b.c.d
            @Override // com.amgcyo.cuttadon.view.dialog.l1.a
            public final void a(CommentReprotType commentReprotType) {
                this.a.a(baseNewComment, commentReprotType);
            }
        });
    }

    public /* synthetic */ void a(BaseNewComment baseNewComment, CommentReprotType commentReprotType) {
        commentReprotType.setComment_id(baseNewComment.getComment_id());
        commentReprotType.setComment_reply_id(baseNewComment.getReply_comment_id());
        Context context = this.f14735w;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).submitCommentReprot(commentReprotType);
        } else {
            l.b.a.j.a((CharSequence) "参数异常！");
        }
    }

    private void a(com.chad.library.adapter.base.b bVar, ImageView imageView, String str) {
        this.L.a(bVar.itemView.getContext(), ImageConfigImpl.builder().isCircle(true).fallback(R.drawable.user_avatar).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).url(com.amgcyo.cuttadon.utils.otherutils.g.b(str)).imageView(imageView).build());
    }

    public /* synthetic */ void b(BaseNewComment baseNewComment, int i2, View view) {
        com.amgcyo.cuttadon.g.c cVar = this.M;
        if (cVar != null) {
            if (this.N == 0) {
                cVar.gotoCommentDeiailPage(baseNewComment);
            } else {
                cVar.submitOrDeleteComment(baseNewComment, i2);
            }
        }
    }
}
