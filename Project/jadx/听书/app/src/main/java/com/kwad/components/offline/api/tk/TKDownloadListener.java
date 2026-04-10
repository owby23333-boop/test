package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* JADX INFO: loaded from: classes4.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(StyleTemplate styleTemplate);
}
