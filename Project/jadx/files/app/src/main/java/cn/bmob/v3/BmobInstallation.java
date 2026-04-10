package cn.bmob.v3;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.http.RequestUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class BmobInstallation extends BmobObject {
    private static final long serialVersionUID = 371823543247670010L;
    private String deviceToken;
    private String installationId;
    private String timeZone;
    private String deviceType = DispatchConstants.ANDROID;
    private List<String> channels = new ArrayList();

    public BmobInstallation() {
        this.channels.clear();
        setChannels(this.channels);
        setInstallationId(RequestUtils.getInstallationId(Bmob.getApplicationContext()));
        setTimeZone(TimeZone.getDefault().getID());
    }

    public static <T> BmobQuery<T> getQuery() {
        return new BmobQuery<>();
    }

    public List<String> getChannels() {
        return Collections.unmodifiableList(this.channels);
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getInstallationId() {
        return this.installationId;
    }

    @Override // cn.bmob.v3.BmobObject
    public String getTableName() {
        return "_Installation";
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setChannels(List<String> list) {
        this.channels = list;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setInstallationId(String str) {
        this.installationId = str;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }
}
