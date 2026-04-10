package cn.kuaipan.kss.implement;

import cn.kuaipan.kss.KssDef;
import cn.kuaipan.kss.KssDownload;
import cn.kuaipan.kss.utils.Encode;
import cn.kuaipan.kss.utils.RC4;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/* JADX INFO: loaded from: classes.dex */
public class HttpClientDownload implements KssDownload {
    private HttpClient m_client;
    private byte[] m_dataBuffer;
    private _DownloadProgress m_downProgress;
    private HttpClientProxyHelper m_proxyHelper;
    private KssDownload.RequestDownloadInfo m_downloadInfo = null;
    private int m_currentBlockPos = 0;
    private KssDef.NetState m_netState = KssDef.NetState.Wifi;
    private int m_maxRetryCount = 0;

    public HttpClientDownload(HttpClient httpClient, HttpClientProxyHelper httpClientProxyHelper) {
        this.m_client = null;
        this.m_dataBuffer = null;
        this.m_proxyHelper = null;
        this.m_downProgress = null;
        this.m_client = httpClient;
        this.m_proxyHelper = httpClientProxyHelper;
        this.m_downProgress = new _DownloadProgress();
        this.m_dataBuffer = new byte[KssDef.DOWNLOAD_BUFFER];
    }

    private KssDef.KssAPIResult _downloadBlock(KssDownload.DownloadTransControl downloadTransControl, KssDownload.BlockDownloadInfo blockDownloadInfo) throws Exception {
        RC4 rc4 = new RC4();
        byte[] bArrHexStringToByteArray = Encode.hexStringToByteArray(this.m_downloadInfo.getSecureKey());
        KssDef.KssAPIResult kssAPIResult = KssDef.KssAPIResult.Error;
        for (int i = 0; i < this.m_maxRetryCount; i++) {
            HttpGet httpGet = null;
            try {
                try {
                    HttpClientProxyHelper httpClientProxyHelper = this.m_proxyHelper;
                    HttpGet httpGet2 = httpClientProxyHelper == null ? new HttpGet(blockDownloadInfo.getBlockDownload_FullURL(0)) : httpClientProxyHelper.createGet(blockDownloadInfo.getBlockDownload_FullURL(0));
                    try {
                        try {
                            httpGet2.addHeader("Range", "bytes=" + Integer.toString(this.m_currentBlockPos) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            rc4.makeKey(bArrHexStringToByteArray);
                            InputStream content = this.m_client.execute(httpGet2).getEntity().getContent();
                            KssDef.KssAPIResult kssAPIResult2 = KssDef.KssAPIResult.OK;
                            while (true) {
                                int i2 = content.read(this.m_dataBuffer, 0, KssDef.DOWNLOAD_BUFFER);
                                if (i2 < 0) {
                                    break;
                                }
                                byte[] bArr = this.m_dataBuffer;
                                rc4.genRC4(bArr, 0, i2, bArr, 0);
                                try {
                                    try {
                                        try {
                                            downloadTransControl.addData(this.m_dataBuffer, i2);
                                            try {
                                                this.m_currentBlockPos += i2;
                                                this.m_downProgress.TransBytes(i2);
                                                if (this.m_downProgress.getIsCanceled()) {
                                                    httpGet2.abort();
                                                    kssAPIResult2 = KssDef.KssAPIResult.Cancel;
                                                    break;
                                                }
                                            } catch (IOException unused) {
                                                httpGet = httpGet2;
                                                httpGet.abort();
                                                kssAPIResult = KssDef.KssAPIResult.NetTimeout;
                                            }
                                        } catch (RuntimeException unused2) {
                                            httpGet = httpGet2;
                                            httpGet.abort();
                                            kssAPIResult = KssDef.KssAPIResult.Error;
                                        } catch (Exception unused3) {
                                            kssAPIResult = KssDef.KssAPIResult.Error;
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        e.printStackTrace();
                                        kssAPIResult2 = KssDef.KssAPIResult.Error;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            }
                            kssAPIResult = kssAPIResult2;
                        } catch (IOException unused4) {
                        }
                    } catch (RuntimeException unused5) {
                    }
                } catch (IOException unused6) {
                } catch (RuntimeException unused7) {
                }
            } catch (Exception unused8) {
            }
            if (kssAPIResult != KssDef.KssAPIResult.NetTimeout) {
                break;
            }
        }
        return kssAPIResult;
    }

    @Override // cn.kuaipan.kss.KssDownload
    public KssDef.KssAPIResult download(OutputStream outputStream, int i) throws Exception {
        if (i < 0) {
            i = 0;
        }
        KPDownloadTransControl kPDownloadTransControl = new KPDownloadTransControl();
        kPDownloadTransControl.init(outputStream);
        kPDownloadTransControl.setStartPos(i);
        return download(kPDownloadTransControl);
    }

    @Override // cn.kuaipan.kss.KssDownload
    public boolean init(KssDownload.RequestDownloadInfo requestDownloadInfo, KssDef.OnUpDownload onUpDownload, KssDef.NetState netState) {
        this.m_downloadInfo = requestDownloadInfo;
        this.m_downProgress.init(requestDownloadInfo, onUpDownload);
        this.m_netState = netState;
        this.m_maxRetryCount = KssDef.NET_RETRY_TIMES;
        if (netState == KssDef.NetState.Wifi) {
            return true;
        }
        this.m_maxRetryCount = KssDef.NET_RETRY_TIMES * 2;
        return true;
    }

    @Override // cn.kuaipan.kss.KssDownload
    public void terminal() {
        this.m_client = null;
        this.m_dataBuffer = null;
        this.m_proxyHelper = null;
        this.m_downloadInfo = null;
        this.m_downProgress = null;
    }

    @Override // cn.kuaipan.kss.KssDownload
    public KssDef.KssAPIResult download(KssDownload.DownloadTransControl downloadTransControl) throws Exception {
        boolean z;
        HttpClientProxyHelper httpClientProxyHelper;
        this.m_downProgress.startTrans(downloadTransControl);
        this.m_currentBlockPos = downloadTransControl.getStartPos() % KssDef.BLOCKSIZE;
        KssDef.KssAPIResult kssAPIResult_downloadBlock = KssDef.KssAPIResult.Error;
        for (int startPos = downloadTransControl.getStartPos() / KssDef.BLOCKSIZE; startPos < this.m_downloadInfo.getBlockCount(); startPos++) {
            KssDownload.BlockDownloadInfo blockInfos = this.m_downloadInfo.getBlockInfos(startPos);
            while (true) {
                for (true; z; false) {
                    kssAPIResult_downloadBlock = _downloadBlock(downloadTransControl, blockInfos);
                    z = kssAPIResult_downloadBlock == KssDef.KssAPIResult.NetTimeout && (httpClientProxyHelper = this.m_proxyHelper) != null && httpClientProxyHelper.nextProxy();
                }
            }
            if (kssAPIResult_downloadBlock != KssDef.KssAPIResult.OK) {
                break;
            }
            this.m_currentBlockPos = 0;
        }
        if (kssAPIResult_downloadBlock == KssDef.KssAPIResult.OK) {
            downloadTransControl.setEndState(KssDownload.DownloadTransControl.EndState.Completed);
        } else {
            downloadTransControl.setEndState(KssDownload.DownloadTransControl.EndState.Interrupt);
        }
        return kssAPIResult_downloadBlock;
    }
}
