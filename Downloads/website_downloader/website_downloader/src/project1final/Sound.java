/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1final;

import javafx.scene.media.AudioClip;

/**
 *
 * @author CSC
 */
public class Sound
{
    
    // لتمثلها و لنستطيع تشغيلها من خلالها AudioClip الملفات الصوتية الموضوعة في المشروع قمنا بإنشاء كائنات من الكلاس
    AudioClip audio_1 = new AudioClip(getClass().getResource("general-click.wav").toString());
    AudioClip audio_2 = new AudioClip(getClass().getResource("playing-click.wav").toString());
    AudioClip audio_3 = new AudioClip(getClass().getResource("intro.MP3").toString());
    AudioClip audio_4 = new AudioClip(getClass().getResource("clock-tick.wav").toString());
    AudioClip audio_5 = new AudioClip(getClass().getResource("win-sound.mp3").toString());
    
    public void clickSound() {
        audio_1.play();
    }
    
    public void ClickOnWrongAnswerSound() {
        audio_2.play();
    }
    
    public void ClickOnCorrectAnswerSound() {
        audio_5.play();
    }
    
    public void introSound() {
        audio_3.play();
    }
    
    public void clockTickSound() {
        audio_4.play();
    }
    
}
