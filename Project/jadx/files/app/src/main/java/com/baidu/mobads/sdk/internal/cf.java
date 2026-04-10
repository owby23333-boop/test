package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.u;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class cf implements Observer {
    private static final String a = "APKParser";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12997g = "__xadsdk_downloaded__version__";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12998h = "version";
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URL f12999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final bu f13001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f13002f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SharedPreferences f13003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f13004j;

    public interface a {
        void a(bu buVar);

        void b(bu buVar);
    }

    public cf(Context context, URL url, bu buVar, a aVar) {
        this.f12999c = null;
        this.f13000d = null;
        this.f13004j = new cg(this);
        this.f12999c = url;
        this.f13001e = buVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.b = context;
        this.f13002f = aVar;
        this.f13003i = this.b.getSharedPreferences(f12997g, 0);
        this.f13003i.registerOnSharedPreferenceChangeListener(this.f13004j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        u uVar = (u) observable;
        if (uVar.l() == u.a.COMPLETED) {
            this.f13002f.a(new bu(this.f13001e, uVar.g(), true));
        }
        if (uVar.l() == u.a.ERROR) {
            this.f13002f.b(new bu(this.f13001e, uVar.g(), false));
        }
    }

    public void a(String str, String str2) {
        String str3 = this.f13000d;
        al alVar = new al(this.b, str3 != null ? new URL(str3) : this.f12999c, str, str2, false);
        alVar.addObserver(this);
        alVar.a();
        SharedPreferences.Editor editorEdit = this.f13003i.edit();
        editorEdit.putString("version", this.f13001e.toString());
        editorEdit.apply();
    }

    public cf(Context context, String str, bu buVar, a aVar) {
        this.f12999c = null;
        this.f13000d = null;
        this.f13004j = new cg(this);
        this.f13000d = str;
        this.f13001e = buVar;
        a(context, aVar);
    }
}
