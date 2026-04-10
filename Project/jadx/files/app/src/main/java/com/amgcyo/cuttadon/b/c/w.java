package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.CentertCommentBean;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkMsgMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends com.chad.library.adapter.base.a<CentertCommentBean, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;

    public w(List<CentertCommentBean> list, me.jessyan.art.c.e.c cVar) {
        super(list);
        this.L = cVar;
        b(2, R.layout.item_msg_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, CentertCommentBean centertCommentBean) {
        Context context = bVar.itemView.getContext();
        ImageView imageView = (ImageView) bVar.a(R.id.comment_user_icon);
        TextView textView = (TextView) bVar.a(R.id.comment_user_name);
        TextView textView2 = (TextView) bVar.a(R.id.tv_other_comment);
        TextView textView3 = (TextView) bVar.a(R.id.comment_time);
        TextView textView4 = (TextView) bVar.a(R.id.tv_book);
        ((TextView) bVar.a(R.id.tv_my_comment)).setText(centertCommentBean.getComment_content());
        textView4.setText(String.format("《%s》", centertCommentBean.getBook_name()));
        textView.setText(centertCommentBean.getNick_name());
        if (TextUtils.isEmpty(centertCommentBean.getAvatar())) {
            imageView.setImageResource(R.drawable.user_avatar);
        } else {
            this.L.a(context, ImageConfigImpl.builder().isCircle(true).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.E(), centertCommentBean.getAvatar())).imageView(imageView).build());
        }
        textView3.setText(t0.a(centertCommentBean.getCreated_at(), "yyyy-MM-dd"));
        textView2.setText(centertCommentBean.getComment_reply_content());
        bVar.a(R.id.ll_have_comment);
        bVar.a(R.id.tv_book);
        bVar.a(R.id.tv_my_comment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, CentertCommentBean centertCommentBean) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, centertCommentBean);
    }
}
