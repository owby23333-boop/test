package com.xiaomi.micloudsdk.exception;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes8.dex */
public class CloudServerException extends Exception {
    private static final String RETRY_AFTER = "Retry-After";
    private static final String TAG = "CloudServerException";
    public int code;
    public int retryTime;
    public int statusCode;

    public CloudServerException(int i) {
        super("status: " + i);
        this.statusCode = i;
    }

    public static boolean isMiCloudServerException(int i) {
        return i == 400 || i == 401 || i == 403 || i == 406 || i / 100 == 5;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public CloudServerException(int i, int i2, int i3) {
        super("status: " + i);
        this.statusCode = i;
        this.code = i2;
        this.retryTime = i3 * 1000;
    }

    public CloudServerException(int i, HttpURLConnection httpURLConnection) {
        super("status: " + i);
        this.statusCode = i;
        try {
            if (httpURLConnection.getResponseCode() != 503 || TextUtils.isEmpty(httpURLConnection.getHeaderField("Retry-After"))) {
                return;
            }
            this.retryTime = Integer.valueOf(httpURLConnection.getHeaderField("Retry-After")).intValue() * 1000;
        } catch (IOException unused) {
            Log.d(TAG, "Can't find retry time in 503 HttpURLConnection response");
        } catch (NumberFormatException unused2) {
            Log.d(TAG, "Can't find retry time in 503 HttpURLConnection response");
        }
    }

    public CloudServerException(int i, HttpResponse httpResponse) {
        Header firstHeader;
        super("status: " + i);
        this.statusCode = i;
        if (httpResponse != null) {
            try {
                if (httpResponse.getStatusLine() == null || httpResponse.getStatusLine().getStatusCode() != 503 || (firstHeader = httpResponse.getFirstHeader("Retry-After")) == null || TextUtils.isEmpty(firstHeader.getValue())) {
                    return;
                }
                this.retryTime = Integer.valueOf(firstHeader.getValue()).intValue() * 1000;
            } catch (NumberFormatException unused) {
                Log.d(TAG, "Can't find retry time in 503 HttpURLConnection response");
            }
        }
    }
}
