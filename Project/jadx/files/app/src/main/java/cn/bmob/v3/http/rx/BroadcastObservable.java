package cn.bmob.v3.http.rx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastObservable implements ObservableOnSubscribe<Boolean> {
    private final Context context;

    public BroadcastObservable(Context context) {
        this.context = context;
    }

    public static Observable<Boolean> fromConnectivityManager(Context context) {
        return Observable.create(new BroadcastObservable(context)).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnectedToInternet() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static Disposable unsubscribeInUiThread(final Action action) {
        return Disposables.fromAction(new Action() { // from class: cn.bmob.v3.http.rx.BroadcastObservable.1
            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    action.run();
                } else {
                    final Scheduler.Worker workerCreateWorker = AndroidSchedulers.mainThread().createWorker();
                    workerCreateWorker.schedule(new Runnable() { // from class: cn.bmob.v3.http.rx.BroadcastObservable.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                action.run();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            workerCreateWorker.dispose();
                        }
                    });
                }
            }
        });
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cn.bmob.v3.http.rx.BroadcastObservable.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                observableEmitter.onNext(Boolean.valueOf(BroadcastObservable.this.isConnectedToInternet()));
            }
        };
        this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        observableEmitter.setDisposable(unsubscribeInUiThread(new Action() { // from class: cn.bmob.v3.http.rx.BroadcastObservable.3
            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                BroadcastObservable.this.context.unregisterReceiver(broadcastReceiver);
            }
        }));
    }
}
