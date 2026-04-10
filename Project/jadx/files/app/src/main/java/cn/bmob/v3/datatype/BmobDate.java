package cn.bmob.v3.datatype;

import com.umeng.message.utils.HttpRequest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class BmobDate implements Serializable {
    private static final long serialVersionUID = -7739760111722811743L;
    private String __type = HttpRequest.HEADER_DATE;
    private String iso;

    public BmobDate(Date date) {
        this.iso = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static BmobDate createBmobDate(String str, String str2) {
        try {
            return new BmobDate(new SimpleDateFormat(str).parse(str2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getIso() {
        return this.iso;
    }

    public static long getTimeStamp(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private String get__type() {
        return this.__type;
    }

    public String getDate() {
        return this.iso;
    }
}
