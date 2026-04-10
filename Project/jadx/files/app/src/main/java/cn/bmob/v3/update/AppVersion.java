package cn.bmob.v3.update;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/* JADX INFO: loaded from: classes.dex */
public class AppVersion extends BmobObject {
    private static final long serialVersionUID = 64546978636988120L;
    private String android_url;
    private String channel;
    private String ios_url;
    private Boolean isforce;
    private BmobFile path;
    private String platform;
    private String target_size;
    private String update_log;
    private String version;
    private Integer version_i;

    public AppVersion() {
    }

    public String getAndroid_url() {
        return this.android_url;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getIos_url() {
        return this.ios_url;
    }

    public Boolean getIsforce() {
        return this.isforce;
    }

    public BmobFile getPath() {
        return this.path;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getTarget_size() {
        return this.target_size;
    }

    public String getUpdate_log() {
        return this.update_log;
    }

    public String getVersion() {
        return this.version;
    }

    public Integer getVersion_i() {
        return this.version_i;
    }

    public void setAndroid_url(String str) {
        this.android_url = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setIos_url(String str) {
        this.ios_url = str;
    }

    public void setIsforce(Boolean bool) {
        this.isforce = bool;
    }

    public void setPath(BmobFile bmobFile) {
        this.path = bmobFile;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setTarget_size(String str) {
        this.target_size = str;
    }

    public void setUpdate_log(String str) {
        this.update_log = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVersion_i(Integer num) {
        this.version_i = num;
    }

    public AppVersion(String str) {
        super(str);
    }
}
