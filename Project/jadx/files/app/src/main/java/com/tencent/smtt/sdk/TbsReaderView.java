package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static boolean f18929f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    Context a;
    ReaderWizard b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f18930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ReaderCallback f18931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ReaderCallback f18932e;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(context.getApplicationContext());
        this.a = null;
        this.b = null;
        this.f18930c = null;
        this.f18931d = null;
        this.f18932e = null;
        if (!(context instanceof Activity)) {
            throw new RuntimeException("error: unexpect context(none Activity)");
        }
        this.f18931d = readerCallback;
        this.a = context;
        this.f18932e = new ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                TbsReaderView tbsReaderView;
                String str;
                Bundle bundle;
                TbsReaderView tbsReaderView2;
                String str2;
                int iIntValue = num.intValue();
                String string = "";
                Bundle bundle2 = null;
                boolean z2 = true;
                if (iIntValue != 5026) {
                    if (iIntValue != 5030) {
                        switch (iIntValue) {
                            case 5008:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.a)) {
                                    num = 5011;
                                    String resString = TbsReaderView.getResString(TbsReaderView.this.a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z2 = false;
                                } else {
                                    if (obj != null) {
                                        bundle2 = (Bundle) obj;
                                        string = bundle2.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.a, string, 4, 0, "pdf", bundle2);
                                    tbsReaderView = TbsReaderView.this;
                                    str = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                }
                                break;
                            case 5009:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.a)) {
                                    num = 5011;
                                    String resString2 = TbsReaderView.getResString(TbsReaderView.this.a, 5021);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString2);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z2 = false;
                                } else {
                                    if (obj != null) {
                                        bundle2 = (Bundle) obj;
                                        string = bundle2.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.a, string, 4, 0, "", bundle2);
                                    tbsReaderView = TbsReaderView.this;
                                    str = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                }
                                break;
                            case 5010:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.a)) {
                                    num = 5011;
                                    String resString3 = TbsReaderView.getResString(TbsReaderView.this.a, 5022);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString3);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z2 = false;
                                } else {
                                    if (obj != null) {
                                        bundle2 = (Bundle) obj;
                                        string = bundle2.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.a, string, 4, 0, "txt", bundle2);
                                }
                                break;
                            default:
                                z2 = false;
                                break;
                        }
                    } else if (obj != null) {
                        Bundle bundle3 = (Bundle) obj;
                        TbsReaderView.gReaderPackName = bundle3.getString("name");
                        TbsReaderView.gReaderPackVersion = bundle3.getString("version");
                    }
                } else if (MttLoader.isBrowserInstalledEx(TbsReaderView.this.a)) {
                    if (obj != null) {
                        bundle2 = (Bundle) obj;
                        string = bundle2.getString("docpath");
                    }
                    QbSdk.startQBForDoc(TbsReaderView.this.a, string, 4, 0, "doc", bundle2);
                    tbsReaderView = TbsReaderView.this;
                    str = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER;
                    tbsReaderView.userStatistics(str);
                } else {
                    num = 5011;
                    String resString4 = TbsReaderView.getResString(TbsReaderView.this.a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    bundle = new Bundle();
                    bundle.putString("tip", resString4);
                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                    tbsReaderView2 = TbsReaderView.this;
                    str2 = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG;
                    tbsReaderView2.userStatistics(str2);
                    obj = bundle;
                    z2 = false;
                }
                ReaderCallback readerCallback2 = TbsReaderView.this.f18931d;
                if (readerCallback2 == null || z2) {
                    return;
                }
                readerCallback2.onCallBackAction(num, obj, obj2);
            }
        };
    }

    static boolean a(Context context) {
        if (!f18929f) {
            g.a(true).a(context.getApplicationContext(), true, false);
            f18929f = g.a(false).b();
        }
        return f18929f;
    }

    public static Drawable getResDrawable(Context context, int i2) {
        if (a(context)) {
            return ReaderWizard.getResDrawable(i2);
        }
        return null;
    }

    public static String getResString(Context context, int i2) {
        return a(context) ? ReaderWizard.getResString(i2) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        return a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str);
    }

    boolean a() {
        try {
            if (this.b == null) {
                this.b = new ReaderWizard(this.f18932e);
            }
            if (this.f18930c == null) {
                this.f18930c = this.b.getTbsReader();
            }
            if (this.f18930c != null) {
                return this.b.initTbsReader(this.f18930c, this.a);
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj3 = this.f18930c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f18930c;
        if (obj == null) {
            return false;
        }
        return this.b.checkPlugin(obj, this.a, str, true);
    }

    public void onSizeChanged(int i2, int i3) {
        Object obj;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj = this.f18930c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i2, i3);
    }

    public void onStop() {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.destroy(this.f18930c);
            this.f18930c = null;
        }
        this.a = null;
        f18929f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f18930c == null || bundle == null) {
            return;
        }
        bundle.putBoolean("browser6.0", MttLoader.isBrowserInstalledEx(this.a) | (!MttLoader.isBrowserInstalled(this.a)));
        bundle.putBoolean("browser6.1", MttLoader.isGreatBrowserVer(this.a, 6101625L, 610000L) | (!MttLoader.isBrowserInstalled(this.a)));
        this.b.openFile(this.f18930c, this.a, bundle, this);
    }

    public boolean preOpen(String str, boolean z2) {
        if (!isSupportExt(this.a, str)) {
            String str2 = "not supported by:" + str;
            return false;
        }
        boolean zA = a(this.a);
        if (!zA) {
            return zA;
        }
        boolean zA2 = a();
        if (z2 && zA2) {
            return this.b.checkPlugin(this.f18930c, this.a, str, Apn.getApnType(this.a) == 3);
        }
        return zA2;
    }

    public void userStatistics(String str) {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.f18930c, str);
        }
    }
}
