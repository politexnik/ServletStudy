package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> names =  model.list();
        String checkboxName;
        for (String name : names) {
            checkboxName = req.getParameter(name);
            if (checkboxName != null){
                Model.deleteUser(name);
            }
        }
        String path = "/showUsers";
        resp.sendRedirect(path);
    }
}
