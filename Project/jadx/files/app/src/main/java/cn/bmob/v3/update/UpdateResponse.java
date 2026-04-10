package cn.bmob.v3.update;

import android.content.Context;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.util.BmobResource;
import cn.bmob.v3.util.EncryptMD5;
import cn.bmob.v3.util.Utils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UpdateResponse implements Serializable {
    private static final long serialVersionUID = 287172543706916699L;
    public BmobException exception;
    public Boolean isforce;
    public String path;
    public String path_md5;
    public long target_size;
    public Integer version_i;
    public String version = null;
    public String updateLog = null;

    public UpdateResponse(AppVersion appVersion) {
        parseJson(appVersion);
    }

    private String getFormatString(int i2, String str, String str2, String str3, String str4, String str5, String str6) {
        String string;
        Object[] objArr;
        if (this.updateLog.contains("；")) {
            String[] strArrSplit = this.updateLog.split("；");
            int length = strArrSplit.length;
            StringBuilder sb = new StringBuilder();
            objArr = new Object[length + 6];
            if (i2 == 4) {
                sb.append("%s %s\n%s\n\n%s");
                objArr[0] = str;
                objArr[1] = this.version;
                objArr[2] = str4;
                objArr[3] = str3;
            } else if (i2 == 6) {
                sb.append("%s %s\n%s %s%s\n\n%s");
                objArr[0] = str;
                objArr[1] = this.version;
                objArr[2] = str2;
                objArr[3] = str6;
                objArr[4] = str5;
                objArr[5] = str3;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 != length - 1) {
                    sb.append("\n%s");
                    objArr[i2 + i3] = strArrSplit[i3] + "；";
                } else {
                    sb.append("\n%s");
                    objArr[i2 + i3] = strArrSplit[i3];
                }
            }
            string = sb.toString();
        } else if (i2 == 4) {
            objArr = new Object[]{str, this.version, str4, str3, this.updateLog};
            string = "%s %s\n%s\n\n%s\n%s\n";
        } else if (i2 == 6) {
            objArr = new Object[]{str, this.version, str2, str6, str5, str3, this.updateLog};
            string = "%s %s\n%s %s%s\n\n%s\n%s\n";
        } else {
            string = "";
            objArr = null;
        }
        return String.format(string, objArr);
    }

    private void parseJson(AppVersion appVersion) {
        this.updateLog = appVersion.getUpdate_log();
        this.version = appVersion.getVersion();
        this.version_i = appVersion.getVersion_i();
        if (this.version_i == null) {
            this.version_i = 0;
        }
        this.isforce = appVersion.getIsforce();
        if (this.isforce == null) {
            this.isforce = false;
        }
        if (appVersion.getPath() != null) {
            this.path = appVersion.getPath().getFileUrl();
            this.path_md5 = EncryptMD5.setMD5(this.path);
        } else if (appVersion.getAndroid_url() != null) {
            this.path = appVersion.getAndroid_url();
            this.path_md5 = EncryptMD5.setMD5(this.path);
        }
        try {
            this.target_size = Long.parseLong(appVersion.getTarget_size());
        } catch (Exception unused) {
            this.target_size = 0L;
        }
    }

    public BmobException getException() {
        return this.exception;
    }

    public String getUpdateInfo(Context context, boolean z2) {
        String string = context.getString(BmobResource.getInstance(context).getString("BMNewVersion"));
        String string2 = context.getString(BmobResource.getInstance(context).getString("BMTargetSize"));
        String string3 = context.getString(BmobResource.getInstance(context).getString("BMUpdateContent"));
        String string4 = context.getString(BmobResource.getInstance(context).getString("BMDialog_InstallAPK"));
        return z2 ? getFormatString(4, string, string2, string3, string4, "", "") : getFormatString(6, string, string2, string3, string4, "", Utils.convertFileSize(this.target_size));
    }

    public UpdateResponse(int i2, String str) {
        this.exception = new BmobException(i2, str);
    }
}
