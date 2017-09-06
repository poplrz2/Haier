package com.ys.haier.data;

import java.util.List;

/**
 * Created by lzc on 2017-09-01.
 */

public class ServeDetail {
    /**
     * rows : [{"id":6,"Relation_BJ":120,"docid":1,"Doctor_Name":"李四","JT_Name":"护士","DE_Name":"护理","Doctor_GRJS":"简介 ： 1970年山西医学院医疗系本科毕业 。1998年晋升儿科主任医\r\n师 ，1999年起任长治医学院附属和平医院儿科主任，兼职中华医学会\r\n山西分会儿科学组委会 。毕业以来一直从事儿科临床及教学工作","Doctor_SCLY":"儿童常见疾病以及疑难病的针织，尤其是儿童血液系统疾病、\r\n儿童肿瘤的诊断以及治疗；儿童危机重症的监护和抢救。","Image_Url":"/Upload/Image/20170829/_20170829100536773.png","XJ":5}]
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
         * id : 6
         * Relation_BJ : 120
         * docid : 1
         * Doctor_Name : 李四
         * JT_Name : 护士
         * DE_Name : 护理
         * Doctor_GRJS : 简介 ： 1970年山西医学院医疗系本科毕业 。1998年晋升儿科主任医
         师 ，1999年起任长治医学院附属和平医院儿科主任，兼职中华医学会
         山西分会儿科学组委会 。毕业以来一直从事儿科临床及教学工作
         * Doctor_SCLY : 儿童常见疾病以及疑难病的针织，尤其是儿童血液系统疾病、
         儿童肿瘤的诊断以及治疗；儿童危机重症的监护和抢救。
         * Image_Url : /Upload/Image/20170829/_20170829100536773.png
         * XJ : 5
         */

        private int id;
        private int Relation_BJ;
        private int docid;
        private String Doctor_Name;
        private String JT_Name;
        private String DE_Name;
        private String Doctor_GRJS;
        private String Doctor_SCLY;
        private String Image_Url;
//        private int XJ;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRelation_BJ() {
            return Relation_BJ;
        }

        public void setRelation_BJ(int Relation_BJ) {
            this.Relation_BJ = Relation_BJ;
        }

        public int getDocid() {
            return docid;
        }

        public void setDocid(int docid) {
            this.docid = docid;
        }

        public String getDoctor_Name() {
            return Doctor_Name;
        }

        public void setDoctor_Name(String Doctor_Name) {
            this.Doctor_Name = Doctor_Name;
        }

        public String getJT_Name() {
            return JT_Name;
        }

        public void setJT_Name(String JT_Name) {
            this.JT_Name = JT_Name;
        }

        public String getDE_Name() {
            return DE_Name;
        }

        public void setDE_Name(String DE_Name) {
            this.DE_Name = DE_Name;
        }

        public String getDoctor_GRJS() {
            return Doctor_GRJS;
        }

        public void setDoctor_GRJS(String Doctor_GRJS) {
            this.Doctor_GRJS = Doctor_GRJS;
        }

        public String getDoctor_SCLY() {
            return Doctor_SCLY;
        }

        public void setDoctor_SCLY(String Doctor_SCLY) {
            this.Doctor_SCLY = Doctor_SCLY;
        }

        public String getImage_Url() {
            return Image_Url;
        }

        public void setImage_Url(String Image_Url) {
            this.Image_Url = Image_Url;
        }

//        public int getXJ() {
//            return XJ;
//        }
//
//        public void setXJ(int XJ) {
//            this.XJ = XJ;
//        }
    }
}
