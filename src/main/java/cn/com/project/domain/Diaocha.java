package cn.com.project.domain;

// 帖子
public class Diaocha {
    //主键id
    private Integer id;

    //主键id
    private Integer kid;

    //标题
    private String mycd;

    //内容
    private String content;

    //添加人
    private String lname;

    //用户姓名
    private String account;

    //用户id
    private Integer aid;

    //日期
    private String dcrq;

    private String photo;

    private String idk;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getMycd() {
        return mycd;
    }

    public void setMycd(String mycd) {
        this.mycd = mycd == null ? null : mycd.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getDcrq() {
        return dcrq;
    }

    public void setDcrq(String dcrq) {
        this.dcrq = dcrq;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdk() {
        return idk;
    }

    public void setIdk(String idk) {
        this.idk = idk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}