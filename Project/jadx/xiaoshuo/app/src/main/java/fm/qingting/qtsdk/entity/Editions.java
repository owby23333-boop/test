package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Editions {

    @SerializedName("editions")
    private List<Edition> mEditions;

    @SerializedName("expire")
    private Integer mExpire;

    public List<Edition> getEditions() {
        return this.mEditions;
    }

    public Integer getExpire() {
        return this.mExpire;
    }

    public void setEditions(List<Edition> editions) {
        this.mEditions = editions;
    }

    public void setExpire(Integer expire) {
        this.mExpire = expire;
    }
}
