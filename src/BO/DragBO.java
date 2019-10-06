package BO;

import DAO.DragDAO;
import DAO.LoginDAO;
import VO.UserVO;

import java.util.ArrayList;

/**
 * 药品业务层，处理业务
 *
 * @author dico
 *
 */
public class DragBO {
    public ArrayList whichDrag(UserVO userVO){
        DragDAO dragDAO = new DragDAO();
        return dragDAO.DragList(userVO);

    }
}
