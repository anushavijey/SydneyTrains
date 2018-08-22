

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SydneyTrainsSample {
	
	public static void main(String args[]) {
	// Create Chart
	final XYChart chart = new XYChartBuilder().width(600).height(400).title("Sydney Trains Offence Report").xAxisTitle("Number of PNs").yAxisTitle("Face Values").build();

	// Customize Chart
	chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

	// Series
	chart.addSeries("Parking Offence", new double[] { 72362, 91891, 98989}, new double[] { 8136122, 9297100, 9297200});
	chart.addSeries("Fare Evasion/ False Information", new double[] { 69705, 69705, 70890}, new double[] {1303900, 1303900, 1303900});
	chart.addSeries("Compliance Safety", new double[] { 25172, 32189, 32199}, new double[] {6652750, 7131850, 7131850});
	chart.addSeries("Vehicle Offence", new double[] { 652, 781, 781}, new double[] { 121359, 212132, 212345 });
	chart.addSeries("Feet on Seat", new double[] { 330, 617, 617 }, new double[] { 35000, 61700, 61700 });
	chart.addSeries("Smoking Offence", new double[] { 371, 450, 470 }, new double[] { 87500, 100250, 100250});
	chart.addSeries("Littering Offence", new double[] { 108, 167, 167 }, new double[] { 17860, 29150, 29150 });
	chart.addSeries("Animal Offence", new double[] { 91, 123, 123 }, new double[] { 22150, 25171, 25171 });

	
	// Schedule a job for the event-dispatching thread:
	// creating and showing this application's GUI.
	javax.swing.SwingUtilities.invokeLater(new Runnable() {

	  public void run() {

	    // Create and set up the window.
	    JFrame frame = new JFrame("Sydney Trains Service");
	    frame.setLayout(new BorderLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // chart
	    JPanel chartPanel = new XChartPanel<XYChart>(chart);
	    frame.add(chartPanel, BorderLayout.CENTER);

	    // label
//	    JLabel PNLabel = new JLabel("Number of PNs", SwingConstants.CENTER);
//	    JLabel faceLabel = new JLabel("Face Values", SwingConstants.CENTER);
//	    frame.add(PNLabel, BorderLayout.SOUTH);
//	    frame.add(faceLabel, BorderLayout.WEST);

	    // Display the window.
	    frame.pack();
	    frame.setVisible(true);
	  }
	});

}
}

