package com.kingsoft.iciba.sdk2;

import android.util.Log;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/* JADX INFO: loaded from: classes7.dex */
final class h extends Thread {
    private HttpClient H;
    private g I;
    private d z;

    public h(d dVar) {
        this.z = dVar;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        this.H = defaultHttpClient;
        defaultHttpClient.getParams().setParameter("http.connection.timeout", 5000);
        this.H.getParams().setParameter("http.socket.timeout", 5000);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HttpClient httpClient;
        while (d.b(this.z)) {
            synchronized (d.a(this.z)) {
                if (d.a(this.z).size() <= 0) {
                    try {
                        d.a(this.z).wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    g gVar = (g) d.a(this.z).remove(0);
                    this.I = gVar;
                    if (gVar.E && (httpClient = this.H) != null) {
                        try {
                            try {
                                try {
                                    gVar.D = httpClient.execute(gVar.C);
                                    Header[] headers = this.I.D.getHeaders("Content-Encoding");
                                    d.a(this.z, "gzip".equals((headers.length <= 0 || !"Content-Encoding".equals(headers[0].getName())) ? null : headers[0].getValue()) ? d.a(new GZIPInputStream(this.I.D.getEntity().getContent())) : d.a(this.I.D.getEntity().getContent()), this.I);
                                } catch (ClientProtocolException e2) {
                                    e2.printStackTrace();
                                    d.a(this.z, (String) null, this.I);
                                    Log.e("NetSearchManage", "Search net word ClientProtocolException failed", e2);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                d.a(this.z, (String) null, this.I);
                                Log.e("NetSearchManage", "Search net word failed", e3);
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            d.a(this.z, (String) null, this.I);
                            Log.e("NetSearchManage", "Search net word IOException failed", e4);
                        }
                    }
                }
            }
        }
    }

    public final void stopCurrentWordSearch() {
        HttpClient httpClient = this.H;
        if (httpClient == null || httpClient.getConnectionManager() == null) {
            return;
        }
        this.H.getConnectionManager().shutdown();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        this.H = defaultHttpClient;
        defaultHttpClient.getParams().setParameter("http.connection.timeout", 5000);
        this.H.getParams().setParameter("http.socket.timeout", 5000);
    }
}
