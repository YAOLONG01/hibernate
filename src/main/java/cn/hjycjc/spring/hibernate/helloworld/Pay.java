package cn.hjycjc.spring.hibernate.helloworld;

public class Pay {
	private int mPay;
	
	private int yPay;
	
	private int vocationWithPay;

	public Pay() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Pay(int mPay, int yPay, int vocationWithPay) {
		//super();
		this.mPay = mPay;
		this.yPay = yPay;
		this.vocationWithPay = vocationWithPay;
	}

	public int getmPay() {
		return mPay;
	}

	public void setmPay(int mPay) {
		this.mPay = mPay;
	}

	public int getyPay() {
		return yPay;
	}

	public void setyPay(int yPay) {
		this.yPay = yPay;
	}

	public int getVocationWithPay() {
		return vocationWithPay;
	}

	public void setVocationWithPay(int vocationWithPay) {
		this.vocationWithPay = vocationWithPay;
	}

	@Override
	public String toString() {
		return "Pay [mPay=" + mPay + ", yPay=" + yPay + ", vocationWithPay=" + vocationWithPay + "]";
	}
	
}
