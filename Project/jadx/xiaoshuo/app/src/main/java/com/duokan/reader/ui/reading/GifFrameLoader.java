package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import com.yuewen.d91;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes5.dex */
public class GifFrameLoader {
    public static GifFrameLoader d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f5791b = new Semaphore(0, true);
    public final LinkedList<a> c = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5790a = false;

    public enum FrameStatus {
        DIRTY,
        MARKED,
        READY,
        SHOW,
        DELETE
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f5793b;
        public d91 c;
        public FrameStatus d = FrameStatus.DIRTY;

        public a() {
        }
    }

    public class b extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (GifFrameLoader.this.f5790a) {
                GifFrameLoader.this.f5791b.acquireUninterruptibly();
                synchronized (GifFrameLoader.this) {
                    for (int i = 0; i < GifFrameLoader.this.c.size(); i++) {
                        a aVar = (a) GifFrameLoader.this.c.get(i);
                        if (aVar.d == FrameStatus.MARKED && aVar.c.isActive()) {
                            aVar.f5793b.eraseColor(0);
                            aVar.c.e(aVar.f5792a, aVar.f5793b);
                            aVar.d = FrameStatus.READY;
                        }
                    }
                }
            }
        }

        public b() {
        }
    }

    public static GifFrameLoader f() {
        if (d == null) {
            d = new GifFrameLoader();
        }
        return d;
    }

    public void d(d91 d91Var, int i, int i2, int i3) {
        a aVar;
        synchronized (this) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.c.size()) {
                    aVar = null;
                    break;
                }
                aVar = this.c.get(i4);
                if (aVar.d == FrameStatus.DIRTY && aVar.f5793b.getWidth() == i2 && aVar.f5793b.getHeight() == i3) {
                    aVar.f5792a = i;
                    aVar.c = d91Var;
                    aVar.d = FrameStatus.MARKED;
                    break;
                }
                i4++;
            }
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.f5792a = i;
                aVar2.c = d91Var;
                aVar2.f5793b = com.duokan.core.utils.a.d(i2, i3, Bitmap.Config.ARGB_8888);
                aVar2.d = FrameStatus.MARKED;
                this.c.addFirst(aVar2);
            }
            if (!this.f5790a) {
                this.f5790a = true;
                new b().start();
            }
            this.f5791b.release();
        }
    }

    public a e(d91 d91Var, int i, int i2, int i3) {
        synchronized (this) {
            for (int i4 = 0; i4 < this.c.size(); i4++) {
                a aVar = this.c.get(i4);
                if (aVar.d == FrameStatus.READY && aVar.f5793b.getWidth() == i2 && aVar.f5793b.getHeight() == i3) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public void g(d91 d91Var) {
        synchronized (this) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.c.size(); i++) {
                a aVar = this.c.get(i);
                d91 d91Var2 = aVar.c;
                if (d91Var2 == d91Var || !d91Var2.isActive()) {
                    aVar.d = FrameStatus.DELETE;
                    aVar.f5793b.recycle();
                    linkedList.add(aVar);
                }
            }
            this.c.removeAll(linkedList);
            if (this.c.size() == 0) {
                this.f5790a = false;
                this.f5791b.release();
            }
        }
    }
}
