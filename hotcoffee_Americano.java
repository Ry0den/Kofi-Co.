package Kofi_Co;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import Kofi_Co_Customization.RoundedToggleButton;
import Kofi_Co_Fundamentals.RoundedButton;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class hotcoffee_Americano extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel headerPanel = new JPanel();
	private JPanel footerPanel = new JPanel();
	private JPanel contentPanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel addOnPanel = new JPanel();
	private JPanel sizePanel = new JPanel();
	private JPanel sugarPanel = new JPanel();
	private JPanel tempPanel = new JPanel();
	private JPanel syrupsPanel = new JPanel();
	private JPanel logoPanel = new JPanel();
	private JPanel drinkNamePanel = new JPanel();
	private JPanel drinkDescPanel = new JPanel();
	
	private JLabel arrow = new JLabel("<");
	private JLabel K_Co = new JLabel("K. Co");
	private JLabel title = new JLabel();
	private JLabel description = new JLabel();
	private JLabel costLabel;
	
	private JScrollPane scrollPane = new JScrollPane();
	
	private String selectedSize = "";
	private String selectedSugar = "";
	private String selectedTemp = "";
	private String selectedSyrup = "";
	private double totalPrice = 0.0;
	
	private Menu menuReference;
	private ArrayList<RoundedToggleButton[]> optionGroups = new ArrayList<>();
	private ArrayList<JLabel[]> priceLabel = new ArrayList<>();

	public hotcoffee_Americano() {
		initializeFrame();
		setupComponents();
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	private void initializeFrame() {
		frame.setTitle("Kofi Co.");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(700, 775));
	}

	private void setupComponents() {
		setupMainPanel();
		setupHeader();
		setupNamePanel();
		setupAddOnPanel();
		setupFooter();
	}

	private void setupMainPanel() {
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
		
		scrollPane.setViewportView(contentPanel);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(namePanel, BorderLayout.NORTH);
		contentPanel.add(addOnPanel, BorderLayout.CENTER);
	}

	private void setupHeader() {
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setPreferredSize(new Dimension(700, 70));
		headerPanel.setBackground(Color.WHITE);
		
		arrow.setForeground(Color.BLACK);
		arrow.setFont(new Font("Advent Pro", Font.PLAIN, 45));
		arrow.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		
		backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		backPanel.setOpaque(false);
		backPanel.add(arrow);
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		arrow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { frame.dispose(); }
			public void mouseEntered(MouseEvent e) { arrow.setForeground(Color.GRAY); }
			public void mouseExited(MouseEvent e) { arrow.setForeground(Color.BLACK); }
		});
		
		headerPanel.add(backPanel, BorderLayout.WEST);
	}

	private void setupNamePanel() {
		K_Co.setForeground(new Color(0x5e3219));
		K_Co.setFont(new Font("Gugi", Font.BOLD, 35));
		K_Co.setBorder(BorderFactory.createEmptyBorder(10, 50, 0, 0));
		
		title.setText("<html><p style='text-align: center;'>Americano</p></html>");
		title.setFont(new Font("Poppins SemiBold", Font.BOLD, 45));
		title.setBorder(BorderFactory.createEmptyBorder(-15, 0, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		description.setText("<html><p style='width: 450px; text-align: center;'>A classic espresso-based drink made with hot water, creating a rich and bold coffee experience.</p></html>");
		description.setFont(new Font("Roboto Flex Regular", Font.BOLD, 15));
		description.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		description.setHorizontalAlignment(SwingConstants.CENTER);
		
		logoPanel.setLayout(new BorderLayout());
		logoPanel.add(K_Co, BorderLayout.WEST);
		
		drinkNamePanel.setLayout(new BorderLayout());
		drinkNamePanel.add(title);
		
		drinkDescPanel.setLayout(new BorderLayout());
		drinkDescPanel.add(description);
		
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		namePanel.setBackground(new Color(0xFBFBFB));
		namePanel.add(logoPanel);
		namePanel.add(drinkNamePanel);
		namePanel.add(drinkDescPanel);
	}

	private void setupAddOnPanel() {
		addOnPanel.setLayout(new BoxLayout(addOnPanel, BoxLayout.Y_AXIS));
		setupSizeOptions();
		setupSugarOptions();
		setupMilkOptions();
		setupSyrupOptions();
		addOnPanel.setOpaque(false);
	}

	private void setupSizeOptions() {
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		sizePanel.add(createOptionHeader("Size: ", "Pick 1"));
		
		String[] sizes = {"Small", "Medium", "Large"};
		String[] prices = {"80.00", "90.00", "100.00"};
		String[] images = {"Small Cup.png", "Medium Cup.png", "Large Cup.png"};
		
		JPanel optionsPanel = createOptionsGrid(1, 3, 120, 40, 400, sizes, images, prices);
		sizePanel.add(optionsPanel);
		addOnPanel.add(sizePanel);
	}

	private void setupSugarOptions() {
		sugarPanel.setLayout(new BoxLayout(sugarPanel, BoxLayout.Y_AXIS));
		sugarPanel.add(createOptionHeader("Sugar: ", "Pick 1"));
		
		String[] options = {"Regular", "Decaf", "None"};
		JPanel optionsPanel = createOptionsGrid(1, 3, 120, 40, 400, options, null, null);
		sugarPanel.add(optionsPanel);
		addOnPanel.add(sugarPanel);
	}

	private void setupMilkOptions() {
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		tempPanel.add(createOptionHeader("Milk: ", "Pick 1"));
		
		String[] options = {"Whole Milk", "Non Fat Milk", "Half and Half"};
		JPanel optionsPanel = createOptionsGrid(1, 3, 150, 40, 500, options, null, null);
		tempPanel.add(optionsPanel);
		addOnPanel.add(tempPanel);
	}

	private void setupSyrupOptions() {
		syrupsPanel.setLayout(new BoxLayout(syrupsPanel, BoxLayout.Y_AXIS));
		syrupsPanel.add(createOptionHeader("Syrups: ", "Pick 1"));
		
		String[] options = {"Vanilla", "Caramel", "Hazelnut", "Salted Caramel"};
		String[] prices = {"10.00", "10.00", "10.00", "10.00"};
		JPanel optionsPanel = createOptionsGrid(2, 2, 150, 40, 500, options, null, prices);
		syrupsPanel.add(optionsPanel);
		addOnPanel.add(syrupsPanel);
	}

	private JPanel createOptionHeader(String option, String pick) {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		header.setBorder(new MatteBorder(1, 0, 0, 0, new Color(0xE8E8E8)));
		
		JLabel optionLabel = new JLabel(option);
		JLabel pickLabel = new JLabel(pick);
		
		optionLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		pickLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		
		optionLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 0));
		pickLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 50));
		
		header.add(optionLabel);
		header.add(Box.createHorizontalGlue());
		header.add(pickLabel);
		header.setOpaque(false);
		
		return header;
	}

	private JPanel createOptionsGrid(int rows, int cols, int buttonWidth, int buttonHeight, 
								   int panelWidth, String[] options, String[] images, String[] prices) {
		JPanel grid = new JPanel(new GridLayout(rows, cols, 10, 0));
		grid.setOpaque(false);
		grid.setMaximumSize(new Dimension(panelWidth, Integer.MAX_VALUE));
		
		ButtonGroup group = new ButtonGroup();
		RoundedToggleButton[] buttons = new RoundedToggleButton[options.length];
		JLabel[] priceLabels = new JLabel[options.length];
		
		for (int i = 0; i < options.length; i++) {
			JPanel wrapper = new JPanel();
			wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
			wrapper.setOpaque(false);
			
			if (images != null) {
				JLabel img = new JLabel(new ImageIcon(images[i]));
				img.setAlignmentX(Component.CENTER_ALIGNMENT);
				wrapper.add(img);
				wrapper.add(Box.createVerticalStrut(5));
			}
			
			RoundedToggleButton button = new RoundedToggleButton(buttonWidth, buttonHeight, options[i]);
			button.setFont(new Font("Poppins SemiBold", Font.PLAIN, 17));
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			if (prices != null && i < prices.length) {
				JLabel priceLabel = new JLabel("₱" + prices[i]);
				priceLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
				priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				wrapper.add(button);
				wrapper.add(Box.createVerticalStrut(5));
				wrapper.add(priceLabel);
				priceLabels[i] = priceLabel;
			} else {
				wrapper.add(button);
			}
			
			buttons[i] = button;
			group.add(button);
			grid.add(wrapper);
			
			final String option = options[i];
			final String price = prices != null && i < prices.length ? prices[i] : null;
			
			button.addActionListener(e -> {
				updateSelection(option, price);
				updatePrice();
			});
		}
		
		optionGroups.add(buttons);
		if (prices != null) {
			priceLabel.add(priceLabels);
		}
		
		return grid;
	}

	private void updateSelection(String option, String price) {
		if (Arrays.asList("Small", "Medium", "Large").contains(option)) {
			selectedSize = option;
		} else if (Arrays.asList("Regular", "Decaf", "None").contains(option)) {
			selectedSugar = option;
		} else if (Arrays.asList("Whole Milk", "Non Fat Milk", "Half and Half").contains(option)) {
			selectedTemp = option;
		} else if (Arrays.asList("Vanilla", "Caramel", "Hazelnut", "Salted Caramel").contains(option)) {
			selectedSyrup = option;
		}
	}

	private void updatePrice() {
		double price = 80.0;
		if (selectedSize.equals("Large")) price += 20.0;
		else if (selectedSize.equals("Medium")) price += 10.0;
		if (!selectedSyrup.isEmpty()) price += 10.0;
		
		totalPrice = price;
		if (costLabel != null) {
			costLabel.setText("P" + String.format("%.2f", totalPrice));
		}
	}

	private void setupFooter() {
		JLabel total = new JLabel("Total");
		JLabel cost = new JLabel("P0.00");
		JButton proceed = new RoundedButton();
		this.costLabel = cost;
		
		total.setFont(new Font("Poppins", Font.BOLD, 15));
		cost.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		
		proceed.setText("Proceed");
		proceed.setBackground(new Color(0x5e3219));
		proceed.setForeground(Color.WHITE);
		proceed.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		total.setBounds(342, 24, 100, 30);
		cost.setBounds(320, 45, 100, 30);
		proceed.setBounds(415, 23, 252, 55);
		
		proceed.addActionListener(e -> {
			StringBuilder orderName = new StringBuilder("Americano");
			if (!selectedSize.isEmpty()) orderName.append(" - ").append(selectedSize);
			if (!selectedSugar.isEmpty()) orderName.append(", ").append(selectedSugar);
			if (!selectedTemp.isEmpty()) orderName.append(", ").append(selectedTemp);
			if (!selectedSyrup.isEmpty()) orderName.append(", ").append(selectedSyrup);
			
			OrderManager.getInstance().addToOrder(orderName.toString(), "P" + String.format("%.2f", totalPrice));
			if (menuReference != null) {
				menuReference.updateTotal();
			}
			frame.dispose();
		});
		
		footerPanel.setLayout(null);
		footerPanel.setPreferredSize(new Dimension(700, 98));
		footerPanel.setBackground(new Color(0xFBFBFB));
		footerPanel.add(total);
		footerPanel.add(cost);
		footerPanel.add(proceed);
	}

	public void setMenuReference(Menu menu) {
		this.menuReference = menu;
	}
}
