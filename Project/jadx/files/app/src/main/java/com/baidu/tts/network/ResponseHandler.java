package com.baidu.tts.network;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResponseHandler implements ResponseHandlerInterface {
    private static final String TAG = "TtsResponseHandler";
    private URI requestURI = null;

    public URI getRequestURI() {
        return this.requestURI;
    }

    public abstract void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr);

    @Override // com.baidu.tts.network.ResponseHandlerInterface
    public void sendErrorMessage(int i2, Map<String, List<String>> map, String str, Exception exc) {
        onFailure(i2, map, str, null, exc);
    }

    @Override // com.baidu.tts.network.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponseEntity httpResponseEntity) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        LoggerProxy.d(TAG, "response: " + httpResponseEntity.getResponseCode());
        int responseCode = httpResponseEntity.getResponseCode();
        Map<String, List<String>> header = httpResponseEntity.getHeader();
        String contentType = httpResponseEntity.getContentType();
        try {
            InputStream content = httpResponseEntity.getContent();
            if (responseCode != 200) {
                LoggerProxy.d(TAG, "request fail statusCode: " + responseCode);
                onFailure(responseCode, header, httpResponseEntity.getContentType(), null, null);
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(content);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1) {
                    bufferedInputStream.close();
                    onSuccess(responseCode, header, contentType, byteArrayOutputStream.toByteArray());
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            e2.printStackTrace();
            onFailure(responseCode, httpResponseEntity.getHeader(), httpResponseEntity.getContentType(), null, e2);
        }
    }

    @Override // com.baidu.tts.network.ResponseHandlerInterface
    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }
}
