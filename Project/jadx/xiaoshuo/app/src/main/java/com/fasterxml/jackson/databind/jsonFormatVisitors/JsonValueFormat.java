package com.fasterxml.jackson.databind.jsonFormatVisitors;

import androidx.core.app.NotificationCompat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.xiaomi.onetrack.api.at;
import com.yuewen.et;

/* JADX INFO: loaded from: classes7.dex */
public enum JsonValueFormat {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL(NotificationCompat.CATEGORY_EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE(at.d),
    REGEX("regex"),
    STYLE(TtmlNode.TAG_STYLE),
    TIME(et.j),
    URI("uri"),
    UTC_MILLISEC("utc-millisec");

    private final String _desc;

    JsonValueFormat(String str) {
        this._desc = str;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
