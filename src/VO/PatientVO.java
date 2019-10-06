package VO;

import java.io.Serializable;

/**
 * 病人类
 *
 * @author dc
 */

public class PatientVO implements Serializable {
    //病人属性
    private String Invoice;//发票号
    private String birthday;//出生日期
    private String IDNum;//身份证号码
    private String address;//家庭住址
    private String jiesuanLeiBie;//结算方式
    private String lookDoctorDay;//看诊日期
    private String wubie;//午别
    private String room;//所挂科室
    private String haobie;//号别
    private boolean bingliben;//是否需要病历本
    private String needMoney;//需要病人交的费用
    private String WayofMoney;//得钱的方式

    //需要读取信息的病人属性
    private String BingLiNumber;//病历号
    private String patientName;//病人姓名
    private String sex;//性别
    private String old;//年龄
    private String lookDoctor;//所看的医生
    private DragVO needDrag = null;//病人所需要的药
    private Boolean JiaoFeiOrNot = false;//病人是否缴费


    public PatientVO(String BingLiNumber,String patientName,String sex,String old){
        this.BingLiNumber = BingLiNumber;
        this.patientName = patientName;
        this.sex = sex;
        this.old = old;
    }
    public PatientVO(){

    }

    //Set方法
    public void setAddress(String address) {
        this.address = address;
    }

    public void setBingLiNumber(String bingLiNumber) {
        BingLiNumber = bingLiNumber;
    }

    public void setInvoice(String invoice) {
        Invoice = invoice;
    }

    public void setBingliben(boolean bingliben) {
        this.bingliben = bingliben;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public void setHaobie(String haobie) {
        this.haobie = haobie;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setJiesuanLeiBie(String jiesuanLeiBie) {
        this.jiesuanLeiBie = jiesuanLeiBie;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLookDoctor(String lookDoctor) {
        this.lookDoctor = lookDoctor;
    }

    public void setLookDoctorDay(String lookDoctorDay) {
        this.lookDoctorDay = lookDoctorDay;
    }

    public void setNeedMoney(String needMoney) {
        this.needMoney = needMoney;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setWayofMoney(String wayofMoney) {
        WayofMoney = wayofMoney;
    }

    public void setWubie(String wubie) {
        this.wubie = wubie;
    }

    public void setNeedDrag(DragVO needDrag) {
        this.needDrag = needDrag;
    }

    public void setJiaoFeiOrNot(Boolean jiaoFeiOrNot) {
        JiaoFeiOrNot = jiaoFeiOrNot;
    }

    //Get方法
    public String getAddress() {
        return address;
    }

    public String getBingLiNumber() {
        return BingLiNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getIDNum() {
        return IDNum;
    }

    public String getInvoice() {
        return Invoice;
    }

    public String getJiesuanLeiBie() {
        return jiesuanLeiBie;
    }

    public String getOld() {
        return old;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getSex() {
        return sex;
    }

    public String getHaobie() {
        return haobie;
    }

    public String getLookDoctor() {
        return lookDoctor;
    }

    public String getLookDoctorDay() {
        return lookDoctorDay;
    }

    public String getRoom() {
        return room;
    }

    public String getNeedMoney() {
        return needMoney;
    }

    public String getWayofMoney() {
        return WayofMoney;
    }

    public String getWubie() {
        return wubie;
    }

    public DragVO getNeedDrag() {
        return needDrag;
    }

    public Boolean getJiaoFeiOrNot() {
        return JiaoFeiOrNot;
    }


}
