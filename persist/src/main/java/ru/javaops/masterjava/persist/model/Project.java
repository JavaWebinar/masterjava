package ru.javaops.masterjava.persist.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Project extends BaseEntity {

    @NonNull private String name;
    @NonNull private String description;
}
