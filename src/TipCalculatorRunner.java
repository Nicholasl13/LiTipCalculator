public class TipCalculatorRunner {
    private int numPeople;
    private int tipPercentage;
    private double totalBillBeforeTheTip;
//a
    public TipCalculatorRunner (int numPeople, int tipPercentage) {
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
        totalBillBeforeTheTip = 0;
    }
    public double getTotalBillBeforeTheTip () {
        return totalBillBeforeTheTip;
    }
    public int getTipPercentage() {
        return tipPercentage;
    }
    public void addMeal(double cost) {
        totalBillBeforeTheTip += cost;
    }
    public double tipAmount () {
        return (totalBillBeforeTheTip * tipPercentage)/100;
    }
    public double totalBill () {
        return tipAmount() + totalBillBeforeTheTip;
    }
    public double perPersonCostBeforeTip () {
        return totalBillBeforeTheTip / numPeople;
    }
    public double perPersonTipAmount () {
        return tipAmount() / numPeople;
    }
    public double perPersonTotalCost() {
        return totalBill() / numPeople;
    }
}
