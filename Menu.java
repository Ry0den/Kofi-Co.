package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.ImportedFonts;
import Kofi_Co_Fundamentals.RoundedButton;
import java.util.ArrayList;

public class Menu {

	ImageIcon Cup = new ImageIcon("Large Cup.png");

	CardLayout categoryselectioncard = new CardLayout();
	CardLayout cardLayout = new CardLayout();

	JPanel cardPanel = new JPanel(cardLayout);
	JPanel MainPanel = new JPanel();
	JPanel MenuCategoryPanel = new JPanel();
	JPanel drinkselectiontrspanel = new JPanel();
	JPanel MainDrinkSelectionPopular = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionCoffee = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionFrappucino = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionHotNonCoffee = MainDrinkSelectionComps();
	JPanel MainDrinkSelectionColdNonCoffee = MainDrinkSelectionComps();
	JPanel BottomHeaderPanel = new JPanel();

	JButton CoffeeSelectionPopular = CoffeeTypesListComps();
	JButton CoffeeSelectionCoffee = CoffeeTypesListComps();
	JButton CoffeeSelectionFrappucinos = CoffeeTypesListComps();
	JButton CoffeeSelectionHotNonCoffee = CoffeeTypesListComps();
	JButton CoffeeSelectionColdNonCoffee = CoffeeTypesListComps();

	ImportedFonts IMPFonts = new ImportedFonts();

	private JLabel menuCostLabel;

	private JButton CoffeeTypesListComps() {
		JButton btn2 = new JButton();
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.setFocusable(false);
		btn2.setFont(new Font("Poppins SemiBold", Font.BOLD, 17));
		btn2.setVerticalTextPosition(JLabel.BOTTOM);
		btn2.setHorizontalTextPosition(JLabel.CENTER);
		btn2.setIconTextGap(-12);
		return btn2;
	}

	private JPanel MainDrinkSelectionComps() {
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		pnl.setLayout(null);
		return pnl;
	}

	private JButton DrinkSelectionComps(String text) {
		JButton btn = new JButton(text, Cup);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setFont(new Font("Poppins Regular", Font.PLAIN, 15));
		btn.setVerticalTextPosition(JLabel.BOTTOM);
		btn.setHorizontalTextPosition(JLabel.CENTER);
		btn.setIconTextGap(-12);
		return btn;
	}

	public void CoffeeTypesList() {

		JLabel KoficoLabel = new JLabel();

		MenuCategoryPanel.setBackground(new Color(0xFBFBFB));
		MenuCategoryPanel.setBounds(0, 0, 200, 775);
		MenuCategoryPanel.setLayout(null);

		KoficoLabel.setText("K. Co");
		KoficoLabel.setForeground(new Color(0x5e3219));
		KoficoLabel.setFont(new Font("Gugi", Font.PLAIN, 55));
		KoficoLabel.setBounds(30, 30, 140, 70);
		MenuCategoryPanel.add(KoficoLabel);

		CoffeeSelectionPopular.setText("Popular");
		CoffeeSelectionPopular.setIcon(Cup);
		CoffeeSelectionPopular.setBounds(0, 150, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionPopular);

		CoffeeSelectionCoffee.setText("Coffee");
		CoffeeSelectionCoffee.setIcon(Cup);
		CoffeeSelectionCoffee.setBounds(0, 280, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionCoffee);

		CoffeeSelectionFrappucinos.setText("Frappucinos");
		CoffeeSelectionFrappucinos.setIcon(Cup);
		CoffeeSelectionFrappucinos.setBounds(0, 410, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionFrappucinos);

		CoffeeSelectionHotNonCoffee.setText("Hot Non-Coffee");
		CoffeeSelectionHotNonCoffee.setIcon(Cup);
		CoffeeSelectionHotNonCoffee.setBounds(0, 540, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionHotNonCoffee);

		CoffeeSelectionColdNonCoffee.setText("Cold Non-Coffee");
		CoffeeSelectionColdNonCoffee.setIcon(Cup);
		CoffeeSelectionColdNonCoffee.setBounds(0, 670, 200, 130);
		MenuCategoryPanel.add(CoffeeSelectionColdNonCoffee);

		MenuCategoryPanel.setPreferredSize(new Dimension(200, 850));

	}

	public void Coffee() {

		JLabel coffeelabel = new JLabel();
		JButton americano = DrinkSelectionComps("Americano");
		JButton espresso = DrinkSelectionComps("Espresso");
		JButton cappucino = DrinkSelectionComps("Cappucino");

		coffeelabel.setText("Coffee");
		coffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		coffeelabel.setBounds(25, 125, 160, 80);
		MainDrinkSelectionCoffee.add(coffeelabel);

		americano.setBounds(35, 200, 120, 120);
		americano.addActionListener(e -> {
			hotcoffee_Americano americanoCustomization = new hotcoffee_Americano();
			americanoCustomization.setMenuReference(this);
			americanoCustomization.mainFrame();
			americanoCustomization.frame.pack();
			americanoCustomization.frame.setVisible(true);
		});
		MainDrinkSelectionCoffee.add(americano);

		cappucino.setBounds(180, 200, 120, 120);
		MainDrinkSelectionCoffee.add(cappucino);

		espresso.setBounds(325, 200, 120, 120);
		espresso.addActionListener(e -> {
			hotcoffee_Espresso espressoCustomization = new hotcoffee_Espresso();
			espressoCustomization.setMenuReference(this);
			espressoCustomization.mainFrame();
			espressoCustomization.frame.pack();
			espressoCustomization.frame.setVisible(true);
		});
		MainDrinkSelectionCoffee.add(espresso);

	}

	public void Frappucinos() {

		JLabel frappucinolabel = new JLabel();
		JButton saltedcaramelfrappucino = DrinkSelectionComps("<html><center>Salted<br>Caramel<html>");
		JButton matchafrappucino = DrinkSelectionComps("Matcha");
		JButton darkmochachipfrappe = DrinkSelectionComps("<html><center>Dark Mocha<br>Chip<html>");

		frappucinolabel.setText("Frappucinos");
		frappucinolabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		frappucinolabel.setBounds(25, 125, 280, 80);
		MainDrinkSelectionFrappucino.add(frappucinolabel);

		saltedcaramelfrappucino.setBounds(35, 200, 120, 136);
		MainDrinkSelectionFrappucino.add(saltedcaramelfrappucino);

		matchafrappucino.setBounds(180, 200, 120, 120);
		MainDrinkSelectionFrappucino.add(matchafrappucino);

		darkmochachipfrappe.setBounds(325, 200, 125, 136);
		MainDrinkSelectionFrappucino.add(darkmochachipfrappe);

	}

	public void Hot_Non_Coffee() {

		JLabel hotnoncoffeelabel = new JLabel();
		JButton hotchocolate = DrinkSelectionComps("<html><center>Hot<br>Chocolate<html>");
		JButton chaitea = DrinkSelectionComps("Chai Tea");
		JButton londonfog = DrinkSelectionComps("London Fog");

		hotnoncoffeelabel.setText("Hot Non - Coffee");
		hotnoncoffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		hotnoncoffeelabel.setBounds(25, 125, 400, 80);
		MainDrinkSelectionHotNonCoffee.add(hotnoncoffeelabel);

		hotchocolate.setBounds(35, 200, 120, 136);
		MainDrinkSelectionHotNonCoffee.add(hotchocolate);

		chaitea.setBounds(180, 200, 120, 120);
		MainDrinkSelectionHotNonCoffee.add(chaitea);

		londonfog.setBounds(325, 200, 122, 120);
		MainDrinkSelectionHotNonCoffee.add(londonfog);

	}

	public void Cold_Non_Coffee() {

		JLabel coldnoncoffeelabel = new JLabel();
		JButton saltedcaramelmacha = DrinkSelectionComps("<html><center>Caramel<br>Matcha<html>");
		JButton greentea = DrinkSelectionComps("Green Tea");
		JButton machalatte = DrinkSelectionComps("Macha Latte");

		coldnoncoffeelabel.setText("Cold Non - Coffee");
		coldnoncoffeelabel.setFont(new Font("Poppins Bold", Font.PLAIN, 40));
		coldnoncoffeelabel.setBounds(25, 125, 400, 80);
		MainDrinkSelectionColdNonCoffee.add(coldnoncoffeelabel);

		saltedcaramelmacha.setBounds(35, 200, 120, 136);
		MainDrinkSelectionColdNonCoffee.add(saltedcaramelmacha);

		greentea.setBounds(180, 200, 120, 120);
		MainDrinkSelectionColdNonCoffee.add(greentea);

		machalatte.setBounds(325, 200, 125, 120);
		MainDrinkSelectionColdNonCoffee.add(machalatte);

	}

	public void BottomHeader() {

		JLabel total = new JLabel();
		JLabel cost = new JLabel();
		this.menuCostLabel = cost;
		JButton vieworder = new RoundedButton();
		JButton buynow = new RoundedButton();

		BottomHeaderPanel.setBackground(new Color(0xFBFBFB));
		BottomHeaderPanel.setBounds(0, 640, 700, 200);
		BottomHeaderPanel.setLayout(null);

		total.setText("Total");
		total.setFont(new Font("Poppins", Font.BOLD, 15));
		total.setBounds(342, 24, 100, 30);
		BottomHeaderPanel.add(total);

		cost.setText("P0.00");
		cost.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		cost.setBounds(320, 45, 100, 30);
		BottomHeaderPanel.add(cost);

		vieworder.setBorderPainted(false);
		vieworder.setBackground(new Color(0x5e3219));
		vieworder.setText("<html><center>View<br>Order<html>");
		vieworder.setForeground(Color.WHITE);
		vieworder.setFont(new Font("Arial", Font.BOLD, 15));
		vieworder.setBounds(415, 23, 85, 55);
		BottomHeaderPanel.add(vieworder);

		buynow.setBorderPainted(false);
		buynow.setBackground(new Color(0x5e3219));
		buynow.setText("Buy Now");
		buynow.setForeground(Color.WHITE);
		buynow.setFont(new Font("Arial", Font.BOLD, 15));
		buynow.setBounds(512, 23, 140, 55);
		BottomHeaderPanel.add(buynow);

		vieworder.addActionListener(e -> {
			cardLayout.show(cardPanel, "ViewOrder");
			cardPanel.validate();
			cardPanel.repaint();
			for (java.awt.event.ComponentListener listener : cardPanel.getComponentListeners()) {
				listener.componentShown(new java.awt.event.ComponentEvent(cardPanel, java.awt.event.ComponentEvent.COMPONENT_SHOWN));
			}
		});
		buynow.addActionListener(e -> cardLayout.show(cardPanel, "Payment Options"));

		MainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent e) {
				updateTotal();
			}
		});

	}

	public void updateTotal() {
		if (menuCostLabel != null) {
			double total = 0.0;
			ArrayList<OrderItem> orders = OrderManager.getInstance().getCurrentOrder();
			
			for (OrderItem item : orders) {
				String priceStr = item.price.replace("P", "").trim();
				try {
					total += Double.parseDouble(priceStr);
				} catch (NumberFormatException e) {
					System.out.println("Error parsing price: " + item.price);
				}
			}
			
			menuCostLabel.setText("P" + String.format("%.2f", total));
		}
	}

	public void CardLayout() {

		CoffeeTypesList();
		Coffee();
		Frappucinos();
		Hot_Non_Coffee();
		Cold_Non_Coffee();
		BottomHeader();

		MainPanel.setLayout(null);
		MainPanel.setBounds(0, 0, 700, 775);

		JScrollPane scrollmenu = new JScrollPane(MenuCategoryPanel);
		scrollmenu.setBounds(0, 0, 200, 775);
		scrollmenu.setBorder(null);
		scrollmenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollmenu.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scrollmenu.getVerticalScrollBar().setUnitIncrement(10);
		MainPanel.add(scrollmenu);

		drinkselectiontrspanel.setLayout(categoryselectioncard);
		drinkselectiontrspanel.setBounds(200, 0, 500, 640);
		drinkselectiontrspanel.setBackground(Color.WHITE);

		drinkselectiontrspanel.add(MainDrinkSelectionPopular, "Popular");
		drinkselectiontrspanel.add(MainDrinkSelectionCoffee, "Coffee");
		drinkselectiontrspanel.add(MainDrinkSelectionFrappucino, "Frappucinos");
		drinkselectiontrspanel.add(MainDrinkSelectionHotNonCoffee, "Hot Non - Coffee");
		drinkselectiontrspanel.add(MainDrinkSelectionColdNonCoffee, "Cold Non - Coffee");

		MainPanel.add(drinkselectiontrspanel);
		MainPanel.add(BottomHeaderPanel);

		CoffeeSelectionPopular.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Popular"));
		CoffeeSelectionCoffee.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Coffee"));
		CoffeeSelectionFrappucinos.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Frappucinos"));
		CoffeeSelectionHotNonCoffee.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Hot Non - Coffee"));
		CoffeeSelectionColdNonCoffee.addActionListener(e -> categoryselectioncard.show(drinkselectiontrspanel, "Cold Non - Coffee"));
		
		cardPanel.add(MainPanel, "Menu");

	}
	
	public JPanel getMenuPanel() {
	    return MainPanel;
	}
	
	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
	}
}