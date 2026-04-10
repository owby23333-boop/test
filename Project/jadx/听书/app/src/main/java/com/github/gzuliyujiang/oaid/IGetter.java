package com.github.gzuliyujiang.oaid;

/* JADX INFO: loaded from: classes3.dex */
public interface IGetter {
    void onOAIDGetComplete(String result);

    void onOAIDGetError(Exception error);
}
