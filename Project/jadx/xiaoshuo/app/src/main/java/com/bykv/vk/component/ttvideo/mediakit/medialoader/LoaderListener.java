package com.bykv.vk.component.ttvideo.mediakit.medialoader;

/* JADX INFO: loaded from: classes.dex */
public interface LoaderListener {
    void onLoaderTaskCancel(LoaderEventInfo loaderEventInfo);

    void onLoaderTaskCompleted(LoaderEventInfo loaderEventInfo);

    void onLoaderTaskStart(LoaderEventInfo loaderEventInfo);
}
