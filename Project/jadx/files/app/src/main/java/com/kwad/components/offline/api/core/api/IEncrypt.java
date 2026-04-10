package com.kwad.components.offline.api.core.api;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getMD5(String str);

    String getResponseData(String str);
}
