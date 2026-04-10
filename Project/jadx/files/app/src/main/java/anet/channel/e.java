package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e {
    private final Map<SessionRequest, List<Session>> a = new HashMap();
    private final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f314c = this.b.readLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f315d = this.b.writeLock();

    e() {
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.a() == null || session == null) {
            return;
        }
        this.f315d.lock();
        try {
            List<Session> arrayList = this.a.get(sessionRequest);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(sessionRequest, arrayList);
            }
            if (arrayList.indexOf(session) != -1) {
                return;
            }
            arrayList.add(session);
            Collections.sort(arrayList);
        } finally {
            this.f315d.unlock();
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f315d.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.a.remove(sessionRequest);
            }
        } finally {
            this.f315d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f314c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            boolean z2 = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            this.f314c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f314c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f314c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i2) {
        this.f314c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i2 == anet.channel.entity.c.f328c || session2.f252j.getType() == i2)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f314c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f314c.lock();
        try {
            return this.a.isEmpty() ? list : new ArrayList(this.a.keySet());
        } finally {
            this.f314c.unlock();
        }
    }
}
