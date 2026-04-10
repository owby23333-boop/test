package com.amgcyo.cuttadon.g;

import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;

/* JADX INFO: compiled from: CommentItemViewClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    void addReplyComment(@NonNull BaseNewComment baseNewComment, ReplyArrBean replyArrBean, int i2, int i3);

    void deleteReplyComment(@NonNull BaseNewComment baseNewComment, @NonNull ReplyArrBean replyArrBean, int i2);

    void gotoCommentDeiailPage(@NonNull BaseNewComment baseNewComment);

    void likeCommentOperation(@NonNull BaseNewComment baseNewComment, int i2);

    void submitOrDeleteComment(@NonNull BaseNewComment baseNewComment, int i2);
}
