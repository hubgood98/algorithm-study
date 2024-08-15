
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ex7_9 {
   public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("액션이벤트 발생");
            }
        });
   }
    
}