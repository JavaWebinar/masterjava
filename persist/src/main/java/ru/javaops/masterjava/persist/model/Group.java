package ru.javaops.masterjava.persist.model;

import com.bertoncelj.jdbi.entitymapper.Column;
import lombok.*;
import ru.javaops.masterjava.persist.model.type.GroupType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Group extends BaseEntity {

    @NonNull private String name;
    @NonNull private GroupType type;
    @NonNull @Column("project_id") private int projectId;
}
