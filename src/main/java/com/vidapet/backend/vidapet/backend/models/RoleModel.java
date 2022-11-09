package com.vidapet.backend.vidapet.backend.models;

import com.vidapet.backend.vidapet.backend.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "papel")
public class RoleModel implements GrantedAuthority, Serializable {

    @Serial
    private static final long serialVersionUID = 7064452877490964201L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public RoleModel(Long roleId, RoleName roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleModel() {

    }
}
