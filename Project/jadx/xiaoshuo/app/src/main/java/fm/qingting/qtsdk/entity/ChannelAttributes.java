package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.mibi.sdk.component.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelAttributes {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName(Constants.KEY_RECHARGE_VALUES)
    private List<Value> values;

    public String getName() {
        return this.name;
    }

    public List<Value> getValues() {
        return this.values;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
