package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    private TTAdSdk.InitCallback z;

    private interface g<T> {
        void z(T t);
    }

    protected abstract com.bytedance.sdk.openadsdk.dl.dl dl();

    public abstract dl g();

    public abstract void g(Context context, com.bykv.z.z.z.z.dl dlVar);

    protected boolean g(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    protected void z(Result result) {
    }

    public abstract boolean z();

    public abstract boolean z(Context context, com.bykv.z.z.z.z.dl dlVar);

    public void z(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.bytedance.sdk.openadsdk.api.gc.z()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.dl.a.z().z(dl());
        if (g(context, adConfig, initCallback)) {
            this.z = initCallback;
            final com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z(com.bytedance.sdk.openadsdk.ls.z.dl.z.z(adConfig));
            dlVarZ.z(1, SystemClock.elapsedRealtime());
            dlVarZ.z(5, "main");
            dlVarZ.z(4, true);
            dlVarZ.z(6, 999);
            dlVarZ.z(10, 7105);
            dlVarZ.z(11, "7.1.0.5");
            dlVarZ.z(12, "com.byted.pangle");
            dlVarZ.z(14, true);
            dlVarZ.z(16, com.bytedance.sdk.openadsdk.dl.a.z());
            dlVarZ.z(17, com.bytedance.sdk.openadsdk.fv.z.z().g());
            Thread threadCurrentThread = Thread.currentThread();
            dlVarZ.z(2, threadCurrentThread.getName());
            dlVarZ.z(3, threadCurrentThread.getPriority());
            dlVarZ.z(15, new a());
            dlVarZ.z(8301, new MediationInitCLassLoader());
            if (!z(context, dlVarZ)) {
                com.bytedance.sdk.openadsdk.fv.z.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g(context, dlVarZ);
                    }
                });
            }
            g().z(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(Manager manager, boolean z) {
        m.g("_tt_ad_sdk_", "update manager");
        g().z(manager, z);
        g().register(com.bytedance.sdk.openadsdk.dl.a.z());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Result result) {
        z(result);
        if (result.isSuccess()) {
            m.g("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.z;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            m.gc("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.z;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.z = null;
    }

    private class a implements Function<SparseArray<Object>, Object> {
        private a() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray == null || (sparseArray2 = (SparseArray) com.bykv.z.z.z.z.dl.z(sparseArray).g().objectValue(-99999979, SparseArray.class)) == null) {
                return null;
            }
            ValueSet valueSetG = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) sparseArray2).g();
            z.this.g(com.bykv.z.z.z.z.g.z().z(valueSetG.intValue(-999900)).z(valueSetG.stringValue(-999901)).z(valueSetG.booleanValue(-999903)).z(com.bykv.z.z.z.z.dl.z((SparseArray<Object>) valueSetG.objectValue(-999902, SparseArray.class)).g()).g());
            return null;
        }
    }

    public static abstract class dl implements TTAdManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<g<Manager>, Object> f903a = new WeakHashMap();
        private volatile boolean dl;
        private volatile boolean g;
        private volatile Manager z;

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.1.0.5";
        }

        protected Object z(Object obj) {
            return obj;
        }

        protected void z(Throwable th) {
        }

        public void z(boolean z) {
            this.g = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(Manager manager, boolean z) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            this.dl = z;
            this.z = manager;
            if (this.z == null || !z) {
                return;
            }
            try {
                Iterator<g<Manager>> it = this.f903a.keySet().iterator();
                while (it.hasNext()) {
                    it.next().z(this.z);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(g<Manager> gVar) {
            if (com.bytedance.sdk.openadsdk.api.gc.z() || this.dl) {
                return;
            }
            this.f903a.put(gVar, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return null;
            }
            return new gc(new AnonymousClass1(new SoftReference(context))).z();
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.z$dl$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0149z<Loader> {
            final /* synthetic */ SoftReference dl;
            final g<Manager> g;
            Loader z;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SoftReference softReference) {
                super();
                this.dl = softReference;
                this.g = new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.z.g
                    public void z(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.z = manager.createLoader((Context) anonymousClass1.dl.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.z.AbstractC0149z
            public void z(final g<Loader> gVar, int i) {
                Loader loader = this.z;
                if (loader == null) {
                    dl.this.call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.z.g
                        public void z(Manager manager) {
                            dl.this.z(AnonymousClass1.this.g);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            anonymousClass1.z = manager.createLoader((Context) anonymousClass1.dl.get());
                            gVar.z(AnonymousClass1.this.z);
                        }
                    }, i + 10000);
                } else {
                    gVar.z(loader);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.2
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Manager manager) {
                    Function<SparseArray<Object>, Object> functionZ;
                    SparseArray<Object> sparseArray = com.bykv.z.z.z.z.dl.z(2).z(8, dl.this.z(obj)).z(-99999987, 4).z(-99999985, Void.class).g().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.dl) || (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1)) == null) {
                        return;
                    }
                    functionZ.apply(sparseArray);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.3
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Manager manager) {
                    Function<SparseArray<Object>, Object> functionZ;
                    Object gVar = obj;
                    if (com.bytedance.sdk.openadsdk.l.g.z(gVar)) {
                        gVar = new com.bytedance.sdk.openadsdk.l.g(obj);
                    }
                    SparseArray<Object> sparseArray = com.bykv.z.z.z.z.dl.z(2).z(8, gVar).z(-99999987, 5).z(-99999985, Void.class).g().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.dl) || (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1)) == null) {
                        return;
                    }
                    functionZ.apply(sparseArray);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return null;
            }
            if (this.z != null) {
                return (T) g(this.z, cls, bundle);
            }
            call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.4
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Manager manager) {
                    dl.g(dl.this.z, cls, bundle);
                }
            }, 6);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T g(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionZ;
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return null;
            }
            SparseArray<Object> sparseArray = com.bykv.z.z.z.z.dl.z(3).z(9, cls).z(10, bundle).z(-99999987, 6).z(-99999985, cls).g().sparseArray();
            if (!(manager instanceof com.bytedance.sdk.openadsdk.api.dl) || (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1)) == null) {
                return null;
            }
            return (T) functionZ.apply(sparseArray);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.5
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Manager manager) {
                    Function<SparseArray<Object>, Object> functionZ;
                    SparseArray<Object> sparseArray = com.bykv.z.z.z.z.dl.z(2).z(7, context).z(-99999987, 3).z(-99999985, Void.class).g().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.dl) || (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1)) == null) {
                        return;
                    }
                    functionZ.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_ACTIVITY, activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.bytedance.sdk.openadsdk.ls.z.g.z(exitInstallListener));
            Object objApply = com.bytedance.sdk.openadsdk.downloadnew.dl.z(TTAppContextHolder.getContext()).apply(com.bykv.z.z.z.z.dl.z(2).z(0, map).z(-99999987, 0).z(-99999985, Boolean.class).g().sparseArray());
            if (objApply == null) {
                return false;
            }
            return ((Boolean) objApply).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.z != null ? this.z.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionZ;
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(com.bytedance.sdk.openadsdk.ls.z.dl.g.z(adSlot)).z(13, z).z(14, i).z(-99999987, 2).z(-99999985, String.class).g();
            if ((this.z instanceof com.bytedance.sdk.openadsdk.api.dl) && (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) this.z).z(1)) != null) {
                Object objApply = functionZ.apply(valueSetG.sparseArray());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> functionZ;
            ValueSet valueSetG = com.bykv.z.z.z.z.dl.z().z(20, bundle).z(-99999987, 19).z(-99999985, Bundle.class).g();
            if ((this.z instanceof com.bytedance.sdk.openadsdk.api.dl) && (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) this.z).z(1)) != null) {
                Object objApply = functionZ.apply(valueSetG.sparseArray());
                if (objApply instanceof Bundle) {
                    return (Bundle) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            call(new g<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.6
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Manager manager) {
                    Function<SparseArray<Object>, Object> functionZ;
                    ValueSet valueSetG = com.bykv.z.z.z.z.dl.z().z(11, i).z(-99999987, 1).z(-99999985, Void.class).g();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.dl) || (functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1)) == null) {
                        return;
                    }
                    functionZ.apply(valueSetG.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.z != null) {
                return this.z.values().intValue(11);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final g<Manager> gVar, final int i) {
            if (com.bytedance.sdk.openadsdk.api.gc.z()) {
                return;
            }
            if (this.z != null) {
                try {
                    gVar.z(this.z);
                    return;
                } catch (Throwable th) {
                    m.a("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    z(th);
                    return;
                }
            }
            if (!this.g && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.bytedance.sdk.openadsdk.fv.z.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.z.dl.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (dl.this.z != null) {
                            gVar.z(dl.this.z);
                        } else {
                            m.a("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        }
                    } catch (Throwable th2) {
                        m.a("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        dl.this.z(th2);
                    }
                }
            });
        }
    }

    private static class gc extends com.bytedance.sdk.openadsdk.ls.z.z {
        private AbstractC0149z<Loader> z;

        gc(AbstractC0149z<Loader> abstractC0149z) {
            this.z = abstractC0149z;
        }

        private void z(g<Loader> gVar, int i) {
            m.g("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.z.z(gVar, i);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void z(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.1
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void g(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.3
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void dl(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.4
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void a(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.5
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void z(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.6
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(3, i).z(1, function).g(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void gc(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.7
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void m(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.8
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(1, function).g(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void e(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.9
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(2, true).z(1, function).g(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void gz(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.10
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(2, true).z(1, function).g(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public void fo(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            z(new g<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.z.gc.2
                @Override // com.bytedance.sdk.openadsdk.api.z.g
                public void z(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.bykv.z.z.z.z.dl.z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).z(2, true).z(1, function).g(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.z.z
        public Pair<Integer, String> z(Exception exc) {
            m.a("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.z$z, reason: collision with other inner class name */
    private static abstract class AbstractC0149z<T> {
        abstract void z(g<T> gVar, int i);

        private AbstractC0149z() {
        }
    }
}
