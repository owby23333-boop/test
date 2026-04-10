package cn.bmob.v3.http.bean;

import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobURL;
import com.anythink.expressad.d.a.b;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Migration {
    private List<String> batch;
    private List<String> cdn;
    private List<String> cloud_query;
    private List<String> collect;
    private List<String> create;
    private List<String> delcdnbatch;
    private List<String> delcdnupload;
    private List<String> delete;
    private List<String> device;
    private List<String> domain;
    private List<String> email_verify;
    private List<String> find;
    private List<String> functions;
    private boolean isFirst;
    private List<String> login;
    private List<String> login_or_signup;
    private List<String> pay;
    private List<String> pay_query;
    private List<String> phone_ci;
    private List<String> phone_reset;
    private List<String> push;
    private List<String> query_sms;
    private List<String> request_sms;
    private List<String> request_sms_code;
    private List<String> reset;
    private List<String> savecdnupload;
    private List<String> schemas;
    private List<String> signup;
    private List<String> tcp_fileserver_url;
    private List<String> timestamp;
    private List<String> update;
    private List<String> update_user_password;
    private List<String> verify_sms_code;
    private final String BATCH = "batch";
    private final String CDN = "cdn";
    private final String CLOUD_QUERY = "cloud_query";
    private final String CREATE = "create";
    private final String DELCDNBATCH = "delcdnbatch";
    private final String DELCDNUPLOAD = "delcdnupload";
    private final String DELETE = b.az;
    private final String DEVICE = "device";
    private final String PHONE_CI = "phone_ci";
    private final String EMAIL_VERIFY = "email_verify";
    private final String FIND = "find";
    private final String COLLECT = "collect";
    private final String FUNCTIONS = "functions";
    private final String LOGIN = "login";
    private final String LOGIN_OR_SIGNUP = "login_or_signup";
    private final String PAY = "pay";
    private final String PAY_QUERY = "pay_query";
    private final String PHONE_RESET = "phone_reset";
    private final String PUSH = "push";
    private final String QUERY_SMS = "query_sms";
    private final String REQUEST_SMS = "request_sms";
    private final String REQUEST_SMS_CODE = "request_sms_code";
    private final String RESET = "reset";
    private final String SAVECDNUPLOAD = "savecdnupload";
    private final String SCHEMAS = "schemas";
    private final String SIGNUP = "signup";
    private final String TCP_FILESERVER_URL = "tcp_fileserver_url";
    private final String TIMESTAMP = "timestamp";
    private final String UPDATE = "update";
    private final String UPDATE_USER_PASSWORD = "update_user_password";
    private final String VERIFY_SMS_CODE = "verify_sms_code";
    private HashMap<String, List<String>> map = new HashMap<>();

    private void addToMap() {
        if (this.isFirst) {
            return;
        }
        this.map.put("batch", this.batch);
        this.map.put("cdn", this.cdn);
        this.map.put("cloud_query", this.cloud_query);
        this.map.put("create", this.create);
        this.map.put("delcdnbatch", this.delcdnbatch);
        this.map.put("delcdnupload", this.delcdnupload);
        this.map.put(b.az, this.delete);
        this.map.put("device", this.device);
        this.map.put("phone_ci", this.phone_ci);
        this.map.put("email_verify", this.email_verify);
        this.map.put("find", this.find);
        this.map.put("collect", this.collect);
        this.map.put("functions", this.functions);
        this.map.put("login", this.login);
        this.map.put("login_or_signup", this.login_or_signup);
        this.map.put("pay", this.pay);
        this.map.put("pay_query", this.pay_query);
        this.map.put("phone_reset", this.phone_reset);
        this.map.put("push", this.push);
        this.map.put("query_sms", this.query_sms);
        this.map.put("request_sms", this.request_sms);
        this.map.put("request_sms_code", this.request_sms_code);
        this.map.put("reset", this.reset);
        this.map.put("savecdnupload", this.savecdnupload);
        this.map.put("schemas", this.schemas);
        this.map.put("signup", this.signup);
        this.map.put("tcp_fileserver_url", this.tcp_fileserver_url);
        this.map.put("timestamp", this.timestamp);
        this.map.put("update", this.update);
        this.map.put("update_user_password", this.update_user_password);
        this.map.put("verify_sms_code", this.verify_sms_code);
        this.isFirst = true;
    }

    public String getUrlByOption(String str) {
        addToMap();
        List<String> list = this.map.get(str);
        if (list == null) {
            return null;
        }
        if (BmobClient.isIsNewDomain()) {
            return BmobURL.getDefault().getDefaultBaseUrl() + list.get(1);
        }
        return this.domain.get(Integer.parseInt(list.get(0))) + list.get(1);
    }
}
