package com.ys.haier.data;

import java.util.List;

/**
 * Created by wz on 2017-08-11.
 */

public class News {

    /**
     * rows : [{"ID":2,"News_CategoryID":1,"News_Title":"123","News_Describe":"<p><img src=\"http://p3.pstatp.com/large/31f7000498e29f53d195\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>吴京自导自演的战狼2可以说是现下最火爆的电影了，票房口碑可谓是双丰收！已突破了39.5亿票房！打破了周星驰的《美人鱼》。<\/p><p><img src=\"http://p3.pstatp.com/large/320100027cb6a517dc67\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>今日吴京在广州做宣传的时候，带着张翰、卢靖姗等一众主演共同参加，并且做了热情互动。<\/p><p><img src=\"http://p3.pstatp.com/large/320700009e1155433649\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p><img src=\"http://p3.pstatp.com/large/320700009e28fdc7bb7c\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>节目期间，吴京也透露，会继续拍摄《战狼3》，也答应了在剧中表演的角色冷锋和余男在感情上一定会有一个交代。<\/p><p>不过在谈论战狼3的时候，吴京欢喜的脸上也出现了凝重，称自己的压力非常大，也希望会是原班人马，但是有困难。<\/p><p><img src=\"http://p9.pstatp.com/large/320b0001a9c535209097\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p><img src=\"http://p3.pstatp.com/large/31f60000f0bfcc4b033f\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>在谈话期间，吴京更是谈到，有想过邀请王宝强来出演《战狼2》，觉得王宝强出演过《士兵突击》，对于军人的表演应该是很有经验，但是因为某些原因，被王宝强的经纪人婉拒了，可能是经纪人有其他的安排吧。<\/p><p><img src=\"http://p3.pstatp.com/large/320b0001a9dc57bce625\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p><img src=\"http://p9.pstatp.com/large/320100027d52338a006f\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>但是吴京并没有多谈其他，前段时间《战狼2》捷报传来，马蓉就力挺吴京，对吴京自身的男人气概赞赏有加，而马蓉则公开声称，愿意出资投资《战狼3》，称吴京也是老相识，只要有需要也可以加盟出演，不过之前吴京就表示，马蓉是哪个明星呢？<\/p><p><img src=\"http://p3.pstatp.com/large/320b0001aa30144cd2d3\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p><img src=\"http://p9.pstatp.com/large/31fe00048e8ce5bd6066\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p>不知道《战狼3》是否还有邀请王宝强出演的计划，如果马蓉也参加，那将会是一个怎么样的情况呢？ 想必票房必然不会太差。<br/><\/p><p><img src=\"http://p3.pstatp.com/large/320100027da7ae3d5fb2\" alt=\"王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了\"/><\/p><p><br/><\/p>","News_FileName":"","News_FileUrl":"","Handle_Time":"2017/8/11 0:00:00","Handlers":1,"States":1,"Null1":"0","Null2":"","Null3":"","Null4":"","Null5":"","Null6":"","Null7":"","Null8":"","Null9":"","Null10":""},{"ID":3,"News_CategoryID":1,"News_Title":"多睡觉的好处","News_Describe":"<p>为什么要多睡觉了？<\/p><p>因为<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<\/p><p>。<br/><\/p><p>。<br/><\/p><p>。<br/><\/p><p>。<br/><\/p><p>。<br/><\/p><p>困了！<br/><\/p>","News_FileName":"","News_FileUrl":"","Handle_Time":"2017/8/11 0:00:00","Handlers":1,"States":1,"Null1":"0","Null2":"","Null3":"","Null4":"","Null5":"","Null6":"","Null7":"","Null8":"","Null9":"","Null10":""}]
     * success : true
     */

    private boolean success;
    private List<RowsBean> rows;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * ID : 2
         * News_CategoryID : 1
         * News_Title : 123
         * News_Describe : <p><img src="http://p3.pstatp.com/large/31f7000498e29f53d195" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>吴京自导自演的战狼2可以说是现下最火爆的电影了，票房口碑可谓是双丰收！已突破了39.5亿票房！打破了周星驰的《美人鱼》。</p><p><img src="http://p3.pstatp.com/large/320100027cb6a517dc67" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>今日吴京在广州做宣传的时候，带着张翰、卢靖姗等一众主演共同参加，并且做了热情互动。</p><p><img src="http://p3.pstatp.com/large/320700009e1155433649" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p><img src="http://p3.pstatp.com/large/320700009e28fdc7bb7c" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>节目期间，吴京也透露，会继续拍摄《战狼3》，也答应了在剧中表演的角色冷锋和余男在感情上一定会有一个交代。</p><p>不过在谈论战狼3的时候，吴京欢喜的脸上也出现了凝重，称自己的压力非常大，也希望会是原班人马，但是有困难。</p><p><img src="http://p9.pstatp.com/large/320b0001a9c535209097" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p><img src="http://p3.pstatp.com/large/31f60000f0bfcc4b033f" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>在谈话期间，吴京更是谈到，有想过邀请王宝强来出演《战狼2》，觉得王宝强出演过《士兵突击》，对于军人的表演应该是很有经验，但是因为某些原因，被王宝强的经纪人婉拒了，可能是经纪人有其他的安排吧。</p><p><img src="http://p3.pstatp.com/large/320b0001a9dc57bce625" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p><img src="http://p9.pstatp.com/large/320100027d52338a006f" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>但是吴京并没有多谈其他，前段时间《战狼2》捷报传来，马蓉就力挺吴京，对吴京自身的男人气概赞赏有加，而马蓉则公开声称，愿意出资投资《战狼3》，称吴京也是老相识，只要有需要也可以加盟出演，不过之前吴京就表示，马蓉是哪个明星呢？</p><p><img src="http://p3.pstatp.com/large/320b0001aa30144cd2d3" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p><img src="http://p9.pstatp.com/large/31fe00048e8ce5bd6066" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p>不知道《战狼3》是否还有邀请王宝强出演的计划，如果马蓉也参加，那将会是一个怎么样的情况呢？ 想必票房必然不会太差。<br/></p><p><img src="http://p3.pstatp.com/large/320100027da7ae3d5fb2" alt="王宝强妻子马蓉公开声称愿意投资《战狼3》，不过吴京的回答亮了"/></p><p><br/></p>
         * News_FileName :
         * News_FileUrl :
         * Handle_Time : 2017/8/11 0:00:00
         * Handlers : 1
         * States : 1
         * Null1 : 0
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         * Null6 :
         * Null7 :
         * Null8 :
         * Null9 :
         * Null10 :
         */

        private int ID;
        private int News_CategoryID;
        private String News_Title;
        private String News_Describe;
        private String News_FileName;
        private String News_FileUrl;
        private String Handle_Time;
        private int Handlers;
        private int States;
        private String Null1;
        private String Null2;
        private String Null3;
        private String Null4;
        private String Null5;
        private String Null6;
        private String Null7;
        private String Null8;
        private String Null9;
        private String Null10;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getNews_CategoryID() {
            return News_CategoryID;
        }

        public void setNews_CategoryID(int News_CategoryID) {
            this.News_CategoryID = News_CategoryID;
        }

        public String getNews_Title() {
            return News_Title;
        }

        public void setNews_Title(String News_Title) {
            this.News_Title = News_Title;
        }

        public String getNews_Describe() {
            return News_Describe;
        }

        public void setNews_Describe(String News_Describe) {
            this.News_Describe = News_Describe;
        }

        public String getNews_FileName() {
            return News_FileName;
        }

        public void setNews_FileName(String News_FileName) {
            this.News_FileName = News_FileName;
        }

        public String getNews_FileUrl() {
            return News_FileUrl;
        }

        public void setNews_FileUrl(String News_FileUrl) {
            this.News_FileUrl = News_FileUrl;
        }

        public String getHandle_Time() {
            return Handle_Time;
        }

        public void setHandle_Time(String Handle_Time) {
            this.Handle_Time = Handle_Time;
        }

        public int getHandlers() {
            return Handlers;
        }

        public void setHandlers(int Handlers) {
            this.Handlers = Handlers;
        }

        public int getStates() {
            return States;
        }

        public void setStates(int States) {
            this.States = States;
        }

        public String getNull1() {
            return Null1;
        }

        public void setNull1(String Null1) {
            this.Null1 = Null1;
        }

        public String getNull2() {
            return Null2;
        }

        public void setNull2(String Null2) {
            this.Null2 = Null2;
        }

        public String getNull3() {
            return Null3;
        }

        public void setNull3(String Null3) {
            this.Null3 = Null3;
        }

        public String getNull4() {
            return Null4;
        }

        public void setNull4(String Null4) {
            this.Null4 = Null4;
        }

        public String getNull5() {
            return Null5;
        }

        public void setNull5(String Null5) {
            this.Null5 = Null5;
        }

        public String getNull6() {
            return Null6;
        }

        public void setNull6(String Null6) {
            this.Null6 = Null6;
        }

        public String getNull7() {
            return Null7;
        }

        public void setNull7(String Null7) {
            this.Null7 = Null7;
        }

        public String getNull8() {
            return Null8;
        }

        public void setNull8(String Null8) {
            this.Null8 = Null8;
        }

        public String getNull9() {
            return Null9;
        }

        public void setNull9(String Null9) {
            this.Null9 = Null9;
        }

        public String getNull10() {
            return Null10;
        }

        public void setNull10(String Null10) {
            this.Null10 = Null10;
        }
    }
}
