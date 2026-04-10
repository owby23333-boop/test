package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.ad;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static o f19061c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FileLock f19070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FileOutputStream f19071f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ReentrantLock f19062h = new ReentrantLock();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lock f19063i = new ReentrantLock();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static FileLock f19064k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ThreadLocal<Integer> f19065l = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.o.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Handler f19066m = null;
    static boolean a = false;
    static final FileFilter b = new FileFilter() { // from class: com.tencent.smtt.sdk.o.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21 && name.endsWith(".dex")) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 26 || !name.endsWith(".prof")) {
                return Build.VERSION.SDK_INT < 26 || !name.equals("oat");
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f19067n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f19068o = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19069d = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19072g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f19073j = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f19074p = -1;

    private o() {
        if (f19066m == null) {
            f19066m = new Handler(n.a().getLooper()) { // from class: com.tencent.smtt.sdk.o.3
                @Override // android.os.Handler
                public void handleMessage(Message message) throws Throwable {
                    QbSdk.setTBSInstallingStatus(true);
                    int i2 = message.what;
                    if (i2 == 1) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                        Object[] objArr = (Object[]) message.obj;
                        o.this.b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                        return;
                    }
                    if (i2 == 2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                        Object[] objArr2 = (Object[]) message.obj;
                        o.this.a((Context) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue());
                    } else if (i2 == 3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr3 = (Object[]) message.obj;
                        o.this.b((Context) objArr3[0], (Bundle) objArr3[1]);
                    } else {
                        if (i2 != 4) {
                            return;
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                        Object[] objArr4 = (Object[]) message.obj;
                        o.this.a((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                        QbSdk.setTBSInstallingStatus(false);
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    private void A(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File fileE = e(context, 5);
        File fileP = p(context);
        if (fileE == null || fileP == null) {
            return;
        }
        fileE.renameTo(fileP);
        TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #09");
        e(context, false);
    }

    private void B(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File fileE = e(context, 0);
        if (fileE != null) {
            FileUtil.a(fileE, false);
        }
        m.a(context).c(0, 5);
        m.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static synchronized o a() {
        if (f19061c == null) {
            synchronized (o.class) {
                if (f19061c == null) {
                    f19061c = new o();
                }
            }
        }
        return f19061c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008f -> B:58:0x00a9). Please report as a decompilation issue!!! */
    private void a(int i2, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
                try {
                    properties.setProperty("tbs_local_installation", ITagManager.STATUS_TRUE);
                    properties.store(bufferedOutputStream, (String) null);
                    TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    try {
                        th.printStackTrace();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedInputStream == null) {
                        } else {
                            bufferedInputStream.close();
                        }
                    } finally {
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(Context context) {
        String str;
        if (u(context)) {
            return;
        }
        if (a(context, "core_unzip_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
        } else if (a(context, "core_share_backup_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        } else {
            if (!a(context, "core_copy_tmp")) {
                return;
            }
            TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
        TbsLog.e("TbsInstaller", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ca A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e5 A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03f4 A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0431 A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0440 A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x044c A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0478 A[Catch: Exception -> 0x0509, all -> 0x0523, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0481 A[Catch: Exception -> 0x0509, all -> 0x0523, TRY_LEAVE, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[Catch: Exception -> 0x0509, all -> 0x0523, SYNTHETIC, TryCatch #0 {all -> 0x0523, blocks: (B:20:0x00a2, B:22:0x00bc, B:25:0x00d6, B:27:0x00f0, B:30:0x011e, B:35:0x012e, B:42:0x013e, B:43:0x0147, B:45:0x014d, B:49:0x0194, B:54:0x01bd, B:56:0x01c7, B:59:0x01e9, B:60:0x01f1, B:63:0x01fd, B:65:0x023d, B:67:0x0246, B:82:0x02a1, B:104:0x02ca, B:105:0x02d8, B:107:0x02db, B:109:0x02e7, B:111:0x02f3, B:113:0x02ff, B:115:0x0305, B:118:0x0312, B:120:0x0324, B:122:0x032a, B:123:0x0348, B:126:0x037d, B:129:0x0395, B:132:0x03c0, B:134:0x03d4, B:136:0x03da, B:140:0x03eb, B:142:0x03f4, B:145:0x0431, B:139:0x03e5, B:146:0x0434, B:148:0x0440, B:149:0x0448, B:151:0x0455, B:153:0x0478, B:160:0x04b8, B:159:0x04a0, B:154:0x0481, B:150:0x044c, B:124:0x0377, B:86:0x02a7, B:165:0x04c1, B:170:0x04ca, B:169:0x04c7, B:97:0x02be, B:101:0x02c4, B:171:0x04cb, B:183:0x0529, B:185:0x0540, B:189:0x054e, B:173:0x04f4, B:177:0x050e), top: B:195:0x00a2, inners: #1 }] */
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r22, android.content.Context r23, int r24) {
        /*
            Method dump skipped, instruction units count: 1435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.a(android.content.Context, android.content.Context, int):void");
    }

    private boolean a(Context context, File file, boolean z2) {
        StringBuilder sb;
        TbsDownloadConfig tbsDownloadConfig;
        int i2;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start isDecoupleCore is " + z2);
        if (FileUtil.c(file)) {
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file2 = z2 ? new File(tbsFolderDir, "core_share_decouple") : new File(tbsFolderDir, "core_unzip_tmp");
                if (file2.exists() && !TbsDownloader.a(context)) {
                    FileUtil.b(file2);
                }
            } catch (Throwable th) {
                TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File fileE = z2 ? e(context, 2) : e(context, 0);
            if (fileE != null) {
                try {
                    try {
                        try {
                            FileUtil.a(fileE);
                            if (z2) {
                                FileUtil.a(fileE, true);
                            }
                            boolean zA = FileUtil.a(file, fileE);
                            if (zA) {
                                zA = a(fileE, context);
                            }
                            if (z2) {
                                for (String str : fileE.list()) {
                                    File file3 = new File(fileE, str);
                                    if (file3.getName().endsWith(".dex")) {
                                        file3.delete();
                                    }
                                }
                                try {
                                    new File(r(context), "x5.tbs").delete();
                                } catch (Exception unused) {
                                }
                            }
                            if (zA) {
                                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #05");
                                e(context, true);
                            } else {
                                FileUtil.b(fileE);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + fileE.exists());
                            }
                            return zA;
                        } catch (IOException e2) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                            TbsLogReport.getInstance(context).setInstallErrorCode(206, e2);
                            if ((fileE != null && fileE.exists()) && fileE != null) {
                                try {
                                    FileUtil.b(fileE);
                                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileE.exists());
                                } catch (Throwable th2) {
                                    th = th2;
                                    sb = new StringBuilder();
                                    sb.append("copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:");
                                    sb.append(Log.getStackTraceString(th));
                                    TbsLog.e("TbsInstaller", sb.toString());
                                    TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                                    com.tencent.smtt.utils.s.a(AgooConstants.ACK_BODY_NULL);
                                    return false;
                                }
                            }
                            TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                            com.tencent.smtt.utils.s.a(AgooConstants.ACK_BODY_NULL);
                            return false;
                        }
                    } catch (Exception e3) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(207, e3);
                        if ((fileE != null && fileE.exists()) && fileE != null) {
                            try {
                                FileUtil.b(fileE);
                                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileE.exists());
                            } catch (Throwable th3) {
                                th = th3;
                                sb = new StringBuilder();
                                sb.append("copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:");
                                sb.append(Log.getStackTraceString(th));
                                TbsLog.e("TbsInstaller", sb.toString());
                                TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                                com.tencent.smtt.utils.s.a(AgooConstants.ACK_BODY_NULL);
                                return false;
                            }
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        com.tencent.smtt.utils.s.a(AgooConstants.ACK_BODY_NULL);
                        return false;
                    }
                } finally {
                    TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    com.tencent.smtt.utils.s.a(AgooConstants.ACK_BODY_NULL);
                }
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i2 = -521;
        } else {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i2 = -520;
        }
        tbsDownloadConfig.setInstallInterruptCode(i2);
        return false;
    }

    static boolean a(Context context, String str) {
        StringBuilder sb;
        String str2;
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            sb = new StringBuilder();
            str2 = "#1# ";
        } else {
            if (new File(file, "tbs.conf").exists()) {
                TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#3# " + str);
                return true;
            }
            sb = new StringBuilder();
            str2 = "#2# ";
        }
        sb.append(str2);
        sb.append(str);
        TbsLog.i("TbsInstaller", "isPrepareTbsCore", sb.toString());
        return false;
    }

    private boolean a(File file, Context context) throws Throwable {
        Properties properties;
        boolean z2;
        boolean z3;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file2 = new File(file, "1");
                properties = new Properties();
                try {
                    if (file2.exists()) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                        try {
                            properties.load(bufferedInputStream2);
                            bufferedInputStream = bufferedInputStream2;
                            z2 = true;
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream = bufferedInputStream2;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            z2 = true;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        z2 = false;
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
            properties = null;
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z2);
        if (z2) {
            for (File file3 : file.listFiles()) {
                if (!"1".equals(file3.getName()) && !file3.getName().endsWith(".dex") && !"tbs.conf".equals(file3.getName()) && !file3.isDirectory() && !file3.getName().endsWith(".prof")) {
                    String strA = com.tencent.smtt.utils.a.a(file3);
                    String property = properties.getProperty(file3.getName(), "");
                    if (property.equals("") || !property.equals(strA)) {
                        TbsLog.e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ad.f20406s + " targetMd5:" + property + ", realMd5:" + strA);
                        z3 = false;
                        break;
                    }
                    TbsLog.i("TbsInstaller", "md5_check_success for (" + file3.getName() + ad.f20406s);
                }
            }
            z3 = true;
        } else {
            z3 = true;
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z3);
        if (!z2 || z3) {
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            return true;
        }
        TbsLog.e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
        return false;
    }

    public static void b() {
        f19065l.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0489 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r17, java.lang.String r18, int r19) {
        /*
            Method dump skipped, instruction units count: 1636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.b(android.content.Context, java.lang.String, int):void");
    }

    private boolean b(Context context, File file) {
        return a(context, file, false);
    }

    private int c(Context context, Bundle bundle) throws Throwable {
        int i2;
        int iA;
        TbsLogReport tbsLogReport;
        int i3;
        try {
            Bundle bundleA = QbSdk.a(context, bundle);
            TbsLog.i("TbsInstaller", "tpatch finished,ret is" + bundleA);
            int i4 = bundleA.getInt("patch_result");
            if (i4 != 0) {
                String string = bundle.getString("new_apk_location");
                if (!TextUtils.isEmpty(string)) {
                    FileUtil.b(new File(string));
                }
                TbsLogReport.getInstance(context).setInstallErrorCode(i4, "tpatch fail,patch error_code=" + i4);
                return 1;
            }
            String string2 = bundle.getString("new_apk_location");
            int i5 = bundle.getInt("new_core_ver");
            try {
                i2 = bundle.getInt("for_stable_core");
            } catch (Throwable unused) {
                i2 = 0;
            }
            if (i2 == 1) {
                File file = new File(FileUtil.a(context, "com.tencent.mm", 4, true));
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                int i6 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
                File[] fileArrListFiles = file.listFiles();
                Pattern patternCompile = Pattern.compile(com.tencent.smtt.utils.a.a(false, i6));
                for (File file2 : fileArrListFiles) {
                    if (patternCompile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
                File file3 = new File(file, com.tencent.smtt.utils.a.a(false, i6) + "." + tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                if (!file3.exists()) {
                    file3.createNewFile();
                }
                iA = TbsShareManager.getTbsStableCoreVersion(context, i6);
            } else {
                iA = a(new File(string2));
            }
            TbsLog.i("TbsInstaller", "doTpatch wholeFile is " + i2 + " version is " + i5 + " patchVersion is " + iA);
            if (i5 == iA) {
                if (TbsDownloader.a(context)) {
                    TbsLog.i("TbsInstaller", "Tpatch decouple success!");
                    tbsLogReport = TbsLogReport.getInstance(context);
                    i3 = TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS;
                } else {
                    TbsLog.i("TbsInstaller", "Tpatch success!");
                    tbsLogReport = TbsLogReport.getInstance(context);
                    i3 = TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS;
                }
                tbsLogReport.setInstallErrorCode(i3, "");
                return 0;
            }
            TbsLog.i("TbsInstaller", "version not equals!!!" + i5 + "patchVersion:" + iA);
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_VERSION_FAILED, "version=" + i5 + ",patchVersion=" + iA);
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "patch exception" + Log.getStackTraceString(e2));
            return 1;
        }
    }

    private boolean c(Context context, File file) {
        try {
            File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.o.4
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().endsWith(".jar");
                }
            });
            int length = fileArrListFiles.length;
            if (Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000L);
                } catch (Exception unused) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i2 = 0; i2 < length; i2++) {
                TbsLog.i("TbsInstaller", "jarFile: " + fileArrListFiles[i2].getAbsolutePath());
                new DexClassLoader(fileArrListFiles[i2].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    private synchronized boolean c(Context context, boolean z2) {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z3 = false;
        try {
            if (!s(context)) {
                return false;
            }
            boolean zTryLock = f19062h.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + zTryLock);
            if (zTryLock) {
                try {
                    int iB = m.a(context).b("tpatch_status");
                    int iA = a(false, context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + iB);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + iA);
                    if (iB == 1) {
                        if (iA == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                        } else if (z2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                        }
                        x(context);
                        z3 = true;
                    }
                    f19062h.unlock();
                } catch (Throwable th) {
                    f19062h.unlock();
                    throw th;
                }
            }
            c();
        } catch (Throwable th2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th2));
        }
        return z3;
    }

    private boolean d(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String strA = f.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(strA)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.o.5
                @Override // java.io.FileFilter
                public boolean accept(File file5) {
                    return file5.getName().endsWith(".jar");
                }
            })) {
                String strSubstring = file4.getName().substring(0, r5.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + strA.replaceAll("tbs_sdk_extension_dex", strSubstring) + " --dex-location=" + a().p(context) + File.separator + strSubstring + ".jar").waitFor();
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[Catch: Exception -> 0x00c3, all -> 0x00dd, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00c3, blocks: (B:10:0x0040, B:14:0x0048, B:25:0x00b2, B:29:0x00bf, B:27:0x00b9, B:28:0x00be), top: B:42:0x0040, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean d(android.content.Context r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.d(android.content.Context, boolean):boolean");
    }

    private void e(Context context, boolean z2) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead context is null");
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner return #01");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z2) {
                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file delete #01");
                FileUtil.b(file);
            } else if (file.exists()) {
                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file already exist #01");
            } else {
                TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file create #01");
                file.createNewFile();
            }
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead Exception message is " + e2.getMessage() + " Exception cause is " + e2.getCause());
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead inner exception #01");
        }
    }

    private void f(Context context, int i2) {
        TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + i2);
        if (i2 == 0) {
            TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #03");
            e(context, true);
            m.a(context).b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
        }
        QbSdk.setTBSInstallingStatus(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(android.content.Context r8, int r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "TbsInstaller-doTbsDexOpt start - dirMode: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TbsInstaller"
            com.tencent.smtt.utils.TbsLog.i(r1, r0)
            r0 = 0
            r2 = 1
            if (r9 == 0) goto L3e
            if (r9 == r2) goto L39
            r3 = 2
            if (r9 == r3) goto L34
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La2
            r3.<init>()     // Catch: java.lang.Exception -> La2
            java.lang.String r4 = "doDexoptOrDexoat mode error: "
            r3.append(r4)     // Catch: java.lang.Exception -> La2
            r3.append(r9)     // Catch: java.lang.Exception -> La2
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Exception -> La2
            com.tencent.smtt.utils.TbsLog.e(r1, r9)     // Catch: java.lang.Exception -> La2
            return r0
        L34:
            java.io.File r9 = r7.p(r8)     // Catch: java.lang.Exception -> La2
            goto L49
        L39:
            java.io.File r9 = r7.e(r8, r2)     // Catch: java.lang.Exception -> La2
            goto L49
        L3e:
            boolean r9 = com.tencent.smtt.sdk.TbsDownloader.a(r8)     // Catch: java.lang.Exception -> La2
            if (r9 == 0) goto L45
            return r2
        L45:
            java.io.File r9 = r7.e(r8, r0)     // Catch: java.lang.Exception -> La2
        L49:
            java.lang.String r3 = "java.vm.version"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L65
            java.lang.String r4 = "2"
            boolean r3 = r3.startsWith(r4)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L65
            r3 = 1
            goto L66
        L5b:
            r3 = move-exception
            com.tencent.smtt.sdk.TbsLogReport r4 = com.tencent.smtt.sdk.TbsLogReport.getInstance(r8)     // Catch: java.lang.Exception -> La2
            r5 = 226(0xe2, float:3.17E-43)
            r4.setInstallErrorCode(r5, r3)     // Catch: java.lang.Exception -> La2
        L65:
            r3 = 0
        L66:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> La2
            r5 = 23
            if (r4 != r5) goto L6e
            r4 = 1
            goto L6f
        L6e:
            r4 = 0
        L6f:
            com.tencent.smtt.sdk.TbsDownloadConfig r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8)     // Catch: java.lang.Exception -> La2
            android.content.SharedPreferences r5 = r5.mPreferences     // Catch: java.lang.Exception -> La2
            java.lang.String r6 = "tbs_stop_preoat"
            boolean r5 = r5.getBoolean(r6, r0)     // Catch: java.lang.Exception -> La2
            if (r3 == 0) goto L82
            if (r4 == 0) goto L82
            if (r5 != 0) goto L82
            r0 = 1
        L82:
            if (r0 == 0) goto L90
            boolean r0 = r7.d(r8, r9)     // Catch: java.lang.Exception -> La2
            if (r0 == 0) goto L90
            java.lang.String r9 = "doTbsDexOpt -- doDexoatForArtVm"
            com.tencent.smtt.utils.TbsLog.i(r1, r9)     // Catch: java.lang.Exception -> La2
            return r2
        L90:
            if (r3 == 0) goto L98
            java.lang.String r9 = "doTbsDexOpt -- is ART mode, skip!"
            com.tencent.smtt.utils.TbsLog.i(r1, r9)     // Catch: java.lang.Exception -> La2
            goto Lb3
        L98:
            java.lang.String r0 = "doTbsDexOpt -- doDexoptForDavlikVM"
            com.tencent.smtt.utils.TbsLog.i(r1, r0)     // Catch: java.lang.Exception -> La2
            boolean r8 = r7.c(r8, r9)     // Catch: java.lang.Exception -> La2
            return r8
        La2:
            r9 = move-exception
            r9.printStackTrace()
            com.tencent.smtt.sdk.TbsLogReport r8 = com.tencent.smtt.sdk.TbsLogReport.getInstance(r8)
            r0 = 209(0xd1, float:2.93E-43)
            java.lang.String r9 = r9.toString()
            r8.setInstallErrorCode(r0, r9)
        Lb3:
            java.lang.String r8 = "TbsInstaller-doTbsDexOpt done"
            com.tencent.smtt.utils.TbsLog.i(r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.g(android.content.Context, int):boolean");
    }

    static File r(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    private int t(Context context) {
        boolean z2 = m.a(context).d() == 1;
        boolean zA = TbsDownloader.a(context);
        if (z2) {
            if (zA) {
                return TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
            }
            return 221;
        }
        if (zA) {
            return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        }
        return 200;
    }

    private static boolean u(Context context) {
        String str;
        if (context == null) {
            str = "#1#";
        } else {
            try {
                if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                    TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#2#");
                    return true;
                }
                TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#3#");
                return false;
            } catch (Exception unused) {
                str = "#4#";
            }
        }
        TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", str);
        return true;
    }

    private boolean v(Context context) {
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        f19064k = FileUtil.e(context);
        if (f19064k == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    private void w(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!v(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            y(context);
            z(context);
            TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            m.a(context).a(0);
            m.a(context).b(0);
            m.a(context).d(0);
            m.a(context).a("incrupdate_retry_num", 0);
            m.a(context).c(0, 3);
            m.a(context).a("");
            m.a(context).a("tpatch_num", 0);
            m.a(context).c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().g(context) || i2 != a().h(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().g(context) + " getTbsCoreInstalledVerInNolock is " + a().h(context));
                } else {
                    m(context);
                }
            }
            f19065l.set(0);
            f19067n = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        f(context);
    }

    private void x(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!v(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            y(context);
            A(context);
            m.a(context).b(0, -1);
            m.a(context).a("tpatch_num", 0);
            f19065l.set(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, "exception when renameing from tpatch:" + e2.toString());
        }
        f(context);
    }

    private void y(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        FileUtil.a(p(context), false);
    }

    private void z(Context context) {
        TbsLogReport tbsLogReport;
        int i2;
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File fileE = e(context, 0);
        File fileP = p(context);
        if (fileE == null || fileP == null) {
            TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + fileE + "tbsSharePath=" + fileP);
            return;
        }
        boolean zRenameTo = fileE.renameTo(fileP);
        TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + zRenameTo);
        com.tencent.smtt.utils.s.a("8is" + zRenameTo);
        if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (zRenameTo) {
                tbsLogReport = TbsLogReport.getInstance(context);
                i2 = TbsListener.ErrorCode.RENAME_SUCCESS;
            } else {
                tbsLogReport = TbsLogReport.getInstance(context);
                i2 = TbsListener.ErrorCode.RENAME_FAIL;
            }
            tbsLogReport.setInstallErrorCode(i2, " ");
        }
        TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #07");
        e(context, false);
    }

    int a(File file) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int i2 = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return i2;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
            }
        }
        return 0;
    }

    public int a(boolean z2, Context context) {
        if (z2 || f19065l.get().intValue() <= 0) {
            f19065l.set(Integer.valueOf(h(context)));
        }
        return f19065l.get().intValue();
    }

    File a(Context context, int i2, boolean z2) {
        String str;
        String str2;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i2) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = "";
                break;
        }
        TbsLog.i("TbsInstaller", "type=" + i2 + "needMakeDir=" + z2 + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (z2) {
                str2 = file.mkdir() ? "getCoreDir,no need mkdir" : "getCoreDir,mkdir false";
            }
            TbsLog.i("TbsInstaller", str2);
            return null;
        }
        return file;
    }

    File a(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    File a(Context context, File file) {
        File file2 = new File(file, "core_share_decouple");
        if (file2.isDirectory() || file2.mkdir()) {
            return file2;
        }
        return null;
    }

    public void a(Context context, int i2) {
        TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #01 ");
        e(context, true);
        m.a(context).c(i2, 2);
    }

    void a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        Object[] objArr = {context, bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        f19066m.sendMessage(message);
    }

    public void a(Context context, File file, int i2) throws Throwable {
        FileOutputStream fileOutputStreamB = FileUtil.b(context, true, "core_unzip.lock");
        FileLock fileLockA = FileUtil.a(context, fileOutputStreamB);
        if (fileLockA == null) {
            TbsLog.i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
            return;
        }
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean zA = a(context, file, false);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + zA);
        com.tencent.smtt.utils.s.a(context, "copy_host_core_v3", ("coreVersionIs" + i2) + "_ret=is=" + zA);
        if (zA) {
            a().a(context, i2);
        }
        FileUtil.a(fileLockA, fileOutputStreamB);
    }

    void a(Context context, String str, int i2) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = {context, str, Integer.valueOf(i2)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        f19066m.sendMessage(message);
    }

    void a(Context context, boolean z2) {
        int iC;
        int iB;
        String strD;
        int iC2;
        int iB2;
        boolean z3 = true;
        if (z2) {
            this.f19073j = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (s(context)) {
            if (f19062h.tryLock()) {
                try {
                    iC = m.a(context).c();
                    iB = m.a(context).b();
                    strD = m.a(context).d("install_apk_path");
                    iC2 = m.a(context).c("copy_core_ver");
                    iB2 = m.a(context).b("copy_status");
                } finally {
                    f19062h.unlock();
                }
            } else {
                strD = null;
                iC = -1;
                iB = 0;
                iC2 = 0;
                iB2 = -1;
            }
            c();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + iC);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + iB);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + strD);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + iC2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + iB2);
            int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i2 != 1 && i2 != 2 && i2 != 4) {
                z3 = false;
            }
            if (!z3 && i2 != 0 && i2 != 5) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (iC > -1 && iC < 2) {
                a(context, strD, iB);
            }
            if (iB2 == 0) {
                b(context, iC2);
            }
        }
    }

    public boolean a(Context context, File[] fileArr) {
        return false;
    }

    public int b(Context context) {
        if (!u(context)) {
            return 0;
        }
        if (a(context, "core_unzip_tmp")) {
            return -1;
        }
        if (a(context, "core_share_backup_tmp")) {
            return -2;
        }
        if (a(context, "core_copy_tmp")) {
            return -3;
        }
        return a(context, "tpatch_tmp") ? -4 : 1;
    }

    int b(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(android.content.Context r18, android.os.Bundle r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.b(android.content.Context, android.os.Bundle):void");
    }

    void b(Context context, boolean z2) {
        String str;
        if (QbSdk.b) {
            return;
        }
        if (Build.VERSION.SDK_INT < 8) {
            TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            return;
        }
        TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#1# check local x5core prepared to install");
        if (TbsShareManager.isThirdPartyApp(context) && m.a(context).b("remove_old_core") == 1 && z2) {
            try {
                FileUtil.b(a().p(context));
                TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "thirdAPP success--> delete old core_share Directory");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            m.a(context).a("remove_old_core", 0);
        }
        if (u(context)) {
            TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#2# try to install tbs core from tmp dir");
            if (a(context, "core_unzip_tmp") && d(context, z2)) {
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip !!";
            } else {
                if (!a(context, "tpatch_tmp") || !c(context, z2)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                    return;
                }
                str = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch !!";
            }
            TbsLog.i("TbsInstaller", str, true);
        }
    }

    boolean b(Context context, int i2) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context contextC = c(context, i2);
        if (contextC == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
            return false;
        }
        Object[] objArr = {contextC, context, Integer.valueOf(i2)};
        Message message = new Message();
        message.what = 2;
        message.obj = objArr;
        f19066m.sendMessage(message);
        return true;
    }

    @Deprecated
    public Context c(Context context, int i2) {
        return null;
    }

    synchronized void c() {
        if (this.f19069d <= 0) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.f19069d + "call stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (this.f19069d > 1) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.f19069d--;
        } else {
            if (this.f19069d == 1) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                FileUtil.a(this.f19070e, this.f19071f);
                this.f19069d = 0;
            }
        }
    }

    public void c(Context context) {
        TbsLog.i("TbsInstaller", "setTmpFolderCoreToRead call #02");
        e(context, true);
        m.a(context).c(g(context), 2);
    }

    int d(Context context, int i2) {
        return a(e(context, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: IOException -> 0x006f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x006f, blocks: (B:15:0x006b, B:28:0x0080), top: B:46:0x0019 }] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean d(android.content.Context r10) {
        /*
            r9 = this;
            java.io.File r10 = r9.p(r10)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "tbs.conf"
            r0.<init>(r10, r1)
            boolean r10 = r0.exists()
            r1 = 0
            if (r10 != 0) goto L13
            return r1
        L13:
            java.util.Properties r10 = new java.util.Properties
            r10.<init>()
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L78
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L78
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L78
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L78
            r10.load(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "tbs_local_installation"
            java.lang.String r3 = "false"
            java.lang.String r10 = r10.getProperty(r2, r3)     // Catch: java.lang.Throwable -> L76
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L76
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L76
            r2 = 1
            if (r10 == 0) goto L4a
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L74
            long r7 = r0.lastModified()     // Catch: java.lang.Throwable -> L74
            long r5 = r5 - r7
            r7 = 259200000(0xf731400, double:1.280618154E-315)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L4a
            r1 = 1
        L4a:
            java.lang.String r0 = "TbsInstaller"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r3.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = "TBS_LOCAL_INSTALLATION is:"
            r3.append(r5)     // Catch: java.lang.Throwable -> L74
            r3.append(r10)     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = " expired="
            r3.append(r5)     // Catch: java.lang.Throwable -> L74
            r3.append(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L74
            com.tencent.smtt.utils.TbsLog.i(r0, r3)     // Catch: java.lang.Throwable -> L74
            r0 = r1 ^ 1
            r10 = r10 & r0
            r4.close()     // Catch: java.io.IOException -> L6f
            goto L83
        L6f:
            r0 = move-exception
            r0.printStackTrace()
            goto L83
        L74:
            r0 = move-exception
            goto L7b
        L76:
            r0 = move-exception
            goto L7a
        L78:
            r0 = move-exception
            r4 = r2
        L7a:
            r10 = 0
        L7b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r4 == 0) goto L83
            r4.close()     // Catch: java.io.IOException -> L6f
        L83:
            return r10
        L84:
            r10 = move-exception
            if (r4 == 0) goto L8f
            r4.close()     // Catch: java.io.IOException -> L8b
            goto L8f
        L8b:
            r0 = move-exception
            r0.printStackTrace()
        L8f:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.o.d(android.content.Context):boolean");
    }

    File e(Context context, int i2) {
        return a(context, i2, true);
    }

    public void e(Context context) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            File file = new File(p(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                bufferedInputStream = null;
            }
            try {
                properties.setProperty("tbs_local_installation", ITagManager.STATUS_FALSE);
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (Throwable unused4) {
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (bufferedInputStream == null) {
                    return;
                }
            }
            bufferedInputStream.close();
        } catch (Throwable unused6) {
        }
    }

    public void f(Context context) {
        FileLock fileLock = f19064k;
        if (fileLock != null) {
            FileUtil.a(context, fileLock);
        }
    }

    int g(Context context) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(o(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int i2 = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return i2;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
            }
        }
        return 0;
    }

    int h(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(p(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                TbsLog.i("TbsInstaller", "getTbsCoreInstalledVerInNolock tbsPropFile is " + file.getAbsolutePath());
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                        }
                        return 0;
                    }
                    int i2 = Integer.parseInt(property);
                    if (f19067n == 0) {
                        f19067n = i2;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e3.toString());
                    }
                    return i2;
                } catch (Exception e4) {
                    e = e4;
                    bufferedInputStream = bufferedInputStream2;
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e5.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e7.toString());
            }
        }
        throw th;
    }

    int i(Context context) {
        int i2 = f19067n;
        return i2 != 0 ? i2 : h(context);
    }

    void j(Context context) {
        if (f19067n != 0) {
            return;
        }
        f19067n = h(context);
    }

    boolean k(Context context) {
        return new File(p(context), "tbs.conf").exists();
    }

    int l(Context context) throws Throwable {
        if (!s(context)) {
            return -1;
        }
        boolean zTryLock = f19062h.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + zTryLock);
        if (!zTryLock) {
            c();
            return 0;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(p(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (f19062h.isHeldByCurrentThread()) {
                            f19062h.unlock();
                        }
                    } catch (Throwable th) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th);
                    }
                    c();
                    return 0;
                }
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e2.toString());
                        }
                        try {
                            if (f19062h.isHeldByCurrentThread()) {
                                f19062h.unlock();
                            }
                        } catch (Throwable th2) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                        }
                        c();
                        return 0;
                    }
                    f19065l.set(Integer.valueOf(Integer.parseInt(property)));
                    int iIntValue = f19065l.get().intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e3.toString());
                    }
                    try {
                        if (f19062h.isHeldByCurrentThread()) {
                            f19062h.unlock();
                        }
                    } catch (Throwable th3) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                    }
                    c();
                    return iIntValue;
                } catch (Exception e4) {
                    e = e4;
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e5.toString());
                        }
                    }
                    try {
                        if (f19062h.isHeldByCurrentThread()) {
                            f19062h.unlock();
                        }
                    } catch (Throwable th5) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th5);
                    }
                    c();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e6) {
            e = e6;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e.toString());
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e7.toString());
            }
        }
        try {
            if (f19062h.isHeldByCurrentThread()) {
                f19062h.unlock();
            }
        } catch (Throwable th7) {
            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th7);
        }
        c();
        return 0;
    }

    public boolean m(Context context) {
        return true;
    }

    void n(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        m.a(context).a(0);
        m.a(context).b(0);
        m.a(context).d(0);
        m.a(context).a("incrupdate_retry_num", 0);
        if (TbsDownloader.a(context)) {
            return;
        }
        m.a(context).c(0, -1);
        m.a(context).a("");
        m.a(context).a("copy_retry_num", 0);
        m.a(context).c(-1);
        m.a(context).a(0, -1);
        FileUtil.a(e(context, 0), true);
        FileUtil.a(e(context, 1), true);
    }

    File o(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    File p(Context context) {
        return a((Context) null, context);
    }

    File q(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "share");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    synchronized boolean s(Context context) {
        if (this.f19069d > 0) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.f19069d++;
            return true;
        }
        this.f19071f = FileUtil.b(context, true, "tbslock.txt");
        if (this.f19071f == null) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
            return false;
        }
        this.f19070e = FileUtil.a(context, this.f19071f);
        if (this.f19070e == null) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
            return false;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.f19069d++;
        return true;
    }
}
