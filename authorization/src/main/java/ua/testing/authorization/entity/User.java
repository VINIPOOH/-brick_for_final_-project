package ua.testing.authorization.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table( name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "name_ru", nullable = false)
    private String nameRu;
    @Column(name = "name_en", nullable = false)
    private String nameEn;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
