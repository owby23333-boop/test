package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class RadioCategoryList {

    @SerializedName("content")
    private List<Content> content;

    @SerializedName("regions")
    private List<Region> regions;

    public List<Content> getContent() {
        return this.content;
    }

    public List<Region> getRegions() {
        return this.regions;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
