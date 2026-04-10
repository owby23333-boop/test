package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GlideException extends Exception {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final StackTraceElement[] f13489x = new StackTraceElement[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List<Throwable> f13490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.bumptech.glide.load.c f13491t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private DataSource f13492u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Class<?> f13493v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f13494w;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i2 = i3;
        }
    }

    void a(com.bumptech.glide.load.c cVar, DataSource dataSource) {
        a(cVar, dataSource, null);
    }

    public void a(@Nullable Exception exc) {
    }

    public List<Throwable> f() {
        return this.f13490s;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> g() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f13494w);
        sb.append(this.f13493v != null ? ", " + this.f13493v : "");
        sb.append(this.f13492u != null ? ", " + this.f13492u : "");
        sb.append(this.f13491t != null ? ", " + this.f13491t : "");
        List<Throwable> listG = g();
        if (listG.isEmpty()) {
            return sb.toString();
        }
        if (listG.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listG.size());
            sb.append(" root causes:");
        }
        for (Throwable th : listG) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    void a(com.bumptech.glide.load.c cVar, DataSource dataSource, Class<?> cls) {
        this.f13491t = cVar;
        this.f13492u = dataSource;
        this.f13493v = cls;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f13494w = str;
        setStackTrace(f13489x);
        this.f13490s = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    private static final class a implements Appendable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Appendable f13495s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f13496t = true;

        a(Appendable appendable) {
            this.f13495s = appendable;
        }

        @NonNull
        private CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            if (this.f13496t) {
                this.f13496t = false;
                this.f13495s.append("  ");
            }
            this.f13496t = c2 == '\n';
            this.f13495s.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            append(charSequenceA, 0, charSequenceA.length());
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z2 = false;
            if (this.f13496t) {
                this.f13496t = false;
                this.f13495s.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i3 - 1) == '\n') {
                z2 = true;
            }
            this.f13496t = z2;
            this.f13495s.append(charSequenceA, i2, i3);
            return this;
        }
    }

    public void a(String str) {
        List<Throwable> listG = g();
        int size = listG.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(ad.f20406s);
            sb.toString();
            listG.get(i2);
            i2 = i3;
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th).f().iterator();
            while (it.hasNext()) {
                a(it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    private void a(Appendable appendable) {
        a(this, appendable);
        a(f(), new a(appendable));
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
