package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0461a> aEP = new ArrayList<>();

    @Override // com.kwai.filedownloader.e
    public final void GF() {
        w wVarHg = r.Hd().Hg();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aEP) {
            List<a.InterfaceC0461a> list = (List) this.aEP.clone();
            this.aEP.clear();
            ArrayList arrayList = new ArrayList(wVarHg.Hk());
            for (a.InterfaceC0461a interfaceC0461a : list) {
                int iGo = interfaceC0461a.Go();
                if (wVarHg.cA(iGo)) {
                    interfaceC0461a.Gm().FV().Gu();
                    if (!arrayList.contains(Integer.valueOf(iGo))) {
                        arrayList.add(Integer.valueOf(iGo));
                    }
                } else {
                    interfaceC0461a.Gs();
                }
            }
            wVarHg.H(arrayList);
        }
    }

    @Override // com.kwai.filedownloader.e
    public final void GG() {
        if (GH() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.GK().size() > 0) {
                com.kwai.filedownloader.e.d.h(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.GK().size()));
                return;
            }
            return;
        }
        w wVarHg = r.Hd().Hg();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.GK().size()));
        }
        if (h.GK().size() > 0) {
            synchronized (this.aEP) {
                h.GK().G(this.aEP);
                Iterator<a.InterfaceC0461a> it = this.aEP.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                wVarHg.Hj();
            }
            r.Hd().He();
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean d(a.InterfaceC0461a interfaceC0461a) {
        return !this.aEP.isEmpty() && this.aEP.contains(interfaceC0461a);
    }

    @Override // com.kwai.filedownloader.v
    public final void e(a.InterfaceC0461a interfaceC0461a) {
        if (this.aEP.isEmpty()) {
            return;
        }
        synchronized (this.aEP) {
            this.aEP.remove(interfaceC0461a);
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean f(a.InterfaceC0461a interfaceC0461a) {
        r.Hd();
        if (!r.Hf()) {
            synchronized (this.aEP) {
                r.Hd();
                if (!r.Hf()) {
                    if (com.kwai.filedownloader.e.d.aHT) {
                        com.kwai.filedownloader.e.d.g(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0461a.Gm().getId()));
                    }
                    n.GV().dw(com.kwai.filedownloader.e.c.IN());
                    if (!this.aEP.contains(interfaceC0461a)) {
                        interfaceC0461a.free();
                        this.aEP.add(interfaceC0461a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0461a);
        return false;
    }
}
