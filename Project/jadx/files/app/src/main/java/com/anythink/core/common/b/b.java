package com.anythink.core.common.b;

import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    WeakReference<ATAdSourceStatusListener> a;

    public final void a(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (aTAdSourceStatusListener == null) {
            return;
        }
        this.a = new WeakReference<>(aTAdSourceStatusListener);
    }

    public final void b(com.anythink.core.common.e.e eVar) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceBiddingFilled(jVarA);
                }
            }
        });
    }

    public final void c(com.anythink.core.common.e.e eVar) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.4
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceAttempt(jVarA);
                }
            }
        });
    }

    public final void d(com.anythink.core.common.e.e eVar) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.5
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceLoadFilled(jVarA);
                }
            }
        });
    }

    private ATAdSourceStatusListener a() {
        WeakReference<ATAdSourceStatusListener> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.6
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceLoadFail(jVarA, adError);
                }
            }
        });
    }

    public final void a(com.anythink.core.common.e.e eVar) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceBiddingAttempt(jVarA);
                }
            }
        });
    }

    public final void a(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j jVarA = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.3
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener aTAdSourceStatusListenerA = b.a(b.this);
                if (aTAdSourceStatusListenerA != null) {
                    aTAdSourceStatusListenerA.onAdSourceBiddingFail(jVarA, adError);
                }
            }
        });
    }

    static /* synthetic */ ATAdSourceStatusListener a(b bVar) {
        WeakReference<ATAdSourceStatusListener> weakReference = bVar.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
