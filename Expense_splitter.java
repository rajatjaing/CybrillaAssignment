import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Expense_splitter{
	static HashMap<String,ArrayList<Attributes>> hashMap=new HashMap<String,ArrayList<Attributes>>();

	static class Attributes{
		String paidBy;
		float amount;
		String expenseName;
		String splitBy;
		// static float totalExpense;

		Attributes(String paidBy,float amount,String splitBy,String expenseName){
			this.paidBy=paidBy;
			this.amount=amount;
			this.splitBy=splitBy;
			// this.totalExpense=totalExpense;
			setPaidBy(paidBy);
			setSplitBy(splitBy);
			setExpenseName(expenseName);
			setAmount(amount);
			// setTotalExpense(amount);


		}

		public void setPaidBy(String paidBy){
			this.paidBy=paidBy;
		}
		public String getPaidBy(){
			return paidBy;
		}

		public void setAmount(float amount){
			this.amount=amount;
		}
		public float getAmount(){
			return amount;
		}

		public void setSplitBy(String splitBy){
			this.splitBy=splitBy;
		}
		public String getSplitBy(){
			return splitBy;
		}

		public void setExpenseName(String expenseName){
			this.expenseName=expenseName;
		}
		public String getExpenseName(){
			return expenseName;
		}

		// public void setTotalExpense(float totalExpense){
		// 	this.totalExpense=totalExpense;
		// }
		// public float getTotalExpense(){
		// 	return totalExpense;
		// }


		
	}

	public void createUsers(){
			Scanner newUserObj = new Scanner(System.in);
    		System.out.println("Enter User Name :: ");

    		String userName = newUserObj.nextLine();
    		
    		hashMap.put(userName,new ArrayList<Attributes>());

		}
		public static void addExpenses(){
			Scanner expnsNameObj = new Scanner(System.in);
    		System.out.println("Enter expense Subject :: ");
    		String expnsName = expnsNameObj.nextLine();

    		Scanner amountObj = new Scanner(System.in);
    		System.out.println("Enter Amount :: ");
    		float amountValue = amountObj.nextFloat();

    		Scanner splitByObj = new Scanner(System.in);
    		System.out.println("Enter Splitby Type :: ");
    		String splitByType = splitByObj.nextLine();

    		Scanner paidByObj = new Scanner(System.in);
    		System.out.println("Enter Paid by :: ");
    		String paidByName = paidByObj.nextLine();


    		Attributes atrObj=new Attributes(paidByName,amountValue,splitByType,expnsName);


    		if (hashMap.get(paidByName)!=null) {
    			
    			ArrayList<Attributes> alist= hashMap.get(paidByName);
    			alist.add(atrObj);
    			hashMap.put(paidByName,alist);
    		}
    		else{
    			System.out.printf("\nUser Name %s does not exists try again..!!\n\n",paidByName);
    		}


		}

		public void splitExpenses(){
			
			 for (String parentUser : hashMap.keySet()){
			 float totalExpense=0.0f;
			 String splitType;  
            System.out.println("key: " + parentUser);
            if (parentUser!=null) {
            	
            		
            	
             	ArrayList<Attributes> attrblist =hashMap.get(parentUser);
             	
             	for (Attributes atr :attrblist ) {
             		totalExpense=totalExpense+atr.getAmount();
             		if (atr.getSplitBy().equals("equals")) {
             			
             		}
            	 }

            	 float splittedAmount=totalExpense/hashMap.size();
            	 if (splittedAmount!=0.0 && totalExpense!=0.0) {
           
           		 	 for (String childUser :hashMap.keySet()) {
            		 	if (!childUser.equals(parentUser)) {
            	 			System.out.printf("%s owes %.2f to %s.\n",childUser,splittedAmount,parentUser);
            	 		}else{
            	 			System.out.printf("%s get back %.2f from %s\n",parentUser,totalExpense - splittedAmount,getChildUserString(parentUser));
            	 		}
            	 	
            	 	}
            	 }
			
		}
	}
}

	public String getChildUserString(String parentUser){
		String childString="";
		for (String user :hashMap.keySet() ) {
			if (!user.equals(parentUser)) {
				childString=childString+user+",";
			}
		}

		StringBuilder str= new StringBuilder(childString);	
		int index = childString.lastIndexOf(",");
		if( index>=0 )
   		str =str.replace(index, index+1,".");
   		childString=str.toString();
   		int indexforAnd = childString.lastIndexOf(",");
		if( indexforAnd>=0 )
   		str =str.replace(indexforAnd, indexforAnd+1," and ");
		childString=str.toString();
		return childString;
	}


	public static void main(String[] args) {
			Expense_splitter obj =new Expense_splitter();
			Boolean isValidState=true;
			System.out.println("============== Welcome to Expense Splitter ================");
			while(isValidState){
				System.out.println("Choose your Option from Menu --> ");
				System.out.println("1). Create User");
				System.out.println("2). Add Expense");
				System.out.println("3). Split Expenses");
				System.out.println("4). Exit ");
				System.out.println("Enter your option no. ");
				Scanner optionObj = new Scanner(System.in);
    			int optionNum = optionObj.nextInt();
				switch(optionNum){
					case 1:	obj.createUsers();
					break;
					case 2: obj.addExpenses();
					break;
					case 3: obj.splitExpenses();
					System.out.println(hashMap);
					break;
					case 4: isValidState=false;
					default:System.out.println("Invalid Option !! ....Please Select from option menu.");  
				}
			}
		}

}