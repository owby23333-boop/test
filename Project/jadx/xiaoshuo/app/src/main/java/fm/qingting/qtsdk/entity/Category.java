package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class Category extends QTEntity {

    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    public Integer getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
