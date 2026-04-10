package cn.kuaipan.android.exception;

import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

/* JADX INFO: loaded from: classes.dex */
public class KscException extends Exception implements IKscError {
    private static final long serialVersionUID = 7461260166746901326L;
    protected final String detailMessage;
    private final int errCode;

    public KscException(int i) {
        this(i, null, null);
    }

    public static Throwable getSerial(Throwable th) {
        return (th != null && (th instanceof HttpHostConnectException)) ? new HttpHostConnectExceptionWrapper((HttpHostConnectException) th) : th;
    }

    public static KscException newException(Throwable th, String str) throws InterruptedException {
        if (th instanceof KscException) {
            return (KscException) th;
        }
        ErrorHelper.handleInterruptException(th);
        if (th instanceof ConnectException) {
            return new NetworkException(ErrorCode.NET_ECONNREFUSED, str, th);
        }
        if (th instanceof SocketException) {
            return new NetworkException(504000, str, th);
        }
        if (th instanceof SocketTimeoutException) {
            return new NetworkException(ErrorCode.NET_SOCKET_TIMEOUT, str, th);
        }
        if (th instanceof ConnectTimeoutException) {
            return new NetworkException(ErrorCode.NET_SOCKET_ETIMEDOUT, str, th);
        }
        if (th instanceof ClientProtocolException) {
            return new NetworkException(ErrorCode.NET_ERROR_HTTP_PROTOCOL, str, th);
        }
        if (th instanceof UnknownHostException) {
            return new NetworkException(ErrorCode.NET_ERROR_UNKNOW_HOST, str, th);
        }
        if (th instanceof InvalidKeyException) {
            return new KscException(ErrorCode.INVALID_DATA, str, th);
        }
        if (th instanceof FileNotFoundException) {
            return new KscException(ErrorCode.IOERR_MISS_FILE, str, th);
        }
        if (th instanceof IOException) {
            return new KscException(403000, str, th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        return new KscException(403999, str, th);
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

    public KscException(int i, String str) {
        this(i, str, null);
    }

    public KscException(int i, Throwable th) {
        this(i, th == null ? null : th.toString(), th);
    }

    public KscException(int i, String str, Throwable th) {
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
        super(sb.toString(), getSerial(th));
        this.errCode = i;
        this.detailMessage = str;
    }
}
