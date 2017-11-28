package ru.javaops.masterjava.service.mail.persist;

import com.bertoncelj.jdbi.entitymapper.Column;
import com.google.common.base.Joiner;
import lombok.*;
import ru.javaops.masterjava.persist.model.BaseEntity;
import ru.javaops.masterjava.service.mail.Addressee;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) // compare without id
@ToString
public class MailCase extends BaseEntity {
    private @Column("list_to") String listTo;
    private @Column("list_cc") String listCc;
    private String subject;
    private String state;
    private Date datetime;

    public static MailCase of(Set<Addressee> to, Set<Addressee> cc, String subject, String state){
        return new MailCase(Joiner.on(", ").join(to), Joiner.on(", ").join(cc), subject, state, new Date());
    }
}