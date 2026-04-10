package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.message.utils.HttpRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f20110e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f20111f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f20112g = false;
    private String a = "10.0.0.172";
    private int b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f20113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f20114d;

    public c(Context context) {
        this.f20113c = context;
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f20113c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f20113c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f20113c, "oversea_domain_p", "");
        String strImprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f20113c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(strImprintProperty3);
        }
        if (!TextUtils.isEmpty(strImprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(strImprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f20112g) {
            return;
        }
        ImprintHandler.getImprintService(this.f20113c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f20113c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f20113c, com.umeng.commonsdk.internal.a.f19991w, com.umeng.commonsdk.internal.b.a(c.this.f20113c).a(), null);
                }
            }
        });
        f20112g = true;
    }

    private void d() {
        if (f20111f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f20113c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f20113c);
                UMWorkDispatch.sendEvent(c.this.f20113c, com.umeng.commonsdk.internal.a.f19987s, com.umeng.commonsdk.internal.b.a(c.this.f20113c).a(), null);
                ImprintHandler.getImprintService(c.this.f20113c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f20113c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f20113c, str2);
                UMWorkDispatch.sendEvent(c.this.f20113c, com.umeng.commonsdk.internal.a.f19987s, com.umeng.commonsdk.internal.b.a(c.this.f20113c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f20113c, o.a.D, CoreProtocol.getInstance(c.this.f20113c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f20113c).b(c.this.f20113c);
                }
                ImprintHandler.getImprintService(c.this.f20113c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f20111f = true;
    }

    public void a(b bVar) {
        this.f20114d = bVar;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f20113c, "domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f20113c, "domain_s", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(strImprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z2, boolean z3, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i2 = 0;
        byte[] bArrA = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i2 >= strArr.length) {
                break;
            }
            String str2 = strArr[i2];
            if (z3) {
                d();
            } else {
                c();
            }
            bArrA = a(bArr, str2 + File.separator + str);
            if (bArrA != null) {
                b bVar = this.f20114d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z2);
                }
            } else {
                b bVar2 = this.f20114d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i2++;
            }
        }
        return bArrA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x016b: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:88:0x0177, block:B:83:0x016b */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z2;
        try {
            try {
                if (this.f20114d != null) {
                    this.f20114d.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    if (!f20110e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f20110e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f20113c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f20113c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    z2 = false;
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
            } catch (UnknownHostException unused4) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused5) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused6) {
                httpsURLConnection = null;
                outputStream = null;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                httpsURLConnection.connect();
                if (this.f20114d != null) {
                    this.f20114d.onRequestEnd();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                String headerField = httpsURLConnection.getHeaderField("Content-Type");
                if (!TextUtils.isEmpty(headerField) && headerField.equalsIgnoreCase(HttpRequest.CONTENT_TYPE_THRIFT)) {
                    z2 = true;
                }
                boolean z3 = AnalyticsConstants.UM_DEBUG;
                if (responseCode != 200 || !z2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                            UMCrashManager.reportCrash(this.f20113c, e2);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused7) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
                InputStream inputStream = httpsURLConnection.getInputStream();
                try {
                    byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            UMCrashManager.reportCrash(this.f20113c, e3);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused8) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return streamToByteArray;
                } finally {
                    HelperUtils.safeClose(inputStream);
                }
            } catch (UnknownHostException unused9) {
                UMLog.aq("A_10200", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f20113c, e4);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused10) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (SSLHandshakeException unused11) {
                UMLog.aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        UMCrashManager.reportCrash(this.f20113c, e5);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused12) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (Throwable unused13) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        UMCrashManager.reportCrash(this.f20113c, e6);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused14) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable th) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e7) {
                    UMCrashManager.reportCrash(this.f20113c, e7);
                }
            }
            if (str == 0) {
                throw th;
            }
            try {
                str.getInputStream().close();
            } catch (IOException unused15) {
            }
            str.disconnect();
            throw th;
        }
    }
}
