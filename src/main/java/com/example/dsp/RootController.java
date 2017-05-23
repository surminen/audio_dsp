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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 */
@Controller
public class RootController
{
    /**
     * TODO
     * 
     * @param model
     * @return the index page
     */
    @RequestMapping("/")
    public String index(Model model)
    {
        return "index";
    }
}
