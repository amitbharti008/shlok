package com.amit.sholoklogistics.controller;

import com.amit.sholoklogistics.model.RequestModel;
import com.amit.sholoklogistics.services.RequestService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestController", urlPatterns = {"/RequestController"})
public class RequestController extends HttpServlet {

    private final RequestService service = new RequestService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("index.jsp?message=Invalid action");
            return;
        }

        switch (action) {
            case "insert":
                insert(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                response.sendRedirect("index.jsp?message=Invalid action");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "RequestController handles the request actions for Shlok Logistics.";
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestModel requestModel = new RequestModel();

        try {
            requestModel.setDepartureCity(request.getParameter("departureCity"));
            requestModel.setDeliveryCity(request.getParameter("deliveryCity"));
            requestModel.setWeight(Double.parseDouble(request.getParameter("weight")));
            requestModel.setDimensions(request.getParameter("dimensions"));
            requestModel.setName(request.getParameter("name"));
            requestModel.setEmail(request.getParameter("email"));
            requestModel.setPhone(request.getParameter("phone"));
            requestModel.setMessage(request.getParameter("message"));

            String message = service.insert(requestModel);
            response.sendRedirect("index.jsp?msg=" + message);
        } catch (NumberFormatException e) {
            response.sendRedirect("index.jsp?msg=Invalid weight format");
        } catch (Exception e) {
            response.sendRedirect("index.jsp?msg=An error occurred: " + e.getMessage());
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("index.jsp?message=Invalid ID");
            return;
        }

        String message = service.deletePost(id);
        response.sendRedirect("index.jsp?message=" + message);
    }

    public ArrayList<RequestModel> findAll() {
        return service.findAll();
    }
}
