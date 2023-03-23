package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(urlPatterns = "/airetupal")
public class MyServlet extends HttpServlet {
    ArrayList<Todo> things = new ArrayList<>();
    static final long serialVersionUID = 35L;  //preguntar al profesor

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try{
            Optional<Integer> optId = Optional.ofNullable(Integer.parseInt(req.getParameter("id")));
            Integer id = optId.isPresent() ? optId.get(): null;
            Todo thing = Service.getTodo(id);
            things.add(thing);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(things));
            responseWriter.flush();
        }
        catch ( NumberFormatException e){
            responseWriter.write("Invalid Request.");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (FileNotFoundException e){
            responseWriter.write("404 NOT FOUND.");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (MalformedURLException e){
            responseWriter.write("500 INTERNAL SERVER ERROR");
        }catch (Exception e){
            responseWriter.write("Invalid Request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional <Integer> optId = Optional.ofNullable(Integer.parseInt(req.getParameter("id")));
            Integer id = optId.isPresent() ? optId.get(): null;
            Todo thing = Service.getTodo(id);
            things.add(thing);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(things));
            responseWriter.flush();
        }catch ( NumberFormatException e){
            responseWriter.write("Requerimiento Inválido");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (FileNotFoundException e){
            responseWriter.write("No encontrado.");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (MalformedURLException e){
            responseWriter.write("error interno en el Servidor ");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            responseWriter.write("requerimiento inválido");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
