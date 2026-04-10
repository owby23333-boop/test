package com.market.sdk.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Connection {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int GPRS_READ_TIMEOUT = 30000;
    protected static final String PROTOCOL_HTTP = "http";
    protected static final String PROTOCOL_HTTPS = "https";
    private static final String TAG = "MarketConnection";
    private static final int WIFI_READ_TIMEOUT = 10000;
    protected boolean mIsBackground;
    protected boolean mNeedBaseParameter;
    protected boolean mNeedHosted;
    protected boolean mNeedId;
    protected boolean mNeedSessionID;
    protected Parameter mParameter;
    protected JSONObject mResponse;
    protected String mString;
    protected URL mUrl;
    protected boolean mUseGet;

    public class ConnectionException extends Exception {
        private static final long serialVersionUID = 1;
        protected NetworkError mError;

        public ConnectionException(NetworkError networkError) {
            this.mError = networkError;
        }
    }

    public class FileResetableOutputStream extends ResetableOutputStream {
        private File mFile;

        public FileResetableOutputStream(File file) throws FileNotFoundException {
            super(new FileOutputStream(file));
            this.mFile = file;
        }

        @Override // com.market.sdk.utils.Connection.ResetableOutputStream
        public void reset() {
            try {
                this.mOutputStream.close();
            } catch (IOException unused) {
            }
            this.mFile.delete();
            try {
                this.mOutputStream = new FileOutputStream(this.mFile);
            } catch (FileNotFoundException unused2) {
            }
        }
    }

    public class MemoryResetableOutputStream extends ResetableOutputStream {
        public MemoryResetableOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            super(byteArrayOutputStream);
        }

        @Override // com.market.sdk.utils.Connection.ResetableOutputStream
        public void reset() {
            ((ByteArrayOutputStream) this.mOutputStream).reset();
        }
    }

    public enum NetworkError {
        OK,
        URL_ERROR,
        NETWORK_ERROR,
        AUTH_ERROR,
        CLIENT_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    public class Parameter {
        private TreeMap<String, String> params;

        public Parameter(Connection connection) {
            this(true);
        }

        public Parameter add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.params.put(str, str2);
            }
            return this;
        }

        public String get(String str) {
            return this.params.get(str);
        }

        public TreeMap<String, String> getParams() {
            return this.params;
        }

        public boolean isEmpty() {
            return this.params.isEmpty();
        }

        public String toString() {
            if (this.params.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : this.params.keySet()) {
                sb.append(str);
                sb.append(MscKeys.KEY_VAL_SEP);
                try {
                    sb.append(URLEncoder.encode(this.params.get(str), "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
                sb.append(a.p);
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        public Parameter(boolean z) {
            this.params = new TreeMap<>();
            if (z) {
                Connection.this.mParameter = this;
            }
        }

        public Parameter add(String str, boolean z) {
            if (z) {
                this.params.put(str, com.duokan.reader.domain.payment.a.c);
            } else {
                this.params.put(str, MscKeys.VAL_FALSE);
            }
            return this;
        }
    }

    public abstract class ResetableOutputStream extends OutputStream {
        protected OutputStream mOutputStream;

        public ResetableOutputStream(OutputStream outputStream) {
            if (outputStream == null) {
                throw new IllegalArgumentException("outputstream is null");
            }
            this.mOutputStream = outputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mOutputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.mOutputStream.flush();
        }

        public abstract void reset();

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.mOutputStream.write(i);
        }
    }

    public Connection(String str) {
        this(str, false);
    }

    public static String connect(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str + "/" + str2;
    }

    private NetworkError handleResponseCode(int i) {
        if (i == 200) {
            return NetworkError.OK;
        }
        Log.e(TAG, "Network Error : " + i);
        return NetworkError.SERVER_ERROR;
    }

    private void init(URL url) {
        this.mNeedBaseParameter = true;
        this.mUseGet = false;
        this.mNeedHosted = true;
        this.mNeedId = true;
        this.mNeedSessionID = true;
        if (checkURL(url)) {
            this.mUrl = url;
        }
    }

    private NetworkError innerRequest(String str, String str2, boolean z, boolean z2, ResetableOutputStream resetableOutputStream) throws Throwable {
        HttpURLConnection httpURLConnectionOnConnectionCreated;
        Exception e;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e2;
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(str);
        for (String str3 : arrayList) {
            if (Utils.DEBUG) {
                Log.d(TAG, "hosted connection url: " + str3);
            }
            try {
                URL url = new URL(str3);
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnectionOnConnectionCreated = (HttpURLConnection) url.openConnection();
                } catch (Exception e3) {
                    httpURLConnectionOnConnectionCreated = null;
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    try {
                        httpURLConnectionOnConnectionCreated.setConnectTimeout(10000);
                        if (Utils.isWifiConnected(AppGlobal.getContext())) {
                            httpURLConnectionOnConnectionCreated.setReadTimeout(10000);
                        } else {
                            httpURLConnectionOnConnectionCreated.setReadTimeout(30000);
                        }
                        if (z) {
                            httpURLConnectionOnConnectionCreated.setRequestMethod("GET");
                            httpURLConnectionOnConnectionCreated.setDoOutput(false);
                        } else {
                            httpURLConnectionOnConnectionCreated.setRequestMethod("POST");
                            httpURLConnectionOnConnectionCreated.setDoOutput(true);
                        }
                        try {
                            httpURLConnectionOnConnectionCreated = onConnectionCreated(httpURLConnectionOnConnectionCreated);
                            httpURLConnectionOnConnectionCreated.connect();
                            if (!z && !TextUtils.isEmpty(str2)) {
                                OutputStream outputStream = httpURLConnectionOnConnectionCreated.getOutputStream();
                                outputStream.write(str2.getBytes());
                                if (Utils.DEBUG) {
                                    Log.d(TAG, "[post]" + str2);
                                }
                                outputStream.close();
                            }
                            NetworkError networkErrorHandleResponseCode = handleResponseCode(httpURLConnectionOnConnectionCreated.getResponseCode());
                            if (networkErrorHandleResponseCode == NetworkError.OK && resetableOutputStream != null) {
                                try {
                                    bufferedInputStream = new BufferedInputStream(httpURLConnectionOnConnectionCreated.getInputStream(), 8192);
                                } catch (Exception e4) {
                                    bufferedInputStream = null;
                                    e2 = e4;
                                } catch (Throwable th3) {
                                    bufferedInputStream = null;
                                    th = th3;
                                }
                                try {
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = bufferedInputStream.read(bArr, 0, 1024);
                                            if (i <= 0) {
                                                break;
                                            }
                                            resetableOutputStream.write(bArr, 0, i);
                                        }
                                        resetableOutputStream.flush();
                                        bufferedInputStream.close();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e5) {
                                    e2 = e5;
                                    Log.e(TAG, "Connection Exception for " + url.getHost() + " : read file stream error " + e2);
                                    resetableOutputStream.reset();
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    httpURLConnectionOnConnectionCreated.disconnect();
                                }
                            }
                            httpURLConnectionOnConnectionCreated.disconnect();
                            return networkErrorHandleResponseCode;
                        } catch (ConnectionException e6) {
                            NetworkError networkError = e6.mError;
                            httpURLConnectionOnConnectionCreated.disconnect();
                            return networkError;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        Log.e(TAG, "Connection Exception for " + url.getHost() + " :" + e);
                        if (httpURLConnectionOnConnectionCreated != null) {
                            httpURLConnectionOnConnectionCreated.disconnect();
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnectionOnConnectionCreated;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (MalformedURLException e8) {
                Log.e(TAG, " URL error :" + e8);
            }
        }
        return NetworkError.NETWORK_ERROR;
    }

    public boolean checkURL(URL url) {
        if (url == null) {
            return false;
        }
        String protocol = url.getProtocol();
        return TextUtils.equals(protocol, "http") || TextUtils.equals(protocol, "https");
    }

    public Parameter getParameter() {
        return this.mParameter;
    }

    public JSONObject getResponse() {
        return this.mResponse;
    }

    public String getStringResponse() {
        return this.mString;
    }

    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) throws ConnectionException {
        return httpURLConnection;
    }

    public Parameter onQueryCreated(Parameter parameter) throws ConnectionException {
        return parameter;
    }

    public String onURLCreated(String str, Parameter parameter) throws ConnectionException {
        return str;
    }

    public NetworkError request(ResetableOutputStream resetableOutputStream) throws Throwable {
        if (this.mUrl == null) {
            return NetworkError.URL_ERROR;
        }
        if (!Utils.isConnected(AppGlobal.getContext())) {
            return NetworkError.NETWORK_ERROR;
        }
        if (this.mParameter == null) {
            this.mParameter = new Parameter(this);
        }
        try {
            Parameter parameterOnQueryCreated = onQueryCreated(this.mParameter);
            String string = this.mUrl.toString();
            if (this.mUseGet && !parameterOnQueryCreated.isEmpty()) {
                String query = this.mUrl.getQuery();
                String string2 = this.mUrl.toString();
                if (TextUtils.isEmpty(query)) {
                    string = string2 + "?" + parameterOnQueryCreated.toString();
                } else {
                    string = string2 + a.p + parameterOnQueryCreated.toString();
                }
            }
            try {
                String strOnURLCreated = onURLCreated(string, parameterOnQueryCreated);
                if (Utils.DEBUG) {
                    Log.d(TAG, "connection url: " + strOnURLCreated);
                }
                String string3 = !this.mUseGet ? parameterOnQueryCreated.toString() : "";
                long jCurrentTimeMillis = System.currentTimeMillis();
                NetworkError networkErrorInnerRequest = innerRequest(strOnURLCreated, string3, this.mUseGet, false, resetableOutputStream);
                if (Utils.DEBUG) {
                    Log.d(TAG, "Time(ms) spent in request: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", " + strOnURLCreated);
                }
                return networkErrorInnerRequest;
            } catch (ConnectionException e) {
                return e.mError;
            }
        } catch (ConnectionException e2) {
            return e2.mError;
        }
    }

    public NetworkError requestFile(File file) throws Throwable {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        try {
            FileResetableOutputStream fileResetableOutputStream = new FileResetableOutputStream(file);
            NetworkError networkErrorRequest = request(fileResetableOutputStream);
            try {
                fileResetableOutputStream.close();
                if (networkErrorRequest != NetworkError.OK) {
                    Log.e(TAG, "Connection failed : " + networkErrorRequest);
                    file.delete();
                }
            } catch (IOException unused) {
            }
            return networkErrorRequest;
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e);
            throw e;
        }
    }

    public NetworkError requestJSON() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        NetworkError networkErrorRequest = request(new MemoryResetableOutputStream(byteArrayOutputStream));
        try {
            try {
                if (networkErrorRequest == NetworkError.OK) {
                    this.mResponse = new JSONObject(byteArrayOutputStream.toString());
                } else {
                    Log.e(TAG, "Connection failed : " + networkErrorRequest);
                }
                return networkErrorRequest;
            } catch (JSONException e) {
                Log.e(TAG, "JSON error: " + e);
                NetworkError networkError = NetworkError.RESULT_ERROR;
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return networkError;
            }
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
        }
    }

    public NetworkError requestString() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        NetworkError networkErrorRequest = request(new MemoryResetableOutputStream(byteArrayOutputStream));
        if (networkErrorRequest == NetworkError.OK) {
            this.mString = byteArrayOutputStream.toString();
        } else {
            Log.e(TAG, "Connection failed : " + networkErrorRequest);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return networkErrorRequest;
    }

    public void setNeedBaseParameter(boolean z) {
        this.mNeedBaseParameter = z;
    }

    public void setNeedHosted(boolean z) {
        this.mNeedHosted = z;
    }

    public void setNeedId(boolean z) {
        this.mNeedId = z;
    }

    public void setNeedSessionId(boolean z) {
        this.mNeedSessionID = z;
    }

    public void setUseGet(boolean z) {
        this.mUseGet = z;
    }

    public Connection(String str, String str2) {
        this(connect(str, str2), false);
    }

    public Connection(String str, boolean z) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Log.e(TAG, "URL error: " + e);
            url = null;
        }
        init(url);
        this.mIsBackground = z;
    }
}
