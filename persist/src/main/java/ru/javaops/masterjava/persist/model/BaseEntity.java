package ru.javaops.masterjava.persist.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
abstract public class BaseEntity {

    @Getter
    @Setter
    protected Integer id;

    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return id != null && id.equals(baseEntity.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
