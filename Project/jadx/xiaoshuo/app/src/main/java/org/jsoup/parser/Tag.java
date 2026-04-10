package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.m.n.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.dkbookshelf.ui.f;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.common.util.Constants;
import com.xiaomi.ad.y;
import com.yuewen.cq3;
import com.yuewen.et;
import com.yuewen.i8;
import com.yuewen.openapi.track.TrackConstants;
import com.yuewen.rf4;
import com.yuewen.so2;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;

/* JADX INFO: loaded from: classes9.dex */
public class Tag implements Cloneable {
    private static final String[] blockTags;
    private static final String[] emptyTags;
    private static final String[] formListedTags;
    private static final String[] formSubmitTags;
    private static final String[] formatAsInlineTags;
    private static final String[] inlineTags;
    private static final String[] preserveWhitespaceTags;
    private static final Map<String, Tag> tags = new HashMap();
    private String normalName;
    private String tagName;
    private boolean isBlock = true;
    private boolean formatAsBlock = true;
    private boolean empty = false;
    private boolean selfClosing = false;
    private boolean preserveWhitespace = false;
    private boolean formList = false;
    private boolean formSubmit = false;

    static {
        String[] strArr = {"html", TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "frameset", "script", "noscript", TtmlNode.TAG_STYLE, "meta", "link", "title", TypedValues.AttributesType.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", i8.p, "h6", "ul", "ol", Constants.KEY_IS_PRECACHE, TtmlNode.TAG_DIV, "blockquote", "hr", "address", "figure", "figcaption", c.c, "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", so2.Va, "plaintext", i8.f12399a, cq3.S, "main", "svg", "math", "center"};
        blockTags = strArr;
        inlineTags = new String[]{"object", "base", "font", TtmlNode.TAG_TT, "i", y.j, "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", et.j, "acronym", "mark", TtmlNode.ATTR_TTS_RUBY, "rt", "rp", "a", "img", TtmlNode.TAG_BR, "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", TtmlNode.TAG_SPAN, rf4.b.n, f.b.d, "textarea", TTDownloadField.TT_LABEL, "button", "optgroup", "option", "legend", "datalist", "keygen", MscKeys.KEY_LOG_OUTPUT, "progress", "meter", "area", TrackConstants.PARAM, "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", TrackConstants.PARAM, "source", "track", "data", "bdi", "s"};
        emptyTags = new String[]{"meta", "link", "base", TypedValues.AttributesType.S_FRAME, "img", TtmlNode.TAG_BR, "wbr", "embed", "hr", rf4.b.n, "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", TrackConstants.PARAM, "source", "track"};
        formatAsInlineTags = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", i8.p, "h6", Constants.KEY_IS_PRECACHE, "address", "li", "th", "td", "script", TtmlNode.TAG_STYLE, "ins", "del", "s"};
        preserveWhitespaceTags = new String[]{Constants.KEY_IS_PRECACHE, "plaintext", "title", "textarea"};
        formListedTags = new String[]{"button", "fieldset", rf4.b.n, "keygen", "object", MscKeys.KEY_LOG_OUTPUT, f.b.d, "textarea"};
        formSubmitTags = new String[]{rf4.b.n, "keygen", "object", f.b.d, "textarea"};
        for (String str : strArr) {
            register(new Tag(str));
        }
        for (String str2 : inlineTags) {
            Tag tag = new Tag(str2);
            tag.isBlock = false;
            tag.formatAsBlock = false;
            register(tag);
        }
        for (String str3 : emptyTags) {
            Tag tag2 = tags.get(str3);
            Validate.notNull(tag2);
            tag2.empty = true;
        }
        for (String str4 : formatAsInlineTags) {
            Tag tag3 = tags.get(str4);
            Validate.notNull(tag3);
            tag3.formatAsBlock = false;
        }
        for (String str5 : preserveWhitespaceTags) {
            Tag tag4 = tags.get(str5);
            Validate.notNull(tag4);
            tag4.preserveWhitespace = true;
        }
        for (String str6 : formListedTags) {
            Tag tag5 = tags.get(str6);
            Validate.notNull(tag5);
            tag5.formList = true;
        }
        for (String str7 : formSubmitTags) {
            Tag tag6 = tags.get(str7);
            Validate.notNull(tag6);
            tag6.formSubmit = true;
        }
    }

    private Tag(String str) {
        this.tagName = str;
        this.normalName = Normalizer.lowerCase(str);
    }

    private static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        Validate.notNull(str);
        Map<String, Tag> map = tags;
        Tag tag = map.get(str);
        if (tag != null) {
            return tag;
        }
        String strNormalizeTag = parseSettings.normalizeTag(str);
        Validate.notEmpty(strNormalizeTag);
        String strLowerCase = Normalizer.lowerCase(strNormalizeTag);
        Tag tag2 = map.get(strLowerCase);
        if (tag2 == null) {
            Tag tag3 = new Tag(strNormalizeTag);
            tag3.isBlock = false;
            return tag3;
        }
        if (!parseSettings.preserveTagCase() || strNormalizeTag.equals(strLowerCase)) {
            return tag2;
        }
        Tag tagClone = tag2.clone();
        tagClone.tagName = strNormalizeTag;
        return tagClone;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.tagName.equals(tag.tagName) && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public String getName() {
        return this.tagName;
    }

    public int hashCode() {
        return (((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public String normalName() {
        return this.normalName;
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public String toString() {
        return this.tagName;
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }

    public Tag clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Tag valueOf(String str) {
        return valueOf(str, ParseSettings.preserveCase);
    }
}
