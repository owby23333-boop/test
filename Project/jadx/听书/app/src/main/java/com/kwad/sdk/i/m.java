package com.kwad.sdk.i;

import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
final class m {
    private static final Map<String, k> aTf = new ConcurrentHashMap();
    private static long aTg;

    static synchronized void a(i iVar, boolean z) {
        Map<String, k> map = aTf;
        if (map.size() > 200) {
            j.ak("LogRequestManger", "enqueueAction fail size limit");
        } else {
            k kVarB = b(iVar, z);
            map.put(kVarB.actionId, kVarB);
        }
        Nq();
    }

    static void Nq() {
        long jCurrentTimeMillis = System.currentTimeMillis() - aTg;
        if (aTf.size() <= 0 || jCurrentTimeMillis <= h.Nd().Nj()) {
            return;
        }
        aTg = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        actionList.size();
        j.No();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.No();
                m.B(actionList);
            }
        });
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        Map<String, k> map = aTf;
        arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void B(List<k> list) {
        if (list != null) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                aTf.remove(it.next().actionId);
            }
        }
    }

    private static k b(i iVar, boolean z) {
        c.a aVarTo;
        if (z) {
            aVarTo = c.a.Tn();
        } else {
            aVarTo = c.a.To();
        }
        com.kwai.adclient.kscommerciallogger.model.c cVarTp = aVarTo.c(BusinessType.OTHER).b(SubBusinessType.OTHER).hO("ad_sdk_local_log").hN(iVar.aSY).A(iVar.toJson()).Tp();
        return new k(cVarTp.Th(), cVarTp.toString(), iVar);
    }
}
