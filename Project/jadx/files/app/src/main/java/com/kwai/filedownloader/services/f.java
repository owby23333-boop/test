package com.kwai.filedownloader.services;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static void f(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.Ge() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra("model", cVar);
        com.kwai.filedownloader.e.c.IN().sendBroadcast(intent);
    }
}
