package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.c;
import java.util.List;

/* JADX INFO: compiled from: MessageSnapshotGate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 implements c.b {
    private boolean a(List<a.b> list, MessageSnapshot messageSnapshot) {
        boolean zA;
        if (list.size() > 1 && messageSnapshot.o() == -3) {
            for (a.b bVar : list) {
                synchronized (bVar.k()) {
                    if (bVar.getMessageHandler().d(messageSnapshot)) {
                        com.liulishuo.filedownloader.h0.d.a(this, "updateMoreLikelyCompleted", new Object[0]);
                        return true;
                    }
                }
            }
        }
        for (a.b bVar2 : list) {
            synchronized (bVar2.k()) {
                if (bVar2.getMessageHandler().b(messageSnapshot)) {
                    com.liulishuo.filedownloader.h0.d.a(this, "updateKeepFlow", new Object[0]);
                    return true;
                }
            }
        }
        if (-4 == messageSnapshot.o()) {
            for (a.b bVar3 : list) {
                synchronized (bVar3.k()) {
                    if (bVar3.getMessageHandler().c(messageSnapshot)) {
                        com.liulishuo.filedownloader.h0.d.a(this, "updateSampleFilePathTaskRunning", new Object[0]);
                        return true;
                    }
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        a.b bVar4 = list.get(0);
        synchronized (bVar4.k()) {
            com.liulishuo.filedownloader.h0.d.a(this, "updateKeepAhead", new Object[0]);
            zA = bVar4.getMessageHandler().a(messageSnapshot);
        }
        return zA;
    }

    @Override // com.liulishuo.filedownloader.message.c.b
    public void a(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.e()).intern()) {
            List<a.b> listB = h.b().b(messageSnapshot.e());
            if (listB.size() > 0) {
                a origin = listB.get(0).getOrigin();
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(origin.c()), Byte.valueOf(messageSnapshot.o()), Integer.valueOf(listB.size()));
                }
                if (!a(listB, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.e() + " status:" + ((int) messageSnapshot.o()) + " task-count:" + listB.size());
                    for (a.b bVar : listB) {
                        sb.append(" | ");
                        sb.append((int) bVar.getOrigin().c());
                    }
                    com.liulishuo.filedownloader.h0.d.c(this, sb.toString(), new Object[0]);
                }
            } else {
                com.liulishuo.filedownloader.h0.d.c(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.o()));
            }
        }
    }
}
