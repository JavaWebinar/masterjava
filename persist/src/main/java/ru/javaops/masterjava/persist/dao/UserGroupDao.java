package ru.javaops.masterjava.persist.dao;

import com.bertoncelj.jdbi.entitymapper.EntityMapperFactory;
import one.util.streamex.StreamEx;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import ru.javaops.masterjava.persist.model.UserGroup;

import java.util.List;
import java.util.Set;

@RegisterMapperFactory(EntityMapperFactory.class)
public abstract class UserGroupDao implements AbstractDao {

    @SqlUpdate("TRUNCATE user_group CASCADE")
    @Override
    public abstract void clean();

    @SqlBatch("INSERT INTO user_group (user_id, group_id) VALUES (:userId, :groupId)")
    public abstract void insertBatch(@BindBean List<UserGroup> userGroups);

    @SqlQuery("SELECT user_id FROM user_group WHERE group_id=:it")
    public abstract Set<Integer> getUserIds(@Bind int groupId);

    public static List<UserGroup> toUserGroups(int userId, Integer... groupIds) {
        return StreamEx.of(groupIds).map(groupId -> new UserGroup(userId, groupId)).toList();
    }

    public static Set<Integer> getByGroupId(int groupId, List<UserGroup> userGroups) {
        return StreamEx.of(userGroups).filter(ug -> ug.getGroupId() == groupId).map(UserGroup::getUserId).toSet();
    }
}