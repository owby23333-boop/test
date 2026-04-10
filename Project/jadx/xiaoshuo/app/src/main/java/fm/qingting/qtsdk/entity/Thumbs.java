package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class Thumbs {

    @SerializedName("large_thumb")
    private String mLargeThumb;

    @SerializedName("medium_thumb")
    private String mMediumThumb;

    @SerializedName("small_thumb")
    private String mSmallThumb;

    public String getLargeThumb() {
        return this.mLargeThumb;
    }

    public String getMediumThumb() {
        return this.mMediumThumb;
    }

    public String getSmallThumb() {
        return this.mSmallThumb;
    }

    public void setLargeThumb(String largeThumb) {
        this.mLargeThumb = largeThumb;
    }

    public void setMediumThumb(String mediumThumb) {
        this.mMediumThumb = mediumThumb;
    }

    public void setSmallThumb(String smallThumb) {
        this.mSmallThumb = smallThumb;
    }
}
