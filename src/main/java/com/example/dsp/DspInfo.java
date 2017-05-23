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

/**
 * TODO
 */
public class DspInfo
{
    private String info;
    private String action;

    /**
     * @param action
     *            the action to set
     */
    public void setAction(String action)
    {
        this.action = action;
    }

    /**
     * @param info
     *            the info to set
     */
    public void setInfo(String info)
    {
        this.info = info;
    }

    /**
     * @return the info
     */
    public String getInfo()
    {
        return info;
    }

    /**
     * @return the action
     */
    public String getAction()
    {
        return action;
    }
}
