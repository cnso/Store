package edu.zhuoxun.store.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private Date birthday;
    private String sex;
}
