/**This class PremiumMember is a child class of GymMember. This class consists of various methods that help store, update and manipulate
   values referring to the attributes of Premium member**/
public class PremiumMember extends GymMember
{
     final double premiumCharge =50000;
     String personalTrainer;
     boolean isFullPayment=false;
     double paidAmount=0;
     double discountAmount=0;
    //constructor
    PremiumMember(int id, String name,String location, String phone, String email,
    String gender, String DOB, String membershipStartDate, String personalTrainer){
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer= personalTrainer;
    }
    // Accessor methods
    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean getIsFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
    public String payDueAmount(double payment){
        
        if (payment >= 50000) {
        // Apply 10% discount
        double discount = payment * 0.10;
        double finalAmount = payment - discount;
        
        // Update the member's payment record
        this.paidAmount = finalAmount;
        this.discountAmount = discount;
        this.isFullPayment = true;
        return "Payment successful!\nOriginal Amount: " + payment + 
               "\nDiscount (10%): " + discount + 
               "\nFinal Amount Paid: " + finalAmount;
               
    } else {
        // Partial payment without discount
        this.paidAmount = payment;
        double remaining = 50000 - payment;
        
        return "Partial payment of " + payment + " received.\nRemaining balance: " + remaining;
        
    }
    
    }
    public void calculateDiscount() {
        if (isFullPayment) {
            discountAmount = premiumCharge * 0.10;
            System.out.println("Discount given: " + discountAmount);
        } else {
            System.out.println("No discount available as payment is not complete.");
        }
    }
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer=" ";
        this.isFullPayment= false;
        this.paidAmount=0;
        this.discountAmount=0;
    }
    @Override
    public void markAttendance(){
       }
    @Override
    public void display(){
        super.display();
        System.out.println("Personal trainer:"+personalTrainer);
        System.out.println("Paid amount:"+paidAmount);
        System.out.println("Full payment:"+isFullPayment);
        double remainingAmount=premiumCharge-paidAmount;
        System.out.println("remaining amount:"+remainingAmount);
        if(isFullPayment){
            System.out.println("discounf amount:"+discountAmount);
        }
    }
}
