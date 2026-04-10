package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelPrmission {

    @SerializedName("program_ids")
    private List<Long> ProgramIds;

    @SerializedName("valid")
    private Boolean Valid;

    @SerializedName("valid_type")
    private String ValidType;

    public List<Long> getProgramIds() {
        return this.ProgramIds;
    }

    public Boolean getValid() {
        return this.Valid;
    }

    public String getValidType() {
        return this.ValidType;
    }

    public void setProgramIds(List<Long> programIds) {
        this.ProgramIds = programIds;
    }

    public void setValid(Boolean valid) {
        this.Valid = valid;
    }

    public void setValidType(String validType) {
        this.ValidType = validType;
    }
}
