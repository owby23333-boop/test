package com.baidu.tts.network;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    private static final String TAG = "RangeFileAsyncHttpRH";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
        this.current = 0L;
        this.append = false;
    }

    protected byte[] getResponseData(HttpResponseEntity httpResponseEntity) {
        if (httpResponseEntity == null) {
            return null;
        }
        try {
            InputStream content = httpResponseEntity.getContent();
            long contentLength = httpResponseEntity.getContentLength();
            FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
            if (content == null) {
                return null;
            }
            try {
                byte[] bArr = new byte[4096];
                int i2 = 0;
                while (true) {
                    int i3 = content.read(bArr);
                    if (i3 == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i2 += i3;
                    fileOutputStream.write(bArr, 0, i3);
                    onProgress(i2, contentLength);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                return null;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tts.network.ResponseHandler, com.baidu.tts.network.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponseEntity httpResponseEntity) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        int responseCode = httpResponseEntity.getResponseCode();
        Map<String, List<String>> header = httpResponseEntity.getHeader();
        if (responseCode == 416) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            onFailure(responseCode, header, null, null);
            return;
        }
        if (responseCode > 300) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            onFailure(responseCode, header, new Exception("response failed "), null);
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            List<String> list = header.get("Content-Range");
            if (list == null) {
                this.append = false;
                this.current = 0L;
            } else {
                LoggerProxy.v(TAG, " HEADER_CONTENT_RANGE: " + ((Object) list.get(0)));
            }
            onSuccess(responseCode, header, httpResponseEntity.getContentType(), getResponseData(httpResponseEntity));
        }
    }

    public void updateRequestHeaders(HttpURLConnection httpURLConnection) {
        if (this.file.exists() && this.file.canWrite()) {
            this.current = this.file.length();
        }
        if (this.current > 0) {
            this.append = true;
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.current + "-");
        }
    }
}
