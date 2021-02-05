package dinoGame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class moveDino {

        void jump(JLabel label) {
        	
		Timer myTimer = new Timer();
		TimerTask task = new TimerTask() {
			int x = 0;
			int y = 0;
			int z = 0;
			int JumpHeight=60   ;
			int groundPx=label.getY();
			@Override
			public void run() {
				if(x<JumpHeight) {
				label.setBounds(label.getX(), label.getY()-2, label.getWidth(), label.getHeight());
				x++;
				z++;
				}
				else {
					y=1;
				}
				if (y>0&&label.getY()<groundPx) {
					label.setBounds(label.getX(), label.getY()+2, label.getWidth(), label.getHeight());
					y++;
					z++;
				}
				if(z==JumpHeight*2) {
					myTimer.cancel();
				}
				
		}};
		myTimer.scheduleAtFixedRate(task, 100, 5 );
			
		
		
		
}
        void moveLeft(JLabel dino,JLabel player) {
        	Random rand = new Random();
        	Timer myTimer = new Timer();
    		TimerTask task = new TimerTask() {
      			@Override
    			public void run() {		
    				if(dino.getX()>=0-dino.getWidth()) {
    				dino.setBounds(dino.getX()-2, dino.getY(), dino.getWidth(), dino.getHeight());}
    				else {
    					myTimer.cancel();
    					dino.setBounds(rand.nextInt(100)+700, 256, 23,46 );
    					moveLeft(dino,player);
    				}
    				if(isColiding(dino,player)) {
    					myTimer.cancel();
    					JOptionPane.showMessageDialog(null,"You lost");
    				}
    		}};
    		myTimer.scheduleAtFixedRate(task, 100, 5); 
        }
        
        
        
        
        boolean isColiding(JLabel label_1,JLabel label1) {
        	if( ( label_1.getX() + label_1.getWidth() > label1.getX() && label_1.getX() < label1.getX()+label1.getWidth() ) &&
    				(label_1.getY() + label_1.getHeight() > label1.getY()&& label_1.getY() < label1.getY() + label1.getHeight() ) 
    				) {
    			return true;
    		}
        	else {
        		return false;
        	}
        }



}
