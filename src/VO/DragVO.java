package VO;

import java.io.Serializable;

/**
 * 药品类
 *
 * @author dico
 *
 */
public class DragVO implements Serializable {
    private String DragName;//药品名称
    private double DragPrice;//药品价格
    private String DragRoom;//药房

    public DragVO(){

    }

    public DragVO(String DragName,double DragPrice, String DragRoom){//构造方法，用于新建药品对象
        this.DragName = DragName;
        this.DragPrice = DragPrice;
        this.DragRoom = DragRoom;
    }

    public String getDragName() {
        return DragName;
    }

    public void setDragName(String dragName) {
        DragName = dragName;
    }

    public double getDragPrice() {
        return DragPrice;
    }

    public void setDragPrice(double dragPrice) {
        DragPrice = dragPrice;
    }

    public String getDragRoom() {
        return DragRoom;
    }

    public void setDragRoom(String dragRoom) {
        DragRoom = dragRoom;
    }
}
