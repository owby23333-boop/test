package com.kwad.components.core.offline.init.kwai;

import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements IOfflineHostApi {
    private IOfflineCompoLogcat KA;
    private ICrash KB;
    private ILoggerReporter KC;
    private IDownloader KD;
    private IImageLoader KE;
    private IVideo KF;
    private ILive KG;
    private ICache KH;
    private IWebView KI;
    private IVibratorUtil KJ;
    private IAsync Kv;
    private IEnvironment Kw;
    private IZipper Kx;
    private INet Ky;
    private IEncrypt Kz;

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.Kv == null) {
            this.Kv = new a();
        }
        return this.Kv;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.KH == null) {
            this.KH = new b();
        }
        return this.KH;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.KB == null) {
            this.KB = new ICrash() { // from class: com.kwad.components.core.offline.init.kwai.g.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.b.gatherException(th);
                }
            };
        }
        return this.KB;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.KD == null) {
            this.KD = new IDownloader() { // from class: com.kwad.components.core.offline.init.kwai.g.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.c(str, file);
                }
            };
        }
        return this.KD;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.Kz == null) {
            this.Kz = new c();
        }
        return this.Kz;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.Kw == null) {
            this.Kw = new d();
        }
        return this.Kw;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.KE == null) {
            this.KE = new e();
        }
        return this.KE;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.KG == null) {
            this.KG = new com.kwad.components.core.offline.init.a.a();
        }
        return this.KG;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.KA == null) {
            this.KA = new h();
        }
        return this.KA;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.KC == null) {
            this.KC = new ILoggerReporter() { // from class: com.kwad.components.core.offline.init.kwai.g.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                    KSLoggerReporter.a(str, businessType, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, str2, jSONObject);
                }
            };
        }
        return this.KC;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.Ky == null) {
            this.Ky = new f();
        }
        return this.Ky;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.KJ == null) {
            this.KJ = new j();
        }
        return this.KJ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.KF == null) {
            this.KF = new com.kwad.components.core.offline.init.b.e();
        }
        return this.KF;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.KI == null) {
            this.KI = new com.kwad.components.core.offline.init.c.b();
        }
        return this.KI;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.Kx == null) {
            this.Kx = new k();
        }
        return this.Kx;
    }
}
