package cn.kuaipan.kss.implement;

import cn.kuaipan.kss.KssDef;
import cn.kuaipan.kss.KssUpload;
import cn.kuaipan.kss.utils.RC4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.zip.CRC32;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes.dex */
public class HttpClientUpload implements KssUpload {
    private int CHUNKSIZE;
    private byte[] m_chunkDataBuffer;
    private HttpClient m_client;
    private CRC32 m_crc32;
    private _UploadProgress m_progress;
    private HttpClientProxyHelper m_proxyHelper;
    private RC4 m_rc4;
    private KssUpload.RequestUploadInfo m_requestInfo;
    private _UploadResult m_uploadResult;

    public HttpClientUpload(HttpClient httpClient, HttpClientProxyHelper httpClientProxyHelper) {
        int i = KssDef.CHUNKSIZE_MIN;
        this.CHUNKSIZE = i;
        this.m_client = null;
        this.m_proxyHelper = null;
        this.m_requestInfo = null;
        this.m_progress = null;
        this.m_uploadResult = null;
        this.m_chunkDataBuffer = new byte[i];
        this.m_rc4 = new RC4();
        this.m_crc32 = new CRC32();
        this.m_client = httpClient;
        this.m_proxyHelper = httpClientProxyHelper;
        this.m_progress = new _UploadProgress();
        this.m_uploadResult = new _UploadResult();
    }

    private HttpPost _genUploadChunkPost(URI uri, byte[] bArr, int i) {
        HttpClientProxyHelper httpClientProxyHelper = this.m_proxyHelper;
        HttpPost httpPost = httpClientProxyHelper == null ? new HttpPost(uri) : httpClientProxyHelper.createPost(uri);
        httpPost.setEntity(i == bArr.length ? new ByteArrayEntity(bArr) : new InputStreamEntity(new ByteArrayInputStream(bArr, 0, i), i));
        return httpPost;
    }

    private URI _genUploadChunkURI(String str, int i, int i2, _UploadChunkInfo _uploadchunkinfo) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("chunk_pos", Integer.toString(i)));
        arrayList.add(new BasicNameValuePair("body_sum", str));
        if (i == 0) {
            arrayList.add(new BasicNameValuePair("file_meta", this.m_requestInfo.getFileMeta()));
            arrayList.add(new BasicNameValuePair("block_meta", this.m_requestInfo.getBlockMeta(i2)));
        } else {
            arrayList.add(new BasicNameValuePair("upload_id", _uploadchunkinfo.getUploadID()));
        }
        return URIUtils.createURI(this.m_requestInfo.getProtocol(), this.m_requestInfo.getNodeIP(0), -1, KssDef.FUNC_UPLOADBLOCKCHUNK, URLEncodedUtils.format(arrayList, "UTF-8"), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.kuaipan.kss.KssDef.KssAPIResult _parseResponse(org.apache.http.HttpResponse r6, cn.kuaipan.kss.implement._UploadChunkInfo r7) throws java.lang.Throwable {
        /*
            r5 = this;
            cn.kuaipan.kss.KssDef$KssAPIResult r0 = cn.kuaipan.kss.KssDef.KssAPIResult.OK
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
            org.apache.http.HttpEntity r6 = r6.getEntity()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
            java.io.InputStream r6 = r6.getContent()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37 java.lang.IllegalStateException -> L3f
        L1a:
            java.lang.String r6 = r3.readLine()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30 java.lang.IllegalStateException -> L32
            if (r6 == 0) goto L24
            r1.append(r6)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30 java.lang.IllegalStateException -> L32
            goto L1a
        L24:
            r3.close()     // Catch: java.lang.Exception -> L28
            goto L4a
        L28:
            r6 = move-exception
            r6.printStackTrace()
            goto L4a
        L2d:
            r6 = move-exception
            r2 = r3
            goto L57
        L30:
            r2 = r3
            goto L37
        L32:
            r6 = move-exception
            r2 = r3
            goto L40
        L35:
            r6 = move-exception
            goto L57
        L37:
            cn.kuaipan.kss.KssDef$KssAPIResult r0 = cn.kuaipan.kss.KssDef.KssAPIResult.NetTimeout     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Exception -> L28
            goto L4a
        L3f:
            r6 = move-exception
        L40:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L35
            cn.kuaipan.kss.KssDef$KssAPIResult r0 = cn.kuaipan.kss.KssDef.KssAPIResult.Error     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Exception -> L28
        L4a:
            cn.kuaipan.kss.KssDef$KssAPIResult r6 = cn.kuaipan.kss.KssDef.KssAPIResult.OK
            if (r0 != r6) goto L56
            java.lang.String r6 = r1.toString()
            cn.kuaipan.kss.KssDef$KssAPIResult r0 = r7.parseInfo(r6)
        L56:
            return r0
        L57:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.lang.Exception -> L5d
            goto L61
        L5d:
            r7 = move-exception
            r7.printStackTrace()
        L61:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.kuaipan.kss.implement.HttpClientUpload._parseResponse(org.apache.http.HttpResponse, cn.kuaipan.kss.implement._UploadChunkInfo):cn.kuaipan.kss.KssDef$KssAPIResult");
    }

    private int _readChunkData(InputStream inputStream, byte[] bArr) throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = this.CHUNKSIZE;
            if (i2 >= i3 || (i = inputStream.read(bArr, i2, i3 - i2)) < 0) {
                break;
            }
            i2 += i;
        }
        return i2;
    }

    private KssDef.KssAPIResult _upload(InputStream inputStream) throws Exception {
        int blockCount = this.m_requestInfo.getBlockCount();
        for (int i = 0; i < blockCount; i++) {
            if (this.m_requestInfo.getBlockIsExist(i)) {
                inputStream.skip(KssDef.BLOCKSIZE);
                this.m_uploadResult.addCommitMeta(this.m_requestInfo.getBlockMeta(i));
                if (!this.m_progress.TransBytes(KssDef.BLOCKSIZE)) {
                    return KssDef.KssAPIResult.Cancel;
                }
            } else {
                _UploadChunkInfo _uploadchunkinfo = new _UploadChunkInfo();
                KssDef.KssAPIResult kssAPIResult_uploadBlock = _uploadBlock(inputStream, i, _uploadchunkinfo);
                if (kssAPIResult_uploadBlock != KssDef.KssAPIResult.OK) {
                    return kssAPIResult_uploadBlock;
                }
                this.m_uploadResult.addCommitMeta(_uploadchunkinfo.getCommitMeta());
            }
        }
        return KssDef.KssAPIResult.OK;
    }

    private KssDef.KssAPIResult _uploadBlock(InputStream inputStream, int i, _UploadChunkInfo _uploadchunkinfo) throws Exception {
        int i_readChunkData;
        KssDef.KssAPIResult kssAPIResult_uploadChunk;
        KssDef.KssAPIResult kssAPIResult = KssDef.KssAPIResult.OK;
        int i2 = 0;
        while (true) {
            try {
                i_readChunkData = _readChunkData(inputStream, this.m_chunkDataBuffer);
            } catch (IOException unused) {
                kssAPIResult = KssDef.KssAPIResult.Error;
                i_readChunkData = 0;
            }
            if (i_readChunkData == 0) {
                return kssAPIResult;
            }
            this.m_rc4.makeKey(this.m_requestInfo.getSeureKey());
            RC4 rc4 = this.m_rc4;
            byte[] bArr = this.m_chunkDataBuffer;
            rc4.genRC4(bArr, 0, i_readChunkData, bArr, 0);
            boolean z = false;
            do {
                kssAPIResult_uploadChunk = _uploadChunk(i, i2, i_readChunkData, _uploadchunkinfo);
                if (KssDef.KssAPIResult.NetTimeout == kssAPIResult_uploadChunk) {
                    HttpClientProxyHelper httpClientProxyHelper = this.m_proxyHelper;
                    z = httpClientProxyHelper != null && httpClientProxyHelper.nextProxy();
                }
            } while (z);
            if (KssDef.KssAPIResult.OK != kssAPIResult_uploadChunk || (i2 = i2 + i_readChunkData) >= KssDef.BLOCKSIZE) {
                break;
            }
            kssAPIResult = kssAPIResult_uploadChunk;
        }
        return kssAPIResult_uploadChunk;
    }

    private KssDef.KssAPIResult _uploadChunk(int i, int i2, int i3, _UploadChunkInfo _uploadchunkinfo) throws Exception {
        KssDef.KssAPIResult kssAPIResult_parseResponse;
        KssDef.KssAPIResult kssAPIResult = KssDef.KssAPIResult.OK;
        this.m_crc32.reset();
        int i4 = 0;
        this.m_crc32.update(this.m_chunkDataBuffer, 0, i3);
        HttpPost httpPost = null;
        try {
            try {
                URI uri_genUploadChunkURI = _genUploadChunkURI(Integer.toString((int) this.m_crc32.getValue()), i2, i, _uploadchunkinfo);
                HttpPost httpPost_genUploadChunkPost = null;
                HttpResponse httpResponseExecute = null;
                while (i4 < KssDef.NET_RETRY_TIMES) {
                    try {
                        try {
                            httpPost_genUploadChunkPost = _genUploadChunkPost(uri_genUploadChunkURI, this.m_chunkDataBuffer, i3);
                            try {
                                httpResponseExecute = this.m_client.execute(httpPost_genUploadChunkPost);
                            } catch (ClientProtocolException e) {
                                throw e;
                            } catch (IOException unused) {
                                httpPost_genUploadChunkPost.abort();
                                httpResponseExecute = null;
                            } catch (Exception e2) {
                                throw e2;
                            }
                            i4++;
                            if (httpResponseExecute != null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpPost = httpPost_genUploadChunkPost;
                            httpPost.abort();
                            throw th;
                        }
                    } catch (Exception e3) {
                        throw e3;
                    }
                }
                HttpPost httpPost2 = httpPost_genUploadChunkPost;
                if (httpResponseExecute == null) {
                    kssAPIResult_parseResponse = KssDef.KssAPIResult.NetTimeout;
                } else {
                    kssAPIResult_parseResponse = _parseResponse(httpResponseExecute, _uploadchunkinfo);
                    if (kssAPIResult_parseResponse == KssDef.KssAPIResult.OK && !this.m_progress.TransBytes(i3)) {
                        kssAPIResult_parseResponse = KssDef.KssAPIResult.Cancel;
                    }
                }
                httpPost2.abort();
                return kssAPIResult_parseResponse;
            } catch (Exception e4) {
                throw e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // cn.kuaipan.kss.KssUpload
    public KssUpload.UploadResult getCommitInfo() throws Exception {
        return this.m_uploadResult;
    }

    @Override // cn.kuaipan.kss.KssUpload
    public boolean init(KssUpload.RequestUploadInfo requestUploadInfo, KssDef.OnUpDownload onUpDownload, KssDef.NetState netState) {
        if (requestUploadInfo == null) {
            return false;
        }
        this.m_requestInfo = requestUploadInfo;
        this.m_progress.init(requestUploadInfo, onUpDownload);
        this.m_uploadResult.setFileMeta(this.m_requestInfo.getFileMeta());
        return true;
    }

    @Override // cn.kuaipan.kss.KssUpload
    public void terminal() {
        this.m_client = null;
        this.m_requestInfo = null;
        this.m_uploadResult = null;
        this.m_progress = null;
        this.m_proxyHelper = null;
        this.m_crc32 = null;
        this.m_rc4 = null;
        this.m_chunkDataBuffer = null;
    }

    @Override // cn.kuaipan.kss.KssUpload
    @Deprecated
    public KssDef.KssAPIResult upload(byte[] bArr) throws Exception {
        return _upload(new ByteArrayInputStream(bArr));
    }

    @Override // cn.kuaipan.kss.KssUpload
    public KssDef.KssAPIResult upload(InputStream inputStream) throws Exception {
        return _upload(inputStream);
    }
}
