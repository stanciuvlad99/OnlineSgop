package ro.mycode.viewAdmin;

import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.User;
import ro.mycode.utils.Utile;

public class ViewAdmin {
    private Admin admin;
    private ControlUser controlUser;

    public ViewAdmin (){
        this.admin=admin;
        this.controlUser=new ControlUser();
        Utile.play();
    }




}
