package absensisekolah.Utility;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author Champerz
*/

public class jamdigital extends JLabel {


//Deklarasi Variable
JPanel Pnl;

int currentHour;
int currentMinute;
int currentSecond;

//Set Font
Font myFont = new Font("Segoe UI Light", Font.BOLD, 30);

//Set Color
Color myColor = new Color(0, 0, 0);

//Save Font Information.
FontMetrics fm;

public jamdigital() {
//Create a window using JFrame with title ( Java Digital Clock )

//add(this) mean add created panel into JFrame
//Which panel ?
//See line 98 and 20 (I hope you understand it)

//Set default close operation for JFrame

//Set Frame size

//Make JFrame locate at center

//Make JFrame visible
// frame.setUndecorated(false);

/*
*Loop that will make sure panel show current time
*like current second, current minute and current hour.
*/
while (true) {
//It will do all code in method paint(See line 71)
repaint();

try {
Thread.sleep(900);
} catch (Exception exception) {
exception.printStackTrace();
}
}
}
@Override
public void paint(Graphics g) {
super.paint(g);

/*
*Create current Date object. It means it store information
*about current hour, minute and second.
*/
Date myDate = new Date();

currentHour = myDate.getHours();
currentMinute = myDate.getMinutes();
currentSecond = myDate.getSeconds();

//Set font that will use to draw digital number
g.setFont(myFont);

//Information about distance between number in digital clock
fm = g.getFontMetrics();
int hourXCoordinate = 20;
int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
int secondXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 4);

//Set color that will use to draw digital number
g.setColor(myColor);

//Draw hour, draw (:) between number, draw minute and draw second.
g.drawString(Integer.toString(currentHour), hourXCoordinate, 30);
g.drawString(":", (hourXCoordinate + minuteXCoordinate) / 2, 30);
g.drawString(Integer.toString(currentMinute), minuteXCoordinate, 30);
g.drawString(":", (secondXCoordinate + minuteXCoordinate) / 2, 30);
g.drawString(Integer.toString(currentSecond), secondXCoordinate, 30);
}

}