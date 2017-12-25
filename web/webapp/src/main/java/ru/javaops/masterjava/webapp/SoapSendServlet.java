package ru.javaops.masterjava.webapp;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.service.mail.GroupResult;
import ru.javaops.masterjava.service.mail.MailWSClient;
import ru.javaops.masterjava.service.mail.util.MailUtils;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import static ru.javaops.masterjava.webapp.WebUtil.doAndWriteResponse;
import static ru.javaops.masterjava.webapp.WebUtil.getNotEmptyParam;

@WebServlet("/sendSoap")
@Slf4j
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, //10 MB in memory limit
        maxFileSize = 1024 * 1024 * 25)
public class SoapSendServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        doAndWriteResponse(resp, () -> {
            String users = getNotEmptyParam(req, "users");
            String subject = req.getParameter("subject");
            String body = getNotEmptyParam(req, "body");
            Part filePart = req.getPart("attach");
            GroupResult groupResult = MailWSClient.sendBulk(MailUtils.split(users), subject, body,
                    filePart == null ? null :
                            ImmutableList.of(MailUtils.getAttachment(filePart.getSubmittedFileName(), filePart.getInputStream())));
            return groupResult.toString();
        });
    }
}
