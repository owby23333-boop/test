package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class Region {

    @SerializedName("id")
    private Long id;

    @SerializedName("title")
    private String title;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
