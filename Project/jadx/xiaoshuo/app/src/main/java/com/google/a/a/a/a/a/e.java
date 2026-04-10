package com.google.a.a.a.a.a;

/* JADX INFO: loaded from: classes7.dex */
final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f6784a = new c();

    @Override // com.google.a.a.a.a.a.b
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f6784a.a(th, true).add(th2);
    }
}
