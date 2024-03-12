package kz.kelsingazin.techtask.io.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    protected Date deletedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    protected Date updatedAt;
}
