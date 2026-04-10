package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Entity(indices = {@Index(unique = true, value = {"art_id"})}, tableName = "MkCommentStatus")
public class MkCommentStatus implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int art_id;

    @ColumnInfo(name = "commentId")
    private int commentId;

    @ColumnInfo(name = "comment_fav_status")
    private int comment_fav_status;

    @ColumnInfo(name = "likeUserId")
    private int likeUserId;

    @Ignore
    public MkCommentStatus(int i2, int i3, int i4) {
        this.commentId = i2;
        this.comment_fav_status = i3;
        this.likeUserId = i4;
    }

    public int getArt_id() {
        return this.art_id;
    }

    public int getCommentId() {
        return this.commentId;
    }

    public int getComment_fav_status() {
        return this.comment_fav_status;
    }

    public int getLikeUserId() {
        return this.likeUserId;
    }

    public void setArt_id(int i2) {
        this.art_id = i2;
    }

    public void setCommentId(int i2) {
        this.commentId = i2;
    }

    public void setComment_fav_status(int i2) {
        this.comment_fav_status = i2;
    }

    public void setLikeUserId(int i2) {
        this.likeUserId = i2;
    }

    public MkCommentStatus() {
    }
}
