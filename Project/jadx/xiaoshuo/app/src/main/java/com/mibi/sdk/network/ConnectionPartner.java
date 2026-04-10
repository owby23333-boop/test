package com.mibi.sdk.network;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.network.ConnectionDefault;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public class ConnectionPartner extends ConnectionDefault {
    private static final String TAG = "ConnectionPartner";
    private String mUserId;

    public ConnectionPartner(String str, String str2) {
        super(str);
        this.mUserId = str2;
    }

    @Override // com.mibi.sdk.network.ConnectionDefault
    public boolean checkURL(URL url) {
        if (TextUtils.isEmpty(url.getQuery())) {
            return super.checkURL(url);
        }
        return false;
    }

    @Override // com.mibi.sdk.network.ConnectionDefault
    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) {
        StringBuilder sb = new StringBuilder();
        sb.append("userId=" + this.mUserId);
        sb.append("; ");
        httpURLConnection.setRequestProperty(HttpHeaders.COOKIE, sb.toString());
        return httpURLConnection;
    }

    @Override // com.mibi.sdk.network.ConnectionDefault
    public ConnectionDefault.Parameter onQueryCreated(ConnectionDefault.Parameter parameter) {
        return parameter;
    }

    @Override // com.mibi.sdk.network.ConnectionDefault, com.mibi.sdk.network.Connection
    public String requestString() throws Throwable {
        super.requestString();
        String str = this.mString;
        if (str != null) {
            return str;
        }
        throw new ResultException("requestString error, decode failed");
    }
}
