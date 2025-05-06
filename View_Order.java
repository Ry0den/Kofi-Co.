package Kofi_Co;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Kofi_Co_Fundamentals.RoundedButton;

import javax.swing.*;

public class View_Order extends JFrame {
	CardLayout cardLayout = new CardLayout();
	JPanel cardPanel = new JPanel(cardLayout);

	// Main Frame and Panels
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel headerPanel = new JPanel();
	JPanel footerPanel = new JPanel();
	JPanel contentPanel = new JPanel();

	// Header Sub Panel & Label
	JPanel backPanel = new JPanel();
	JLabel arrow = new JLabel();

	// Sub Panels inside contentPanel
	JPanel namePanel = new JPanel();
	JPanel upperPanel = new JPanel(new BorderLayout());
	JPanel logoPanel = new JPanel(new BorderLayout());
	JLabel logoLabel = new JLabel("K.Co");
	
	JPanel myOrderPanel = new JPanel(new BorderLayout());
	JLabel myOrderLabel = new JLabel();
	JPanel myOrderPanel2 = new JPanel(new BorderLayout());
	JLabel myOrderLabel2 = new JLabel();
	
	// Label
	JLabel K_Co = new JLabel();
	JLabel title = new JLabel();
	JLabel description = new JLabel();

	JScrollPane scrollPane = new JScrollPane();

	public void mainFrame() {
		frame.setTitle("Kofi Co.");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(700, 775));
	}

	public void setupHeaderPanel() {

		arrow.setText("<");
		arrow.setForeground(Color.BLACK);
		arrow.setFont(new Font("Advent Pro", Font.PLAIN, 45));
		arrow.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

		backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		backPanel.setOpaque(false);

		MouseAdapter goBack = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Menu");
			}

			public void mouseEntered(MouseEvent e) {
				arrow.setForeground(Color.GRAY);
			}

			public void mouseExited(MouseEvent e) {
				arrow.setForeground(Color.BLACK);
			}
		};

		arrow.addMouseListener(goBack);

		backPanel.add(arrow);
		backPanel.add(Box.createRigidArea(new Dimension(-5, 0)));

		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	}

	public void BottomHeader() {

		JLabel total = new JLabel();
		JLabel cost = new JLabel();
		JButton buynow = new RoundedButton();

		total.setText("Total");
		total.setFont(new Font("Poppins", Font.BOLD, 15));
		total.setBounds(342, 24, 100, 30);
		footerPanel.add(total);

		cost.setText("P00.00");
		cost.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
		cost.setBounds(320, 45, 100, 30);
		footerPanel.add(cost);

		buynow.setBorderPainted(false);
		buynow.setBackground(new Color(0x5e3219));
		buynow.setText("Buy Now");
		buynow.setForeground(Color.WHITE);
		buynow.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		buynow.setBounds(415, 23, 237, 55);
		footerPanel.add(buynow);
	}

	public void upper() {
	    logoLabel.setFont(new Font("Gugi", Font.BOLD, 110));
	    logoLabel.setForeground(new Color(0x5e3219));
	    logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    logoLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, -10, 0)); 
	    logoPanel.add(logoLabel);

	    myOrderLabel.setText("My"); 
	    myOrderLabel.setFont(new Font("Poppins SemiBold", Font.BOLD, 40));
	    myOrderLabel.setForeground(Color.black);
	    myOrderLabel.setBorder(BorderFactory.createEmptyBorder(0, 80, -10, 0)); 
	    myOrderPanel.add(myOrderLabel, BorderLayout.CENTER);

	    myOrderLabel2.setText("Order");
	    myOrderLabel2.setFont(new Font("Poppins SemiBold", Font.BOLD, 40));
	    myOrderLabel2.setForeground(Color.black);
	    myOrderLabel2.setBorder(BorderFactory.createEmptyBorder(-10, 80, 0, 0));
	    myOrderPanel2.add(myOrderLabel2, BorderLayout.CENTER);

	    upperPanel.add(logoPanel, BorderLayout.NORTH);
	    upperPanel.add(myOrderPanel, BorderLayout.CENTER);
	    upperPanel.add(myOrderPanel2, BorderLayout.SOUTH);

	    namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
	    namePanel.add(upperPanel);

	    
	    logoPanel.setOpaque(false);
	    myOrderPanel.setOpaque(false);
	    myOrderPanel2.setOpaque(false);
	    upperPanel.setOpaque(false);
	    namePanel.setOpaque(false);
	}


	public void CardLayout() {
		setupHeaderPanel();
		BottomHeader();
		upper();

		// Main Panel
		mainPanel.setLayout(new BorderLayout());

		// Header
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setPreferredSize(new Dimension(700, 70));
		headerPanel.setBackground(new Color(0xFBFBFB)); // Visual lang

		headerPanel.add(backPanel, BorderLayout.WEST);

		// Content Panels (Add to the Component)
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.white); // Visual lang

		// Footer
		footerPanel.setLayout(new BorderLayout());
		footerPanel.setPreferredSize(new Dimension(700, 98));
		footerPanel.setBackground(new Color(0xFBFBFB));

		// Addition to Content Panel
		contentPanel.add(namePanel, BorderLayout.NORTH);

		// contentPanel.add(upperPanel, BorderLayout.CENTER);

		// Scroll Pane
		scrollPane.setViewportView(contentPanel);
		scrollPane.setBorder(null);

		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setOpaque(false);

		// Compilation of Main Panel
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);

		cardPanel.add(mainPanel, "ViewOrder");
	}

	public JPanel getViewOrderPanel() {
		return mainPanel;
	}

	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
	}
}
