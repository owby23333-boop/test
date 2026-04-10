package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class HttpDispatcher {
    private CopyOnWriteArraySet<IDispatchEventListener> a;
    private anet.channel.strategy.dispatch.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f456f;

    /* JADX INFO: compiled from: Taobao */
    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    /* JADX INFO: compiled from: Taobao */
    private static class a {
        static HttpDispatcher a = new HttpDispatcher();

        private a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return a.a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f455e.addAll(list);
            this.f454d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f455e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f454d.contains(str);
        if (!zContains) {
            this.f454d.add(str);
        }
        return !zContains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i2) {
        if (!this.f453c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap map = new HashMap();
        map.put(DispatchConstants.HOSTS, set);
        map.put("cv", String.valueOf(i2));
        this.b.a(map);
    }

    public void setEnable(boolean z2) {
        this.f453c = z2;
    }

    public void switchENV() {
        this.f454d.clear();
        this.f455e.clear();
        this.f456f.set(false);
    }

    private HttpDispatcher() {
        this.a = new CopyOnWriteArraySet<>();
        this.b = new anet.channel.strategy.dispatch.a();
        this.f453c = true;
        this.f454d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f455e = new TreeSet();
        this.f456f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (this.f456f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f456f.compareAndSet(false, true)) {
            return;
        }
        this.f455e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f455e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
