package za.co.codecrafter.ticker;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class Tone {

    int channel = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments

    int volume = 80; // between 0 et 127
    int duration = 200; // in milliseconds

    int shortTone = 100;
    int longTone = 500;

    private Synthesizer synth;
    private MidiChannel[] channels;

    public Tone() throws MidiUnavailableException {
        synth = MidiSystem.getSynthesizer();
        channels = synth.getChannels();
    }

    public void chord(int duration, Integer... notes) {
        try {
            synth.open();
            for (Integer note : notes) {
                channels[channel].noteOn(note, duration);
            }
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } finally {
            channels[channel].allNotesOff();
            synth.close();
        }
    }

    public void apigio(Integer... notes) {
        try {
            synth.open();
            int previousNote = 0;
            for (Integer note : notes) {
                channels[channel].noteOff(previousNote);
                channels[channel].noteOn(note, volume); // C note
                Thread.sleep(duration);
                previousNote = note;
            }
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } finally {
            channels[channel].allNotesOff();
            synth.close();
        }
    }

    public void goingUp(int threshold) {
        apigio(60, 64, 67);
        if (threshold > 1) {
            apigio(64, 67, 72);
        }
        if (threshold > 2) {
            apigio(67, 72, 76);
        }
        if (threshold > 10) {
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(longTone, 67, 72, 76);
        }
        if (threshold > 20) {
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(longTone, 67, 72, 76);
        }
        if (threshold > 30) {
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(longTone, 67, 72, 76);
        }
        if (threshold > 40) {
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(longTone, 67, 72, 76);
        }
        if (threshold > 50) {
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(shortTone, 67, 72, 76);
            chord(longTone, 67, 72, 76);
        }
    }

    public void goingDown(int threshold) {
        apigio(67, 64, 60);
        if (threshold > 1) {
            apigio(64, 60, 55);
        }
        if (threshold > 2) {
            apigio(60, 55, 52);
        }
        //---
        if (threshold > 10) {
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(longTone, 60, 55, 52);
        }
        if (threshold > 20) {
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(longTone, 60, 55, 52);
        }
        if (threshold > 30) {
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(longTone, 60, 55, 52);
        }
        if (threshold > 40) {
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(longTone, 60, 55, 52);
        }
        if (threshold > 50) {
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(shortTone, 60, 55, 52);
            chord(longTone, 60, 55, 52);
        }
    }
}
