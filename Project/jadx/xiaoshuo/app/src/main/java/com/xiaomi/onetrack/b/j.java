package com.xiaomi.onetrack.b;

/* JADX INFO: loaded from: classes8.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f7609b;

    public j(h hVar, String str) {
        this.f7609b = hVar;
        this.f7608a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7609b.f7604b.getWritableDatabase().delete(g.f7602b, "app_id=?", new String[]{this.f7608a});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
