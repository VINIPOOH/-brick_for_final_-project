package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User extends Entity {
    private String email;
    private RoleType roleType;
    private String password;
    private Long userMoneyInCents;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private List<Delivery> waysWhereThisUserIsSend;
    private List<Delivery> waysWhereThisUserIsGet;


}
