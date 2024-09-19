import javax.swing.*;

public class sliderbar {
    JSlider slider;
    int spacing;
    int pointer;
    public sliderbar(String average){
        if ("0".equals(average) || "0.0".equals(average)){

            pointer = 0;
            average = "500";
        }
        else{
            pointer = Double.valueOf(average).intValue();
        }
        int maximum = Math.round(((Double.valueOf(average).intValue()*3)/50.0f))*50;
        spacing = maximum/10;
        
        System.out.println(spacing);

        slider = new JSlider(JSlider.HORIZONTAL,0,maximum,pointer);
        //slider.setSize(300,4);
        slider.setMinorTickSpacing(spacing);
        slider.setMajorTickSpacing(spacing);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        };
    public void changeBar(){
        
    }
    public int sliderListener(){
     
        int SliderValue = slider.getValue();

        return SliderValue;
        }
}   

