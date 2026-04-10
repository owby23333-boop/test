package com.amgcyo.cuttadon.api.entity.comment;

import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.chad.library.adapter.base.d.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseNewComment extends BaseCommentBean implements b {
    public static final int AD = 1;
    public static final int COMMENTS = 2;
    private NormalAdParams adParams;
    private int fav;
    private List<FavArrBean> fav_arr;
    private int fav_state;
    private boolean floor_host;
    private int itemType;
    private List<ReplyArrBean> reply_arr;
    private int reply_comment_id;
    private ReplyToCommentBean reply_to_comment;

    public BaseNewComment(NormalAdParams normalAdParams, int i2) {
        this.adParams = normalAdParams;
        this.itemType = i2;
    }

    public NormalAdParams getAdParams() {
        return this.adParams;
    }

    public int getFav() {
        return this.fav;
    }

    public List<FavArrBean> getFav_arr() {
        return this.fav_arr;
    }

    public int getFav_state() {
        return this.fav_state;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public List<ReplyArrBean> getReply_arr() {
        return this.reply_arr;
    }

    public int getReply_comment_id() {
        return this.reply_comment_id;
    }

    public ReplyToCommentBean getReply_to_comment() {
        return this.reply_to_comment;
    }

    public boolean isFloor_host() {
        return this.floor_host;
    }

    public void setAdParams(NormalAdParams normalAdParams) {
        this.adParams = normalAdParams;
    }

    public void setFav(int i2) {
        this.fav = i2;
    }

    public void setFav_arr(List<FavArrBean> list) {
        this.fav_arr = list;
    }

    public void setFav_state(int i2) {
        this.fav_state = i2;
    }

    public void setFloor_host(boolean z2) {
        this.floor_host = z2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setReply_arr(List<ReplyArrBean> list) {
        this.reply_arr = list;
    }

    public void setReply_comment_id(int i2) {
        this.reply_comment_id = i2;
    }

    public void setReply_to_comment(ReplyToCommentBean replyToCommentBean) {
        this.reply_to_comment = replyToCommentBean;
    }

    public BaseNewComment(int i2) {
        this.itemType = i2;
    }

    public BaseNewComment() {
    }
}
