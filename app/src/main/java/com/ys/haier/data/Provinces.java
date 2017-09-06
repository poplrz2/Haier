package com.ys.haier.data;

import java.util.List;

/**
 * Created by wz on 2017-08-10.
 */

public class Provinces {

    /**
     * rows : [{"ID":1,"Sheng_Name":"湖北省","Sheng_Remark":"湖北","Handlers":1,"Handle_Time":"2017/7/31 11:07:56","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":2,"Sheng_Name":"上海市","Sheng_Remark":"上海","Handlers":1,"Handle_Time":"2017/7/31 11:08:14","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":3,"Sheng_Name":"山东省","Sheng_Remark":"山东","Handlers":1,"Handle_Time":"2017/7/31 11:08:54","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":6,"Sheng_Name":"河南省","Sheng_Remark":"河南","Handlers":1,"Handle_Time":"2017/7/31 11:47:34","States":1,"Null1":"","Null2":"","Null3":"","Null4":"","Null5":""}]
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
         * Sheng_Name : 湖北省
         * Sheng_Remark : 湖北
         * Handlers : 1
         * Handle_Time : 2017/7/31 11:07:56
         * States : 1
         * Null1 :
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         */

        private int ID;
        private String Sheng_Name;
        private String Sheng_Remark;
        private int Handlers;
        private String Handle_Time;
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

        public String getSheng_Name() {
            return Sheng_Name;
        }

        public void setSheng_Name(String Sheng_Name) {
            this.Sheng_Name = Sheng_Name;
        }

        public String getSheng_Remark() {
            return Sheng_Remark;
        }

        public void setSheng_Remark(String Sheng_Remark) {
            this.Sheng_Remark = Sheng_Remark;
        }

        public int getHandlers() {
            return Handlers;
        }

        public void setHandlers(int Handlers) {
            this.Handlers = Handlers;
        }

        public String getHandle_Time() {
            return Handle_Time;
        }

        public void setHandle_Time(String Handle_Time) {
            this.Handle_Time = Handle_Time;
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
