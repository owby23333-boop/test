package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.domain.store.DkAnnotationBookInfo;
import com.yuewen.lp2;
import com.yuewen.yd;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudNoteBookInfo extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String mBookFormat;
    private final DkAnnotationBookInfo mBookInfo;
    private String mBookTitle;
    private final boolean mIsDuokanBook;

    public DkCloudNoteBookInfo(DkAnnotationBookInfo dkAnnotationBookInfo, boolean z) {
        super(dkAnnotationBookInfo.mVersion);
        this.mBookInfo = dkAnnotationBookInfo;
        if (z || TextUtils.isEmpty(dkAnnotationBookInfo.mBookName)) {
            this.mBookTitle = dkAnnotationBookInfo.mBookName;
            this.mBookFormat = "";
        } else {
            this.mBookTitle = lp2.x(dkAnnotationBookInfo.mBookName);
            this.mBookFormat = lp2.u(dkAnnotationBookInfo.mBookName).toUpperCase();
        }
        this.mIsDuokanBook = z;
    }

    public static boolean canCreateFromJson(JSONObject jSONObject) {
        return jSONObject.has("is_duokan_book");
    }

    public static DkCloudNoteBookInfo createFromJson(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_duokan_book");
        DkAnnotationBookInfo dkAnnotationBookInfo = new DkAnnotationBookInfo();
        dkAnnotationBookInfo.mBookUuid = jSONObject.optString("book_uuid");
        dkAnnotationBookInfo.mVersion = jSONObject.optLong("version");
        dkAnnotationBookInfo.mLastUpdateTime = new Date(jSONObject.optLong(yd.m.a.c));
        dkAnnotationBookInfo.mCommentCount = jSONObject.optInt("comment_count");
        dkAnnotationBookInfo.mIdeaCount = jSONObject.optInt("idea_count");
        dkAnnotationBookInfo.mBookmarkCount = jSONObject.optInt("bookmark_count");
        dkAnnotationBookInfo.mBookName = jSONObject.optString("name");
        dkAnnotationBookInfo.mAuthor = jSONObject.optString("author");
        dkAnnotationBookInfo.mEditor = jSONObject.optString("editor");
        dkAnnotationBookInfo.mCoverUrl = jSONObject.optString("cover");
        dkAnnotationBookInfo.mSerial = jSONObject.optBoolean("is_serial");
        return new DkCloudNoteBookInfo(dkAnnotationBookInfo, zOptBoolean);
    }

    public JSONObject convertToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_duokan_book", this.mIsDuokanBook);
            jSONObject.put("book_uuid", this.mBookInfo.mBookUuid);
            jSONObject.put("version", this.mBookInfo.mVersion);
            jSONObject.put(yd.m.a.c, this.mBookInfo.mLastUpdateTime.getTime());
            jSONObject.put("comment_count", this.mBookInfo.mCommentCount);
            jSONObject.put("idea_count", this.mBookInfo.mIdeaCount);
            jSONObject.put("bookmark_count", this.mBookInfo.mBookmarkCount);
            jSONObject.put("name", this.mBookInfo.mBookName);
            jSONObject.put("author", this.mBookInfo.mAuthor);
            jSONObject.put("editor", this.mBookInfo.mEditor);
            jSONObject.put("cover", this.mBookInfo.mCoverUrl);
            jSONObject.put("is_serial", this.mBookInfo.mSerial);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudJsonItem, com.duokan.reader.domain.cloud.DkCloudItem
    public void fillJsonObject(JSONObject jSONObject) throws JSONException {
    }

    public int getAnnotationCount() {
        DkAnnotationBookInfo dkAnnotationBookInfo = this.mBookInfo;
        return dkAnnotationBookInfo.mIdeaCount + dkAnnotationBookInfo.mCommentCount;
    }

    public String getBookAuthor() {
        return this.mBookInfo.mAuthor;
    }

    public String getBookCoverUrl() {
        return this.mBookInfo.mCoverUrl;
    }

    public String getBookEditor() {
        return this.mBookInfo.mEditor;
    }

    public String getBookFormat() {
        return this.mBookFormat;
    }

    public String getBookName() {
        return this.mBookInfo.mBookName;
    }

    public String getBookUuid() {
        return this.mBookInfo.mBookUuid;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return this.mBookInfo.mBookUuid;
    }

    public int getIdeaCount() {
        return this.mBookInfo.mIdeaCount;
    }

    public Date getLastDate() {
        return this.mBookInfo.mLastUpdateTime;
    }

    public int getNoteCount() {
        return this.mBookInfo.mCommentCount;
    }

    public String getTitle() {
        return this.mBookTitle;
    }

    public boolean isDuokanBookNote() {
        return this.mIsDuokanBook;
    }

    public boolean isSerial() {
        return this.mBookInfo.mSerial;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }

    public void setBookAuthor(String str) {
        this.mBookInfo.mAuthor = str;
    }

    public void setBookCoverUrl(String str) {
        this.mBookInfo.mCoverUrl = str;
    }

    public void setBookEditor(String str) {
        this.mBookInfo.mEditor = str;
    }

    public void setIdeaCount(int i) {
        this.mBookInfo.mIdeaCount = i;
    }

    public void setLastDate(Date date) {
        this.mBookInfo.mLastUpdateTime = date;
    }

    public void setNoteCount(int i) {
        this.mBookInfo.mCommentCount = i;
    }

    public void setTitle(String str) {
        this.mBookTitle = str;
    }
}
