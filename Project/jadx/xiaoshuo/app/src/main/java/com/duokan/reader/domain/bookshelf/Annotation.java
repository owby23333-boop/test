package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.common.BookFormat;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.PointAnchor;
import com.yuewen.bc;
import com.yuewen.cs0;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Annotation implements Serializable {
    private String bodyJsonString;
    private long mAddedDate;
    private String mAnnotationUuid;
    private long mBookId;
    private PointAnchor mEndAnchor;
    private long mId;
    private long mModifiedDate;
    private String mSample;
    private PointAnchor mStartAnchor;

    public static Annotation newAnnotation(AnnotationType annotationType, String str) {
        if (annotationType == AnnotationType.BOOKMARK) {
            return newBookmark(str);
        }
        if (annotationType == AnnotationType.COMMENT) {
            return newComment(str);
        }
        if (annotationType == AnnotationType.IDEA) {
            return newIdea(str);
        }
        return null;
    }

    public static Annotation newBookmark(String str) {
        Bookmark bookmark = new Bookmark();
        bookmark.setAddedDate(System.currentTimeMillis());
        bookmark.setModifiedDate(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        bookmark.setAnnotationUuid(str);
        return bookmark;
    }

    public static Annotation newComment(String str) {
        Comment comment = new Comment();
        comment.setAddedDate(System.currentTimeMillis());
        comment.setModifiedDate(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        comment.setAnnotationUuid(str);
        return comment;
    }

    public static Annotation newIdea(String str) {
        Idea idea = new Idea();
        long jCurrentTimeMillis = System.currentTimeMillis();
        idea.setAddedDate(jCurrentTimeMillis);
        idea.setModifiedDate(jCurrentTimeMillis);
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        idea.setAnnotationUuid(str);
        return idea;
    }

    public void changeStringToAnchors(BookFormat bookFormat, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mStartAnchor = cs0.c().a(bookFormat, 0L, 0L, 0L, 0L);
            this.mEndAnchor = cs0.c().a(bookFormat, 0L, 0L, 0L, 0L);
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            JSONObject jSONObject2 = jSONArray.getJSONObject(1);
            this.mStartAnchor = bc.a().b(bookFormat, jSONObject);
            this.mEndAnchor = bc.a().b(bookFormat, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public abstract Annotation copy();

    public long getAddedDate() {
        return this.mAddedDate;
    }

    public String getAnnotationUuid() {
        return this.mAnnotationUuid;
    }

    public String getBodyJsonString() {
        return "";
    }

    public long getBookId() {
        return this.mBookId;
    }

    public PointAnchor getEndAnchor() {
        return this.mEndAnchor;
    }

    public long getId() {
        return this.mId;
    }

    public long getModifiedDate() {
        return this.mModifiedDate;
    }

    public String getOriginalSample() {
        return this.mSample;
    }

    public String getRangeJsonString() {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, this.mStartAnchor.toJson());
            jSONArray.put(1, this.mEndAnchor.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public String getSample(boolean z) {
        return z ? DkUtils.chs2chtText(getOriginalSample()) : getOriginalSample();
    }

    public PointAnchor getStartAnchor() {
        return this.mStartAnchor;
    }

    public abstract AnnotationType getType();

    public void setAddedDate(long j) {
        this.mAddedDate = j;
    }

    public void setAnnotationUuid(String str) {
        this.mAnnotationUuid = str;
    }

    public void setBodyJsonString(String str) {
    }

    public void setBookId(long j) {
        this.mBookId = j;
    }

    public void setEndAnchor(PointAnchor pointAnchor) {
        this.mEndAnchor = pointAnchor;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setModifiedDate(long j) {
        this.mModifiedDate = j;
    }

    public void setSample(String str) {
        this.mSample = str;
    }

    public void setStartAnchor(PointAnchor pointAnchor) {
        this.mStartAnchor = pointAnchor;
    }
}
