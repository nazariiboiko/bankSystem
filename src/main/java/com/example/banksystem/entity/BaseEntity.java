package com.example.banksystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@Setter
@Getter
public class BaseEntity {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Long id;

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null || o.getClass() != o.getClass())
            return false;

        BaseEntity ent = (BaseEntity) o;

        return this.getId() == ent.getId();

    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }


}
