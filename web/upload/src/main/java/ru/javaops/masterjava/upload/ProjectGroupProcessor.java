package ru.javaops.masterjava.upload;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.javaops.masterjava.persist.DBIProvider;
import ru.javaops.masterjava.persist.dao.GroupDao;
import ru.javaops.masterjava.persist.dao.ProjectDao;
import ru.javaops.masterjava.persist.model.Group;
import ru.javaops.masterjava.persist.model.Project;
import ru.javaops.masterjava.persist.model.type.GroupType;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.Map;

import static ru.javaops.masterjava.upload.PayloadProcessor.jaxbParser;

@Slf4j
public class ProjectGroupProcessor {
    private final ProjectDao projectDao = DBIProvider.getDao(ProjectDao.class);
    private final GroupDao groupDao = DBIProvider.getDao(GroupDao.class);

    public Map<String, Group> process(StaxStreamProcessor processor) throws XMLStreamException, JAXBException {
        val projectMap = projectDao.getAsMap();
        val groupMap = groupDao.getAsMap();
        val newGroups = new ArrayList<Group>();

        processor.doUntil(XMLEvent.START_ELEMENT, "Projects");
        Payload.Projects projects = jaxbParser.createUnmarshaller().unmarshal(processor.getReader(), Payload.Projects.class);
        projects.getProject().forEach(p -> {
            Project project = projectMap.get(p.getName());
            if (project == null) {
                project = new Project(p.getName(), p.getDescription());
                log.info("Insert project " + project);
                projectDao.insert(project);
            }
            final int projectId = project.getId();
            p.getGroup().forEach(g -> {
                if (!groupMap.containsKey(g.getName())) {
                    newGroups.add(new Group(g.getName(), GroupType.valueOf(g.getType().value()), projectId));
                }
            });
        });
        log.info("Insert groups " + newGroups);
        groupDao.insertBatch(newGroups);
        return groupDao.getAsMap();
    }
}