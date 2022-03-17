package com.example.example.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname,
            lastname,
            username,
            password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date col_update;

    /* asigna en automatico la fecha al insertar */
    @PrePersist
    public void prePersist(){
        this.created = new Date();
    }

    /* asigna en automatico la fecha al actualizar */
    @PreUpdate
    public void preUpdate(){
        this.col_update = new Date();
    }


}
