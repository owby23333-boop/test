package h;

import androidx.annotation.RequiresApi;
import java.io.OutputStream;

/* JADX INFO: compiled from: BinaryFileWriter.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 19)
public class c implements AutoCloseable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final OutputStream f20816s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f20817t;

    public c(OutputStream outputStream, b bVar) {
        this.f20816s = outputStream;
        this.f20817t = bVar;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        this.f20816s.close();
    }
}
