package ru.javaops.masterjava.persist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract public class BaseEntity {

    protected Integer id;

    public boolean isNew() {
        return id == null;
    }
}
