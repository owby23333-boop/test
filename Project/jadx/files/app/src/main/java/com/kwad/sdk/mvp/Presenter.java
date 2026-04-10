package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.service.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Presenter {
    private Object atN;
    private View mRootView;
    private final List<Presenter> atM = new CopyOnWriteArrayList();
    private PresenterState atO = PresenterState.INIT;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        static {
            int i2 = 0;
            INIT = new PresenterState("INIT", i2, i2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            int i3 = 1;
            CREATE = new PresenterState("CREATE", i3, i3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.atM.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).H(presenter.mRootView);
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            int i4 = 2;
            BIND = new PresenterState("BIND", i4, i4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.atM.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).f(presenter.atN);
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            int i5 = 3;
            UNBIND = new PresenterState("UNBIND", i5, i5) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.atM.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).ko();
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            int i6 = 4;
            DESTROY = new PresenterState("DESTROY", i6, i6) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.atM.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e2) {
                            b.gatherException(e2);
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            };
            $VALUES = new PresenterState[]{INIT, CREATE, BIND, UNBIND, DESTROY};
        }

        private PresenterState(String str, int i2, int i3) {
            this.mIndex = i3;
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }

        abstract void performCallState(Presenter presenter);
    }

    private boolean Bq() {
        return this.atO.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        if (this.atO.index() >= PresenterState.UNBIND.index() || presenter.atO.index() >= PresenterState.UNBIND.index()) {
            return;
        }
        if (Bq() && !presenter.Bq() && (view = this.mRootView) != null) {
            presenter.H(view);
        }
        if (!isBound() || !presenter.Bq() || presenter.isBound() || (obj = this.atN) == null) {
            return;
        }
        presenter.f(obj);
    }

    private boolean isBound() {
        return this.atO == PresenterState.BIND;
    }

    public final List<Presenter> Br() {
        return this.atM;
    }

    public final Object Bs() {
        return this.atN;
    }

    @UiThread
    public final void H(View view) {
        this.atO = PresenterState.CREATE;
        this.mRootView = view;
        onCreate();
        this.atO.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.atM.add(presenter);
        if (!Bq() || presenter.Bq()) {
            return;
        }
        H(this.mRootView);
    }

    public final void a(Presenter presenter, boolean z2) {
        this.atM.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            b.gatherException(th);
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    protected void ar() {
    }

    @UiThread
    public final void destroy() {
        if (this.atO == PresenterState.BIND) {
            ko();
        }
        this.atO = PresenterState.DESTROY;
        onDestroy();
        this.atO.performCallState(this);
    }

    @UiThread
    public final void f(@NonNull Object obj) {
        if (this.atO != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.atO == PresenterState.BIND) {
            ko();
        }
        this.atO = PresenterState.BIND;
        this.atN = obj;
        ar();
        this.atO.performCallState(this);
    }

    public final <T extends View> T findViewById(int i2) {
        return (T) this.mRootView.findViewById(i2);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        Context context = getContext();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(context);
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ResContext) {
                Context delegatedContext = ((ResContext) context).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
            context = ((ContextWrapper) context).getBaseContext();
        } while (!hashSet.contains(context));
        return null;
    }

    public final Context getContext() {
        View view = this.mRootView;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void ko() {
        this.atO = PresenterState.UNBIND;
        onUnbind();
        this.atO.performCallState(this);
    }

    protected void onCreate() {
    }

    protected void onDestroy() {
    }

    protected void onUnbind() {
    }
}
