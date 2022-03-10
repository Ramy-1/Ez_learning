package TTS;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

//    public static void main(String args[]) {
    public static void speak(String say) {

//creating an object of the Voice class  
        Voice voice;
//getting voice, here we have used kevin (male version) voice  
        voice = VoiceManager.getInstance().getVoice("kevin");
        if (voice != null) {
//the Voice class allocate() method allocates this voice  
            voice.allocate();
        }
        try {
//sets the rate (words per minute i.e. 190) of the speech  
            voice.setRate(190);
//sets the baseline pitch (150) in hertz   
            voice.setPitch(150);
//sets the volume (10) of the voice   
            voice.setVolume(10);
//the speak() method speaks the specified text  
            voice.speak(say);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
