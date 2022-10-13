package pl.rentalcar.servlets.frontend;

import pl.rentalcar.PageList;
import pl.rentalcar.impl.PrinterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrinterService.printData(req,"HomeServlet");
        req.getRequestDispatcher(PageList.HOME_PAGE).forward(req,resp);
    }
}
