
import javax.swing.*;
import javax.swing.event.ChangeEvent;


public class sliderbar {
    JSlider slider;
    public sliderbar(int max,int average){
        slider = new JSlider(JSlider.HORIZONTAL,0,max,average);
        slider.setSize(300,4);
        //slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(100);
        slider.setPaintTicks(false);
        slider.setPaintLabels(true);
    }
    public int sliderListener(JSlider slider){
        int SliderValue = slider.getValue();

        return SliderValue;
    }
    
    public static void main(String[] args){
    
        sliderbar Rent = new sliderbar();
        int x = Rent.slider(100,40);
        System.out.println(x);
        
    }
   
    



}

