import java.awt.*;
import java.awt.event.*;

public class BankingApp extends Frame{


	private static TextArea infoArea = new TextArea("Investment App");

	public static void print(String text){
		infoArea.setText(text);
	}

	private Portfolio agent;
	private Panel stockButtonsPanel;



	public void printStocks(){
		String text = agent.getListOfStockNames();
		print(text);
	}


	public void printClientInfo(int index){
		String text = agent.getStockInfo(index);
		print(text);
	}


	public void deposit(String name, int amount){
		boolean found = agent.deposit(name,amount);
		if (found == false){
			System.out.println("Error");
		}
		else{
			System.out.println("Success");
		}
	}
	public void withdraw(String name, int amount){
		boolean found = agent.withdraw(name,amount);
		if (found == false){
			System.out.println("Error");
		}
		else{
			System.out.println("Success");
		}
	}
	public void addStock(String name){

		agent.addStock(new Stock(name));

		int numStocks = agent.getNumberOfStocks();
		Button btn = new Button(name);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printClientInfo(numStocks - 1);
			}
		});
		stockButtonsPanel.add(btn);
		this.setVisible(true);// Just to refresh the frame, so that the button shows up
	}

	public BankingApp(){

		this.agent = new Portfolio();
		this.setLayout(new FlowLayout());


		Button reportButton=new Button("Portfolio");
		reportButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				printStocks();
			}
		});
		this.add(reportButton);

		this.agent = new Portfolio();
		this.setLayout(new FlowLayout());



		Button depositButton = new Button("Deposit");
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField TF = new TextField("Your Account");

				TextField TF2 = new TextField("Enter Deposit Amount");
				acp.add(TF2);
				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = TF.getText();
						int amount = Integer.parseInt(TF2.getText());
						deposit(name,amount);
					}
				});

				acp.activate();
			}
		});
		this.add(depositButton);

		Button withdrawButton = new Button("Withdraw");
		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField TF = new TextField("Your Account");

				TextField TF2 = new TextField("Enter Withdraw Amount");
				acp.add(TF2);
				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = TF.getText();
						int amount = Integer.parseInt(TF2.getText());
						withdraw(name,amount);
					}
				});


				//...

				acp.activate();
			}
		});
		this.add(withdrawButton);
		// Output console
		infoArea.setEditable(false);
		this.add(infoArea);

		Button buyButton = new Button("Buy");
		buyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField TF = new TextField("Enter Stock Name");
				acp.add(TF);
				TextField TF2 = new TextField("Enter Buy Amount");
				acp.add(TF2);
				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = TF.getText();
						int amount = Integer.parseInt(TF2.getText());
						deposit(name,amount);
					}
				});

				acp.activate();
			}
		});
		this.add(buyButton);

		Button sellButton = new Button("Sell");
		sellButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				TextField TF = new TextField("Enter Name");
				acp.add(TF);
				TextField TF2 = new TextField("Enter Sell Amount");
				acp.add(TF2);
				acp.addSubmitListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name = TF.getText();
						int amount = Integer.parseInt(TF2.getText());
						withdraw(name,amount);
					}
				});

				acp.activate();
			}
		});
		this.add(sellButton);
		// Output console
		infoArea.setEditable(false);
		this.add(infoArea);


		stockButtonsPanel = new Panel();
		stockButtonsPanel.setLayout(new GridLayout(0,1));
		stockButtonsPanel.setVisible(true);
		this.add(stockButtonsPanel);



		this.addStock("Your Account");
		this.addStock("Saving Account");
		this.addStock("Mortgage Account");
		this.addStock("Investment Account");



		WindowCloser wc = new WindowCloser();
		this.addWindowListener(wc);

		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args){
		new BankingApp();
	}
}
