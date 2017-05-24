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

import java.util.Vector;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tarsos.AudioInfo;
import tarsos.DspInfo;
import tarsos.PitchShiftingExample;

/**
 * TODO
 */
@Controller
public class DspController
{
    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    PitchShiftingExample ps = new PitchShiftingExample();

    /**
     * TODO
     * 
     * @param model
     * @return the index page
     */
    @RequestMapping("/dsp")
    public String dsp(Model model)
    {
        AudioInfo[] infoArr = new AudioInfo[2];

        infoArr[0] = new AudioInfo("mixer1");
        infoArr[1] = new AudioInfo("mixer2");

        Vector<Info> mixers = AudioInfo.getMixerInfo(true, true);
        Object[] arr = mixers.stream().toArray();

        model.addAttribute("mixers", arr);
        model.addAttribute("infoArr", infoArr);
        model.addAttribute("dspInfo", new DspInfo());

        return "dsp";
    }

    /**
     * TODO
     * 
     * @param model
     * @param dspInfo
     * @param action
     * @return the index page
     * @throws LineUnavailableException
     */
    @PostMapping("/dsp/action")
    public String action(Model model, @ModelAttribute DspInfo dspInfo,
            @RequestParam(value = "action", required = true) String action) throws LineUnavailableException
    {
        logger.info(dspInfo.getAction());
        logger.info(dspInfo.getMixerInfo());
        logger.info(dspInfo.getInfo());

        if (action.equalsIgnoreCase("start"))
        {
            startEffects(dspInfo.getMixerInfo());
            return "dspStop";
        }
        else if (action.equalsIgnoreCase("stop"))
        {
            stopEffects();
        }

        return "redirect:/dsp.html";
    }

    private void stopEffects()
    {
        ps.stopFromMic();
    }

    private void startEffects(String mixerName) throws LineUnavailableException
    {
        Mixer mixer = null;
        Vector<Info> info = AudioInfo.getMixerInfo(true, true);
        for (Info mixerInfo : info)
        {
            if (mixerName.equals(mixerInfo.getName()))
            {
                mixer = AudioSystem.getMixer(mixerInfo);
            }
        }

        ps.startFromMic(0.5, mixer);
    }
}
