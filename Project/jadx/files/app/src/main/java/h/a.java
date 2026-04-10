package h;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.RequiresApi;
import h0.g;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BinaryFileDownloader.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 19)
public class a implements AutoCloseable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final OkHttpClient f20814s = f.a.a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f20815t;

    public a(c cVar, OkHttpClient okHttpClient) {
        this.f20815t = cVar;
    }

    public long b(String str) throws Exception {
        Response responseExecute = this.f20814s.newCall(new Request.Builder().url(str).build()).execute();
        ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            throw new IllegalStateException("Response doesn't contain a file");
        }
        double d2 = Double.parseDouble((String) Objects.requireNonNull(responseExecute.header("Content-Length", "1")));
        c cVar = this.f20815t;
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        cVar.getClass();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamByteStream);
        try {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1) {
                    cVar.f20816s.flush();
                    ((g.c) cVar.f20817t).a();
                    bufferedInputStream.close();
                    return j2;
                }
                j2 += (long) i2;
                cVar.f20816s.write(bArr, 0, i2);
                b bVar = cVar.f20817t;
                double d3 = j2;
                Double.isNaN(d3);
                double d4 = (d3 / d2) * 100.0d;
                Handler handler = g.this.f20834f;
                handler.sendMessage(Message.obtain(handler, 2, Double.valueOf(d4)));
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        this.f20815t.f20816s.close();
    }
}
