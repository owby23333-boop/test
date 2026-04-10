package com.duokan.reader.elegant.ui.user.data;

import com.yuewen.sr3;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BookInfo implements Serializable {
    public String authors;
    public int bookPercent;
    public long bookReadTime;
    public String bookUuid;
    public String comment;
    public String coverUri;
    public int rate;
    public Calendar readTime;
    public int source = 0;
    public String sourceId = "";
    public String summary;
    public String title;

    public int getPercent() {
        return this.bookPercent / 100;
    }

    public void initFromJson(JSONObject jSONObject) throws JSONException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(jSONObject.getLong("read_time") * 1000));
        this.readTime = calendar;
        this.source = jSONObject.optInt("source");
        this.bookUuid = jSONObject.optString("id");
        this.sourceId = jSONObject.optString("source_id");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("role");
        StringBuilder sb = new StringBuilder();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.getJSONArray(i).optString(1);
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strOptString);
            }
        }
        this.authors = sb.toString();
        this.title = jSONObject.optString("title");
        this.coverUri = jSONObject.optString("cover");
        this.comment = jSONObject.optString("content");
        this.rate = jSONObject.optInt("rate", 0);
        this.bookReadTime = jSONObject.optLong("book_read_time");
        this.bookPercent = jSONObject.optInt("book_percent", 0);
    }

    public boolean isAudio() {
        int i = this.source;
        return i == 9 || (i == 0 && sr3.a(this.bookUuid));
    }

    public boolean isComic() {
        int i = this.source;
        return i == 6 || (i == 0 && sr3.c(this.bookUuid));
    }
}
