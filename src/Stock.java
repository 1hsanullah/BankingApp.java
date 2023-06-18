public class Stock extends User {
     
    private Account account;
    
    public Stock(String name){
	super(name);
	this.account = new Account();
    }

    public void deposit(int amount){
	this.account.deposit(amount);
    }

    public void withdraw(int amount){
	this.account.withdraw(amount);
    }

    public int getFunds(){
	return this.account.getBalance();
    }
    
}
