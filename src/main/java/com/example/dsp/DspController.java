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

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 */
@Controller
public class DspController
{
    /**
     * TODO
     * 
     * @param model
     * @return the index page
     */
    @RequestMapping("/dsp")
    public String dsp(Model model)
    {
        model.addAttribute("dspInfo", new DspInfo());

        return "dsp";
    }

    /**
     * TODO
     * 
     * @param model
     * @param dspInfo
     * @return the index page
     */
    @PostMapping("/dsp/action")
    public String action(Model model, @ModelAttribute DspInfo dspInfo,
            @RequestParam(value = "action", required = true) String action)
    {
        Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
        logger.info(dspInfo.getAction());
        logger.info(dspInfo.getInfo());

        return "redirect:/dsp.html";
    }
}
