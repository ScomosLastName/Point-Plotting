package pointPlotting;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener{
	JFrame frame;
	
	JButton submit = new JButton("Submit");
	JButton restartButton = new JButton("Reset");
	
	JTextField xCoordinate = new JTextField("", 4);
	JTextField yCoordinate = new JTextField("", 4);
	
	JLabel xCoordinateLabel = new JLabel("X: ");
	JLabel yCoordinateLabel = new JLabel("Y: ");
	
	int frameHeight = 800;
    int frameWidth = 1530;
    
    ArrayList<Point> points = new ArrayList<Point>();
    Point yIntercept = new Point(0, 0);
    
    GraphPlot graphPlot;
	
	public void init() {
		points.add(yIntercept);
		
		frame = new JFrame("Point Plotting");
		JPanel mainPanel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				graphPlot.updateSize(getWidth() - 40, getHeight() - 25);
        	    graphPlot.updateWindowSize(getWidth(), getHeight());
        	    
        	    graphPlot.drawAxis(g);
        	    graphPlot.graphPoints(g);
			}		
		};
		
		JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints inputPanelConstarints = new GridBagConstraints();
        
        xCoordinateLabel.setForeground(Color.white);
        yCoordinateLabel.setForeground(Color.white);
        
        inputPanel.add(xCoordinateLabel);
        inputPanel.add(xCoordinate);
        inputPanel.add(yCoordinateLabel);
        inputPanel.add(yCoordinate);
        inputPanel.add(submit);
        inputPanel.add(restartButton);
		
		frame.add(inputPanel, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocationRelativeTo(null);
		
		mainPanel.setBackground(Color.DARK_GRAY);
		inputPanel.setBackground(Color.DARK_GRAY);
		
		graphPlot = new GraphPlot(
        		points, 20, 20, getWidth() - 40, getHeight() - 30, Color.RED, Color.WHITE
        		);
		
		submit.addActionListener(this);
		restartButton.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Main().init();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			double x = Double.parseDouble(xCoordinate.getText());
			double y = Double.parseDouble(yCoordinate.getText());
			
			points.add(new Point(x, y));
			frame.repaint();
		}
	}
}
