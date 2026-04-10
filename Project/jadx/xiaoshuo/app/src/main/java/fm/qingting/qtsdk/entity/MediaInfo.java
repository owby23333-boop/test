package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class MediaInfo extends QTEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("type")
    private int type;

    public int getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }
}
