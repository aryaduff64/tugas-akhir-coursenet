package com.subrutin.catalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
@Table(indexes = {
        @Index(name = "uk_secure_id", columnList = "secure_id")
})
public abstract class AbstractBaseEntity implements Serializable {

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();

    @Column(name = "deleted", columnDefinition = "tinyint(1) default 0")
    private boolean deleted;

}
