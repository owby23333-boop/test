package com.mibi.sdk.mvp;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.mvp.IView;
import com.mibi.sdk.mvp.lifecycle.ILifeCycleListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class Presenter<T extends IView> implements IPresenter {
    private static final String KEY_SAVE_ID = "SAVE_ID";
    private Bundle mArguments;
    private Context mContext;
    private T mView;
    private final Class<T> mViewInterface;
    private T mViewProxy;
    private ArrayList<ILifeCycleListener> mLifeCycleListeners = new ArrayList<>();
    private String mId = UUID.randomUUID().toString();
    private final Presenter<T>.PendingEventInvocationHandler mInvocationHandler = new PendingEventInvocationHandler();

    public class PendingEventInvocationHandler implements InvocationHandler {
        private Queue<Presenter<T>.PendingEventInvocationHandler.ViewEvent> mPendingViewEvents;

        public class ViewEvent {
            Object[] mArgs;
            Method mMethod;

            private ViewEvent() {
            }
        }

        private PendingEventInvocationHandler() {
            this.mPendingViewEvents = new LinkedList();
        }

        public void applyPendingEvent() {
            if (Presenter.this.mView == null) {
                return;
            }
            while (!this.mPendingViewEvents.isEmpty()) {
                Presenter<T>.PendingEventInvocationHandler.ViewEvent viewEventPoll = this.mPendingViewEvents.poll();
                try {
                    viewEventPoll.mMethod.invoke(Presenter.this.mView, viewEventPoll.mArgs);
                } catch (Exception e) {
                    throw new IllegalStateException("apply pending method invocation error when view attached", e);
                }
            }
        }

        public void clear() {
            this.mPendingViewEvents.clear();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Utils.ensureOnMainThread();
            Presenter<T>.PendingEventInvocationHandler.ViewEvent viewEvent = new ViewEvent();
            viewEvent.mMethod = method;
            viewEvent.mArgs = objArr;
            this.mPendingViewEvents.offer(viewEvent);
            applyPendingEvent();
            return null;
        }
    }

    public Presenter(Class<T> cls) {
        this.mViewInterface = cls;
    }

    public void addLifeCycleListener(ILifeCycleListener iLifeCycleListener) {
        this.mLifeCycleListeners.add(iLifeCycleListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mibi.sdk.mvp.IPresenter
    public final void attach(IView iView) {
        this.mView = iView;
        this.mInvocationHandler.applyPendingEvent();
        onAttach();
    }

    public void checkInLifecycle() {
        if (this.mContext == null) {
            throw new IllegalStateException("Do not call this method before onInit");
        }
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public final void detach() {
        onDetach();
        this.mView = null;
    }

    public Bundle getArguments() {
        checkInLifecycle();
        return this.mArguments;
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public Context getContext() {
        checkInLifecycle();
        return this.mContext;
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public String getId() {
        return this.mId;
    }

    public T getView() {
        Utils.ensureOnMainThread();
        if (this.mViewProxy == null) {
            this.mViewProxy = (T) Proxy.newProxyInstance(this.mViewInterface.getClassLoader(), new Class[]{this.mViewInterface}, this.mInvocationHandler);
        }
        return this.mViewProxy;
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public void handleResult(int i, int i2, Bundle bundle) {
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().handleResult(i, i2, bundle);
        }
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public final void init(Context context, Bundle bundle, Bundle bundle2) {
        this.mContext = context.getApplicationContext();
        this.mArguments = bundle;
        if (bundle2 != null) {
            this.mId = bundle2.getString(KEY_SAVE_ID);
        }
        onInit(bundle2);
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
    }

    public void onAttach() {
    }

    public void onDetach() {
    }

    public void onInit(Bundle bundle) {
    }

    public void onPause() {
    }

    public void onRelease() {
    }

    public void onResume(IView iView) {
    }

    public void onSave(Bundle bundle) {
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public void pause() {
        onPause();
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public final void release() {
        onRelease();
        this.mView = null;
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mInvocationHandler.clear();
        this.mLifeCycleListeners.clear();
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public void resume(IView iView) {
        onResume(iView);
        Iterator<ILifeCycleListener> it = this.mLifeCycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.mibi.sdk.mvp.IPresenter
    public final void save(Bundle bundle) {
        bundle.putString(KEY_SAVE_ID, this.mId);
        onSave(bundle);
    }
}
