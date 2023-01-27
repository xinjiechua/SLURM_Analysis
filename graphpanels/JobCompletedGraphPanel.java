package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JobCompletedGraphPanel extends JPanel{
	public void paint(Graphics g) {

		//set data to be modified
		int xAxisnum = 7;
		String nameX = "Month";
		String nameY = "Number of jobs";
		String title = "Number of jobs completed by month";
		int scaleYnum = 4;
		int scaleYdiff = 500;
		int scaleYini = 0;

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 100;

		//set initial value
		int leftBorder = 100;
		int upBorder = 150;
		int yAxislength = 500;
		int xAxislength = 800;

		//set data in y axis
		int[] yVar = {1893,1139,1186,1153,1564,1092,452};
		int mult = 1;

		//set data in x axis
		String[] xVar = {"June","July","August","September","October","November","December"};
		String[] xVarShort = {"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		int space = 100;

		Graphics2D g2D = (Graphics2D)g ;

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString(nameY,leftBorder-60 ,upBorder-30 );
		g2D.drawString(nameX, leftBorder+xAxislength+30, upBorder+yAxislength);

		//lable title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString(title, 300, 70);

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		int scale = scaleYini;
		for(int i = 0; i<scaleYnum; i++) {
			scale += scaleYdiff;
			String scalee = Integer.toString(scale);
			g2D.drawString(scalee, leftBorder-50, yAxislength+upBorder-labelspace*(i+1)+10);
		}

		for(int i = 0; i<scaleYnum; i++) {
			g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*(i+1), leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*(i+1));
		}

		//draw graph lines---------------------------------------
		g2D.setStroke(new BasicStroke(3));
		g2D.setColor(new Color(195,123,135));
		for(int i = 0; i<xAxisnum-1; i++) {
			g2D.drawLine(space*(i+1)+leftBorder, yAxislength-yVar[i]*mult/5+upBorder,space*(i+2)+leftBorder ,yAxislength-yVar[(i+1)]*mult/5+upBorder);
		}

		//draw dots on graph -----------------------
		g2D.setColor(new Color(130,111,141));
		for(int i = 0; i<xAxisnum; i++) {
			g2D.fillOval(space*(i+1)+leftBorder-5, yAxislength-yVar[i]*mult/5+upBorder-5, 10, 10);
		}

		//labels on x axis-----------------------
		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		for(int i = 0; i<xAxisnum; i++) {
			g2D.drawString(xVarShort[i],space*(i+1)+leftBorder-10 ,yAxislength+upBorder+50);
		}

		//=====================================table===================================
		int tablex = 1000;
		int tabley = upBorder+50;
		int tablewidth = 450;
		int tablelength = 35*(xAxisnum+1);
		int tablespaceY = 35;
		int tablespaceX = tablewidth/2;
		int tablenext = 25;

		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.black);
		for(int i = 0; i<3; i++) {
			g2D.drawLine(tablex+tablespaceX*i, tabley, tablex+tablespaceX*i, tabley+tablelength);
		}
		for(int i = 0; i<(xAxisnum+2);i++) {
			g2D.drawLine(tablex, tabley+tablespaceY*i, tablex+tablewidth, tabley+tablespaceY*i);
		}

		//insert table x and y
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString(nameX, tablex+10, tabley+tablenext);
		g2D.drawString(nameY, tablex+10+tablewidth/2, tabley+tablenext);

		//insert data in table x
		for(int i = 0; i<xAxisnum; i++) {
			g2D.drawString(xVar[i], tablex+10, tabley+tablenext+tablespaceY*(i+1));
		}

		// insert data in table y
		for(int i = 0; i<xAxisnum;i++) {
			int dataaa = yVar[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespaceY*(i+1));
		}
	}
}

