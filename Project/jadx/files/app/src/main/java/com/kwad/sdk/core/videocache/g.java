package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.an;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class g {
    private final c anh;
    private volatile e anm;
    private final b ano;
    private final String url;
    private final AtomicInteger anl = new AtomicInteger(0);
    private final List<b> ann = new CopyOnWriteArrayList();

    static final class a extends Handler implements b {
        private final List<b> ann;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.ann = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i2) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.ann.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.url = an.et(str);
        this.anh = (c) an.checkNotNull(cVar);
        this.ano = new a(str, this.ann);
    }

    private synchronized void yM() {
        this.anm = this.anm == null ? yO() : this.anm;
    }

    private synchronized void yN() {
        if (this.anl.decrementAndGet() <= 0) {
            this.anm.shutdown();
            this.anm = null;
        }
    }

    private e yO() {
        String str = this.url;
        c cVar = this.anh;
        e eVar = new e(new h(str, cVar.amT, cVar.amU), new com.kwad.sdk.core.videocache.kwai.b(this.anh.cw(this.url), this.anh.amS));
        eVar.a(this.ano);
        return eVar;
    }

    public final void a(d dVar, Socket socket) {
        yM();
        try {
            this.anl.incrementAndGet();
            this.anm.a(dVar, socket);
        } finally {
            yN();
        }
    }

    public final void shutdown() {
        this.ann.clear();
        e eVar = this.anm;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.anm = null;
        this.anl.set(0);
    }

    public final int yJ() {
        return this.anl.get();
    }
}
