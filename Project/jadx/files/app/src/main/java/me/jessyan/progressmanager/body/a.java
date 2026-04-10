package me.jessyan.progressmanager.body;

import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: ProgressRequestBody.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends RequestBody {
    protected Handler a;
    protected int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final RequestBody f21226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final me.jessyan.progressmanager.a[] f21227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final ProgressInfo f21228e = new ProgressInfo(System.currentTimeMillis());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BufferedSink f21229f;

    /* JADX INFO: renamed from: me.jessyan.progressmanager.body.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProgressRequestBody.java */
    protected final class C0582a extends ForwardingSink {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private long f21230s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f21231t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f21232u;

        /* JADX INFO: renamed from: me.jessyan.progressmanager.body.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProgressRequestBody.java */
        class RunnableC0583a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ long f21234s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ long f21235t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            final /* synthetic */ long f21236u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            final /* synthetic */ me.jessyan.progressmanager.a f21237v;

            RunnableC0583a(long j2, long j3, long j4, me.jessyan.progressmanager.a aVar) {
                this.f21234s = j2;
                this.f21235t = j3;
                this.f21236u = j4;
                this.f21237v = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f21228e.c(this.f21234s);
                a.this.f21228e.b(this.f21235t);
                a.this.f21228e.d(this.f21236u);
                ProgressInfo progressInfo = a.this.f21228e;
                progressInfo.a(this.f21235t == progressInfo.a());
                this.f21237v.a(a.this.f21228e);
            }
        }

        public C0582a(Sink sink) {
            super(sink);
            this.f21230s = 0L;
            this.f21231t = 0L;
            this.f21232u = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            int i2 = 0;
            try {
                super.write(buffer, j2);
                if (a.this.f21228e.a() == 0) {
                    a aVar = a.this;
                    aVar.f21228e.a(aVar.contentLength());
                }
                this.f21230s += j2;
                this.f21232u += j2;
                if (a.this.f21227d == null) {
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = jElapsedRealtime - this.f21231t;
                a aVar2 = a.this;
                if (j3 < aVar2.b && this.f21230s != aVar2.f21228e.a()) {
                    return;
                }
                long j4 = this.f21232u;
                long j5 = this.f21230s;
                long j6 = jElapsedRealtime - this.f21231t;
                int i3 = 0;
                while (true) {
                    a aVar3 = a.this;
                    me.jessyan.progressmanager.a[] aVarArr = aVar3.f21227d;
                    if (i3 >= aVarArr.length) {
                        this.f21231t = jElapsedRealtime;
                        this.f21232u = 0L;
                        return;
                    } else {
                        aVar3.a.post(new RunnableC0583a(j4, j5, j6, aVarArr[i3]));
                        i3++;
                        j4 = j4;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                while (true) {
                    a aVar4 = a.this;
                    me.jessyan.progressmanager.a[] aVarArr2 = aVar4.f21227d;
                    if (i2 >= aVarArr2.length) {
                        throw e2;
                    }
                    aVarArr2[i2].a(aVar4.f21228e.b(), e2);
                    i2++;
                }
            }
        }
    }

    public a(Handler handler, RequestBody requestBody, List<me.jessyan.progressmanager.a> list, int i2) {
        this.f21226c = requestBody;
        this.f21227d = (me.jessyan.progressmanager.a[]) list.toArray(new me.jessyan.progressmanager.a[list.size()]);
        this.a = handler;
        this.b = i2;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.f21226c.contentLength();
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return this.f21226c.getContentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.f21229f == null) {
            this.f21229f = Okio.buffer(new C0582a(bufferedSink));
        }
        try {
            this.f21226c.writeTo(this.f21229f);
            this.f21229f.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
            int i2 = 0;
            while (true) {
                me.jessyan.progressmanager.a[] aVarArr = this.f21227d;
                if (i2 >= aVarArr.length) {
                    throw e2;
                }
                aVarArr[i2].a(this.f21228e.b(), e2);
                i2++;
            }
        }
    }
}
