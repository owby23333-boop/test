package com.kwad.components.ad.reflux;

import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.sdk.core.download.kwai.a {
    private int itemType;
    private c mApkDownloadHelper;
    private int oA;
    private InterfaceC0362a oB;

    @Nullable
    private com.kwad.components.core.g.c oq;
    private int or;
    private String os;
    private String ot;
    private String ou;
    private String ov;
    private String ow;
    private boolean ox = false;
    private int oy = -1;
    private int oz;
    private String title;

    /* JADX INFO: renamed from: com.kwad.components.ad.reflux.a$a, reason: collision with other inner class name */
    public interface InterfaceC0362a {
        void fi();
    }

    public a(@Nullable com.kwad.components.core.g.c cVar) {
        this.oq = cVar;
    }

    private static a a(com.kwad.components.core.g.c cVar) {
        AdTemplate adTemplate = cVar.getAdTemplate();
        AdInfo adInfoCb = d.cb(adTemplate);
        a aVar = new a(cVar);
        aVar.N(0);
        aVar.ox = com.kwad.sdk.core.response.a.a.ay(adInfoCb);
        aVar.or = adTemplate.type;
        aVar.title = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
        aVar.ot = com.kwad.sdk.core.response.a.a.O(adInfoCb);
        aVar.ow = com.kwad.sdk.core.response.a.a.ax(adInfoCb);
        aVar.ov = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
        aVar.ou = com.kwad.sdk.core.response.a.a.bJ(adInfoCb);
        aVar.os = com.kwad.sdk.core.response.a.a.bL(adInfoCb);
        return aVar;
    }

    public static List<a> b(List<com.kwad.components.core.g.c> list, List<c> list2) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && list2.size() != 0) {
            if (list.size() != list2.size()) {
                return null;
            }
            arrayList = new ArrayList();
            int i2 = 0;
            Iterator<com.kwad.components.core.g.c> it = list.iterator();
            while (it.hasNext()) {
                a aVarA = a(it.next());
                aVarA.setApkDownloadHelper(list2.get(i2));
                aVarA.oy = i2;
                arrayList.add(aVarA);
                i2++;
            }
        }
        return arrayList;
    }

    private void fy() {
        InterfaceC0362a interfaceC0362a = this.oB;
        if (interfaceC0362a != null) {
            interfaceC0362a.fi();
        }
    }

    private void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public final void N(int i2) {
        this.itemType = i2;
    }

    public final void a(InterfaceC0362a interfaceC0362a) {
        this.oB = interfaceC0362a;
    }

    public final com.kwad.components.core.g.c fm() {
        return this.oq;
    }

    public final void fn() {
        c cVar;
        if (!fs() || (cVar = this.mApkDownloadHelper) == null) {
            return;
        }
        cVar.b(this);
    }

    public final String fo() {
        return this.os;
    }

    public final String fp() {
        return this.ou;
    }

    public final String fq() {
        return this.ov;
    }

    public final String fr() {
        return this.ot;
    }

    public final boolean fs() {
        return this.ox;
    }

    public final int ft() {
        return this.oy;
    }

    public final int fu() {
        int i2 = this.itemType;
        return i2 == 0 ? this.or : i2;
    }

    public final int fv() {
        return this.oz;
    }

    public final int fw() {
        return this.oA;
    }

    public final c fx() {
        return this.mApkDownloadHelper;
    }

    public final AdTemplate getAdTemplate() {
        com.kwad.components.core.g.c cVar = this.oq;
        if (cVar != null) {
            return cVar.getAdTemplate();
        }
        return null;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        this.oz = 11;
        fy();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        this.oz = 8;
        fy();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        this.oz = 0;
        this.oA = 0;
        fy();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        this.oz = 12;
        fy();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i2) {
        this.oz = 2;
        this.oA = i2;
        fy();
    }
}
