package com.dangdang.reader.global;

import android.content.Context;
import com.dangdang.reader.utils.ConfigManager;
import com.duokan.reader.domain.store.DkStoreBookInfo;

/* JADX INFO: loaded from: classes10.dex */
public class DangdangConfig {
    public static final String BUY_BOOK_CITY = "bookCity";
    public static final String BUY_READER_BORROW = "readerBorrow";
    public static final String BUY_READER_TRY_READ = "readerTryRead";
    public static final String BUY_SHELF_BORROW = "shelfBorrow";
    public static final String BUY_SHELF_STEAL = "shelfSteal";
    private static final String DEVELOP_120_URL = "http://10.255.223.120";
    private static final String DEVELOP_URL = "http://10.255.223.117";
    public static final int EBOOK_BUY_PAYMENT_KEY_ALI = 1004;
    public static final int EBOOK_BUY_PAYMENT_KEY_WEIXIN = 1005;
    private static final String GATEWAY_ONLINE_URL = "http://api.dangdang.com";
    private static final String GATEWAY_ST_URL = "http://st.api.dangdang.com";
    private static final String GATEWAY_TEST_URL = "http://test.api.dangdang.com";
    private static final String GATEWAY_TEST_URL_1 = "http://10.255.255.99:9109/";
    public static final String JSON_KEY_BOOK_REFER_TYPE = "referType";
    public static final String LISTEN_API_MD5_SIGN_KEY = "BCB85603ED5961A280FAD963EBABF4DE";
    public static String MODULE_DEVELOP_120_ENVIRONMENT = "develop_120";
    public static String MODULE_DEVELOP_ENVIRONMENT = "develop_117";
    public static String MODULE_K8S_ENVIRONMENT = "dev_1_k8s";
    public static String MODULE_K8S_ONLINE_ENVIRONMENT = "online_k8s";
    public static String MODULE_K8S_STAGE_ENVIRONMENT = "staging_k8s";
    public static String MODULE_NGINX_ONLINE_ENVIRONMENT = "online_nginx";
    public static String MODULE_ONLINE_ENVIRONMENT = "online";
    public static String MODULE_STAG2_ENVIRONMENT = "staging2_32";
    public static String MODULE_STAG2_EXTERNAL_ENVIRONMENT = "staging2_external";
    public static String MODULE_STAG3_ENVIRONMENT = "staging3_20";
    public static String MODULE_STAG_ENVIRONMENT = "staging_27";
    public static final int MODULE_SUB_ID_EBOOK_ONE_KEY_BROUGHT_PAY = 3;
    public static String MODULE_TEST_ENVIRONMENT = "test_212";
    private static final String ONLINE_FOR_K8S_URL = "http://e.pdt.k8s.eb.dapp.com";
    private static final String ONLINE_FOR_NGINX_URL = "http://10.5.38.100";
    private static final String ONLINE_URL = "http://e.dangdang.com";
    public static final int PAPER_BOOK_BUY_PAYMENT_KEY_ALI = 1004;
    public static final int PAPER_BOOK_BUY_PAYMENT_KEY_WEIXIN = 1005;
    public static final String PLAN_EXPLAIN_URL = "https://e.dangdang.com/media/h5/fenxiang/dushujihua/plan_instruction.html";
    public static final int PageSize = 10;
    public static final int SMALL_BELL_RECHARGE_PAYMENT_KEY_ALI = 1018;
    public static final int SMALL_BELL_RECHARGE_PAYMENT_KEY_HUAWEI = 1020;
    public static final int SMALL_BELL_RECHARGE_PAYMENT_KEY_SMS = 1019;
    public static final int SMALL_BELL_RECHARGE_PAYMENT_KEY_TENPAY = 1016;
    public static final int SMALL_BELL_RECHARGE_PAYMENT_KEY_WEIXIN = 1017;
    private static final String STAGE2_EXTERNAL_URL = "http://e-staging2.dangdang.com";
    private static final String STAGE2_URL = "http://e-staging2.dangdang.com";
    private static final String STAGE3_URL = "http://10.4.36.20";
    private static final String STAGE_FOR_K8S_URL = "http://e.stg-1.k8s.eb.dapp.com";
    private static final String STAG_URL = "http://e-staging1.dangdang.com";
    private static final String TEST_FOR_K8S_URL = "http://e.dev-1.k8s.eb.dapp.com";
    private static final String TEST_URL = "http://10.255.223.212";
    public static String TING_YUN_APP_KEY = "af3eda2a08d049529e6d3af75931d52b";
    public static final int TYPE_ALIX_PAY = 7;
    public static final int TYPE_COUPON_PAY = 18;
    public static final int TYPE_GIFT_CARD_PAY = 17;
    public static final int TYPE_MINITEN_PAY = 9;
    public static final int TYPE_NET_ALIX_PAY = 8;
    public static final int TYPE_TEN_PAY = 6;
    public static final int TYPE_VIRTUAL_COIN_PAY = 16;
    public static final String fromPaltform_client = "ds_android";
    private static Context mContext = null;
    public static String mEnvironment = "online";
    public static boolean mLogON = true;
    public static String SERVER_MEDIA_API_URL = getAppHost() + "/media/api.go?";
    public static String SERVER_MEDIA_API2_URL = getAppHost() + "/media/api2.go?";
    public static String SERVER_EAPI_URL = getAppHost() + "/mobile/api2.do?";
    public static String SERVER_MOBILE_API2_URL = getAppHost() + "/mobile/api2.do?";
    public static String SERVER_MOBILE_BOOK_CLOUD_API2_URL = getAppBookCloudHost() + "/mobile/api2.do?";
    public static final String PERSONAL_HISTORY_HTML_PATH = getAppH5Host() + "/media/h5/ddreader50/yueli2016/yueli2016.html";
    public static final String PRIVATE_PROTECT_HTML_PATH = getAppH5Host() + "/touch/ddreader50/appAgreement-page.html";
    public static final String ABOUT_HTML_PATH = getAppH5Host() + "/touch/ddreader50/agreement-page.html?type=userLogin";
    public static String BOOK_SHELF_RECOMMAND_COLUMN_HOST = getAppH5Host() + "/media/h5/ddreader50/list-page.html?type=listType&code=";
    public static String BOOK_SHELF_TO_SPECIAL_PAGE_HOST = getAppH5Host() + "/media/h5/ddreader50/special-page.html?stId=";
    public static String STORE_PAGER_ORDER_SETTLE_URL_ONLINE = "https://mcheckoutb.dangdang.com/h5_checkout.php";
    public static String STORE_PAGER_ORDER_SETTLE_URL_TEST = "https://mtestb.dangdang.com/h5_checkout.php";
    public static String STORE_PAGER_ORDER_SETTLE_URL_ST = "https://stmcheckout.dangdang.com/h5_checkout.php";
    public static boolean isUseH5SettlePaperBook = true;
    public static String notification_channel_id = "my_notification_channel";
    public static String PUNCH_THE_CLOCK_END = "readingClock-page.html";

    public static class ParamsType {
        static String mPagekageName;

        public static String getDeviceType() {
            return (isReader() || isXingkong()) ? DkStoreBookInfo.PLATFORM : "";
        }

        public static String getFromPaltform() {
            return (isReader() || isXingkong()) ? DangdangConfig.fromPaltform_client : "";
        }

        public static String getFromPaltformNoDevice() {
            return (isReader() || isXingkong()) ? "ds" : "";
        }

        public static String getFromPlatform() {
            return isReader() ? "103" : isXingkong() ? "110" : "";
        }

        public static String getPlatformSource() {
            return (isReader() || isXingkong()) ? "DDDS-P" : "";
        }

        public static void initPackageName(String str) {
            mPagekageName = str;
        }

        public static boolean isReader() {
            return "com.dangdang.reader".equals(mPagekageName);
        }

        public static boolean isXingkong() {
            return "com.dangdang.xingkong".equals(mPagekageName);
        }
    }

    public static String gerUserClient() {
        return "ddreader_android";
    }

    public static String getAction() {
        return "get_order_flow";
    }

    public static String getAppBookCloudHost() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return environment.equals(MODULE_DEVELOP_ENVIRONMENT) ? DEVELOP_URL : environment.equals(MODULE_DEVELOP_120_ENVIRONMENT) ? DEVELOP_120_URL : environment.equals(MODULE_TEST_ENVIRONMENT) ? "http://10.255.223.212:8090" : environment.equals(MODULE_STAG_ENVIRONMENT) ? STAG_URL : environment.equals(MODULE_STAG2_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_STAG3_ENVIRONMENT) ? STAGE3_URL : environment.equals(MODULE_STAG2_EXTERNAL_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_K8S_ENVIRONMENT) ? TEST_FOR_K8S_URL : environment.equals(MODULE_K8S_STAGE_ENVIRONMENT) ? STAGE_FOR_K8S_URL : environment.equals(MODULE_K8S_ONLINE_ENVIRONMENT) ? ONLINE_FOR_K8S_URL : environment.equals(MODULE_NGINX_ONLINE_ENVIRONMENT) ? ONLINE_FOR_NGINX_URL : ONLINE_URL;
    }

    public static String getAppH5Host() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return environment.equals(MODULE_DEVELOP_ENVIRONMENT) ? DEVELOP_URL : environment.equals(MODULE_DEVELOP_120_ENVIRONMENT) ? DEVELOP_120_URL : environment.equals(MODULE_TEST_ENVIRONMENT) ? TEST_URL : environment.equals(MODULE_STAG_ENVIRONMENT) ? STAG_URL : environment.equals(MODULE_STAG2_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_STAG3_ENVIRONMENT) ? STAGE3_URL : environment.equals(MODULE_STAG2_EXTERNAL_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_K8S_ENVIRONMENT) ? TEST_FOR_K8S_URL : environment.equals(MODULE_K8S_STAGE_ENVIRONMENT) ? STAGE_FOR_K8S_URL : environment.equals(MODULE_K8S_ONLINE_ENVIRONMENT) ? ONLINE_FOR_K8S_URL : environment.equals(MODULE_NGINX_ONLINE_ENVIRONMENT) ? ONLINE_FOR_NGINX_URL : isOnLineEnv() ? ONLINE_URL.replace("http://", "https://") : ONLINE_URL;
    }

    public static String getAppHost() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return environment.equals(MODULE_DEVELOP_ENVIRONMENT) ? DEVELOP_URL : environment.equals(MODULE_DEVELOP_120_ENVIRONMENT) ? DEVELOP_120_URL : environment.equals(MODULE_TEST_ENVIRONMENT) ? TEST_URL : environment.equals(MODULE_STAG_ENVIRONMENT) ? STAG_URL : environment.equals(MODULE_STAG2_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_STAG3_ENVIRONMENT) ? STAGE3_URL : environment.equals(MODULE_STAG2_EXTERNAL_ENVIRONMENT) ? "http://e-staging2.dangdang.com" : environment.equals(MODULE_K8S_ENVIRONMENT) ? TEST_FOR_K8S_URL : environment.equals(MODULE_K8S_STAGE_ENVIRONMENT) ? STAGE_FOR_K8S_URL : environment.equals(MODULE_K8S_ONLINE_ENVIRONMENT) ? ONLINE_FOR_K8S_URL : environment.equals(MODULE_NGINX_ONLINE_ENVIRONMENT) ? ONLINE_FOR_NGINX_URL : ONLINE_URL;
    }

    public static int getBaiduPushAppId() {
        if (ParamsType.isReader()) {
            return 11;
        }
        return ParamsType.isXingkong() ? 9 : 0;
    }

    public static String getColumnAuthenticationUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/writerCertification-page.html";
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getDoubleSignhUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/doubleCheck-page.html";
    }

    public static String getEncodeString() {
        return "EdsgerWybeDijkstra";
    }

    public static String getFocusWeiXinUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/publicnoguide-page.html?code=publicnoguide";
    }

    public static String getGatewayUrl() {
        return isOnLineEnv() ? GATEWAY_ONLINE_URL : isStageEnv() ? GATEWAY_ST_URL : GATEWAY_TEST_URL;
    }

    public static String getListenPackageDetailUrl() {
        return getAppH5Host() + "/touch/ddreader50/listenVipDetail-page.html";
    }

    public static String getListenPackageUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/listenVip-page.html";
    }

    public static String getPunchClockUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/" + PUNCH_THE_CLOCK_END;
    }

    public static String getPunchRankUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/myRecord-page.html";
    }

    public static String getStorePagerOrderSettleUrl() {
        return isOnLineEnv() ? STORE_PAGER_ORDER_SETTLE_URL_ONLINE : isStageEnv() ? STORE_PAGER_ORDER_SETTLE_URL_ST : STORE_PAGER_ORDER_SETTLE_URL_TEST;
    }

    public static String getTaskUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/dailyTask-page.html";
    }

    public static String getVipAutoPurchUrl() {
        return getAppH5Host() + "/touch/ddreader50/autoPayVip-page.html";
    }

    public static String getVipUrl() {
        return getAppH5Host() + "/media/h5/ddreader50/myVip-page.html?";
    }

    public static boolean isDebug() {
        return mLogON;
    }

    public static boolean isDebugForConfig() {
        return false;
    }

    public static boolean isDevelopEnv() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return MODULE_DEVELOP_ENVIRONMENT.equals(environment) || MODULE_DEVELOP_120_ENVIRONMENT.equals(environment) || MODULE_K8S_ENVIRONMENT.equals(environment);
    }

    public static boolean isOnLineEnv() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return MODULE_ONLINE_ENVIRONMENT.equals(environment) || MODULE_K8S_ONLINE_ENVIRONMENT.equals(environment) || MODULE_NGINX_ONLINE_ENVIRONMENT.equals(environment);
    }

    public static boolean isOnLineOrStaggingEnv() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return MODULE_STAG_ENVIRONMENT.equals(environment) || MODULE_ONLINE_ENVIRONMENT.equals(environment) || MODULE_STAG2_ENVIRONMENT.equals(environment) || "http://e-staging2.dangdang.com".equals(environment) || MODULE_STAG3_ENVIRONMENT.equals(environment) || MODULE_K8S_STAGE_ENVIRONMENT.equals(environment) || MODULE_K8S_ONLINE_ENVIRONMENT.equals(environment) || MODULE_NGINX_ONLINE_ENVIRONMENT.equals(environment);
    }

    public static boolean isStage2Env() {
        return MODULE_STAG2_ENVIRONMENT.equals(isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment);
    }

    public static boolean isStage2ExternalEnv() {
        return MODULE_STAG2_EXTERNAL_ENVIRONMENT.equals(isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment);
    }

    public static boolean isStage3Env() {
        return MODULE_STAG3_ENVIRONMENT.equals(isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment);
    }

    public static boolean isStageEnv() {
        String environment = isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment;
        return MODULE_STAG_ENVIRONMENT.equals(environment) || MODULE_STAG2_ENVIRONMENT.equals(environment) || MODULE_STAG2_EXTERNAL_ENVIRONMENT.equals(environment) || MODULE_STAG3_ENVIRONMENT.equals(environment) || MODULE_K8S_STAGE_ENVIRONMENT.equals(environment);
    }

    public static boolean isTestEnv() {
        return MODULE_TEST_ENVIRONMENT.equals(isDebugForConfig() ? new ConfigManager(getContext()).getEnvironment() : mEnvironment);
    }

    public static void setContext(Context context) {
        mContext = context;
        SERVER_MEDIA_API_URL = getAppHost() + "/media/api.go?";
        SERVER_MEDIA_API2_URL = getAppHost() + "/media/api2.go?";
        SERVER_EAPI_URL = getAppHost() + "/mobile/api2.do?";
        SERVER_MOBILE_API2_URL = getAppHost() + "/mobile/api2.do?";
    }
}
