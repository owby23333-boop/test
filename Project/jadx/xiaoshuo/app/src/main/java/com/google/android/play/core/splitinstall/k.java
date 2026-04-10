package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.tasks.Task;
import com.iflytek.aikit.utils.constants.ErrorCode;
import com.yuewen.km4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.android.play.core.splitcompat.b.b f6975b = new com.google.android.play.core.splitcompat.b.b("SplitInstallService");
    private static final Intent c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage(km4.v);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.play.core.a.b<com.google.android.play.core.splitinstall.a.a> f6976a;
    private final Context d;
    private final String e;
    private final com.google.android.play.core.a.f f;

    public k(Context context) {
        this(context, context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", ErrorCode.MSP_ERROR_NET_GENERAL);
        return bundle;
    }

    public final Task<List<SplitInstallSessionState>> a() {
        f6975b.a("getSessionStates", new Object[0]);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new q(this, iVar, iVar));
        return iVar.a();
    }

    public final /* synthetic */ void d() {
        f6975b.a("onBinderDied", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", -1);
        bundle.putInt("status", 6);
        bundle.putInt("error_code", -9);
        Intent intent = new Intent();
        intent.setPackage(this.e);
        intent.setAction("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService");
        intent.putExtra("session_state", bundle);
        intent.addFlags(1073741824);
        intent.addFlags(2097152);
        this.d.sendBroadcast(intent);
    }

    private k(Context context, String str) {
        j jVar = new j(this);
        this.f = jVar;
        this.d = context;
        this.e = str;
        this.f6976a = new com.google.android.play.core.a.b<>(context.getApplicationContext(), f6975b, "SplitInstallService", c, l.f6977a, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Bundle> c(Collection<String> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (String str : collection) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final Task<SplitInstallSessionState> a(int i) {
        f6975b.a("getSessionState(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new p(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Void> b(int i) {
        f6975b.a("cancelInstall(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new r(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Integer> a(Collection<String> collection) {
        f6975b.a("startInstall(%s)", collection);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new m(this, iVar, collection, iVar));
        return iVar.a();
    }

    public final Task<Void> b(List<String> list) {
        f6975b.a("deferredInstall(%s)", list);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new o(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> a(List<String> list) {
        f6975b.a("deferredUninstall(%s)", list);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.f6976a.a(new n(this, iVar, list, iVar));
        return iVar.a();
    }
}
