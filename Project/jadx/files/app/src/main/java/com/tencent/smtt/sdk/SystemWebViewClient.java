package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient extends android.webkit.WebViewClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18866c;
    private WebViewClient a;
    private WebView b;

    private static class a extends ClientCertRequest {
        private android.webkit.ClientCertRequest a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.a.proceed(privateKey, x509CertificateArr);
        }
    }

    private static class b implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.a.useHttpAuthUsernamePassword();
        }
    }

    private static class c implements SslErrorHandler {
        android.webkit.SslErrorHandler a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.a.proceed();
        }
    }

    private static class d implements SslError {
        android.net.http.SslError a;

        d(android.net.http.SslError sslError) {
            this.a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i2) {
            return this.a.addError(i2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i2) {
            return this.a.hasError(i2);
        }
    }

    static class e implements WebResourceRequest {
        private String a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f18867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f18868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f18869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, String> f18870f;

        public e(String str, boolean z2, boolean z3, boolean z4, String str2, Map<String, String> map) {
            this.a = str;
            this.b = z2;
            this.f18867c = z3;
            this.f18868d = z4;
            this.f18869e = str2;
            this.f18870f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f18869e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f18870f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f18868d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f18867c;
        }
    }

    private static class f implements WebResourceRequest {
        android.webkit.WebResourceRequest a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object objA = com.tencent.smtt.utils.j.a(this.a, "isRedirect");
                if (objA instanceof Boolean) {
                    return ((Boolean) objA).booleanValue();
                }
            }
            return false;
        }
    }

    private static class g extends WebResourceResponse {
        android.webkit.WebResourceResponse a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i2, String str) {
            this.a.setStatusCodeAndReasonPhrase(i2, str);
        }
    }

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z2) {
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z2);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.a.onPageCommitVisible(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) throws Throwable {
        com.tencent.smtt.utils.p pVarA;
        TbsPrivacyAccess.rmPrivacyItemIfNeeded(webView.getContext().getApplicationContext());
        if (f18866c == null && (pVarA = com.tencent.smtt.utils.p.a()) != null) {
            pVarA.a(true);
            f18866c = Boolean.toString(true);
        }
        this.b.a(webView);
        this.b.a++;
        this.a.onPageFinished(this.b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.c();
        if (!TbsShareManager.mHasQueryed && this.b.getContext() != null && TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TbsDownloader.needDownload(SystemWebViewClient.this.b.getContext(), false);
                }
            }).start();
        }
        if (this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i2, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, webResourceRequest != null ? new f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(android.webkit.WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        this.b.a(webView);
        return this.a.onRenderProcessGone(this.b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.3
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                return renderProcessGoneDetail.didCrash();
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r10, android.webkit.WebResourceRequest r11) {
        /*
            r9 = this;
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 0
            r1 = 21
            if (r10 >= r1) goto L8
            return r0
        L8:
            if (r11 != 0) goto Lb
            return r0
        Lb:
            r1 = 0
            r2 = 24
            if (r10 < r2) goto L22
            java.lang.String r10 = "isRedirect"
            java.lang.Object r10 = com.tencent.smtt.utils.j.a(r11, r10)
            boolean r2 = r10 instanceof java.lang.Boolean
            if (r2 == 0) goto L22
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r1 = r10.booleanValue()
            r5 = r1
            goto L23
        L22:
            r5 = 0
        L23:
            com.tencent.smtt.sdk.SystemWebViewClient$e r10 = new com.tencent.smtt.sdk.SystemWebViewClient$e
            android.net.Uri r1 = r11.getUrl()
            java.lang.String r3 = r1.toString()
            boolean r4 = r11.isForMainFrame()
            boolean r6 = r11.hasGesture()
            java.lang.String r7 = r11.getMethod()
            java.util.Map r8 = r11.getRequestHeaders()
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.tencent.smtt.sdk.WebViewClient r11 = r9.a
            com.tencent.smtt.sdk.WebView r1 = r9.b
            com.tencent.smtt.export.external.interfaces.WebResourceResponse r10 = r11.shouldInterceptRequest(r1, r10)
            if (r10 != 0) goto L4c
            return r0
        L4c:
            android.webkit.WebResourceResponse r11 = new android.webkit.WebResourceResponse
            java.lang.String r0 = r10.getMimeType()
            java.lang.String r1 = r10.getEncoding()
            java.io.InputStream r2 = r10.getData()
            r11.<init>(r0, r1, r2)
            java.util.Map r0 = r10.getResponseHeaders()
            r11.setResponseHeaders(r0)
            int r0 = r10.getStatusCode()
            java.lang.String r10 = r10.getReasonPhrase()
            int r1 = r11.getStatusCode()
            if (r0 != r1) goto L7e
            if (r10 == 0) goto L81
            java.lang.String r1 = r11.getReasonPhrase()
            boolean r1 = r10.equals(r1)
            if (r1 != 0) goto L81
        L7e:
            r11.setStatusCodeAndReasonPhrase(r0, r10)
        L81:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.SystemWebViewClient.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse webResourceResponseShouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (webResourceResponseShouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str)) != null) {
            return new android.webkit.WebResourceResponse(webResourceResponseShouldInterceptRequest.getMimeType(), webResourceResponseShouldInterceptRequest.getEncoding(), webResourceResponseShouldInterceptRequest.getData());
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r8, android.webkit.WebResourceRequest r9) {
        /*
            r7 = this;
            if (r9 == 0) goto L11
            android.net.Uri r0 = r9.getUrl()
            if (r0 == 0) goto L11
            android.net.Uri r0 = r9.getUrl()
            java.lang.String r0 = r0.toString()
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L63
            com.tencent.smtt.sdk.WebView r1 = r7.b
            boolean r0 = r1.showDebugView(r0)
            if (r0 == 0) goto L1d
            goto L63
        L1d:
            com.tencent.smtt.sdk.WebView r0 = r7.b
            r0.a(r8)
            r8 = 0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L3b
            java.lang.String r0 = "isRedirect"
            java.lang.Object r0 = com.tencent.smtt.utils.j.a(r9, r0)
            boolean r1 = r0 instanceof java.lang.Boolean
            if (r1 == 0) goto L3b
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r8 = r0.booleanValue()
            r3 = r8
            goto L3c
        L3b:
            r3 = 0
        L3c:
            com.tencent.smtt.sdk.SystemWebViewClient$e r8 = new com.tencent.smtt.sdk.SystemWebViewClient$e
            android.net.Uri r0 = r9.getUrl()
            java.lang.String r1 = r0.toString()
            boolean r2 = r9.isForMainFrame()
            boolean r4 = r9.hasGesture()
            java.lang.String r5 = r9.getMethod()
            java.util.Map r6 = r9.getRequestHeaders()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.tencent.smtt.sdk.WebViewClient r9 = r7.a
            com.tencent.smtt.sdk.WebView r0 = r7.b
            boolean r8 = r9.shouldOverrideUrlLoading(r0, r8)
            return r8
        L63:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.SystemWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.a.shouldOverrideUrlLoading(this.b, str);
    }
}
