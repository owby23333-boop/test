package com.liulishuo.filedownloader.services;

import android.content.Intent;
import com.liulishuo.filedownloader.model.FileDownloadModel;

/* JADX INFO: compiled from: FileDownloadBroadcastHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static void a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            throw new IllegalArgumentException();
        }
        if (fileDownloadModel.h() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra("model", fileDownloadModel);
        com.liulishuo.filedownloader.h0.c.a().sendBroadcast(intent);
    }
}
