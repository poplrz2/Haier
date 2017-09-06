package com.ys.haier.data;

import java.util.List;

/**
 * Created by wz on 2017-08-10.
 */

public class City {

    /**
     * rows : [{"ID":2,"Shi_ShengID":2,"Shi_Name":"虹口区","Shi_Remark":"","Handle_Time":"2017/7/31 11:10:36","Handlers":1,"States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":3,"Shi_ShengID":2,"Shi_Name":"杨浦区","Shi_Remark":"","Handle_Time":"2017/7/31 11:10:44","Handlers":1,"States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":7,"Shi_ShengID":2,"Shi_Name":"浦东新区","Shi_Remark":"浦东新区\r\n","Handle_Time":"2017/7/31 17:59:26","Handlers":"","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":10,"Shi_ShengID":2,"Shi_Name":"宝山区","Shi_Remark":"宝山","Handle_Time":"2017/7/31 17:56:42","Handlers":1,"States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""}]
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
         * Shi_ShengID : 2
         * Shi_Name : 虹口区
         * Shi_Remark :
         * Handle_Time : 2017/7/31 11:10:36
         * Handlers : 1
         * States : 1
         * Null1 :
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         */

        private int ID;
        private int Shi_ShengID;
        private String Shi_Name;
        private String Shi_Remark;
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

        public int getShi_ShengID() {
            return Shi_ShengID;
        }

        public void setShi_ShengID(int Shi_ShengID) {
            this.Shi_ShengID = Shi_ShengID;
        }

        public String getShi_Name() {
            return Shi_Name;
        }

        public void setShi_Name(String Shi_Name) {
            this.Shi_Name = Shi_Name;
        }

        public String getShi_Remark() {
            return Shi_Remark;
        }

        public void setShi_Remark(String Shi_Remark) {
            this.Shi_Remark = Shi_Remark;
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
