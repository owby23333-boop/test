package com.amgcyo.cuttadon.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amgcyo.cuttadon.activity.main.UmPushBookDialogActivity;
import com.amgcyo.cuttadon.activity.setting.MkNoticeActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.UmPushBean;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: compiled from: PushHelper.java */
    class a implements UPushRegisterCallback {
        a() {
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onFailure(String str, String str2) {
            String str3 = "register failure：--> code:" + str + ",desc:" + str2;
            System.out.println("push register failure  code:" + str + ",desc:" + str2);
            com.amgcyo.cuttadon.utils.otherutils.g.a(true);
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onSuccess(String str) {
            String str2 = "deviceToken --> " + str;
            if (!TextUtils.isEmpty(str)) {
                System.out.println("push register success");
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(true);
                System.out.println("push register failure");
            }
        }
    }

    /* JADX INFO: compiled from: PushHelper.java */
    class b extends UmengMessageHandler {
        b() {
        }

        @Override // com.umeng.message.UmengMessageHandler
        public void dealWithCustomMessage(Context context, UMessage uMessage) {
            super.dealWithCustomMessage(context, uMessage);
            String str = "custom receiver:" + uMessage.getRaw().toString();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.umeng.message.UmengMessageHandler
        public void dealWithNotificationMessage(Context context, UMessage uMessage) {
            super.dealWithNotificationMessage(context, uMessage);
            JSONObject raw = uMessage.getRaw();
            boolean zA = g0.a().a("currentt_run_foreground", false);
            String str = "是否在前台运行：" + zA;
            if (raw != null) {
                String string = raw.toString();
                UmPushBean umPushBean = (UmPushBean) r.a(string, UmPushBean.class);
                if (umPushBean != null) {
                    UmPushBean.ExtraBean extra = umPushBean.getExtra();
                    String type = extra.getType();
                    int bookId = extra.getBookId();
                    int form = extra.getForm();
                    String str2 = "类型：" + type + " bookId: " + bookId;
                    byte b = -1;
                    switch (type.hashCode()) {
                        case -1945383662:
                            if (type.equals("bookUpdate")) {
                                b = 1;
                            }
                            break;
                        case -1039690024:
                            if (type.equals("notice")) {
                                b = 4;
                            }
                            break;
                        case -191501435:
                            if (type.equals("feedback")) {
                                b = 2;
                            }
                            break;
                        case 1614800665:
                            if (type.equals("bookDetails")) {
                                b = 0;
                            }
                            break;
                        case 2103873213:
                            if (type.equals("comment_rep")) {
                                b = 3;
                            }
                            break;
                    }
                    if (b != 0) {
                        if (b != 1) {
                            if (b == 2 || b == 3) {
                                if (zA && com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
                                    Intent intent = new Intent(context, (Class<?>) MkNoticeActivity.class);
                                    intent.putExtra("UmPushBean", umPushBean);
                                    intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                                    context.startActivity(intent);
                                }
                            } else if (b == 4 && zA) {
                                Intent intent2 = new Intent(context, (Class<?>) MkNoticeActivity.class);
                                intent2.putExtra("UmPushBean", umPushBean);
                                intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                                context.startActivity(intent2);
                            }
                        } else if (zA) {
                            com.amgcyo.cuttadon.f.o.b("收藏的书籍更新啦~");
                            com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
                            if (fVarA != null && bookId > 0) {
                                fVarA.c(0, bookId);
                            }
                        }
                    } else if (zA) {
                        MkBook mkBook = new MkBook();
                        mkBook.setBook_id(bookId);
                        mkBook.setImage(extra.getImage());
                        mkBook.setRemark(extra.getRemark());
                        mkBook.setAuthor(extra.getAuthor());
                        mkBook.setLtype(extra.getLtype());
                        mkBook.setForm(form);
                        mkBook.setName(extra.getBookName());
                        mkBook.setPush_status(extra.getStatus());
                        Intent intent3 = new Intent(context, (Class<?>) UmPushBookDialogActivity.class);
                        intent3.putExtra("book", mkBook);
                        intent3.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                        context.startActivity(intent3);
                    }
                }
                String str3 = "notification receiver:" + string;
            }
        }
    }

    /* JADX INFO: compiled from: PushHelper.java */
    class c extends UmengNotificationClickHandler {
        c() {
        }

        @Override // com.umeng.message.UmengNotificationClickHandler
        public void dismissNotification(Context context, UMessage uMessage) {
            super.dismissNotification(context, uMessage);
            String str = "click dismissNotification: " + uMessage.getRaw().toString();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
        @Override // com.umeng.message.UmengNotificationClickHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void launchApp(android.content.Context r13, com.umeng.message.entity.UMessage r14) {
            /*
                Method dump skipped, instruction units count: 316
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.m.c.launchApp(android.content.Context, com.umeng.message.entity.UMessage):void");
        }

        @Override // com.umeng.message.UmengNotificationClickHandler
        public void openActivity(Context context, UMessage uMessage) {
            super.openActivity(context, uMessage);
            String str = "click openActivity: " + uMessage.getRaw().toString();
        }
    }

    public static void a(Context context) {
        UMConfigure.init(context, com.amgcyo.cuttadon.utils.otherutils.g.U(), com.amgcyo.cuttadon.utils.otherutils.g.T(), 1, com.amgcyo.cuttadon.utils.otherutils.g.V());
        UMConfigure.setLogEnabled(false);
        PushAgent pushAgent = PushAgent.getInstance(context);
        pushAgent.setResourcePackageName("com.amgcyo.cuttadon");
        pushAgent.setPushCheck(true);
        d(context);
        pushAgent.register(new a());
        if (b(context)) {
            e(context);
        }
    }

    private static boolean b(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public static void c(Context context) {
        try {
            AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
            builder.setAppKey(null);
            builder.setAppSecret(com.amgcyo.cuttadon.utils.otherutils.g.V());
            builder.setTag("default");
            ACCSClient.init(context, builder.build());
            TaobaoRegister.setAccsConfigTag(context, "default");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        UMConfigure.preInit(context, null, null);
        if (b(context)) {
            return;
        }
        a(context);
    }

    private static void d(Context context) {
        PushAgent pushAgent = PushAgent.getInstance(context);
        pushAgent.setDisplayNotificationNumber(0);
        pushAgent.setMessageHandler(new b());
        pushAgent.setNotificationClickHandler(new c());
    }

    private static void e(Context context) {
    }
}
