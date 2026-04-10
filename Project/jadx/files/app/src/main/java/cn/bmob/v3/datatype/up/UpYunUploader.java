package cn.bmob.v3.datatype.up;

import android.content.Context;
import android.os.PowerManager;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.http.bean.Upyun;
import cn.bmob.v3.listener.UploadFileListener;
import cn.bmob.v3.util.BLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UpYunUploader extends BmobUploader {
    private Context context;
    private File file;
    private PowerManager.WakeLock mWakeLock;
    private Upyun result;

    public UpYunUploader(Context context, Upyun upyun, BmobFile bmobFile, UploadFileListener uploadFileListener) {
        super(bmobFile, uploadFileListener);
        this.result = upyun;
        this.context = context;
        this.file = bmobFile.getLocalFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doComplement(boolean z2, String str) {
        String str2;
        try {
            if (!z2) {
                UploadFileListener uploadFileListener = this.listener;
                if (uploadFileListener != null) {
                    uploadFileListener.done(new BmobException(ErrorCode.E9015, str));
                    return;
                }
                return;
            }
            try {
                str2 = "http://" + this.result.getDomain() + ((String) ((Map) new Gson().fromJson(str, new TypeToken<Map<String, String>>() { // from class: cn.bmob.v3.datatype.up.UpYunUploader.4
                }.getType())).get("url"));
            } catch (Exception unused) {
                str2 = "http://" + this.result.getDomain() + str;
            }
            this.bmobFile.obtain(this.file.getName(), "", str2);
            if (this.listener != null) {
                this.listener.done(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            UploadFileListener uploadFileListener2 = this.listener;
            if (uploadFileListener2 != null) {
                uploadFileListener2.done(new BmobException(ErrorCode.E9015, e2.getMessage()));
            }
        }
    }

    @Override // cn.bmob.v3.datatype.up.BmobUploader
    public void doUpload() {
        String strValueOf;
        String strValueOf2;
        if (this.file.isDirectory()) {
            this.listener.doneError(ErrorCode.E9025, ErrorCode.E9025S);
            return;
        }
        this.mWakeLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, UpYunUploader.class.getName());
        this.mWakeLock.acquire();
        HashMap map = new HashMap();
        map.put(Params.BUCKET, this.result.getName());
        BLog.e("bucket:" + this.result.getName());
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        if (i3 < 10) {
            strValueOf = "0" + i3;
        } else {
            strValueOf = String.valueOf(i3);
        }
        if (i4 < 10) {
            strValueOf2 = "0" + i4;
        } else {
            strValueOf2 = String.valueOf(i4);
        }
        String path = this.file.getPath();
        String strSubstring = this.file.getName().contains(".") ? path.substring(path.lastIndexOf(".")) : "";
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        sb.append("/");
        sb.append(i2);
        sb.append("/");
        sb.append(strValueOf);
        sb.append("/");
        sb.append(strValueOf2);
        sb.append("/");
        sb.append(strReplace);
        sb.append(strSubstring);
        map.put(Params.SAVE_KEY, sb.toString());
        BLog.e("save-key:" + sb.toString());
        UploadManager.getInstance().parallelUpload(this.file, map, new SignatureListener() { // from class: cn.bmob.v3.datatype.up.UpYunUploader.3
            @Override // cn.bmob.v3.datatype.up.SignatureListener
            public String getSignature(String str) {
                return UpYunUtils.md5(str + UpYunUploader.this.result.getSecret());
            }
        }, new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.UpYunUploader.2
            @Override // cn.bmob.v3.datatype.up.UpCompleteListener
            public void onComplete(boolean z2, String str) {
                BLog.e(str);
                UpYunUploader.this.doComplement(z2, str);
                if (UpYunUploader.this.mWakeLock != null) {
                    UpYunUploader.this.mWakeLock.release();
                }
                UploadFileListener uploadFileListener = UpYunUploader.this.listener;
                if (uploadFileListener != null) {
                    uploadFileListener.onFinish();
                }
            }
        }, new UpProgressListener() { // from class: cn.bmob.v3.datatype.up.UpYunUploader.1
            @Override // cn.bmob.v3.datatype.up.UpProgressListener
            public void onRequestProgress(long j2, long j3) {
                int i5 = (int) ((j2 * 100) / j3);
                UploadFileListener uploadFileListener = UpYunUploader.this.listener;
                if (uploadFileListener != null) {
                    uploadFileListener.onProgress(Integer.valueOf(i5));
                }
            }
        });
    }
}
