package com.yuewen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpResponseFactory;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpExpectationVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;

/* JADX INFO: loaded from: classes12.dex */
public class ph1 {
    public static final int g = 200;
    public static final ExecutorService h = Executors.newSingleThreadExecutor();
    public static final /* synthetic */ boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f16043b = new Semaphore(1);
    public final ConcurrentLinkedQueue<c> c = new ConcurrentLinkedQueue<>();
    public Thread d = null;
    public ExecutorService e = null;
    public ServerSocket f = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpService f16044a;

        public a(HttpService httpService) {
            this.f16044a = httpService;
        }

        @Override // java.lang.Runnable
        public void run() {
            ph1.this.g(this.f16044a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f16046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HttpService f16047b;
        public final /* synthetic */ HttpContext c;

        public b(c cVar, HttpService httpService, HttpContext httpContext) {
            this.f16046a = cVar;
            this.f16047b = httpService;
            this.c = httpContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ph1.this.f16043b.release();
            while (this.f16046a.isOpen()) {
                try {
                    this.f16047b.handleRequest(this.f16046a, this.c);
                    if (!this.f16046a.a(200)) {
                        this.f16046a.close();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (this.f16046a.isOpen()) {
                        try {
                            this.f16046a.close();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            ph1.this.c.remove(this.f16046a);
        }
    }

    public class c extends DefaultHttpServerConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SessionInputBuffer f16048a;

        public boolean a(int i) {
            try {
                return this.f16048a.isDataAvailable(i);
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // org.apache.http.impl.AbstractHttpServerConnection
        public void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
            this.f16048a = sessionInputBuffer;
            super.init(sessionInputBuffer, sessionOutputBuffer, httpParams);
        }

        public c() {
            this.f16048a = null;
        }
    }

    public ph1(int i2) {
        this.f16042a = i2;
    }

    public final Executor d() {
        ExecutorService executorService = this.e;
        return executorService == null ? h : executorService;
    }

    public final int e() {
        return this.f16042a;
    }

    public final boolean f() {
        Thread thread = this.d;
        return thread != null && thread.isAlive();
    }

    public final void g(HttpService httpService) {
        while (true) {
            ServerSocket serverSocket = this.f;
            if (serverSocket == null || serverSocket.isClosed()) {
                return;
            }
            try {
                this.f16043b.acquire();
                Socket socketAccept = this.f.accept();
                Executor executorD = d();
                c cVar = new c();
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                this.c.add(cVar);
                try {
                    cVar.bind(socketAccept, httpService.getParams());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                executorD.execute(new b(cVar, httpService, basicHttpContext));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final HttpService h(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        HttpProcessor httpProcessor2 = httpProcessor;
        if (httpProcessor == null) {
            BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
            basicHttpProcessor.addInterceptor(new ResponseDate());
            basicHttpProcessor.addInterceptor(new ResponseServer());
            basicHttpProcessor.addInterceptor(new ResponseContent());
            basicHttpProcessor.addInterceptor(new ResponseConnControl());
            basicHttpProcessor.addInterceptor(new ResponseProcessCookies());
            httpProcessor2 = basicHttpProcessor;
        }
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = new DefaultConnectionReuseStrategy();
        }
        if (httpResponseFactory == null) {
            httpResponseFactory = new DefaultHttpResponseFactory();
        }
        if (httpParams == null) {
            httpParams = new BasicHttpParams();
        }
        HttpService httpService = new HttpService(httpProcessor2, connectionReuseStrategy, httpResponseFactory);
        httpService.setHandlerResolver(httpRequestHandlerResolver);
        httpService.setExpectationVerifier(httpExpectationVerifier);
        httpService.setParams(httpParams);
        return httpService;
    }

    public final void i() {
        ServerSocket serverSocket = this.f;
        if (serverSocket != null) {
            try {
                serverSocket.close();
                this.d.join();
                this.e.shutdown();
                Iterator<c> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().shutdown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void j() {
        ServerSocket serverSocket = this.f;
        if (serverSocket != null) {
            try {
                serverSocket.close();
                this.d.join();
                this.e.shutdownNow();
                Iterator<c> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().shutdown();
                }
                this.e.awaitTermination(1000L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean k(ExecutorService executorService, ConnectionReuseStrategy connectionReuseStrategy, HttpProcessor httpProcessor, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        if (this.d != null) {
            return false;
        }
        this.e = executorService;
        HttpService httpServiceH = h(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerResolver, httpExpectationVerifier, httpParams);
        try {
            this.f = new ServerSocket(this.f16042a);
            Thread thread = new Thread(new a(httpServiceH));
            this.d = thread;
            thread.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
