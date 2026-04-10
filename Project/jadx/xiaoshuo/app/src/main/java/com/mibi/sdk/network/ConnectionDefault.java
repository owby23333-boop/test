package com.mibi.sdk.network;

import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.exception.ServerException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.utils.MibiLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ConnectionDefault implements Connection {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;
    private static final String TAG = "ConnectionDefault";
    protected boolean mNeedGzipRequest;
    protected Parameter mParameter;
    protected JSONObject mResponse;
    protected int mResponseCode;
    private volatile Status mStatus;
    protected String mString;
    protected URL mUrl;
    protected boolean mUseGet;

    /* JADX INFO: renamed from: com.mibi.sdk.network.ConnectionDefault$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum NetworkError {
        OK,
        NETWORK_ERROR,
        ACCOUNT_CHANGED_ERROR,
        AUTH_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    public class Parameter extends SortedParameter {
        public Parameter() {
        }

        @Override // com.mibi.sdk.common.SortedParameter
        public TreeMap<String, Object> getParams() {
            return this.mParams;
        }

        @Override // com.mibi.sdk.common.SortedParameter
        public String toString() {
            if (this.mParams.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : this.mParams.keySet()) {
                sb.append(str);
                sb.append(MscKeys.KEY_VAL_SEP);
                try {
                    sb.append(URLEncoder.encode(this.mParams.get(str).toString(), "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
                sb.append(a.p);
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public ConnectionDefault(String str) {
        this.mStatus = Status.PENDING;
        try {
            init(new URL(str));
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("URL error: " + ((Object) null));
        }
    }

    public static String connect(String str, String str2) {
        return Utils.join(str, str2);
    }

    private void init(URL url) {
        this.mUseGet = false;
        this.mNeedGzipRequest = false;
        if (checkURL(url)) {
            this.mUrl = url;
            return;
        }
        throw new IllegalArgumentException("URL error: " + url);
    }

    private void innerRequest(URL url, String str, boolean z, boolean z2, OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    if (z) {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setDoOutput(false);
                    } else {
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setDoOutput(true);
                    }
                    if (z2) {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/gzip");
                        httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                    }
                    HttpURLConnection httpURLConnectionOnConnectionCreated = onConnectionCreated(httpURLConnection2);
                    httpURLConnectionOnConnectionCreated.connect();
                    if (!z && !TextUtils.isEmpty(str)) {
                        OutputStream outputStream2 = httpURLConnectionOnConnectionCreated.getOutputStream();
                        if (z2) {
                            outputStream2 = new GZIPOutputStream(outputStream2);
                        }
                        outputStream2.write(str.getBytes());
                        outputStream2.flush();
                        outputStream2.close();
                    }
                    int responseCode = httpURLConnectionOnConnectionCreated.getResponseCode();
                    this.mResponseCode = responseCode;
                    if (responseCode != 200) {
                        if (responseCode == 401) {
                            MibiLog.d(TAG, "401, unauthorized");
                            throw new ServiceTokenExpiredException();
                        }
                        if (responseCode == 404) {
                            MibiLog.d(TAG, "404, maybe the account's region is not cn");
                            throw new ServerException(this.mResponseCode, url);
                        }
                        MibiLog.d(TAG, "unknown error, responseCode : " + this.mResponseCode);
                        throw new ServerException(this.mResponseCode, url);
                    }
                    try {
                        if (outputStream != null) {
                            try {
                                bufferedInputStream = new BufferedInputStream(httpURLConnectionOnConnectionCreated.getInputStream(), 8192);
                            } catch (IOException e) {
                                e = e;
                            } catch (Exception e2) {
                                e = e2;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = bufferedInputStream.read(bArr, 0, 1024);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        outputStream.write(bArr, 0, i);
                                    }
                                }
                                outputStream.flush();
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                e = e3;
                                throw new ConnectionException(url, "read file stream error ", e);
                            } catch (Exception e4) {
                                e = e4;
                                throw new ConnectionException(url, "error read/write data", e);
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream2 = bufferedInputStream;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                throw th;
                            }
                        }
                        httpURLConnectionOnConnectionCreated.disconnect();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (PaymentException e5) {
                } catch (IOException e6) {
                    e = e6;
                    throw new ConnectionException(url, e);
                } catch (Exception e7) {
                    e = e7;
                    throw new ConnectionException(url, e);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (PaymentException e8) {
                throw e8;
            } catch (IOException e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public boolean checkURL(URL url) {
        return url != null;
    }

    @Override // com.mibi.sdk.network.Connection
    public JSONObject getResponse() {
        return this.mResponse;
    }

    @Override // com.mibi.sdk.network.Connection
    public int getResponseCode() {
        return this.mResponseCode;
    }

    @Override // com.mibi.sdk.network.Connection
    public String getStringResponse() {
        return this.mString;
    }

    @Override // com.mibi.sdk.network.Connection
    public URL getUrl() {
        return this.mUrl;
    }

    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) {
        return httpURLConnection;
    }

    public Parameter onQueryCreated(Parameter parameter) {
        return parameter;
    }

    public URL onURLCreated(URL url, Parameter parameter) {
        return url;
    }

    public void request(OutputStream outputStream) throws Throwable {
        if (this.mStatus != Status.PENDING) {
            int i = AnonymousClass1.$SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot start: the connection is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot start: the connection has already finished.");
            }
        }
        this.mStatus = Status.RUNNING;
        Parameter parameterOnQueryCreated = onQueryCreated(getParameter());
        String string = this.mUrl.toString();
        if (this.mUseGet && !parameterOnQueryCreated.isEmpty()) {
            if (TextUtils.isEmpty(this.mUrl.getQuery())) {
                string = string + "?" + parameterOnQueryCreated.toString();
            } else {
                string = string + a.p + parameterOnQueryCreated.toString();
            }
        }
        try {
            innerRequest(onURLCreated(new URL(string), parameterOnQueryCreated), !this.mUseGet ? parameterOnQueryCreated.toString() : "", this.mUseGet, this.mNeedGzipRequest, outputStream);
            this.mStatus = Status.FINISHED;
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.mibi.sdk.network.Connection
    public JSONObject requestJSON() throws Throwable {
        requestString();
        try {
            JSONObject jSONObject = new JSONObject(this.mString);
            this.mResponse = jSONObject;
            return jSONObject;
        } catch (Exception e) {
            throw new ResultException(e);
        }
    }

    @Override // com.mibi.sdk.network.Connection
    public String requestString() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        request(byteArrayOutputStream);
        this.mString = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return this.mString;
    }

    @Override // com.mibi.sdk.network.Connection
    public void setNeedGzipRequest(boolean z) {
        this.mNeedGzipRequest = z;
    }

    @Override // com.mibi.sdk.network.Connection
    public void setUseGet(boolean z) {
        this.mUseGet = z;
    }

    @Override // com.mibi.sdk.network.Connection
    public Parameter getParameter() {
        if (this.mParameter == null) {
            this.mParameter = new Parameter();
        }
        return this.mParameter;
    }

    public ConnectionDefault(String str, String str2) {
        this(connect(str, str2));
    }
}
