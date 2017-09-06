package com.ys.haier.data;

import java.util.List;

/**
 * Created by wz on 2017-08-23.
 */

public class Serve {


    /**
     * rows : [{"ID":1,"Serve_CategoryID":1,"Serve_TOrganID":0,"Serve_Name":"睡眠监测1","Serve_Icon":10,"Serve_Money":"","Serve_Goout":"","Serve_Product":"睡眠仪器","Serve_ShiID":"","Serve_Describe":"对个人的睡眠进行深入监测","Handle_Time":"2017/7/31 0:00:00","Handlers":1,"States":1,"Null1":"1","Null2":"","Null3":"","Null4":"","Null5":"","Null6":"","Null7":"","Null8":"","Null9":"","Null10":"","Image_Url":"/Upload/Image/20170807/电话_20170807101812333.png"},{"ID":3,"Serve_CategoryID":1,"Serve_TOrganID":0,"Serve_Name":"睡眠保养","Serve_Icon":20,"Serve_Money":"","Serve_Goout":"","Serve_Product":"无","Serve_ShiID":"","Serve_Describe":"无","Handle_Time":"2017/8/7 0:00:00","Handlers":1,"States":1,"Null1":"1","Null2":"","Null3":"","Null4":"","Null5":"","Null6":"","Null7":"","Null8":"","Null9":"","Null10":"","Image_Url":"/Upload/Image/20170807/睡眠_2017080709582918.png"},{"ID":4,"Serve_CategoryID":1,"Serve_TOrganID":0,"Serve_Name":"睡眠测试数据","Serve_Icon":36,"Serve_Money":"","Serve_Goout":"","Serve_Product":"睡眠监测仪","Serve_ShiID":"","Serve_Describe":"无描述","Handle_Time":"2017/8/23 0:00:00","Handlers":1,"States":1,"Null1":"1","Null2":"","Null3":"","Null4":"","Null5":"","Null6":"","Null7":"","Null8":"","Null9":"","Null10":"","Image_Url":"/Upload/Image/20170823/睡眠_20170823051357223.png"}]
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
         * ID : 1
         * Serve_CategoryID : 1
         * Serve_TOrganID : 0
         * Serve_Name : 睡眠监测1
         * Serve_Icon : 10
         * Serve_Money :
         * Serve_Goout :
         * Serve_Product : 睡眠仪器
         * Serve_ShiID :
         * Serve_Describe : 对个人的睡眠进行深入监测
         * Handle_Time : 2017/7/31 0:00:00
         * Handlers : 1
         * States : 1
         * Null1 : 1
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         * Null6 :
         * Null7 :
         * Null8 :
         * Null9 :
         * Null10 :
         * Image_Url : /Upload/Image/20170807/电话_20170807101812333.png
         */

        private int ID;
        private int Serve_CategoryID;
        private int Serve_TOrganID;
        private String Serve_Name;
        private int Serve_Icon;
        private String Serve_Money;
        private String Serve_Goout;
        private String Serve_Product;
        private String Serve_ShiID;
        private String Serve_Describe;
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
        private String Image_Url;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getServe_CategoryID() {
            return Serve_CategoryID;
        }

        public void setServe_CategoryID(int Serve_CategoryID) {
            this.Serve_CategoryID = Serve_CategoryID;
        }

        public int getServe_TOrganID() {
            return Serve_TOrganID;
        }

        public void setServe_TOrganID(int Serve_TOrganID) {
            this.Serve_TOrganID = Serve_TOrganID;
        }

        public String getServe_Name() {
            return Serve_Name;
        }

        public void setServe_Name(String Serve_Name) {
            this.Serve_Name = Serve_Name;
        }

        public int getServe_Icon() {
            return Serve_Icon;
        }

        public void setServe_Icon(int Serve_Icon) {
            this.Serve_Icon = Serve_Icon;
        }

        public String getServe_Money() {
            return Serve_Money;
        }

        public void setServe_Money(String Serve_Money) {
            this.Serve_Money = Serve_Money;
        }

        public String getServe_Goout() {
            return Serve_Goout;
        }

        public void setServe_Goout(String Serve_Goout) {
            this.Serve_Goout = Serve_Goout;
        }

        public String getServe_Product() {
            return Serve_Product;
        }

        public void setServe_Product(String Serve_Product) {
            this.Serve_Product = Serve_Product;
        }

        public String getServe_ShiID() {
            return Serve_ShiID;
        }

        public void setServe_ShiID(String Serve_ShiID) {
            this.Serve_ShiID = Serve_ShiID;
        }

        public String getServe_Describe() {
            return Serve_Describe;
        }

        public void setServe_Describe(String Serve_Describe) {
            this.Serve_Describe = Serve_Describe;
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

        public String getImage_Url() {
            return Image_Url;
        }

        public void setImage_Url(String Image_Url) {
            this.Image_Url = Image_Url;
        }
    }
}
