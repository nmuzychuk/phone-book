package com.nmuzychuk.directory.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecordControllerTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRecordControllerGetIndex() throws Exception {
        when(request.getRequestDispatcher("record/index.jsp")).thenReturn(requestDispatcher);

        new RecordController().doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRecordControllerGetNew() throws Exception {
        when(request.getParameter("action")).thenReturn("new");
        when(request.getRequestDispatcher("record/new.jsp")).thenReturn(requestDispatcher);

        new RecordController().doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRecordControllerGetShow() throws Exception {
        when(request.getParameter("action")).thenReturn("show");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getRequestDispatcher("record/show.jsp")).thenReturn(requestDispatcher);

        new RecordController().doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRecordControllerGetEdit() throws Exception {
        when(request.getParameter("action")).thenReturn("edit");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getRequestDispatcher("record/edit.jsp")).thenReturn(requestDispatcher);

        new RecordController().doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRecordControllerPost() throws Exception {
        when(request.getParameter("id")).thenReturn("1");

        new RecordController().doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void testRecordControllerPostNoId() throws Exception {
        new RecordController().doPost(request, response);

        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, "ID auto increment is not supported");
    }

    @Test
    public void testRecordControllerPut() throws Exception {
        when(request.getParameter("_method")).thenReturn("put");
        when(request.getParameter("id")).thenReturn("1");

        new RecordController().doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void testRecordControllerDelete() throws Exception {
        when(request.getParameter("_method")).thenReturn("delete");
        when(request.getParameter("id")).thenReturn("1");

        new RecordController().doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void testRecordControllerInvalidMethod() throws Exception {
        when(request.getParameter("_method")).thenReturn("invalid");

        new RecordController().doPost(request, response);

        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, "Undefined method invalid");
    }
}
