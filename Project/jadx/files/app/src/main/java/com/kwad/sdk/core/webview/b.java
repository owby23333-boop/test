package com.kwad.sdk.core.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public ViewGroup LI;
    public WebView Lk;
    public e aoM;

    @Nullable
    public ae aoN;
    public boolean aoO = true;
    public boolean aoP = true;
    private List<AdTemplate> aoQ = null;

    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aoQ;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.aoQ.get(0);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.aoQ = new ArrayList();
        this.aoQ.add(adTemplate);
        AdTemplate adTemplate2 = adTemplate.mPlayAgain;
        if (adTemplate2 != null) {
            this.aoQ.add(adTemplate2);
        }
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aoQ = arrayList;
    }

    public final List<AdTemplate> ze() {
        return this.aoQ;
    }

    public final boolean zf() {
        List<AdTemplate> list = this.aoQ;
        return list == null || list.size() == 0;
    }
}
