package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes8.dex */
public class ha extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hj f8027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hk f488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Throwable f489a;

    public ha() {
        this.f8027a = null;
        this.f488a = null;
        this.f489a = null;
    }

    public Throwable a() {
        return this.f489a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        hj hjVar;
        hk hkVar;
        String message = super.getMessage();
        return (message != null || (hkVar = this.f488a) == null) ? (message != null || (hjVar = this.f8027a) == null) ? message : hjVar.toString() : hkVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        hk hkVar = this.f488a;
        if (hkVar != null) {
            sb.append(hkVar);
        }
        hj hjVar = this.f8027a;
        if (hjVar != null) {
            sb.append(hjVar);
        }
        if (this.f489a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f489a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f489a != null) {
            printStream.println("Nested Exception: ");
            this.f489a.printStackTrace(printStream);
        }
    }

    public ha(String str) {
        super(str);
        this.f8027a = null;
        this.f488a = null;
        this.f489a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f489a != null) {
            printWriter.println("Nested Exception: ");
            this.f489a.printStackTrace(printWriter);
        }
    }

    public ha(Throwable th) {
        this.f8027a = null;
        this.f488a = null;
        this.f489a = th;
    }

    public ha(hj hjVar) {
        this.f488a = null;
        this.f489a = null;
        this.f8027a = hjVar;
    }

    public ha(String str, Throwable th) {
        super(str);
        this.f8027a = null;
        this.f488a = null;
        this.f489a = th;
    }
}
