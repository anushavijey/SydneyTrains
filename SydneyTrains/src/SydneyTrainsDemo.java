
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.internal.chartpart.Chart;

/** Class containing all XChart example charts */
public class SydneyTrainsDemo extends JPanel implements TreeSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The main split frame */
	private final JSplitPane splitPane;

	/** The tree */
	private final JTree tree;

	/** The panel for chart */
	protected XChartPanel<Chart<?, ?>> chartPanel;

	Timer timer = new Timer();

	/** Constructor */
	public SydneyTrainsDemo() {

		super(new GridLayout(1, 0));

		// Create the nodes.
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Sydney Trains Offence Report Charts");
		createNodes(top);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);

		// Create the scroll pane and add the tree to it.
		JScrollPane treeView = new JScrollPane(tree);

		// Create Chart Panel
		chartPanel = new XChartPanel<Chart<?, ?>>(new PieChart07().getChart());

		// Add the scroll panes to a split pane.
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(chartPanel);

		Dimension minimumSize = new Dimension(130, 160);
		treeView.setMinimumSize(minimumSize);
		splitPane.setPreferredSize(new Dimension(700, 700));

		// Add the split pane to this panel.
		add(splitPane);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		if (node == null) {
			return;
		}

		Object nodeInfo = node.getUserObject();
		// tree leaf
		if (node.isLeaf()) {
			ChartInfo chartInfo = (ChartInfo) nodeInfo;
			// displayURL(chartInfo.bookURL);
			chartPanel = new XChartPanel<Chart<?, ?>>(chartInfo.getExampleChart());
			splitPane.setBottomComponent(chartPanel);

			// start running a simulated data feed for the sample real-time plot
			timer.cancel(); // just in case

		}
	}

	/**
	 * Create the tree
	 *
	 * @param top
	 */
	private void createNodes(DefaultMutableTreeNode top) {

		// categories
		DefaultMutableTreeNode category;
		// leaves
		DefaultMutableTreeNode defaultMutableTreeNode;

		// Area
		category = new DefaultMutableTreeNode("Offence Charts");
		top.add(category);
		
		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Total Offence Category Number of PNs", new PieChart07().getChart()));
		category.add(defaultMutableTreeNode);
		
		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Total Offence Category Face Values", new PieChart08().getChart()));
		category.add(defaultMutableTreeNode);

		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Year 2013 Offence Category Number of PNs", new PieChart01().getChart()));
		category.add(defaultMutableTreeNode);

		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Year 2014 Offence Category Number of PNs", new PieChart02().getChart()));
		category.add(defaultMutableTreeNode);

		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Year 2013 Offence Category Face Values", new PieChart05().getChart()));
		category.add(defaultMutableTreeNode);

		defaultMutableTreeNode = new DefaultMutableTreeNode(
				new ChartInfo("Year 2014 Offence Category Face Values", new PieChart06().getChart()));
		category.add(defaultMutableTreeNode);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI() {

		// Create and set up the window.
		JFrame frame = new JFrame("Sydney Trains");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new SydneyTrainsDemo());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				createAndShowGUI();
			}
		});
	}
}
