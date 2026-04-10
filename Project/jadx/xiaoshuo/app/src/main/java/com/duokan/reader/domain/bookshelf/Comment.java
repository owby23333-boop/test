package com.duokan.reader.domain.bookshelf;

import android.graphics.Color;
import com.duokan.reader.domain.account.prefs.PersonalPrefsInterface;
import com.yuewen.rd2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Comment extends Annotation {
    private int mHighlightColor = Color.rgb(237, 88, 0);
    private String mNoteText;
    private rd2<Boolean> mPublic;

    public Comment() {
        boolean z = false;
        if (PersonalPrefsInterface.f() != null && PersonalPrefsInterface.f().A()) {
            z = true;
        }
        this.mPublic = new rd2<>(Boolean.valueOf(z));
    }

    public static String makeBodyJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", str);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public Annotation copy() {
        Comment comment = new Comment();
        comment.setId(getId());
        comment.setBookId(getBookId());
        comment.setSample(getOriginalSample());
        comment.setAddedDate(getAddedDate());
        comment.setModifiedDate(getModifiedDate());
        comment.setEndAnchor(getEndAnchor());
        comment.setStartAnchor(getStartAnchor());
        comment.setHighlightColor(getHighlightColor());
        comment.setNoteText(getNoteText());
        comment.setAnnotationUuid(getAnnotationUuid());
        if (isPublic().hasValue()) {
            comment.setPublicValue(isPublic().getValue().booleanValue());
        } else {
            comment.isPublic().clear();
        }
        return comment;
    }

    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public String getBodyJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("note_text", this.mNoteText);
            jSONObject.put("highlight_color", String.format("%d %d %d", Integer.valueOf(Color.red(this.mHighlightColor)), Integer.valueOf(Color.green(this.mHighlightColor)), Integer.valueOf(Color.blue(this.mHighlightColor))));
            if (this.mPublic.hasValue()) {
                jSONObject.put("public", this.mPublic.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    public String getNoteText() {
        return this.mNoteText;
    }

    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public AnnotationType getType() {
        return AnnotationType.COMMENT;
    }

    public rd2<Boolean> isPublic() {
        return this.mPublic;
    }

    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public void setBodyJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mNoteText = jSONObject.optString("note_text");
            String[] strArrSplit = jSONObject.optString("highlight_color", "237 88 0").split(" ");
            this.mHighlightColor = Color.rgb(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue(), Integer.valueOf(strArrSplit[2]).intValue());
            if (jSONObject.has("public")) {
                this.mPublic.setValue(Boolean.valueOf(jSONObject.getBoolean("public")));
            } else {
                this.mPublic.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighlightColor(int i) {
        this.mHighlightColor = i;
    }

    public void setNoteText(String str) {
        this.mNoteText = str;
    }

    public void setPublicValue(boolean z) {
        this.mPublic.setValue(Boolean.valueOf(z));
    }
}
