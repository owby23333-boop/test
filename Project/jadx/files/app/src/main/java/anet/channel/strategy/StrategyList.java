package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyList implements Serializable {
    private List<IPConnStrategy> a;
    private Map<Integer, ConnHistoryItem> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f446d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    interface Predicate<T> {
        boolean apply(T t2);
    }

    public StrategyList() {
        this.a = new ArrayList();
        this.b = new SerialLruCache(40);
        this.f445c = false;
        this.f446d = null;
    }

    public void checkInit() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        if (this.b == null) {
            this.b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.a) {
            if (!this.b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.a) {
            ConnHistoryItem connHistoryItem = this.b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.i("awcn.StrategyList", "strategy ban!", null, Constants.KEY_STRATEGY, iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(iConnStrategy instanceof IPConnStrategy) || this.a.indexOf(iConnStrategy) == -1) {
            return;
        }
        this.b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
        Collections.sort(this.a, this.f446d);
    }

    public boolean shouldRefresh() {
        boolean z2 = true;
        boolean z3 = true;
        for (IPConnStrategy iPConnStrategy : this.a) {
            if (!this.b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).b()) {
                if (iPConnStrategy.a == 0) {
                    z2 = false;
                }
                z3 = false;
            }
        }
        return (this.f445c && z2) || z3;
    }

    public String toString() {
        return new ArrayList(this.a).toString();
    }

    public void update(l.b bVar) {
        Iterator<IPConnStrategy> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f433c = true;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.f474h.length; i3++) {
            int i4 = 0;
            while (true) {
                String[] strArr = bVar.f472f;
                if (i4 >= strArr.length) {
                    break;
                }
                a(strArr[i4], 1, bVar.f474h[i3]);
                i4++;
            }
            if (bVar.f473g != null) {
                this.f445c = true;
                int i5 = 0;
                while (true) {
                    String[] strArr2 = bVar.f473g;
                    if (i5 < strArr2.length) {
                        a(strArr2[i5], 0, bVar.f474h[i3]);
                        i5++;
                    }
                }
            } else {
                this.f445c = false;
            }
        }
        if (bVar.f475i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f475i;
                if (i2 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i2];
                String str = eVar.a;
                a(str, anet.channel.strategy.utils.c.c(str) ? -1 : 1, eVar.b);
                i2++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f433c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.a, a());
    }

    private void a(String str, int i2, l.a aVar) {
        int iA = a(this.a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (iA != -1) {
            IPConnStrategy iPConnStrategy = this.a.get(iA);
            iPConnStrategy.cto = aVar.f463c;
            iPConnStrategy.rto = aVar.f464d;
            iPConnStrategy.heartbeat = aVar.f466f;
            iPConnStrategy.a = i2;
            iPConnStrategy.b = 0;
            iPConnStrategy.f433c = false;
            return;
        }
        IPConnStrategy iPConnStrategyA = IPConnStrategy.a(str, aVar);
        if (iPConnStrategyA != null) {
            iPConnStrategyA.a = i2;
            iPConnStrategyA.b = 0;
            if (!this.b.containsKey(Integer.valueOf(iPConnStrategyA.getUniqueId()))) {
                this.b.put(Integer.valueOf(iPConnStrategyA.getUniqueId()), new ConnHistoryItem());
            }
            this.a.add(iPConnStrategyA);
        }
    }

    StrategyList(List<IPConnStrategy> list) {
        this.a = new ArrayList();
        this.b = new SerialLruCache(40);
        this.f445c = false;
        this.f446d = null;
        this.a = list;
    }

    private Comparator a() {
        if (this.f446d == null) {
            this.f446d = new k(this);
        }
        return this.f446d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i2 = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i2++;
        }
        if (i2 == collection.size()) {
            return -1;
        }
        return i2;
    }
}
