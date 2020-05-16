package com.geyuxu.activeObject;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by temp on 2016/9/7.
 */
public class MMSDeliveryServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        MMSDeliveryReqest mmsDeliveryReqest = this.parseRequest(req.getInputStream());
        Recipient shortNumberRecipient = mmsDeliveryReqest.getRecipient();
        Recipient originalNumberRecipient = null;

    }

    private MMSDeliveryReqest parseRequest(InputStream reqInputStream){
        MMSDeliveryReqest mmsDeliveryReqest = new MMSDeliveryReqest();
        //...
        return mmsDeliveryReqest;
    }

    class Recipient{}
}

