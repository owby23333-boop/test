package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX INFO: compiled from: DownloadTaskHunter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements x, x.b, x.a, a.d {
    private t a;
    private final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f17098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte f17099d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f17100e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s f17101f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f17103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17104i;

    /* JADX INFO: compiled from: DownloadTaskHunter.java */
    interface a {
        void a(String str);

        FileDownloadHeader getHeader();

        a.b i();

        ArrayList<a.InterfaceC0481a> q();
    }

    d(a aVar, Object obj) {
        this.b = obj;
        this.f17098c = aVar;
        this.a = new k(aVar.i(), this);
    }

    private int i() {
        return this.f17098c.i().getOrigin().getId();
    }

    private void j() throws IOException {
        File file;
        com.liulishuo.filedownloader.a origin = this.f17098c.i().getOrigin();
        if (origin.getPath() == null) {
            origin.b(com.liulishuo.filedownloader.h0.f.h(origin.getUrl()));
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "save Path is null to %s", origin.getPath());
            }
        }
        if (origin.m()) {
            file = new File(origin.getPath());
        } else {
            String strJ = com.liulishuo.filedownloader.h0.f.j(origin.getPath());
            if (strJ == null) {
                throw new InvalidParameterException(com.liulishuo.filedownloader.h0.f.a("the provided mPath[%s] is invalid, can't find its directory", origin.getPath()));
            }
            file = new File(strJ);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.liulishuo.filedownloader.h0.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void update(MessageSnapshot messageSnapshot) {
        com.liulishuo.filedownloader.a origin = this.f17098c.i().getOrigin();
        byte bO = messageSnapshot.o();
        this.f17099d = bO;
        messageSnapshot.q();
        if (bO == -4) {
            this.f17101f.reset();
            int iA = h.b().a(origin.getId());
            if (iA + ((iA > 1 || !origin.m()) ? 0 : h.b().a(com.liulishuo.filedownloader.h0.f.c(origin.getUrl(), origin.getTargetFilePath()))) <= 1) {
                byte status = m.c().getStatus(origin.getId());
                com.liulishuo.filedownloader.h0.d.e(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(origin.getId()), Integer.valueOf(status));
                if (com.liulishuo.filedownloader.model.b.a(status)) {
                    this.f17099d = (byte) 1;
                    this.f17103h = messageSnapshot.g();
                    this.f17102g = messageSnapshot.f();
                    this.f17101f.start(this.f17102g);
                    this.a.a(((MessageSnapshot.b) messageSnapshot).a());
                    return;
                }
            }
            h.b().a(this.f17098c.i(), messageSnapshot);
            return;
        }
        if (bO == -3) {
            messageSnapshot.s();
            this.f17102g = messageSnapshot.g();
            this.f17103h = messageSnapshot.g();
            h.b().a(this.f17098c.i(), messageSnapshot);
            return;
        }
        if (bO != -2) {
            if (bO == -1) {
                this.f17100e = messageSnapshot.p();
                this.f17102g = messageSnapshot.f();
                h.b().a(this.f17098c.i(), messageSnapshot);
                return;
            }
            if (bO == 1) {
                this.f17102g = messageSnapshot.f();
                this.f17103h = messageSnapshot.g();
                this.a.a(messageSnapshot);
                return;
            }
            if (bO == 2) {
                this.f17103h = messageSnapshot.g();
                messageSnapshot.r();
                messageSnapshot.c();
                String strD = messageSnapshot.d();
                if (strD != null) {
                    if (origin.getFilename() != null) {
                        com.liulishuo.filedownloader.h0.d.e(this, "already has mFilename[%s], but assign mFilename[%s] again", origin.getFilename(), strD);
                    }
                    this.f17098c.a(strD);
                }
                this.f17101f.start(this.f17102g);
                this.a.d(messageSnapshot);
                return;
            }
            if (bO == 3) {
                this.f17102g = messageSnapshot.f();
                this.f17101f.update(messageSnapshot.f());
                this.a.g(messageSnapshot);
            } else if (bO != 5) {
                if (bO != 6) {
                    return;
                }
                this.a.e(messageSnapshot);
            } else {
                this.f17102g = messageSnapshot.f();
                this.f17100e = messageSnapshot.p();
                this.f17104i = messageSnapshot.h();
                this.f17101f.reset();
                this.a.c(messageSnapshot);
            }
        }
    }

    @Override // com.liulishuo.filedownloader.x.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.model.b.a(c(), messageSnapshot.o())) {
            update(messageSnapshot);
            return true;
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f17099d), Byte.valueOf(c()), Integer.valueOf(i()));
        }
        return false;
    }

    @Override // com.liulishuo.filedownloader.x.a
    public boolean b(MessageSnapshot messageSnapshot) {
        byte bC = c();
        byte bO = messageSnapshot.o();
        if (-2 == bC && com.liulishuo.filedownloader.model.b.a(bO)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(i()));
            }
            return true;
        }
        if (com.liulishuo.filedownloader.model.b.b(bC, bO)) {
            update(messageSnapshot);
            return true;
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f17099d), Byte.valueOf(c()), Integer.valueOf(i()));
        }
        return false;
    }

    @Override // com.liulishuo.filedownloader.x.a
    public boolean c(MessageSnapshot messageSnapshot) {
        if (!this.f17098c.i().getOrigin().m() || messageSnapshot.o() != -4 || c() != 2) {
            return false;
        }
        update(messageSnapshot);
        return true;
    }

    @Override // com.liulishuo.filedownloader.x.a
    public boolean d(MessageSnapshot messageSnapshot) {
        if (!com.liulishuo.filedownloader.model.b.a(this.f17098c.i().getOrigin())) {
            return false;
        }
        update(messageSnapshot);
        return true;
    }

    @Override // com.liulishuo.filedownloader.x
    public void e() {
        boolean z2;
        synchronized (this.b) {
            if (this.f17099d != 0) {
                com.liulishuo.filedownloader.h0.d.e(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(i()), Byte.valueOf(this.f17099d));
                return;
            }
            this.f17099d = (byte) 10;
            a.b bVarI = this.f17098c.i();
            com.liulishuo.filedownloader.a origin = bVarI.getOrigin();
            if (l.b()) {
                l.a().a(origin);
            }
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.d(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", origin.getUrl(), origin.getPath(), origin.getListener(), origin.getTag());
            }
            try {
                j();
                z2 = true;
            } catch (Throwable th) {
                h.b().a(bVarI);
                h.b().a(bVarI, a(th));
                z2 = false;
            }
            if (z2) {
                p.a().a(this);
            }
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.d(this, "the task[%d] has been into the launch pool.", Integer.valueOf(i()));
            }
        }
    }

    @Override // com.liulishuo.filedownloader.a.d
    public void f() {
        com.liulishuo.filedownloader.a origin = this.f17098c.i().getOrigin();
        if (l.b()) {
            l.a().b(origin);
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(c()));
        }
        this.f17101f.end(this.f17102g);
        if (this.f17098c.q() != null) {
            ArrayList arrayList = (ArrayList) this.f17098c.q().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.InterfaceC0481a) arrayList.get(i2)).a(origin);
            }
        }
        q.d().a().c(this.f17098c.i());
    }

    @Override // com.liulishuo.filedownloader.x
    public void free() {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "free the task %d, when the status is %d", Integer.valueOf(i()), Byte.valueOf(this.f17099d));
        }
        this.f17099d = (byte) 0;
    }

    @Override // com.liulishuo.filedownloader.x.a
    public t g() {
        return this.a;
    }

    @Override // com.liulishuo.filedownloader.x
    public long getTotalBytes() {
        return this.f17103h;
    }

    @Override // com.liulishuo.filedownloader.a.d
    public void h() {
        if (l.b() && c() == 6) {
            l.a().d(this.f17098c.i().getOrigin());
        }
    }

    @Override // com.liulishuo.filedownloader.a.d
    public void onBegin() {
        if (l.b()) {
            l.a().c(this.f17098c.i().getOrigin());
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(c()));
        }
    }

    @Override // com.liulishuo.filedownloader.x.b
    public void start() {
        if (this.f17099d != 10) {
            com.liulishuo.filedownloader.h0.d.e(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(i()), Byte.valueOf(this.f17099d));
            return;
        }
        a.b bVarI = this.f17098c.i();
        com.liulishuo.filedownloader.a origin = bVarI.getOrigin();
        v vVarA = q.d().a();
        try {
            if (vVarA.a(bVarI)) {
                return;
            }
            synchronized (this.b) {
                if (this.f17099d != 10) {
                    com.liulishuo.filedownloader.h0.d.e(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(i()), Byte.valueOf(this.f17099d));
                    return;
                }
                this.f17099d = (byte) 11;
                h.b().a(bVarI);
                if (com.liulishuo.filedownloader.h0.c.a(origin.getId(), origin.getTargetFilePath(), origin.u(), true)) {
                    return;
                }
                boolean zA = m.c().a(origin.getUrl(), origin.getPath(), origin.m(), origin.l(), origin.g(), origin.j(), origin.u(), this.f17098c.getHeader(), origin.h());
                if (this.f17099d == -2) {
                    com.liulishuo.filedownloader.h0.d.e(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(i()));
                    if (zA) {
                        m.c().pause(i());
                        return;
                    }
                    return;
                }
                if (zA) {
                    vVarA.c(bVarI);
                    return;
                }
                if (vVarA.a(bVarI)) {
                    return;
                }
                MessageSnapshot messageSnapshotA = a(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (h.b().c(bVarI)) {
                    vVarA.c(bVarI);
                    h.b().a(bVarI);
                }
                h.b().a(bVarI, messageSnapshotA);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.b().a(bVarI, a(th));
        }
    }

    @Override // com.liulishuo.filedownloader.x
    public long d() {
        return this.f17102g;
    }

    @Override // com.liulishuo.filedownloader.x
    public byte c() {
        return this.f17099d;
    }

    @Override // com.liulishuo.filedownloader.x.a
    public MessageSnapshot a(Throwable th) {
        this.f17099d = (byte) -1;
        this.f17100e = th;
        return com.liulishuo.filedownloader.message.d.a(i(), d(), th);
    }

    @Override // com.liulishuo.filedownloader.x
    public int a() {
        return this.f17104i;
    }

    @Override // com.liulishuo.filedownloader.x
    public Throwable b() {
        return this.f17100e;
    }
}
