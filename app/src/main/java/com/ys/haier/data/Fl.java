package com.ys.haier.data;

import java.util.List;

/**
 * Created by lzc on 2017-08-28.
 */

public class Fl {

    /**
     * rows : [{"ID":1,"Category_Name":"睡眠","Category_Icon":27,"Category_Remark":"睡眠","Handle_Time":"","Handlers":"","State":1,"Null1":"35","imgh":"/Upload/Image/20170823/睡眠2_20170823111740882.png","imgq":"/Upload/Image/20170823/睡眠_20170823111740358.png","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":2,"Category_Name":"呼吸","Category_Icon":26,"Category_Remark":"呼吸","Handle_Time":"","Handlers":"","State":1,"Null1":"34","imgh":"/Upload/Image/20170823/呼吸2_20170823111716495.png","imgq":"/Upload/Image/20170823/呼吸1_20170823111716449.png","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":3,"Category_Name":"母婴","Category_Icon":25,"Category_Remark":"母婴","Handle_Time":"","Handlers":"","State":1,"Null1":"33","imgh":"/Upload/Image/20170823/母婴2_20170823111651267.png","imgq":"/Upload/Image/20170823/母婴1_20170823111650221.png","Null2":"","Null3":"","Null4":"","Null5":""},{"ID":4,"Category_Name":"康居","Category_Icon":28,"Category_Remark":"康居","Handle_Time":"","Handlers":"","State":1,"Null1":"32","imgh":"/Upload/Image/20170823/康居2_20170823111625628.png","imgq":"/Upload/Image/20170823/康居_20170823111624387.png","Null2":"","Null3":"","Null4":"","Null5":""}]
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
         * Category_Name : 睡眠
         * Category_Icon : 27
         * Category_Remark : 睡眠
         * Handle_Time :
         * Handlers :
         * State : 1
         * Null1 : 35
         * imgh : /Upload/Image/20170823/睡眠2_20170823111740882.png
         * imgq : /Upload/Image/20170823/睡眠_20170823111740358.png
         * Null2 :
         * Null3 :
         * Null4 :
         * Null5 :
         */

        private int ID;
        private String Category_Name;
        private int Category_Icon;
        private String Category_Remark;
        private String Handle_Time;
        private String Handlers;
        private int State;
        private String Null1;
        private String imgh;
        private String imgq;
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

        public String getCategory_Name() {
            return Category_Name;
        }

        public void setCategory_Name(String Category_Name) {
            this.Category_Name = Category_Name;
        }

        public int getCategory_Icon() {
            return Category_Icon;
        }

        public void setCategory_Icon(int Category_Icon) {
            this.Category_Icon = Category_Icon;
        }

        public String getCategory_Remark() {
            return Category_Remark;
        }

        public void setCategory_Remark(String Category_Remark) {
            this.Category_Remark = Category_Remark;
        }

        public String getHandle_Time() {
            return Handle_Time;
        }

        public void setHandle_Time(String Handle_Time) {
            this.Handle_Time = Handle_Time;
        }

        public String getHandlers() {
            return Handlers;
        }

        public void setHandlers(String Handlers) {
            this.Handlers = Handlers;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public String getNull1() {
            return Null1;
        }

        public void setNull1(String Null1) {
            this.Null1 = Null1;
        }

        public String getImgh() {
            return imgh;
        }

        public void setImgh(String imgh) {
            this.imgh = imgh;
        }

        public String getImgq() {
            return imgq;
        }

        public void setImgq(String imgq) {
            this.imgq = imgq;
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
