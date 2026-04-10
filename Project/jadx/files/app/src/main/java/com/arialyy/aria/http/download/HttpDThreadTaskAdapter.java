package com.arialyy.aria.http.download;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.BaseHttpThreadTaskAdapter;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.BufferedRandomAccessFile;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class HttpDThreadTaskAdapter extends BaseHttpThreadTaskAdapter {
    private final String TAG;
    private DTaskWrapper mTaskWrapper;

    HttpDThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
        this.TAG = "HttpDThreadTaskAdapter";
    }

    private void handleComplete() {
        if (!getThreadTask().isBreak() && getThreadTask().checkBlock()) {
            complete();
        }
    }

    private void readChunked(InputStream inputStream) throws Throwable {
        int i2;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(getThreadConfig().tempFile, true);
                    try {
                        byte[] bArr = new byte[getTaskConfig().getBuffSize()];
                        while (getThreadTask().isLive() && (i2 = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
                            if (this.mSpeedBandUtil != null) {
                                this.mSpeedBandUtil.limitNextBytes(i2);
                            }
                            fileOutputStream2.write(bArr, 0, i2);
                            progress(i2);
                        }
                        handleComplete();
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        fail(new AriaHTTPException(String.format("文件下载失败，savePath: %s, url: %s", getEntity().getFilePath(), getThreadConfig().url), e), true);
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00fb A[Catch: IOException -> 0x00f7, TryCatch #3 {IOException -> 0x00f7, blocks: (B:54:0x00f0, B:58:0x00fb, B:60:0x0100), top: B:67:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100 A[Catch: IOException -> 0x00f7, TRY_LEAVE, TryCatch #3 {IOException -> 0x00f7, blocks: (B:54:0x00f0, B:58:0x00fb, B:60:0x0100), top: B:67:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readDynamicFile(java.io.InputStream r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.http.download.HttpDThreadTaskAdapter.readDynamicFile(java.io.InputStream):void");
    }

    private void readNormal(InputStream inputStream, BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        int i2;
        byte[] bArr = new byte[getTaskConfig().getBuffSize()];
        while (getThreadTask().isLive() && (i2 = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
            BandwidthLimiter bandwidthLimiter = this.mSpeedBandUtil;
            if (bandwidthLimiter != null) {
                bandwidthLimiter.limitNextBytes(i2);
            }
            bufferedRandomAccessFile.write(bArr, 0, i2);
            progress(i2);
        }
    }

    @Override // com.arialyy.aria.core.task.AbsThreadTaskAdapter
    protected void handlerThreadTask() throws Throwable {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Map<String, String> params;
        this.mTaskWrapper = (DTaskWrapper) getTaskWrapper();
        if (getThreadRecord().isComplete) {
            handleComplete();
            return;
        }
        BufferedRandomAccessFile bufferedRandomAccessFile = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnectionHandleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(getThreadConfig().url, this.mTaskOption), this.mTaskOption);
                    try {
                        if (this.mTaskWrapper.isSupportBP()) {
                            ALog.d("HttpDThreadTaskAdapter", String.format("任务【%s】线程__%s__开始下载【开始位置 : %s，结束位置：%s】", getFileName(), Integer.valueOf(getThreadRecord().threadId), Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation)));
                            httpURLConnectionHandleConnection.setRequestProperty("Range", String.format("bytes=%s-%s", Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation - 1)));
                        } else {
                            ALog.w("HttpDThreadTaskAdapter", "该下载不支持断点");
                        }
                        ConnectionHelp.setConnectParam(this.mTaskOption, httpURLConnectionHandleConnection);
                        httpURLConnectionHandleConnection.setConnectTimeout(getTaskConfig().getConnectTimeOut());
                        httpURLConnectionHandleConnection.setReadTimeout(getTaskConfig().getIOTimeOut());
                        if (this.mTaskOption.isChunked()) {
                            httpURLConnectionHandleConnection.setDoInput(true);
                            httpURLConnectionHandleConnection.setChunkedStreamingMode(0);
                        }
                        httpURLConnectionHandleConnection.connect();
                        if (this.mTaskOption.getRequestEnum() == RequestEnum.POST && (params = this.mTaskOption.getParams()) != null) {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionHandleConnection.getOutputStream());
                            Set<String> setKeySet = params.keySet();
                            StringBuilder sb = new StringBuilder();
                            for (String str : setKeySet) {
                                sb.append(str);
                                sb.append("=");
                                sb.append(URLEncoder.encode(params.get(str)));
                                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                            }
                            String string = sb.toString();
                            outputStreamWriter.write(string.substring(0, string.length() - 1));
                            outputStreamWriter.flush();
                            outputStreamWriter.close();
                        }
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(ConnectionHelp.convertInputStream(httpURLConnectionHandleConnection));
                        try {
                            if (this.mTaskOption.isChunked()) {
                                readChunked(bufferedInputStream2);
                            } else if (getThreadConfig().isBlock) {
                                readDynamicFile(bufferedInputStream2);
                            } else {
                                BufferedRandomAccessFile bufferedRandomAccessFile2 = new BufferedRandomAccessFile(getThreadConfig().tempFile, "rwd", getTaskConfig().getBuffSize());
                                try {
                                    if (getThreadRecord().startLocation > 0) {
                                        bufferedRandomAccessFile2.seek(getThreadRecord().startLocation);
                                    }
                                    readNormal(bufferedInputStream2, bufferedRandomAccessFile2);
                                    handleComplete();
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                } catch (ArrayIndexOutOfBoundsException e2) {
                                    e = e2;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    httpURLConnection = httpURLConnectionHandleConnection;
                                    bufferedInputStream = bufferedInputStream2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    return;
                                } catch (MalformedURLException e3) {
                                    e = e3;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    httpURLConnection = httpURLConnectionHandleConnection;
                                    bufferedInputStream = bufferedInputStream2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    return;
                                } catch (IOException e4) {
                                    e = e4;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    httpURLConnection = httpURLConnectionHandleConnection;
                                    bufferedInputStream = bufferedInputStream2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e), true);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    return;
                                } catch (Exception e5) {
                                    e = e5;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    httpURLConnection = httpURLConnectionHandleConnection;
                                    bufferedInputStream = bufferedInputStream2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    httpURLConnection = httpURLConnectionHandleConnection;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedRandomAccessFile != null) {
                                        try {
                                            bufferedRandomAccessFile.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedRandomAccessFile != null) {
                                bufferedRandomAccessFile.close();
                            }
                            bufferedInputStream2.close();
                            if (httpURLConnectionHandleConnection != null) {
                                httpURLConnectionHandleConnection.getInputStream().close();
                                httpURLConnectionHandleConnection.disconnect();
                            }
                        } catch (ArrayIndexOutOfBoundsException e7) {
                            httpURLConnection = httpURLConnectionHandleConnection;
                            bufferedInputStream = bufferedInputStream2;
                            e = e7;
                        } catch (MalformedURLException e8) {
                            httpURLConnection = httpURLConnectionHandleConnection;
                            bufferedInputStream = bufferedInputStream2;
                            e = e8;
                        } catch (IOException e9) {
                            httpURLConnection = httpURLConnectionHandleConnection;
                            bufferedInputStream = bufferedInputStream2;
                            e = e9;
                        } catch (Exception e10) {
                            httpURLConnection = httpURLConnectionHandleConnection;
                            bufferedInputStream = bufferedInputStream2;
                            e = e10;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (MalformedURLException e11) {
                        e = e11;
                        httpURLConnection = httpURLConnectionHandleConnection;
                        bufferedInputStream = null;
                    } catch (IOException e12) {
                        e = e12;
                        httpURLConnection = httpURLConnectionHandleConnection;
                        bufferedInputStream = null;
                    } catch (ArrayIndexOutOfBoundsException e13) {
                        e = e13;
                        httpURLConnection = httpURLConnectionHandleConnection;
                        bufferedInputStream = null;
                    } catch (Exception e14) {
                        e = e14;
                        httpURLConnection = httpURLConnectionHandleConnection;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnectionHandleConnection;
                        bufferedInputStream = null;
                    }
                } catch (ArrayIndexOutOfBoundsException e15) {
                    e = e15;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } catch (MalformedURLException e16) {
                    e = e16;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } catch (IOException e17) {
                    e = e17;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } catch (Exception e18) {
                    e = e18;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }
}
