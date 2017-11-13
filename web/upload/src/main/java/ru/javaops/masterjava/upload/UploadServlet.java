package ru.javaops.masterjava.upload;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.context.WebContext;
import ru.javaops.masterjava.persist.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static ru.javaops.masterjava.common.web.ThymeleafListener.engine;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10) //10 MB in memory limit
public class UploadServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UploadServlet.class);
    private static final int CHUNK_SIZE = 2000;

    private final UserProcessor userProcessor = new UserProcessor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out(req, resp, "", CHUNK_SIZE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        int chunkSize = CHUNK_SIZE;
        try {
//            http://docs.oracle.com/javaee/6/tutorial/doc/glraq.html
            chunkSize = Integer.parseInt(req.getParameter("chunkSize"));
            if (chunkSize < 1) {
                message = "Chunk Size must be > 1";
            } else {
                Part filePart = req.getPart("fileToUpload");
                try (InputStream is = filePart.getInputStream()) {
                    List<User> users = userProcessor.process(is, chunkSize);
                    log.info("Successfully uploaded " + users.size() + " users");
                    final WebContext webContext =
                            new WebContext(req, resp, req.getServletContext(), req.getLocale(),
                                    ImmutableMap.of("users", users));
                    engine.process("result", webContext, resp.getWriter());
                    return;
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            message = e.toString();
        }
        out(req, resp, message, chunkSize);
    }

    private void out(HttpServletRequest req, HttpServletResponse resp, String message, int chunkSize) throws IOException {
        resp.setCharacterEncoding("utf-8");
        final WebContext webContext = new WebContext(req, resp, req.getServletContext(), req.getLocale(),
                ImmutableMap.of("message", message, "chunkSize", chunkSize));
        engine.process("upload", webContext, resp.getWriter());
    }
}
