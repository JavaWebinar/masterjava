package ru.javaops.masterjava.persist.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
abstract public class RefEntity {
    @Getter
    @NonNull private String ref;
}
