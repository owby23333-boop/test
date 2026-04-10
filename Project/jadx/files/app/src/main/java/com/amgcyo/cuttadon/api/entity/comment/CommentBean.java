package com.amgcyo.cuttadon.api.entity.comment;

import com.amgcyo.cuttadon.api.entity.other.BaseLimit;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentBean extends BaseLimit {
    private List<BaseNewComment> lists;

    public List<BaseNewComment> getLists() {
        return this.lists;
    }

    public void setLists(List<BaseNewComment> list) {
        this.lists = list;
    }
}
