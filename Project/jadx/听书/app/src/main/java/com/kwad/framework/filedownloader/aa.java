package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0370a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.wJ() == -3) {
            Iterator<a.InterfaceC0370a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().wS().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0370a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().wS().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.wJ()) {
            Iterator<a.InterfaceC0370a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().wS().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).wS().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0370a> listBt = h.xp().bt(messageSnapshot.getId());
            if (listBt.size() > 0) {
                a aVarWR = listBt.get(0).wR();
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(aVarWR.wJ()), Byte.valueOf(messageSnapshot.wJ()), Integer.valueOf(listBt.size()));
                }
                if (!a(listBt, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.wJ()) + " task-count:" + listBt.size());
                    Iterator<a.InterfaceC0370a> it = listBt.iterator();
                    while (it.hasNext()) {
                        sb.append(" | ").append((int) it.next().wR().wJ());
                    }
                    com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.wJ()));
            }
        }
    }
}
