package com.ys.haier.data;

import java.util.List;

/**
 * Created by wz on 2017-08-09.
 */

public class Banner_Pic {

    /**
     * rows : [{"ID":9,"Ad_SHD":2,"Ad_ImageName":"","Ad_ImageUrl":" /UpImg/20170809112321125.jpg","Ad_BuyUrl":"","Ad_Datetime":"2017/8/9 11:23:49","Handlers":"","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":14,"Ad_SHD":2,"Ad_ImageName":"","Ad_ImageUrl":"/UpImg/20170809021131289.png","Ad_BuyUrl":"","Ad_Datetime":"2017/8/9 14:11:33","Handlers":"","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""}]
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
         * ID : 9
         * Ad_SHD : 2
         * Ad_ImageName :
         * Ad_ImageUrl :  /UpImg/20170809112321125.jpg
         * Ad_BuyUrl :
         * Ad_Datetime : 2017/8/9 11:23:49
         * Handlers :
         * States : 1
         * Null1 :
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         */

        private int ID;
        private int Ad_SHD;
        private String Ad_ImageName;
        private String Ad_ImageUrl;
        private String Ad_BuyUrl;
        private String Ad_Datetime;
        private String Handlers;
        private int States;
        private String Null1;
        private String Null2;
        private String Null3;
        private String Null4;
        private String Null5;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getAd_SHD() {
            return Ad_SHD;
        }

        public void setAd_SHD(int Ad_SHD) {
            this.Ad_SHD = Ad_SHD;
        }

        public String getAd_ImageName() {
            return Ad_ImageName;
        }

        public void setAd_ImageName(String Ad_ImageName) {
            this.Ad_ImageName = Ad_ImageName;
        }

        public String getAd_ImageUrl() {
            return Ad_ImageUrl;
        }

        public void setAd_ImageUrl(String Ad_ImageUrl) {
            this.Ad_ImageUrl = Ad_ImageUrl;
        }

        public String getAd_BuyUrl() {
            return Ad_BuyUrl;
        }

        public void setAd_BuyUrl(String Ad_BuyUrl) {
            this.Ad_BuyUrl = Ad_BuyUrl;
        }

        public String getAd_Datetime() {
            return Ad_Datetime;
        }

        public void setAd_Datetime(String Ad_Datetime) {
            this.Ad_Datetime = Ad_Datetime;
        }

        public String getHandlers() {
            return Handlers;
        }

        public void setHandlers(String Handlers) {
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
    }
}
