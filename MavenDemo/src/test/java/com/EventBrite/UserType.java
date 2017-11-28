/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EventBrite;

/**
 *
 * @author PANDA
 */
public class UserType {

    final static int MEMBER = 0;
    final static int VIP_MEMBER = 1;
    final static int CORPORATE = 3;

    static String Name(int userType) {
        switch(userType){
            case MEMBER:
                return "Member";
            case VIP_MEMBER:
                return "Member VIP";
            case CORPORATE:
                return "Corporate User";
            default:
                return "Member";

        }
    }
}
