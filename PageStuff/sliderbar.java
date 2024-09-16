
import javax.swing.*;



public class sliderbar {
    JSlider slider;
    public sliderbar(int max, int average, int spacing){
        slider = new JSlider(JSlider.HORIZONTAL,0,max,average);
        slider.setSize(300,4);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(spacing);
        slider.setPaintTicks(false);
        slider.setPaintLabels(true);
    }
    public int sliderListener(){
        int SliderValue = slider.getValue();

        return SliderValue;
    }
    
    



}

