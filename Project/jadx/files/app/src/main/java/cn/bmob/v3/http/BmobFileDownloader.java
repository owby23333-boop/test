package cn.bmob.v3.http;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import cn.bmob.v3.datatype.up.UploadClient;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.util.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class BmobFileDownloader extends AsyncTask<Void, Long, BmobException> {
    private DownloadFileListener callback;
    private Context context;
    private PowerManager.WakeLock mWakeLock;
    private UploadClient okHttpClient = new UploadClient();
    private File savePath;
    private String url;

    public BmobFileDownloader(Context context, String str, File file, DownloadFileListener downloadFileListener) {
        this.context = context;
        this.url = str;
        this.callback = downloadFileListener;
        this.savePath = file;
        Utils.mkdirs(file.getParentFile());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.mWakeLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, BmobFileDownloader.class.getName());
        this.mWakeLock.acquire();
        DownloadFileListener downloadFileListener = this.callback;
        if (downloadFileListener != null) {
            downloadFileListener.internalStart();
        }
    }

    public String saveFile(Response response) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamByteStream;
        byte[] bArr = new byte[1024];
        try {
            inputStreamByteStream = response.body().byteStream();
            try {
                long jContentLength = response.body().getContentLength();
                long j2 = 0;
                Utils.mkdirs(this.savePath.getParentFile());
                fileOutputStream = new FileOutputStream(this.savePath);
                while (true) {
                    try {
                        int i2 = inputStreamByteStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        j2 += (long) i2;
                        fileOutputStream.write(bArr, 0, i2);
                        if (this.callback != null) {
                            publishProgress(Long.valueOf(j2), Long.valueOf(jContentLength));
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (inputStreamByteStream != null) {
                            try {
                                inputStreamByteStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream.flush();
                String absolutePath = this.savePath.getAbsolutePath();
                if (inputStreamByteStream != null) {
                    try {
                        inputStreamByteStream.close();
                    } catch (IOException unused3) {
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
                return absolutePath;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            inputStreamByteStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public BmobException doInBackground(Void... voidArr) throws Throwable {
        try {
            Response responseDownload = this.okHttpClient.download(this.url);
            long jContentLength = responseDownload.body().getContentLength();
            saveFile(responseDownload);
            int i2 = (jContentLength > this.savePath.length() ? 1 : (jContentLength == this.savePath.length() ? 0 : -1));
            return null;
        } catch (BmobException e2) {
            e2.printStackTrace();
            return e2;
        } catch (IOException e3) {
            e3.printStackTrace();
            return new BmobException(ErrorCode.E9015, e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(BmobException bmobException) {
        super.onPostExecute(bmobException);
        this.mWakeLock.release();
        if (bmobException == null) {
            DownloadFileListener downloadFileListener = this.callback;
            if (downloadFileListener != null) {
                downloadFileListener.done(this.savePath.getAbsolutePath(), (BmobException) null);
            }
        } else {
            DownloadFileListener downloadFileListener2 = this.callback;
            if (downloadFileListener2 != null) {
                downloadFileListener2.done((String) null, new BmobException(bmobException.getErrorCode(), bmobException.getMessage()));
            }
        }
        DownloadFileListener downloadFileListener3 = this.callback;
        if (downloadFileListener3 != null) {
            downloadFileListener3.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Long... lArr) {
        super.onProgressUpdate((Object[]) lArr);
        if (this.callback == null || lArr == null || lArr.length < 2) {
            return;
        }
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        this.callback.onProgress(Integer.valueOf((int) ((jLongValue * 100.0f) / jLongValue2)), jLongValue2);
    }
}
