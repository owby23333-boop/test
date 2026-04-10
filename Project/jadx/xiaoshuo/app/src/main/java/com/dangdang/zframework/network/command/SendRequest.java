package com.dangdang.zframework.network.command;

import com.alipay.sdk.m.w.a;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.network.IRequest;
import com.dangdang.zframework.network.RequestConstant;
import com.dangdang.zframework.utils.DangDangParams;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes10.dex */
public class SendRequest {
    private final int DEFAULT_TIMEOUT;
    private final String PROTOCOL_HTTP;
    private final String PROTOCOL_HTTPS;
    private IRequest mBaseRequestCommand;
    protected HttpURLConnection mHttpClient;
    private RequestConstant.HttpMode mHttpMode;
    private RequestConstant.HttpType mHttpType;
    protected String mPost;
    private boolean mRequestFinish;
    private int mTimeout;
    protected String mUrl;

    /* JADX INFO: renamed from: com.dangdang.zframework.network.command.SendRequest$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpMode;
        static final /* synthetic */ int[] $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpType;

        static {
            int[] iArr = new int[RequestConstant.HttpMode.values().length];
            $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpMode = iArr;
            try {
                iArr[RequestConstant.HttpMode.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpMode[RequestConstant.HttpMode.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RequestConstant.HttpType.values().length];
            $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpType = iArr2;
            try {
                iArr2[RequestConstant.HttpType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpType[RequestConstant.HttpType.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SendRequest(IRequest iRequest) {
        this.mRequestFinish = false;
        this.DEFAULT_TIMEOUT = 15000;
        this.mHttpType = RequestConstant.HttpType.HTTP;
        this.mHttpMode = RequestConstant.HttpMode.POST;
        this.mTimeout = 15000;
        this.PROTOCOL_HTTP = "http://";
        this.PROTOCOL_HTTPS = "https://";
        this.mBaseRequestCommand = iRequest;
    }

    private HttpURLConnection getHttpClient(int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private HttpsURLConnection getHttpsClient(int i) {
        try {
            if (this.mBaseRequestCommand.isTrustAllHost()) {
                trustAllHosts();
            }
            return (HttpsURLConnection) getHttpClient(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void trustAllHosts() {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.dangdang.zframework.network.command.SendRequest.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                if (x509CertificateArr == null) {
                    throw new IllegalArgumentException("checkServerTrusted:x509Certificate array isnull");
                }
                if (x509CertificateArr.length <= 0) {
                    throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
                }
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                    trustManagerFactory.init((KeyStore) null);
                    for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                        ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                    }
                    if (!"30820122300d06092a864886f70d01010105000382010f003082010a0282010100b6ed1cc630c37bb7c38f988ab72ffa0ffdaf1886c733c272fba70f634d503f0168dfd7173fa49a20764a6a6747fbcda42d05382753a4d4ac6eaf998e268efa9e42d10fed08dad66049a1ffafabe10b47ce7b46e612c3032bfc37034dcc165c869bcd154ae56cef1c14c857e374a25f31ec451bece1ae2b3fba81d11447654edb9f439d589c39688a12f6a70dc2a04eed5ee09186d61171e4420548eb8c6f36f1f5a8a83921cd76c80d01d7dd152d934e002ae60224e89f2a06e3d0bfcfefec655310bcfe1346cf0b323cc8098b55b41547694150c9c7d30b5dcac661ec5e3ea486d5ca13c7e5acd50be49f81943953fa44ef0a7bf0a8c36aad7f7b4f9620c34b0203010001".equalsIgnoreCase(new BigInteger(1, ((RSAPublicKey) x509CertificateArr[0].getPublicKey()).getEncoded()).toString(16))) {
                        throw new CertificateException("checkServerTrusted error");
                    }
                } catch (Exception e) {
                    throw new CertificateException(e);
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.dangdang.zframework.network.command.SendRequest.2
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return (str == null || "".equals(str)) ? HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession) : str.contains("dangdang.com");
            }
        });
    }

    public boolean abortRequest() {
        if (this.mRequestFinish) {
            return false;
        }
        closeConnection();
        this.mRequestFinish = true;
        return true;
    }

    public void addHeader() {
        HashMap<String, String> customHeader = getCustomHeader();
        if (customHeader != null) {
            for (Map.Entry<String, String> entry : customHeader.entrySet()) {
                this.mHttpClient.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void closeConnection() {
        try {
            HttpURLConnection httpURLConnection = this.mHttpClient;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mHttpClient = null;
    }

    public HttpURLConnection executeHttp() throws Exception {
        init();
        int i = AnonymousClass3.$SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpMode[this.mHttpMode.ordinal()];
        if (i == 1) {
            this.mHttpClient.setRequestMethod("GET");
        } else if (i == 2) {
            this.mHttpClient.setRequestMethod("POST");
            this.mHttpClient.setDoOutput(true);
            this.mHttpClient.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        addHeader();
        this.mHttpClient.connect();
        if (this.mHttpMode == RequestConstant.HttpMode.POST) {
            PrintWriter printWriter = new PrintWriter(this.mHttpClient.getOutputStream());
            printWriter.write(this.mPost);
            printWriter.flush();
            printWriter.close();
        }
        return this.mHttpClient;
    }

    public HashMap<String, String> getCustomHeader() {
        return null;
    }

    public HttpURLConnection getDefaultHttpClient(int i) throws IOException {
        int i2 = AnonymousClass3.$SwitchMap$com$dangdang$zframework$network$RequestConstant$HttpType[this.mHttpType.ordinal()];
        if (i2 == 1) {
            return getHttpClient(i);
        }
        if (i2 != 2) {
            return null;
        }
        this.mUrl = this.mUrl.replace("http://", "https://");
        return getHttpsClient(i);
    }

    public String getUrl() {
        RequestConstant.HttpMode httpMode = this.mHttpMode;
        if (httpMode != RequestConstant.HttpMode.GET && httpMode == RequestConstant.HttpMode.POST) {
            return this.mUrl + a.p + this.mPost;
        }
        return this.mUrl;
    }

    public void init() throws IOException {
        this.mHttpMode = this.mBaseRequestCommand.getHttpMode();
        this.mUrl = this.mBaseRequestCommand.getUrl();
        this.mPost = this.mBaseRequestCommand.getPost();
        initPublicParams();
        if (this.mHttpClient == null || this.mHttpType != this.mBaseRequestCommand.getHttpType()) {
            this.mHttpType = this.mBaseRequestCommand.getHttpType();
            this.mHttpClient = getDefaultHttpClient(this.mTimeout);
        }
    }

    public void initPublicParams() {
        try {
            if (this.mBaseRequestCommand.getDataType() == RequestConstant.DataType.TEXT) {
                String publicParams = DangDangParams.getPublicParams();
                RequestConstant.HttpMode httpMode = this.mHttpMode;
                if (httpMode != RequestConstant.HttpMode.GET) {
                    if (httpMode == RequestConstant.HttpMode.POST) {
                        if (this.mPost == null) {
                            this.mPost = "";
                        }
                        this.mPost += publicParams;
                        return;
                    }
                    return;
                }
                if (!this.mUrl.contains("?")) {
                    this.mUrl += "?occupy=";
                }
                this.mUrl += publicParams;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isRequestFinished() {
        return this.mRequestFinish;
    }

    public void setRequestFinish() {
        this.mRequestFinish = true;
    }

    public void setTimeOut(int i) {
        try {
            HttpURLConnection httpURLConnection = this.mHttpClient;
            if (httpURLConnection != null) {
                httpURLConnection.setReadTimeout(i);
                this.mHttpClient.setConnectTimeout(i);
            }
        } catch (Exception e) {
            LogM.e(e.toString());
        }
    }

    public SendRequest(int i, IRequest iRequest) {
        this.mRequestFinish = false;
        this.DEFAULT_TIMEOUT = 15000;
        this.mHttpType = RequestConstant.HttpType.HTTP;
        this.mHttpMode = RequestConstant.HttpMode.POST;
        this.PROTOCOL_HTTP = "http://";
        this.PROTOCOL_HTTPS = "https://";
        this.mBaseRequestCommand = iRequest;
        this.mTimeout = i;
    }
}
