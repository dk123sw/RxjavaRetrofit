package dk.rxajavaretrofit.entity;

/**
 * Created by dk on 2016/10/20.
 */

public class Gank {
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String url;
    private boolean used;
    private String who;
//    "_id": "58078baf421aa91369f9594c",
//            "createdAt": "2016-10-19T23:05:19.787Z",
//            "desc": "10-20",
//            "publishedAt": "2016-10-20T11:39:59.546Z",
//            "source": "chrome",
//            "type": "\u798f\u5229",
//            "url": "http://ww4.sinaimg.cn/large/610dc034jw1f8xz7ip2u5j20u011h78h.jpg",
//            "used": true,
//            "who": "daimajia"

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "Gank{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
