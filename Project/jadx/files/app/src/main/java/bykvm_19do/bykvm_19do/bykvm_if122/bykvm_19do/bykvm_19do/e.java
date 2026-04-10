package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f {

    class a implements Runnable {
        final /* synthetic */ AdError a;

        a(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    class b implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d
        public void callback() {
            e.this.h0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.k();
            e.super.S();
        }
    }

    protected e(Context context, String str) {
        super(context, str);
    }

    private boolean e0() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : cVar.B()) {
                if (TextUtils.equals(jVar.e(), "pangle") && jVar.G()) {
                    return true;
                }
            }
        }
        return false;
    }

    private AdError f0() {
        AdSlot adSlot;
        if (!this.K || (adSlot = this.f1619h) == null) {
            return null;
        }
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
        shallowCopy.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_LOADED, AdError.getMessage(AdError.ERROR_CODE_LOADED));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, cVar != null ? cVar.C() : null, true, j(), AdError.ERROR_CODE_LOADED);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, adBreakError, cVar2 != null ? cVar2.C() : null, j());
        return adBreakError;
    }

    private AdError g0() {
        AdSlot adSlot;
        if (!this.L || (adSlot = this.f1619h) == null) {
            return null;
        }
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
        shallowCopy.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_SHOWED, AdError.getMessage(AdError.ERROR_CODE_SHOWED));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, cVar != null ? cVar.C() : null, true, j(), AdError.ERROR_CODE_SHOWED);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, adBreakError, cVar2 != null ? cVar2.C() : null, j());
        return adBreakError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (e0() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.g()) {
            ThreadHelper.runOnThreadPool(new c());
        } else {
            super.S();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void S() {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().q() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().u()) {
            h0();
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(new b());
        }
    }

    protected boolean d0() {
        if (this.f1619h == null) {
            return true;
        }
        AdError adErrorG0 = g0();
        if (adErrorG0 == null && (adErrorG0 = f0()) == null) {
            return true;
        }
        ThreadHelper.runOnUiThread(new a(adErrorG0));
        return false;
    }
}
