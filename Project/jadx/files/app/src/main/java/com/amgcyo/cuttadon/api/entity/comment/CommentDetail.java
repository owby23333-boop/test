package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentDetail implements Serializable {
    private BaseNewComment comment;
    private List<BaseNewComment> comment_reply_list;

    public BaseNewComment getComment() {
        return this.comment;
    }

    public List<BaseNewComment> getComment_reply_list() {
        return this.comment_reply_list;
    }

    public void setComment(BaseNewComment baseNewComment) {
        this.comment = baseNewComment;
    }

    public void setComment_reply_list(List<BaseNewComment> list) {
        this.comment_reply_list = list;
    }
}
