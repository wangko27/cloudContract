package com.veight.user.entities;

import com.veight.user.model.enums.Gender;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-17T18:36:58")
@StaticMetamodel(UserModel.class)
public class UserModel_ { 

    public static volatile SingularAttribute<UserModel, Date> birthday;
    public static volatile SingularAttribute<UserModel, String> password;
    public static volatile SingularAttribute<UserModel, Boolean> isEnabled;
    public static volatile SingularAttribute<UserModel, String> registerIp;
    public static volatile SingularAttribute<UserModel, String> username;
    public static volatile SingularAttribute<UserModel, String> loginIp;
    public static volatile SingularAttribute<UserModel, String> email;
    public static volatile SingularAttribute<UserModel, String> name;
    public static volatile SingularAttribute<UserModel, Integer> loginFailureCount;
    public static volatile SingularAttribute<UserModel, Gender> gender;
    public static volatile SingularAttribute<UserModel, Date> loginDate;
    public static volatile SingularAttribute<UserModel, Date> lockedDate;
    public static volatile SingularAttribute<UserModel, Boolean> isLock;
    public static volatile SingularAttribute<UserModel, String> idNumber;
    public static volatile SingularAttribute<UserModel, String> mobile;

}