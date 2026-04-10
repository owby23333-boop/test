package com.baidu.tts.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncHttpResponseHandler extends ResponseHandler {
    private static final String LOG_TAG = "AsyncHttpRH";
    private Handler handler;
    private Looper looper;
    private URI requestURI;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    private static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler, Looper looper) {
            super(looper);
            this.mResponder = asyncHttpResponseHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }

    public AsyncHttpResponseHandler() {
        this(null);
    }

    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    protected void handleMessage(Message message) {
        try {
            int i2 = message.what;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
    }

    public void setUsePoolThread(boolean z2) {
        if (z2) {
            this.looper = null;
            this.handler = null;
        }
        this.usePoolThread = z2;
    }

    public void setUseSynchronousMode(boolean z2) {
        if (!z2 && this.looper == null) {
            z2 = true;
        }
        if (!z2 && this.handler == null) {
            this.handler = new ResponderHandler(this, this.looper);
        } else if (z2 && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z2;
    }

    public AsyncHttpResponseHandler(Looper looper) {
        this.requestURI = null;
        this.looper = null;
        this.looper = looper == null ? Looper.myLooper() : looper;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }
}
