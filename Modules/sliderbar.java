
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class sliderbar {
    JSlider slider;
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

