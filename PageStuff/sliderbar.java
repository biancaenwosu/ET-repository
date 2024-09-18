import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class sliderbar {
    JSlider slider;
<<<<<<< Updated upstream
    int sliderValue;
    JFrame frame;
    public int slider(int max,int average,SliderValueListener listener){
        slider = new JSlider(JSlider.HORIZONTAL,0,max,average);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (!slider.getValueIsAdjusting()){
                    sliderValue = slider.getValue();
                    listener.finalValue(sliderValue);
                }
            }
            
        });
        frame = new JFrame();
        frame.add(slider);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
=======
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
        }
    public int sliderListener(){
        int SliderValue = slider.getValue();

        return SliderValue;
        }
>>>>>>> Stashed changes

        return sliderValue;
    }
    public interface SliderValueListener {
        void finalValue(int value);
    
        
    }
    public static void main(String[] args){
    
        sliderbar Rent = new sliderbar();
        int x = Rent.slider(100,40, new SliderValueListener() {
            @Override
            public void finalValue(int value){
                System.out.println(value);
            }
        });
        System.out.println(x);
    }

}