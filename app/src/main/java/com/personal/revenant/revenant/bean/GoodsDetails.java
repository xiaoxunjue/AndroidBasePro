package com.personal.revenant.revenant.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/22.
 */

public class GoodsDetails {
    private String msg;
    private int collections;
    private GoodsBean goods;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }
    private List<PinglunBean> pinglun;





    public List<PinglunBean> getPinglun() {
        return pinglun;
    }

    public void setPinglun(List<PinglunBean> pinglun) {
        this.pinglun = pinglun;
    }



    public static class PinglunBean {
        /**
         * commentcont :
         * commentid : 1
         * commentstar : 3
         * commenttime : {"date":25,"day":5,"hours":16,"minutes":38,"month":4,"seconds":49,"time":1527237529000,"timezoneOffset":-480,"year":118}
         * goods : {"fgt":null,"fgtid":7,"goodsact":0,"goodsdate":null,"goodsdesc":"1111","goodsdis":0,"goodsid":1,"goodsimg":"http://192.168.252.111:8888/qingniaozhongchou/tastes/0.jpg","goodsintro":"1","goodsname":"衣服","goodsnum":100,"goodsprice":1.1,"goodsproblem":"","goodsreport":"","goodsstate":1,"isshouye":0,"mgrid":0,"sgt":null,"sgtid":14}
         * goodsid : 1
         * labelid : 0
         * userid : 4
         * users : {"userhead":"http://192.168.252.111:8888/qingniaozhongchou/headimg/4.jpg","userid":4,"username":"dcbka","userphone":"15708455685","userpwd":"123456789","userscore":5,"userstate":1}
         */

        private String commentcont;
        private int commentid;
        private int commentstar;
        private PinglunBean.CommenttimeBean commenttime;
        private PinglunBean.GoodsBeanX goods;
        private int goodsid;
        private int labelid;
        private int userid;
        private String shijian;

        public String getShijian() {
            return shijian;
        }

        public void setShijian(String shijian) {
            this.shijian = shijian;
        }

        private PinglunBean.UsersBean users;

        public String getCommentcont() {
            return commentcont;
        }

        public void setCommentcont(String commentcont) {
            this.commentcont = commentcont;
        }

        public int getCommentid() {
            return commentid;
        }

        public void setCommentid(int commentid) {
            this.commentid = commentid;
        }

        public int getCommentstar() {
            return commentstar;
        }

        public void setCommentstar(int commentstar) {
            this.commentstar = commentstar;
        }

        public PinglunBean.CommenttimeBean getCommenttime() {
            return commenttime;
        }

        public void setCommenttime(PinglunBean.CommenttimeBean commenttime) {
            this.commenttime = commenttime;
        }

        public PinglunBean.GoodsBeanX getGoods() {
            return goods;
        }

        public void setGoods(PinglunBean.GoodsBeanX goods) {
            this.goods = goods;
        }

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public int getLabelid() {
            return labelid;
        }

        public void setLabelid(int labelid) {
            this.labelid = labelid;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public PinglunBean.UsersBean getUsers() {
            return users;
        }

        public void setUsers(PinglunBean.UsersBean users) {
            this.users = users;
        }

        public static class CommenttimeBean {
            /**
             * date : 25
             * day : 5
             * hours : 16
             * minutes : 38
             * month : 4
             * seconds : 49
             * time : 1527237529000
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class GoodsBeanX {
            /**
             * fgt : null
             * fgtid : 7
             * goodsact : 0
             * goodsdate : null
             * goodsdesc : 1111
             * goodsdis : 0
             * goodsid : 1
             * goodsimg : http://192.168.252.111:8888/qingniaozhongchou/tastes/0.jpg
             * goodsintro : 1
             * goodsname : 衣服
             * goodsnum : 100
             * goodsprice : 1.1
             * goodsproblem :
             * goodsreport :
             * goodsstate : 1
             * isshouye : 0
             * mgrid : 0
             * sgt : null
             * sgtid : 14
             */

            private Object fgt;
            private int fgtid;
            private int goodsact;
            private Object goodsdate;
            private String goodsdesc;
            private int goodsdis;
            private int goodsid;
            private String goodsimg;
            private String goodsintro;
            private String goodsname;
            private int goodsnum;
            private double goodsprice;
            private String goodsproblem;
            private String goodsreport;
            private int goodsstate;
            private int isshouye;
            private int mgrid;
            private Object sgt;
            private int sgtid;

            public Object getFgt() {
                return fgt;
            }

            public void setFgt(Object fgt) {
                this.fgt = fgt;
            }

            public int getFgtid() {
                return fgtid;
            }

            public void setFgtid(int fgtid) {
                this.fgtid = fgtid;
            }

            public int getGoodsact() {
                return goodsact;
            }

            public void setGoodsact(int goodsact) {
                this.goodsact = goodsact;
            }

            public Object getGoodsdate() {
                return goodsdate;
            }

            public void setGoodsdate(Object goodsdate) {
                this.goodsdate = goodsdate;
            }

            public String getGoodsdesc() {
                return goodsdesc;
            }

            public void setGoodsdesc(String goodsdesc) {
                this.goodsdesc = goodsdesc;
            }

            public int getGoodsdis() {
                return goodsdis;
            }

            public void setGoodsdis(int goodsdis) {
                this.goodsdis = goodsdis;
            }

            public int getGoodsid() {
                return goodsid;
            }

            public void setGoodsid(int goodsid) {
                this.goodsid = goodsid;
            }

            public String getGoodsimg() {
                return goodsimg;
            }

            public void setGoodsimg(String goodsimg) {
                this.goodsimg = goodsimg;
            }

            public String getGoodsintro() {
                return goodsintro;
            }

            public void setGoodsintro(String goodsintro) {
                this.goodsintro = goodsintro;
            }

            public String getGoodsname() {
                return goodsname;
            }

            public void setGoodsname(String goodsname) {
                this.goodsname = goodsname;
            }

            public int getGoodsnum() {
                return goodsnum;
            }

            public void setGoodsnum(int goodsnum) {
                this.goodsnum = goodsnum;
            }

            public double getGoodsprice() {
                return goodsprice;
            }

            public void setGoodsprice(double goodsprice) {
                this.goodsprice = goodsprice;
            }

            public String getGoodsproblem() {
                return goodsproblem;
            }

            public void setGoodsproblem(String goodsproblem) {
                this.goodsproblem = goodsproblem;
            }

            public String getGoodsreport() {
                return goodsreport;
            }

            public void setGoodsreport(String goodsreport) {
                this.goodsreport = goodsreport;
            }


            public void setGoodsstate(int goodsstate) {
                this.goodsstate = goodsstate;
            }

            public int getIsshouye() {
                return isshouye;
            }

            public void setIsshouye(int isshouye) {
                this.isshouye = isshouye;
            }

            public int getMgrid() {
                return mgrid;
            }

            public void setMgrid(int mgrid) {
                this.mgrid = mgrid;
            }

            public Object getSgt() {
                return sgt;
            }

            public void setSgt(Object sgt) {
                this.sgt = sgt;
            }

            public int getSgtid() {
                return sgtid;
            }

            public void setSgtid(int sgtid) {
                this.sgtid = sgtid;
            }
        }

        public static class UsersBean {
            /**
             * userhead : http://192.168.252.111:8888/qingniaozhongchou/headimg/4.jpg
             * userid : 4
             * username : dcbka
             * userphone : 15708455685
             * userpwd : 123456789
             * userscore : 5
             * userstate : 1
             */

            private String userhead;
            private int userid;
            private String username;
            private String userphone;
            private String userpwd;
            private int userscore;
            private int userstate;

            public String getUserhead() {
                return userhead;
            }

            public void setUserhead(String userhead) {
                this.userhead = userhead;
            }

            public int getUserid() {
                return userid;
            }

            public void setUserid(int userid) {
                this.userid = userid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getUserphone() {
                return userphone;
            }

            public void setUserphone(String userphone) {
                this.userphone = userphone;
            }

            public String getUserpwd() {
                return userpwd;
            }

            public void setUserpwd(String userpwd) {
                this.userpwd = userpwd;
            }

            public int getUserscore() {
                return userscore;
            }

            public void setUserscore(int userscore) {
                this.userscore = userscore;
            }

            public int getUserstate() {
                return userstate;
            }

            public void setUserstate(int userstate) {
                this.userstate = userstate;
            }
        }
    }

    public static class GoodsBean {
        /**
         * fgt : {"fgtid":7,"fgtname":"服饰","fgtstate":0,"lsg":[]}
         * fgtid : 7
         * goodsact : 0
         * goodsdate : {"date":19,"day":6,"hours":11,"minutes":3,"month":4,"seconds":26,"time":1526699006000,"timezoneOffset":-480,"year":118}
         * goodsdesc : 1111
         * goodsdis : 0
         * goodsid : 2
         * goodsimg : http://192.168.252.111:8888/qingniaozhongchou/tastes/7.jpg
         * goodsintro : 1
         * goodsname : 鞋子
         * goodsnum : 100
         * goodsprice : 1
         * goodsproblem :
         * goodsreport :
         * goodsstate : 1
         * isshouye : 0
         * mgrid : 1
         * sgt : {"fgt":null,"fgtid":7,"gname":"","sgtid":10,"sgtimg":"http://192.168.252.111:8888/qingniaozhongchou/headimg/4.jpg","sgtname":"鞋子","sgtstate":1}
         * sgtid : 10
         */

        private FgtBean fgt;
        private int fgtid;
        private int goodsact;
        private GoodsdateBean goodsdate;
        private String goodsdesc;
        private int goodsdis;
        private int goodsid;
        private String goodsimg;
        private String goodsintro;
        private String goodsname;
        private int goodsnum;
        private double goodsprice;
        private String goodsproblem;
        private String goodsreport;
        private int goodsstate;
        private int isshouye;
        private int mgrid;
        private SgtBean sgt;
        private int sgtid;

        public FgtBean getFgt() {
            return fgt;
        }

        public void setFgt(FgtBean fgt) {
            this.fgt = fgt;
        }

        public int getFgtid() {
            return fgtid;
        }

        public void setFgtid(int fgtid) {
            this.fgtid = fgtid;
        }

        public int getGoodsact() {
            return goodsact;
        }

        public void setGoodsact(int goodsact) {
            this.goodsact = goodsact;
        }

        public GoodsdateBean getGoodsdate() {
            return goodsdate;
        }

        public void setGoodsdate(GoodsdateBean goodsdate) {
            this.goodsdate = goodsdate;
        }

        public String getGoodsdesc() {
            return goodsdesc;
        }

        public void setGoodsdesc(String goodsdesc) {
            this.goodsdesc = goodsdesc;
        }

        public int getGoodsdis() {
            return goodsdis;
        }

        public void setGoodsdis(int goodsdis) {
            this.goodsdis = goodsdis;
        }

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public String getGoodsimg() {
            return goodsimg;
        }

        public void setGoodsimg(String goodsimg) {
            this.goodsimg = goodsimg;
        }

        public String getGoodsintro() {
            return goodsintro;
        }

        public void setGoodsintro(String goodsintro) {
            this.goodsintro = goodsintro;
        }

        public String getGoodsname() {
            return goodsname;
        }

        public void setGoodsname(String goodsname) {
            this.goodsname = goodsname;
        }

        public int getGoodsnum() {
            return goodsnum;
        }

        public void setGoodsnum(int goodsnum) {
            this.goodsnum = goodsnum;
        }

        public double getGoodsprice() {
            return goodsprice;
        }

        public void setGoodsprice(int goodsprice) {
            this.goodsprice = goodsprice;
        }

        public String getGoodsproblem() {
            return goodsproblem;
        }

        public void setGoodsproblem(String goodsproblem) {
            this.goodsproblem = goodsproblem;
        }

        public String getGoodsreport() {
            return goodsreport;
        }

        public void setGoodsreport(String goodsreport) {
            this.goodsreport = goodsreport;
        }

        public int getGoodsstate() {
            return goodsstate;
        }

        public void setGoodsstate(int goodsstate) {
            this.goodsstate = goodsstate;
        }

        public int getIsshouye() {
            return isshouye;
        }

        public void setIsshouye(int isshouye) {
            this.isshouye = isshouye;
        }

        public int getMgrid() {
            return mgrid;
        }

        public void setMgrid(int mgrid) {
            this.mgrid = mgrid;
        }

        public SgtBean getSgt() {
            return sgt;
        }

        public void setSgt(SgtBean sgt) {
            this.sgt = sgt;
        }

        public int getSgtid() {
            return sgtid;
        }

        public void setSgtid(int sgtid) {
            this.sgtid = sgtid;
        }

        public static class FgtBean {
            /**
             * fgtid : 7
             * fgtname : 服饰
             * fgtstate : 0
             * lsg : []
             */

            private int fgtid;
            private String fgtname;
            private int fgtstate;
            private List<?> lsg;

            public int getFgtid() {
                return fgtid;
            }

            public void setFgtid(int fgtid) {
                this.fgtid = fgtid;
            }

            public String getFgtname() {
                return fgtname;
            }

            public void setFgtname(String fgtname) {
                this.fgtname = fgtname;
            }

            public int getFgtstate() {
                return fgtstate;
            }

            public void setFgtstate(int fgtstate) {
                this.fgtstate = fgtstate;
            }

            public List<?> getLsg() {
                return lsg;
            }

            public void setLsg(List<?> lsg) {
                this.lsg = lsg;
            }
        }

        public static class GoodsdateBean {
            /**
             * date : 19
             * day : 6
             * hours : 11
             * minutes : 3
             * month : 4
             * seconds : 26
             * time : 1526699006000
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class SgtBean {
            /**
             * fgt : null
             * fgtid : 7
             * gname :
             * sgtid : 10
             * sgtimg : http://192.168.252.111:8888/qingniaozhongchou/headimg/4.jpg
             * sgtname : 鞋子
             * sgtstate : 1
             */

            private Object fgt;
            private int fgtid;
            private String gname;
            private int sgtid;
            private String sgtimg;
            private String sgtname;
            private int sgtstate;

            public Object getFgt() {
                return fgt;
            }

            public void setFgt(Object fgt) {
                this.fgt = fgt;
            }

            public int getFgtid() {
                return fgtid;
            }

            public void setFgtid(int fgtid) {
                this.fgtid = fgtid;
            }

            public String getGname() {
                return gname;
            }

            public void setGname(String gname) {
                this.gname = gname;
            }

            public int getSgtid() {
                return sgtid;
            }

            public void setSgtid(int sgtid) {
                this.sgtid = sgtid;
            }

            public String getSgtimg() {
                return sgtimg;
            }

            public void setSgtimg(String sgtimg) {
                this.sgtimg = sgtimg;
            }

            public String getSgtname() {
                return sgtname;
            }

            public void setSgtname(String sgtname) {
                this.sgtname = sgtname;
            }

            public int getSgtstate() {
                return sgtstate;
            }

            public void setSgtstate(int sgtstate) {
                this.sgtstate = sgtstate;
            }
        }
    }
}
