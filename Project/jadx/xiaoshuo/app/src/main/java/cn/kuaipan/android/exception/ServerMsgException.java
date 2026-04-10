package cn.kuaipan.android.exception;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes.dex */
public class ServerMsgException extends KscException {
    private static final long serialVersionUID = -681123175263669159L;
    private final String origMessage;
    private final int statusCode;

    public ServerMsgException(int i, String str) {
        this(i, str, (String) null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (TextUtils.isEmpty(this.origMessage)) {
            return super.getMessage();
        }
        return this.origMessage + SignatureUtils.DELIMITER + super.getMessage();
    }

    public String getOrigMessage() {
        return this.origMessage;
    }

    @Override // cn.kuaipan.android.exception.KscException, cn.kuaipan.android.exception.IKscError
    public String getSimpleMessage() {
        String str = getClass().getName() + "(ErrCode: " + getErrorCode() + "): StatusCode: " + this.statusCode;
        if (this.origMessage != null) {
            str = str + ", msg: " + this.origMessage;
        }
        String str2 = this.detailMessage;
        if (str2 == null || str2.length() >= 100) {
            return str;
        }
        return str + ", " + this.detailMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ServerMsgException(int i, String str, String str2) {
        super(ServerMsgMap.getErrorCode(i, str), str2);
        this.statusCode = i;
        this.origMessage = str;
    }

    public ServerMsgException(int i, int i2, String str) {
        super(i2, str);
        this.statusCode = i;
        this.origMessage = "Message not come from api server.";
    }
}
