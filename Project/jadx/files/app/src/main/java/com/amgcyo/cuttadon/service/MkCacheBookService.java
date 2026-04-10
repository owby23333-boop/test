package com.amgcyo.cuttadon.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.amgcyo.cuttadon.api.entity.other.DownloadBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.presenter.CatalogPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.fatcatfat.io.R;
import com.umeng.message.entity.UMessage;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import me.jessyan.art.f.e;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkCacheBookService extends Service {
    private static final String A = MkCacheBookService.class.getSimpleName();
    public static boolean B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f4331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4332t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    a f4333u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Intent f4334v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f4335w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    NotificationCompat.Builder f4336x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    NotificationManager f4337y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Notification f4338z;

    private static class a extends AsyncTask<Integer, Integer, Integer> {
        private WeakReference<MkCacheBookService> a;
        private DownloadBean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<MkCatalog> f4339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MkBook f4340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4341e;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.service.MkCacheBookService$a$a, reason: collision with other inner class name */
        class C0113a implements Observer<MkChapterContent> {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ MkCacheBookService f4342s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ int f4343t;

            C0113a(MkCacheBookService mkCacheBookService, int i2) {
                this.f4342s = mkCacheBookService;
                this.f4343t = i2;
            }

            @Override // io.reactivex.Observer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(MkChapterContent mkChapterContent) {
                this.f4342s.a(a.this.f4340d.getBook_id(), this.f4343t, a.this.f4341e);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }
        }

        a(MkCacheBookService mkCacheBookService, DownloadBean downloadBean) {
            this.a = new WeakReference<>(mkCacheBookService);
            this.b = downloadBean;
            this.f4339c = this.b.getCatalogList();
            this.f4341e = this.f4339c.size();
            this.f4340d = downloadBean.getBook();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Integer... numArr) {
            if (isCancelled()) {
                return null;
            }
            CatalogPresenter catalogPresenter = new CatalogPresenter(e.a(MkApplication.getAppContext()));
            MkCacheBookService mkCacheBookService = this.a.get();
            for (int i2 = 0; i2 < this.f4339c.size() && mkCacheBookService != null; i2++) {
                mkCacheBookService.f4332t = i2;
                MkCatalog mkCatalog = this.f4339c.get(i2);
                String absolutePath = z.a(String.valueOf(this.f4340d.getBook_id()), this.f4340d.getReading_site_id(), g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at())).getAbsolutePath();
                mkCatalog.setCacheExists(!g.a(r4));
                try {
                    if (!mkCatalog.isCacheExists() || TextUtils.isEmpty(absolutePath)) {
                        Thread.sleep(this.b.getThread_time());
                        catalogPresenter.a(this.f4340d, mkCatalog).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0113a(mkCacheBookService, i2));
                    } else {
                        String str = mkCatalog.getName() + " 该章节内容缓存已经缓存好了";
                        Thread.sleep(20L);
                        mkCacheBookService.a(this.f4340d.getBook_id(), i2, this.f4341e);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "DownloadBean")
    private void setDownloadBeanInfo(DownloadBean downloadBean) {
        if (downloadBean != null) {
            MkBook book = downloadBean.getBook();
            this.f4331s = book.getName();
            NotificationCompat.Builder builder = this.f4336x;
            if (builder != null) {
                builder.setContentTitle("正在缓存《" + this.f4331s + "》");
            }
            MkApplication.getAppContext().downloadArray.put(book.getBook_id(), book.getBook_id());
            this.f4333u = new a(this, downloadBean);
            this.f4333u.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[0]);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
        this.f4335w = false;
        this.f4338z = a();
        startForeground(1009090, this.f4338z);
    }

    @Override // android.app.Service
    public void onDestroy() {
        B = false;
        stopForeground(true);
        MkApplication.getAppContext().downloadArray.clear();
        EventBus.getDefault().unregister(this);
        this.f4332t = 0;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        this.f4335w = false;
        B = true;
        return super.onStartCommand(intent, i2, i3);
    }

    protected void a(int i2, int i3, int i4) {
        try {
            if (!this.f4335w) {
                if (this.f4334v == null) {
                    this.f4334v = new Intent();
                }
                this.f4334v.setAction("com.example.servicecallback.content");
                this.f4334v.putExtra("book_id", i2);
                this.f4334v.putExtra(NotificationCompat.CATEGORY_PROGRESS, this.f4332t);
                this.f4334v.putExtra("total", i4);
                sendBroadcast(this.f4334v);
                if (this.f4336x != null) {
                    this.f4336x.setContentText(String.format(Locale.getDefault(), "当前进度：第%d章共%d章", Integer.valueOf(this.f4332t), Integer.valueOf(i4)));
                    this.f4338z = this.f4336x.build();
                    this.f4337y.notify(1009090, this.f4338z);
                }
                if (MkApplication.getAppContext().downloadArray.indexOfKey(i2) == -1) {
                    MkApplication.getAppContext().downloadArray.put(i2, i2);
                }
            }
            if (this.f4332t >= i4 - 1) {
                stopSelf();
                this.f4335w = true;
            }
        } catch (Exception unused) {
            stopSelf();
            this.f4335w = true;
            MkApplication.getAppContext().downloadArray.clear();
            o.b("出现错误，请重试!");
        }
    }

    private Notification a() {
        this.f4337y = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("notification_channel_id_010203", "书籍缓存通知", 2);
            notificationChannel.setDescription("缓存书籍章节");
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.enableVibration(false);
            NotificationManager notificationManager = this.f4337y;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        this.f4336x = new NotificationCompat.Builder(this, "notification_channel_id_010203");
        this.f4336x.setVibrate(new long[]{0});
        this.f4336x.setSmallIcon(R.mipmap.app_logo);
        this.f4336x.setContentTitle("正在缓存");
        this.f4336x.setContentText("开始缓存...");
        this.f4336x.setWhen(System.currentTimeMillis());
        return this.f4336x.build();
    }
}
