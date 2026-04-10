package cn.kuaipan.android.exception;

import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes.dex */
public class KscRuntimeException extends RuntimeException implements IKscError {
    private static final long serialVersionUID = 4693852528580738850L;
    private final String detailMessage;
    private final int errCode;

    public KscRuntimeException(int i) {
        this(i, null, null);
    }

    @Override // cn.kuaipan.android.exception.IKscError
    public int getErrorCode() {
        return this.errCode;
    }

    @Override // cn.kuaipan.android.exception.IKscError
    public String getSimpleMessage() {
        String str = getClass().getName() + "(ErrCode: " + this.errCode + ")";
        String str2 = this.detailMessage;
        if (str2 == null || str2.length() >= 100) {
            return str;
        }
        return str + ": " + this.detailMessage;
    }

    public KscRuntimeException(int i, String str) {
        this(i, str, null);
    }

    public KscRuntimeException(int i, Throwable th) {
        this(i, th == null ? null : th.toString(), th);
    }

    public KscRuntimeException(int i, String str, Throwable th) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("ErrCode: ");
        sb.append(i);
        if (str == null) {
            str2 = "";
        } else {
            str2 = SignatureUtils.DELIMITER + str;
        }
        sb.append(str2);
        super(sb.toString(), KscException.getSerial(th));
        this.errCode = i;
        this.detailMessage = str;
    }
}
