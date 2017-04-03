package net.ua.entity;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "permissions",
	uniqueConstraints=@UniqueConstraint(columnNames={"permissionname"}))
public class Permission extends BaseEntity implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 2178238061564691997L;

	@NotNull
    @NotEmpty
    @Size(max = 50)
    @Column(name = "permissionname", length = 50)
    private String permissionname;

    @ManyToMany //(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
            joinColumns        = {@JoinColumn(name = "permission_id"/*, referencedColumnName = "id"*/)},
            inverseJoinColumns = {@JoinColumn(name = "role_id"/*, referencedColumnName = "id"*/)}
    )
    private Set<Role> permRoles;

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Set<Role> getPermRoles() {
        return permRoles;
    }

    public void setPermRoles(Set<Role> permRoles) {
        this.permRoles = permRoles;
    }

    @Override
    public String toString() {
        return String.format("%s(id=%d, permissionname='%s')",
                this.getClass().getSimpleName(),
                this.getId(), this.getPermissionname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Role) {
            final Permission other = (Permission) o;
            return Objects.equal(getId(), other.getId())
                    && Objects.equal(getPermissionname(), other.getPermissionname());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getPermissionname());
    }

    @Override
    public String getAuthority() {
        return permissionname;
    }
}
