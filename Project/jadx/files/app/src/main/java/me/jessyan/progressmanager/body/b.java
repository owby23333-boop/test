package me.jessyan.progressmanager.body;

import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: ProgressResponseBody.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends ResponseBody {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected Handler f21239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f21240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected final ResponseBody f21241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected final me.jessyan.progressmanager.a[] f21242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected final ProgressInfo f21243w = new ProgressInfo(System.currentTimeMillis());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BufferedSource f21244x;

    /* JADX INFO: compiled from: ProgressResponseBody.java */
    class a extends ForwardingSource {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private long f21245s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f21246t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f21247u;

        /* JADX INFO: renamed from: me.jessyan.progressmanager.body.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProgressResponseBody.java */
        class RunnableC0584a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ long f21249s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ long f21250t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            final /* synthetic */ long f21251u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            final /* synthetic */ long f21252v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            final /* synthetic */ me.jessyan.progressmanager.a f21253w;

            RunnableC0584a(long j2, long j3, long j4, long j5, me.jessyan.progressmanager.a aVar) {
                this.f21249s = j2;
                this.f21250t = j3;
                this.f21251u = j4;
                this.f21252v = j5;
                this.f21253w = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f21243w.c(this.f21249s != -1 ? this.f21250t : -1L);
                b.this.f21243w.b(this.f21251u);
                b.this.f21243w.d(this.f21252v);
                ProgressInfo progressInfo = b.this.f21243w;
                progressInfo.a(this.f21249s == -1 && this.f21251u == progressInfo.a());
                this.f21253w.a(b.this.f21243w);
            }
        }

        a(Source source) {
            super(source);
            this.f21245s = 0L;
            this.f21246t = 0L;
            this.f21247u = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            a aVar = this;
            int i2 = 0;
            try {
                long j3 = super.read(buffer, j2);
                if (b.this.f21243w.a() == 0) {
                    b bVar = b.this;
                    bVar.f21243w.a(bVar.getContentLength());
                }
                aVar.f21245s += j3 != -1 ? j3 : 0L;
                aVar.f21247u += j3 != -1 ? j3 : 0L;
                if (b.this.f21242v != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j4 = jElapsedRealtime - aVar.f21246t;
                    b bVar2 = b.this;
                    if (j4 >= bVar2.f21240t || j3 == -1 || aVar.f21245s == bVar2.f21243w.a()) {
                        long j5 = aVar.f21247u;
                        long j6 = aVar.f21245s;
                        long j7 = jElapsedRealtime - aVar.f21246t;
                        int i3 = 0;
                        while (true) {
                            b bVar3 = b.this;
                            me.jessyan.progressmanager.a[] aVarArr = bVar3.f21242v;
                            if (i3 >= aVarArr.length) {
                                a aVar2 = aVar;
                                long j8 = j3;
                                aVar2.f21246t = jElapsedRealtime;
                                aVar2.f21247u = 0L;
                                return j8;
                            }
                            long j9 = j6;
                            bVar3.f21239s.post(new RunnableC0584a(j3, j5, j9, j7, aVarArr[i3]));
                            i3++;
                            aVar = this;
                            jElapsedRealtime = jElapsedRealtime;
                            j6 = j9;
                            j3 = j3;
                            j5 = j5;
                        }
                    }
                }
                return j3;
            } catch (IOException e2) {
                e2.printStackTrace();
                while (true) {
                    b bVar4 = b.this;
                    me.jessyan.progressmanager.a[] aVarArr2 = bVar4.f21242v;
                    if (i2 >= aVarArr2.length) {
                        throw e2;
                    }
                    aVarArr2[i2].a(bVar4.f21243w.b(), e2);
                    i2++;
                }
            }
        }
    }

    public b(Handler handler, ResponseBody responseBody, List<me.jessyan.progressmanager.a> list, int i2) {
        this.f21241u = responseBody;
        this.f21242v = (me.jessyan.progressmanager.a[]) list.toArray(new me.jessyan.progressmanager.a[list.size()]);
        this.f21239s = handler;
        this.f21240t = i2;
    }

    private Source a(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.f21241u.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.f21241u.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getSource() {
        if (this.f21244x == null) {
            this.f21244x = Okio.buffer(a(this.f21241u.getSource()));
        }
        return this.f21244x;
    }
}
