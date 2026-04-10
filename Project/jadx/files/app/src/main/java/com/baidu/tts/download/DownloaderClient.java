package com.baidu.tts.download;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class DownloaderClient {
    private ModelMediator mModelMediator;
    private ConcurrentMap<String, DownloadHandler> mPool = new ConcurrentHashMap();
    private Downloader mDownloader = Downloader.getInstance();

    private void stopHandlers() {
        Iterator<DownloadHandler> it = this.mPool.values().iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }

    public void create() {
        this.mDownloader.create();
    }

    public void destroy() {
        this.mDownloader.destroy();
    }

    public DownloadHandler download(DownloadParams downloadParams) {
        DownloadHandler handler;
        if (downloadParams == null || !downloadParams.isParamsValid() || (handler = getHandler(downloadParams.getModelId())) == null) {
            return null;
        }
        handler.reset(downloadParams);
        return this.mDownloader.download(handler);
    }

    public synchronized DownloadHandler getHandler(String str) {
        DownloadHandler downloadHandler;
        try {
            downloadHandler = this.mPool.get(str);
            if (downloadHandler == null) {
                downloadHandler = new DownloadHandler(this.mModelMediator);
                this.mPool.put(str, downloadHandler);
            }
        } catch (Exception unused) {
            return null;
        }
        return downloadHandler;
    }

    public void pause() {
        this.mDownloader.pause();
    }

    public void resume() {
        this.mDownloader.resume();
    }

    public void setModelMediator(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
        this.mDownloader.setModelMediator(modelMediator);
    }

    public void start() {
        this.mDownloader.start();
    }

    public void stop() {
        stopHandlers();
        this.mDownloader.stop();
    }
}
