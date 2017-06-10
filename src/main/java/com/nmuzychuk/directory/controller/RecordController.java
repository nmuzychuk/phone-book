package com.nmuzychuk.directory.controller;

import com.nmuzychuk.directory.model.Record;
import com.nmuzychuk.directory.service.RecordService;
import com.nmuzychuk.directory.service.RecordServiceStubImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RecordController extends HttpServlet {
    private RecordService recordService = new RecordServiceStubImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id;
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "new":
                    req.getRequestDispatcher("record/new.jsp").forward(req, resp);
                    break;
                case "show":
                    id = req.getParameter("id");
                    try {
                        Record record = recordService.getRecord(Integer.parseInt(id));
                        req.setAttribute("record", record);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    req.getRequestDispatcher("record/show.jsp").forward(req, resp);
                    break;
                case "edit":
                    id = req.getParameter("id");
                    try {
                        Record record = recordService.getRecord(Integer.parseInt(id));
                        req.setAttribute("record", record);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    req.getRequestDispatcher("record/edit.jsp").forward(req, resp);
                    break;
            }
        } else {
            List<Record> recordList = recordService.getAllRecords();
            req.setAttribute("recordList", recordList);

            req.getRequestDispatcher("record/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id, firstName, lastName, phoneNumber;
        String method = req.getParameter("_method");
        Record record;

        if (method != null && !method.isEmpty()) {
            switch (method) {
                case "put":
                    id = req.getParameter("id");
                    firstName = req.getParameter("firstName");
                    lastName = req.getParameter("lastName");
                    phoneNumber = req.getParameter("phoneNumber");

                    record = new Record(Integer.parseInt(id), firstName, lastName, phoneNumber);

                    try {
                        recordService.updateRecord(record);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    resp.sendRedirect("/");
                    return;
                case "delete":
                    id = req.getParameter("id");
                    try {
                        recordService.deleteRecord(Integer.parseInt(id));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    resp.sendRedirect("/");
                    return;

            }
        }

        id = req.getParameter("id");
        firstName = req.getParameter("firstName");
        lastName = req.getParameter("lastName");
        phoneNumber = req.getParameter("phoneNumber");

        record = new Record(Integer.parseInt(id), firstName, lastName, phoneNumber);

        recordService.addRecord(record);
        resp.sendRedirect("/");
    }
}
