package fm.qingting.qtsdk.entity;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Edition implements Serializable {

    @SerializedName(MediaFormat.KEY_BIT_RATE)
    private Integer mBitrate;

    @SerializedName("urls")
    private List<String> mUrl;

    public Integer getBitrate() {
        return this.mBitrate;
    }

    public List<String> getUrl() {
        return this.mUrl;
    }

    public void setBitrate(Integer bitrate) {
        this.mBitrate = bitrate;
    }

    public void setUrl(List<String> url) {
        this.mUrl = url;
    }
}
