

static class Attributes{
		String paidBy;
		float amount;
		String expenseName;
		String splitBy;
		

		Attributes(String paidBy,float amount,String splitBy,String expenseName){
			this.paidBy=paidBy;
			this.amount=amount;
			this.splitBy=splitBy;

			setPaidBy(paidBy);
			setSplitBy(splitBy);
			setExpenseName(expenseName);
			setAmount(amount);

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


	}