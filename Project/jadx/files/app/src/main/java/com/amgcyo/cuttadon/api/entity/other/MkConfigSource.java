package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.amgcyo.cuttadon.j.c.d;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "MkConfigSource")
public class MkConfigSource implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int art_id;

    @TypeConverters({d.class})
    private ArrayList<MkRegular> regular;

    @ColumnInfo(name = "regular_time")
    private long regular_time;

    @ColumnInfo(name = TTLiveConstants.APP_SITEID_KEY)
    private String site_id;

    @ColumnInfo(name = "url_state")
    private int url_state;

    public int getArt_id() {
        return this.art_id;
    }

    public ArrayList<MkRegular> getRegular() {
        return this.regular;
    }

    public long getRegular_time() {
        return this.regular_time;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public int getUrl_state() {
        return this.url_state;
    }

    public void setArt_id(int i2) {
        this.art_id = i2;
    }

    public void setRegular(ArrayList<MkRegular> arrayList) {
        this.regular = arrayList;
    }

    public void setRegular_time(long j2) {
        this.regular_time = j2;
    }

    public void setSite_id(String str) {
        this.site_id = str;
    }

    public void setUrl_state(int i2) {
        this.url_state = i2;
    }
}
