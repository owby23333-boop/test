package com.xm.logsdk.log.logger.lib;

import android.os.Process;
import android.util.Log;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xm.logsdk.log.Logz;
import com.xm.logsdk.log.logger.crypt.CryptLog;
import com.xm.logsdk.log.logger.crypt.ICrypt;
import com.xm.logsdk.log.logger.lib.thread.IMessageThread;
import com.xm.logsdk.log.logger.lib.thread.IMsgCallback;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AppenderSkeleton implements Logger {
    private static SimpleDateFormat S_D_FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ");
    protected String name;
    protected IMessageThread<String> mMessageThread = null;
    private CryptLog mCryptLog = null;
    private IMsgCallback<String> mCallback = new IMsgCallback<String>() { // from class: com.xm.logsdk.log.logger.lib.AppenderSkeleton.2
        @Override // com.xm.logsdk.log.logger.lib.thread.IMsgCallback
        public void handleMessage(String str) {
            if (str != null) {
                AppenderSkeleton.this.appendContent(str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void appendContent(String str) {
        String str2 = str + SignatureUtils.DELIMITER;
        if (Logz.sLogConfig.isEnableEncrypt() && encrytContent(str2, new ICrypt.AESLogCallback() { // from class: com.xm.logsdk.log.logger.lib.AppenderSkeleton.1
            @Override // com.xm.logsdk.log.logger.crypt.ICrypt.AESLogCallback
            public void callback(byte[] bArr, boolean z) {
                AppenderSkeleton.this.appendIO(bArr, 0, bArr.length);
            }
        })) {
            return;
        }
        appendIO(str2);
    }

    private boolean encrytContent(String str, ICrypt.AESLogCallback aESLogCallback) {
        try {
            getCryptLog().encrypt(str, aESLogCallback);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String getFormatTime() {
        S_D_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return S_D_FORMAT.format(new Date());
    }

    public void activateOptions() {
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public final void append(int i, String str, StringBuilder sb) {
        if (i >= Logz.sLogConfig.getLimitDiskLevel() && !filter(i, str, sb)) {
            StringBuilder sbObtain = StringBuilderPool.obtain();
            sbObtain.append(getFormatTime());
            sbObtain.append(getPidTid());
            sbObtain.append(str);
            sbObtain.append(" ");
            if (i == 2) {
                sbObtain.append(" V ");
            } else if (i == 3) {
                sbObtain.append(" D ");
            } else if (i == 4) {
                sbObtain.append(" I ");
            } else if (i == 5) {
                sbObtain.append(" W ");
            } else if (i != 6) {
                sbObtain.append(" T ");
            } else {
                sbObtain.append(" E ");
            }
            String str2 = ((Object) sbObtain) + sb.toString();
            IMessageThread<String> iMessageThread = this.mMessageThread;
            if (iMessageThread != null) {
                iMessageThread.doMessage(str2);
            } else {
                appendContent(str2);
            }
            StringBuilderPool.recycle(sbObtain);
        }
    }

    public abstract void appendIO(String str);

    public abstract void appendIO(byte[] bArr, int i, int i2);

    public boolean filter(int i, String str, StringBuilder sb) {
        return false;
    }

    public CryptLog getCryptLog() {
        if (this.mCryptLog == null) {
            this.mCryptLog = new CryptLog(Logz.sLogConfig.getAesKey(), false);
        }
        return this.mCryptLog;
    }

    public final String getName() {
        return this.name;
    }

    public String getPidTid() {
        return Process.myPid() + "_" + Process.myTid() + " ";
    }

    public byte[] getStrFooter() {
        return null;
    }

    public byte[] getStrHeader() {
        return Logz.sLogConfig.isEnableEncrypt() ? getCryptLog().getFileHeader() : "\n====================START==========================\n".getBytes(StandardCharsets.UTF_8);
    }

    public void log(String str) {
        if (Logz.sLogConfig.isEnableDEBUG()) {
            Log.i("LOGZ_FILE_W", str);
        }
    }

    public void loge(String str, Throwable th) {
        if (Logz.sLogConfig.isEnableDEBUG()) {
            Log.e("LOGZ_FILE_W", str, th);
        }
    }

    public void setMessageThread(IMessageThread<String> iMessageThread) {
        IMsgCallback<String> iMsgCallback;
        this.mMessageThread = iMessageThread;
        if (iMessageThread == null || (iMsgCallback = this.mCallback) == null) {
            return;
        }
        iMessageThread.setCallback(iMsgCallback);
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public final void append(StringBuilder sb) {
        String str = getFormatTime() + getPidTid() + sb.toString();
        IMessageThread<String> iMessageThread = this.mMessageThread;
        if (iMessageThread != null) {
            iMessageThread.doMessage(str);
        } else {
            appendContent(str);
        }
    }
}
