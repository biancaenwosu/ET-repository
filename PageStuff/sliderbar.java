import javax.swing.*;

public class sliderbar {
    JSlider slider;
    int spacing;
    public sliderbar(String average){
        if ("0".equals(average)){

            average = "500";
        }
        int maximum = Math.round(((Double.valueOf(average).intValue()*3)/50.0f))*50;
        spacing = maximum/10;
        System.out.println(spacing);

        slider = new JSlider(JSlider.HORIZONTAL,0,maximum,Double.valueOf(average).intValue());
        //slider.setSize(300,4);
        slider.setMinorTickSpacing(spacing);
        slider.setMajorTickSpacing(spacing);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        };
    public int sliderListener(){
        int SliderValue = slider.getValue();

        return SliderValue;
        }
}    

