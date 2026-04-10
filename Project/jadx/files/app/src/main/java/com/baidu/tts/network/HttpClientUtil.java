package com.baidu.tts.network;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public class HttpClientUtil {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    public static final int DEFAULT_TIMEOUT = 3000;
    private static final String REQUESTMETHOD_GET = "GET";
    private static final String REQUESTMETHOD_POST = "POST";
    private static final String TAG = "HttpClientUtil";
    private static String[] VERIFY_HOST_NAME_ARRAY = new String[0];
    private static SSLContext mSSLContext;
    private boolean isUrlEncodingEnabled = true;
    private int mTimeOut = 3000;
    private Proxy proxy = null;
    private String contentType = null;
    private int statusCode = -1;
    private HttpURLConnection httpURLConnection = null;
    final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.baidu.tts.network.HttpClientUtil.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            try {
                String peerHost = sSLSession.getPeerHost();
                for (X509Certificate x509Certificate : (X509Certificate[]) sSLSession.getPeerCertificates()) {
                    X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                    try {
                        x509Certificate.getSubjectAlternativeNames();
                    } catch (CertificateParsingException e2) {
                        e2.printStackTrace();
                    }
                    for (String str2 : subjectX500Principal.getName().split(",")) {
                        if (str2.startsWith("CN") && peerHost.equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (SSLPeerUnverifiedException e3) {
                e3.printStackTrace();
            }
            return false;
        }
    };

    public HttpClientUtil() {
        if (mSSLContext == null) {
            try {
                mSSLContext = SSLContext.getInstance("TLS");
                mSSLContext.init(null, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void makeRequest(String str, String str2, String str3, ResponseHandlerInterface responseHandlerInterface) {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> headerFields = null;
        try {
            try {
                try {
                    try {
                        try {
                            URL url = !this.isUrlEncodingEnabled ? new URL(URLDecoder.decode(str, "UTF-8")) : new URL(str);
                            if (url.getProtocol().toLowerCase().equals("https")) {
                                if (this.proxy != null) {
                                    this.httpURLConnection = (HttpsURLConnection) url.openConnection(this.proxy);
                                } else {
                                    this.httpURLConnection = (HttpsURLConnection) url.openConnection();
                                }
                                ((HttpsURLConnection) this.httpURLConnection).setHostnameVerifier(this.DO_NOT_VERIFY);
                                if (mSSLContext != null) {
                                    ((HttpsURLConnection) this.httpURLConnection).setSSLSocketFactory(mSSLContext.getSocketFactory());
                                }
                            } else if (this.proxy != null) {
                                this.httpURLConnection = (HttpURLConnection) url.openConnection(this.proxy);
                            } else {
                                this.httpURLConnection = (HttpURLConnection) url.openConnection();
                            }
                            if (responseHandlerInterface instanceof RangeFileAsyncHttpResponseHandler) {
                                ((RangeFileAsyncHttpResponseHandler) responseHandlerInterface).updateRequestHeaders(this.httpURLConnection);
                            }
                            responseHandlerInterface.setRequestURI(URI.create(str));
                            this.httpURLConnection.setRequestMethod(str3);
                            this.httpURLConnection.setConnectTimeout(this.mTimeOut);
                            this.httpURLConnection.setReadTimeout(this.mTimeOut);
                            if (str3 == "POST") {
                                this.httpURLConnection.setDoInput(true);
                                this.httpURLConnection.setDoOutput(true);
                                OutputStream outputStream = this.httpURLConnection.getOutputStream();
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                                bufferedOutputStream.write(str2.getBytes());
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                outputStream.close();
                            }
                            this.statusCode = this.httpURLConnection.getResponseCode();
                            LoggerProxy.d(TAG, "ResponseCode: " + this.statusCode);
                            this.contentType = this.httpURLConnection.getContentType();
                            headerFields = this.httpURLConnection.getHeaderFields();
                            HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
                            httpResponseEntity.setContentLength(this.httpURLConnection.getContentLength());
                            httpResponseEntity.setInputStream(this.httpURLConnection.getInputStream());
                            httpResponseEntity.setHeader(headerFields);
                            httpResponseEntity.setContentEncoding(this.httpURLConnection.getContentEncoding());
                            httpResponseEntity.setContentType(this.contentType);
                            httpResponseEntity.setResponseCode(this.statusCode);
                            responseHandlerInterface.sendResponseMessage(httpResponseEntity);
                            httpURLConnection = this.httpURLConnection;
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (MalformedURLException e2) {
                            if (responseHandlerInterface != null) {
                                responseHandlerInterface.sendErrorMessage(this.statusCode, headerFields, this.contentType, e2);
                            }
                            e2.printStackTrace();
                            httpURLConnection = this.httpURLConnection;
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (IOException e3) {
                            if (responseHandlerInterface != null) {
                                responseHandlerInterface.sendErrorMessage(this.statusCode, headerFields, this.contentType, e3);
                            }
                            e3.printStackTrace();
                            httpURLConnection = this.httpURLConnection;
                            if (httpURLConnection == null) {
                                return;
                            }
                        }
                    } catch (InterruptedIOException e4) {
                        LoggerProxy.d(TAG, e4.toString());
                        httpURLConnection = this.httpURLConnection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                } catch (Exception e5) {
                    if (responseHandlerInterface != null) {
                        responseHandlerInterface.sendErrorMessage(this.statusCode, headerFields, this.contentType, e5);
                    }
                    e5.printStackTrace();
                    httpURLConnection = this.httpURLConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
            } catch (SocketTimeoutException e6) {
                if (responseHandlerInterface != null) {
                    responseHandlerInterface.sendErrorMessage(this.statusCode, headerFields, this.contentType, e6);
                }
                e6.printStackTrace();
                httpURLConnection = this.httpURLConnection;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public void get(String str, ResponseHandlerInterface responseHandlerInterface) {
        makeRequest(str, "", "GET", responseHandlerInterface);
    }

    public int getTimeOut(int i2) {
        return this.mTimeOut;
    }

    public boolean isUrlEncodingEnabled() {
        return this.isUrlEncodingEnabled;
    }

    public void post(String str, String str2, ResponseHandlerInterface responseHandlerInterface) {
        makeRequest(str, str2, "POST", responseHandlerInterface);
    }

    public void setProxy(String str, int i2) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
    }

    public void setTimeOut(int i2) {
        if (i2 < 1000) {
            i2 = 3000;
        }
        this.mTimeOut = i2;
    }

    public void setURLEncodingEnabled(boolean z2) {
        this.isUrlEncodingEnabled = z2;
    }

    public void stop() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
