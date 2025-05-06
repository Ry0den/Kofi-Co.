package Kofi_Co;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import Kofi_Co_Customization.RoundedToggleButton;
import Kofi_Co_Fundamentals.RoundedButton;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class hotcoffee_Americano extends JFrame {
	
	// Drink name and description
	String name;
	String desc;

	// Main Frame and Panels
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel headerPanel = new JPanel();
	JPanel footerPanel = new JPanel();
	JPanel contentPanel = new JPanel();

	// Header Sub Panel & Label
	JPanel backPanel = new JPanel();
	JLabel back = new JLabel();
	JLabel arrow = new JLabel();

	// Sub Panels inside contentPanel
	JPanel namePanel = new JPanel();
	JPanel addOnPanel = new JPanel();
	JPanel sizePanel = new JPanel();
	JPanel sugarPanel = new JPanel();
	JPanel tempPanel = new JPanel();
	JPanel toppingPanel = new JPanel();
	JPanel syrupsPanel = new JPanel();

	// Sub Panels inside of Name Panel
	JPanel logoPanel = new JPanel();
	JPanel drinkNamePanel = new JPanel();
	JPanel drinkDescPanel = new JPanel();

	// Label
	JLabel K_Co = new JLabel(); 
	JLabel title = new JLabel();
	JLabel description = new JLabel();

	// Scroll Pane
	JScrollPane scrollPane = new JScrollPane();

	
	public hotcoffee_Americano() {
		mainFrame();
		mainPanel();
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	// -----------------------------------
	// Main Frame Setup
	// -----------------------------------
	public void mainFrame() {
		frame.setTitle("Kofi Co.");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(700, 775));
	}

	// -----------------------------------
	// Main Panel Setup
	// -----------------------------------
	public void mainPanel() {
		setupHeaderPanel();
		BottomHeader(); 
		setupNamePanel();
		setupAddOnPanel();

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
		contentPanel.add(addOnPanel, BorderLayout.CENTER);

		// Scroll Pane
		scrollPane.setViewportView(contentPanel);
		scrollPane.setBorder(null);

		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Compilation of Main Panel
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
	}

	// -----------------------------------
	// Header Panel Setup.
	// -----------------------------------
	public void setupHeaderPanel() {

		arrow.setText("<");
		arrow.setForeground(Color.BLACK);
		arrow.setFont(new Font("Advent Pro", Font.PLAIN, 45));
		arrow.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

		backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		backPanel.setOpaque(false);
		
		MouseAdapter goBack = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}

			public void mouseEntered(MouseEvent e) {
				back.setForeground(Color.GRAY);
				arrow.setForeground(Color.GRAY);
			}

			public void mouseExited(MouseEvent e) {
				back.setForeground(Color.BLACK);
				arrow.setForeground(Color.BLACK);
			}
		};

		arrow.addMouseListener(goBack);
		back.addMouseListener(goBack);

		backPanel.add(arrow);
		backPanel.add(Box.createRigidArea(new Dimension(-5, 0)));
		backPanel.add(back);

		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	}
	public void BottomHeader() {

		JLabel total = new JLabel();
		JLabel cost = new JLabel();
		JButton vieworder = new RoundedButton();
		JButton buynow = new RoundedButton();

		total.setText("Total");
		total.setFont(new Font("Poppins", Font.BOLD, 15));
		total.setBounds(342, 24, 100, 30);
		footerPanel.add(total);

		cost.setText("P00.00");
		cost.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
		cost.setBounds(320, 45, 100, 30);
		footerPanel.add(cost);

		vieworder.setBorderPainted(false);
		vieworder.setBackground(new Color(0x5e3219));
		vieworder.setText("<html><center>View<br>Order<html>");
		vieworder.setForeground(Color.WHITE);
		vieworder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		vieworder.setBounds(415, 23, 85, 55);

		buynow.setBorderPainted(false);
		buynow.setBackground(new Color(0x5e3219));
		buynow.setText("Proceed");
		buynow.setForeground(Color.WHITE);
		buynow.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		buynow.setBounds(415, 23, 252, 55);
		footerPanel.add(buynow);

	}
	// -----------------------------------
	// Name Panel Setup.
	// -----------------------------------
	public void setupNamePanel() {
		setupDescription();

		K_Co.setText("K. Co");
		K_Co.setForeground(new Color(0x5e3219));
		K_Co.setFont(new Font("Gugi", Font.BOLD, 35));
		K_Co.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 0));

		logoPanel.setLayout(new BorderLayout());
		logoPanel.add(K_Co, BorderLayout.WEST);
		logoPanel.setOpaque(false);

		title.setText(name);
		title.setFont(new Font("Poppins SemiBold", Font.BOLD, 45));
		title.setForeground(Color.BLACK);
		title.setBorder(BorderFactory.createEmptyBorder(-15, 0, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		drinkNamePanel.setLayout(new BorderLayout());
		drinkNamePanel.add(title);
		drinkNamePanel.setOpaque(false);

		description.setText(desc);
		description.setFont(new Font("Roboto Flex Regular", Font.BOLD, 15));
		description.setForeground(Color.BLACK);
		description.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		description.setHorizontalAlignment(SwingConstants.CENTER);

		drinkDescPanel.setLayout(new BorderLayout());
		//drinkDescPanel.setBackground(Color.ORANGE);
		drinkDescPanel.add(description);
		drinkDescPanel.setOpaque(false);


		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		namePanel.setBackground(new Color(0xFBFBFB));
		namePanel.add(logoPanel, BorderLayout.NORTH);
		namePanel.add(drinkNamePanel, BorderLayout.CENTER);
		namePanel.add(drinkDescPanel, BorderLayout.SOUTH);
	}

	// -----------------------------------
	// Add-On Panel Setup
	// -----------------------------------
	public void setupAddOnPanel() {
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		sizePanel.add(optionHeaderPanel("Drink Size: ", "Pick 1"));
		
		JPanel sizeOptPanel = new JPanel();
		sizeOptPanel.setLayout(new BoxLayout(sizeOptPanel, BoxLayout.Y_AXIS));
		
		String [] sizeIMG = {"D:\\Kitsu\\Documents\\eclipse-workspace\\Freshmen\\practice\\src\\Kofi_Co\\Small Cup.png",
									"D:\\Kitsu\\Documents\\eclipse-workspace\\Freshmen\\practice\\src\\Kofi_Co\\Medium Cup.png",
									"D:\\Kitsu\\Documents\\eclipse-workspace\\Freshmen\\practice\\src\\Kofi_Co\\Large Cup.png"
								};
		String [] sizeOption = {"Small", "Medium", "Large"};
		String [] sizePrice = {"00.00", "00.00", "00.00"};
		
		sizeOptPanel.add(setupOptionsPanel(1, 3,  120, 40, 400, 3, sizeIMG, sizeOption, sizePrice));
		// ----------------------------------------------------------------

		// Setup Sugar Panel
		sugarPanel.setLayout(new BoxLayout(sugarPanel, BoxLayout.Y_AXIS));
		sugarPanel.add(optionHeaderPanel("Sugar Level: ", "Pick 1"));

		// Button Panel
		JPanel sugarOptPanel = new JPanel();
		sugarOptPanel.setLayout(new BoxLayout(sugarOptPanel, BoxLayout.Y_AXIS));
		
		String [] sugarIMG = {"", "", "", ""};
		String [] sugarOption = {"25%", "50%", "75%", "100%"};
		String [] sugarPrice = {"", "", "", ""};

		sugarOptPanel.add(setupOptionsPanel(1, 3, 120, 40, 400, 4, sugarIMG, sugarOption, sugarPrice));
		// ----------------------------------------------------------------

		// Setup TempPanel
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		tempPanel.add(optionHeaderPanel("Temperature: ", "Pick 1"));


		// Button Panel
		JPanel tempOptPanel = new JPanel();
		tempOptPanel.setLayout(new BoxLayout(tempOptPanel, BoxLayout.Y_AXIS));
		
		String [] tempIMG = {"", "",};
		String [] tempOption = {"Hot", "Ice"};
		String [] tempPrice = {"", ""};
		
		tempOptPanel.add(setupOptionsPanel(1, 3, 120, 40, 150, 2, tempIMG, tempOption, tempPrice));
		// ----------------------------------------------------------------

		// Setup toppingPanel
		toppingPanel.setLayout(new BoxLayout(toppingPanel, BoxLayout.Y_AXIS));
		toppingPanel.add(optionHeaderPanel("Toppings: ", "Pick 1"));

		// Button
		JPanel toppingOptPanel = new JPanel();
		toppingOptPanel.setLayout(new BoxLayout(toppingOptPanel, BoxLayout.Y_AXIS));
		
		String [] toppingIMG = {"", "", "", "", "", ""};
		String [] toppingOption = {"Crushed Oreo", "Whipped Cream" , "Chocolate Chip" , 
								"   Stick O   ", "", "" };
		String [] toppingPrice = {"00.00", "00.00", "00.00", "00.00", "", "", ""};
		
		toppingOptPanel.add(setupOptionsPanel(2, 3,  160, 40, 500, 6, toppingIMG, toppingOption, toppingPrice));
		// ----------------------------------------------------------------

		// Setup syrupsPanel
		syrupsPanel.setLayout(new BoxLayout(syrupsPanel, BoxLayout.Y_AXIS));
		syrupsPanel.add(optionHeaderPanel("Syrups: ", "Pick 1"));

		// Button
		JPanel syrupsOptPanel = new JPanel();
		syrupsOptPanel.setLayout(new BoxLayout(syrupsOptPanel, BoxLayout.Y_AXIS));
		
		String [] syrupIMG = {"", "", "", "", "", ""};
		String [] syrupsOption = {"Vanilla", "Caramel" , "Hazelnut" , 
								"Salted Caramel", "Chocolate", "" };
		String [] syrupsPrice = {"00.00", "00.00", "00.00", "00.00", "00.00", "", ""};
		
		syrupsOptPanel.add(setupOptionsPanel(2, 3,  150, 40, 500, 6, syrupIMG, syrupsOption, syrupsPrice));
		// ----------------------------------------------------------------

		// Add On Panel
		addOnPanel.setLayout(new BoxLayout(addOnPanel, BoxLayout.Y_AXIS));

		addOnPanel.add(sizePanel);//header
		addOnPanel.add(sizeOptPanel);//option
		
		addOnPanel.add(sugarPanel);
		addOnPanel.add(sugarOptPanel);

		addOnPanel.add(tempPanel);
		addOnPanel.add(tempOptPanel);

		addOnPanel.add(toppingPanel);
		addOnPanel.add(toppingOptPanel);

		addOnPanel.add(syrupsPanel);
		addOnPanel.add(syrupsOptPanel);

		sizePanel.setOpaque(false);
		sizeOptPanel.setOpaque(false);
		sugarPanel.setOpaque(false);
		sugarOptPanel.setOpaque(false);
		tempPanel.setOpaque(false);
		tempOptPanel.setOpaque(false);
		toppingPanel.setOpaque(false);
		toppingOptPanel.setOpaque(false);
		syrupsPanel.setOpaque(false);
		syrupsOptPanel.setOpaque(false);
		addOnPanel.setOpaque(false);

	}
	public ArrayList<RoundedToggleButton[]> optionGroups = new ArrayList<>(); 	
	public ArrayList<JLabel[]> priceLabel = new ArrayList<>(); 	

	int labelIndex = 0; //Counting of the Array

	// -----------------------------------
	// Drink Options Setup
	// -----------------------------------
	public JPanel setupOptionsPanel(int row, int col, int w, int h, int width, int count, String[] pic, String[] bLabel, String[] sizePrice) {
	    Font bFont = new Font("Poppins SemiBold", Font.PLAIN, 17);
	    Font pFont = new Font("Open Sans", Font.PLAIN, 14);

	    RoundedToggleButton[] groupB = new RoundedToggleButton[count];
	    JLabel[] groupL = new JLabel[count];

	    JPanel gridPanel = new JPanel(new GridLayout(row, col, 10, 0));
	    gridPanel.setOpaque(false);
	    gridPanel.setMaximumSize(new Dimension(width, Integer.MAX_VALUE));

	    ButtonGroup groupBtn = new ButtonGroup(); 
	    
	    for (int i = 0; i < count; i++) {
	        JPanel wrapperPanel = new JPanel();
	        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
	        wrapperPanel.setOpaque(false);

	        String labelB = bLabel[i];
	        String labelP = sizePrice[i];
	        String picIm = pic[i];

	        ImageIcon image = new ImageIcon(picIm);
	        JLabel img = new JLabel(image);

	        JLabel price = new JLabel();


	        RoundedToggleButton button = new RoundedToggleButton(w, h, labelB);
	        button.setFont(bFont);
	        price.setFont(pFont);

	        img.setAlignmentX(Component.CENTER_ALIGNMENT);
	        button.setAlignmentX(Component.CENTER_ALIGNMENT);
	        price.setAlignmentX(Component.CENTER_ALIGNMENT);
	        
	        boolean hasLabelB = labelB != null && !labelB.trim().isEmpty();
	        boolean hasLabelP = labelP != null && !labelP.trim().isEmpty();

	        if (hasLabelP) {
	            price.setText("₱" + labelP);
	        }
	        else {
	        	price.setVisible(false);
	        }

	        if (!hasLabelB) {
	            button.setVisible(false);
	            img.setVisible(false);
	        } else {
	            groupBtn.add(button);
	        }

	        // Add to Wrapper Panel
	        wrapperPanel.add(img);
	        wrapperPanel.add(Box.createVerticalStrut(5));
	        wrapperPanel.add(button);
	        wrapperPanel.add(Box.createVerticalStrut(5));
	        wrapperPanel.add(price);

	        gridPanel.add(wrapperPanel);

	        groupB[i] = button;
	        groupL[i] = price;
	    }

	    optionGroups.add(groupB);
	    priceLabel.add(groupL);

	    return gridPanel;
	}
		
	// -----------------------------------
	// Drink Description
	// -----------------------------------
	public void setupDescription() {
		name = "<html><p style='text-align: center;'>Coffee Name</p></html>";
		desc = "<html><p style='width: 450px; text-align: center;'>Lorem ipsum dolor sit amet, consectetur "
				+ "adipiscing elit, sed do eiusmod tempor incididunt ut laboLorem ipsum dolor sit amet, "
				+ "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut laboLorem ipsum dolor "
				+ "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat "
				+ "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p></html>";
	}

	// -----------------------------------
	// Header Panel For Option
	// -----------------------------------
	public JPanel optionHeaderPanel(String option, String pick) {
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		headerPanel.setBorder(new MatteBorder(1, 0, 0, 0, new Color(0xE8E8E8)));

		JLabel optionLabel = new JLabel(option);
		optionLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		optionLabel.setForeground(Color.black);
		optionLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 0));

		JLabel pickLabel = new JLabel(pick);
		pickLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		pickLabel.setForeground(Color.black);
		pickLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 50));

		headerPanel.add(optionLabel);
		headerPanel.add(Box.createHorizontalGlue());
		headerPanel.setOpaque(false);
		headerPanel.add(pickLabel);

		return headerPanel;
	}
	
	// -----------------------------------
	// Main Method
	// -----------------------------------
	public static void main(String[] args) {
		new hotcoffee_Americano();
	}
}
