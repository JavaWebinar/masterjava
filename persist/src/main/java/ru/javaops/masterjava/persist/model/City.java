package ru.javaops.masterjava.persist.model;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class City extends RefEntity {
    public City(String ref, String name) {
        super(ref);
        this.name = name;
    }

    @NonNull private String name;
}