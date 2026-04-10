package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;
    static final String[] b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ReaderPreDownloadCallback f18927i;
    Handler a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinkedList<String> f18921c = new LinkedList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f18922d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ReaderWizard f18923e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TbsReaderView.ReaderCallback f18924f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f18925g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Context f18926h = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f18928j = "";

    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i2, boolean z2);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.f18927i = null;
        this.f18927i = readerPreDownloadCallback;
        for (String str : b) {
            this.f18921c.add(str);
        }
        a();
    }

    private void b() {
        b(3);
    }

    void a() {
        this.a = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 3 && !TbsReaderPredownload.this.f18921c.isEmpty()) {
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    if (tbsReaderPredownload.f18922d) {
                        return;
                    }
                    String strRemoveFirst = tbsReaderPredownload.f18921c.removeFirst();
                    TbsReaderPredownload tbsReaderPredownload2 = TbsReaderPredownload.this;
                    tbsReaderPredownload2.f18928j = strRemoveFirst;
                    if (tbsReaderPredownload2.a(strRemoveFirst)) {
                        return;
                    }
                    TbsReaderPredownload.this.a(-1);
                }
            }
        };
    }

    void a(int i2) {
        if (this.f18927i != null) {
            this.f18927i.onEvent(this.f18928j, i2, this.f18921c.isEmpty());
        }
    }

    void a(int i2, int i3) {
        this.a.sendMessageDelayed(this.a.obtainMessage(i2), i3);
    }

    boolean a(String str) {
        if (this.f18925g == null || this.f18923e == null || !ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.f18923e.checkPlugin(this.f18925g, this.f18926h, str, true);
    }

    void b(int i2) {
        this.a.removeMessages(i2);
    }

    boolean c(int i2) {
        return this.a.hasMessages(i2);
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.f18926h = context.getApplicationContext();
        boolean zA = TbsReaderView.a(context.getApplicationContext());
        this.f18924f = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int iIntValue;
                if (num.intValue() == 5012 && 5014 != (iIntValue = ((Integer) obj).intValue())) {
                    if (5013 == iIntValue || iIntValue == 0) {
                        TbsReaderPredownload.this.a(0);
                    } else {
                        TbsReaderPredownload.this.a(-1);
                    }
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    tbsReaderPredownload.f18928j = "";
                    tbsReaderPredownload.a(3, 100);
                }
            }
        };
        try {
            if (this.f18923e == null) {
                this.f18923e = new ReaderWizard(this.f18924f);
            }
            if (this.f18925g == null) {
                this.f18925g = this.f18923e.getTbsReader();
            }
            return this.f18925g != null ? this.f18923e.initTbsReader(this.f18925g, context.getApplicationContext()) : zA;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public void pause() {
        this.f18922d = true;
    }

    public void shutdown() {
        this.f18927i = null;
        this.f18922d = false;
        this.f18921c.clear();
        b();
        ReaderWizard readerWizard = this.f18923e;
        if (readerWizard != null) {
            readerWizard.destroy(this.f18925g);
            this.f18925g = null;
        }
        this.f18926h = null;
    }

    public void start(String str) {
        this.f18922d = false;
        b(3);
        this.f18921c.add(str);
        a(3, 100);
    }

    public void startAll() {
        this.f18922d = false;
        if (!false && !c(3)) {
            a(3, 100);
        }
    }
}
