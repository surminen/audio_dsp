/*
 * (c) Copyright 2017 TeleCommunication Systems, Inc.
 * ALL RIGHTS RESERVED
 *
 * The software and information contained herein are proprietary to, and
 * comprise valuable trade secrets of, TeleCommunication Systems, Inc., which
 * intends to preserve as trade secrets such software and information.
 * This software is furnished pursuant to a written license agreement and
 * may be used, copied, transmitted, and stored only in accordance with
 * the terms of such license and with the inclusion of the above copyright
 * notice.  This software and information or any other copies thereof may
 * not be provided or otherwise made available to any other person.
 */

package com.example.dsp;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 
 */
@Controller
public class FaultController implements ErrorController
{
    private static final String ERROR_PATH = "/error";

    /**
     * TODO
     * 
     * @return the error text
     */
    @RequestMapping(value = ERROR_PATH)
    public String error()
    {
        return "error";
    }

    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }
}
