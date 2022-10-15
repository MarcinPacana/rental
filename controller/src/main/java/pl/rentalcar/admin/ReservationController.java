package pl.rentalcar.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReservationController {
    public void showReservationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
