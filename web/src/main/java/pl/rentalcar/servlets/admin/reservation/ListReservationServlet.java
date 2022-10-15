package pl.rentalcar.servlets.admin.reservation;

import pl.rentalcar.admin.ReservationController;
import pl.rentalcar.admin.implement.ReservationControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/listReservation")
public class ListReservationServlet extends HttpServlet {

    ReservationController reservationController;

    public ListReservationServlet( ) {
        this.reservationController = new ReservationControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reservationController.showReservationList(req,resp);
    }
}
