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

package tarsos;

import java.util.Vector;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;

/**
 * TODO
 */
public class AudioInfo
{
    String mixer;

    /**
     * @param string
     */
    public AudioInfo(String string)
    {
        setMixer(string);
    }

    /**
     * @param mixer
     *            the mixer to set
     */
    public void setMixer(String mixer)
    {
        this.mixer = mixer;
    }

    /**
     * @return the mixer
     */
    public String getMixer()
    {
        return mixer;
    }

    /**
     * TODO
     * 
     * @param supportsPlayback
     * @param supportsRecording
     * @return mixer information
     */
    public static Vector<Mixer.Info> getMixerInfo(final boolean supportsPlayback, final boolean supportsRecording)
    {
        final Vector<Mixer.Info> infos = new Vector<Mixer.Info>();
        final Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (final Info mixerinfo : mixers)
        {
            if (supportsRecording && AudioSystem.getMixer(mixerinfo).getTargetLineInfo().length != 0)
            {
                // Mixer capable of recording audio if target LineWavelet length != 0
                infos.add(mixerinfo);
            }
            else if (supportsPlayback && AudioSystem.getMixer(mixerinfo).getSourceLineInfo().length != 0)
            {
                // Mixer capable of audio play back if source LineWavelet length != 0
                infos.add(mixerinfo);
            }
        }
        return infos;
    }
}
