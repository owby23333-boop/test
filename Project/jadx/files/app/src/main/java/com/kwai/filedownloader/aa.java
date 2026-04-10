package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0461a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.Ge() == -3) {
            Iterator<a.InterfaceC0461a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().Gn().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0461a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().Gn().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.Ge()) {
            Iterator<a.InterfaceC0461a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().Gn().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).Gn().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwai.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0461a> listCt = h.GK().ct(messageSnapshot.getId());
            if (listCt.size() > 0) {
                a aVarGm = listCt.get(0).Gm();
                if (com.kwai.filedownloader.e.d.aHT) {
                    com.kwai.filedownloader.e.d.g(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(aVarGm.Ge()), Byte.valueOf(messageSnapshot.Ge()), Integer.valueOf(listCt.size()));
                }
                if (!a(listCt, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.Ge()) + " task-count:" + listCt.size());
                    for (a.InterfaceC0461a interfaceC0461a : listCt) {
                        sb.append(" | ");
                        sb.append((int) interfaceC0461a.Gm().Ge());
                    }
                    com.kwai.filedownloader.e.d.f(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwai.filedownloader.e.d.f(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.Ge()));
            }
        }
    }
}
